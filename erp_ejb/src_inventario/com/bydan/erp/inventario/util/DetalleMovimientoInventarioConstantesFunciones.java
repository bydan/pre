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


import com.bydan.erp.inventario.util.DetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleMovimientoInventarioParameterGeneral;

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
final public class DetalleMovimientoInventarioConstantesFunciones extends DetalleMovimientoInventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleMovimientoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleMovimientoInventario"+DetalleMovimientoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleMovimientoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleMovimientoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleMovimientoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleMovimientoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Movimiento Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Movimiento Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Movimiento Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleMovimientoInventario";
	public static final String OBJECTNAME="detallemovimientoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_movimiento_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallemovimientoinventario from "+DetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" detallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_periodo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_anio,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_mes,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_estado_detalle_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_bodega,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_producto,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_unidad,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descripcion,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".cantidad,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_total,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".disponible,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".iva,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".iva_valor,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".costo_iva,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".ice,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".ice_valor,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento1,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".descuento2,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".serie,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_detalle_movimiento_inventario,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+DetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleMovimientoInventarioConstantesFuncionesAdditional detallemovimientoinventarioConstantesFuncionesAdditional=null;
	
	public DetalleMovimientoInventarioConstantesFuncionesAdditional getDetalleMovimientoInventarioConstantesFuncionesAdditional() {
		return this.detallemovimientoinventarioConstantesFuncionesAdditional;
	}
	
	public void setDetalleMovimientoInventarioConstantesFuncionesAdditional(DetalleMovimientoInventarioConstantesFuncionesAdditional detallemovimientoinventarioConstantesFuncionesAdditional) {
		try {
			this.detallemovimientoinventarioConstantesFuncionesAdditional=detallemovimientoinventarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMOVIMIENTOINVENTARIO= "id_movimiento_inventario";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDESTADODETALLEMOVIMIENTOINVENTARIO= "id_estado_detalle_movimiento_inventario";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCUENTO= "descuento";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DISPONIBLE= "disponible";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String COSTOIVA= "costo_iva";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String DESCUENTO1= "descuento1";
    public static final String DESCUENTO2= "descuento2";
    public static final String SERIE= "serie";
    public static final String LOTE= "lote";
    public static final String FECHAELABORACIONLOTE= "fecha_elaboracion_lote";
    public static final String FECHACADUCIDADLOTE= "fecha_caducidad_lote";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
    public static final String IDTIPODETALLEMOVIMIENTOINVENTARIO= "id_tipo_detalle_movimiento_inventario";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String LOTECLIENTE= "lote_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMOVIMIENTOINVENTARIO= "Movimiento";
		public static final String LABEL_IDMOVIMIENTOINVENTARIO_LOWER= "Movimiento Inventario";
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
    	public static final String LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO= "Estado";
		public static final String LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO_LOWER= "Estado Detalle Movimiento Inventario";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
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
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "Cta Contable Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
    	public static final String LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO= "Tipo Detalle Movimiento Inventario";
		public static final String LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO_LOWER= "Tipo Detalle Movimiento Inventario";
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
	
	public static String getDetalleMovimientoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDANIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDMES)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IVA)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOIVA)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOIVA;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.ICE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.SERIE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.LOTE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHAELABORACIONLOTE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHACADUCIDADLOTE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTECLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcosto_ivaDescripcion(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallemovimientoinventario.getcosto_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcosto_ivaHtmlDescripcion(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallemovimientoinventario.getId(),detallemovimientoinventario.getcosto_iva());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleMovimientoInventarioDescripcion(DetalleMovimientoInventario detallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallemovimientoinventario !=null/* && detallemovimientoinventario.getId()!=0*/) {
			if(detallemovimientoinventario.getId()!=null) {
				sDescripcion=detallemovimientoinventario.getId().toString();
			}//detallemovimientoinventariodetallemovimientoinventario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleMovimientoInventarioDescripcionDetallado(DetalleMovimientoInventario detallemovimientoinventario) {
		String sDescripcion="";
			
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=detallemovimientoinventario.getId().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallemovimientoinventario.getVersionRow().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=detallemovimientoinventario.getid_movimiento_inventario().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallemovimientoinventario.getid_empresa().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallemovimientoinventario.getid_sucursal().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallemovimientoinventario.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallemovimientoinventario.getid_periodo().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallemovimientoinventario.getid_anio().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDMES+"=";
		sDescripcion+=detallemovimientoinventario.getid_mes().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=detallemovimientoinventario.getid_estado_detalle_movimiento_inventario().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallemovimientoinventario.getid_bodega().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallemovimientoinventario.getid_producto().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallemovimientoinventario.getid_unidad().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallemovimientoinventario.getdescripcion()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallemovimientoinventario.getcantidad().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallemovimientoinventario.getdescuento().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detallemovimientoinventario.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detallemovimientoinventario.getcosto_total().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=detallemovimientoinventario.getdisponible().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IVA+"=";
		sDescripcion+=detallemovimientoinventario.getiva().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallemovimientoinventario.getiva_valor().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.COSTOIVA+"=";
		sDescripcion+=detallemovimientoinventario.getcosto_iva().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.ICE+"=";
		sDescripcion+=detallemovimientoinventario.getice().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallemovimientoinventario.getice_valor().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1+"=";
		sDescripcion+=detallemovimientoinventario.getdescuento1().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detallemovimientoinventario.getdescuento2().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.SERIE+"=";
		sDescripcion+=detallemovimientoinventario.getserie()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.LOTE+"=";
		sDescripcion+=detallemovimientoinventario.getlote()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE+"=";
		sDescripcion+=detallemovimientoinventario.getfecha_elaboracion_lote().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE+"=";
		sDescripcion+=detallemovimientoinventario.getfecha_caducidad_lote().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=detallemovimientoinventario.getid_novedad_producto().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallemovimientoinventario.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=detallemovimientoinventario.getid_cuenta_contable_costo().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario().toString()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detallemovimientoinventario.getnumero_comprobante()+",";
		sDescripcion+=DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detallemovimientoinventario.getlote_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleMovimientoInventarioDescripcion(DetalleMovimientoInventario detallemovimientoinventario,String sValor) throws Exception {			
		if(detallemovimientoinventario !=null) {
			//detallemovimientoinventariodetallemovimientoinventario.getId().toString();
		}		
	}
	
		

	public static String getMovimientoInventarioDescripcion(MovimientoInventario movimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(movimientoinventario!=null/*&&movimientoinventario.getId()>0*/) {
			sDescripcion=MovimientoInventarioConstantesFunciones.getMovimientoInventarioDescripcion(movimientoinventario);
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

	public static String getEstadoDetalleMovimientoInventarioDescripcion(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetallemovimientoinventario!=null/*&&estadodetallemovimientoinventario.getId()>0*/) {
			sDescripcion=EstadoDetalleMovimientoInventarioConstantesFunciones.getEstadoDetalleMovimientoInventarioDescripcion(estadodetallemovimientoinventario);
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

	public static String getTipoDetalleMovimientoInventarioDescripcion(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodetallemovimientoinventario!=null/*&&tipodetallemovimientoinventario.getId()>0*/) {
			sDescripcion=TipoDetalleMovimientoInventarioConstantesFunciones.getTipoDetalleMovimientoInventarioDescripcion(tipodetallemovimientoinventario);
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por Cta Contable Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Movimiento";
		} else if(sNombreIndice.equals("FK_IdNovedadProducto")) {
			sNombreIndice="Tipo=  Por Novedad";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDetalleMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Tipo Detalle Movimiento Inventario";
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

	public static String getDetalleIndiceFK_IdEstadoDetalleMovimientoInventario(Long id_estado_detalle_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_movimiento_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMovimientoInventario(Long id_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Movimiento="+id_movimiento_inventario.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoDetalleMovimientoInventario(Long id_tipo_detalle_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_detalle_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Tipo Detalle Movimiento Inventario="+id_tipo_detalle_movimiento_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallemovimientoinventario.setdescripcion(detallemovimientoinventario.getdescripcion().trim());
		detallemovimientoinventario.setserie(detallemovimientoinventario.getserie().trim());
		detallemovimientoinventario.setlote(detallemovimientoinventario.getlote().trim());
		detallemovimientoinventario.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante().trim());
		detallemovimientoinventario.setlote_cliente(detallemovimientoinventario.getlote_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario: detallemovimientoinventarios) {
			detallemovimientoinventario.setdescripcion(detallemovimientoinventario.getdescripcion().trim());
			detallemovimientoinventario.setserie(detallemovimientoinventario.getserie().trim());
			detallemovimientoinventario.setlote(detallemovimientoinventario.getlote().trim());
			detallemovimientoinventario.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante().trim());
			detallemovimientoinventario.setlote_cliente(detallemovimientoinventario.getlote_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallemovimientoinventario.getConCambioAuxiliar()) {
			detallemovimientoinventario.setIsDeleted(detallemovimientoinventario.getIsDeletedAuxiliar());	
			detallemovimientoinventario.setIsNew(detallemovimientoinventario.getIsNewAuxiliar());	
			detallemovimientoinventario.setIsChanged(detallemovimientoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallemovimientoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallemovimientoinventario.setIsDeletedAuxiliar(false);	
			detallemovimientoinventario.setIsNewAuxiliar(false);	
			detallemovimientoinventario.setIsChangedAuxiliar(false);
			
			detallemovimientoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario : detallemovimientoinventarios) {
			if(conAsignarBase && detallemovimientoinventario.getConCambioAuxiliar()) {
				detallemovimientoinventario.setIsDeleted(detallemovimientoinventario.getIsDeletedAuxiliar());	
				detallemovimientoinventario.setIsNew(detallemovimientoinventario.getIsNewAuxiliar());	
				detallemovimientoinventario.setIsChanged(detallemovimientoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallemovimientoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallemovimientoinventario.setIsDeletedAuxiliar(false);	
				detallemovimientoinventario.setIsNewAuxiliar(false);	
				detallemovimientoinventario.setIsChangedAuxiliar(false);
				
				detallemovimientoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario,Boolean conEnteros) throws Exception  {
		detallemovimientoinventario.setdescuento(0.0);
		detallemovimientoinventario.setcosto_unitario(0.0);
		detallemovimientoinventario.setcosto_total(0.0);
		detallemovimientoinventario.setiva(0.0);
		detallemovimientoinventario.setiva_valor(0.0);
		detallemovimientoinventario.setice(0.0);
		detallemovimientoinventario.setice_valor(0.0);
		detallemovimientoinventario.setdescuento1(0.0);
		detallemovimientoinventario.setdescuento2(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallemovimientoinventario.setcantidad(0);
			detallemovimientoinventario.setdisponible(0);
		}
	}		
	
	public static void InicializarValoresDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios,Boolean conEnteros) throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario: detallemovimientoinventarios) {
			detallemovimientoinventario.setdescuento(0.0);
			detallemovimientoinventario.setcosto_unitario(0.0);
			detallemovimientoinventario.setcosto_total(0.0);
			detallemovimientoinventario.setiva(0.0);
			detallemovimientoinventario.setiva_valor(0.0);
			detallemovimientoinventario.setice(0.0);
			detallemovimientoinventario.setice_valor(0.0);
			detallemovimientoinventario.setdescuento1(0.0);
			detallemovimientoinventario.setdescuento2(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallemovimientoinventario.setcantidad(0);
				detallemovimientoinventario.setdisponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleMovimientoInventario(List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventario detallemovimientoinventarioAux) throws Exception  {
		DetalleMovimientoInventarioConstantesFunciones.InicializarValoresDetalleMovimientoInventario(detallemovimientoinventarioAux,true);
		
		for(DetalleMovimientoInventario detallemovimientoinventario: detallemovimientoinventarios) {
			if(detallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallemovimientoinventarioAux.setcantidad(detallemovimientoinventarioAux.getcantidad()+detallemovimientoinventario.getcantidad());			
			detallemovimientoinventarioAux.setdescuento(detallemovimientoinventarioAux.getdescuento()+detallemovimientoinventario.getdescuento());			
			detallemovimientoinventarioAux.setcosto_unitario(detallemovimientoinventarioAux.getcosto_unitario()+detallemovimientoinventario.getcosto_unitario());			
			detallemovimientoinventarioAux.setcosto_total(detallemovimientoinventarioAux.getcosto_total()+detallemovimientoinventario.getcosto_total());			
			detallemovimientoinventarioAux.setdisponible(detallemovimientoinventarioAux.getdisponible()+detallemovimientoinventario.getdisponible());			
			detallemovimientoinventarioAux.setiva(detallemovimientoinventarioAux.getiva()+detallemovimientoinventario.getiva());			
			detallemovimientoinventarioAux.setiva_valor(detallemovimientoinventarioAux.getiva_valor()+detallemovimientoinventario.getiva_valor());			
			detallemovimientoinventarioAux.setice(detallemovimientoinventarioAux.getice()+detallemovimientoinventario.getice());			
			detallemovimientoinventarioAux.setice_valor(detallemovimientoinventarioAux.getice_valor()+detallemovimientoinventario.getice_valor());			
			detallemovimientoinventarioAux.setdescuento1(detallemovimientoinventarioAux.getdescuento1()+detallemovimientoinventario.getdescuento1());			
			detallemovimientoinventarioAux.setdescuento2(detallemovimientoinventarioAux.getdescuento2()+detallemovimientoinventario.getdescuento2());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleMovimientoInventarioConstantesFunciones.getArrayColumnasGlobalesDetalleMovimientoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventario detallemovimientoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleMovimientoInventario detallemovimientoinventarioAux: detallemovimientoinventarios) {
			if(detallemovimientoinventarioAux!=null && detallemovimientoinventario!=null) {
				if((detallemovimientoinventarioAux.getId()==null && detallemovimientoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallemovimientoinventarioAux.getId()!=null && detallemovimientoinventario.getId()!=null){
					if(detallemovimientoinventarioAux.getId().equals(detallemovimientoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleMovimientoInventario(List<DetalleMovimientoInventario> detallemovimientoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double descuento1Total=0.0;
		Double descuento2Total=0.0;
	
		for(DetalleMovimientoInventario detallemovimientoinventario: detallemovimientoinventarios) {			
			if(detallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=detallemovimientoinventario.getdescuento();
			costo_unitarioTotal+=detallemovimientoinventario.getcosto_unitario();
			costo_totalTotal+=detallemovimientoinventario.getcosto_total();
			ivaTotal+=detallemovimientoinventario.getiva();
			iva_valorTotal+=detallemovimientoinventario.getiva_valor();
			iceTotal+=detallemovimientoinventario.getice();
			ice_valorTotal+=detallemovimientoinventario.getice_valor();
			descuento1Total+=detallemovimientoinventario.getdescuento1();
			descuento2Total+=detallemovimientoinventario.getdescuento2();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1);
		datoGeneral.setdValorDouble(descuento1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleMovimientoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_ID, DetalleMovimientoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_VERSIONROW, DetalleMovimientoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMOVIMIENTOINVENTARIO, DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA, DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL, DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO, DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPERIODO, DetalleMovimientoInventarioConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDANIO, DetalleMovimientoInventarioConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMES, DetalleMovimientoInventarioConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO, DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDBODEGA, DetalleMovimientoInventarioConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPRODUCTO, DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDUNIDAD, DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION, DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_CANTIDAD, DetalleMovimientoInventarioConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO, DetalleMovimientoInventarioConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO, DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL, DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_DISPONIBLE, DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA, DetalleMovimientoInventarioConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR, DetalleMovimientoInventarioConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOIVA, DetalleMovimientoInventarioConstantesFunciones.COSTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE, DetalleMovimientoInventarioConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR, DetalleMovimientoInventarioConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1, DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2, DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_SERIE, DetalleMovimientoInventarioConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTE, DetalleMovimientoInventarioConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHAELABORACIONLOTE, DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHACADUCIDADLOTE, DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO, DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTECLIENTE, DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleMovimientoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.COSTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMovimientoInventario() throws Exception  {
		return DetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarDetalleMovimientoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMovimientoInventario(Boolean conFk) throws Exception  {
		return DetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarDetalleMovimientoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMovimientoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOIVA);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHAELABORACIONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHACADUCIDADLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleMovimientoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventarioAux) throws Exception {
		
			detallemovimientoinventarioAux.setmovimientoinventario_descripcion(MovimientoInventarioConstantesFunciones.getMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getMovimientoInventario()));
			detallemovimientoinventarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemovimientoinventarioAux.getEmpresa()));
			detallemovimientoinventarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemovimientoinventarioAux.getSucursal()));
			detallemovimientoinventarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallemovimientoinventarioAux.getEjercicio()));
			detallemovimientoinventarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallemovimientoinventarioAux.getPeriodo()));
			detallemovimientoinventarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallemovimientoinventarioAux.getAnio()));
			detallemovimientoinventarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallemovimientoinventarioAux.getMes()));
			detallemovimientoinventarioAux.setestadodetallemovimientoinventario_descripcion(EstadoDetalleMovimientoInventarioConstantesFunciones.getEstadoDetalleMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getEstadoDetalleMovimientoInventario()));
			detallemovimientoinventarioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallemovimientoinventarioAux.getBodega()));
			detallemovimientoinventarioAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallemovimientoinventarioAux.getProducto()));
			detallemovimientoinventarioAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallemovimientoinventarioAux.getUnidad()));
			detallemovimientoinventarioAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallemovimientoinventarioAux.getNovedadProducto()));
			detallemovimientoinventarioAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallemovimientoinventarioAux.getCentroCosto()));
			detallemovimientoinventarioAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallemovimientoinventarioAux.getCuentaContableCosto()));
			detallemovimientoinventarioAux.settipodetallemovimientoinventario_descripcion(TipoDetalleMovimientoInventarioConstantesFunciones.getTipoDetalleMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getTipoDetalleMovimientoInventario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMovimientoInventario(List<DetalleMovimientoInventario> detallemovimientoinventariosTemp) throws Exception {
		for(DetalleMovimientoInventario detallemovimientoinventarioAux:detallemovimientoinventariosTemp) {
			
			detallemovimientoinventarioAux.setmovimientoinventario_descripcion(MovimientoInventarioConstantesFunciones.getMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getMovimientoInventario()));
			detallemovimientoinventarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemovimientoinventarioAux.getEmpresa()));
			detallemovimientoinventarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemovimientoinventarioAux.getSucursal()));
			detallemovimientoinventarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallemovimientoinventarioAux.getEjercicio()));
			detallemovimientoinventarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallemovimientoinventarioAux.getPeriodo()));
			detallemovimientoinventarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallemovimientoinventarioAux.getAnio()));
			detallemovimientoinventarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallemovimientoinventarioAux.getMes()));
			detallemovimientoinventarioAux.setestadodetallemovimientoinventario_descripcion(EstadoDetalleMovimientoInventarioConstantesFunciones.getEstadoDetalleMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getEstadoDetalleMovimientoInventario()));
			detallemovimientoinventarioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallemovimientoinventarioAux.getBodega()));
			detallemovimientoinventarioAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallemovimientoinventarioAux.getProducto()));
			detallemovimientoinventarioAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallemovimientoinventarioAux.getUnidad()));
			detallemovimientoinventarioAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detallemovimientoinventarioAux.getNovedadProducto()));
			detallemovimientoinventarioAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallemovimientoinventarioAux.getCentroCosto()));
			detallemovimientoinventarioAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallemovimientoinventarioAux.getCuentaContableCosto()));
			detallemovimientoinventarioAux.settipodetallemovimientoinventario_descripcion(TipoDetalleMovimientoInventarioConstantesFunciones.getTipoDetalleMovimientoInventarioDescripcion(detallemovimientoinventarioAux.getTipoDetalleMovimientoInventario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MovimientoInventario.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(EstadoDetalleMovimientoInventario.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoDetalleMovimientoInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoInventario.class)) {
						classes.add(new Classe(MovimientoInventario.class));
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
					if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
						classes.add(new Classe(EstadoDetalleMovimientoInventario.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
						classes.add(new Classe(TipoDetalleMovimientoInventario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
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

					if(EstadoDetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleMovimientoInventario.class)); continue;
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

					if(TipoDetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetalleMovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
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

					if(EstadoDetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleMovimientoInventario.class)); continue;
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

					if(TipoDetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetalleMovimientoInventario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfDetalleMovimientoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NovedadSeguimiento.class));
				classes.add(new Classe(Costo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadSeguimiento.class)) {
						classes.add(new Classe(NovedadSeguimiento.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Costo.class)) {
						classes.add(new Classe(Costo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleMovimientoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
					}

					if(Costo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Costo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
					}

					if(Costo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Costo.class)); continue;
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
	public static void actualizarLista(DetalleMovimientoInventario detallemovimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleMovimientoInventario detallemovimientoinventarioEncontrado=null;
			
			for(DetalleMovimientoInventario detallemovimientoinventarioLocal:detallemovimientoinventarios) {
				if(detallemovimientoinventarioLocal.getId().equals(detallemovimientoinventario.getId())) {
					detallemovimientoinventarioEncontrado=detallemovimientoinventarioLocal;
					
					detallemovimientoinventarioLocal.setIsChanged(detallemovimientoinventario.getIsChanged());
					detallemovimientoinventarioLocal.setIsNew(detallemovimientoinventario.getIsNew());
					detallemovimientoinventarioLocal.setIsDeleted(detallemovimientoinventario.getIsDeleted());
					
					detallemovimientoinventarioLocal.setGeneralEntityOriginal(detallemovimientoinventario.getGeneralEntityOriginal());
					
					detallemovimientoinventarioLocal.setId(detallemovimientoinventario.getId());	
					detallemovimientoinventarioLocal.setVersionRow(detallemovimientoinventario.getVersionRow());	
					detallemovimientoinventarioLocal.setid_movimiento_inventario(detallemovimientoinventario.getid_movimiento_inventario());	
					detallemovimientoinventarioLocal.setid_empresa(detallemovimientoinventario.getid_empresa());	
					detallemovimientoinventarioLocal.setid_sucursal(detallemovimientoinventario.getid_sucursal());	
					detallemovimientoinventarioLocal.setid_ejercicio(detallemovimientoinventario.getid_ejercicio());	
					detallemovimientoinventarioLocal.setid_periodo(detallemovimientoinventario.getid_periodo());	
					detallemovimientoinventarioLocal.setid_anio(detallemovimientoinventario.getid_anio());	
					detallemovimientoinventarioLocal.setid_mes(detallemovimientoinventario.getid_mes());	
					detallemovimientoinventarioLocal.setid_estado_detalle_movimiento_inventario(detallemovimientoinventario.getid_estado_detalle_movimiento_inventario());	
					detallemovimientoinventarioLocal.setid_bodega(detallemovimientoinventario.getid_bodega());	
					detallemovimientoinventarioLocal.setid_producto(detallemovimientoinventario.getid_producto());	
					detallemovimientoinventarioLocal.setid_unidad(detallemovimientoinventario.getid_unidad());	
					detallemovimientoinventarioLocal.setdescripcion(detallemovimientoinventario.getdescripcion());	
					detallemovimientoinventarioLocal.setcantidad(detallemovimientoinventario.getcantidad());	
					detallemovimientoinventarioLocal.setdescuento(detallemovimientoinventario.getdescuento());	
					detallemovimientoinventarioLocal.setcosto_unitario(detallemovimientoinventario.getcosto_unitario());	
					detallemovimientoinventarioLocal.setcosto_total(detallemovimientoinventario.getcosto_total());	
					detallemovimientoinventarioLocal.setdisponible(detallemovimientoinventario.getdisponible());	
					detallemovimientoinventarioLocal.setiva(detallemovimientoinventario.getiva());	
					detallemovimientoinventarioLocal.setiva_valor(detallemovimientoinventario.getiva_valor());	
					detallemovimientoinventarioLocal.setcosto_iva(detallemovimientoinventario.getcosto_iva());	
					detallemovimientoinventarioLocal.setice(detallemovimientoinventario.getice());	
					detallemovimientoinventarioLocal.setice_valor(detallemovimientoinventario.getice_valor());	
					detallemovimientoinventarioLocal.setdescuento1(detallemovimientoinventario.getdescuento1());	
					detallemovimientoinventarioLocal.setdescuento2(detallemovimientoinventario.getdescuento2());	
					detallemovimientoinventarioLocal.setserie(detallemovimientoinventario.getserie());	
					detallemovimientoinventarioLocal.setlote(detallemovimientoinventario.getlote());	
					detallemovimientoinventarioLocal.setfecha_elaboracion_lote(detallemovimientoinventario.getfecha_elaboracion_lote());	
					detallemovimientoinventarioLocal.setfecha_caducidad_lote(detallemovimientoinventario.getfecha_caducidad_lote());	
					detallemovimientoinventarioLocal.setid_novedad_producto(detallemovimientoinventario.getid_novedad_producto());	
					detallemovimientoinventarioLocal.setid_centro_costo(detallemovimientoinventario.getid_centro_costo());	
					detallemovimientoinventarioLocal.setid_cuenta_contable_costo(detallemovimientoinventario.getid_cuenta_contable_costo());	
					detallemovimientoinventarioLocal.setid_tipo_detalle_movimiento_inventario(detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario());	
					detallemovimientoinventarioLocal.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante());	
					detallemovimientoinventarioLocal.setlote_cliente(detallemovimientoinventario.getlote_cliente());	
					
					
					detallemovimientoinventarioLocal.setNovedadSeguimientos(detallemovimientoinventario.getNovedadSeguimientos());
					
					existe=true;
					break;
				}
			}
			
			if(!detallemovimientoinventario.getIsDeleted()) {
				if(!existe) {
					detallemovimientoinventarios.add(detallemovimientoinventario);
				}
			} else {
				if(detallemovimientoinventarioEncontrado!=null && permiteQuitar)  {
					detallemovimientoinventarios.remove(detallemovimientoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleMovimientoInventario detallemovimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios) throws Exception {
		try	{			
			for(DetalleMovimientoInventario detallemovimientoinventarioLocal:detallemovimientoinventarios) {
				if(detallemovimientoinventarioLocal.getId().equals(detallemovimientoinventario.getId())) {
					detallemovimientoinventarioLocal.setIsSelected(detallemovimientoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleMovimientoInventario(List<DetalleMovimientoInventario> detallemovimientoinventariosAux) throws Exception {
		//this.detallemovimientoinventariosAux=detallemovimientoinventariosAux;
		
		for(DetalleMovimientoInventario detallemovimientoinventarioAux:detallemovimientoinventariosAux) {
			if(detallemovimientoinventarioAux.getIsChanged()) {
				detallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(detallemovimientoinventarioAux.getIsNew()) {
				detallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(detallemovimientoinventarioAux.getIsDeleted()) {
				detallemovimientoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventarioAux) throws Exception {
		//this.detallemovimientoinventarioAux=detallemovimientoinventarioAux;
		
			if(detallemovimientoinventarioAux.getIsChanged()) {
				detallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(detallemovimientoinventarioAux.getIsNew()) {
				detallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(detallemovimientoinventarioAux.getIsDeleted()) {
				detallemovimientoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleMovimientoInventario detallemovimientoinventarioAsignar,DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		detallemovimientoinventarioAsignar.setId(detallemovimientoinventario.getId());	
		detallemovimientoinventarioAsignar.setVersionRow(detallemovimientoinventario.getVersionRow());	
		detallemovimientoinventarioAsignar.setid_movimiento_inventario(detallemovimientoinventario.getid_movimiento_inventario());
		detallemovimientoinventarioAsignar.setmovimientoinventario_descripcion(detallemovimientoinventario.getmovimientoinventario_descripcion());	
		detallemovimientoinventarioAsignar.setid_empresa(detallemovimientoinventario.getid_empresa());
		detallemovimientoinventarioAsignar.setempresa_descripcion(detallemovimientoinventario.getempresa_descripcion());	
		detallemovimientoinventarioAsignar.setid_sucursal(detallemovimientoinventario.getid_sucursal());
		detallemovimientoinventarioAsignar.setsucursal_descripcion(detallemovimientoinventario.getsucursal_descripcion());	
		detallemovimientoinventarioAsignar.setid_ejercicio(detallemovimientoinventario.getid_ejercicio());
		detallemovimientoinventarioAsignar.setejercicio_descripcion(detallemovimientoinventario.getejercicio_descripcion());	
		detallemovimientoinventarioAsignar.setid_periodo(detallemovimientoinventario.getid_periodo());
		detallemovimientoinventarioAsignar.setperiodo_descripcion(detallemovimientoinventario.getperiodo_descripcion());	
		detallemovimientoinventarioAsignar.setid_anio(detallemovimientoinventario.getid_anio());
		detallemovimientoinventarioAsignar.setanio_descripcion(detallemovimientoinventario.getanio_descripcion());	
		detallemovimientoinventarioAsignar.setid_mes(detallemovimientoinventario.getid_mes());
		detallemovimientoinventarioAsignar.setmes_descripcion(detallemovimientoinventario.getmes_descripcion());	
		detallemovimientoinventarioAsignar.setid_estado_detalle_movimiento_inventario(detallemovimientoinventario.getid_estado_detalle_movimiento_inventario());
		detallemovimientoinventarioAsignar.setestadodetallemovimientoinventario_descripcion(detallemovimientoinventario.getestadodetallemovimientoinventario_descripcion());	
		detallemovimientoinventarioAsignar.setid_bodega(detallemovimientoinventario.getid_bodega());
		detallemovimientoinventarioAsignar.setbodega_descripcion(detallemovimientoinventario.getbodega_descripcion());	
		detallemovimientoinventarioAsignar.setid_producto(detallemovimientoinventario.getid_producto());
		detallemovimientoinventarioAsignar.setproducto_descripcion(detallemovimientoinventario.getproducto_descripcion());	
		detallemovimientoinventarioAsignar.setid_unidad(detallemovimientoinventario.getid_unidad());
		detallemovimientoinventarioAsignar.setunidad_descripcion(detallemovimientoinventario.getunidad_descripcion());	
		detallemovimientoinventarioAsignar.setdescripcion(detallemovimientoinventario.getdescripcion());	
		detallemovimientoinventarioAsignar.setcantidad(detallemovimientoinventario.getcantidad());	
		detallemovimientoinventarioAsignar.setdescuento(detallemovimientoinventario.getdescuento());	
		detallemovimientoinventarioAsignar.setcosto_unitario(detallemovimientoinventario.getcosto_unitario());	
		detallemovimientoinventarioAsignar.setcosto_total(detallemovimientoinventario.getcosto_total());	
		detallemovimientoinventarioAsignar.setdisponible(detallemovimientoinventario.getdisponible());	
		detallemovimientoinventarioAsignar.setiva(detallemovimientoinventario.getiva());	
		detallemovimientoinventarioAsignar.setiva_valor(detallemovimientoinventario.getiva_valor());	
		detallemovimientoinventarioAsignar.setcosto_iva(detallemovimientoinventario.getcosto_iva());	
		detallemovimientoinventarioAsignar.setice(detallemovimientoinventario.getice());	
		detallemovimientoinventarioAsignar.setice_valor(detallemovimientoinventario.getice_valor());	
		detallemovimientoinventarioAsignar.setdescuento1(detallemovimientoinventario.getdescuento1());	
		detallemovimientoinventarioAsignar.setdescuento2(detallemovimientoinventario.getdescuento2());	
		detallemovimientoinventarioAsignar.setserie(detallemovimientoinventario.getserie());	
		detallemovimientoinventarioAsignar.setlote(detallemovimientoinventario.getlote());	
		detallemovimientoinventarioAsignar.setfecha_elaboracion_lote(detallemovimientoinventario.getfecha_elaboracion_lote());	
		detallemovimientoinventarioAsignar.setfecha_caducidad_lote(detallemovimientoinventario.getfecha_caducidad_lote());	
		detallemovimientoinventarioAsignar.setid_novedad_producto(detallemovimientoinventario.getid_novedad_producto());
		detallemovimientoinventarioAsignar.setnovedadproducto_descripcion(detallemovimientoinventario.getnovedadproducto_descripcion());	
		detallemovimientoinventarioAsignar.setid_centro_costo(detallemovimientoinventario.getid_centro_costo());
		detallemovimientoinventarioAsignar.setcentrocosto_descripcion(detallemovimientoinventario.getcentrocosto_descripcion());	
		detallemovimientoinventarioAsignar.setid_cuenta_contable_costo(detallemovimientoinventario.getid_cuenta_contable_costo());
		detallemovimientoinventarioAsignar.setcuentacontablecosto_descripcion(detallemovimientoinventario.getcuentacontablecosto_descripcion());	
		detallemovimientoinventarioAsignar.setid_tipo_detalle_movimiento_inventario(detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario());
		detallemovimientoinventarioAsignar.settipodetallemovimientoinventario_descripcion(detallemovimientoinventario.gettipodetallemovimientoinventario_descripcion());	
		detallemovimientoinventarioAsignar.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante());	
		detallemovimientoinventarioAsignar.setlote_cliente(detallemovimientoinventario.getlote_cliente());	
	}
	
	public static void inicializarDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		try {
				detallemovimientoinventario.setId(0L);	
					
				detallemovimientoinventario.setid_movimiento_inventario(-1L);	
				detallemovimientoinventario.setid_empresa(-1L);	
				detallemovimientoinventario.setid_sucursal(-1L);	
				detallemovimientoinventario.setid_ejercicio(-1L);	
				detallemovimientoinventario.setid_periodo(-1L);	
				detallemovimientoinventario.setid_anio(null);	
				detallemovimientoinventario.setid_mes(null);	
				detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(1L);	
				detallemovimientoinventario.setid_bodega(-1L);	
				detallemovimientoinventario.setid_producto(-1L);	
				detallemovimientoinventario.setid_unidad(-1L);	
				detallemovimientoinventario.setdescripcion("");	
				detallemovimientoinventario.setcantidad(0);	
				detallemovimientoinventario.setdescuento(0.0);	
				detallemovimientoinventario.setcosto_unitario(0.0);	
				detallemovimientoinventario.setcosto_total(0.0);	
				detallemovimientoinventario.setdisponible(0);	
				detallemovimientoinventario.setiva(0.0);	
				detallemovimientoinventario.setiva_valor(0.0);	
				detallemovimientoinventario.setcosto_iva(false);	
				detallemovimientoinventario.setice(0.0);	
				detallemovimientoinventario.setice_valor(0.0);	
				detallemovimientoinventario.setdescuento1(0.0);	
				detallemovimientoinventario.setdescuento2(0.0);	
				detallemovimientoinventario.setserie("");	
				detallemovimientoinventario.setlote("");	
				detallemovimientoinventario.setfecha_elaboracion_lote(new Date());	
				detallemovimientoinventario.setfecha_caducidad_lote(new Date());	
				detallemovimientoinventario.setid_novedad_producto(null);	
				detallemovimientoinventario.setid_centro_costo(null);	
				detallemovimientoinventario.setid_cuenta_contable_costo(null);	
				detallemovimientoinventario.setid_tipo_detalle_movimiento_inventario(null);	
				detallemovimientoinventario.setnumero_comprobante("");	
				detallemovimientoinventario.setlote_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDESTADODETALLEMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_COSTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_IDTIPODETALLEMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMovimientoInventarioConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook,DetalleMovimientoInventario detallemovimientoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getmovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getestadodetallemovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallemovimientoinventario.getcosto_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getdescuento1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getfecha_elaboracion_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getfecha_caducidad_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.gettipodetallemovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemovimientoinventario.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleMovimientoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleMovimientoInventario() {
		return this.sFinalQueryDetalleMovimientoInventario;
	}
	
	public void setsFinalQueryDetalleMovimientoInventario(String sFinalQueryDetalleMovimientoInventario) {
		this.sFinalQueryDetalleMovimientoInventario= sFinalQueryDetalleMovimientoInventario;
	}
	
	public Border resaltarSeleccionarDetalleMovimientoInventario=null;
	
	public Border setResaltarSeleccionarDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleMovimientoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleMovimientoInventario() {
		return this.resaltarSeleccionarDetalleMovimientoInventario;
	}
	
	public void setResaltarSeleccionarDetalleMovimientoInventario(Border borderResaltarSeleccionarDetalleMovimientoInventario) {
		this.resaltarSeleccionarDetalleMovimientoInventario= borderResaltarSeleccionarDetalleMovimientoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleMovimientoInventario=null;
	public Boolean mostraridDetalleMovimientoInventario=true;
	public Boolean activaridDetalleMovimientoInventario=true;

	public Border resaltarid_movimiento_inventarioDetalleMovimientoInventario=null;
	public Boolean mostrarid_movimiento_inventarioDetalleMovimientoInventario=true;
	public Boolean activarid_movimiento_inventarioDetalleMovimientoInventario=true;
	public Boolean cargarid_movimiento_inventarioDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_movimiento_inventarioDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleMovimientoInventario=null;
	public Boolean mostrarid_empresaDetalleMovimientoInventario=true;
	public Boolean activarid_empresaDetalleMovimientoInventario=true;
	public Boolean cargarid_empresaDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleMovimientoInventario=null;
	public Boolean mostrarid_sucursalDetalleMovimientoInventario=true;
	public Boolean activarid_sucursalDetalleMovimientoInventario=true;
	public Boolean cargarid_sucursalDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleMovimientoInventario=null;
	public Boolean mostrarid_ejercicioDetalleMovimientoInventario=true;
	public Boolean activarid_ejercicioDetalleMovimientoInventario=true;
	public Boolean cargarid_ejercicioDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleMovimientoInventario=null;
	public Boolean mostrarid_periodoDetalleMovimientoInventario=true;
	public Boolean activarid_periodoDetalleMovimientoInventario=true;
	public Boolean cargarid_periodoDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleMovimientoInventario=null;
	public Boolean mostrarid_anioDetalleMovimientoInventario=true;
	public Boolean activarid_anioDetalleMovimientoInventario=false;
	public Boolean cargarid_anioDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleMovimientoInventario=null;
	public Boolean mostrarid_mesDetalleMovimientoInventario=true;
	public Boolean activarid_mesDetalleMovimientoInventario=false;
	public Boolean cargarid_mesDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario=null;
	public Boolean mostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario=true;
	public Boolean activarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario=false;
	public Boolean cargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleMovimientoInventario=null;
	public Boolean mostrarid_bodegaDetalleMovimientoInventario=true;
	public Boolean activarid_bodegaDetalleMovimientoInventario=true;
	public Boolean cargarid_bodegaDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleMovimientoInventario=null;
	public Boolean mostrarid_productoDetalleMovimientoInventario=true;
	public Boolean activarid_productoDetalleMovimientoInventario=true;
	public Boolean cargarid_productoDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleMovimientoInventario=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleMovimientoInventario=null;
	public Boolean mostrarid_unidadDetalleMovimientoInventario=true;
	public Boolean activarid_unidadDetalleMovimientoInventario=true;
	public Boolean cargarid_unidadDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleMovimientoInventario=true;//ConEventDepend=true

	public Border resaltardescripcionDetalleMovimientoInventario=null;
	public Boolean mostrardescripcionDetalleMovimientoInventario=true;
	public Boolean activardescripcionDetalleMovimientoInventario=true;

	public Border resaltarcantidadDetalleMovimientoInventario=null;
	public Boolean mostrarcantidadDetalleMovimientoInventario=true;
	public Boolean activarcantidadDetalleMovimientoInventario=true;

	public Border resaltardescuentoDetalleMovimientoInventario=null;
	public Boolean mostrardescuentoDetalleMovimientoInventario=true;
	public Boolean activardescuentoDetalleMovimientoInventario=false;

	public Border resaltarcosto_unitarioDetalleMovimientoInventario=null;
	public Boolean mostrarcosto_unitarioDetalleMovimientoInventario=true;
	public Boolean activarcosto_unitarioDetalleMovimientoInventario=true;

	public Border resaltarcosto_totalDetalleMovimientoInventario=null;
	public Boolean mostrarcosto_totalDetalleMovimientoInventario=true;
	public Boolean activarcosto_totalDetalleMovimientoInventario=true;

	public Border resaltardisponibleDetalleMovimientoInventario=null;
	public Boolean mostrardisponibleDetalleMovimientoInventario=true;
	public Boolean activardisponibleDetalleMovimientoInventario=true;

	public Border resaltarivaDetalleMovimientoInventario=null;
	public Boolean mostrarivaDetalleMovimientoInventario=true;
	public Boolean activarivaDetalleMovimientoInventario=false;

	public Border resaltariva_valorDetalleMovimientoInventario=null;
	public Boolean mostrariva_valorDetalleMovimientoInventario=true;
	public Boolean activariva_valorDetalleMovimientoInventario=false;

	public Border resaltarcosto_ivaDetalleMovimientoInventario=null;
	public Boolean mostrarcosto_ivaDetalleMovimientoInventario=true;
	public Boolean activarcosto_ivaDetalleMovimientoInventario=false;

	public Border resaltariceDetalleMovimientoInventario=null;
	public Boolean mostrariceDetalleMovimientoInventario=true;
	public Boolean activariceDetalleMovimientoInventario=false;

	public Border resaltarice_valorDetalleMovimientoInventario=null;
	public Boolean mostrarice_valorDetalleMovimientoInventario=true;
	public Boolean activarice_valorDetalleMovimientoInventario=false;

	public Border resaltardescuento1DetalleMovimientoInventario=null;
	public Boolean mostrardescuento1DetalleMovimientoInventario=true;
	public Boolean activardescuento1DetalleMovimientoInventario=false;

	public Border resaltardescuento2DetalleMovimientoInventario=null;
	public Boolean mostrardescuento2DetalleMovimientoInventario=true;
	public Boolean activardescuento2DetalleMovimientoInventario=false;

	public Border resaltarserieDetalleMovimientoInventario=null;
	public Boolean mostrarserieDetalleMovimientoInventario=true;
	public Boolean activarserieDetalleMovimientoInventario=false;

	public Border resaltarloteDetalleMovimientoInventario=null;
	public Boolean mostrarloteDetalleMovimientoInventario=true;
	public Boolean activarloteDetalleMovimientoInventario=false;

	public Border resaltarfecha_elaboracion_loteDetalleMovimientoInventario=null;
	public Boolean mostrarfecha_elaboracion_loteDetalleMovimientoInventario=true;
	public Boolean activarfecha_elaboracion_loteDetalleMovimientoInventario=false;

	public Border resaltarfecha_caducidad_loteDetalleMovimientoInventario=null;
	public Boolean mostrarfecha_caducidad_loteDetalleMovimientoInventario=true;
	public Boolean activarfecha_caducidad_loteDetalleMovimientoInventario=false;

	public Border resaltarid_novedad_productoDetalleMovimientoInventario=null;
	public Boolean mostrarid_novedad_productoDetalleMovimientoInventario=true;
	public Boolean activarid_novedad_productoDetalleMovimientoInventario=true;
	public Boolean cargarid_novedad_productoDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleMovimientoInventario=null;
	public Boolean mostrarid_centro_costoDetalleMovimientoInventario=true;
	public Boolean activarid_centro_costoDetalleMovimientoInventario=false;
	public Boolean cargarid_centro_costoDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoDetalleMovimientoInventario=null;
	public Boolean mostrarid_cuenta_contable_costoDetalleMovimientoInventario=true;
	public Boolean activarid_cuenta_contable_costoDetalleMovimientoInventario=false;
	public Boolean cargarid_cuenta_contable_costoDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario=null;
	public Boolean mostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario=true;
	public Boolean activarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario=false;
	public Boolean cargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteDetalleMovimientoInventario=null;
	public Boolean mostrarnumero_comprobanteDetalleMovimientoInventario=true;
	public Boolean activarnumero_comprobanteDetalleMovimientoInventario=false;

	public Border resaltarlote_clienteDetalleMovimientoInventario=null;
	public Boolean mostrarlote_clienteDetalleMovimientoInventario=true;
	public Boolean activarlote_clienteDetalleMovimientoInventario=false;

	
	

	public Border setResaltaridDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleMovimientoInventario() {
		return this.resaltaridDetalleMovimientoInventario;
	}

	public void setResaltaridDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltaridDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostraridDetalleMovimientoInventario() {
		return this.mostraridDetalleMovimientoInventario;
	}

	public void setMostraridDetalleMovimientoInventario(Boolean mostraridDetalleMovimientoInventario) {
		this.mostraridDetalleMovimientoInventario= mostraridDetalleMovimientoInventario;
	}

	public Boolean getActivaridDetalleMovimientoInventario() {
		return this.activaridDetalleMovimientoInventario;
	}

	public void setActivaridDetalleMovimientoInventario(Boolean activaridDetalleMovimientoInventario) {
		this.activaridDetalleMovimientoInventario= activaridDetalleMovimientoInventario;
	}

	public Border setResaltarid_movimiento_inventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_movimiento_inventarioDetalleMovimientoInventario() {
		return this.resaltarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setResaltarid_movimiento_inventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_movimiento_inventarioDetalleMovimientoInventario() {
		return this.mostrarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setMostrarid_movimiento_inventarioDetalleMovimientoInventario(Boolean mostrarid_movimiento_inventarioDetalleMovimientoInventario) {
		this.mostrarid_movimiento_inventarioDetalleMovimientoInventario= mostrarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getActivarid_movimiento_inventarioDetalleMovimientoInventario() {
		return this.activarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setActivarid_movimiento_inventarioDetalleMovimientoInventario(Boolean activarid_movimiento_inventarioDetalleMovimientoInventario) {
		this.activarid_movimiento_inventarioDetalleMovimientoInventario= activarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getCargarid_movimiento_inventarioDetalleMovimientoInventario() {
		return this.cargarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setCargarid_movimiento_inventarioDetalleMovimientoInventario(Boolean cargarid_movimiento_inventarioDetalleMovimientoInventario) {
		this.cargarid_movimiento_inventarioDetalleMovimientoInventario= cargarid_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Border setResaltarid_empresaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleMovimientoInventario() {
		return this.resaltarid_empresaDetalleMovimientoInventario;
	}

	public void setResaltarid_empresaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_empresaDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleMovimientoInventario() {
		return this.mostrarid_empresaDetalleMovimientoInventario;
	}

	public void setMostrarid_empresaDetalleMovimientoInventario(Boolean mostrarid_empresaDetalleMovimientoInventario) {
		this.mostrarid_empresaDetalleMovimientoInventario= mostrarid_empresaDetalleMovimientoInventario;
	}

	public Boolean getActivarid_empresaDetalleMovimientoInventario() {
		return this.activarid_empresaDetalleMovimientoInventario;
	}

	public void setActivarid_empresaDetalleMovimientoInventario(Boolean activarid_empresaDetalleMovimientoInventario) {
		this.activarid_empresaDetalleMovimientoInventario= activarid_empresaDetalleMovimientoInventario;
	}

	public Boolean getCargarid_empresaDetalleMovimientoInventario() {
		return this.cargarid_empresaDetalleMovimientoInventario;
	}

	public void setCargarid_empresaDetalleMovimientoInventario(Boolean cargarid_empresaDetalleMovimientoInventario) {
		this.cargarid_empresaDetalleMovimientoInventario= cargarid_empresaDetalleMovimientoInventario;
	}

	public Border setResaltarid_sucursalDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleMovimientoInventario() {
		return this.resaltarid_sucursalDetalleMovimientoInventario;
	}

	public void setResaltarid_sucursalDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_sucursalDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleMovimientoInventario() {
		return this.mostrarid_sucursalDetalleMovimientoInventario;
	}

	public void setMostrarid_sucursalDetalleMovimientoInventario(Boolean mostrarid_sucursalDetalleMovimientoInventario) {
		this.mostrarid_sucursalDetalleMovimientoInventario= mostrarid_sucursalDetalleMovimientoInventario;
	}

	public Boolean getActivarid_sucursalDetalleMovimientoInventario() {
		return this.activarid_sucursalDetalleMovimientoInventario;
	}

	public void setActivarid_sucursalDetalleMovimientoInventario(Boolean activarid_sucursalDetalleMovimientoInventario) {
		this.activarid_sucursalDetalleMovimientoInventario= activarid_sucursalDetalleMovimientoInventario;
	}

	public Boolean getCargarid_sucursalDetalleMovimientoInventario() {
		return this.cargarid_sucursalDetalleMovimientoInventario;
	}

	public void setCargarid_sucursalDetalleMovimientoInventario(Boolean cargarid_sucursalDetalleMovimientoInventario) {
		this.cargarid_sucursalDetalleMovimientoInventario= cargarid_sucursalDetalleMovimientoInventario;
	}

	public Border setResaltarid_ejercicioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleMovimientoInventario() {
		return this.resaltarid_ejercicioDetalleMovimientoInventario;
	}

	public void setResaltarid_ejercicioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleMovimientoInventario() {
		return this.mostrarid_ejercicioDetalleMovimientoInventario;
	}

	public void setMostrarid_ejercicioDetalleMovimientoInventario(Boolean mostrarid_ejercicioDetalleMovimientoInventario) {
		this.mostrarid_ejercicioDetalleMovimientoInventario= mostrarid_ejercicioDetalleMovimientoInventario;
	}

	public Boolean getActivarid_ejercicioDetalleMovimientoInventario() {
		return this.activarid_ejercicioDetalleMovimientoInventario;
	}

	public void setActivarid_ejercicioDetalleMovimientoInventario(Boolean activarid_ejercicioDetalleMovimientoInventario) {
		this.activarid_ejercicioDetalleMovimientoInventario= activarid_ejercicioDetalleMovimientoInventario;
	}

	public Boolean getCargarid_ejercicioDetalleMovimientoInventario() {
		return this.cargarid_ejercicioDetalleMovimientoInventario;
	}

	public void setCargarid_ejercicioDetalleMovimientoInventario(Boolean cargarid_ejercicioDetalleMovimientoInventario) {
		this.cargarid_ejercicioDetalleMovimientoInventario= cargarid_ejercicioDetalleMovimientoInventario;
	}

	public Border setResaltarid_periodoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleMovimientoInventario() {
		return this.resaltarid_periodoDetalleMovimientoInventario;
	}

	public void setResaltarid_periodoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_periodoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleMovimientoInventario() {
		return this.mostrarid_periodoDetalleMovimientoInventario;
	}

	public void setMostrarid_periodoDetalleMovimientoInventario(Boolean mostrarid_periodoDetalleMovimientoInventario) {
		this.mostrarid_periodoDetalleMovimientoInventario= mostrarid_periodoDetalleMovimientoInventario;
	}

	public Boolean getActivarid_periodoDetalleMovimientoInventario() {
		return this.activarid_periodoDetalleMovimientoInventario;
	}

	public void setActivarid_periodoDetalleMovimientoInventario(Boolean activarid_periodoDetalleMovimientoInventario) {
		this.activarid_periodoDetalleMovimientoInventario= activarid_periodoDetalleMovimientoInventario;
	}

	public Boolean getCargarid_periodoDetalleMovimientoInventario() {
		return this.cargarid_periodoDetalleMovimientoInventario;
	}

	public void setCargarid_periodoDetalleMovimientoInventario(Boolean cargarid_periodoDetalleMovimientoInventario) {
		this.cargarid_periodoDetalleMovimientoInventario= cargarid_periodoDetalleMovimientoInventario;
	}

	public Border setResaltarid_anioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleMovimientoInventario() {
		return this.resaltarid_anioDetalleMovimientoInventario;
	}

	public void setResaltarid_anioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_anioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleMovimientoInventario() {
		return this.mostrarid_anioDetalleMovimientoInventario;
	}

	public void setMostrarid_anioDetalleMovimientoInventario(Boolean mostrarid_anioDetalleMovimientoInventario) {
		this.mostrarid_anioDetalleMovimientoInventario= mostrarid_anioDetalleMovimientoInventario;
	}

	public Boolean getActivarid_anioDetalleMovimientoInventario() {
		return this.activarid_anioDetalleMovimientoInventario;
	}

	public void setActivarid_anioDetalleMovimientoInventario(Boolean activarid_anioDetalleMovimientoInventario) {
		this.activarid_anioDetalleMovimientoInventario= activarid_anioDetalleMovimientoInventario;
	}

	public Boolean getCargarid_anioDetalleMovimientoInventario() {
		return this.cargarid_anioDetalleMovimientoInventario;
	}

	public void setCargarid_anioDetalleMovimientoInventario(Boolean cargarid_anioDetalleMovimientoInventario) {
		this.cargarid_anioDetalleMovimientoInventario= cargarid_anioDetalleMovimientoInventario;
	}

	public Border setResaltarid_mesDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleMovimientoInventario() {
		return this.resaltarid_mesDetalleMovimientoInventario;
	}

	public void setResaltarid_mesDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_mesDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleMovimientoInventario() {
		return this.mostrarid_mesDetalleMovimientoInventario;
	}

	public void setMostrarid_mesDetalleMovimientoInventario(Boolean mostrarid_mesDetalleMovimientoInventario) {
		this.mostrarid_mesDetalleMovimientoInventario= mostrarid_mesDetalleMovimientoInventario;
	}

	public Boolean getActivarid_mesDetalleMovimientoInventario() {
		return this.activarid_mesDetalleMovimientoInventario;
	}

	public void setActivarid_mesDetalleMovimientoInventario(Boolean activarid_mesDetalleMovimientoInventario) {
		this.activarid_mesDetalleMovimientoInventario= activarid_mesDetalleMovimientoInventario;
	}

	public Boolean getCargarid_mesDetalleMovimientoInventario() {
		return this.cargarid_mesDetalleMovimientoInventario;
	}

	public void setCargarid_mesDetalleMovimientoInventario(Boolean cargarid_mesDetalleMovimientoInventario) {
		this.cargarid_mesDetalleMovimientoInventario= cargarid_mesDetalleMovimientoInventario;
	}

	public Border setResaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.resaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setResaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.mostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setMostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean mostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.mostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario= mostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getActivarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.activarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setActivarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean activarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.activarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario= activarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getCargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.cargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setCargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean cargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.cargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario= cargarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Border setResaltarid_bodegaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_bodegaDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleMovimientoInventario() {
		return this.resaltarid_bodegaDetalleMovimientoInventario;
	}

	public void setResaltarid_bodegaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_bodegaDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleMovimientoInventario() {
		return this.mostrarid_bodegaDetalleMovimientoInventario;
	}

	public void setMostrarid_bodegaDetalleMovimientoInventario(Boolean mostrarid_bodegaDetalleMovimientoInventario) {
		this.mostrarid_bodegaDetalleMovimientoInventario= mostrarid_bodegaDetalleMovimientoInventario;
	}

	public Boolean getActivarid_bodegaDetalleMovimientoInventario() {
		return this.activarid_bodegaDetalleMovimientoInventario;
	}

	public void setActivarid_bodegaDetalleMovimientoInventario(Boolean activarid_bodegaDetalleMovimientoInventario) {
		this.activarid_bodegaDetalleMovimientoInventario= activarid_bodegaDetalleMovimientoInventario;
	}

	public Boolean getCargarid_bodegaDetalleMovimientoInventario() {
		return this.cargarid_bodegaDetalleMovimientoInventario;
	}

	public void setCargarid_bodegaDetalleMovimientoInventario(Boolean cargarid_bodegaDetalleMovimientoInventario) {
		this.cargarid_bodegaDetalleMovimientoInventario= cargarid_bodegaDetalleMovimientoInventario;
	}

	public Border setResaltarid_productoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_productoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleMovimientoInventario() {
		return this.resaltarid_productoDetalleMovimientoInventario;
	}

	public void setResaltarid_productoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_productoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleMovimientoInventario() {
		return this.mostrarid_productoDetalleMovimientoInventario;
	}

	public void setMostrarid_productoDetalleMovimientoInventario(Boolean mostrarid_productoDetalleMovimientoInventario) {
		this.mostrarid_productoDetalleMovimientoInventario= mostrarid_productoDetalleMovimientoInventario;
	}

	public Boolean getActivarid_productoDetalleMovimientoInventario() {
		return this.activarid_productoDetalleMovimientoInventario;
	}

	public void setActivarid_productoDetalleMovimientoInventario(Boolean activarid_productoDetalleMovimientoInventario) {
		this.activarid_productoDetalleMovimientoInventario= activarid_productoDetalleMovimientoInventario;
	}

	public Boolean getCargarid_productoDetalleMovimientoInventario() {
		return this.cargarid_productoDetalleMovimientoInventario;
	}

	public void setCargarid_productoDetalleMovimientoInventario(Boolean cargarid_productoDetalleMovimientoInventario) {
		this.cargarid_productoDetalleMovimientoInventario= cargarid_productoDetalleMovimientoInventario;
	}

	public Border setResaltarid_unidadDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_unidadDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleMovimientoInventario() {
		return this.resaltarid_unidadDetalleMovimientoInventario;
	}

	public void setResaltarid_unidadDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_unidadDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleMovimientoInventario() {
		return this.mostrarid_unidadDetalleMovimientoInventario;
	}

	public void setMostrarid_unidadDetalleMovimientoInventario(Boolean mostrarid_unidadDetalleMovimientoInventario) {
		this.mostrarid_unidadDetalleMovimientoInventario= mostrarid_unidadDetalleMovimientoInventario;
	}

	public Boolean getActivarid_unidadDetalleMovimientoInventario() {
		return this.activarid_unidadDetalleMovimientoInventario;
	}

	public void setActivarid_unidadDetalleMovimientoInventario(Boolean activarid_unidadDetalleMovimientoInventario) {
		this.activarid_unidadDetalleMovimientoInventario= activarid_unidadDetalleMovimientoInventario;
	}

	public Boolean getCargarid_unidadDetalleMovimientoInventario() {
		return this.cargarid_unidadDetalleMovimientoInventario;
	}

	public void setCargarid_unidadDetalleMovimientoInventario(Boolean cargarid_unidadDetalleMovimientoInventario) {
		this.cargarid_unidadDetalleMovimientoInventario= cargarid_unidadDetalleMovimientoInventario;
	}

	public Border setResaltardescripcionDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltardescripcionDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleMovimientoInventario() {
		return this.resaltardescripcionDetalleMovimientoInventario;
	}

	public void setResaltardescripcionDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltardescripcionDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleMovimientoInventario() {
		return this.mostrardescripcionDetalleMovimientoInventario;
	}

	public void setMostrardescripcionDetalleMovimientoInventario(Boolean mostrardescripcionDetalleMovimientoInventario) {
		this.mostrardescripcionDetalleMovimientoInventario= mostrardescripcionDetalleMovimientoInventario;
	}

	public Boolean getActivardescripcionDetalleMovimientoInventario() {
		return this.activardescripcionDetalleMovimientoInventario;
	}

	public void setActivardescripcionDetalleMovimientoInventario(Boolean activardescripcionDetalleMovimientoInventario) {
		this.activardescripcionDetalleMovimientoInventario= activardescripcionDetalleMovimientoInventario;
	}

	public Border setResaltarcantidadDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarcantidadDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleMovimientoInventario() {
		return this.resaltarcantidadDetalleMovimientoInventario;
	}

	public void setResaltarcantidadDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcantidadDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleMovimientoInventario() {
		return this.mostrarcantidadDetalleMovimientoInventario;
	}

	public void setMostrarcantidadDetalleMovimientoInventario(Boolean mostrarcantidadDetalleMovimientoInventario) {
		this.mostrarcantidadDetalleMovimientoInventario= mostrarcantidadDetalleMovimientoInventario;
	}

	public Boolean getActivarcantidadDetalleMovimientoInventario() {
		return this.activarcantidadDetalleMovimientoInventario;
	}

	public void setActivarcantidadDetalleMovimientoInventario(Boolean activarcantidadDetalleMovimientoInventario) {
		this.activarcantidadDetalleMovimientoInventario= activarcantidadDetalleMovimientoInventario;
	}

	public Border setResaltardescuentoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltardescuentoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleMovimientoInventario() {
		return this.resaltardescuentoDetalleMovimientoInventario;
	}

	public void setResaltardescuentoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltardescuentoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleMovimientoInventario() {
		return this.mostrardescuentoDetalleMovimientoInventario;
	}

	public void setMostrardescuentoDetalleMovimientoInventario(Boolean mostrardescuentoDetalleMovimientoInventario) {
		this.mostrardescuentoDetalleMovimientoInventario= mostrardescuentoDetalleMovimientoInventario;
	}

	public Boolean getActivardescuentoDetalleMovimientoInventario() {
		return this.activardescuentoDetalleMovimientoInventario;
	}

	public void setActivardescuentoDetalleMovimientoInventario(Boolean activardescuentoDetalleMovimientoInventario) {
		this.activardescuentoDetalleMovimientoInventario= activardescuentoDetalleMovimientoInventario;
	}

	public Border setResaltarcosto_unitarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarcosto_unitarioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleMovimientoInventario() {
		return this.resaltarcosto_unitarioDetalleMovimientoInventario;
	}

	public void setResaltarcosto_unitarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleMovimientoInventario() {
		return this.mostrarcosto_unitarioDetalleMovimientoInventario;
	}

	public void setMostrarcosto_unitarioDetalleMovimientoInventario(Boolean mostrarcosto_unitarioDetalleMovimientoInventario) {
		this.mostrarcosto_unitarioDetalleMovimientoInventario= mostrarcosto_unitarioDetalleMovimientoInventario;
	}

	public Boolean getActivarcosto_unitarioDetalleMovimientoInventario() {
		return this.activarcosto_unitarioDetalleMovimientoInventario;
	}

	public void setActivarcosto_unitarioDetalleMovimientoInventario(Boolean activarcosto_unitarioDetalleMovimientoInventario) {
		this.activarcosto_unitarioDetalleMovimientoInventario= activarcosto_unitarioDetalleMovimientoInventario;
	}

	public Border setResaltarcosto_totalDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarcosto_totalDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleMovimientoInventario() {
		return this.resaltarcosto_totalDetalleMovimientoInventario;
	}

	public void setResaltarcosto_totalDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcosto_totalDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleMovimientoInventario() {
		return this.mostrarcosto_totalDetalleMovimientoInventario;
	}

	public void setMostrarcosto_totalDetalleMovimientoInventario(Boolean mostrarcosto_totalDetalleMovimientoInventario) {
		this.mostrarcosto_totalDetalleMovimientoInventario= mostrarcosto_totalDetalleMovimientoInventario;
	}

	public Boolean getActivarcosto_totalDetalleMovimientoInventario() {
		return this.activarcosto_totalDetalleMovimientoInventario;
	}

	public void setActivarcosto_totalDetalleMovimientoInventario(Boolean activarcosto_totalDetalleMovimientoInventario) {
		this.activarcosto_totalDetalleMovimientoInventario= activarcosto_totalDetalleMovimientoInventario;
	}

	public Border setResaltardisponibleDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltardisponibleDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleDetalleMovimientoInventario() {
		return this.resaltardisponibleDetalleMovimientoInventario;
	}

	public void setResaltardisponibleDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltardisponibleDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardisponibleDetalleMovimientoInventario() {
		return this.mostrardisponibleDetalleMovimientoInventario;
	}

	public void setMostrardisponibleDetalleMovimientoInventario(Boolean mostrardisponibleDetalleMovimientoInventario) {
		this.mostrardisponibleDetalleMovimientoInventario= mostrardisponibleDetalleMovimientoInventario;
	}

	public Boolean getActivardisponibleDetalleMovimientoInventario() {
		return this.activardisponibleDetalleMovimientoInventario;
	}

	public void setActivardisponibleDetalleMovimientoInventario(Boolean activardisponibleDetalleMovimientoInventario) {
		this.activardisponibleDetalleMovimientoInventario= activardisponibleDetalleMovimientoInventario;
	}

	public Border setResaltarivaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarivaDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleMovimientoInventario() {
		return this.resaltarivaDetalleMovimientoInventario;
	}

	public void setResaltarivaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarivaDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarivaDetalleMovimientoInventario() {
		return this.mostrarivaDetalleMovimientoInventario;
	}

	public void setMostrarivaDetalleMovimientoInventario(Boolean mostrarivaDetalleMovimientoInventario) {
		this.mostrarivaDetalleMovimientoInventario= mostrarivaDetalleMovimientoInventario;
	}

	public Boolean getActivarivaDetalleMovimientoInventario() {
		return this.activarivaDetalleMovimientoInventario;
	}

	public void setActivarivaDetalleMovimientoInventario(Boolean activarivaDetalleMovimientoInventario) {
		this.activarivaDetalleMovimientoInventario= activarivaDetalleMovimientoInventario;
	}

	public Border setResaltariva_valorDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltariva_valorDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleMovimientoInventario() {
		return this.resaltariva_valorDetalleMovimientoInventario;
	}

	public void setResaltariva_valorDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltariva_valorDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleMovimientoInventario() {
		return this.mostrariva_valorDetalleMovimientoInventario;
	}

	public void setMostrariva_valorDetalleMovimientoInventario(Boolean mostrariva_valorDetalleMovimientoInventario) {
		this.mostrariva_valorDetalleMovimientoInventario= mostrariva_valorDetalleMovimientoInventario;
	}

	public Boolean getActivariva_valorDetalleMovimientoInventario() {
		return this.activariva_valorDetalleMovimientoInventario;
	}

	public void setActivariva_valorDetalleMovimientoInventario(Boolean activariva_valorDetalleMovimientoInventario) {
		this.activariva_valorDetalleMovimientoInventario= activariva_valorDetalleMovimientoInventario;
	}

	public Border setResaltarcosto_ivaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarcosto_ivaDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ivaDetalleMovimientoInventario() {
		return this.resaltarcosto_ivaDetalleMovimientoInventario;
	}

	public void setResaltarcosto_ivaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcosto_ivaDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcosto_ivaDetalleMovimientoInventario() {
		return this.mostrarcosto_ivaDetalleMovimientoInventario;
	}

	public void setMostrarcosto_ivaDetalleMovimientoInventario(Boolean mostrarcosto_ivaDetalleMovimientoInventario) {
		this.mostrarcosto_ivaDetalleMovimientoInventario= mostrarcosto_ivaDetalleMovimientoInventario;
	}

	public Boolean getActivarcosto_ivaDetalleMovimientoInventario() {
		return this.activarcosto_ivaDetalleMovimientoInventario;
	}

	public void setActivarcosto_ivaDetalleMovimientoInventario(Boolean activarcosto_ivaDetalleMovimientoInventario) {
		this.activarcosto_ivaDetalleMovimientoInventario= activarcosto_ivaDetalleMovimientoInventario;
	}

	public Border setResaltariceDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltariceDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleMovimientoInventario() {
		return this.resaltariceDetalleMovimientoInventario;
	}

	public void setResaltariceDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltariceDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrariceDetalleMovimientoInventario() {
		return this.mostrariceDetalleMovimientoInventario;
	}

	public void setMostrariceDetalleMovimientoInventario(Boolean mostrariceDetalleMovimientoInventario) {
		this.mostrariceDetalleMovimientoInventario= mostrariceDetalleMovimientoInventario;
	}

	public Boolean getActivariceDetalleMovimientoInventario() {
		return this.activariceDetalleMovimientoInventario;
	}

	public void setActivariceDetalleMovimientoInventario(Boolean activariceDetalleMovimientoInventario) {
		this.activariceDetalleMovimientoInventario= activariceDetalleMovimientoInventario;
	}

	public Border setResaltarice_valorDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarice_valorDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleMovimientoInventario() {
		return this.resaltarice_valorDetalleMovimientoInventario;
	}

	public void setResaltarice_valorDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarice_valorDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleMovimientoInventario() {
		return this.mostrarice_valorDetalleMovimientoInventario;
	}

	public void setMostrarice_valorDetalleMovimientoInventario(Boolean mostrarice_valorDetalleMovimientoInventario) {
		this.mostrarice_valorDetalleMovimientoInventario= mostrarice_valorDetalleMovimientoInventario;
	}

	public Boolean getActivarice_valorDetalleMovimientoInventario() {
		return this.activarice_valorDetalleMovimientoInventario;
	}

	public void setActivarice_valorDetalleMovimientoInventario(Boolean activarice_valorDetalleMovimientoInventario) {
		this.activarice_valorDetalleMovimientoInventario= activarice_valorDetalleMovimientoInventario;
	}

	public Border setResaltardescuento1DetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltardescuento1DetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento1DetalleMovimientoInventario() {
		return this.resaltardescuento1DetalleMovimientoInventario;
	}

	public void setResaltardescuento1DetalleMovimientoInventario(Border borderResaltar) {
		this.resaltardescuento1DetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardescuento1DetalleMovimientoInventario() {
		return this.mostrardescuento1DetalleMovimientoInventario;
	}

	public void setMostrardescuento1DetalleMovimientoInventario(Boolean mostrardescuento1DetalleMovimientoInventario) {
		this.mostrardescuento1DetalleMovimientoInventario= mostrardescuento1DetalleMovimientoInventario;
	}

	public Boolean getActivardescuento1DetalleMovimientoInventario() {
		return this.activardescuento1DetalleMovimientoInventario;
	}

	public void setActivardescuento1DetalleMovimientoInventario(Boolean activardescuento1DetalleMovimientoInventario) {
		this.activardescuento1DetalleMovimientoInventario= activardescuento1DetalleMovimientoInventario;
	}

	public Border setResaltardescuento2DetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltardescuento2DetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetalleMovimientoInventario() {
		return this.resaltardescuento2DetalleMovimientoInventario;
	}

	public void setResaltardescuento2DetalleMovimientoInventario(Border borderResaltar) {
		this.resaltardescuento2DetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardescuento2DetalleMovimientoInventario() {
		return this.mostrardescuento2DetalleMovimientoInventario;
	}

	public void setMostrardescuento2DetalleMovimientoInventario(Boolean mostrardescuento2DetalleMovimientoInventario) {
		this.mostrardescuento2DetalleMovimientoInventario= mostrardescuento2DetalleMovimientoInventario;
	}

	public Boolean getActivardescuento2DetalleMovimientoInventario() {
		return this.activardescuento2DetalleMovimientoInventario;
	}

	public void setActivardescuento2DetalleMovimientoInventario(Boolean activardescuento2DetalleMovimientoInventario) {
		this.activardescuento2DetalleMovimientoInventario= activardescuento2DetalleMovimientoInventario;
	}

	public Border setResaltarserieDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarserieDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleMovimientoInventario() {
		return this.resaltarserieDetalleMovimientoInventario;
	}

	public void setResaltarserieDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarserieDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarserieDetalleMovimientoInventario() {
		return this.mostrarserieDetalleMovimientoInventario;
	}

	public void setMostrarserieDetalleMovimientoInventario(Boolean mostrarserieDetalleMovimientoInventario) {
		this.mostrarserieDetalleMovimientoInventario= mostrarserieDetalleMovimientoInventario;
	}

	public Boolean getActivarserieDetalleMovimientoInventario() {
		return this.activarserieDetalleMovimientoInventario;
	}

	public void setActivarserieDetalleMovimientoInventario(Boolean activarserieDetalleMovimientoInventario) {
		this.activarserieDetalleMovimientoInventario= activarserieDetalleMovimientoInventario;
	}

	public Border setResaltarloteDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarloteDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleMovimientoInventario() {
		return this.resaltarloteDetalleMovimientoInventario;
	}

	public void setResaltarloteDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarloteDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarloteDetalleMovimientoInventario() {
		return this.mostrarloteDetalleMovimientoInventario;
	}

	public void setMostrarloteDetalleMovimientoInventario(Boolean mostrarloteDetalleMovimientoInventario) {
		this.mostrarloteDetalleMovimientoInventario= mostrarloteDetalleMovimientoInventario;
	}

	public Boolean getActivarloteDetalleMovimientoInventario() {
		return this.activarloteDetalleMovimientoInventario;
	}

	public void setActivarloteDetalleMovimientoInventario(Boolean activarloteDetalleMovimientoInventario) {
		this.activarloteDetalleMovimientoInventario= activarloteDetalleMovimientoInventario;
	}

	public Border setResaltarfecha_elaboracion_loteDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarfecha_elaboracion_loteDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_elaboracion_loteDetalleMovimientoInventario() {
		return this.resaltarfecha_elaboracion_loteDetalleMovimientoInventario;
	}

	public void setResaltarfecha_elaboracion_loteDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarfecha_elaboracion_loteDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfecha_elaboracion_loteDetalleMovimientoInventario() {
		return this.mostrarfecha_elaboracion_loteDetalleMovimientoInventario;
	}

	public void setMostrarfecha_elaboracion_loteDetalleMovimientoInventario(Boolean mostrarfecha_elaboracion_loteDetalleMovimientoInventario) {
		this.mostrarfecha_elaboracion_loteDetalleMovimientoInventario= mostrarfecha_elaboracion_loteDetalleMovimientoInventario;
	}

	public Boolean getActivarfecha_elaboracion_loteDetalleMovimientoInventario() {
		return this.activarfecha_elaboracion_loteDetalleMovimientoInventario;
	}

	public void setActivarfecha_elaboracion_loteDetalleMovimientoInventario(Boolean activarfecha_elaboracion_loteDetalleMovimientoInventario) {
		this.activarfecha_elaboracion_loteDetalleMovimientoInventario= activarfecha_elaboracion_loteDetalleMovimientoInventario;
	}

	public Border setResaltarfecha_caducidad_loteDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarfecha_caducidad_loteDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidad_loteDetalleMovimientoInventario() {
		return this.resaltarfecha_caducidad_loteDetalleMovimientoInventario;
	}

	public void setResaltarfecha_caducidad_loteDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarfecha_caducidad_loteDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidad_loteDetalleMovimientoInventario() {
		return this.mostrarfecha_caducidad_loteDetalleMovimientoInventario;
	}

	public void setMostrarfecha_caducidad_loteDetalleMovimientoInventario(Boolean mostrarfecha_caducidad_loteDetalleMovimientoInventario) {
		this.mostrarfecha_caducidad_loteDetalleMovimientoInventario= mostrarfecha_caducidad_loteDetalleMovimientoInventario;
	}

	public Boolean getActivarfecha_caducidad_loteDetalleMovimientoInventario() {
		return this.activarfecha_caducidad_loteDetalleMovimientoInventario;
	}

	public void setActivarfecha_caducidad_loteDetalleMovimientoInventario(Boolean activarfecha_caducidad_loteDetalleMovimientoInventario) {
		this.activarfecha_caducidad_loteDetalleMovimientoInventario= activarfecha_caducidad_loteDetalleMovimientoInventario;
	}

	public Border setResaltarid_novedad_productoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_novedad_productoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoDetalleMovimientoInventario() {
		return this.resaltarid_novedad_productoDetalleMovimientoInventario;
	}

	public void setResaltarid_novedad_productoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_novedad_productoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoDetalleMovimientoInventario() {
		return this.mostrarid_novedad_productoDetalleMovimientoInventario;
	}

	public void setMostrarid_novedad_productoDetalleMovimientoInventario(Boolean mostrarid_novedad_productoDetalleMovimientoInventario) {
		this.mostrarid_novedad_productoDetalleMovimientoInventario= mostrarid_novedad_productoDetalleMovimientoInventario;
	}

	public Boolean getActivarid_novedad_productoDetalleMovimientoInventario() {
		return this.activarid_novedad_productoDetalleMovimientoInventario;
	}

	public void setActivarid_novedad_productoDetalleMovimientoInventario(Boolean activarid_novedad_productoDetalleMovimientoInventario) {
		this.activarid_novedad_productoDetalleMovimientoInventario= activarid_novedad_productoDetalleMovimientoInventario;
	}

	public Boolean getCargarid_novedad_productoDetalleMovimientoInventario() {
		return this.cargarid_novedad_productoDetalleMovimientoInventario;
	}

	public void setCargarid_novedad_productoDetalleMovimientoInventario(Boolean cargarid_novedad_productoDetalleMovimientoInventario) {
		this.cargarid_novedad_productoDetalleMovimientoInventario= cargarid_novedad_productoDetalleMovimientoInventario;
	}

	public Border setResaltarid_centro_costoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_centro_costoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleMovimientoInventario() {
		return this.resaltarid_centro_costoDetalleMovimientoInventario;
	}

	public void setResaltarid_centro_costoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleMovimientoInventario() {
		return this.mostrarid_centro_costoDetalleMovimientoInventario;
	}

	public void setMostrarid_centro_costoDetalleMovimientoInventario(Boolean mostrarid_centro_costoDetalleMovimientoInventario) {
		this.mostrarid_centro_costoDetalleMovimientoInventario= mostrarid_centro_costoDetalleMovimientoInventario;
	}

	public Boolean getActivarid_centro_costoDetalleMovimientoInventario() {
		return this.activarid_centro_costoDetalleMovimientoInventario;
	}

	public void setActivarid_centro_costoDetalleMovimientoInventario(Boolean activarid_centro_costoDetalleMovimientoInventario) {
		this.activarid_centro_costoDetalleMovimientoInventario= activarid_centro_costoDetalleMovimientoInventario;
	}

	public Boolean getCargarid_centro_costoDetalleMovimientoInventario() {
		return this.cargarid_centro_costoDetalleMovimientoInventario;
	}

	public void setCargarid_centro_costoDetalleMovimientoInventario(Boolean cargarid_centro_costoDetalleMovimientoInventario) {
		this.cargarid_centro_costoDetalleMovimientoInventario= cargarid_centro_costoDetalleMovimientoInventario;
	}

	public Border setResaltarid_cuenta_contable_costoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contable_costoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoDetalleMovimientoInventario() {
		return this.resaltarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public void setResaltarid_cuenta_contable_costoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoDetalleMovimientoInventario() {
		return this.mostrarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public void setMostrarid_cuenta_contable_costoDetalleMovimientoInventario(Boolean mostrarid_cuenta_contable_costoDetalleMovimientoInventario) {
		this.mostrarid_cuenta_contable_costoDetalleMovimientoInventario= mostrarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public Boolean getActivarid_cuenta_contable_costoDetalleMovimientoInventario() {
		return this.activarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public void setActivarid_cuenta_contable_costoDetalleMovimientoInventario(Boolean activarid_cuenta_contable_costoDetalleMovimientoInventario) {
		this.activarid_cuenta_contable_costoDetalleMovimientoInventario= activarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public Boolean getCargarid_cuenta_contable_costoDetalleMovimientoInventario() {
		return this.cargarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public void setCargarid_cuenta_contable_costoDetalleMovimientoInventario(Boolean cargarid_cuenta_contable_costoDetalleMovimientoInventario) {
		this.cargarid_cuenta_contable_costoDetalleMovimientoInventario= cargarid_cuenta_contable_costoDetalleMovimientoInventario;
	}

	public Border setResaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.resaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setResaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.mostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setMostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean mostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.mostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario= mostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getActivarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.activarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setActivarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean activarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.activarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario= activarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Boolean getCargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario() {
		return this.cargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public void setCargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(Boolean cargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario) {
		this.cargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario= cargarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario;
	}

	public Border setResaltarnumero_comprobanteDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleMovimientoInventario() {
		return this.resaltarnumero_comprobanteDetalleMovimientoInventario;
	}

	public void setResaltarnumero_comprobanteDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleMovimientoInventario() {
		return this.mostrarnumero_comprobanteDetalleMovimientoInventario;
	}

	public void setMostrarnumero_comprobanteDetalleMovimientoInventario(Boolean mostrarnumero_comprobanteDetalleMovimientoInventario) {
		this.mostrarnumero_comprobanteDetalleMovimientoInventario= mostrarnumero_comprobanteDetalleMovimientoInventario;
	}

	public Boolean getActivarnumero_comprobanteDetalleMovimientoInventario() {
		return this.activarnumero_comprobanteDetalleMovimientoInventario;
	}

	public void setActivarnumero_comprobanteDetalleMovimientoInventario(Boolean activarnumero_comprobanteDetalleMovimientoInventario) {
		this.activarnumero_comprobanteDetalleMovimientoInventario= activarnumero_comprobanteDetalleMovimientoInventario;
	}

	public Border setResaltarlote_clienteDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltar);
		*/
		this.resaltarlote_clienteDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleMovimientoInventario() {
		return this.resaltarlote_clienteDetalleMovimientoInventario;
	}

	public void setResaltarlote_clienteDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarlote_clienteDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleMovimientoInventario() {
		return this.mostrarlote_clienteDetalleMovimientoInventario;
	}

	public void setMostrarlote_clienteDetalleMovimientoInventario(Boolean mostrarlote_clienteDetalleMovimientoInventario) {
		this.mostrarlote_clienteDetalleMovimientoInventario= mostrarlote_clienteDetalleMovimientoInventario;
	}

	public Boolean getActivarlote_clienteDetalleMovimientoInventario() {
		return this.activarlote_clienteDetalleMovimientoInventario;
	}

	public void setActivarlote_clienteDetalleMovimientoInventario(Boolean activarlote_clienteDetalleMovimientoInventario) {
		this.activarlote_clienteDetalleMovimientoInventario= activarlote_clienteDetalleMovimientoInventario;
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
		
		
		this.setMostraridDetalleMovimientoInventario(esInicial);
		this.setMostrarid_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setMostrarid_empresaDetalleMovimientoInventario(esInicial);
		this.setMostrarid_sucursalDetalleMovimientoInventario(esInicial);
		this.setMostrarid_ejercicioDetalleMovimientoInventario(esInicial);
		this.setMostrarid_periodoDetalleMovimientoInventario(esInicial);
		this.setMostrarid_anioDetalleMovimientoInventario(esInicial);
		this.setMostrarid_mesDetalleMovimientoInventario(esInicial);
		this.setMostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setMostrarid_bodegaDetalleMovimientoInventario(esInicial);
		this.setMostrarid_productoDetalleMovimientoInventario(esInicial);
		this.setMostrarid_unidadDetalleMovimientoInventario(esInicial);
		this.setMostrardescripcionDetalleMovimientoInventario(esInicial);
		this.setMostrarcantidadDetalleMovimientoInventario(esInicial);
		this.setMostrardescuentoDetalleMovimientoInventario(esInicial);
		this.setMostrarcosto_unitarioDetalleMovimientoInventario(esInicial);
		this.setMostrarcosto_totalDetalleMovimientoInventario(esInicial);
		this.setMostrardisponibleDetalleMovimientoInventario(esInicial);
		this.setMostrarivaDetalleMovimientoInventario(esInicial);
		this.setMostrariva_valorDetalleMovimientoInventario(esInicial);
		this.setMostrarcosto_ivaDetalleMovimientoInventario(esInicial);
		this.setMostrariceDetalleMovimientoInventario(esInicial);
		this.setMostrarice_valorDetalleMovimientoInventario(esInicial);
		this.setMostrardescuento1DetalleMovimientoInventario(esInicial);
		this.setMostrardescuento2DetalleMovimientoInventario(esInicial);
		this.setMostrarserieDetalleMovimientoInventario(esInicial);
		this.setMostrarloteDetalleMovimientoInventario(esInicial);
		this.setMostrarfecha_elaboracion_loteDetalleMovimientoInventario(esInicial);
		this.setMostrarfecha_caducidad_loteDetalleMovimientoInventario(esInicial);
		this.setMostrarid_novedad_productoDetalleMovimientoInventario(esInicial);
		this.setMostrarid_centro_costoDetalleMovimientoInventario(esInicial);
		this.setMostrarid_cuenta_contable_costoDetalleMovimientoInventario(esInicial);
		this.setMostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setMostrarnumero_comprobanteDetalleMovimientoInventario(esInicial);
		this.setMostrarlote_clienteDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setMostraridDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOIVA)) {
				this.setMostrarcosto_ivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICE)) {
				this.setMostrariceDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1)) {
				this.setMostrardescuento1DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setMostrarfecha_elaboracion_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setMostrarfecha_caducidad_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleMovimientoInventario(esAsigna);
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
		
		
		this.setActivaridDetalleMovimientoInventario(esInicial);
		this.setActivarid_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setActivarid_empresaDetalleMovimientoInventario(esInicial);
		this.setActivarid_sucursalDetalleMovimientoInventario(esInicial);
		this.setActivarid_ejercicioDetalleMovimientoInventario(esInicial);
		this.setActivarid_periodoDetalleMovimientoInventario(esInicial);
		this.setActivarid_anioDetalleMovimientoInventario(esInicial);
		this.setActivarid_mesDetalleMovimientoInventario(esInicial);
		this.setActivarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setActivarid_bodegaDetalleMovimientoInventario(esInicial);
		this.setActivarid_productoDetalleMovimientoInventario(esInicial);
		this.setActivarid_unidadDetalleMovimientoInventario(esInicial);
		this.setActivardescripcionDetalleMovimientoInventario(esInicial);
		this.setActivarcantidadDetalleMovimientoInventario(esInicial);
		this.setActivardescuentoDetalleMovimientoInventario(esInicial);
		this.setActivarcosto_unitarioDetalleMovimientoInventario(esInicial);
		this.setActivarcosto_totalDetalleMovimientoInventario(esInicial);
		this.setActivardisponibleDetalleMovimientoInventario(esInicial);
		this.setActivarivaDetalleMovimientoInventario(esInicial);
		this.setActivariva_valorDetalleMovimientoInventario(esInicial);
		this.setActivarcosto_ivaDetalleMovimientoInventario(esInicial);
		this.setActivariceDetalleMovimientoInventario(esInicial);
		this.setActivarice_valorDetalleMovimientoInventario(esInicial);
		this.setActivardescuento1DetalleMovimientoInventario(esInicial);
		this.setActivardescuento2DetalleMovimientoInventario(esInicial);
		this.setActivarserieDetalleMovimientoInventario(esInicial);
		this.setActivarloteDetalleMovimientoInventario(esInicial);
		this.setActivarfecha_elaboracion_loteDetalleMovimientoInventario(esInicial);
		this.setActivarfecha_caducidad_loteDetalleMovimientoInventario(esInicial);
		this.setActivarid_novedad_productoDetalleMovimientoInventario(esInicial);
		this.setActivarid_centro_costoDetalleMovimientoInventario(esInicial);
		this.setActivarid_cuenta_contable_costoDetalleMovimientoInventario(esInicial);
		this.setActivarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setActivarnumero_comprobanteDetalleMovimientoInventario(esInicial);
		this.setActivarlote_clienteDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setActivaridDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO)) {
				this.setActivarid_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO)) {
				this.setActivarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVA)) {
				this.setActivarivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOIVA)) {
				this.setActivarcosto_ivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICE)) {
				this.setActivariceDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1)) {
				this.setActivardescuento1DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setActivarfecha_elaboracion_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setActivarfecha_caducidad_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO)) {
				this.setActivarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleMovimientoInventario(esInicial);
		this.setResaltarid_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setResaltarid_empresaDetalleMovimientoInventario(esInicial);
		this.setResaltarid_sucursalDetalleMovimientoInventario(esInicial);
		this.setResaltarid_ejercicioDetalleMovimientoInventario(esInicial);
		this.setResaltarid_periodoDetalleMovimientoInventario(esInicial);
		this.setResaltarid_anioDetalleMovimientoInventario(esInicial);
		this.setResaltarid_mesDetalleMovimientoInventario(esInicial);
		this.setResaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setResaltarid_bodegaDetalleMovimientoInventario(esInicial);
		this.setResaltarid_productoDetalleMovimientoInventario(esInicial);
		this.setResaltarid_unidadDetalleMovimientoInventario(esInicial);
		this.setResaltardescripcionDetalleMovimientoInventario(esInicial);
		this.setResaltarcantidadDetalleMovimientoInventario(esInicial);
		this.setResaltardescuentoDetalleMovimientoInventario(esInicial);
		this.setResaltarcosto_unitarioDetalleMovimientoInventario(esInicial);
		this.setResaltarcosto_totalDetalleMovimientoInventario(esInicial);
		this.setResaltardisponibleDetalleMovimientoInventario(esInicial);
		this.setResaltarivaDetalleMovimientoInventario(esInicial);
		this.setResaltariva_valorDetalleMovimientoInventario(esInicial);
		this.setResaltarcosto_ivaDetalleMovimientoInventario(esInicial);
		this.setResaltariceDetalleMovimientoInventario(esInicial);
		this.setResaltarice_valorDetalleMovimientoInventario(esInicial);
		this.setResaltardescuento1DetalleMovimientoInventario(esInicial);
		this.setResaltardescuento2DetalleMovimientoInventario(esInicial);
		this.setResaltarserieDetalleMovimientoInventario(esInicial);
		this.setResaltarloteDetalleMovimientoInventario(esInicial);
		this.setResaltarfecha_elaboracion_loteDetalleMovimientoInventario(esInicial);
		this.setResaltarfecha_caducidad_loteDetalleMovimientoInventario(esInicial);
		this.setResaltarid_novedad_productoDetalleMovimientoInventario(esInicial);
		this.setResaltarid_centro_costoDetalleMovimientoInventario(esInicial);
		this.setResaltarid_cuenta_contable_costoDetalleMovimientoInventario(esInicial);
		this.setResaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esInicial);
		this.setResaltarnumero_comprobanteDetalleMovimientoInventario(esInicial);
		this.setResaltarlote_clienteDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setResaltaridDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_estado_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.COSTOIVA)) {
				this.setResaltarcosto_ivaDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICE)) {
				this.setResaltariceDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1)) {
				this.setResaltardescuento1DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setResaltarfecha_elaboracion_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setResaltarfecha_caducidad_loteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_tipo_detalle_movimiento_inventarioDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNovedadSeguimientoDetalleMovimientoInventario=null;

	public Border getResaltarNovedadSeguimientoDetalleMovimientoInventario() {
		return this.resaltarNovedadSeguimientoDetalleMovimientoInventario;
	}

	public void setResaltarNovedadSeguimientoDetalleMovimientoInventario(Border borderResaltarNovedadSeguimiento) {
		if(borderResaltarNovedadSeguimiento!=null) {
			this.resaltarNovedadSeguimientoDetalleMovimientoInventario= borderResaltarNovedadSeguimiento;
		}
	}

	public Border setResaltarNovedadSeguimientoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedadSeguimiento=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			/*

		//detallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarDetalleMovimientoInventario.setBorder(borderResaltarNovedadSeguimiento);
			*/
		this.resaltarNovedadSeguimientoDetalleMovimientoInventario= borderResaltarNovedadSeguimiento;

		 return borderResaltarNovedadSeguimiento;
	}



	public Boolean mostrarNovedadSeguimientoDetalleMovimientoInventario=true;

	public Boolean getMostrarNovedadSeguimientoDetalleMovimientoInventario() {
		return this.mostrarNovedadSeguimientoDetalleMovimientoInventario;
	}

	public void setMostrarNovedadSeguimientoDetalleMovimientoInventario(Boolean visibilidadResaltarNovedadSeguimiento) {
		this.mostrarNovedadSeguimientoDetalleMovimientoInventario= visibilidadResaltarNovedadSeguimiento;
	}



	public Boolean activarNovedadSeguimientoDetalleMovimientoInventario=true;

	public Boolean gethabilitarResaltarNovedadSeguimientoDetalleMovimientoInventario() {
		return this.activarNovedadSeguimientoDetalleMovimientoInventario;
	}

	public void setActivarNovedadSeguimientoDetalleMovimientoInventario(Boolean habilitarResaltarNovedadSeguimiento) {
		this.activarNovedadSeguimientoDetalleMovimientoInventario= habilitarResaltarNovedadSeguimiento;
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

		this.setMostrarNovedadSeguimientoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setMostrarNovedadSeguimientoDetalleMovimientoInventario(esAsigna);
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

		this.setActivarNovedadSeguimientoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setActivarNovedadSeguimientoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNovedadSeguimientoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadSeguimiento.class)) {
				this.setResaltarNovedadSeguimientoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdBodegaDetalleMovimientoInventario() {
		return this.mostrarFK_IdBodegaDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdBodegaDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleMovimientoInventario() {
		return this.mostrarFK_IdCentroCostoDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdCentroCostoDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCostoDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdCuentaContableCostoDetalleMovimientoInventario() {
		return this.mostrarFK_IdCuentaContableCostoDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdCuentaContableCostoDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdEjercicioDetalleMovimientoInventario() {
		return this.mostrarFK_IdEjercicioDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdEjercicioDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdEmpresaDetalleMovimientoInventario() {
		return this.mostrarFK_IdEmpresaDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdEmpresaDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.mostrarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdMovimientoInventarioDetalleMovimientoInventario() {
		return this.mostrarFK_IdMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdMovimientoInventarioDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMovimientoInventarioDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdNovedadProductoDetalleMovimientoInventario() {
		return this.mostrarFK_IdNovedadProductoDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdNovedadProductoDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdPeriodoDetalleMovimientoInventario() {
		return this.mostrarFK_IdPeriodoDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdPeriodoDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdProductoDetalleMovimientoInventario() {
		return this.mostrarFK_IdProductoDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdProductoDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdSucursalDetalleMovimientoInventario() {
		return this.mostrarFK_IdSucursalDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdSucursalDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.mostrarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleMovimientoInventario=true;

	public Boolean getMostrarFK_IdUnidadDetalleMovimientoInventario() {
		return this.mostrarFK_IdUnidadDetalleMovimientoInventario;
	}

	public void setMostrarFK_IdUnidadDetalleMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleMovimientoInventario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdBodegaDetalleMovimientoInventario() {
		return this.activarFK_IdBodegaDetalleMovimientoInventario;
	}

	public void setActivarFK_IdBodegaDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdCentroCostoDetalleMovimientoInventario() {
		return this.activarFK_IdCentroCostoDetalleMovimientoInventario;
	}

	public void setActivarFK_IdCentroCostoDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCostoDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdCuentaContableCostoDetalleMovimientoInventario() {
		return this.activarFK_IdCuentaContableCostoDetalleMovimientoInventario;
	}

	public void setActivarFK_IdCuentaContableCostoDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdEjercicioDetalleMovimientoInventario() {
		return this.activarFK_IdEjercicioDetalleMovimientoInventario;
	}

	public void setActivarFK_IdEjercicioDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdEmpresaDetalleMovimientoInventario() {
		return this.activarFK_IdEmpresaDetalleMovimientoInventario;
	}

	public void setActivarFK_IdEmpresaDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.activarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setActivarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdMovimientoInventarioDetalleMovimientoInventario() {
		return this.activarFK_IdMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setActivarFK_IdMovimientoInventarioDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdMovimientoInventarioDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdNovedadProductoDetalleMovimientoInventario() {
		return this.activarFK_IdNovedadProductoDetalleMovimientoInventario;
	}

	public void setActivarFK_IdNovedadProductoDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdPeriodoDetalleMovimientoInventario() {
		return this.activarFK_IdPeriodoDetalleMovimientoInventario;
	}

	public void setActivarFK_IdPeriodoDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdProductoDetalleMovimientoInventario() {
		return this.activarFK_IdProductoDetalleMovimientoInventario;
	}

	public void setActivarFK_IdProductoDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdSucursalDetalleMovimientoInventario() {
		return this.activarFK_IdSucursalDetalleMovimientoInventario;
	}

	public void setActivarFK_IdSucursalDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.activarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setActivarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleMovimientoInventario=true;

	public Boolean getActivarFK_IdUnidadDetalleMovimientoInventario() {
		return this.activarFK_IdUnidadDetalleMovimientoInventario;
	}

	public void setActivarFK_IdUnidadDetalleMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleMovimientoInventario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdBodegaDetalleMovimientoInventario() {
		return this.resaltarFK_IdBodegaDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdBodegaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdCentroCostoDetalleMovimientoInventario() {
		return this.resaltarFK_IdCentroCostoDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdCentroCostoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCostoDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdCuentaContableCostoDetalleMovimientoInventario() {
		return this.resaltarFK_IdCuentaContableCostoDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdEjercicioDetalleMovimientoInventario() {
		return this.resaltarFK_IdEjercicioDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdEjercicioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdEmpresaDetalleMovimientoInventario() {
		return this.resaltarFK_IdEmpresaDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdEmpresaDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.resaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdMovimientoInventarioDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdMovimientoInventarioDetalleMovimientoInventario() {
		return this.resaltarFK_IdMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdMovimientoInventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdMovimientoInventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdNovedadProductoDetalleMovimientoInventario() {
		return this.resaltarFK_IdNovedadProductoDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdNovedadProductoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdPeriodoDetalleMovimientoInventario() {
		return this.resaltarFK_IdPeriodoDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdPeriodoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdProductoDetalleMovimientoInventario() {
		return this.resaltarFK_IdProductoDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdProductoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdSucursalDetalleMovimientoInventario() {
		return this.resaltarFK_IdSucursalDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdSucursalDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario() {
		return this.resaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDetalleMovimientoInventarioDetalleMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleMovimientoInventario=null;

	public Border getResaltarFK_IdUnidadDetalleMovimientoInventario() {
		return this.resaltarFK_IdUnidadDetalleMovimientoInventario;
	}

	public void setResaltarFK_IdUnidadDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMovimientoInventarioBeanSwingJInternalFrame detallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleMovimientoInventario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}