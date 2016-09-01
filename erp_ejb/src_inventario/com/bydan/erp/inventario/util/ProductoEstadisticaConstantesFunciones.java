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


import com.bydan.erp.inventario.util.ProductoEstadisticaConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoEstadisticaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoEstadisticaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoEstadisticaConstantesFunciones extends ProductoEstadisticaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProductoEstadistica";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductoEstadistica"+ProductoEstadisticaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoEstadisticaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoEstadisticaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoEstadisticaConstantesFunciones.SCHEMA+"_"+ProductoEstadisticaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoEstadisticaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoEstadisticaConstantesFunciones.SCHEMA+"_"+ProductoEstadisticaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoEstadisticaConstantesFunciones.SCHEMA+"_"+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoEstadisticaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoEstadisticaConstantesFunciones.SCHEMA+"_"+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoEstadisticaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoEstadisticaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoEstadisticaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoEstadisticaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoEstadisticaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoEstadisticaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoEstadisticaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estadisticas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estadistica";
	public static final String SCLASSWEBTITULO_LOWER="Producto Estadistica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductoEstadistica";
	public static final String OBJECTNAME="productoestadistica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto_estadistica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productoestadistica from "+ProductoEstadisticaConstantesFunciones.SPERSISTENCENAME+" productoestadistica";
	public static String QUERYSELECTNATIVE="select "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".version_row,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_empresa,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_bodega,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_producto,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_cotizacion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_proforma,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_disponible,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_reservada,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_demanda,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_maximo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_minimo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_fisica,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_orden_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_pedida,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_requisicion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_ingreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_egreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_produccion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_devolucion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_orden_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_pedido,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_requisicion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_ingreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_egreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_producido,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_devuelto,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_ultimo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_total,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_produccion from "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME;//+" as "+ProductoEstadisticaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoEstadisticaConstantesFuncionesAdditional productoestadisticaConstantesFuncionesAdditional=null;
	
	public ProductoEstadisticaConstantesFuncionesAdditional getProductoEstadisticaConstantesFuncionesAdditional() {
		return this.productoestadisticaConstantesFuncionesAdditional;
	}
	
	public void setProductoEstadisticaConstantesFuncionesAdditional(ProductoEstadisticaConstantesFuncionesAdditional productoestadisticaConstantesFuncionesAdditional) {
		try {
			this.productoestadisticaConstantesFuncionesAdditional=productoestadisticaConstantesFuncionesAdditional;
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
    public static final String PRECIOULTIMACOMPRA= "precio_ultima_compra";
    public static final String PRECIOULTIMAVENTA= "precio_ultima_venta";
    public static final String PRECIOULTIMACOTIZACION= "precio_ultima_cotizacion";
    public static final String PRECIOULTIMAPROFORMA= "precio_ultima_proforma";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String CANTIDADRESERVADA= "cantidad_reservada";
    public static final String CANTIDADDEMANDA= "cantidad_demanda";
    public static final String CANTIDADMAXIMO= "cantidad_maximo";
    public static final String CANTIDADMINIMO= "cantidad_minimo";
    public static final String CANTIDADFISICA= "cantidad_fisica";
    public static final String CANTIDADORDENCOMPRA= "cantidad_orden_compra";
    public static final String CANTIDADPEDIDA= "cantidad_pedida";
    public static final String CANTIDADREQUISICION= "cantidad_requisicion";
    public static final String FECHAULTIMAINGRESO= "fecha_ultima_ingreso";
    public static final String FECHAULTIMAEGRESO= "fecha_ultima_egreso";
    public static final String FECHAULTIMAPRODUCCION= "fecha_ultima_produccion";
    public static final String FECHAULTIMACOMPRA= "fecha_ultima_compra";
    public static final String FECHAULTIMAVENTA= "fecha_ultima_venta";
    public static final String FECHAULTIMADEVOLUCION= "fecha_ultima_devolucion";
    public static final String FECHAULTIMAORDENCOMPRA= "fecha_ultima_orden_compra";
    public static final String FECHAULTIMAPEDIDO= "fecha_ultima_pedido";
    public static final String FECHAULTIMAREQUISICION= "fecha_ultima_requisicion";
    public static final String TOTALINGRESO= "total_ingreso";
    public static final String TOTALEGRESO= "total_egreso";
    public static final String TOTALCOMPRA= "total_compra";
    public static final String TOTALVENTA= "total_venta";
    public static final String TOTALPRODUCIDO= "total_producido";
    public static final String TOTALDEVUELTO= "total_devuelto";
    public static final String COSTOULTIMO= "costo_ultimo";
    public static final String COSTOTOTAL= "costo_total";
    public static final String COSTOPRODUCCION= "costo_produccion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_PRECIOULTIMACOMPRA= "Precio Ultima Compra";
		public static final String LABEL_PRECIOULTIMACOMPRA_LOWER= "Precio Ultima Compra";
    	public static final String LABEL_PRECIOULTIMAVENTA= "Precio Ultima Venta";
		public static final String LABEL_PRECIOULTIMAVENTA_LOWER= "Precio Ultima Venta";
    	public static final String LABEL_PRECIOULTIMACOTIZACION= "Precio Ultima Cotizacion";
		public static final String LABEL_PRECIOULTIMACOTIZACION_LOWER= "Precio Ultima Cotizacion";
    	public static final String LABEL_PRECIOULTIMAPROFORMA= "Precio Ultima Proforma";
		public static final String LABEL_PRECIOULTIMAPROFORMA_LOWER= "Precio Ultima Proforma";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantidad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_CANTIDADRESERVADA= "Cantidad Reservada";
		public static final String LABEL_CANTIDADRESERVADA_LOWER= "Cantidad Reservada";
    	public static final String LABEL_CANTIDADDEMANDA= "Cantidad Demanda";
		public static final String LABEL_CANTIDADDEMANDA_LOWER= "Cantidad Demanda";
    	public static final String LABEL_CANTIDADMAXIMO= "Cantidad Maximo";
		public static final String LABEL_CANTIDADMAXIMO_LOWER= "Cantidad Maximo";
    	public static final String LABEL_CANTIDADMINIMO= "Cantidad Minimo";
		public static final String LABEL_CANTIDADMINIMO_LOWER= "Cantidad Minimo";
    	public static final String LABEL_CANTIDADFISICA= "Cantidad Fisica";
		public static final String LABEL_CANTIDADFISICA_LOWER= "Cantidad Fisica";
    	public static final String LABEL_CANTIDADORDENCOMPRA= "Cantidad Orden Compra";
		public static final String LABEL_CANTIDADORDENCOMPRA_LOWER= "Cantidad Orden Compra";
    	public static final String LABEL_CANTIDADPEDIDA= "Cantidad Pedida";
		public static final String LABEL_CANTIDADPEDIDA_LOWER= "Cantidad Pedida";
    	public static final String LABEL_CANTIDADREQUISICION= "Cantidad Requisicion";
		public static final String LABEL_CANTIDADREQUISICION_LOWER= "Cantidad Requisicion";
    	public static final String LABEL_FECHAULTIMAINGRESO= "Fecha Ultima Ingreso";
		public static final String LABEL_FECHAULTIMAINGRESO_LOWER= "Fecha Ultima Ingreso";
    	public static final String LABEL_FECHAULTIMAEGRESO= "Fecha Ultima Egreso";
		public static final String LABEL_FECHAULTIMAEGRESO_LOWER= "Fecha Ultima Egreso";
    	public static final String LABEL_FECHAULTIMAPRODUCCION= "Fecha Ultima Produccion";
		public static final String LABEL_FECHAULTIMAPRODUCCION_LOWER= "Fecha Ultima Produccion";
    	public static final String LABEL_FECHAULTIMACOMPRA= "Fecha Ultima Compra";
		public static final String LABEL_FECHAULTIMACOMPRA_LOWER= "Fecha Ultima Compra";
    	public static final String LABEL_FECHAULTIMAVENTA= "Fecha Ultima Venta";
		public static final String LABEL_FECHAULTIMAVENTA_LOWER= "Fecha Ultima Venta";
    	public static final String LABEL_FECHAULTIMADEVOLUCION= "Fecha Ultima Devolucion";
		public static final String LABEL_FECHAULTIMADEVOLUCION_LOWER= "Fecha Ultima Devolucion";
    	public static final String LABEL_FECHAULTIMAORDENCOMPRA= "Fecha Ultima Orden Compra";
		public static final String LABEL_FECHAULTIMAORDENCOMPRA_LOWER= "Fecha Ultima Orden Compra";
    	public static final String LABEL_FECHAULTIMAPEDIDO= "Fecha Ultima Pedido";
		public static final String LABEL_FECHAULTIMAPEDIDO_LOWER= "Fecha Ultima Pedido";
    	public static final String LABEL_FECHAULTIMAREQUISICION= "Fecha Ultima Requisicion";
		public static final String LABEL_FECHAULTIMAREQUISICION_LOWER= "Fecha Ultima Requisicion";
    	public static final String LABEL_TOTALINGRESO= "Total Ingreso";
		public static final String LABEL_TOTALINGRESO_LOWER= "Total Ingreso";
    	public static final String LABEL_TOTALEGRESO= "Total Egreso";
		public static final String LABEL_TOTALEGRESO_LOWER= "Total Egreso";
    	public static final String LABEL_TOTALCOMPRA= "Total Compra";
		public static final String LABEL_TOTALCOMPRA_LOWER= "Total Compra";
    	public static final String LABEL_TOTALVENTA= "Total Venta";
		public static final String LABEL_TOTALVENTA_LOWER= "Total Venta";
    	public static final String LABEL_TOTALPRODUCIDO= "Total Producido";
		public static final String LABEL_TOTALPRODUCIDO_LOWER= "Total Producido";
    	public static final String LABEL_TOTALDEVUELTO= "Total Devuelto";
		public static final String LABEL_TOTALDEVUELTO_LOWER= "Total Devuelto";
    	public static final String LABEL_COSTOULTIMO= "Costo Ultimo";
		public static final String LABEL_COSTOULTIMO_LOWER= "Costo Ultimo";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_COSTOPRODUCCION= "Costo Produccion";
		public static final String LABEL_COSTOPRODUCCION_LOWER= "Costo Produccion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getProductoEstadisticaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMAXIMO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMINIMO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADFISICA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAINGRESO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAEGRESO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPRODUCCION;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMACOMPRA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAVENTA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAORDENCOMPRA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPEDIDO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAREQUISICION;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALINGRESO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALEGRESO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALCOMPRA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALVENTA)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.COSTOULTIMO)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION)) {sLabelColumna=ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoEstadisticaDescripcion(ProductoEstadistica productoestadistica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productoestadistica !=null/* && productoestadistica.getId()!=0*/) {
			if(productoestadistica.getId()!=null) {
				sDescripcion=productoestadistica.getId().toString();
			}//productoestadisticaproductoestadistica.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoEstadisticaDescripcionDetallado(ProductoEstadistica productoestadistica) {
		String sDescripcion="";
			
		sDescripcion+=ProductoEstadisticaConstantesFunciones.ID+"=";
		sDescripcion+=productoestadistica.getId().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productoestadistica.getVersionRow().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productoestadistica.getid_empresa().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productoestadistica.getid_sucursal().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productoestadistica.getid_bodega().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productoestadistica.getid_producto().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA+"=";
		sDescripcion+=productoestadistica.getprecio_ultima_compra().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA+"=";
		sDescripcion+=productoestadistica.getprecio_ultima_venta().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION+"=";
		sDescripcion+=productoestadistica.getprecio_ultima_cotizacion().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA+"=";
		sDescripcion+=productoestadistica.getprecio_ultima_proforma().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=productoestadistica.getcantidad_disponible().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA+"=";
		sDescripcion+=productoestadistica.getcantidad_reservada().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA+"=";
		sDescripcion+=productoestadistica.getcantidad_demanda().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO+"=";
		sDescripcion+=productoestadistica.getcantidad_maximo().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO+"=";
		sDescripcion+=productoestadistica.getcantidad_minimo().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADFISICA+"=";
		sDescripcion+=productoestadistica.getcantidad_fisica().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA+"=";
		sDescripcion+=productoestadistica.getcantidad_orden_compra().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA+"=";
		sDescripcion+=productoestadistica.getcantidad_pedida().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION+"=";
		sDescripcion+=productoestadistica.getcantidad_requisicion().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_ingreso().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_egreso().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_produccion().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_compra().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_venta().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_devolucion().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_orden_compra().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_pedido().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION+"=";
		sDescripcion+=productoestadistica.getfecha_ultima_requisicion().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALINGRESO+"=";
		sDescripcion+=productoestadistica.gettotal_ingreso().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALEGRESO+"=";
		sDescripcion+=productoestadistica.gettotal_egreso().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALCOMPRA+"=";
		sDescripcion+=productoestadistica.gettotal_compra().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALVENTA+"=";
		sDescripcion+=productoestadistica.gettotal_venta().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO+"=";
		sDescripcion+=productoestadistica.gettotal_producido().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO+"=";
		sDescripcion+=productoestadistica.gettotal_devuelto().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.COSTOULTIMO+"=";
		sDescripcion+=productoestadistica.getcosto_ultimo().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=productoestadistica.getcosto_total().toString()+",";
		sDescripcion+=ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION+"=";
		sDescripcion+=productoestadistica.getcosto_produccion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoEstadisticaDescripcion(ProductoEstadistica productoestadistica,String sValor) throws Exception {			
		if(productoestadistica !=null) {
			//productoestadisticaproductoestadistica.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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
	
	
	
	
	
	
	public static void quitarEspaciosProductoEstadistica(ProductoEstadistica productoestadistica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProductoEstadisticas(List<ProductoEstadistica> productoestadisticas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoEstadistica productoestadistica: productoestadisticas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoEstadistica(ProductoEstadistica productoestadistica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productoestadistica.getConCambioAuxiliar()) {
			productoestadistica.setIsDeleted(productoestadistica.getIsDeletedAuxiliar());	
			productoestadistica.setIsNew(productoestadistica.getIsNewAuxiliar());	
			productoestadistica.setIsChanged(productoestadistica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productoestadistica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productoestadistica.setIsDeletedAuxiliar(false);	
			productoestadistica.setIsNewAuxiliar(false);	
			productoestadistica.setIsChangedAuxiliar(false);
			
			productoestadistica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductoEstadisticas(List<ProductoEstadistica> productoestadisticas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductoEstadistica productoestadistica : productoestadisticas) {
			if(conAsignarBase && productoestadistica.getConCambioAuxiliar()) {
				productoestadistica.setIsDeleted(productoestadistica.getIsDeletedAuxiliar());	
				productoestadistica.setIsNew(productoestadistica.getIsNewAuxiliar());	
				productoestadistica.setIsChanged(productoestadistica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productoestadistica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productoestadistica.setIsDeletedAuxiliar(false);	
				productoestadistica.setIsNewAuxiliar(false);	
				productoestadistica.setIsChangedAuxiliar(false);
				
				productoestadistica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductoEstadistica(ProductoEstadistica productoestadistica,Boolean conEnteros) throws Exception  {
		productoestadistica.setprecio_ultima_compra(0.0);
		productoestadistica.setprecio_ultima_venta(0.0);
		productoestadistica.setprecio_ultima_cotizacion(0.0);
		productoestadistica.setprecio_ultima_proforma(0.0);
		productoestadistica.setcantidad_reservada(0.0);
		productoestadistica.setcantidad_demanda(0.0);
		productoestadistica.setcantidad_fisica(0.0);
		productoestadistica.setcantidad_orden_compra(0.0);
		productoestadistica.setcantidad_pedida(0.0);
		productoestadistica.setcantidad_requisicion(0.0);
		productoestadistica.settotal_ingreso(0.0);
		productoestadistica.settotal_egreso(0.0);
		productoestadistica.settotal_compra(0.0);
		productoestadistica.settotal_venta(0.0);
		productoestadistica.settotal_producido(0.0);
		productoestadistica.settotal_devuelto(0.0);
		productoestadistica.setcosto_ultimo(0.0);
		productoestadistica.setcosto_total(0.0);
		productoestadistica.setcosto_produccion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productoestadistica.setcantidad_disponible(0);
			productoestadistica.setcantidad_maximo(0);
			productoestadistica.setcantidad_minimo(0);
		}
	}		
	
	public static void InicializarValoresProductoEstadisticas(List<ProductoEstadistica> productoestadisticas,Boolean conEnteros) throws Exception  {
		
		for(ProductoEstadistica productoestadistica: productoestadisticas) {
			productoestadistica.setprecio_ultima_compra(0.0);
			productoestadistica.setprecio_ultima_venta(0.0);
			productoestadistica.setprecio_ultima_cotizacion(0.0);
			productoestadistica.setprecio_ultima_proforma(0.0);
			productoestadistica.setcantidad_reservada(0.0);
			productoestadistica.setcantidad_demanda(0.0);
			productoestadistica.setcantidad_fisica(0.0);
			productoestadistica.setcantidad_orden_compra(0.0);
			productoestadistica.setcantidad_pedida(0.0);
			productoestadistica.setcantidad_requisicion(0.0);
			productoestadistica.settotal_ingreso(0.0);
			productoestadistica.settotal_egreso(0.0);
			productoestadistica.settotal_compra(0.0);
			productoestadistica.settotal_venta(0.0);
			productoestadistica.settotal_producido(0.0);
			productoestadistica.settotal_devuelto(0.0);
			productoestadistica.setcosto_ultimo(0.0);
			productoestadistica.setcosto_total(0.0);
			productoestadistica.setcosto_produccion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productoestadistica.setcantidad_disponible(0);
				productoestadistica.setcantidad_maximo(0);
				productoestadistica.setcantidad_minimo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductoEstadistica(List<ProductoEstadistica> productoestadisticas,ProductoEstadistica productoestadisticaAux) throws Exception  {
		ProductoEstadisticaConstantesFunciones.InicializarValoresProductoEstadistica(productoestadisticaAux,true);
		
		for(ProductoEstadistica productoestadistica: productoestadisticas) {
			if(productoestadistica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoestadisticaAux.setprecio_ultima_compra(productoestadisticaAux.getprecio_ultima_compra()+productoestadistica.getprecio_ultima_compra());			
			productoestadisticaAux.setprecio_ultima_venta(productoestadisticaAux.getprecio_ultima_venta()+productoestadistica.getprecio_ultima_venta());			
			productoestadisticaAux.setprecio_ultima_cotizacion(productoestadisticaAux.getprecio_ultima_cotizacion()+productoestadistica.getprecio_ultima_cotizacion());			
			productoestadisticaAux.setprecio_ultima_proforma(productoestadisticaAux.getprecio_ultima_proforma()+productoestadistica.getprecio_ultima_proforma());			
			productoestadisticaAux.setcantidad_disponible(productoestadisticaAux.getcantidad_disponible()+productoestadistica.getcantidad_disponible());			
			productoestadisticaAux.setcantidad_reservada(productoestadisticaAux.getcantidad_reservada()+productoestadistica.getcantidad_reservada());			
			productoestadisticaAux.setcantidad_demanda(productoestadisticaAux.getcantidad_demanda()+productoestadistica.getcantidad_demanda());			
			productoestadisticaAux.setcantidad_maximo(productoestadisticaAux.getcantidad_maximo()+productoestadistica.getcantidad_maximo());			
			productoestadisticaAux.setcantidad_minimo(productoestadisticaAux.getcantidad_minimo()+productoestadistica.getcantidad_minimo());			
			productoestadisticaAux.setcantidad_fisica(productoestadisticaAux.getcantidad_fisica()+productoestadistica.getcantidad_fisica());			
			productoestadisticaAux.setcantidad_orden_compra(productoestadisticaAux.getcantidad_orden_compra()+productoestadistica.getcantidad_orden_compra());			
			productoestadisticaAux.setcantidad_pedida(productoestadisticaAux.getcantidad_pedida()+productoestadistica.getcantidad_pedida());			
			productoestadisticaAux.setcantidad_requisicion(productoestadisticaAux.getcantidad_requisicion()+productoestadistica.getcantidad_requisicion());			
			productoestadisticaAux.settotal_ingreso(productoestadisticaAux.gettotal_ingreso()+productoestadistica.gettotal_ingreso());			
			productoestadisticaAux.settotal_egreso(productoestadisticaAux.gettotal_egreso()+productoestadistica.gettotal_egreso());			
			productoestadisticaAux.settotal_compra(productoestadisticaAux.gettotal_compra()+productoestadistica.gettotal_compra());			
			productoestadisticaAux.settotal_venta(productoestadisticaAux.gettotal_venta()+productoestadistica.gettotal_venta());			
			productoestadisticaAux.settotal_producido(productoestadisticaAux.gettotal_producido()+productoestadistica.gettotal_producido());			
			productoestadisticaAux.settotal_devuelto(productoestadisticaAux.gettotal_devuelto()+productoestadistica.gettotal_devuelto());			
			productoestadisticaAux.setcosto_ultimo(productoestadisticaAux.getcosto_ultimo()+productoestadistica.getcosto_ultimo());			
			productoestadisticaAux.setcosto_total(productoestadisticaAux.getcosto_total()+productoestadistica.getcosto_total());			
			productoestadisticaAux.setcosto_produccion(productoestadisticaAux.getcosto_produccion()+productoestadistica.getcosto_produccion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoEstadistica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoEstadisticaConstantesFunciones.getArrayColumnasGlobalesProductoEstadistica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoEstadistica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoEstadisticaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoEstadisticaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoEstadisticaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoEstadisticaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductoEstadistica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoEstadistica> productoestadisticas,ProductoEstadistica productoestadistica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoEstadistica productoestadisticaAux: productoestadisticas) {
			if(productoestadisticaAux!=null && productoestadistica!=null) {
				if((productoestadisticaAux.getId()==null && productoestadistica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoestadisticaAux.getId()!=null && productoestadistica.getId()!=null){
					if(productoestadisticaAux.getId().equals(productoestadistica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoEstadistica(List<ProductoEstadistica> productoestadisticas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio_ultima_compraTotal=0.0;
		Double precio_ultima_ventaTotal=0.0;
		Double precio_ultima_cotizacionTotal=0.0;
		Double precio_ultima_proformaTotal=0.0;
		Double cantidad_reservadaTotal=0.0;
		Double cantidad_demandaTotal=0.0;
		Double cantidad_fisicaTotal=0.0;
		Double cantidad_orden_compraTotal=0.0;
		Double cantidad_pedidaTotal=0.0;
		Double cantidad_requisicionTotal=0.0;
		Double total_ingresoTotal=0.0;
		Double total_egresoTotal=0.0;
		Double total_compraTotal=0.0;
		Double total_ventaTotal=0.0;
		Double total_producidoTotal=0.0;
		Double total_devueltoTotal=0.0;
		Double costo_ultimoTotal=0.0;
		Double costo_totalTotal=0.0;
		Double costo_produccionTotal=0.0;
	
		for(ProductoEstadistica productoestadistica: productoestadisticas) {			
			if(productoestadistica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precio_ultima_compraTotal+=productoestadistica.getprecio_ultima_compra();
			precio_ultima_ventaTotal+=productoestadistica.getprecio_ultima_venta();
			precio_ultima_cotizacionTotal+=productoestadistica.getprecio_ultima_cotizacion();
			precio_ultima_proformaTotal+=productoestadistica.getprecio_ultima_proforma();
			cantidad_reservadaTotal+=productoestadistica.getcantidad_reservada();
			cantidad_demandaTotal+=productoestadistica.getcantidad_demanda();
			cantidad_fisicaTotal+=productoestadistica.getcantidad_fisica();
			cantidad_orden_compraTotal+=productoestadistica.getcantidad_orden_compra();
			cantidad_pedidaTotal+=productoestadistica.getcantidad_pedida();
			cantidad_requisicionTotal+=productoestadistica.getcantidad_requisicion();
			total_ingresoTotal+=productoestadistica.gettotal_ingreso();
			total_egresoTotal+=productoestadistica.gettotal_egreso();
			total_compraTotal+=productoestadistica.gettotal_compra();
			total_ventaTotal+=productoestadistica.gettotal_venta();
			total_producidoTotal+=productoestadistica.gettotal_producido();
			total_devueltoTotal+=productoestadistica.gettotal_devuelto();
			costo_ultimoTotal+=productoestadistica.getcosto_ultimo();
			costo_totalTotal+=productoestadistica.getcosto_total();
			costo_produccionTotal+=productoestadistica.getcosto_produccion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA);
		datoGeneral.setdValorDouble(precio_ultima_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA);
		datoGeneral.setdValorDouble(precio_ultima_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION);
		datoGeneral.setdValorDouble(precio_ultima_cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA);
		datoGeneral.setdValorDouble(precio_ultima_proformaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA);
		datoGeneral.setdValorDouble(cantidad_reservadaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA);
		datoGeneral.setdValorDouble(cantidad_demandaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADFISICA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA);
		datoGeneral.setdValorDouble(cantidad_fisicaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA);
		datoGeneral.setdValorDouble(cantidad_orden_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA);
		datoGeneral.setdValorDouble(cantidad_pedidaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION);
		datoGeneral.setdValorDouble(cantidad_requisicionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALINGRESO);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO);
		datoGeneral.setdValorDouble(total_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALEGRESO);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO);
		datoGeneral.setdValorDouble(total_egresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALCOMPRA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA);
		datoGeneral.setdValorDouble(total_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALVENTA);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA);
		datoGeneral.setdValorDouble(total_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO);
		datoGeneral.setdValorDouble(total_producidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO);
		datoGeneral.setdValorDouble(total_devueltoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.COSTOULTIMO);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO);
		datoGeneral.setdValorDouble(costo_ultimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION);
		datoGeneral.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION);
		datoGeneral.setdValorDouble(costo_produccionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductoEstadistica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_ID, ProductoEstadisticaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_VERSIONROW, ProductoEstadisticaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_IDEMPRESA, ProductoEstadisticaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_IDSUCURSAL, ProductoEstadisticaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_IDBODEGA, ProductoEstadisticaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_IDPRODUCTO, ProductoEstadisticaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA, ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA, ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION, ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA, ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDISPONIBLE, ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA, ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA, ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMAXIMO, ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMINIMO, ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA, ProductoEstadisticaConstantesFunciones.CANTIDADFISICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA, ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA, ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION, ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAINGRESO, ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAEGRESO, ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPRODUCCION, ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMACOMPRA, ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAVENTA, ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION, ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAORDENCOMPRA, ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPEDIDO, ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAREQUISICION, ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO, ProductoEstadisticaConstantesFunciones.TOTALINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO, ProductoEstadisticaConstantesFunciones.TOTALEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA, ProductoEstadisticaConstantesFunciones.TOTALCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA, ProductoEstadisticaConstantesFunciones.TOTALVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO, ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO, ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO, ProductoEstadisticaConstantesFunciones.COSTOULTIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL, ProductoEstadisticaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION, ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductoEstadistica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADFISICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.COSTOULTIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEstadistica() throws Exception  {
		return ProductoEstadisticaConstantesFunciones.getTiposSeleccionarProductoEstadistica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEstadistica(Boolean conFk) throws Exception  {
		return ProductoEstadisticaConstantesFunciones.getTiposSeleccionarProductoEstadistica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductoEstadistica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMAXIMO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMINIMO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAINGRESO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAEGRESO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPRODUCCION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAVENTA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAORDENCOMPRA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPEDIDO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAREQUISICION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION);
			reporte.setsDescripcion(ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductoEstadistica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductoEstadistica(ProductoEstadistica productoestadisticaAux) throws Exception {
		
			productoestadisticaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoestadisticaAux.getEmpresa()));
			productoestadisticaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoestadisticaAux.getSucursal()));
			productoestadisticaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoestadisticaAux.getBodega()));
			productoestadisticaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoestadisticaAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductoEstadistica(List<ProductoEstadistica> productoestadisticasTemp) throws Exception {
		for(ProductoEstadistica productoestadisticaAux:productoestadisticasTemp) {
			
			productoestadisticaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoestadisticaAux.getEmpresa()));
			productoestadisticaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoestadisticaAux.getSucursal()));
			productoestadisticaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productoestadisticaAux.getBodega()));
			productoestadisticaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productoestadisticaAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductoEstadistica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductoEstadistica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoEstadistica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoEstadisticaConstantesFunciones.getClassesRelationshipsOfProductoEstadistica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductoEstadistica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoEstadistica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoEstadisticaConstantesFunciones.getClassesRelationshipsFromStringsOfProductoEstadistica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductoEstadistica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductoEstadistica productoestadistica,List<ProductoEstadistica> productoestadisticas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProductoEstadistica productoestadisticaEncontrado=null;
			
			for(ProductoEstadistica productoestadisticaLocal:productoestadisticas) {
				if(productoestadisticaLocal.getId().equals(productoestadistica.getId())) {
					productoestadisticaEncontrado=productoestadisticaLocal;
					
					productoestadisticaLocal.setIsChanged(productoestadistica.getIsChanged());
					productoestadisticaLocal.setIsNew(productoestadistica.getIsNew());
					productoestadisticaLocal.setIsDeleted(productoestadistica.getIsDeleted());
					
					productoestadisticaLocal.setGeneralEntityOriginal(productoestadistica.getGeneralEntityOriginal());
					
					productoestadisticaLocal.setId(productoestadistica.getId());	
					productoestadisticaLocal.setVersionRow(productoestadistica.getVersionRow());	
					productoestadisticaLocal.setid_empresa(productoestadistica.getid_empresa());	
					productoestadisticaLocal.setid_sucursal(productoestadistica.getid_sucursal());	
					productoestadisticaLocal.setid_bodega(productoestadistica.getid_bodega());	
					productoestadisticaLocal.setid_producto(productoestadistica.getid_producto());	
					productoestadisticaLocal.setprecio_ultima_compra(productoestadistica.getprecio_ultima_compra());	
					productoestadisticaLocal.setprecio_ultima_venta(productoestadistica.getprecio_ultima_venta());	
					productoestadisticaLocal.setprecio_ultima_cotizacion(productoestadistica.getprecio_ultima_cotizacion());	
					productoestadisticaLocal.setprecio_ultima_proforma(productoestadistica.getprecio_ultima_proforma());	
					productoestadisticaLocal.setcantidad_disponible(productoestadistica.getcantidad_disponible());	
					productoestadisticaLocal.setcantidad_reservada(productoestadistica.getcantidad_reservada());	
					productoestadisticaLocal.setcantidad_demanda(productoestadistica.getcantidad_demanda());	
					productoestadisticaLocal.setcantidad_maximo(productoestadistica.getcantidad_maximo());	
					productoestadisticaLocal.setcantidad_minimo(productoestadistica.getcantidad_minimo());	
					productoestadisticaLocal.setcantidad_fisica(productoestadistica.getcantidad_fisica());	
					productoestadisticaLocal.setcantidad_orden_compra(productoestadistica.getcantidad_orden_compra());	
					productoestadisticaLocal.setcantidad_pedida(productoestadistica.getcantidad_pedida());	
					productoestadisticaLocal.setcantidad_requisicion(productoestadistica.getcantidad_requisicion());	
					productoestadisticaLocal.setfecha_ultima_ingreso(productoestadistica.getfecha_ultima_ingreso());	
					productoestadisticaLocal.setfecha_ultima_egreso(productoestadistica.getfecha_ultima_egreso());	
					productoestadisticaLocal.setfecha_ultima_produccion(productoestadistica.getfecha_ultima_produccion());	
					productoestadisticaLocal.setfecha_ultima_compra(productoestadistica.getfecha_ultima_compra());	
					productoestadisticaLocal.setfecha_ultima_venta(productoestadistica.getfecha_ultima_venta());	
					productoestadisticaLocal.setfecha_ultima_devolucion(productoestadistica.getfecha_ultima_devolucion());	
					productoestadisticaLocal.setfecha_ultima_orden_compra(productoestadistica.getfecha_ultima_orden_compra());	
					productoestadisticaLocal.setfecha_ultima_pedido(productoestadistica.getfecha_ultima_pedido());	
					productoestadisticaLocal.setfecha_ultima_requisicion(productoestadistica.getfecha_ultima_requisicion());	
					productoestadisticaLocal.settotal_ingreso(productoestadistica.gettotal_ingreso());	
					productoestadisticaLocal.settotal_egreso(productoestadistica.gettotal_egreso());	
					productoestadisticaLocal.settotal_compra(productoestadistica.gettotal_compra());	
					productoestadisticaLocal.settotal_venta(productoestadistica.gettotal_venta());	
					productoestadisticaLocal.settotal_producido(productoestadistica.gettotal_producido());	
					productoestadisticaLocal.settotal_devuelto(productoestadistica.gettotal_devuelto());	
					productoestadisticaLocal.setcosto_ultimo(productoestadistica.getcosto_ultimo());	
					productoestadisticaLocal.setcosto_total(productoestadistica.getcosto_total());	
					productoestadisticaLocal.setcosto_produccion(productoestadistica.getcosto_produccion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!productoestadistica.getIsDeleted()) {
				if(!existe) {
					productoestadisticas.add(productoestadistica);
				}
			} else {
				if(productoestadisticaEncontrado!=null && permiteQuitar)  {
					productoestadisticas.remove(productoestadisticaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProductoEstadistica productoestadistica,List<ProductoEstadistica> productoestadisticas) throws Exception {
		try	{			
			for(ProductoEstadistica productoestadisticaLocal:productoestadisticas) {
				if(productoestadisticaLocal.getId().equals(productoestadistica.getId())) {
					productoestadisticaLocal.setIsSelected(productoestadistica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductoEstadistica(List<ProductoEstadistica> productoestadisticasAux) throws Exception {
		//this.productoestadisticasAux=productoestadisticasAux;
		
		for(ProductoEstadistica productoestadisticaAux:productoestadisticasAux) {
			if(productoestadisticaAux.getIsChanged()) {
				productoestadisticaAux.setIsChanged(false);
			}		
			
			if(productoestadisticaAux.getIsNew()) {
				productoestadisticaAux.setIsNew(false);
			}	
			
			if(productoestadisticaAux.getIsDeleted()) {
				productoestadisticaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductoEstadistica(ProductoEstadistica productoestadisticaAux) throws Exception {
		//this.productoestadisticaAux=productoestadisticaAux;
		
			if(productoestadisticaAux.getIsChanged()) {
				productoestadisticaAux.setIsChanged(false);
			}		
			
			if(productoestadisticaAux.getIsNew()) {
				productoestadisticaAux.setIsNew(false);
			}	
			
			if(productoestadisticaAux.getIsDeleted()) {
				productoestadisticaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductoEstadistica productoestadisticaAsignar,ProductoEstadistica productoestadistica) throws Exception {
		productoestadisticaAsignar.setId(productoestadistica.getId());	
		productoestadisticaAsignar.setVersionRow(productoestadistica.getVersionRow());	
		productoestadisticaAsignar.setid_empresa(productoestadistica.getid_empresa());
		productoestadisticaAsignar.setempresa_descripcion(productoestadistica.getempresa_descripcion());	
		productoestadisticaAsignar.setid_sucursal(productoestadistica.getid_sucursal());
		productoestadisticaAsignar.setsucursal_descripcion(productoestadistica.getsucursal_descripcion());	
		productoestadisticaAsignar.setid_bodega(productoestadistica.getid_bodega());
		productoestadisticaAsignar.setbodega_descripcion(productoestadistica.getbodega_descripcion());	
		productoestadisticaAsignar.setid_producto(productoestadistica.getid_producto());
		productoestadisticaAsignar.setproducto_descripcion(productoestadistica.getproducto_descripcion());	
		productoestadisticaAsignar.setprecio_ultima_compra(productoestadistica.getprecio_ultima_compra());	
		productoestadisticaAsignar.setprecio_ultima_venta(productoestadistica.getprecio_ultima_venta());	
		productoestadisticaAsignar.setprecio_ultima_cotizacion(productoestadistica.getprecio_ultima_cotizacion());	
		productoestadisticaAsignar.setprecio_ultima_proforma(productoestadistica.getprecio_ultima_proforma());	
		productoestadisticaAsignar.setcantidad_disponible(productoestadistica.getcantidad_disponible());	
		productoestadisticaAsignar.setcantidad_reservada(productoestadistica.getcantidad_reservada());	
		productoestadisticaAsignar.setcantidad_demanda(productoestadistica.getcantidad_demanda());	
		productoestadisticaAsignar.setcantidad_maximo(productoestadistica.getcantidad_maximo());	
		productoestadisticaAsignar.setcantidad_minimo(productoestadistica.getcantidad_minimo());	
		productoestadisticaAsignar.setcantidad_fisica(productoestadistica.getcantidad_fisica());	
		productoestadisticaAsignar.setcantidad_orden_compra(productoestadistica.getcantidad_orden_compra());	
		productoestadisticaAsignar.setcantidad_pedida(productoestadistica.getcantidad_pedida());	
		productoestadisticaAsignar.setcantidad_requisicion(productoestadistica.getcantidad_requisicion());	
		productoestadisticaAsignar.setfecha_ultima_ingreso(productoestadistica.getfecha_ultima_ingreso());	
		productoestadisticaAsignar.setfecha_ultima_egreso(productoestadistica.getfecha_ultima_egreso());	
		productoestadisticaAsignar.setfecha_ultima_produccion(productoestadistica.getfecha_ultima_produccion());	
		productoestadisticaAsignar.setfecha_ultima_compra(productoestadistica.getfecha_ultima_compra());	
		productoestadisticaAsignar.setfecha_ultima_venta(productoestadistica.getfecha_ultima_venta());	
		productoestadisticaAsignar.setfecha_ultima_devolucion(productoestadistica.getfecha_ultima_devolucion());	
		productoestadisticaAsignar.setfecha_ultima_orden_compra(productoestadistica.getfecha_ultima_orden_compra());	
		productoestadisticaAsignar.setfecha_ultima_pedido(productoestadistica.getfecha_ultima_pedido());	
		productoestadisticaAsignar.setfecha_ultima_requisicion(productoestadistica.getfecha_ultima_requisicion());	
		productoestadisticaAsignar.settotal_ingreso(productoestadistica.gettotal_ingreso());	
		productoestadisticaAsignar.settotal_egreso(productoestadistica.gettotal_egreso());	
		productoestadisticaAsignar.settotal_compra(productoestadistica.gettotal_compra());	
		productoestadisticaAsignar.settotal_venta(productoestadistica.gettotal_venta());	
		productoestadisticaAsignar.settotal_producido(productoestadistica.gettotal_producido());	
		productoestadisticaAsignar.settotal_devuelto(productoestadistica.gettotal_devuelto());	
		productoestadisticaAsignar.setcosto_ultimo(productoestadistica.getcosto_ultimo());	
		productoestadisticaAsignar.setcosto_total(productoestadistica.getcosto_total());	
		productoestadisticaAsignar.setcosto_produccion(productoestadistica.getcosto_produccion());	
	}
	
	public static void inicializarProductoEstadistica(ProductoEstadistica productoestadistica) throws Exception {
		try {
				productoestadistica.setId(0L);	
					
				productoestadistica.setid_empresa(-1L);	
				productoestadistica.setid_sucursal(-1L);	
				productoestadistica.setid_bodega(-1L);	
				productoestadistica.setid_producto(-1L);	
				productoestadistica.setprecio_ultima_compra(0.0);	
				productoestadistica.setprecio_ultima_venta(0.0);	
				productoestadistica.setprecio_ultima_cotizacion(0.0);	
				productoestadistica.setprecio_ultima_proforma(0.0);	
				productoestadistica.setcantidad_disponible(0);	
				productoestadistica.setcantidad_reservada(0.0);	
				productoestadistica.setcantidad_demanda(0.0);	
				productoestadistica.setcantidad_maximo(0);	
				productoestadistica.setcantidad_minimo(0);	
				productoestadistica.setcantidad_fisica(0.0);	
				productoestadistica.setcantidad_orden_compra(0.0);	
				productoestadistica.setcantidad_pedida(0.0);	
				productoestadistica.setcantidad_requisicion(0.0);	
				productoestadistica.setfecha_ultima_ingreso(new Date());	
				productoestadistica.setfecha_ultima_egreso(new Date());	
				productoestadistica.setfecha_ultima_produccion(new Date());	
				productoestadistica.setfecha_ultima_compra(new Date());	
				productoestadistica.setfecha_ultima_venta(new Date());	
				productoestadistica.setfecha_ultima_devolucion(new Date());	
				productoestadistica.setfecha_ultima_orden_compra(new Date());	
				productoestadistica.setfecha_ultima_pedido(new Date());	
				productoestadistica.setfecha_ultima_requisicion(new Date());	
				productoestadistica.settotal_ingreso(0.0);	
				productoestadistica.settotal_egreso(0.0);	
				productoestadistica.settotal_compra(0.0);	
				productoestadistica.settotal_venta(0.0);	
				productoestadistica.settotal_producido(0.0);	
				productoestadistica.settotal_devuelto(0.0);	
				productoestadistica.setcosto_ultimo(0.0);	
				productoestadistica.setcosto_total(0.0);	
				productoestadistica.setcosto_produccion(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductoEstadistica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMACOTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_PRECIOULTIMAPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADRESERVADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADDEMANDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADFISICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADPEDIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_CANTIDADREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMADEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_FECHAULTIMAREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALPRODUCIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_TOTALDEVUELTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_COSTOULTIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoEstadisticaConstantesFunciones.LABEL_COSTOPRODUCCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductoEstadistica(String sTipo,Row row,Workbook workbook,ProductoEstadistica productoestadistica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getprecio_ultima_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getprecio_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getprecio_ultima_cotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getprecio_ultima_proforma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_reservada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_demanda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_fisica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_orden_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_pedida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcantidad_requisicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_produccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_devolucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_orden_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getfecha_ultima_requisicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_producido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.gettotal_devuelto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcosto_ultimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productoestadistica.getcosto_produccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductoEstadistica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProductoEstadistica() {
		return this.sFinalQueryProductoEstadistica;
	}
	
	public void setsFinalQueryProductoEstadistica(String sFinalQueryProductoEstadistica) {
		this.sFinalQueryProductoEstadistica= sFinalQueryProductoEstadistica;
	}
	
	public Border resaltarSeleccionarProductoEstadistica=null;
	
	public Border setResaltarSeleccionarProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductoEstadistica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductoEstadistica() {
		return this.resaltarSeleccionarProductoEstadistica;
	}
	
	public void setResaltarSeleccionarProductoEstadistica(Border borderResaltarSeleccionarProductoEstadistica) {
		this.resaltarSeleccionarProductoEstadistica= borderResaltarSeleccionarProductoEstadistica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductoEstadistica=null;
	public Boolean mostraridProductoEstadistica=true;
	public Boolean activaridProductoEstadistica=true;

	public Border resaltarid_empresaProductoEstadistica=null;
	public Boolean mostrarid_empresaProductoEstadistica=true;
	public Boolean activarid_empresaProductoEstadistica=true;
	public Boolean cargarid_empresaProductoEstadistica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductoEstadistica=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductoEstadistica=null;
	public Boolean mostrarid_sucursalProductoEstadistica=true;
	public Boolean activarid_sucursalProductoEstadistica=true;
	public Boolean cargarid_sucursalProductoEstadistica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductoEstadistica=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductoEstadistica=null;
	public Boolean mostrarid_bodegaProductoEstadistica=true;
	public Boolean activarid_bodegaProductoEstadistica=true;
	public Boolean cargarid_bodegaProductoEstadistica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductoEstadistica=false;//ConEventDepend=true

	public Border resaltarid_productoProductoEstadistica=null;
	public Boolean mostrarid_productoProductoEstadistica=true;
	public Boolean activarid_productoProductoEstadistica=true;
	public Boolean cargarid_productoProductoEstadistica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductoEstadistica=false;//ConEventDepend=true

	public Border resaltarprecio_ultima_compraProductoEstadistica=null;
	public Boolean mostrarprecio_ultima_compraProductoEstadistica=true;
	public Boolean activarprecio_ultima_compraProductoEstadistica=true;

	public Border resaltarprecio_ultima_ventaProductoEstadistica=null;
	public Boolean mostrarprecio_ultima_ventaProductoEstadistica=true;
	public Boolean activarprecio_ultima_ventaProductoEstadistica=true;

	public Border resaltarprecio_ultima_cotizacionProductoEstadistica=null;
	public Boolean mostrarprecio_ultima_cotizacionProductoEstadistica=true;
	public Boolean activarprecio_ultima_cotizacionProductoEstadistica=true;

	public Border resaltarprecio_ultima_proformaProductoEstadistica=null;
	public Boolean mostrarprecio_ultima_proformaProductoEstadistica=true;
	public Boolean activarprecio_ultima_proformaProductoEstadistica=true;

	public Border resaltarcantidad_disponibleProductoEstadistica=null;
	public Boolean mostrarcantidad_disponibleProductoEstadistica=true;
	public Boolean activarcantidad_disponibleProductoEstadistica=true;

	public Border resaltarcantidad_reservadaProductoEstadistica=null;
	public Boolean mostrarcantidad_reservadaProductoEstadistica=true;
	public Boolean activarcantidad_reservadaProductoEstadistica=true;

	public Border resaltarcantidad_demandaProductoEstadistica=null;
	public Boolean mostrarcantidad_demandaProductoEstadistica=true;
	public Boolean activarcantidad_demandaProductoEstadistica=true;

	public Border resaltarcantidad_maximoProductoEstadistica=null;
	public Boolean mostrarcantidad_maximoProductoEstadistica=true;
	public Boolean activarcantidad_maximoProductoEstadistica=true;

	public Border resaltarcantidad_minimoProductoEstadistica=null;
	public Boolean mostrarcantidad_minimoProductoEstadistica=true;
	public Boolean activarcantidad_minimoProductoEstadistica=true;

	public Border resaltarcantidad_fisicaProductoEstadistica=null;
	public Boolean mostrarcantidad_fisicaProductoEstadistica=true;
	public Boolean activarcantidad_fisicaProductoEstadistica=true;

	public Border resaltarcantidad_orden_compraProductoEstadistica=null;
	public Boolean mostrarcantidad_orden_compraProductoEstadistica=true;
	public Boolean activarcantidad_orden_compraProductoEstadistica=true;

	public Border resaltarcantidad_pedidaProductoEstadistica=null;
	public Boolean mostrarcantidad_pedidaProductoEstadistica=true;
	public Boolean activarcantidad_pedidaProductoEstadistica=true;

	public Border resaltarcantidad_requisicionProductoEstadistica=null;
	public Boolean mostrarcantidad_requisicionProductoEstadistica=true;
	public Boolean activarcantidad_requisicionProductoEstadistica=true;

	public Border resaltarfecha_ultima_ingresoProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_ingresoProductoEstadistica=true;
	public Boolean activarfecha_ultima_ingresoProductoEstadistica=false;

	public Border resaltarfecha_ultima_egresoProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_egresoProductoEstadistica=true;
	public Boolean activarfecha_ultima_egresoProductoEstadistica=false;

	public Border resaltarfecha_ultima_produccionProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_produccionProductoEstadistica=true;
	public Boolean activarfecha_ultima_produccionProductoEstadistica=false;

	public Border resaltarfecha_ultima_compraProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_compraProductoEstadistica=true;
	public Boolean activarfecha_ultima_compraProductoEstadistica=false;

	public Border resaltarfecha_ultima_ventaProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_ventaProductoEstadistica=true;
	public Boolean activarfecha_ultima_ventaProductoEstadistica=false;

	public Border resaltarfecha_ultima_devolucionProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_devolucionProductoEstadistica=true;
	public Boolean activarfecha_ultima_devolucionProductoEstadistica=false;

	public Border resaltarfecha_ultima_orden_compraProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_orden_compraProductoEstadistica=true;
	public Boolean activarfecha_ultima_orden_compraProductoEstadistica=false;

	public Border resaltarfecha_ultima_pedidoProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_pedidoProductoEstadistica=true;
	public Boolean activarfecha_ultima_pedidoProductoEstadistica=false;

	public Border resaltarfecha_ultima_requisicionProductoEstadistica=null;
	public Boolean mostrarfecha_ultima_requisicionProductoEstadistica=true;
	public Boolean activarfecha_ultima_requisicionProductoEstadistica=false;

	public Border resaltartotal_ingresoProductoEstadistica=null;
	public Boolean mostrartotal_ingresoProductoEstadistica=true;
	public Boolean activartotal_ingresoProductoEstadistica=true;

	public Border resaltartotal_egresoProductoEstadistica=null;
	public Boolean mostrartotal_egresoProductoEstadistica=true;
	public Boolean activartotal_egresoProductoEstadistica=true;

	public Border resaltartotal_compraProductoEstadistica=null;
	public Boolean mostrartotal_compraProductoEstadistica=true;
	public Boolean activartotal_compraProductoEstadistica=true;

	public Border resaltartotal_ventaProductoEstadistica=null;
	public Boolean mostrartotal_ventaProductoEstadistica=true;
	public Boolean activartotal_ventaProductoEstadistica=true;

	public Border resaltartotal_producidoProductoEstadistica=null;
	public Boolean mostrartotal_producidoProductoEstadistica=true;
	public Boolean activartotal_producidoProductoEstadistica=true;

	public Border resaltartotal_devueltoProductoEstadistica=null;
	public Boolean mostrartotal_devueltoProductoEstadistica=true;
	public Boolean activartotal_devueltoProductoEstadistica=true;

	public Border resaltarcosto_ultimoProductoEstadistica=null;
	public Boolean mostrarcosto_ultimoProductoEstadistica=true;
	public Boolean activarcosto_ultimoProductoEstadistica=true;

	public Border resaltarcosto_totalProductoEstadistica=null;
	public Boolean mostrarcosto_totalProductoEstadistica=true;
	public Boolean activarcosto_totalProductoEstadistica=true;

	public Border resaltarcosto_produccionProductoEstadistica=null;
	public Boolean mostrarcosto_produccionProductoEstadistica=true;
	public Boolean activarcosto_produccionProductoEstadistica=true;

	
	

	public Border setResaltaridProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltaridProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductoEstadistica() {
		return this.resaltaridProductoEstadistica;
	}

	public void setResaltaridProductoEstadistica(Border borderResaltar) {
		this.resaltaridProductoEstadistica= borderResaltar;
	}

	public Boolean getMostraridProductoEstadistica() {
		return this.mostraridProductoEstadistica;
	}

	public void setMostraridProductoEstadistica(Boolean mostraridProductoEstadistica) {
		this.mostraridProductoEstadistica= mostraridProductoEstadistica;
	}

	public Boolean getActivaridProductoEstadistica() {
		return this.activaridProductoEstadistica;
	}

	public void setActivaridProductoEstadistica(Boolean activaridProductoEstadistica) {
		this.activaridProductoEstadistica= activaridProductoEstadistica;
	}

	public Border setResaltarid_empresaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductoEstadistica() {
		return this.resaltarid_empresaProductoEstadistica;
	}

	public void setResaltarid_empresaProductoEstadistica(Border borderResaltar) {
		this.resaltarid_empresaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductoEstadistica() {
		return this.mostrarid_empresaProductoEstadistica;
	}

	public void setMostrarid_empresaProductoEstadistica(Boolean mostrarid_empresaProductoEstadistica) {
		this.mostrarid_empresaProductoEstadistica= mostrarid_empresaProductoEstadistica;
	}

	public Boolean getActivarid_empresaProductoEstadistica() {
		return this.activarid_empresaProductoEstadistica;
	}

	public void setActivarid_empresaProductoEstadistica(Boolean activarid_empresaProductoEstadistica) {
		this.activarid_empresaProductoEstadistica= activarid_empresaProductoEstadistica;
	}

	public Boolean getCargarid_empresaProductoEstadistica() {
		return this.cargarid_empresaProductoEstadistica;
	}

	public void setCargarid_empresaProductoEstadistica(Boolean cargarid_empresaProductoEstadistica) {
		this.cargarid_empresaProductoEstadistica= cargarid_empresaProductoEstadistica;
	}

	public Border setResaltarid_sucursalProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductoEstadistica() {
		return this.resaltarid_sucursalProductoEstadistica;
	}

	public void setResaltarid_sucursalProductoEstadistica(Border borderResaltar) {
		this.resaltarid_sucursalProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductoEstadistica() {
		return this.mostrarid_sucursalProductoEstadistica;
	}

	public void setMostrarid_sucursalProductoEstadistica(Boolean mostrarid_sucursalProductoEstadistica) {
		this.mostrarid_sucursalProductoEstadistica= mostrarid_sucursalProductoEstadistica;
	}

	public Boolean getActivarid_sucursalProductoEstadistica() {
		return this.activarid_sucursalProductoEstadistica;
	}

	public void setActivarid_sucursalProductoEstadistica(Boolean activarid_sucursalProductoEstadistica) {
		this.activarid_sucursalProductoEstadistica= activarid_sucursalProductoEstadistica;
	}

	public Boolean getCargarid_sucursalProductoEstadistica() {
		return this.cargarid_sucursalProductoEstadistica;
	}

	public void setCargarid_sucursalProductoEstadistica(Boolean cargarid_sucursalProductoEstadistica) {
		this.cargarid_sucursalProductoEstadistica= cargarid_sucursalProductoEstadistica;
	}

	public Border setResaltarid_bodegaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductoEstadistica() {
		return this.resaltarid_bodegaProductoEstadistica;
	}

	public void setResaltarid_bodegaProductoEstadistica(Border borderResaltar) {
		this.resaltarid_bodegaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductoEstadistica() {
		return this.mostrarid_bodegaProductoEstadistica;
	}

	public void setMostrarid_bodegaProductoEstadistica(Boolean mostrarid_bodegaProductoEstadistica) {
		this.mostrarid_bodegaProductoEstadistica= mostrarid_bodegaProductoEstadistica;
	}

	public Boolean getActivarid_bodegaProductoEstadistica() {
		return this.activarid_bodegaProductoEstadistica;
	}

	public void setActivarid_bodegaProductoEstadistica(Boolean activarid_bodegaProductoEstadistica) {
		this.activarid_bodegaProductoEstadistica= activarid_bodegaProductoEstadistica;
	}

	public Boolean getCargarid_bodegaProductoEstadistica() {
		return this.cargarid_bodegaProductoEstadistica;
	}

	public void setCargarid_bodegaProductoEstadistica(Boolean cargarid_bodegaProductoEstadistica) {
		this.cargarid_bodegaProductoEstadistica= cargarid_bodegaProductoEstadistica;
	}

	public Border setResaltarid_productoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarid_productoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductoEstadistica() {
		return this.resaltarid_productoProductoEstadistica;
	}

	public void setResaltarid_productoProductoEstadistica(Border borderResaltar) {
		this.resaltarid_productoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarid_productoProductoEstadistica() {
		return this.mostrarid_productoProductoEstadistica;
	}

	public void setMostrarid_productoProductoEstadistica(Boolean mostrarid_productoProductoEstadistica) {
		this.mostrarid_productoProductoEstadistica= mostrarid_productoProductoEstadistica;
	}

	public Boolean getActivarid_productoProductoEstadistica() {
		return this.activarid_productoProductoEstadistica;
	}

	public void setActivarid_productoProductoEstadistica(Boolean activarid_productoProductoEstadistica) {
		this.activarid_productoProductoEstadistica= activarid_productoProductoEstadistica;
	}

	public Boolean getCargarid_productoProductoEstadistica() {
		return this.cargarid_productoProductoEstadistica;
	}

	public void setCargarid_productoProductoEstadistica(Boolean cargarid_productoProductoEstadistica) {
		this.cargarid_productoProductoEstadistica= cargarid_productoProductoEstadistica;
	}

	public Border setResaltarprecio_ultima_compraProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarprecio_ultima_compraProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ultima_compraProductoEstadistica() {
		return this.resaltarprecio_ultima_compraProductoEstadistica;
	}

	public void setResaltarprecio_ultima_compraProductoEstadistica(Border borderResaltar) {
		this.resaltarprecio_ultima_compraProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarprecio_ultima_compraProductoEstadistica() {
		return this.mostrarprecio_ultima_compraProductoEstadistica;
	}

	public void setMostrarprecio_ultima_compraProductoEstadistica(Boolean mostrarprecio_ultima_compraProductoEstadistica) {
		this.mostrarprecio_ultima_compraProductoEstadistica= mostrarprecio_ultima_compraProductoEstadistica;
	}

	public Boolean getActivarprecio_ultima_compraProductoEstadistica() {
		return this.activarprecio_ultima_compraProductoEstadistica;
	}

	public void setActivarprecio_ultima_compraProductoEstadistica(Boolean activarprecio_ultima_compraProductoEstadistica) {
		this.activarprecio_ultima_compraProductoEstadistica= activarprecio_ultima_compraProductoEstadistica;
	}

	public Border setResaltarprecio_ultima_ventaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarprecio_ultima_ventaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ultima_ventaProductoEstadistica() {
		return this.resaltarprecio_ultima_ventaProductoEstadistica;
	}

	public void setResaltarprecio_ultima_ventaProductoEstadistica(Border borderResaltar) {
		this.resaltarprecio_ultima_ventaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarprecio_ultima_ventaProductoEstadistica() {
		return this.mostrarprecio_ultima_ventaProductoEstadistica;
	}

	public void setMostrarprecio_ultima_ventaProductoEstadistica(Boolean mostrarprecio_ultima_ventaProductoEstadistica) {
		this.mostrarprecio_ultima_ventaProductoEstadistica= mostrarprecio_ultima_ventaProductoEstadistica;
	}

	public Boolean getActivarprecio_ultima_ventaProductoEstadistica() {
		return this.activarprecio_ultima_ventaProductoEstadistica;
	}

	public void setActivarprecio_ultima_ventaProductoEstadistica(Boolean activarprecio_ultima_ventaProductoEstadistica) {
		this.activarprecio_ultima_ventaProductoEstadistica= activarprecio_ultima_ventaProductoEstadistica;
	}

	public Border setResaltarprecio_ultima_cotizacionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarprecio_ultima_cotizacionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ultima_cotizacionProductoEstadistica() {
		return this.resaltarprecio_ultima_cotizacionProductoEstadistica;
	}

	public void setResaltarprecio_ultima_cotizacionProductoEstadistica(Border borderResaltar) {
		this.resaltarprecio_ultima_cotizacionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarprecio_ultima_cotizacionProductoEstadistica() {
		return this.mostrarprecio_ultima_cotizacionProductoEstadistica;
	}

	public void setMostrarprecio_ultima_cotizacionProductoEstadistica(Boolean mostrarprecio_ultima_cotizacionProductoEstadistica) {
		this.mostrarprecio_ultima_cotizacionProductoEstadistica= mostrarprecio_ultima_cotizacionProductoEstadistica;
	}

	public Boolean getActivarprecio_ultima_cotizacionProductoEstadistica() {
		return this.activarprecio_ultima_cotizacionProductoEstadistica;
	}

	public void setActivarprecio_ultima_cotizacionProductoEstadistica(Boolean activarprecio_ultima_cotizacionProductoEstadistica) {
		this.activarprecio_ultima_cotizacionProductoEstadistica= activarprecio_ultima_cotizacionProductoEstadistica;
	}

	public Border setResaltarprecio_ultima_proformaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarprecio_ultima_proformaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ultima_proformaProductoEstadistica() {
		return this.resaltarprecio_ultima_proformaProductoEstadistica;
	}

	public void setResaltarprecio_ultima_proformaProductoEstadistica(Border borderResaltar) {
		this.resaltarprecio_ultima_proformaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarprecio_ultima_proformaProductoEstadistica() {
		return this.mostrarprecio_ultima_proformaProductoEstadistica;
	}

	public void setMostrarprecio_ultima_proformaProductoEstadistica(Boolean mostrarprecio_ultima_proformaProductoEstadistica) {
		this.mostrarprecio_ultima_proformaProductoEstadistica= mostrarprecio_ultima_proformaProductoEstadistica;
	}

	public Boolean getActivarprecio_ultima_proformaProductoEstadistica() {
		return this.activarprecio_ultima_proformaProductoEstadistica;
	}

	public void setActivarprecio_ultima_proformaProductoEstadistica(Boolean activarprecio_ultima_proformaProductoEstadistica) {
		this.activarprecio_ultima_proformaProductoEstadistica= activarprecio_ultima_proformaProductoEstadistica;
	}

	public Border setResaltarcantidad_disponibleProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleProductoEstadistica() {
		return this.resaltarcantidad_disponibleProductoEstadistica;
	}

	public void setResaltarcantidad_disponibleProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_disponibleProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleProductoEstadistica() {
		return this.mostrarcantidad_disponibleProductoEstadistica;
	}

	public void setMostrarcantidad_disponibleProductoEstadistica(Boolean mostrarcantidad_disponibleProductoEstadistica) {
		this.mostrarcantidad_disponibleProductoEstadistica= mostrarcantidad_disponibleProductoEstadistica;
	}

	public Boolean getActivarcantidad_disponibleProductoEstadistica() {
		return this.activarcantidad_disponibleProductoEstadistica;
	}

	public void setActivarcantidad_disponibleProductoEstadistica(Boolean activarcantidad_disponibleProductoEstadistica) {
		this.activarcantidad_disponibleProductoEstadistica= activarcantidad_disponibleProductoEstadistica;
	}

	public Border setResaltarcantidad_reservadaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_reservadaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_reservadaProductoEstadistica() {
		return this.resaltarcantidad_reservadaProductoEstadistica;
	}

	public void setResaltarcantidad_reservadaProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_reservadaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_reservadaProductoEstadistica() {
		return this.mostrarcantidad_reservadaProductoEstadistica;
	}

	public void setMostrarcantidad_reservadaProductoEstadistica(Boolean mostrarcantidad_reservadaProductoEstadistica) {
		this.mostrarcantidad_reservadaProductoEstadistica= mostrarcantidad_reservadaProductoEstadistica;
	}

	public Boolean getActivarcantidad_reservadaProductoEstadistica() {
		return this.activarcantidad_reservadaProductoEstadistica;
	}

	public void setActivarcantidad_reservadaProductoEstadistica(Boolean activarcantidad_reservadaProductoEstadistica) {
		this.activarcantidad_reservadaProductoEstadistica= activarcantidad_reservadaProductoEstadistica;
	}

	public Border setResaltarcantidad_demandaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_demandaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_demandaProductoEstadistica() {
		return this.resaltarcantidad_demandaProductoEstadistica;
	}

	public void setResaltarcantidad_demandaProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_demandaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_demandaProductoEstadistica() {
		return this.mostrarcantidad_demandaProductoEstadistica;
	}

	public void setMostrarcantidad_demandaProductoEstadistica(Boolean mostrarcantidad_demandaProductoEstadistica) {
		this.mostrarcantidad_demandaProductoEstadistica= mostrarcantidad_demandaProductoEstadistica;
	}

	public Boolean getActivarcantidad_demandaProductoEstadistica() {
		return this.activarcantidad_demandaProductoEstadistica;
	}

	public void setActivarcantidad_demandaProductoEstadistica(Boolean activarcantidad_demandaProductoEstadistica) {
		this.activarcantidad_demandaProductoEstadistica= activarcantidad_demandaProductoEstadistica;
	}

	public Border setResaltarcantidad_maximoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_maximoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_maximoProductoEstadistica() {
		return this.resaltarcantidad_maximoProductoEstadistica;
	}

	public void setResaltarcantidad_maximoProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_maximoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_maximoProductoEstadistica() {
		return this.mostrarcantidad_maximoProductoEstadistica;
	}

	public void setMostrarcantidad_maximoProductoEstadistica(Boolean mostrarcantidad_maximoProductoEstadistica) {
		this.mostrarcantidad_maximoProductoEstadistica= mostrarcantidad_maximoProductoEstadistica;
	}

	public Boolean getActivarcantidad_maximoProductoEstadistica() {
		return this.activarcantidad_maximoProductoEstadistica;
	}

	public void setActivarcantidad_maximoProductoEstadistica(Boolean activarcantidad_maximoProductoEstadistica) {
		this.activarcantidad_maximoProductoEstadistica= activarcantidad_maximoProductoEstadistica;
	}

	public Border setResaltarcantidad_minimoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_minimoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_minimoProductoEstadistica() {
		return this.resaltarcantidad_minimoProductoEstadistica;
	}

	public void setResaltarcantidad_minimoProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_minimoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_minimoProductoEstadistica() {
		return this.mostrarcantidad_minimoProductoEstadistica;
	}

	public void setMostrarcantidad_minimoProductoEstadistica(Boolean mostrarcantidad_minimoProductoEstadistica) {
		this.mostrarcantidad_minimoProductoEstadistica= mostrarcantidad_minimoProductoEstadistica;
	}

	public Boolean getActivarcantidad_minimoProductoEstadistica() {
		return this.activarcantidad_minimoProductoEstadistica;
	}

	public void setActivarcantidad_minimoProductoEstadistica(Boolean activarcantidad_minimoProductoEstadistica) {
		this.activarcantidad_minimoProductoEstadistica= activarcantidad_minimoProductoEstadistica;
	}

	public Border setResaltarcantidad_fisicaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_fisicaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_fisicaProductoEstadistica() {
		return this.resaltarcantidad_fisicaProductoEstadistica;
	}

	public void setResaltarcantidad_fisicaProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_fisicaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_fisicaProductoEstadistica() {
		return this.mostrarcantidad_fisicaProductoEstadistica;
	}

	public void setMostrarcantidad_fisicaProductoEstadistica(Boolean mostrarcantidad_fisicaProductoEstadistica) {
		this.mostrarcantidad_fisicaProductoEstadistica= mostrarcantidad_fisicaProductoEstadistica;
	}

	public Boolean getActivarcantidad_fisicaProductoEstadistica() {
		return this.activarcantidad_fisicaProductoEstadistica;
	}

	public void setActivarcantidad_fisicaProductoEstadistica(Boolean activarcantidad_fisicaProductoEstadistica) {
		this.activarcantidad_fisicaProductoEstadistica= activarcantidad_fisicaProductoEstadistica;
	}

	public Border setResaltarcantidad_orden_compraProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_orden_compraProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_orden_compraProductoEstadistica() {
		return this.resaltarcantidad_orden_compraProductoEstadistica;
	}

	public void setResaltarcantidad_orden_compraProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_orden_compraProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_orden_compraProductoEstadistica() {
		return this.mostrarcantidad_orden_compraProductoEstadistica;
	}

	public void setMostrarcantidad_orden_compraProductoEstadistica(Boolean mostrarcantidad_orden_compraProductoEstadistica) {
		this.mostrarcantidad_orden_compraProductoEstadistica= mostrarcantidad_orden_compraProductoEstadistica;
	}

	public Boolean getActivarcantidad_orden_compraProductoEstadistica() {
		return this.activarcantidad_orden_compraProductoEstadistica;
	}

	public void setActivarcantidad_orden_compraProductoEstadistica(Boolean activarcantidad_orden_compraProductoEstadistica) {
		this.activarcantidad_orden_compraProductoEstadistica= activarcantidad_orden_compraProductoEstadistica;
	}

	public Border setResaltarcantidad_pedidaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidaProductoEstadistica() {
		return this.resaltarcantidad_pedidaProductoEstadistica;
	}

	public void setResaltarcantidad_pedidaProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_pedidaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidaProductoEstadistica() {
		return this.mostrarcantidad_pedidaProductoEstadistica;
	}

	public void setMostrarcantidad_pedidaProductoEstadistica(Boolean mostrarcantidad_pedidaProductoEstadistica) {
		this.mostrarcantidad_pedidaProductoEstadistica= mostrarcantidad_pedidaProductoEstadistica;
	}

	public Boolean getActivarcantidad_pedidaProductoEstadistica() {
		return this.activarcantidad_pedidaProductoEstadistica;
	}

	public void setActivarcantidad_pedidaProductoEstadistica(Boolean activarcantidad_pedidaProductoEstadistica) {
		this.activarcantidad_pedidaProductoEstadistica= activarcantidad_pedidaProductoEstadistica;
	}

	public Border setResaltarcantidad_requisicionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcantidad_requisicionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_requisicionProductoEstadistica() {
		return this.resaltarcantidad_requisicionProductoEstadistica;
	}

	public void setResaltarcantidad_requisicionProductoEstadistica(Border borderResaltar) {
		this.resaltarcantidad_requisicionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcantidad_requisicionProductoEstadistica() {
		return this.mostrarcantidad_requisicionProductoEstadistica;
	}

	public void setMostrarcantidad_requisicionProductoEstadistica(Boolean mostrarcantidad_requisicionProductoEstadistica) {
		this.mostrarcantidad_requisicionProductoEstadistica= mostrarcantidad_requisicionProductoEstadistica;
	}

	public Boolean getActivarcantidad_requisicionProductoEstadistica() {
		return this.activarcantidad_requisicionProductoEstadistica;
	}

	public void setActivarcantidad_requisicionProductoEstadistica(Boolean activarcantidad_requisicionProductoEstadistica) {
		this.activarcantidad_requisicionProductoEstadistica= activarcantidad_requisicionProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_ingresoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_ingresoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_ingresoProductoEstadistica() {
		return this.resaltarfecha_ultima_ingresoProductoEstadistica;
	}

	public void setResaltarfecha_ultima_ingresoProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_ingresoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_ingresoProductoEstadistica() {
		return this.mostrarfecha_ultima_ingresoProductoEstadistica;
	}

	public void setMostrarfecha_ultima_ingresoProductoEstadistica(Boolean mostrarfecha_ultima_ingresoProductoEstadistica) {
		this.mostrarfecha_ultima_ingresoProductoEstadistica= mostrarfecha_ultima_ingresoProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_ingresoProductoEstadistica() {
		return this.activarfecha_ultima_ingresoProductoEstadistica;
	}

	public void setActivarfecha_ultima_ingresoProductoEstadistica(Boolean activarfecha_ultima_ingresoProductoEstadistica) {
		this.activarfecha_ultima_ingresoProductoEstadistica= activarfecha_ultima_ingresoProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_egresoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_egresoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_egresoProductoEstadistica() {
		return this.resaltarfecha_ultima_egresoProductoEstadistica;
	}

	public void setResaltarfecha_ultima_egresoProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_egresoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_egresoProductoEstadistica() {
		return this.mostrarfecha_ultima_egresoProductoEstadistica;
	}

	public void setMostrarfecha_ultima_egresoProductoEstadistica(Boolean mostrarfecha_ultima_egresoProductoEstadistica) {
		this.mostrarfecha_ultima_egresoProductoEstadistica= mostrarfecha_ultima_egresoProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_egresoProductoEstadistica() {
		return this.activarfecha_ultima_egresoProductoEstadistica;
	}

	public void setActivarfecha_ultima_egresoProductoEstadistica(Boolean activarfecha_ultima_egresoProductoEstadistica) {
		this.activarfecha_ultima_egresoProductoEstadistica= activarfecha_ultima_egresoProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_produccionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_produccionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_produccionProductoEstadistica() {
		return this.resaltarfecha_ultima_produccionProductoEstadistica;
	}

	public void setResaltarfecha_ultima_produccionProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_produccionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_produccionProductoEstadistica() {
		return this.mostrarfecha_ultima_produccionProductoEstadistica;
	}

	public void setMostrarfecha_ultima_produccionProductoEstadistica(Boolean mostrarfecha_ultima_produccionProductoEstadistica) {
		this.mostrarfecha_ultima_produccionProductoEstadistica= mostrarfecha_ultima_produccionProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_produccionProductoEstadistica() {
		return this.activarfecha_ultima_produccionProductoEstadistica;
	}

	public void setActivarfecha_ultima_produccionProductoEstadistica(Boolean activarfecha_ultima_produccionProductoEstadistica) {
		this.activarfecha_ultima_produccionProductoEstadistica= activarfecha_ultima_produccionProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_compraProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_compraProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_compraProductoEstadistica() {
		return this.resaltarfecha_ultima_compraProductoEstadistica;
	}

	public void setResaltarfecha_ultima_compraProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_compraProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_compraProductoEstadistica() {
		return this.mostrarfecha_ultima_compraProductoEstadistica;
	}

	public void setMostrarfecha_ultima_compraProductoEstadistica(Boolean mostrarfecha_ultima_compraProductoEstadistica) {
		this.mostrarfecha_ultima_compraProductoEstadistica= mostrarfecha_ultima_compraProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_compraProductoEstadistica() {
		return this.activarfecha_ultima_compraProductoEstadistica;
	}

	public void setActivarfecha_ultima_compraProductoEstadistica(Boolean activarfecha_ultima_compraProductoEstadistica) {
		this.activarfecha_ultima_compraProductoEstadistica= activarfecha_ultima_compraProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_ventaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_ventaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_ventaProductoEstadistica() {
		return this.resaltarfecha_ultima_ventaProductoEstadistica;
	}

	public void setResaltarfecha_ultima_ventaProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_ventaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_ventaProductoEstadistica() {
		return this.mostrarfecha_ultima_ventaProductoEstadistica;
	}

	public void setMostrarfecha_ultima_ventaProductoEstadistica(Boolean mostrarfecha_ultima_ventaProductoEstadistica) {
		this.mostrarfecha_ultima_ventaProductoEstadistica= mostrarfecha_ultima_ventaProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_ventaProductoEstadistica() {
		return this.activarfecha_ultima_ventaProductoEstadistica;
	}

	public void setActivarfecha_ultima_ventaProductoEstadistica(Boolean activarfecha_ultima_ventaProductoEstadistica) {
		this.activarfecha_ultima_ventaProductoEstadistica= activarfecha_ultima_ventaProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_devolucionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_devolucionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_devolucionProductoEstadistica() {
		return this.resaltarfecha_ultima_devolucionProductoEstadistica;
	}

	public void setResaltarfecha_ultima_devolucionProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_devolucionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_devolucionProductoEstadistica() {
		return this.mostrarfecha_ultima_devolucionProductoEstadistica;
	}

	public void setMostrarfecha_ultima_devolucionProductoEstadistica(Boolean mostrarfecha_ultima_devolucionProductoEstadistica) {
		this.mostrarfecha_ultima_devolucionProductoEstadistica= mostrarfecha_ultima_devolucionProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_devolucionProductoEstadistica() {
		return this.activarfecha_ultima_devolucionProductoEstadistica;
	}

	public void setActivarfecha_ultima_devolucionProductoEstadistica(Boolean activarfecha_ultima_devolucionProductoEstadistica) {
		this.activarfecha_ultima_devolucionProductoEstadistica= activarfecha_ultima_devolucionProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_orden_compraProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_orden_compraProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_orden_compraProductoEstadistica() {
		return this.resaltarfecha_ultima_orden_compraProductoEstadistica;
	}

	public void setResaltarfecha_ultima_orden_compraProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_orden_compraProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_orden_compraProductoEstadistica() {
		return this.mostrarfecha_ultima_orden_compraProductoEstadistica;
	}

	public void setMostrarfecha_ultima_orden_compraProductoEstadistica(Boolean mostrarfecha_ultima_orden_compraProductoEstadistica) {
		this.mostrarfecha_ultima_orden_compraProductoEstadistica= mostrarfecha_ultima_orden_compraProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_orden_compraProductoEstadistica() {
		return this.activarfecha_ultima_orden_compraProductoEstadistica;
	}

	public void setActivarfecha_ultima_orden_compraProductoEstadistica(Boolean activarfecha_ultima_orden_compraProductoEstadistica) {
		this.activarfecha_ultima_orden_compraProductoEstadistica= activarfecha_ultima_orden_compraProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_pedidoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_pedidoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_pedidoProductoEstadistica() {
		return this.resaltarfecha_ultima_pedidoProductoEstadistica;
	}

	public void setResaltarfecha_ultima_pedidoProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_pedidoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_pedidoProductoEstadistica() {
		return this.mostrarfecha_ultima_pedidoProductoEstadistica;
	}

	public void setMostrarfecha_ultima_pedidoProductoEstadistica(Boolean mostrarfecha_ultima_pedidoProductoEstadistica) {
		this.mostrarfecha_ultima_pedidoProductoEstadistica= mostrarfecha_ultima_pedidoProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_pedidoProductoEstadistica() {
		return this.activarfecha_ultima_pedidoProductoEstadistica;
	}

	public void setActivarfecha_ultima_pedidoProductoEstadistica(Boolean activarfecha_ultima_pedidoProductoEstadistica) {
		this.activarfecha_ultima_pedidoProductoEstadistica= activarfecha_ultima_pedidoProductoEstadistica;
	}

	public Border setResaltarfecha_ultima_requisicionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_requisicionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_requisicionProductoEstadistica() {
		return this.resaltarfecha_ultima_requisicionProductoEstadistica;
	}

	public void setResaltarfecha_ultima_requisicionProductoEstadistica(Border borderResaltar) {
		this.resaltarfecha_ultima_requisicionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_requisicionProductoEstadistica() {
		return this.mostrarfecha_ultima_requisicionProductoEstadistica;
	}

	public void setMostrarfecha_ultima_requisicionProductoEstadistica(Boolean mostrarfecha_ultima_requisicionProductoEstadistica) {
		this.mostrarfecha_ultima_requisicionProductoEstadistica= mostrarfecha_ultima_requisicionProductoEstadistica;
	}

	public Boolean getActivarfecha_ultima_requisicionProductoEstadistica() {
		return this.activarfecha_ultima_requisicionProductoEstadistica;
	}

	public void setActivarfecha_ultima_requisicionProductoEstadistica(Boolean activarfecha_ultima_requisicionProductoEstadistica) {
		this.activarfecha_ultima_requisicionProductoEstadistica= activarfecha_ultima_requisicionProductoEstadistica;
	}

	public Border setResaltartotal_ingresoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_ingresoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ingresoProductoEstadistica() {
		return this.resaltartotal_ingresoProductoEstadistica;
	}

	public void setResaltartotal_ingresoProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_ingresoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_ingresoProductoEstadistica() {
		return this.mostrartotal_ingresoProductoEstadistica;
	}

	public void setMostrartotal_ingresoProductoEstadistica(Boolean mostrartotal_ingresoProductoEstadistica) {
		this.mostrartotal_ingresoProductoEstadistica= mostrartotal_ingresoProductoEstadistica;
	}

	public Boolean getActivartotal_ingresoProductoEstadistica() {
		return this.activartotal_ingresoProductoEstadistica;
	}

	public void setActivartotal_ingresoProductoEstadistica(Boolean activartotal_ingresoProductoEstadistica) {
		this.activartotal_ingresoProductoEstadistica= activartotal_ingresoProductoEstadistica;
	}

	public Border setResaltartotal_egresoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_egresoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_egresoProductoEstadistica() {
		return this.resaltartotal_egresoProductoEstadistica;
	}

	public void setResaltartotal_egresoProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_egresoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_egresoProductoEstadistica() {
		return this.mostrartotal_egresoProductoEstadistica;
	}

	public void setMostrartotal_egresoProductoEstadistica(Boolean mostrartotal_egresoProductoEstadistica) {
		this.mostrartotal_egresoProductoEstadistica= mostrartotal_egresoProductoEstadistica;
	}

	public Boolean getActivartotal_egresoProductoEstadistica() {
		return this.activartotal_egresoProductoEstadistica;
	}

	public void setActivartotal_egresoProductoEstadistica(Boolean activartotal_egresoProductoEstadistica) {
		this.activartotal_egresoProductoEstadistica= activartotal_egresoProductoEstadistica;
	}

	public Border setResaltartotal_compraProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_compraProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_compraProductoEstadistica() {
		return this.resaltartotal_compraProductoEstadistica;
	}

	public void setResaltartotal_compraProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_compraProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_compraProductoEstadistica() {
		return this.mostrartotal_compraProductoEstadistica;
	}

	public void setMostrartotal_compraProductoEstadistica(Boolean mostrartotal_compraProductoEstadistica) {
		this.mostrartotal_compraProductoEstadistica= mostrartotal_compraProductoEstadistica;
	}

	public Boolean getActivartotal_compraProductoEstadistica() {
		return this.activartotal_compraProductoEstadistica;
	}

	public void setActivartotal_compraProductoEstadistica(Boolean activartotal_compraProductoEstadistica) {
		this.activartotal_compraProductoEstadistica= activartotal_compraProductoEstadistica;
	}

	public Border setResaltartotal_ventaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_ventaProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ventaProductoEstadistica() {
		return this.resaltartotal_ventaProductoEstadistica;
	}

	public void setResaltartotal_ventaProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_ventaProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_ventaProductoEstadistica() {
		return this.mostrartotal_ventaProductoEstadistica;
	}

	public void setMostrartotal_ventaProductoEstadistica(Boolean mostrartotal_ventaProductoEstadistica) {
		this.mostrartotal_ventaProductoEstadistica= mostrartotal_ventaProductoEstadistica;
	}

	public Boolean getActivartotal_ventaProductoEstadistica() {
		return this.activartotal_ventaProductoEstadistica;
	}

	public void setActivartotal_ventaProductoEstadistica(Boolean activartotal_ventaProductoEstadistica) {
		this.activartotal_ventaProductoEstadistica= activartotal_ventaProductoEstadistica;
	}

	public Border setResaltartotal_producidoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_producidoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_producidoProductoEstadistica() {
		return this.resaltartotal_producidoProductoEstadistica;
	}

	public void setResaltartotal_producidoProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_producidoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_producidoProductoEstadistica() {
		return this.mostrartotal_producidoProductoEstadistica;
	}

	public void setMostrartotal_producidoProductoEstadistica(Boolean mostrartotal_producidoProductoEstadistica) {
		this.mostrartotal_producidoProductoEstadistica= mostrartotal_producidoProductoEstadistica;
	}

	public Boolean getActivartotal_producidoProductoEstadistica() {
		return this.activartotal_producidoProductoEstadistica;
	}

	public void setActivartotal_producidoProductoEstadistica(Boolean activartotal_producidoProductoEstadistica) {
		this.activartotal_producidoProductoEstadistica= activartotal_producidoProductoEstadistica;
	}

	public Border setResaltartotal_devueltoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltartotal_devueltoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_devueltoProductoEstadistica() {
		return this.resaltartotal_devueltoProductoEstadistica;
	}

	public void setResaltartotal_devueltoProductoEstadistica(Border borderResaltar) {
		this.resaltartotal_devueltoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrartotal_devueltoProductoEstadistica() {
		return this.mostrartotal_devueltoProductoEstadistica;
	}

	public void setMostrartotal_devueltoProductoEstadistica(Boolean mostrartotal_devueltoProductoEstadistica) {
		this.mostrartotal_devueltoProductoEstadistica= mostrartotal_devueltoProductoEstadistica;
	}

	public Boolean getActivartotal_devueltoProductoEstadistica() {
		return this.activartotal_devueltoProductoEstadistica;
	}

	public void setActivartotal_devueltoProductoEstadistica(Boolean activartotal_devueltoProductoEstadistica) {
		this.activartotal_devueltoProductoEstadistica= activartotal_devueltoProductoEstadistica;
	}

	public Border setResaltarcosto_ultimoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcosto_ultimoProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ultimoProductoEstadistica() {
		return this.resaltarcosto_ultimoProductoEstadistica;
	}

	public void setResaltarcosto_ultimoProductoEstadistica(Border borderResaltar) {
		this.resaltarcosto_ultimoProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcosto_ultimoProductoEstadistica() {
		return this.mostrarcosto_ultimoProductoEstadistica;
	}

	public void setMostrarcosto_ultimoProductoEstadistica(Boolean mostrarcosto_ultimoProductoEstadistica) {
		this.mostrarcosto_ultimoProductoEstadistica= mostrarcosto_ultimoProductoEstadistica;
	}

	public Boolean getActivarcosto_ultimoProductoEstadistica() {
		return this.activarcosto_ultimoProductoEstadistica;
	}

	public void setActivarcosto_ultimoProductoEstadistica(Boolean activarcosto_ultimoProductoEstadistica) {
		this.activarcosto_ultimoProductoEstadistica= activarcosto_ultimoProductoEstadistica;
	}

	public Border setResaltarcosto_totalProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcosto_totalProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalProductoEstadistica() {
		return this.resaltarcosto_totalProductoEstadistica;
	}

	public void setResaltarcosto_totalProductoEstadistica(Border borderResaltar) {
		this.resaltarcosto_totalProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcosto_totalProductoEstadistica() {
		return this.mostrarcosto_totalProductoEstadistica;
	}

	public void setMostrarcosto_totalProductoEstadistica(Boolean mostrarcosto_totalProductoEstadistica) {
		this.mostrarcosto_totalProductoEstadistica= mostrarcosto_totalProductoEstadistica;
	}

	public Boolean getActivarcosto_totalProductoEstadistica() {
		return this.activarcosto_totalProductoEstadistica;
	}

	public void setActivarcosto_totalProductoEstadistica(Boolean activarcosto_totalProductoEstadistica) {
		this.activarcosto_totalProductoEstadistica= activarcosto_totalProductoEstadistica;
	}

	public Border setResaltarcosto_produccionProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoestadisticaBeanSwingJInternalFrame.jTtoolBarProductoEstadistica.setBorder(borderResaltar);
		
		this.resaltarcosto_produccionProductoEstadistica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_produccionProductoEstadistica() {
		return this.resaltarcosto_produccionProductoEstadistica;
	}

	public void setResaltarcosto_produccionProductoEstadistica(Border borderResaltar) {
		this.resaltarcosto_produccionProductoEstadistica= borderResaltar;
	}

	public Boolean getMostrarcosto_produccionProductoEstadistica() {
		return this.mostrarcosto_produccionProductoEstadistica;
	}

	public void setMostrarcosto_produccionProductoEstadistica(Boolean mostrarcosto_produccionProductoEstadistica) {
		this.mostrarcosto_produccionProductoEstadistica= mostrarcosto_produccionProductoEstadistica;
	}

	public Boolean getActivarcosto_produccionProductoEstadistica() {
		return this.activarcosto_produccionProductoEstadistica;
	}

	public void setActivarcosto_produccionProductoEstadistica(Boolean activarcosto_produccionProductoEstadistica) {
		this.activarcosto_produccionProductoEstadistica= activarcosto_produccionProductoEstadistica;
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
		
		
		this.setMostraridProductoEstadistica(esInicial);
		this.setMostrarid_empresaProductoEstadistica(esInicial);
		this.setMostrarid_sucursalProductoEstadistica(esInicial);
		this.setMostrarid_bodegaProductoEstadistica(esInicial);
		this.setMostrarid_productoProductoEstadistica(esInicial);
		this.setMostrarprecio_ultima_compraProductoEstadistica(esInicial);
		this.setMostrarprecio_ultima_ventaProductoEstadistica(esInicial);
		this.setMostrarprecio_ultima_cotizacionProductoEstadistica(esInicial);
		this.setMostrarprecio_ultima_proformaProductoEstadistica(esInicial);
		this.setMostrarcantidad_disponibleProductoEstadistica(esInicial);
		this.setMostrarcantidad_reservadaProductoEstadistica(esInicial);
		this.setMostrarcantidad_demandaProductoEstadistica(esInicial);
		this.setMostrarcantidad_maximoProductoEstadistica(esInicial);
		this.setMostrarcantidad_minimoProductoEstadistica(esInicial);
		this.setMostrarcantidad_fisicaProductoEstadistica(esInicial);
		this.setMostrarcantidad_orden_compraProductoEstadistica(esInicial);
		this.setMostrarcantidad_pedidaProductoEstadistica(esInicial);
		this.setMostrarcantidad_requisicionProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_ingresoProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_egresoProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_produccionProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_compraProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_ventaProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_devolucionProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_orden_compraProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_pedidoProductoEstadistica(esInicial);
		this.setMostrarfecha_ultima_requisicionProductoEstadistica(esInicial);
		this.setMostrartotal_ingresoProductoEstadistica(esInicial);
		this.setMostrartotal_egresoProductoEstadistica(esInicial);
		this.setMostrartotal_compraProductoEstadistica(esInicial);
		this.setMostrartotal_ventaProductoEstadistica(esInicial);
		this.setMostrartotal_producidoProductoEstadistica(esInicial);
		this.setMostrartotal_devueltoProductoEstadistica(esInicial);
		this.setMostrarcosto_ultimoProductoEstadistica(esInicial);
		this.setMostrarcosto_totalProductoEstadistica(esInicial);
		this.setMostrarcosto_produccionProductoEstadistica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.ID)) {
				this.setMostraridProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA)) {
				this.setMostrarprecio_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA)) {
				this.setMostrarprecio_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION)) {
				this.setMostrarprecio_ultima_cotizacionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA)) {
				this.setMostrarprecio_ultima_proformaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA)) {
				this.setMostrarcantidad_reservadaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA)) {
				this.setMostrarcantidad_demandaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO)) {
				this.setMostrarcantidad_maximoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO)) {
				this.setMostrarcantidad_minimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADFISICA)) {
				this.setMostrarcantidad_fisicaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA)) {
				this.setMostrarcantidad_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA)) {
				this.setMostrarcantidad_pedidaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION)) {
				this.setMostrarcantidad_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO)) {
				this.setMostrarfecha_ultima_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO)) {
				this.setMostrarfecha_ultima_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION)) {
				this.setMostrarfecha_ultima_produccionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setMostrarfecha_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setMostrarfecha_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setMostrarfecha_ultima_devolucionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA)) {
				this.setMostrarfecha_ultima_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO)) {
				this.setMostrarfecha_ultima_pedidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION)) {
				this.setMostrarfecha_ultima_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALINGRESO)) {
				this.setMostrartotal_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALEGRESO)) {
				this.setMostrartotal_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALCOMPRA)) {
				this.setMostrartotal_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALVENTA)) {
				this.setMostrartotal_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO)) {
				this.setMostrartotal_producidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO)) {
				this.setMostrartotal_devueltoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOULTIMO)) {
				this.setMostrarcosto_ultimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION)) {
				this.setMostrarcosto_produccionProductoEstadistica(esAsigna);
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
		
		
		this.setActivaridProductoEstadistica(esInicial);
		this.setActivarid_empresaProductoEstadistica(esInicial);
		this.setActivarid_sucursalProductoEstadistica(esInicial);
		this.setActivarid_bodegaProductoEstadistica(esInicial);
		this.setActivarid_productoProductoEstadistica(esInicial);
		this.setActivarprecio_ultima_compraProductoEstadistica(esInicial);
		this.setActivarprecio_ultima_ventaProductoEstadistica(esInicial);
		this.setActivarprecio_ultima_cotizacionProductoEstadistica(esInicial);
		this.setActivarprecio_ultima_proformaProductoEstadistica(esInicial);
		this.setActivarcantidad_disponibleProductoEstadistica(esInicial);
		this.setActivarcantidad_reservadaProductoEstadistica(esInicial);
		this.setActivarcantidad_demandaProductoEstadistica(esInicial);
		this.setActivarcantidad_maximoProductoEstadistica(esInicial);
		this.setActivarcantidad_minimoProductoEstadistica(esInicial);
		this.setActivarcantidad_fisicaProductoEstadistica(esInicial);
		this.setActivarcantidad_orden_compraProductoEstadistica(esInicial);
		this.setActivarcantidad_pedidaProductoEstadistica(esInicial);
		this.setActivarcantidad_requisicionProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_ingresoProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_egresoProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_produccionProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_compraProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_ventaProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_devolucionProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_orden_compraProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_pedidoProductoEstadistica(esInicial);
		this.setActivarfecha_ultima_requisicionProductoEstadistica(esInicial);
		this.setActivartotal_ingresoProductoEstadistica(esInicial);
		this.setActivartotal_egresoProductoEstadistica(esInicial);
		this.setActivartotal_compraProductoEstadistica(esInicial);
		this.setActivartotal_ventaProductoEstadistica(esInicial);
		this.setActivartotal_producidoProductoEstadistica(esInicial);
		this.setActivartotal_devueltoProductoEstadistica(esInicial);
		this.setActivarcosto_ultimoProductoEstadistica(esInicial);
		this.setActivarcosto_totalProductoEstadistica(esInicial);
		this.setActivarcosto_produccionProductoEstadistica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.ID)) {
				this.setActivaridProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA)) {
				this.setActivarprecio_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA)) {
				this.setActivarprecio_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION)) {
				this.setActivarprecio_ultima_cotizacionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA)) {
				this.setActivarprecio_ultima_proformaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA)) {
				this.setActivarcantidad_reservadaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA)) {
				this.setActivarcantidad_demandaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO)) {
				this.setActivarcantidad_maximoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO)) {
				this.setActivarcantidad_minimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADFISICA)) {
				this.setActivarcantidad_fisicaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA)) {
				this.setActivarcantidad_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA)) {
				this.setActivarcantidad_pedidaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION)) {
				this.setActivarcantidad_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO)) {
				this.setActivarfecha_ultima_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO)) {
				this.setActivarfecha_ultima_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION)) {
				this.setActivarfecha_ultima_produccionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setActivarfecha_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setActivarfecha_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setActivarfecha_ultima_devolucionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA)) {
				this.setActivarfecha_ultima_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO)) {
				this.setActivarfecha_ultima_pedidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION)) {
				this.setActivarfecha_ultima_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALINGRESO)) {
				this.setActivartotal_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALEGRESO)) {
				this.setActivartotal_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALCOMPRA)) {
				this.setActivartotal_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALVENTA)) {
				this.setActivartotal_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO)) {
				this.setActivartotal_producidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO)) {
				this.setActivartotal_devueltoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOULTIMO)) {
				this.setActivarcosto_ultimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION)) {
				this.setActivarcosto_produccionProductoEstadistica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductoEstadistica(esInicial);
		this.setResaltarid_empresaProductoEstadistica(esInicial);
		this.setResaltarid_sucursalProductoEstadistica(esInicial);
		this.setResaltarid_bodegaProductoEstadistica(esInicial);
		this.setResaltarid_productoProductoEstadistica(esInicial);
		this.setResaltarprecio_ultima_compraProductoEstadistica(esInicial);
		this.setResaltarprecio_ultima_ventaProductoEstadistica(esInicial);
		this.setResaltarprecio_ultima_cotizacionProductoEstadistica(esInicial);
		this.setResaltarprecio_ultima_proformaProductoEstadistica(esInicial);
		this.setResaltarcantidad_disponibleProductoEstadistica(esInicial);
		this.setResaltarcantidad_reservadaProductoEstadistica(esInicial);
		this.setResaltarcantidad_demandaProductoEstadistica(esInicial);
		this.setResaltarcantidad_maximoProductoEstadistica(esInicial);
		this.setResaltarcantidad_minimoProductoEstadistica(esInicial);
		this.setResaltarcantidad_fisicaProductoEstadistica(esInicial);
		this.setResaltarcantidad_orden_compraProductoEstadistica(esInicial);
		this.setResaltarcantidad_pedidaProductoEstadistica(esInicial);
		this.setResaltarcantidad_requisicionProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_ingresoProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_egresoProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_produccionProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_compraProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_ventaProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_devolucionProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_orden_compraProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_pedidoProductoEstadistica(esInicial);
		this.setResaltarfecha_ultima_requisicionProductoEstadistica(esInicial);
		this.setResaltartotal_ingresoProductoEstadistica(esInicial);
		this.setResaltartotal_egresoProductoEstadistica(esInicial);
		this.setResaltartotal_compraProductoEstadistica(esInicial);
		this.setResaltartotal_ventaProductoEstadistica(esInicial);
		this.setResaltartotal_producidoProductoEstadistica(esInicial);
		this.setResaltartotal_devueltoProductoEstadistica(esInicial);
		this.setResaltarcosto_ultimoProductoEstadistica(esInicial);
		this.setResaltarcosto_totalProductoEstadistica(esInicial);
		this.setResaltarcosto_produccionProductoEstadistica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.ID)) {
				this.setResaltaridProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA)) {
				this.setResaltarprecio_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA)) {
				this.setResaltarprecio_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION)) {
				this.setResaltarprecio_ultima_cotizacionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA)) {
				this.setResaltarprecio_ultima_proformaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA)) {
				this.setResaltarcantidad_reservadaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA)) {
				this.setResaltarcantidad_demandaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO)) {
				this.setResaltarcantidad_maximoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO)) {
				this.setResaltarcantidad_minimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADFISICA)) {
				this.setResaltarcantidad_fisicaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA)) {
				this.setResaltarcantidad_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA)) {
				this.setResaltarcantidad_pedidaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION)) {
				this.setResaltarcantidad_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO)) {
				this.setResaltarfecha_ultima_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO)) {
				this.setResaltarfecha_ultima_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION)) {
				this.setResaltarfecha_ultima_produccionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setResaltarfecha_ultima_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setResaltarfecha_ultima_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION)) {
				this.setResaltarfecha_ultima_devolucionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA)) {
				this.setResaltarfecha_ultima_orden_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO)) {
				this.setResaltarfecha_ultima_pedidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION)) {
				this.setResaltarfecha_ultima_requisicionProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALINGRESO)) {
				this.setResaltartotal_ingresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALEGRESO)) {
				this.setResaltartotal_egresoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALCOMPRA)) {
				this.setResaltartotal_compraProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALVENTA)) {
				this.setResaltartotal_ventaProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO)) {
				this.setResaltartotal_producidoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO)) {
				this.setResaltartotal_devueltoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOULTIMO)) {
				this.setResaltarcosto_ultimoProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalProductoEstadistica(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION)) {
				this.setResaltarcosto_produccionProductoEstadistica(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaProductoEstadistica=true;

	public Boolean getMostrarFK_IdBodegaProductoEstadistica() {
		return this.mostrarFK_IdBodegaProductoEstadistica;
	}

	public void setMostrarFK_IdBodegaProductoEstadistica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaProductoEstadistica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProductoEstadistica=true;

	public Boolean getMostrarFK_IdEmpresaProductoEstadistica() {
		return this.mostrarFK_IdEmpresaProductoEstadistica;
	}

	public void setMostrarFK_IdEmpresaProductoEstadistica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProductoEstadistica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoProductoEstadistica=true;

	public Boolean getMostrarFK_IdProductoProductoEstadistica() {
		return this.mostrarFK_IdProductoProductoEstadistica;
	}

	public void setMostrarFK_IdProductoProductoEstadistica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoProductoEstadistica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProductoEstadistica=true;

	public Boolean getMostrarFK_IdSucursalProductoEstadistica() {
		return this.mostrarFK_IdSucursalProductoEstadistica;
	}

	public void setMostrarFK_IdSucursalProductoEstadistica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProductoEstadistica= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaProductoEstadistica=true;

	public Boolean getActivarFK_IdBodegaProductoEstadistica() {
		return this.activarFK_IdBodegaProductoEstadistica;
	}

	public void setActivarFK_IdBodegaProductoEstadistica(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaProductoEstadistica= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProductoEstadistica=true;

	public Boolean getActivarFK_IdEmpresaProductoEstadistica() {
		return this.activarFK_IdEmpresaProductoEstadistica;
	}

	public void setActivarFK_IdEmpresaProductoEstadistica(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProductoEstadistica= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoProductoEstadistica=true;

	public Boolean getActivarFK_IdProductoProductoEstadistica() {
		return this.activarFK_IdProductoProductoEstadistica;
	}

	public void setActivarFK_IdProductoProductoEstadistica(Boolean habilitarResaltar) {
		this.activarFK_IdProductoProductoEstadistica= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProductoEstadistica=true;

	public Boolean getActivarFK_IdSucursalProductoEstadistica() {
		return this.activarFK_IdSucursalProductoEstadistica;
	}

	public void setActivarFK_IdSucursalProductoEstadistica(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProductoEstadistica= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaProductoEstadistica=null;

	public Border getResaltarFK_IdBodegaProductoEstadistica() {
		return this.resaltarFK_IdBodegaProductoEstadistica;
	}

	public void setResaltarFK_IdBodegaProductoEstadistica(Border borderResaltar) {
		this.resaltarFK_IdBodegaProductoEstadistica= borderResaltar;
	}

	public void setResaltarFK_IdBodegaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaProductoEstadistica= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProductoEstadistica=null;

	public Border getResaltarFK_IdEmpresaProductoEstadistica() {
		return this.resaltarFK_IdEmpresaProductoEstadistica;
	}

	public void setResaltarFK_IdEmpresaProductoEstadistica(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProductoEstadistica= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProductoEstadistica= borderResaltar;
	}

	public Border resaltarFK_IdProductoProductoEstadistica=null;

	public Border getResaltarFK_IdProductoProductoEstadistica() {
		return this.resaltarFK_IdProductoProductoEstadistica;
	}

	public void setResaltarFK_IdProductoProductoEstadistica(Border borderResaltar) {
		this.resaltarFK_IdProductoProductoEstadistica= borderResaltar;
	}

	public void setResaltarFK_IdProductoProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoProductoEstadistica= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProductoEstadistica=null;

	public Border getResaltarFK_IdSucursalProductoEstadistica() {
		return this.resaltarFK_IdSucursalProductoEstadistica;
	}

	public void setResaltarFK_IdSucursalProductoEstadistica(Border borderResaltar) {
		this.resaltarFK_IdSucursalProductoEstadistica= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProductoEstadistica(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoEstadisticaBeanSwingJInternalFrame productoestadisticaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProductoEstadistica= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}