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


import com.bydan.erp.facturacion.util.DetalleConsignacionConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleConsignacionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleConsignacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleConsignacionConstantesFunciones extends DetalleConsignacionConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=150;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=150;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=150 + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=150 + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
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
	public static final String SNOMBREOPCION="DetalleConsignacion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleConsignacion"+DetalleConsignacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleConsignacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleConsignacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleConsignacionConstantesFunciones.SCHEMA+"_"+DetalleConsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleConsignacionConstantesFunciones.SCHEMA+"_"+DetalleConsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleConsignacionConstantesFunciones.SCHEMA+"_"+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleConsignacionConstantesFunciones.SCHEMA+"_"+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleConsignacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleConsignacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleConsignacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleConsignacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Consignacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Consignacion";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Consignacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleConsignacion";
	public static final String OBJECTNAME="detalleconsignacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_consignacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleconsignacion from "+DetalleConsignacionConstantesFunciones.SPERSISTENCENAME+" detalleconsignacion";
	public static String QUERYSELECTNATIVE="select "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".version_row,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_anio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_mes,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_consignacion,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_producto,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".id_estado_detalle_pedido,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".cantidad,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".precio,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".iva,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".total,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".ice,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".costo,"+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME+".utilidad from "+DetalleConsignacionConstantesFunciones.SCHEMA+"."+DetalleConsignacionConstantesFunciones.TABLENAME;//+" as "+DetalleConsignacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleConsignacionConstantesFuncionesAdditional detalleconsignacionConstantesFuncionesAdditional=null;
	
	public DetalleConsignacionConstantesFuncionesAdditional getDetalleConsignacionConstantesFuncionesAdditional() {
		return this.detalleconsignacionConstantesFuncionesAdditional;
	}
	
	public void setDetalleConsignacionConstantesFuncionesAdditional(DetalleConsignacionConstantesFuncionesAdditional detalleconsignacionConstantesFuncionesAdditional) {
		try {
			this.detalleconsignacionConstantesFuncionesAdditional=detalleconsignacionConstantesFuncionesAdditional;
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
    public static final String IDCONSIGNACION= "id_consignacion";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDESTADODETALLEPEDIDO= "id_estado_detalle_pedido";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String IVA= "iva";
    public static final String TOTAL= "total";
    public static final String ICE= "ice";
    public static final String COSTO= "costo";
    public static final String UTILIDAD= "utilidad";
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
    	public static final String LABEL_IDCONSIGNACION= "Consignacion";
		public static final String LABEL_IDCONSIGNACION_LOWER= "Consignacion";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDESTADODETALLEPEDIDO= "Estado";
		public static final String LABEL_IDESTADODETALLEPEDIDO_LOWER= "Estado Detalle Pedido";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_UTILIDAD= "Utilidad";
		public static final String LABEL_UTILIDAD_LOWER= "Utilidad";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleConsignacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDANIO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDMES)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDCONSIGNACION)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDCONSIGNACION;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.PRECIO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.IVA)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.TOTAL)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.ICE)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.COSTO)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetalleConsignacionConstantesFunciones.UTILIDAD)) {sLabelColumna=DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleConsignacionDescripcion(DetalleConsignacion detalleconsignacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleconsignacion !=null/* && detalleconsignacion.getId()!=0*/) {
			if(detalleconsignacion.getId()!=null) {
				sDescripcion=detalleconsignacion.getId().toString();
			}//detalleconsignaciondetalleconsignacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleConsignacionDescripcionDetallado(DetalleConsignacion detalleconsignacion) {
		String sDescripcion="";
			
		sDescripcion+=DetalleConsignacionConstantesFunciones.ID+"=";
		sDescripcion+=detalleconsignacion.getId().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleconsignacion.getVersionRow().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleconsignacion.getid_empresa().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleconsignacion.getid_sucursal().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleconsignacion.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleconsignacion.getid_periodo().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleconsignacion.getid_anio().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleconsignacion.getid_mes().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDCONSIGNACION+"=";
		sDescripcion+=detalleconsignacion.getid_consignacion().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleconsignacion.getid_producto().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleconsignacion.getid_bodega().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleconsignacion.getid_unidad().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO+"=";
		sDescripcion+=detalleconsignacion.getid_estado_detalle_pedido().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleconsignacion.getcantidad().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.PRECIO+"=";
		sDescripcion+=detalleconsignacion.getprecio().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=detalleconsignacion.getdescuento_porcentaje().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detalleconsignacion.getdescuento_valor().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.IVA+"=";
		sDescripcion+=detalleconsignacion.getiva().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.TOTAL+"=";
		sDescripcion+=detalleconsignacion.gettotal().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.ICE+"=";
		sDescripcion+=detalleconsignacion.getice().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.COSTO+"=";
		sDescripcion+=detalleconsignacion.getcosto().toString()+",";
		sDescripcion+=DetalleConsignacionConstantesFunciones.UTILIDAD+"=";
		sDescripcion+=detalleconsignacion.getutilidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleConsignacionDescripcion(DetalleConsignacion detalleconsignacion,String sValor) throws Exception {			
		if(detalleconsignacion !=null) {
			//detalleconsignaciondetalleconsignacion.getId().toString();
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

	public static String getConsignacionDescripcion(Consignacion consignacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(consignacion!=null/*&&consignacion.getId()>0*/) {
			sDescripcion=ConsignacionConstantesFunciones.getConsignacionDescripcion(consignacion);
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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

	public static String getEstadoDetallePedidoDescripcion(EstadoDetallePedido estadodetallepedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetallepedido!=null/*&&estadodetallepedido.getId()>0*/) {
			sDescripcion=EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(estadodetallepedido);
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
		} else if(sNombreIndice.equals("FK_IdConsignacion")) {
			sNombreIndice="Tipo=  Por Consignacion";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetallePedido")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
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

	public static String getDetalleIndiceFK_IdConsignacion(Long id_consignacion) {
		String sDetalleIndice=" Parametros->";
		if(id_consignacion!=null) {sDetalleIndice+=" Codigo Unico De Consignacion="+id_consignacion.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoDetallePedido(Long id_estado_detalle_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleConsignacion(DetalleConsignacion detalleconsignacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleConsignacions(List<DetalleConsignacion> detalleconsignacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleConsignacion detalleconsignacion: detalleconsignacions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleConsignacion(DetalleConsignacion detalleconsignacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleconsignacion.getConCambioAuxiliar()) {
			detalleconsignacion.setIsDeleted(detalleconsignacion.getIsDeletedAuxiliar());	
			detalleconsignacion.setIsNew(detalleconsignacion.getIsNewAuxiliar());	
			detalleconsignacion.setIsChanged(detalleconsignacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleconsignacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleconsignacion.setIsDeletedAuxiliar(false);	
			detalleconsignacion.setIsNewAuxiliar(false);	
			detalleconsignacion.setIsChangedAuxiliar(false);
			
			detalleconsignacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleConsignacions(List<DetalleConsignacion> detalleconsignacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleConsignacion detalleconsignacion : detalleconsignacions) {
			if(conAsignarBase && detalleconsignacion.getConCambioAuxiliar()) {
				detalleconsignacion.setIsDeleted(detalleconsignacion.getIsDeletedAuxiliar());	
				detalleconsignacion.setIsNew(detalleconsignacion.getIsNewAuxiliar());	
				detalleconsignacion.setIsChanged(detalleconsignacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleconsignacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleconsignacion.setIsDeletedAuxiliar(false);	
				detalleconsignacion.setIsNewAuxiliar(false);	
				detalleconsignacion.setIsChangedAuxiliar(false);
				
				detalleconsignacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleConsignacion(DetalleConsignacion detalleconsignacion,Boolean conEnteros) throws Exception  {
		detalleconsignacion.setprecio(0.0);
		detalleconsignacion.setdescuento_porcentaje(0.0);
		detalleconsignacion.setdescuento_valor(0.0);
		detalleconsignacion.setiva(0.0);
		detalleconsignacion.settotal(0.0);
		detalleconsignacion.setice(0.0);
		detalleconsignacion.setcosto(0.0);
		detalleconsignacion.setutilidad(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleconsignacion.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleConsignacions(List<DetalleConsignacion> detalleconsignacions,Boolean conEnteros) throws Exception  {
		
		for(DetalleConsignacion detalleconsignacion: detalleconsignacions) {
			detalleconsignacion.setprecio(0.0);
			detalleconsignacion.setdescuento_porcentaje(0.0);
			detalleconsignacion.setdescuento_valor(0.0);
			detalleconsignacion.setiva(0.0);
			detalleconsignacion.settotal(0.0);
			detalleconsignacion.setice(0.0);
			detalleconsignacion.setcosto(0.0);
			detalleconsignacion.setutilidad(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleconsignacion.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleConsignacion(List<DetalleConsignacion> detalleconsignacions,DetalleConsignacion detalleconsignacionAux) throws Exception  {
		DetalleConsignacionConstantesFunciones.InicializarValoresDetalleConsignacion(detalleconsignacionAux,true);
		
		for(DetalleConsignacion detalleconsignacion: detalleconsignacions) {
			if(detalleconsignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleconsignacionAux.setcantidad(detalleconsignacionAux.getcantidad()+detalleconsignacion.getcantidad());			
			detalleconsignacionAux.setprecio(detalleconsignacionAux.getprecio()+detalleconsignacion.getprecio());			
			detalleconsignacionAux.setdescuento_porcentaje(detalleconsignacionAux.getdescuento_porcentaje()+detalleconsignacion.getdescuento_porcentaje());			
			detalleconsignacionAux.setdescuento_valor(detalleconsignacionAux.getdescuento_valor()+detalleconsignacion.getdescuento_valor());			
			detalleconsignacionAux.setiva(detalleconsignacionAux.getiva()+detalleconsignacion.getiva());			
			detalleconsignacionAux.settotal(detalleconsignacionAux.gettotal()+detalleconsignacion.gettotal());			
			detalleconsignacionAux.setice(detalleconsignacionAux.getice()+detalleconsignacion.getice());			
			detalleconsignacionAux.setcosto(detalleconsignacionAux.getcosto()+detalleconsignacion.getcosto());			
			detalleconsignacionAux.setutilidad(detalleconsignacionAux.getutilidad()+detalleconsignacion.getutilidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleConsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleConsignacionConstantesFunciones.getArrayColumnasGlobalesDetalleConsignacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleConsignacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleConsignacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleConsignacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleConsignacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleConsignacionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleConsignacionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleConsignacionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleConsignacionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleConsignacionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleConsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleConsignacion> detalleconsignacions,DetalleConsignacion detalleconsignacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleConsignacion detalleconsignacionAux: detalleconsignacions) {
			if(detalleconsignacionAux!=null && detalleconsignacion!=null) {
				if((detalleconsignacionAux.getId()==null && detalleconsignacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleconsignacionAux.getId()!=null && detalleconsignacion.getId()!=null){
					if(detalleconsignacionAux.getId().equals(detalleconsignacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleConsignacion(List<DetalleConsignacion> detalleconsignacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double ivaTotal=0.0;
		Double totalTotal=0.0;
		Double iceTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
	
		for(DetalleConsignacion detalleconsignacion: detalleconsignacions) {			
			if(detalleconsignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detalleconsignacion.getprecio();
			descuento_porcentajeTotal+=detalleconsignacion.getdescuento_porcentaje();
			descuento_valorTotal+=detalleconsignacion.getdescuento_valor();
			ivaTotal+=detalleconsignacion.getiva();
			totalTotal+=detalleconsignacion.gettotal();
			iceTotal+=detalleconsignacion.getice();
			costoTotal+=detalleconsignacion.getcosto();
			utilidadTotal+=detalleconsignacion.getutilidad();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleConsignacionConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleConsignacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_ID, DetalleConsignacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_VERSIONROW, DetalleConsignacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDEMPRESA, DetalleConsignacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDSUCURSAL, DetalleConsignacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDEJERCICIO, DetalleConsignacionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDPERIODO, DetalleConsignacionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDANIO, DetalleConsignacionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDMES, DetalleConsignacionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDCONSIGNACION, DetalleConsignacionConstantesFunciones.IDCONSIGNACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDPRODUCTO, DetalleConsignacionConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDBODEGA, DetalleConsignacionConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDUNIDAD, DetalleConsignacionConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO, DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_CANTIDAD, DetalleConsignacionConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_PRECIO, DetalleConsignacionConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR, DetalleConsignacionConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_IVA, DetalleConsignacionConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_TOTAL, DetalleConsignacionConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_ICE, DetalleConsignacionConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_COSTO, DetalleConsignacionConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD, DetalleConsignacionConstantesFunciones.UTILIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleConsignacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDCONSIGNACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleConsignacionConstantesFunciones.UTILIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleConsignacion() throws Exception  {
		return DetalleConsignacionConstantesFunciones.getTiposSeleccionarDetalleConsignacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleConsignacion(Boolean conFk) throws Exception  {
		return DetalleConsignacionConstantesFunciones.getTiposSeleccionarDetalleConsignacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleConsignacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDCONSIGNACION);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDCONSIGNACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD);
			reporte.setsDescripcion(DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleConsignacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleConsignacion(DetalleConsignacion detalleconsignacionAux) throws Exception {
		
			detalleconsignacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleconsignacionAux.getEmpresa()));
			detalleconsignacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleconsignacionAux.getSucursal()));
			detalleconsignacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleconsignacionAux.getEjercicio()));
			detalleconsignacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleconsignacionAux.getPeriodo()));
			detalleconsignacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleconsignacionAux.getAnio()));
			detalleconsignacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleconsignacionAux.getMes()));
			detalleconsignacionAux.setconsignacion_descripcion(ConsignacionConstantesFunciones.getConsignacionDescripcion(detalleconsignacionAux.getConsignacion()));
			detalleconsignacionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleconsignacionAux.getProducto()));
			detalleconsignacionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleconsignacionAux.getBodega()));
			detalleconsignacionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleconsignacionAux.getUnidad()));
			detalleconsignacionAux.setestadodetallepedido_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detalleconsignacionAux.getEstadoDetallePedido()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleConsignacion(List<DetalleConsignacion> detalleconsignacionsTemp) throws Exception {
		for(DetalleConsignacion detalleconsignacionAux:detalleconsignacionsTemp) {
			
			detalleconsignacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleconsignacionAux.getEmpresa()));
			detalleconsignacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleconsignacionAux.getSucursal()));
			detalleconsignacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleconsignacionAux.getEjercicio()));
			detalleconsignacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleconsignacionAux.getPeriodo()));
			detalleconsignacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleconsignacionAux.getAnio()));
			detalleconsignacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleconsignacionAux.getMes()));
			detalleconsignacionAux.setconsignacion_descripcion(ConsignacionConstantesFunciones.getConsignacionDescripcion(detalleconsignacionAux.getConsignacion()));
			detalleconsignacionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleconsignacionAux.getProducto()));
			detalleconsignacionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleconsignacionAux.getBodega()));
			detalleconsignacionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleconsignacionAux.getUnidad()));
			detalleconsignacionAux.setestadodetallepedido_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detalleconsignacionAux.getEstadoDetallePedido()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(EstadoDetallePedido.class));
				
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
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetallePedido.class)) {
						classes.add(new Classe(EstadoDetallePedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetallePedido.class)); continue;
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

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetallePedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleConsignacionConstantesFunciones.getClassesRelationshipsOfDetalleConsignacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleConsignacionConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleConsignacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleConsignacion detalleconsignacion,List<DetalleConsignacion> detalleconsignacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleConsignacion detalleconsignacionEncontrado=null;
			
			for(DetalleConsignacion detalleconsignacionLocal:detalleconsignacions) {
				if(detalleconsignacionLocal.getId().equals(detalleconsignacion.getId())) {
					detalleconsignacionEncontrado=detalleconsignacionLocal;
					
					detalleconsignacionLocal.setIsChanged(detalleconsignacion.getIsChanged());
					detalleconsignacionLocal.setIsNew(detalleconsignacion.getIsNew());
					detalleconsignacionLocal.setIsDeleted(detalleconsignacion.getIsDeleted());
					
					detalleconsignacionLocal.setGeneralEntityOriginal(detalleconsignacion.getGeneralEntityOriginal());
					
					detalleconsignacionLocal.setId(detalleconsignacion.getId());	
					detalleconsignacionLocal.setVersionRow(detalleconsignacion.getVersionRow());	
					detalleconsignacionLocal.setid_empresa(detalleconsignacion.getid_empresa());	
					detalleconsignacionLocal.setid_sucursal(detalleconsignacion.getid_sucursal());	
					detalleconsignacionLocal.setid_ejercicio(detalleconsignacion.getid_ejercicio());	
					detalleconsignacionLocal.setid_periodo(detalleconsignacion.getid_periodo());	
					detalleconsignacionLocal.setid_anio(detalleconsignacion.getid_anio());	
					detalleconsignacionLocal.setid_mes(detalleconsignacion.getid_mes());	
					detalleconsignacionLocal.setid_consignacion(detalleconsignacion.getid_consignacion());	
					detalleconsignacionLocal.setid_producto(detalleconsignacion.getid_producto());	
					detalleconsignacionLocal.setid_bodega(detalleconsignacion.getid_bodega());	
					detalleconsignacionLocal.setid_unidad(detalleconsignacion.getid_unidad());	
					detalleconsignacionLocal.setid_estado_detalle_pedido(detalleconsignacion.getid_estado_detalle_pedido());	
					detalleconsignacionLocal.setcantidad(detalleconsignacion.getcantidad());	
					detalleconsignacionLocal.setprecio(detalleconsignacion.getprecio());	
					detalleconsignacionLocal.setdescuento_porcentaje(detalleconsignacion.getdescuento_porcentaje());	
					detalleconsignacionLocal.setdescuento_valor(detalleconsignacion.getdescuento_valor());	
					detalleconsignacionLocal.setiva(detalleconsignacion.getiva());	
					detalleconsignacionLocal.settotal(detalleconsignacion.gettotal());	
					detalleconsignacionLocal.setice(detalleconsignacion.getice());	
					detalleconsignacionLocal.setcosto(detalleconsignacion.getcosto());	
					detalleconsignacionLocal.setutilidad(detalleconsignacion.getutilidad());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleconsignacion.getIsDeleted()) {
				if(!existe) {
					detalleconsignacions.add(detalleconsignacion);
				}
			} else {
				if(detalleconsignacionEncontrado!=null && permiteQuitar)  {
					detalleconsignacions.remove(detalleconsignacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleConsignacion detalleconsignacion,List<DetalleConsignacion> detalleconsignacions) throws Exception {
		try	{			
			for(DetalleConsignacion detalleconsignacionLocal:detalleconsignacions) {
				if(detalleconsignacionLocal.getId().equals(detalleconsignacion.getId())) {
					detalleconsignacionLocal.setIsSelected(detalleconsignacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleConsignacion(List<DetalleConsignacion> detalleconsignacionsAux) throws Exception {
		//this.detalleconsignacionsAux=detalleconsignacionsAux;
		
		for(DetalleConsignacion detalleconsignacionAux:detalleconsignacionsAux) {
			if(detalleconsignacionAux.getIsChanged()) {
				detalleconsignacionAux.setIsChanged(false);
			}		
			
			if(detalleconsignacionAux.getIsNew()) {
				detalleconsignacionAux.setIsNew(false);
			}	
			
			if(detalleconsignacionAux.getIsDeleted()) {
				detalleconsignacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleConsignacion(DetalleConsignacion detalleconsignacionAux) throws Exception {
		//this.detalleconsignacionAux=detalleconsignacionAux;
		
			if(detalleconsignacionAux.getIsChanged()) {
				detalleconsignacionAux.setIsChanged(false);
			}		
			
			if(detalleconsignacionAux.getIsNew()) {
				detalleconsignacionAux.setIsNew(false);
			}	
			
			if(detalleconsignacionAux.getIsDeleted()) {
				detalleconsignacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleConsignacion detalleconsignacionAsignar,DetalleConsignacion detalleconsignacion) throws Exception {
		detalleconsignacionAsignar.setId(detalleconsignacion.getId());	
		detalleconsignacionAsignar.setVersionRow(detalleconsignacion.getVersionRow());	
		detalleconsignacionAsignar.setid_empresa(detalleconsignacion.getid_empresa());
		detalleconsignacionAsignar.setempresa_descripcion(detalleconsignacion.getempresa_descripcion());	
		detalleconsignacionAsignar.setid_sucursal(detalleconsignacion.getid_sucursal());
		detalleconsignacionAsignar.setsucursal_descripcion(detalleconsignacion.getsucursal_descripcion());	
		detalleconsignacionAsignar.setid_ejercicio(detalleconsignacion.getid_ejercicio());
		detalleconsignacionAsignar.setejercicio_descripcion(detalleconsignacion.getejercicio_descripcion());	
		detalleconsignacionAsignar.setid_periodo(detalleconsignacion.getid_periodo());
		detalleconsignacionAsignar.setperiodo_descripcion(detalleconsignacion.getperiodo_descripcion());	
		detalleconsignacionAsignar.setid_anio(detalleconsignacion.getid_anio());
		detalleconsignacionAsignar.setanio_descripcion(detalleconsignacion.getanio_descripcion());	
		detalleconsignacionAsignar.setid_mes(detalleconsignacion.getid_mes());
		detalleconsignacionAsignar.setmes_descripcion(detalleconsignacion.getmes_descripcion());	
		detalleconsignacionAsignar.setid_consignacion(detalleconsignacion.getid_consignacion());
		detalleconsignacionAsignar.setconsignacion_descripcion(detalleconsignacion.getconsignacion_descripcion());	
		detalleconsignacionAsignar.setid_producto(detalleconsignacion.getid_producto());
		detalleconsignacionAsignar.setproducto_descripcion(detalleconsignacion.getproducto_descripcion());	
		detalleconsignacionAsignar.setid_bodega(detalleconsignacion.getid_bodega());
		detalleconsignacionAsignar.setbodega_descripcion(detalleconsignacion.getbodega_descripcion());	
		detalleconsignacionAsignar.setid_unidad(detalleconsignacion.getid_unidad());
		detalleconsignacionAsignar.setunidad_descripcion(detalleconsignacion.getunidad_descripcion());	
		detalleconsignacionAsignar.setid_estado_detalle_pedido(detalleconsignacion.getid_estado_detalle_pedido());
		detalleconsignacionAsignar.setestadodetallepedido_descripcion(detalleconsignacion.getestadodetallepedido_descripcion());	
		detalleconsignacionAsignar.setcantidad(detalleconsignacion.getcantidad());	
		detalleconsignacionAsignar.setprecio(detalleconsignacion.getprecio());	
		detalleconsignacionAsignar.setdescuento_porcentaje(detalleconsignacion.getdescuento_porcentaje());	
		detalleconsignacionAsignar.setdescuento_valor(detalleconsignacion.getdescuento_valor());	
		detalleconsignacionAsignar.setiva(detalleconsignacion.getiva());	
		detalleconsignacionAsignar.settotal(detalleconsignacion.gettotal());	
		detalleconsignacionAsignar.setice(detalleconsignacion.getice());	
		detalleconsignacionAsignar.setcosto(detalleconsignacion.getcosto());	
		detalleconsignacionAsignar.setutilidad(detalleconsignacion.getutilidad());	
	}
	
	public static void inicializarDetalleConsignacion(DetalleConsignacion detalleconsignacion) throws Exception {
		try {
				detalleconsignacion.setId(0L);	
					
				detalleconsignacion.setid_empresa(-1L);	
				detalleconsignacion.setid_sucursal(-1L);	
				detalleconsignacion.setid_ejercicio(-1L);	
				detalleconsignacion.setid_periodo(-1L);	
				detalleconsignacion.setid_anio(null);	
				detalleconsignacion.setid_mes(null);	
				detalleconsignacion.setid_consignacion(-1L);	
				detalleconsignacion.setid_producto(-1L);	
				detalleconsignacion.setid_bodega(-1L);	
				detalleconsignacion.setid_unidad(-1L);	
				detalleconsignacion.setid_estado_detalle_pedido(-1L);	
				detalleconsignacion.setcantidad(0);	
				detalleconsignacion.setprecio(0.0);	
				detalleconsignacion.setdescuento_porcentaje(0.0);	
				detalleconsignacion.setdescuento_valor(0.0);	
				detalleconsignacion.setiva(0.0);	
				detalleconsignacion.settotal(0.0);	
				detalleconsignacion.setice(0.0);	
				detalleconsignacion.setcosto(0.0);	
				detalleconsignacion.setutilidad(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleConsignacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDCONSIGNACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleConsignacionConstantesFunciones.LABEL_UTILIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleConsignacion(String sTipo,Row row,Workbook workbook,DetalleConsignacion detalleconsignacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getconsignacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getestadodetallepedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleconsignacion.getutilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleConsignacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleConsignacion() {
		return this.sFinalQueryDetalleConsignacion;
	}
	
	public void setsFinalQueryDetalleConsignacion(String sFinalQueryDetalleConsignacion) {
		this.sFinalQueryDetalleConsignacion= sFinalQueryDetalleConsignacion;
	}
	
	public Border resaltarSeleccionarDetalleConsignacion=null;
	
	public Border setResaltarSeleccionarDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleConsignacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleConsignacion() {
		return this.resaltarSeleccionarDetalleConsignacion;
	}
	
	public void setResaltarSeleccionarDetalleConsignacion(Border borderResaltarSeleccionarDetalleConsignacion) {
		this.resaltarSeleccionarDetalleConsignacion= borderResaltarSeleccionarDetalleConsignacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleConsignacion=null;
	public Boolean mostraridDetalleConsignacion=true;
	public Boolean activaridDetalleConsignacion=true;

	public Border resaltarid_empresaDetalleConsignacion=null;
	public Boolean mostrarid_empresaDetalleConsignacion=true;
	public Boolean activarid_empresaDetalleConsignacion=true;
	public Boolean cargarid_empresaDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleConsignacion=null;
	public Boolean mostrarid_sucursalDetalleConsignacion=true;
	public Boolean activarid_sucursalDetalleConsignacion=true;
	public Boolean cargarid_sucursalDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleConsignacion=null;
	public Boolean mostrarid_ejercicioDetalleConsignacion=true;
	public Boolean activarid_ejercicioDetalleConsignacion=true;
	public Boolean cargarid_ejercicioDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleConsignacion=null;
	public Boolean mostrarid_periodoDetalleConsignacion=true;
	public Boolean activarid_periodoDetalleConsignacion=true;
	public Boolean cargarid_periodoDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleConsignacion=null;
	public Boolean mostrarid_anioDetalleConsignacion=true;
	public Boolean activarid_anioDetalleConsignacion=false;
	public Boolean cargarid_anioDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleConsignacion=null;
	public Boolean mostrarid_mesDetalleConsignacion=true;
	public Boolean activarid_mesDetalleConsignacion=false;
	public Boolean cargarid_mesDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_consignacionDetalleConsignacion=null;
	public Boolean mostrarid_consignacionDetalleConsignacion=true;
	public Boolean activarid_consignacionDetalleConsignacion=true;
	public Boolean cargarid_consignacionDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consignacionDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleConsignacion=null;
	public Boolean mostrarid_productoDetalleConsignacion=true;
	public Boolean activarid_productoDetalleConsignacion=true;
	public Boolean cargarid_productoDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleConsignacion=true;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleConsignacion=null;
	public Boolean mostrarid_bodegaDetalleConsignacion=true;
	public Boolean activarid_bodegaDetalleConsignacion=true;
	public Boolean cargarid_bodegaDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarid_unidadDetalleConsignacion=null;
	public Boolean mostrarid_unidadDetalleConsignacion=true;
	public Boolean activarid_unidadDetalleConsignacion=true;
	public Boolean cargarid_unidadDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleConsignacion=true;//ConEventDepend=true

	public Border resaltarid_estado_detalle_pedidoDetalleConsignacion=null;
	public Boolean mostrarid_estado_detalle_pedidoDetalleConsignacion=true;
	public Boolean activarid_estado_detalle_pedidoDetalleConsignacion=true;
	public Boolean cargarid_estado_detalle_pedidoDetalleConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_pedidoDetalleConsignacion=false;//ConEventDepend=true

	public Border resaltarcantidadDetalleConsignacion=null;
	public Boolean mostrarcantidadDetalleConsignacion=true;
	public Boolean activarcantidadDetalleConsignacion=true;

	public Border resaltarprecioDetalleConsignacion=null;
	public Boolean mostrarprecioDetalleConsignacion=true;
	public Boolean activarprecioDetalleConsignacion=true;

	public Border resaltardescuento_porcentajeDetalleConsignacion=null;
	public Boolean mostrardescuento_porcentajeDetalleConsignacion=true;
	public Boolean activardescuento_porcentajeDetalleConsignacion=true;

	public Border resaltardescuento_valorDetalleConsignacion=null;
	public Boolean mostrardescuento_valorDetalleConsignacion=true;
	public Boolean activardescuento_valorDetalleConsignacion=true;

	public Border resaltarivaDetalleConsignacion=null;
	public Boolean mostrarivaDetalleConsignacion=true;
	public Boolean activarivaDetalleConsignacion=true;

	public Border resaltartotalDetalleConsignacion=null;
	public Boolean mostrartotalDetalleConsignacion=true;
	public Boolean activartotalDetalleConsignacion=true;

	public Border resaltariceDetalleConsignacion=null;
	public Boolean mostrariceDetalleConsignacion=true;
	public Boolean activariceDetalleConsignacion=false;

	public Border resaltarcostoDetalleConsignacion=null;
	public Boolean mostrarcostoDetalleConsignacion=true;
	public Boolean activarcostoDetalleConsignacion=false;

	public Border resaltarutilidadDetalleConsignacion=null;
	public Boolean mostrarutilidadDetalleConsignacion=true;
	public Boolean activarutilidadDetalleConsignacion=false;

	
	

	public Border setResaltaridDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltaridDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleConsignacion() {
		return this.resaltaridDetalleConsignacion;
	}

	public void setResaltaridDetalleConsignacion(Border borderResaltar) {
		this.resaltaridDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostraridDetalleConsignacion() {
		return this.mostraridDetalleConsignacion;
	}

	public void setMostraridDetalleConsignacion(Boolean mostraridDetalleConsignacion) {
		this.mostraridDetalleConsignacion= mostraridDetalleConsignacion;
	}

	public Boolean getActivaridDetalleConsignacion() {
		return this.activaridDetalleConsignacion;
	}

	public void setActivaridDetalleConsignacion(Boolean activaridDetalleConsignacion) {
		this.activaridDetalleConsignacion= activaridDetalleConsignacion;
	}

	public Border setResaltarid_empresaDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleConsignacion() {
		return this.resaltarid_empresaDetalleConsignacion;
	}

	public void setResaltarid_empresaDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_empresaDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleConsignacion() {
		return this.mostrarid_empresaDetalleConsignacion;
	}

	public void setMostrarid_empresaDetalleConsignacion(Boolean mostrarid_empresaDetalleConsignacion) {
		this.mostrarid_empresaDetalleConsignacion= mostrarid_empresaDetalleConsignacion;
	}

	public Boolean getActivarid_empresaDetalleConsignacion() {
		return this.activarid_empresaDetalleConsignacion;
	}

	public void setActivarid_empresaDetalleConsignacion(Boolean activarid_empresaDetalleConsignacion) {
		this.activarid_empresaDetalleConsignacion= activarid_empresaDetalleConsignacion;
	}

	public Boolean getCargarid_empresaDetalleConsignacion() {
		return this.cargarid_empresaDetalleConsignacion;
	}

	public void setCargarid_empresaDetalleConsignacion(Boolean cargarid_empresaDetalleConsignacion) {
		this.cargarid_empresaDetalleConsignacion= cargarid_empresaDetalleConsignacion;
	}

	public Border setResaltarid_sucursalDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleConsignacion() {
		return this.resaltarid_sucursalDetalleConsignacion;
	}

	public void setResaltarid_sucursalDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_sucursalDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleConsignacion() {
		return this.mostrarid_sucursalDetalleConsignacion;
	}

	public void setMostrarid_sucursalDetalleConsignacion(Boolean mostrarid_sucursalDetalleConsignacion) {
		this.mostrarid_sucursalDetalleConsignacion= mostrarid_sucursalDetalleConsignacion;
	}

	public Boolean getActivarid_sucursalDetalleConsignacion() {
		return this.activarid_sucursalDetalleConsignacion;
	}

	public void setActivarid_sucursalDetalleConsignacion(Boolean activarid_sucursalDetalleConsignacion) {
		this.activarid_sucursalDetalleConsignacion= activarid_sucursalDetalleConsignacion;
	}

	public Boolean getCargarid_sucursalDetalleConsignacion() {
		return this.cargarid_sucursalDetalleConsignacion;
	}

	public void setCargarid_sucursalDetalleConsignacion(Boolean cargarid_sucursalDetalleConsignacion) {
		this.cargarid_sucursalDetalleConsignacion= cargarid_sucursalDetalleConsignacion;
	}

	public Border setResaltarid_ejercicioDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleConsignacion() {
		return this.resaltarid_ejercicioDetalleConsignacion;
	}

	public void setResaltarid_ejercicioDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleConsignacion() {
		return this.mostrarid_ejercicioDetalleConsignacion;
	}

	public void setMostrarid_ejercicioDetalleConsignacion(Boolean mostrarid_ejercicioDetalleConsignacion) {
		this.mostrarid_ejercicioDetalleConsignacion= mostrarid_ejercicioDetalleConsignacion;
	}

	public Boolean getActivarid_ejercicioDetalleConsignacion() {
		return this.activarid_ejercicioDetalleConsignacion;
	}

	public void setActivarid_ejercicioDetalleConsignacion(Boolean activarid_ejercicioDetalleConsignacion) {
		this.activarid_ejercicioDetalleConsignacion= activarid_ejercicioDetalleConsignacion;
	}

	public Boolean getCargarid_ejercicioDetalleConsignacion() {
		return this.cargarid_ejercicioDetalleConsignacion;
	}

	public void setCargarid_ejercicioDetalleConsignacion(Boolean cargarid_ejercicioDetalleConsignacion) {
		this.cargarid_ejercicioDetalleConsignacion= cargarid_ejercicioDetalleConsignacion;
	}

	public Border setResaltarid_periodoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleConsignacion() {
		return this.resaltarid_periodoDetalleConsignacion;
	}

	public void setResaltarid_periodoDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_periodoDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleConsignacion() {
		return this.mostrarid_periodoDetalleConsignacion;
	}

	public void setMostrarid_periodoDetalleConsignacion(Boolean mostrarid_periodoDetalleConsignacion) {
		this.mostrarid_periodoDetalleConsignacion= mostrarid_periodoDetalleConsignacion;
	}

	public Boolean getActivarid_periodoDetalleConsignacion() {
		return this.activarid_periodoDetalleConsignacion;
	}

	public void setActivarid_periodoDetalleConsignacion(Boolean activarid_periodoDetalleConsignacion) {
		this.activarid_periodoDetalleConsignacion= activarid_periodoDetalleConsignacion;
	}

	public Boolean getCargarid_periodoDetalleConsignacion() {
		return this.cargarid_periodoDetalleConsignacion;
	}

	public void setCargarid_periodoDetalleConsignacion(Boolean cargarid_periodoDetalleConsignacion) {
		this.cargarid_periodoDetalleConsignacion= cargarid_periodoDetalleConsignacion;
	}

	public Border setResaltarid_anioDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleConsignacion() {
		return this.resaltarid_anioDetalleConsignacion;
	}

	public void setResaltarid_anioDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_anioDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleConsignacion() {
		return this.mostrarid_anioDetalleConsignacion;
	}

	public void setMostrarid_anioDetalleConsignacion(Boolean mostrarid_anioDetalleConsignacion) {
		this.mostrarid_anioDetalleConsignacion= mostrarid_anioDetalleConsignacion;
	}

	public Boolean getActivarid_anioDetalleConsignacion() {
		return this.activarid_anioDetalleConsignacion;
	}

	public void setActivarid_anioDetalleConsignacion(Boolean activarid_anioDetalleConsignacion) {
		this.activarid_anioDetalleConsignacion= activarid_anioDetalleConsignacion;
	}

	public Boolean getCargarid_anioDetalleConsignacion() {
		return this.cargarid_anioDetalleConsignacion;
	}

	public void setCargarid_anioDetalleConsignacion(Boolean cargarid_anioDetalleConsignacion) {
		this.cargarid_anioDetalleConsignacion= cargarid_anioDetalleConsignacion;
	}

	public Border setResaltarid_mesDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleConsignacion() {
		return this.resaltarid_mesDetalleConsignacion;
	}

	public void setResaltarid_mesDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_mesDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleConsignacion() {
		return this.mostrarid_mesDetalleConsignacion;
	}

	public void setMostrarid_mesDetalleConsignacion(Boolean mostrarid_mesDetalleConsignacion) {
		this.mostrarid_mesDetalleConsignacion= mostrarid_mesDetalleConsignacion;
	}

	public Boolean getActivarid_mesDetalleConsignacion() {
		return this.activarid_mesDetalleConsignacion;
	}

	public void setActivarid_mesDetalleConsignacion(Boolean activarid_mesDetalleConsignacion) {
		this.activarid_mesDetalleConsignacion= activarid_mesDetalleConsignacion;
	}

	public Boolean getCargarid_mesDetalleConsignacion() {
		return this.cargarid_mesDetalleConsignacion;
	}

	public void setCargarid_mesDetalleConsignacion(Boolean cargarid_mesDetalleConsignacion) {
		this.cargarid_mesDetalleConsignacion= cargarid_mesDetalleConsignacion;
	}

	public Border setResaltarid_consignacionDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_consignacionDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consignacionDetalleConsignacion() {
		return this.resaltarid_consignacionDetalleConsignacion;
	}

	public void setResaltarid_consignacionDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_consignacionDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_consignacionDetalleConsignacion() {
		return this.mostrarid_consignacionDetalleConsignacion;
	}

	public void setMostrarid_consignacionDetalleConsignacion(Boolean mostrarid_consignacionDetalleConsignacion) {
		this.mostrarid_consignacionDetalleConsignacion= mostrarid_consignacionDetalleConsignacion;
	}

	public Boolean getActivarid_consignacionDetalleConsignacion() {
		return this.activarid_consignacionDetalleConsignacion;
	}

	public void setActivarid_consignacionDetalleConsignacion(Boolean activarid_consignacionDetalleConsignacion) {
		this.activarid_consignacionDetalleConsignacion= activarid_consignacionDetalleConsignacion;
	}

	public Boolean getCargarid_consignacionDetalleConsignacion() {
		return this.cargarid_consignacionDetalleConsignacion;
	}

	public void setCargarid_consignacionDetalleConsignacion(Boolean cargarid_consignacionDetalleConsignacion) {
		this.cargarid_consignacionDetalleConsignacion= cargarid_consignacionDetalleConsignacion;
	}

	public Border setResaltarid_productoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleConsignacion() {
		return this.resaltarid_productoDetalleConsignacion;
	}

	public void setResaltarid_productoDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_productoDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleConsignacion() {
		return this.mostrarid_productoDetalleConsignacion;
	}

	public void setMostrarid_productoDetalleConsignacion(Boolean mostrarid_productoDetalleConsignacion) {
		this.mostrarid_productoDetalleConsignacion= mostrarid_productoDetalleConsignacion;
	}

	public Boolean getActivarid_productoDetalleConsignacion() {
		return this.activarid_productoDetalleConsignacion;
	}

	public void setActivarid_productoDetalleConsignacion(Boolean activarid_productoDetalleConsignacion) {
		this.activarid_productoDetalleConsignacion= activarid_productoDetalleConsignacion;
	}

	public Boolean getCargarid_productoDetalleConsignacion() {
		return this.cargarid_productoDetalleConsignacion;
	}

	public void setCargarid_productoDetalleConsignacion(Boolean cargarid_productoDetalleConsignacion) {
		this.cargarid_productoDetalleConsignacion= cargarid_productoDetalleConsignacion;
	}

	public Border setResaltarid_bodegaDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleConsignacion() {
		return this.resaltarid_bodegaDetalleConsignacion;
	}

	public void setResaltarid_bodegaDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_bodegaDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleConsignacion() {
		return this.mostrarid_bodegaDetalleConsignacion;
	}

	public void setMostrarid_bodegaDetalleConsignacion(Boolean mostrarid_bodegaDetalleConsignacion) {
		this.mostrarid_bodegaDetalleConsignacion= mostrarid_bodegaDetalleConsignacion;
	}

	public Boolean getActivarid_bodegaDetalleConsignacion() {
		return this.activarid_bodegaDetalleConsignacion;
	}

	public void setActivarid_bodegaDetalleConsignacion(Boolean activarid_bodegaDetalleConsignacion) {
		this.activarid_bodegaDetalleConsignacion= activarid_bodegaDetalleConsignacion;
	}

	public Boolean getCargarid_bodegaDetalleConsignacion() {
		return this.cargarid_bodegaDetalleConsignacion;
	}

	public void setCargarid_bodegaDetalleConsignacion(Boolean cargarid_bodegaDetalleConsignacion) {
		this.cargarid_bodegaDetalleConsignacion= cargarid_bodegaDetalleConsignacion;
	}

	public Border setResaltarid_unidadDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleConsignacion() {
		return this.resaltarid_unidadDetalleConsignacion;
	}

	public void setResaltarid_unidadDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_unidadDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleConsignacion() {
		return this.mostrarid_unidadDetalleConsignacion;
	}

	public void setMostrarid_unidadDetalleConsignacion(Boolean mostrarid_unidadDetalleConsignacion) {
		this.mostrarid_unidadDetalleConsignacion= mostrarid_unidadDetalleConsignacion;
	}

	public Boolean getActivarid_unidadDetalleConsignacion() {
		return this.activarid_unidadDetalleConsignacion;
	}

	public void setActivarid_unidadDetalleConsignacion(Boolean activarid_unidadDetalleConsignacion) {
		this.activarid_unidadDetalleConsignacion= activarid_unidadDetalleConsignacion;
	}

	public Boolean getCargarid_unidadDetalleConsignacion() {
		return this.cargarid_unidadDetalleConsignacion;
	}

	public void setCargarid_unidadDetalleConsignacion(Boolean cargarid_unidadDetalleConsignacion) {
		this.cargarid_unidadDetalleConsignacion= cargarid_unidadDetalleConsignacion;
	}

	public Border setResaltarid_estado_detalle_pedidoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_pedidoDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_pedidoDetalleConsignacion() {
		return this.resaltarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public void setResaltarid_estado_detalle_pedidoDetalleConsignacion(Border borderResaltar) {
		this.resaltarid_estado_detalle_pedidoDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_pedidoDetalleConsignacion() {
		return this.mostrarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public void setMostrarid_estado_detalle_pedidoDetalleConsignacion(Boolean mostrarid_estado_detalle_pedidoDetalleConsignacion) {
		this.mostrarid_estado_detalle_pedidoDetalleConsignacion= mostrarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public Boolean getActivarid_estado_detalle_pedidoDetalleConsignacion() {
		return this.activarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public void setActivarid_estado_detalle_pedidoDetalleConsignacion(Boolean activarid_estado_detalle_pedidoDetalleConsignacion) {
		this.activarid_estado_detalle_pedidoDetalleConsignacion= activarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public Boolean getCargarid_estado_detalle_pedidoDetalleConsignacion() {
		return this.cargarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public void setCargarid_estado_detalle_pedidoDetalleConsignacion(Boolean cargarid_estado_detalle_pedidoDetalleConsignacion) {
		this.cargarid_estado_detalle_pedidoDetalleConsignacion= cargarid_estado_detalle_pedidoDetalleConsignacion;
	}

	public Border setResaltarcantidadDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleConsignacion() {
		return this.resaltarcantidadDetalleConsignacion;
	}

	public void setResaltarcantidadDetalleConsignacion(Border borderResaltar) {
		this.resaltarcantidadDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleConsignacion() {
		return this.mostrarcantidadDetalleConsignacion;
	}

	public void setMostrarcantidadDetalleConsignacion(Boolean mostrarcantidadDetalleConsignacion) {
		this.mostrarcantidadDetalleConsignacion= mostrarcantidadDetalleConsignacion;
	}

	public Boolean getActivarcantidadDetalleConsignacion() {
		return this.activarcantidadDetalleConsignacion;
	}

	public void setActivarcantidadDetalleConsignacion(Boolean activarcantidadDetalleConsignacion) {
		this.activarcantidadDetalleConsignacion= activarcantidadDetalleConsignacion;
	}

	public Border setResaltarprecioDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleConsignacion() {
		return this.resaltarprecioDetalleConsignacion;
	}

	public void setResaltarprecioDetalleConsignacion(Border borderResaltar) {
		this.resaltarprecioDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleConsignacion() {
		return this.mostrarprecioDetalleConsignacion;
	}

	public void setMostrarprecioDetalleConsignacion(Boolean mostrarprecioDetalleConsignacion) {
		this.mostrarprecioDetalleConsignacion= mostrarprecioDetalleConsignacion;
	}

	public Boolean getActivarprecioDetalleConsignacion() {
		return this.activarprecioDetalleConsignacion;
	}

	public void setActivarprecioDetalleConsignacion(Boolean activarprecioDetalleConsignacion) {
		this.activarprecioDetalleConsignacion= activarprecioDetalleConsignacion;
	}

	public Border setResaltardescuento_porcentajeDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeDetalleConsignacion() {
		return this.resaltardescuento_porcentajeDetalleConsignacion;
	}

	public void setResaltardescuento_porcentajeDetalleConsignacion(Border borderResaltar) {
		this.resaltardescuento_porcentajeDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeDetalleConsignacion() {
		return this.mostrardescuento_porcentajeDetalleConsignacion;
	}

	public void setMostrardescuento_porcentajeDetalleConsignacion(Boolean mostrardescuento_porcentajeDetalleConsignacion) {
		this.mostrardescuento_porcentajeDetalleConsignacion= mostrardescuento_porcentajeDetalleConsignacion;
	}

	public Boolean getActivardescuento_porcentajeDetalleConsignacion() {
		return this.activardescuento_porcentajeDetalleConsignacion;
	}

	public void setActivardescuento_porcentajeDetalleConsignacion(Boolean activardescuento_porcentajeDetalleConsignacion) {
		this.activardescuento_porcentajeDetalleConsignacion= activardescuento_porcentajeDetalleConsignacion;
	}

	public Border setResaltardescuento_valorDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetalleConsignacion() {
		return this.resaltardescuento_valorDetalleConsignacion;
	}

	public void setResaltardescuento_valorDetalleConsignacion(Border borderResaltar) {
		this.resaltardescuento_valorDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetalleConsignacion() {
		return this.mostrardescuento_valorDetalleConsignacion;
	}

	public void setMostrardescuento_valorDetalleConsignacion(Boolean mostrardescuento_valorDetalleConsignacion) {
		this.mostrardescuento_valorDetalleConsignacion= mostrardescuento_valorDetalleConsignacion;
	}

	public Boolean getActivardescuento_valorDetalleConsignacion() {
		return this.activardescuento_valorDetalleConsignacion;
	}

	public void setActivardescuento_valorDetalleConsignacion(Boolean activardescuento_valorDetalleConsignacion) {
		this.activardescuento_valorDetalleConsignacion= activardescuento_valorDetalleConsignacion;
	}

	public Border setResaltarivaDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarivaDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleConsignacion() {
		return this.resaltarivaDetalleConsignacion;
	}

	public void setResaltarivaDetalleConsignacion(Border borderResaltar) {
		this.resaltarivaDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarivaDetalleConsignacion() {
		return this.mostrarivaDetalleConsignacion;
	}

	public void setMostrarivaDetalleConsignacion(Boolean mostrarivaDetalleConsignacion) {
		this.mostrarivaDetalleConsignacion= mostrarivaDetalleConsignacion;
	}

	public Boolean getActivarivaDetalleConsignacion() {
		return this.activarivaDetalleConsignacion;
	}

	public void setActivarivaDetalleConsignacion(Boolean activarivaDetalleConsignacion) {
		this.activarivaDetalleConsignacion= activarivaDetalleConsignacion;
	}

	public Border setResaltartotalDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltartotalDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleConsignacion() {
		return this.resaltartotalDetalleConsignacion;
	}

	public void setResaltartotalDetalleConsignacion(Border borderResaltar) {
		this.resaltartotalDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrartotalDetalleConsignacion() {
		return this.mostrartotalDetalleConsignacion;
	}

	public void setMostrartotalDetalleConsignacion(Boolean mostrartotalDetalleConsignacion) {
		this.mostrartotalDetalleConsignacion= mostrartotalDetalleConsignacion;
	}

	public Boolean getActivartotalDetalleConsignacion() {
		return this.activartotalDetalleConsignacion;
	}

	public void setActivartotalDetalleConsignacion(Boolean activartotalDetalleConsignacion) {
		this.activartotalDetalleConsignacion= activartotalDetalleConsignacion;
	}

	public Border setResaltariceDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltariceDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleConsignacion() {
		return this.resaltariceDetalleConsignacion;
	}

	public void setResaltariceDetalleConsignacion(Border borderResaltar) {
		this.resaltariceDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrariceDetalleConsignacion() {
		return this.mostrariceDetalleConsignacion;
	}

	public void setMostrariceDetalleConsignacion(Boolean mostrariceDetalleConsignacion) {
		this.mostrariceDetalleConsignacion= mostrariceDetalleConsignacion;
	}

	public Boolean getActivariceDetalleConsignacion() {
		return this.activariceDetalleConsignacion;
	}

	public void setActivariceDetalleConsignacion(Boolean activariceDetalleConsignacion) {
		this.activariceDetalleConsignacion= activariceDetalleConsignacion;
	}

	public Border setResaltarcostoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarcostoDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetalleConsignacion() {
		return this.resaltarcostoDetalleConsignacion;
	}

	public void setResaltarcostoDetalleConsignacion(Border borderResaltar) {
		this.resaltarcostoDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarcostoDetalleConsignacion() {
		return this.mostrarcostoDetalleConsignacion;
	}

	public void setMostrarcostoDetalleConsignacion(Boolean mostrarcostoDetalleConsignacion) {
		this.mostrarcostoDetalleConsignacion= mostrarcostoDetalleConsignacion;
	}

	public Boolean getActivarcostoDetalleConsignacion() {
		return this.activarcostoDetalleConsignacion;
	}

	public void setActivarcostoDetalleConsignacion(Boolean activarcostoDetalleConsignacion) {
		this.activarcostoDetalleConsignacion= activarcostoDetalleConsignacion;
	}

	public Border setResaltarutilidadDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleconsignacionBeanSwingJInternalFrame.jTtoolBarDetalleConsignacion.setBorder(borderResaltar);
		
		this.resaltarutilidadDetalleConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidadDetalleConsignacion() {
		return this.resaltarutilidadDetalleConsignacion;
	}

	public void setResaltarutilidadDetalleConsignacion(Border borderResaltar) {
		this.resaltarutilidadDetalleConsignacion= borderResaltar;
	}

	public Boolean getMostrarutilidadDetalleConsignacion() {
		return this.mostrarutilidadDetalleConsignacion;
	}

	public void setMostrarutilidadDetalleConsignacion(Boolean mostrarutilidadDetalleConsignacion) {
		this.mostrarutilidadDetalleConsignacion= mostrarutilidadDetalleConsignacion;
	}

	public Boolean getActivarutilidadDetalleConsignacion() {
		return this.activarutilidadDetalleConsignacion;
	}

	public void setActivarutilidadDetalleConsignacion(Boolean activarutilidadDetalleConsignacion) {
		this.activarutilidadDetalleConsignacion= activarutilidadDetalleConsignacion;
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
		
		
		this.setMostraridDetalleConsignacion(esInicial);
		this.setMostrarid_empresaDetalleConsignacion(esInicial);
		this.setMostrarid_sucursalDetalleConsignacion(esInicial);
		this.setMostrarid_ejercicioDetalleConsignacion(esInicial);
		this.setMostrarid_periodoDetalleConsignacion(esInicial);
		this.setMostrarid_anioDetalleConsignacion(esInicial);
		this.setMostrarid_mesDetalleConsignacion(esInicial);
		this.setMostrarid_consignacionDetalleConsignacion(esInicial);
		this.setMostrarid_productoDetalleConsignacion(esInicial);
		this.setMostrarid_bodegaDetalleConsignacion(esInicial);
		this.setMostrarid_unidadDetalleConsignacion(esInicial);
		this.setMostrarid_estado_detalle_pedidoDetalleConsignacion(esInicial);
		this.setMostrarcantidadDetalleConsignacion(esInicial);
		this.setMostrarprecioDetalleConsignacion(esInicial);
		this.setMostrardescuento_porcentajeDetalleConsignacion(esInicial);
		this.setMostrardescuento_valorDetalleConsignacion(esInicial);
		this.setMostrarivaDetalleConsignacion(esInicial);
		this.setMostrartotalDetalleConsignacion(esInicial);
		this.setMostrariceDetalleConsignacion(esInicial);
		this.setMostrarcostoDetalleConsignacion(esInicial);
		this.setMostrarutilidadDetalleConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ID)) {
				this.setMostraridDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDCONSIGNACION)) {
				this.setMostrarid_consignacionDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setMostrarid_estado_detalle_pedidoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ICE)) {
				this.setMostrariceDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.UTILIDAD)) {
				this.setMostrarutilidadDetalleConsignacion(esAsigna);
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
		
		
		this.setActivaridDetalleConsignacion(esInicial);
		this.setActivarid_empresaDetalleConsignacion(esInicial);
		this.setActivarid_sucursalDetalleConsignacion(esInicial);
		this.setActivarid_ejercicioDetalleConsignacion(esInicial);
		this.setActivarid_periodoDetalleConsignacion(esInicial);
		this.setActivarid_anioDetalleConsignacion(esInicial);
		this.setActivarid_mesDetalleConsignacion(esInicial);
		this.setActivarid_consignacionDetalleConsignacion(esInicial);
		this.setActivarid_productoDetalleConsignacion(esInicial);
		this.setActivarid_bodegaDetalleConsignacion(esInicial);
		this.setActivarid_unidadDetalleConsignacion(esInicial);
		this.setActivarid_estado_detalle_pedidoDetalleConsignacion(esInicial);
		this.setActivarcantidadDetalleConsignacion(esInicial);
		this.setActivarprecioDetalleConsignacion(esInicial);
		this.setActivardescuento_porcentajeDetalleConsignacion(esInicial);
		this.setActivardescuento_valorDetalleConsignacion(esInicial);
		this.setActivarivaDetalleConsignacion(esInicial);
		this.setActivartotalDetalleConsignacion(esInicial);
		this.setActivariceDetalleConsignacion(esInicial);
		this.setActivarcostoDetalleConsignacion(esInicial);
		this.setActivarutilidadDetalleConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ID)) {
				this.setActivaridDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDCONSIGNACION)) {
				this.setActivarid_consignacionDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setActivarid_estado_detalle_pedidoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IVA)) {
				this.setActivarivaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ICE)) {
				this.setActivariceDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.COSTO)) {
				this.setActivarcostoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.UTILIDAD)) {
				this.setActivarutilidadDetalleConsignacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleConsignacion(esInicial);
		this.setResaltarid_empresaDetalleConsignacion(esInicial);
		this.setResaltarid_sucursalDetalleConsignacion(esInicial);
		this.setResaltarid_ejercicioDetalleConsignacion(esInicial);
		this.setResaltarid_periodoDetalleConsignacion(esInicial);
		this.setResaltarid_anioDetalleConsignacion(esInicial);
		this.setResaltarid_mesDetalleConsignacion(esInicial);
		this.setResaltarid_consignacionDetalleConsignacion(esInicial);
		this.setResaltarid_productoDetalleConsignacion(esInicial);
		this.setResaltarid_bodegaDetalleConsignacion(esInicial);
		this.setResaltarid_unidadDetalleConsignacion(esInicial);
		this.setResaltarid_estado_detalle_pedidoDetalleConsignacion(esInicial);
		this.setResaltarcantidadDetalleConsignacion(esInicial);
		this.setResaltarprecioDetalleConsignacion(esInicial);
		this.setResaltardescuento_porcentajeDetalleConsignacion(esInicial);
		this.setResaltardescuento_valorDetalleConsignacion(esInicial);
		this.setResaltarivaDetalleConsignacion(esInicial);
		this.setResaltartotalDetalleConsignacion(esInicial);
		this.setResaltariceDetalleConsignacion(esInicial);
		this.setResaltarcostoDetalleConsignacion(esInicial);
		this.setResaltarutilidadDetalleConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ID)) {
				this.setResaltaridDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDCONSIGNACION)) {
				this.setResaltarid_consignacionDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setResaltarid_estado_detalle_pedidoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.ICE)) {
				this.setResaltariceDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetalleConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleConsignacionConstantesFunciones.UTILIDAD)) {
				this.setResaltarutilidadDetalleConsignacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleConsignacion=true;

	public Boolean getMostrarFK_IdBodegaDetalleConsignacion() {
		return this.mostrarFK_IdBodegaDetalleConsignacion;
	}

	public void setMostrarFK_IdBodegaDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsignacionDetalleConsignacion=true;

	public Boolean getMostrarFK_IdConsignacionDetalleConsignacion() {
		return this.mostrarFK_IdConsignacionDetalleConsignacion;
	}

	public void setMostrarFK_IdConsignacionDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsignacionDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleConsignacion=true;

	public Boolean getMostrarFK_IdEjercicioDetalleConsignacion() {
		return this.mostrarFK_IdEjercicioDetalleConsignacion;
	}

	public void setMostrarFK_IdEjercicioDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleConsignacion=true;

	public Boolean getMostrarFK_IdEmpresaDetalleConsignacion() {
		return this.mostrarFK_IdEmpresaDetalleConsignacion;
	}

	public void setMostrarFK_IdEmpresaDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetallePedidoDetalleConsignacion=true;

	public Boolean getMostrarFK_IdEstadoDetallePedidoDetalleConsignacion() {
		return this.mostrarFK_IdEstadoDetallePedidoDetalleConsignacion;
	}

	public void setMostrarFK_IdEstadoDetallePedidoDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetallePedidoDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleConsignacion=true;

	public Boolean getMostrarFK_IdPeriodoDetalleConsignacion() {
		return this.mostrarFK_IdPeriodoDetalleConsignacion;
	}

	public void setMostrarFK_IdPeriodoDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleConsignacion=true;

	public Boolean getMostrarFK_IdProductoDetalleConsignacion() {
		return this.mostrarFK_IdProductoDetalleConsignacion;
	}

	public void setMostrarFK_IdProductoDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleConsignacion=true;

	public Boolean getMostrarFK_IdSucursalDetalleConsignacion() {
		return this.mostrarFK_IdSucursalDetalleConsignacion;
	}

	public void setMostrarFK_IdSucursalDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleConsignacion=true;

	public Boolean getMostrarFK_IdUnidadDetalleConsignacion() {
		return this.mostrarFK_IdUnidadDetalleConsignacion;
	}

	public void setMostrarFK_IdUnidadDetalleConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleConsignacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleConsignacion=true;

	public Boolean getActivarFK_IdBodegaDetalleConsignacion() {
		return this.activarFK_IdBodegaDetalleConsignacion;
	}

	public void setActivarFK_IdBodegaDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdConsignacionDetalleConsignacion=true;

	public Boolean getActivarFK_IdConsignacionDetalleConsignacion() {
		return this.activarFK_IdConsignacionDetalleConsignacion;
	}

	public void setActivarFK_IdConsignacionDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdConsignacionDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleConsignacion=true;

	public Boolean getActivarFK_IdEjercicioDetalleConsignacion() {
		return this.activarFK_IdEjercicioDetalleConsignacion;
	}

	public void setActivarFK_IdEjercicioDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleConsignacion=true;

	public Boolean getActivarFK_IdEmpresaDetalleConsignacion() {
		return this.activarFK_IdEmpresaDetalleConsignacion;
	}

	public void setActivarFK_IdEmpresaDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetallePedidoDetalleConsignacion=true;

	public Boolean getActivarFK_IdEstadoDetallePedidoDetalleConsignacion() {
		return this.activarFK_IdEstadoDetallePedidoDetalleConsignacion;
	}

	public void setActivarFK_IdEstadoDetallePedidoDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetallePedidoDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleConsignacion=true;

	public Boolean getActivarFK_IdPeriodoDetalleConsignacion() {
		return this.activarFK_IdPeriodoDetalleConsignacion;
	}

	public void setActivarFK_IdPeriodoDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleConsignacion=true;

	public Boolean getActivarFK_IdProductoDetalleConsignacion() {
		return this.activarFK_IdProductoDetalleConsignacion;
	}

	public void setActivarFK_IdProductoDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleConsignacion=true;

	public Boolean getActivarFK_IdSucursalDetalleConsignacion() {
		return this.activarFK_IdSucursalDetalleConsignacion;
	}

	public void setActivarFK_IdSucursalDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleConsignacion=true;

	public Boolean getActivarFK_IdUnidadDetalleConsignacion() {
		return this.activarFK_IdUnidadDetalleConsignacion;
	}

	public void setActivarFK_IdUnidadDetalleConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleConsignacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleConsignacion=null;

	public Border getResaltarFK_IdBodegaDetalleConsignacion() {
		return this.resaltarFK_IdBodegaDetalleConsignacion;
	}

	public void setResaltarFK_IdBodegaDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdConsignacionDetalleConsignacion=null;

	public Border getResaltarFK_IdConsignacionDetalleConsignacion() {
		return this.resaltarFK_IdConsignacionDetalleConsignacion;
	}

	public void setResaltarFK_IdConsignacionDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdConsignacionDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdConsignacionDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsignacionDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleConsignacion=null;

	public Border getResaltarFK_IdEjercicioDetalleConsignacion() {
		return this.resaltarFK_IdEjercicioDetalleConsignacion;
	}

	public void setResaltarFK_IdEjercicioDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleConsignacion=null;

	public Border getResaltarFK_IdEmpresaDetalleConsignacion() {
		return this.resaltarFK_IdEmpresaDetalleConsignacion;
	}

	public void setResaltarFK_IdEmpresaDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetallePedidoDetalleConsignacion=null;

	public Border getResaltarFK_IdEstadoDetallePedidoDetalleConsignacion() {
		return this.resaltarFK_IdEstadoDetallePedidoDetalleConsignacion;
	}

	public void setResaltarFK_IdEstadoDetallePedidoDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetallePedidoDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetallePedidoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetallePedidoDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleConsignacion=null;

	public Border getResaltarFK_IdPeriodoDetalleConsignacion() {
		return this.resaltarFK_IdPeriodoDetalleConsignacion;
	}

	public void setResaltarFK_IdPeriodoDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleConsignacion=null;

	public Border getResaltarFK_IdProductoDetalleConsignacion() {
		return this.resaltarFK_IdProductoDetalleConsignacion;
	}

	public void setResaltarFK_IdProductoDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleConsignacion=null;

	public Border getResaltarFK_IdSucursalDetalleConsignacion() {
		return this.resaltarFK_IdSucursalDetalleConsignacion;
	}

	public void setResaltarFK_IdSucursalDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleConsignacion=null;

	public Border getResaltarFK_IdUnidadDetalleConsignacion() {
		return this.resaltarFK_IdUnidadDetalleConsignacion;
	}

	public void setResaltarFK_IdUnidadDetalleConsignacion(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleConsignacionBeanSwingJInternalFrame detalleconsignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleConsignacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}