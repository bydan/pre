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


import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaParameterGeneral;

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
final public class DetalleNotaCreditoPuntoVentaConstantesFunciones extends DetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleNotaCreditoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleNotaCreditoPuntoVenta"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleNotaCreditoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleNotaCreditoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleNotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleNotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleNotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleNotaCreditoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleNotaCreditoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleNotaCreditoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleNotaCreditoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleNotaCreditoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleNotaCreditoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Nota Credito Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleNotaCreditoPuntoVenta";
	public static final String OBJECTNAME="detallenotacreditopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="detalle_nota_credito_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallenotacreditopuntoventa from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallenotacreditopuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional detallenotacreditopuntoventaConstantesFuncionesAdditional=null;
	
	public DetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional getDetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional() {
		return this.detallenotacreditopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setDetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional(DetalleNotaCreditoPuntoVentaConstantesFuncionesAdditional detallenotacreditopuntoventaConstantesFuncionesAdditional) {
		try {
			this.detallenotacreditopuntoventaConstantesFuncionesAdditional=detallenotacreditopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDNOTACREDITOPUNTOVENTA= "id_factura_punto_venta";
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
    	public static final String LABEL_IDNOTACREDITOPUNTOVENTA= "Nota Credito";
		public static final String LABEL_IDNOTACREDITOPUNTOVENTA_LOWER= "Nota Credito Punto Venta";
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
	
	public static String getDetalleNotaCreditoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDNOTACREDITOPUNTOVENTA;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleNotaCreditoPuntoVentaDescripcion(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallenotacreditopuntoventa !=null/* && detallenotacreditopuntoventa.getId()!=0*/) {
			if(detallenotacreditopuntoventa.getId()!=null) {
				sDescripcion=detallenotacreditopuntoventa.getId().toString();
			}//detallenotacreditopuntoventadetallenotacreditopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleNotaCreditoPuntoVentaDescripcionDetallado(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=detallenotacreditopuntoventa.getId().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallenotacreditopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_factura_punto_venta().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_bodega().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_producto().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallenotacreditopuntoventa.getid_unidad().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE+"=";
		sDescripcion+=detallenotacreditopuntoventa.getserie()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallenotacreditopuntoventa.getcantidad().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallenotacreditopuntoventa.getprecio().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallenotacreditopuntoventa.getdescuento().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallenotacreditopuntoventa.getdescuento_valor().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=detallenotacreditopuntoventa.getiva().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallenotacreditopuntoventa.getiva_valor().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=detallenotacreditopuntoventa.getice().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallenotacreditopuntoventa.getice_valor().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detallenotacreditopuntoventa.getsub_total().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallenotacreditopuntoventa.gettotal().toString()+",";
		sDescripcion+=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallenotacreditopuntoventa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleNotaCreditoPuntoVentaDescripcion(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,String sValor) throws Exception {			
		if(detallenotacreditopuntoventa !=null) {
			//detallenotacreditopuntoventadetallenotacreditopuntoventa.getId().toString();
		}		
	}
	
		

	public static String getNotaCreditoPuntoVentaDescripcion(NotaCreditoPuntoVenta notacreditopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(notacreditopuntoventa!=null/*&&notacreditopuntoventa.getId()>0*/) {
			sDescripcion=NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaDescripcion(notacreditopuntoventa);
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
		} else if(sNombreIndice.equals("FK_IdNotaCreditoPuntoVenta")) {
			sNombreIndice="Tipo=  Por Nota Credito";
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

	public static String getDetalleIndiceFK_IdNotaCreditoPuntoVenta(Long id_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Nota Credito="+id_factura_punto_venta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallenotacreditopuntoventa.setserie(detallenotacreditopuntoventa.getserie().trim());
		detallenotacreditopuntoventa.setdescripcion(detallenotacreditopuntoventa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa: detallenotacreditopuntoventas) {
			detallenotacreditopuntoventa.setserie(detallenotacreditopuntoventa.getserie().trim());
			detallenotacreditopuntoventa.setdescripcion(detallenotacreditopuntoventa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallenotacreditopuntoventa.getConCambioAuxiliar()) {
			detallenotacreditopuntoventa.setIsDeleted(detallenotacreditopuntoventa.getIsDeletedAuxiliar());	
			detallenotacreditopuntoventa.setIsNew(detallenotacreditopuntoventa.getIsNewAuxiliar());	
			detallenotacreditopuntoventa.setIsChanged(detallenotacreditopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallenotacreditopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallenotacreditopuntoventa.setIsDeletedAuxiliar(false);	
			detallenotacreditopuntoventa.setIsNewAuxiliar(false);	
			detallenotacreditopuntoventa.setIsChangedAuxiliar(false);
			
			detallenotacreditopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa : detallenotacreditopuntoventas) {
			if(conAsignarBase && detallenotacreditopuntoventa.getConCambioAuxiliar()) {
				detallenotacreditopuntoventa.setIsDeleted(detallenotacreditopuntoventa.getIsDeletedAuxiliar());	
				detallenotacreditopuntoventa.setIsNew(detallenotacreditopuntoventa.getIsNewAuxiliar());	
				detallenotacreditopuntoventa.setIsChanged(detallenotacreditopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallenotacreditopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallenotacreditopuntoventa.setIsDeletedAuxiliar(false);	
				detallenotacreditopuntoventa.setIsNewAuxiliar(false);	
				detallenotacreditopuntoventa.setIsChangedAuxiliar(false);
				
				detallenotacreditopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean conEnteros) throws Exception  {
		detallenotacreditopuntoventa.setprecio(0.0);
		detallenotacreditopuntoventa.setdescuento(0.0);
		detallenotacreditopuntoventa.setdescuento_valor(0.0);
		detallenotacreditopuntoventa.setiva(0.0);
		detallenotacreditopuntoventa.setiva_valor(0.0);
		detallenotacreditopuntoventa.setice(0.0);
		detallenotacreditopuntoventa.setice_valor(0.0);
		detallenotacreditopuntoventa.setsub_total(0.0);
		detallenotacreditopuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallenotacreditopuntoventa.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa: detallenotacreditopuntoventas) {
			detallenotacreditopuntoventa.setprecio(0.0);
			detallenotacreditopuntoventa.setdescuento(0.0);
			detallenotacreditopuntoventa.setdescuento_valor(0.0);
			detallenotacreditopuntoventa.setiva(0.0);
			detallenotacreditopuntoventa.setiva_valor(0.0);
			detallenotacreditopuntoventa.setice(0.0);
			detallenotacreditopuntoventa.setice_valor(0.0);
			detallenotacreditopuntoventa.setsub_total(0.0);
			detallenotacreditopuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallenotacreditopuntoventa.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux) throws Exception  {
		DetalleNotaCreditoPuntoVentaConstantesFunciones.InicializarValoresDetalleNotaCreditoPuntoVenta(detallenotacreditopuntoventaAux,true);
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa: detallenotacreditopuntoventas) {
			if(detallenotacreditopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallenotacreditopuntoventaAux.setcantidad(detallenotacreditopuntoventaAux.getcantidad()+detallenotacreditopuntoventa.getcantidad());			
			detallenotacreditopuntoventaAux.setprecio(detallenotacreditopuntoventaAux.getprecio()+detallenotacreditopuntoventa.getprecio());			
			detallenotacreditopuntoventaAux.setdescuento(detallenotacreditopuntoventaAux.getdescuento()+detallenotacreditopuntoventa.getdescuento());			
			detallenotacreditopuntoventaAux.setdescuento_valor(detallenotacreditopuntoventaAux.getdescuento_valor()+detallenotacreditopuntoventa.getdescuento_valor());			
			detallenotacreditopuntoventaAux.setiva(detallenotacreditopuntoventaAux.getiva()+detallenotacreditopuntoventa.getiva());			
			detallenotacreditopuntoventaAux.setiva_valor(detallenotacreditopuntoventaAux.getiva_valor()+detallenotacreditopuntoventa.getiva_valor());			
			detallenotacreditopuntoventaAux.setice(detallenotacreditopuntoventaAux.getice()+detallenotacreditopuntoventa.getice());			
			detallenotacreditopuntoventaAux.setice_valor(detallenotacreditopuntoventaAux.getice_valor()+detallenotacreditopuntoventa.getice_valor());			
			detallenotacreditopuntoventaAux.setsub_total(detallenotacreditopuntoventaAux.getsub_total()+detallenotacreditopuntoventa.getsub_total());			
			detallenotacreditopuntoventaAux.settotal(detallenotacreditopuntoventaAux.gettotal()+detallenotacreditopuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleNotaCreditoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesDetalleNotaCreditoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleNotaCreditoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux: detallenotacreditopuntoventas) {
			if(detallenotacreditopuntoventaAux!=null && detallenotacreditopuntoventa!=null) {
				if((detallenotacreditopuntoventaAux.getId()==null && detallenotacreditopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallenotacreditopuntoventaAux.getId()!=null && detallenotacreditopuntoventa.getId()!=null){
					if(detallenotacreditopuntoventaAux.getId().equals(detallenotacreditopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) throws Exception  {
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
	
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa: detallenotacreditopuntoventas) {			
			if(detallenotacreditopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallenotacreditopuntoventa.getprecio();
			descuentoTotal+=detallenotacreditopuntoventa.getdescuento();
			descuento_valorTotal+=detallenotacreditopuntoventa.getdescuento_valor();
			ivaTotal+=detallenotacreditopuntoventa.getiva();
			iva_valorTotal+=detallenotacreditopuntoventa.getiva_valor();
			iceTotal+=detallenotacreditopuntoventa.getice();
			ice_valorTotal+=detallenotacreditopuntoventa.getice_valor();
			sub_totalTotal+=detallenotacreditopuntoventa.getsub_total();
			totalTotal+=detallenotacreditopuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleNotaCreditoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ID, DetalleNotaCreditoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, DetalleNotaCreditoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDNOTACREDITOPUNTOVENTA, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDBODEGA, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD, DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SERIE, DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_CANTIDAD, DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO, DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO, DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR, DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA, DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR, DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE, DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR, DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL, DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION, DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleNotaCreditoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleNotaCreditoPuntoVenta() throws Exception  {
		return DetalleNotaCreditoPuntoVentaConstantesFunciones.getTiposSeleccionarDetalleNotaCreditoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleNotaCreditoPuntoVenta(Boolean conFk) throws Exception  {
		return DetalleNotaCreditoPuntoVentaConstantesFunciones.getTiposSeleccionarDetalleNotaCreditoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleNotaCreditoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDNOTACREDITOPUNTOVENTA);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDNOTACREDITOPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleNotaCreditoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux) throws Exception {
		
			detallenotacreditopuntoventaAux.setnotacreditopuntoventa_descripcion(NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaDescripcion(detallenotacreditopuntoventaAux.getNotaCreditoPuntoVenta()));
			detallenotacreditopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallenotacreditopuntoventaAux.getEmpresa()));
			detallenotacreditopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallenotacreditopuntoventaAux.getSucursal()));
			detallenotacreditopuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallenotacreditopuntoventaAux.getBodega()));
			detallenotacreditopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallenotacreditopuntoventaAux.getProducto()));
			detallenotacreditopuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallenotacreditopuntoventaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventasTemp) throws Exception {
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux:detallenotacreditopuntoventasTemp) {
			
			detallenotacreditopuntoventaAux.setnotacreditopuntoventa_descripcion(NotaCreditoPuntoVentaConstantesFunciones.getNotaCreditoPuntoVentaDescripcion(detallenotacreditopuntoventaAux.getNotaCreditoPuntoVenta()));
			detallenotacreditopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallenotacreditopuntoventaAux.getEmpresa()));
			detallenotacreditopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallenotacreditopuntoventaAux.getSucursal()));
			detallenotacreditopuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallenotacreditopuntoventaAux.getBodega()));
			detallenotacreditopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallenotacreditopuntoventaAux.getProducto()));
			detallenotacreditopuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallenotacreditopuntoventaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
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

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetalleNotaCreditoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleNotaCreditoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleNotaCreditoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleNotaCreditoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleNotaCreditoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaEncontrado=null;
			
			for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal:detallenotacreditopuntoventas) {
				if(detallenotacreditopuntoventaLocal.getId().equals(detallenotacreditopuntoventa.getId())) {
					detallenotacreditopuntoventaEncontrado=detallenotacreditopuntoventaLocal;
					
					detallenotacreditopuntoventaLocal.setIsChanged(detallenotacreditopuntoventa.getIsChanged());
					detallenotacreditopuntoventaLocal.setIsNew(detallenotacreditopuntoventa.getIsNew());
					detallenotacreditopuntoventaLocal.setIsDeleted(detallenotacreditopuntoventa.getIsDeleted());
					
					detallenotacreditopuntoventaLocal.setGeneralEntityOriginal(detallenotacreditopuntoventa.getGeneralEntityOriginal());
					
					detallenotacreditopuntoventaLocal.setId(detallenotacreditopuntoventa.getId());	
					detallenotacreditopuntoventaLocal.setVersionRow(detallenotacreditopuntoventa.getVersionRow());	
					detallenotacreditopuntoventaLocal.setid_factura_punto_venta(detallenotacreditopuntoventa.getid_factura_punto_venta());	
					detallenotacreditopuntoventaLocal.setid_empresa(detallenotacreditopuntoventa.getid_empresa());	
					detallenotacreditopuntoventaLocal.setid_sucursal(detallenotacreditopuntoventa.getid_sucursal());	
					detallenotacreditopuntoventaLocal.setid_bodega(detallenotacreditopuntoventa.getid_bodega());	
					detallenotacreditopuntoventaLocal.setid_producto(detallenotacreditopuntoventa.getid_producto());	
					detallenotacreditopuntoventaLocal.setid_unidad(detallenotacreditopuntoventa.getid_unidad());	
					detallenotacreditopuntoventaLocal.setserie(detallenotacreditopuntoventa.getserie());	
					detallenotacreditopuntoventaLocal.setcantidad(detallenotacreditopuntoventa.getcantidad());	
					detallenotacreditopuntoventaLocal.setprecio(detallenotacreditopuntoventa.getprecio());	
					detallenotacreditopuntoventaLocal.setdescuento(detallenotacreditopuntoventa.getdescuento());	
					detallenotacreditopuntoventaLocal.setdescuento_valor(detallenotacreditopuntoventa.getdescuento_valor());	
					detallenotacreditopuntoventaLocal.setiva(detallenotacreditopuntoventa.getiva());	
					detallenotacreditopuntoventaLocal.setiva_valor(detallenotacreditopuntoventa.getiva_valor());	
					detallenotacreditopuntoventaLocal.setice(detallenotacreditopuntoventa.getice());	
					detallenotacreditopuntoventaLocal.setice_valor(detallenotacreditopuntoventa.getice_valor());	
					detallenotacreditopuntoventaLocal.setsub_total(detallenotacreditopuntoventa.getsub_total());	
					detallenotacreditopuntoventaLocal.settotal(detallenotacreditopuntoventa.gettotal());	
					detallenotacreditopuntoventaLocal.setdescripcion(detallenotacreditopuntoventa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallenotacreditopuntoventa.getIsDeleted()) {
				if(!existe) {
					detallenotacreditopuntoventas.add(detallenotacreditopuntoventa);
				}
			} else {
				if(detallenotacreditopuntoventaEncontrado!=null && permiteQuitar)  {
					detallenotacreditopuntoventas.remove(detallenotacreditopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) throws Exception {
		try	{			
			for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaLocal:detallenotacreditopuntoventas) {
				if(detallenotacreditopuntoventaLocal.getId().equals(detallenotacreditopuntoventa.getId())) {
					detallenotacreditopuntoventaLocal.setIsSelected(detallenotacreditopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleNotaCreditoPuntoVenta(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventasAux) throws Exception {
		//this.detallenotacreditopuntoventasAux=detallenotacreditopuntoventasAux;
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux:detallenotacreditopuntoventasAux) {
			if(detallenotacreditopuntoventaAux.getIsChanged()) {
				detallenotacreditopuntoventaAux.setIsChanged(false);
			}		
			
			if(detallenotacreditopuntoventaAux.getIsNew()) {
				detallenotacreditopuntoventaAux.setIsNew(false);
			}	
			
			if(detallenotacreditopuntoventaAux.getIsDeleted()) {
				detallenotacreditopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAux) throws Exception {
		//this.detallenotacreditopuntoventaAux=detallenotacreditopuntoventaAux;
		
			if(detallenotacreditopuntoventaAux.getIsChanged()) {
				detallenotacreditopuntoventaAux.setIsChanged(false);
			}		
			
			if(detallenotacreditopuntoventaAux.getIsNew()) {
				detallenotacreditopuntoventaAux.setIsNew(false);
			}	
			
			if(detallenotacreditopuntoventaAux.getIsDeleted()) {
				detallenotacreditopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventaAsignar,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		detallenotacreditopuntoventaAsignar.setId(detallenotacreditopuntoventa.getId());	
		detallenotacreditopuntoventaAsignar.setVersionRow(detallenotacreditopuntoventa.getVersionRow());	
		detallenotacreditopuntoventaAsignar.setid_factura_punto_venta(detallenotacreditopuntoventa.getid_factura_punto_venta());
		detallenotacreditopuntoventaAsignar.setnotacreditopuntoventa_descripcion(detallenotacreditopuntoventa.getnotacreditopuntoventa_descripcion());	
		detallenotacreditopuntoventaAsignar.setid_empresa(detallenotacreditopuntoventa.getid_empresa());
		detallenotacreditopuntoventaAsignar.setempresa_descripcion(detallenotacreditopuntoventa.getempresa_descripcion());	
		detallenotacreditopuntoventaAsignar.setid_sucursal(detallenotacreditopuntoventa.getid_sucursal());
		detallenotacreditopuntoventaAsignar.setsucursal_descripcion(detallenotacreditopuntoventa.getsucursal_descripcion());	
		detallenotacreditopuntoventaAsignar.setid_bodega(detallenotacreditopuntoventa.getid_bodega());
		detallenotacreditopuntoventaAsignar.setbodega_descripcion(detallenotacreditopuntoventa.getbodega_descripcion());	
		detallenotacreditopuntoventaAsignar.setid_producto(detallenotacreditopuntoventa.getid_producto());
		detallenotacreditopuntoventaAsignar.setproducto_descripcion(detallenotacreditopuntoventa.getproducto_descripcion());	
		detallenotacreditopuntoventaAsignar.setid_unidad(detallenotacreditopuntoventa.getid_unidad());
		detallenotacreditopuntoventaAsignar.setunidad_descripcion(detallenotacreditopuntoventa.getunidad_descripcion());	
		detallenotacreditopuntoventaAsignar.setserie(detallenotacreditopuntoventa.getserie());	
		detallenotacreditopuntoventaAsignar.setcantidad(detallenotacreditopuntoventa.getcantidad());	
		detallenotacreditopuntoventaAsignar.setprecio(detallenotacreditopuntoventa.getprecio());	
		detallenotacreditopuntoventaAsignar.setdescuento(detallenotacreditopuntoventa.getdescuento());	
		detallenotacreditopuntoventaAsignar.setdescuento_valor(detallenotacreditopuntoventa.getdescuento_valor());	
		detallenotacreditopuntoventaAsignar.setiva(detallenotacreditopuntoventa.getiva());	
		detallenotacreditopuntoventaAsignar.setiva_valor(detallenotacreditopuntoventa.getiva_valor());	
		detallenotacreditopuntoventaAsignar.setice(detallenotacreditopuntoventa.getice());	
		detallenotacreditopuntoventaAsignar.setice_valor(detallenotacreditopuntoventa.getice_valor());	
		detallenotacreditopuntoventaAsignar.setsub_total(detallenotacreditopuntoventa.getsub_total());	
		detallenotacreditopuntoventaAsignar.settotal(detallenotacreditopuntoventa.gettotal());	
		detallenotacreditopuntoventaAsignar.setdescripcion(detallenotacreditopuntoventa.getdescripcion());	
	}
	
	public static void inicializarDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		try {
				detallenotacreditopuntoventa.setId(0L);	
					
				detallenotacreditopuntoventa.setid_factura_punto_venta(-1L);	
				detallenotacreditopuntoventa.setid_empresa(-1L);	
				detallenotacreditopuntoventa.setid_sucursal(-1L);	
				detallenotacreditopuntoventa.setid_bodega(-1L);	
				detallenotacreditopuntoventa.setid_producto(-1L);	
				detallenotacreditopuntoventa.setid_unidad(-1L);	
				detallenotacreditopuntoventa.setserie("");	
				detallenotacreditopuntoventa.setcantidad(0);	
				detallenotacreditopuntoventa.setprecio(0.0);	
				detallenotacreditopuntoventa.setdescuento(0.0);	
				detallenotacreditopuntoventa.setdescuento_valor(0.0);	
				detallenotacreditopuntoventa.setiva(0.0);	
				detallenotacreditopuntoventa.setiva_valor(0.0);	
				detallenotacreditopuntoventa.setice(0.0);	
				detallenotacreditopuntoventa.setice_valor(0.0);	
				detallenotacreditopuntoventa.setsub_total(0.0);	
				detallenotacreditopuntoventa.settotal(0.0);	
				detallenotacreditopuntoventa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleNotaCreditoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDNOTACREDITOPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleNotaCreditoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleNotaCreditoPuntoVenta(String sTipo,Row row,Workbook workbook,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getnotacreditopuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallenotacreditopuntoventa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleNotaCreditoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleNotaCreditoPuntoVenta() {
		return this.sFinalQueryDetalleNotaCreditoPuntoVenta;
	}
	
	public void setsFinalQueryDetalleNotaCreditoPuntoVenta(String sFinalQueryDetalleNotaCreditoPuntoVenta) {
		this.sFinalQueryDetalleNotaCreditoPuntoVenta= sFinalQueryDetalleNotaCreditoPuntoVenta;
	}
	
	public Border resaltarSeleccionarDetalleNotaCreditoPuntoVenta=null;
	
	public Border setResaltarSeleccionarDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleNotaCreditoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleNotaCreditoPuntoVenta() {
		return this.resaltarSeleccionarDetalleNotaCreditoPuntoVenta;
	}
	
	public void setResaltarSeleccionarDetalleNotaCreditoPuntoVenta(Border borderResaltarSeleccionarDetalleNotaCreditoPuntoVenta) {
		this.resaltarSeleccionarDetalleNotaCreditoPuntoVenta= borderResaltarSeleccionarDetalleNotaCreditoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostraridDetalleNotaCreditoPuntoVenta=true;
	public Boolean activaridDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factura_punto_ventaDetalleNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_empresaDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_empresaDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_empresaDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_sucursalDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_sucursalDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_sucursalDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_bodegaDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_bodegaDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_bodegaDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleNotaCreditoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_productoDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_productoDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_productoDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleNotaCreditoPuntoVenta=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarid_unidadDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarid_unidadDetalleNotaCreditoPuntoVenta=true;
	public Boolean cargarid_unidadDetalleNotaCreditoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleNotaCreditoPuntoVenta=true;//ConEventDepend=true

	public Border resaltarserieDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarserieDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarserieDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarcantidadDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarcantidadDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarcantidadDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarprecioDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarprecioDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarprecioDetalleNotaCreditoPuntoVenta=true;

	public Border resaltardescuentoDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrardescuentoDetalleNotaCreditoPuntoVenta=true;
	public Boolean activardescuentoDetalleNotaCreditoPuntoVenta=true;

	public Border resaltardescuento_valorDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrardescuento_valorDetalleNotaCreditoPuntoVenta=true;
	public Boolean activardescuento_valorDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarivaDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarivaDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarivaDetalleNotaCreditoPuntoVenta=true;

	public Border resaltariva_valorDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrariva_valorDetalleNotaCreditoPuntoVenta=true;
	public Boolean activariva_valorDetalleNotaCreditoPuntoVenta=true;

	public Border resaltariceDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrariceDetalleNotaCreditoPuntoVenta=true;
	public Boolean activariceDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarice_valorDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarice_valorDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarice_valorDetalleNotaCreditoPuntoVenta=true;

	public Border resaltarsub_totalDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrarsub_totalDetalleNotaCreditoPuntoVenta=true;
	public Boolean activarsub_totalDetalleNotaCreditoPuntoVenta=true;

	public Border resaltartotalDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrartotalDetalleNotaCreditoPuntoVenta=true;
	public Boolean activartotalDetalleNotaCreditoPuntoVenta=true;

	public Border resaltardescripcionDetalleNotaCreditoPuntoVenta=null;
	public Boolean mostrardescripcionDetalleNotaCreditoPuntoVenta=true;
	public Boolean activardescripcionDetalleNotaCreditoPuntoVenta=true;

	
	

	public Border setResaltaridDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleNotaCreditoPuntoVenta() {
		return this.resaltaridDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltaridDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltaridDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridDetalleNotaCreditoPuntoVenta() {
		return this.mostraridDetalleNotaCreditoPuntoVenta;
	}

	public void setMostraridDetalleNotaCreditoPuntoVenta(Boolean mostraridDetalleNotaCreditoPuntoVenta) {
		this.mostraridDetalleNotaCreditoPuntoVenta= mostraridDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivaridDetalleNotaCreditoPuntoVenta() {
		return this.activaridDetalleNotaCreditoPuntoVenta;
	}

	public void setActivaridDetalleNotaCreditoPuntoVenta(Boolean activaridDetalleNotaCreditoPuntoVenta) {
		this.activaridDetalleNotaCreditoPuntoVenta= activaridDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(Boolean mostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta= mostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta() {
		return this.activarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(Boolean activarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta) {
		this.activarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta= activarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(Boolean cargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta) {
		this.cargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta= cargarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_empresaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_empresaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_empresaDetalleNotaCreditoPuntoVenta(Boolean mostrarid_empresaDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_empresaDetalleNotaCreditoPuntoVenta= mostrarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_empresaDetalleNotaCreditoPuntoVenta() {
		return this.activarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_empresaDetalleNotaCreditoPuntoVenta(Boolean activarid_empresaDetalleNotaCreditoPuntoVenta) {
		this.activarid_empresaDetalleNotaCreditoPuntoVenta= activarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_empresaDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_empresaDetalleNotaCreditoPuntoVenta(Boolean cargarid_empresaDetalleNotaCreditoPuntoVenta) {
		this.cargarid_empresaDetalleNotaCreditoPuntoVenta= cargarid_empresaDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_sucursalDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_sucursalDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_sucursalDetalleNotaCreditoPuntoVenta(Boolean mostrarid_sucursalDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_sucursalDetalleNotaCreditoPuntoVenta= mostrarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_sucursalDetalleNotaCreditoPuntoVenta() {
		return this.activarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_sucursalDetalleNotaCreditoPuntoVenta(Boolean activarid_sucursalDetalleNotaCreditoPuntoVenta) {
		this.activarid_sucursalDetalleNotaCreditoPuntoVenta= activarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_sucursalDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_sucursalDetalleNotaCreditoPuntoVenta(Boolean cargarid_sucursalDetalleNotaCreditoPuntoVenta) {
		this.cargarid_sucursalDetalleNotaCreditoPuntoVenta= cargarid_sucursalDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_bodegaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_bodegaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_bodegaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_bodegaDetalleNotaCreditoPuntoVenta(Boolean mostrarid_bodegaDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_bodegaDetalleNotaCreditoPuntoVenta= mostrarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_bodegaDetalleNotaCreditoPuntoVenta() {
		return this.activarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_bodegaDetalleNotaCreditoPuntoVenta(Boolean activarid_bodegaDetalleNotaCreditoPuntoVenta) {
		this.activarid_bodegaDetalleNotaCreditoPuntoVenta= activarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_bodegaDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_bodegaDetalleNotaCreditoPuntoVenta(Boolean cargarid_bodegaDetalleNotaCreditoPuntoVenta) {
		this.cargarid_bodegaDetalleNotaCreditoPuntoVenta= cargarid_bodegaDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_productoDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_productoDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_productoDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_productoDetalleNotaCreditoPuntoVenta(Boolean mostrarid_productoDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_productoDetalleNotaCreditoPuntoVenta= mostrarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_productoDetalleNotaCreditoPuntoVenta() {
		return this.activarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_productoDetalleNotaCreditoPuntoVenta(Boolean activarid_productoDetalleNotaCreditoPuntoVenta) {
		this.activarid_productoDetalleNotaCreditoPuntoVenta= activarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_productoDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_productoDetalleNotaCreditoPuntoVenta(Boolean cargarid_productoDetalleNotaCreditoPuntoVenta) {
		this.cargarid_productoDetalleNotaCreditoPuntoVenta= cargarid_productoDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarid_unidadDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleNotaCreditoPuntoVenta() {
		return this.resaltarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarid_unidadDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarid_unidadDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleNotaCreditoPuntoVenta() {
		return this.mostrarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarid_unidadDetalleNotaCreditoPuntoVenta(Boolean mostrarid_unidadDetalleNotaCreditoPuntoVenta) {
		this.mostrarid_unidadDetalleNotaCreditoPuntoVenta= mostrarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarid_unidadDetalleNotaCreditoPuntoVenta() {
		return this.activarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarid_unidadDetalleNotaCreditoPuntoVenta(Boolean activarid_unidadDetalleNotaCreditoPuntoVenta) {
		this.activarid_unidadDetalleNotaCreditoPuntoVenta= activarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getCargarid_unidadDetalleNotaCreditoPuntoVenta() {
		return this.cargarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public void setCargarid_unidadDetalleNotaCreditoPuntoVenta(Boolean cargarid_unidadDetalleNotaCreditoPuntoVenta) {
		this.cargarid_unidadDetalleNotaCreditoPuntoVenta= cargarid_unidadDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarserieDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarserieDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleNotaCreditoPuntoVenta() {
		return this.resaltarserieDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarserieDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarserieDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarserieDetalleNotaCreditoPuntoVenta() {
		return this.mostrarserieDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarserieDetalleNotaCreditoPuntoVenta(Boolean mostrarserieDetalleNotaCreditoPuntoVenta) {
		this.mostrarserieDetalleNotaCreditoPuntoVenta= mostrarserieDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarserieDetalleNotaCreditoPuntoVenta() {
		return this.activarserieDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarserieDetalleNotaCreditoPuntoVenta(Boolean activarserieDetalleNotaCreditoPuntoVenta) {
		this.activarserieDetalleNotaCreditoPuntoVenta= activarserieDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarcantidadDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleNotaCreditoPuntoVenta() {
		return this.resaltarcantidadDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarcantidadDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarcantidadDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleNotaCreditoPuntoVenta() {
		return this.mostrarcantidadDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarcantidadDetalleNotaCreditoPuntoVenta(Boolean mostrarcantidadDetalleNotaCreditoPuntoVenta) {
		this.mostrarcantidadDetalleNotaCreditoPuntoVenta= mostrarcantidadDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarcantidadDetalleNotaCreditoPuntoVenta() {
		return this.activarcantidadDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarcantidadDetalleNotaCreditoPuntoVenta(Boolean activarcantidadDetalleNotaCreditoPuntoVenta) {
		this.activarcantidadDetalleNotaCreditoPuntoVenta= activarcantidadDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarprecioDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleNotaCreditoPuntoVenta() {
		return this.resaltarprecioDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarprecioDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarprecioDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleNotaCreditoPuntoVenta() {
		return this.mostrarprecioDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarprecioDetalleNotaCreditoPuntoVenta(Boolean mostrarprecioDetalleNotaCreditoPuntoVenta) {
		this.mostrarprecioDetalleNotaCreditoPuntoVenta= mostrarprecioDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarprecioDetalleNotaCreditoPuntoVenta() {
		return this.activarprecioDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarprecioDetalleNotaCreditoPuntoVenta(Boolean activarprecioDetalleNotaCreditoPuntoVenta) {
		this.activarprecioDetalleNotaCreditoPuntoVenta= activarprecioDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltardescuentoDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleNotaCreditoPuntoVenta() {
		return this.resaltardescuentoDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltardescuentoDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleNotaCreditoPuntoVenta() {
		return this.mostrardescuentoDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrardescuentoDetalleNotaCreditoPuntoVenta(Boolean mostrardescuentoDetalleNotaCreditoPuntoVenta) {
		this.mostrardescuentoDetalleNotaCreditoPuntoVenta= mostrardescuentoDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivardescuentoDetalleNotaCreditoPuntoVenta() {
		return this.activardescuentoDetalleNotaCreditoPuntoVenta;
	}

	public void setActivardescuentoDetalleNotaCreditoPuntoVenta(Boolean activardescuentoDetalleNotaCreditoPuntoVenta) {
		this.activardescuentoDetalleNotaCreditoPuntoVenta= activardescuentoDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltardescuento_valorDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetalleNotaCreditoPuntoVenta() {
		return this.resaltardescuento_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltardescuento_valorDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltardescuento_valorDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetalleNotaCreditoPuntoVenta() {
		return this.mostrardescuento_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrardescuento_valorDetalleNotaCreditoPuntoVenta(Boolean mostrardescuento_valorDetalleNotaCreditoPuntoVenta) {
		this.mostrardescuento_valorDetalleNotaCreditoPuntoVenta= mostrardescuento_valorDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivardescuento_valorDetalleNotaCreditoPuntoVenta() {
		return this.activardescuento_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setActivardescuento_valorDetalleNotaCreditoPuntoVenta(Boolean activardescuento_valorDetalleNotaCreditoPuntoVenta) {
		this.activardescuento_valorDetalleNotaCreditoPuntoVenta= activardescuento_valorDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarivaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarivaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarivaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarivaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarivaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarivaDetalleNotaCreditoPuntoVenta(Boolean mostrarivaDetalleNotaCreditoPuntoVenta) {
		this.mostrarivaDetalleNotaCreditoPuntoVenta= mostrarivaDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarivaDetalleNotaCreditoPuntoVenta() {
		return this.activarivaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarivaDetalleNotaCreditoPuntoVenta(Boolean activarivaDetalleNotaCreditoPuntoVenta) {
		this.activarivaDetalleNotaCreditoPuntoVenta= activarivaDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltariva_valorDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariva_valorDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleNotaCreditoPuntoVenta() {
		return this.resaltariva_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltariva_valorDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltariva_valorDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleNotaCreditoPuntoVenta() {
		return this.mostrariva_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrariva_valorDetalleNotaCreditoPuntoVenta(Boolean mostrariva_valorDetalleNotaCreditoPuntoVenta) {
		this.mostrariva_valorDetalleNotaCreditoPuntoVenta= mostrariva_valorDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivariva_valorDetalleNotaCreditoPuntoVenta() {
		return this.activariva_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setActivariva_valorDetalleNotaCreditoPuntoVenta(Boolean activariva_valorDetalleNotaCreditoPuntoVenta) {
		this.activariva_valorDetalleNotaCreditoPuntoVenta= activariva_valorDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltariceDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariceDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleNotaCreditoPuntoVenta() {
		return this.resaltariceDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltariceDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltariceDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariceDetalleNotaCreditoPuntoVenta() {
		return this.mostrariceDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrariceDetalleNotaCreditoPuntoVenta(Boolean mostrariceDetalleNotaCreditoPuntoVenta) {
		this.mostrariceDetalleNotaCreditoPuntoVenta= mostrariceDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivariceDetalleNotaCreditoPuntoVenta() {
		return this.activariceDetalleNotaCreditoPuntoVenta;
	}

	public void setActivariceDetalleNotaCreditoPuntoVenta(Boolean activariceDetalleNotaCreditoPuntoVenta) {
		this.activariceDetalleNotaCreditoPuntoVenta= activariceDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarice_valorDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarice_valorDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleNotaCreditoPuntoVenta() {
		return this.resaltarice_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarice_valorDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarice_valorDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleNotaCreditoPuntoVenta() {
		return this.mostrarice_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarice_valorDetalleNotaCreditoPuntoVenta(Boolean mostrarice_valorDetalleNotaCreditoPuntoVenta) {
		this.mostrarice_valorDetalleNotaCreditoPuntoVenta= mostrarice_valorDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarice_valorDetalleNotaCreditoPuntoVenta() {
		return this.activarice_valorDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarice_valorDetalleNotaCreditoPuntoVenta(Boolean activarice_valorDetalleNotaCreditoPuntoVenta) {
		this.activarice_valorDetalleNotaCreditoPuntoVenta= activarice_valorDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltarsub_totalDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetalleNotaCreditoPuntoVenta() {
		return this.resaltarsub_totalDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarsub_totalDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetalleNotaCreditoPuntoVenta() {
		return this.mostrarsub_totalDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarsub_totalDetalleNotaCreditoPuntoVenta(Boolean mostrarsub_totalDetalleNotaCreditoPuntoVenta) {
		this.mostrarsub_totalDetalleNotaCreditoPuntoVenta= mostrarsub_totalDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivarsub_totalDetalleNotaCreditoPuntoVenta() {
		return this.activarsub_totalDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarsub_totalDetalleNotaCreditoPuntoVenta(Boolean activarsub_totalDetalleNotaCreditoPuntoVenta) {
		this.activarsub_totalDetalleNotaCreditoPuntoVenta= activarsub_totalDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltartotalDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleNotaCreditoPuntoVenta() {
		return this.resaltartotalDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltartotalDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltartotalDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalDetalleNotaCreditoPuntoVenta() {
		return this.mostrartotalDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrartotalDetalleNotaCreditoPuntoVenta(Boolean mostrartotalDetalleNotaCreditoPuntoVenta) {
		this.mostrartotalDetalleNotaCreditoPuntoVenta= mostrartotalDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivartotalDetalleNotaCreditoPuntoVenta() {
		return this.activartotalDetalleNotaCreditoPuntoVenta;
	}

	public void setActivartotalDetalleNotaCreditoPuntoVenta(Boolean activartotalDetalleNotaCreditoPuntoVenta) {
		this.activartotalDetalleNotaCreditoPuntoVenta= activartotalDetalleNotaCreditoPuntoVenta;
	}

	public Border setResaltardescripcionDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallenotacreditopuntoventaBeanSwingJInternalFrame.jTtoolBarDetalleNotaCreditoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleNotaCreditoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleNotaCreditoPuntoVenta() {
		return this.resaltardescripcionDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltardescripcionDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltardescripcionDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleNotaCreditoPuntoVenta() {
		return this.mostrardescripcionDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrardescripcionDetalleNotaCreditoPuntoVenta(Boolean mostrardescripcionDetalleNotaCreditoPuntoVenta) {
		this.mostrardescripcionDetalleNotaCreditoPuntoVenta= mostrardescripcionDetalleNotaCreditoPuntoVenta;
	}

	public Boolean getActivardescripcionDetalleNotaCreditoPuntoVenta() {
		return this.activardescripcionDetalleNotaCreditoPuntoVenta;
	}

	public void setActivardescripcionDetalleNotaCreditoPuntoVenta(Boolean activardescripcionDetalleNotaCreditoPuntoVenta) {
		this.activardescripcionDetalleNotaCreditoPuntoVenta= activardescripcionDetalleNotaCreditoPuntoVenta;
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
		
		
		this.setMostraridDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_empresaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_sucursalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_bodegaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_productoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarid_unidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarserieDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarcantidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarprecioDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrardescuentoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrardescuento_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarivaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrariva_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrariceDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarice_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrarsub_totalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrartotalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setMostrardescripcionDetalleNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA)) {
				this.setMostrarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setMostrariceDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleNotaCreditoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_empresaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_sucursalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_bodegaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_productoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarid_unidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarserieDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarcantidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarprecioDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivardescuentoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivardescuento_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarivaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivariva_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivariceDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarice_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivarsub_totalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivartotalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setActivardescripcionDetalleNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA)) {
				this.setActivarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setActivariceDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_empresaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_sucursalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_bodegaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_productoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarid_unidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarserieDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarcantidadDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarprecioDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltardescuentoDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltardescuento_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarivaDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltariva_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltariceDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarice_valorDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltarsub_totalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltartotalDetalleNotaCreditoPuntoVenta(esInicial);
		this.setResaltardescripcionDetalleNotaCreditoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA)) {
				this.setResaltarid_factura_punto_ventaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltariceDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleNotaCreditoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleNotaCreditoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdBodegaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdBodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdBodegaDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdEmpresaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdProductoDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdProductoDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdProductoDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdSucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleNotaCreditoPuntoVenta=true;

	public Boolean getMostrarFK_IdUnidadDetalleNotaCreditoPuntoVenta() {
		return this.mostrarFK_IdUnidadDetalleNotaCreditoPuntoVenta;
	}

	public void setMostrarFK_IdUnidadDetalleNotaCreditoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleNotaCreditoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdBodegaDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdBodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdBodegaDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdEmpresaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdProductoDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdProductoDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdProductoDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdSucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdSucursalDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleNotaCreditoPuntoVenta=true;

	public Boolean getActivarFK_IdUnidadDetalleNotaCreditoPuntoVenta() {
		return this.activarFK_IdUnidadDetalleNotaCreditoPuntoVenta;
	}

	public void setActivarFK_IdUnidadDetalleNotaCreditoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleNotaCreditoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNotaCreditoPuntoVentaDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdProductoDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdProductoDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdProductoDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta=null;

	public Border getResaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta() {
		return this.resaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta;
	}

	public void setResaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleNotaCreditoPuntoVentaBeanSwingJInternalFrame detallenotacreditopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleNotaCreditoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}