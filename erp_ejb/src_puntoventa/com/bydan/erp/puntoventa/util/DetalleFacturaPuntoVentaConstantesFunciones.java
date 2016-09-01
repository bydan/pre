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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleFacturaPuntoVentaConstantesFunciones extends DetalleFacturaPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleFacturaPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleFacturaPuntoVenta"+DetalleFacturaPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleFacturaPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleFacturaPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleFacturaPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleFacturaPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Factura";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Factura Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleFacturaPuntoVenta";
	public static final String OBJECTNAME="detallefacturapuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="detalle_factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallefacturapuntoventa from "+DetalleFacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallefacturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".total,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleFacturaPuntoVentaConstantesFuncionesAdditional detallefacturapuntoventaConstantesFuncionesAdditional=null;
	
	public DetalleFacturaPuntoVentaConstantesFuncionesAdditional getDetalleFacturaPuntoVentaConstantesFuncionesAdditional() {
		return this.detallefacturapuntoventaConstantesFuncionesAdditional;
	}
	
	public void setDetalleFacturaPuntoVentaConstantesFuncionesAdditional(DetalleFacturaPuntoVentaConstantesFuncionesAdditional detallefacturapuntoventaConstantesFuncionesAdditional) {
		try {
			this.detallefacturapuntoventaConstantesFuncionesAdditional=detallefacturapuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDFACTURAPUNTOVENTA= "id_factura_punto_venta";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String SERIE= "serie";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDFACTURAPUNTOVENTA= "Factura";
		public static final String LABEL_IDFACTURAPUNTOVENTA_LOWER= "Factura Punto Venta";
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
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTO= "Descuento %";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_IVA= "Iva %";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_ICE= "Ice %";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ICEVALOR= "Ice";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleFacturaPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.SERIE)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleFacturaPuntoVentaDescripcion(DetalleFacturaPuntoVenta detallefacturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallefacturapuntoventa !=null/* && detallefacturapuntoventa.getId()!=0*/) {
			if(detallefacturapuntoventa.getId()!=null) {
				sDescripcion=detallefacturapuntoventa.getId().toString();
			}//detallefacturapuntoventadetallefacturapuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleFacturaPuntoVentaDescripcionDetallado(DetalleFacturaPuntoVenta detallefacturapuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=detallefacturapuntoventa.getId().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallefacturapuntoventa.getVersionRow().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA+"=";
		sDescripcion+=detallefacturapuntoventa.getid_factura_punto_venta().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallefacturapuntoventa.getid_empresa().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallefacturapuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallefacturapuntoventa.getid_bodega().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallefacturapuntoventa.getid_producto().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallefacturapuntoventa.getid_unidad().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.SERIE+"=";
		sDescripcion+=detallefacturapuntoventa.getserie()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallefacturapuntoventa.getcantidad().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallefacturapuntoventa.getprecio().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallefacturapuntoventa.getdescuento().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallefacturapuntoventa.getdescuento_valor().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=detallefacturapuntoventa.getiva().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallefacturapuntoventa.getiva_valor().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=detallefacturapuntoventa.getice().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallefacturapuntoventa.getice_valor().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detallefacturapuntoventa.getsub_total().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallefacturapuntoventa.gettotal().toString()+",";
		sDescripcion+=DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallefacturapuntoventa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleFacturaPuntoVentaDescripcion(DetalleFacturaPuntoVenta detallefacturapuntoventa,String sValor) throws Exception {			
		if(detallefacturapuntoventa !=null) {
			//detallefacturapuntoventadetallefacturapuntoventa.getId().toString();
		}		
	}
	
		

	public static String getFacturaPuntoVentaDescripcion(FacturaPuntoVenta facturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(facturapuntoventa!=null/*&&facturapuntoventa.getId()>0*/) {
			sDescripcion=FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(facturapuntoventa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFacturaPuntoVenta")) {
			sNombreIndice="Tipo=  Por Factura";
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

	public static String getDetalleIndiceFK_IdFacturaPuntoVenta(Long id_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura_punto_venta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturapuntoventa.setserie(detallefacturapuntoventa.getserie().trim());
		detallefacturapuntoventa.setdescripcion(detallefacturapuntoventa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {
			detallefacturapuntoventa.setserie(detallefacturapuntoventa.getserie().trim());
			detallefacturapuntoventa.setdescripcion(detallefacturapuntoventa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallefacturapuntoventa.getConCambioAuxiliar()) {
			detallefacturapuntoventa.setIsDeleted(detallefacturapuntoventa.getIsDeletedAuxiliar());	
			detallefacturapuntoventa.setIsNew(detallefacturapuntoventa.getIsNewAuxiliar());	
			detallefacturapuntoventa.setIsChanged(detallefacturapuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallefacturapuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallefacturapuntoventa.setIsDeletedAuxiliar(false);	
			detallefacturapuntoventa.setIsNewAuxiliar(false);	
			detallefacturapuntoventa.setIsChangedAuxiliar(false);
			
			detallefacturapuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa : detallefacturapuntoventas) {
			if(conAsignarBase && detallefacturapuntoventa.getConCambioAuxiliar()) {
				detallefacturapuntoventa.setIsDeleted(detallefacturapuntoventa.getIsDeletedAuxiliar());	
				detallefacturapuntoventa.setIsNew(detallefacturapuntoventa.getIsNewAuxiliar());	
				detallefacturapuntoventa.setIsChanged(detallefacturapuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallefacturapuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallefacturapuntoventa.setIsDeletedAuxiliar(false);	
				detallefacturapuntoventa.setIsNewAuxiliar(false);	
				detallefacturapuntoventa.setIsChangedAuxiliar(false);
				
				detallefacturapuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean conEnteros) throws Exception  {
		detallefacturapuntoventa.setprecio(0.0);
		detallefacturapuntoventa.setdescuento(0.0);
		detallefacturapuntoventa.setdescuento_valor(0.0);
		detallefacturapuntoventa.setiva(0.0);
		detallefacturapuntoventa.setiva_valor(0.0);
		detallefacturapuntoventa.setice(0.0);
		detallefacturapuntoventa.setice_valor(0.0);
		detallefacturapuntoventa.setsub_total(0.0);
		detallefacturapuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallefacturapuntoventa.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,Boolean conEnteros) throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {
			detallefacturapuntoventa.setprecio(0.0);
			detallefacturapuntoventa.setdescuento(0.0);
			detallefacturapuntoventa.setdescuento_valor(0.0);
			detallefacturapuntoventa.setiva(0.0);
			detallefacturapuntoventa.setiva_valor(0.0);
			detallefacturapuntoventa.setice(0.0);
			detallefacturapuntoventa.setice_valor(0.0);
			detallefacturapuntoventa.setsub_total(0.0);
			detallefacturapuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallefacturapuntoventa.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVenta detallefacturapuntoventaAux) throws Exception  {
		DetalleFacturaPuntoVentaConstantesFunciones.InicializarValoresDetalleFacturaPuntoVenta(detallefacturapuntoventaAux,true);
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {
			if(detallefacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallefacturapuntoventaAux.setcantidad(detallefacturapuntoventaAux.getcantidad()+detallefacturapuntoventa.getcantidad());			
			detallefacturapuntoventaAux.setprecio(detallefacturapuntoventaAux.getprecio()+detallefacturapuntoventa.getprecio());			
			detallefacturapuntoventaAux.setdescuento(detallefacturapuntoventaAux.getdescuento()+detallefacturapuntoventa.getdescuento());			
			detallefacturapuntoventaAux.setdescuento_valor(detallefacturapuntoventaAux.getdescuento_valor()+detallefacturapuntoventa.getdescuento_valor());			
			detallefacturapuntoventaAux.setiva(detallefacturapuntoventaAux.getiva()+detallefacturapuntoventa.getiva());			
			detallefacturapuntoventaAux.setiva_valor(detallefacturapuntoventaAux.getiva_valor()+detallefacturapuntoventa.getiva_valor());			
			detallefacturapuntoventaAux.setice(detallefacturapuntoventaAux.getice()+detallefacturapuntoventa.getice());			
			detallefacturapuntoventaAux.setice_valor(detallefacturapuntoventaAux.getice_valor()+detallefacturapuntoventa.getice_valor());			
			detallefacturapuntoventaAux.setsub_total(detallefacturapuntoventaAux.getsub_total()+detallefacturapuntoventa.getsub_total());			
			detallefacturapuntoventaAux.settotal(detallefacturapuntoventaAux.gettotal()+detallefacturapuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleFacturaPuntoVentaConstantesFunciones.getArrayColumnasGlobalesDetalleFacturaPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux: detallefacturapuntoventas) {
			if(detallefacturapuntoventaAux!=null && detallefacturapuntoventa!=null) {
				if((detallefacturapuntoventaAux.getId()==null && detallefacturapuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallefacturapuntoventaAux.getId()!=null && detallefacturapuntoventa.getId()!=null){
					if(detallefacturapuntoventaAux.getId().equals(detallefacturapuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {			
			if(detallefacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallefacturapuntoventa.getprecio();
			descuentoTotal+=detallefacturapuntoventa.getdescuento();
			descuento_valorTotal+=detallefacturapuntoventa.getdescuento_valor();
			ivaTotal+=detallefacturapuntoventa.getiva();
			iva_valorTotal+=detallefacturapuntoventa.getiva_valor();
			iceTotal+=detallefacturapuntoventa.getice();
			ice_valorTotal+=detallefacturapuntoventa.getice_valor();
			sub_totalTotal+=detallefacturapuntoventa.getsub_total();
			totalTotal+=detallefacturapuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleFacturaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ID, DetalleFacturaPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_VERSIONROW, DetalleFacturaPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA, DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDBODEGA, DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO, DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDUNIDAD, DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SERIE, DetalleFacturaPuntoVentaConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_CANTIDAD, DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO, DetalleFacturaPuntoVentaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO, DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR, DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA, DetalleFacturaPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR, DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE, DetalleFacturaPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR, DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL, DetalleFacturaPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION, DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleFacturaPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaPuntoVenta() throws Exception  {
		return DetalleFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarDetalleFacturaPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaPuntoVenta(Boolean conFk) throws Exception  {
		return DetalleFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarDetalleFacturaPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturaPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleFacturaPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventaAux) throws Exception {
		
			detallefacturapuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(detallefacturapuntoventaAux.getFacturaPuntoVenta()));
			detallefacturapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturapuntoventaAux.getEmpresa()));
			detallefacturapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturapuntoventaAux.getSucursal()));
			detallefacturapuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturapuntoventaAux.getBodega()));
			detallefacturapuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturapuntoventaAux.getProducto()));
			detallefacturapuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturapuntoventaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> detallefacturapuntoventasTemp) throws Exception {
		for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux:detallefacturapuntoventasTemp) {
			
			detallefacturapuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(detallefacturapuntoventaAux.getFacturaPuntoVenta()));
			detallefacturapuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturapuntoventaAux.getEmpresa()));
			detallefacturapuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturapuntoventaAux.getSucursal()));
			detallefacturapuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturapuntoventaAux.getBodega()));
			detallefacturapuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturapuntoventaAux.getProducto()));
			detallefacturapuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturapuntoventaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetalleFacturaPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleFacturaPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleFacturaPuntoVenta detallefacturapuntoventa,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleFacturaPuntoVenta detallefacturapuntoventaEncontrado=null;
			
			for(DetalleFacturaPuntoVenta detallefacturapuntoventaLocal:detallefacturapuntoventas) {
				if(detallefacturapuntoventaLocal.getId().equals(detallefacturapuntoventa.getId())) {
					detallefacturapuntoventaEncontrado=detallefacturapuntoventaLocal;
					
					detallefacturapuntoventaLocal.setIsChanged(detallefacturapuntoventa.getIsChanged());
					detallefacturapuntoventaLocal.setIsNew(detallefacturapuntoventa.getIsNew());
					detallefacturapuntoventaLocal.setIsDeleted(detallefacturapuntoventa.getIsDeleted());
					
					detallefacturapuntoventaLocal.setGeneralEntityOriginal(detallefacturapuntoventa.getGeneralEntityOriginal());
					
					detallefacturapuntoventaLocal.setId(detallefacturapuntoventa.getId());	
					detallefacturapuntoventaLocal.setVersionRow(detallefacturapuntoventa.getVersionRow());	
					detallefacturapuntoventaLocal.setid_factura_punto_venta(detallefacturapuntoventa.getid_factura_punto_venta());	
					detallefacturapuntoventaLocal.setid_empresa(detallefacturapuntoventa.getid_empresa());	
					detallefacturapuntoventaLocal.setid_sucursal(detallefacturapuntoventa.getid_sucursal());	
					detallefacturapuntoventaLocal.setid_bodega(detallefacturapuntoventa.getid_bodega());	
					detallefacturapuntoventaLocal.setid_producto(detallefacturapuntoventa.getid_producto());	
					detallefacturapuntoventaLocal.setid_unidad(detallefacturapuntoventa.getid_unidad());	
					detallefacturapuntoventaLocal.setserie(detallefacturapuntoventa.getserie());	
					detallefacturapuntoventaLocal.setcantidad(detallefacturapuntoventa.getcantidad());	
					detallefacturapuntoventaLocal.setprecio(detallefacturapuntoventa.getprecio());	
					detallefacturapuntoventaLocal.setdescuento(detallefacturapuntoventa.getdescuento());	
					detallefacturapuntoventaLocal.setdescuento_valor(detallefacturapuntoventa.getdescuento_valor());	
					detallefacturapuntoventaLocal.setiva(detallefacturapuntoventa.getiva());	
					detallefacturapuntoventaLocal.setiva_valor(detallefacturapuntoventa.getiva_valor());	
					detallefacturapuntoventaLocal.setice(detallefacturapuntoventa.getice());	
					detallefacturapuntoventaLocal.setice_valor(detallefacturapuntoventa.getice_valor());	
					detallefacturapuntoventaLocal.setsub_total(detallefacturapuntoventa.getsub_total());	
					detallefacturapuntoventaLocal.settotal(detallefacturapuntoventa.gettotal());	
					detallefacturapuntoventaLocal.setdescripcion(detallefacturapuntoventa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallefacturapuntoventa.getIsDeleted()) {
				if(!existe) {
					detallefacturapuntoventas.add(detallefacturapuntoventa);
				}
			} else {
				if(detallefacturapuntoventaEncontrado!=null && permiteQuitar)  {
					detallefacturapuntoventas.remove(detallefacturapuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleFacturaPuntoVenta detallefacturapuntoventa,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas) throws Exception {
		try	{			
			for(DetalleFacturaPuntoVenta detallefacturapuntoventaLocal:detallefacturapuntoventas) {
				if(detallefacturapuntoventaLocal.getId().equals(detallefacturapuntoventa.getId())) {
					detallefacturapuntoventaLocal.setIsSelected(detallefacturapuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> detallefacturapuntoventasAux) throws Exception {
		//this.detallefacturapuntoventasAux=detallefacturapuntoventasAux;
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux:detallefacturapuntoventasAux) {
			if(detallefacturapuntoventaAux.getIsChanged()) {
				detallefacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(detallefacturapuntoventaAux.getIsNew()) {
				detallefacturapuntoventaAux.setIsNew(false);
			}	
			
			if(detallefacturapuntoventaAux.getIsDeleted()) {
				detallefacturapuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventaAux) throws Exception {
		//this.detallefacturapuntoventaAux=detallefacturapuntoventaAux;
		
			if(detallefacturapuntoventaAux.getIsChanged()) {
				detallefacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(detallefacturapuntoventaAux.getIsNew()) {
				detallefacturapuntoventaAux.setIsNew(false);
			}	
			
			if(detallefacturapuntoventaAux.getIsDeleted()) {
				detallefacturapuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleFacturaPuntoVenta detallefacturapuntoventaAsignar,DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		detallefacturapuntoventaAsignar.setId(detallefacturapuntoventa.getId());	
		detallefacturapuntoventaAsignar.setVersionRow(detallefacturapuntoventa.getVersionRow());	
		detallefacturapuntoventaAsignar.setid_factura_punto_venta(detallefacturapuntoventa.getid_factura_punto_venta());
		detallefacturapuntoventaAsignar.setfacturapuntoventa_descripcion(detallefacturapuntoventa.getfacturapuntoventa_descripcion());	
		detallefacturapuntoventaAsignar.setid_empresa(detallefacturapuntoventa.getid_empresa());
		detallefacturapuntoventaAsignar.setempresa_descripcion(detallefacturapuntoventa.getempresa_descripcion());	
		detallefacturapuntoventaAsignar.setid_sucursal(detallefacturapuntoventa.getid_sucursal());
		detallefacturapuntoventaAsignar.setsucursal_descripcion(detallefacturapuntoventa.getsucursal_descripcion());	
		detallefacturapuntoventaAsignar.setid_bodega(detallefacturapuntoventa.getid_bodega());
		detallefacturapuntoventaAsignar.setbodega_descripcion(detallefacturapuntoventa.getbodega_descripcion());	
		detallefacturapuntoventaAsignar.setid_producto(detallefacturapuntoventa.getid_producto());
		detallefacturapuntoventaAsignar.setproducto_descripcion(detallefacturapuntoventa.getproducto_descripcion());	
		detallefacturapuntoventaAsignar.setid_unidad(detallefacturapuntoventa.getid_unidad());
		detallefacturapuntoventaAsignar.setunidad_descripcion(detallefacturapuntoventa.getunidad_descripcion());	
		detallefacturapuntoventaAsignar.setserie(detallefacturapuntoventa.getserie());	
		detallefacturapuntoventaAsignar.setcantidad(detallefacturapuntoventa.getcantidad());	
		detallefacturapuntoventaAsignar.setprecio(detallefacturapuntoventa.getprecio());	
		detallefacturapuntoventaAsignar.setdescuento(detallefacturapuntoventa.getdescuento());	
		detallefacturapuntoventaAsignar.setdescuento_valor(detallefacturapuntoventa.getdescuento_valor());	
		detallefacturapuntoventaAsignar.setiva(detallefacturapuntoventa.getiva());	
		detallefacturapuntoventaAsignar.setiva_valor(detallefacturapuntoventa.getiva_valor());	
		detallefacturapuntoventaAsignar.setice(detallefacturapuntoventa.getice());	
		detallefacturapuntoventaAsignar.setice_valor(detallefacturapuntoventa.getice_valor());	
		detallefacturapuntoventaAsignar.setsub_total(detallefacturapuntoventa.getsub_total());	
		detallefacturapuntoventaAsignar.settotal(detallefacturapuntoventa.gettotal());	
		detallefacturapuntoventaAsignar.setdescripcion(detallefacturapuntoventa.getdescripcion());	
	}
	
	public static void inicializarDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		try {
				detallefacturapuntoventa.setId(0L);	
					
				detallefacturapuntoventa.setid_factura_punto_venta(-1L);	
				detallefacturapuntoventa.setid_empresa(-1L);	
				detallefacturapuntoventa.setid_sucursal(-1L);	
				detallefacturapuntoventa.setid_bodega(-1L);	
				detallefacturapuntoventa.setid_producto(-1L);	
				detallefacturapuntoventa.setid_unidad(-1L);	
				detallefacturapuntoventa.setserie("");	
				detallefacturapuntoventa.setcantidad(0);	
				detallefacturapuntoventa.setprecio(0.0);	
				detallefacturapuntoventa.setdescuento(0.0);	
				detallefacturapuntoventa.setdescuento_valor(0.0);	
				detallefacturapuntoventa.setiva(0.0);	
				detallefacturapuntoventa.setiva_valor(0.0);	
				detallefacturapuntoventa.setice(0.0);	
				detallefacturapuntoventa.setice_valor(0.0);	
				detallefacturapuntoventa.setsub_total(0.0);	
				detallefacturapuntoventa.settotal(0.0);	
				detallefacturapuntoventa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleFacturaPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleFacturaPuntoVenta(String sTipo,Row row,Workbook workbook,DetalleFacturaPuntoVenta detallefacturapuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getfacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturapuntoventa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleFacturaPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleFacturaPuntoVenta() {
		return this.sFinalQueryDetalleFacturaPuntoVenta;
	}
	
	public void setsFinalQueryDetalleFacturaPuntoVenta(String sFinalQueryDetalleFacturaPuntoVenta) {
		this.sFinalQueryDetalleFacturaPuntoVenta= sFinalQueryDetalleFacturaPuntoVenta;
	}
	
	public Border resaltarSeleccionarDetalleFacturaPuntoVenta=null;
	
	public Border setResaltarSeleccionarDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleFacturaPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleFacturaPuntoVenta() {
		return this.resaltarSeleccionarDetalleFacturaPuntoVenta;
	}
	
	public void setResaltarSeleccionarDetalleFacturaPuntoVenta(Border borderResaltarSeleccionarDetalleFacturaPuntoVenta) {
		this.resaltarSeleccionarDetalleFacturaPuntoVenta= borderResaltarSeleccionarDetalleFacturaPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleFacturaPuntoVenta=null;
	public Boolean mostraridDetalleFacturaPuntoVenta=true;
	public Boolean activaridDetalleFacturaPuntoVenta=true;

	public Border resaltarid_factura_punto_ventaDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_factura_punto_ventaDetalleFacturaPuntoVenta=true;
	public Boolean activarid_factura_punto_ventaDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_factura_punto_ventaDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factura_punto_ventaDetalleFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_empresaDetalleFacturaPuntoVenta=true;
	public Boolean activarid_empresaDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_empresaDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_sucursalDetalleFacturaPuntoVenta=true;
	public Boolean activarid_sucursalDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_sucursalDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_bodegaDetalleFacturaPuntoVenta=true;
	public Boolean activarid_bodegaDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_bodegaDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleFacturaPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_productoDetalleFacturaPuntoVenta=true;
	public Boolean activarid_productoDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_productoDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleFacturaPuntoVenta=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleFacturaPuntoVenta=null;
	public Boolean mostrarid_unidadDetalleFacturaPuntoVenta=true;
	public Boolean activarid_unidadDetalleFacturaPuntoVenta=true;
	public Boolean cargarid_unidadDetalleFacturaPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleFacturaPuntoVenta=true;//ConEventDepend=true

	public Border resaltarserieDetalleFacturaPuntoVenta=null;
	public Boolean mostrarserieDetalleFacturaPuntoVenta=true;
	public Boolean activarserieDetalleFacturaPuntoVenta=true;

	public Border resaltarcantidadDetalleFacturaPuntoVenta=null;
	public Boolean mostrarcantidadDetalleFacturaPuntoVenta=true;
	public Boolean activarcantidadDetalleFacturaPuntoVenta=true;

	public Border resaltarprecioDetalleFacturaPuntoVenta=null;
	public Boolean mostrarprecioDetalleFacturaPuntoVenta=true;
	public Boolean activarprecioDetalleFacturaPuntoVenta=true;

	public Border resaltardescuentoDetalleFacturaPuntoVenta=null;
	public Boolean mostrardescuentoDetalleFacturaPuntoVenta=true;
	public Boolean activardescuentoDetalleFacturaPuntoVenta=true;

	public Border resaltardescuento_valorDetalleFacturaPuntoVenta=null;
	public Boolean mostrardescuento_valorDetalleFacturaPuntoVenta=true;
	public Boolean activardescuento_valorDetalleFacturaPuntoVenta=true;

	public Border resaltarivaDetalleFacturaPuntoVenta=null;
	public Boolean mostrarivaDetalleFacturaPuntoVenta=true;
	public Boolean activarivaDetalleFacturaPuntoVenta=true;

	public Border resaltariva_valorDetalleFacturaPuntoVenta=null;
	public Boolean mostrariva_valorDetalleFacturaPuntoVenta=true;
	public Boolean activariva_valorDetalleFacturaPuntoVenta=true;

	public Border resaltariceDetalleFacturaPuntoVenta=null;
	public Boolean mostrariceDetalleFacturaPuntoVenta=true;
	public Boolean activariceDetalleFacturaPuntoVenta=true;

	public Border resaltarice_valorDetalleFacturaPuntoVenta=null;
	public Boolean mostrarice_valorDetalleFacturaPuntoVenta=true;
	public Boolean activarice_valorDetalleFacturaPuntoVenta=true;

	public Border resaltarsub_totalDetalleFacturaPuntoVenta=null;
	public Boolean mostrarsub_totalDetalleFacturaPuntoVenta=true;
	public Boolean activarsub_totalDetalleFacturaPuntoVenta=true;

	public Border resaltartotalDetalleFacturaPuntoVenta=null;
	public Boolean mostrartotalDetalleFacturaPuntoVenta=true;
	public Boolean activartotalDetalleFacturaPuntoVenta=true;

	public Border resaltardescripcionDetalleFacturaPuntoVenta=null;
	public Boolean mostrardescripcionDetalleFacturaPuntoVenta=true;
	public Boolean activardescripcionDetalleFacturaPuntoVenta=true;

	
	

	public Border setResaltaridDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleFacturaPuntoVenta() {
		return this.resaltaridDetalleFacturaPuntoVenta;
	}

	public void setResaltaridDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltaridDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridDetalleFacturaPuntoVenta() {
		return this.mostraridDetalleFacturaPuntoVenta;
	}

	public void setMostraridDetalleFacturaPuntoVenta(Boolean mostraridDetalleFacturaPuntoVenta) {
		this.mostraridDetalleFacturaPuntoVenta= mostraridDetalleFacturaPuntoVenta;
	}

	public Boolean getActivaridDetalleFacturaPuntoVenta() {
		return this.activaridDetalleFacturaPuntoVenta;
	}

	public void setActivaridDetalleFacturaPuntoVenta(Boolean activaridDetalleFacturaPuntoVenta) {
		this.activaridDetalleFacturaPuntoVenta= activaridDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_factura_punto_ventaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_factura_punto_ventaDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factura_punto_ventaDetalleFacturaPuntoVenta() {
		return this.resaltarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_factura_punto_ventaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_factura_punto_ventaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_factura_punto_ventaDetalleFacturaPuntoVenta() {
		return this.mostrarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_factura_punto_ventaDetalleFacturaPuntoVenta(Boolean mostrarid_factura_punto_ventaDetalleFacturaPuntoVenta) {
		this.mostrarid_factura_punto_ventaDetalleFacturaPuntoVenta= mostrarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_factura_punto_ventaDetalleFacturaPuntoVenta() {
		return this.activarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public void setActivarid_factura_punto_ventaDetalleFacturaPuntoVenta(Boolean activarid_factura_punto_ventaDetalleFacturaPuntoVenta) {
		this.activarid_factura_punto_ventaDetalleFacturaPuntoVenta= activarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_factura_punto_ventaDetalleFacturaPuntoVenta() {
		return this.cargarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public void setCargarid_factura_punto_ventaDetalleFacturaPuntoVenta(Boolean cargarid_factura_punto_ventaDetalleFacturaPuntoVenta) {
		this.cargarid_factura_punto_ventaDetalleFacturaPuntoVenta= cargarid_factura_punto_ventaDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_empresaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleFacturaPuntoVenta() {
		return this.resaltarid_empresaDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_empresaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleFacturaPuntoVenta() {
		return this.mostrarid_empresaDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_empresaDetalleFacturaPuntoVenta(Boolean mostrarid_empresaDetalleFacturaPuntoVenta) {
		this.mostrarid_empresaDetalleFacturaPuntoVenta= mostrarid_empresaDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_empresaDetalleFacturaPuntoVenta() {
		return this.activarid_empresaDetalleFacturaPuntoVenta;
	}

	public void setActivarid_empresaDetalleFacturaPuntoVenta(Boolean activarid_empresaDetalleFacturaPuntoVenta) {
		this.activarid_empresaDetalleFacturaPuntoVenta= activarid_empresaDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_empresaDetalleFacturaPuntoVenta() {
		return this.cargarid_empresaDetalleFacturaPuntoVenta;
	}

	public void setCargarid_empresaDetalleFacturaPuntoVenta(Boolean cargarid_empresaDetalleFacturaPuntoVenta) {
		this.cargarid_empresaDetalleFacturaPuntoVenta= cargarid_empresaDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_sucursalDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleFacturaPuntoVenta() {
		return this.resaltarid_sucursalDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_sucursalDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleFacturaPuntoVenta() {
		return this.mostrarid_sucursalDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_sucursalDetalleFacturaPuntoVenta(Boolean mostrarid_sucursalDetalleFacturaPuntoVenta) {
		this.mostrarid_sucursalDetalleFacturaPuntoVenta= mostrarid_sucursalDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_sucursalDetalleFacturaPuntoVenta() {
		return this.activarid_sucursalDetalleFacturaPuntoVenta;
	}

	public void setActivarid_sucursalDetalleFacturaPuntoVenta(Boolean activarid_sucursalDetalleFacturaPuntoVenta) {
		this.activarid_sucursalDetalleFacturaPuntoVenta= activarid_sucursalDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_sucursalDetalleFacturaPuntoVenta() {
		return this.cargarid_sucursalDetalleFacturaPuntoVenta;
	}

	public void setCargarid_sucursalDetalleFacturaPuntoVenta(Boolean cargarid_sucursalDetalleFacturaPuntoVenta) {
		this.cargarid_sucursalDetalleFacturaPuntoVenta= cargarid_sucursalDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_bodegaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleFacturaPuntoVenta() {
		return this.resaltarid_bodegaDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_bodegaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_bodegaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleFacturaPuntoVenta() {
		return this.mostrarid_bodegaDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_bodegaDetalleFacturaPuntoVenta(Boolean mostrarid_bodegaDetalleFacturaPuntoVenta) {
		this.mostrarid_bodegaDetalleFacturaPuntoVenta= mostrarid_bodegaDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_bodegaDetalleFacturaPuntoVenta() {
		return this.activarid_bodegaDetalleFacturaPuntoVenta;
	}

	public void setActivarid_bodegaDetalleFacturaPuntoVenta(Boolean activarid_bodegaDetalleFacturaPuntoVenta) {
		this.activarid_bodegaDetalleFacturaPuntoVenta= activarid_bodegaDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_bodegaDetalleFacturaPuntoVenta() {
		return this.cargarid_bodegaDetalleFacturaPuntoVenta;
	}

	public void setCargarid_bodegaDetalleFacturaPuntoVenta(Boolean cargarid_bodegaDetalleFacturaPuntoVenta) {
		this.cargarid_bodegaDetalleFacturaPuntoVenta= cargarid_bodegaDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_productoDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleFacturaPuntoVenta() {
		return this.resaltarid_productoDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_productoDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_productoDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleFacturaPuntoVenta() {
		return this.mostrarid_productoDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_productoDetalleFacturaPuntoVenta(Boolean mostrarid_productoDetalleFacturaPuntoVenta) {
		this.mostrarid_productoDetalleFacturaPuntoVenta= mostrarid_productoDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_productoDetalleFacturaPuntoVenta() {
		return this.activarid_productoDetalleFacturaPuntoVenta;
	}

	public void setActivarid_productoDetalleFacturaPuntoVenta(Boolean activarid_productoDetalleFacturaPuntoVenta) {
		this.activarid_productoDetalleFacturaPuntoVenta= activarid_productoDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_productoDetalleFacturaPuntoVenta() {
		return this.cargarid_productoDetalleFacturaPuntoVenta;
	}

	public void setCargarid_productoDetalleFacturaPuntoVenta(Boolean cargarid_productoDetalleFacturaPuntoVenta) {
		this.cargarid_productoDetalleFacturaPuntoVenta= cargarid_productoDetalleFacturaPuntoVenta;
	}

	public Border setResaltarid_unidadDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleFacturaPuntoVenta() {
		return this.resaltarid_unidadDetalleFacturaPuntoVenta;
	}

	public void setResaltarid_unidadDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarid_unidadDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleFacturaPuntoVenta() {
		return this.mostrarid_unidadDetalleFacturaPuntoVenta;
	}

	public void setMostrarid_unidadDetalleFacturaPuntoVenta(Boolean mostrarid_unidadDetalleFacturaPuntoVenta) {
		this.mostrarid_unidadDetalleFacturaPuntoVenta= mostrarid_unidadDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarid_unidadDetalleFacturaPuntoVenta() {
		return this.activarid_unidadDetalleFacturaPuntoVenta;
	}

	public void setActivarid_unidadDetalleFacturaPuntoVenta(Boolean activarid_unidadDetalleFacturaPuntoVenta) {
		this.activarid_unidadDetalleFacturaPuntoVenta= activarid_unidadDetalleFacturaPuntoVenta;
	}

	public Boolean getCargarid_unidadDetalleFacturaPuntoVenta() {
		return this.cargarid_unidadDetalleFacturaPuntoVenta;
	}

	public void setCargarid_unidadDetalleFacturaPuntoVenta(Boolean cargarid_unidadDetalleFacturaPuntoVenta) {
		this.cargarid_unidadDetalleFacturaPuntoVenta= cargarid_unidadDetalleFacturaPuntoVenta;
	}

	public Border setResaltarserieDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarserieDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleFacturaPuntoVenta() {
		return this.resaltarserieDetalleFacturaPuntoVenta;
	}

	public void setResaltarserieDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarserieDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarserieDetalleFacturaPuntoVenta() {
		return this.mostrarserieDetalleFacturaPuntoVenta;
	}

	public void setMostrarserieDetalleFacturaPuntoVenta(Boolean mostrarserieDetalleFacturaPuntoVenta) {
		this.mostrarserieDetalleFacturaPuntoVenta= mostrarserieDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarserieDetalleFacturaPuntoVenta() {
		return this.activarserieDetalleFacturaPuntoVenta;
	}

	public void setActivarserieDetalleFacturaPuntoVenta(Boolean activarserieDetalleFacturaPuntoVenta) {
		this.activarserieDetalleFacturaPuntoVenta= activarserieDetalleFacturaPuntoVenta;
	}

	public Border setResaltarcantidadDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleFacturaPuntoVenta() {
		return this.resaltarcantidadDetalleFacturaPuntoVenta;
	}

	public void setResaltarcantidadDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarcantidadDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleFacturaPuntoVenta() {
		return this.mostrarcantidadDetalleFacturaPuntoVenta;
	}

	public void setMostrarcantidadDetalleFacturaPuntoVenta(Boolean mostrarcantidadDetalleFacturaPuntoVenta) {
		this.mostrarcantidadDetalleFacturaPuntoVenta= mostrarcantidadDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarcantidadDetalleFacturaPuntoVenta() {
		return this.activarcantidadDetalleFacturaPuntoVenta;
	}

	public void setActivarcantidadDetalleFacturaPuntoVenta(Boolean activarcantidadDetalleFacturaPuntoVenta) {
		this.activarcantidadDetalleFacturaPuntoVenta= activarcantidadDetalleFacturaPuntoVenta;
	}

	public Border setResaltarprecioDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleFacturaPuntoVenta() {
		return this.resaltarprecioDetalleFacturaPuntoVenta;
	}

	public void setResaltarprecioDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarprecioDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleFacturaPuntoVenta() {
		return this.mostrarprecioDetalleFacturaPuntoVenta;
	}

	public void setMostrarprecioDetalleFacturaPuntoVenta(Boolean mostrarprecioDetalleFacturaPuntoVenta) {
		this.mostrarprecioDetalleFacturaPuntoVenta= mostrarprecioDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarprecioDetalleFacturaPuntoVenta() {
		return this.activarprecioDetalleFacturaPuntoVenta;
	}

	public void setActivarprecioDetalleFacturaPuntoVenta(Boolean activarprecioDetalleFacturaPuntoVenta) {
		this.activarprecioDetalleFacturaPuntoVenta= activarprecioDetalleFacturaPuntoVenta;
	}

	public Border setResaltardescuentoDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleFacturaPuntoVenta() {
		return this.resaltardescuentoDetalleFacturaPuntoVenta;
	}

	public void setResaltardescuentoDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleFacturaPuntoVenta() {
		return this.mostrardescuentoDetalleFacturaPuntoVenta;
	}

	public void setMostrardescuentoDetalleFacturaPuntoVenta(Boolean mostrardescuentoDetalleFacturaPuntoVenta) {
		this.mostrardescuentoDetalleFacturaPuntoVenta= mostrardescuentoDetalleFacturaPuntoVenta;
	}

	public Boolean getActivardescuentoDetalleFacturaPuntoVenta() {
		return this.activardescuentoDetalleFacturaPuntoVenta;
	}

	public void setActivardescuentoDetalleFacturaPuntoVenta(Boolean activardescuentoDetalleFacturaPuntoVenta) {
		this.activardescuentoDetalleFacturaPuntoVenta= activardescuentoDetalleFacturaPuntoVenta;
	}

	public Border setResaltardescuento_valorDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetalleFacturaPuntoVenta() {
		return this.resaltardescuento_valorDetalleFacturaPuntoVenta;
	}

	public void setResaltardescuento_valorDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardescuento_valorDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetalleFacturaPuntoVenta() {
		return this.mostrardescuento_valorDetalleFacturaPuntoVenta;
	}

	public void setMostrardescuento_valorDetalleFacturaPuntoVenta(Boolean mostrardescuento_valorDetalleFacturaPuntoVenta) {
		this.mostrardescuento_valorDetalleFacturaPuntoVenta= mostrardescuento_valorDetalleFacturaPuntoVenta;
	}

	public Boolean getActivardescuento_valorDetalleFacturaPuntoVenta() {
		return this.activardescuento_valorDetalleFacturaPuntoVenta;
	}

	public void setActivardescuento_valorDetalleFacturaPuntoVenta(Boolean activardescuento_valorDetalleFacturaPuntoVenta) {
		this.activardescuento_valorDetalleFacturaPuntoVenta= activardescuento_valorDetalleFacturaPuntoVenta;
	}

	public Border setResaltarivaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleFacturaPuntoVenta() {
		return this.resaltarivaDetalleFacturaPuntoVenta;
	}

	public void setResaltarivaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarivaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaDetalleFacturaPuntoVenta() {
		return this.mostrarivaDetalleFacturaPuntoVenta;
	}

	public void setMostrarivaDetalleFacturaPuntoVenta(Boolean mostrarivaDetalleFacturaPuntoVenta) {
		this.mostrarivaDetalleFacturaPuntoVenta= mostrarivaDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarivaDetalleFacturaPuntoVenta() {
		return this.activarivaDetalleFacturaPuntoVenta;
	}

	public void setActivarivaDetalleFacturaPuntoVenta(Boolean activarivaDetalleFacturaPuntoVenta) {
		this.activarivaDetalleFacturaPuntoVenta= activarivaDetalleFacturaPuntoVenta;
	}

	public Border setResaltariva_valorDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariva_valorDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleFacturaPuntoVenta() {
		return this.resaltariva_valorDetalleFacturaPuntoVenta;
	}

	public void setResaltariva_valorDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltariva_valorDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleFacturaPuntoVenta() {
		return this.mostrariva_valorDetalleFacturaPuntoVenta;
	}

	public void setMostrariva_valorDetalleFacturaPuntoVenta(Boolean mostrariva_valorDetalleFacturaPuntoVenta) {
		this.mostrariva_valorDetalleFacturaPuntoVenta= mostrariva_valorDetalleFacturaPuntoVenta;
	}

	public Boolean getActivariva_valorDetalleFacturaPuntoVenta() {
		return this.activariva_valorDetalleFacturaPuntoVenta;
	}

	public void setActivariva_valorDetalleFacturaPuntoVenta(Boolean activariva_valorDetalleFacturaPuntoVenta) {
		this.activariva_valorDetalleFacturaPuntoVenta= activariva_valorDetalleFacturaPuntoVenta;
	}

	public Border setResaltariceDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariceDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleFacturaPuntoVenta() {
		return this.resaltariceDetalleFacturaPuntoVenta;
	}

	public void setResaltariceDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltariceDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariceDetalleFacturaPuntoVenta() {
		return this.mostrariceDetalleFacturaPuntoVenta;
	}

	public void setMostrariceDetalleFacturaPuntoVenta(Boolean mostrariceDetalleFacturaPuntoVenta) {
		this.mostrariceDetalleFacturaPuntoVenta= mostrariceDetalleFacturaPuntoVenta;
	}

	public Boolean getActivariceDetalleFacturaPuntoVenta() {
		return this.activariceDetalleFacturaPuntoVenta;
	}

	public void setActivariceDetalleFacturaPuntoVenta(Boolean activariceDetalleFacturaPuntoVenta) {
		this.activariceDetalleFacturaPuntoVenta= activariceDetalleFacturaPuntoVenta;
	}

	public Border setResaltarice_valorDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarice_valorDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleFacturaPuntoVenta() {
		return this.resaltarice_valorDetalleFacturaPuntoVenta;
	}

	public void setResaltarice_valorDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarice_valorDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleFacturaPuntoVenta() {
		return this.mostrarice_valorDetalleFacturaPuntoVenta;
	}

	public void setMostrarice_valorDetalleFacturaPuntoVenta(Boolean mostrarice_valorDetalleFacturaPuntoVenta) {
		this.mostrarice_valorDetalleFacturaPuntoVenta= mostrarice_valorDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarice_valorDetalleFacturaPuntoVenta() {
		return this.activarice_valorDetalleFacturaPuntoVenta;
	}

	public void setActivarice_valorDetalleFacturaPuntoVenta(Boolean activarice_valorDetalleFacturaPuntoVenta) {
		this.activarice_valorDetalleFacturaPuntoVenta= activarice_valorDetalleFacturaPuntoVenta;
	}

	public Border setResaltarsub_totalDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetalleFacturaPuntoVenta() {
		return this.resaltarsub_totalDetalleFacturaPuntoVenta;
	}

	public void setResaltarsub_totalDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetalleFacturaPuntoVenta() {
		return this.mostrarsub_totalDetalleFacturaPuntoVenta;
	}

	public void setMostrarsub_totalDetalleFacturaPuntoVenta(Boolean mostrarsub_totalDetalleFacturaPuntoVenta) {
		this.mostrarsub_totalDetalleFacturaPuntoVenta= mostrarsub_totalDetalleFacturaPuntoVenta;
	}

	public Boolean getActivarsub_totalDetalleFacturaPuntoVenta() {
		return this.activarsub_totalDetalleFacturaPuntoVenta;
	}

	public void setActivarsub_totalDetalleFacturaPuntoVenta(Boolean activarsub_totalDetalleFacturaPuntoVenta) {
		this.activarsub_totalDetalleFacturaPuntoVenta= activarsub_totalDetalleFacturaPuntoVenta;
	}

	public Border setResaltartotalDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleFacturaPuntoVenta() {
		return this.resaltartotalDetalleFacturaPuntoVenta;
	}

	public void setResaltartotalDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltartotalDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalDetalleFacturaPuntoVenta() {
		return this.mostrartotalDetalleFacturaPuntoVenta;
	}

	public void setMostrartotalDetalleFacturaPuntoVenta(Boolean mostrartotalDetalleFacturaPuntoVenta) {
		this.mostrartotalDetalleFacturaPuntoVenta= mostrartotalDetalleFacturaPuntoVenta;
	}

	public Boolean getActivartotalDetalleFacturaPuntoVenta() {
		return this.activartotalDetalleFacturaPuntoVenta;
	}

	public void setActivartotalDetalleFacturaPuntoVenta(Boolean activartotalDetalleFacturaPuntoVenta) {
		this.activartotalDetalleFacturaPuntoVenta= activartotalDetalleFacturaPuntoVenta;
	}

	public Border setResaltardescripcionDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturapuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleFacturaPuntoVenta() {
		return this.resaltardescripcionDetalleFacturaPuntoVenta;
	}

	public void setResaltardescripcionDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardescripcionDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleFacturaPuntoVenta() {
		return this.mostrardescripcionDetalleFacturaPuntoVenta;
	}

	public void setMostrardescripcionDetalleFacturaPuntoVenta(Boolean mostrardescripcionDetalleFacturaPuntoVenta) {
		this.mostrardescripcionDetalleFacturaPuntoVenta= mostrardescripcionDetalleFacturaPuntoVenta;
	}

	public Boolean getActivardescripcionDetalleFacturaPuntoVenta() {
		return this.activardescripcionDetalleFacturaPuntoVenta;
	}

	public void setActivardescripcionDetalleFacturaPuntoVenta(Boolean activardescripcionDetalleFacturaPuntoVenta) {
		this.activardescripcionDetalleFacturaPuntoVenta= activardescripcionDetalleFacturaPuntoVenta;
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
		
		
		this.setMostraridDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_factura_punto_ventaDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_empresaDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_sucursalDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_bodegaDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_productoDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarid_unidadDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarserieDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarcantidadDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarprecioDetalleFacturaPuntoVenta(esInicial);
		this.setMostrardescuentoDetalleFacturaPuntoVenta(esInicial);
		this.setMostrardescuento_valorDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarivaDetalleFacturaPuntoVenta(esInicial);
		this.setMostrariva_valorDetalleFacturaPuntoVenta(esInicial);
		this.setMostrariceDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarice_valorDetalleFacturaPuntoVenta(esInicial);
		this.setMostrarsub_totalDetalleFacturaPuntoVenta(esInicial);
		this.setMostrartotalDetalleFacturaPuntoVenta(esInicial);
		this.setMostrardescripcionDetalleFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setMostrarid_factura_punto_ventaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setMostrariceDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleFacturaPuntoVenta(esAsigna);
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
		
		
		this.setActivaridDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_factura_punto_ventaDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_empresaDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_sucursalDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_bodegaDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_productoDetalleFacturaPuntoVenta(esInicial);
		this.setActivarid_unidadDetalleFacturaPuntoVenta(esInicial);
		this.setActivarserieDetalleFacturaPuntoVenta(esInicial);
		this.setActivarcantidadDetalleFacturaPuntoVenta(esInicial);
		this.setActivarprecioDetalleFacturaPuntoVenta(esInicial);
		this.setActivardescuentoDetalleFacturaPuntoVenta(esInicial);
		this.setActivardescuento_valorDetalleFacturaPuntoVenta(esInicial);
		this.setActivarivaDetalleFacturaPuntoVenta(esInicial);
		this.setActivariva_valorDetalleFacturaPuntoVenta(esInicial);
		this.setActivariceDetalleFacturaPuntoVenta(esInicial);
		this.setActivarice_valorDetalleFacturaPuntoVenta(esInicial);
		this.setActivarsub_totalDetalleFacturaPuntoVenta(esInicial);
		this.setActivartotalDetalleFacturaPuntoVenta(esInicial);
		this.setActivardescripcionDetalleFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setActivarid_factura_punto_ventaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setActivariceDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_factura_punto_ventaDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_empresaDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_sucursalDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_bodegaDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_productoDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarid_unidadDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarserieDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarcantidadDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarprecioDetalleFacturaPuntoVenta(esInicial);
		this.setResaltardescuentoDetalleFacturaPuntoVenta(esInicial);
		this.setResaltardescuento_valorDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarivaDetalleFacturaPuntoVenta(esInicial);
		this.setResaltariva_valorDetalleFacturaPuntoVenta(esInicial);
		this.setResaltariceDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarice_valorDetalleFacturaPuntoVenta(esInicial);
		this.setResaltarsub_totalDetalleFacturaPuntoVenta(esInicial);
		this.setResaltartotalDetalleFacturaPuntoVenta(esInicial);
		this.setResaltardescripcionDetalleFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setResaltarid_factura_punto_ventaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltariceDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleFacturaPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdBodegaDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdBodegaDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdBodegaDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdEmpresaDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdProductoDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdProductoDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdProductoDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdSucursalDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdSucursalDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleFacturaPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleFacturaPuntoVenta=true;

	public Boolean getMostrarFK_IdUnidadDetalleFacturaPuntoVenta() {
		return this.mostrarFK_IdUnidadDetalleFacturaPuntoVenta;
	}

	public void setMostrarFK_IdUnidadDetalleFacturaPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleFacturaPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdBodegaDetalleFacturaPuntoVenta() {
		return this.activarFK_IdBodegaDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdBodegaDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaDetalleFacturaPuntoVenta() {
		return this.activarFK_IdEmpresaDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdEmpresaDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta() {
		return this.activarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdProductoDetalleFacturaPuntoVenta() {
		return this.activarFK_IdProductoDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdProductoDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalDetalleFacturaPuntoVenta() {
		return this.activarFK_IdSucursalDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdSucursalDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleFacturaPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleFacturaPuntoVenta=true;

	public Boolean getActivarFK_IdUnidadDetalleFacturaPuntoVenta() {
		return this.activarFK_IdUnidadDetalleFacturaPuntoVenta;
	}

	public void setActivarFK_IdUnidadDetalleFacturaPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleFacturaPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdBodegaDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdBodegaDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdBodegaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdEmpresaDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaPuntoVentaDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdProductoDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdProductoDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdProductoDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdSucursalDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdSucursalDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdSucursalDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleFacturaPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleFacturaPuntoVenta=null;

	public Border getResaltarFK_IdUnidadDetalleFacturaPuntoVenta() {
		return this.resaltarFK_IdUnidadDetalleFacturaPuntoVenta;
	}

	public void setResaltarFK_IdUnidadDetalleFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleFacturaPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaPuntoVentaBeanSwingJInternalFrame detallefacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleFacturaPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}