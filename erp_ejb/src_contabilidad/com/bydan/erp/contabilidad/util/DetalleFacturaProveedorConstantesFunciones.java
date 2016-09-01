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


import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleFacturaProveedorConstantesFunciones extends DetalleFacturaProveedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleFacturaProveedor";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleFacturaProveedor"+DetalleFacturaProveedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleFacturaProveedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleFacturaProveedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleFacturaProveedorConstantesFunciones.SCHEMA+"_"+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleFacturaProveedorConstantesFunciones.SCHEMA+"_"+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleFacturaProveedorConstantesFunciones.SCHEMA+"_"+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleFacturaProveedorConstantesFunciones.SCHEMA+"_"+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleFacturaProveedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleFacturaProveedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleFacturaProveedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleFacturaProveedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Factura Proveedores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Factura Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Factura Proveedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleFacturaProveedor";
	public static final String OBJECTNAME="detallefacturaproveedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="detalle_factura_proveedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallefacturaproveedor from "+DetalleFacturaProveedorConstantesFunciones.SPERSISTENCENAME+" detallefacturaproveedor";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_factura_proveedor,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_bodega,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_producto,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_unidad,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_periodo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".cantidad,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".cantidad_auxiliar,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".iva,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_iva,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".costo_total,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".ice,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento1,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descuento2,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".descripcion,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".precio_venta,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_bodega_enviar,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".lote_cliente,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".disponible,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".serie,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".ice_valor,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_anio,"+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME+".id_mes from "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+"."+DetalleFacturaProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaProveedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleFacturaProveedorConstantesFuncionesAdditional detallefacturaproveedorConstantesFuncionesAdditional=null;
	
	public DetalleFacturaProveedorConstantesFuncionesAdditional getDetalleFacturaProveedorConstantesFuncionesAdditional() {
		return this.detallefacturaproveedorConstantesFuncionesAdditional;
	}
	
	public void setDetalleFacturaProveedorConstantesFuncionesAdditional(DetalleFacturaProveedorConstantesFuncionesAdditional detallefacturaproveedorConstantesFuncionesAdditional) {
		try {
			this.detallefacturaproveedorConstantesFuncionesAdditional=detallefacturaproveedorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDFACTURAPROVEEDOR= "id_factura_proveedor";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String CANTIDAD= "cantidad";
    public static final String CANTIDADAUXILIAR= "cantidad_auxiliar";
    public static final String DESCUENTO= "descuento";
    public static final String IVA= "iva";
    public static final String LOTE= "lote";
    public static final String FECHAELABORACIONLOTE= "fecha_elaboracion_lote";
    public static final String FECHACADUCIDADLOTE= "fecha_caducidad_lote";
    public static final String COSTOIVA= "costo_iva";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String ICE= "ice";
    public static final String DESCUENTO1= "descuento1";
    public static final String DESCUENTO2= "descuento2";
    public static final String DESCRIPCION= "descripcion";
    public static final String PRECIOVENTA= "precio_venta";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String IDBODEGAENVIAR= "id_bodega_enviar";
    public static final String LOTECLIENTE= "lote_cliente";
    public static final String DISPONIBLE= "disponible";
    public static final String SERIE= "serie";
    public static final String ICEVALOR= "ice_valor";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDFACTURAPROVEEDOR= "Factura Proveedor";
		public static final String LABEL_IDFACTURAPROVEEDOR_LOWER= "Factura Proveedor";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_CANTIDADAUXILIAR= "Cantad Auxiliar";
		public static final String LABEL_CANTIDADAUXILIAR_LOWER= "Cantidad Auxiliar";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_FECHAELABORACIONLOTE= "Fecha Elaboracion Lote";
		public static final String LABEL_FECHAELABORACIONLOTE_LOWER= "Fecha Elaboracion Lote";
    	public static final String LABEL_FECHACADUCIDADLOTE= "Fecha Caducad Lote";
		public static final String LABEL_FECHACADUCIDADLOTE_LOWER= "Fecha Caducidad Lote";
    	public static final String LABEL_COSTOIVA= "Costo Iva";
		public static final String LABEL_COSTOIVA_LOWER= "Costo Iva";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_DESCUENTO1= "Descuento1";
		public static final String LABEL_DESCUENTO1_LOWER= "Descuento1";
    	public static final String LABEL_DESCUENTO2= "Descuento2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PRECIOVENTA= "Precio Venta";
		public static final String LABEL_PRECIOVENTA_LOWER= "Precio Venta";
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad Producto";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "Cuenta Contable Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
    	public static final String LABEL_IDBODEGAENVIAR= "Bodega Enviar";
		public static final String LABEL_IDBODEGAENVIAR_LOWER= "Bodega Enviar";
    	public static final String LABEL_LOTECLIENTE= "Lote Cliente";
		public static final String LABEL_LOTECLIENTE_LOWER= "Lote Cliente";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_ICEVALOR= "Ice Valor";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXLOTE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getDetalleFacturaProveedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDFACTURAPROVEEDOR;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDADAUXILIAR;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IVA)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.LOTE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_FECHAELABORACIONLOTE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_FECHACADUCIDADLOTE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.COSTOIVA)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOIVA;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.ICE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGAENVIAR;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_LOTECLIENTE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.SERIE)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDANIO)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleFacturaProveedorConstantesFunciones.IDMES)) {sLabelColumna=DetalleFacturaProveedorConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcosto_ivaDescripcion(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallefacturaproveedor.getcosto_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcosto_ivaHtmlDescripcion(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallefacturaproveedor.getId(),detallefacturaproveedor.getcosto_iva());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleFacturaProveedorDescripcion(DetalleFacturaProveedor detallefacturaproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallefacturaproveedor !=null/* && detallefacturaproveedor.getId()!=0*/) {
			if(detallefacturaproveedor.getId()!=null) {
				sDescripcion=detallefacturaproveedor.getId().toString();
			}//detallefacturaproveedordetallefacturaproveedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleFacturaProveedorDescripcionDetallado(DetalleFacturaProveedor detallefacturaproveedor) {
		String sDescripcion="";
			
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.ID+"=";
		sDescripcion+=detallefacturaproveedor.getId().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallefacturaproveedor.getVersionRow().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR+"=";
		sDescripcion+=detallefacturaproveedor.getid_factura_proveedor().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallefacturaproveedor.getid_empresa().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallefacturaproveedor.getid_sucursal().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallefacturaproveedor.getid_bodega().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallefacturaproveedor.getid_producto().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallefacturaproveedor.getid_unidad().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallefacturaproveedor.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallefacturaproveedor.getid_periodo().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detallefacturaproveedor.getnumero_comprobante()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallefacturaproveedor.getcantidad().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR+"=";
		sDescripcion+=detallefacturaproveedor.getcantidad_auxiliar().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallefacturaproveedor.getdescuento().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IVA+"=";
		sDescripcion+=detallefacturaproveedor.getiva().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.LOTE+"=";
		sDescripcion+=detallefacturaproveedor.getlote()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE+"=";
		sDescripcion+=detallefacturaproveedor.getfecha_elaboracion_lote().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE+"=";
		sDescripcion+=detallefacturaproveedor.getfecha_caducidad_lote().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.COSTOIVA+"=";
		sDescripcion+=detallefacturaproveedor.getcosto_iva().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detallefacturaproveedor.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detallefacturaproveedor.getcosto_total().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.ICE+"=";
		sDescripcion+=detallefacturaproveedor.getice().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.DESCUENTO1+"=";
		sDescripcion+=detallefacturaproveedor.getdescuento1().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detallefacturaproveedor.getdescuento2().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallefacturaproveedor.getdescripcion()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA+"=";
		sDescripcion+=detallefacturaproveedor.getprecio_venta().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=detallefacturaproveedor.getid_novedad_producto().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallefacturaproveedor.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=detallefacturaproveedor.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR+"=";
		sDescripcion+=detallefacturaproveedor.getid_bodega_enviar().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detallefacturaproveedor.getlote_cliente()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=detallefacturaproveedor.getdisponible().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.SERIE+"=";
		sDescripcion+=detallefacturaproveedor.getserie()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallefacturaproveedor.getice_valor().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallefacturaproveedor.getid_anio().toString()+",";
		sDescripcion+=DetalleFacturaProveedorConstantesFunciones.IDMES+"=";
		sDescripcion+=detallefacturaproveedor.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleFacturaProveedorDescripcion(DetalleFacturaProveedor detallefacturaproveedor,String sValor) throws Exception {			
		if(detallefacturaproveedor !=null) {
			//detallefacturaproveedordetallefacturaproveedor.getId().toString();
		}		
	}
	
		

	public static String getFacturaProveedorDescripcion(FacturaProveedor facturaproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(facturaproveedor!=null/*&&facturaproveedor.getId()>0*/) {
			sDescripcion=FacturaProveedorConstantesFunciones.getFacturaProveedorDescripcion(facturaproveedor);
		}

		return sDescripcion;
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

	public static String getNovedadProductoDescripcion(NovedadProducto novedadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(novedadproducto!=null/*&&novedadproducto.getId()>0*/) {
			sDescripcion=NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(novedadproducto);
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

	public static String getCuentaContableCostoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getBodegaEnviarDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaEnviar")) {
			sNombreIndice="Tipo=  Por Bodega Enviar";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFacturaProveedor")) {
			sNombreIndice="Tipo=  Por Factura Proveedor";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNovedadProducto")) {
			sNombreIndice="Tipo=  Por Novedad Producto";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
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

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaEnviar(Long id_bodega_enviar) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_enviar!=null) {sDetalleIndice+=" Codigo Unico De Bodega Enviar="+id_bodega_enviar.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCosto(Long id_cuenta_contable_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Costo="+id_cuenta_contable_costo.toString();} 

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

	public static String getDetalleIndiceFK_IdFacturaProveedor(Long id_factura_proveedor) {
		String sDetalleIndice=" Parametros->";
		if(id_factura_proveedor!=null) {sDetalleIndice+=" Codigo Unico De Factura Proveedor="+id_factura_proveedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNovedadProducto(Long id_novedad_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_novedad_producto!=null) {sDetalleIndice+=" Codigo Unico De Novedad Producto="+id_novedad_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

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
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturaproveedor.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante().trim());
		detallefacturaproveedor.setlote(detallefacturaproveedor.getlote().trim());
		detallefacturaproveedor.setdescripcion(detallefacturaproveedor.getdescripcion().trim());
		detallefacturaproveedor.setlote_cliente(detallefacturaproveedor.getlote_cliente().trim());
		detallefacturaproveedor.setserie(detallefacturaproveedor.getserie().trim());
	}
	
	public static void quitarEspaciosDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {
			detallefacturaproveedor.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante().trim());
			detallefacturaproveedor.setlote(detallefacturaproveedor.getlote().trim());
			detallefacturaproveedor.setdescripcion(detallefacturaproveedor.getdescripcion().trim());
			detallefacturaproveedor.setlote_cliente(detallefacturaproveedor.getlote_cliente().trim());
			detallefacturaproveedor.setserie(detallefacturaproveedor.getserie().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallefacturaproveedor.getConCambioAuxiliar()) {
			detallefacturaproveedor.setIsDeleted(detallefacturaproveedor.getIsDeletedAuxiliar());	
			detallefacturaproveedor.setIsNew(detallefacturaproveedor.getIsNewAuxiliar());	
			detallefacturaproveedor.setIsChanged(detallefacturaproveedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallefacturaproveedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallefacturaproveedor.setIsDeletedAuxiliar(false);	
			detallefacturaproveedor.setIsNewAuxiliar(false);	
			detallefacturaproveedor.setIsChangedAuxiliar(false);
			
			detallefacturaproveedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor : detallefacturaproveedors) {
			if(conAsignarBase && detallefacturaproveedor.getConCambioAuxiliar()) {
				detallefacturaproveedor.setIsDeleted(detallefacturaproveedor.getIsDeletedAuxiliar());	
				detallefacturaproveedor.setIsNew(detallefacturaproveedor.getIsNewAuxiliar());	
				detallefacturaproveedor.setIsChanged(detallefacturaproveedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallefacturaproveedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallefacturaproveedor.setIsDeletedAuxiliar(false);	
				detallefacturaproveedor.setIsNewAuxiliar(false);	
				detallefacturaproveedor.setIsChangedAuxiliar(false);
				
				detallefacturaproveedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor,Boolean conEnteros) throws Exception  {
		detallefacturaproveedor.setdescuento(0.0);
		detallefacturaproveedor.setiva(0.0);
		detallefacturaproveedor.setcosto_unitario(0.0);
		detallefacturaproveedor.setcosto_total(0.0);
		detallefacturaproveedor.setice(0.0);
		detallefacturaproveedor.setdescuento1(0.0);
		detallefacturaproveedor.setdescuento2(0.0);
		detallefacturaproveedor.setprecio_venta(0.0);
		detallefacturaproveedor.setdisponible(0.0);
		detallefacturaproveedor.setice_valor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallefacturaproveedor.setcantidad(0);
			detallefacturaproveedor.setcantidad_auxiliar(0);
		}
	}		
	
	public static void InicializarValoresDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors,Boolean conEnteros) throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {
			detallefacturaproveedor.setdescuento(0.0);
			detallefacturaproveedor.setiva(0.0);
			detallefacturaproveedor.setcosto_unitario(0.0);
			detallefacturaproveedor.setcosto_total(0.0);
			detallefacturaproveedor.setice(0.0);
			detallefacturaproveedor.setdescuento1(0.0);
			detallefacturaproveedor.setdescuento2(0.0);
			detallefacturaproveedor.setprecio_venta(0.0);
			detallefacturaproveedor.setdisponible(0.0);
			detallefacturaproveedor.setice_valor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallefacturaproveedor.setcantidad(0);
				detallefacturaproveedor.setcantidad_auxiliar(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleFacturaProveedor(List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedor detallefacturaproveedorAux) throws Exception  {
		DetalleFacturaProveedorConstantesFunciones.InicializarValoresDetalleFacturaProveedor(detallefacturaproveedorAux,true);
		
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {
			if(detallefacturaproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallefacturaproveedorAux.setcantidad(detallefacturaproveedorAux.getcantidad()+detallefacturaproveedor.getcantidad());			
			detallefacturaproveedorAux.setcantidad_auxiliar(detallefacturaproveedorAux.getcantidad_auxiliar()+detallefacturaproveedor.getcantidad_auxiliar());			
			detallefacturaproveedorAux.setdescuento(detallefacturaproveedorAux.getdescuento()+detallefacturaproveedor.getdescuento());			
			detallefacturaproveedorAux.setiva(detallefacturaproveedorAux.getiva()+detallefacturaproveedor.getiva());			
			detallefacturaproveedorAux.setcosto_unitario(detallefacturaproveedorAux.getcosto_unitario()+detallefacturaproveedor.getcosto_unitario());			
			detallefacturaproveedorAux.setcosto_total(detallefacturaproveedorAux.getcosto_total()+detallefacturaproveedor.getcosto_total());			
			detallefacturaproveedorAux.setice(detallefacturaproveedorAux.getice()+detallefacturaproveedor.getice());			
			detallefacturaproveedorAux.setdescuento1(detallefacturaproveedorAux.getdescuento1()+detallefacturaproveedor.getdescuento1());			
			detallefacturaproveedorAux.setdescuento2(detallefacturaproveedorAux.getdescuento2()+detallefacturaproveedor.getdescuento2());			
			detallefacturaproveedorAux.setprecio_venta(detallefacturaproveedorAux.getprecio_venta()+detallefacturaproveedor.getprecio_venta());			
			detallefacturaproveedorAux.setdisponible(detallefacturaproveedorAux.getdisponible()+detallefacturaproveedor.getdisponible());			
			detallefacturaproveedorAux.setice_valor(detallefacturaproveedorAux.getice_valor()+detallefacturaproveedor.getice_valor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleFacturaProveedorConstantesFunciones.getArrayColumnasGlobalesDetalleFacturaProveedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaProveedorConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedor detallefacturaproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturaProveedor detallefacturaproveedorAux: detallefacturaproveedors) {
			if(detallefacturaproveedorAux!=null && detallefacturaproveedor!=null) {
				if((detallefacturaproveedorAux.getId()==null && detallefacturaproveedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallefacturaproveedorAux.getId()!=null && detallefacturaproveedor.getId()!=null){
					if(detallefacturaproveedorAux.getId().equals(detallefacturaproveedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturaProveedor(List<DetalleFacturaProveedor> detallefacturaproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double iceTotal=0.0;
		Double descuento1Total=0.0;
		Double descuento2Total=0.0;
		Double precio_ventaTotal=0.0;
		Double disponibleTotal=0.0;
		Double ice_valorTotal=0.0;
	
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {			
			if(detallefacturaproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=detallefacturaproveedor.getdescuento();
			ivaTotal+=detallefacturaproveedor.getiva();
			costo_unitarioTotal+=detallefacturaproveedor.getcosto_unitario();
			costo_totalTotal+=detallefacturaproveedor.getcosto_total();
			iceTotal+=detallefacturaproveedor.getice();
			descuento1Total+=detallefacturaproveedor.getdescuento1();
			descuento2Total+=detallefacturaproveedor.getdescuento2();
			precio_ventaTotal+=detallefacturaproveedor.getprecio_venta();
			disponibleTotal+=detallefacturaproveedor.getdisponible();
			ice_valorTotal+=detallefacturaproveedor.getice_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1);
		datoGeneral.setdValorDouble(descuento1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA);
		datoGeneral.setdValorDouble(precio_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleFacturaProveedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_ID, DetalleFacturaProveedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_VERSIONROW, DetalleFacturaProveedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDFACTURAPROVEEDOR, DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDEMPRESA, DetalleFacturaProveedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL, DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGA, DetalleFacturaProveedorConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDPRODUCTO, DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDUNIDAD, DetalleFacturaProveedorConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO, DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDPERIODO, DetalleFacturaProveedorConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDAD, DetalleFacturaProveedorConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDADAUXILIAR, DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO, DetalleFacturaProveedorConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IVA, DetalleFacturaProveedorConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_LOTE, DetalleFacturaProveedorConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_FECHAELABORACIONLOTE, DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_FECHACADUCIDADLOTE, DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOIVA, DetalleFacturaProveedorConstantesFunciones.COSTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO, DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL, DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_ICE, DetalleFacturaProveedorConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1, DetalleFacturaProveedorConstantesFunciones.DESCUENTO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2, DetalleFacturaProveedorConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_DESCRIPCION, DetalleFacturaProveedorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA, DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGAENVIAR, DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_LOTECLIENTE, DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE, DetalleFacturaProveedorConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_SERIE, DetalleFacturaProveedorConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR, DetalleFacturaProveedorConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDANIO, DetalleFacturaProveedorConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaProveedorConstantesFunciones.LABEL_IDMES, DetalleFacturaProveedorConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleFacturaProveedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.COSTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.DESCUENTO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaProveedorConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaProveedor() throws Exception  {
		return DetalleFacturaProveedorConstantesFunciones.getTiposSeleccionarDetalleFacturaProveedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaProveedor(Boolean conFk) throws Exception  {
		return DetalleFacturaProveedorConstantesFunciones.getTiposSeleccionarDetalleFacturaProveedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaProveedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDFACTURAPROVEEDOR);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDFACTURAPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDADAUXILIAR);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDADAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHAELABORACIONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHACADUCIDADLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOIVA);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGAENVIAR);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGAENVIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaProveedorConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleFacturaProveedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedorAux) throws Exception {
		
			detallefacturaproveedorAux.setfacturaproveedor_descripcion(FacturaProveedorConstantesFunciones.getFacturaProveedorDescripcion(detallefacturaproveedorAux.getFacturaProveedor()));
			detallefacturaproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturaproveedorAux.getEmpresa()));
			detallefacturaproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturaproveedorAux.getSucursal()));
			detallefacturaproveedorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaproveedorAux.getBodega()));
			detallefacturaproveedorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturaproveedorAux.getProducto()));
			detallefacturaproveedorAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturaproveedorAux.getUnidad()));
			detallefacturaproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallefacturaproveedorAux.getEjercicio()));
			detallefacturaproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallefacturaproveedorAux.getPeriodo()));
			detallefacturaproveedorAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallefacturaproveedorAux.getNovedadProducto()));
			detallefacturaproveedorAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallefacturaproveedorAux.getCentroCosto()));
			detallefacturaproveedorAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallefacturaproveedorAux.getCuentaContableCosto()));
			detallefacturaproveedorAux.setbodegaenviar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaproveedorAux.getBodegaEnviar()));
			detallefacturaproveedorAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallefacturaproveedorAux.getAnio()));
			detallefacturaproveedorAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallefacturaproveedorAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturaProveedor(List<DetalleFacturaProveedor> detallefacturaproveedorsTemp) throws Exception {
		for(DetalleFacturaProveedor detallefacturaproveedorAux:detallefacturaproveedorsTemp) {
			
			detallefacturaproveedorAux.setfacturaproveedor_descripcion(FacturaProveedorConstantesFunciones.getFacturaProveedorDescripcion(detallefacturaproveedorAux.getFacturaProveedor()));
			detallefacturaproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturaproveedorAux.getEmpresa()));
			detallefacturaproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturaproveedorAux.getSucursal()));
			detallefacturaproveedorAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaproveedorAux.getBodega()));
			detallefacturaproveedorAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturaproveedorAux.getProducto()));
			detallefacturaproveedorAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturaproveedorAux.getUnidad()));
			detallefacturaproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallefacturaproveedorAux.getEjercicio()));
			detallefacturaproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallefacturaproveedorAux.getPeriodo()));
			detallefacturaproveedorAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallefacturaproveedorAux.getNovedadProducto()));
			detallefacturaproveedorAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallefacturaproveedorAux.getCentroCosto()));
			detallefacturaproveedorAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallefacturaproveedorAux.getCuentaContableCosto()));
			detallefacturaproveedorAux.setbodegaenviar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaproveedorAux.getBodegaEnviar()));
			detallefacturaproveedorAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallefacturaproveedorAux.getAnio()));
			detallefacturaproveedorAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallefacturaproveedorAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaProveedor.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedor.class)) {
						classes.add(new Classe(FacturaProveedor.class));
					}
				}

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
					if(clas.clas.equals(NovedadProducto.class)) {
						classes.add(new Classe(NovedadProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaProveedorConstantesFunciones.getClassesRelationshipsOfDetalleFacturaProveedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaProveedorConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleFacturaProveedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleFacturaProveedor detallefacturaproveedor,List<DetalleFacturaProveedor> detallefacturaproveedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleFacturaProveedor detallefacturaproveedorEncontrado=null;
			
			for(DetalleFacturaProveedor detallefacturaproveedorLocal:detallefacturaproveedors) {
				if(detallefacturaproveedorLocal.getId().equals(detallefacturaproveedor.getId())) {
					detallefacturaproveedorEncontrado=detallefacturaproveedorLocal;
					
					detallefacturaproveedorLocal.setIsChanged(detallefacturaproveedor.getIsChanged());
					detallefacturaproveedorLocal.setIsNew(detallefacturaproveedor.getIsNew());
					detallefacturaproveedorLocal.setIsDeleted(detallefacturaproveedor.getIsDeleted());
					
					detallefacturaproveedorLocal.setGeneralEntityOriginal(detallefacturaproveedor.getGeneralEntityOriginal());
					
					detallefacturaproveedorLocal.setId(detallefacturaproveedor.getId());	
					detallefacturaproveedorLocal.setVersionRow(detallefacturaproveedor.getVersionRow());	
					detallefacturaproveedorLocal.setid_factura_proveedor(detallefacturaproveedor.getid_factura_proveedor());	
					detallefacturaproveedorLocal.setid_empresa(detallefacturaproveedor.getid_empresa());	
					detallefacturaproveedorLocal.setid_sucursal(detallefacturaproveedor.getid_sucursal());	
					detallefacturaproveedorLocal.setid_bodega(detallefacturaproveedor.getid_bodega());	
					detallefacturaproveedorLocal.setid_producto(detallefacturaproveedor.getid_producto());	
					detallefacturaproveedorLocal.setid_unidad(detallefacturaproveedor.getid_unidad());	
					detallefacturaproveedorLocal.setid_ejercicio(detallefacturaproveedor.getid_ejercicio());	
					detallefacturaproveedorLocal.setid_periodo(detallefacturaproveedor.getid_periodo());	
					detallefacturaproveedorLocal.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante());	
					detallefacturaproveedorLocal.setcantidad(detallefacturaproveedor.getcantidad());	
					detallefacturaproveedorLocal.setcantidad_auxiliar(detallefacturaproveedor.getcantidad_auxiliar());	
					detallefacturaproveedorLocal.setdescuento(detallefacturaproveedor.getdescuento());	
					detallefacturaproveedorLocal.setiva(detallefacturaproveedor.getiva());	
					detallefacturaproveedorLocal.setlote(detallefacturaproveedor.getlote());	
					detallefacturaproveedorLocal.setfecha_elaboracion_lote(detallefacturaproveedor.getfecha_elaboracion_lote());	
					detallefacturaproveedorLocal.setfecha_caducidad_lote(detallefacturaproveedor.getfecha_caducidad_lote());	
					detallefacturaproveedorLocal.setcosto_iva(detallefacturaproveedor.getcosto_iva());	
					detallefacturaproveedorLocal.setcosto_unitario(detallefacturaproveedor.getcosto_unitario());	
					detallefacturaproveedorLocal.setcosto_total(detallefacturaproveedor.getcosto_total());	
					detallefacturaproveedorLocal.setice(detallefacturaproveedor.getice());	
					detallefacturaproveedorLocal.setdescuento1(detallefacturaproveedor.getdescuento1());	
					detallefacturaproveedorLocal.setdescuento2(detallefacturaproveedor.getdescuento2());	
					detallefacturaproveedorLocal.setdescripcion(detallefacturaproveedor.getdescripcion());	
					detallefacturaproveedorLocal.setprecio_venta(detallefacturaproveedor.getprecio_venta());	
					detallefacturaproveedorLocal.setid_novedad_producto(detallefacturaproveedor.getid_novedad_producto());	
					detallefacturaproveedorLocal.setid_centro_costo(detallefacturaproveedor.getid_centro_costo());	
					detallefacturaproveedorLocal.setid_cuenta_contable_costo(detallefacturaproveedor.getid_cuenta_contable_costo());	
					detallefacturaproveedorLocal.setid_bodega_enviar(detallefacturaproveedor.getid_bodega_enviar());	
					detallefacturaproveedorLocal.setlote_cliente(detallefacturaproveedor.getlote_cliente());	
					detallefacturaproveedorLocal.setdisponible(detallefacturaproveedor.getdisponible());	
					detallefacturaproveedorLocal.setserie(detallefacturaproveedor.getserie());	
					detallefacturaproveedorLocal.setice_valor(detallefacturaproveedor.getice_valor());	
					detallefacturaproveedorLocal.setid_anio(detallefacturaproveedor.getid_anio());	
					detallefacturaproveedorLocal.setid_mes(detallefacturaproveedor.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallefacturaproveedor.getIsDeleted()) {
				if(!existe) {
					detallefacturaproveedors.add(detallefacturaproveedor);
				}
			} else {
				if(detallefacturaproveedorEncontrado!=null && permiteQuitar)  {
					detallefacturaproveedors.remove(detallefacturaproveedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleFacturaProveedor detallefacturaproveedor,List<DetalleFacturaProveedor> detallefacturaproveedors) throws Exception {
		try	{			
			for(DetalleFacturaProveedor detallefacturaproveedorLocal:detallefacturaproveedors) {
				if(detallefacturaproveedorLocal.getId().equals(detallefacturaproveedor.getId())) {
					detallefacturaproveedorLocal.setIsSelected(detallefacturaproveedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleFacturaProveedor(List<DetalleFacturaProveedor> detallefacturaproveedorsAux) throws Exception {
		//this.detallefacturaproveedorsAux=detallefacturaproveedorsAux;
		
		for(DetalleFacturaProveedor detallefacturaproveedorAux:detallefacturaproveedorsAux) {
			if(detallefacturaproveedorAux.getIsChanged()) {
				detallefacturaproveedorAux.setIsChanged(false);
			}		
			
			if(detallefacturaproveedorAux.getIsNew()) {
				detallefacturaproveedorAux.setIsNew(false);
			}	
			
			if(detallefacturaproveedorAux.getIsDeleted()) {
				detallefacturaproveedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedorAux) throws Exception {
		//this.detallefacturaproveedorAux=detallefacturaproveedorAux;
		
			if(detallefacturaproveedorAux.getIsChanged()) {
				detallefacturaproveedorAux.setIsChanged(false);
			}		
			
			if(detallefacturaproveedorAux.getIsNew()) {
				detallefacturaproveedorAux.setIsNew(false);
			}	
			
			if(detallefacturaproveedorAux.getIsDeleted()) {
				detallefacturaproveedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleFacturaProveedor detallefacturaproveedorAsignar,DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		detallefacturaproveedorAsignar.setId(detallefacturaproveedor.getId());	
		detallefacturaproveedorAsignar.setVersionRow(detallefacturaproveedor.getVersionRow());	
		detallefacturaproveedorAsignar.setid_factura_proveedor(detallefacturaproveedor.getid_factura_proveedor());
		detallefacturaproveedorAsignar.setfacturaproveedor_descripcion(detallefacturaproveedor.getfacturaproveedor_descripcion());	
		detallefacturaproveedorAsignar.setid_empresa(detallefacturaproveedor.getid_empresa());
		detallefacturaproveedorAsignar.setempresa_descripcion(detallefacturaproveedor.getempresa_descripcion());	
		detallefacturaproveedorAsignar.setid_sucursal(detallefacturaproveedor.getid_sucursal());
		detallefacturaproveedorAsignar.setsucursal_descripcion(detallefacturaproveedor.getsucursal_descripcion());	
		detallefacturaproveedorAsignar.setid_bodega(detallefacturaproveedor.getid_bodega());
		detallefacturaproveedorAsignar.setbodega_descripcion(detallefacturaproveedor.getbodega_descripcion());	
		detallefacturaproveedorAsignar.setid_producto(detallefacturaproveedor.getid_producto());
		detallefacturaproveedorAsignar.setproducto_descripcion(detallefacturaproveedor.getproducto_descripcion());	
		detallefacturaproveedorAsignar.setid_unidad(detallefacturaproveedor.getid_unidad());
		detallefacturaproveedorAsignar.setunidad_descripcion(detallefacturaproveedor.getunidad_descripcion());	
		detallefacturaproveedorAsignar.setid_ejercicio(detallefacturaproveedor.getid_ejercicio());
		detallefacturaproveedorAsignar.setejercicio_descripcion(detallefacturaproveedor.getejercicio_descripcion());	
		detallefacturaproveedorAsignar.setid_periodo(detallefacturaproveedor.getid_periodo());
		detallefacturaproveedorAsignar.setperiodo_descripcion(detallefacturaproveedor.getperiodo_descripcion());	
		detallefacturaproveedorAsignar.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante());	
		detallefacturaproveedorAsignar.setcantidad(detallefacturaproveedor.getcantidad());	
		detallefacturaproveedorAsignar.setcantidad_auxiliar(detallefacturaproveedor.getcantidad_auxiliar());	
		detallefacturaproveedorAsignar.setdescuento(detallefacturaproveedor.getdescuento());	
		detallefacturaproveedorAsignar.setiva(detallefacturaproveedor.getiva());	
		detallefacturaproveedorAsignar.setlote(detallefacturaproveedor.getlote());	
		detallefacturaproveedorAsignar.setfecha_elaboracion_lote(detallefacturaproveedor.getfecha_elaboracion_lote());	
		detallefacturaproveedorAsignar.setfecha_caducidad_lote(detallefacturaproveedor.getfecha_caducidad_lote());	
		detallefacturaproveedorAsignar.setcosto_iva(detallefacturaproveedor.getcosto_iva());	
		detallefacturaproveedorAsignar.setcosto_unitario(detallefacturaproveedor.getcosto_unitario());	
		detallefacturaproveedorAsignar.setcosto_total(detallefacturaproveedor.getcosto_total());	
		detallefacturaproveedorAsignar.setice(detallefacturaproveedor.getice());	
		detallefacturaproveedorAsignar.setdescuento1(detallefacturaproveedor.getdescuento1());	
		detallefacturaproveedorAsignar.setdescuento2(detallefacturaproveedor.getdescuento2());	
		detallefacturaproveedorAsignar.setdescripcion(detallefacturaproveedor.getdescripcion());	
		detallefacturaproveedorAsignar.setprecio_venta(detallefacturaproveedor.getprecio_venta());	
		detallefacturaproveedorAsignar.setid_novedad_producto(detallefacturaproveedor.getid_novedad_producto());
		detallefacturaproveedorAsignar.setnovedadproducto_descripcion(detallefacturaproveedor.getnovedadproducto_descripcion());	
		detallefacturaproveedorAsignar.setid_centro_costo(detallefacturaproveedor.getid_centro_costo());
		detallefacturaproveedorAsignar.setcentrocosto_descripcion(detallefacturaproveedor.getcentrocosto_descripcion());	
		detallefacturaproveedorAsignar.setid_cuenta_contable_costo(detallefacturaproveedor.getid_cuenta_contable_costo());
		detallefacturaproveedorAsignar.setcuentacontablecosto_descripcion(detallefacturaproveedor.getcuentacontablecosto_descripcion());	
		detallefacturaproveedorAsignar.setid_bodega_enviar(detallefacturaproveedor.getid_bodega_enviar());
		detallefacturaproveedorAsignar.setbodegaenviar_descripcion(detallefacturaproveedor.getbodegaenviar_descripcion());	
		detallefacturaproveedorAsignar.setlote_cliente(detallefacturaproveedor.getlote_cliente());	
		detallefacturaproveedorAsignar.setdisponible(detallefacturaproveedor.getdisponible());	
		detallefacturaproveedorAsignar.setserie(detallefacturaproveedor.getserie());	
		detallefacturaproveedorAsignar.setice_valor(detallefacturaproveedor.getice_valor());	
		detallefacturaproveedorAsignar.setid_anio(detallefacturaproveedor.getid_anio());
		detallefacturaproveedorAsignar.setanio_descripcion(detallefacturaproveedor.getanio_descripcion());	
		detallefacturaproveedorAsignar.setid_mes(detallefacturaproveedor.getid_mes());
		detallefacturaproveedorAsignar.setmes_descripcion(detallefacturaproveedor.getmes_descripcion());	
	}
	
	public static void inicializarDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		try {
				detallefacturaproveedor.setId(0L);	
					
				detallefacturaproveedor.setid_factura_proveedor(-1L);	
				detallefacturaproveedor.setid_empresa(-1L);	
				detallefacturaproveedor.setid_sucursal(-1L);	
				detallefacturaproveedor.setid_bodega(-1L);	
				detallefacturaproveedor.setid_producto(-1L);	
				detallefacturaproveedor.setid_unidad(-1L);	
				detallefacturaproveedor.setid_ejercicio(-1L);	
				detallefacturaproveedor.setid_periodo(-1L);	
				detallefacturaproveedor.setnumero_comprobante("");	
				detallefacturaproveedor.setcantidad(0);	
				detallefacturaproveedor.setcantidad_auxiliar(0);	
				detallefacturaproveedor.setdescuento(0.0);	
				detallefacturaproveedor.setiva(0.0);	
				detallefacturaproveedor.setlote("");	
				detallefacturaproveedor.setfecha_elaboracion_lote(new Date());	
				detallefacturaproveedor.setfecha_caducidad_lote(new Date());	
				detallefacturaproveedor.setcosto_iva(false);	
				detallefacturaproveedor.setcosto_unitario(0.0);	
				detallefacturaproveedor.setcosto_total(0.0);	
				detallefacturaproveedor.setice(0.0);	
				detallefacturaproveedor.setdescuento1(0.0);	
				detallefacturaproveedor.setdescuento2(0.0);	
				detallefacturaproveedor.setdescripcion("");	
				detallefacturaproveedor.setprecio_venta(0.0);	
				detallefacturaproveedor.setid_novedad_producto(-1L);	
				detallefacturaproveedor.setid_centro_costo(null);	
				detallefacturaproveedor.setid_cuenta_contable_costo(-1L);	
				detallefacturaproveedor.setid_bodega_enviar(-1L);	
				detallefacturaproveedor.setlote_cliente("");	
				detallefacturaproveedor.setdisponible(0.0);	
				detallefacturaproveedor.setserie("");	
				detallefacturaproveedor.setice_valor(0.0);	
				detallefacturaproveedor.setid_anio(null);	
				detallefacturaproveedor.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleFacturaProveedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDFACTURAPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_CANTIDADAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDBODEGAENVIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaProveedorConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleFacturaProveedor(String sTipo,Row row,Workbook workbook,DetalleFacturaProveedor detallefacturaproveedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getfacturaproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcantidad_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getfecha_elaboracion_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getfecha_caducidad_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallefacturaproveedor.getcosto_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getdescuento1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getprecio_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getbodegaenviar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturaproveedor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleFacturaProveedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleFacturaProveedor() {
		return this.sFinalQueryDetalleFacturaProveedor;
	}
	
	public void setsFinalQueryDetalleFacturaProveedor(String sFinalQueryDetalleFacturaProveedor) {
		this.sFinalQueryDetalleFacturaProveedor= sFinalQueryDetalleFacturaProveedor;
	}
	
	public Border resaltarSeleccionarDetalleFacturaProveedor=null;
	
	public Border setResaltarSeleccionarDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleFacturaProveedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleFacturaProveedor() {
		return this.resaltarSeleccionarDetalleFacturaProveedor;
	}
	
	public void setResaltarSeleccionarDetalleFacturaProveedor(Border borderResaltarSeleccionarDetalleFacturaProveedor) {
		this.resaltarSeleccionarDetalleFacturaProveedor= borderResaltarSeleccionarDetalleFacturaProveedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleFacturaProveedor=null;
	public Boolean mostraridDetalleFacturaProveedor=true;
	public Boolean activaridDetalleFacturaProveedor=true;

	public Border resaltarid_factura_proveedorDetalleFacturaProveedor=null;
	public Boolean mostrarid_factura_proveedorDetalleFacturaProveedor=true;
	public Boolean activarid_factura_proveedorDetalleFacturaProveedor=true;
	public Boolean cargarid_factura_proveedorDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factura_proveedorDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleFacturaProveedor=null;
	public Boolean mostrarid_empresaDetalleFacturaProveedor=true;
	public Boolean activarid_empresaDetalleFacturaProveedor=true;
	public Boolean cargarid_empresaDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleFacturaProveedor=null;
	public Boolean mostrarid_sucursalDetalleFacturaProveedor=true;
	public Boolean activarid_sucursalDetalleFacturaProveedor=true;
	public Boolean cargarid_sucursalDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleFacturaProveedor=null;
	public Boolean mostrarid_bodegaDetalleFacturaProveedor=true;
	public Boolean activarid_bodegaDetalleFacturaProveedor=true;
	public Boolean cargarid_bodegaDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleFacturaProveedor=null;
	public Boolean mostrarid_productoDetalleFacturaProveedor=true;
	public Boolean activarid_productoDetalleFacturaProveedor=true;
	public Boolean cargarid_productoDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleFacturaProveedor=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleFacturaProveedor=null;
	public Boolean mostrarid_unidadDetalleFacturaProveedor=true;
	public Boolean activarid_unidadDetalleFacturaProveedor=true;
	public Boolean cargarid_unidadDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleFacturaProveedor=true;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleFacturaProveedor=null;
	public Boolean mostrarid_ejercicioDetalleFacturaProveedor=true;
	public Boolean activarid_ejercicioDetalleFacturaProveedor=true;
	public Boolean cargarid_ejercicioDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleFacturaProveedor=null;
	public Boolean mostrarid_periodoDetalleFacturaProveedor=true;
	public Boolean activarid_periodoDetalleFacturaProveedor=true;
	public Boolean cargarid_periodoDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteDetalleFacturaProveedor=null;
	public Boolean mostrarnumero_comprobanteDetalleFacturaProveedor=true;
	public Boolean activarnumero_comprobanteDetalleFacturaProveedor=true;

	public Border resaltarcantidadDetalleFacturaProveedor=null;
	public Boolean mostrarcantidadDetalleFacturaProveedor=true;
	public Boolean activarcantidadDetalleFacturaProveedor=true;

	public Border resaltarcantidad_auxiliarDetalleFacturaProveedor=null;
	public Boolean mostrarcantidad_auxiliarDetalleFacturaProveedor=true;
	public Boolean activarcantidad_auxiliarDetalleFacturaProveedor=true;

	public Border resaltardescuentoDetalleFacturaProveedor=null;
	public Boolean mostrardescuentoDetalleFacturaProveedor=true;
	public Boolean activardescuentoDetalleFacturaProveedor=true;

	public Border resaltarivaDetalleFacturaProveedor=null;
	public Boolean mostrarivaDetalleFacturaProveedor=true;
	public Boolean activarivaDetalleFacturaProveedor=true;

	public Border resaltarloteDetalleFacturaProveedor=null;
	public Boolean mostrarloteDetalleFacturaProveedor=true;
	public Boolean activarloteDetalleFacturaProveedor=true;

	public Border resaltarfecha_elaboracion_loteDetalleFacturaProveedor=null;
	public Boolean mostrarfecha_elaboracion_loteDetalleFacturaProveedor=true;
	public Boolean activarfecha_elaboracion_loteDetalleFacturaProveedor=false;

	public Border resaltarfecha_caducidad_loteDetalleFacturaProveedor=null;
	public Boolean mostrarfecha_caducidad_loteDetalleFacturaProveedor=true;
	public Boolean activarfecha_caducidad_loteDetalleFacturaProveedor=false;

	public Border resaltarcosto_ivaDetalleFacturaProveedor=null;
	public Boolean mostrarcosto_ivaDetalleFacturaProveedor=true;
	public Boolean activarcosto_ivaDetalleFacturaProveedor=true;

	public Border resaltarcosto_unitarioDetalleFacturaProveedor=null;
	public Boolean mostrarcosto_unitarioDetalleFacturaProveedor=true;
	public Boolean activarcosto_unitarioDetalleFacturaProveedor=true;

	public Border resaltarcosto_totalDetalleFacturaProveedor=null;
	public Boolean mostrarcosto_totalDetalleFacturaProveedor=true;
	public Boolean activarcosto_totalDetalleFacturaProveedor=true;

	public Border resaltariceDetalleFacturaProveedor=null;
	public Boolean mostrariceDetalleFacturaProveedor=true;
	public Boolean activariceDetalleFacturaProveedor=true;

	public Border resaltardescuento1DetalleFacturaProveedor=null;
	public Boolean mostrardescuento1DetalleFacturaProveedor=true;
	public Boolean activardescuento1DetalleFacturaProveedor=true;

	public Border resaltardescuento2DetalleFacturaProveedor=null;
	public Boolean mostrardescuento2DetalleFacturaProveedor=true;
	public Boolean activardescuento2DetalleFacturaProveedor=true;

	public Border resaltardescripcionDetalleFacturaProveedor=null;
	public Boolean mostrardescripcionDetalleFacturaProveedor=true;
	public Boolean activardescripcionDetalleFacturaProveedor=true;

	public Border resaltarprecio_ventaDetalleFacturaProveedor=null;
	public Boolean mostrarprecio_ventaDetalleFacturaProveedor=true;
	public Boolean activarprecio_ventaDetalleFacturaProveedor=true;

	public Border resaltarid_novedad_productoDetalleFacturaProveedor=null;
	public Boolean mostrarid_novedad_productoDetalleFacturaProveedor=true;
	public Boolean activarid_novedad_productoDetalleFacturaProveedor=true;
	public Boolean cargarid_novedad_productoDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleFacturaProveedor=null;
	public Boolean mostrarid_centro_costoDetalleFacturaProveedor=true;
	public Boolean activarid_centro_costoDetalleFacturaProveedor=true;
	public Boolean cargarid_centro_costoDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoDetalleFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_costoDetalleFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_costoDetalleFacturaProveedor=true;
	public Boolean cargarid_cuenta_contable_costoDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_bodega_enviarDetalleFacturaProveedor=null;
	public Boolean mostrarid_bodega_enviarDetalleFacturaProveedor=true;
	public Boolean activarid_bodega_enviarDetalleFacturaProveedor=true;
	public Boolean cargarid_bodega_enviarDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_enviarDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarlote_clienteDetalleFacturaProveedor=null;
	public Boolean mostrarlote_clienteDetalleFacturaProveedor=true;
	public Boolean activarlote_clienteDetalleFacturaProveedor=true;

	public Border resaltardisponibleDetalleFacturaProveedor=null;
	public Boolean mostrardisponibleDetalleFacturaProveedor=true;
	public Boolean activardisponibleDetalleFacturaProveedor=true;

	public Border resaltarserieDetalleFacturaProveedor=null;
	public Boolean mostrarserieDetalleFacturaProveedor=true;
	public Boolean activarserieDetalleFacturaProveedor=true;

	public Border resaltarice_valorDetalleFacturaProveedor=null;
	public Boolean mostrarice_valorDetalleFacturaProveedor=true;
	public Boolean activarice_valorDetalleFacturaProveedor=true;

	public Border resaltarid_anioDetalleFacturaProveedor=null;
	public Boolean mostrarid_anioDetalleFacturaProveedor=true;
	public Boolean activarid_anioDetalleFacturaProveedor=true;
	public Boolean cargarid_anioDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleFacturaProveedor=null;
	public Boolean mostrarid_mesDetalleFacturaProveedor=true;
	public Boolean activarid_mesDetalleFacturaProveedor=true;
	public Boolean cargarid_mesDetalleFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleFacturaProveedor=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaridDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleFacturaProveedor() {
		return this.resaltaridDetalleFacturaProveedor;
	}

	public void setResaltaridDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltaridDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraridDetalleFacturaProveedor() {
		return this.mostraridDetalleFacturaProveedor;
	}

	public void setMostraridDetalleFacturaProveedor(Boolean mostraridDetalleFacturaProveedor) {
		this.mostraridDetalleFacturaProveedor= mostraridDetalleFacturaProveedor;
	}

	public Boolean getActivaridDetalleFacturaProveedor() {
		return this.activaridDetalleFacturaProveedor;
	}

	public void setActivaridDetalleFacturaProveedor(Boolean activaridDetalleFacturaProveedor) {
		this.activaridDetalleFacturaProveedor= activaridDetalleFacturaProveedor;
	}

	public Border setResaltarid_factura_proveedorDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_factura_proveedorDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factura_proveedorDetalleFacturaProveedor() {
		return this.resaltarid_factura_proveedorDetalleFacturaProveedor;
	}

	public void setResaltarid_factura_proveedorDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_factura_proveedorDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_factura_proveedorDetalleFacturaProveedor() {
		return this.mostrarid_factura_proveedorDetalleFacturaProveedor;
	}

	public void setMostrarid_factura_proveedorDetalleFacturaProveedor(Boolean mostrarid_factura_proveedorDetalleFacturaProveedor) {
		this.mostrarid_factura_proveedorDetalleFacturaProveedor= mostrarid_factura_proveedorDetalleFacturaProveedor;
	}

	public Boolean getActivarid_factura_proveedorDetalleFacturaProveedor() {
		return this.activarid_factura_proveedorDetalleFacturaProveedor;
	}

	public void setActivarid_factura_proveedorDetalleFacturaProveedor(Boolean activarid_factura_proveedorDetalleFacturaProveedor) {
		this.activarid_factura_proveedorDetalleFacturaProveedor= activarid_factura_proveedorDetalleFacturaProveedor;
	}

	public Boolean getCargarid_factura_proveedorDetalleFacturaProveedor() {
		return this.cargarid_factura_proveedorDetalleFacturaProveedor;
	}

	public void setCargarid_factura_proveedorDetalleFacturaProveedor(Boolean cargarid_factura_proveedorDetalleFacturaProveedor) {
		this.cargarid_factura_proveedorDetalleFacturaProveedor= cargarid_factura_proveedorDetalleFacturaProveedor;
	}

	public Border setResaltarid_empresaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleFacturaProveedor() {
		return this.resaltarid_empresaDetalleFacturaProveedor;
	}

	public void setResaltarid_empresaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_empresaDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleFacturaProveedor() {
		return this.mostrarid_empresaDetalleFacturaProveedor;
	}

	public void setMostrarid_empresaDetalleFacturaProveedor(Boolean mostrarid_empresaDetalleFacturaProveedor) {
		this.mostrarid_empresaDetalleFacturaProveedor= mostrarid_empresaDetalleFacturaProveedor;
	}

	public Boolean getActivarid_empresaDetalleFacturaProveedor() {
		return this.activarid_empresaDetalleFacturaProveedor;
	}

	public void setActivarid_empresaDetalleFacturaProveedor(Boolean activarid_empresaDetalleFacturaProveedor) {
		this.activarid_empresaDetalleFacturaProveedor= activarid_empresaDetalleFacturaProveedor;
	}

	public Boolean getCargarid_empresaDetalleFacturaProveedor() {
		return this.cargarid_empresaDetalleFacturaProveedor;
	}

	public void setCargarid_empresaDetalleFacturaProveedor(Boolean cargarid_empresaDetalleFacturaProveedor) {
		this.cargarid_empresaDetalleFacturaProveedor= cargarid_empresaDetalleFacturaProveedor;
	}

	public Border setResaltarid_sucursalDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleFacturaProveedor() {
		return this.resaltarid_sucursalDetalleFacturaProveedor;
	}

	public void setResaltarid_sucursalDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_sucursalDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleFacturaProveedor() {
		return this.mostrarid_sucursalDetalleFacturaProveedor;
	}

	public void setMostrarid_sucursalDetalleFacturaProveedor(Boolean mostrarid_sucursalDetalleFacturaProveedor) {
		this.mostrarid_sucursalDetalleFacturaProveedor= mostrarid_sucursalDetalleFacturaProveedor;
	}

	public Boolean getActivarid_sucursalDetalleFacturaProveedor() {
		return this.activarid_sucursalDetalleFacturaProveedor;
	}

	public void setActivarid_sucursalDetalleFacturaProveedor(Boolean activarid_sucursalDetalleFacturaProveedor) {
		this.activarid_sucursalDetalleFacturaProveedor= activarid_sucursalDetalleFacturaProveedor;
	}

	public Boolean getCargarid_sucursalDetalleFacturaProveedor() {
		return this.cargarid_sucursalDetalleFacturaProveedor;
	}

	public void setCargarid_sucursalDetalleFacturaProveedor(Boolean cargarid_sucursalDetalleFacturaProveedor) {
		this.cargarid_sucursalDetalleFacturaProveedor= cargarid_sucursalDetalleFacturaProveedor;
	}

	public Border setResaltarid_bodegaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleFacturaProveedor() {
		return this.resaltarid_bodegaDetalleFacturaProveedor;
	}

	public void setResaltarid_bodegaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_bodegaDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleFacturaProveedor() {
		return this.mostrarid_bodegaDetalleFacturaProveedor;
	}

	public void setMostrarid_bodegaDetalleFacturaProveedor(Boolean mostrarid_bodegaDetalleFacturaProveedor) {
		this.mostrarid_bodegaDetalleFacturaProveedor= mostrarid_bodegaDetalleFacturaProveedor;
	}

	public Boolean getActivarid_bodegaDetalleFacturaProveedor() {
		return this.activarid_bodegaDetalleFacturaProveedor;
	}

	public void setActivarid_bodegaDetalleFacturaProveedor(Boolean activarid_bodegaDetalleFacturaProveedor) {
		this.activarid_bodegaDetalleFacturaProveedor= activarid_bodegaDetalleFacturaProveedor;
	}

	public Boolean getCargarid_bodegaDetalleFacturaProveedor() {
		return this.cargarid_bodegaDetalleFacturaProveedor;
	}

	public void setCargarid_bodegaDetalleFacturaProveedor(Boolean cargarid_bodegaDetalleFacturaProveedor) {
		this.cargarid_bodegaDetalleFacturaProveedor= cargarid_bodegaDetalleFacturaProveedor;
	}

	public Border setResaltarid_productoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleFacturaProveedor() {
		return this.resaltarid_productoDetalleFacturaProveedor;
	}

	public void setResaltarid_productoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_productoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleFacturaProveedor() {
		return this.mostrarid_productoDetalleFacturaProveedor;
	}

	public void setMostrarid_productoDetalleFacturaProveedor(Boolean mostrarid_productoDetalleFacturaProveedor) {
		this.mostrarid_productoDetalleFacturaProveedor= mostrarid_productoDetalleFacturaProveedor;
	}

	public Boolean getActivarid_productoDetalleFacturaProveedor() {
		return this.activarid_productoDetalleFacturaProveedor;
	}

	public void setActivarid_productoDetalleFacturaProveedor(Boolean activarid_productoDetalleFacturaProveedor) {
		this.activarid_productoDetalleFacturaProveedor= activarid_productoDetalleFacturaProveedor;
	}

	public Boolean getCargarid_productoDetalleFacturaProveedor() {
		return this.cargarid_productoDetalleFacturaProveedor;
	}

	public void setCargarid_productoDetalleFacturaProveedor(Boolean cargarid_productoDetalleFacturaProveedor) {
		this.cargarid_productoDetalleFacturaProveedor= cargarid_productoDetalleFacturaProveedor;
	}

	public Border setResaltarid_unidadDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleFacturaProveedor() {
		return this.resaltarid_unidadDetalleFacturaProveedor;
	}

	public void setResaltarid_unidadDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_unidadDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleFacturaProveedor() {
		return this.mostrarid_unidadDetalleFacturaProveedor;
	}

	public void setMostrarid_unidadDetalleFacturaProveedor(Boolean mostrarid_unidadDetalleFacturaProveedor) {
		this.mostrarid_unidadDetalleFacturaProveedor= mostrarid_unidadDetalleFacturaProveedor;
	}

	public Boolean getActivarid_unidadDetalleFacturaProveedor() {
		return this.activarid_unidadDetalleFacturaProveedor;
	}

	public void setActivarid_unidadDetalleFacturaProveedor(Boolean activarid_unidadDetalleFacturaProveedor) {
		this.activarid_unidadDetalleFacturaProveedor= activarid_unidadDetalleFacturaProveedor;
	}

	public Boolean getCargarid_unidadDetalleFacturaProveedor() {
		return this.cargarid_unidadDetalleFacturaProveedor;
	}

	public void setCargarid_unidadDetalleFacturaProveedor(Boolean cargarid_unidadDetalleFacturaProveedor) {
		this.cargarid_unidadDetalleFacturaProveedor= cargarid_unidadDetalleFacturaProveedor;
	}

	public Border setResaltarid_ejercicioDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleFacturaProveedor() {
		return this.resaltarid_ejercicioDetalleFacturaProveedor;
	}

	public void setResaltarid_ejercicioDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleFacturaProveedor() {
		return this.mostrarid_ejercicioDetalleFacturaProveedor;
	}

	public void setMostrarid_ejercicioDetalleFacturaProveedor(Boolean mostrarid_ejercicioDetalleFacturaProveedor) {
		this.mostrarid_ejercicioDetalleFacturaProveedor= mostrarid_ejercicioDetalleFacturaProveedor;
	}

	public Boolean getActivarid_ejercicioDetalleFacturaProveedor() {
		return this.activarid_ejercicioDetalleFacturaProveedor;
	}

	public void setActivarid_ejercicioDetalleFacturaProveedor(Boolean activarid_ejercicioDetalleFacturaProveedor) {
		this.activarid_ejercicioDetalleFacturaProveedor= activarid_ejercicioDetalleFacturaProveedor;
	}

	public Boolean getCargarid_ejercicioDetalleFacturaProveedor() {
		return this.cargarid_ejercicioDetalleFacturaProveedor;
	}

	public void setCargarid_ejercicioDetalleFacturaProveedor(Boolean cargarid_ejercicioDetalleFacturaProveedor) {
		this.cargarid_ejercicioDetalleFacturaProveedor= cargarid_ejercicioDetalleFacturaProveedor;
	}

	public Border setResaltarid_periodoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleFacturaProveedor() {
		return this.resaltarid_periodoDetalleFacturaProveedor;
	}

	public void setResaltarid_periodoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_periodoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleFacturaProveedor() {
		return this.mostrarid_periodoDetalleFacturaProveedor;
	}

	public void setMostrarid_periodoDetalleFacturaProveedor(Boolean mostrarid_periodoDetalleFacturaProveedor) {
		this.mostrarid_periodoDetalleFacturaProveedor= mostrarid_periodoDetalleFacturaProveedor;
	}

	public Boolean getActivarid_periodoDetalleFacturaProveedor() {
		return this.activarid_periodoDetalleFacturaProveedor;
	}

	public void setActivarid_periodoDetalleFacturaProveedor(Boolean activarid_periodoDetalleFacturaProveedor) {
		this.activarid_periodoDetalleFacturaProveedor= activarid_periodoDetalleFacturaProveedor;
	}

	public Boolean getCargarid_periodoDetalleFacturaProveedor() {
		return this.cargarid_periodoDetalleFacturaProveedor;
	}

	public void setCargarid_periodoDetalleFacturaProveedor(Boolean cargarid_periodoDetalleFacturaProveedor) {
		this.cargarid_periodoDetalleFacturaProveedor= cargarid_periodoDetalleFacturaProveedor;
	}

	public Border setResaltarnumero_comprobanteDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleFacturaProveedor() {
		return this.resaltarnumero_comprobanteDetalleFacturaProveedor;
	}

	public void setResaltarnumero_comprobanteDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleFacturaProveedor() {
		return this.mostrarnumero_comprobanteDetalleFacturaProveedor;
	}

	public void setMostrarnumero_comprobanteDetalleFacturaProveedor(Boolean mostrarnumero_comprobanteDetalleFacturaProveedor) {
		this.mostrarnumero_comprobanteDetalleFacturaProveedor= mostrarnumero_comprobanteDetalleFacturaProveedor;
	}

	public Boolean getActivarnumero_comprobanteDetalleFacturaProveedor() {
		return this.activarnumero_comprobanteDetalleFacturaProveedor;
	}

	public void setActivarnumero_comprobanteDetalleFacturaProveedor(Boolean activarnumero_comprobanteDetalleFacturaProveedor) {
		this.activarnumero_comprobanteDetalleFacturaProveedor= activarnumero_comprobanteDetalleFacturaProveedor;
	}

	public Border setResaltarcantidadDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleFacturaProveedor() {
		return this.resaltarcantidadDetalleFacturaProveedor;
	}

	public void setResaltarcantidadDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarcantidadDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleFacturaProveedor() {
		return this.mostrarcantidadDetalleFacturaProveedor;
	}

	public void setMostrarcantidadDetalleFacturaProveedor(Boolean mostrarcantidadDetalleFacturaProveedor) {
		this.mostrarcantidadDetalleFacturaProveedor= mostrarcantidadDetalleFacturaProveedor;
	}

	public Boolean getActivarcantidadDetalleFacturaProveedor() {
		return this.activarcantidadDetalleFacturaProveedor;
	}

	public void setActivarcantidadDetalleFacturaProveedor(Boolean activarcantidadDetalleFacturaProveedor) {
		this.activarcantidadDetalleFacturaProveedor= activarcantidadDetalleFacturaProveedor;
	}

	public Border setResaltarcantidad_auxiliarDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcantidad_auxiliarDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_auxiliarDetalleFacturaProveedor() {
		return this.resaltarcantidad_auxiliarDetalleFacturaProveedor;
	}

	public void setResaltarcantidad_auxiliarDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarcantidad_auxiliarDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcantidad_auxiliarDetalleFacturaProveedor() {
		return this.mostrarcantidad_auxiliarDetalleFacturaProveedor;
	}

	public void setMostrarcantidad_auxiliarDetalleFacturaProveedor(Boolean mostrarcantidad_auxiliarDetalleFacturaProveedor) {
		this.mostrarcantidad_auxiliarDetalleFacturaProveedor= mostrarcantidad_auxiliarDetalleFacturaProveedor;
	}

	public Boolean getActivarcantidad_auxiliarDetalleFacturaProveedor() {
		return this.activarcantidad_auxiliarDetalleFacturaProveedor;
	}

	public void setActivarcantidad_auxiliarDetalleFacturaProveedor(Boolean activarcantidad_auxiliarDetalleFacturaProveedor) {
		this.activarcantidad_auxiliarDetalleFacturaProveedor= activarcantidad_auxiliarDetalleFacturaProveedor;
	}

	public Border setResaltardescuentoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardescuentoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleFacturaProveedor() {
		return this.resaltardescuentoDetalleFacturaProveedor;
	}

	public void setResaltardescuentoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardescuentoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleFacturaProveedor() {
		return this.mostrardescuentoDetalleFacturaProveedor;
	}

	public void setMostrardescuentoDetalleFacturaProveedor(Boolean mostrardescuentoDetalleFacturaProveedor) {
		this.mostrardescuentoDetalleFacturaProveedor= mostrardescuentoDetalleFacturaProveedor;
	}

	public Boolean getActivardescuentoDetalleFacturaProveedor() {
		return this.activardescuentoDetalleFacturaProveedor;
	}

	public void setActivardescuentoDetalleFacturaProveedor(Boolean activardescuentoDetalleFacturaProveedor) {
		this.activardescuentoDetalleFacturaProveedor= activardescuentoDetalleFacturaProveedor;
	}

	public Border setResaltarivaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarivaDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleFacturaProveedor() {
		return this.resaltarivaDetalleFacturaProveedor;
	}

	public void setResaltarivaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarivaDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarivaDetalleFacturaProveedor() {
		return this.mostrarivaDetalleFacturaProveedor;
	}

	public void setMostrarivaDetalleFacturaProveedor(Boolean mostrarivaDetalleFacturaProveedor) {
		this.mostrarivaDetalleFacturaProveedor= mostrarivaDetalleFacturaProveedor;
	}

	public Boolean getActivarivaDetalleFacturaProveedor() {
		return this.activarivaDetalleFacturaProveedor;
	}

	public void setActivarivaDetalleFacturaProveedor(Boolean activarivaDetalleFacturaProveedor) {
		this.activarivaDetalleFacturaProveedor= activarivaDetalleFacturaProveedor;
	}

	public Border setResaltarloteDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarloteDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleFacturaProveedor() {
		return this.resaltarloteDetalleFacturaProveedor;
	}

	public void setResaltarloteDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarloteDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarloteDetalleFacturaProveedor() {
		return this.mostrarloteDetalleFacturaProveedor;
	}

	public void setMostrarloteDetalleFacturaProveedor(Boolean mostrarloteDetalleFacturaProveedor) {
		this.mostrarloteDetalleFacturaProveedor= mostrarloteDetalleFacturaProveedor;
	}

	public Boolean getActivarloteDetalleFacturaProveedor() {
		return this.activarloteDetalleFacturaProveedor;
	}

	public void setActivarloteDetalleFacturaProveedor(Boolean activarloteDetalleFacturaProveedor) {
		this.activarloteDetalleFacturaProveedor= activarloteDetalleFacturaProveedor;
	}

	public Border setResaltarfecha_elaboracion_loteDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_elaboracion_loteDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_elaboracion_loteDetalleFacturaProveedor() {
		return this.resaltarfecha_elaboracion_loteDetalleFacturaProveedor;
	}

	public void setResaltarfecha_elaboracion_loteDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarfecha_elaboracion_loteDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_elaboracion_loteDetalleFacturaProveedor() {
		return this.mostrarfecha_elaboracion_loteDetalleFacturaProveedor;
	}

	public void setMostrarfecha_elaboracion_loteDetalleFacturaProveedor(Boolean mostrarfecha_elaboracion_loteDetalleFacturaProveedor) {
		this.mostrarfecha_elaboracion_loteDetalleFacturaProveedor= mostrarfecha_elaboracion_loteDetalleFacturaProveedor;
	}

	public Boolean getActivarfecha_elaboracion_loteDetalleFacturaProveedor() {
		return this.activarfecha_elaboracion_loteDetalleFacturaProveedor;
	}

	public void setActivarfecha_elaboracion_loteDetalleFacturaProveedor(Boolean activarfecha_elaboracion_loteDetalleFacturaProveedor) {
		this.activarfecha_elaboracion_loteDetalleFacturaProveedor= activarfecha_elaboracion_loteDetalleFacturaProveedor;
	}

	public Border setResaltarfecha_caducidad_loteDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_caducidad_loteDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidad_loteDetalleFacturaProveedor() {
		return this.resaltarfecha_caducidad_loteDetalleFacturaProveedor;
	}

	public void setResaltarfecha_caducidad_loteDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarfecha_caducidad_loteDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidad_loteDetalleFacturaProveedor() {
		return this.mostrarfecha_caducidad_loteDetalleFacturaProveedor;
	}

	public void setMostrarfecha_caducidad_loteDetalleFacturaProveedor(Boolean mostrarfecha_caducidad_loteDetalleFacturaProveedor) {
		this.mostrarfecha_caducidad_loteDetalleFacturaProveedor= mostrarfecha_caducidad_loteDetalleFacturaProveedor;
	}

	public Boolean getActivarfecha_caducidad_loteDetalleFacturaProveedor() {
		return this.activarfecha_caducidad_loteDetalleFacturaProveedor;
	}

	public void setActivarfecha_caducidad_loteDetalleFacturaProveedor(Boolean activarfecha_caducidad_loteDetalleFacturaProveedor) {
		this.activarfecha_caducidad_loteDetalleFacturaProveedor= activarfecha_caducidad_loteDetalleFacturaProveedor;
	}

	public Border setResaltarcosto_ivaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcosto_ivaDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ivaDetalleFacturaProveedor() {
		return this.resaltarcosto_ivaDetalleFacturaProveedor;
	}

	public void setResaltarcosto_ivaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarcosto_ivaDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcosto_ivaDetalleFacturaProveedor() {
		return this.mostrarcosto_ivaDetalleFacturaProveedor;
	}

	public void setMostrarcosto_ivaDetalleFacturaProveedor(Boolean mostrarcosto_ivaDetalleFacturaProveedor) {
		this.mostrarcosto_ivaDetalleFacturaProveedor= mostrarcosto_ivaDetalleFacturaProveedor;
	}

	public Boolean getActivarcosto_ivaDetalleFacturaProveedor() {
		return this.activarcosto_ivaDetalleFacturaProveedor;
	}

	public void setActivarcosto_ivaDetalleFacturaProveedor(Boolean activarcosto_ivaDetalleFacturaProveedor) {
		this.activarcosto_ivaDetalleFacturaProveedor= activarcosto_ivaDetalleFacturaProveedor;
	}

	public Border setResaltarcosto_unitarioDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleFacturaProveedor() {
		return this.resaltarcosto_unitarioDetalleFacturaProveedor;
	}

	public void setResaltarcosto_unitarioDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleFacturaProveedor() {
		return this.mostrarcosto_unitarioDetalleFacturaProveedor;
	}

	public void setMostrarcosto_unitarioDetalleFacturaProveedor(Boolean mostrarcosto_unitarioDetalleFacturaProveedor) {
		this.mostrarcosto_unitarioDetalleFacturaProveedor= mostrarcosto_unitarioDetalleFacturaProveedor;
	}

	public Boolean getActivarcosto_unitarioDetalleFacturaProveedor() {
		return this.activarcosto_unitarioDetalleFacturaProveedor;
	}

	public void setActivarcosto_unitarioDetalleFacturaProveedor(Boolean activarcosto_unitarioDetalleFacturaProveedor) {
		this.activarcosto_unitarioDetalleFacturaProveedor= activarcosto_unitarioDetalleFacturaProveedor;
	}

	public Border setResaltarcosto_totalDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcosto_totalDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleFacturaProveedor() {
		return this.resaltarcosto_totalDetalleFacturaProveedor;
	}

	public void setResaltarcosto_totalDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarcosto_totalDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleFacturaProveedor() {
		return this.mostrarcosto_totalDetalleFacturaProveedor;
	}

	public void setMostrarcosto_totalDetalleFacturaProveedor(Boolean mostrarcosto_totalDetalleFacturaProveedor) {
		this.mostrarcosto_totalDetalleFacturaProveedor= mostrarcosto_totalDetalleFacturaProveedor;
	}

	public Boolean getActivarcosto_totalDetalleFacturaProveedor() {
		return this.activarcosto_totalDetalleFacturaProveedor;
	}

	public void setActivarcosto_totalDetalleFacturaProveedor(Boolean activarcosto_totalDetalleFacturaProveedor) {
		this.activarcosto_totalDetalleFacturaProveedor= activarcosto_totalDetalleFacturaProveedor;
	}

	public Border setResaltariceDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltariceDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleFacturaProveedor() {
		return this.resaltariceDetalleFacturaProveedor;
	}

	public void setResaltariceDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltariceDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrariceDetalleFacturaProveedor() {
		return this.mostrariceDetalleFacturaProveedor;
	}

	public void setMostrariceDetalleFacturaProveedor(Boolean mostrariceDetalleFacturaProveedor) {
		this.mostrariceDetalleFacturaProveedor= mostrariceDetalleFacturaProveedor;
	}

	public Boolean getActivariceDetalleFacturaProveedor() {
		return this.activariceDetalleFacturaProveedor;
	}

	public void setActivariceDetalleFacturaProveedor(Boolean activariceDetalleFacturaProveedor) {
		this.activariceDetalleFacturaProveedor= activariceDetalleFacturaProveedor;
	}

	public Border setResaltardescuento1DetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardescuento1DetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento1DetalleFacturaProveedor() {
		return this.resaltardescuento1DetalleFacturaProveedor;
	}

	public void setResaltardescuento1DetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardescuento1DetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardescuento1DetalleFacturaProveedor() {
		return this.mostrardescuento1DetalleFacturaProveedor;
	}

	public void setMostrardescuento1DetalleFacturaProveedor(Boolean mostrardescuento1DetalleFacturaProveedor) {
		this.mostrardescuento1DetalleFacturaProveedor= mostrardescuento1DetalleFacturaProveedor;
	}

	public Boolean getActivardescuento1DetalleFacturaProveedor() {
		return this.activardescuento1DetalleFacturaProveedor;
	}

	public void setActivardescuento1DetalleFacturaProveedor(Boolean activardescuento1DetalleFacturaProveedor) {
		this.activardescuento1DetalleFacturaProveedor= activardescuento1DetalleFacturaProveedor;
	}

	public Border setResaltardescuento2DetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardescuento2DetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetalleFacturaProveedor() {
		return this.resaltardescuento2DetalleFacturaProveedor;
	}

	public void setResaltardescuento2DetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardescuento2DetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardescuento2DetalleFacturaProveedor() {
		return this.mostrardescuento2DetalleFacturaProveedor;
	}

	public void setMostrardescuento2DetalleFacturaProveedor(Boolean mostrardescuento2DetalleFacturaProveedor) {
		this.mostrardescuento2DetalleFacturaProveedor= mostrardescuento2DetalleFacturaProveedor;
	}

	public Boolean getActivardescuento2DetalleFacturaProveedor() {
		return this.activardescuento2DetalleFacturaProveedor;
	}

	public void setActivardescuento2DetalleFacturaProveedor(Boolean activardescuento2DetalleFacturaProveedor) {
		this.activardescuento2DetalleFacturaProveedor= activardescuento2DetalleFacturaProveedor;
	}

	public Border setResaltardescripcionDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleFacturaProveedor() {
		return this.resaltardescripcionDetalleFacturaProveedor;
	}

	public void setResaltardescripcionDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardescripcionDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleFacturaProveedor() {
		return this.mostrardescripcionDetalleFacturaProveedor;
	}

	public void setMostrardescripcionDetalleFacturaProveedor(Boolean mostrardescripcionDetalleFacturaProveedor) {
		this.mostrardescripcionDetalleFacturaProveedor= mostrardescripcionDetalleFacturaProveedor;
	}

	public Boolean getActivardescripcionDetalleFacturaProveedor() {
		return this.activardescripcionDetalleFacturaProveedor;
	}

	public void setActivardescripcionDetalleFacturaProveedor(Boolean activardescripcionDetalleFacturaProveedor) {
		this.activardescripcionDetalleFacturaProveedor= activardescripcionDetalleFacturaProveedor;
	}

	public Border setResaltarprecio_ventaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarprecio_ventaDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ventaDetalleFacturaProveedor() {
		return this.resaltarprecio_ventaDetalleFacturaProveedor;
	}

	public void setResaltarprecio_ventaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarprecio_ventaDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarprecio_ventaDetalleFacturaProveedor() {
		return this.mostrarprecio_ventaDetalleFacturaProveedor;
	}

	public void setMostrarprecio_ventaDetalleFacturaProveedor(Boolean mostrarprecio_ventaDetalleFacturaProveedor) {
		this.mostrarprecio_ventaDetalleFacturaProveedor= mostrarprecio_ventaDetalleFacturaProveedor;
	}

	public Boolean getActivarprecio_ventaDetalleFacturaProveedor() {
		return this.activarprecio_ventaDetalleFacturaProveedor;
	}

	public void setActivarprecio_ventaDetalleFacturaProveedor(Boolean activarprecio_ventaDetalleFacturaProveedor) {
		this.activarprecio_ventaDetalleFacturaProveedor= activarprecio_ventaDetalleFacturaProveedor;
	}

	public Border setResaltarid_novedad_productoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_novedad_productoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoDetalleFacturaProveedor() {
		return this.resaltarid_novedad_productoDetalleFacturaProveedor;
	}

	public void setResaltarid_novedad_productoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_novedad_productoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoDetalleFacturaProveedor() {
		return this.mostrarid_novedad_productoDetalleFacturaProveedor;
	}

	public void setMostrarid_novedad_productoDetalleFacturaProveedor(Boolean mostrarid_novedad_productoDetalleFacturaProveedor) {
		this.mostrarid_novedad_productoDetalleFacturaProveedor= mostrarid_novedad_productoDetalleFacturaProveedor;
	}

	public Boolean getActivarid_novedad_productoDetalleFacturaProveedor() {
		return this.activarid_novedad_productoDetalleFacturaProveedor;
	}

	public void setActivarid_novedad_productoDetalleFacturaProveedor(Boolean activarid_novedad_productoDetalleFacturaProveedor) {
		this.activarid_novedad_productoDetalleFacturaProveedor= activarid_novedad_productoDetalleFacturaProveedor;
	}

	public Boolean getCargarid_novedad_productoDetalleFacturaProveedor() {
		return this.cargarid_novedad_productoDetalleFacturaProveedor;
	}

	public void setCargarid_novedad_productoDetalleFacturaProveedor(Boolean cargarid_novedad_productoDetalleFacturaProveedor) {
		this.cargarid_novedad_productoDetalleFacturaProveedor= cargarid_novedad_productoDetalleFacturaProveedor;
	}

	public Border setResaltarid_centro_costoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleFacturaProveedor() {
		return this.resaltarid_centro_costoDetalleFacturaProveedor;
	}

	public void setResaltarid_centro_costoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleFacturaProveedor() {
		return this.mostrarid_centro_costoDetalleFacturaProveedor;
	}

	public void setMostrarid_centro_costoDetalleFacturaProveedor(Boolean mostrarid_centro_costoDetalleFacturaProveedor) {
		this.mostrarid_centro_costoDetalleFacturaProveedor= mostrarid_centro_costoDetalleFacturaProveedor;
	}

	public Boolean getActivarid_centro_costoDetalleFacturaProveedor() {
		return this.activarid_centro_costoDetalleFacturaProveedor;
	}

	public void setActivarid_centro_costoDetalleFacturaProveedor(Boolean activarid_centro_costoDetalleFacturaProveedor) {
		this.activarid_centro_costoDetalleFacturaProveedor= activarid_centro_costoDetalleFacturaProveedor;
	}

	public Boolean getCargarid_centro_costoDetalleFacturaProveedor() {
		return this.cargarid_centro_costoDetalleFacturaProveedor;
	}

	public void setCargarid_centro_costoDetalleFacturaProveedor(Boolean cargarid_centro_costoDetalleFacturaProveedor) {
		this.cargarid_centro_costoDetalleFacturaProveedor= cargarid_centro_costoDetalleFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_costoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costoDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoDetalleFacturaProveedor() {
		return this.resaltarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_costoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoDetalleFacturaProveedor() {
		return this.mostrarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_costoDetalleFacturaProveedor(Boolean mostrarid_cuenta_contable_costoDetalleFacturaProveedor) {
		this.mostrarid_cuenta_contable_costoDetalleFacturaProveedor= mostrarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_costoDetalleFacturaProveedor() {
		return this.activarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_costoDetalleFacturaProveedor(Boolean activarid_cuenta_contable_costoDetalleFacturaProveedor) {
		this.activarid_cuenta_contable_costoDetalleFacturaProveedor= activarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_costoDetalleFacturaProveedor() {
		return this.cargarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_costoDetalleFacturaProveedor(Boolean cargarid_cuenta_contable_costoDetalleFacturaProveedor) {
		this.cargarid_cuenta_contable_costoDetalleFacturaProveedor= cargarid_cuenta_contable_costoDetalleFacturaProveedor;
	}

	public Border setResaltarid_bodega_enviarDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_bodega_enviarDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_enviarDetalleFacturaProveedor() {
		return this.resaltarid_bodega_enviarDetalleFacturaProveedor;
	}

	public void setResaltarid_bodega_enviarDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_bodega_enviarDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_bodega_enviarDetalleFacturaProveedor() {
		return this.mostrarid_bodega_enviarDetalleFacturaProveedor;
	}

	public void setMostrarid_bodega_enviarDetalleFacturaProveedor(Boolean mostrarid_bodega_enviarDetalleFacturaProveedor) {
		this.mostrarid_bodega_enviarDetalleFacturaProveedor= mostrarid_bodega_enviarDetalleFacturaProveedor;
	}

	public Boolean getActivarid_bodega_enviarDetalleFacturaProveedor() {
		return this.activarid_bodega_enviarDetalleFacturaProveedor;
	}

	public void setActivarid_bodega_enviarDetalleFacturaProveedor(Boolean activarid_bodega_enviarDetalleFacturaProveedor) {
		this.activarid_bodega_enviarDetalleFacturaProveedor= activarid_bodega_enviarDetalleFacturaProveedor;
	}

	public Boolean getCargarid_bodega_enviarDetalleFacturaProveedor() {
		return this.cargarid_bodega_enviarDetalleFacturaProveedor;
	}

	public void setCargarid_bodega_enviarDetalleFacturaProveedor(Boolean cargarid_bodega_enviarDetalleFacturaProveedor) {
		this.cargarid_bodega_enviarDetalleFacturaProveedor= cargarid_bodega_enviarDetalleFacturaProveedor;
	}

	public Border setResaltarlote_clienteDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarlote_clienteDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleFacturaProveedor() {
		return this.resaltarlote_clienteDetalleFacturaProveedor;
	}

	public void setResaltarlote_clienteDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarlote_clienteDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleFacturaProveedor() {
		return this.mostrarlote_clienteDetalleFacturaProveedor;
	}

	public void setMostrarlote_clienteDetalleFacturaProveedor(Boolean mostrarlote_clienteDetalleFacturaProveedor) {
		this.mostrarlote_clienteDetalleFacturaProveedor= mostrarlote_clienteDetalleFacturaProveedor;
	}

	public Boolean getActivarlote_clienteDetalleFacturaProveedor() {
		return this.activarlote_clienteDetalleFacturaProveedor;
	}

	public void setActivarlote_clienteDetalleFacturaProveedor(Boolean activarlote_clienteDetalleFacturaProveedor) {
		this.activarlote_clienteDetalleFacturaProveedor= activarlote_clienteDetalleFacturaProveedor;
	}

	public Border setResaltardisponibleDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardisponibleDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleDetalleFacturaProveedor() {
		return this.resaltardisponibleDetalleFacturaProveedor;
	}

	public void setResaltardisponibleDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardisponibleDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardisponibleDetalleFacturaProveedor() {
		return this.mostrardisponibleDetalleFacturaProveedor;
	}

	public void setMostrardisponibleDetalleFacturaProveedor(Boolean mostrardisponibleDetalleFacturaProveedor) {
		this.mostrardisponibleDetalleFacturaProveedor= mostrardisponibleDetalleFacturaProveedor;
	}

	public Boolean getActivardisponibleDetalleFacturaProveedor() {
		return this.activardisponibleDetalleFacturaProveedor;
	}

	public void setActivardisponibleDetalleFacturaProveedor(Boolean activardisponibleDetalleFacturaProveedor) {
		this.activardisponibleDetalleFacturaProveedor= activardisponibleDetalleFacturaProveedor;
	}

	public Border setResaltarserieDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarserieDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleFacturaProveedor() {
		return this.resaltarserieDetalleFacturaProveedor;
	}

	public void setResaltarserieDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarserieDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarserieDetalleFacturaProveedor() {
		return this.mostrarserieDetalleFacturaProveedor;
	}

	public void setMostrarserieDetalleFacturaProveedor(Boolean mostrarserieDetalleFacturaProveedor) {
		this.mostrarserieDetalleFacturaProveedor= mostrarserieDetalleFacturaProveedor;
	}

	public Boolean getActivarserieDetalleFacturaProveedor() {
		return this.activarserieDetalleFacturaProveedor;
	}

	public void setActivarserieDetalleFacturaProveedor(Boolean activarserieDetalleFacturaProveedor) {
		this.activarserieDetalleFacturaProveedor= activarserieDetalleFacturaProveedor;
	}

	public Border setResaltarice_valorDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarice_valorDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleFacturaProveedor() {
		return this.resaltarice_valorDetalleFacturaProveedor;
	}

	public void setResaltarice_valorDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarice_valorDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleFacturaProveedor() {
		return this.mostrarice_valorDetalleFacturaProveedor;
	}

	public void setMostrarice_valorDetalleFacturaProveedor(Boolean mostrarice_valorDetalleFacturaProveedor) {
		this.mostrarice_valorDetalleFacturaProveedor= mostrarice_valorDetalleFacturaProveedor;
	}

	public Boolean getActivarice_valorDetalleFacturaProveedor() {
		return this.activarice_valorDetalleFacturaProveedor;
	}

	public void setActivarice_valorDetalleFacturaProveedor(Boolean activarice_valorDetalleFacturaProveedor) {
		this.activarice_valorDetalleFacturaProveedor= activarice_valorDetalleFacturaProveedor;
	}

	public Border setResaltarid_anioDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleFacturaProveedor() {
		return this.resaltarid_anioDetalleFacturaProveedor;
	}

	public void setResaltarid_anioDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_anioDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleFacturaProveedor() {
		return this.mostrarid_anioDetalleFacturaProveedor;
	}

	public void setMostrarid_anioDetalleFacturaProveedor(Boolean mostrarid_anioDetalleFacturaProveedor) {
		this.mostrarid_anioDetalleFacturaProveedor= mostrarid_anioDetalleFacturaProveedor;
	}

	public Boolean getActivarid_anioDetalleFacturaProveedor() {
		return this.activarid_anioDetalleFacturaProveedor;
	}

	public void setActivarid_anioDetalleFacturaProveedor(Boolean activarid_anioDetalleFacturaProveedor) {
		this.activarid_anioDetalleFacturaProveedor= activarid_anioDetalleFacturaProveedor;
	}

	public Boolean getCargarid_anioDetalleFacturaProveedor() {
		return this.cargarid_anioDetalleFacturaProveedor;
	}

	public void setCargarid_anioDetalleFacturaProveedor(Boolean cargarid_anioDetalleFacturaProveedor) {
		this.cargarid_anioDetalleFacturaProveedor= cargarid_anioDetalleFacturaProveedor;
	}

	public Border setResaltarid_mesDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaproveedorBeanSwingJInternalFrame.jTtoolBarDetalleFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleFacturaProveedor() {
		return this.resaltarid_mesDetalleFacturaProveedor;
	}

	public void setResaltarid_mesDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarid_mesDetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleFacturaProveedor() {
		return this.mostrarid_mesDetalleFacturaProveedor;
	}

	public void setMostrarid_mesDetalleFacturaProveedor(Boolean mostrarid_mesDetalleFacturaProveedor) {
		this.mostrarid_mesDetalleFacturaProveedor= mostrarid_mesDetalleFacturaProveedor;
	}

	public Boolean getActivarid_mesDetalleFacturaProveedor() {
		return this.activarid_mesDetalleFacturaProveedor;
	}

	public void setActivarid_mesDetalleFacturaProveedor(Boolean activarid_mesDetalleFacturaProveedor) {
		this.activarid_mesDetalleFacturaProveedor= activarid_mesDetalleFacturaProveedor;
	}

	public Boolean getCargarid_mesDetalleFacturaProveedor() {
		return this.cargarid_mesDetalleFacturaProveedor;
	}

	public void setCargarid_mesDetalleFacturaProveedor(Boolean cargarid_mesDetalleFacturaProveedor) {
		this.cargarid_mesDetalleFacturaProveedor= cargarid_mesDetalleFacturaProveedor;
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
		
		
		this.setMostraridDetalleFacturaProveedor(esInicial);
		this.setMostrarid_factura_proveedorDetalleFacturaProveedor(esInicial);
		this.setMostrarid_empresaDetalleFacturaProveedor(esInicial);
		this.setMostrarid_sucursalDetalleFacturaProveedor(esInicial);
		this.setMostrarid_bodegaDetalleFacturaProveedor(esInicial);
		this.setMostrarid_productoDetalleFacturaProveedor(esInicial);
		this.setMostrarid_unidadDetalleFacturaProveedor(esInicial);
		this.setMostrarid_ejercicioDetalleFacturaProveedor(esInicial);
		this.setMostrarid_periodoDetalleFacturaProveedor(esInicial);
		this.setMostrarnumero_comprobanteDetalleFacturaProveedor(esInicial);
		this.setMostrarcantidadDetalleFacturaProveedor(esInicial);
		this.setMostrarcantidad_auxiliarDetalleFacturaProveedor(esInicial);
		this.setMostrardescuentoDetalleFacturaProveedor(esInicial);
		this.setMostrarivaDetalleFacturaProveedor(esInicial);
		this.setMostrarloteDetalleFacturaProveedor(esInicial);
		this.setMostrarfecha_elaboracion_loteDetalleFacturaProveedor(esInicial);
		this.setMostrarfecha_caducidad_loteDetalleFacturaProveedor(esInicial);
		this.setMostrarcosto_ivaDetalleFacturaProveedor(esInicial);
		this.setMostrarcosto_unitarioDetalleFacturaProveedor(esInicial);
		this.setMostrarcosto_totalDetalleFacturaProveedor(esInicial);
		this.setMostrariceDetalleFacturaProveedor(esInicial);
		this.setMostrardescuento1DetalleFacturaProveedor(esInicial);
		this.setMostrardescuento2DetalleFacturaProveedor(esInicial);
		this.setMostrardescripcionDetalleFacturaProveedor(esInicial);
		this.setMostrarprecio_ventaDetalleFacturaProveedor(esInicial);
		this.setMostrarid_novedad_productoDetalleFacturaProveedor(esInicial);
		this.setMostrarid_centro_costoDetalleFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_costoDetalleFacturaProveedor(esInicial);
		this.setMostrarid_bodega_enviarDetalleFacturaProveedor(esInicial);
		this.setMostrarlote_clienteDetalleFacturaProveedor(esInicial);
		this.setMostrardisponibleDetalleFacturaProveedor(esInicial);
		this.setMostrarserieDetalleFacturaProveedor(esInicial);
		this.setMostrarice_valorDetalleFacturaProveedor(esInicial);
		this.setMostrarid_anioDetalleFacturaProveedor(esInicial);
		this.setMostrarid_mesDetalleFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ID)) {
				this.setMostraridDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR)) {
				this.setMostrarid_factura_proveedorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setMostrarcantidad_auxiliarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setMostrarfecha_elaboracion_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setMostrarfecha_caducidad_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOIVA)) {
				this.setMostrarcosto_ivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICE)) {
				this.setMostrariceDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1)) {
				this.setMostrardescuento1DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA)) {
				this.setMostrarprecio_ventaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR)) {
				this.setMostrarid_bodega_enviarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleFacturaProveedor(esAsigna);
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
		
		
		this.setActivaridDetalleFacturaProveedor(esInicial);
		this.setActivarid_factura_proveedorDetalleFacturaProveedor(esInicial);
		this.setActivarid_empresaDetalleFacturaProveedor(esInicial);
		this.setActivarid_sucursalDetalleFacturaProveedor(esInicial);
		this.setActivarid_bodegaDetalleFacturaProveedor(esInicial);
		this.setActivarid_productoDetalleFacturaProveedor(esInicial);
		this.setActivarid_unidadDetalleFacturaProveedor(esInicial);
		this.setActivarid_ejercicioDetalleFacturaProveedor(esInicial);
		this.setActivarid_periodoDetalleFacturaProveedor(esInicial);
		this.setActivarnumero_comprobanteDetalleFacturaProveedor(esInicial);
		this.setActivarcantidadDetalleFacturaProveedor(esInicial);
		this.setActivarcantidad_auxiliarDetalleFacturaProveedor(esInicial);
		this.setActivardescuentoDetalleFacturaProveedor(esInicial);
		this.setActivarivaDetalleFacturaProveedor(esInicial);
		this.setActivarloteDetalleFacturaProveedor(esInicial);
		this.setActivarfecha_elaboracion_loteDetalleFacturaProveedor(esInicial);
		this.setActivarfecha_caducidad_loteDetalleFacturaProveedor(esInicial);
		this.setActivarcosto_ivaDetalleFacturaProveedor(esInicial);
		this.setActivarcosto_unitarioDetalleFacturaProveedor(esInicial);
		this.setActivarcosto_totalDetalleFacturaProveedor(esInicial);
		this.setActivariceDetalleFacturaProveedor(esInicial);
		this.setActivardescuento1DetalleFacturaProveedor(esInicial);
		this.setActivardescuento2DetalleFacturaProveedor(esInicial);
		this.setActivardescripcionDetalleFacturaProveedor(esInicial);
		this.setActivarprecio_ventaDetalleFacturaProveedor(esInicial);
		this.setActivarid_novedad_productoDetalleFacturaProveedor(esInicial);
		this.setActivarid_centro_costoDetalleFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_costoDetalleFacturaProveedor(esInicial);
		this.setActivarid_bodega_enviarDetalleFacturaProveedor(esInicial);
		this.setActivarlote_clienteDetalleFacturaProveedor(esInicial);
		this.setActivardisponibleDetalleFacturaProveedor(esInicial);
		this.setActivarserieDetalleFacturaProveedor(esInicial);
		this.setActivarice_valorDetalleFacturaProveedor(esInicial);
		this.setActivarid_anioDetalleFacturaProveedor(esInicial);
		this.setActivarid_mesDetalleFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ID)) {
				this.setActivaridDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR)) {
				this.setActivarid_factura_proveedorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setActivarcantidad_auxiliarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IVA)) {
				this.setActivarivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setActivarfecha_elaboracion_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setActivarfecha_caducidad_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOIVA)) {
				this.setActivarcosto_ivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICE)) {
				this.setActivariceDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1)) {
				this.setActivardescuento1DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA)) {
				this.setActivarprecio_ventaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR)) {
				this.setActivarid_bodega_enviarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleFacturaProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleFacturaProveedor(esInicial);
		this.setResaltarid_factura_proveedorDetalleFacturaProveedor(esInicial);
		this.setResaltarid_empresaDetalleFacturaProveedor(esInicial);
		this.setResaltarid_sucursalDetalleFacturaProveedor(esInicial);
		this.setResaltarid_bodegaDetalleFacturaProveedor(esInicial);
		this.setResaltarid_productoDetalleFacturaProveedor(esInicial);
		this.setResaltarid_unidadDetalleFacturaProveedor(esInicial);
		this.setResaltarid_ejercicioDetalleFacturaProveedor(esInicial);
		this.setResaltarid_periodoDetalleFacturaProveedor(esInicial);
		this.setResaltarnumero_comprobanteDetalleFacturaProveedor(esInicial);
		this.setResaltarcantidadDetalleFacturaProveedor(esInicial);
		this.setResaltarcantidad_auxiliarDetalleFacturaProveedor(esInicial);
		this.setResaltardescuentoDetalleFacturaProveedor(esInicial);
		this.setResaltarivaDetalleFacturaProveedor(esInicial);
		this.setResaltarloteDetalleFacturaProveedor(esInicial);
		this.setResaltarfecha_elaboracion_loteDetalleFacturaProveedor(esInicial);
		this.setResaltarfecha_caducidad_loteDetalleFacturaProveedor(esInicial);
		this.setResaltarcosto_ivaDetalleFacturaProveedor(esInicial);
		this.setResaltarcosto_unitarioDetalleFacturaProveedor(esInicial);
		this.setResaltarcosto_totalDetalleFacturaProveedor(esInicial);
		this.setResaltariceDetalleFacturaProveedor(esInicial);
		this.setResaltardescuento1DetalleFacturaProveedor(esInicial);
		this.setResaltardescuento2DetalleFacturaProveedor(esInicial);
		this.setResaltardescripcionDetalleFacturaProveedor(esInicial);
		this.setResaltarprecio_ventaDetalleFacturaProveedor(esInicial);
		this.setResaltarid_novedad_productoDetalleFacturaProveedor(esInicial);
		this.setResaltarid_centro_costoDetalleFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_costoDetalleFacturaProveedor(esInicial);
		this.setResaltarid_bodega_enviarDetalleFacturaProveedor(esInicial);
		this.setResaltarlote_clienteDetalleFacturaProveedor(esInicial);
		this.setResaltardisponibleDetalleFacturaProveedor(esInicial);
		this.setResaltarserieDetalleFacturaProveedor(esInicial);
		this.setResaltarice_valorDetalleFacturaProveedor(esInicial);
		this.setResaltarid_anioDetalleFacturaProveedor(esInicial);
		this.setResaltarid_mesDetalleFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ID)) {
				this.setResaltaridDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR)) {
				this.setResaltarid_factura_proveedorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setResaltarcantidad_auxiliarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setResaltarfecha_elaboracion_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setResaltarfecha_caducidad_loteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOIVA)) {
				this.setResaltarcosto_ivaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICE)) {
				this.setResaltariceDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1)) {
				this.setResaltardescuento1DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA)) {
				this.setResaltarprecio_ventaDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR)) {
				this.setResaltarid_bodega_enviarDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaProveedorConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleFacturaProveedor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdAnioDetalleFacturaProveedor() {
		return this.mostrarFK_IdAnioDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdAnioDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdBodegaDetalleFacturaProveedor() {
		return this.mostrarFK_IdBodegaDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdBodegaDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaEnviarDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdBodegaEnviarDetalleFacturaProveedor() {
		return this.mostrarFK_IdBodegaEnviarDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdBodegaEnviarDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaEnviarDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleFacturaProveedor() {
		return this.mostrarFK_IdCentroCostoDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdCentroCostoDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdCuentaContableCostoDetalleFacturaProveedor() {
		return this.mostrarFK_IdCuentaContableCostoDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdCuentaContableCostoDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdEjercicioDetalleFacturaProveedor() {
		return this.mostrarFK_IdEjercicioDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdEjercicioDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdEmpresaDetalleFacturaProveedor() {
		return this.mostrarFK_IdEmpresaDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdEmpresaDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaProveedorDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdFacturaProveedorDetalleFacturaProveedor() {
		return this.mostrarFK_IdFacturaProveedorDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdFacturaProveedorDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaProveedorDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdMesDetalleFacturaProveedor() {
		return this.mostrarFK_IdMesDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdMesDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdNovedadProductoDetalleFacturaProveedor() {
		return this.mostrarFK_IdNovedadProductoDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdNovedadProductoDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdPeriodoDetalleFacturaProveedor() {
		return this.mostrarFK_IdPeriodoDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdPeriodoDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdProductoDetalleFacturaProveedor() {
		return this.mostrarFK_IdProductoDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdProductoDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdSucursalDetalleFacturaProveedor() {
		return this.mostrarFK_IdSucursalDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdSucursalDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleFacturaProveedor=true;

	public Boolean getMostrarFK_IdUnidadDetalleFacturaProveedor() {
		return this.mostrarFK_IdUnidadDetalleFacturaProveedor;
	}

	public void setMostrarFK_IdUnidadDetalleFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleFacturaProveedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdAnioDetalleFacturaProveedor() {
		return this.activarFK_IdAnioDetalleFacturaProveedor;
	}

	public void setActivarFK_IdAnioDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdAnioDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdBodegaDetalleFacturaProveedor() {
		return this.activarFK_IdBodegaDetalleFacturaProveedor;
	}

	public void setActivarFK_IdBodegaDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaEnviarDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdBodegaEnviarDetalleFacturaProveedor() {
		return this.activarFK_IdBodegaEnviarDetalleFacturaProveedor;
	}

	public void setActivarFK_IdBodegaEnviarDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaEnviarDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdCentroCostoDetalleFacturaProveedor() {
		return this.activarFK_IdCentroCostoDetalleFacturaProveedor;
	}

	public void setActivarFK_IdCentroCostoDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdCuentaContableCostoDetalleFacturaProveedor() {
		return this.activarFK_IdCuentaContableCostoDetalleFacturaProveedor;
	}

	public void setActivarFK_IdCuentaContableCostoDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdEjercicioDetalleFacturaProveedor() {
		return this.activarFK_IdEjercicioDetalleFacturaProveedor;
	}

	public void setActivarFK_IdEjercicioDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdEmpresaDetalleFacturaProveedor() {
		return this.activarFK_IdEmpresaDetalleFacturaProveedor;
	}

	public void setActivarFK_IdEmpresaDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaProveedorDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdFacturaProveedorDetalleFacturaProveedor() {
		return this.activarFK_IdFacturaProveedorDetalleFacturaProveedor;
	}

	public void setActivarFK_IdFacturaProveedorDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaProveedorDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdMesDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdMesDetalleFacturaProveedor() {
		return this.activarFK_IdMesDetalleFacturaProveedor;
	}

	public void setActivarFK_IdMesDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdMesDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdNovedadProductoDetalleFacturaProveedor() {
		return this.activarFK_IdNovedadProductoDetalleFacturaProveedor;
	}

	public void setActivarFK_IdNovedadProductoDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdPeriodoDetalleFacturaProveedor() {
		return this.activarFK_IdPeriodoDetalleFacturaProveedor;
	}

	public void setActivarFK_IdPeriodoDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdProductoDetalleFacturaProveedor() {
		return this.activarFK_IdProductoDetalleFacturaProveedor;
	}

	public void setActivarFK_IdProductoDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdSucursalDetalleFacturaProveedor() {
		return this.activarFK_IdSucursalDetalleFacturaProveedor;
	}

	public void setActivarFK_IdSucursalDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleFacturaProveedor=true;

	public Boolean getActivarFK_IdUnidadDetalleFacturaProveedor() {
		return this.activarFK_IdUnidadDetalleFacturaProveedor;
	}

	public void setActivarFK_IdUnidadDetalleFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleFacturaProveedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdAnioDetalleFacturaProveedor() {
		return this.resaltarFK_IdAnioDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdAnioDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdAnioDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdAnioDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdBodegaDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdBodegaDetalleFacturaProveedor() {
		return this.resaltarFK_IdBodegaDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdBodegaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdBodegaEnviarDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdBodegaEnviarDetalleFacturaProveedor() {
		return this.resaltarFK_IdBodegaEnviarDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdBodegaEnviarDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdBodegaEnviarDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaEnviarDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaEnviarDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdCentroCostoDetalleFacturaProveedor() {
		return this.resaltarFK_IdCentroCostoDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdCentroCostoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdCuentaContableCostoDetalleFacturaProveedor() {
		return this.resaltarFK_IdCuentaContableCostoDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdEjercicioDetalleFacturaProveedor() {
		return this.resaltarFK_IdEjercicioDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdEjercicioDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdEmpresaDetalleFacturaProveedor() {
		return this.resaltarFK_IdEmpresaDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdEmpresaDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdFacturaProveedorDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdFacturaProveedorDetalleFacturaProveedor() {
		return this.resaltarFK_IdFacturaProveedorDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdFacturaProveedorDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdFacturaProveedorDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdFacturaProveedorDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaProveedorDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdMesDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdMesDetalleFacturaProveedor() {
		return this.resaltarFK_IdMesDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdMesDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdMesDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdMesDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdNovedadProductoDetalleFacturaProveedor() {
		return this.resaltarFK_IdNovedadProductoDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdNovedadProductoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdPeriodoDetalleFacturaProveedor() {
		return this.resaltarFK_IdPeriodoDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdPeriodoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdProductoDetalleFacturaProveedor() {
		return this.resaltarFK_IdProductoDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdProductoDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdSucursalDetalleFacturaProveedor() {
		return this.resaltarFK_IdSucursalDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdSucursalDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleFacturaProveedor=null;

	public Border getResaltarFK_IdUnidadDetalleFacturaProveedor() {
		return this.resaltarFK_IdUnidadDetalleFacturaProveedor;
	}

	public void setResaltarFK_IdUnidadDetalleFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaProveedorBeanSwingJInternalFrame detallefacturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleFacturaProveedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}