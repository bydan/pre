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


import com.bydan.erp.inventario.util.DetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleOrdenCompraParameterGeneral;

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
final public class DetalleOrdenCompraConstantesFunciones extends DetalleOrdenCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleOrdenCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleOrdenCompra"+DetalleOrdenCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleOrdenCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleOrdenCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+DetalleOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+DetalleOrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleOrdenCompraConstantesFunciones.SCHEMA+"_"+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleOrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleOrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleOrdenCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleOrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleOrdenCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Orden Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Orden Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Orden Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleOrdenCompra";
	public static final String OBJECTNAME="detalleordencompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_orden_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleordencompra from "+DetalleOrdenCompraConstantesFunciones.SPERSISTENCENAME+" detalleordencompra";
	public static String QUERYSELECTNATIVE="select "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".cantidad,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".descuento,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".iva,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".iva_valor,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".disponible,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_estado_detalle_orden_compra,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+DetalleOrdenCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleOrdenCompraConstantesFuncionesAdditional detalleordencompraConstantesFuncionesAdditional=null;
	
	public DetalleOrdenCompraConstantesFuncionesAdditional getDetalleOrdenCompraConstantesFuncionesAdditional() {
		return this.detalleordencompraConstantesFuncionesAdditional;
	}
	
	public void setDetalleOrdenCompraConstantesFuncionesAdditional(DetalleOrdenCompraConstantesFuncionesAdditional detalleordencompraConstantesFuncionesAdditional) {
		try {
			this.detalleordencompraConstantesFuncionesAdditional=detalleordencompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDORDENCOMPRA= "id_orden_compra";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCUENTO= "descuento";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DISPONIBLE= "disponible";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String IDESTADODETALLEORDENCOMPRA= "id_estado_detalle_orden_compra";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String LOTECLIENTE= "lote_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDORDENCOMPRA= "Orden Compra";
		public static final String LABEL_IDORDENCOMPRA_LOWER= "Orden Compra";
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
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_IDESTADODETALLEORDENCOMPRA= "Estado";
		public static final String LABEL_IDESTADODETALLEORDENCOMPRA_LOWER= "Estado Detalle Orden Compra";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Nro Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_LOTECLIENTE= "Lote Cliente";
		public static final String LABEL_LOTECLIENTE_LOWER= "Lote Cliente";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleOrdenCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDANIO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDMES)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IVA)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.DISPONIBLE)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_IDESTADODETALLEORDENCOMPRA;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleOrdenCompraConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleOrdenCompraConstantesFunciones.LABEL_LOTECLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleOrdenCompraDescripcion(DetalleOrdenCompra detalleordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleordencompra !=null/* && detalleordencompra.getId()!=0*/) {
			if(detalleordencompra.getId()!=null) {
				sDescripcion=detalleordencompra.getId().toString();
			}//detalleordencompradetalleordencompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleOrdenCompraDescripcionDetallado(DetalleOrdenCompra detalleordencompra) {
		String sDescripcion="";
			
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.ID+"=";
		sDescripcion+=detalleordencompra.getId().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleordencompra.getVersionRow().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA+"=";
		sDescripcion+=detalleordencompra.getid_orden_compra().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleordencompra.getid_empresa().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleordencompra.getid_sucursal().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleordencompra.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleordencompra.getid_periodo().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleordencompra.getid_anio().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleordencompra.getid_mes().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleordencompra.getid_bodega().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleordencompra.getid_producto().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleordencompra.getid_unidad().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleordencompra.getdescripcion()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleordencompra.getcantidad().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detalleordencompra.getdescuento().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detalleordencompra.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IVA+"=";
		sDescripcion+=detalleordencompra.getiva().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detalleordencompra.getiva_valor().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detalleordencompra.getcosto_total().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=detalleordencompra.getdisponible().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=detalleordencompra.getid_novedad_producto().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA+"=";
		sDescripcion+=detalleordencompra.getid_estado_detalle_orden_compra().toString()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detalleordencompra.getnumero_comprobante()+",";
		sDescripcion+=DetalleOrdenCompraConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detalleordencompra.getlote_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleOrdenCompraDescripcion(DetalleOrdenCompra detalleordencompra,String sValor) throws Exception {			
		if(detalleordencompra !=null) {
			//detalleordencompradetalleordencompra.getId().toString();
		}		
	}
	
		

	public static String getOrdenCompraDescripcion(OrdenCompra ordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordencompra!=null/*&&ordencompra.getId()>0*/) {
			sDescripcion=OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompra);
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

	public static String getEstadoDetalleOrdenCompraDescripcion(EstadoDetalleOrdenCompra estadodetalleordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetalleordencompra!=null/*&&estadodetalleordencompra.getId()>0*/) {
			sDescripcion=EstadoDetalleOrdenCompraConstantesFunciones.getEstadoDetalleOrdenCompraDescripcion(estadodetalleordencompra);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleOrdenCompra")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNovedadProducto")) {
			sNombreIndice="Tipo=  Por Novedad";
		} else if(sNombreIndice.equals("FK_IdOrdenCompra")) {
			sNombreIndice="Tipo=  Por Orden Compra";
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

	public static String getDetalleIndiceFK_IdEstadoDetalleOrdenCompra(Long id_estado_detalle_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_orden_compra.toString();} 

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

	public static String getDetalleIndiceFK_IdOrdenCompra(Long id_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Orden Compra="+id_orden_compra.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleordencompra.setdescripcion(detalleordencompra.getdescripcion().trim());
		detalleordencompra.setnumero_comprobante(detalleordencompra.getnumero_comprobante().trim());
		detalleordencompra.setlote_cliente(detalleordencompra.getlote_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleOrdenCompras(List<DetalleOrdenCompra> detalleordencompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleOrdenCompra detalleordencompra: detalleordencompras) {
			detalleordencompra.setdescripcion(detalleordencompra.getdescripcion().trim());
			detalleordencompra.setnumero_comprobante(detalleordencompra.getnumero_comprobante().trim());
			detalleordencompra.setlote_cliente(detalleordencompra.getlote_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleordencompra.getConCambioAuxiliar()) {
			detalleordencompra.setIsDeleted(detalleordencompra.getIsDeletedAuxiliar());	
			detalleordencompra.setIsNew(detalleordencompra.getIsNewAuxiliar());	
			detalleordencompra.setIsChanged(detalleordencompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleordencompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleordencompra.setIsDeletedAuxiliar(false);	
			detalleordencompra.setIsNewAuxiliar(false);	
			detalleordencompra.setIsChangedAuxiliar(false);
			
			detalleordencompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleOrdenCompras(List<DetalleOrdenCompra> detalleordencompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleOrdenCompra detalleordencompra : detalleordencompras) {
			if(conAsignarBase && detalleordencompra.getConCambioAuxiliar()) {
				detalleordencompra.setIsDeleted(detalleordencompra.getIsDeletedAuxiliar());	
				detalleordencompra.setIsNew(detalleordencompra.getIsNewAuxiliar());	
				detalleordencompra.setIsChanged(detalleordencompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleordencompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleordencompra.setIsDeletedAuxiliar(false);	
				detalleordencompra.setIsNewAuxiliar(false);	
				detalleordencompra.setIsChangedAuxiliar(false);
				
				detalleordencompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra,Boolean conEnteros) throws Exception  {
		detalleordencompra.setdescuento(0.0);
		detalleordencompra.setcosto_unitario(0.0);
		detalleordencompra.setiva(0.0);
		detalleordencompra.setiva_valor(0.0);
		detalleordencompra.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleordencompra.setcantidad(0);
			detalleordencompra.setdisponible(0);
		}
	}		
	
	public static void InicializarValoresDetalleOrdenCompras(List<DetalleOrdenCompra> detalleordencompras,Boolean conEnteros) throws Exception  {
		
		for(DetalleOrdenCompra detalleordencompra: detalleordencompras) {
			detalleordencompra.setdescuento(0.0);
			detalleordencompra.setcosto_unitario(0.0);
			detalleordencompra.setiva(0.0);
			detalleordencompra.setiva_valor(0.0);
			detalleordencompra.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleordencompra.setcantidad(0);
				detalleordencompra.setdisponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleOrdenCompra(List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompra detalleordencompraAux) throws Exception  {
		DetalleOrdenCompraConstantesFunciones.InicializarValoresDetalleOrdenCompra(detalleordencompraAux,true);
		
		for(DetalleOrdenCompra detalleordencompra: detalleordencompras) {
			if(detalleordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleordencompraAux.setcantidad(detalleordencompraAux.getcantidad()+detalleordencompra.getcantidad());			
			detalleordencompraAux.setdescuento(detalleordencompraAux.getdescuento()+detalleordencompra.getdescuento());			
			detalleordencompraAux.setcosto_unitario(detalleordencompraAux.getcosto_unitario()+detalleordencompra.getcosto_unitario());			
			detalleordencompraAux.setiva(detalleordencompraAux.getiva()+detalleordencompra.getiva());			
			detalleordencompraAux.setiva_valor(detalleordencompraAux.getiva_valor()+detalleordencompra.getiva_valor());			
			detalleordencompraAux.setcosto_total(detalleordencompraAux.getcosto_total()+detalleordencompra.getcosto_total());			
			detalleordencompraAux.setdisponible(detalleordencompraAux.getdisponible()+detalleordencompra.getdisponible());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleOrdenCompraConstantesFunciones.getArrayColumnasGlobalesDetalleOrdenCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleOrdenCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleOrdenCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleOrdenCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleOrdenCompraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompra detalleordencompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleOrdenCompra detalleordencompraAux: detalleordencompras) {
			if(detalleordencompraAux!=null && detalleordencompra!=null) {
				if((detalleordencompraAux.getId()==null && detalleordencompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleordencompraAux.getId()!=null && detalleordencompra.getId()!=null){
					if(detalleordencompraAux.getId().equals(detalleordencompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleOrdenCompra(List<DetalleOrdenCompra> detalleordencompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(DetalleOrdenCompra detalleordencompra: detalleordencompras) {			
			if(detalleordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=detalleordencompra.getdescuento();
			costo_unitarioTotal+=detalleordencompra.getcosto_unitario();
			ivaTotal+=detalleordencompra.getiva();
			iva_valorTotal+=detalleordencompra.getiva_valor();
			costo_totalTotal+=detalleordencompra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleOrdenCompraConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleOrdenCompraConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleOrdenCompraConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleOrdenCompraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleOrdenCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_ID, DetalleOrdenCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_VERSIONROW, DetalleOrdenCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA, DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDEMPRESA, DetalleOrdenCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL, DetalleOrdenCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO, DetalleOrdenCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDPERIODO, DetalleOrdenCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDANIO, DetalleOrdenCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDMES, DetalleOrdenCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDBODEGA, DetalleOrdenCompraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDPRODUCTO, DetalleOrdenCompraConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDUNIDAD, DetalleOrdenCompraConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_DESCRIPCION, DetalleOrdenCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_CANTIDAD, DetalleOrdenCompraConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO, DetalleOrdenCompraConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO, DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IVA, DetalleOrdenCompraConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR, DetalleOrdenCompraConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL, DetalleOrdenCompraConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_DISPONIBLE, DetalleOrdenCompraConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_IDESTADODETALLEORDENCOMPRA, DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleOrdenCompraConstantesFunciones.LABEL_LOTECLIENTE, DetalleOrdenCompraConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleOrdenCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleOrdenCompraConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleOrdenCompra() throws Exception  {
		return DetalleOrdenCompraConstantesFunciones.getTiposSeleccionarDetalleOrdenCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleOrdenCompra(Boolean conFk) throws Exception  {
		return DetalleOrdenCompraConstantesFunciones.getTiposSeleccionarDetalleOrdenCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleOrdenCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_IDESTADODETALLEORDENCOMPRA);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_IDESTADODETALLEORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleOrdenCompraConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleOrdenCompraConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleOrdenCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleOrdenCompra(DetalleOrdenCompra detalleordencompraAux) throws Exception {
		
			detalleordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(detalleordencompraAux.getOrdenCompra()));
			detalleordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleordencompraAux.getEmpresa()));
			detalleordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleordencompraAux.getSucursal()));
			detalleordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleordencompraAux.getEjercicio()));
			detalleordencompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleordencompraAux.getPeriodo()));
			detalleordencompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleordencompraAux.getAnio()));
			detalleordencompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleordencompraAux.getMes()));
			detalleordencompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleordencompraAux.getBodega()));
			detalleordencompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleordencompraAux.getProducto()));
			detalleordencompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleordencompraAux.getUnidad()));
			detalleordencompraAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detalleordencompraAux.getNovedadProducto()));
			detalleordencompraAux.setestadodetalleordencompra_descripcion(EstadoDetalleOrdenCompraConstantesFunciones.getEstadoDetalleOrdenCompraDescripcion(detalleordencompraAux.getEstadoDetalleOrdenCompra()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleOrdenCompra(List<DetalleOrdenCompra> detalleordencomprasTemp) throws Exception {
		for(DetalleOrdenCompra detalleordencompraAux:detalleordencomprasTemp) {
			
			detalleordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(detalleordencompraAux.getOrdenCompra()));
			detalleordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleordencompraAux.getEmpresa()));
			detalleordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleordencompraAux.getSucursal()));
			detalleordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleordencompraAux.getEjercicio()));
			detalleordencompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleordencompraAux.getPeriodo()));
			detalleordencompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleordencompraAux.getAnio()));
			detalleordencompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleordencompraAux.getMes()));
			detalleordencompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleordencompraAux.getBodega()));
			detalleordencompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleordencompraAux.getProducto()));
			detalleordencompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleordencompraAux.getUnidad()));
			detalleordencompraAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detalleordencompraAux.getNovedadProducto()));
			detalleordencompraAux.setestadodetalleordencompra_descripcion(EstadoDetalleOrdenCompraConstantesFunciones.getEstadoDetalleOrdenCompraDescripcion(detalleordencompraAux.getEstadoDetalleOrdenCompra()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(EstadoDetalleOrdenCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class));
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
					if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
						classes.add(new Classe(EstadoDetalleOrdenCompra.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
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

					if(EstadoDetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleOrdenCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
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

					if(EstadoDetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleOrdenCompra.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleOrdenCompraConstantesFunciones.getClassesRelationshipsOfDetalleOrdenCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleOrdenCompraConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleOrdenCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleOrdenCompra detalleordencompra,List<DetalleOrdenCompra> detalleordencompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleOrdenCompra detalleordencompraEncontrado=null;
			
			for(DetalleOrdenCompra detalleordencompraLocal:detalleordencompras) {
				if(detalleordencompraLocal.getId().equals(detalleordencompra.getId())) {
					detalleordencompraEncontrado=detalleordencompraLocal;
					
					detalleordencompraLocal.setIsChanged(detalleordencompra.getIsChanged());
					detalleordencompraLocal.setIsNew(detalleordencompra.getIsNew());
					detalleordencompraLocal.setIsDeleted(detalleordencompra.getIsDeleted());
					
					detalleordencompraLocal.setGeneralEntityOriginal(detalleordencompra.getGeneralEntityOriginal());
					
					detalleordencompraLocal.setId(detalleordencompra.getId());	
					detalleordencompraLocal.setVersionRow(detalleordencompra.getVersionRow());	
					detalleordencompraLocal.setid_orden_compra(detalleordencompra.getid_orden_compra());	
					detalleordencompraLocal.setid_empresa(detalleordencompra.getid_empresa());	
					detalleordencompraLocal.setid_sucursal(detalleordencompra.getid_sucursal());	
					detalleordencompraLocal.setid_ejercicio(detalleordencompra.getid_ejercicio());	
					detalleordencompraLocal.setid_periodo(detalleordencompra.getid_periodo());	
					detalleordencompraLocal.setid_anio(detalleordencompra.getid_anio());	
					detalleordencompraLocal.setid_mes(detalleordencompra.getid_mes());	
					detalleordencompraLocal.setid_bodega(detalleordencompra.getid_bodega());	
					detalleordencompraLocal.setid_producto(detalleordencompra.getid_producto());	
					detalleordencompraLocal.setid_unidad(detalleordencompra.getid_unidad());	
					detalleordencompraLocal.setdescripcion(detalleordencompra.getdescripcion());	
					detalleordencompraLocal.setcantidad(detalleordencompra.getcantidad());	
					detalleordencompraLocal.setdescuento(detalleordencompra.getdescuento());	
					detalleordencompraLocal.setcosto_unitario(detalleordencompra.getcosto_unitario());	
					detalleordencompraLocal.setiva(detalleordencompra.getiva());	
					detalleordencompraLocal.setiva_valor(detalleordencompra.getiva_valor());	
					detalleordencompraLocal.setcosto_total(detalleordencompra.getcosto_total());	
					detalleordencompraLocal.setdisponible(detalleordencompra.getdisponible());	
					detalleordencompraLocal.setid_novedad_producto(detalleordencompra.getid_novedad_producto());	
					detalleordencompraLocal.setid_estado_detalle_orden_compra(detalleordencompra.getid_estado_detalle_orden_compra());	
					detalleordencompraLocal.setnumero_comprobante(detalleordencompra.getnumero_comprobante());	
					detalleordencompraLocal.setlote_cliente(detalleordencompra.getlote_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleordencompra.getIsDeleted()) {
				if(!existe) {
					detalleordencompras.add(detalleordencompra);
				}
			} else {
				if(detalleordencompraEncontrado!=null && permiteQuitar)  {
					detalleordencompras.remove(detalleordencompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleOrdenCompra detalleordencompra,List<DetalleOrdenCompra> detalleordencompras) throws Exception {
		try	{			
			for(DetalleOrdenCompra detalleordencompraLocal:detalleordencompras) {
				if(detalleordencompraLocal.getId().equals(detalleordencompra.getId())) {
					detalleordencompraLocal.setIsSelected(detalleordencompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleOrdenCompra(List<DetalleOrdenCompra> detalleordencomprasAux) throws Exception {
		//this.detalleordencomprasAux=detalleordencomprasAux;
		
		for(DetalleOrdenCompra detalleordencompraAux:detalleordencomprasAux) {
			if(detalleordencompraAux.getIsChanged()) {
				detalleordencompraAux.setIsChanged(false);
			}		
			
			if(detalleordencompraAux.getIsNew()) {
				detalleordencompraAux.setIsNew(false);
			}	
			
			if(detalleordencompraAux.getIsDeleted()) {
				detalleordencompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleOrdenCompra(DetalleOrdenCompra detalleordencompraAux) throws Exception {
		//this.detalleordencompraAux=detalleordencompraAux;
		
			if(detalleordencompraAux.getIsChanged()) {
				detalleordencompraAux.setIsChanged(false);
			}		
			
			if(detalleordencompraAux.getIsNew()) {
				detalleordencompraAux.setIsNew(false);
			}	
			
			if(detalleordencompraAux.getIsDeleted()) {
				detalleordencompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleOrdenCompra detalleordencompraAsignar,DetalleOrdenCompra detalleordencompra) throws Exception {
		detalleordencompraAsignar.setId(detalleordencompra.getId());	
		detalleordencompraAsignar.setVersionRow(detalleordencompra.getVersionRow());	
		detalleordencompraAsignar.setid_orden_compra(detalleordencompra.getid_orden_compra());
		detalleordencompraAsignar.setordencompra_descripcion(detalleordencompra.getordencompra_descripcion());	
		detalleordencompraAsignar.setid_empresa(detalleordencompra.getid_empresa());
		detalleordencompraAsignar.setempresa_descripcion(detalleordencompra.getempresa_descripcion());	
		detalleordencompraAsignar.setid_sucursal(detalleordencompra.getid_sucursal());
		detalleordencompraAsignar.setsucursal_descripcion(detalleordencompra.getsucursal_descripcion());	
		detalleordencompraAsignar.setid_ejercicio(detalleordencompra.getid_ejercicio());
		detalleordencompraAsignar.setejercicio_descripcion(detalleordencompra.getejercicio_descripcion());	
		detalleordencompraAsignar.setid_periodo(detalleordencompra.getid_periodo());
		detalleordencompraAsignar.setperiodo_descripcion(detalleordencompra.getperiodo_descripcion());	
		detalleordencompraAsignar.setid_anio(detalleordencompra.getid_anio());
		detalleordencompraAsignar.setanio_descripcion(detalleordencompra.getanio_descripcion());	
		detalleordencompraAsignar.setid_mes(detalleordencompra.getid_mes());
		detalleordencompraAsignar.setmes_descripcion(detalleordencompra.getmes_descripcion());	
		detalleordencompraAsignar.setid_bodega(detalleordencompra.getid_bodega());
		detalleordencompraAsignar.setbodega_descripcion(detalleordencompra.getbodega_descripcion());	
		detalleordencompraAsignar.setid_producto(detalleordencompra.getid_producto());
		detalleordencompraAsignar.setproducto_descripcion(detalleordencompra.getproducto_descripcion());	
		detalleordencompraAsignar.setid_unidad(detalleordencompra.getid_unidad());
		detalleordencompraAsignar.setunidad_descripcion(detalleordencompra.getunidad_descripcion());	
		detalleordencompraAsignar.setdescripcion(detalleordencompra.getdescripcion());	
		detalleordencompraAsignar.setcantidad(detalleordencompra.getcantidad());	
		detalleordencompraAsignar.setdescuento(detalleordencompra.getdescuento());	
		detalleordencompraAsignar.setcosto_unitario(detalleordencompra.getcosto_unitario());	
		detalleordencompraAsignar.setiva(detalleordencompra.getiva());	
		detalleordencompraAsignar.setiva_valor(detalleordencompra.getiva_valor());	
		detalleordencompraAsignar.setcosto_total(detalleordencompra.getcosto_total());	
		detalleordencompraAsignar.setdisponible(detalleordencompra.getdisponible());	
		detalleordencompraAsignar.setid_novedad_producto(detalleordencompra.getid_novedad_producto());
		detalleordencompraAsignar.setnovedadproducto_descripcion(detalleordencompra.getnovedadproducto_descripcion());	
		detalleordencompraAsignar.setid_estado_detalle_orden_compra(detalleordencompra.getid_estado_detalle_orden_compra());
		detalleordencompraAsignar.setestadodetalleordencompra_descripcion(detalleordencompra.getestadodetalleordencompra_descripcion());	
		detalleordencompraAsignar.setnumero_comprobante(detalleordencompra.getnumero_comprobante());	
		detalleordencompraAsignar.setlote_cliente(detalleordencompra.getlote_cliente());	
	}
	
	public static void inicializarDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra) throws Exception {
		try {
				detalleordencompra.setId(0L);	
					
				detalleordencompra.setid_orden_compra(-1L);	
				detalleordencompra.setid_empresa(-1L);	
				detalleordencompra.setid_sucursal(-1L);	
				detalleordencompra.setid_ejercicio(-1L);	
				detalleordencompra.setid_periodo(-1L);	
				detalleordencompra.setid_anio(null);	
				detalleordencompra.setid_mes(null);	
				detalleordencompra.setid_bodega(-1L);	
				detalleordencompra.setid_producto(-1L);	
				detalleordencompra.setid_unidad(-1L);	
				detalleordencompra.setdescripcion("");	
				detalleordencompra.setcantidad(0);	
				detalleordencompra.setdescuento(0.0);	
				detalleordencompra.setcosto_unitario(0.0);	
				detalleordencompra.setiva(0.0);	
				detalleordencompra.setiva_valor(0.0);	
				detalleordencompra.setcosto_total(0.0);	
				detalleordencompra.setdisponible(0);	
				detalleordencompra.setid_novedad_producto(null);	
				detalleordencompra.setid_estado_detalle_orden_compra(-1L);	
				detalleordencompra.setnumero_comprobante("");	
				detalleordencompra.setlote_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleOrdenCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_IDESTADODETALLEORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleOrdenCompraConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleOrdenCompra(String sTipo,Row row,Workbook workbook,DetalleOrdenCompra detalleordencompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getestadodetalleordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleordencompra.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleOrdenCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleOrdenCompra() {
		return this.sFinalQueryDetalleOrdenCompra;
	}
	
	public void setsFinalQueryDetalleOrdenCompra(String sFinalQueryDetalleOrdenCompra) {
		this.sFinalQueryDetalleOrdenCompra= sFinalQueryDetalleOrdenCompra;
	}
	
	public Border resaltarSeleccionarDetalleOrdenCompra=null;
	
	public Border setResaltarSeleccionarDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleOrdenCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleOrdenCompra() {
		return this.resaltarSeleccionarDetalleOrdenCompra;
	}
	
	public void setResaltarSeleccionarDetalleOrdenCompra(Border borderResaltarSeleccionarDetalleOrdenCompra) {
		this.resaltarSeleccionarDetalleOrdenCompra= borderResaltarSeleccionarDetalleOrdenCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleOrdenCompra=null;
	public Boolean mostraridDetalleOrdenCompra=true;
	public Boolean activaridDetalleOrdenCompra=true;

	public Border resaltarid_orden_compraDetalleOrdenCompra=null;
	public Boolean mostrarid_orden_compraDetalleOrdenCompra=true;
	public Boolean activarid_orden_compraDetalleOrdenCompra=true;
	public Boolean cargarid_orden_compraDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_compraDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleOrdenCompra=null;
	public Boolean mostrarid_empresaDetalleOrdenCompra=true;
	public Boolean activarid_empresaDetalleOrdenCompra=true;
	public Boolean cargarid_empresaDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleOrdenCompra=null;
	public Boolean mostrarid_sucursalDetalleOrdenCompra=true;
	public Boolean activarid_sucursalDetalleOrdenCompra=true;
	public Boolean cargarid_sucursalDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleOrdenCompra=null;
	public Boolean mostrarid_ejercicioDetalleOrdenCompra=true;
	public Boolean activarid_ejercicioDetalleOrdenCompra=true;
	public Boolean cargarid_ejercicioDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleOrdenCompra=null;
	public Boolean mostrarid_periodoDetalleOrdenCompra=true;
	public Boolean activarid_periodoDetalleOrdenCompra=true;
	public Boolean cargarid_periodoDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleOrdenCompra=null;
	public Boolean mostrarid_anioDetalleOrdenCompra=true;
	public Boolean activarid_anioDetalleOrdenCompra=false;
	public Boolean cargarid_anioDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleOrdenCompra=null;
	public Boolean mostrarid_mesDetalleOrdenCompra=true;
	public Boolean activarid_mesDetalleOrdenCompra=false;
	public Boolean cargarid_mesDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleOrdenCompra=null;
	public Boolean mostrarid_bodegaDetalleOrdenCompra=true;
	public Boolean activarid_bodegaDetalleOrdenCompra=true;
	public Boolean cargarid_bodegaDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleOrdenCompra=null;
	public Boolean mostrarid_productoDetalleOrdenCompra=true;
	public Boolean activarid_productoDetalleOrdenCompra=true;
	public Boolean cargarid_productoDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleOrdenCompra=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleOrdenCompra=null;
	public Boolean mostrarid_unidadDetalleOrdenCompra=true;
	public Boolean activarid_unidadDetalleOrdenCompra=true;
	public Boolean cargarid_unidadDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleOrdenCompra=true;//ConEventDepend=true

	public Border resaltardescripcionDetalleOrdenCompra=null;
	public Boolean mostrardescripcionDetalleOrdenCompra=true;
	public Boolean activardescripcionDetalleOrdenCompra=true;

	public Border resaltarcantidadDetalleOrdenCompra=null;
	public Boolean mostrarcantidadDetalleOrdenCompra=true;
	public Boolean activarcantidadDetalleOrdenCompra=true;

	public Border resaltardescuentoDetalleOrdenCompra=null;
	public Boolean mostrardescuentoDetalleOrdenCompra=true;
	public Boolean activardescuentoDetalleOrdenCompra=false;

	public Border resaltarcosto_unitarioDetalleOrdenCompra=null;
	public Boolean mostrarcosto_unitarioDetalleOrdenCompra=true;
	public Boolean activarcosto_unitarioDetalleOrdenCompra=true;

	public Border resaltarivaDetalleOrdenCompra=null;
	public Boolean mostrarivaDetalleOrdenCompra=true;
	public Boolean activarivaDetalleOrdenCompra=true;

	public Border resaltariva_valorDetalleOrdenCompra=null;
	public Boolean mostrariva_valorDetalleOrdenCompra=true;
	public Boolean activariva_valorDetalleOrdenCompra=true;

	public Border resaltarcosto_totalDetalleOrdenCompra=null;
	public Boolean mostrarcosto_totalDetalleOrdenCompra=true;
	public Boolean activarcosto_totalDetalleOrdenCompra=true;

	public Border resaltardisponibleDetalleOrdenCompra=null;
	public Boolean mostrardisponibleDetalleOrdenCompra=true;
	public Boolean activardisponibleDetalleOrdenCompra=true;

	public Border resaltarid_novedad_productoDetalleOrdenCompra=null;
	public Boolean mostrarid_novedad_productoDetalleOrdenCompra=true;
	public Boolean activarid_novedad_productoDetalleOrdenCompra=true;
	public Boolean cargarid_novedad_productoDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_orden_compraDetalleOrdenCompra=null;
	public Boolean mostrarid_estado_detalle_orden_compraDetalleOrdenCompra=true;
	public Boolean activarid_estado_detalle_orden_compraDetalleOrdenCompra=false;
	public Boolean cargarid_estado_detalle_orden_compraDetalleOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_orden_compraDetalleOrdenCompra=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteDetalleOrdenCompra=null;
	public Boolean mostrarnumero_comprobanteDetalleOrdenCompra=true;
	public Boolean activarnumero_comprobanteDetalleOrdenCompra=false;

	public Border resaltarlote_clienteDetalleOrdenCompra=null;
	public Boolean mostrarlote_clienteDetalleOrdenCompra=true;
	public Boolean activarlote_clienteDetalleOrdenCompra=false;

	
	

	public Border setResaltaridDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleOrdenCompra() {
		return this.resaltaridDetalleOrdenCompra;
	}

	public void setResaltaridDetalleOrdenCompra(Border borderResaltar) {
		this.resaltaridDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostraridDetalleOrdenCompra() {
		return this.mostraridDetalleOrdenCompra;
	}

	public void setMostraridDetalleOrdenCompra(Boolean mostraridDetalleOrdenCompra) {
		this.mostraridDetalleOrdenCompra= mostraridDetalleOrdenCompra;
	}

	public Boolean getActivaridDetalleOrdenCompra() {
		return this.activaridDetalleOrdenCompra;
	}

	public void setActivaridDetalleOrdenCompra(Boolean activaridDetalleOrdenCompra) {
		this.activaridDetalleOrdenCompra= activaridDetalleOrdenCompra;
	}

	public Border setResaltarid_orden_compraDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_orden_compraDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_compraDetalleOrdenCompra() {
		return this.resaltarid_orden_compraDetalleOrdenCompra;
	}

	public void setResaltarid_orden_compraDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_orden_compraDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_orden_compraDetalleOrdenCompra() {
		return this.mostrarid_orden_compraDetalleOrdenCompra;
	}

	public void setMostrarid_orden_compraDetalleOrdenCompra(Boolean mostrarid_orden_compraDetalleOrdenCompra) {
		this.mostrarid_orden_compraDetalleOrdenCompra= mostrarid_orden_compraDetalleOrdenCompra;
	}

	public Boolean getActivarid_orden_compraDetalleOrdenCompra() {
		return this.activarid_orden_compraDetalleOrdenCompra;
	}

	public void setActivarid_orden_compraDetalleOrdenCompra(Boolean activarid_orden_compraDetalleOrdenCompra) {
		this.activarid_orden_compraDetalleOrdenCompra= activarid_orden_compraDetalleOrdenCompra;
	}

	public Boolean getCargarid_orden_compraDetalleOrdenCompra() {
		return this.cargarid_orden_compraDetalleOrdenCompra;
	}

	public void setCargarid_orden_compraDetalleOrdenCompra(Boolean cargarid_orden_compraDetalleOrdenCompra) {
		this.cargarid_orden_compraDetalleOrdenCompra= cargarid_orden_compraDetalleOrdenCompra;
	}

	public Border setResaltarid_empresaDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleOrdenCompra() {
		return this.resaltarid_empresaDetalleOrdenCompra;
	}

	public void setResaltarid_empresaDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_empresaDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleOrdenCompra() {
		return this.mostrarid_empresaDetalleOrdenCompra;
	}

	public void setMostrarid_empresaDetalleOrdenCompra(Boolean mostrarid_empresaDetalleOrdenCompra) {
		this.mostrarid_empresaDetalleOrdenCompra= mostrarid_empresaDetalleOrdenCompra;
	}

	public Boolean getActivarid_empresaDetalleOrdenCompra() {
		return this.activarid_empresaDetalleOrdenCompra;
	}

	public void setActivarid_empresaDetalleOrdenCompra(Boolean activarid_empresaDetalleOrdenCompra) {
		this.activarid_empresaDetalleOrdenCompra= activarid_empresaDetalleOrdenCompra;
	}

	public Boolean getCargarid_empresaDetalleOrdenCompra() {
		return this.cargarid_empresaDetalleOrdenCompra;
	}

	public void setCargarid_empresaDetalleOrdenCompra(Boolean cargarid_empresaDetalleOrdenCompra) {
		this.cargarid_empresaDetalleOrdenCompra= cargarid_empresaDetalleOrdenCompra;
	}

	public Border setResaltarid_sucursalDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleOrdenCompra() {
		return this.resaltarid_sucursalDetalleOrdenCompra;
	}

	public void setResaltarid_sucursalDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_sucursalDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleOrdenCompra() {
		return this.mostrarid_sucursalDetalleOrdenCompra;
	}

	public void setMostrarid_sucursalDetalleOrdenCompra(Boolean mostrarid_sucursalDetalleOrdenCompra) {
		this.mostrarid_sucursalDetalleOrdenCompra= mostrarid_sucursalDetalleOrdenCompra;
	}

	public Boolean getActivarid_sucursalDetalleOrdenCompra() {
		return this.activarid_sucursalDetalleOrdenCompra;
	}

	public void setActivarid_sucursalDetalleOrdenCompra(Boolean activarid_sucursalDetalleOrdenCompra) {
		this.activarid_sucursalDetalleOrdenCompra= activarid_sucursalDetalleOrdenCompra;
	}

	public Boolean getCargarid_sucursalDetalleOrdenCompra() {
		return this.cargarid_sucursalDetalleOrdenCompra;
	}

	public void setCargarid_sucursalDetalleOrdenCompra(Boolean cargarid_sucursalDetalleOrdenCompra) {
		this.cargarid_sucursalDetalleOrdenCompra= cargarid_sucursalDetalleOrdenCompra;
	}

	public Border setResaltarid_ejercicioDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleOrdenCompra() {
		return this.resaltarid_ejercicioDetalleOrdenCompra;
	}

	public void setResaltarid_ejercicioDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleOrdenCompra() {
		return this.mostrarid_ejercicioDetalleOrdenCompra;
	}

	public void setMostrarid_ejercicioDetalleOrdenCompra(Boolean mostrarid_ejercicioDetalleOrdenCompra) {
		this.mostrarid_ejercicioDetalleOrdenCompra= mostrarid_ejercicioDetalleOrdenCompra;
	}

	public Boolean getActivarid_ejercicioDetalleOrdenCompra() {
		return this.activarid_ejercicioDetalleOrdenCompra;
	}

	public void setActivarid_ejercicioDetalleOrdenCompra(Boolean activarid_ejercicioDetalleOrdenCompra) {
		this.activarid_ejercicioDetalleOrdenCompra= activarid_ejercicioDetalleOrdenCompra;
	}

	public Boolean getCargarid_ejercicioDetalleOrdenCompra() {
		return this.cargarid_ejercicioDetalleOrdenCompra;
	}

	public void setCargarid_ejercicioDetalleOrdenCompra(Boolean cargarid_ejercicioDetalleOrdenCompra) {
		this.cargarid_ejercicioDetalleOrdenCompra= cargarid_ejercicioDetalleOrdenCompra;
	}

	public Border setResaltarid_periodoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleOrdenCompra() {
		return this.resaltarid_periodoDetalleOrdenCompra;
	}

	public void setResaltarid_periodoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_periodoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleOrdenCompra() {
		return this.mostrarid_periodoDetalleOrdenCompra;
	}

	public void setMostrarid_periodoDetalleOrdenCompra(Boolean mostrarid_periodoDetalleOrdenCompra) {
		this.mostrarid_periodoDetalleOrdenCompra= mostrarid_periodoDetalleOrdenCompra;
	}

	public Boolean getActivarid_periodoDetalleOrdenCompra() {
		return this.activarid_periodoDetalleOrdenCompra;
	}

	public void setActivarid_periodoDetalleOrdenCompra(Boolean activarid_periodoDetalleOrdenCompra) {
		this.activarid_periodoDetalleOrdenCompra= activarid_periodoDetalleOrdenCompra;
	}

	public Boolean getCargarid_periodoDetalleOrdenCompra() {
		return this.cargarid_periodoDetalleOrdenCompra;
	}

	public void setCargarid_periodoDetalleOrdenCompra(Boolean cargarid_periodoDetalleOrdenCompra) {
		this.cargarid_periodoDetalleOrdenCompra= cargarid_periodoDetalleOrdenCompra;
	}

	public Border setResaltarid_anioDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleOrdenCompra() {
		return this.resaltarid_anioDetalleOrdenCompra;
	}

	public void setResaltarid_anioDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_anioDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleOrdenCompra() {
		return this.mostrarid_anioDetalleOrdenCompra;
	}

	public void setMostrarid_anioDetalleOrdenCompra(Boolean mostrarid_anioDetalleOrdenCompra) {
		this.mostrarid_anioDetalleOrdenCompra= mostrarid_anioDetalleOrdenCompra;
	}

	public Boolean getActivarid_anioDetalleOrdenCompra() {
		return this.activarid_anioDetalleOrdenCompra;
	}

	public void setActivarid_anioDetalleOrdenCompra(Boolean activarid_anioDetalleOrdenCompra) {
		this.activarid_anioDetalleOrdenCompra= activarid_anioDetalleOrdenCompra;
	}

	public Boolean getCargarid_anioDetalleOrdenCompra() {
		return this.cargarid_anioDetalleOrdenCompra;
	}

	public void setCargarid_anioDetalleOrdenCompra(Boolean cargarid_anioDetalleOrdenCompra) {
		this.cargarid_anioDetalleOrdenCompra= cargarid_anioDetalleOrdenCompra;
	}

	public Border setResaltarid_mesDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleOrdenCompra() {
		return this.resaltarid_mesDetalleOrdenCompra;
	}

	public void setResaltarid_mesDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_mesDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleOrdenCompra() {
		return this.mostrarid_mesDetalleOrdenCompra;
	}

	public void setMostrarid_mesDetalleOrdenCompra(Boolean mostrarid_mesDetalleOrdenCompra) {
		this.mostrarid_mesDetalleOrdenCompra= mostrarid_mesDetalleOrdenCompra;
	}

	public Boolean getActivarid_mesDetalleOrdenCompra() {
		return this.activarid_mesDetalleOrdenCompra;
	}

	public void setActivarid_mesDetalleOrdenCompra(Boolean activarid_mesDetalleOrdenCompra) {
		this.activarid_mesDetalleOrdenCompra= activarid_mesDetalleOrdenCompra;
	}

	public Boolean getCargarid_mesDetalleOrdenCompra() {
		return this.cargarid_mesDetalleOrdenCompra;
	}

	public void setCargarid_mesDetalleOrdenCompra(Boolean cargarid_mesDetalleOrdenCompra) {
		this.cargarid_mesDetalleOrdenCompra= cargarid_mesDetalleOrdenCompra;
	}

	public Border setResaltarid_bodegaDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_bodegaDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleOrdenCompra() {
		return this.resaltarid_bodegaDetalleOrdenCompra;
	}

	public void setResaltarid_bodegaDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_bodegaDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleOrdenCompra() {
		return this.mostrarid_bodegaDetalleOrdenCompra;
	}

	public void setMostrarid_bodegaDetalleOrdenCompra(Boolean mostrarid_bodegaDetalleOrdenCompra) {
		this.mostrarid_bodegaDetalleOrdenCompra= mostrarid_bodegaDetalleOrdenCompra;
	}

	public Boolean getActivarid_bodegaDetalleOrdenCompra() {
		return this.activarid_bodegaDetalleOrdenCompra;
	}

	public void setActivarid_bodegaDetalleOrdenCompra(Boolean activarid_bodegaDetalleOrdenCompra) {
		this.activarid_bodegaDetalleOrdenCompra= activarid_bodegaDetalleOrdenCompra;
	}

	public Boolean getCargarid_bodegaDetalleOrdenCompra() {
		return this.cargarid_bodegaDetalleOrdenCompra;
	}

	public void setCargarid_bodegaDetalleOrdenCompra(Boolean cargarid_bodegaDetalleOrdenCompra) {
		this.cargarid_bodegaDetalleOrdenCompra= cargarid_bodegaDetalleOrdenCompra;
	}

	public Border setResaltarid_productoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_productoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleOrdenCompra() {
		return this.resaltarid_productoDetalleOrdenCompra;
	}

	public void setResaltarid_productoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_productoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleOrdenCompra() {
		return this.mostrarid_productoDetalleOrdenCompra;
	}

	public void setMostrarid_productoDetalleOrdenCompra(Boolean mostrarid_productoDetalleOrdenCompra) {
		this.mostrarid_productoDetalleOrdenCompra= mostrarid_productoDetalleOrdenCompra;
	}

	public Boolean getActivarid_productoDetalleOrdenCompra() {
		return this.activarid_productoDetalleOrdenCompra;
	}

	public void setActivarid_productoDetalleOrdenCompra(Boolean activarid_productoDetalleOrdenCompra) {
		this.activarid_productoDetalleOrdenCompra= activarid_productoDetalleOrdenCompra;
	}

	public Boolean getCargarid_productoDetalleOrdenCompra() {
		return this.cargarid_productoDetalleOrdenCompra;
	}

	public void setCargarid_productoDetalleOrdenCompra(Boolean cargarid_productoDetalleOrdenCompra) {
		this.cargarid_productoDetalleOrdenCompra= cargarid_productoDetalleOrdenCompra;
	}

	public Border setResaltarid_unidadDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_unidadDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleOrdenCompra() {
		return this.resaltarid_unidadDetalleOrdenCompra;
	}

	public void setResaltarid_unidadDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_unidadDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleOrdenCompra() {
		return this.mostrarid_unidadDetalleOrdenCompra;
	}

	public void setMostrarid_unidadDetalleOrdenCompra(Boolean mostrarid_unidadDetalleOrdenCompra) {
		this.mostrarid_unidadDetalleOrdenCompra= mostrarid_unidadDetalleOrdenCompra;
	}

	public Boolean getActivarid_unidadDetalleOrdenCompra() {
		return this.activarid_unidadDetalleOrdenCompra;
	}

	public void setActivarid_unidadDetalleOrdenCompra(Boolean activarid_unidadDetalleOrdenCompra) {
		this.activarid_unidadDetalleOrdenCompra= activarid_unidadDetalleOrdenCompra;
	}

	public Boolean getCargarid_unidadDetalleOrdenCompra() {
		return this.cargarid_unidadDetalleOrdenCompra;
	}

	public void setCargarid_unidadDetalleOrdenCompra(Boolean cargarid_unidadDetalleOrdenCompra) {
		this.cargarid_unidadDetalleOrdenCompra= cargarid_unidadDetalleOrdenCompra;
	}

	public Border setResaltardescripcionDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltardescripcionDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleOrdenCompra() {
		return this.resaltardescripcionDetalleOrdenCompra;
	}

	public void setResaltardescripcionDetalleOrdenCompra(Border borderResaltar) {
		this.resaltardescripcionDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleOrdenCompra() {
		return this.mostrardescripcionDetalleOrdenCompra;
	}

	public void setMostrardescripcionDetalleOrdenCompra(Boolean mostrardescripcionDetalleOrdenCompra) {
		this.mostrardescripcionDetalleOrdenCompra= mostrardescripcionDetalleOrdenCompra;
	}

	public Boolean getActivardescripcionDetalleOrdenCompra() {
		return this.activardescripcionDetalleOrdenCompra;
	}

	public void setActivardescripcionDetalleOrdenCompra(Boolean activardescripcionDetalleOrdenCompra) {
		this.activardescripcionDetalleOrdenCompra= activardescripcionDetalleOrdenCompra;
	}

	public Border setResaltarcantidadDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarcantidadDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleOrdenCompra() {
		return this.resaltarcantidadDetalleOrdenCompra;
	}

	public void setResaltarcantidadDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarcantidadDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleOrdenCompra() {
		return this.mostrarcantidadDetalleOrdenCompra;
	}

	public void setMostrarcantidadDetalleOrdenCompra(Boolean mostrarcantidadDetalleOrdenCompra) {
		this.mostrarcantidadDetalleOrdenCompra= mostrarcantidadDetalleOrdenCompra;
	}

	public Boolean getActivarcantidadDetalleOrdenCompra() {
		return this.activarcantidadDetalleOrdenCompra;
	}

	public void setActivarcantidadDetalleOrdenCompra(Boolean activarcantidadDetalleOrdenCompra) {
		this.activarcantidadDetalleOrdenCompra= activarcantidadDetalleOrdenCompra;
	}

	public Border setResaltardescuentoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltardescuentoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleOrdenCompra() {
		return this.resaltardescuentoDetalleOrdenCompra;
	}

	public void setResaltardescuentoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltardescuentoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleOrdenCompra() {
		return this.mostrardescuentoDetalleOrdenCompra;
	}

	public void setMostrardescuentoDetalleOrdenCompra(Boolean mostrardescuentoDetalleOrdenCompra) {
		this.mostrardescuentoDetalleOrdenCompra= mostrardescuentoDetalleOrdenCompra;
	}

	public Boolean getActivardescuentoDetalleOrdenCompra() {
		return this.activardescuentoDetalleOrdenCompra;
	}

	public void setActivardescuentoDetalleOrdenCompra(Boolean activardescuentoDetalleOrdenCompra) {
		this.activardescuentoDetalleOrdenCompra= activardescuentoDetalleOrdenCompra;
	}

	public Border setResaltarcosto_unitarioDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarcosto_unitarioDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleOrdenCompra() {
		return this.resaltarcosto_unitarioDetalleOrdenCompra;
	}

	public void setResaltarcosto_unitarioDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleOrdenCompra() {
		return this.mostrarcosto_unitarioDetalleOrdenCompra;
	}

	public void setMostrarcosto_unitarioDetalleOrdenCompra(Boolean mostrarcosto_unitarioDetalleOrdenCompra) {
		this.mostrarcosto_unitarioDetalleOrdenCompra= mostrarcosto_unitarioDetalleOrdenCompra;
	}

	public Boolean getActivarcosto_unitarioDetalleOrdenCompra() {
		return this.activarcosto_unitarioDetalleOrdenCompra;
	}

	public void setActivarcosto_unitarioDetalleOrdenCompra(Boolean activarcosto_unitarioDetalleOrdenCompra) {
		this.activarcosto_unitarioDetalleOrdenCompra= activarcosto_unitarioDetalleOrdenCompra;
	}

	public Border setResaltarivaDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarivaDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleOrdenCompra() {
		return this.resaltarivaDetalleOrdenCompra;
	}

	public void setResaltarivaDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarivaDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarivaDetalleOrdenCompra() {
		return this.mostrarivaDetalleOrdenCompra;
	}

	public void setMostrarivaDetalleOrdenCompra(Boolean mostrarivaDetalleOrdenCompra) {
		this.mostrarivaDetalleOrdenCompra= mostrarivaDetalleOrdenCompra;
	}

	public Boolean getActivarivaDetalleOrdenCompra() {
		return this.activarivaDetalleOrdenCompra;
	}

	public void setActivarivaDetalleOrdenCompra(Boolean activarivaDetalleOrdenCompra) {
		this.activarivaDetalleOrdenCompra= activarivaDetalleOrdenCompra;
	}

	public Border setResaltariva_valorDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltariva_valorDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleOrdenCompra() {
		return this.resaltariva_valorDetalleOrdenCompra;
	}

	public void setResaltariva_valorDetalleOrdenCompra(Border borderResaltar) {
		this.resaltariva_valorDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleOrdenCompra() {
		return this.mostrariva_valorDetalleOrdenCompra;
	}

	public void setMostrariva_valorDetalleOrdenCompra(Boolean mostrariva_valorDetalleOrdenCompra) {
		this.mostrariva_valorDetalleOrdenCompra= mostrariva_valorDetalleOrdenCompra;
	}

	public Boolean getActivariva_valorDetalleOrdenCompra() {
		return this.activariva_valorDetalleOrdenCompra;
	}

	public void setActivariva_valorDetalleOrdenCompra(Boolean activariva_valorDetalleOrdenCompra) {
		this.activariva_valorDetalleOrdenCompra= activariva_valorDetalleOrdenCompra;
	}

	public Border setResaltarcosto_totalDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarcosto_totalDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleOrdenCompra() {
		return this.resaltarcosto_totalDetalleOrdenCompra;
	}

	public void setResaltarcosto_totalDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarcosto_totalDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleOrdenCompra() {
		return this.mostrarcosto_totalDetalleOrdenCompra;
	}

	public void setMostrarcosto_totalDetalleOrdenCompra(Boolean mostrarcosto_totalDetalleOrdenCompra) {
		this.mostrarcosto_totalDetalleOrdenCompra= mostrarcosto_totalDetalleOrdenCompra;
	}

	public Boolean getActivarcosto_totalDetalleOrdenCompra() {
		return this.activarcosto_totalDetalleOrdenCompra;
	}

	public void setActivarcosto_totalDetalleOrdenCompra(Boolean activarcosto_totalDetalleOrdenCompra) {
		this.activarcosto_totalDetalleOrdenCompra= activarcosto_totalDetalleOrdenCompra;
	}

	public Border setResaltardisponibleDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltardisponibleDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleDetalleOrdenCompra() {
		return this.resaltardisponibleDetalleOrdenCompra;
	}

	public void setResaltardisponibleDetalleOrdenCompra(Border borderResaltar) {
		this.resaltardisponibleDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrardisponibleDetalleOrdenCompra() {
		return this.mostrardisponibleDetalleOrdenCompra;
	}

	public void setMostrardisponibleDetalleOrdenCompra(Boolean mostrardisponibleDetalleOrdenCompra) {
		this.mostrardisponibleDetalleOrdenCompra= mostrardisponibleDetalleOrdenCompra;
	}

	public Boolean getActivardisponibleDetalleOrdenCompra() {
		return this.activardisponibleDetalleOrdenCompra;
	}

	public void setActivardisponibleDetalleOrdenCompra(Boolean activardisponibleDetalleOrdenCompra) {
		this.activardisponibleDetalleOrdenCompra= activardisponibleDetalleOrdenCompra;
	}

	public Border setResaltarid_novedad_productoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_novedad_productoDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoDetalleOrdenCompra() {
		return this.resaltarid_novedad_productoDetalleOrdenCompra;
	}

	public void setResaltarid_novedad_productoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_novedad_productoDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoDetalleOrdenCompra() {
		return this.mostrarid_novedad_productoDetalleOrdenCompra;
	}

	public void setMostrarid_novedad_productoDetalleOrdenCompra(Boolean mostrarid_novedad_productoDetalleOrdenCompra) {
		this.mostrarid_novedad_productoDetalleOrdenCompra= mostrarid_novedad_productoDetalleOrdenCompra;
	}

	public Boolean getActivarid_novedad_productoDetalleOrdenCompra() {
		return this.activarid_novedad_productoDetalleOrdenCompra;
	}

	public void setActivarid_novedad_productoDetalleOrdenCompra(Boolean activarid_novedad_productoDetalleOrdenCompra) {
		this.activarid_novedad_productoDetalleOrdenCompra= activarid_novedad_productoDetalleOrdenCompra;
	}

	public Boolean getCargarid_novedad_productoDetalleOrdenCompra() {
		return this.cargarid_novedad_productoDetalleOrdenCompra;
	}

	public void setCargarid_novedad_productoDetalleOrdenCompra(Boolean cargarid_novedad_productoDetalleOrdenCompra) {
		this.cargarid_novedad_productoDetalleOrdenCompra= cargarid_novedad_productoDetalleOrdenCompra;
	}

	public Border setResaltarid_estado_detalle_orden_compraDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_detalle_orden_compraDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_orden_compraDetalleOrdenCompra() {
		return this.resaltarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public void setResaltarid_estado_detalle_orden_compraDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarid_estado_detalle_orden_compraDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_orden_compraDetalleOrdenCompra() {
		return this.mostrarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public void setMostrarid_estado_detalle_orden_compraDetalleOrdenCompra(Boolean mostrarid_estado_detalle_orden_compraDetalleOrdenCompra) {
		this.mostrarid_estado_detalle_orden_compraDetalleOrdenCompra= mostrarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public Boolean getActivarid_estado_detalle_orden_compraDetalleOrdenCompra() {
		return this.activarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public void setActivarid_estado_detalle_orden_compraDetalleOrdenCompra(Boolean activarid_estado_detalle_orden_compraDetalleOrdenCompra) {
		this.activarid_estado_detalle_orden_compraDetalleOrdenCompra= activarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public Boolean getCargarid_estado_detalle_orden_compraDetalleOrdenCompra() {
		return this.cargarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public void setCargarid_estado_detalle_orden_compraDetalleOrdenCompra(Boolean cargarid_estado_detalle_orden_compraDetalleOrdenCompra) {
		this.cargarid_estado_detalle_orden_compraDetalleOrdenCompra= cargarid_estado_detalle_orden_compraDetalleOrdenCompra;
	}

	public Border setResaltarnumero_comprobanteDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleOrdenCompra() {
		return this.resaltarnumero_comprobanteDetalleOrdenCompra;
	}

	public void setResaltarnumero_comprobanteDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleOrdenCompra() {
		return this.mostrarnumero_comprobanteDetalleOrdenCompra;
	}

	public void setMostrarnumero_comprobanteDetalleOrdenCompra(Boolean mostrarnumero_comprobanteDetalleOrdenCompra) {
		this.mostrarnumero_comprobanteDetalleOrdenCompra= mostrarnumero_comprobanteDetalleOrdenCompra;
	}

	public Boolean getActivarnumero_comprobanteDetalleOrdenCompra() {
		return this.activarnumero_comprobanteDetalleOrdenCompra;
	}

	public void setActivarnumero_comprobanteDetalleOrdenCompra(Boolean activarnumero_comprobanteDetalleOrdenCompra) {
		this.activarnumero_comprobanteDetalleOrdenCompra= activarnumero_comprobanteDetalleOrdenCompra;
	}

	public Border setResaltarlote_clienteDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleordencompraBeanSwingJInternalFrame.jTtoolBarDetalleOrdenCompra.setBorder(borderResaltar);
		*/
		this.resaltarlote_clienteDetalleOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleOrdenCompra() {
		return this.resaltarlote_clienteDetalleOrdenCompra;
	}

	public void setResaltarlote_clienteDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarlote_clienteDetalleOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleOrdenCompra() {
		return this.mostrarlote_clienteDetalleOrdenCompra;
	}

	public void setMostrarlote_clienteDetalleOrdenCompra(Boolean mostrarlote_clienteDetalleOrdenCompra) {
		this.mostrarlote_clienteDetalleOrdenCompra= mostrarlote_clienteDetalleOrdenCompra;
	}

	public Boolean getActivarlote_clienteDetalleOrdenCompra() {
		return this.activarlote_clienteDetalleOrdenCompra;
	}

	public void setActivarlote_clienteDetalleOrdenCompra(Boolean activarlote_clienteDetalleOrdenCompra) {
		this.activarlote_clienteDetalleOrdenCompra= activarlote_clienteDetalleOrdenCompra;
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
		
		
		this.setMostraridDetalleOrdenCompra(esInicial);
		this.setMostrarid_orden_compraDetalleOrdenCompra(esInicial);
		this.setMostrarid_empresaDetalleOrdenCompra(esInicial);
		this.setMostrarid_sucursalDetalleOrdenCompra(esInicial);
		this.setMostrarid_ejercicioDetalleOrdenCompra(esInicial);
		this.setMostrarid_periodoDetalleOrdenCompra(esInicial);
		this.setMostrarid_anioDetalleOrdenCompra(esInicial);
		this.setMostrarid_mesDetalleOrdenCompra(esInicial);
		this.setMostrarid_bodegaDetalleOrdenCompra(esInicial);
		this.setMostrarid_productoDetalleOrdenCompra(esInicial);
		this.setMostrarid_unidadDetalleOrdenCompra(esInicial);
		this.setMostrardescripcionDetalleOrdenCompra(esInicial);
		this.setMostrarcantidadDetalleOrdenCompra(esInicial);
		this.setMostrardescuentoDetalleOrdenCompra(esInicial);
		this.setMostrarcosto_unitarioDetalleOrdenCompra(esInicial);
		this.setMostrarivaDetalleOrdenCompra(esInicial);
		this.setMostrariva_valorDetalleOrdenCompra(esInicial);
		this.setMostrarcosto_totalDetalleOrdenCompra(esInicial);
		this.setMostrardisponibleDetalleOrdenCompra(esInicial);
		this.setMostrarid_novedad_productoDetalleOrdenCompra(esInicial);
		this.setMostrarid_estado_detalle_orden_compraDetalleOrdenCompra(esInicial);
		this.setMostrarnumero_comprobanteDetalleOrdenCompra(esInicial);
		this.setMostrarlote_clienteDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.ID)) {
				this.setMostraridDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setMostrarid_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA)) {
				this.setMostrarid_estado_detalle_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleOrdenCompra(esAsigna);
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
		
		
		this.setActivaridDetalleOrdenCompra(esInicial);
		this.setActivarid_orden_compraDetalleOrdenCompra(esInicial);
		this.setActivarid_empresaDetalleOrdenCompra(esInicial);
		this.setActivarid_sucursalDetalleOrdenCompra(esInicial);
		this.setActivarid_ejercicioDetalleOrdenCompra(esInicial);
		this.setActivarid_periodoDetalleOrdenCompra(esInicial);
		this.setActivarid_anioDetalleOrdenCompra(esInicial);
		this.setActivarid_mesDetalleOrdenCompra(esInicial);
		this.setActivarid_bodegaDetalleOrdenCompra(esInicial);
		this.setActivarid_productoDetalleOrdenCompra(esInicial);
		this.setActivarid_unidadDetalleOrdenCompra(esInicial);
		this.setActivardescripcionDetalleOrdenCompra(esInicial);
		this.setActivarcantidadDetalleOrdenCompra(esInicial);
		this.setActivardescuentoDetalleOrdenCompra(esInicial);
		this.setActivarcosto_unitarioDetalleOrdenCompra(esInicial);
		this.setActivarivaDetalleOrdenCompra(esInicial);
		this.setActivariva_valorDetalleOrdenCompra(esInicial);
		this.setActivarcosto_totalDetalleOrdenCompra(esInicial);
		this.setActivardisponibleDetalleOrdenCompra(esInicial);
		this.setActivarid_novedad_productoDetalleOrdenCompra(esInicial);
		this.setActivarid_estado_detalle_orden_compraDetalleOrdenCompra(esInicial);
		this.setActivarnumero_comprobanteDetalleOrdenCompra(esInicial);
		this.setActivarlote_clienteDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.ID)) {
				this.setActivaridDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setActivarid_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVA)) {
				this.setActivarivaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA)) {
				this.setActivarid_estado_detalle_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleOrdenCompra(esInicial);
		this.setResaltarid_orden_compraDetalleOrdenCompra(esInicial);
		this.setResaltarid_empresaDetalleOrdenCompra(esInicial);
		this.setResaltarid_sucursalDetalleOrdenCompra(esInicial);
		this.setResaltarid_ejercicioDetalleOrdenCompra(esInicial);
		this.setResaltarid_periodoDetalleOrdenCompra(esInicial);
		this.setResaltarid_anioDetalleOrdenCompra(esInicial);
		this.setResaltarid_mesDetalleOrdenCompra(esInicial);
		this.setResaltarid_bodegaDetalleOrdenCompra(esInicial);
		this.setResaltarid_productoDetalleOrdenCompra(esInicial);
		this.setResaltarid_unidadDetalleOrdenCompra(esInicial);
		this.setResaltardescripcionDetalleOrdenCompra(esInicial);
		this.setResaltarcantidadDetalleOrdenCompra(esInicial);
		this.setResaltardescuentoDetalleOrdenCompra(esInicial);
		this.setResaltarcosto_unitarioDetalleOrdenCompra(esInicial);
		this.setResaltarivaDetalleOrdenCompra(esInicial);
		this.setResaltariva_valorDetalleOrdenCompra(esInicial);
		this.setResaltarcosto_totalDetalleOrdenCompra(esInicial);
		this.setResaltardisponibleDetalleOrdenCompra(esInicial);
		this.setResaltarid_novedad_productoDetalleOrdenCompra(esInicial);
		this.setResaltarid_estado_detalle_orden_compraDetalleOrdenCompra(esInicial);
		this.setResaltarnumero_comprobanteDetalleOrdenCompra(esInicial);
		this.setResaltarlote_clienteDetalleOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.ID)) {
				this.setResaltaridDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setResaltarid_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA)) {
				this.setResaltarid_estado_detalle_orden_compraDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleOrdenCompraConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleOrdenCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdBodegaDetalleOrdenCompra() {
		return this.mostrarFK_IdBodegaDetalleOrdenCompra;
	}

	public void setMostrarFK_IdBodegaDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdEjercicioDetalleOrdenCompra() {
		return this.mostrarFK_IdEjercicioDetalleOrdenCompra;
	}

	public void setMostrarFK_IdEjercicioDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdEmpresaDetalleOrdenCompra() {
		return this.mostrarFK_IdEmpresaDetalleOrdenCompra;
	}

	public void setMostrarFK_IdEmpresaDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra() {
		return this.mostrarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra;
	}

	public void setMostrarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdNovedadProductoDetalleOrdenCompra() {
		return this.mostrarFK_IdNovedadProductoDetalleOrdenCompra;
	}

	public void setMostrarFK_IdNovedadProductoDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenCompraDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdOrdenCompraDetalleOrdenCompra() {
		return this.mostrarFK_IdOrdenCompraDetalleOrdenCompra;
	}

	public void setMostrarFK_IdOrdenCompraDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenCompraDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdPeriodoDetalleOrdenCompra() {
		return this.mostrarFK_IdPeriodoDetalleOrdenCompra;
	}

	public void setMostrarFK_IdPeriodoDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdProductoDetalleOrdenCompra() {
		return this.mostrarFK_IdProductoDetalleOrdenCompra;
	}

	public void setMostrarFK_IdProductoDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdSucursalDetalleOrdenCompra() {
		return this.mostrarFK_IdSucursalDetalleOrdenCompra;
	}

	public void setMostrarFK_IdSucursalDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleOrdenCompra=true;

	public Boolean getMostrarFK_IdUnidadDetalleOrdenCompra() {
		return this.mostrarFK_IdUnidadDetalleOrdenCompra;
	}

	public void setMostrarFK_IdUnidadDetalleOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleOrdenCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdBodegaDetalleOrdenCompra() {
		return this.activarFK_IdBodegaDetalleOrdenCompra;
	}

	public void setActivarFK_IdBodegaDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdEjercicioDetalleOrdenCompra() {
		return this.activarFK_IdEjercicioDetalleOrdenCompra;
	}

	public void setActivarFK_IdEjercicioDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdEmpresaDetalleOrdenCompra() {
		return this.activarFK_IdEmpresaDetalleOrdenCompra;
	}

	public void setActivarFK_IdEmpresaDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra() {
		return this.activarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra;
	}

	public void setActivarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdNovedadProductoDetalleOrdenCompra() {
		return this.activarFK_IdNovedadProductoDetalleOrdenCompra;
	}

	public void setActivarFK_IdNovedadProductoDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenCompraDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdOrdenCompraDetalleOrdenCompra() {
		return this.activarFK_IdOrdenCompraDetalleOrdenCompra;
	}

	public void setActivarFK_IdOrdenCompraDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenCompraDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdPeriodoDetalleOrdenCompra() {
		return this.activarFK_IdPeriodoDetalleOrdenCompra;
	}

	public void setActivarFK_IdPeriodoDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdProductoDetalleOrdenCompra() {
		return this.activarFK_IdProductoDetalleOrdenCompra;
	}

	public void setActivarFK_IdProductoDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdSucursalDetalleOrdenCompra() {
		return this.activarFK_IdSucursalDetalleOrdenCompra;
	}

	public void setActivarFK_IdSucursalDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleOrdenCompra=true;

	public Boolean getActivarFK_IdUnidadDetalleOrdenCompra() {
		return this.activarFK_IdUnidadDetalleOrdenCompra;
	}

	public void setActivarFK_IdUnidadDetalleOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleOrdenCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleOrdenCompra=null;

	public Border getResaltarFK_IdBodegaDetalleOrdenCompra() {
		return this.resaltarFK_IdBodegaDetalleOrdenCompra;
	}

	public void setResaltarFK_IdBodegaDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleOrdenCompra=null;

	public Border getResaltarFK_IdEjercicioDetalleOrdenCompra() {
		return this.resaltarFK_IdEjercicioDetalleOrdenCompra;
	}

	public void setResaltarFK_IdEjercicioDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleOrdenCompra=null;

	public Border getResaltarFK_IdEmpresaDetalleOrdenCompra() {
		return this.resaltarFK_IdEmpresaDetalleOrdenCompra;
	}

	public void setResaltarFK_IdEmpresaDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra=null;

	public Border getResaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra() {
		return this.resaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra;
	}

	public void setResaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleOrdenCompraDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoDetalleOrdenCompra=null;

	public Border getResaltarFK_IdNovedadProductoDetalleOrdenCompra() {
		return this.resaltarFK_IdNovedadProductoDetalleOrdenCompra;
	}

	public void setResaltarFK_IdNovedadProductoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdOrdenCompraDetalleOrdenCompra=null;

	public Border getResaltarFK_IdOrdenCompraDetalleOrdenCompra() {
		return this.resaltarFK_IdOrdenCompraDetalleOrdenCompra;
	}

	public void setResaltarFK_IdOrdenCompraDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdOrdenCompraDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdOrdenCompraDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenCompraDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleOrdenCompra=null;

	public Border getResaltarFK_IdPeriodoDetalleOrdenCompra() {
		return this.resaltarFK_IdPeriodoDetalleOrdenCompra;
	}

	public void setResaltarFK_IdPeriodoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleOrdenCompra=null;

	public Border getResaltarFK_IdProductoDetalleOrdenCompra() {
		return this.resaltarFK_IdProductoDetalleOrdenCompra;
	}

	public void setResaltarFK_IdProductoDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleOrdenCompra=null;

	public Border getResaltarFK_IdSucursalDetalleOrdenCompra() {
		return this.resaltarFK_IdSucursalDetalleOrdenCompra;
	}

	public void setResaltarFK_IdSucursalDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleOrdenCompra=null;

	public Border getResaltarFK_IdUnidadDetalleOrdenCompra() {
		return this.resaltarFK_IdUnidadDetalleOrdenCompra;
	}

	public void setResaltarFK_IdUnidadDetalleOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleOrdenCompraBeanSwingJInternalFrame detalleordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleOrdenCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}