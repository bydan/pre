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


import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaParameterGeneral;

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
final public class DetallePedidoPuntoVentaConstantesFunciones extends DetallePedidoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePedidoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePedidoPuntoVenta"+DetallePedidoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePedidoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePedidoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePedidoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePedidoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pedido Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePedidoPuntoVenta";
	public static final String OBJECTNAME="detallepedidopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="detalle_pedido_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepedidopuntoventa from "+DetallePedidoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallepedidopuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_pedido_punto_venta,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".total from "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePedidoPuntoVentaConstantesFuncionesAdditional detallepedidopuntoventaConstantesFuncionesAdditional=null;
	
	public DetallePedidoPuntoVentaConstantesFuncionesAdditional getDetallePedidoPuntoVentaConstantesFuncionesAdditional() {
		return this.detallepedidopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setDetallePedidoPuntoVentaConstantesFuncionesAdditional(DetallePedidoPuntoVentaConstantesFuncionesAdditional detallepedidopuntoventaConstantesFuncionesAdditional) {
		try {
			this.detallepedidopuntoventaConstantesFuncionesAdditional=detallepedidopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPEDIDOPUNTOVENTA= "id_pedido_punto_venta";
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
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPEDIDOPUNTOVENTA= "Pedido";
		public static final String LABEL_IDPEDIDOPUNTOVENTA_LOWER= "Pedido Punto Venta";
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
	
		
		
		
		
		
		
		
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetallePedidoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPEDIDOPUNTOVENTA;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.SERIE)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.PRECIO)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetallePedidoPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePedidoPuntoVentaDescripcion(DetallePedidoPuntoVenta detallepedidopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepedidopuntoventa !=null/* && detallepedidopuntoventa.getId()!=0*/) {
			if(detallepedidopuntoventa.getId()!=null) {
				sDescripcion=detallepedidopuntoventa.getId().toString();
			}//detallepedidopuntoventadetallepedidopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePedidoPuntoVentaDescripcionDetallado(DetallePedidoPuntoVenta detallepedidopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=detallepedidopuntoventa.getId().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepedidopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepedidopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepedidopuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA+"=";
		sDescripcion+=detallepedidopuntoventa.getid_pedido_punto_venta().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallepedidopuntoventa.getid_bodega().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallepedidopuntoventa.getid_producto().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallepedidopuntoventa.getid_unidad().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.SERIE+"=";
		sDescripcion+=detallepedidopuntoventa.getserie()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallepedidopuntoventa.getcantidad().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallepedidopuntoventa.getprecio().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallepedidopuntoventa.getdescuento().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallepedidopuntoventa.getdescuento_valor().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=detallepedidopuntoventa.getiva().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallepedidopuntoventa.getiva_valor().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=detallepedidopuntoventa.getice().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallepedidopuntoventa.getice_valor().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detallepedidopuntoventa.getsub_total().toString()+",";
		sDescripcion+=DetallePedidoPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallepedidopuntoventa.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePedidoPuntoVentaDescripcion(DetallePedidoPuntoVenta detallepedidopuntoventa,String sValor) throws Exception {			
		if(detallepedidopuntoventa !=null) {
			//detallepedidopuntoventadetallepedidopuntoventa.getId().toString();
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

	public static String getPedidoPuntoVentaDescripcion(PedidoPuntoVenta pedidopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidopuntoventa!=null/*&&pedidopuntoventa.getId()>0*/) {
			sDescripcion=PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaDescripcion(pedidopuntoventa);
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
		} else if(sNombreIndice.equals("FK_IdPedidoPuntoVenta")) {
			sNombreIndice="Tipo=  Por Pedido";
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

	public static String getDetalleIndiceFK_IdPedidoPuntoVenta(Long id_pedido_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Pedido="+id_pedido_punto_venta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidopuntoventa.setserie(detallepedidopuntoventa.getserie().trim());
	}
	
	public static void quitarEspaciosDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {
			detallepedidopuntoventa.setserie(detallepedidopuntoventa.getserie().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepedidopuntoventa.getConCambioAuxiliar()) {
			detallepedidopuntoventa.setIsDeleted(detallepedidopuntoventa.getIsDeletedAuxiliar());	
			detallepedidopuntoventa.setIsNew(detallepedidopuntoventa.getIsNewAuxiliar());	
			detallepedidopuntoventa.setIsChanged(detallepedidopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepedidopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepedidopuntoventa.setIsDeletedAuxiliar(false);	
			detallepedidopuntoventa.setIsNewAuxiliar(false);	
			detallepedidopuntoventa.setIsChangedAuxiliar(false);
			
			detallepedidopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa : detallepedidopuntoventas) {
			if(conAsignarBase && detallepedidopuntoventa.getConCambioAuxiliar()) {
				detallepedidopuntoventa.setIsDeleted(detallepedidopuntoventa.getIsDeletedAuxiliar());	
				detallepedidopuntoventa.setIsNew(detallepedidopuntoventa.getIsNewAuxiliar());	
				detallepedidopuntoventa.setIsChanged(detallepedidopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepedidopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepedidopuntoventa.setIsDeletedAuxiliar(false);	
				detallepedidopuntoventa.setIsNewAuxiliar(false);	
				detallepedidopuntoventa.setIsChangedAuxiliar(false);
				
				detallepedidopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean conEnteros) throws Exception  {
		detallepedidopuntoventa.setprecio(0.0);
		detallepedidopuntoventa.setdescuento(0.0);
		detallepedidopuntoventa.setdescuento_valor(0.0);
		detallepedidopuntoventa.setiva(0.0);
		detallepedidopuntoventa.setiva_valor(0.0);
		detallepedidopuntoventa.setice(0.0);
		detallepedidopuntoventa.setice_valor(0.0);
		detallepedidopuntoventa.setsub_total(0.0);
		detallepedidopuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepedidopuntoventa.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {
			detallepedidopuntoventa.setprecio(0.0);
			detallepedidopuntoventa.setdescuento(0.0);
			detallepedidopuntoventa.setdescuento_valor(0.0);
			detallepedidopuntoventa.setiva(0.0);
			detallepedidopuntoventa.setiva_valor(0.0);
			detallepedidopuntoventa.setice(0.0);
			detallepedidopuntoventa.setice_valor(0.0);
			detallepedidopuntoventa.setsub_total(0.0);
			detallepedidopuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepedidopuntoventa.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVenta detallepedidopuntoventaAux) throws Exception  {
		DetallePedidoPuntoVentaConstantesFunciones.InicializarValoresDetallePedidoPuntoVenta(detallepedidopuntoventaAux,true);
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {
			if(detallepedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepedidopuntoventaAux.setcantidad(detallepedidopuntoventaAux.getcantidad()+detallepedidopuntoventa.getcantidad());			
			detallepedidopuntoventaAux.setprecio(detallepedidopuntoventaAux.getprecio()+detallepedidopuntoventa.getprecio());			
			detallepedidopuntoventaAux.setdescuento(detallepedidopuntoventaAux.getdescuento()+detallepedidopuntoventa.getdescuento());			
			detallepedidopuntoventaAux.setdescuento_valor(detallepedidopuntoventaAux.getdescuento_valor()+detallepedidopuntoventa.getdescuento_valor());			
			detallepedidopuntoventaAux.setiva(detallepedidopuntoventaAux.getiva()+detallepedidopuntoventa.getiva());			
			detallepedidopuntoventaAux.setiva_valor(detallepedidopuntoventaAux.getiva_valor()+detallepedidopuntoventa.getiva_valor());			
			detallepedidopuntoventaAux.setice(detallepedidopuntoventaAux.getice()+detallepedidopuntoventa.getice());			
			detallepedidopuntoventaAux.setice_valor(detallepedidopuntoventaAux.getice_valor()+detallepedidopuntoventa.getice_valor());			
			detallepedidopuntoventaAux.setsub_total(detallepedidopuntoventaAux.getsub_total()+detallepedidopuntoventa.getsub_total());			
			detallepedidopuntoventaAux.settotal(detallepedidopuntoventaAux.gettotal()+detallepedidopuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePedidoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesDetallePedidoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventaAux: detallepedidopuntoventas) {
			if(detallepedidopuntoventaAux!=null && detallepedidopuntoventa!=null) {
				if((detallepedidopuntoventaAux.getId()==null && detallepedidopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepedidopuntoventaAux.getId()!=null && detallepedidopuntoventa.getId()!=null){
					if(detallepedidopuntoventaAux.getId().equals(detallepedidopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception  {
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
	
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {			
			if(detallepedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallepedidopuntoventa.getprecio();
			descuentoTotal+=detallepedidopuntoventa.getdescuento();
			descuento_valorTotal+=detallepedidopuntoventa.getdescuento_valor();
			ivaTotal+=detallepedidopuntoventa.getiva();
			iva_valorTotal+=detallepedidopuntoventa.getiva_valor();
			iceTotal+=detallepedidopuntoventa.getice();
			ice_valorTotal+=detallepedidopuntoventa.getice_valor();
			sub_totalTotal+=detallepedidopuntoventa.getsub_total();
			totalTotal+=detallepedidopuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePedidoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_ID, DetallePedidoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, DetallePedidoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPEDIDOPUNTOVENTA, DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDBODEGA, DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO, DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD, DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_SERIE, DetallePedidoPuntoVentaConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_CANTIDAD, DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO, DetallePedidoPuntoVentaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO, DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR, DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA, DetallePedidoPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR, DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE, DetallePedidoPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR, DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL, DetallePedidoPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePedidoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoPuntoVenta() throws Exception  {
		return DetallePedidoPuntoVentaConstantesFunciones.getTiposSeleccionarDetallePedidoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoPuntoVenta(Boolean conFk) throws Exception  {
		return DetallePedidoPuntoVentaConstantesFunciones.getTiposSeleccionarDetallePedidoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPEDIDOPUNTOVENTA);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPEDIDOPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePedidoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventaAux) throws Exception {
		
			detallepedidopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidopuntoventaAux.getEmpresa()));
			detallepedidopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidopuntoventaAux.getSucursal()));
			detallepedidopuntoventaAux.setpedidopuntoventa_descripcion(PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaDescripcion(detallepedidopuntoventaAux.getPedidoPuntoVenta()));
			detallepedidopuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidopuntoventaAux.getBodega()));
			detallepedidopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidopuntoventaAux.getProducto()));
			detallepedidopuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidopuntoventaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> detallepedidopuntoventasTemp) throws Exception {
		for(DetallePedidoPuntoVenta detallepedidopuntoventaAux:detallepedidopuntoventasTemp) {
			
			detallepedidopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidopuntoventaAux.getEmpresa()));
			detallepedidopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidopuntoventaAux.getSucursal()));
			detallepedidopuntoventaAux.setpedidopuntoventa_descripcion(PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaDescripcion(detallepedidopuntoventaAux.getPedidoPuntoVenta()));
			detallepedidopuntoventaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidopuntoventaAux.getBodega()));
			detallepedidopuntoventaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidopuntoventaAux.getProducto()));
			detallepedidopuntoventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidopuntoventaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(PedidoPuntoVenta.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
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
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
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

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfDetallePedidoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePedidoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePedidoPuntoVenta detallepedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePedidoPuntoVenta detallepedidopuntoventaEncontrado=null;
			
			for(DetallePedidoPuntoVenta detallepedidopuntoventaLocal:detallepedidopuntoventas) {
				if(detallepedidopuntoventaLocal.getId().equals(detallepedidopuntoventa.getId())) {
					detallepedidopuntoventaEncontrado=detallepedidopuntoventaLocal;
					
					detallepedidopuntoventaLocal.setIsChanged(detallepedidopuntoventa.getIsChanged());
					detallepedidopuntoventaLocal.setIsNew(detallepedidopuntoventa.getIsNew());
					detallepedidopuntoventaLocal.setIsDeleted(detallepedidopuntoventa.getIsDeleted());
					
					detallepedidopuntoventaLocal.setGeneralEntityOriginal(detallepedidopuntoventa.getGeneralEntityOriginal());
					
					detallepedidopuntoventaLocal.setId(detallepedidopuntoventa.getId());	
					detallepedidopuntoventaLocal.setVersionRow(detallepedidopuntoventa.getVersionRow());	
					detallepedidopuntoventaLocal.setid_empresa(detallepedidopuntoventa.getid_empresa());	
					detallepedidopuntoventaLocal.setid_sucursal(detallepedidopuntoventa.getid_sucursal());	
					detallepedidopuntoventaLocal.setid_pedido_punto_venta(detallepedidopuntoventa.getid_pedido_punto_venta());	
					detallepedidopuntoventaLocal.setid_bodega(detallepedidopuntoventa.getid_bodega());	
					detallepedidopuntoventaLocal.setid_producto(detallepedidopuntoventa.getid_producto());	
					detallepedidopuntoventaLocal.setid_unidad(detallepedidopuntoventa.getid_unidad());	
					detallepedidopuntoventaLocal.setserie(detallepedidopuntoventa.getserie());	
					detallepedidopuntoventaLocal.setcantidad(detallepedidopuntoventa.getcantidad());	
					detallepedidopuntoventaLocal.setprecio(detallepedidopuntoventa.getprecio());	
					detallepedidopuntoventaLocal.setdescuento(detallepedidopuntoventa.getdescuento());	
					detallepedidopuntoventaLocal.setdescuento_valor(detallepedidopuntoventa.getdescuento_valor());	
					detallepedidopuntoventaLocal.setiva(detallepedidopuntoventa.getiva());	
					detallepedidopuntoventaLocal.setiva_valor(detallepedidopuntoventa.getiva_valor());	
					detallepedidopuntoventaLocal.setice(detallepedidopuntoventa.getice());	
					detallepedidopuntoventaLocal.setice_valor(detallepedidopuntoventa.getice_valor());	
					detallepedidopuntoventaLocal.setsub_total(detallepedidopuntoventa.getsub_total());	
					detallepedidopuntoventaLocal.settotal(detallepedidopuntoventa.gettotal());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepedidopuntoventa.getIsDeleted()) {
				if(!existe) {
					detallepedidopuntoventas.add(detallepedidopuntoventa);
				}
			} else {
				if(detallepedidopuntoventaEncontrado!=null && permiteQuitar)  {
					detallepedidopuntoventas.remove(detallepedidopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePedidoPuntoVenta detallepedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception {
		try	{			
			for(DetallePedidoPuntoVenta detallepedidopuntoventaLocal:detallepedidopuntoventas) {
				if(detallepedidopuntoventaLocal.getId().equals(detallepedidopuntoventa.getId())) {
					detallepedidopuntoventaLocal.setIsSelected(detallepedidopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> detallepedidopuntoventasAux) throws Exception {
		//this.detallepedidopuntoventasAux=detallepedidopuntoventasAux;
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventaAux:detallepedidopuntoventasAux) {
			if(detallepedidopuntoventaAux.getIsChanged()) {
				detallepedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(detallepedidopuntoventaAux.getIsNew()) {
				detallepedidopuntoventaAux.setIsNew(false);
			}	
			
			if(detallepedidopuntoventaAux.getIsDeleted()) {
				detallepedidopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventaAux) throws Exception {
		//this.detallepedidopuntoventaAux=detallepedidopuntoventaAux;
		
			if(detallepedidopuntoventaAux.getIsChanged()) {
				detallepedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(detallepedidopuntoventaAux.getIsNew()) {
				detallepedidopuntoventaAux.setIsNew(false);
			}	
			
			if(detallepedidopuntoventaAux.getIsDeleted()) {
				detallepedidopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePedidoPuntoVenta detallepedidopuntoventaAsignar,DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		detallepedidopuntoventaAsignar.setId(detallepedidopuntoventa.getId());	
		detallepedidopuntoventaAsignar.setVersionRow(detallepedidopuntoventa.getVersionRow());	
		detallepedidopuntoventaAsignar.setid_empresa(detallepedidopuntoventa.getid_empresa());
		detallepedidopuntoventaAsignar.setempresa_descripcion(detallepedidopuntoventa.getempresa_descripcion());	
		detallepedidopuntoventaAsignar.setid_sucursal(detallepedidopuntoventa.getid_sucursal());
		detallepedidopuntoventaAsignar.setsucursal_descripcion(detallepedidopuntoventa.getsucursal_descripcion());	
		detallepedidopuntoventaAsignar.setid_pedido_punto_venta(detallepedidopuntoventa.getid_pedido_punto_venta());
		detallepedidopuntoventaAsignar.setpedidopuntoventa_descripcion(detallepedidopuntoventa.getpedidopuntoventa_descripcion());	
		detallepedidopuntoventaAsignar.setid_bodega(detallepedidopuntoventa.getid_bodega());
		detallepedidopuntoventaAsignar.setbodega_descripcion(detallepedidopuntoventa.getbodega_descripcion());	
		detallepedidopuntoventaAsignar.setid_producto(detallepedidopuntoventa.getid_producto());
		detallepedidopuntoventaAsignar.setproducto_descripcion(detallepedidopuntoventa.getproducto_descripcion());	
		detallepedidopuntoventaAsignar.setid_unidad(detallepedidopuntoventa.getid_unidad());
		detallepedidopuntoventaAsignar.setunidad_descripcion(detallepedidopuntoventa.getunidad_descripcion());	
		detallepedidopuntoventaAsignar.setserie(detallepedidopuntoventa.getserie());	
		detallepedidopuntoventaAsignar.setcantidad(detallepedidopuntoventa.getcantidad());	
		detallepedidopuntoventaAsignar.setprecio(detallepedidopuntoventa.getprecio());	
		detallepedidopuntoventaAsignar.setdescuento(detallepedidopuntoventa.getdescuento());	
		detallepedidopuntoventaAsignar.setdescuento_valor(detallepedidopuntoventa.getdescuento_valor());	
		detallepedidopuntoventaAsignar.setiva(detallepedidopuntoventa.getiva());	
		detallepedidopuntoventaAsignar.setiva_valor(detallepedidopuntoventa.getiva_valor());	
		detallepedidopuntoventaAsignar.setice(detallepedidopuntoventa.getice());	
		detallepedidopuntoventaAsignar.setice_valor(detallepedidopuntoventa.getice_valor());	
		detallepedidopuntoventaAsignar.setsub_total(detallepedidopuntoventa.getsub_total());	
		detallepedidopuntoventaAsignar.settotal(detallepedidopuntoventa.gettotal());	
	}
	
	public static void inicializarDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		try {
				detallepedidopuntoventa.setId(0L);	
					
				detallepedidopuntoventa.setid_empresa(-1L);	
				detallepedidopuntoventa.setid_sucursal(-1L);	
				detallepedidopuntoventa.setid_pedido_punto_venta(-1L);	
				detallepedidopuntoventa.setid_bodega(-1L);	
				detallepedidopuntoventa.setid_producto(-1L);	
				detallepedidopuntoventa.setid_unidad(-1L);	
				detallepedidopuntoventa.setserie("");	
				detallepedidopuntoventa.setcantidad(0);	
				detallepedidopuntoventa.setprecio(0.0);	
				detallepedidopuntoventa.setdescuento(0.0);	
				detallepedidopuntoventa.setdescuento_valor(0.0);	
				detallepedidopuntoventa.setiva(0.0);	
				detallepedidopuntoventa.setiva_valor(0.0);	
				detallepedidopuntoventa.setice(0.0);	
				detallepedidopuntoventa.setice_valor(0.0);	
				detallepedidopuntoventa.setsub_total(0.0);	
				detallepedidopuntoventa.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePedidoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPEDIDOPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePedidoPuntoVenta(String sTipo,Row row,Workbook workbook,DetallePedidoPuntoVenta detallepedidopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getpedidopuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidopuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePedidoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePedidoPuntoVenta() {
		return this.sFinalQueryDetallePedidoPuntoVenta;
	}
	
	public void setsFinalQueryDetallePedidoPuntoVenta(String sFinalQueryDetallePedidoPuntoVenta) {
		this.sFinalQueryDetallePedidoPuntoVenta= sFinalQueryDetallePedidoPuntoVenta;
	}
	
	public Border resaltarSeleccionarDetallePedidoPuntoVenta=null;
	
	public Border setResaltarSeleccionarDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePedidoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePedidoPuntoVenta() {
		return this.resaltarSeleccionarDetallePedidoPuntoVenta;
	}
	
	public void setResaltarSeleccionarDetallePedidoPuntoVenta(Border borderResaltarSeleccionarDetallePedidoPuntoVenta) {
		this.resaltarSeleccionarDetallePedidoPuntoVenta= borderResaltarSeleccionarDetallePedidoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePedidoPuntoVenta=null;
	public Boolean mostraridDetallePedidoPuntoVenta=true;
	public Boolean activaridDetallePedidoPuntoVenta=true;

	public Border resaltarid_empresaDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_empresaDetallePedidoPuntoVenta=true;
	public Boolean activarid_empresaDetallePedidoPuntoVenta=true;
	public Boolean cargarid_empresaDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_sucursalDetallePedidoPuntoVenta=true;
	public Boolean activarid_sucursalDetallePedidoPuntoVenta=true;
	public Boolean cargarid_sucursalDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_pedido_punto_ventaDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_pedido_punto_ventaDetallePedidoPuntoVenta=true;
	public Boolean activarid_pedido_punto_ventaDetallePedidoPuntoVenta=true;
	public Boolean cargarid_pedido_punto_ventaDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_punto_ventaDetallePedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_bodegaDetallePedidoPuntoVenta=true;
	public Boolean activarid_bodegaDetallePedidoPuntoVenta=true;
	public Boolean cargarid_bodegaDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetallePedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_productoDetallePedidoPuntoVenta=true;
	public Boolean activarid_productoDetallePedidoPuntoVenta=true;
	public Boolean cargarid_productoDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePedidoPuntoVenta=true;//ConEventDepend=true

	public Border resaltarid_unidadDetallePedidoPuntoVenta=null;
	public Boolean mostrarid_unidadDetallePedidoPuntoVenta=true;
	public Boolean activarid_unidadDetallePedidoPuntoVenta=true;
	public Boolean cargarid_unidadDetallePedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePedidoPuntoVenta=true;//ConEventDepend=true

	public Border resaltarserieDetallePedidoPuntoVenta=null;
	public Boolean mostrarserieDetallePedidoPuntoVenta=true;
	public Boolean activarserieDetallePedidoPuntoVenta=true;

	public Border resaltarcantidadDetallePedidoPuntoVenta=null;
	public Boolean mostrarcantidadDetallePedidoPuntoVenta=true;
	public Boolean activarcantidadDetallePedidoPuntoVenta=true;

	public Border resaltarprecioDetallePedidoPuntoVenta=null;
	public Boolean mostrarprecioDetallePedidoPuntoVenta=true;
	public Boolean activarprecioDetallePedidoPuntoVenta=true;

	public Border resaltardescuentoDetallePedidoPuntoVenta=null;
	public Boolean mostrardescuentoDetallePedidoPuntoVenta=true;
	public Boolean activardescuentoDetallePedidoPuntoVenta=true;

	public Border resaltardescuento_valorDetallePedidoPuntoVenta=null;
	public Boolean mostrardescuento_valorDetallePedidoPuntoVenta=true;
	public Boolean activardescuento_valorDetallePedidoPuntoVenta=true;

	public Border resaltarivaDetallePedidoPuntoVenta=null;
	public Boolean mostrarivaDetallePedidoPuntoVenta=true;
	public Boolean activarivaDetallePedidoPuntoVenta=true;

	public Border resaltariva_valorDetallePedidoPuntoVenta=null;
	public Boolean mostrariva_valorDetallePedidoPuntoVenta=true;
	public Boolean activariva_valorDetallePedidoPuntoVenta=true;

	public Border resaltariceDetallePedidoPuntoVenta=null;
	public Boolean mostrariceDetallePedidoPuntoVenta=true;
	public Boolean activariceDetallePedidoPuntoVenta=true;

	public Border resaltarice_valorDetallePedidoPuntoVenta=null;
	public Boolean mostrarice_valorDetallePedidoPuntoVenta=true;
	public Boolean activarice_valorDetallePedidoPuntoVenta=true;

	public Border resaltarsub_totalDetallePedidoPuntoVenta=null;
	public Boolean mostrarsub_totalDetallePedidoPuntoVenta=true;
	public Boolean activarsub_totalDetallePedidoPuntoVenta=true;

	public Border resaltartotalDetallePedidoPuntoVenta=null;
	public Boolean mostrartotalDetallePedidoPuntoVenta=true;
	public Boolean activartotalDetallePedidoPuntoVenta=true;

	
	

	public Border setResaltaridDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePedidoPuntoVenta() {
		return this.resaltaridDetallePedidoPuntoVenta;
	}

	public void setResaltaridDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltaridDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridDetallePedidoPuntoVenta() {
		return this.mostraridDetallePedidoPuntoVenta;
	}

	public void setMostraridDetallePedidoPuntoVenta(Boolean mostraridDetallePedidoPuntoVenta) {
		this.mostraridDetallePedidoPuntoVenta= mostraridDetallePedidoPuntoVenta;
	}

	public Boolean getActivaridDetallePedidoPuntoVenta() {
		return this.activaridDetallePedidoPuntoVenta;
	}

	public void setActivaridDetallePedidoPuntoVenta(Boolean activaridDetallePedidoPuntoVenta) {
		this.activaridDetallePedidoPuntoVenta= activaridDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_empresaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePedidoPuntoVenta() {
		return this.resaltarid_empresaDetallePedidoPuntoVenta;
	}

	public void setResaltarid_empresaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePedidoPuntoVenta() {
		return this.mostrarid_empresaDetallePedidoPuntoVenta;
	}

	public void setMostrarid_empresaDetallePedidoPuntoVenta(Boolean mostrarid_empresaDetallePedidoPuntoVenta) {
		this.mostrarid_empresaDetallePedidoPuntoVenta= mostrarid_empresaDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_empresaDetallePedidoPuntoVenta() {
		return this.activarid_empresaDetallePedidoPuntoVenta;
	}

	public void setActivarid_empresaDetallePedidoPuntoVenta(Boolean activarid_empresaDetallePedidoPuntoVenta) {
		this.activarid_empresaDetallePedidoPuntoVenta= activarid_empresaDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_empresaDetallePedidoPuntoVenta() {
		return this.cargarid_empresaDetallePedidoPuntoVenta;
	}

	public void setCargarid_empresaDetallePedidoPuntoVenta(Boolean cargarid_empresaDetallePedidoPuntoVenta) {
		this.cargarid_empresaDetallePedidoPuntoVenta= cargarid_empresaDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_sucursalDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePedidoPuntoVenta() {
		return this.resaltarid_sucursalDetallePedidoPuntoVenta;
	}

	public void setResaltarid_sucursalDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePedidoPuntoVenta() {
		return this.mostrarid_sucursalDetallePedidoPuntoVenta;
	}

	public void setMostrarid_sucursalDetallePedidoPuntoVenta(Boolean mostrarid_sucursalDetallePedidoPuntoVenta) {
		this.mostrarid_sucursalDetallePedidoPuntoVenta= mostrarid_sucursalDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_sucursalDetallePedidoPuntoVenta() {
		return this.activarid_sucursalDetallePedidoPuntoVenta;
	}

	public void setActivarid_sucursalDetallePedidoPuntoVenta(Boolean activarid_sucursalDetallePedidoPuntoVenta) {
		this.activarid_sucursalDetallePedidoPuntoVenta= activarid_sucursalDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_sucursalDetallePedidoPuntoVenta() {
		return this.cargarid_sucursalDetallePedidoPuntoVenta;
	}

	public void setCargarid_sucursalDetallePedidoPuntoVenta(Boolean cargarid_sucursalDetallePedidoPuntoVenta) {
		this.cargarid_sucursalDetallePedidoPuntoVenta= cargarid_sucursalDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_pedido_punto_ventaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_pedido_punto_ventaDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_punto_ventaDetallePedidoPuntoVenta() {
		return this.resaltarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public void setResaltarid_pedido_punto_ventaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_pedido_punto_ventaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_pedido_punto_ventaDetallePedidoPuntoVenta() {
		return this.mostrarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public void setMostrarid_pedido_punto_ventaDetallePedidoPuntoVenta(Boolean mostrarid_pedido_punto_ventaDetallePedidoPuntoVenta) {
		this.mostrarid_pedido_punto_ventaDetallePedidoPuntoVenta= mostrarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_pedido_punto_ventaDetallePedidoPuntoVenta() {
		return this.activarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public void setActivarid_pedido_punto_ventaDetallePedidoPuntoVenta(Boolean activarid_pedido_punto_ventaDetallePedidoPuntoVenta) {
		this.activarid_pedido_punto_ventaDetallePedidoPuntoVenta= activarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_pedido_punto_ventaDetallePedidoPuntoVenta() {
		return this.cargarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public void setCargarid_pedido_punto_ventaDetallePedidoPuntoVenta(Boolean cargarid_pedido_punto_ventaDetallePedidoPuntoVenta) {
		this.cargarid_pedido_punto_ventaDetallePedidoPuntoVenta= cargarid_pedido_punto_ventaDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_bodegaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetallePedidoPuntoVenta() {
		return this.resaltarid_bodegaDetallePedidoPuntoVenta;
	}

	public void setResaltarid_bodegaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_bodegaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetallePedidoPuntoVenta() {
		return this.mostrarid_bodegaDetallePedidoPuntoVenta;
	}

	public void setMostrarid_bodegaDetallePedidoPuntoVenta(Boolean mostrarid_bodegaDetallePedidoPuntoVenta) {
		this.mostrarid_bodegaDetallePedidoPuntoVenta= mostrarid_bodegaDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_bodegaDetallePedidoPuntoVenta() {
		return this.activarid_bodegaDetallePedidoPuntoVenta;
	}

	public void setActivarid_bodegaDetallePedidoPuntoVenta(Boolean activarid_bodegaDetallePedidoPuntoVenta) {
		this.activarid_bodegaDetallePedidoPuntoVenta= activarid_bodegaDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_bodegaDetallePedidoPuntoVenta() {
		return this.cargarid_bodegaDetallePedidoPuntoVenta;
	}

	public void setCargarid_bodegaDetallePedidoPuntoVenta(Boolean cargarid_bodegaDetallePedidoPuntoVenta) {
		this.cargarid_bodegaDetallePedidoPuntoVenta= cargarid_bodegaDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_productoDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePedidoPuntoVenta() {
		return this.resaltarid_productoDetallePedidoPuntoVenta;
	}

	public void setResaltarid_productoDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_productoDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePedidoPuntoVenta() {
		return this.mostrarid_productoDetallePedidoPuntoVenta;
	}

	public void setMostrarid_productoDetallePedidoPuntoVenta(Boolean mostrarid_productoDetallePedidoPuntoVenta) {
		this.mostrarid_productoDetallePedidoPuntoVenta= mostrarid_productoDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_productoDetallePedidoPuntoVenta() {
		return this.activarid_productoDetallePedidoPuntoVenta;
	}

	public void setActivarid_productoDetallePedidoPuntoVenta(Boolean activarid_productoDetallePedidoPuntoVenta) {
		this.activarid_productoDetallePedidoPuntoVenta= activarid_productoDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_productoDetallePedidoPuntoVenta() {
		return this.cargarid_productoDetallePedidoPuntoVenta;
	}

	public void setCargarid_productoDetallePedidoPuntoVenta(Boolean cargarid_productoDetallePedidoPuntoVenta) {
		this.cargarid_productoDetallePedidoPuntoVenta= cargarid_productoDetallePedidoPuntoVenta;
	}

	public Border setResaltarid_unidadDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePedidoPuntoVenta() {
		return this.resaltarid_unidadDetallePedidoPuntoVenta;
	}

	public void setResaltarid_unidadDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_unidadDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePedidoPuntoVenta() {
		return this.mostrarid_unidadDetallePedidoPuntoVenta;
	}

	public void setMostrarid_unidadDetallePedidoPuntoVenta(Boolean mostrarid_unidadDetallePedidoPuntoVenta) {
		this.mostrarid_unidadDetallePedidoPuntoVenta= mostrarid_unidadDetallePedidoPuntoVenta;
	}

	public Boolean getActivarid_unidadDetallePedidoPuntoVenta() {
		return this.activarid_unidadDetallePedidoPuntoVenta;
	}

	public void setActivarid_unidadDetallePedidoPuntoVenta(Boolean activarid_unidadDetallePedidoPuntoVenta) {
		this.activarid_unidadDetallePedidoPuntoVenta= activarid_unidadDetallePedidoPuntoVenta;
	}

	public Boolean getCargarid_unidadDetallePedidoPuntoVenta() {
		return this.cargarid_unidadDetallePedidoPuntoVenta;
	}

	public void setCargarid_unidadDetallePedidoPuntoVenta(Boolean cargarid_unidadDetallePedidoPuntoVenta) {
		this.cargarid_unidadDetallePedidoPuntoVenta= cargarid_unidadDetallePedidoPuntoVenta;
	}

	public Border setResaltarserieDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarserieDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetallePedidoPuntoVenta() {
		return this.resaltarserieDetallePedidoPuntoVenta;
	}

	public void setResaltarserieDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarserieDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarserieDetallePedidoPuntoVenta() {
		return this.mostrarserieDetallePedidoPuntoVenta;
	}

	public void setMostrarserieDetallePedidoPuntoVenta(Boolean mostrarserieDetallePedidoPuntoVenta) {
		this.mostrarserieDetallePedidoPuntoVenta= mostrarserieDetallePedidoPuntoVenta;
	}

	public Boolean getActivarserieDetallePedidoPuntoVenta() {
		return this.activarserieDetallePedidoPuntoVenta;
	}

	public void setActivarserieDetallePedidoPuntoVenta(Boolean activarserieDetallePedidoPuntoVenta) {
		this.activarserieDetallePedidoPuntoVenta= activarserieDetallePedidoPuntoVenta;
	}

	public Border setResaltarcantidadDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcantidadDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetallePedidoPuntoVenta() {
		return this.resaltarcantidadDetallePedidoPuntoVenta;
	}

	public void setResaltarcantidadDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarcantidadDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcantidadDetallePedidoPuntoVenta() {
		return this.mostrarcantidadDetallePedidoPuntoVenta;
	}

	public void setMostrarcantidadDetallePedidoPuntoVenta(Boolean mostrarcantidadDetallePedidoPuntoVenta) {
		this.mostrarcantidadDetallePedidoPuntoVenta= mostrarcantidadDetallePedidoPuntoVenta;
	}

	public Boolean getActivarcantidadDetallePedidoPuntoVenta() {
		return this.activarcantidadDetallePedidoPuntoVenta;
	}

	public void setActivarcantidadDetallePedidoPuntoVenta(Boolean activarcantidadDetallePedidoPuntoVenta) {
		this.activarcantidadDetallePedidoPuntoVenta= activarcantidadDetallePedidoPuntoVenta;
	}

	public Border setResaltarprecioDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarprecioDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetallePedidoPuntoVenta() {
		return this.resaltarprecioDetallePedidoPuntoVenta;
	}

	public void setResaltarprecioDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarprecioDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarprecioDetallePedidoPuntoVenta() {
		return this.mostrarprecioDetallePedidoPuntoVenta;
	}

	public void setMostrarprecioDetallePedidoPuntoVenta(Boolean mostrarprecioDetallePedidoPuntoVenta) {
		this.mostrarprecioDetallePedidoPuntoVenta= mostrarprecioDetallePedidoPuntoVenta;
	}

	public Boolean getActivarprecioDetallePedidoPuntoVenta() {
		return this.activarprecioDetallePedidoPuntoVenta;
	}

	public void setActivarprecioDetallePedidoPuntoVenta(Boolean activarprecioDetallePedidoPuntoVenta) {
		this.activarprecioDetallePedidoPuntoVenta= activarprecioDetallePedidoPuntoVenta;
	}

	public Border setResaltardescuentoDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetallePedidoPuntoVenta() {
		return this.resaltardescuentoDetallePedidoPuntoVenta;
	}

	public void setResaltardescuentoDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoDetallePedidoPuntoVenta() {
		return this.mostrardescuentoDetallePedidoPuntoVenta;
	}

	public void setMostrardescuentoDetallePedidoPuntoVenta(Boolean mostrardescuentoDetallePedidoPuntoVenta) {
		this.mostrardescuentoDetallePedidoPuntoVenta= mostrardescuentoDetallePedidoPuntoVenta;
	}

	public Boolean getActivardescuentoDetallePedidoPuntoVenta() {
		return this.activardescuentoDetallePedidoPuntoVenta;
	}

	public void setActivardescuentoDetallePedidoPuntoVenta(Boolean activardescuentoDetallePedidoPuntoVenta) {
		this.activardescuentoDetallePedidoPuntoVenta= activardescuentoDetallePedidoPuntoVenta;
	}

	public Border setResaltardescuento_valorDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetallePedidoPuntoVenta() {
		return this.resaltardescuento_valorDetallePedidoPuntoVenta;
	}

	public void setResaltardescuento_valorDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltardescuento_valorDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetallePedidoPuntoVenta() {
		return this.mostrardescuento_valorDetallePedidoPuntoVenta;
	}

	public void setMostrardescuento_valorDetallePedidoPuntoVenta(Boolean mostrardescuento_valorDetallePedidoPuntoVenta) {
		this.mostrardescuento_valorDetallePedidoPuntoVenta= mostrardescuento_valorDetallePedidoPuntoVenta;
	}

	public Boolean getActivardescuento_valorDetallePedidoPuntoVenta() {
		return this.activardescuento_valorDetallePedidoPuntoVenta;
	}

	public void setActivardescuento_valorDetallePedidoPuntoVenta(Boolean activardescuento_valorDetallePedidoPuntoVenta) {
		this.activardescuento_valorDetallePedidoPuntoVenta= activardescuento_valorDetallePedidoPuntoVenta;
	}

	public Border setResaltarivaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetallePedidoPuntoVenta() {
		return this.resaltarivaDetallePedidoPuntoVenta;
	}

	public void setResaltarivaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarivaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaDetallePedidoPuntoVenta() {
		return this.mostrarivaDetallePedidoPuntoVenta;
	}

	public void setMostrarivaDetallePedidoPuntoVenta(Boolean mostrarivaDetallePedidoPuntoVenta) {
		this.mostrarivaDetallePedidoPuntoVenta= mostrarivaDetallePedidoPuntoVenta;
	}

	public Boolean getActivarivaDetallePedidoPuntoVenta() {
		return this.activarivaDetallePedidoPuntoVenta;
	}

	public void setActivarivaDetallePedidoPuntoVenta(Boolean activarivaDetallePedidoPuntoVenta) {
		this.activarivaDetallePedidoPuntoVenta= activarivaDetallePedidoPuntoVenta;
	}

	public Border setResaltariva_valorDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariva_valorDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetallePedidoPuntoVenta() {
		return this.resaltariva_valorDetallePedidoPuntoVenta;
	}

	public void setResaltariva_valorDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltariva_valorDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariva_valorDetallePedidoPuntoVenta() {
		return this.mostrariva_valorDetallePedidoPuntoVenta;
	}

	public void setMostrariva_valorDetallePedidoPuntoVenta(Boolean mostrariva_valorDetallePedidoPuntoVenta) {
		this.mostrariva_valorDetallePedidoPuntoVenta= mostrariva_valorDetallePedidoPuntoVenta;
	}

	public Boolean getActivariva_valorDetallePedidoPuntoVenta() {
		return this.activariva_valorDetallePedidoPuntoVenta;
	}

	public void setActivariva_valorDetallePedidoPuntoVenta(Boolean activariva_valorDetallePedidoPuntoVenta) {
		this.activariva_valorDetallePedidoPuntoVenta= activariva_valorDetallePedidoPuntoVenta;
	}

	public Border setResaltariceDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltariceDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetallePedidoPuntoVenta() {
		return this.resaltariceDetallePedidoPuntoVenta;
	}

	public void setResaltariceDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltariceDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrariceDetallePedidoPuntoVenta() {
		return this.mostrariceDetallePedidoPuntoVenta;
	}

	public void setMostrariceDetallePedidoPuntoVenta(Boolean mostrariceDetallePedidoPuntoVenta) {
		this.mostrariceDetallePedidoPuntoVenta= mostrariceDetallePedidoPuntoVenta;
	}

	public Boolean getActivariceDetallePedidoPuntoVenta() {
		return this.activariceDetallePedidoPuntoVenta;
	}

	public void setActivariceDetallePedidoPuntoVenta(Boolean activariceDetallePedidoPuntoVenta) {
		this.activariceDetallePedidoPuntoVenta= activariceDetallePedidoPuntoVenta;
	}

	public Border setResaltarice_valorDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarice_valorDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetallePedidoPuntoVenta() {
		return this.resaltarice_valorDetallePedidoPuntoVenta;
	}

	public void setResaltarice_valorDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarice_valorDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarice_valorDetallePedidoPuntoVenta() {
		return this.mostrarice_valorDetallePedidoPuntoVenta;
	}

	public void setMostrarice_valorDetallePedidoPuntoVenta(Boolean mostrarice_valorDetallePedidoPuntoVenta) {
		this.mostrarice_valorDetallePedidoPuntoVenta= mostrarice_valorDetallePedidoPuntoVenta;
	}

	public Boolean getActivarice_valorDetallePedidoPuntoVenta() {
		return this.activarice_valorDetallePedidoPuntoVenta;
	}

	public void setActivarice_valorDetallePedidoPuntoVenta(Boolean activarice_valorDetallePedidoPuntoVenta) {
		this.activarice_valorDetallePedidoPuntoVenta= activarice_valorDetallePedidoPuntoVenta;
	}

	public Border setResaltarsub_totalDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetallePedidoPuntoVenta() {
		return this.resaltarsub_totalDetallePedidoPuntoVenta;
	}

	public void setResaltarsub_totalDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetallePedidoPuntoVenta() {
		return this.mostrarsub_totalDetallePedidoPuntoVenta;
	}

	public void setMostrarsub_totalDetallePedidoPuntoVenta(Boolean mostrarsub_totalDetallePedidoPuntoVenta) {
		this.mostrarsub_totalDetallePedidoPuntoVenta= mostrarsub_totalDetallePedidoPuntoVenta;
	}

	public Boolean getActivarsub_totalDetallePedidoPuntoVenta() {
		return this.activarsub_totalDetallePedidoPuntoVenta;
	}

	public void setActivarsub_totalDetallePedidoPuntoVenta(Boolean activarsub_totalDetallePedidoPuntoVenta) {
		this.activarsub_totalDetallePedidoPuntoVenta= activarsub_totalDetallePedidoPuntoVenta;
	}

	public Border setResaltartotalDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidopuntoventaBeanSwingJInternalFrame.jTtoolBarDetallePedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalDetallePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetallePedidoPuntoVenta() {
		return this.resaltartotalDetallePedidoPuntoVenta;
	}

	public void setResaltartotalDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltartotalDetallePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalDetallePedidoPuntoVenta() {
		return this.mostrartotalDetallePedidoPuntoVenta;
	}

	public void setMostrartotalDetallePedidoPuntoVenta(Boolean mostrartotalDetallePedidoPuntoVenta) {
		this.mostrartotalDetallePedidoPuntoVenta= mostrartotalDetallePedidoPuntoVenta;
	}

	public Boolean getActivartotalDetallePedidoPuntoVenta() {
		return this.activartotalDetallePedidoPuntoVenta;
	}

	public void setActivartotalDetallePedidoPuntoVenta(Boolean activartotalDetallePedidoPuntoVenta) {
		this.activartotalDetallePedidoPuntoVenta= activartotalDetallePedidoPuntoVenta;
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
		
		
		this.setMostraridDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_empresaDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_sucursalDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_pedido_punto_ventaDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_bodegaDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_productoDetallePedidoPuntoVenta(esInicial);
		this.setMostrarid_unidadDetallePedidoPuntoVenta(esInicial);
		this.setMostrarserieDetallePedidoPuntoVenta(esInicial);
		this.setMostrarcantidadDetallePedidoPuntoVenta(esInicial);
		this.setMostrarprecioDetallePedidoPuntoVenta(esInicial);
		this.setMostrardescuentoDetallePedidoPuntoVenta(esInicial);
		this.setMostrardescuento_valorDetallePedidoPuntoVenta(esInicial);
		this.setMostrarivaDetallePedidoPuntoVenta(esInicial);
		this.setMostrariva_valorDetallePedidoPuntoVenta(esInicial);
		this.setMostrariceDetallePedidoPuntoVenta(esInicial);
		this.setMostrarice_valorDetallePedidoPuntoVenta(esInicial);
		this.setMostrarsub_totalDetallePedidoPuntoVenta(esInicial);
		this.setMostrartotalDetallePedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA)) {
				this.setMostrarid_pedido_punto_ventaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SERIE)) {
				this.setMostrarserieDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setMostrariceDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetallePedidoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_empresaDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_sucursalDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_pedido_punto_ventaDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_bodegaDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_productoDetallePedidoPuntoVenta(esInicial);
		this.setActivarid_unidadDetallePedidoPuntoVenta(esInicial);
		this.setActivarserieDetallePedidoPuntoVenta(esInicial);
		this.setActivarcantidadDetallePedidoPuntoVenta(esInicial);
		this.setActivarprecioDetallePedidoPuntoVenta(esInicial);
		this.setActivardescuentoDetallePedidoPuntoVenta(esInicial);
		this.setActivardescuento_valorDetallePedidoPuntoVenta(esInicial);
		this.setActivarivaDetallePedidoPuntoVenta(esInicial);
		this.setActivariva_valorDetallePedidoPuntoVenta(esInicial);
		this.setActivariceDetallePedidoPuntoVenta(esInicial);
		this.setActivarice_valorDetallePedidoPuntoVenta(esInicial);
		this.setActivarsub_totalDetallePedidoPuntoVenta(esInicial);
		this.setActivartotalDetallePedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA)) {
				this.setActivarid_pedido_punto_ventaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SERIE)) {
				this.setActivarserieDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setActivariceDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_empresaDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_sucursalDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_pedido_punto_ventaDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_bodegaDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_productoDetallePedidoPuntoVenta(esInicial);
		this.setResaltarid_unidadDetallePedidoPuntoVenta(esInicial);
		this.setResaltarserieDetallePedidoPuntoVenta(esInicial);
		this.setResaltarcantidadDetallePedidoPuntoVenta(esInicial);
		this.setResaltarprecioDetallePedidoPuntoVenta(esInicial);
		this.setResaltardescuentoDetallePedidoPuntoVenta(esInicial);
		this.setResaltardescuento_valorDetallePedidoPuntoVenta(esInicial);
		this.setResaltarivaDetallePedidoPuntoVenta(esInicial);
		this.setResaltariva_valorDetallePedidoPuntoVenta(esInicial);
		this.setResaltariceDetallePedidoPuntoVenta(esInicial);
		this.setResaltarice_valorDetallePedidoPuntoVenta(esInicial);
		this.setResaltarsub_totalDetallePedidoPuntoVenta(esInicial);
		this.setResaltartotalDetallePedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA)) {
				this.setResaltarid_pedido_punto_ventaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SERIE)) {
				this.setResaltarserieDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltariceDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetallePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetallePedidoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdBodegaDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdBodegaDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdBodegaDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetallePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdEmpresaDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdProductoDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdProductoDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdProductoDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdSucursalDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdUnidadDetallePedidoPuntoVenta() {
		return this.mostrarFK_IdUnidadDetallePedidoPuntoVenta;
	}

	public void setMostrarFK_IdUnidadDetallePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePedidoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdBodegaDetallePedidoPuntoVenta() {
		return this.activarFK_IdBodegaDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdBodegaDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetallePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaDetallePedidoPuntoVenta() {
		return this.activarFK_IdEmpresaDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta() {
		return this.activarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdProductoDetallePedidoPuntoVenta() {
		return this.activarFK_IdProductoDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdProductoDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalDetallePedidoPuntoVenta() {
		return this.activarFK_IdSucursalDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdSucursalDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdUnidadDetallePedidoPuntoVenta() {
		return this.activarFK_IdUnidadDetallePedidoPuntoVenta;
	}

	public void setActivarFK_IdUnidadDetallePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePedidoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdBodegaDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdBodegaDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdBodegaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdEmpresaDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoPuntoVentaDetallePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdProductoDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdProductoDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdProductoDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdSucursalDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePedidoPuntoVenta=null;

	public Border getResaltarFK_IdUnidadDetallePedidoPuntoVenta() {
		return this.resaltarFK_IdUnidadDetallePedidoPuntoVenta;
	}

	public void setResaltarFK_IdUnidadDetallePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoPuntoVentaBeanSwingJInternalFrame detallepedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePedidoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}