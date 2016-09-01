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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.CompraConstantesFunciones;
import com.bydan.erp.inventario.util.CompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CompraConstantesFunciones extends CompraConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-10);
	
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
	public static final String SNOMBREOPCION="Compra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Compra"+CompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CompraConstantesFunciones.SCHEMA+"_"+CompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CompraConstantesFunciones.SCHEMA+"_"+CompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CompraConstantesFunciones.SCHEMA+"_"+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CompraConstantesFunciones.SCHEMA+"_"+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Compra";
	public static final String SCLASSWEBTITULO_LOWER="Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Compra";
	public static final String OBJECTNAME="compra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select compra from "+CompraConstantesFunciones.SPERSISTENCENAME+" compra";
	public static String QUERYSELECTNATIVE="select "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".version_row,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_empresa,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_sucursal,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_modulo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_ejercicio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_periodo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_anio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_mes,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_usuario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_emision,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_entrega,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_secuencial,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_moneda,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_estado_inventario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_cliente,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_formato,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_empleado,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_factura,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_transportista,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".descripcion,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_orden_compra,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_pedido_compra,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".autori_usuario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".factura_inicial,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".factura_final,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".servicio_documento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_valor,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".porcentaje_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".suman,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".ice,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".valor_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".iva,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".stock,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".sub_total,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total_otro,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".ultimo_costo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_items,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".retencion,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".flete,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".impuesto,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_comprobante,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha from "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME;//+" as "+CompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected CompraConstantesFuncionesAdditional compraConstantesFuncionesAdditional=null;
	
	public CompraConstantesFuncionesAdditional getCompraConstantesFuncionesAdditional() {
		return this.compraConstantesFuncionesAdditional;
	}
	
	public void setCompraConstantesFuncionesAdditional(CompraConstantesFuncionesAdditional compraConstantesFuncionesAdditional) {
		try {
			this.compraConstantesFuncionesAdditional=compraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDUSUARIO= "id_usuario";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDESTADOINVENTARIO= "id_estado_inventario";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFORMATO= "id_formato";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDORDENCOMPRA= "id_orden_compra";
    public static final String IDPEDIDOCOMPRA= "id_pedido_compra";
    public static final String AUTORIUSUARIO= "autori_usuario";
    public static final String FACTURAINICIAL= "factura_inicial";
    public static final String FACTURAFINAL= "factura_final";
    public static final String SERVICIODOCUMENTO= "servicio_documento";
    public static final String FECHAVALOR= "fecha_valor";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
    public static final String SUMAN= "suman";
    public static final String ICE= "ice";
    public static final String VALORDESCUENTO= "valor_descuento";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String IVA= "iva";
    public static final String STOCK= "stock";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTALOTRO= "total_otro";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String NUMEROITEMS= "numero_items";
    public static final String RETENCION= "retencion";
    public static final String TOTAL= "total";
    public static final String FLETE= "flete";
    public static final String IMPUESTO= "impuesto";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
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
    	public static final String LABEL_FECHAEMISION= "F Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "F Emision";
    	public static final String LABEL_FECHAENTREGA= "F Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "F Entrega";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "No Secuen";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDTIPOCAMBIO= "T Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDESTADOINVENTARIO= "Estado";
		public static final String LABEL_IDESTADOINVENTARIO_LOWER= "Estado";
    	public static final String LABEL_IDCLIENTE= "Proveedor";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_NUMEROFACTURA= "No Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDORDENCOMPRA= "Orden Compra";
		public static final String LABEL_IDORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_IDPEDIDOCOMPRA= "Pedido Compra";
		public static final String LABEL_IDPEDIDOCOMPRA_LOWER= "Pedido Compra";
    	public static final String LABEL_AUTORIUSUARIO= "COA->Aut. Usuario";
		public static final String LABEL_AUTORIUSUARIO_LOWER= "Autori Usuario";
    	public static final String LABEL_FACTURAINICIAL= "Fac Inicial";
		public static final String LABEL_FACTURAINICIAL_LOWER= "Factura Inicial";
    	public static final String LABEL_FACTURAFINAL= "Fac Final";
		public static final String LABEL_FACTURAFINAL_LOWER= "Factura Final";
    	public static final String LABEL_SERVICIODOCUMENTO= "Serv Documento";
		public static final String LABEL_SERVICIODOCUMENTO_LOWER= "Servicio Documento";
    	public static final String LABEL_FECHAVALOR= "F Valor";
		public static final String LABEL_FECHAVALOR_LOWER= "Fecha Valor";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "Descuento %";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "% Descuento";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_VALORDESCUENTO= "Descuento Valor";
		public static final String LABEL_VALORDESCUENTO_LOWER= "Val Desc";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Desc";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_STOCK= "Stock";
		public static final String LABEL_STOCK_LOWER= "Stock";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTALOTRO= "Total Otro";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_NUMEROITEMS= "No Items";
		public static final String LABEL_NUMEROITEMS_LOWER= "No Items";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXAUTORI_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORI_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFACTURA_INICIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFACTURA_INICIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFACTURA_FINAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFACTURA_FINAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERVICIO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERVICIO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDMODULO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDPERIODO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDANIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDMES)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FECHAEMISION)) {sLabelColumna=CompraConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FECHAENTREGA)) {sLabelColumna=CompraConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDMONEDA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDESTADOINVENTARIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDESTADOINVENTARIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDCLIENTE)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDFORMATO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=CompraConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=CompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDORDENCOMPRA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDORDENCOMPRA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDPEDIDOCOMPRA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.AUTORIUSUARIO)) {sLabelColumna=CompraConstantesFunciones.LABEL_AUTORIUSUARIO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FACTURAINICIAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_FACTURAINICIAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FACTURAFINAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_FACTURAFINAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.SERVICIODOCUMENTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_SERVICIODOCUMENTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FECHAVALOR)) {sLabelColumna=CompraConstantesFunciones.LABEL_FECHAVALOR;}
		if(sNombreColumna.equals(CompraConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.SUMAN)) {sLabelColumna=CompraConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(CompraConstantesFunciones.ICE)) {sLabelColumna=CompraConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(CompraConstantesFunciones.VALORDESCUENTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_VALORDESCUENTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IVA)) {sLabelColumna=CompraConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(CompraConstantesFunciones.STOCK)) {sLabelColumna=CompraConstantesFunciones.LABEL_STOCK;}
		if(sNombreColumna.equals(CompraConstantesFunciones.SUBTOTAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.TOTALOTRO)) {sLabelColumna=CompraConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.NUMEROITEMS)) {sLabelColumna=CompraConstantesFunciones.LABEL_NUMEROITEMS;}
		if(sNombreColumna.equals(CompraConstantesFunciones.RETENCION)) {sLabelColumna=CompraConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(CompraConstantesFunciones.TOTAL)) {sLabelColumna=CompraConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FLETE)) {sLabelColumna=CompraConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IMPUESTO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(CompraConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=CompraConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(CompraConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CompraConstantesFunciones.FECHA)) {sLabelColumna=CompraConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCompraDescripcion(Compra compra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(compra !=null/* && compra.getId()!=0*/) {
			if(compra.getId()!=null) {
				sDescripcion=compra.getId().toString();
			}//compracompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCompraDescripcionDetallado(Compra compra) {
		String sDescripcion="";
			
		sDescripcion+=CompraConstantesFunciones.ID+"=";
		sDescripcion+=compra.getId().toString()+",";
		sDescripcion+=CompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=compra.getVersionRow().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=compra.getid_empresa().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=compra.getid_sucursal().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=compra.getid_modulo().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=compra.getid_ejercicio().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=compra.getid_periodo().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=compra.getid_anio().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDMES+"=";
		sDescripcion+=compra.getid_mes().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=compra.getid_usuario().toString()+",";
		sDescripcion+=CompraConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=compra.getfecha_emision().toString()+",";
		sDescripcion+=CompraConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=compra.getfecha_entrega().toString()+",";
		sDescripcion+=CompraConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=compra.getnumero_secuencial()+",";
		sDescripcion+=CompraConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=compra.getid_moneda().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=compra.getid_tipo_cambio().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDESTADOINVENTARIO+"=";
		sDescripcion+=compra.getid_estado_inventario().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=compra.getid_cliente().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=compra.getid_formato().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=compra.getid_empleado().toString()+",";
		sDescripcion+=CompraConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=compra.getnumero_factura()+",";
		sDescripcion+=CompraConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=compra.getid_transportista().toString()+",";
		sDescripcion+=CompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=compra.getdescripcion()+",";
		sDescripcion+=CompraConstantesFunciones.IDORDENCOMPRA+"=";
		sDescripcion+=compra.getid_orden_compra().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDPEDIDOCOMPRA+"=";
		sDescripcion+=compra.getid_pedido_compra().toString()+",";
		sDescripcion+=CompraConstantesFunciones.AUTORIUSUARIO+"=";
		sDescripcion+=compra.getautori_usuario()+",";
		sDescripcion+=CompraConstantesFunciones.FACTURAINICIAL+"=";
		sDescripcion+=compra.getfactura_inicial()+",";
		sDescripcion+=CompraConstantesFunciones.FACTURAFINAL+"=";
		sDescripcion+=compra.getfactura_final()+",";
		sDescripcion+=CompraConstantesFunciones.SERVICIODOCUMENTO+"=";
		sDescripcion+=compra.getservicio_documento()+",";
		sDescripcion+=CompraConstantesFunciones.FECHAVALOR+"=";
		sDescripcion+=compra.getfecha_valor().toString()+",";
		sDescripcion+=CompraConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=compra.getporcentaje_descuento().toString()+",";
		sDescripcion+=CompraConstantesFunciones.SUMAN+"=";
		sDescripcion+=compra.getsuman().toString()+",";
		sDescripcion+=CompraConstantesFunciones.ICE+"=";
		sDescripcion+=compra.getice().toString()+",";
		sDescripcion+=CompraConstantesFunciones.VALORDESCUENTO+"=";
		sDescripcion+=compra.getvalor_descuento().toString()+",";
		sDescripcion+=CompraConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=compra.gettotal_descuento().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IVA+"=";
		sDescripcion+=compra.getiva().toString()+",";
		sDescripcion+=CompraConstantesFunciones.STOCK+"=";
		sDescripcion+=compra.getstock().toString()+",";
		sDescripcion+=CompraConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=compra.getsub_total().toString()+",";
		sDescripcion+=CompraConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=compra.gettotal_otro().toString()+",";
		sDescripcion+=CompraConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=compra.getultimo_costo().toString()+",";
		sDescripcion+=CompraConstantesFunciones.NUMEROITEMS+"=";
		sDescripcion+=compra.getnumero_items().toString()+",";
		sDescripcion+=CompraConstantesFunciones.RETENCION+"=";
		sDescripcion+=compra.getretencion().toString()+",";
		sDescripcion+=CompraConstantesFunciones.TOTAL+"=";
		sDescripcion+=compra.gettotal().toString()+",";
		sDescripcion+=CompraConstantesFunciones.FLETE+"=";
		sDescripcion+=compra.getflete().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=compra.getimpuesto().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=compra.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=CompraConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=compra.getid_asiento_contable().toString()+",";
		sDescripcion+=CompraConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=compra.getnumero_comprobante()+",";
		sDescripcion+=CompraConstantesFunciones.FECHA+"=";
		sDescripcion+=compra.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCompraDescripcion(Compra compra,String sValor) throws Exception {			
		if(compra !=null) {
			//compracompra.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getEstadoInventarioDescripcion(EstadoInventario estadoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoinventario!=null/*&&estadoinventario.getId()>0*/) {
			sDescripcion=EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(estadoinventario);
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getOrdenCompraDescripcion(OrdenCompra ordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordencompra!=null/*&&ordencompra.getId()>0*/) {
			sDescripcion=OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompra);
		}

		return sDescripcion;
	}

	public static String getPedidoCompraDescripcion(PedidoCompra pedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidocompra!=null/*&&pedidocompra.getId()>0*/) {
			sDescripcion=PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(pedidocompra);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Proveedor";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoInventario")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdOrdenCompra")) {
			sNombreIndice="Tipo=  Por Orden Compra";
		} else if(sNombreIndice.equals("FK_IdPedidoCompra")) {
			sNombreIndice="Tipo=  Por Pedido Compra";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por T Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Proveedor="+id_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoInventario(Long id_estado_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_inventario!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_inventario.toString();} 

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

	public static String getDetalleIndiceFK_IdOrdenCompra(Long id_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Orden Compra="+id_orden_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoCompra(Long id_pedido_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_compra!=null) {sDetalleIndice+=" Codigo Unico De Pedido Compra="+id_pedido_compra.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De T Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosCompra(Compra compra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		compra.setnumero_secuencial(compra.getnumero_secuencial().trim());
		compra.setnumero_factura(compra.getnumero_factura().trim());
		compra.setdescripcion(compra.getdescripcion().trim());
		compra.setautori_usuario(compra.getautori_usuario().trim());
		compra.setfactura_inicial(compra.getfactura_inicial().trim());
		compra.setfactura_final(compra.getfactura_final().trim());
		compra.setservicio_documento(compra.getservicio_documento().trim());
		compra.setnumero_comprobante(compra.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosCompras(List<Compra> compras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Compra compra: compras) {
			compra.setnumero_secuencial(compra.getnumero_secuencial().trim());
			compra.setnumero_factura(compra.getnumero_factura().trim());
			compra.setdescripcion(compra.getdescripcion().trim());
			compra.setautori_usuario(compra.getautori_usuario().trim());
			compra.setfactura_inicial(compra.getfactura_inicial().trim());
			compra.setfactura_final(compra.getfactura_final().trim());
			compra.setservicio_documento(compra.getservicio_documento().trim());
			compra.setnumero_comprobante(compra.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCompra(Compra compra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && compra.getConCambioAuxiliar()) {
			compra.setIsDeleted(compra.getIsDeletedAuxiliar());	
			compra.setIsNew(compra.getIsNewAuxiliar());	
			compra.setIsChanged(compra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			compra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			compra.setIsDeletedAuxiliar(false);	
			compra.setIsNewAuxiliar(false);	
			compra.setIsChangedAuxiliar(false);
			
			compra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCompras(List<Compra> compras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Compra compra : compras) {
			if(conAsignarBase && compra.getConCambioAuxiliar()) {
				compra.setIsDeleted(compra.getIsDeletedAuxiliar());	
				compra.setIsNew(compra.getIsNewAuxiliar());	
				compra.setIsChanged(compra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				compra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				compra.setIsDeletedAuxiliar(false);	
				compra.setIsNewAuxiliar(false);	
				compra.setIsChangedAuxiliar(false);
				
				compra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCompra(Compra compra,Boolean conEnteros) throws Exception  {
		compra.setporcentaje_descuento(0.0);
		compra.setsuman(0.0);
		compra.setice(0.0);
		compra.setvalor_descuento(0.0);
		compra.settotal_descuento(0.0);
		compra.setiva(0.0);
		compra.setstock(0.0);
		compra.setsub_total(0.0);
		compra.settotal_otro(0.0);
		compra.setultimo_costo(0.0);
		compra.setretencion(0.0);
		compra.settotal(0.0);
		compra.setflete(0.0);
		compra.setimpuesto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			compra.setnumero_items(0);
		}
	}		
	
	public static void InicializarValoresCompras(List<Compra> compras,Boolean conEnteros) throws Exception  {
		
		for(Compra compra: compras) {
			compra.setporcentaje_descuento(0.0);
			compra.setsuman(0.0);
			compra.setice(0.0);
			compra.setvalor_descuento(0.0);
			compra.settotal_descuento(0.0);
			compra.setiva(0.0);
			compra.setstock(0.0);
			compra.setsub_total(0.0);
			compra.settotal_otro(0.0);
			compra.setultimo_costo(0.0);
			compra.setretencion(0.0);
			compra.settotal(0.0);
			compra.setflete(0.0);
			compra.setimpuesto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				compra.setnumero_items(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCompra(List<Compra> compras,Compra compraAux) throws Exception  {
		CompraConstantesFunciones.InicializarValoresCompra(compraAux,true);
		
		for(Compra compra: compras) {
			if(compra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			compraAux.setporcentaje_descuento(compraAux.getporcentaje_descuento()+compra.getporcentaje_descuento());			
			compraAux.setsuman(compraAux.getsuman()+compra.getsuman());			
			compraAux.setice(compraAux.getice()+compra.getice());			
			compraAux.setvalor_descuento(compraAux.getvalor_descuento()+compra.getvalor_descuento());			
			compraAux.settotal_descuento(compraAux.gettotal_descuento()+compra.gettotal_descuento());			
			compraAux.setiva(compraAux.getiva()+compra.getiva());			
			compraAux.setstock(compraAux.getstock()+compra.getstock());			
			compraAux.setsub_total(compraAux.getsub_total()+compra.getsub_total());			
			compraAux.settotal_otro(compraAux.gettotal_otro()+compra.gettotal_otro());			
			compraAux.setultimo_costo(compraAux.getultimo_costo()+compra.getultimo_costo());			
			compraAux.setnumero_items(compraAux.getnumero_items()+compra.getnumero_items());			
			compraAux.setretencion(compraAux.getretencion()+compra.getretencion());			
			compraAux.settotal(compraAux.gettotal()+compra.gettotal());			
			compraAux.setflete(compraAux.getflete()+compra.getflete());			
			compraAux.setimpuesto(compraAux.getimpuesto()+compra.getimpuesto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CompraConstantesFunciones.getArrayColumnasGlobalesCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompraConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompraConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Compra> compras,Compra compra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Compra compraAux: compras) {
			if(compraAux!=null && compra!=null) {
				if((compraAux.getId()==null && compra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(compraAux.getId()!=null && compra.getId()!=null){
					if(compraAux.getId().equals(compra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCompra(List<Compra> compras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_descuentoTotal=0.0;
		Double sumanTotal=0.0;
		Double iceTotal=0.0;
		Double valor_descuentoTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double stockTotal=0.0;
		Double sub_totalTotal=0.0;
		Double total_otroTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double retencionTotal=0.0;
		Double totalTotal=0.0;
		Double fleteTotal=0.0;
		Double impuestoTotal=0.0;
	
		for(Compra compra: compras) {			
			if(compra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_descuentoTotal+=compra.getporcentaje_descuento();
			sumanTotal+=compra.getsuman();
			iceTotal+=compra.getice();
			valor_descuentoTotal+=compra.getvalor_descuento();
			total_descuentoTotal+=compra.gettotal_descuento();
			ivaTotal+=compra.getiva();
			stockTotal+=compra.getstock();
			sub_totalTotal+=compra.getsub_total();
			total_otroTotal+=compra.gettotal_otro();
			ultimo_costoTotal+=compra.getultimo_costo();
			retencionTotal+=compra.getretencion();
			totalTotal+=compra.gettotal();
			fleteTotal+=compra.getflete();
			impuestoTotal+=compra.getimpuesto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.VALORDESCUENTO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_VALORDESCUENTO);
		datoGeneral.setdValorDouble(valor_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.STOCK);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_STOCK);
		datoGeneral.setdValorDouble(stockTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompraConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(CompraConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_ID, CompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_VERSIONROW, CompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDEMPRESA, CompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDSUCURSAL, CompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDMODULO, CompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDEJERCICIO, CompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDPERIODO, CompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDANIO, CompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDMES, CompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDUSUARIO, CompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FECHAEMISION, CompraConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FECHAENTREGA, CompraConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_NUMEROSECUENCIAL, CompraConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDMONEDA, CompraConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDTIPOCAMBIO, CompraConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDESTADOINVENTARIO, CompraConstantesFunciones.IDESTADOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDCLIENTE, CompraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDFORMATO, CompraConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDEMPLEADO, CompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_NUMEROFACTURA, CompraConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDTRANSPORTISTA, CompraConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_DESCRIPCION, CompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDORDENCOMPRA, CompraConstantesFunciones.IDORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA, CompraConstantesFunciones.IDPEDIDOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_AUTORIUSUARIO, CompraConstantesFunciones.AUTORIUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FACTURAINICIAL, CompraConstantesFunciones.FACTURAINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FACTURAFINAL, CompraConstantesFunciones.FACTURAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_SERVICIODOCUMENTO, CompraConstantesFunciones.SERVICIODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FECHAVALOR, CompraConstantesFunciones.FECHAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, CompraConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_SUMAN, CompraConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_ICE, CompraConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_VALORDESCUENTO, CompraConstantesFunciones.VALORDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_TOTALDESCUENTO, CompraConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IVA, CompraConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_STOCK, CompraConstantesFunciones.STOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_SUBTOTAL, CompraConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_TOTALOTRO, CompraConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_ULTIMOCOSTO, CompraConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_NUMEROITEMS, CompraConstantesFunciones.NUMEROITEMS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_RETENCION, CompraConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_TOTAL, CompraConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FLETE, CompraConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IMPUESTO, CompraConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_IDASIENTOCONTABLE, CompraConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CompraConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompraConstantesFunciones.LABEL_FECHA, CompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDESTADOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDPEDIDOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.AUTORIUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FACTURAINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FACTURAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.SERVICIODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FECHAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.VALORDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.STOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.NUMEROITEMS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompra() throws Exception  {
		return CompraConstantesFunciones.getTiposSeleccionarCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompra(Boolean conFk) throws Exception  {
		return CompraConstantesFunciones.getTiposSeleccionarCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDESTADOINVENTARIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDESTADOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDORDENCOMPRA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_AUTORIUSUARIO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_AUTORIUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FACTURAINICIAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FACTURAINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FACTURAFINAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FACTURAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_SERVICIODOCUMENTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_SERVICIODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FECHAVALOR);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FECHAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_VALORDESCUENTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_VALORDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_STOCK);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_STOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_NUMEROITEMS);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_NUMEROITEMS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCompra(Compra compraAux) throws Exception {
		
			compraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(compraAux.getEmpresa()));
			compraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(compraAux.getSucursal()));
			compraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(compraAux.getModulo()));
			compraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(compraAux.getEjercicio()));
			compraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(compraAux.getPeriodo()));
			compraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(compraAux.getAnio()));
			compraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(compraAux.getMes()));
			compraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(compraAux.getUsuario()));
			compraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(compraAux.getMoneda()));
			compraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(compraAux.getTipoCambio()));
			compraAux.setestadoinventario_descripcion(EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(compraAux.getEstadoInventario()));
			compraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(compraAux.getCliente()));
			compraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(compraAux.getFormato()));
			compraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(compraAux.getEmpleado()));
			compraAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(compraAux.getTransportista()));
			compraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(compraAux.getOrdenCompra()));
			compraAux.setpedidocompra_descripcion(PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(compraAux.getPedidoCompra()));
			compraAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(compraAux.getTipoTransaccionModulo()));
			compraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(compraAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCompra(List<Compra> comprasTemp) throws Exception {
		for(Compra compraAux:comprasTemp) {
			
			compraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(compraAux.getEmpresa()));
			compraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(compraAux.getSucursal()));
			compraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(compraAux.getModulo()));
			compraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(compraAux.getEjercicio()));
			compraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(compraAux.getPeriodo()));
			compraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(compraAux.getAnio()));
			compraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(compraAux.getMes()));
			compraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(compraAux.getUsuario()));
			compraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(compraAux.getMoneda()));
			compraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(compraAux.getTipoCambio()));
			compraAux.setestadoinventario_descripcion(EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(compraAux.getEstadoInventario()));
			compraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(compraAux.getCliente()));
			compraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(compraAux.getFormato()));
			compraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(compraAux.getEmpleado()));
			compraAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(compraAux.getTransportista()));
			compraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(compraAux.getOrdenCompra()));
			compraAux.setpedidocompra_descripcion(PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(compraAux.getPedidoCompra()));
			compraAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(compraAux.getTipoTransaccionModulo()));
			compraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(compraAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(EstadoInventario.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(PedidoCompra.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoInventario.class)) {
						classes.add(new Classe(EstadoInventario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompra.class)) {
						classes.add(new Classe(PedidoCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoInventario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoInventario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CompraConstantesFunciones.getClassesRelationshipsOfCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RetencionInven.class));
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(MovimientoInventario.class));
				classes.add(new Classe(FormaPagoInven.class));
				classes.add(new Classe(DetalleCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RetencionInven.class)) {
						classes.add(new Classe(RetencionInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoInventario.class)) {
						classes.add(new Classe(MovimientoInventario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoInven.class)) {
						classes.add(new Classe(FormaPagoInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCompra.class)) {
						classes.add(new Classe(DetalleCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CompraConstantesFunciones.getClassesRelationshipsFromStringsOfCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RetencionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RetencionInven.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
					}

					if(FormaPagoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoInven.class)); continue;
					}

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RetencionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RetencionInven.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
					}

					if(FormaPagoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoInven.class)); continue;
					}

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
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
	public static void actualizarLista(Compra compra,List<Compra> compras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Compra compraEncontrado=null;
			
			for(Compra compraLocal:compras) {
				if(compraLocal.getId().equals(compra.getId())) {
					compraEncontrado=compraLocal;
					
					compraLocal.setIsChanged(compra.getIsChanged());
					compraLocal.setIsNew(compra.getIsNew());
					compraLocal.setIsDeleted(compra.getIsDeleted());
					
					compraLocal.setGeneralEntityOriginal(compra.getGeneralEntityOriginal());
					
					compraLocal.setId(compra.getId());	
					compraLocal.setVersionRow(compra.getVersionRow());	
					compraLocal.setid_empresa(compra.getid_empresa());	
					compraLocal.setid_sucursal(compra.getid_sucursal());	
					compraLocal.setid_modulo(compra.getid_modulo());	
					compraLocal.setid_ejercicio(compra.getid_ejercicio());	
					compraLocal.setid_periodo(compra.getid_periodo());	
					compraLocal.setid_anio(compra.getid_anio());	
					compraLocal.setid_mes(compra.getid_mes());	
					compraLocal.setid_usuario(compra.getid_usuario());	
					compraLocal.setfecha_emision(compra.getfecha_emision());	
					compraLocal.setfecha_entrega(compra.getfecha_entrega());	
					compraLocal.setnumero_secuencial(compra.getnumero_secuencial());	
					compraLocal.setid_moneda(compra.getid_moneda());	
					compraLocal.setid_tipo_cambio(compra.getid_tipo_cambio());	
					compraLocal.setid_estado_inventario(compra.getid_estado_inventario());	
					compraLocal.setid_cliente(compra.getid_cliente());	
					compraLocal.setid_formato(compra.getid_formato());	
					compraLocal.setid_empleado(compra.getid_empleado());	
					compraLocal.setnumero_factura(compra.getnumero_factura());	
					compraLocal.setid_transportista(compra.getid_transportista());	
					compraLocal.setdescripcion(compra.getdescripcion());	
					compraLocal.setid_orden_compra(compra.getid_orden_compra());	
					compraLocal.setid_pedido_compra(compra.getid_pedido_compra());	
					compraLocal.setautori_usuario(compra.getautori_usuario());	
					compraLocal.setfactura_inicial(compra.getfactura_inicial());	
					compraLocal.setfactura_final(compra.getfactura_final());	
					compraLocal.setservicio_documento(compra.getservicio_documento());	
					compraLocal.setfecha_valor(compra.getfecha_valor());	
					compraLocal.setporcentaje_descuento(compra.getporcentaje_descuento());	
					compraLocal.setsuman(compra.getsuman());	
					compraLocal.setice(compra.getice());	
					compraLocal.setvalor_descuento(compra.getvalor_descuento());	
					compraLocal.settotal_descuento(compra.gettotal_descuento());	
					compraLocal.setiva(compra.getiva());	
					compraLocal.setstock(compra.getstock());	
					compraLocal.setsub_total(compra.getsub_total());	
					compraLocal.settotal_otro(compra.gettotal_otro());	
					compraLocal.setultimo_costo(compra.getultimo_costo());	
					compraLocal.setnumero_items(compra.getnumero_items());	
					compraLocal.setretencion(compra.getretencion());	
					compraLocal.settotal(compra.gettotal());	
					compraLocal.setflete(compra.getflete());	
					compraLocal.setimpuesto(compra.getimpuesto());	
					compraLocal.setid_tipo_transaccion_modulo(compra.getid_tipo_transaccion_modulo());	
					compraLocal.setid_asiento_contable(compra.getid_asiento_contable());	
					compraLocal.setnumero_comprobante(compra.getnumero_comprobante());	
					compraLocal.setfecha(compra.getfecha());	
					
					
					compraLocal.setRetencionInvens(compra.getRetencionInvens());
					compraLocal.setTransaccionLocals(compra.getTransaccionLocals());
					compraLocal.setFormaPagoInvens(compra.getFormaPagoInvens());
					compraLocal.setDetalleCompras(compra.getDetalleCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!compra.getIsDeleted()) {
				if(!existe) {
					compras.add(compra);
				}
			} else {
				if(compraEncontrado!=null && permiteQuitar)  {
					compras.remove(compraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Compra compra,List<Compra> compras) throws Exception {
		try	{			
			for(Compra compraLocal:compras) {
				if(compraLocal.getId().equals(compra.getId())) {
					compraLocal.setIsSelected(compra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCompra(List<Compra> comprasAux) throws Exception {
		//this.comprasAux=comprasAux;
		
		for(Compra compraAux:comprasAux) {
			if(compraAux.getIsChanged()) {
				compraAux.setIsChanged(false);
			}		
			
			if(compraAux.getIsNew()) {
				compraAux.setIsNew(false);
			}	
			
			if(compraAux.getIsDeleted()) {
				compraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCompra(Compra compraAux) throws Exception {
		//this.compraAux=compraAux;
		
			if(compraAux.getIsChanged()) {
				compraAux.setIsChanged(false);
			}		
			
			if(compraAux.getIsNew()) {
				compraAux.setIsNew(false);
			}	
			
			if(compraAux.getIsDeleted()) {
				compraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Compra compraAsignar,Compra compra) throws Exception {
		compraAsignar.setId(compra.getId());	
		compraAsignar.setVersionRow(compra.getVersionRow());	
		compraAsignar.setid_empresa(compra.getid_empresa());
		compraAsignar.setempresa_descripcion(compra.getempresa_descripcion());	
		compraAsignar.setid_sucursal(compra.getid_sucursal());
		compraAsignar.setsucursal_descripcion(compra.getsucursal_descripcion());	
		compraAsignar.setid_modulo(compra.getid_modulo());
		compraAsignar.setmodulo_descripcion(compra.getmodulo_descripcion());	
		compraAsignar.setid_ejercicio(compra.getid_ejercicio());
		compraAsignar.setejercicio_descripcion(compra.getejercicio_descripcion());	
		compraAsignar.setid_periodo(compra.getid_periodo());
		compraAsignar.setperiodo_descripcion(compra.getperiodo_descripcion());	
		compraAsignar.setid_anio(compra.getid_anio());
		compraAsignar.setanio_descripcion(compra.getanio_descripcion());	
		compraAsignar.setid_mes(compra.getid_mes());
		compraAsignar.setmes_descripcion(compra.getmes_descripcion());	
		compraAsignar.setid_usuario(compra.getid_usuario());
		compraAsignar.setusuario_descripcion(compra.getusuario_descripcion());	
		compraAsignar.setfecha_emision(compra.getfecha_emision());	
		compraAsignar.setfecha_entrega(compra.getfecha_entrega());	
		compraAsignar.setnumero_secuencial(compra.getnumero_secuencial());	
		compraAsignar.setid_moneda(compra.getid_moneda());
		compraAsignar.setmoneda_descripcion(compra.getmoneda_descripcion());	
		compraAsignar.setid_tipo_cambio(compra.getid_tipo_cambio());
		compraAsignar.settipocambio_descripcion(compra.gettipocambio_descripcion());	
		compraAsignar.setid_estado_inventario(compra.getid_estado_inventario());
		compraAsignar.setestadoinventario_descripcion(compra.getestadoinventario_descripcion());	
		compraAsignar.setid_cliente(compra.getid_cliente());
		compraAsignar.setcliente_descripcion(compra.getcliente_descripcion());	
		compraAsignar.setid_formato(compra.getid_formato());
		compraAsignar.setformato_descripcion(compra.getformato_descripcion());	
		compraAsignar.setid_empleado(compra.getid_empleado());
		compraAsignar.setempleado_descripcion(compra.getempleado_descripcion());	
		compraAsignar.setnumero_factura(compra.getnumero_factura());	
		compraAsignar.setid_transportista(compra.getid_transportista());
		compraAsignar.settransportista_descripcion(compra.gettransportista_descripcion());	
		compraAsignar.setdescripcion(compra.getdescripcion());	
		compraAsignar.setid_orden_compra(compra.getid_orden_compra());
		compraAsignar.setordencompra_descripcion(compra.getordencompra_descripcion());	
		compraAsignar.setid_pedido_compra(compra.getid_pedido_compra());
		compraAsignar.setpedidocompra_descripcion(compra.getpedidocompra_descripcion());	
		compraAsignar.setautori_usuario(compra.getautori_usuario());	
		compraAsignar.setfactura_inicial(compra.getfactura_inicial());	
		compraAsignar.setfactura_final(compra.getfactura_final());	
		compraAsignar.setservicio_documento(compra.getservicio_documento());	
		compraAsignar.setfecha_valor(compra.getfecha_valor());	
		compraAsignar.setporcentaje_descuento(compra.getporcentaje_descuento());	
		compraAsignar.setsuman(compra.getsuman());	
		compraAsignar.setice(compra.getice());	
		compraAsignar.setvalor_descuento(compra.getvalor_descuento());	
		compraAsignar.settotal_descuento(compra.gettotal_descuento());	
		compraAsignar.setiva(compra.getiva());	
		compraAsignar.setstock(compra.getstock());	
		compraAsignar.setsub_total(compra.getsub_total());	
		compraAsignar.settotal_otro(compra.gettotal_otro());	
		compraAsignar.setultimo_costo(compra.getultimo_costo());	
		compraAsignar.setnumero_items(compra.getnumero_items());	
		compraAsignar.setretencion(compra.getretencion());	
		compraAsignar.settotal(compra.gettotal());	
		compraAsignar.setflete(compra.getflete());	
		compraAsignar.setimpuesto(compra.getimpuesto());	
		compraAsignar.setid_tipo_transaccion_modulo(compra.getid_tipo_transaccion_modulo());
		compraAsignar.settipotransaccionmodulo_descripcion(compra.gettipotransaccionmodulo_descripcion());	
		compraAsignar.setid_asiento_contable(compra.getid_asiento_contable());
		compraAsignar.setasientocontable_descripcion(compra.getasientocontable_descripcion());	
		compraAsignar.setnumero_comprobante(compra.getnumero_comprobante());	
		compraAsignar.setfecha(compra.getfecha());	
	}
	
	public static void inicializarCompra(Compra compra) throws Exception {
		try {
				compra.setId(0L);	
					
				compra.setid_empresa(-1L);	
				compra.setid_sucursal(-1L);	
				compra.setid_modulo(-1L);	
				compra.setid_ejercicio(-1L);	
				compra.setid_periodo(-1L);	
				compra.setid_anio(null);	
				compra.setid_mes(null);	
				compra.setid_usuario(-1L);	
				compra.setfecha_emision(new Date());	
				compra.setfecha_entrega(new Date());	
				compra.setnumero_secuencial("");	
				compra.setid_moneda(-1L);	
				compra.setid_tipo_cambio(null);	
				compra.setid_estado_inventario(-1L);	
				compra.setid_cliente(-1L);	
				compra.setid_formato(-1L);	
				compra.setid_empleado(-1L);	
				compra.setnumero_factura("");	
				compra.setid_transportista(null);	
				compra.setdescripcion("");	
				compra.setid_orden_compra(null);	
				compra.setid_pedido_compra(null);	
				compra.setautori_usuario("");	
				compra.setfactura_inicial("");	
				compra.setfactura_final("");	
				compra.setservicio_documento("");	
				compra.setfecha_valor(new Date());	
				compra.setporcentaje_descuento(0.0);	
				compra.setsuman(0.0);	
				compra.setice(0.0);	
				compra.setvalor_descuento(0.0);	
				compra.settotal_descuento(0.0);	
				compra.setiva(0.0);	
				compra.setstock(0.0);	
				compra.setsub_total(0.0);	
				compra.settotal_otro(0.0);	
				compra.setultimo_costo(0.0);	
				compra.setnumero_items(0);	
				compra.setretencion(0.0);	
				compra.settotal(0.0);	
				compra.setflete(0.0);	
				compra.setimpuesto(0.0);	
				compra.setid_tipo_transaccion_modulo(null);	
				compra.setid_asiento_contable(null);	
				compra.setnumero_comprobante("");	
				compra.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDESTADOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_AUTORIUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FACTURAINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FACTURAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_SERVICIODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FECHAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_VALORDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_STOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_NUMEROITEMS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCompra(String sTipo,Row row,Workbook workbook,Compra compra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getestadoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getpedidocompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getautori_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfactura_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfactura_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getservicio_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfecha_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getvalor_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getstock());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getnumero_items());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCompra() {
		return this.sFinalQueryCompra;
	}
	
	public void setsFinalQueryCompra(String sFinalQueryCompra) {
		this.sFinalQueryCompra= sFinalQueryCompra;
	}
	
	public Border resaltarSeleccionarCompra=null;
	
	public Border setResaltarSeleccionarCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCompra() {
		return this.resaltarSeleccionarCompra;
	}
	
	public void setResaltarSeleccionarCompra(Border borderResaltarSeleccionarCompra) {
		this.resaltarSeleccionarCompra= borderResaltarSeleccionarCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCompra=null;
	public Boolean mostraridCompra=true;
	public Boolean activaridCompra=true;

	public Border resaltarid_empresaCompra=null;
	public Boolean mostrarid_empresaCompra=true;
	public Boolean activarid_empresaCompra=true;
	public Boolean cargarid_empresaCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalCompra=null;
	public Boolean mostrarid_sucursalCompra=true;
	public Boolean activarid_sucursalCompra=true;
	public Boolean cargarid_sucursalCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCompra=false;//ConEventDepend=true

	public Border resaltarid_moduloCompra=null;
	public Boolean mostrarid_moduloCompra=true;
	public Boolean activarid_moduloCompra=true;
	public Boolean cargarid_moduloCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCompra=null;
	public Boolean mostrarid_ejercicioCompra=true;
	public Boolean activarid_ejercicioCompra=true;
	public Boolean cargarid_ejercicioCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoCompra=null;
	public Boolean mostrarid_periodoCompra=true;
	public Boolean activarid_periodoCompra=true;
	public Boolean cargarid_periodoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoCompra=false;//ConEventDepend=true

	public Border resaltarid_anioCompra=null;
	public Boolean mostrarid_anioCompra=true;
	public Boolean activarid_anioCompra=false;
	public Boolean cargarid_anioCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioCompra=false;//ConEventDepend=true

	public Border resaltarid_mesCompra=null;
	public Boolean mostrarid_mesCompra=true;
	public Boolean activarid_mesCompra=false;
	public Boolean cargarid_mesCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioCompra=null;
	public Boolean mostrarid_usuarioCompra=true;
	public Boolean activarid_usuarioCompra=true;
	public Boolean cargarid_usuarioCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCompra=false;//ConEventDepend=true

	public Border resaltarfecha_emisionCompra=null;
	public Boolean mostrarfecha_emisionCompra=true;
	public Boolean activarfecha_emisionCompra=true;

	public Border resaltarfecha_entregaCompra=null;
	public Boolean mostrarfecha_entregaCompra=true;
	public Boolean activarfecha_entregaCompra=true;

	public Border resaltarnumero_secuencialCompra=null;
	public Boolean mostrarnumero_secuencialCompra=true;
	public Boolean activarnumero_secuencialCompra=true;

	public Border resaltarid_monedaCompra=null;
	public Boolean mostrarid_monedaCompra=true;
	public Boolean activarid_monedaCompra=true;
	public Boolean cargarid_monedaCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioCompra=null;
	public Boolean mostrarid_tipo_cambioCompra=true;
	public Boolean activarid_tipo_cambioCompra=true;
	public Boolean cargarid_tipo_cambioCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_inventarioCompra=null;
	public Boolean mostrarid_estado_inventarioCompra=true;
	public Boolean activarid_estado_inventarioCompra=false;
	public Boolean cargarid_estado_inventarioCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_inventarioCompra=false;//ConEventDepend=true

	public Border resaltarid_clienteCompra=null;
	public Boolean mostrarid_clienteCompra=true;
	public Boolean activarid_clienteCompra=true;
	public Boolean cargarid_clienteCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCompra=false;//ConEventDepend=true

	public Border resaltarid_formatoCompra=null;
	public Boolean mostrarid_formatoCompra=true;
	public Boolean activarid_formatoCompra=true;
	public Boolean cargarid_formatoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoCompra=false;//ConEventDepend=true

	public Border resaltarid_empleadoCompra=null;
	public Boolean mostrarid_empleadoCompra=true;
	public Boolean activarid_empleadoCompra=true;
	public Boolean cargarid_empleadoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCompra=false;//ConEventDepend=true

	public Border resaltarnumero_facturaCompra=null;
	public Boolean mostrarnumero_facturaCompra=true;
	public Boolean activarnumero_facturaCompra=false;

	public Border resaltarid_transportistaCompra=null;
	public Boolean mostrarid_transportistaCompra=true;
	public Boolean activarid_transportistaCompra=true;
	public Boolean cargarid_transportistaCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaCompra=false;//ConEventDepend=true

	public Border resaltardescripcionCompra=null;
	public Boolean mostrardescripcionCompra=true;
	public Boolean activardescripcionCompra=true;

	public Border resaltarid_orden_compraCompra=null;
	public Boolean mostrarid_orden_compraCompra=true;
	public Boolean activarid_orden_compraCompra=true;
	public Boolean cargarid_orden_compraCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_compraCompra=false;//ConEventDepend=true

	public Border resaltarid_pedido_compraCompra=null;
	public Boolean mostrarid_pedido_compraCompra=true;
	public Boolean activarid_pedido_compraCompra=true;
	public Boolean cargarid_pedido_compraCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_compraCompra=false;//ConEventDepend=true

	public Border resaltarautori_usuarioCompra=null;
	public Boolean mostrarautori_usuarioCompra=true;
	public Boolean activarautori_usuarioCompra=true;

	public Border resaltarfactura_inicialCompra=null;
	public Boolean mostrarfactura_inicialCompra=true;
	public Boolean activarfactura_inicialCompra=true;

	public Border resaltarfactura_finalCompra=null;
	public Boolean mostrarfactura_finalCompra=true;
	public Boolean activarfactura_finalCompra=true;

	public Border resaltarservicio_documentoCompra=null;
	public Boolean mostrarservicio_documentoCompra=true;
	public Boolean activarservicio_documentoCompra=true;

	public Border resaltarfecha_valorCompra=null;
	public Boolean mostrarfecha_valorCompra=true;
	public Boolean activarfecha_valorCompra=true;

	public Border resaltarporcentaje_descuentoCompra=null;
	public Boolean mostrarporcentaje_descuentoCompra=true;
	public Boolean activarporcentaje_descuentoCompra=true;

	public Border resaltarsumanCompra=null;
	public Boolean mostrarsumanCompra=true;
	public Boolean activarsumanCompra=true;

	public Border resaltariceCompra=null;
	public Boolean mostrariceCompra=true;
	public Boolean activariceCompra=true;

	public Border resaltarvalor_descuentoCompra=null;
	public Boolean mostrarvalor_descuentoCompra=true;
	public Boolean activarvalor_descuentoCompra=true;

	public Border resaltartotal_descuentoCompra=null;
	public Boolean mostrartotal_descuentoCompra=true;
	public Boolean activartotal_descuentoCompra=true;

	public Border resaltarivaCompra=null;
	public Boolean mostrarivaCompra=true;
	public Boolean activarivaCompra=true;

	public Border resaltarstockCompra=null;
	public Boolean mostrarstockCompra=true;
	public Boolean activarstockCompra=true;

	public Border resaltarsub_totalCompra=null;
	public Boolean mostrarsub_totalCompra=true;
	public Boolean activarsub_totalCompra=true;

	public Border resaltartotal_otroCompra=null;
	public Boolean mostrartotal_otroCompra=true;
	public Boolean activartotal_otroCompra=true;

	public Border resaltarultimo_costoCompra=null;
	public Boolean mostrarultimo_costoCompra=true;
	public Boolean activarultimo_costoCompra=true;

	public Border resaltarnumero_itemsCompra=null;
	public Boolean mostrarnumero_itemsCompra=true;
	public Boolean activarnumero_itemsCompra=true;

	public Border resaltarretencionCompra=null;
	public Boolean mostrarretencionCompra=true;
	public Boolean activarretencionCompra=true;

	public Border resaltartotalCompra=null;
	public Boolean mostrartotalCompra=true;
	public Boolean activartotalCompra=true;

	public Border resaltarfleteCompra=null;
	public Boolean mostrarfleteCompra=true;
	public Boolean activarfleteCompra=false;

	public Border resaltarimpuestoCompra=null;
	public Boolean mostrarimpuestoCompra=true;
	public Boolean activarimpuestoCompra=false;

	public Border resaltarid_tipo_transaccion_moduloCompra=null;
	public Boolean mostrarid_tipo_transaccion_moduloCompra=true;
	public Boolean activarid_tipo_transaccion_moduloCompra=false;
	public Boolean cargarid_tipo_transaccion_moduloCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloCompra=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableCompra=null;
	public Boolean mostrarid_asiento_contableCompra=true;
	public Boolean activarid_asiento_contableCompra=false;
	public Boolean cargarid_asiento_contableCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableCompra=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteCompra=null;
	public Boolean mostrarnumero_comprobanteCompra=true;
	public Boolean activarnumero_comprobanteCompra=false;

	public Border resaltarfechaCompra=null;
	public Boolean mostrarfechaCompra=true;
	public Boolean activarfechaCompra=false;

	
	

	public Border setResaltaridCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltaridCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCompra() {
		return this.resaltaridCompra;
	}

	public void setResaltaridCompra(Border borderResaltar) {
		this.resaltaridCompra= borderResaltar;
	}

	public Boolean getMostraridCompra() {
		return this.mostraridCompra;
	}

	public void setMostraridCompra(Boolean mostraridCompra) {
		this.mostraridCompra= mostraridCompra;
	}

	public Boolean getActivaridCompra() {
		return this.activaridCompra;
	}

	public void setActivaridCompra(Boolean activaridCompra) {
		this.activaridCompra= activaridCompra;
	}

	public Border setResaltarid_empresaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCompra() {
		return this.resaltarid_empresaCompra;
	}

	public void setResaltarid_empresaCompra(Border borderResaltar) {
		this.resaltarid_empresaCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaCompra() {
		return this.mostrarid_empresaCompra;
	}

	public void setMostrarid_empresaCompra(Boolean mostrarid_empresaCompra) {
		this.mostrarid_empresaCompra= mostrarid_empresaCompra;
	}

	public Boolean getActivarid_empresaCompra() {
		return this.activarid_empresaCompra;
	}

	public void setActivarid_empresaCompra(Boolean activarid_empresaCompra) {
		this.activarid_empresaCompra= activarid_empresaCompra;
	}

	public Boolean getCargarid_empresaCompra() {
		return this.cargarid_empresaCompra;
	}

	public void setCargarid_empresaCompra(Boolean cargarid_empresaCompra) {
		this.cargarid_empresaCompra= cargarid_empresaCompra;
	}

	public Border setResaltarid_sucursalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCompra() {
		return this.resaltarid_sucursalCompra;
	}

	public void setResaltarid_sucursalCompra(Border borderResaltar) {
		this.resaltarid_sucursalCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCompra() {
		return this.mostrarid_sucursalCompra;
	}

	public void setMostrarid_sucursalCompra(Boolean mostrarid_sucursalCompra) {
		this.mostrarid_sucursalCompra= mostrarid_sucursalCompra;
	}

	public Boolean getActivarid_sucursalCompra() {
		return this.activarid_sucursalCompra;
	}

	public void setActivarid_sucursalCompra(Boolean activarid_sucursalCompra) {
		this.activarid_sucursalCompra= activarid_sucursalCompra;
	}

	public Boolean getCargarid_sucursalCompra() {
		return this.cargarid_sucursalCompra;
	}

	public void setCargarid_sucursalCompra(Boolean cargarid_sucursalCompra) {
		this.cargarid_sucursalCompra= cargarid_sucursalCompra;
	}

	public Border setResaltarid_moduloCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloCompra() {
		return this.resaltarid_moduloCompra;
	}

	public void setResaltarid_moduloCompra(Border borderResaltar) {
		this.resaltarid_moduloCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloCompra() {
		return this.mostrarid_moduloCompra;
	}

	public void setMostrarid_moduloCompra(Boolean mostrarid_moduloCompra) {
		this.mostrarid_moduloCompra= mostrarid_moduloCompra;
	}

	public Boolean getActivarid_moduloCompra() {
		return this.activarid_moduloCompra;
	}

	public void setActivarid_moduloCompra(Boolean activarid_moduloCompra) {
		this.activarid_moduloCompra= activarid_moduloCompra;
	}

	public Boolean getCargarid_moduloCompra() {
		return this.cargarid_moduloCompra;
	}

	public void setCargarid_moduloCompra(Boolean cargarid_moduloCompra) {
		this.cargarid_moduloCompra= cargarid_moduloCompra;
	}

	public Border setResaltarid_ejercicioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCompra() {
		return this.resaltarid_ejercicioCompra;
	}

	public void setResaltarid_ejercicioCompra(Border borderResaltar) {
		this.resaltarid_ejercicioCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCompra() {
		return this.mostrarid_ejercicioCompra;
	}

	public void setMostrarid_ejercicioCompra(Boolean mostrarid_ejercicioCompra) {
		this.mostrarid_ejercicioCompra= mostrarid_ejercicioCompra;
	}

	public Boolean getActivarid_ejercicioCompra() {
		return this.activarid_ejercicioCompra;
	}

	public void setActivarid_ejercicioCompra(Boolean activarid_ejercicioCompra) {
		this.activarid_ejercicioCompra= activarid_ejercicioCompra;
	}

	public Boolean getCargarid_ejercicioCompra() {
		return this.cargarid_ejercicioCompra;
	}

	public void setCargarid_ejercicioCompra(Boolean cargarid_ejercicioCompra) {
		this.cargarid_ejercicioCompra= cargarid_ejercicioCompra;
	}

	public Border setResaltarid_periodoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoCompra() {
		return this.resaltarid_periodoCompra;
	}

	public void setResaltarid_periodoCompra(Border borderResaltar) {
		this.resaltarid_periodoCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoCompra() {
		return this.mostrarid_periodoCompra;
	}

	public void setMostrarid_periodoCompra(Boolean mostrarid_periodoCompra) {
		this.mostrarid_periodoCompra= mostrarid_periodoCompra;
	}

	public Boolean getActivarid_periodoCompra() {
		return this.activarid_periodoCompra;
	}

	public void setActivarid_periodoCompra(Boolean activarid_periodoCompra) {
		this.activarid_periodoCompra= activarid_periodoCompra;
	}

	public Boolean getCargarid_periodoCompra() {
		return this.cargarid_periodoCompra;
	}

	public void setCargarid_periodoCompra(Boolean cargarid_periodoCompra) {
		this.cargarid_periodoCompra= cargarid_periodoCompra;
	}

	public Border setResaltarid_anioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioCompra() {
		return this.resaltarid_anioCompra;
	}

	public void setResaltarid_anioCompra(Border borderResaltar) {
		this.resaltarid_anioCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioCompra() {
		return this.mostrarid_anioCompra;
	}

	public void setMostrarid_anioCompra(Boolean mostrarid_anioCompra) {
		this.mostrarid_anioCompra= mostrarid_anioCompra;
	}

	public Boolean getActivarid_anioCompra() {
		return this.activarid_anioCompra;
	}

	public void setActivarid_anioCompra(Boolean activarid_anioCompra) {
		this.activarid_anioCompra= activarid_anioCompra;
	}

	public Boolean getCargarid_anioCompra() {
		return this.cargarid_anioCompra;
	}

	public void setCargarid_anioCompra(Boolean cargarid_anioCompra) {
		this.cargarid_anioCompra= cargarid_anioCompra;
	}

	public Border setResaltarid_mesCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesCompra() {
		return this.resaltarid_mesCompra;
	}

	public void setResaltarid_mesCompra(Border borderResaltar) {
		this.resaltarid_mesCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesCompra() {
		return this.mostrarid_mesCompra;
	}

	public void setMostrarid_mesCompra(Boolean mostrarid_mesCompra) {
		this.mostrarid_mesCompra= mostrarid_mesCompra;
	}

	public Boolean getActivarid_mesCompra() {
		return this.activarid_mesCompra;
	}

	public void setActivarid_mesCompra(Boolean activarid_mesCompra) {
		this.activarid_mesCompra= activarid_mesCompra;
	}

	public Boolean getCargarid_mesCompra() {
		return this.cargarid_mesCompra;
	}

	public void setCargarid_mesCompra(Boolean cargarid_mesCompra) {
		this.cargarid_mesCompra= cargarid_mesCompra;
	}

	public Border setResaltarid_usuarioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCompra() {
		return this.resaltarid_usuarioCompra;
	}

	public void setResaltarid_usuarioCompra(Border borderResaltar) {
		this.resaltarid_usuarioCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCompra() {
		return this.mostrarid_usuarioCompra;
	}

	public void setMostrarid_usuarioCompra(Boolean mostrarid_usuarioCompra) {
		this.mostrarid_usuarioCompra= mostrarid_usuarioCompra;
	}

	public Boolean getActivarid_usuarioCompra() {
		return this.activarid_usuarioCompra;
	}

	public void setActivarid_usuarioCompra(Boolean activarid_usuarioCompra) {
		this.activarid_usuarioCompra= activarid_usuarioCompra;
	}

	public Boolean getCargarid_usuarioCompra() {
		return this.cargarid_usuarioCompra;
	}

	public void setCargarid_usuarioCompra(Boolean cargarid_usuarioCompra) {
		this.cargarid_usuarioCompra= cargarid_usuarioCompra;
	}

	public Border setResaltarfecha_emisionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionCompra() {
		return this.resaltarfecha_emisionCompra;
	}

	public void setResaltarfecha_emisionCompra(Border borderResaltar) {
		this.resaltarfecha_emisionCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionCompra() {
		return this.mostrarfecha_emisionCompra;
	}

	public void setMostrarfecha_emisionCompra(Boolean mostrarfecha_emisionCompra) {
		this.mostrarfecha_emisionCompra= mostrarfecha_emisionCompra;
	}

	public Boolean getActivarfecha_emisionCompra() {
		return this.activarfecha_emisionCompra;
	}

	public void setActivarfecha_emisionCompra(Boolean activarfecha_emisionCompra) {
		this.activarfecha_emisionCompra= activarfecha_emisionCompra;
	}

	public Border setResaltarfecha_entregaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaCompra() {
		return this.resaltarfecha_entregaCompra;
	}

	public void setResaltarfecha_entregaCompra(Border borderResaltar) {
		this.resaltarfecha_entregaCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaCompra() {
		return this.mostrarfecha_entregaCompra;
	}

	public void setMostrarfecha_entregaCompra(Boolean mostrarfecha_entregaCompra) {
		this.mostrarfecha_entregaCompra= mostrarfecha_entregaCompra;
	}

	public Boolean getActivarfecha_entregaCompra() {
		return this.activarfecha_entregaCompra;
	}

	public void setActivarfecha_entregaCompra(Boolean activarfecha_entregaCompra) {
		this.activarfecha_entregaCompra= activarfecha_entregaCompra;
	}

	public Border setResaltarnumero_secuencialCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialCompra() {
		return this.resaltarnumero_secuencialCompra;
	}

	public void setResaltarnumero_secuencialCompra(Border borderResaltar) {
		this.resaltarnumero_secuencialCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialCompra() {
		return this.mostrarnumero_secuencialCompra;
	}

	public void setMostrarnumero_secuencialCompra(Boolean mostrarnumero_secuencialCompra) {
		this.mostrarnumero_secuencialCompra= mostrarnumero_secuencialCompra;
	}

	public Boolean getActivarnumero_secuencialCompra() {
		return this.activarnumero_secuencialCompra;
	}

	public void setActivarnumero_secuencialCompra(Boolean activarnumero_secuencialCompra) {
		this.activarnumero_secuencialCompra= activarnumero_secuencialCompra;
	}

	public Border setResaltarid_monedaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_monedaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaCompra() {
		return this.resaltarid_monedaCompra;
	}

	public void setResaltarid_monedaCompra(Border borderResaltar) {
		this.resaltarid_monedaCompra= borderResaltar;
	}

	public Boolean getMostrarid_monedaCompra() {
		return this.mostrarid_monedaCompra;
	}

	public void setMostrarid_monedaCompra(Boolean mostrarid_monedaCompra) {
		this.mostrarid_monedaCompra= mostrarid_monedaCompra;
	}

	public Boolean getActivarid_monedaCompra() {
		return this.activarid_monedaCompra;
	}

	public void setActivarid_monedaCompra(Boolean activarid_monedaCompra) {
		this.activarid_monedaCompra= activarid_monedaCompra;
	}

	public Boolean getCargarid_monedaCompra() {
		return this.cargarid_monedaCompra;
	}

	public void setCargarid_monedaCompra(Boolean cargarid_monedaCompra) {
		this.cargarid_monedaCompra= cargarid_monedaCompra;
	}

	public Border setResaltarid_tipo_cambioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioCompra() {
		return this.resaltarid_tipo_cambioCompra;
	}

	public void setResaltarid_tipo_cambioCompra(Border borderResaltar) {
		this.resaltarid_tipo_cambioCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioCompra() {
		return this.mostrarid_tipo_cambioCompra;
	}

	public void setMostrarid_tipo_cambioCompra(Boolean mostrarid_tipo_cambioCompra) {
		this.mostrarid_tipo_cambioCompra= mostrarid_tipo_cambioCompra;
	}

	public Boolean getActivarid_tipo_cambioCompra() {
		return this.activarid_tipo_cambioCompra;
	}

	public void setActivarid_tipo_cambioCompra(Boolean activarid_tipo_cambioCompra) {
		this.activarid_tipo_cambioCompra= activarid_tipo_cambioCompra;
	}

	public Boolean getCargarid_tipo_cambioCompra() {
		return this.cargarid_tipo_cambioCompra;
	}

	public void setCargarid_tipo_cambioCompra(Boolean cargarid_tipo_cambioCompra) {
		this.cargarid_tipo_cambioCompra= cargarid_tipo_cambioCompra;
	}

	public Border setResaltarid_estado_inventarioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_inventarioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_inventarioCompra() {
		return this.resaltarid_estado_inventarioCompra;
	}

	public void setResaltarid_estado_inventarioCompra(Border borderResaltar) {
		this.resaltarid_estado_inventarioCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_inventarioCompra() {
		return this.mostrarid_estado_inventarioCompra;
	}

	public void setMostrarid_estado_inventarioCompra(Boolean mostrarid_estado_inventarioCompra) {
		this.mostrarid_estado_inventarioCompra= mostrarid_estado_inventarioCompra;
	}

	public Boolean getActivarid_estado_inventarioCompra() {
		return this.activarid_estado_inventarioCompra;
	}

	public void setActivarid_estado_inventarioCompra(Boolean activarid_estado_inventarioCompra) {
		this.activarid_estado_inventarioCompra= activarid_estado_inventarioCompra;
	}

	public Boolean getCargarid_estado_inventarioCompra() {
		return this.cargarid_estado_inventarioCompra;
	}

	public void setCargarid_estado_inventarioCompra(Boolean cargarid_estado_inventarioCompra) {
		this.cargarid_estado_inventarioCompra= cargarid_estado_inventarioCompra;
	}

	public Border setResaltarid_clienteCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_clienteCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCompra() {
		return this.resaltarid_clienteCompra;
	}

	public void setResaltarid_clienteCompra(Border borderResaltar) {
		this.resaltarid_clienteCompra= borderResaltar;
	}

	public Boolean getMostrarid_clienteCompra() {
		return this.mostrarid_clienteCompra;
	}

	public void setMostrarid_clienteCompra(Boolean mostrarid_clienteCompra) {
		this.mostrarid_clienteCompra= mostrarid_clienteCompra;
	}

	public Boolean getActivarid_clienteCompra() {
		return this.activarid_clienteCompra;
	}

	public void setActivarid_clienteCompra(Boolean activarid_clienteCompra) {
		this.activarid_clienteCompra= activarid_clienteCompra;
	}

	public Boolean getCargarid_clienteCompra() {
		return this.cargarid_clienteCompra;
	}

	public void setCargarid_clienteCompra(Boolean cargarid_clienteCompra) {
		this.cargarid_clienteCompra= cargarid_clienteCompra;
	}

	public Border setResaltarid_formatoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_formatoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoCompra() {
		return this.resaltarid_formatoCompra;
	}

	public void setResaltarid_formatoCompra(Border borderResaltar) {
		this.resaltarid_formatoCompra= borderResaltar;
	}

	public Boolean getMostrarid_formatoCompra() {
		return this.mostrarid_formatoCompra;
	}

	public void setMostrarid_formatoCompra(Boolean mostrarid_formatoCompra) {
		this.mostrarid_formatoCompra= mostrarid_formatoCompra;
	}

	public Boolean getActivarid_formatoCompra() {
		return this.activarid_formatoCompra;
	}

	public void setActivarid_formatoCompra(Boolean activarid_formatoCompra) {
		this.activarid_formatoCompra= activarid_formatoCompra;
	}

	public Boolean getCargarid_formatoCompra() {
		return this.cargarid_formatoCompra;
	}

	public void setCargarid_formatoCompra(Boolean cargarid_formatoCompra) {
		this.cargarid_formatoCompra= cargarid_formatoCompra;
	}

	public Border setResaltarid_empleadoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCompra() {
		return this.resaltarid_empleadoCompra;
	}

	public void setResaltarid_empleadoCompra(Border borderResaltar) {
		this.resaltarid_empleadoCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCompra() {
		return this.mostrarid_empleadoCompra;
	}

	public void setMostrarid_empleadoCompra(Boolean mostrarid_empleadoCompra) {
		this.mostrarid_empleadoCompra= mostrarid_empleadoCompra;
	}

	public Boolean getActivarid_empleadoCompra() {
		return this.activarid_empleadoCompra;
	}

	public void setActivarid_empleadoCompra(Boolean activarid_empleadoCompra) {
		this.activarid_empleadoCompra= activarid_empleadoCompra;
	}

	public Boolean getCargarid_empleadoCompra() {
		return this.cargarid_empleadoCompra;
	}

	public void setCargarid_empleadoCompra(Boolean cargarid_empleadoCompra) {
		this.cargarid_empleadoCompra= cargarid_empleadoCompra;
	}

	public Border setResaltarnumero_facturaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaCompra() {
		return this.resaltarnumero_facturaCompra;
	}

	public void setResaltarnumero_facturaCompra(Border borderResaltar) {
		this.resaltarnumero_facturaCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaCompra() {
		return this.mostrarnumero_facturaCompra;
	}

	public void setMostrarnumero_facturaCompra(Boolean mostrarnumero_facturaCompra) {
		this.mostrarnumero_facturaCompra= mostrarnumero_facturaCompra;
	}

	public Boolean getActivarnumero_facturaCompra() {
		return this.activarnumero_facturaCompra;
	}

	public void setActivarnumero_facturaCompra(Boolean activarnumero_facturaCompra) {
		this.activarnumero_facturaCompra= activarnumero_facturaCompra;
	}

	public Border setResaltarid_transportistaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_transportistaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaCompra() {
		return this.resaltarid_transportistaCompra;
	}

	public void setResaltarid_transportistaCompra(Border borderResaltar) {
		this.resaltarid_transportistaCompra= borderResaltar;
	}

	public Boolean getMostrarid_transportistaCompra() {
		return this.mostrarid_transportistaCompra;
	}

	public void setMostrarid_transportistaCompra(Boolean mostrarid_transportistaCompra) {
		this.mostrarid_transportistaCompra= mostrarid_transportistaCompra;
	}

	public Boolean getActivarid_transportistaCompra() {
		return this.activarid_transportistaCompra;
	}

	public void setActivarid_transportistaCompra(Boolean activarid_transportistaCompra) {
		this.activarid_transportistaCompra= activarid_transportistaCompra;
	}

	public Boolean getCargarid_transportistaCompra() {
		return this.cargarid_transportistaCompra;
	}

	public void setCargarid_transportistaCompra(Boolean cargarid_transportistaCompra) {
		this.cargarid_transportistaCompra= cargarid_transportistaCompra;
	}

	public Border setResaltardescripcionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCompra() {
		return this.resaltardescripcionCompra;
	}

	public void setResaltardescripcionCompra(Border borderResaltar) {
		this.resaltardescripcionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionCompra() {
		return this.mostrardescripcionCompra;
	}

	public void setMostrardescripcionCompra(Boolean mostrardescripcionCompra) {
		this.mostrardescripcionCompra= mostrardescripcionCompra;
	}

	public Boolean getActivardescripcionCompra() {
		return this.activardescripcionCompra;
	}

	public void setActivardescripcionCompra(Boolean activardescripcionCompra) {
		this.activardescripcionCompra= activardescripcionCompra;
	}

	public Border setResaltarid_orden_compraCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_orden_compraCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_compraCompra() {
		return this.resaltarid_orden_compraCompra;
	}

	public void setResaltarid_orden_compraCompra(Border borderResaltar) {
		this.resaltarid_orden_compraCompra= borderResaltar;
	}

	public Boolean getMostrarid_orden_compraCompra() {
		return this.mostrarid_orden_compraCompra;
	}

	public void setMostrarid_orden_compraCompra(Boolean mostrarid_orden_compraCompra) {
		this.mostrarid_orden_compraCompra= mostrarid_orden_compraCompra;
	}

	public Boolean getActivarid_orden_compraCompra() {
		return this.activarid_orden_compraCompra;
	}

	public void setActivarid_orden_compraCompra(Boolean activarid_orden_compraCompra) {
		this.activarid_orden_compraCompra= activarid_orden_compraCompra;
	}

	public Boolean getCargarid_orden_compraCompra() {
		return this.cargarid_orden_compraCompra;
	}

	public void setCargarid_orden_compraCompra(Boolean cargarid_orden_compraCompra) {
		this.cargarid_orden_compraCompra= cargarid_orden_compraCompra;
	}

	public Border setResaltarid_pedido_compraCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_pedido_compraCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_compraCompra() {
		return this.resaltarid_pedido_compraCompra;
	}

	public void setResaltarid_pedido_compraCompra(Border borderResaltar) {
		this.resaltarid_pedido_compraCompra= borderResaltar;
	}

	public Boolean getMostrarid_pedido_compraCompra() {
		return this.mostrarid_pedido_compraCompra;
	}

	public void setMostrarid_pedido_compraCompra(Boolean mostrarid_pedido_compraCompra) {
		this.mostrarid_pedido_compraCompra= mostrarid_pedido_compraCompra;
	}

	public Boolean getActivarid_pedido_compraCompra() {
		return this.activarid_pedido_compraCompra;
	}

	public void setActivarid_pedido_compraCompra(Boolean activarid_pedido_compraCompra) {
		this.activarid_pedido_compraCompra= activarid_pedido_compraCompra;
	}

	public Boolean getCargarid_pedido_compraCompra() {
		return this.cargarid_pedido_compraCompra;
	}

	public void setCargarid_pedido_compraCompra(Boolean cargarid_pedido_compraCompra) {
		this.cargarid_pedido_compraCompra= cargarid_pedido_compraCompra;
	}

	public Border setResaltarautori_usuarioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarautori_usuarioCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautori_usuarioCompra() {
		return this.resaltarautori_usuarioCompra;
	}

	public void setResaltarautori_usuarioCompra(Border borderResaltar) {
		this.resaltarautori_usuarioCompra= borderResaltar;
	}

	public Boolean getMostrarautori_usuarioCompra() {
		return this.mostrarautori_usuarioCompra;
	}

	public void setMostrarautori_usuarioCompra(Boolean mostrarautori_usuarioCompra) {
		this.mostrarautori_usuarioCompra= mostrarautori_usuarioCompra;
	}

	public Boolean getActivarautori_usuarioCompra() {
		return this.activarautori_usuarioCompra;
	}

	public void setActivarautori_usuarioCompra(Boolean activarautori_usuarioCompra) {
		this.activarautori_usuarioCompra= activarautori_usuarioCompra;
	}

	public Border setResaltarfactura_inicialCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfactura_inicialCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfactura_inicialCompra() {
		return this.resaltarfactura_inicialCompra;
	}

	public void setResaltarfactura_inicialCompra(Border borderResaltar) {
		this.resaltarfactura_inicialCompra= borderResaltar;
	}

	public Boolean getMostrarfactura_inicialCompra() {
		return this.mostrarfactura_inicialCompra;
	}

	public void setMostrarfactura_inicialCompra(Boolean mostrarfactura_inicialCompra) {
		this.mostrarfactura_inicialCompra= mostrarfactura_inicialCompra;
	}

	public Boolean getActivarfactura_inicialCompra() {
		return this.activarfactura_inicialCompra;
	}

	public void setActivarfactura_inicialCompra(Boolean activarfactura_inicialCompra) {
		this.activarfactura_inicialCompra= activarfactura_inicialCompra;
	}

	public Border setResaltarfactura_finalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfactura_finalCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfactura_finalCompra() {
		return this.resaltarfactura_finalCompra;
	}

	public void setResaltarfactura_finalCompra(Border borderResaltar) {
		this.resaltarfactura_finalCompra= borderResaltar;
	}

	public Boolean getMostrarfactura_finalCompra() {
		return this.mostrarfactura_finalCompra;
	}

	public void setMostrarfactura_finalCompra(Boolean mostrarfactura_finalCompra) {
		this.mostrarfactura_finalCompra= mostrarfactura_finalCompra;
	}

	public Boolean getActivarfactura_finalCompra() {
		return this.activarfactura_finalCompra;
	}

	public void setActivarfactura_finalCompra(Boolean activarfactura_finalCompra) {
		this.activarfactura_finalCompra= activarfactura_finalCompra;
	}

	public Border setResaltarservicio_documentoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarservicio_documentoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicio_documentoCompra() {
		return this.resaltarservicio_documentoCompra;
	}

	public void setResaltarservicio_documentoCompra(Border borderResaltar) {
		this.resaltarservicio_documentoCompra= borderResaltar;
	}

	public Boolean getMostrarservicio_documentoCompra() {
		return this.mostrarservicio_documentoCompra;
	}

	public void setMostrarservicio_documentoCompra(Boolean mostrarservicio_documentoCompra) {
		this.mostrarservicio_documentoCompra= mostrarservicio_documentoCompra;
	}

	public Boolean getActivarservicio_documentoCompra() {
		return this.activarservicio_documentoCompra;
	}

	public void setActivarservicio_documentoCompra(Boolean activarservicio_documentoCompra) {
		this.activarservicio_documentoCompra= activarservicio_documentoCompra;
	}

	public Border setResaltarfecha_valorCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_valorCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_valorCompra() {
		return this.resaltarfecha_valorCompra;
	}

	public void setResaltarfecha_valorCompra(Border borderResaltar) {
		this.resaltarfecha_valorCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_valorCompra() {
		return this.mostrarfecha_valorCompra;
	}

	public void setMostrarfecha_valorCompra(Boolean mostrarfecha_valorCompra) {
		this.mostrarfecha_valorCompra= mostrarfecha_valorCompra;
	}

	public Boolean getActivarfecha_valorCompra() {
		return this.activarfecha_valorCompra;
	}

	public void setActivarfecha_valorCompra(Boolean activarfecha_valorCompra) {
		this.activarfecha_valorCompra= activarfecha_valorCompra;
	}

	public Border setResaltarporcentaje_descuentoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoCompra() {
		return this.resaltarporcentaje_descuentoCompra;
	}

	public void setResaltarporcentaje_descuentoCompra(Border borderResaltar) {
		this.resaltarporcentaje_descuentoCompra= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoCompra() {
		return this.mostrarporcentaje_descuentoCompra;
	}

	public void setMostrarporcentaje_descuentoCompra(Boolean mostrarporcentaje_descuentoCompra) {
		this.mostrarporcentaje_descuentoCompra= mostrarporcentaje_descuentoCompra;
	}

	public Boolean getActivarporcentaje_descuentoCompra() {
		return this.activarporcentaje_descuentoCompra;
	}

	public void setActivarporcentaje_descuentoCompra(Boolean activarporcentaje_descuentoCompra) {
		this.activarporcentaje_descuentoCompra= activarporcentaje_descuentoCompra;
	}

	public Border setResaltarsumanCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarsumanCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanCompra() {
		return this.resaltarsumanCompra;
	}

	public void setResaltarsumanCompra(Border borderResaltar) {
		this.resaltarsumanCompra= borderResaltar;
	}

	public Boolean getMostrarsumanCompra() {
		return this.mostrarsumanCompra;
	}

	public void setMostrarsumanCompra(Boolean mostrarsumanCompra) {
		this.mostrarsumanCompra= mostrarsumanCompra;
	}

	public Boolean getActivarsumanCompra() {
		return this.activarsumanCompra;
	}

	public void setActivarsumanCompra(Boolean activarsumanCompra) {
		this.activarsumanCompra= activarsumanCompra;
	}

	public Border setResaltariceCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltariceCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceCompra() {
		return this.resaltariceCompra;
	}

	public void setResaltariceCompra(Border borderResaltar) {
		this.resaltariceCompra= borderResaltar;
	}

	public Boolean getMostrariceCompra() {
		return this.mostrariceCompra;
	}

	public void setMostrariceCompra(Boolean mostrariceCompra) {
		this.mostrariceCompra= mostrariceCompra;
	}

	public Boolean getActivariceCompra() {
		return this.activariceCompra;
	}

	public void setActivariceCompra(Boolean activariceCompra) {
		this.activariceCompra= activariceCompra;
	}

	public Border setResaltarvalor_descuentoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarvalor_descuentoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_descuentoCompra() {
		return this.resaltarvalor_descuentoCompra;
	}

	public void setResaltarvalor_descuentoCompra(Border borderResaltar) {
		this.resaltarvalor_descuentoCompra= borderResaltar;
	}

	public Boolean getMostrarvalor_descuentoCompra() {
		return this.mostrarvalor_descuentoCompra;
	}

	public void setMostrarvalor_descuentoCompra(Boolean mostrarvalor_descuentoCompra) {
		this.mostrarvalor_descuentoCompra= mostrarvalor_descuentoCompra;
	}

	public Boolean getActivarvalor_descuentoCompra() {
		return this.activarvalor_descuentoCompra;
	}

	public void setActivarvalor_descuentoCompra(Boolean activarvalor_descuentoCompra) {
		this.activarvalor_descuentoCompra= activarvalor_descuentoCompra;
	}

	public Border setResaltartotal_descuentoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoCompra() {
		return this.resaltartotal_descuentoCompra;
	}

	public void setResaltartotal_descuentoCompra(Border borderResaltar) {
		this.resaltartotal_descuentoCompra= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoCompra() {
		return this.mostrartotal_descuentoCompra;
	}

	public void setMostrartotal_descuentoCompra(Boolean mostrartotal_descuentoCompra) {
		this.mostrartotal_descuentoCompra= mostrartotal_descuentoCompra;
	}

	public Boolean getActivartotal_descuentoCompra() {
		return this.activartotal_descuentoCompra;
	}

	public void setActivartotal_descuentoCompra(Boolean activartotal_descuentoCompra) {
		this.activartotal_descuentoCompra= activartotal_descuentoCompra;
	}

	public Border setResaltarivaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarivaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaCompra() {
		return this.resaltarivaCompra;
	}

	public void setResaltarivaCompra(Border borderResaltar) {
		this.resaltarivaCompra= borderResaltar;
	}

	public Boolean getMostrarivaCompra() {
		return this.mostrarivaCompra;
	}

	public void setMostrarivaCompra(Boolean mostrarivaCompra) {
		this.mostrarivaCompra= mostrarivaCompra;
	}

	public Boolean getActivarivaCompra() {
		return this.activarivaCompra;
	}

	public void setActivarivaCompra(Boolean activarivaCompra) {
		this.activarivaCompra= activarivaCompra;
	}

	public Border setResaltarstockCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarstockCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstockCompra() {
		return this.resaltarstockCompra;
	}

	public void setResaltarstockCompra(Border borderResaltar) {
		this.resaltarstockCompra= borderResaltar;
	}

	public Boolean getMostrarstockCompra() {
		return this.mostrarstockCompra;
	}

	public void setMostrarstockCompra(Boolean mostrarstockCompra) {
		this.mostrarstockCompra= mostrarstockCompra;
	}

	public Boolean getActivarstockCompra() {
		return this.activarstockCompra;
	}

	public void setActivarstockCompra(Boolean activarstockCompra) {
		this.activarstockCompra= activarstockCompra;
	}

	public Border setResaltarsub_totalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarsub_totalCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalCompra() {
		return this.resaltarsub_totalCompra;
	}

	public void setResaltarsub_totalCompra(Border borderResaltar) {
		this.resaltarsub_totalCompra= borderResaltar;
	}

	public Boolean getMostrarsub_totalCompra() {
		return this.mostrarsub_totalCompra;
	}

	public void setMostrarsub_totalCompra(Boolean mostrarsub_totalCompra) {
		this.mostrarsub_totalCompra= mostrarsub_totalCompra;
	}

	public Boolean getActivarsub_totalCompra() {
		return this.activarsub_totalCompra;
	}

	public void setActivarsub_totalCompra(Boolean activarsub_totalCompra) {
		this.activarsub_totalCompra= activarsub_totalCompra;
	}

	public Border setResaltartotal_otroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltartotal_otroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroCompra() {
		return this.resaltartotal_otroCompra;
	}

	public void setResaltartotal_otroCompra(Border borderResaltar) {
		this.resaltartotal_otroCompra= borderResaltar;
	}

	public Boolean getMostrartotal_otroCompra() {
		return this.mostrartotal_otroCompra;
	}

	public void setMostrartotal_otroCompra(Boolean mostrartotal_otroCompra) {
		this.mostrartotal_otroCompra= mostrartotal_otroCompra;
	}

	public Boolean getActivartotal_otroCompra() {
		return this.activartotal_otroCompra;
	}

	public void setActivartotal_otroCompra(Boolean activartotal_otroCompra) {
		this.activartotal_otroCompra= activartotal_otroCompra;
	}

	public Border setResaltarultimo_costoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarultimo_costoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoCompra() {
		return this.resaltarultimo_costoCompra;
	}

	public void setResaltarultimo_costoCompra(Border borderResaltar) {
		this.resaltarultimo_costoCompra= borderResaltar;
	}

	public Boolean getMostrarultimo_costoCompra() {
		return this.mostrarultimo_costoCompra;
	}

	public void setMostrarultimo_costoCompra(Boolean mostrarultimo_costoCompra) {
		this.mostrarultimo_costoCompra= mostrarultimo_costoCompra;
	}

	public Boolean getActivarultimo_costoCompra() {
		return this.activarultimo_costoCompra;
	}

	public void setActivarultimo_costoCompra(Boolean activarultimo_costoCompra) {
		this.activarultimo_costoCompra= activarultimo_costoCompra;
	}

	public Border setResaltarnumero_itemsCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_itemsCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_itemsCompra() {
		return this.resaltarnumero_itemsCompra;
	}

	public void setResaltarnumero_itemsCompra(Border borderResaltar) {
		this.resaltarnumero_itemsCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_itemsCompra() {
		return this.mostrarnumero_itemsCompra;
	}

	public void setMostrarnumero_itemsCompra(Boolean mostrarnumero_itemsCompra) {
		this.mostrarnumero_itemsCompra= mostrarnumero_itemsCompra;
	}

	public Boolean getActivarnumero_itemsCompra() {
		return this.activarnumero_itemsCompra;
	}

	public void setActivarnumero_itemsCompra(Boolean activarnumero_itemsCompra) {
		this.activarnumero_itemsCompra= activarnumero_itemsCompra;
	}

	public Border setResaltarretencionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarretencionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionCompra() {
		return this.resaltarretencionCompra;
	}

	public void setResaltarretencionCompra(Border borderResaltar) {
		this.resaltarretencionCompra= borderResaltar;
	}

	public Boolean getMostrarretencionCompra() {
		return this.mostrarretencionCompra;
	}

	public void setMostrarretencionCompra(Boolean mostrarretencionCompra) {
		this.mostrarretencionCompra= mostrarretencionCompra;
	}

	public Boolean getActivarretencionCompra() {
		return this.activarretencionCompra;
	}

	public void setActivarretencionCompra(Boolean activarretencionCompra) {
		this.activarretencionCompra= activarretencionCompra;
	}

	public Border setResaltartotalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltartotalCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCompra() {
		return this.resaltartotalCompra;
	}

	public void setResaltartotalCompra(Border borderResaltar) {
		this.resaltartotalCompra= borderResaltar;
	}

	public Boolean getMostrartotalCompra() {
		return this.mostrartotalCompra;
	}

	public void setMostrartotalCompra(Boolean mostrartotalCompra) {
		this.mostrartotalCompra= mostrartotalCompra;
	}

	public Boolean getActivartotalCompra() {
		return this.activartotalCompra;
	}

	public void setActivartotalCompra(Boolean activartotalCompra) {
		this.activartotalCompra= activartotalCompra;
	}

	public Border setResaltarfleteCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfleteCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteCompra() {
		return this.resaltarfleteCompra;
	}

	public void setResaltarfleteCompra(Border borderResaltar) {
		this.resaltarfleteCompra= borderResaltar;
	}

	public Boolean getMostrarfleteCompra() {
		return this.mostrarfleteCompra;
	}

	public void setMostrarfleteCompra(Boolean mostrarfleteCompra) {
		this.mostrarfleteCompra= mostrarfleteCompra;
	}

	public Boolean getActivarfleteCompra() {
		return this.activarfleteCompra;
	}

	public void setActivarfleteCompra(Boolean activarfleteCompra) {
		this.activarfleteCompra= activarfleteCompra;
	}

	public Border setResaltarimpuestoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarimpuestoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoCompra() {
		return this.resaltarimpuestoCompra;
	}

	public void setResaltarimpuestoCompra(Border borderResaltar) {
		this.resaltarimpuestoCompra= borderResaltar;
	}

	public Boolean getMostrarimpuestoCompra() {
		return this.mostrarimpuestoCompra;
	}

	public void setMostrarimpuestoCompra(Boolean mostrarimpuestoCompra) {
		this.mostrarimpuestoCompra= mostrarimpuestoCompra;
	}

	public Boolean getActivarimpuestoCompra() {
		return this.activarimpuestoCompra;
	}

	public void setActivarimpuestoCompra(Boolean activarimpuestoCompra) {
		this.activarimpuestoCompra= activarimpuestoCompra;
	}

	public Border setResaltarid_tipo_transaccion_moduloCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloCompra() {
		return this.resaltarid_tipo_transaccion_moduloCompra;
	}

	public void setResaltarid_tipo_transaccion_moduloCompra(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloCompra() {
		return this.mostrarid_tipo_transaccion_moduloCompra;
	}

	public void setMostrarid_tipo_transaccion_moduloCompra(Boolean mostrarid_tipo_transaccion_moduloCompra) {
		this.mostrarid_tipo_transaccion_moduloCompra= mostrarid_tipo_transaccion_moduloCompra;
	}

	public Boolean getActivarid_tipo_transaccion_moduloCompra() {
		return this.activarid_tipo_transaccion_moduloCompra;
	}

	public void setActivarid_tipo_transaccion_moduloCompra(Boolean activarid_tipo_transaccion_moduloCompra) {
		this.activarid_tipo_transaccion_moduloCompra= activarid_tipo_transaccion_moduloCompra;
	}

	public Boolean getCargarid_tipo_transaccion_moduloCompra() {
		return this.cargarid_tipo_transaccion_moduloCompra;
	}

	public void setCargarid_tipo_transaccion_moduloCompra(Boolean cargarid_tipo_transaccion_moduloCompra) {
		this.cargarid_tipo_transaccion_moduloCompra= cargarid_tipo_transaccion_moduloCompra;
	}

	public Border setResaltarid_asiento_contableCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableCompra() {
		return this.resaltarid_asiento_contableCompra;
	}

	public void setResaltarid_asiento_contableCompra(Border borderResaltar) {
		this.resaltarid_asiento_contableCompra= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableCompra() {
		return this.mostrarid_asiento_contableCompra;
	}

	public void setMostrarid_asiento_contableCompra(Boolean mostrarid_asiento_contableCompra) {
		this.mostrarid_asiento_contableCompra= mostrarid_asiento_contableCompra;
	}

	public Boolean getActivarid_asiento_contableCompra() {
		return this.activarid_asiento_contableCompra;
	}

	public void setActivarid_asiento_contableCompra(Boolean activarid_asiento_contableCompra) {
		this.activarid_asiento_contableCompra= activarid_asiento_contableCompra;
	}

	public Boolean getCargarid_asiento_contableCompra() {
		return this.cargarid_asiento_contableCompra;
	}

	public void setCargarid_asiento_contableCompra(Boolean cargarid_asiento_contableCompra) {
		this.cargarid_asiento_contableCompra= cargarid_asiento_contableCompra;
	}

	public Border setResaltarnumero_comprobanteCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCompra() {
		return this.resaltarnumero_comprobanteCompra;
	}

	public void setResaltarnumero_comprobanteCompra(Border borderResaltar) {
		this.resaltarnumero_comprobanteCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCompra() {
		return this.mostrarnumero_comprobanteCompra;
	}

	public void setMostrarnumero_comprobanteCompra(Boolean mostrarnumero_comprobanteCompra) {
		this.mostrarnumero_comprobanteCompra= mostrarnumero_comprobanteCompra;
	}

	public Boolean getActivarnumero_comprobanteCompra() {
		return this.activarnumero_comprobanteCompra;
	}

	public void setActivarnumero_comprobanteCompra(Boolean activarnumero_comprobanteCompra) {
		this.activarnumero_comprobanteCompra= activarnumero_comprobanteCompra;
	}

	public Border setResaltarfechaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltar);
		
		this.resaltarfechaCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCompra() {
		return this.resaltarfechaCompra;
	}

	public void setResaltarfechaCompra(Border borderResaltar) {
		this.resaltarfechaCompra= borderResaltar;
	}

	public Boolean getMostrarfechaCompra() {
		return this.mostrarfechaCompra;
	}

	public void setMostrarfechaCompra(Boolean mostrarfechaCompra) {
		this.mostrarfechaCompra= mostrarfechaCompra;
	}

	public Boolean getActivarfechaCompra() {
		return this.activarfechaCompra;
	}

	public void setActivarfechaCompra(Boolean activarfechaCompra) {
		this.activarfechaCompra= activarfechaCompra;
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
		
		
		this.setMostraridCompra(esInicial);
		this.setMostrarid_empresaCompra(esInicial);
		this.setMostrarid_sucursalCompra(esInicial);
		this.setMostrarid_moduloCompra(esInicial);
		this.setMostrarid_ejercicioCompra(esInicial);
		this.setMostrarid_periodoCompra(esInicial);
		this.setMostrarid_anioCompra(esInicial);
		this.setMostrarid_mesCompra(esInicial);
		this.setMostrarid_usuarioCompra(esInicial);
		this.setMostrarfecha_emisionCompra(esInicial);
		this.setMostrarfecha_entregaCompra(esInicial);
		this.setMostrarnumero_secuencialCompra(esInicial);
		this.setMostrarid_monedaCompra(esInicial);
		this.setMostrarid_tipo_cambioCompra(esInicial);
		this.setMostrarid_estado_inventarioCompra(esInicial);
		this.setMostrarid_clienteCompra(esInicial);
		this.setMostrarid_formatoCompra(esInicial);
		this.setMostrarid_empleadoCompra(esInicial);
		this.setMostrarnumero_facturaCompra(esInicial);
		this.setMostrarid_transportistaCompra(esInicial);
		this.setMostrardescripcionCompra(esInicial);
		this.setMostrarid_orden_compraCompra(esInicial);
		this.setMostrarid_pedido_compraCompra(esInicial);
		this.setMostrarautori_usuarioCompra(esInicial);
		this.setMostrarfactura_inicialCompra(esInicial);
		this.setMostrarfactura_finalCompra(esInicial);
		this.setMostrarservicio_documentoCompra(esInicial);
		this.setMostrarfecha_valorCompra(esInicial);
		this.setMostrarporcentaje_descuentoCompra(esInicial);
		this.setMostrarsumanCompra(esInicial);
		this.setMostrariceCompra(esInicial);
		this.setMostrarvalor_descuentoCompra(esInicial);
		this.setMostrartotal_descuentoCompra(esInicial);
		this.setMostrarivaCompra(esInicial);
		this.setMostrarstockCompra(esInicial);
		this.setMostrarsub_totalCompra(esInicial);
		this.setMostrartotal_otroCompra(esInicial);
		this.setMostrarultimo_costoCompra(esInicial);
		this.setMostrarnumero_itemsCompra(esInicial);
		this.setMostrarretencionCompra(esInicial);
		this.setMostrartotalCompra(esInicial);
		this.setMostrarfleteCompra(esInicial);
		this.setMostrarimpuestoCompra(esInicial);
		this.setMostrarid_tipo_transaccion_moduloCompra(esInicial);
		this.setMostrarid_asiento_contableCompra(esInicial);
		this.setMostrarnumero_comprobanteCompra(esInicial);
		this.setMostrarfechaCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompraConstantesFunciones.ID)) {
				this.setMostraridCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setMostrarid_estado_inventarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setMostrarid_orden_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setMostrarid_pedido_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.AUTORIUSUARIO)) {
				this.setMostrarautori_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAINICIAL)) {
				this.setMostrarfactura_inicialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAFINAL)) {
				this.setMostrarfactura_finalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SERVICIODOCUMENTO)) {
				this.setMostrarservicio_documentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAVALOR)) {
				this.setMostrarfecha_valorCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUMAN)) {
				this.setMostrarsumanCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ICE)) {
				this.setMostrariceCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.VALORDESCUENTO)) {
				this.setMostrarvalor_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IVA)) {
				this.setMostrarivaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.STOCK)) {
				this.setMostrarstockCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROITEMS)) {
				this.setMostrarnumero_itemsCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.RETENCION)) {
				this.setMostrarretencionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTAL)) {
				this.setMostrartotalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FLETE)) {
				this.setMostrarfleteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaCompra(esAsigna);
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
		
		
		this.setActivaridCompra(esInicial);
		this.setActivarid_empresaCompra(esInicial);
		this.setActivarid_sucursalCompra(esInicial);
		this.setActivarid_moduloCompra(esInicial);
		this.setActivarid_ejercicioCompra(esInicial);
		this.setActivarid_periodoCompra(esInicial);
		this.setActivarid_anioCompra(esInicial);
		this.setActivarid_mesCompra(esInicial);
		this.setActivarid_usuarioCompra(esInicial);
		this.setActivarfecha_emisionCompra(esInicial);
		this.setActivarfecha_entregaCompra(esInicial);
		this.setActivarnumero_secuencialCompra(esInicial);
		this.setActivarid_monedaCompra(esInicial);
		this.setActivarid_tipo_cambioCompra(esInicial);
		this.setActivarid_estado_inventarioCompra(esInicial);
		this.setActivarid_clienteCompra(esInicial);
		this.setActivarid_formatoCompra(esInicial);
		this.setActivarid_empleadoCompra(esInicial);
		this.setActivarnumero_facturaCompra(esInicial);
		this.setActivarid_transportistaCompra(esInicial);
		this.setActivardescripcionCompra(esInicial);
		this.setActivarid_orden_compraCompra(esInicial);
		this.setActivarid_pedido_compraCompra(esInicial);
		this.setActivarautori_usuarioCompra(esInicial);
		this.setActivarfactura_inicialCompra(esInicial);
		this.setActivarfactura_finalCompra(esInicial);
		this.setActivarservicio_documentoCompra(esInicial);
		this.setActivarfecha_valorCompra(esInicial);
		this.setActivarporcentaje_descuentoCompra(esInicial);
		this.setActivarsumanCompra(esInicial);
		this.setActivariceCompra(esInicial);
		this.setActivarvalor_descuentoCompra(esInicial);
		this.setActivartotal_descuentoCompra(esInicial);
		this.setActivarivaCompra(esInicial);
		this.setActivarstockCompra(esInicial);
		this.setActivarsub_totalCompra(esInicial);
		this.setActivartotal_otroCompra(esInicial);
		this.setActivarultimo_costoCompra(esInicial);
		this.setActivarnumero_itemsCompra(esInicial);
		this.setActivarretencionCompra(esInicial);
		this.setActivartotalCompra(esInicial);
		this.setActivarfleteCompra(esInicial);
		this.setActivarimpuestoCompra(esInicial);
		this.setActivarid_tipo_transaccion_moduloCompra(esInicial);
		this.setActivarid_asiento_contableCompra(esInicial);
		this.setActivarnumero_comprobanteCompra(esInicial);
		this.setActivarfechaCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompraConstantesFunciones.ID)) {
				this.setActivaridCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setActivarid_estado_inventarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setActivarid_orden_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setActivarid_pedido_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.AUTORIUSUARIO)) {
				this.setActivarautori_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAINICIAL)) {
				this.setActivarfactura_inicialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAFINAL)) {
				this.setActivarfactura_finalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SERVICIODOCUMENTO)) {
				this.setActivarservicio_documentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAVALOR)) {
				this.setActivarfecha_valorCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUMAN)) {
				this.setActivarsumanCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ICE)) {
				this.setActivariceCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.VALORDESCUENTO)) {
				this.setActivarvalor_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IVA)) {
				this.setActivarivaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.STOCK)) {
				this.setActivarstockCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROITEMS)) {
				this.setActivarnumero_itemsCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.RETENCION)) {
				this.setActivarretencionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTAL)) {
				this.setActivartotalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FLETE)) {
				this.setActivarfleteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHA)) {
				this.setActivarfechaCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCompra(esInicial);
		this.setResaltarid_empresaCompra(esInicial);
		this.setResaltarid_sucursalCompra(esInicial);
		this.setResaltarid_moduloCompra(esInicial);
		this.setResaltarid_ejercicioCompra(esInicial);
		this.setResaltarid_periodoCompra(esInicial);
		this.setResaltarid_anioCompra(esInicial);
		this.setResaltarid_mesCompra(esInicial);
		this.setResaltarid_usuarioCompra(esInicial);
		this.setResaltarfecha_emisionCompra(esInicial);
		this.setResaltarfecha_entregaCompra(esInicial);
		this.setResaltarnumero_secuencialCompra(esInicial);
		this.setResaltarid_monedaCompra(esInicial);
		this.setResaltarid_tipo_cambioCompra(esInicial);
		this.setResaltarid_estado_inventarioCompra(esInicial);
		this.setResaltarid_clienteCompra(esInicial);
		this.setResaltarid_formatoCompra(esInicial);
		this.setResaltarid_empleadoCompra(esInicial);
		this.setResaltarnumero_facturaCompra(esInicial);
		this.setResaltarid_transportistaCompra(esInicial);
		this.setResaltardescripcionCompra(esInicial);
		this.setResaltarid_orden_compraCompra(esInicial);
		this.setResaltarid_pedido_compraCompra(esInicial);
		this.setResaltarautori_usuarioCompra(esInicial);
		this.setResaltarfactura_inicialCompra(esInicial);
		this.setResaltarfactura_finalCompra(esInicial);
		this.setResaltarservicio_documentoCompra(esInicial);
		this.setResaltarfecha_valorCompra(esInicial);
		this.setResaltarporcentaje_descuentoCompra(esInicial);
		this.setResaltarsumanCompra(esInicial);
		this.setResaltariceCompra(esInicial);
		this.setResaltarvalor_descuentoCompra(esInicial);
		this.setResaltartotal_descuentoCompra(esInicial);
		this.setResaltarivaCompra(esInicial);
		this.setResaltarstockCompra(esInicial);
		this.setResaltarsub_totalCompra(esInicial);
		this.setResaltartotal_otroCompra(esInicial);
		this.setResaltarultimo_costoCompra(esInicial);
		this.setResaltarnumero_itemsCompra(esInicial);
		this.setResaltarretencionCompra(esInicial);
		this.setResaltartotalCompra(esInicial);
		this.setResaltarfleteCompra(esInicial);
		this.setResaltarimpuestoCompra(esInicial);
		this.setResaltarid_tipo_transaccion_moduloCompra(esInicial);
		this.setResaltarid_asiento_contableCompra(esInicial);
		this.setResaltarnumero_comprobanteCompra(esInicial);
		this.setResaltarfechaCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompraConstantesFunciones.ID)) {
				this.setResaltaridCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setResaltarid_estado_inventarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setResaltarid_orden_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setResaltarid_pedido_compraCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.AUTORIUSUARIO)) {
				this.setResaltarautori_usuarioCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAINICIAL)) {
				this.setResaltarfactura_inicialCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FACTURAFINAL)) {
				this.setResaltarfactura_finalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SERVICIODOCUMENTO)) {
				this.setResaltarservicio_documentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHAVALOR)) {
				this.setResaltarfecha_valorCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUMAN)) {
				this.setResaltarsumanCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ICE)) {
				this.setResaltariceCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.VALORDESCUENTO)) {
				this.setResaltarvalor_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IVA)) {
				this.setResaltarivaCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.STOCK)) {
				this.setResaltarstockCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROITEMS)) {
				this.setResaltarnumero_itemsCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.RETENCION)) {
				this.setResaltarretencionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.TOTAL)) {
				this.setResaltartotalCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FLETE)) {
				this.setResaltarfleteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRetencionInvenCompra=null;

	public Border getResaltarRetencionInvenCompra() {
		return this.resaltarRetencionInvenCompra;
	}

	public void setResaltarRetencionInvenCompra(Border borderResaltarRetencionInven) {
		if(borderResaltarRetencionInven!=null) {
			this.resaltarRetencionInvenCompra= borderResaltarRetencionInven;
		}
	}

	public Border setResaltarRetencionInvenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltarRetencionInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltarRetencionInven);
			
		this.resaltarRetencionInvenCompra= borderResaltarRetencionInven;

		 return borderResaltarRetencionInven;
	}



	public Boolean mostrarRetencionInvenCompra=true;

	public Boolean getMostrarRetencionInvenCompra() {
		return this.mostrarRetencionInvenCompra;
	}

	public void setMostrarRetencionInvenCompra(Boolean visibilidadResaltarRetencionInven) {
		this.mostrarRetencionInvenCompra= visibilidadResaltarRetencionInven;
	}



	public Boolean activarRetencionInvenCompra=true;

	public Boolean gethabilitarResaltarRetencionInvenCompra() {
		return this.activarRetencionInvenCompra;
	}

	public void setActivarRetencionInvenCompra(Boolean habilitarResaltarRetencionInven) {
		this.activarRetencionInvenCompra= habilitarResaltarRetencionInven;
	}


	public Border resaltarTransaccionLocalCompra=null;

	public Border getResaltarTransaccionLocalCompra() {
		return this.resaltarTransaccionLocalCompra;
	}

	public void setResaltarTransaccionLocalCompra(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalCompra= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalCompra= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalCompra=true;

	public Boolean getMostrarTransaccionLocalCompra() {
		return this.mostrarTransaccionLocalCompra;
	}

	public void setMostrarTransaccionLocalCompra(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalCompra= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalCompra=true;

	public Boolean gethabilitarResaltarTransaccionLocalCompra() {
		return this.activarTransaccionLocalCompra;
	}

	public void setActivarTransaccionLocalCompra(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalCompra= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarFormaPagoInvenCompra=null;

	public Border getResaltarFormaPagoInvenCompra() {
		return this.resaltarFormaPagoInvenCompra;
	}

	public void setResaltarFormaPagoInvenCompra(Border borderResaltarFormaPagoInven) {
		if(borderResaltarFormaPagoInven!=null) {
			this.resaltarFormaPagoInvenCompra= borderResaltarFormaPagoInven;
		}
	}

	public Border setResaltarFormaPagoInvenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltarFormaPagoInven);
			
		this.resaltarFormaPagoInvenCompra= borderResaltarFormaPagoInven;

		 return borderResaltarFormaPagoInven;
	}



	public Boolean mostrarFormaPagoInvenCompra=true;

	public Boolean getMostrarFormaPagoInvenCompra() {
		return this.mostrarFormaPagoInvenCompra;
	}

	public void setMostrarFormaPagoInvenCompra(Boolean visibilidadResaltarFormaPagoInven) {
		this.mostrarFormaPagoInvenCompra= visibilidadResaltarFormaPagoInven;
	}



	public Boolean activarFormaPagoInvenCompra=true;

	public Boolean gethabilitarResaltarFormaPagoInvenCompra() {
		return this.activarFormaPagoInvenCompra;
	}

	public void setActivarFormaPagoInvenCompra(Boolean habilitarResaltarFormaPagoInven) {
		this.activarFormaPagoInvenCompra= habilitarResaltarFormaPagoInven;
	}


	public Border resaltarDetalleCompraCompra=null;

	public Border getResaltarDetalleCompraCompra() {
		return this.resaltarDetalleCompraCompra;
	}

	public void setResaltarDetalleCompraCompra(Border borderResaltarDetalleCompra) {
		if(borderResaltarDetalleCompra!=null) {
			this.resaltarDetalleCompraCompra= borderResaltarDetalleCompra;
		}
	}

	public Border setResaltarDetalleCompraCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//compraBeanSwingJInternalFrame.jTtoolBarCompra.setBorder(borderResaltarDetalleCompra);
			
		this.resaltarDetalleCompraCompra= borderResaltarDetalleCompra;

		 return borderResaltarDetalleCompra;
	}



	public Boolean mostrarDetalleCompraCompra=true;

	public Boolean getMostrarDetalleCompraCompra() {
		return this.mostrarDetalleCompraCompra;
	}

	public void setMostrarDetalleCompraCompra(Boolean visibilidadResaltarDetalleCompra) {
		this.mostrarDetalleCompraCompra= visibilidadResaltarDetalleCompra;
	}



	public Boolean activarDetalleCompraCompra=true;

	public Boolean gethabilitarResaltarDetalleCompraCompra() {
		return this.activarDetalleCompraCompra;
	}

	public void setActivarDetalleCompraCompra(Boolean habilitarResaltarDetalleCompra) {
		this.activarDetalleCompraCompra= habilitarResaltarDetalleCompra;
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

		this.setMostrarRetencionInvenCompra(esInicial);
		this.setMostrarTransaccionLocalCompra(esInicial);
		this.setMostrarFormaPagoInvenCompra(esInicial);
		this.setMostrarDetalleCompraCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RetencionInven.class)) {
				this.setMostrarRetencionInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setMostrarFormaPagoInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setMostrarDetalleCompraCompra(esAsigna);
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

		this.setActivarRetencionInvenCompra(esInicial);
		this.setActivarTransaccionLocalCompra(esInicial);
		this.setActivarFormaPagoInvenCompra(esInicial);
		this.setActivarDetalleCompraCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RetencionInven.class)) {
				this.setActivarRetencionInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setActivarFormaPagoInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setActivarDetalleCompraCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRetencionInvenCompra(esInicial);
		this.setResaltarTransaccionLocalCompra(esInicial);
		this.setResaltarFormaPagoInvenCompra(esInicial);
		this.setResaltarDetalleCompraCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RetencionInven.class)) {
				this.setResaltarRetencionInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setResaltarFormaPagoInvenCompra(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setResaltarDetalleCompraCompra(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableCompra=true;

	public Boolean getMostrarFK_IdAsientoContableCompra() {
		return this.mostrarFK_IdAsientoContableCompra;
	}

	public void setMostrarFK_IdAsientoContableCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteCompra=true;

	public Boolean getMostrarFK_IdClienteCompra() {
		return this.mostrarFK_IdClienteCompra;
	}

	public void setMostrarFK_IdClienteCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioCompra=true;

	public Boolean getMostrarFK_IdEjercicioCompra() {
		return this.mostrarFK_IdEjercicioCompra;
	}

	public void setMostrarFK_IdEjercicioCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoCompra=true;

	public Boolean getMostrarFK_IdEmpleadoCompra() {
		return this.mostrarFK_IdEmpleadoCompra;
	}

	public void setMostrarFK_IdEmpleadoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCompra=true;

	public Boolean getMostrarFK_IdEmpresaCompra() {
		return this.mostrarFK_IdEmpresaCompra;
	}

	public void setMostrarFK_IdEmpresaCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoInventarioCompra=true;

	public Boolean getMostrarFK_IdEstadoInventarioCompra() {
		return this.mostrarFK_IdEstadoInventarioCompra;
	}

	public void setMostrarFK_IdEstadoInventarioCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoInventarioCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloCompra=true;

	public Boolean getMostrarFK_IdModuloCompra() {
		return this.mostrarFK_IdModuloCompra;
	}

	public void setMostrarFK_IdModuloCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenCompraCompra=true;

	public Boolean getMostrarFK_IdOrdenCompraCompra() {
		return this.mostrarFK_IdOrdenCompraCompra;
	}

	public void setMostrarFK_IdOrdenCompraCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenCompraCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoCompraCompra=true;

	public Boolean getMostrarFK_IdPedidoCompraCompra() {
		return this.mostrarFK_IdPedidoCompraCompra;
	}

	public void setMostrarFK_IdPedidoCompraCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoCompraCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoCompra=true;

	public Boolean getMostrarFK_IdPeriodoCompra() {
		return this.mostrarFK_IdPeriodoCompra;
	}

	public void setMostrarFK_IdPeriodoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCompra=true;

	public Boolean getMostrarFK_IdSucursalCompra() {
		return this.mostrarFK_IdSucursalCompra;
	}

	public void setMostrarFK_IdSucursalCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloCompra=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloCompra() {
		return this.mostrarFK_IdTipoTransaccionModuloCompra;
	}

	public void setMostrarFK_IdTipoTransaccionModuloCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioCompra=true;

	public Boolean getMostrarFK_IdUsuarioCompra() {
		return this.mostrarFK_IdUsuarioCompra;
	}

	public void setMostrarFK_IdUsuarioCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableCompra=true;

	public Boolean getActivarFK_IdAsientoContableCompra() {
		return this.activarFK_IdAsientoContableCompra;
	}

	public void setActivarFK_IdAsientoContableCompra(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteCompra=true;

	public Boolean getActivarFK_IdClienteCompra() {
		return this.activarFK_IdClienteCompra;
	}

	public void setActivarFK_IdClienteCompra(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioCompra=true;

	public Boolean getActivarFK_IdEjercicioCompra() {
		return this.activarFK_IdEjercicioCompra;
	}

	public void setActivarFK_IdEjercicioCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoCompra=true;

	public Boolean getActivarFK_IdEmpleadoCompra() {
		return this.activarFK_IdEmpleadoCompra;
	}

	public void setActivarFK_IdEmpleadoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCompra=true;

	public Boolean getActivarFK_IdEmpresaCompra() {
		return this.activarFK_IdEmpresaCompra;
	}

	public void setActivarFK_IdEmpresaCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoInventarioCompra=true;

	public Boolean getActivarFK_IdEstadoInventarioCompra() {
		return this.activarFK_IdEstadoInventarioCompra;
	}

	public void setActivarFK_IdEstadoInventarioCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoInventarioCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloCompra=true;

	public Boolean getActivarFK_IdModuloCompra() {
		return this.activarFK_IdModuloCompra;
	}

	public void setActivarFK_IdModuloCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenCompraCompra=true;

	public Boolean getActivarFK_IdOrdenCompraCompra() {
		return this.activarFK_IdOrdenCompraCompra;
	}

	public void setActivarFK_IdOrdenCompraCompra(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenCompraCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoCompraCompra=true;

	public Boolean getActivarFK_IdPedidoCompraCompra() {
		return this.activarFK_IdPedidoCompraCompra;
	}

	public void setActivarFK_IdPedidoCompraCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoCompraCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoCompra=true;

	public Boolean getActivarFK_IdPeriodoCompra() {
		return this.activarFK_IdPeriodoCompra;
	}

	public void setActivarFK_IdPeriodoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCompra=true;

	public Boolean getActivarFK_IdSucursalCompra() {
		return this.activarFK_IdSucursalCompra;
	}

	public void setActivarFK_IdSucursalCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloCompra=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloCompra() {
		return this.activarFK_IdTipoTransaccionModuloCompra;
	}

	public void setActivarFK_IdTipoTransaccionModuloCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioCompra=true;

	public Boolean getActivarFK_IdUsuarioCompra() {
		return this.activarFK_IdUsuarioCompra;
	}

	public void setActivarFK_IdUsuarioCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableCompra=null;

	public Border getResaltarFK_IdAsientoContableCompra() {
		return this.resaltarFK_IdAsientoContableCompra;
	}

	public void setResaltarFK_IdAsientoContableCompra(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableCompra= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableCompra= borderResaltar;
	}

	public Border resaltarFK_IdClienteCompra=null;

	public Border getResaltarFK_IdClienteCompra() {
		return this.resaltarFK_IdClienteCompra;
	}

	public void setResaltarFK_IdClienteCompra(Border borderResaltar) {
		this.resaltarFK_IdClienteCompra= borderResaltar;
	}

	public void setResaltarFK_IdClienteCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioCompra=null;

	public Border getResaltarFK_IdEjercicioCompra() {
		return this.resaltarFK_IdEjercicioCompra;
	}

	public void setResaltarFK_IdEjercicioCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoCompra=null;

	public Border getResaltarFK_IdEmpleadoCompra() {
		return this.resaltarFK_IdEmpleadoCompra;
	}

	public void setResaltarFK_IdEmpleadoCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCompra=null;

	public Border getResaltarFK_IdEmpresaCompra() {
		return this.resaltarFK_IdEmpresaCompra;
	}

	public void setResaltarFK_IdEmpresaCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoInventarioCompra=null;

	public Border getResaltarFK_IdEstadoInventarioCompra() {
		return this.resaltarFK_IdEstadoInventarioCompra;
	}

	public void setResaltarFK_IdEstadoInventarioCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoInventarioCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoInventarioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoInventarioCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloCompra=null;

	public Border getResaltarFK_IdModuloCompra() {
		return this.resaltarFK_IdModuloCompra;
	}

	public void setResaltarFK_IdModuloCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloCompra= borderResaltar;
	}

	public Border resaltarFK_IdOrdenCompraCompra=null;

	public Border getResaltarFK_IdOrdenCompraCompra() {
		return this.resaltarFK_IdOrdenCompraCompra;
	}

	public void setResaltarFK_IdOrdenCompraCompra(Border borderResaltar) {
		this.resaltarFK_IdOrdenCompraCompra= borderResaltar;
	}

	public void setResaltarFK_IdOrdenCompraCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenCompraCompra= borderResaltar;
	}

	public Border resaltarFK_IdPedidoCompraCompra=null;

	public Border getResaltarFK_IdPedidoCompraCompra() {
		return this.resaltarFK_IdPedidoCompraCompra;
	}

	public void setResaltarFK_IdPedidoCompraCompra(Border borderResaltar) {
		this.resaltarFK_IdPedidoCompraCompra= borderResaltar;
	}

	public void setResaltarFK_IdPedidoCompraCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoCompraCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoCompra=null;

	public Border getResaltarFK_IdPeriodoCompra() {
		return this.resaltarFK_IdPeriodoCompra;
	}

	public void setResaltarFK_IdPeriodoCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCompra=null;

	public Border getResaltarFK_IdSucursalCompra() {
		return this.resaltarFK_IdSucursalCompra;
	}

	public void setResaltarFK_IdSucursalCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloCompra=null;

	public Border getResaltarFK_IdTipoTransaccionModuloCompra() {
		return this.resaltarFK_IdTipoTransaccionModuloCompra;
	}

	public void setResaltarFK_IdTipoTransaccionModuloCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioCompra=null;

	public Border getResaltarFK_IdUsuarioCompra() {
		return this.resaltarFK_IdUsuarioCompra;
	}

	public void setResaltarFK_IdUsuarioCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioCompra(ParametroGeneralUsuario parametroGeneralUsuario/*CompraBeanSwingJInternalFrame compraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}