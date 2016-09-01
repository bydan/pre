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


import com.bydan.erp.inventario.util.DetalleCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleCompraParameterGeneral;

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
final public class DetalleCompraConstantesFunciones extends DetalleCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleCompra"+DetalleCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleCompraConstantesFunciones.SCHEMA+"_"+DetalleCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleCompraConstantesFunciones.SCHEMA+"_"+DetalleCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleCompraConstantesFunciones.SCHEMA+"_"+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleCompraConstantesFunciones.SCHEMA+"_"+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleCompra";
	public static final String OBJECTNAME="detallecompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallecompra from "+DetalleCompraConstantesFunciones.SPERSISTENCENAME+" detallecompra";
	public static String QUERYSELECTNATIVE="select "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_compra,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_estado_detalle_inventario,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".cantidad,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".iva,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".iva_valor,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".disponible,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_iva,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".ice,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".ice_valor,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento1,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento2,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".serie,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME;//+" as "+DetalleCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleCompraConstantesFuncionesAdditional detallecompraConstantesFuncionesAdditional=null;
	
	public DetalleCompraConstantesFuncionesAdditional getDetalleCompraConstantesFuncionesAdditional() {
		return this.detallecompraConstantesFuncionesAdditional;
	}
	
	public void setDetalleCompraConstantesFuncionesAdditional(DetalleCompraConstantesFuncionesAdditional detallecompraConstantesFuncionesAdditional) {
		try {
			this.detallecompraConstantesFuncionesAdditional=detallecompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCOMPRA= "id_compra";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDESTADODETALLEINVENTARIO= "id_estado_detalle_inventario";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCUENTO= "descuento";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DISPONIBLE= "disponible";
    public static final String COSTOIVA= "costo_iva";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String DESCUENTO1= "descuento1";
    public static final String DESCUENTO2= "descuento2";
    public static final String SERIE= "serie";
    public static final String LOTE= "lote";
    public static final String FECHAELABORACIONLOTE= "fecha_elaboracion_lote";
    public static final String FECHACADUCIDADLOTE= "fecha_caducidad_lote";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String LOTECLIENTE= "lote_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCOMPRA= "Compra";
		public static final String LABEL_IDCOMPRA_LOWER= "Compra";
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
    	public static final String LABEL_IDESTADODETALLEINVENTARIO= "Estado";
		public static final String LABEL_IDESTADODETALLEINVENTARIO_LOWER= "Estado Detalle Inventario";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_COSTOIVA= "Costo Iva";
		public static final String LABEL_COSTOIVA_LOWER= "Costo Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ICEVALOR= "Ice Valor";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_DESCUENTO1= "Descuento 1";
		public static final String LABEL_DESCUENTO1_LOWER= "Descuento1";
    	public static final String LABEL_DESCUENTO2= "Descuento 2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_FECHAELABORACIONLOTE= "F Elaboracion Lote";
		public static final String LABEL_FECHAELABORACIONLOTE_LOWER= "Fecha Elaboracion Lote";
    	public static final String LABEL_FECHACADUCIDADLOTE= "F Caducidad Lote";
		public static final String LABEL_FECHACADUCIDADLOTE_LOWER= "Fecha Caducidad Lote";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "Cta Contable Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Nro Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_LOTECLIENTE= "Lote Cliente";
		public static final String LABEL_LOTECLIENTE_LOWER= "Lote Cliente";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDCOMPRA)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDCOMPRA;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDANIO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDMES)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IVA)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.DISPONIBLE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.COSTOIVA)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_COSTOIVA;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.ICE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.DESCUENTO1)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_DESCUENTO1;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.SERIE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.LOTE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_FECHAELABORACIONLOTE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_FECHACADUCIDADLOTE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleCompraConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleCompraConstantesFunciones.LABEL_LOTECLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcosto_ivaDescripcion(DetalleCompra detallecompra) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallecompra.getcosto_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcosto_ivaHtmlDescripcion(DetalleCompra detallecompra) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallecompra.getId(),detallecompra.getcosto_iva());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleCompraDescripcion(DetalleCompra detallecompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallecompra !=null/* && detallecompra.getId()!=0*/) {
			if(detallecompra.getId()!=null) {
				sDescripcion=detallecompra.getId().toString();
			}//detallecompradetallecompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleCompraDescripcionDetallado(DetalleCompra detallecompra) {
		String sDescripcion="";
			
		sDescripcion+=DetalleCompraConstantesFunciones.ID+"=";
		sDescripcion+=detallecompra.getId().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallecompra.getVersionRow().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDCOMPRA+"=";
		sDescripcion+=detallecompra.getid_compra().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallecompra.getid_empresa().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallecompra.getid_sucursal().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallecompra.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallecompra.getid_periodo().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallecompra.getid_anio().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=detallecompra.getid_mes().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO+"=";
		sDescripcion+=detallecompra.getid_estado_detalle_inventario().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallecompra.getid_bodega().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallecompra.getid_producto().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallecompra.getid_unidad().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallecompra.getdescripcion()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=detallecompra.getid_novedad_producto().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallecompra.getcantidad().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallecompra.getdescuento().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detallecompra.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IVA+"=";
		sDescripcion+=detallecompra.getiva().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallecompra.getiva_valor().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detallecompra.getcosto_total().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=detallecompra.getdisponible().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.COSTOIVA+"=";
		sDescripcion+=detallecompra.getcosto_iva().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.ICE+"=";
		sDescripcion+=detallecompra.getice().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallecompra.getice_valor().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.DESCUENTO1+"=";
		sDescripcion+=detallecompra.getdescuento1().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detallecompra.getdescuento2().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.SERIE+"=";
		sDescripcion+=detallecompra.getserie()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.LOTE+"=";
		sDescripcion+=detallecompra.getlote()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE+"=";
		sDescripcion+=detallecompra.getfecha_elaboracion_lote().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE+"=";
		sDescripcion+=detallecompra.getfecha_caducidad_lote().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallecompra.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=detallecompra.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detallecompra.getnumero_comprobante()+",";
		sDescripcion+=DetalleCompraConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detallecompra.getlote_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleCompraDescripcion(DetalleCompra detallecompra,String sValor) throws Exception {			
		if(detallecompra !=null) {
			//detallecompradetallecompra.getId().toString();
		}		
	}
	
		

	public static String getCompraDescripcion(Compra compra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(compra!=null/*&&compra.getId()>0*/) {
			sDescripcion=CompraConstantesFunciones.getCompraDescripcion(compra);
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

	public static String getEstadoDetalleInventarioDescripcion(EstadoDetalleInventario estadodetalleinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetalleinventario!=null/*&&estadodetalleinventario.getId()>0*/) {
			sDescripcion=EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(estadodetalleinventario);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCompra")) {
			sNombreIndice="Tipo=  Por Compra";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por Cta Contable Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleInventario")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNovedadProducto")) {
			sNombreIndice="Tipo=  Por Novedad";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCompra(Long id_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_compra!=null) {sDetalleIndice+=" Codigo Unico De Compra="+id_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCosto(Long id_cuenta_contable_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Costo="+id_cuenta_contable_costo.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoDetalleInventario(Long id_estado_detalle_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_inventario!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNovedadProducto(Long id_novedad_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_novedad_producto!=null) {sDetalleIndice+=" Codigo Unico De Novedad="+id_novedad_producto.toString();} 

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
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleCompra(DetalleCompra detallecompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallecompra.setdescripcion(detallecompra.getdescripcion().trim());
		detallecompra.setserie(detallecompra.getserie().trim());
		detallecompra.setlote(detallecompra.getlote().trim());
		detallecompra.setnumero_comprobante(detallecompra.getnumero_comprobante().trim());
		detallecompra.setlote_cliente(detallecompra.getlote_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleCompras(List<DetalleCompra> detallecompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleCompra detallecompra: detallecompras) {
			detallecompra.setdescripcion(detallecompra.getdescripcion().trim());
			detallecompra.setserie(detallecompra.getserie().trim());
			detallecompra.setlote(detallecompra.getlote().trim());
			detallecompra.setnumero_comprobante(detallecompra.getnumero_comprobante().trim());
			detallecompra.setlote_cliente(detallecompra.getlote_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCompra(DetalleCompra detallecompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallecompra.getConCambioAuxiliar()) {
			detallecompra.setIsDeleted(detallecompra.getIsDeletedAuxiliar());	
			detallecompra.setIsNew(detallecompra.getIsNewAuxiliar());	
			detallecompra.setIsChanged(detallecompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallecompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallecompra.setIsDeletedAuxiliar(false);	
			detallecompra.setIsNewAuxiliar(false);	
			detallecompra.setIsChangedAuxiliar(false);
			
			detallecompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCompras(List<DetalleCompra> detallecompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleCompra detallecompra : detallecompras) {
			if(conAsignarBase && detallecompra.getConCambioAuxiliar()) {
				detallecompra.setIsDeleted(detallecompra.getIsDeletedAuxiliar());	
				detallecompra.setIsNew(detallecompra.getIsNewAuxiliar());	
				detallecompra.setIsChanged(detallecompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallecompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallecompra.setIsDeletedAuxiliar(false);	
				detallecompra.setIsNewAuxiliar(false);	
				detallecompra.setIsChangedAuxiliar(false);
				
				detallecompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleCompra(DetalleCompra detallecompra,Boolean conEnteros) throws Exception  {
		detallecompra.setdescuento(0.0);
		detallecompra.setcosto_unitario(0.0);
		detallecompra.setiva(0.0);
		detallecompra.setiva_valor(0.0);
		detallecompra.setcosto_total(0.0);
		detallecompra.setice(0.0);
		detallecompra.setice_valor(0.0);
		detallecompra.setdescuento1(0.0);
		detallecompra.setdescuento2(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallecompra.setcantidad(0);
			detallecompra.setdisponible(0);
		}
	}		
	
	public static void InicializarValoresDetalleCompras(List<DetalleCompra> detallecompras,Boolean conEnteros) throws Exception  {
		
		for(DetalleCompra detallecompra: detallecompras) {
			detallecompra.setdescuento(0.0);
			detallecompra.setcosto_unitario(0.0);
			detallecompra.setiva(0.0);
			detallecompra.setiva_valor(0.0);
			detallecompra.setcosto_total(0.0);
			detallecompra.setice(0.0);
			detallecompra.setice_valor(0.0);
			detallecompra.setdescuento1(0.0);
			detallecompra.setdescuento2(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallecompra.setcantidad(0);
				detallecompra.setdisponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleCompra(List<DetalleCompra> detallecompras,DetalleCompra detallecompraAux) throws Exception  {
		DetalleCompraConstantesFunciones.InicializarValoresDetalleCompra(detallecompraAux,true);
		
		for(DetalleCompra detallecompra: detallecompras) {
			if(detallecompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallecompraAux.setcantidad(detallecompraAux.getcantidad()+detallecompra.getcantidad());			
			detallecompraAux.setdescuento(detallecompraAux.getdescuento()+detallecompra.getdescuento());			
			detallecompraAux.setcosto_unitario(detallecompraAux.getcosto_unitario()+detallecompra.getcosto_unitario());			
			detallecompraAux.setiva(detallecompraAux.getiva()+detallecompra.getiva());			
			detallecompraAux.setiva_valor(detallecompraAux.getiva_valor()+detallecompra.getiva_valor());			
			detallecompraAux.setcosto_total(detallecompraAux.getcosto_total()+detallecompra.getcosto_total());			
			detallecompraAux.setdisponible(detallecompraAux.getdisponible()+detallecompra.getdisponible());			
			detallecompraAux.setice(detallecompraAux.getice()+detallecompra.getice());			
			detallecompraAux.setice_valor(detallecompraAux.getice_valor()+detallecompra.getice_valor());			
			detallecompraAux.setdescuento1(detallecompraAux.getdescuento1()+detallecompra.getdescuento1());			
			detallecompraAux.setdescuento2(detallecompraAux.getdescuento2()+detallecompra.getdescuento2());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleCompraConstantesFunciones.getArrayColumnasGlobalesDetalleCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCompraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleCompra> detallecompras,DetalleCompra detallecompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleCompra detallecompraAux: detallecompras) {
			if(detallecompraAux!=null && detallecompra!=null) {
				if((detallecompraAux.getId()==null && detallecompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallecompraAux.getId()!=null && detallecompra.getId()!=null){
					if(detallecompraAux.getId().equals(detallecompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleCompra(List<DetalleCompra> detallecompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double costo_totalTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double descuento1Total=0.0;
		Double descuento2Total=0.0;
	
		for(DetalleCompra detallecompra: detallecompras) {			
			if(detallecompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=detallecompra.getdescuento();
			costo_unitarioTotal+=detallecompra.getcosto_unitario();
			ivaTotal+=detallecompra.getiva();
			iva_valorTotal+=detallecompra.getiva_valor();
			costo_totalTotal+=detallecompra.getcosto_total();
			iceTotal+=detallecompra.getice();
			ice_valorTotal+=detallecompra.getice_valor();
			descuento1Total+=detallecompra.getdescuento1();
			descuento2Total+=detallecompra.getdescuento2();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.DESCUENTO1);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO1);
		datoGeneral.setdValorDouble(descuento1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCompraConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_ID, DetalleCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_VERSIONROW, DetalleCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDCOMPRA, DetalleCompraConstantesFunciones.IDCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDEMPRESA, DetalleCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDSUCURSAL, DetalleCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDEJERCICIO, DetalleCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDPERIODO, DetalleCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDANIO, DetalleCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDMES, DetalleCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO, DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDBODEGA, DetalleCompraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDPRODUCTO, DetalleCompraConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDUNIDAD, DetalleCompraConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_DESCRIPCION, DetalleCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_CANTIDAD, DetalleCompraConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_DESCUENTO, DetalleCompraConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO, DetalleCompraConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IVA, DetalleCompraConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IVAVALOR, DetalleCompraConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL, DetalleCompraConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_DISPONIBLE, DetalleCompraConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_COSTOIVA, DetalleCompraConstantesFunciones.COSTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_ICE, DetalleCompraConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_ICEVALOR, DetalleCompraConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_DESCUENTO1, DetalleCompraConstantesFunciones.DESCUENTO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_DESCUENTO2, DetalleCompraConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_SERIE, DetalleCompraConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_LOTE, DetalleCompraConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_FECHAELABORACIONLOTE, DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_FECHACADUCIDADLOTE, DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleCompraConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCompraConstantesFunciones.LABEL_LOTECLIENTE, DetalleCompraConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.COSTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.DESCUENTO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCompraConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCompra() throws Exception  {
		return DetalleCompraConstantesFunciones.getTiposSeleccionarDetalleCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCompra(Boolean conFk) throws Exception  {
		return DetalleCompraConstantesFunciones.getTiposSeleccionarDetalleCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDCOMPRA);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_COSTOIVA);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_COSTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_DESCUENTO1);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_FECHAELABORACIONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_FECHACADUCIDADLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCompraConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleCompraConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCompra(DetalleCompra detallecompraAux) throws Exception {
		
			detallecompraAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(detallecompraAux.getCompra()));
			detallecompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallecompraAux.getEmpresa()));
			detallecompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallecompraAux.getSucursal()));
			detallecompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallecompraAux.getEjercicio()));
			detallecompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallecompraAux.getPeriodo()));
			detallecompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallecompraAux.getAnio()));
			detallecompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallecompraAux.getMes()));
			detallecompraAux.setestadodetalleinventario_descripcion(EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(detallecompraAux.getEstadoDetalleInventario()));
			detallecompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallecompraAux.getBodega()));
			detallecompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallecompraAux.getProducto()));
			detallecompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallecompraAux.getUnidad()));
			detallecompraAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallecompraAux.getNovedadProducto()));
			detallecompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallecompraAux.getCentroCosto()));
			detallecompraAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallecompraAux.getCuentaContableCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCompra(List<DetalleCompra> detallecomprasTemp) throws Exception {
		for(DetalleCompra detallecompraAux:detallecomprasTemp) {
			
			detallecompraAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(detallecompraAux.getCompra()));
			detallecompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallecompraAux.getEmpresa()));
			detallecompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallecompraAux.getSucursal()));
			detallecompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallecompraAux.getEjercicio()));
			detallecompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallecompraAux.getPeriodo()));
			detallecompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallecompraAux.getAnio()));
			detallecompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallecompraAux.getMes()));
			detallecompraAux.setestadodetalleinventario_descripcion(EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(detallecompraAux.getEstadoDetalleInventario()));
			detallecompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallecompraAux.getBodega()));
			detallecompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallecompraAux.getProducto()));
			detallecompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallecompraAux.getUnidad()));
			detallecompraAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallecompraAux.getNovedadProducto()));
			detallecompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallecompraAux.getCentroCosto()));
			detallecompraAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallecompraAux.getCuentaContableCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(EstadoDetalleInventario.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class));
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
					if(clas.clas.equals(EstadoDetalleInventario.class)) {
						classes.add(new Classe(EstadoDetalleInventario.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

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

					if(EstadoDetalleInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleInventario.class)); continue;
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

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

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

					if(EstadoDetalleInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleInventario.class)); continue;
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

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCompraConstantesFunciones.getClassesRelationshipsOfDetalleCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCompraConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleCompra detallecompra,List<DetalleCompra> detallecompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleCompra detallecompraEncontrado=null;
			
			for(DetalleCompra detallecompraLocal:detallecompras) {
				if(detallecompraLocal.getId().equals(detallecompra.getId())) {
					detallecompraEncontrado=detallecompraLocal;
					
					detallecompraLocal.setIsChanged(detallecompra.getIsChanged());
					detallecompraLocal.setIsNew(detallecompra.getIsNew());
					detallecompraLocal.setIsDeleted(detallecompra.getIsDeleted());
					
					detallecompraLocal.setGeneralEntityOriginal(detallecompra.getGeneralEntityOriginal());
					
					detallecompraLocal.setId(detallecompra.getId());	
					detallecompraLocal.setVersionRow(detallecompra.getVersionRow());	
					detallecompraLocal.setid_compra(detallecompra.getid_compra());	
					detallecompraLocal.setid_empresa(detallecompra.getid_empresa());	
					detallecompraLocal.setid_sucursal(detallecompra.getid_sucursal());	
					detallecompraLocal.setid_ejercicio(detallecompra.getid_ejercicio());	
					detallecompraLocal.setid_periodo(detallecompra.getid_periodo());	
					detallecompraLocal.setid_anio(detallecompra.getid_anio());	
					detallecompraLocal.setid_mes(detallecompra.getid_mes());	
					detallecompraLocal.setid_estado_detalle_inventario(detallecompra.getid_estado_detalle_inventario());	
					detallecompraLocal.setid_bodega(detallecompra.getid_bodega());	
					detallecompraLocal.setid_producto(detallecompra.getid_producto());	
					detallecompraLocal.setid_unidad(detallecompra.getid_unidad());	
					detallecompraLocal.setdescripcion(detallecompra.getdescripcion());	
					detallecompraLocal.setid_novedad_producto(detallecompra.getid_novedad_producto());	
					detallecompraLocal.setcantidad(detallecompra.getcantidad());	
					detallecompraLocal.setdescuento(detallecompra.getdescuento());	
					detallecompraLocal.setcosto_unitario(detallecompra.getcosto_unitario());	
					detallecompraLocal.setiva(detallecompra.getiva());	
					detallecompraLocal.setiva_valor(detallecompra.getiva_valor());	
					detallecompraLocal.setcosto_total(detallecompra.getcosto_total());	
					detallecompraLocal.setdisponible(detallecompra.getdisponible());	
					detallecompraLocal.setcosto_iva(detallecompra.getcosto_iva());	
					detallecompraLocal.setice(detallecompra.getice());	
					detallecompraLocal.setice_valor(detallecompra.getice_valor());	
					detallecompraLocal.setdescuento1(detallecompra.getdescuento1());	
					detallecompraLocal.setdescuento2(detallecompra.getdescuento2());	
					detallecompraLocal.setserie(detallecompra.getserie());	
					detallecompraLocal.setlote(detallecompra.getlote());	
					detallecompraLocal.setfecha_elaboracion_lote(detallecompra.getfecha_elaboracion_lote());	
					detallecompraLocal.setfecha_caducidad_lote(detallecompra.getfecha_caducidad_lote());	
					detallecompraLocal.setid_centro_costo(detallecompra.getid_centro_costo());	
					detallecompraLocal.setid_cuenta_contable_costo(detallecompra.getid_cuenta_contable_costo());	
					detallecompraLocal.setnumero_comprobante(detallecompra.getnumero_comprobante());	
					detallecompraLocal.setlote_cliente(detallecompra.getlote_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallecompra.getIsDeleted()) {
				if(!existe) {
					detallecompras.add(detallecompra);
				}
			} else {
				if(detallecompraEncontrado!=null && permiteQuitar)  {
					detallecompras.remove(detallecompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleCompra detallecompra,List<DetalleCompra> detallecompras) throws Exception {
		try	{			
			for(DetalleCompra detallecompraLocal:detallecompras) {
				if(detallecompraLocal.getId().equals(detallecompra.getId())) {
					detallecompraLocal.setIsSelected(detallecompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleCompra(List<DetalleCompra> detallecomprasAux) throws Exception {
		//this.detallecomprasAux=detallecomprasAux;
		
		for(DetalleCompra detallecompraAux:detallecomprasAux) {
			if(detallecompraAux.getIsChanged()) {
				detallecompraAux.setIsChanged(false);
			}		
			
			if(detallecompraAux.getIsNew()) {
				detallecompraAux.setIsNew(false);
			}	
			
			if(detallecompraAux.getIsDeleted()) {
				detallecompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleCompra(DetalleCompra detallecompraAux) throws Exception {
		//this.detallecompraAux=detallecompraAux;
		
			if(detallecompraAux.getIsChanged()) {
				detallecompraAux.setIsChanged(false);
			}		
			
			if(detallecompraAux.getIsNew()) {
				detallecompraAux.setIsNew(false);
			}	
			
			if(detallecompraAux.getIsDeleted()) {
				detallecompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleCompra detallecompraAsignar,DetalleCompra detallecompra) throws Exception {
		detallecompraAsignar.setId(detallecompra.getId());	
		detallecompraAsignar.setVersionRow(detallecompra.getVersionRow());	
		detallecompraAsignar.setid_compra(detallecompra.getid_compra());
		detallecompraAsignar.setcompra_descripcion(detallecompra.getcompra_descripcion());	
		detallecompraAsignar.setid_empresa(detallecompra.getid_empresa());
		detallecompraAsignar.setempresa_descripcion(detallecompra.getempresa_descripcion());	
		detallecompraAsignar.setid_sucursal(detallecompra.getid_sucursal());
		detallecompraAsignar.setsucursal_descripcion(detallecompra.getsucursal_descripcion());	
		detallecompraAsignar.setid_ejercicio(detallecompra.getid_ejercicio());
		detallecompraAsignar.setejercicio_descripcion(detallecompra.getejercicio_descripcion());	
		detallecompraAsignar.setid_periodo(detallecompra.getid_periodo());
		detallecompraAsignar.setperiodo_descripcion(detallecompra.getperiodo_descripcion());	
		detallecompraAsignar.setid_anio(detallecompra.getid_anio());
		detallecompraAsignar.setanio_descripcion(detallecompra.getanio_descripcion());	
		detallecompraAsignar.setid_mes(detallecompra.getid_mes());
		detallecompraAsignar.setmes_descripcion(detallecompra.getmes_descripcion());	
		detallecompraAsignar.setid_estado_detalle_inventario(detallecompra.getid_estado_detalle_inventario());
		detallecompraAsignar.setestadodetalleinventario_descripcion(detallecompra.getestadodetalleinventario_descripcion());	
		detallecompraAsignar.setid_bodega(detallecompra.getid_bodega());
		detallecompraAsignar.setbodega_descripcion(detallecompra.getbodega_descripcion());	
		detallecompraAsignar.setid_producto(detallecompra.getid_producto());
		detallecompraAsignar.setproducto_descripcion(detallecompra.getproducto_descripcion());	
		detallecompraAsignar.setid_unidad(detallecompra.getid_unidad());
		detallecompraAsignar.setunidad_descripcion(detallecompra.getunidad_descripcion());	
		detallecompraAsignar.setdescripcion(detallecompra.getdescripcion());	
		detallecompraAsignar.setid_novedad_producto(detallecompra.getid_novedad_producto());
		detallecompraAsignar.setnovedadproducto_descripcion(detallecompra.getnovedadproducto_descripcion());	
		detallecompraAsignar.setcantidad(detallecompra.getcantidad());	
		detallecompraAsignar.setdescuento(detallecompra.getdescuento());	
		detallecompraAsignar.setcosto_unitario(detallecompra.getcosto_unitario());	
		detallecompraAsignar.setiva(detallecompra.getiva());	
		detallecompraAsignar.setiva_valor(detallecompra.getiva_valor());	
		detallecompraAsignar.setcosto_total(detallecompra.getcosto_total());	
		detallecompraAsignar.setdisponible(detallecompra.getdisponible());	
		detallecompraAsignar.setcosto_iva(detallecompra.getcosto_iva());	
		detallecompraAsignar.setice(detallecompra.getice());	
		detallecompraAsignar.setice_valor(detallecompra.getice_valor());	
		detallecompraAsignar.setdescuento1(detallecompra.getdescuento1());	
		detallecompraAsignar.setdescuento2(detallecompra.getdescuento2());	
		detallecompraAsignar.setserie(detallecompra.getserie());	
		detallecompraAsignar.setlote(detallecompra.getlote());	
		detallecompraAsignar.setfecha_elaboracion_lote(detallecompra.getfecha_elaboracion_lote());	
		detallecompraAsignar.setfecha_caducidad_lote(detallecompra.getfecha_caducidad_lote());	
		detallecompraAsignar.setid_centro_costo(detallecompra.getid_centro_costo());
		detallecompraAsignar.setcentrocosto_descripcion(detallecompra.getcentrocosto_descripcion());	
		detallecompraAsignar.setid_cuenta_contable_costo(detallecompra.getid_cuenta_contable_costo());
		detallecompraAsignar.setcuentacontablecosto_descripcion(detallecompra.getcuentacontablecosto_descripcion());	
		detallecompraAsignar.setnumero_comprobante(detallecompra.getnumero_comprobante());	
		detallecompraAsignar.setlote_cliente(detallecompra.getlote_cliente());	
	}
	
	public static void inicializarDetalleCompra(DetalleCompra detallecompra) throws Exception {
		try {
				detallecompra.setId(0L);	
					
				detallecompra.setid_compra(-1L);	
				detallecompra.setid_empresa(-1L);	
				detallecompra.setid_sucursal(-1L);	
				detallecompra.setid_ejercicio(-1L);	
				detallecompra.setid_periodo(-1L);	
				detallecompra.setid_anio(null);	
				detallecompra.setid_mes(null);	
				detallecompra.setid_estado_detalle_inventario(1L);	
				detallecompra.setid_bodega(-1L);	
				detallecompra.setid_producto(-1L);	
				detallecompra.setid_unidad(-1L);	
				detallecompra.setdescripcion("");	
				detallecompra.setid_novedad_producto(null);	
				detallecompra.setcantidad(0);	
				detallecompra.setdescuento(0.0);	
				detallecompra.setcosto_unitario(0.0);	
				detallecompra.setiva(0.0);	
				detallecompra.setiva_valor(0.0);	
				detallecompra.setcosto_total(0.0);	
				detallecompra.setdisponible(0);	
				detallecompra.setcosto_iva(false);	
				detallecompra.setice(0.0);	
				detallecompra.setice_valor(0.0);	
				detallecompra.setdescuento1(0.0);	
				detallecompra.setdescuento2(0.0);	
				detallecompra.setserie("");	
				detallecompra.setlote("");	
				detallecompra.setfecha_elaboracion_lote(new Date());	
				detallecompra.setfecha_caducidad_lote(new Date());	
				detallecompra.setid_centro_costo(null);	
				detallecompra.setid_cuenta_contable_costo(null);	
				detallecompra.setnumero_comprobante("");	
				detallecompra.setlote_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_COSTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_DESCUENTO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCompraConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleCompra(String sTipo,Row row,Workbook workbook,DetalleCompra detallecompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getestadodetalleinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallecompra.getcosto_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getdescuento1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getfecha_elaboracion_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getfecha_caducidad_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecompra.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleCompra() {
		return this.sFinalQueryDetalleCompra;
	}
	
	public void setsFinalQueryDetalleCompra(String sFinalQueryDetalleCompra) {
		this.sFinalQueryDetalleCompra= sFinalQueryDetalleCompra;
	}
	
	public Border resaltarSeleccionarDetalleCompra=null;
	
	public Border setResaltarSeleccionarDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleCompra() {
		return this.resaltarSeleccionarDetalleCompra;
	}
	
	public void setResaltarSeleccionarDetalleCompra(Border borderResaltarSeleccionarDetalleCompra) {
		this.resaltarSeleccionarDetalleCompra= borderResaltarSeleccionarDetalleCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleCompra=null;
	public Boolean mostraridDetalleCompra=true;
	public Boolean activaridDetalleCompra=true;

	public Border resaltarid_compraDetalleCompra=null;
	public Boolean mostrarid_compraDetalleCompra=true;
	public Boolean activarid_compraDetalleCompra=true;
	public Boolean cargarid_compraDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_compraDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleCompra=null;
	public Boolean mostrarid_empresaDetalleCompra=true;
	public Boolean activarid_empresaDetalleCompra=true;
	public Boolean cargarid_empresaDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleCompra=null;
	public Boolean mostrarid_sucursalDetalleCompra=true;
	public Boolean activarid_sucursalDetalleCompra=true;
	public Boolean cargarid_sucursalDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleCompra=null;
	public Boolean mostrarid_ejercicioDetalleCompra=true;
	public Boolean activarid_ejercicioDetalleCompra=true;
	public Boolean cargarid_ejercicioDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleCompra=null;
	public Boolean mostrarid_periodoDetalleCompra=true;
	public Boolean activarid_periodoDetalleCompra=true;
	public Boolean cargarid_periodoDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleCompra=null;
	public Boolean mostrarid_anioDetalleCompra=true;
	public Boolean activarid_anioDetalleCompra=false;
	public Boolean cargarid_anioDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleCompra=null;
	public Boolean mostrarid_mesDetalleCompra=true;
	public Boolean activarid_mesDetalleCompra=false;
	public Boolean cargarid_mesDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_inventarioDetalleCompra=null;
	public Boolean mostrarid_estado_detalle_inventarioDetalleCompra=true;
	public Boolean activarid_estado_detalle_inventarioDetalleCompra=false;
	public Boolean cargarid_estado_detalle_inventarioDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_inventarioDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleCompra=null;
	public Boolean mostrarid_bodegaDetalleCompra=true;
	public Boolean activarid_bodegaDetalleCompra=true;
	public Boolean cargarid_bodegaDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleCompra=null;
	public Boolean mostrarid_productoDetalleCompra=true;
	public Boolean activarid_productoDetalleCompra=true;
	public Boolean cargarid_productoDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleCompra=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleCompra=null;
	public Boolean mostrarid_unidadDetalleCompra=true;
	public Boolean activarid_unidadDetalleCompra=true;
	public Boolean cargarid_unidadDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleCompra=true;//ConEventDepend=true

	public Border resaltardescripcionDetalleCompra=null;
	public Boolean mostrardescripcionDetalleCompra=true;
	public Boolean activardescripcionDetalleCompra=true;

	public Border resaltarid_novedad_productoDetalleCompra=null;
	public Boolean mostrarid_novedad_productoDetalleCompra=true;
	public Boolean activarid_novedad_productoDetalleCompra=true;
	public Boolean cargarid_novedad_productoDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoDetalleCompra=false;//ConEventDepend=true

	public Border resaltarcantidadDetalleCompra=null;
	public Boolean mostrarcantidadDetalleCompra=true;
	public Boolean activarcantidadDetalleCompra=true;

	public Border resaltardescuentoDetalleCompra=null;
	public Boolean mostrardescuentoDetalleCompra=true;
	public Boolean activardescuentoDetalleCompra=false;

	public Border resaltarcosto_unitarioDetalleCompra=null;
	public Boolean mostrarcosto_unitarioDetalleCompra=true;
	public Boolean activarcosto_unitarioDetalleCompra=true;

	public Border resaltarivaDetalleCompra=null;
	public Boolean mostrarivaDetalleCompra=true;
	public Boolean activarivaDetalleCompra=true;

	public Border resaltariva_valorDetalleCompra=null;
	public Boolean mostrariva_valorDetalleCompra=true;
	public Boolean activariva_valorDetalleCompra=true;

	public Border resaltarcosto_totalDetalleCompra=null;
	public Boolean mostrarcosto_totalDetalleCompra=true;
	public Boolean activarcosto_totalDetalleCompra=true;

	public Border resaltardisponibleDetalleCompra=null;
	public Boolean mostrardisponibleDetalleCompra=true;
	public Boolean activardisponibleDetalleCompra=true;

	public Border resaltarcosto_ivaDetalleCompra=null;
	public Boolean mostrarcosto_ivaDetalleCompra=true;
	public Boolean activarcosto_ivaDetalleCompra=false;

	public Border resaltariceDetalleCompra=null;
	public Boolean mostrariceDetalleCompra=true;
	public Boolean activariceDetalleCompra=false;

	public Border resaltarice_valorDetalleCompra=null;
	public Boolean mostrarice_valorDetalleCompra=true;
	public Boolean activarice_valorDetalleCompra=false;

	public Border resaltardescuento1DetalleCompra=null;
	public Boolean mostrardescuento1DetalleCompra=true;
	public Boolean activardescuento1DetalleCompra=false;

	public Border resaltardescuento2DetalleCompra=null;
	public Boolean mostrardescuento2DetalleCompra=true;
	public Boolean activardescuento2DetalleCompra=false;

	public Border resaltarserieDetalleCompra=null;
	public Boolean mostrarserieDetalleCompra=true;
	public Boolean activarserieDetalleCompra=true;

	public Border resaltarloteDetalleCompra=null;
	public Boolean mostrarloteDetalleCompra=true;
	public Boolean activarloteDetalleCompra=true;

	public Border resaltarfecha_elaboracion_loteDetalleCompra=null;
	public Boolean mostrarfecha_elaboracion_loteDetalleCompra=true;
	public Boolean activarfecha_elaboracion_loteDetalleCompra=true;

	public Border resaltarfecha_caducidad_loteDetalleCompra=null;
	public Boolean mostrarfecha_caducidad_loteDetalleCompra=true;
	public Boolean activarfecha_caducidad_loteDetalleCompra=true;

	public Border resaltarid_centro_costoDetalleCompra=null;
	public Boolean mostrarid_centro_costoDetalleCompra=true;
	public Boolean activarid_centro_costoDetalleCompra=false;
	public Boolean cargarid_centro_costoDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleCompra=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoDetalleCompra=null;
	public Boolean mostrarid_cuenta_contable_costoDetalleCompra=true;
	public Boolean activarid_cuenta_contable_costoDetalleCompra=false;
	public Boolean cargarid_cuenta_contable_costoDetalleCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoDetalleCompra=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteDetalleCompra=null;
	public Boolean mostrarnumero_comprobanteDetalleCompra=true;
	public Boolean activarnumero_comprobanteDetalleCompra=false;

	public Border resaltarlote_clienteDetalleCompra=null;
	public Boolean mostrarlote_clienteDetalleCompra=true;
	public Boolean activarlote_clienteDetalleCompra=false;

	
	

	public Border setResaltaridDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleCompra() {
		return this.resaltaridDetalleCompra;
	}

	public void setResaltaridDetalleCompra(Border borderResaltar) {
		this.resaltaridDetalleCompra= borderResaltar;
	}

	public Boolean getMostraridDetalleCompra() {
		return this.mostraridDetalleCompra;
	}

	public void setMostraridDetalleCompra(Boolean mostraridDetalleCompra) {
		this.mostraridDetalleCompra= mostraridDetalleCompra;
	}

	public Boolean getActivaridDetalleCompra() {
		return this.activaridDetalleCompra;
	}

	public void setActivaridDetalleCompra(Boolean activaridDetalleCompra) {
		this.activaridDetalleCompra= activaridDetalleCompra;
	}

	public Border setResaltarid_compraDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_compraDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_compraDetalleCompra() {
		return this.resaltarid_compraDetalleCompra;
	}

	public void setResaltarid_compraDetalleCompra(Border borderResaltar) {
		this.resaltarid_compraDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_compraDetalleCompra() {
		return this.mostrarid_compraDetalleCompra;
	}

	public void setMostrarid_compraDetalleCompra(Boolean mostrarid_compraDetalleCompra) {
		this.mostrarid_compraDetalleCompra= mostrarid_compraDetalleCompra;
	}

	public Boolean getActivarid_compraDetalleCompra() {
		return this.activarid_compraDetalleCompra;
	}

	public void setActivarid_compraDetalleCompra(Boolean activarid_compraDetalleCompra) {
		this.activarid_compraDetalleCompra= activarid_compraDetalleCompra;
	}

	public Boolean getCargarid_compraDetalleCompra() {
		return this.cargarid_compraDetalleCompra;
	}

	public void setCargarid_compraDetalleCompra(Boolean cargarid_compraDetalleCompra) {
		this.cargarid_compraDetalleCompra= cargarid_compraDetalleCompra;
	}

	public Border setResaltarid_empresaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleCompra() {
		return this.resaltarid_empresaDetalleCompra;
	}

	public void setResaltarid_empresaDetalleCompra(Border borderResaltar) {
		this.resaltarid_empresaDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleCompra() {
		return this.mostrarid_empresaDetalleCompra;
	}

	public void setMostrarid_empresaDetalleCompra(Boolean mostrarid_empresaDetalleCompra) {
		this.mostrarid_empresaDetalleCompra= mostrarid_empresaDetalleCompra;
	}

	public Boolean getActivarid_empresaDetalleCompra() {
		return this.activarid_empresaDetalleCompra;
	}

	public void setActivarid_empresaDetalleCompra(Boolean activarid_empresaDetalleCompra) {
		this.activarid_empresaDetalleCompra= activarid_empresaDetalleCompra;
	}

	public Boolean getCargarid_empresaDetalleCompra() {
		return this.cargarid_empresaDetalleCompra;
	}

	public void setCargarid_empresaDetalleCompra(Boolean cargarid_empresaDetalleCompra) {
		this.cargarid_empresaDetalleCompra= cargarid_empresaDetalleCompra;
	}

	public Border setResaltarid_sucursalDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleCompra() {
		return this.resaltarid_sucursalDetalleCompra;
	}

	public void setResaltarid_sucursalDetalleCompra(Border borderResaltar) {
		this.resaltarid_sucursalDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleCompra() {
		return this.mostrarid_sucursalDetalleCompra;
	}

	public void setMostrarid_sucursalDetalleCompra(Boolean mostrarid_sucursalDetalleCompra) {
		this.mostrarid_sucursalDetalleCompra= mostrarid_sucursalDetalleCompra;
	}

	public Boolean getActivarid_sucursalDetalleCompra() {
		return this.activarid_sucursalDetalleCompra;
	}

	public void setActivarid_sucursalDetalleCompra(Boolean activarid_sucursalDetalleCompra) {
		this.activarid_sucursalDetalleCompra= activarid_sucursalDetalleCompra;
	}

	public Boolean getCargarid_sucursalDetalleCompra() {
		return this.cargarid_sucursalDetalleCompra;
	}

	public void setCargarid_sucursalDetalleCompra(Boolean cargarid_sucursalDetalleCompra) {
		this.cargarid_sucursalDetalleCompra= cargarid_sucursalDetalleCompra;
	}

	public Border setResaltarid_ejercicioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleCompra() {
		return this.resaltarid_ejercicioDetalleCompra;
	}

	public void setResaltarid_ejercicioDetalleCompra(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleCompra() {
		return this.mostrarid_ejercicioDetalleCompra;
	}

	public void setMostrarid_ejercicioDetalleCompra(Boolean mostrarid_ejercicioDetalleCompra) {
		this.mostrarid_ejercicioDetalleCompra= mostrarid_ejercicioDetalleCompra;
	}

	public Boolean getActivarid_ejercicioDetalleCompra() {
		return this.activarid_ejercicioDetalleCompra;
	}

	public void setActivarid_ejercicioDetalleCompra(Boolean activarid_ejercicioDetalleCompra) {
		this.activarid_ejercicioDetalleCompra= activarid_ejercicioDetalleCompra;
	}

	public Boolean getCargarid_ejercicioDetalleCompra() {
		return this.cargarid_ejercicioDetalleCompra;
	}

	public void setCargarid_ejercicioDetalleCompra(Boolean cargarid_ejercicioDetalleCompra) {
		this.cargarid_ejercicioDetalleCompra= cargarid_ejercicioDetalleCompra;
	}

	public Border setResaltarid_periodoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleCompra() {
		return this.resaltarid_periodoDetalleCompra;
	}

	public void setResaltarid_periodoDetalleCompra(Border borderResaltar) {
		this.resaltarid_periodoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleCompra() {
		return this.mostrarid_periodoDetalleCompra;
	}

	public void setMostrarid_periodoDetalleCompra(Boolean mostrarid_periodoDetalleCompra) {
		this.mostrarid_periodoDetalleCompra= mostrarid_periodoDetalleCompra;
	}

	public Boolean getActivarid_periodoDetalleCompra() {
		return this.activarid_periodoDetalleCompra;
	}

	public void setActivarid_periodoDetalleCompra(Boolean activarid_periodoDetalleCompra) {
		this.activarid_periodoDetalleCompra= activarid_periodoDetalleCompra;
	}

	public Boolean getCargarid_periodoDetalleCompra() {
		return this.cargarid_periodoDetalleCompra;
	}

	public void setCargarid_periodoDetalleCompra(Boolean cargarid_periodoDetalleCompra) {
		this.cargarid_periodoDetalleCompra= cargarid_periodoDetalleCompra;
	}

	public Border setResaltarid_anioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleCompra() {
		return this.resaltarid_anioDetalleCompra;
	}

	public void setResaltarid_anioDetalleCompra(Border borderResaltar) {
		this.resaltarid_anioDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleCompra() {
		return this.mostrarid_anioDetalleCompra;
	}

	public void setMostrarid_anioDetalleCompra(Boolean mostrarid_anioDetalleCompra) {
		this.mostrarid_anioDetalleCompra= mostrarid_anioDetalleCompra;
	}

	public Boolean getActivarid_anioDetalleCompra() {
		return this.activarid_anioDetalleCompra;
	}

	public void setActivarid_anioDetalleCompra(Boolean activarid_anioDetalleCompra) {
		this.activarid_anioDetalleCompra= activarid_anioDetalleCompra;
	}

	public Boolean getCargarid_anioDetalleCompra() {
		return this.cargarid_anioDetalleCompra;
	}

	public void setCargarid_anioDetalleCompra(Boolean cargarid_anioDetalleCompra) {
		this.cargarid_anioDetalleCompra= cargarid_anioDetalleCompra;
	}

	public Border setResaltarid_mesDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleCompra() {
		return this.resaltarid_mesDetalleCompra;
	}

	public void setResaltarid_mesDetalleCompra(Border borderResaltar) {
		this.resaltarid_mesDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleCompra() {
		return this.mostrarid_mesDetalleCompra;
	}

	public void setMostrarid_mesDetalleCompra(Boolean mostrarid_mesDetalleCompra) {
		this.mostrarid_mesDetalleCompra= mostrarid_mesDetalleCompra;
	}

	public Boolean getActivarid_mesDetalleCompra() {
		return this.activarid_mesDetalleCompra;
	}

	public void setActivarid_mesDetalleCompra(Boolean activarid_mesDetalleCompra) {
		this.activarid_mesDetalleCompra= activarid_mesDetalleCompra;
	}

	public Boolean getCargarid_mesDetalleCompra() {
		return this.cargarid_mesDetalleCompra;
	}

	public void setCargarid_mesDetalleCompra(Boolean cargarid_mesDetalleCompra) {
		this.cargarid_mesDetalleCompra= cargarid_mesDetalleCompra;
	}

	public Border setResaltarid_estado_detalle_inventarioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_detalle_inventarioDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_inventarioDetalleCompra() {
		return this.resaltarid_estado_detalle_inventarioDetalleCompra;
	}

	public void setResaltarid_estado_detalle_inventarioDetalleCompra(Border borderResaltar) {
		this.resaltarid_estado_detalle_inventarioDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_inventarioDetalleCompra() {
		return this.mostrarid_estado_detalle_inventarioDetalleCompra;
	}

	public void setMostrarid_estado_detalle_inventarioDetalleCompra(Boolean mostrarid_estado_detalle_inventarioDetalleCompra) {
		this.mostrarid_estado_detalle_inventarioDetalleCompra= mostrarid_estado_detalle_inventarioDetalleCompra;
	}

	public Boolean getActivarid_estado_detalle_inventarioDetalleCompra() {
		return this.activarid_estado_detalle_inventarioDetalleCompra;
	}

	public void setActivarid_estado_detalle_inventarioDetalleCompra(Boolean activarid_estado_detalle_inventarioDetalleCompra) {
		this.activarid_estado_detalle_inventarioDetalleCompra= activarid_estado_detalle_inventarioDetalleCompra;
	}

	public Boolean getCargarid_estado_detalle_inventarioDetalleCompra() {
		return this.cargarid_estado_detalle_inventarioDetalleCompra;
	}

	public void setCargarid_estado_detalle_inventarioDetalleCompra(Boolean cargarid_estado_detalle_inventarioDetalleCompra) {
		this.cargarid_estado_detalle_inventarioDetalleCompra= cargarid_estado_detalle_inventarioDetalleCompra;
	}

	public Border setResaltarid_bodegaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_bodegaDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleCompra() {
		return this.resaltarid_bodegaDetalleCompra;
	}

	public void setResaltarid_bodegaDetalleCompra(Border borderResaltar) {
		this.resaltarid_bodegaDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleCompra() {
		return this.mostrarid_bodegaDetalleCompra;
	}

	public void setMostrarid_bodegaDetalleCompra(Boolean mostrarid_bodegaDetalleCompra) {
		this.mostrarid_bodegaDetalleCompra= mostrarid_bodegaDetalleCompra;
	}

	public Boolean getActivarid_bodegaDetalleCompra() {
		return this.activarid_bodegaDetalleCompra;
	}

	public void setActivarid_bodegaDetalleCompra(Boolean activarid_bodegaDetalleCompra) {
		this.activarid_bodegaDetalleCompra= activarid_bodegaDetalleCompra;
	}

	public Boolean getCargarid_bodegaDetalleCompra() {
		return this.cargarid_bodegaDetalleCompra;
	}

	public void setCargarid_bodegaDetalleCompra(Boolean cargarid_bodegaDetalleCompra) {
		this.cargarid_bodegaDetalleCompra= cargarid_bodegaDetalleCompra;
	}

	public Border setResaltarid_productoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_productoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleCompra() {
		return this.resaltarid_productoDetalleCompra;
	}

	public void setResaltarid_productoDetalleCompra(Border borderResaltar) {
		this.resaltarid_productoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleCompra() {
		return this.mostrarid_productoDetalleCompra;
	}

	public void setMostrarid_productoDetalleCompra(Boolean mostrarid_productoDetalleCompra) {
		this.mostrarid_productoDetalleCompra= mostrarid_productoDetalleCompra;
	}

	public Boolean getActivarid_productoDetalleCompra() {
		return this.activarid_productoDetalleCompra;
	}

	public void setActivarid_productoDetalleCompra(Boolean activarid_productoDetalleCompra) {
		this.activarid_productoDetalleCompra= activarid_productoDetalleCompra;
	}

	public Boolean getCargarid_productoDetalleCompra() {
		return this.cargarid_productoDetalleCompra;
	}

	public void setCargarid_productoDetalleCompra(Boolean cargarid_productoDetalleCompra) {
		this.cargarid_productoDetalleCompra= cargarid_productoDetalleCompra;
	}

	public Border setResaltarid_unidadDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_unidadDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleCompra() {
		return this.resaltarid_unidadDetalleCompra;
	}

	public void setResaltarid_unidadDetalleCompra(Border borderResaltar) {
		this.resaltarid_unidadDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleCompra() {
		return this.mostrarid_unidadDetalleCompra;
	}

	public void setMostrarid_unidadDetalleCompra(Boolean mostrarid_unidadDetalleCompra) {
		this.mostrarid_unidadDetalleCompra= mostrarid_unidadDetalleCompra;
	}

	public Boolean getActivarid_unidadDetalleCompra() {
		return this.activarid_unidadDetalleCompra;
	}

	public void setActivarid_unidadDetalleCompra(Boolean activarid_unidadDetalleCompra) {
		this.activarid_unidadDetalleCompra= activarid_unidadDetalleCompra;
	}

	public Boolean getCargarid_unidadDetalleCompra() {
		return this.cargarid_unidadDetalleCompra;
	}

	public void setCargarid_unidadDetalleCompra(Boolean cargarid_unidadDetalleCompra) {
		this.cargarid_unidadDetalleCompra= cargarid_unidadDetalleCompra;
	}

	public Border setResaltardescripcionDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltardescripcionDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleCompra() {
		return this.resaltardescripcionDetalleCompra;
	}

	public void setResaltardescripcionDetalleCompra(Border borderResaltar) {
		this.resaltardescripcionDetalleCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleCompra() {
		return this.mostrardescripcionDetalleCompra;
	}

	public void setMostrardescripcionDetalleCompra(Boolean mostrardescripcionDetalleCompra) {
		this.mostrardescripcionDetalleCompra= mostrardescripcionDetalleCompra;
	}

	public Boolean getActivardescripcionDetalleCompra() {
		return this.activardescripcionDetalleCompra;
	}

	public void setActivardescripcionDetalleCompra(Boolean activardescripcionDetalleCompra) {
		this.activardescripcionDetalleCompra= activardescripcionDetalleCompra;
	}

	public Border setResaltarid_novedad_productoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_novedad_productoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoDetalleCompra() {
		return this.resaltarid_novedad_productoDetalleCompra;
	}

	public void setResaltarid_novedad_productoDetalleCompra(Border borderResaltar) {
		this.resaltarid_novedad_productoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoDetalleCompra() {
		return this.mostrarid_novedad_productoDetalleCompra;
	}

	public void setMostrarid_novedad_productoDetalleCompra(Boolean mostrarid_novedad_productoDetalleCompra) {
		this.mostrarid_novedad_productoDetalleCompra= mostrarid_novedad_productoDetalleCompra;
	}

	public Boolean getActivarid_novedad_productoDetalleCompra() {
		return this.activarid_novedad_productoDetalleCompra;
	}

	public void setActivarid_novedad_productoDetalleCompra(Boolean activarid_novedad_productoDetalleCompra) {
		this.activarid_novedad_productoDetalleCompra= activarid_novedad_productoDetalleCompra;
	}

	public Boolean getCargarid_novedad_productoDetalleCompra() {
		return this.cargarid_novedad_productoDetalleCompra;
	}

	public void setCargarid_novedad_productoDetalleCompra(Boolean cargarid_novedad_productoDetalleCompra) {
		this.cargarid_novedad_productoDetalleCompra= cargarid_novedad_productoDetalleCompra;
	}

	public Border setResaltarcantidadDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarcantidadDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleCompra() {
		return this.resaltarcantidadDetalleCompra;
	}

	public void setResaltarcantidadDetalleCompra(Border borderResaltar) {
		this.resaltarcantidadDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleCompra() {
		return this.mostrarcantidadDetalleCompra;
	}

	public void setMostrarcantidadDetalleCompra(Boolean mostrarcantidadDetalleCompra) {
		this.mostrarcantidadDetalleCompra= mostrarcantidadDetalleCompra;
	}

	public Boolean getActivarcantidadDetalleCompra() {
		return this.activarcantidadDetalleCompra;
	}

	public void setActivarcantidadDetalleCompra(Boolean activarcantidadDetalleCompra) {
		this.activarcantidadDetalleCompra= activarcantidadDetalleCompra;
	}

	public Border setResaltardescuentoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltardescuentoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleCompra() {
		return this.resaltardescuentoDetalleCompra;
	}

	public void setResaltardescuentoDetalleCompra(Border borderResaltar) {
		this.resaltardescuentoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleCompra() {
		return this.mostrardescuentoDetalleCompra;
	}

	public void setMostrardescuentoDetalleCompra(Boolean mostrardescuentoDetalleCompra) {
		this.mostrardescuentoDetalleCompra= mostrardescuentoDetalleCompra;
	}

	public Boolean getActivardescuentoDetalleCompra() {
		return this.activardescuentoDetalleCompra;
	}

	public void setActivardescuentoDetalleCompra(Boolean activardescuentoDetalleCompra) {
		this.activardescuentoDetalleCompra= activardescuentoDetalleCompra;
	}

	public Border setResaltarcosto_unitarioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarcosto_unitarioDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleCompra() {
		return this.resaltarcosto_unitarioDetalleCompra;
	}

	public void setResaltarcosto_unitarioDetalleCompra(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleCompra() {
		return this.mostrarcosto_unitarioDetalleCompra;
	}

	public void setMostrarcosto_unitarioDetalleCompra(Boolean mostrarcosto_unitarioDetalleCompra) {
		this.mostrarcosto_unitarioDetalleCompra= mostrarcosto_unitarioDetalleCompra;
	}

	public Boolean getActivarcosto_unitarioDetalleCompra() {
		return this.activarcosto_unitarioDetalleCompra;
	}

	public void setActivarcosto_unitarioDetalleCompra(Boolean activarcosto_unitarioDetalleCompra) {
		this.activarcosto_unitarioDetalleCompra= activarcosto_unitarioDetalleCompra;
	}

	public Border setResaltarivaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarivaDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleCompra() {
		return this.resaltarivaDetalleCompra;
	}

	public void setResaltarivaDetalleCompra(Border borderResaltar) {
		this.resaltarivaDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarivaDetalleCompra() {
		return this.mostrarivaDetalleCompra;
	}

	public void setMostrarivaDetalleCompra(Boolean mostrarivaDetalleCompra) {
		this.mostrarivaDetalleCompra= mostrarivaDetalleCompra;
	}

	public Boolean getActivarivaDetalleCompra() {
		return this.activarivaDetalleCompra;
	}

	public void setActivarivaDetalleCompra(Boolean activarivaDetalleCompra) {
		this.activarivaDetalleCompra= activarivaDetalleCompra;
	}

	public Border setResaltariva_valorDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltariva_valorDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleCompra() {
		return this.resaltariva_valorDetalleCompra;
	}

	public void setResaltariva_valorDetalleCompra(Border borderResaltar) {
		this.resaltariva_valorDetalleCompra= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleCompra() {
		return this.mostrariva_valorDetalleCompra;
	}

	public void setMostrariva_valorDetalleCompra(Boolean mostrariva_valorDetalleCompra) {
		this.mostrariva_valorDetalleCompra= mostrariva_valorDetalleCompra;
	}

	public Boolean getActivariva_valorDetalleCompra() {
		return this.activariva_valorDetalleCompra;
	}

	public void setActivariva_valorDetalleCompra(Boolean activariva_valorDetalleCompra) {
		this.activariva_valorDetalleCompra= activariva_valorDetalleCompra;
	}

	public Border setResaltarcosto_totalDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarcosto_totalDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleCompra() {
		return this.resaltarcosto_totalDetalleCompra;
	}

	public void setResaltarcosto_totalDetalleCompra(Border borderResaltar) {
		this.resaltarcosto_totalDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleCompra() {
		return this.mostrarcosto_totalDetalleCompra;
	}

	public void setMostrarcosto_totalDetalleCompra(Boolean mostrarcosto_totalDetalleCompra) {
		this.mostrarcosto_totalDetalleCompra= mostrarcosto_totalDetalleCompra;
	}

	public Boolean getActivarcosto_totalDetalleCompra() {
		return this.activarcosto_totalDetalleCompra;
	}

	public void setActivarcosto_totalDetalleCompra(Boolean activarcosto_totalDetalleCompra) {
		this.activarcosto_totalDetalleCompra= activarcosto_totalDetalleCompra;
	}

	public Border setResaltardisponibleDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltardisponibleDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleDetalleCompra() {
		return this.resaltardisponibleDetalleCompra;
	}

	public void setResaltardisponibleDetalleCompra(Border borderResaltar) {
		this.resaltardisponibleDetalleCompra= borderResaltar;
	}

	public Boolean getMostrardisponibleDetalleCompra() {
		return this.mostrardisponibleDetalleCompra;
	}

	public void setMostrardisponibleDetalleCompra(Boolean mostrardisponibleDetalleCompra) {
		this.mostrardisponibleDetalleCompra= mostrardisponibleDetalleCompra;
	}

	public Boolean getActivardisponibleDetalleCompra() {
		return this.activardisponibleDetalleCompra;
	}

	public void setActivardisponibleDetalleCompra(Boolean activardisponibleDetalleCompra) {
		this.activardisponibleDetalleCompra= activardisponibleDetalleCompra;
	}

	public Border setResaltarcosto_ivaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarcosto_ivaDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ivaDetalleCompra() {
		return this.resaltarcosto_ivaDetalleCompra;
	}

	public void setResaltarcosto_ivaDetalleCompra(Border borderResaltar) {
		this.resaltarcosto_ivaDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_ivaDetalleCompra() {
		return this.mostrarcosto_ivaDetalleCompra;
	}

	public void setMostrarcosto_ivaDetalleCompra(Boolean mostrarcosto_ivaDetalleCompra) {
		this.mostrarcosto_ivaDetalleCompra= mostrarcosto_ivaDetalleCompra;
	}

	public Boolean getActivarcosto_ivaDetalleCompra() {
		return this.activarcosto_ivaDetalleCompra;
	}

	public void setActivarcosto_ivaDetalleCompra(Boolean activarcosto_ivaDetalleCompra) {
		this.activarcosto_ivaDetalleCompra= activarcosto_ivaDetalleCompra;
	}

	public Border setResaltariceDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltariceDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleCompra() {
		return this.resaltariceDetalleCompra;
	}

	public void setResaltariceDetalleCompra(Border borderResaltar) {
		this.resaltariceDetalleCompra= borderResaltar;
	}

	public Boolean getMostrariceDetalleCompra() {
		return this.mostrariceDetalleCompra;
	}

	public void setMostrariceDetalleCompra(Boolean mostrariceDetalleCompra) {
		this.mostrariceDetalleCompra= mostrariceDetalleCompra;
	}

	public Boolean getActivariceDetalleCompra() {
		return this.activariceDetalleCompra;
	}

	public void setActivariceDetalleCompra(Boolean activariceDetalleCompra) {
		this.activariceDetalleCompra= activariceDetalleCompra;
	}

	public Border setResaltarice_valorDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarice_valorDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleCompra() {
		return this.resaltarice_valorDetalleCompra;
	}

	public void setResaltarice_valorDetalleCompra(Border borderResaltar) {
		this.resaltarice_valorDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleCompra() {
		return this.mostrarice_valorDetalleCompra;
	}

	public void setMostrarice_valorDetalleCompra(Boolean mostrarice_valorDetalleCompra) {
		this.mostrarice_valorDetalleCompra= mostrarice_valorDetalleCompra;
	}

	public Boolean getActivarice_valorDetalleCompra() {
		return this.activarice_valorDetalleCompra;
	}

	public void setActivarice_valorDetalleCompra(Boolean activarice_valorDetalleCompra) {
		this.activarice_valorDetalleCompra= activarice_valorDetalleCompra;
	}

	public Border setResaltardescuento1DetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltardescuento1DetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento1DetalleCompra() {
		return this.resaltardescuento1DetalleCompra;
	}

	public void setResaltardescuento1DetalleCompra(Border borderResaltar) {
		this.resaltardescuento1DetalleCompra= borderResaltar;
	}

	public Boolean getMostrardescuento1DetalleCompra() {
		return this.mostrardescuento1DetalleCompra;
	}

	public void setMostrardescuento1DetalleCompra(Boolean mostrardescuento1DetalleCompra) {
		this.mostrardescuento1DetalleCompra= mostrardescuento1DetalleCompra;
	}

	public Boolean getActivardescuento1DetalleCompra() {
		return this.activardescuento1DetalleCompra;
	}

	public void setActivardescuento1DetalleCompra(Boolean activardescuento1DetalleCompra) {
		this.activardescuento1DetalleCompra= activardescuento1DetalleCompra;
	}

	public Border setResaltardescuento2DetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltardescuento2DetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetalleCompra() {
		return this.resaltardescuento2DetalleCompra;
	}

	public void setResaltardescuento2DetalleCompra(Border borderResaltar) {
		this.resaltardescuento2DetalleCompra= borderResaltar;
	}

	public Boolean getMostrardescuento2DetalleCompra() {
		return this.mostrardescuento2DetalleCompra;
	}

	public void setMostrardescuento2DetalleCompra(Boolean mostrardescuento2DetalleCompra) {
		this.mostrardescuento2DetalleCompra= mostrardescuento2DetalleCompra;
	}

	public Boolean getActivardescuento2DetalleCompra() {
		return this.activardescuento2DetalleCompra;
	}

	public void setActivardescuento2DetalleCompra(Boolean activardescuento2DetalleCompra) {
		this.activardescuento2DetalleCompra= activardescuento2DetalleCompra;
	}

	public Border setResaltarserieDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarserieDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleCompra() {
		return this.resaltarserieDetalleCompra;
	}

	public void setResaltarserieDetalleCompra(Border borderResaltar) {
		this.resaltarserieDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarserieDetalleCompra() {
		return this.mostrarserieDetalleCompra;
	}

	public void setMostrarserieDetalleCompra(Boolean mostrarserieDetalleCompra) {
		this.mostrarserieDetalleCompra= mostrarserieDetalleCompra;
	}

	public Boolean getActivarserieDetalleCompra() {
		return this.activarserieDetalleCompra;
	}

	public void setActivarserieDetalleCompra(Boolean activarserieDetalleCompra) {
		this.activarserieDetalleCompra= activarserieDetalleCompra;
	}

	public Border setResaltarloteDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarloteDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleCompra() {
		return this.resaltarloteDetalleCompra;
	}

	public void setResaltarloteDetalleCompra(Border borderResaltar) {
		this.resaltarloteDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarloteDetalleCompra() {
		return this.mostrarloteDetalleCompra;
	}

	public void setMostrarloteDetalleCompra(Boolean mostrarloteDetalleCompra) {
		this.mostrarloteDetalleCompra= mostrarloteDetalleCompra;
	}

	public Boolean getActivarloteDetalleCompra() {
		return this.activarloteDetalleCompra;
	}

	public void setActivarloteDetalleCompra(Boolean activarloteDetalleCompra) {
		this.activarloteDetalleCompra= activarloteDetalleCompra;
	}

	public Border setResaltarfecha_elaboracion_loteDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarfecha_elaboracion_loteDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_elaboracion_loteDetalleCompra() {
		return this.resaltarfecha_elaboracion_loteDetalleCompra;
	}

	public void setResaltarfecha_elaboracion_loteDetalleCompra(Border borderResaltar) {
		this.resaltarfecha_elaboracion_loteDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_elaboracion_loteDetalleCompra() {
		return this.mostrarfecha_elaboracion_loteDetalleCompra;
	}

	public void setMostrarfecha_elaboracion_loteDetalleCompra(Boolean mostrarfecha_elaboracion_loteDetalleCompra) {
		this.mostrarfecha_elaboracion_loteDetalleCompra= mostrarfecha_elaboracion_loteDetalleCompra;
	}

	public Boolean getActivarfecha_elaboracion_loteDetalleCompra() {
		return this.activarfecha_elaboracion_loteDetalleCompra;
	}

	public void setActivarfecha_elaboracion_loteDetalleCompra(Boolean activarfecha_elaboracion_loteDetalleCompra) {
		this.activarfecha_elaboracion_loteDetalleCompra= activarfecha_elaboracion_loteDetalleCompra;
	}

	public Border setResaltarfecha_caducidad_loteDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarfecha_caducidad_loteDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidad_loteDetalleCompra() {
		return this.resaltarfecha_caducidad_loteDetalleCompra;
	}

	public void setResaltarfecha_caducidad_loteDetalleCompra(Border borderResaltar) {
		this.resaltarfecha_caducidad_loteDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidad_loteDetalleCompra() {
		return this.mostrarfecha_caducidad_loteDetalleCompra;
	}

	public void setMostrarfecha_caducidad_loteDetalleCompra(Boolean mostrarfecha_caducidad_loteDetalleCompra) {
		this.mostrarfecha_caducidad_loteDetalleCompra= mostrarfecha_caducidad_loteDetalleCompra;
	}

	public Boolean getActivarfecha_caducidad_loteDetalleCompra() {
		return this.activarfecha_caducidad_loteDetalleCompra;
	}

	public void setActivarfecha_caducidad_loteDetalleCompra(Boolean activarfecha_caducidad_loteDetalleCompra) {
		this.activarfecha_caducidad_loteDetalleCompra= activarfecha_caducidad_loteDetalleCompra;
	}

	public Border setResaltarid_centro_costoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_centro_costoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleCompra() {
		return this.resaltarid_centro_costoDetalleCompra;
	}

	public void setResaltarid_centro_costoDetalleCompra(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleCompra() {
		return this.mostrarid_centro_costoDetalleCompra;
	}

	public void setMostrarid_centro_costoDetalleCompra(Boolean mostrarid_centro_costoDetalleCompra) {
		this.mostrarid_centro_costoDetalleCompra= mostrarid_centro_costoDetalleCompra;
	}

	public Boolean getActivarid_centro_costoDetalleCompra() {
		return this.activarid_centro_costoDetalleCompra;
	}

	public void setActivarid_centro_costoDetalleCompra(Boolean activarid_centro_costoDetalleCompra) {
		this.activarid_centro_costoDetalleCompra= activarid_centro_costoDetalleCompra;
	}

	public Boolean getCargarid_centro_costoDetalleCompra() {
		return this.cargarid_centro_costoDetalleCompra;
	}

	public void setCargarid_centro_costoDetalleCompra(Boolean cargarid_centro_costoDetalleCompra) {
		this.cargarid_centro_costoDetalleCompra= cargarid_centro_costoDetalleCompra;
	}

	public Border setResaltarid_cuenta_contable_costoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contable_costoDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoDetalleCompra() {
		return this.resaltarid_cuenta_contable_costoDetalleCompra;
	}

	public void setResaltarid_cuenta_contable_costoDetalleCompra(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoDetalleCompra() {
		return this.mostrarid_cuenta_contable_costoDetalleCompra;
	}

	public void setMostrarid_cuenta_contable_costoDetalleCompra(Boolean mostrarid_cuenta_contable_costoDetalleCompra) {
		this.mostrarid_cuenta_contable_costoDetalleCompra= mostrarid_cuenta_contable_costoDetalleCompra;
	}

	public Boolean getActivarid_cuenta_contable_costoDetalleCompra() {
		return this.activarid_cuenta_contable_costoDetalleCompra;
	}

	public void setActivarid_cuenta_contable_costoDetalleCompra(Boolean activarid_cuenta_contable_costoDetalleCompra) {
		this.activarid_cuenta_contable_costoDetalleCompra= activarid_cuenta_contable_costoDetalleCompra;
	}

	public Boolean getCargarid_cuenta_contable_costoDetalleCompra() {
		return this.cargarid_cuenta_contable_costoDetalleCompra;
	}

	public void setCargarid_cuenta_contable_costoDetalleCompra(Boolean cargarid_cuenta_contable_costoDetalleCompra) {
		this.cargarid_cuenta_contable_costoDetalleCompra= cargarid_cuenta_contable_costoDetalleCompra;
	}

	public Border setResaltarnumero_comprobanteDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleCompra() {
		return this.resaltarnumero_comprobanteDetalleCompra;
	}

	public void setResaltarnumero_comprobanteDetalleCompra(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleCompra() {
		return this.mostrarnumero_comprobanteDetalleCompra;
	}

	public void setMostrarnumero_comprobanteDetalleCompra(Boolean mostrarnumero_comprobanteDetalleCompra) {
		this.mostrarnumero_comprobanteDetalleCompra= mostrarnumero_comprobanteDetalleCompra;
	}

	public Boolean getActivarnumero_comprobanteDetalleCompra() {
		return this.activarnumero_comprobanteDetalleCompra;
	}

	public void setActivarnumero_comprobanteDetalleCompra(Boolean activarnumero_comprobanteDetalleCompra) {
		this.activarnumero_comprobanteDetalleCompra= activarnumero_comprobanteDetalleCompra;
	}

	public Border setResaltarlote_clienteDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallecompraBeanSwingJInternalFrame.jTtoolBarDetalleCompra.setBorder(borderResaltar);
		*/
		this.resaltarlote_clienteDetalleCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleCompra() {
		return this.resaltarlote_clienteDetalleCompra;
	}

	public void setResaltarlote_clienteDetalleCompra(Border borderResaltar) {
		this.resaltarlote_clienteDetalleCompra= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleCompra() {
		return this.mostrarlote_clienteDetalleCompra;
	}

	public void setMostrarlote_clienteDetalleCompra(Boolean mostrarlote_clienteDetalleCompra) {
		this.mostrarlote_clienteDetalleCompra= mostrarlote_clienteDetalleCompra;
	}

	public Boolean getActivarlote_clienteDetalleCompra() {
		return this.activarlote_clienteDetalleCompra;
	}

	public void setActivarlote_clienteDetalleCompra(Boolean activarlote_clienteDetalleCompra) {
		this.activarlote_clienteDetalleCompra= activarlote_clienteDetalleCompra;
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
		
		
		this.setMostraridDetalleCompra(esInicial);
		this.setMostrarid_compraDetalleCompra(esInicial);
		this.setMostrarid_empresaDetalleCompra(esInicial);
		this.setMostrarid_sucursalDetalleCompra(esInicial);
		this.setMostrarid_ejercicioDetalleCompra(esInicial);
		this.setMostrarid_periodoDetalleCompra(esInicial);
		this.setMostrarid_anioDetalleCompra(esInicial);
		this.setMostrarid_mesDetalleCompra(esInicial);
		this.setMostrarid_estado_detalle_inventarioDetalleCompra(esInicial);
		this.setMostrarid_bodegaDetalleCompra(esInicial);
		this.setMostrarid_productoDetalleCompra(esInicial);
		this.setMostrarid_unidadDetalleCompra(esInicial);
		this.setMostrardescripcionDetalleCompra(esInicial);
		this.setMostrarid_novedad_productoDetalleCompra(esInicial);
		this.setMostrarcantidadDetalleCompra(esInicial);
		this.setMostrardescuentoDetalleCompra(esInicial);
		this.setMostrarcosto_unitarioDetalleCompra(esInicial);
		this.setMostrarivaDetalleCompra(esInicial);
		this.setMostrariva_valorDetalleCompra(esInicial);
		this.setMostrarcosto_totalDetalleCompra(esInicial);
		this.setMostrardisponibleDetalleCompra(esInicial);
		this.setMostrarcosto_ivaDetalleCompra(esInicial);
		this.setMostrariceDetalleCompra(esInicial);
		this.setMostrarice_valorDetalleCompra(esInicial);
		this.setMostrardescuento1DetalleCompra(esInicial);
		this.setMostrardescuento2DetalleCompra(esInicial);
		this.setMostrarserieDetalleCompra(esInicial);
		this.setMostrarloteDetalleCompra(esInicial);
		this.setMostrarfecha_elaboracion_loteDetalleCompra(esInicial);
		this.setMostrarfecha_caducidad_loteDetalleCompra(esInicial);
		this.setMostrarid_centro_costoDetalleCompra(esInicial);
		this.setMostrarid_cuenta_contable_costoDetalleCompra(esInicial);
		this.setMostrarnumero_comprobanteDetalleCompra(esInicial);
		this.setMostrarlote_clienteDetalleCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ID)) {
				this.setMostraridDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCOMPRA)) {
				this.setMostrarid_compraDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setMostrarid_estado_detalle_inventarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOIVA)) {
				this.setMostrarcosto_ivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICE)) {
				this.setMostrariceDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO1)) {
				this.setMostrardescuento1DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setMostrarfecha_elaboracion_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setMostrarfecha_caducidad_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleCompra(esAsigna);
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
		
		
		this.setActivaridDetalleCompra(esInicial);
		this.setActivarid_compraDetalleCompra(esInicial);
		this.setActivarid_empresaDetalleCompra(esInicial);
		this.setActivarid_sucursalDetalleCompra(esInicial);
		this.setActivarid_ejercicioDetalleCompra(esInicial);
		this.setActivarid_periodoDetalleCompra(esInicial);
		this.setActivarid_anioDetalleCompra(esInicial);
		this.setActivarid_mesDetalleCompra(esInicial);
		this.setActivarid_estado_detalle_inventarioDetalleCompra(esInicial);
		this.setActivarid_bodegaDetalleCompra(esInicial);
		this.setActivarid_productoDetalleCompra(esInicial);
		this.setActivarid_unidadDetalleCompra(esInicial);
		this.setActivardescripcionDetalleCompra(esInicial);
		this.setActivarid_novedad_productoDetalleCompra(esInicial);
		this.setActivarcantidadDetalleCompra(esInicial);
		this.setActivardescuentoDetalleCompra(esInicial);
		this.setActivarcosto_unitarioDetalleCompra(esInicial);
		this.setActivarivaDetalleCompra(esInicial);
		this.setActivariva_valorDetalleCompra(esInicial);
		this.setActivarcosto_totalDetalleCompra(esInicial);
		this.setActivardisponibleDetalleCompra(esInicial);
		this.setActivarcosto_ivaDetalleCompra(esInicial);
		this.setActivariceDetalleCompra(esInicial);
		this.setActivarice_valorDetalleCompra(esInicial);
		this.setActivardescuento1DetalleCompra(esInicial);
		this.setActivardescuento2DetalleCompra(esInicial);
		this.setActivarserieDetalleCompra(esInicial);
		this.setActivarloteDetalleCompra(esInicial);
		this.setActivarfecha_elaboracion_loteDetalleCompra(esInicial);
		this.setActivarfecha_caducidad_loteDetalleCompra(esInicial);
		this.setActivarid_centro_costoDetalleCompra(esInicial);
		this.setActivarid_cuenta_contable_costoDetalleCompra(esInicial);
		this.setActivarnumero_comprobanteDetalleCompra(esInicial);
		this.setActivarlote_clienteDetalleCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ID)) {
				this.setActivaridDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCOMPRA)) {
				this.setActivarid_compraDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setActivarid_estado_detalle_inventarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVA)) {
				this.setActivarivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOIVA)) {
				this.setActivarcosto_ivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICE)) {
				this.setActivariceDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO1)) {
				this.setActivardescuento1DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setActivarfecha_elaboracion_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setActivarfecha_caducidad_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleCompra(esInicial);
		this.setResaltarid_compraDetalleCompra(esInicial);
		this.setResaltarid_empresaDetalleCompra(esInicial);
		this.setResaltarid_sucursalDetalleCompra(esInicial);
		this.setResaltarid_ejercicioDetalleCompra(esInicial);
		this.setResaltarid_periodoDetalleCompra(esInicial);
		this.setResaltarid_anioDetalleCompra(esInicial);
		this.setResaltarid_mesDetalleCompra(esInicial);
		this.setResaltarid_estado_detalle_inventarioDetalleCompra(esInicial);
		this.setResaltarid_bodegaDetalleCompra(esInicial);
		this.setResaltarid_productoDetalleCompra(esInicial);
		this.setResaltarid_unidadDetalleCompra(esInicial);
		this.setResaltardescripcionDetalleCompra(esInicial);
		this.setResaltarid_novedad_productoDetalleCompra(esInicial);
		this.setResaltarcantidadDetalleCompra(esInicial);
		this.setResaltardescuentoDetalleCompra(esInicial);
		this.setResaltarcosto_unitarioDetalleCompra(esInicial);
		this.setResaltarivaDetalleCompra(esInicial);
		this.setResaltariva_valorDetalleCompra(esInicial);
		this.setResaltarcosto_totalDetalleCompra(esInicial);
		this.setResaltardisponibleDetalleCompra(esInicial);
		this.setResaltarcosto_ivaDetalleCompra(esInicial);
		this.setResaltariceDetalleCompra(esInicial);
		this.setResaltarice_valorDetalleCompra(esInicial);
		this.setResaltardescuento1DetalleCompra(esInicial);
		this.setResaltardescuento2DetalleCompra(esInicial);
		this.setResaltarserieDetalleCompra(esInicial);
		this.setResaltarloteDetalleCompra(esInicial);
		this.setResaltarfecha_elaboracion_loteDetalleCompra(esInicial);
		this.setResaltarfecha_caducidad_loteDetalleCompra(esInicial);
		this.setResaltarid_centro_costoDetalleCompra(esInicial);
		this.setResaltarid_cuenta_contable_costoDetalleCompra(esInicial);
		this.setResaltarnumero_comprobanteDetalleCompra(esInicial);
		this.setResaltarlote_clienteDetalleCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ID)) {
				this.setResaltaridDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCOMPRA)) {
				this.setResaltarid_compraDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setResaltarid_estado_detalle_inventarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.COSTOIVA)) {
				this.setResaltarcosto_ivaDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICE)) {
				this.setResaltariceDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO1)) {
				this.setResaltardescuento1DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setResaltarfecha_elaboracion_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setResaltarfecha_caducidad_loteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCompraConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleCompra=true;

	public Boolean getMostrarFK_IdBodegaDetalleCompra() {
		return this.mostrarFK_IdBodegaDetalleCompra;
	}

	public void setMostrarFK_IdBodegaDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleCompra=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleCompra() {
		return this.mostrarFK_IdCentroCostoDetalleCompra;
	}

	public void setMostrarFK_IdCentroCostoDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCompraDetalleCompra=true;

	public Boolean getMostrarFK_IdCompraDetalleCompra() {
		return this.mostrarFK_IdCompraDetalleCompra;
	}

	public void setMostrarFK_IdCompraDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCompraDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoDetalleCompra=true;

	public Boolean getMostrarFK_IdCuentaContableCostoDetalleCompra() {
		return this.mostrarFK_IdCuentaContableCostoDetalleCompra;
	}

	public void setMostrarFK_IdCuentaContableCostoDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleCompra=true;

	public Boolean getMostrarFK_IdEjercicioDetalleCompra() {
		return this.mostrarFK_IdEjercicioDetalleCompra;
	}

	public void setMostrarFK_IdEjercicioDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleCompra=true;

	public Boolean getMostrarFK_IdEmpresaDetalleCompra() {
		return this.mostrarFK_IdEmpresaDetalleCompra;
	}

	public void setMostrarFK_IdEmpresaDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleInventarioDetalleCompra=true;

	public Boolean getMostrarFK_IdEstadoDetalleInventarioDetalleCompra() {
		return this.mostrarFK_IdEstadoDetalleInventarioDetalleCompra;
	}

	public void setMostrarFK_IdEstadoDetalleInventarioDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleInventarioDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoDetalleCompra=true;

	public Boolean getMostrarFK_IdNovedadProductoDetalleCompra() {
		return this.mostrarFK_IdNovedadProductoDetalleCompra;
	}

	public void setMostrarFK_IdNovedadProductoDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleCompra=true;

	public Boolean getMostrarFK_IdPeriodoDetalleCompra() {
		return this.mostrarFK_IdPeriodoDetalleCompra;
	}

	public void setMostrarFK_IdPeriodoDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleCompra=true;

	public Boolean getMostrarFK_IdProductoDetalleCompra() {
		return this.mostrarFK_IdProductoDetalleCompra;
	}

	public void setMostrarFK_IdProductoDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleCompra=true;

	public Boolean getMostrarFK_IdSucursalDetalleCompra() {
		return this.mostrarFK_IdSucursalDetalleCompra;
	}

	public void setMostrarFK_IdSucursalDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleCompra=true;

	public Boolean getMostrarFK_IdUnidadDetalleCompra() {
		return this.mostrarFK_IdUnidadDetalleCompra;
	}

	public void setMostrarFK_IdUnidadDetalleCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleCompra=true;

	public Boolean getActivarFK_IdBodegaDetalleCompra() {
		return this.activarFK_IdBodegaDetalleCompra;
	}

	public void setActivarFK_IdBodegaDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleCompra=true;

	public Boolean getActivarFK_IdCentroCostoDetalleCompra() {
		return this.activarFK_IdCentroCostoDetalleCompra;
	}

	public void setActivarFK_IdCentroCostoDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCompraDetalleCompra=true;

	public Boolean getActivarFK_IdCompraDetalleCompra() {
		return this.activarFK_IdCompraDetalleCompra;
	}

	public void setActivarFK_IdCompraDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCompraDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoDetalleCompra=true;

	public Boolean getActivarFK_IdCuentaContableCostoDetalleCompra() {
		return this.activarFK_IdCuentaContableCostoDetalleCompra;
	}

	public void setActivarFK_IdCuentaContableCostoDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleCompra=true;

	public Boolean getActivarFK_IdEjercicioDetalleCompra() {
		return this.activarFK_IdEjercicioDetalleCompra;
	}

	public void setActivarFK_IdEjercicioDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleCompra=true;

	public Boolean getActivarFK_IdEmpresaDetalleCompra() {
		return this.activarFK_IdEmpresaDetalleCompra;
	}

	public void setActivarFK_IdEmpresaDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleInventarioDetalleCompra=true;

	public Boolean getActivarFK_IdEstadoDetalleInventarioDetalleCompra() {
		return this.activarFK_IdEstadoDetalleInventarioDetalleCompra;
	}

	public void setActivarFK_IdEstadoDetalleInventarioDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleInventarioDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoDetalleCompra=true;

	public Boolean getActivarFK_IdNovedadProductoDetalleCompra() {
		return this.activarFK_IdNovedadProductoDetalleCompra;
	}

	public void setActivarFK_IdNovedadProductoDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleCompra=true;

	public Boolean getActivarFK_IdPeriodoDetalleCompra() {
		return this.activarFK_IdPeriodoDetalleCompra;
	}

	public void setActivarFK_IdPeriodoDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleCompra=true;

	public Boolean getActivarFK_IdProductoDetalleCompra() {
		return this.activarFK_IdProductoDetalleCompra;
	}

	public void setActivarFK_IdProductoDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleCompra=true;

	public Boolean getActivarFK_IdSucursalDetalleCompra() {
		return this.activarFK_IdSucursalDetalleCompra;
	}

	public void setActivarFK_IdSucursalDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleCompra=true;

	public Boolean getActivarFK_IdUnidadDetalleCompra() {
		return this.activarFK_IdUnidadDetalleCompra;
	}

	public void setActivarFK_IdUnidadDetalleCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleCompra=null;

	public Border getResaltarFK_IdBodegaDetalleCompra() {
		return this.resaltarFK_IdBodegaDetalleCompra;
	}

	public void setResaltarFK_IdBodegaDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleCompra=null;

	public Border getResaltarFK_IdCentroCostoDetalleCompra() {
		return this.resaltarFK_IdCentroCostoDetalleCompra;
	}

	public void setResaltarFK_IdCentroCostoDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdCompraDetalleCompra=null;

	public Border getResaltarFK_IdCompraDetalleCompra() {
		return this.resaltarFK_IdCompraDetalleCompra;
	}

	public void setResaltarFK_IdCompraDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdCompraDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdCompraDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCompraDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoDetalleCompra=null;

	public Border getResaltarFK_IdCuentaContableCostoDetalleCompra() {
		return this.resaltarFK_IdCuentaContableCostoDetalleCompra;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleCompra=null;

	public Border getResaltarFK_IdEjercicioDetalleCompra() {
		return this.resaltarFK_IdEjercicioDetalleCompra;
	}

	public void setResaltarFK_IdEjercicioDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleCompra=null;

	public Border getResaltarFK_IdEmpresaDetalleCompra() {
		return this.resaltarFK_IdEmpresaDetalleCompra;
	}

	public void setResaltarFK_IdEmpresaDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleInventarioDetalleCompra=null;

	public Border getResaltarFK_IdEstadoDetalleInventarioDetalleCompra() {
		return this.resaltarFK_IdEstadoDetalleInventarioDetalleCompra;
	}

	public void setResaltarFK_IdEstadoDetalleInventarioDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleInventarioDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleInventarioDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleInventarioDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoDetalleCompra=null;

	public Border getResaltarFK_IdNovedadProductoDetalleCompra() {
		return this.resaltarFK_IdNovedadProductoDetalleCompra;
	}

	public void setResaltarFK_IdNovedadProductoDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleCompra=null;

	public Border getResaltarFK_IdPeriodoDetalleCompra() {
		return this.resaltarFK_IdPeriodoDetalleCompra;
	}

	public void setResaltarFK_IdPeriodoDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleCompra=null;

	public Border getResaltarFK_IdProductoDetalleCompra() {
		return this.resaltarFK_IdProductoDetalleCompra;
	}

	public void setResaltarFK_IdProductoDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleCompra=null;

	public Border getResaltarFK_IdSucursalDetalleCompra() {
		return this.resaltarFK_IdSucursalDetalleCompra;
	}

	public void setResaltarFK_IdSucursalDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleCompra= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleCompra=null;

	public Border getResaltarFK_IdUnidadDetalleCompra() {
		return this.resaltarFK_IdUnidadDetalleCompra;
	}

	public void setResaltarFK_IdUnidadDetalleCompra(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleCompra= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCompraBeanSwingJInternalFrame detallecompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}