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


import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BodegaProductoConstantesFunciones extends BodegaProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BodegaProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BodegaProducto"+BodegaProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BodegaProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BodegaProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BodegaProductoConstantesFunciones.SCHEMA+"_"+BodegaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BodegaProductoConstantesFunciones.SCHEMA+"_"+BodegaProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BodegaProductoConstantesFunciones.SCHEMA+"_"+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BodegaProductoConstantesFunciones.SCHEMA+"_"+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BodegaProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BodegaProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BodegaProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BodegaProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bodega Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Bodega Producto";
	public static final String SCLASSWEBTITULO_LOWER="Bodega Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BodegaProducto";
	public static final String OBJECTNAME="bodegaproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="bodega_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bodegaproducto from "+BodegaProductoConstantesFunciones.SPERSISTENCENAME+" bodegaproducto";
	public static String QUERYSELECTNATIVE="select "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".version_row,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_empresa,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_sucursal,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_bodega,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_producto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_unidad,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_estado_bodega_producto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descripcion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_disponible,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".stock_maximo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".stock_minimo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".iva,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".iva_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descuento,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descuento_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo_promedio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".porcentaje_comision,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ultimo_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".arancel_porcentaje,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice_porcentaje,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".peso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_iva,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_impuesto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_ice,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".esta_activo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_balanza,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_pedida,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_fisica,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_requerido,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_promedio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_ingresos,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_egresos,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_provision,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_proceso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo_calculado,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".dias_produccion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_reposicion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultimo_pedido,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ingreso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_egreso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_compra,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_devolucion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso_debito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso_credito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_resultado_debito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_resultado_credito from "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME;//+" as "+BodegaProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BodegaProductoConstantesFuncionesAdditional bodegaproductoConstantesFuncionesAdditional=null;
	
	public BodegaProductoConstantesFuncionesAdditional getBodegaProductoConstantesFuncionesAdditional() {
		return this.bodegaproductoConstantesFuncionesAdditional;
	}
	
	public void setBodegaProductoConstantesFuncionesAdditional(BodegaProductoConstantesFuncionesAdditional bodegaproductoConstantesFuncionesAdditional) {
		try {
			this.bodegaproductoConstantesFuncionesAdditional=bodegaproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDESTADOBODEGAPRODUCTO= "id_estado_bodega_producto";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String STOCKMAXIMO= "stock_maximo";
    public static final String STOCKMINIMO= "stock_minimo";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String COSTOPROMEDIO= "costo_promedio";
    public static final String PORCENTAJECOMISION= "porcentaje_comision";
    public static final String PRECIO= "precio";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String COSTO= "costo";
    public static final String ARANCELPORCENTAJE= "arancel_porcentaje";
    public static final String ICEPORCENTAJE= "ice_porcentaje";
    public static final String PESO= "peso";
    public static final String CONIVA= "con_iva";
    public static final String CONIMPUESTO= "con_impuesto";
    public static final String CONICE= "con_ice";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String CONBALANZA= "con_balanza";
    public static final String CANTIDADPEDIDA= "cantidad_pedida";
    public static final String CANTIDADFISICA= "cantidad_fisica";
    public static final String CANTIDADREQUERIDO= "cantidad_requerido";
    public static final String PRECIOCOSTO= "precio_costo";
    public static final String PRECIOPROMEDIO= "precio_promedio";
    public static final String TOTALINGRESOS= "total_ingresos";
    public static final String TOTALEGRESOS= "total_egresos";
    public static final String TOTALPROVISION= "total_provision";
    public static final String TOTALPROCESO= "total_proceso";
    public static final String COSTOCALCULADO= "costo_calculado";
    public static final String DIASPRODUCCION= "dias_produccion";
    public static final String PRECIOREPOSICION= "precio_reposicion";
    public static final String FECHAULTIMOPEDIDO= "fecha_ultimo_pedido";
    public static final String FECHAINGRESO= "fecha_ingreso";
    public static final String FECHAEGRESO= "fecha_egreso";
    public static final String FECHAULTIMACOMPRA= "fecha_ultima_compra";
    public static final String FECHAULTIMAVENTA= "fecha_ultima_venta";
    public static final String FECHAULTIMADEVOLUCION= "fecha_ultima_devolucion";
    public static final String IDCUENTACONTABLEINVENTARIO= "id_cuenta_contable_inventario";
    public static final String IDCUENTACONTABLECOSTOVENTA= "id_cuenta_contable_costo_venta";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEPRODUCCION= "id_cuenta_contable_produccion";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLEINGRESODEBITO= "id_cuenta_contable_ingreso_debito";
    public static final String IDCUENTACONTABLEINGRESOCREDITO= "id_cuenta_contable_ingreso_credito";
    public static final String IDCUENTACONTABLERESULTADODEBITO= "id_cuenta_contable_resultado_debito";
    public static final String IDCUENTACONTABLERESULTADOCREDITO= "id_cuenta_contable_resultado_credito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDESTADOBODEGAPRODUCTO= "Estado Bodega Producto";
		public static final String LABEL_IDESTADOBODEGAPRODUCTO_LOWER= "Estado Bodega Producto";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantidad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_STOCKMAXIMO= "Stock Maximo";
		public static final String LABEL_STOCKMAXIMO_LOWER= "Stock Maximo";
    	public static final String LABEL_STOCKMINIMO= "Stock Minimo";
		public static final String LABEL_STOCKMINIMO_LOWER= "Stock Minimo";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ICEVALOR= "Ice Valor";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_COSTOPROMEDIO= "Costo Promedio";
		public static final String LABEL_COSTOPROMEDIO_LOWER= "Costo Promedio";
    	public static final String LABEL_PORCENTAJECOMISION= "Porcentaje Comision";
		public static final String LABEL_PORCENTAJECOMISION_LOWER= "Porcentaje Comision";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_ARANCELPORCENTAJE= "Arancel Porcentaje";
		public static final String LABEL_ARANCELPORCENTAJE_LOWER= "Arancel Porcentaje";
    	public static final String LABEL_ICEPORCENTAJE= "Ice Porcentaje";
		public static final String LABEL_ICEPORCENTAJE_LOWER= "Ice Porcentaje";
    	public static final String LABEL_PESO= "Peso";
		public static final String LABEL_PESO_LOWER= "Peso";
    	public static final String LABEL_CONIVA= "Con Iva";
		public static final String LABEL_CONIVA_LOWER= "Con Iva";
    	public static final String LABEL_CONIMPUESTO= "Con Impuesto";
		public static final String LABEL_CONIMPUESTO_LOWER= "Con Impuesto";
    	public static final String LABEL_CONICE= "Con Ice";
		public static final String LABEL_CONICE_LOWER= "Con Ice";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_CONBALANZA= "Con Balanza";
		public static final String LABEL_CONBALANZA_LOWER= "Con Balanza";
    	public static final String LABEL_CANTIDADPEDIDA= "Cantidad Pedida";
		public static final String LABEL_CANTIDADPEDIDA_LOWER= "Cantidad Pedida";
    	public static final String LABEL_CANTIDADFISICA= "Cantidad Fisica";
		public static final String LABEL_CANTIDADFISICA_LOWER= "Cantidad Fisica";
    	public static final String LABEL_CANTIDADREQUERIDO= "Cantidad Requerido";
		public static final String LABEL_CANTIDADREQUERIDO_LOWER= "Cantidad Requerido";
    	public static final String LABEL_PRECIOCOSTO= "Precio Costo";
		public static final String LABEL_PRECIOCOSTO_LOWER= "Precio Costo";
    	public static final String LABEL_PRECIOPROMEDIO= "Precio Promedio";
		public static final String LABEL_PRECIOPROMEDIO_LOWER= "Precio Promedio";
    	public static final String LABEL_TOTALINGRESOS= "Total Ingresos";
		public static final String LABEL_TOTALINGRESOS_LOWER= "Total Ingresos";
    	public static final String LABEL_TOTALEGRESOS= "Total Egresos";
		public static final String LABEL_TOTALEGRESOS_LOWER= "Total Egresos";
    	public static final String LABEL_TOTALPROVISION= "Total Provision";
		public static final String LABEL_TOTALPROVISION_LOWER= "Total Provision";
    	public static final String LABEL_TOTALPROCESO= "Total Proceso";
		public static final String LABEL_TOTALPROCESO_LOWER= "Total Proceso";
    	public static final String LABEL_COSTOCALCULADO= "Costo Calculado";
		public static final String LABEL_COSTOCALCULADO_LOWER= "Costo Calculado";
    	public static final String LABEL_DIASPRODUCCION= "Dias Produccion";
		public static final String LABEL_DIASPRODUCCION_LOWER= "Dias Produccion";
    	public static final String LABEL_PRECIOREPOSICION= "Precio Reposicion";
		public static final String LABEL_PRECIOREPOSICION_LOWER= "Precio Reposicion";
    	public static final String LABEL_FECHAULTIMOPEDIDO= "Fecha Ultimo Pedido";
		public static final String LABEL_FECHAULTIMOPEDIDO_LOWER= "Fecha Ultimo Pedido";
    	public static final String LABEL_FECHAINGRESO= "Fecha Ingreso";
		public static final String LABEL_FECHAINGRESO_LOWER= "Fecha Ingreso";
    	public static final String LABEL_FECHAEGRESO= "Fecha Egreso";
		public static final String LABEL_FECHAEGRESO_LOWER= "Fecha Egreso";
    	public static final String LABEL_FECHAULTIMACOMPRA= "Fecha Ultima Compra";
		public static final String LABEL_FECHAULTIMACOMPRA_LOWER= "Fecha Ultima Compra";
    	public static final String LABEL_FECHAULTIMAVENTA= "Fecha Ultima Venta";
		public static final String LABEL_FECHAULTIMAVENTA_LOWER= "Fecha Ultima Venta";
    	public static final String LABEL_FECHAULTIMADEVOLUCION= "Fecha Ultima Devolucion";
		public static final String LABEL_FECHAULTIMADEVOLUCION_LOWER= "Fecha Ultima Devolucion";
    	public static final String LABEL_IDCUENTACONTABLEINVENTARIO= "Cuenta C. Inventario";
		public static final String LABEL_IDCUENTACONTABLEINVENTARIO_LOWER= "Cuenta Contable Inventario";
    	public static final String LABEL_IDCUENTACONTABLECOSTOVENTA= "Cuenta C. Costo Venta";
		public static final String LABEL_IDCUENTACONTABLECOSTOVENTA_LOWER= "Cuenta Contable Costo Venta";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "Cuenta C. Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_IDCUENTACONTABLEDESCUENTO= "Cuenta C. Descuento";
		public static final String LABEL_IDCUENTACONTABLEDESCUENTO_LOWER= "Cuenta Contable Descuento";
    	public static final String LABEL_IDCUENTACONTABLEPRODUCCION= "Cuenta C. Produccion";
		public static final String LABEL_IDCUENTACONTABLEPRODUCCION_LOWER= "Cuenta Contable Produccion";
    	public static final String LABEL_IDCUENTACONTABLEDEVOLUCION= "Cuenta C. Devolucion";
		public static final String LABEL_IDCUENTACONTABLEDEVOLUCION_LOWER= "Cuenta Contable Devolucion";
    	public static final String LABEL_IDCUENTACONTABLEINGRESODEBITO= "Cuenta C. Ingreso Debito";
		public static final String LABEL_IDCUENTACONTABLEINGRESODEBITO_LOWER= "Cuenta Contable Ingreso Debito";
    	public static final String LABEL_IDCUENTACONTABLEINGRESOCREDITO= "Cuenta C. Ingreso Credito";
		public static final String LABEL_IDCUENTACONTABLEINGRESOCREDITO_LOWER= "Cuenta Contable Ingreso Credito";
    	public static final String LABEL_IDCUENTACONTABLERESULTADODEBITO= "Cuenta C. Resultado Debito";
		public static final String LABEL_IDCUENTACONTABLERESULTADODEBITO_LOWER= "Cuenta Contable Resultado Debito";
    	public static final String LABEL_IDCUENTACONTABLERESULTADOCREDITO= "Cuenta C. Resultado Credito";
		public static final String LABEL_IDCUENTACONTABLERESULTADOCREDITO_LOWER= "Cuenta Contable Resultado Credito";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getBodegaProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDUNIDAD)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDESTADOBODEGAPRODUCTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.STOCKMAXIMO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_STOCKMAXIMO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.STOCKMINIMO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_STOCKMINIMO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IVA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IVAVALOR)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.DESCUENTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ICE)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ICEVALOR)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.COSTOPROMEDIO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PORCENTAJECOMISION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PRECIO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.COSTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ARANCELPORCENTAJE)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ICEPORCENTAJE)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PESO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PESO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CONIVA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CONIVA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CONIMPUESTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CONIMPUESTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CONICE)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CONICE;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.ESTAACTIVO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CONBALANZA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CONBALANZA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CANTIDADPEDIDA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CANTIDADPEDIDA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CANTIDADFISICA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CANTIDADFISICA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.CANTIDADREQUERIDO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_CANTIDADREQUERIDO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PRECIOCOSTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PRECIOPROMEDIO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.TOTALINGRESOS)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_TOTALINGRESOS;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.TOTALEGRESOS)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_TOTALEGRESOS;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.TOTALPROVISION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.TOTALPROCESO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.COSTOCALCULADO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.DIASPRODUCCION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.PRECIOREPOSICION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAULTIMOPEDIDO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAINGRESO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAINGRESO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAEGRESO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAEGRESO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAULTIMACOMPRA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAULTIMAVENTA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAULTIMAVENTA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESODEBITO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESOCREDITO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADODEBITO;}
		if(sNombreColumna.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO)) {sLabelColumna=BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADOCREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_ivaDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodegaproducto.getcon_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_ivaHtmlDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodegaproducto.getId(),bodegaproducto.getcon_iva());

		return sDescripcion;
	}	
		
	public static String getcon_impuestoDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodegaproducto.getcon_impuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_impuestoHtmlDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodegaproducto.getId(),bodegaproducto.getcon_impuesto());

		return sDescripcion;
	}	
		
	public static String getcon_iceDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodegaproducto.getcon_ice()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_iceHtmlDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodegaproducto.getId(),bodegaproducto.getcon_ice());

		return sDescripcion;
	}	
		
	public static String getesta_activoDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodegaproducto.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodegaproducto.getId(),bodegaproducto.getesta_activo());

		return sDescripcion;
	}	
		
	public static String getcon_balanzaDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!bodegaproducto.getcon_balanza()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_balanzaHtmlDescripcion(BodegaProducto bodegaproducto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(bodegaproducto.getId(),bodegaproducto.getcon_balanza());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBodegaProductoDescripcion(BodegaProducto bodegaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bodegaproducto !=null/* && bodegaproducto.getId()!=0*/) {
			if(bodegaproducto.getId()!=null) {
				sDescripcion=bodegaproducto.getId().toString();
			}//bodegaproductobodegaproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBodegaProductoDescripcionDetallado(BodegaProducto bodegaproducto) {
		String sDescripcion="";
			
		sDescripcion+=BodegaProductoConstantesFunciones.ID+"=";
		sDescripcion+=bodegaproducto.getId().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bodegaproducto.getVersionRow().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bodegaproducto.getid_empresa().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=bodegaproducto.getid_sucursal().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=bodegaproducto.getid_bodega().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=bodegaproducto.getid_producto().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=bodegaproducto.getid_unidad().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=bodegaproducto.getid_centro_costo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO+"=";
		sDescripcion+=bodegaproducto.getid_estado_bodega_producto().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=bodegaproducto.getdescripcion()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=bodegaproducto.getcantidad_disponible().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.STOCKMAXIMO+"=";
		sDescripcion+=bodegaproducto.getstock_maximo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.STOCKMINIMO+"=";
		sDescripcion+=bodegaproducto.getstock_minimo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IVA+"=";
		sDescripcion+=bodegaproducto.getiva().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=bodegaproducto.getiva_valor().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=bodegaproducto.getdescuento().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=bodegaproducto.getdescuento_valor().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ICE+"=";
		sDescripcion+=bodegaproducto.getice().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=bodegaproducto.getice_valor().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.COSTOPROMEDIO+"=";
		sDescripcion+=bodegaproducto.getcosto_promedio().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PORCENTAJECOMISION+"=";
		sDescripcion+=bodegaproducto.getporcentaje_comision().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PRECIO+"=";
		sDescripcion+=bodegaproducto.getprecio().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=bodegaproducto.getultimo_costo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.COSTO+"=";
		sDescripcion+=bodegaproducto.getcosto().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ARANCELPORCENTAJE+"=";
		sDescripcion+=bodegaproducto.getarancel_porcentaje().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ICEPORCENTAJE+"=";
		sDescripcion+=bodegaproducto.getice_porcentaje().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PESO+"=";
		sDescripcion+=bodegaproducto.getpeso().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CONIVA+"=";
		sDescripcion+=bodegaproducto.getcon_iva().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CONIMPUESTO+"=";
		sDescripcion+=bodegaproducto.getcon_impuesto().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CONICE+"=";
		sDescripcion+=bodegaproducto.getcon_ice().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=bodegaproducto.getesta_activo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CONBALANZA+"=";
		sDescripcion+=bodegaproducto.getcon_balanza().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CANTIDADPEDIDA+"=";
		sDescripcion+=bodegaproducto.getcantidad_pedida().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CANTIDADFISICA+"=";
		sDescripcion+=bodegaproducto.getcantidad_fisica().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.CANTIDADREQUERIDO+"=";
		sDescripcion+=bodegaproducto.getcantidad_requerido().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PRECIOCOSTO+"=";
		sDescripcion+=bodegaproducto.getprecio_costo().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PRECIOPROMEDIO+"=";
		sDescripcion+=bodegaproducto.getprecio_promedio().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.TOTALINGRESOS+"=";
		sDescripcion+=bodegaproducto.gettotal_ingresos().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.TOTALEGRESOS+"=";
		sDescripcion+=bodegaproducto.gettotal_egresos().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.TOTALPROVISION+"=";
		sDescripcion+=bodegaproducto.gettotal_provision().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.TOTALPROCESO+"=";
		sDescripcion+=bodegaproducto.gettotal_proceso().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.COSTOCALCULADO+"=";
		sDescripcion+=bodegaproducto.getcosto_calculado().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.DIASPRODUCCION+"=";
		sDescripcion+=bodegaproducto.getdias_produccion().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.PRECIOREPOSICION+"=";
		sDescripcion+=bodegaproducto.getprecio_reposicion().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO+"=";
		sDescripcion+=bodegaproducto.getfecha_ultimo_pedido().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAINGRESO+"=";
		sDescripcion+=bodegaproducto.getfecha_ingreso().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAEGRESO+"=";
		sDescripcion+=bodegaproducto.getfecha_egreso().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA+"=";
		sDescripcion+=bodegaproducto.getfecha_ultima_compra().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAULTIMAVENTA+"=";
		sDescripcion+=bodegaproducto.getfecha_ultima_venta().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION+"=";
		sDescripcion+=bodegaproducto.getfecha_ultima_devolucion().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_inventario().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_costo_venta().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_produccion().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_ingreso_debito().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_ingreso_credito().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_resultado_debito().toString()+",";
		sDescripcion+=BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO+"=";
		sDescripcion+=bodegaproducto.getid_cuenta_contable_resultado_credito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBodegaProductoDescripcion(BodegaProducto bodegaproducto,String sValor) throws Exception {			
		if(bodegaproducto !=null) {
			//bodegaproductobodegaproducto.getId().toString();
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
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

	public static String getEstadoBodegaProductoDescripcion(EstadoBodegaProducto estadobodegaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadobodegaproducto!=null/*&&estadobodegaproducto.getId()>0*/) {
			sDescripcion=EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoDescripcion(estadobodegaproducto);
		}

		return sDescripcion;
	}

	public static String getCuentaContableInventarioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescuentoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableProduccionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDevolucionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngresoDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngresoCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableResultadoDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableResultadoCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaProducto")) {
			sNombreIndice="Tipo=  Por Estado Bodega Producto";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Costo Venta";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDescuento")) {
			sNombreIndice="Tipo=  Por Cuenta C. Descuento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDevolucion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Devolucion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngresoCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngresoDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso Debito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableInventario")) {
			sNombreIndice="Tipo=  Por Cuenta C. Inventario";
		} else if(sNombreIndice.equals("FK_IdCuentaContableProduccion")) {
			sNombreIndice="Tipo=  Por Cuenta C. Produccion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableResultadoCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Resultado Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableResultadoDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Resultado Debito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por Cuenta C. Venta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
		} else if(sNombreIndice.equals("PorIdBodegaPorIdProductoPorIdUnidad")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Unidad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaProducto(Long id_estado_bodega_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_bodega_producto!=null) {sDetalleIndice+=" Codigo Unico De Estado Bodega Producto="+id_estado_bodega_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoVenta(Long id_cuenta_contable_costo_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Costo Venta="+id_cuenta_contable_costo_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDescuento(Long id_cuenta_contable_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_descuento!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Descuento="+id_cuenta_contable_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDevolucion(Long id_cuenta_contable_devolucion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_devolucion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Devolucion="+id_cuenta_contable_devolucion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngresoCredito(Long id_cuenta_contable_ingreso_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso Credito="+id_cuenta_contable_ingreso_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngresoDebito(Long id_cuenta_contable_ingreso_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso Debito="+id_cuenta_contable_ingreso_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableInventario(Long id_cuenta_contable_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_inventario!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Inventario="+id_cuenta_contable_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableProduccion(Long id_cuenta_contable_produccion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_produccion!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Produccion="+id_cuenta_contable_produccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableResultadoCredito(Long id_cuenta_contable_resultado_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_resultado_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Resultado Credito="+id_cuenta_contable_resultado_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableResultadoDebito(Long id_cuenta_contable_resultado_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_resultado_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Resultado Debito="+id_cuenta_contable_resultado_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Venta="+id_cuenta_contable_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdBodegaPorIdProductoPorIdUnidad(Long id_bodega,Long id_producto,Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBodegaProducto(BodegaProducto bodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bodegaproducto.setdescripcion(bodegaproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosBodegaProductos(List<BodegaProducto> bodegaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BodegaProducto bodegaproducto: bodegaproductos) {
			bodegaproducto.setdescripcion(bodegaproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodegaProducto(BodegaProducto bodegaproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bodegaproducto.getConCambioAuxiliar()) {
			bodegaproducto.setIsDeleted(bodegaproducto.getIsDeletedAuxiliar());	
			bodegaproducto.setIsNew(bodegaproducto.getIsNewAuxiliar());	
			bodegaproducto.setIsChanged(bodegaproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bodegaproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bodegaproducto.setIsDeletedAuxiliar(false);	
			bodegaproducto.setIsNewAuxiliar(false);	
			bodegaproducto.setIsChangedAuxiliar(false);
			
			bodegaproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodegaProductos(List<BodegaProducto> bodegaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BodegaProducto bodegaproducto : bodegaproductos) {
			if(conAsignarBase && bodegaproducto.getConCambioAuxiliar()) {
				bodegaproducto.setIsDeleted(bodegaproducto.getIsDeletedAuxiliar());	
				bodegaproducto.setIsNew(bodegaproducto.getIsNewAuxiliar());	
				bodegaproducto.setIsChanged(bodegaproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bodegaproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bodegaproducto.setIsDeletedAuxiliar(false);	
				bodegaproducto.setIsNewAuxiliar(false);	
				bodegaproducto.setIsChangedAuxiliar(false);
				
				bodegaproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBodegaProducto(BodegaProducto bodegaproducto,Boolean conEnteros) throws Exception  {
		bodegaproducto.setiva(0.0);
		bodegaproducto.setiva_valor(0.0);
		bodegaproducto.setdescuento(0.0);
		bodegaproducto.setdescuento_valor(0.0);
		bodegaproducto.setice(0.0);
		bodegaproducto.setice_valor(0.0);
		bodegaproducto.setcosto_promedio(0.0);
		bodegaproducto.setporcentaje_comision(0.0);
		bodegaproducto.setprecio(0.0);
		bodegaproducto.setultimo_costo(0.0);
		bodegaproducto.setcosto(0.0);
		bodegaproducto.setarancel_porcentaje(0.0);
		bodegaproducto.setice_porcentaje(0.0);
		bodegaproducto.setpeso(0.0);
		bodegaproducto.setprecio_costo(0.0);
		bodegaproducto.setprecio_promedio(0.0);
		bodegaproducto.settotal_provision(0.0);
		bodegaproducto.settotal_proceso(0.0);
		bodegaproducto.setcosto_calculado(0.0);
		bodegaproducto.setdias_produccion(0.0);
		bodegaproducto.setprecio_reposicion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			bodegaproducto.setcantidad_disponible(0);
			bodegaproducto.setstock_maximo(0);
			bodegaproducto.setstock_minimo(0);
			bodegaproducto.setcantidad_pedida(0);
			bodegaproducto.setcantidad_fisica(0);
			bodegaproducto.setcantidad_requerido(0);
			bodegaproducto.settotal_ingresos(0);
			bodegaproducto.settotal_egresos(0);
		}
	}		
	
	public static void InicializarValoresBodegaProductos(List<BodegaProducto> bodegaproductos,Boolean conEnteros) throws Exception  {
		
		for(BodegaProducto bodegaproducto: bodegaproductos) {
			bodegaproducto.setiva(0.0);
			bodegaproducto.setiva_valor(0.0);
			bodegaproducto.setdescuento(0.0);
			bodegaproducto.setdescuento_valor(0.0);
			bodegaproducto.setice(0.0);
			bodegaproducto.setice_valor(0.0);
			bodegaproducto.setcosto_promedio(0.0);
			bodegaproducto.setporcentaje_comision(0.0);
			bodegaproducto.setprecio(0.0);
			bodegaproducto.setultimo_costo(0.0);
			bodegaproducto.setcosto(0.0);
			bodegaproducto.setarancel_porcentaje(0.0);
			bodegaproducto.setice_porcentaje(0.0);
			bodegaproducto.setpeso(0.0);
			bodegaproducto.setprecio_costo(0.0);
			bodegaproducto.setprecio_promedio(0.0);
			bodegaproducto.settotal_provision(0.0);
			bodegaproducto.settotal_proceso(0.0);
			bodegaproducto.setcosto_calculado(0.0);
			bodegaproducto.setdias_produccion(0.0);
			bodegaproducto.setprecio_reposicion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				bodegaproducto.setcantidad_disponible(0);
				bodegaproducto.setstock_maximo(0);
				bodegaproducto.setstock_minimo(0);
				bodegaproducto.setcantidad_pedida(0);
				bodegaproducto.setcantidad_fisica(0);
				bodegaproducto.setcantidad_requerido(0);
				bodegaproducto.settotal_ingresos(0);
				bodegaproducto.settotal_egresos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaBodegaProducto(List<BodegaProducto> bodegaproductos,BodegaProducto bodegaproductoAux) throws Exception  {
		BodegaProductoConstantesFunciones.InicializarValoresBodegaProducto(bodegaproductoAux,true);
		
		for(BodegaProducto bodegaproducto: bodegaproductos) {
			if(bodegaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bodegaproductoAux.setcantidad_disponible(bodegaproductoAux.getcantidad_disponible()+bodegaproducto.getcantidad_disponible());			
			bodegaproductoAux.setstock_maximo(bodegaproductoAux.getstock_maximo()+bodegaproducto.getstock_maximo());			
			bodegaproductoAux.setstock_minimo(bodegaproductoAux.getstock_minimo()+bodegaproducto.getstock_minimo());			
			bodegaproductoAux.setiva(bodegaproductoAux.getiva()+bodegaproducto.getiva());			
			bodegaproductoAux.setiva_valor(bodegaproductoAux.getiva_valor()+bodegaproducto.getiva_valor());			
			bodegaproductoAux.setdescuento(bodegaproductoAux.getdescuento()+bodegaproducto.getdescuento());			
			bodegaproductoAux.setdescuento_valor(bodegaproductoAux.getdescuento_valor()+bodegaproducto.getdescuento_valor());			
			bodegaproductoAux.setice(bodegaproductoAux.getice()+bodegaproducto.getice());			
			bodegaproductoAux.setice_valor(bodegaproductoAux.getice_valor()+bodegaproducto.getice_valor());			
			bodegaproductoAux.setcosto_promedio(bodegaproductoAux.getcosto_promedio()+bodegaproducto.getcosto_promedio());			
			bodegaproductoAux.setporcentaje_comision(bodegaproductoAux.getporcentaje_comision()+bodegaproducto.getporcentaje_comision());			
			bodegaproductoAux.setprecio(bodegaproductoAux.getprecio()+bodegaproducto.getprecio());			
			bodegaproductoAux.setultimo_costo(bodegaproductoAux.getultimo_costo()+bodegaproducto.getultimo_costo());			
			bodegaproductoAux.setcosto(bodegaproductoAux.getcosto()+bodegaproducto.getcosto());			
			bodegaproductoAux.setarancel_porcentaje(bodegaproductoAux.getarancel_porcentaje()+bodegaproducto.getarancel_porcentaje());			
			bodegaproductoAux.setice_porcentaje(bodegaproductoAux.getice_porcentaje()+bodegaproducto.getice_porcentaje());			
			bodegaproductoAux.setpeso(bodegaproductoAux.getpeso()+bodegaproducto.getpeso());			
			bodegaproductoAux.setcantidad_pedida(bodegaproductoAux.getcantidad_pedida()+bodegaproducto.getcantidad_pedida());			
			bodegaproductoAux.setcantidad_fisica(bodegaproductoAux.getcantidad_fisica()+bodegaproducto.getcantidad_fisica());			
			bodegaproductoAux.setcantidad_requerido(bodegaproductoAux.getcantidad_requerido()+bodegaproducto.getcantidad_requerido());			
			bodegaproductoAux.setprecio_costo(bodegaproductoAux.getprecio_costo()+bodegaproducto.getprecio_costo());			
			bodegaproductoAux.setprecio_promedio(bodegaproductoAux.getprecio_promedio()+bodegaproducto.getprecio_promedio());			
			bodegaproductoAux.settotal_ingresos(bodegaproductoAux.gettotal_ingresos()+bodegaproducto.gettotal_ingresos());			
			bodegaproductoAux.settotal_egresos(bodegaproductoAux.gettotal_egresos()+bodegaproducto.gettotal_egresos());			
			bodegaproductoAux.settotal_provision(bodegaproductoAux.gettotal_provision()+bodegaproducto.gettotal_provision());			
			bodegaproductoAux.settotal_proceso(bodegaproductoAux.gettotal_proceso()+bodegaproducto.gettotal_proceso());			
			bodegaproductoAux.setcosto_calculado(bodegaproductoAux.getcosto_calculado()+bodegaproducto.getcosto_calculado());			
			bodegaproductoAux.setdias_produccion(bodegaproductoAux.getdias_produccion()+bodegaproducto.getdias_produccion());			
			bodegaproductoAux.setprecio_reposicion(bodegaproductoAux.getprecio_reposicion()+bodegaproducto.getprecio_reposicion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BodegaProductoConstantesFunciones.getArrayColumnasGlobalesBodegaProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BodegaProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BodegaProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BodegaProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BodegaProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BodegaProducto> bodegaproductos,BodegaProducto bodegaproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BodegaProducto bodegaproductoAux: bodegaproductos) {
			if(bodegaproductoAux!=null && bodegaproducto!=null) {
				if((bodegaproductoAux.getId()==null && bodegaproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bodegaproductoAux.getId()!=null && bodegaproducto.getId()!=null){
					if(bodegaproductoAux.getId().equals(bodegaproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBodegaProducto(List<BodegaProducto> bodegaproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double costo_promedioTotal=0.0;
		Double porcentaje_comisionTotal=0.0;
		Double precioTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double costoTotal=0.0;
		Double arancel_porcentajeTotal=0.0;
		Double ice_porcentajeTotal=0.0;
		Double pesoTotal=0.0;
		Double precio_costoTotal=0.0;
		Double precio_promedioTotal=0.0;
		Double total_provisionTotal=0.0;
		Double total_procesoTotal=0.0;
		Double costo_calculadoTotal=0.0;
		Double dias_produccionTotal=0.0;
		Double precio_reposicionTotal=0.0;
	
		for(BodegaProducto bodegaproducto: bodegaproductos) {			
			if(bodegaproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=bodegaproducto.getiva();
			iva_valorTotal+=bodegaproducto.getiva_valor();
			descuentoTotal+=bodegaproducto.getdescuento();
			descuento_valorTotal+=bodegaproducto.getdescuento_valor();
			iceTotal+=bodegaproducto.getice();
			ice_valorTotal+=bodegaproducto.getice_valor();
			costo_promedioTotal+=bodegaproducto.getcosto_promedio();
			porcentaje_comisionTotal+=bodegaproducto.getporcentaje_comision();
			precioTotal+=bodegaproducto.getprecio();
			ultimo_costoTotal+=bodegaproducto.getultimo_costo();
			costoTotal+=bodegaproducto.getcosto();
			arancel_porcentajeTotal+=bodegaproducto.getarancel_porcentaje();
			ice_porcentajeTotal+=bodegaproducto.getice_porcentaje();
			pesoTotal+=bodegaproducto.getpeso();
			precio_costoTotal+=bodegaproducto.getprecio_costo();
			precio_promedioTotal+=bodegaproducto.getprecio_promedio();
			total_provisionTotal+=bodegaproducto.gettotal_provision();
			total_procesoTotal+=bodegaproducto.gettotal_proceso();
			costo_calculadoTotal+=bodegaproducto.getcosto_calculado();
			dias_produccionTotal+=bodegaproducto.getdias_produccion();
			precio_reposicionTotal+=bodegaproducto.getprecio_reposicion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.COSTOPROMEDIO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO);
		datoGeneral.setdValorDouble(costo_promedioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PORCENTAJECOMISION);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION);
		datoGeneral.setdValorDouble(porcentaje_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.ARANCELPORCENTAJE);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
		datoGeneral.setdValorDouble(arancel_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.ICEPORCENTAJE);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE);
		datoGeneral.setdValorDouble(ice_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PESO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PESO);
		datoGeneral.setdValorDouble(pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PRECIOCOSTO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO);
		datoGeneral.setdValorDouble(precio_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PRECIOPROMEDIO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO);
		datoGeneral.setdValorDouble(precio_promedioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.TOTALPROVISION);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION);
		datoGeneral.setdValorDouble(total_provisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.TOTALPROCESO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO);
		datoGeneral.setdValorDouble(total_procesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.COSTOCALCULADO);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO);
		datoGeneral.setdValorDouble(costo_calculadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.DIASPRODUCCION);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION);
		datoGeneral.setdValorDouble(dias_produccionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BodegaProductoConstantesFunciones.PRECIOREPOSICION);
		datoGeneral.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION);
		datoGeneral.setdValorDouble(precio_reposicionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBodegaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ID, BodegaProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_VERSIONROW, BodegaProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDEMPRESA, BodegaProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDSUCURSAL, BodegaProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDBODEGA, BodegaProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDPRODUCTO, BodegaProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDUNIDAD, BodegaProductoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCENTROCOSTO, BodegaProductoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDESTADOBODEGAPRODUCTO, BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_DESCRIPCION, BodegaProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CANTIDADDISPONIBLE, BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_STOCKMAXIMO, BodegaProductoConstantesFunciones.STOCKMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_STOCKMINIMO, BodegaProductoConstantesFunciones.STOCKMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IVA, BodegaProductoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IVAVALOR, BodegaProductoConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_DESCUENTO, BodegaProductoConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR, BodegaProductoConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ICE, BodegaProductoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ICEVALOR, BodegaProductoConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO, BodegaProductoConstantesFunciones.COSTOPROMEDIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION, BodegaProductoConstantesFunciones.PORCENTAJECOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PRECIO, BodegaProductoConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO, BodegaProductoConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_COSTO, BodegaProductoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE, BodegaProductoConstantesFunciones.ARANCELPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE, BodegaProductoConstantesFunciones.ICEPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PESO, BodegaProductoConstantesFunciones.PESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CONIVA, BodegaProductoConstantesFunciones.CONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CONIMPUESTO, BodegaProductoConstantesFunciones.CONIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CONICE, BodegaProductoConstantesFunciones.CONICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_ESTAACTIVO, BodegaProductoConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CONBALANZA, BodegaProductoConstantesFunciones.CONBALANZA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CANTIDADPEDIDA, BodegaProductoConstantesFunciones.CANTIDADPEDIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CANTIDADFISICA, BodegaProductoConstantesFunciones.CANTIDADFISICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_CANTIDADREQUERIDO, BodegaProductoConstantesFunciones.CANTIDADREQUERIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO, BodegaProductoConstantesFunciones.PRECIOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO, BodegaProductoConstantesFunciones.PRECIOPROMEDIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_TOTALINGRESOS, BodegaProductoConstantesFunciones.TOTALINGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_TOTALEGRESOS, BodegaProductoConstantesFunciones.TOTALEGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION, BodegaProductoConstantesFunciones.TOTALPROVISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO, BodegaProductoConstantesFunciones.TOTALPROCESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO, BodegaProductoConstantesFunciones.COSTOCALCULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION, BodegaProductoConstantesFunciones.DIASPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION, BodegaProductoConstantesFunciones.PRECIOREPOSICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAULTIMOPEDIDO, BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAINGRESO, BodegaProductoConstantesFunciones.FECHAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAEGRESO, BodegaProductoConstantesFunciones.FECHAEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAULTIMACOMPRA, BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAULTIMAVENTA, BodegaProductoConstantesFunciones.FECHAULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION, BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO, BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA, BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION, BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESODEBITO, BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESOCREDITO, BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADODEBITO, BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADOCREDITO, BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBodegaProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.STOCKMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.STOCKMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.COSTOPROMEDIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PORCENTAJECOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ARANCELPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ICEPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CONIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CONICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CONBALANZA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CANTIDADPEDIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CANTIDADFISICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.CANTIDADREQUERIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PRECIOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PRECIOPROMEDIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.TOTALINGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.TOTALEGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.TOTALPROVISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.TOTALPROCESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.COSTOCALCULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.DIASPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.PRECIOREPOSICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaProducto() throws Exception  {
		return BodegaProductoConstantesFunciones.getTiposSeleccionarBodegaProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaProducto(Boolean conFk) throws Exception  {
		return BodegaProductoConstantesFunciones.getTiposSeleccionarBodegaProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDESTADOBODEGAPRODUCTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDESTADOBODEGAPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_STOCKMAXIMO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_STOCKMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_STOCKMINIMO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_STOCKMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PESO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CONIVA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CONIMPUESTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CONIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CONICE);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CONICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CONBALANZA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CONBALANZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CANTIDADPEDIDA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CANTIDADPEDIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CANTIDADFISICA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CANTIDADFISICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_CANTIDADREQUERIDO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_CANTIDADREQUERIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_TOTALINGRESOS);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALINGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_TOTALEGRESOS);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALEGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMOPEDIDO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAINGRESO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAEGRESO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMAVENTA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESODEBITO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESODEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESOCREDITO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESOCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADODEBITO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADODEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADOCREDITO);
			reporte.setsDescripcion(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADOCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBodegaProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBodegaProducto(BodegaProducto bodegaproductoAux) throws Exception {
		
			bodegaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegaproductoAux.getEmpresa()));
			bodegaproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bodegaproductoAux.getSucursal()));
			bodegaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(bodegaproductoAux.getBodega()));
			bodegaproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(bodegaproductoAux.getProducto()));
			bodegaproductoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(bodegaproductoAux.getUnidad()));
			bodegaproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(bodegaproductoAux.getCentroCosto()));
			bodegaproductoAux.setestadobodegaproducto_descripcion(EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoDescripcion(bodegaproductoAux.getEstadoBodegaProducto()));
			bodegaproductoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableInventario()));
			bodegaproductoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableCostoVenta()));
			bodegaproductoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableVenta()));
			bodegaproductoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableDescuento()));
			bodegaproductoAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableProduccion()));
			bodegaproductoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableDevolucion()));
			bodegaproductoAux.setcuentacontableingresodebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableIngresoDebito()));
			bodegaproductoAux.setcuentacontableingresocredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableIngresoCredito()));
			bodegaproductoAux.setcuentacontableresultadodebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableResultadoDebito()));
			bodegaproductoAux.setcuentacontableresultadocredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableResultadoCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBodegaProducto(List<BodegaProducto> bodegaproductosTemp) throws Exception {
		for(BodegaProducto bodegaproductoAux:bodegaproductosTemp) {
			
			bodegaproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegaproductoAux.getEmpresa()));
			bodegaproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bodegaproductoAux.getSucursal()));
			bodegaproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(bodegaproductoAux.getBodega()));
			bodegaproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(bodegaproductoAux.getProducto()));
			bodegaproductoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(bodegaproductoAux.getUnidad()));
			bodegaproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(bodegaproductoAux.getCentroCosto()));
			bodegaproductoAux.setestadobodegaproducto_descripcion(EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoDescripcion(bodegaproductoAux.getEstadoBodegaProducto()));
			bodegaproductoAux.setcuentacontableinventario_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableInventario()));
			bodegaproductoAux.setcuentacontablecostoventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableCostoVenta()));
			bodegaproductoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableVenta()));
			bodegaproductoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableDescuento()));
			bodegaproductoAux.setcuentacontableproduccion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableProduccion()));
			bodegaproductoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableDevolucion()));
			bodegaproductoAux.setcuentacontableingresodebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableIngresoDebito()));
			bodegaproductoAux.setcuentacontableingresocredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableIngresoCredito()));
			bodegaproductoAux.setcuentacontableresultadodebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableResultadoDebito()));
			bodegaproductoAux.setcuentacontableresultadocredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(bodegaproductoAux.getCuentaContableResultadoCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(EstadoBodegaProducto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoBodegaProducto.class)) {
						classes.add(new Classe(EstadoBodegaProducto.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(EstadoBodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoBodegaProducto.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(EstadoBodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoBodegaProducto.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaProductoConstantesFunciones.getClassesRelationshipsOfBodegaProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaProductoConstantesFunciones.getClassesRelationshipsFromStringsOfBodegaProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodegaProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BodegaProducto bodegaproducto,List<BodegaProducto> bodegaproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BodegaProducto bodegaproductoEncontrado=null;
			
			for(BodegaProducto bodegaproductoLocal:bodegaproductos) {
				if(bodegaproductoLocal.getId().equals(bodegaproducto.getId())) {
					bodegaproductoEncontrado=bodegaproductoLocal;
					
					bodegaproductoLocal.setIsChanged(bodegaproducto.getIsChanged());
					bodegaproductoLocal.setIsNew(bodegaproducto.getIsNew());
					bodegaproductoLocal.setIsDeleted(bodegaproducto.getIsDeleted());
					
					bodegaproductoLocal.setGeneralEntityOriginal(bodegaproducto.getGeneralEntityOriginal());
					
					bodegaproductoLocal.setId(bodegaproducto.getId());	
					bodegaproductoLocal.setVersionRow(bodegaproducto.getVersionRow());	
					bodegaproductoLocal.setid_empresa(bodegaproducto.getid_empresa());	
					bodegaproductoLocal.setid_sucursal(bodegaproducto.getid_sucursal());	
					bodegaproductoLocal.setid_bodega(bodegaproducto.getid_bodega());	
					bodegaproductoLocal.setid_producto(bodegaproducto.getid_producto());	
					bodegaproductoLocal.setid_unidad(bodegaproducto.getid_unidad());	
					bodegaproductoLocal.setid_centro_costo(bodegaproducto.getid_centro_costo());	
					bodegaproductoLocal.setid_estado_bodega_producto(bodegaproducto.getid_estado_bodega_producto());	
					bodegaproductoLocal.setdescripcion(bodegaproducto.getdescripcion());	
					bodegaproductoLocal.setcantidad_disponible(bodegaproducto.getcantidad_disponible());	
					bodegaproductoLocal.setstock_maximo(bodegaproducto.getstock_maximo());	
					bodegaproductoLocal.setstock_minimo(bodegaproducto.getstock_minimo());	
					bodegaproductoLocal.setiva(bodegaproducto.getiva());	
					bodegaproductoLocal.setiva_valor(bodegaproducto.getiva_valor());	
					bodegaproductoLocal.setdescuento(bodegaproducto.getdescuento());	
					bodegaproductoLocal.setdescuento_valor(bodegaproducto.getdescuento_valor());	
					bodegaproductoLocal.setice(bodegaproducto.getice());	
					bodegaproductoLocal.setice_valor(bodegaproducto.getice_valor());	
					bodegaproductoLocal.setcosto_promedio(bodegaproducto.getcosto_promedio());	
					bodegaproductoLocal.setporcentaje_comision(bodegaproducto.getporcentaje_comision());	
					bodegaproductoLocal.setprecio(bodegaproducto.getprecio());	
					bodegaproductoLocal.setultimo_costo(bodegaproducto.getultimo_costo());	
					bodegaproductoLocal.setcosto(bodegaproducto.getcosto());	
					bodegaproductoLocal.setarancel_porcentaje(bodegaproducto.getarancel_porcentaje());	
					bodegaproductoLocal.setice_porcentaje(bodegaproducto.getice_porcentaje());	
					bodegaproductoLocal.setpeso(bodegaproducto.getpeso());	
					bodegaproductoLocal.setcon_iva(bodegaproducto.getcon_iva());	
					bodegaproductoLocal.setcon_impuesto(bodegaproducto.getcon_impuesto());	
					bodegaproductoLocal.setcon_ice(bodegaproducto.getcon_ice());	
					bodegaproductoLocal.setesta_activo(bodegaproducto.getesta_activo());	
					bodegaproductoLocal.setcon_balanza(bodegaproducto.getcon_balanza());	
					bodegaproductoLocal.setcantidad_pedida(bodegaproducto.getcantidad_pedida());	
					bodegaproductoLocal.setcantidad_fisica(bodegaproducto.getcantidad_fisica());	
					bodegaproductoLocal.setcantidad_requerido(bodegaproducto.getcantidad_requerido());	
					bodegaproductoLocal.setprecio_costo(bodegaproducto.getprecio_costo());	
					bodegaproductoLocal.setprecio_promedio(bodegaproducto.getprecio_promedio());	
					bodegaproductoLocal.settotal_ingresos(bodegaproducto.gettotal_ingresos());	
					bodegaproductoLocal.settotal_egresos(bodegaproducto.gettotal_egresos());	
					bodegaproductoLocal.settotal_provision(bodegaproducto.gettotal_provision());	
					bodegaproductoLocal.settotal_proceso(bodegaproducto.gettotal_proceso());	
					bodegaproductoLocal.setcosto_calculado(bodegaproducto.getcosto_calculado());	
					bodegaproductoLocal.setdias_produccion(bodegaproducto.getdias_produccion());	
					bodegaproductoLocal.setprecio_reposicion(bodegaproducto.getprecio_reposicion());	
					bodegaproductoLocal.setfecha_ultimo_pedido(bodegaproducto.getfecha_ultimo_pedido());	
					bodegaproductoLocal.setfecha_ingreso(bodegaproducto.getfecha_ingreso());	
					bodegaproductoLocal.setfecha_egreso(bodegaproducto.getfecha_egreso());	
					bodegaproductoLocal.setfecha_ultima_compra(bodegaproducto.getfecha_ultima_compra());	
					bodegaproductoLocal.setfecha_ultima_venta(bodegaproducto.getfecha_ultima_venta());	
					bodegaproductoLocal.setfecha_ultima_devolucion(bodegaproducto.getfecha_ultima_devolucion());	
					bodegaproductoLocal.setid_cuenta_contable_inventario(bodegaproducto.getid_cuenta_contable_inventario());	
					bodegaproductoLocal.setid_cuenta_contable_costo_venta(bodegaproducto.getid_cuenta_contable_costo_venta());	
					bodegaproductoLocal.setid_cuenta_contable_venta(bodegaproducto.getid_cuenta_contable_venta());	
					bodegaproductoLocal.setid_cuenta_contable_descuento(bodegaproducto.getid_cuenta_contable_descuento());	
					bodegaproductoLocal.setid_cuenta_contable_produccion(bodegaproducto.getid_cuenta_contable_produccion());	
					bodegaproductoLocal.setid_cuenta_contable_devolucion(bodegaproducto.getid_cuenta_contable_devolucion());	
					bodegaproductoLocal.setid_cuenta_contable_ingreso_debito(bodegaproducto.getid_cuenta_contable_ingreso_debito());	
					bodegaproductoLocal.setid_cuenta_contable_ingreso_credito(bodegaproducto.getid_cuenta_contable_ingreso_credito());	
					bodegaproductoLocal.setid_cuenta_contable_resultado_debito(bodegaproducto.getid_cuenta_contable_resultado_debito());	
					bodegaproductoLocal.setid_cuenta_contable_resultado_credito(bodegaproducto.getid_cuenta_contable_resultado_credito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bodegaproducto.getIsDeleted()) {
				if(!existe) {
					bodegaproductos.add(bodegaproducto);
				}
			} else {
				if(bodegaproductoEncontrado!=null && permiteQuitar)  {
					bodegaproductos.remove(bodegaproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BodegaProducto bodegaproducto,List<BodegaProducto> bodegaproductos) throws Exception {
		try	{			
			for(BodegaProducto bodegaproductoLocal:bodegaproductos) {
				if(bodegaproductoLocal.getId().equals(bodegaproducto.getId())) {
					bodegaproductoLocal.setIsSelected(bodegaproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBodegaProducto(List<BodegaProducto> bodegaproductosAux) throws Exception {
		//this.bodegaproductosAux=bodegaproductosAux;
		
		for(BodegaProducto bodegaproductoAux:bodegaproductosAux) {
			if(bodegaproductoAux.getIsChanged()) {
				bodegaproductoAux.setIsChanged(false);
			}		
			
			if(bodegaproductoAux.getIsNew()) {
				bodegaproductoAux.setIsNew(false);
			}	
			
			if(bodegaproductoAux.getIsDeleted()) {
				bodegaproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBodegaProducto(BodegaProducto bodegaproductoAux) throws Exception {
		//this.bodegaproductoAux=bodegaproductoAux;
		
			if(bodegaproductoAux.getIsChanged()) {
				bodegaproductoAux.setIsChanged(false);
			}		
			
			if(bodegaproductoAux.getIsNew()) {
				bodegaproductoAux.setIsNew(false);
			}	
			
			if(bodegaproductoAux.getIsDeleted()) {
				bodegaproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BodegaProducto bodegaproductoAsignar,BodegaProducto bodegaproducto) throws Exception {
		bodegaproductoAsignar.setId(bodegaproducto.getId());	
		bodegaproductoAsignar.setVersionRow(bodegaproducto.getVersionRow());	
		bodegaproductoAsignar.setid_empresa(bodegaproducto.getid_empresa());
		bodegaproductoAsignar.setempresa_descripcion(bodegaproducto.getempresa_descripcion());	
		bodegaproductoAsignar.setid_sucursal(bodegaproducto.getid_sucursal());
		bodegaproductoAsignar.setsucursal_descripcion(bodegaproducto.getsucursal_descripcion());	
		bodegaproductoAsignar.setid_bodega(bodegaproducto.getid_bodega());
		bodegaproductoAsignar.setbodega_descripcion(bodegaproducto.getbodega_descripcion());	
		bodegaproductoAsignar.setid_producto(bodegaproducto.getid_producto());
		bodegaproductoAsignar.setproducto_descripcion(bodegaproducto.getproducto_descripcion());	
		bodegaproductoAsignar.setid_unidad(bodegaproducto.getid_unidad());
		bodegaproductoAsignar.setunidad_descripcion(bodegaproducto.getunidad_descripcion());	
		bodegaproductoAsignar.setid_centro_costo(bodegaproducto.getid_centro_costo());
		bodegaproductoAsignar.setcentrocosto_descripcion(bodegaproducto.getcentrocosto_descripcion());	
		bodegaproductoAsignar.setid_estado_bodega_producto(bodegaproducto.getid_estado_bodega_producto());
		bodegaproductoAsignar.setestadobodegaproducto_descripcion(bodegaproducto.getestadobodegaproducto_descripcion());	
		bodegaproductoAsignar.setdescripcion(bodegaproducto.getdescripcion());	
		bodegaproductoAsignar.setcantidad_disponible(bodegaproducto.getcantidad_disponible());	
		bodegaproductoAsignar.setstock_maximo(bodegaproducto.getstock_maximo());	
		bodegaproductoAsignar.setstock_minimo(bodegaproducto.getstock_minimo());	
		bodegaproductoAsignar.setiva(bodegaproducto.getiva());	
		bodegaproductoAsignar.setiva_valor(bodegaproducto.getiva_valor());	
		bodegaproductoAsignar.setdescuento(bodegaproducto.getdescuento());	
		bodegaproductoAsignar.setdescuento_valor(bodegaproducto.getdescuento_valor());	
		bodegaproductoAsignar.setice(bodegaproducto.getice());	
		bodegaproductoAsignar.setice_valor(bodegaproducto.getice_valor());	
		bodegaproductoAsignar.setcosto_promedio(bodegaproducto.getcosto_promedio());	
		bodegaproductoAsignar.setporcentaje_comision(bodegaproducto.getporcentaje_comision());	
		bodegaproductoAsignar.setprecio(bodegaproducto.getprecio());	
		bodegaproductoAsignar.setultimo_costo(bodegaproducto.getultimo_costo());	
		bodegaproductoAsignar.setcosto(bodegaproducto.getcosto());	
		bodegaproductoAsignar.setarancel_porcentaje(bodegaproducto.getarancel_porcentaje());	
		bodegaproductoAsignar.setice_porcentaje(bodegaproducto.getice_porcentaje());	
		bodegaproductoAsignar.setpeso(bodegaproducto.getpeso());	
		bodegaproductoAsignar.setcon_iva(bodegaproducto.getcon_iva());	
		bodegaproductoAsignar.setcon_impuesto(bodegaproducto.getcon_impuesto());	
		bodegaproductoAsignar.setcon_ice(bodegaproducto.getcon_ice());	
		bodegaproductoAsignar.setesta_activo(bodegaproducto.getesta_activo());	
		bodegaproductoAsignar.setcon_balanza(bodegaproducto.getcon_balanza());	
		bodegaproductoAsignar.setcantidad_pedida(bodegaproducto.getcantidad_pedida());	
		bodegaproductoAsignar.setcantidad_fisica(bodegaproducto.getcantidad_fisica());	
		bodegaproductoAsignar.setcantidad_requerido(bodegaproducto.getcantidad_requerido());	
		bodegaproductoAsignar.setprecio_costo(bodegaproducto.getprecio_costo());	
		bodegaproductoAsignar.setprecio_promedio(bodegaproducto.getprecio_promedio());	
		bodegaproductoAsignar.settotal_ingresos(bodegaproducto.gettotal_ingresos());	
		bodegaproductoAsignar.settotal_egresos(bodegaproducto.gettotal_egresos());	
		bodegaproductoAsignar.settotal_provision(bodegaproducto.gettotal_provision());	
		bodegaproductoAsignar.settotal_proceso(bodegaproducto.gettotal_proceso());	
		bodegaproductoAsignar.setcosto_calculado(bodegaproducto.getcosto_calculado());	
		bodegaproductoAsignar.setdias_produccion(bodegaproducto.getdias_produccion());	
		bodegaproductoAsignar.setprecio_reposicion(bodegaproducto.getprecio_reposicion());	
		bodegaproductoAsignar.setfecha_ultimo_pedido(bodegaproducto.getfecha_ultimo_pedido());	
		bodegaproductoAsignar.setfecha_ingreso(bodegaproducto.getfecha_ingreso());	
		bodegaproductoAsignar.setfecha_egreso(bodegaproducto.getfecha_egreso());	
		bodegaproductoAsignar.setfecha_ultima_compra(bodegaproducto.getfecha_ultima_compra());	
		bodegaproductoAsignar.setfecha_ultima_venta(bodegaproducto.getfecha_ultima_venta());	
		bodegaproductoAsignar.setfecha_ultima_devolucion(bodegaproducto.getfecha_ultima_devolucion());	
		bodegaproductoAsignar.setid_cuenta_contable_inventario(bodegaproducto.getid_cuenta_contable_inventario());
		bodegaproductoAsignar.setcuentacontableinventario_descripcion(bodegaproducto.getcuentacontableinventario_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_costo_venta(bodegaproducto.getid_cuenta_contable_costo_venta());
		bodegaproductoAsignar.setcuentacontablecostoventa_descripcion(bodegaproducto.getcuentacontablecostoventa_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_venta(bodegaproducto.getid_cuenta_contable_venta());
		bodegaproductoAsignar.setcuentacontableventa_descripcion(bodegaproducto.getcuentacontableventa_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_descuento(bodegaproducto.getid_cuenta_contable_descuento());
		bodegaproductoAsignar.setcuentacontabledescuento_descripcion(bodegaproducto.getcuentacontabledescuento_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_produccion(bodegaproducto.getid_cuenta_contable_produccion());
		bodegaproductoAsignar.setcuentacontableproduccion_descripcion(bodegaproducto.getcuentacontableproduccion_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_devolucion(bodegaproducto.getid_cuenta_contable_devolucion());
		bodegaproductoAsignar.setcuentacontabledevolucion_descripcion(bodegaproducto.getcuentacontabledevolucion_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_ingreso_debito(bodegaproducto.getid_cuenta_contable_ingreso_debito());
		bodegaproductoAsignar.setcuentacontableingresodebito_descripcion(bodegaproducto.getcuentacontableingresodebito_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_ingreso_credito(bodegaproducto.getid_cuenta_contable_ingreso_credito());
		bodegaproductoAsignar.setcuentacontableingresocredito_descripcion(bodegaproducto.getcuentacontableingresocredito_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_resultado_debito(bodegaproducto.getid_cuenta_contable_resultado_debito());
		bodegaproductoAsignar.setcuentacontableresultadodebito_descripcion(bodegaproducto.getcuentacontableresultadodebito_descripcion());	
		bodegaproductoAsignar.setid_cuenta_contable_resultado_credito(bodegaproducto.getid_cuenta_contable_resultado_credito());
		bodegaproductoAsignar.setcuentacontableresultadocredito_descripcion(bodegaproducto.getcuentacontableresultadocredito_descripcion());	
	}
	
	public static void inicializarBodegaProducto(BodegaProducto bodegaproducto) throws Exception {
		try {
				bodegaproducto.setId(0L);	
					
				bodegaproducto.setid_empresa(-1L);	
				bodegaproducto.setid_sucursal(-1L);	
				bodegaproducto.setid_bodega(-1L);	
				bodegaproducto.setid_producto(-1L);	
				bodegaproducto.setid_unidad(-1L);	
				bodegaproducto.setid_centro_costo(null);	
				bodegaproducto.setid_estado_bodega_producto(-1L);	
				bodegaproducto.setdescripcion("");	
				bodegaproducto.setcantidad_disponible(0);	
				bodegaproducto.setstock_maximo(0);	
				bodegaproducto.setstock_minimo(0);	
				bodegaproducto.setiva(0.0);	
				bodegaproducto.setiva_valor(0.0);	
				bodegaproducto.setdescuento(0.0);	
				bodegaproducto.setdescuento_valor(0.0);	
				bodegaproducto.setice(0.0);	
				bodegaproducto.setice_valor(0.0);	
				bodegaproducto.setcosto_promedio(0.0);	
				bodegaproducto.setporcentaje_comision(0.0);	
				bodegaproducto.setprecio(0.0);	
				bodegaproducto.setultimo_costo(0.0);	
				bodegaproducto.setcosto(0.0);	
				bodegaproducto.setarancel_porcentaje(0.0);	
				bodegaproducto.setice_porcentaje(0.0);	
				bodegaproducto.setpeso(0.0);	
				bodegaproducto.setcon_iva(false);	
				bodegaproducto.setcon_impuesto(false);	
				bodegaproducto.setcon_ice(false);	
				bodegaproducto.setesta_activo(false);	
				bodegaproducto.setcon_balanza(false);	
				bodegaproducto.setcantidad_pedida(0);	
				bodegaproducto.setcantidad_fisica(0);	
				bodegaproducto.setcantidad_requerido(0);	
				bodegaproducto.setprecio_costo(0.0);	
				bodegaproducto.setprecio_promedio(0.0);	
				bodegaproducto.settotal_ingresos(0);	
				bodegaproducto.settotal_egresos(0);	
				bodegaproducto.settotal_provision(0.0);	
				bodegaproducto.settotal_proceso(0.0);	
				bodegaproducto.setcosto_calculado(0.0);	
				bodegaproducto.setdias_produccion(0.0);	
				bodegaproducto.setprecio_reposicion(0.0);	
				bodegaproducto.setfecha_ultimo_pedido(new Date());	
				bodegaproducto.setfecha_ingreso(new Date());	
				bodegaproducto.setfecha_egreso(new Date());	
				bodegaproducto.setfecha_ultima_compra(new Date());	
				bodegaproducto.setfecha_ultima_venta(new Date());	
				bodegaproducto.setfecha_ultima_devolucion(new Date());	
				bodegaproducto.setid_cuenta_contable_inventario(-1L);	
				bodegaproducto.setid_cuenta_contable_costo_venta(-1L);	
				bodegaproducto.setid_cuenta_contable_venta(-1L);	
				bodegaproducto.setid_cuenta_contable_descuento(-1L);	
				bodegaproducto.setid_cuenta_contable_produccion(-1L);	
				bodegaproducto.setid_cuenta_contable_devolucion(-1L);	
				bodegaproducto.setid_cuenta_contable_ingreso_debito(-1L);	
				bodegaproducto.setid_cuenta_contable_ingreso_credito(-1L);	
				bodegaproducto.setid_cuenta_contable_resultado_debito(-1L);	
				bodegaproducto.setid_cuenta_contable_resultado_credito(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBodegaProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDESTADOBODEGAPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_STOCKMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_STOCKMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_COSTOPROMEDIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PORCENTAJECOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ICEPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CONIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CONICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CONBALANZA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CANTIDADPEDIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CANTIDADFISICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_CANTIDADREQUERIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PRECIOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PRECIOPROMEDIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_TOTALINGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_TOTALEGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_TOTALPROVISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_TOTALPROCESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_COSTOCALCULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_DIASPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_PRECIOREPOSICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESODEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESOCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADODEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaProductoConstantesFunciones.LABEL_IDCUENTACONTABLERESULTADOCREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBodegaProducto(String sTipo,Row row,Workbook workbook,BodegaProducto bodegaproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getestadobodegaproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getstock_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getstock_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcosto_promedio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getporcentaje_comision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getarancel_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getice_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getpeso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodegaproducto.getcon_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodegaproducto.getcon_impuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodegaproducto.getcon_ice()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodegaproducto.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(bodegaproducto.getcon_balanza()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcantidad_pedida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcantidad_fisica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcantidad_requerido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getprecio_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getprecio_promedio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.gettotal_ingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.gettotal_egresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.gettotal_provision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.gettotal_proceso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcosto_calculado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getdias_produccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getprecio_reposicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_ultimo_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_ultima_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getfecha_ultima_devolucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontablecostoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableproduccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableingresodebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableingresocredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableresultadodebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegaproducto.getcuentacontableresultadocredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBodegaProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBodegaProducto() {
		return this.sFinalQueryBodegaProducto;
	}
	
	public void setsFinalQueryBodegaProducto(String sFinalQueryBodegaProducto) {
		this.sFinalQueryBodegaProducto= sFinalQueryBodegaProducto;
	}
	
	public Border resaltarSeleccionarBodegaProducto=null;
	
	public Border setResaltarSeleccionarBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBodegaProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBodegaProducto() {
		return this.resaltarSeleccionarBodegaProducto;
	}
	
	public void setResaltarSeleccionarBodegaProducto(Border borderResaltarSeleccionarBodegaProducto) {
		this.resaltarSeleccionarBodegaProducto= borderResaltarSeleccionarBodegaProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBodegaProducto=null;
	public Boolean mostraridBodegaProducto=true;
	public Boolean activaridBodegaProducto=true;

	public Border resaltarid_empresaBodegaProducto=null;
	public Boolean mostrarid_empresaBodegaProducto=true;
	public Boolean activarid_empresaBodegaProducto=true;
	public Boolean cargarid_empresaBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalBodegaProducto=null;
	public Boolean mostrarid_sucursalBodegaProducto=true;
	public Boolean activarid_sucursalBodegaProducto=true;
	public Boolean cargarid_sucursalBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaBodegaProducto=null;
	public Boolean mostrarid_bodegaBodegaProducto=true;
	public Boolean activarid_bodegaBodegaProducto=true;
	public Boolean cargarid_bodegaBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_productoBodegaProducto=null;
	public Boolean mostrarid_productoBodegaProducto=true;
	public Boolean activarid_productoBodegaProducto=true;
	public Boolean cargarid_productoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoBodegaProducto=true;//ConEventDepend=true

	public Border resaltarid_unidadBodegaProducto=null;
	public Boolean mostrarid_unidadBodegaProducto=true;
	public Boolean activarid_unidadBodegaProducto=true;
	public Boolean cargarid_unidadBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadBodegaProducto=true;//ConEventDepend=true

	public Border resaltarid_centro_costoBodegaProducto=null;
	public Boolean mostrarid_centro_costoBodegaProducto=true;
	public Boolean activarid_centro_costoBodegaProducto=true;
	public Boolean cargarid_centro_costoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_estado_bodega_productoBodegaProducto=null;
	public Boolean mostrarid_estado_bodega_productoBodegaProducto=true;
	public Boolean activarid_estado_bodega_productoBodegaProducto=true;
	public Boolean cargarid_estado_bodega_productoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_bodega_productoBodegaProducto=false;//ConEventDepend=true

	public Border resaltardescripcionBodegaProducto=null;
	public Boolean mostrardescripcionBodegaProducto=true;
	public Boolean activardescripcionBodegaProducto=true;

	public Border resaltarcantidad_disponibleBodegaProducto=null;
	public Boolean mostrarcantidad_disponibleBodegaProducto=true;
	public Boolean activarcantidad_disponibleBodegaProducto=false;

	public Border resaltarstock_maximoBodegaProducto=null;
	public Boolean mostrarstock_maximoBodegaProducto=true;
	public Boolean activarstock_maximoBodegaProducto=true;

	public Border resaltarstock_minimoBodegaProducto=null;
	public Boolean mostrarstock_minimoBodegaProducto=true;
	public Boolean activarstock_minimoBodegaProducto=true;

	public Border resaltarivaBodegaProducto=null;
	public Boolean mostrarivaBodegaProducto=true;
	public Boolean activarivaBodegaProducto=true;

	public Border resaltariva_valorBodegaProducto=null;
	public Boolean mostrariva_valorBodegaProducto=true;
	public Boolean activariva_valorBodegaProducto=true;

	public Border resaltardescuentoBodegaProducto=null;
	public Boolean mostrardescuentoBodegaProducto=true;
	public Boolean activardescuentoBodegaProducto=true;

	public Border resaltardescuento_valorBodegaProducto=null;
	public Boolean mostrardescuento_valorBodegaProducto=true;
	public Boolean activardescuento_valorBodegaProducto=true;

	public Border resaltariceBodegaProducto=null;
	public Boolean mostrariceBodegaProducto=true;
	public Boolean activariceBodegaProducto=true;

	public Border resaltarice_valorBodegaProducto=null;
	public Boolean mostrarice_valorBodegaProducto=true;
	public Boolean activarice_valorBodegaProducto=true;

	public Border resaltarcosto_promedioBodegaProducto=null;
	public Boolean mostrarcosto_promedioBodegaProducto=true;
	public Boolean activarcosto_promedioBodegaProducto=false;

	public Border resaltarporcentaje_comisionBodegaProducto=null;
	public Boolean mostrarporcentaje_comisionBodegaProducto=true;
	public Boolean activarporcentaje_comisionBodegaProducto=true;

	public Border resaltarprecioBodegaProducto=null;
	public Boolean mostrarprecioBodegaProducto=true;
	public Boolean activarprecioBodegaProducto=true;

	public Border resaltarultimo_costoBodegaProducto=null;
	public Boolean mostrarultimo_costoBodegaProducto=true;
	public Boolean activarultimo_costoBodegaProducto=false;

	public Border resaltarcostoBodegaProducto=null;
	public Boolean mostrarcostoBodegaProducto=true;
	public Boolean activarcostoBodegaProducto=true;

	public Border resaltararancel_porcentajeBodegaProducto=null;
	public Boolean mostrararancel_porcentajeBodegaProducto=true;
	public Boolean activararancel_porcentajeBodegaProducto=true;

	public Border resaltarice_porcentajeBodegaProducto=null;
	public Boolean mostrarice_porcentajeBodegaProducto=true;
	public Boolean activarice_porcentajeBodegaProducto=true;

	public Border resaltarpesoBodegaProducto=null;
	public Boolean mostrarpesoBodegaProducto=true;
	public Boolean activarpesoBodegaProducto=true;

	public Border resaltarcon_ivaBodegaProducto=null;
	public Boolean mostrarcon_ivaBodegaProducto=true;
	public Boolean activarcon_ivaBodegaProducto=true;

	public Border resaltarcon_impuestoBodegaProducto=null;
	public Boolean mostrarcon_impuestoBodegaProducto=true;
	public Boolean activarcon_impuestoBodegaProducto=true;

	public Border resaltarcon_iceBodegaProducto=null;
	public Boolean mostrarcon_iceBodegaProducto=true;
	public Boolean activarcon_iceBodegaProducto=true;

	public Border resaltaresta_activoBodegaProducto=null;
	public Boolean mostraresta_activoBodegaProducto=true;
	public Boolean activaresta_activoBodegaProducto=true;

	public Border resaltarcon_balanzaBodegaProducto=null;
	public Boolean mostrarcon_balanzaBodegaProducto=true;
	public Boolean activarcon_balanzaBodegaProducto=true;

	public Border resaltarcantidad_pedidaBodegaProducto=null;
	public Boolean mostrarcantidad_pedidaBodegaProducto=true;
	public Boolean activarcantidad_pedidaBodegaProducto=false;

	public Border resaltarcantidad_fisicaBodegaProducto=null;
	public Boolean mostrarcantidad_fisicaBodegaProducto=true;
	public Boolean activarcantidad_fisicaBodegaProducto=true;

	public Border resaltarcantidad_requeridoBodegaProducto=null;
	public Boolean mostrarcantidad_requeridoBodegaProducto=true;
	public Boolean activarcantidad_requeridoBodegaProducto=false;

	public Border resaltarprecio_costoBodegaProducto=null;
	public Boolean mostrarprecio_costoBodegaProducto=true;
	public Boolean activarprecio_costoBodegaProducto=true;

	public Border resaltarprecio_promedioBodegaProducto=null;
	public Boolean mostrarprecio_promedioBodegaProducto=true;
	public Boolean activarprecio_promedioBodegaProducto=false;

	public Border resaltartotal_ingresosBodegaProducto=null;
	public Boolean mostrartotal_ingresosBodegaProducto=true;
	public Boolean activartotal_ingresosBodegaProducto=false;

	public Border resaltartotal_egresosBodegaProducto=null;
	public Boolean mostrartotal_egresosBodegaProducto=true;
	public Boolean activartotal_egresosBodegaProducto=false;

	public Border resaltartotal_provisionBodegaProducto=null;
	public Boolean mostrartotal_provisionBodegaProducto=true;
	public Boolean activartotal_provisionBodegaProducto=false;

	public Border resaltartotal_procesoBodegaProducto=null;
	public Boolean mostrartotal_procesoBodegaProducto=true;
	public Boolean activartotal_procesoBodegaProducto=true;

	public Border resaltarcosto_calculadoBodegaProducto=null;
	public Boolean mostrarcosto_calculadoBodegaProducto=true;
	public Boolean activarcosto_calculadoBodegaProducto=false;

	public Border resaltardias_produccionBodegaProducto=null;
	public Boolean mostrardias_produccionBodegaProducto=true;
	public Boolean activardias_produccionBodegaProducto=true;

	public Border resaltarprecio_reposicionBodegaProducto=null;
	public Boolean mostrarprecio_reposicionBodegaProducto=true;
	public Boolean activarprecio_reposicionBodegaProducto=true;

	public Border resaltarfecha_ultimo_pedidoBodegaProducto=null;
	public Boolean mostrarfecha_ultimo_pedidoBodegaProducto=true;
	public Boolean activarfecha_ultimo_pedidoBodegaProducto=false;

	public Border resaltarfecha_ingresoBodegaProducto=null;
	public Boolean mostrarfecha_ingresoBodegaProducto=true;
	public Boolean activarfecha_ingresoBodegaProducto=false;

	public Border resaltarfecha_egresoBodegaProducto=null;
	public Boolean mostrarfecha_egresoBodegaProducto=true;
	public Boolean activarfecha_egresoBodegaProducto=false;

	public Border resaltarfecha_ultima_compraBodegaProducto=null;
	public Boolean mostrarfecha_ultima_compraBodegaProducto=true;
	public Boolean activarfecha_ultima_compraBodegaProducto=false;

	public Border resaltarfecha_ultima_ventaBodegaProducto=null;
	public Boolean mostrarfecha_ultima_ventaBodegaProducto=true;
	public Boolean activarfecha_ultima_ventaBodegaProducto=false;

	public Border resaltarfecha_ultima_devolucionBodegaProducto=null;
	public Boolean mostrarfecha_ultima_devolucionBodegaProducto=true;
	public Boolean activarfecha_ultima_devolucionBodegaProducto=false;

	public Border resaltarid_cuenta_contable_inventarioBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_inventarioBodegaProducto=true;
	public Boolean activarid_cuenta_contable_inventarioBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_inventarioBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_inventarioBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costo_ventaBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_costo_ventaBodegaProducto=true;
	public Boolean activarid_cuenta_contable_costo_ventaBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_costo_ventaBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_ventaBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_ventaBodegaProducto=true;
	public Boolean activarid_cuenta_contable_ventaBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_ventaBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_descuentoBodegaProducto=true;
	public Boolean activarid_cuenta_contable_descuentoBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_descuentoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_produccionBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_produccionBodegaProducto=true;
	public Boolean activarid_cuenta_contable_produccionBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_produccionBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_produccionBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_devolucionBodegaProducto=true;
	public Boolean activarid_cuenta_contable_devolucionBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_devolucionBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingreso_debitoBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_ingreso_debitoBodegaProducto=true;
	public Boolean activarid_cuenta_contable_ingreso_debitoBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_ingreso_debitoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingreso_debitoBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingreso_creditoBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_ingreso_creditoBodegaProducto=true;
	public Boolean activarid_cuenta_contable_ingreso_creditoBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_ingreso_creditoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingreso_creditoBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_resultado_debitoBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_resultado_debitoBodegaProducto=true;
	public Boolean activarid_cuenta_contable_resultado_debitoBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_resultado_debitoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_resultado_debitoBodegaProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_resultado_creditoBodegaProducto=null;
	public Boolean mostrarid_cuenta_contable_resultado_creditoBodegaProducto=true;
	public Boolean activarid_cuenta_contable_resultado_creditoBodegaProducto=true;
	public Boolean cargarid_cuenta_contable_resultado_creditoBodegaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_resultado_creditoBodegaProducto=false;//ConEventDepend=true

	
	

	public Border setResaltaridBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltaridBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBodegaProducto() {
		return this.resaltaridBodegaProducto;
	}

	public void setResaltaridBodegaProducto(Border borderResaltar) {
		this.resaltaridBodegaProducto= borderResaltar;
	}

	public Boolean getMostraridBodegaProducto() {
		return this.mostraridBodegaProducto;
	}

	public void setMostraridBodegaProducto(Boolean mostraridBodegaProducto) {
		this.mostraridBodegaProducto= mostraridBodegaProducto;
	}

	public Boolean getActivaridBodegaProducto() {
		return this.activaridBodegaProducto;
	}

	public void setActivaridBodegaProducto(Boolean activaridBodegaProducto) {
		this.activaridBodegaProducto= activaridBodegaProducto;
	}

	public Border setResaltarid_empresaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBodegaProducto() {
		return this.resaltarid_empresaBodegaProducto;
	}

	public void setResaltarid_empresaBodegaProducto(Border borderResaltar) {
		this.resaltarid_empresaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaBodegaProducto() {
		return this.mostrarid_empresaBodegaProducto;
	}

	public void setMostrarid_empresaBodegaProducto(Boolean mostrarid_empresaBodegaProducto) {
		this.mostrarid_empresaBodegaProducto= mostrarid_empresaBodegaProducto;
	}

	public Boolean getActivarid_empresaBodegaProducto() {
		return this.activarid_empresaBodegaProducto;
	}

	public void setActivarid_empresaBodegaProducto(Boolean activarid_empresaBodegaProducto) {
		this.activarid_empresaBodegaProducto= activarid_empresaBodegaProducto;
	}

	public Boolean getCargarid_empresaBodegaProducto() {
		return this.cargarid_empresaBodegaProducto;
	}

	public void setCargarid_empresaBodegaProducto(Boolean cargarid_empresaBodegaProducto) {
		this.cargarid_empresaBodegaProducto= cargarid_empresaBodegaProducto;
	}

	public Border setResaltarid_sucursalBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBodegaProducto() {
		return this.resaltarid_sucursalBodegaProducto;
	}

	public void setResaltarid_sucursalBodegaProducto(Border borderResaltar) {
		this.resaltarid_sucursalBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBodegaProducto() {
		return this.mostrarid_sucursalBodegaProducto;
	}

	public void setMostrarid_sucursalBodegaProducto(Boolean mostrarid_sucursalBodegaProducto) {
		this.mostrarid_sucursalBodegaProducto= mostrarid_sucursalBodegaProducto;
	}

	public Boolean getActivarid_sucursalBodegaProducto() {
		return this.activarid_sucursalBodegaProducto;
	}

	public void setActivarid_sucursalBodegaProducto(Boolean activarid_sucursalBodegaProducto) {
		this.activarid_sucursalBodegaProducto= activarid_sucursalBodegaProducto;
	}

	public Boolean getCargarid_sucursalBodegaProducto() {
		return this.cargarid_sucursalBodegaProducto;
	}

	public void setCargarid_sucursalBodegaProducto(Boolean cargarid_sucursalBodegaProducto) {
		this.cargarid_sucursalBodegaProducto= cargarid_sucursalBodegaProducto;
	}

	public Border setResaltarid_bodegaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaBodegaProducto() {
		return this.resaltarid_bodegaBodegaProducto;
	}

	public void setResaltarid_bodegaBodegaProducto(Border borderResaltar) {
		this.resaltarid_bodegaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaBodegaProducto() {
		return this.mostrarid_bodegaBodegaProducto;
	}

	public void setMostrarid_bodegaBodegaProducto(Boolean mostrarid_bodegaBodegaProducto) {
		this.mostrarid_bodegaBodegaProducto= mostrarid_bodegaBodegaProducto;
	}

	public Boolean getActivarid_bodegaBodegaProducto() {
		return this.activarid_bodegaBodegaProducto;
	}

	public void setActivarid_bodegaBodegaProducto(Boolean activarid_bodegaBodegaProducto) {
		this.activarid_bodegaBodegaProducto= activarid_bodegaBodegaProducto;
	}

	public Boolean getCargarid_bodegaBodegaProducto() {
		return this.cargarid_bodegaBodegaProducto;
	}

	public void setCargarid_bodegaBodegaProducto(Boolean cargarid_bodegaBodegaProducto) {
		this.cargarid_bodegaBodegaProducto= cargarid_bodegaBodegaProducto;
	}

	public Border setResaltarid_productoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoBodegaProducto() {
		return this.resaltarid_productoBodegaProducto;
	}

	public void setResaltarid_productoBodegaProducto(Border borderResaltar) {
		this.resaltarid_productoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoBodegaProducto() {
		return this.mostrarid_productoBodegaProducto;
	}

	public void setMostrarid_productoBodegaProducto(Boolean mostrarid_productoBodegaProducto) {
		this.mostrarid_productoBodegaProducto= mostrarid_productoBodegaProducto;
	}

	public Boolean getActivarid_productoBodegaProducto() {
		return this.activarid_productoBodegaProducto;
	}

	public void setActivarid_productoBodegaProducto(Boolean activarid_productoBodegaProducto) {
		this.activarid_productoBodegaProducto= activarid_productoBodegaProducto;
	}

	public Boolean getCargarid_productoBodegaProducto() {
		return this.cargarid_productoBodegaProducto;
	}

	public void setCargarid_productoBodegaProducto(Boolean cargarid_productoBodegaProducto) {
		this.cargarid_productoBodegaProducto= cargarid_productoBodegaProducto;
	}

	public Border setResaltarid_unidadBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_unidadBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadBodegaProducto() {
		return this.resaltarid_unidadBodegaProducto;
	}

	public void setResaltarid_unidadBodegaProducto(Border borderResaltar) {
		this.resaltarid_unidadBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_unidadBodegaProducto() {
		return this.mostrarid_unidadBodegaProducto;
	}

	public void setMostrarid_unidadBodegaProducto(Boolean mostrarid_unidadBodegaProducto) {
		this.mostrarid_unidadBodegaProducto= mostrarid_unidadBodegaProducto;
	}

	public Boolean getActivarid_unidadBodegaProducto() {
		return this.activarid_unidadBodegaProducto;
	}

	public void setActivarid_unidadBodegaProducto(Boolean activarid_unidadBodegaProducto) {
		this.activarid_unidadBodegaProducto= activarid_unidadBodegaProducto;
	}

	public Boolean getCargarid_unidadBodegaProducto() {
		return this.cargarid_unidadBodegaProducto;
	}

	public void setCargarid_unidadBodegaProducto(Boolean cargarid_unidadBodegaProducto) {
		this.cargarid_unidadBodegaProducto= cargarid_unidadBodegaProducto;
	}

	public Border setResaltarid_centro_costoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoBodegaProducto() {
		return this.resaltarid_centro_costoBodegaProducto;
	}

	public void setResaltarid_centro_costoBodegaProducto(Border borderResaltar) {
		this.resaltarid_centro_costoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoBodegaProducto() {
		return this.mostrarid_centro_costoBodegaProducto;
	}

	public void setMostrarid_centro_costoBodegaProducto(Boolean mostrarid_centro_costoBodegaProducto) {
		this.mostrarid_centro_costoBodegaProducto= mostrarid_centro_costoBodegaProducto;
	}

	public Boolean getActivarid_centro_costoBodegaProducto() {
		return this.activarid_centro_costoBodegaProducto;
	}

	public void setActivarid_centro_costoBodegaProducto(Boolean activarid_centro_costoBodegaProducto) {
		this.activarid_centro_costoBodegaProducto= activarid_centro_costoBodegaProducto;
	}

	public Boolean getCargarid_centro_costoBodegaProducto() {
		return this.cargarid_centro_costoBodegaProducto;
	}

	public void setCargarid_centro_costoBodegaProducto(Boolean cargarid_centro_costoBodegaProducto) {
		this.cargarid_centro_costoBodegaProducto= cargarid_centro_costoBodegaProducto;
	}

	public Border setResaltarid_estado_bodega_productoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_estado_bodega_productoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_bodega_productoBodegaProducto() {
		return this.resaltarid_estado_bodega_productoBodegaProducto;
	}

	public void setResaltarid_estado_bodega_productoBodegaProducto(Border borderResaltar) {
		this.resaltarid_estado_bodega_productoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_estado_bodega_productoBodegaProducto() {
		return this.mostrarid_estado_bodega_productoBodegaProducto;
	}

	public void setMostrarid_estado_bodega_productoBodegaProducto(Boolean mostrarid_estado_bodega_productoBodegaProducto) {
		this.mostrarid_estado_bodega_productoBodegaProducto= mostrarid_estado_bodega_productoBodegaProducto;
	}

	public Boolean getActivarid_estado_bodega_productoBodegaProducto() {
		return this.activarid_estado_bodega_productoBodegaProducto;
	}

	public void setActivarid_estado_bodega_productoBodegaProducto(Boolean activarid_estado_bodega_productoBodegaProducto) {
		this.activarid_estado_bodega_productoBodegaProducto= activarid_estado_bodega_productoBodegaProducto;
	}

	public Boolean getCargarid_estado_bodega_productoBodegaProducto() {
		return this.cargarid_estado_bodega_productoBodegaProducto;
	}

	public void setCargarid_estado_bodega_productoBodegaProducto(Boolean cargarid_estado_bodega_productoBodegaProducto) {
		this.cargarid_estado_bodega_productoBodegaProducto= cargarid_estado_bodega_productoBodegaProducto;
	}

	public Border setResaltardescripcionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionBodegaProducto() {
		return this.resaltardescripcionBodegaProducto;
	}

	public void setResaltardescripcionBodegaProducto(Border borderResaltar) {
		this.resaltardescripcionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionBodegaProducto() {
		return this.mostrardescripcionBodegaProducto;
	}

	public void setMostrardescripcionBodegaProducto(Boolean mostrardescripcionBodegaProducto) {
		this.mostrardescripcionBodegaProducto= mostrardescripcionBodegaProducto;
	}

	public Boolean getActivardescripcionBodegaProducto() {
		return this.activardescripcionBodegaProducto;
	}

	public void setActivardescripcionBodegaProducto(Boolean activardescripcionBodegaProducto) {
		this.activardescripcionBodegaProducto= activardescripcionBodegaProducto;
	}

	public Border setResaltarcantidad_disponibleBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleBodegaProducto() {
		return this.resaltarcantidad_disponibleBodegaProducto;
	}

	public void setResaltarcantidad_disponibleBodegaProducto(Border borderResaltar) {
		this.resaltarcantidad_disponibleBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleBodegaProducto() {
		return this.mostrarcantidad_disponibleBodegaProducto;
	}

	public void setMostrarcantidad_disponibleBodegaProducto(Boolean mostrarcantidad_disponibleBodegaProducto) {
		this.mostrarcantidad_disponibleBodegaProducto= mostrarcantidad_disponibleBodegaProducto;
	}

	public Boolean getActivarcantidad_disponibleBodegaProducto() {
		return this.activarcantidad_disponibleBodegaProducto;
	}

	public void setActivarcantidad_disponibleBodegaProducto(Boolean activarcantidad_disponibleBodegaProducto) {
		this.activarcantidad_disponibleBodegaProducto= activarcantidad_disponibleBodegaProducto;
	}

	public Border setResaltarstock_maximoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarstock_maximoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_maximoBodegaProducto() {
		return this.resaltarstock_maximoBodegaProducto;
	}

	public void setResaltarstock_maximoBodegaProducto(Border borderResaltar) {
		this.resaltarstock_maximoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarstock_maximoBodegaProducto() {
		return this.mostrarstock_maximoBodegaProducto;
	}

	public void setMostrarstock_maximoBodegaProducto(Boolean mostrarstock_maximoBodegaProducto) {
		this.mostrarstock_maximoBodegaProducto= mostrarstock_maximoBodegaProducto;
	}

	public Boolean getActivarstock_maximoBodegaProducto() {
		return this.activarstock_maximoBodegaProducto;
	}

	public void setActivarstock_maximoBodegaProducto(Boolean activarstock_maximoBodegaProducto) {
		this.activarstock_maximoBodegaProducto= activarstock_maximoBodegaProducto;
	}

	public Border setResaltarstock_minimoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarstock_minimoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstock_minimoBodegaProducto() {
		return this.resaltarstock_minimoBodegaProducto;
	}

	public void setResaltarstock_minimoBodegaProducto(Border borderResaltar) {
		this.resaltarstock_minimoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarstock_minimoBodegaProducto() {
		return this.mostrarstock_minimoBodegaProducto;
	}

	public void setMostrarstock_minimoBodegaProducto(Boolean mostrarstock_minimoBodegaProducto) {
		this.mostrarstock_minimoBodegaProducto= mostrarstock_minimoBodegaProducto;
	}

	public Boolean getActivarstock_minimoBodegaProducto() {
		return this.activarstock_minimoBodegaProducto;
	}

	public void setActivarstock_minimoBodegaProducto(Boolean activarstock_minimoBodegaProducto) {
		this.activarstock_minimoBodegaProducto= activarstock_minimoBodegaProducto;
	}

	public Border setResaltarivaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarivaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaBodegaProducto() {
		return this.resaltarivaBodegaProducto;
	}

	public void setResaltarivaBodegaProducto(Border borderResaltar) {
		this.resaltarivaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarivaBodegaProducto() {
		return this.mostrarivaBodegaProducto;
	}

	public void setMostrarivaBodegaProducto(Boolean mostrarivaBodegaProducto) {
		this.mostrarivaBodegaProducto= mostrarivaBodegaProducto;
	}

	public Boolean getActivarivaBodegaProducto() {
		return this.activarivaBodegaProducto;
	}

	public void setActivarivaBodegaProducto(Boolean activarivaBodegaProducto) {
		this.activarivaBodegaProducto= activarivaBodegaProducto;
	}

	public Border setResaltariva_valorBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltariva_valorBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorBodegaProducto() {
		return this.resaltariva_valorBodegaProducto;
	}

	public void setResaltariva_valorBodegaProducto(Border borderResaltar) {
		this.resaltariva_valorBodegaProducto= borderResaltar;
	}

	public Boolean getMostrariva_valorBodegaProducto() {
		return this.mostrariva_valorBodegaProducto;
	}

	public void setMostrariva_valorBodegaProducto(Boolean mostrariva_valorBodegaProducto) {
		this.mostrariva_valorBodegaProducto= mostrariva_valorBodegaProducto;
	}

	public Boolean getActivariva_valorBodegaProducto() {
		return this.activariva_valorBodegaProducto;
	}

	public void setActivariva_valorBodegaProducto(Boolean activariva_valorBodegaProducto) {
		this.activariva_valorBodegaProducto= activariva_valorBodegaProducto;
	}

	public Border setResaltardescuentoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltardescuentoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoBodegaProducto() {
		return this.resaltardescuentoBodegaProducto;
	}

	public void setResaltardescuentoBodegaProducto(Border borderResaltar) {
		this.resaltardescuentoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrardescuentoBodegaProducto() {
		return this.mostrardescuentoBodegaProducto;
	}

	public void setMostrardescuentoBodegaProducto(Boolean mostrardescuentoBodegaProducto) {
		this.mostrardescuentoBodegaProducto= mostrardescuentoBodegaProducto;
	}

	public Boolean getActivardescuentoBodegaProducto() {
		return this.activardescuentoBodegaProducto;
	}

	public void setActivardescuentoBodegaProducto(Boolean activardescuentoBodegaProducto) {
		this.activardescuentoBodegaProducto= activardescuentoBodegaProducto;
	}

	public Border setResaltardescuento_valorBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltardescuento_valorBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorBodegaProducto() {
		return this.resaltardescuento_valorBodegaProducto;
	}

	public void setResaltardescuento_valorBodegaProducto(Border borderResaltar) {
		this.resaltardescuento_valorBodegaProducto= borderResaltar;
	}

	public Boolean getMostrardescuento_valorBodegaProducto() {
		return this.mostrardescuento_valorBodegaProducto;
	}

	public void setMostrardescuento_valorBodegaProducto(Boolean mostrardescuento_valorBodegaProducto) {
		this.mostrardescuento_valorBodegaProducto= mostrardescuento_valorBodegaProducto;
	}

	public Boolean getActivardescuento_valorBodegaProducto() {
		return this.activardescuento_valorBodegaProducto;
	}

	public void setActivardescuento_valorBodegaProducto(Boolean activardescuento_valorBodegaProducto) {
		this.activardescuento_valorBodegaProducto= activardescuento_valorBodegaProducto;
	}

	public Border setResaltariceBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltariceBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceBodegaProducto() {
		return this.resaltariceBodegaProducto;
	}

	public void setResaltariceBodegaProducto(Border borderResaltar) {
		this.resaltariceBodegaProducto= borderResaltar;
	}

	public Boolean getMostrariceBodegaProducto() {
		return this.mostrariceBodegaProducto;
	}

	public void setMostrariceBodegaProducto(Boolean mostrariceBodegaProducto) {
		this.mostrariceBodegaProducto= mostrariceBodegaProducto;
	}

	public Boolean getActivariceBodegaProducto() {
		return this.activariceBodegaProducto;
	}

	public void setActivariceBodegaProducto(Boolean activariceBodegaProducto) {
		this.activariceBodegaProducto= activariceBodegaProducto;
	}

	public Border setResaltarice_valorBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarice_valorBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorBodegaProducto() {
		return this.resaltarice_valorBodegaProducto;
	}

	public void setResaltarice_valorBodegaProducto(Border borderResaltar) {
		this.resaltarice_valorBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarice_valorBodegaProducto() {
		return this.mostrarice_valorBodegaProducto;
	}

	public void setMostrarice_valorBodegaProducto(Boolean mostrarice_valorBodegaProducto) {
		this.mostrarice_valorBodegaProducto= mostrarice_valorBodegaProducto;
	}

	public Boolean getActivarice_valorBodegaProducto() {
		return this.activarice_valorBodegaProducto;
	}

	public void setActivarice_valorBodegaProducto(Boolean activarice_valorBodegaProducto) {
		this.activarice_valorBodegaProducto= activarice_valorBodegaProducto;
	}

	public Border setResaltarcosto_promedioBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcosto_promedioBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_promedioBodegaProducto() {
		return this.resaltarcosto_promedioBodegaProducto;
	}

	public void setResaltarcosto_promedioBodegaProducto(Border borderResaltar) {
		this.resaltarcosto_promedioBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcosto_promedioBodegaProducto() {
		return this.mostrarcosto_promedioBodegaProducto;
	}

	public void setMostrarcosto_promedioBodegaProducto(Boolean mostrarcosto_promedioBodegaProducto) {
		this.mostrarcosto_promedioBodegaProducto= mostrarcosto_promedioBodegaProducto;
	}

	public Boolean getActivarcosto_promedioBodegaProducto() {
		return this.activarcosto_promedioBodegaProducto;
	}

	public void setActivarcosto_promedioBodegaProducto(Boolean activarcosto_promedioBodegaProducto) {
		this.activarcosto_promedioBodegaProducto= activarcosto_promedioBodegaProducto;
	}

	public Border setResaltarporcentaje_comisionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarporcentaje_comisionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_comisionBodegaProducto() {
		return this.resaltarporcentaje_comisionBodegaProducto;
	}

	public void setResaltarporcentaje_comisionBodegaProducto(Border borderResaltar) {
		this.resaltarporcentaje_comisionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarporcentaje_comisionBodegaProducto() {
		return this.mostrarporcentaje_comisionBodegaProducto;
	}

	public void setMostrarporcentaje_comisionBodegaProducto(Boolean mostrarporcentaje_comisionBodegaProducto) {
		this.mostrarporcentaje_comisionBodegaProducto= mostrarporcentaje_comisionBodegaProducto;
	}

	public Boolean getActivarporcentaje_comisionBodegaProducto() {
		return this.activarporcentaje_comisionBodegaProducto;
	}

	public void setActivarporcentaje_comisionBodegaProducto(Boolean activarporcentaje_comisionBodegaProducto) {
		this.activarporcentaje_comisionBodegaProducto= activarporcentaje_comisionBodegaProducto;
	}

	public Border setResaltarprecioBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarprecioBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioBodegaProducto() {
		return this.resaltarprecioBodegaProducto;
	}

	public void setResaltarprecioBodegaProducto(Border borderResaltar) {
		this.resaltarprecioBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarprecioBodegaProducto() {
		return this.mostrarprecioBodegaProducto;
	}

	public void setMostrarprecioBodegaProducto(Boolean mostrarprecioBodegaProducto) {
		this.mostrarprecioBodegaProducto= mostrarprecioBodegaProducto;
	}

	public Boolean getActivarprecioBodegaProducto() {
		return this.activarprecioBodegaProducto;
	}

	public void setActivarprecioBodegaProducto(Boolean activarprecioBodegaProducto) {
		this.activarprecioBodegaProducto= activarprecioBodegaProducto;
	}

	public Border setResaltarultimo_costoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarultimo_costoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoBodegaProducto() {
		return this.resaltarultimo_costoBodegaProducto;
	}

	public void setResaltarultimo_costoBodegaProducto(Border borderResaltar) {
		this.resaltarultimo_costoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarultimo_costoBodegaProducto() {
		return this.mostrarultimo_costoBodegaProducto;
	}

	public void setMostrarultimo_costoBodegaProducto(Boolean mostrarultimo_costoBodegaProducto) {
		this.mostrarultimo_costoBodegaProducto= mostrarultimo_costoBodegaProducto;
	}

	public Boolean getActivarultimo_costoBodegaProducto() {
		return this.activarultimo_costoBodegaProducto;
	}

	public void setActivarultimo_costoBodegaProducto(Boolean activarultimo_costoBodegaProducto) {
		this.activarultimo_costoBodegaProducto= activarultimo_costoBodegaProducto;
	}

	public Border setResaltarcostoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcostoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoBodegaProducto() {
		return this.resaltarcostoBodegaProducto;
	}

	public void setResaltarcostoBodegaProducto(Border borderResaltar) {
		this.resaltarcostoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcostoBodegaProducto() {
		return this.mostrarcostoBodegaProducto;
	}

	public void setMostrarcostoBodegaProducto(Boolean mostrarcostoBodegaProducto) {
		this.mostrarcostoBodegaProducto= mostrarcostoBodegaProducto;
	}

	public Boolean getActivarcostoBodegaProducto() {
		return this.activarcostoBodegaProducto;
	}

	public void setActivarcostoBodegaProducto(Boolean activarcostoBodegaProducto) {
		this.activarcostoBodegaProducto= activarcostoBodegaProducto;
	}

	public Border setResaltararancel_porcentajeBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltararancel_porcentajeBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararancel_porcentajeBodegaProducto() {
		return this.resaltararancel_porcentajeBodegaProducto;
	}

	public void setResaltararancel_porcentajeBodegaProducto(Border borderResaltar) {
		this.resaltararancel_porcentajeBodegaProducto= borderResaltar;
	}

	public Boolean getMostrararancel_porcentajeBodegaProducto() {
		return this.mostrararancel_porcentajeBodegaProducto;
	}

	public void setMostrararancel_porcentajeBodegaProducto(Boolean mostrararancel_porcentajeBodegaProducto) {
		this.mostrararancel_porcentajeBodegaProducto= mostrararancel_porcentajeBodegaProducto;
	}

	public Boolean getActivararancel_porcentajeBodegaProducto() {
		return this.activararancel_porcentajeBodegaProducto;
	}

	public void setActivararancel_porcentajeBodegaProducto(Boolean activararancel_porcentajeBodegaProducto) {
		this.activararancel_porcentajeBodegaProducto= activararancel_porcentajeBodegaProducto;
	}

	public Border setResaltarice_porcentajeBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarice_porcentajeBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_porcentajeBodegaProducto() {
		return this.resaltarice_porcentajeBodegaProducto;
	}

	public void setResaltarice_porcentajeBodegaProducto(Border borderResaltar) {
		this.resaltarice_porcentajeBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarice_porcentajeBodegaProducto() {
		return this.mostrarice_porcentajeBodegaProducto;
	}

	public void setMostrarice_porcentajeBodegaProducto(Boolean mostrarice_porcentajeBodegaProducto) {
		this.mostrarice_porcentajeBodegaProducto= mostrarice_porcentajeBodegaProducto;
	}

	public Boolean getActivarice_porcentajeBodegaProducto() {
		return this.activarice_porcentajeBodegaProducto;
	}

	public void setActivarice_porcentajeBodegaProducto(Boolean activarice_porcentajeBodegaProducto) {
		this.activarice_porcentajeBodegaProducto= activarice_porcentajeBodegaProducto;
	}

	public Border setResaltarpesoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarpesoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpesoBodegaProducto() {
		return this.resaltarpesoBodegaProducto;
	}

	public void setResaltarpesoBodegaProducto(Border borderResaltar) {
		this.resaltarpesoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarpesoBodegaProducto() {
		return this.mostrarpesoBodegaProducto;
	}

	public void setMostrarpesoBodegaProducto(Boolean mostrarpesoBodegaProducto) {
		this.mostrarpesoBodegaProducto= mostrarpesoBodegaProducto;
	}

	public Boolean getActivarpesoBodegaProducto() {
		return this.activarpesoBodegaProducto;
	}

	public void setActivarpesoBodegaProducto(Boolean activarpesoBodegaProducto) {
		this.activarpesoBodegaProducto= activarpesoBodegaProducto;
	}

	public Border setResaltarcon_ivaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcon_ivaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_ivaBodegaProducto() {
		return this.resaltarcon_ivaBodegaProducto;
	}

	public void setResaltarcon_ivaBodegaProducto(Border borderResaltar) {
		this.resaltarcon_ivaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcon_ivaBodegaProducto() {
		return this.mostrarcon_ivaBodegaProducto;
	}

	public void setMostrarcon_ivaBodegaProducto(Boolean mostrarcon_ivaBodegaProducto) {
		this.mostrarcon_ivaBodegaProducto= mostrarcon_ivaBodegaProducto;
	}

	public Boolean getActivarcon_ivaBodegaProducto() {
		return this.activarcon_ivaBodegaProducto;
	}

	public void setActivarcon_ivaBodegaProducto(Boolean activarcon_ivaBodegaProducto) {
		this.activarcon_ivaBodegaProducto= activarcon_ivaBodegaProducto;
	}

	public Border setResaltarcon_impuestoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcon_impuestoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_impuestoBodegaProducto() {
		return this.resaltarcon_impuestoBodegaProducto;
	}

	public void setResaltarcon_impuestoBodegaProducto(Border borderResaltar) {
		this.resaltarcon_impuestoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcon_impuestoBodegaProducto() {
		return this.mostrarcon_impuestoBodegaProducto;
	}

	public void setMostrarcon_impuestoBodegaProducto(Boolean mostrarcon_impuestoBodegaProducto) {
		this.mostrarcon_impuestoBodegaProducto= mostrarcon_impuestoBodegaProducto;
	}

	public Boolean getActivarcon_impuestoBodegaProducto() {
		return this.activarcon_impuestoBodegaProducto;
	}

	public void setActivarcon_impuestoBodegaProducto(Boolean activarcon_impuestoBodegaProducto) {
		this.activarcon_impuestoBodegaProducto= activarcon_impuestoBodegaProducto;
	}

	public Border setResaltarcon_iceBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcon_iceBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_iceBodegaProducto() {
		return this.resaltarcon_iceBodegaProducto;
	}

	public void setResaltarcon_iceBodegaProducto(Border borderResaltar) {
		this.resaltarcon_iceBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcon_iceBodegaProducto() {
		return this.mostrarcon_iceBodegaProducto;
	}

	public void setMostrarcon_iceBodegaProducto(Boolean mostrarcon_iceBodegaProducto) {
		this.mostrarcon_iceBodegaProducto= mostrarcon_iceBodegaProducto;
	}

	public Boolean getActivarcon_iceBodegaProducto() {
		return this.activarcon_iceBodegaProducto;
	}

	public void setActivarcon_iceBodegaProducto(Boolean activarcon_iceBodegaProducto) {
		this.activarcon_iceBodegaProducto= activarcon_iceBodegaProducto;
	}

	public Border setResaltaresta_activoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltaresta_activoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoBodegaProducto() {
		return this.resaltaresta_activoBodegaProducto;
	}

	public void setResaltaresta_activoBodegaProducto(Border borderResaltar) {
		this.resaltaresta_activoBodegaProducto= borderResaltar;
	}

	public Boolean getMostraresta_activoBodegaProducto() {
		return this.mostraresta_activoBodegaProducto;
	}

	public void setMostraresta_activoBodegaProducto(Boolean mostraresta_activoBodegaProducto) {
		this.mostraresta_activoBodegaProducto= mostraresta_activoBodegaProducto;
	}

	public Boolean getActivaresta_activoBodegaProducto() {
		return this.activaresta_activoBodegaProducto;
	}

	public void setActivaresta_activoBodegaProducto(Boolean activaresta_activoBodegaProducto) {
		this.activaresta_activoBodegaProducto= activaresta_activoBodegaProducto;
	}

	public Border setResaltarcon_balanzaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcon_balanzaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_balanzaBodegaProducto() {
		return this.resaltarcon_balanzaBodegaProducto;
	}

	public void setResaltarcon_balanzaBodegaProducto(Border borderResaltar) {
		this.resaltarcon_balanzaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcon_balanzaBodegaProducto() {
		return this.mostrarcon_balanzaBodegaProducto;
	}

	public void setMostrarcon_balanzaBodegaProducto(Boolean mostrarcon_balanzaBodegaProducto) {
		this.mostrarcon_balanzaBodegaProducto= mostrarcon_balanzaBodegaProducto;
	}

	public Boolean getActivarcon_balanzaBodegaProducto() {
		return this.activarcon_balanzaBodegaProducto;
	}

	public void setActivarcon_balanzaBodegaProducto(Boolean activarcon_balanzaBodegaProducto) {
		this.activarcon_balanzaBodegaProducto= activarcon_balanzaBodegaProducto;
	}

	public Border setResaltarcantidad_pedidaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidaBodegaProducto() {
		return this.resaltarcantidad_pedidaBodegaProducto;
	}

	public void setResaltarcantidad_pedidaBodegaProducto(Border borderResaltar) {
		this.resaltarcantidad_pedidaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidaBodegaProducto() {
		return this.mostrarcantidad_pedidaBodegaProducto;
	}

	public void setMostrarcantidad_pedidaBodegaProducto(Boolean mostrarcantidad_pedidaBodegaProducto) {
		this.mostrarcantidad_pedidaBodegaProducto= mostrarcantidad_pedidaBodegaProducto;
	}

	public Boolean getActivarcantidad_pedidaBodegaProducto() {
		return this.activarcantidad_pedidaBodegaProducto;
	}

	public void setActivarcantidad_pedidaBodegaProducto(Boolean activarcantidad_pedidaBodegaProducto) {
		this.activarcantidad_pedidaBodegaProducto= activarcantidad_pedidaBodegaProducto;
	}

	public Border setResaltarcantidad_fisicaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_fisicaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_fisicaBodegaProducto() {
		return this.resaltarcantidad_fisicaBodegaProducto;
	}

	public void setResaltarcantidad_fisicaBodegaProducto(Border borderResaltar) {
		this.resaltarcantidad_fisicaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_fisicaBodegaProducto() {
		return this.mostrarcantidad_fisicaBodegaProducto;
	}

	public void setMostrarcantidad_fisicaBodegaProducto(Boolean mostrarcantidad_fisicaBodegaProducto) {
		this.mostrarcantidad_fisicaBodegaProducto= mostrarcantidad_fisicaBodegaProducto;
	}

	public Boolean getActivarcantidad_fisicaBodegaProducto() {
		return this.activarcantidad_fisicaBodegaProducto;
	}

	public void setActivarcantidad_fisicaBodegaProducto(Boolean activarcantidad_fisicaBodegaProducto) {
		this.activarcantidad_fisicaBodegaProducto= activarcantidad_fisicaBodegaProducto;
	}

	public Border setResaltarcantidad_requeridoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_requeridoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_requeridoBodegaProducto() {
		return this.resaltarcantidad_requeridoBodegaProducto;
	}

	public void setResaltarcantidad_requeridoBodegaProducto(Border borderResaltar) {
		this.resaltarcantidad_requeridoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_requeridoBodegaProducto() {
		return this.mostrarcantidad_requeridoBodegaProducto;
	}

	public void setMostrarcantidad_requeridoBodegaProducto(Boolean mostrarcantidad_requeridoBodegaProducto) {
		this.mostrarcantidad_requeridoBodegaProducto= mostrarcantidad_requeridoBodegaProducto;
	}

	public Boolean getActivarcantidad_requeridoBodegaProducto() {
		return this.activarcantidad_requeridoBodegaProducto;
	}

	public void setActivarcantidad_requeridoBodegaProducto(Boolean activarcantidad_requeridoBodegaProducto) {
		this.activarcantidad_requeridoBodegaProducto= activarcantidad_requeridoBodegaProducto;
	}

	public Border setResaltarprecio_costoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarprecio_costoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_costoBodegaProducto() {
		return this.resaltarprecio_costoBodegaProducto;
	}

	public void setResaltarprecio_costoBodegaProducto(Border borderResaltar) {
		this.resaltarprecio_costoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarprecio_costoBodegaProducto() {
		return this.mostrarprecio_costoBodegaProducto;
	}

	public void setMostrarprecio_costoBodegaProducto(Boolean mostrarprecio_costoBodegaProducto) {
		this.mostrarprecio_costoBodegaProducto= mostrarprecio_costoBodegaProducto;
	}

	public Boolean getActivarprecio_costoBodegaProducto() {
		return this.activarprecio_costoBodegaProducto;
	}

	public void setActivarprecio_costoBodegaProducto(Boolean activarprecio_costoBodegaProducto) {
		this.activarprecio_costoBodegaProducto= activarprecio_costoBodegaProducto;
	}

	public Border setResaltarprecio_promedioBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarprecio_promedioBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_promedioBodegaProducto() {
		return this.resaltarprecio_promedioBodegaProducto;
	}

	public void setResaltarprecio_promedioBodegaProducto(Border borderResaltar) {
		this.resaltarprecio_promedioBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarprecio_promedioBodegaProducto() {
		return this.mostrarprecio_promedioBodegaProducto;
	}

	public void setMostrarprecio_promedioBodegaProducto(Boolean mostrarprecio_promedioBodegaProducto) {
		this.mostrarprecio_promedioBodegaProducto= mostrarprecio_promedioBodegaProducto;
	}

	public Boolean getActivarprecio_promedioBodegaProducto() {
		return this.activarprecio_promedioBodegaProducto;
	}

	public void setActivarprecio_promedioBodegaProducto(Boolean activarprecio_promedioBodegaProducto) {
		this.activarprecio_promedioBodegaProducto= activarprecio_promedioBodegaProducto;
	}

	public Border setResaltartotal_ingresosBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltartotal_ingresosBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ingresosBodegaProducto() {
		return this.resaltartotal_ingresosBodegaProducto;
	}

	public void setResaltartotal_ingresosBodegaProducto(Border borderResaltar) {
		this.resaltartotal_ingresosBodegaProducto= borderResaltar;
	}

	public Boolean getMostrartotal_ingresosBodegaProducto() {
		return this.mostrartotal_ingresosBodegaProducto;
	}

	public void setMostrartotal_ingresosBodegaProducto(Boolean mostrartotal_ingresosBodegaProducto) {
		this.mostrartotal_ingresosBodegaProducto= mostrartotal_ingresosBodegaProducto;
	}

	public Boolean getActivartotal_ingresosBodegaProducto() {
		return this.activartotal_ingresosBodegaProducto;
	}

	public void setActivartotal_ingresosBodegaProducto(Boolean activartotal_ingresosBodegaProducto) {
		this.activartotal_ingresosBodegaProducto= activartotal_ingresosBodegaProducto;
	}

	public Border setResaltartotal_egresosBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltartotal_egresosBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_egresosBodegaProducto() {
		return this.resaltartotal_egresosBodegaProducto;
	}

	public void setResaltartotal_egresosBodegaProducto(Border borderResaltar) {
		this.resaltartotal_egresosBodegaProducto= borderResaltar;
	}

	public Boolean getMostrartotal_egresosBodegaProducto() {
		return this.mostrartotal_egresosBodegaProducto;
	}

	public void setMostrartotal_egresosBodegaProducto(Boolean mostrartotal_egresosBodegaProducto) {
		this.mostrartotal_egresosBodegaProducto= mostrartotal_egresosBodegaProducto;
	}

	public Boolean getActivartotal_egresosBodegaProducto() {
		return this.activartotal_egresosBodegaProducto;
	}

	public void setActivartotal_egresosBodegaProducto(Boolean activartotal_egresosBodegaProducto) {
		this.activartotal_egresosBodegaProducto= activartotal_egresosBodegaProducto;
	}

	public Border setResaltartotal_provisionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltartotal_provisionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_provisionBodegaProducto() {
		return this.resaltartotal_provisionBodegaProducto;
	}

	public void setResaltartotal_provisionBodegaProducto(Border borderResaltar) {
		this.resaltartotal_provisionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrartotal_provisionBodegaProducto() {
		return this.mostrartotal_provisionBodegaProducto;
	}

	public void setMostrartotal_provisionBodegaProducto(Boolean mostrartotal_provisionBodegaProducto) {
		this.mostrartotal_provisionBodegaProducto= mostrartotal_provisionBodegaProducto;
	}

	public Boolean getActivartotal_provisionBodegaProducto() {
		return this.activartotal_provisionBodegaProducto;
	}

	public void setActivartotal_provisionBodegaProducto(Boolean activartotal_provisionBodegaProducto) {
		this.activartotal_provisionBodegaProducto= activartotal_provisionBodegaProducto;
	}

	public Border setResaltartotal_procesoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltartotal_procesoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_procesoBodegaProducto() {
		return this.resaltartotal_procesoBodegaProducto;
	}

	public void setResaltartotal_procesoBodegaProducto(Border borderResaltar) {
		this.resaltartotal_procesoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrartotal_procesoBodegaProducto() {
		return this.mostrartotal_procesoBodegaProducto;
	}

	public void setMostrartotal_procesoBodegaProducto(Boolean mostrartotal_procesoBodegaProducto) {
		this.mostrartotal_procesoBodegaProducto= mostrartotal_procesoBodegaProducto;
	}

	public Boolean getActivartotal_procesoBodegaProducto() {
		return this.activartotal_procesoBodegaProducto;
	}

	public void setActivartotal_procesoBodegaProducto(Boolean activartotal_procesoBodegaProducto) {
		this.activartotal_procesoBodegaProducto= activartotal_procesoBodegaProducto;
	}

	public Border setResaltarcosto_calculadoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarcosto_calculadoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_calculadoBodegaProducto() {
		return this.resaltarcosto_calculadoBodegaProducto;
	}

	public void setResaltarcosto_calculadoBodegaProducto(Border borderResaltar) {
		this.resaltarcosto_calculadoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarcosto_calculadoBodegaProducto() {
		return this.mostrarcosto_calculadoBodegaProducto;
	}

	public void setMostrarcosto_calculadoBodegaProducto(Boolean mostrarcosto_calculadoBodegaProducto) {
		this.mostrarcosto_calculadoBodegaProducto= mostrarcosto_calculadoBodegaProducto;
	}

	public Boolean getActivarcosto_calculadoBodegaProducto() {
		return this.activarcosto_calculadoBodegaProducto;
	}

	public void setActivarcosto_calculadoBodegaProducto(Boolean activarcosto_calculadoBodegaProducto) {
		this.activarcosto_calculadoBodegaProducto= activarcosto_calculadoBodegaProducto;
	}

	public Border setResaltardias_produccionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltardias_produccionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_produccionBodegaProducto() {
		return this.resaltardias_produccionBodegaProducto;
	}

	public void setResaltardias_produccionBodegaProducto(Border borderResaltar) {
		this.resaltardias_produccionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrardias_produccionBodegaProducto() {
		return this.mostrardias_produccionBodegaProducto;
	}

	public void setMostrardias_produccionBodegaProducto(Boolean mostrardias_produccionBodegaProducto) {
		this.mostrardias_produccionBodegaProducto= mostrardias_produccionBodegaProducto;
	}

	public Boolean getActivardias_produccionBodegaProducto() {
		return this.activardias_produccionBodegaProducto;
	}

	public void setActivardias_produccionBodegaProducto(Boolean activardias_produccionBodegaProducto) {
		this.activardias_produccionBodegaProducto= activardias_produccionBodegaProducto;
	}

	public Border setResaltarprecio_reposicionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarprecio_reposicionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_reposicionBodegaProducto() {
		return this.resaltarprecio_reposicionBodegaProducto;
	}

	public void setResaltarprecio_reposicionBodegaProducto(Border borderResaltar) {
		this.resaltarprecio_reposicionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarprecio_reposicionBodegaProducto() {
		return this.mostrarprecio_reposicionBodegaProducto;
	}

	public void setMostrarprecio_reposicionBodegaProducto(Boolean mostrarprecio_reposicionBodegaProducto) {
		this.mostrarprecio_reposicionBodegaProducto= mostrarprecio_reposicionBodegaProducto;
	}

	public Boolean getActivarprecio_reposicionBodegaProducto() {
		return this.activarprecio_reposicionBodegaProducto;
	}

	public void setActivarprecio_reposicionBodegaProducto(Boolean activarprecio_reposicionBodegaProducto) {
		this.activarprecio_reposicionBodegaProducto= activarprecio_reposicionBodegaProducto;
	}

	public Border setResaltarfecha_ultimo_pedidoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimo_pedidoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimo_pedidoBodegaProducto() {
		return this.resaltarfecha_ultimo_pedidoBodegaProducto;
	}

	public void setResaltarfecha_ultimo_pedidoBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_ultimo_pedidoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimo_pedidoBodegaProducto() {
		return this.mostrarfecha_ultimo_pedidoBodegaProducto;
	}

	public void setMostrarfecha_ultimo_pedidoBodegaProducto(Boolean mostrarfecha_ultimo_pedidoBodegaProducto) {
		this.mostrarfecha_ultimo_pedidoBodegaProducto= mostrarfecha_ultimo_pedidoBodegaProducto;
	}

	public Boolean getActivarfecha_ultimo_pedidoBodegaProducto() {
		return this.activarfecha_ultimo_pedidoBodegaProducto;
	}

	public void setActivarfecha_ultimo_pedidoBodegaProducto(Boolean activarfecha_ultimo_pedidoBodegaProducto) {
		this.activarfecha_ultimo_pedidoBodegaProducto= activarfecha_ultimo_pedidoBodegaProducto;
	}

	public Border setResaltarfecha_ingresoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ingresoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ingresoBodegaProducto() {
		return this.resaltarfecha_ingresoBodegaProducto;
	}

	public void setResaltarfecha_ingresoBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_ingresoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ingresoBodegaProducto() {
		return this.mostrarfecha_ingresoBodegaProducto;
	}

	public void setMostrarfecha_ingresoBodegaProducto(Boolean mostrarfecha_ingresoBodegaProducto) {
		this.mostrarfecha_ingresoBodegaProducto= mostrarfecha_ingresoBodegaProducto;
	}

	public Boolean getActivarfecha_ingresoBodegaProducto() {
		return this.activarfecha_ingresoBodegaProducto;
	}

	public void setActivarfecha_ingresoBodegaProducto(Boolean activarfecha_ingresoBodegaProducto) {
		this.activarfecha_ingresoBodegaProducto= activarfecha_ingresoBodegaProducto;
	}

	public Border setResaltarfecha_egresoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_egresoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_egresoBodegaProducto() {
		return this.resaltarfecha_egresoBodegaProducto;
	}

	public void setResaltarfecha_egresoBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_egresoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_egresoBodegaProducto() {
		return this.mostrarfecha_egresoBodegaProducto;
	}

	public void setMostrarfecha_egresoBodegaProducto(Boolean mostrarfecha_egresoBodegaProducto) {
		this.mostrarfecha_egresoBodegaProducto= mostrarfecha_egresoBodegaProducto;
	}

	public Boolean getActivarfecha_egresoBodegaProducto() {
		return this.activarfecha_egresoBodegaProducto;
	}

	public void setActivarfecha_egresoBodegaProducto(Boolean activarfecha_egresoBodegaProducto) {
		this.activarfecha_egresoBodegaProducto= activarfecha_egresoBodegaProducto;
	}

	public Border setResaltarfecha_ultima_compraBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_compraBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_compraBodegaProducto() {
		return this.resaltarfecha_ultima_compraBodegaProducto;
	}

	public void setResaltarfecha_ultima_compraBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_ultima_compraBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_compraBodegaProducto() {
		return this.mostrarfecha_ultima_compraBodegaProducto;
	}

	public void setMostrarfecha_ultima_compraBodegaProducto(Boolean mostrarfecha_ultima_compraBodegaProducto) {
		this.mostrarfecha_ultima_compraBodegaProducto= mostrarfecha_ultima_compraBodegaProducto;
	}

	public Boolean getActivarfecha_ultima_compraBodegaProducto() {
		return this.activarfecha_ultima_compraBodegaProducto;
	}

	public void setActivarfecha_ultima_compraBodegaProducto(Boolean activarfecha_ultima_compraBodegaProducto) {
		this.activarfecha_ultima_compraBodegaProducto= activarfecha_ultima_compraBodegaProducto;
	}

	public Border setResaltarfecha_ultima_ventaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_ventaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_ventaBodegaProducto() {
		return this.resaltarfecha_ultima_ventaBodegaProducto;
	}

	public void setResaltarfecha_ultima_ventaBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_ultima_ventaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_ventaBodegaProducto() {
		return this.mostrarfecha_ultima_ventaBodegaProducto;
	}

	public void setMostrarfecha_ultima_ventaBodegaProducto(Boolean mostrarfecha_ultima_ventaBodegaProducto) {
		this.mostrarfecha_ultima_ventaBodegaProducto= mostrarfecha_ultima_ventaBodegaProducto;
	}

	public Boolean getActivarfecha_ultima_ventaBodegaProducto() {
		return this.activarfecha_ultima_ventaBodegaProducto;
	}

	public void setActivarfecha_ultima_ventaBodegaProducto(Boolean activarfecha_ultima_ventaBodegaProducto) {
		this.activarfecha_ultima_ventaBodegaProducto= activarfecha_ultima_ventaBodegaProducto;
	}

	public Border setResaltarfecha_ultima_devolucionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_devolucionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_devolucionBodegaProducto() {
		return this.resaltarfecha_ultima_devolucionBodegaProducto;
	}

	public void setResaltarfecha_ultima_devolucionBodegaProducto(Border borderResaltar) {
		this.resaltarfecha_ultima_devolucionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_devolucionBodegaProducto() {
		return this.mostrarfecha_ultima_devolucionBodegaProducto;
	}

	public void setMostrarfecha_ultima_devolucionBodegaProducto(Boolean mostrarfecha_ultima_devolucionBodegaProducto) {
		this.mostrarfecha_ultima_devolucionBodegaProducto= mostrarfecha_ultima_devolucionBodegaProducto;
	}

	public Boolean getActivarfecha_ultima_devolucionBodegaProducto() {
		return this.activarfecha_ultima_devolucionBodegaProducto;
	}

	public void setActivarfecha_ultima_devolucionBodegaProducto(Boolean activarfecha_ultima_devolucionBodegaProducto) {
		this.activarfecha_ultima_devolucionBodegaProducto= activarfecha_ultima_devolucionBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_inventarioBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_inventarioBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_inventarioBodegaProducto() {
		return this.resaltarid_cuenta_contable_inventarioBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_inventarioBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_inventarioBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_inventarioBodegaProducto() {
		return this.mostrarid_cuenta_contable_inventarioBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_inventarioBodegaProducto(Boolean mostrarid_cuenta_contable_inventarioBodegaProducto) {
		this.mostrarid_cuenta_contable_inventarioBodegaProducto= mostrarid_cuenta_contable_inventarioBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_inventarioBodegaProducto() {
		return this.activarid_cuenta_contable_inventarioBodegaProducto;
	}

	public void setActivarid_cuenta_contable_inventarioBodegaProducto(Boolean activarid_cuenta_contable_inventarioBodegaProducto) {
		this.activarid_cuenta_contable_inventarioBodegaProducto= activarid_cuenta_contable_inventarioBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_inventarioBodegaProducto() {
		return this.cargarid_cuenta_contable_inventarioBodegaProducto;
	}

	public void setCargarid_cuenta_contable_inventarioBodegaProducto(Boolean cargarid_cuenta_contable_inventarioBodegaProducto) {
		this.cargarid_cuenta_contable_inventarioBodegaProducto= cargarid_cuenta_contable_inventarioBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_costo_ventaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_ventaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_ventaBodegaProducto() {
		return this.resaltarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_costo_ventaBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_ventaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_ventaBodegaProducto() {
		return this.mostrarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_costo_ventaBodegaProducto(Boolean mostrarid_cuenta_contable_costo_ventaBodegaProducto) {
		this.mostrarid_cuenta_contable_costo_ventaBodegaProducto= mostrarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_costo_ventaBodegaProducto() {
		return this.activarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public void setActivarid_cuenta_contable_costo_ventaBodegaProducto(Boolean activarid_cuenta_contable_costo_ventaBodegaProducto) {
		this.activarid_cuenta_contable_costo_ventaBodegaProducto= activarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_costo_ventaBodegaProducto() {
		return this.cargarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public void setCargarid_cuenta_contable_costo_ventaBodegaProducto(Boolean cargarid_cuenta_contable_costo_ventaBodegaProducto) {
		this.cargarid_cuenta_contable_costo_ventaBodegaProducto= cargarid_cuenta_contable_costo_ventaBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_ventaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaBodegaProducto() {
		return this.resaltarid_cuenta_contable_ventaBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_ventaBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaBodegaProducto() {
		return this.mostrarid_cuenta_contable_ventaBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_ventaBodegaProducto(Boolean mostrarid_cuenta_contable_ventaBodegaProducto) {
		this.mostrarid_cuenta_contable_ventaBodegaProducto= mostrarid_cuenta_contable_ventaBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_ventaBodegaProducto() {
		return this.activarid_cuenta_contable_ventaBodegaProducto;
	}

	public void setActivarid_cuenta_contable_ventaBodegaProducto(Boolean activarid_cuenta_contable_ventaBodegaProducto) {
		this.activarid_cuenta_contable_ventaBodegaProducto= activarid_cuenta_contable_ventaBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_ventaBodegaProducto() {
		return this.cargarid_cuenta_contable_ventaBodegaProducto;
	}

	public void setCargarid_cuenta_contable_ventaBodegaProducto(Boolean cargarid_cuenta_contable_ventaBodegaProducto) {
		this.cargarid_cuenta_contable_ventaBodegaProducto= cargarid_cuenta_contable_ventaBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_descuentoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoBodegaProducto() {
		return this.resaltarid_cuenta_contable_descuentoBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_descuentoBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoBodegaProducto() {
		return this.mostrarid_cuenta_contable_descuentoBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_descuentoBodegaProducto(Boolean mostrarid_cuenta_contable_descuentoBodegaProducto) {
		this.mostrarid_cuenta_contable_descuentoBodegaProducto= mostrarid_cuenta_contable_descuentoBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_descuentoBodegaProducto() {
		return this.activarid_cuenta_contable_descuentoBodegaProducto;
	}

	public void setActivarid_cuenta_contable_descuentoBodegaProducto(Boolean activarid_cuenta_contable_descuentoBodegaProducto) {
		this.activarid_cuenta_contable_descuentoBodegaProducto= activarid_cuenta_contable_descuentoBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_descuentoBodegaProducto() {
		return this.cargarid_cuenta_contable_descuentoBodegaProducto;
	}

	public void setCargarid_cuenta_contable_descuentoBodegaProducto(Boolean cargarid_cuenta_contable_descuentoBodegaProducto) {
		this.cargarid_cuenta_contable_descuentoBodegaProducto= cargarid_cuenta_contable_descuentoBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_produccionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_produccionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_produccionBodegaProducto() {
		return this.resaltarid_cuenta_contable_produccionBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_produccionBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_produccionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_produccionBodegaProducto() {
		return this.mostrarid_cuenta_contable_produccionBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_produccionBodegaProducto(Boolean mostrarid_cuenta_contable_produccionBodegaProducto) {
		this.mostrarid_cuenta_contable_produccionBodegaProducto= mostrarid_cuenta_contable_produccionBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_produccionBodegaProducto() {
		return this.activarid_cuenta_contable_produccionBodegaProducto;
	}

	public void setActivarid_cuenta_contable_produccionBodegaProducto(Boolean activarid_cuenta_contable_produccionBodegaProducto) {
		this.activarid_cuenta_contable_produccionBodegaProducto= activarid_cuenta_contable_produccionBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_produccionBodegaProducto() {
		return this.cargarid_cuenta_contable_produccionBodegaProducto;
	}

	public void setCargarid_cuenta_contable_produccionBodegaProducto(Boolean cargarid_cuenta_contable_produccionBodegaProducto) {
		this.cargarid_cuenta_contable_produccionBodegaProducto= cargarid_cuenta_contable_produccionBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_devolucionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionBodegaProducto() {
		return this.resaltarid_cuenta_contable_devolucionBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_devolucionBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionBodegaProducto() {
		return this.mostrarid_cuenta_contable_devolucionBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_devolucionBodegaProducto(Boolean mostrarid_cuenta_contable_devolucionBodegaProducto) {
		this.mostrarid_cuenta_contable_devolucionBodegaProducto= mostrarid_cuenta_contable_devolucionBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_devolucionBodegaProducto() {
		return this.activarid_cuenta_contable_devolucionBodegaProducto;
	}

	public void setActivarid_cuenta_contable_devolucionBodegaProducto(Boolean activarid_cuenta_contable_devolucionBodegaProducto) {
		this.activarid_cuenta_contable_devolucionBodegaProducto= activarid_cuenta_contable_devolucionBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_devolucionBodegaProducto() {
		return this.cargarid_cuenta_contable_devolucionBodegaProducto;
	}

	public void setCargarid_cuenta_contable_devolucionBodegaProducto(Boolean cargarid_cuenta_contable_devolucionBodegaProducto) {
		this.cargarid_cuenta_contable_devolucionBodegaProducto= cargarid_cuenta_contable_devolucionBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_ingreso_debitoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingreso_debitoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingreso_debitoBodegaProducto() {
		return this.resaltarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_ingreso_debitoBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingreso_debitoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingreso_debitoBodegaProducto() {
		return this.mostrarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_ingreso_debitoBodegaProducto(Boolean mostrarid_cuenta_contable_ingreso_debitoBodegaProducto) {
		this.mostrarid_cuenta_contable_ingreso_debitoBodegaProducto= mostrarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_ingreso_debitoBodegaProducto() {
		return this.activarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public void setActivarid_cuenta_contable_ingreso_debitoBodegaProducto(Boolean activarid_cuenta_contable_ingreso_debitoBodegaProducto) {
		this.activarid_cuenta_contable_ingreso_debitoBodegaProducto= activarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_ingreso_debitoBodegaProducto() {
		return this.cargarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public void setCargarid_cuenta_contable_ingreso_debitoBodegaProducto(Boolean cargarid_cuenta_contable_ingreso_debitoBodegaProducto) {
		this.cargarid_cuenta_contable_ingreso_debitoBodegaProducto= cargarid_cuenta_contable_ingreso_debitoBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_ingreso_creditoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingreso_creditoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingreso_creditoBodegaProducto() {
		return this.resaltarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_ingreso_creditoBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingreso_creditoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingreso_creditoBodegaProducto() {
		return this.mostrarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_ingreso_creditoBodegaProducto(Boolean mostrarid_cuenta_contable_ingreso_creditoBodegaProducto) {
		this.mostrarid_cuenta_contable_ingreso_creditoBodegaProducto= mostrarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_ingreso_creditoBodegaProducto() {
		return this.activarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public void setActivarid_cuenta_contable_ingreso_creditoBodegaProducto(Boolean activarid_cuenta_contable_ingreso_creditoBodegaProducto) {
		this.activarid_cuenta_contable_ingreso_creditoBodegaProducto= activarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_ingreso_creditoBodegaProducto() {
		return this.cargarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public void setCargarid_cuenta_contable_ingreso_creditoBodegaProducto(Boolean cargarid_cuenta_contable_ingreso_creditoBodegaProducto) {
		this.cargarid_cuenta_contable_ingreso_creditoBodegaProducto= cargarid_cuenta_contable_ingreso_creditoBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_resultado_debitoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_resultado_debitoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_resultado_debitoBodegaProducto() {
		return this.resaltarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_resultado_debitoBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_resultado_debitoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_resultado_debitoBodegaProducto() {
		return this.mostrarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_resultado_debitoBodegaProducto(Boolean mostrarid_cuenta_contable_resultado_debitoBodegaProducto) {
		this.mostrarid_cuenta_contable_resultado_debitoBodegaProducto= mostrarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_resultado_debitoBodegaProducto() {
		return this.activarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public void setActivarid_cuenta_contable_resultado_debitoBodegaProducto(Boolean activarid_cuenta_contable_resultado_debitoBodegaProducto) {
		this.activarid_cuenta_contable_resultado_debitoBodegaProducto= activarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_resultado_debitoBodegaProducto() {
		return this.cargarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public void setCargarid_cuenta_contable_resultado_debitoBodegaProducto(Boolean cargarid_cuenta_contable_resultado_debitoBodegaProducto) {
		this.cargarid_cuenta_contable_resultado_debitoBodegaProducto= cargarid_cuenta_contable_resultado_debitoBodegaProducto;
	}

	public Border setResaltarid_cuenta_contable_resultado_creditoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegaproductoBeanSwingJInternalFrame.jTtoolBarBodegaProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_resultado_creditoBodegaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_resultado_creditoBodegaProducto() {
		return this.resaltarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public void setResaltarid_cuenta_contable_resultado_creditoBodegaProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contable_resultado_creditoBodegaProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_resultado_creditoBodegaProducto() {
		return this.mostrarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public void setMostrarid_cuenta_contable_resultado_creditoBodegaProducto(Boolean mostrarid_cuenta_contable_resultado_creditoBodegaProducto) {
		this.mostrarid_cuenta_contable_resultado_creditoBodegaProducto= mostrarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public Boolean getActivarid_cuenta_contable_resultado_creditoBodegaProducto() {
		return this.activarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public void setActivarid_cuenta_contable_resultado_creditoBodegaProducto(Boolean activarid_cuenta_contable_resultado_creditoBodegaProducto) {
		this.activarid_cuenta_contable_resultado_creditoBodegaProducto= activarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public Boolean getCargarid_cuenta_contable_resultado_creditoBodegaProducto() {
		return this.cargarid_cuenta_contable_resultado_creditoBodegaProducto;
	}

	public void setCargarid_cuenta_contable_resultado_creditoBodegaProducto(Boolean cargarid_cuenta_contable_resultado_creditoBodegaProducto) {
		this.cargarid_cuenta_contable_resultado_creditoBodegaProducto= cargarid_cuenta_contable_resultado_creditoBodegaProducto;
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
		
		
		this.setMostraridBodegaProducto(esInicial);
		this.setMostrarid_empresaBodegaProducto(esInicial);
		this.setMostrarid_sucursalBodegaProducto(esInicial);
		this.setMostrarid_bodegaBodegaProducto(esInicial);
		this.setMostrarid_productoBodegaProducto(esInicial);
		this.setMostrarid_unidadBodegaProducto(esInicial);
		this.setMostrarid_centro_costoBodegaProducto(esInicial);
		this.setMostrarid_estado_bodega_productoBodegaProducto(esInicial);
		this.setMostrardescripcionBodegaProducto(esInicial);
		this.setMostrarcantidad_disponibleBodegaProducto(esInicial);
		this.setMostrarstock_maximoBodegaProducto(esInicial);
		this.setMostrarstock_minimoBodegaProducto(esInicial);
		this.setMostrarivaBodegaProducto(esInicial);
		this.setMostrariva_valorBodegaProducto(esInicial);
		this.setMostrardescuentoBodegaProducto(esInicial);
		this.setMostrardescuento_valorBodegaProducto(esInicial);
		this.setMostrariceBodegaProducto(esInicial);
		this.setMostrarice_valorBodegaProducto(esInicial);
		this.setMostrarcosto_promedioBodegaProducto(esInicial);
		this.setMostrarporcentaje_comisionBodegaProducto(esInicial);
		this.setMostrarprecioBodegaProducto(esInicial);
		this.setMostrarultimo_costoBodegaProducto(esInicial);
		this.setMostrarcostoBodegaProducto(esInicial);
		this.setMostrararancel_porcentajeBodegaProducto(esInicial);
		this.setMostrarice_porcentajeBodegaProducto(esInicial);
		this.setMostrarpesoBodegaProducto(esInicial);
		this.setMostrarcon_ivaBodegaProducto(esInicial);
		this.setMostrarcon_impuestoBodegaProducto(esInicial);
		this.setMostrarcon_iceBodegaProducto(esInicial);
		this.setMostraresta_activoBodegaProducto(esInicial);
		this.setMostrarcon_balanzaBodegaProducto(esInicial);
		this.setMostrarcantidad_pedidaBodegaProducto(esInicial);
		this.setMostrarcantidad_fisicaBodegaProducto(esInicial);
		this.setMostrarcantidad_requeridoBodegaProducto(esInicial);
		this.setMostrarprecio_costoBodegaProducto(esInicial);
		this.setMostrarprecio_promedioBodegaProducto(esInicial);
		this.setMostrartotal_ingresosBodegaProducto(esInicial);
		this.setMostrartotal_egresosBodegaProducto(esInicial);
		this.setMostrartotal_provisionBodegaProducto(esInicial);
		this.setMostrartotal_procesoBodegaProducto(esInicial);
		this.setMostrarcosto_calculadoBodegaProducto(esInicial);
		this.setMostrardias_produccionBodegaProducto(esInicial);
		this.setMostrarprecio_reposicionBodegaProducto(esInicial);
		this.setMostrarfecha_ultimo_pedidoBodegaProducto(esInicial);
		this.setMostrarfecha_ingresoBodegaProducto(esInicial);
		this.setMostrarfecha_egresoBodegaProducto(esInicial);
		this.setMostrarfecha_ultima_compraBodegaProducto(esInicial);
		this.setMostrarfecha_ultima_ventaBodegaProducto(esInicial);
		this.setMostrarfecha_ultima_devolucionBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_inventarioBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_costo_ventaBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_ventaBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_descuentoBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_produccionBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_devolucionBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_ingreso_debitoBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_ingreso_creditoBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_resultado_debitoBodegaProducto(esInicial);
		this.setMostrarid_cuenta_contable_resultado_creditoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ID)) {
				this.setMostraridBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO)) {
				this.setMostrarid_estado_bodega_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMAXIMO)) {
				this.setMostrarstock_maximoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMINIMO)) {
				this.setMostrarstock_minimoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVA)) {
				this.setMostrarivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICE)) {
				this.setMostrariceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOPROMEDIO)) {
				this.setMostrarcosto_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PORCENTAJECOMISION)) {
				this.setMostrarporcentaje_comisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIO)) {
				this.setMostrarprecioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTO)) {
				this.setMostrarcostoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setMostrararancel_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEPORCENTAJE)) {
				this.setMostrarice_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PESO)) {
				this.setMostrarpesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIVA)) {
				this.setMostrarcon_ivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIMPUESTO)) {
				this.setMostrarcon_impuestoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONICE)) {
				this.setMostrarcon_iceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONBALANZA)) {
				this.setMostrarcon_balanzaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADPEDIDA)) {
				this.setMostrarcantidad_pedidaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADFISICA)) {
				this.setMostrarcantidad_fisicaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADREQUERIDO)) {
				this.setMostrarcantidad_requeridoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOCOSTO)) {
				this.setMostrarprecio_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOPROMEDIO)) {
				this.setMostrarprecio_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALINGRESOS)) {
				this.setMostrartotal_ingresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALEGRESOS)) {
				this.setMostrartotal_egresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROVISION)) {
				this.setMostrartotal_provisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROCESO)) {
				this.setMostrartotal_procesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOCALCULADO)) {
				this.setMostrarcosto_calculadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setMostrardias_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOREPOSICION)) {
				this.setMostrarprecio_reposicionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO)) {
				this.setMostrarfecha_ultimo_pedidoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAINGRESO)) {
				this.setMostrarfecha_ingresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAEGRESO)) {
				this.setMostrarfecha_egresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setMostrarfecha_ultima_compraBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setMostrarfecha_ultima_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setMostrarfecha_ultima_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setMostrarid_cuenta_contable_inventarioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setMostrarid_cuenta_contable_costo_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setMostrarid_cuenta_contable_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO)) {
				this.setMostrarid_cuenta_contable_ingreso_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO)) {
				this.setMostrarid_cuenta_contable_ingreso_creditoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO)) {
				this.setMostrarid_cuenta_contable_resultado_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO)) {
				this.setMostrarid_cuenta_contable_resultado_creditoBodegaProducto(esAsigna);
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
		
		
		this.setActivaridBodegaProducto(esInicial);
		this.setActivarid_empresaBodegaProducto(esInicial);
		this.setActivarid_sucursalBodegaProducto(esInicial);
		this.setActivarid_bodegaBodegaProducto(esInicial);
		this.setActivarid_productoBodegaProducto(esInicial);
		this.setActivarid_unidadBodegaProducto(esInicial);
		this.setActivarid_centro_costoBodegaProducto(esInicial);
		this.setActivarid_estado_bodega_productoBodegaProducto(esInicial);
		this.setActivardescripcionBodegaProducto(esInicial);
		this.setActivarcantidad_disponibleBodegaProducto(esInicial);
		this.setActivarstock_maximoBodegaProducto(esInicial);
		this.setActivarstock_minimoBodegaProducto(esInicial);
		this.setActivarivaBodegaProducto(esInicial);
		this.setActivariva_valorBodegaProducto(esInicial);
		this.setActivardescuentoBodegaProducto(esInicial);
		this.setActivardescuento_valorBodegaProducto(esInicial);
		this.setActivariceBodegaProducto(esInicial);
		this.setActivarice_valorBodegaProducto(esInicial);
		this.setActivarcosto_promedioBodegaProducto(esInicial);
		this.setActivarporcentaje_comisionBodegaProducto(esInicial);
		this.setActivarprecioBodegaProducto(esInicial);
		this.setActivarultimo_costoBodegaProducto(esInicial);
		this.setActivarcostoBodegaProducto(esInicial);
		this.setActivararancel_porcentajeBodegaProducto(esInicial);
		this.setActivarice_porcentajeBodegaProducto(esInicial);
		this.setActivarpesoBodegaProducto(esInicial);
		this.setActivarcon_ivaBodegaProducto(esInicial);
		this.setActivarcon_impuestoBodegaProducto(esInicial);
		this.setActivarcon_iceBodegaProducto(esInicial);
		this.setActivaresta_activoBodegaProducto(esInicial);
		this.setActivarcon_balanzaBodegaProducto(esInicial);
		this.setActivarcantidad_pedidaBodegaProducto(esInicial);
		this.setActivarcantidad_fisicaBodegaProducto(esInicial);
		this.setActivarcantidad_requeridoBodegaProducto(esInicial);
		this.setActivarprecio_costoBodegaProducto(esInicial);
		this.setActivarprecio_promedioBodegaProducto(esInicial);
		this.setActivartotal_ingresosBodegaProducto(esInicial);
		this.setActivartotal_egresosBodegaProducto(esInicial);
		this.setActivartotal_provisionBodegaProducto(esInicial);
		this.setActivartotal_procesoBodegaProducto(esInicial);
		this.setActivarcosto_calculadoBodegaProducto(esInicial);
		this.setActivardias_produccionBodegaProducto(esInicial);
		this.setActivarprecio_reposicionBodegaProducto(esInicial);
		this.setActivarfecha_ultimo_pedidoBodegaProducto(esInicial);
		this.setActivarfecha_ingresoBodegaProducto(esInicial);
		this.setActivarfecha_egresoBodegaProducto(esInicial);
		this.setActivarfecha_ultima_compraBodegaProducto(esInicial);
		this.setActivarfecha_ultima_ventaBodegaProducto(esInicial);
		this.setActivarfecha_ultima_devolucionBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_inventarioBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_costo_ventaBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_ventaBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_descuentoBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_produccionBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_devolucionBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_ingreso_debitoBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_ingreso_creditoBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_resultado_debitoBodegaProducto(esInicial);
		this.setActivarid_cuenta_contable_resultado_creditoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ID)) {
				this.setActivaridBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO)) {
				this.setActivarid_estado_bodega_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMAXIMO)) {
				this.setActivarstock_maximoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMINIMO)) {
				this.setActivarstock_minimoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVA)) {
				this.setActivarivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICE)) {
				this.setActivariceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOPROMEDIO)) {
				this.setActivarcosto_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PORCENTAJECOMISION)) {
				this.setActivarporcentaje_comisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIO)) {
				this.setActivarprecioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTO)) {
				this.setActivarcostoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setActivararancel_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEPORCENTAJE)) {
				this.setActivarice_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PESO)) {
				this.setActivarpesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIVA)) {
				this.setActivarcon_ivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIMPUESTO)) {
				this.setActivarcon_impuestoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONICE)) {
				this.setActivarcon_iceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONBALANZA)) {
				this.setActivarcon_balanzaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADPEDIDA)) {
				this.setActivarcantidad_pedidaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADFISICA)) {
				this.setActivarcantidad_fisicaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADREQUERIDO)) {
				this.setActivarcantidad_requeridoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOCOSTO)) {
				this.setActivarprecio_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOPROMEDIO)) {
				this.setActivarprecio_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALINGRESOS)) {
				this.setActivartotal_ingresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALEGRESOS)) {
				this.setActivartotal_egresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROVISION)) {
				this.setActivartotal_provisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROCESO)) {
				this.setActivartotal_procesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOCALCULADO)) {
				this.setActivarcosto_calculadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setActivardias_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOREPOSICION)) {
				this.setActivarprecio_reposicionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO)) {
				this.setActivarfecha_ultimo_pedidoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAINGRESO)) {
				this.setActivarfecha_ingresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAEGRESO)) {
				this.setActivarfecha_egresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setActivarfecha_ultima_compraBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setActivarfecha_ultima_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setActivarfecha_ultima_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setActivarid_cuenta_contable_inventarioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setActivarid_cuenta_contable_costo_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setActivarid_cuenta_contable_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO)) {
				this.setActivarid_cuenta_contable_ingreso_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO)) {
				this.setActivarid_cuenta_contable_ingreso_creditoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO)) {
				this.setActivarid_cuenta_contable_resultado_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO)) {
				this.setActivarid_cuenta_contable_resultado_creditoBodegaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBodegaProducto(esInicial);
		this.setResaltarid_empresaBodegaProducto(esInicial);
		this.setResaltarid_sucursalBodegaProducto(esInicial);
		this.setResaltarid_bodegaBodegaProducto(esInicial);
		this.setResaltarid_productoBodegaProducto(esInicial);
		this.setResaltarid_unidadBodegaProducto(esInicial);
		this.setResaltarid_centro_costoBodegaProducto(esInicial);
		this.setResaltarid_estado_bodega_productoBodegaProducto(esInicial);
		this.setResaltardescripcionBodegaProducto(esInicial);
		this.setResaltarcantidad_disponibleBodegaProducto(esInicial);
		this.setResaltarstock_maximoBodegaProducto(esInicial);
		this.setResaltarstock_minimoBodegaProducto(esInicial);
		this.setResaltarivaBodegaProducto(esInicial);
		this.setResaltariva_valorBodegaProducto(esInicial);
		this.setResaltardescuentoBodegaProducto(esInicial);
		this.setResaltardescuento_valorBodegaProducto(esInicial);
		this.setResaltariceBodegaProducto(esInicial);
		this.setResaltarice_valorBodegaProducto(esInicial);
		this.setResaltarcosto_promedioBodegaProducto(esInicial);
		this.setResaltarporcentaje_comisionBodegaProducto(esInicial);
		this.setResaltarprecioBodegaProducto(esInicial);
		this.setResaltarultimo_costoBodegaProducto(esInicial);
		this.setResaltarcostoBodegaProducto(esInicial);
		this.setResaltararancel_porcentajeBodegaProducto(esInicial);
		this.setResaltarice_porcentajeBodegaProducto(esInicial);
		this.setResaltarpesoBodegaProducto(esInicial);
		this.setResaltarcon_ivaBodegaProducto(esInicial);
		this.setResaltarcon_impuestoBodegaProducto(esInicial);
		this.setResaltarcon_iceBodegaProducto(esInicial);
		this.setResaltaresta_activoBodegaProducto(esInicial);
		this.setResaltarcon_balanzaBodegaProducto(esInicial);
		this.setResaltarcantidad_pedidaBodegaProducto(esInicial);
		this.setResaltarcantidad_fisicaBodegaProducto(esInicial);
		this.setResaltarcantidad_requeridoBodegaProducto(esInicial);
		this.setResaltarprecio_costoBodegaProducto(esInicial);
		this.setResaltarprecio_promedioBodegaProducto(esInicial);
		this.setResaltartotal_ingresosBodegaProducto(esInicial);
		this.setResaltartotal_egresosBodegaProducto(esInicial);
		this.setResaltartotal_provisionBodegaProducto(esInicial);
		this.setResaltartotal_procesoBodegaProducto(esInicial);
		this.setResaltarcosto_calculadoBodegaProducto(esInicial);
		this.setResaltardias_produccionBodegaProducto(esInicial);
		this.setResaltarprecio_reposicionBodegaProducto(esInicial);
		this.setResaltarfecha_ultimo_pedidoBodegaProducto(esInicial);
		this.setResaltarfecha_ingresoBodegaProducto(esInicial);
		this.setResaltarfecha_egresoBodegaProducto(esInicial);
		this.setResaltarfecha_ultima_compraBodegaProducto(esInicial);
		this.setResaltarfecha_ultima_ventaBodegaProducto(esInicial);
		this.setResaltarfecha_ultima_devolucionBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_inventarioBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_costo_ventaBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_ventaBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_descuentoBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_produccionBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_devolucionBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_ingreso_debitoBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_ingreso_creditoBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_resultado_debitoBodegaProducto(esInicial);
		this.setResaltarid_cuenta_contable_resultado_creditoBodegaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ID)) {
				this.setResaltaridBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO)) {
				this.setResaltarid_estado_bodega_productoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMAXIMO)) {
				this.setResaltarstock_maximoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.STOCKMINIMO)) {
				this.setResaltarstock_minimoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVA)) {
				this.setResaltarivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICE)) {
				this.setResaltariceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOPROMEDIO)) {
				this.setResaltarcosto_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PORCENTAJECOMISION)) {
				this.setResaltarporcentaje_comisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIO)) {
				this.setResaltarprecioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTO)) {
				this.setResaltarcostoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setResaltararancel_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ICEPORCENTAJE)) {
				this.setResaltarice_porcentajeBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PESO)) {
				this.setResaltarpesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIVA)) {
				this.setResaltarcon_ivaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONIMPUESTO)) {
				this.setResaltarcon_impuestoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONICE)) {
				this.setResaltarcon_iceBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CONBALANZA)) {
				this.setResaltarcon_balanzaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADPEDIDA)) {
				this.setResaltarcantidad_pedidaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADFISICA)) {
				this.setResaltarcantidad_fisicaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.CANTIDADREQUERIDO)) {
				this.setResaltarcantidad_requeridoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOCOSTO)) {
				this.setResaltarprecio_costoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOPROMEDIO)) {
				this.setResaltarprecio_promedioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALINGRESOS)) {
				this.setResaltartotal_ingresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALEGRESOS)) {
				this.setResaltartotal_egresosBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROVISION)) {
				this.setResaltartotal_provisionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.TOTALPROCESO)) {
				this.setResaltartotal_procesoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.COSTOCALCULADO)) {
				this.setResaltarcosto_calculadoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setResaltardias_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.PRECIOREPOSICION)) {
				this.setResaltarprecio_reposicionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO)) {
				this.setResaltarfecha_ultimo_pedidoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAINGRESO)) {
				this.setResaltarfecha_ingresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAEGRESO)) {
				this.setResaltarfecha_egresoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setResaltarfecha_ultima_compraBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setResaltarfecha_ultima_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setResaltarfecha_ultima_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO)) {
				this.setResaltarid_cuenta_contable_inventarioBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA)) {
				this.setResaltarid_cuenta_contable_costo_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION)) {
				this.setResaltarid_cuenta_contable_produccionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO)) {
				this.setResaltarid_cuenta_contable_ingreso_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO)) {
				this.setResaltarid_cuenta_contable_ingreso_creditoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO)) {
				this.setResaltarid_cuenta_contable_resultado_debitoBodegaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO)) {
				this.setResaltarid_cuenta_contable_resultado_creditoBodegaProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaBodegaProducto=true;

	public Boolean getMostrarFK_IdBodegaBodegaProducto() {
		return this.mostrarFK_IdBodegaBodegaProducto;
	}

	public void setMostrarFK_IdBodegaBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoBodegaProducto=true;

	public Boolean getMostrarFK_IdCentroCostoBodegaProducto() {
		return this.mostrarFK_IdCentroCostoBodegaProducto;
	}

	public void setMostrarFK_IdCentroCostoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoVentaBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableCostoVentaBodegaProducto() {
		return this.mostrarFK_IdCuentaContableCostoVentaBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableCostoVentaBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoVentaBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngresoCreditoBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableIngresoCreditoBodegaProducto() {
		return this.mostrarFK_IdCuentaContableIngresoCreditoBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableIngresoCreditoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngresoCreditoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngresoDebitoBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableIngresoDebitoBodegaProducto() {
		return this.mostrarFK_IdCuentaContableIngresoDebitoBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableIngresoDebitoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngresoDebitoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableProduccionBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableProduccionBodegaProducto() {
		return this.mostrarFK_IdCuentaContableProduccionBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableProduccionBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableProduccionBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableResultadoCreditoBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableResultadoCreditoBodegaProducto() {
		return this.mostrarFK_IdCuentaContableResultadoCreditoBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableResultadoCreditoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableResultadoCreditoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableResultadoDebitoBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableResultadoDebitoBodegaProducto() {
		return this.mostrarFK_IdCuentaContableResultadoDebitoBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableResultadoDebitoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableResultadoDebitoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableVentaBodegaProducto=true;

	public Boolean getMostrarFK_IdCuentaContableVentaBodegaProducto() {
		return this.mostrarFK_IdCuentaContableVentaBodegaProducto;
	}

	public void setMostrarFK_IdCuentaContableVentaBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableVentaBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBodegaProducto=true;

	public Boolean getMostrarFK_IdEmpresaBodegaProducto() {
		return this.mostrarFK_IdEmpresaBodegaProducto;
	}

	public void setMostrarFK_IdEmpresaBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoBodegaProducto=true;

	public Boolean getMostrarFK_IdProductoBodegaProducto() {
		return this.mostrarFK_IdProductoBodegaProducto;
	}

	public void setMostrarFK_IdProductoBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalBodegaProducto=true;

	public Boolean getMostrarFK_IdSucursalBodegaProducto() {
		return this.mostrarFK_IdSucursalBodegaProducto;
	}

	public void setMostrarFK_IdSucursalBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalBodegaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadBodegaProducto=true;

	public Boolean getMostrarFK_IdUnidadBodegaProducto() {
		return this.mostrarFK_IdUnidadBodegaProducto;
	}

	public void setMostrarFK_IdUnidadBodegaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadBodegaProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaBodegaProducto=true;

	public Boolean getActivarFK_IdBodegaBodegaProducto() {
		return this.activarFK_IdBodegaBodegaProducto;
	}

	public void setActivarFK_IdBodegaBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoBodegaProducto=true;

	public Boolean getActivarFK_IdCentroCostoBodegaProducto() {
		return this.activarFK_IdCentroCostoBodegaProducto;
	}

	public void setActivarFK_IdCentroCostoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoVentaBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableCostoVentaBodegaProducto() {
		return this.activarFK_IdCuentaContableCostoVentaBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableCostoVentaBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoVentaBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngresoCreditoBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableIngresoCreditoBodegaProducto() {
		return this.activarFK_IdCuentaContableIngresoCreditoBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableIngresoCreditoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngresoCreditoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngresoDebitoBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableIngresoDebitoBodegaProducto() {
		return this.activarFK_IdCuentaContableIngresoDebitoBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableIngresoDebitoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngresoDebitoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableProduccionBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableProduccionBodegaProducto() {
		return this.activarFK_IdCuentaContableProduccionBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableProduccionBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableProduccionBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableResultadoCreditoBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableResultadoCreditoBodegaProducto() {
		return this.activarFK_IdCuentaContableResultadoCreditoBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableResultadoCreditoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableResultadoCreditoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableResultadoDebitoBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableResultadoDebitoBodegaProducto() {
		return this.activarFK_IdCuentaContableResultadoDebitoBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableResultadoDebitoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableResultadoDebitoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableVentaBodegaProducto=true;

	public Boolean getActivarFK_IdCuentaContableVentaBodegaProducto() {
		return this.activarFK_IdCuentaContableVentaBodegaProducto;
	}

	public void setActivarFK_IdCuentaContableVentaBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableVentaBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBodegaProducto=true;

	public Boolean getActivarFK_IdEmpresaBodegaProducto() {
		return this.activarFK_IdEmpresaBodegaProducto;
	}

	public void setActivarFK_IdEmpresaBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoBodegaProducto=true;

	public Boolean getActivarFK_IdProductoBodegaProducto() {
		return this.activarFK_IdProductoBodegaProducto;
	}

	public void setActivarFK_IdProductoBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalBodegaProducto=true;

	public Boolean getActivarFK_IdSucursalBodegaProducto() {
		return this.activarFK_IdSucursalBodegaProducto;
	}

	public void setActivarFK_IdSucursalBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalBodegaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadBodegaProducto=true;

	public Boolean getActivarFK_IdUnidadBodegaProducto() {
		return this.activarFK_IdUnidadBodegaProducto;
	}

	public void setActivarFK_IdUnidadBodegaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadBodegaProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaBodegaProducto=null;

	public Border getResaltarFK_IdBodegaBodegaProducto() {
		return this.resaltarFK_IdBodegaBodegaProducto;
	}

	public void setResaltarFK_IdBodegaBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoBodegaProducto=null;

	public Border getResaltarFK_IdCentroCostoBodegaProducto() {
		return this.resaltarFK_IdCentroCostoBodegaProducto;
	}

	public void setResaltarFK_IdCentroCostoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoVentaBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableCostoVentaBodegaProducto() {
		return this.resaltarFK_IdCuentaContableCostoVentaBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableCostoVentaBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoVentaBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoVentaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoVentaBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngresoCreditoBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableIngresoCreditoBodegaProducto() {
		return this.resaltarFK_IdCuentaContableIngresoCreditoBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableIngresoCreditoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngresoCreditoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngresoCreditoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngresoCreditoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngresoDebitoBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableIngresoDebitoBodegaProducto() {
		return this.resaltarFK_IdCuentaContableIngresoDebitoBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableIngresoDebitoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngresoDebitoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngresoDebitoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngresoDebitoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableProduccionBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableProduccionBodegaProducto() {
		return this.resaltarFK_IdCuentaContableProduccionBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableProduccionBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableProduccionBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableProduccionBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableProduccionBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableResultadoCreditoBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableResultadoCreditoBodegaProducto() {
		return this.resaltarFK_IdCuentaContableResultadoCreditoBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableResultadoCreditoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableResultadoCreditoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableResultadoCreditoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableResultadoCreditoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableResultadoDebitoBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableResultadoDebitoBodegaProducto() {
		return this.resaltarFK_IdCuentaContableResultadoDebitoBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableResultadoDebitoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableResultadoDebitoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableResultadoDebitoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableResultadoDebitoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableVentaBodegaProducto=null;

	public Border getResaltarFK_IdCuentaContableVentaBodegaProducto() {
		return this.resaltarFK_IdCuentaContableVentaBodegaProducto;
	}

	public void setResaltarFK_IdCuentaContableVentaBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableVentaBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableVentaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableVentaBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBodegaProducto=null;

	public Border getResaltarFK_IdEmpresaBodegaProducto() {
		return this.resaltarFK_IdEmpresaBodegaProducto;
	}

	public void setResaltarFK_IdEmpresaBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoBodegaProducto=null;

	public Border getResaltarFK_IdProductoBodegaProducto() {
		return this.resaltarFK_IdProductoBodegaProducto;
	}

	public void setResaltarFK_IdProductoBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalBodegaProducto=null;

	public Border getResaltarFK_IdSucursalBodegaProducto() {
		return this.resaltarFK_IdSucursalBodegaProducto;
	}

	public void setResaltarFK_IdSucursalBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalBodegaProducto= borderResaltar;
	}

	public Border resaltarFK_IdUnidadBodegaProducto=null;

	public Border getResaltarFK_IdUnidadBodegaProducto() {
		return this.resaltarFK_IdUnidadBodegaProducto;
	}

	public void setResaltarFK_IdUnidadBodegaProducto(Border borderResaltar) {
		this.resaltarFK_IdUnidadBodegaProducto= borderResaltar;
	}

	public void setResaltarFK_IdUnidadBodegaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaProductoBeanSwingJInternalFrame bodegaproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadBodegaProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}