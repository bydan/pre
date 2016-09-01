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


import com.bydan.erp.inventario.util.DetallePedidoConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.facturacion.util.*;
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
final public class DetallePedidoConstantesFunciones extends DetallePedidoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePedido";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePedido"+DetallePedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePedidoConstantesFunciones.SCHEMA+"_"+DetallePedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePedidoConstantesFunciones.SCHEMA+"_"+DetallePedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePedidoConstantesFunciones.SCHEMA+"_"+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePedidoConstantesFunciones.SCHEMA+"_"+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePedido";
	public static final String OBJECTNAME="detallepedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepedido from "+DetallePedidoConstantesFunciones.SPERSISTENCENAME+" detallepedido";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_pedido,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_mes,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".id_estado_detalle_pedido,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".cantidad,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".precio,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".descuento_valor,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".iva,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".ice,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".total,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".costo,"+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME+".utilidad from "+DetallePedidoConstantesFunciones.SCHEMA+"."+DetallePedidoConstantesFunciones.TABLENAME;//+" as "+DetallePedidoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePedidoConstantesFuncionesAdditional detallepedidoConstantesFuncionesAdditional=null;
	
	public DetallePedidoConstantesFuncionesAdditional getDetallePedidoConstantesFuncionesAdditional() {
		return this.detallepedidoConstantesFuncionesAdditional;
	}
	
	public void setDetallePedidoConstantesFuncionesAdditional(DetallePedidoConstantesFuncionesAdditional detallepedidoConstantesFuncionesAdditional) {
		try {
			this.detallepedidoConstantesFuncionesAdditional=detallepedidoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPEDIDO= "id_pedido";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDESTADODETALLEPEDIDO= "id_estado_detalle_pedido";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
    public static final String COSTO= "costo";
    public static final String UTILIDAD= "utilidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPEDIDO= "Pedido";
		public static final String LABEL_IDPEDIDO_LOWER= "Pedido";
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
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_UTILIDAD= "Utilidad";
		public static final String LABEL_UTILIDAD_LOWER= "Utilidad";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetallePedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDPEDIDO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDPEDIDO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDANIO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDMES)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDBODEGA)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.CANTIDAD)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.PRECIO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.IVA)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.ICE)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.TOTAL)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.COSTO)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetallePedidoConstantesFunciones.UTILIDAD)) {sLabelColumna=DetallePedidoConstantesFunciones.LABEL_UTILIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePedidoDescripcion(DetallePedido detallepedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepedido !=null/* && detallepedido.getId()!=0*/) {
			if(detallepedido.getId()!=null) {
				sDescripcion=detallepedido.getId().toString();
			}//detallepedidodetallepedido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePedidoDescripcionDetallado(DetallePedido detallepedido) {
		String sDescripcion="";
			
		sDescripcion+=DetallePedidoConstantesFunciones.ID+"=";
		sDescripcion+=detallepedido.getId().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepedido.getVersionRow().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDPEDIDO+"=";
		sDescripcion+=detallepedido.getid_pedido().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepedido.getid_empresa().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepedido.getid_sucursal().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepedido.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepedido.getid_periodo().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepedido.getid_anio().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepedido.getid_mes().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallepedido.getid_producto().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallepedido.getid_bodega().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallepedido.getid_unidad().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO+"=";
		sDescripcion+=detallepedido.getid_estado_detalle_pedido().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallepedido.getcantidad().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallepedido.getprecio().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=detallepedido.getdescuento_porcentaje().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallepedido.getdescuento_valor().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.IVA+"=";
		sDescripcion+=detallepedido.getiva().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.ICE+"=";
		sDescripcion+=detallepedido.getice().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallepedido.gettotal().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.COSTO+"=";
		sDescripcion+=detallepedido.getcosto().toString()+",";
		sDescripcion+=DetallePedidoConstantesFunciones.UTILIDAD+"=";
		sDescripcion+=detallepedido.getutilidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePedidoDescripcion(DetallePedido detallepedido,String sValor) throws Exception {			
		if(detallepedido !=null) {
			//detallepedidodetallepedido.getId().toString();
		}		
	}
	
		

	public static String getPedidoDescripcion(Pedido pedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedido!=null/*&&pedido.getId()>0*/) {
			sDescripcion=PedidoConstantesFunciones.getPedidoDescripcion(pedido);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetallePedido")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPedido")) {
			sNombreIndice="Tipo=  Por Pedido";
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

	public static String getDetalleIndiceFK_IdPedido(Long id_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido!=null) {sDetalleIndice+=" Codigo Unico De Pedido="+id_pedido.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetallePedido(DetallePedido detallepedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetallePedidos(List<DetallePedido> detallepedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedido detallepedido: detallepedidos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedido(DetallePedido detallepedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepedido.getConCambioAuxiliar()) {
			detallepedido.setIsDeleted(detallepedido.getIsDeletedAuxiliar());	
			detallepedido.setIsNew(detallepedido.getIsNewAuxiliar());	
			detallepedido.setIsChanged(detallepedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepedido.setIsDeletedAuxiliar(false);	
			detallepedido.setIsNewAuxiliar(false);	
			detallepedido.setIsChangedAuxiliar(false);
			
			detallepedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidos(List<DetallePedido> detallepedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePedido detallepedido : detallepedidos) {
			if(conAsignarBase && detallepedido.getConCambioAuxiliar()) {
				detallepedido.setIsDeleted(detallepedido.getIsDeletedAuxiliar());	
				detallepedido.setIsNew(detallepedido.getIsNewAuxiliar());	
				detallepedido.setIsChanged(detallepedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepedido.setIsDeletedAuxiliar(false);	
				detallepedido.setIsNewAuxiliar(false);	
				detallepedido.setIsChangedAuxiliar(false);
				
				detallepedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePedido(DetallePedido detallepedido,Boolean conEnteros) throws Exception  {
		detallepedido.setprecio(0.0);
		detallepedido.setdescuento_porcentaje(0.0);
		detallepedido.setdescuento_valor(0.0);
		detallepedido.setiva(0.0);
		detallepedido.setice(0.0);
		detallepedido.settotal(0.0);
		detallepedido.setcosto(0.0);
		detallepedido.setutilidad(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepedido.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetallePedidos(List<DetallePedido> detallepedidos,Boolean conEnteros) throws Exception  {
		
		for(DetallePedido detallepedido: detallepedidos) {
			detallepedido.setprecio(0.0);
			detallepedido.setdescuento_porcentaje(0.0);
			detallepedido.setdescuento_valor(0.0);
			detallepedido.setiva(0.0);
			detallepedido.setice(0.0);
			detallepedido.settotal(0.0);
			detallepedido.setcosto(0.0);
			detallepedido.setutilidad(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepedido.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePedido(List<DetallePedido> detallepedidos,DetallePedido detallepedidoAux) throws Exception  {
		DetallePedidoConstantesFunciones.InicializarValoresDetallePedido(detallepedidoAux,true);
		
		for(DetallePedido detallepedido: detallepedidos) {
			if(detallepedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepedidoAux.setcantidad(detallepedidoAux.getcantidad()+detallepedido.getcantidad());			
			detallepedidoAux.setprecio(detallepedidoAux.getprecio()+detallepedido.getprecio());			
			detallepedidoAux.setdescuento_porcentaje(detallepedidoAux.getdescuento_porcentaje()+detallepedido.getdescuento_porcentaje());			
			detallepedidoAux.setdescuento_valor(detallepedidoAux.getdescuento_valor()+detallepedido.getdescuento_valor());			
			detallepedidoAux.setiva(detallepedidoAux.getiva()+detallepedido.getiva());			
			detallepedidoAux.setice(detallepedidoAux.getice()+detallepedido.getice());			
			detallepedidoAux.settotal(detallepedidoAux.gettotal()+detallepedido.gettotal());			
			detallepedidoAux.setcosto(detallepedidoAux.getcosto()+detallepedido.getcosto());			
			detallepedidoAux.setutilidad(detallepedidoAux.getutilidad()+detallepedido.getutilidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePedidoConstantesFunciones.getArrayColumnasGlobalesDetallePedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedido> detallepedidos,DetallePedido detallepedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedido detallepedidoAux: detallepedidos) {
			if(detallepedidoAux!=null && detallepedido!=null) {
				if((detallepedidoAux.getId()==null && detallepedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepedidoAux.getId()!=null && detallepedido.getId()!=null){
					if(detallepedidoAux.getId().equals(detallepedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedido(List<DetallePedido> detallepedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
	
		for(DetallePedido detallepedido: detallepedidos) {			
			if(detallepedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallepedido.getprecio();
			descuento_porcentajeTotal+=detallepedido.getdescuento_porcentaje();
			descuento_valorTotal+=detallepedido.getdescuento_valor();
			ivaTotal+=detallepedido.getiva();
			iceTotal+=detallepedido.getice();
			totalTotal+=detallepedido.gettotal();
			costoTotal+=detallepedido.getcosto();
			utilidadTotal+=detallepedido.getutilidad();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_ID, DetallePedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_VERSIONROW, DetallePedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDPEDIDO, DetallePedidoConstantesFunciones.IDPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDEMPRESA, DetallePedidoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDSUCURSAL, DetallePedidoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDEJERCICIO, DetallePedidoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDPERIODO, DetallePedidoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDANIO, DetallePedidoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDMES, DetallePedidoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDPRODUCTO, DetallePedidoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDBODEGA, DetallePedidoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDUNIDAD, DetallePedidoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO, DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_CANTIDAD, DetallePedidoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_PRECIO, DetallePedidoConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR, DetallePedidoConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_IVA, DetallePedidoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_ICE, DetallePedidoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_TOTAL, DetallePedidoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_COSTO, DetallePedidoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoConstantesFunciones.LABEL_UTILIDAD, DetallePedidoConstantesFunciones.UTILIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoConstantesFunciones.UTILIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedido() throws Exception  {
		return DetallePedidoConstantesFunciones.getTiposSeleccionarDetallePedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedido(Boolean conFk) throws Exception  {
		return DetallePedidoConstantesFunciones.getTiposSeleccionarDetallePedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDPEDIDO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoConstantesFunciones.LABEL_UTILIDAD);
			reporte.setsDescripcion(DetallePedidoConstantesFunciones.LABEL_UTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedido(DetallePedido detallepedidoAux) throws Exception {
		
			detallepedidoAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(detallepedidoAux.getPedido()));
			detallepedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidoAux.getEmpresa()));
			detallepedidoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidoAux.getSucursal()));
			detallepedidoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidoAux.getEjercicio()));
			detallepedidoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidoAux.getPeriodo()));
			detallepedidoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidoAux.getAnio()));
			detallepedidoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidoAux.getMes()));
			detallepedidoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidoAux.getProducto()));
			detallepedidoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidoAux.getBodega()));
			detallepedidoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidoAux.getUnidad()));
			detallepedidoAux.setestadodetallepedido_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detallepedidoAux.getEstadoDetallePedido()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedido(List<DetallePedido> detallepedidosTemp) throws Exception {
		for(DetallePedido detallepedidoAux:detallepedidosTemp) {
			
			detallepedidoAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(detallepedidoAux.getPedido()));
			detallepedidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidoAux.getEmpresa()));
			detallepedidoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidoAux.getSucursal()));
			detallepedidoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidoAux.getEjercicio()));
			detallepedidoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidoAux.getPeriodo()));
			detallepedidoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidoAux.getAnio()));
			detallepedidoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidoAux.getMes()));
			detallepedidoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidoAux.getProducto()));
			detallepedidoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidoAux.getBodega()));
			detallepedidoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidoAux.getUnidad()));
			detallepedidoAux.setestadodetallepedido_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detallepedidoAux.getEstadoDetallePedido()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(EstadoDetallePedido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoConstantesFunciones.getClassesRelationshipsOfDetallePedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePedido detallepedido,List<DetallePedido> detallepedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePedido detallepedidoEncontrado=null;
			
			for(DetallePedido detallepedidoLocal:detallepedidos) {
				if(detallepedidoLocal.getId().equals(detallepedido.getId())) {
					detallepedidoEncontrado=detallepedidoLocal;
					
					detallepedidoLocal.setIsChanged(detallepedido.getIsChanged());
					detallepedidoLocal.setIsNew(detallepedido.getIsNew());
					detallepedidoLocal.setIsDeleted(detallepedido.getIsDeleted());
					
					detallepedidoLocal.setGeneralEntityOriginal(detallepedido.getGeneralEntityOriginal());
					
					detallepedidoLocal.setId(detallepedido.getId());	
					detallepedidoLocal.setVersionRow(detallepedido.getVersionRow());	
					detallepedidoLocal.setid_pedido(detallepedido.getid_pedido());	
					detallepedidoLocal.setid_empresa(detallepedido.getid_empresa());	
					detallepedidoLocal.setid_sucursal(detallepedido.getid_sucursal());	
					detallepedidoLocal.setid_ejercicio(detallepedido.getid_ejercicio());	
					detallepedidoLocal.setid_periodo(detallepedido.getid_periodo());	
					detallepedidoLocal.setid_anio(detallepedido.getid_anio());	
					detallepedidoLocal.setid_mes(detallepedido.getid_mes());	
					detallepedidoLocal.setid_producto(detallepedido.getid_producto());	
					detallepedidoLocal.setid_bodega(detallepedido.getid_bodega());	
					detallepedidoLocal.setid_unidad(detallepedido.getid_unidad());	
					detallepedidoLocal.setid_estado_detalle_pedido(detallepedido.getid_estado_detalle_pedido());	
					detallepedidoLocal.setcantidad(detallepedido.getcantidad());	
					detallepedidoLocal.setprecio(detallepedido.getprecio());	
					detallepedidoLocal.setdescuento_porcentaje(detallepedido.getdescuento_porcentaje());	
					detallepedidoLocal.setdescuento_valor(detallepedido.getdescuento_valor());	
					detallepedidoLocal.setiva(detallepedido.getiva());	
					detallepedidoLocal.setice(detallepedido.getice());	
					detallepedidoLocal.settotal(detallepedido.gettotal());	
					detallepedidoLocal.setcosto(detallepedido.getcosto());	
					detallepedidoLocal.setutilidad(detallepedido.getutilidad());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepedido.getIsDeleted()) {
				if(!existe) {
					detallepedidos.add(detallepedido);
				}
			} else {
				if(detallepedidoEncontrado!=null && permiteQuitar)  {
					detallepedidos.remove(detallepedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePedido detallepedido,List<DetallePedido> detallepedidos) throws Exception {
		try	{			
			for(DetallePedido detallepedidoLocal:detallepedidos) {
				if(detallepedidoLocal.getId().equals(detallepedido.getId())) {
					detallepedidoLocal.setIsSelected(detallepedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePedido(List<DetallePedido> detallepedidosAux) throws Exception {
		//this.detallepedidosAux=detallepedidosAux;
		
		for(DetallePedido detallepedidoAux:detallepedidosAux) {
			if(detallepedidoAux.getIsChanged()) {
				detallepedidoAux.setIsChanged(false);
			}		
			
			if(detallepedidoAux.getIsNew()) {
				detallepedidoAux.setIsNew(false);
			}	
			
			if(detallepedidoAux.getIsDeleted()) {
				detallepedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePedido(DetallePedido detallepedidoAux) throws Exception {
		//this.detallepedidoAux=detallepedidoAux;
		
			if(detallepedidoAux.getIsChanged()) {
				detallepedidoAux.setIsChanged(false);
			}		
			
			if(detallepedidoAux.getIsNew()) {
				detallepedidoAux.setIsNew(false);
			}	
			
			if(detallepedidoAux.getIsDeleted()) {
				detallepedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePedido detallepedidoAsignar,DetallePedido detallepedido) throws Exception {
		detallepedidoAsignar.setId(detallepedido.getId());	
		detallepedidoAsignar.setVersionRow(detallepedido.getVersionRow());	
		detallepedidoAsignar.setid_pedido(detallepedido.getid_pedido());
		detallepedidoAsignar.setpedido_descripcion(detallepedido.getpedido_descripcion());	
		detallepedidoAsignar.setid_empresa(detallepedido.getid_empresa());
		detallepedidoAsignar.setempresa_descripcion(detallepedido.getempresa_descripcion());	
		detallepedidoAsignar.setid_sucursal(detallepedido.getid_sucursal());
		detallepedidoAsignar.setsucursal_descripcion(detallepedido.getsucursal_descripcion());	
		detallepedidoAsignar.setid_ejercicio(detallepedido.getid_ejercicio());
		detallepedidoAsignar.setejercicio_descripcion(detallepedido.getejercicio_descripcion());	
		detallepedidoAsignar.setid_periodo(detallepedido.getid_periodo());
		detallepedidoAsignar.setperiodo_descripcion(detallepedido.getperiodo_descripcion());	
		detallepedidoAsignar.setid_anio(detallepedido.getid_anio());
		detallepedidoAsignar.setanio_descripcion(detallepedido.getanio_descripcion());	
		detallepedidoAsignar.setid_mes(detallepedido.getid_mes());
		detallepedidoAsignar.setmes_descripcion(detallepedido.getmes_descripcion());	
		detallepedidoAsignar.setid_producto(detallepedido.getid_producto());
		detallepedidoAsignar.setproducto_descripcion(detallepedido.getproducto_descripcion());	
		detallepedidoAsignar.setid_bodega(detallepedido.getid_bodega());
		detallepedidoAsignar.setbodega_descripcion(detallepedido.getbodega_descripcion());	
		detallepedidoAsignar.setid_unidad(detallepedido.getid_unidad());
		detallepedidoAsignar.setunidad_descripcion(detallepedido.getunidad_descripcion());	
		detallepedidoAsignar.setid_estado_detalle_pedido(detallepedido.getid_estado_detalle_pedido());
		detallepedidoAsignar.setestadodetallepedido_descripcion(detallepedido.getestadodetallepedido_descripcion());	
		detallepedidoAsignar.setcantidad(detallepedido.getcantidad());	
		detallepedidoAsignar.setprecio(detallepedido.getprecio());	
		detallepedidoAsignar.setdescuento_porcentaje(detallepedido.getdescuento_porcentaje());	
		detallepedidoAsignar.setdescuento_valor(detallepedido.getdescuento_valor());	
		detallepedidoAsignar.setiva(detallepedido.getiva());	
		detallepedidoAsignar.setice(detallepedido.getice());	
		detallepedidoAsignar.settotal(detallepedido.gettotal());	
		detallepedidoAsignar.setcosto(detallepedido.getcosto());	
		detallepedidoAsignar.setutilidad(detallepedido.getutilidad());	
	}
	
	public static void inicializarDetallePedido(DetallePedido detallepedido) throws Exception {
		try {
				detallepedido.setId(0L);	
					
				detallepedido.setid_pedido(-1L);	
				detallepedido.setid_empresa(-1L);	
				detallepedido.setid_sucursal(-1L);	
				detallepedido.setid_ejercicio(-1L);	
				detallepedido.setid_periodo(-1L);	
				detallepedido.setid_anio(null);	
				detallepedido.setid_mes(null);	
				detallepedido.setid_producto(-1L);	
				detallepedido.setid_bodega(-1L);	
				detallepedido.setid_unidad(-1L);	
				detallepedido.setid_estado_detalle_pedido(-1L);	
				detallepedido.setcantidad(0);	
				detallepedido.setprecio(0.0);	
				detallepedido.setdescuento_porcentaje(0.0);	
				detallepedido.setdescuento_valor(0.0);	
				detallepedido.setiva(0.0);	
				detallepedido.setice(0.0);	
				detallepedido.settotal(0.0);	
				detallepedido.setcosto(0.0);	
				detallepedido.setutilidad(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IDESTADODETALLEPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoConstantesFunciones.LABEL_UTILIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePedido(String sTipo,Row row,Workbook workbook,DetallePedido detallepedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getpedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getestadodetallepedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedido.getutilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePedido() {
		return this.sFinalQueryDetallePedido;
	}
	
	public void setsFinalQueryDetallePedido(String sFinalQueryDetallePedido) {
		this.sFinalQueryDetallePedido= sFinalQueryDetallePedido;
	}
	
	public Border resaltarSeleccionarDetallePedido=null;
	
	public Border setResaltarSeleccionarDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePedido() {
		return this.resaltarSeleccionarDetallePedido;
	}
	
	public void setResaltarSeleccionarDetallePedido(Border borderResaltarSeleccionarDetallePedido) {
		this.resaltarSeleccionarDetallePedido= borderResaltarSeleccionarDetallePedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePedido=null;
	public Boolean mostraridDetallePedido=true;
	public Boolean activaridDetallePedido=true;

	public Border resaltarid_pedidoDetallePedido=null;
	public Boolean mostrarid_pedidoDetallePedido=true;
	public Boolean activarid_pedidoDetallePedido=true;
	public Boolean cargarid_pedidoDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedidoDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_empresaDetallePedido=null;
	public Boolean mostrarid_empresaDetallePedido=true;
	public Boolean activarid_empresaDetallePedido=true;
	public Boolean cargarid_empresaDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePedido=null;
	public Boolean mostrarid_sucursalDetallePedido=true;
	public Boolean activarid_sucursalDetallePedido=true;
	public Boolean cargarid_sucursalDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePedido=null;
	public Boolean mostrarid_ejercicioDetallePedido=true;
	public Boolean activarid_ejercicioDetallePedido=true;
	public Boolean cargarid_ejercicioDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePedido=null;
	public Boolean mostrarid_periodoDetallePedido=true;
	public Boolean activarid_periodoDetallePedido=true;
	public Boolean cargarid_periodoDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_anioDetallePedido=null;
	public Boolean mostrarid_anioDetallePedido=true;
	public Boolean activarid_anioDetallePedido=false;
	public Boolean cargarid_anioDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePedido=null;
	public Boolean mostrarid_mesDetallePedido=true;
	public Boolean activarid_mesDetallePedido=false;
	public Boolean cargarid_mesDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePedido=null;
	public Boolean mostrarid_productoDetallePedido=true;
	public Boolean activarid_productoDetallePedido=true;
	public Boolean cargarid_productoDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePedido=true;//ConEventDepend=true

	public Border resaltarid_bodegaDetallePedido=null;
	public Boolean mostrarid_bodegaDetallePedido=true;
	public Boolean activarid_bodegaDetallePedido=true;
	public Boolean cargarid_bodegaDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetallePedido=false;//ConEventDepend=true

	public Border resaltarid_unidadDetallePedido=null;
	public Boolean mostrarid_unidadDetallePedido=true;
	public Boolean activarid_unidadDetallePedido=true;
	public Boolean cargarid_unidadDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePedido=true;//ConEventDepend=true

	public Border resaltarid_estado_detalle_pedidoDetallePedido=null;
	public Boolean mostrarid_estado_detalle_pedidoDetallePedido=true;
	public Boolean activarid_estado_detalle_pedidoDetallePedido=true;
	public Boolean cargarid_estado_detalle_pedidoDetallePedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_pedidoDetallePedido=false;//ConEventDepend=true

	public Border resaltarcantidadDetallePedido=null;
	public Boolean mostrarcantidadDetallePedido=true;
	public Boolean activarcantidadDetallePedido=true;

	public Border resaltarprecioDetallePedido=null;
	public Boolean mostrarprecioDetallePedido=true;
	public Boolean activarprecioDetallePedido=true;

	public Border resaltardescuento_porcentajeDetallePedido=null;
	public Boolean mostrardescuento_porcentajeDetallePedido=true;
	public Boolean activardescuento_porcentajeDetallePedido=true;

	public Border resaltardescuento_valorDetallePedido=null;
	public Boolean mostrardescuento_valorDetallePedido=true;
	public Boolean activardescuento_valorDetallePedido=true;

	public Border resaltarivaDetallePedido=null;
	public Boolean mostrarivaDetallePedido=true;
	public Boolean activarivaDetallePedido=true;

	public Border resaltariceDetallePedido=null;
	public Boolean mostrariceDetallePedido=true;
	public Boolean activariceDetallePedido=true;

	public Border resaltartotalDetallePedido=null;
	public Boolean mostrartotalDetallePedido=true;
	public Boolean activartotalDetallePedido=true;

	public Border resaltarcostoDetallePedido=null;
	public Boolean mostrarcostoDetallePedido=true;
	public Boolean activarcostoDetallePedido=false;

	public Border resaltarutilidadDetallePedido=null;
	public Boolean mostrarutilidadDetallePedido=true;
	public Boolean activarutilidadDetallePedido=false;

	
	

	public Border setResaltaridDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltaridDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePedido() {
		return this.resaltaridDetallePedido;
	}

	public void setResaltaridDetallePedido(Border borderResaltar) {
		this.resaltaridDetallePedido= borderResaltar;
	}

	public Boolean getMostraridDetallePedido() {
		return this.mostraridDetallePedido;
	}

	public void setMostraridDetallePedido(Boolean mostraridDetallePedido) {
		this.mostraridDetallePedido= mostraridDetallePedido;
	}

	public Boolean getActivaridDetallePedido() {
		return this.activaridDetallePedido;
	}

	public void setActivaridDetallePedido(Boolean activaridDetallePedido) {
		this.activaridDetallePedido= activaridDetallePedido;
	}

	public Border setResaltarid_pedidoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_pedidoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedidoDetallePedido() {
		return this.resaltarid_pedidoDetallePedido;
	}

	public void setResaltarid_pedidoDetallePedido(Border borderResaltar) {
		this.resaltarid_pedidoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_pedidoDetallePedido() {
		return this.mostrarid_pedidoDetallePedido;
	}

	public void setMostrarid_pedidoDetallePedido(Boolean mostrarid_pedidoDetallePedido) {
		this.mostrarid_pedidoDetallePedido= mostrarid_pedidoDetallePedido;
	}

	public Boolean getActivarid_pedidoDetallePedido() {
		return this.activarid_pedidoDetallePedido;
	}

	public void setActivarid_pedidoDetallePedido(Boolean activarid_pedidoDetallePedido) {
		this.activarid_pedidoDetallePedido= activarid_pedidoDetallePedido;
	}

	public Boolean getCargarid_pedidoDetallePedido() {
		return this.cargarid_pedidoDetallePedido;
	}

	public void setCargarid_pedidoDetallePedido(Boolean cargarid_pedidoDetallePedido) {
		this.cargarid_pedidoDetallePedido= cargarid_pedidoDetallePedido;
	}

	public Border setResaltarid_empresaDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePedido() {
		return this.resaltarid_empresaDetallePedido;
	}

	public void setResaltarid_empresaDetallePedido(Border borderResaltar) {
		this.resaltarid_empresaDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePedido() {
		return this.mostrarid_empresaDetallePedido;
	}

	public void setMostrarid_empresaDetallePedido(Boolean mostrarid_empresaDetallePedido) {
		this.mostrarid_empresaDetallePedido= mostrarid_empresaDetallePedido;
	}

	public Boolean getActivarid_empresaDetallePedido() {
		return this.activarid_empresaDetallePedido;
	}

	public void setActivarid_empresaDetallePedido(Boolean activarid_empresaDetallePedido) {
		this.activarid_empresaDetallePedido= activarid_empresaDetallePedido;
	}

	public Boolean getCargarid_empresaDetallePedido() {
		return this.cargarid_empresaDetallePedido;
	}

	public void setCargarid_empresaDetallePedido(Boolean cargarid_empresaDetallePedido) {
		this.cargarid_empresaDetallePedido= cargarid_empresaDetallePedido;
	}

	public Border setResaltarid_sucursalDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePedido() {
		return this.resaltarid_sucursalDetallePedido;
	}

	public void setResaltarid_sucursalDetallePedido(Border borderResaltar) {
		this.resaltarid_sucursalDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePedido() {
		return this.mostrarid_sucursalDetallePedido;
	}

	public void setMostrarid_sucursalDetallePedido(Boolean mostrarid_sucursalDetallePedido) {
		this.mostrarid_sucursalDetallePedido= mostrarid_sucursalDetallePedido;
	}

	public Boolean getActivarid_sucursalDetallePedido() {
		return this.activarid_sucursalDetallePedido;
	}

	public void setActivarid_sucursalDetallePedido(Boolean activarid_sucursalDetallePedido) {
		this.activarid_sucursalDetallePedido= activarid_sucursalDetallePedido;
	}

	public Boolean getCargarid_sucursalDetallePedido() {
		return this.cargarid_sucursalDetallePedido;
	}

	public void setCargarid_sucursalDetallePedido(Boolean cargarid_sucursalDetallePedido) {
		this.cargarid_sucursalDetallePedido= cargarid_sucursalDetallePedido;
	}

	public Border setResaltarid_ejercicioDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePedido() {
		return this.resaltarid_ejercicioDetallePedido;
	}

	public void setResaltarid_ejercicioDetallePedido(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePedido() {
		return this.mostrarid_ejercicioDetallePedido;
	}

	public void setMostrarid_ejercicioDetallePedido(Boolean mostrarid_ejercicioDetallePedido) {
		this.mostrarid_ejercicioDetallePedido= mostrarid_ejercicioDetallePedido;
	}

	public Boolean getActivarid_ejercicioDetallePedido() {
		return this.activarid_ejercicioDetallePedido;
	}

	public void setActivarid_ejercicioDetallePedido(Boolean activarid_ejercicioDetallePedido) {
		this.activarid_ejercicioDetallePedido= activarid_ejercicioDetallePedido;
	}

	public Boolean getCargarid_ejercicioDetallePedido() {
		return this.cargarid_ejercicioDetallePedido;
	}

	public void setCargarid_ejercicioDetallePedido(Boolean cargarid_ejercicioDetallePedido) {
		this.cargarid_ejercicioDetallePedido= cargarid_ejercicioDetallePedido;
	}

	public Border setResaltarid_periodoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePedido() {
		return this.resaltarid_periodoDetallePedido;
	}

	public void setResaltarid_periodoDetallePedido(Border borderResaltar) {
		this.resaltarid_periodoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePedido() {
		return this.mostrarid_periodoDetallePedido;
	}

	public void setMostrarid_periodoDetallePedido(Boolean mostrarid_periodoDetallePedido) {
		this.mostrarid_periodoDetallePedido= mostrarid_periodoDetallePedido;
	}

	public Boolean getActivarid_periodoDetallePedido() {
		return this.activarid_periodoDetallePedido;
	}

	public void setActivarid_periodoDetallePedido(Boolean activarid_periodoDetallePedido) {
		this.activarid_periodoDetallePedido= activarid_periodoDetallePedido;
	}

	public Boolean getCargarid_periodoDetallePedido() {
		return this.cargarid_periodoDetallePedido;
	}

	public void setCargarid_periodoDetallePedido(Boolean cargarid_periodoDetallePedido) {
		this.cargarid_periodoDetallePedido= cargarid_periodoDetallePedido;
	}

	public Border setResaltarid_anioDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePedido() {
		return this.resaltarid_anioDetallePedido;
	}

	public void setResaltarid_anioDetallePedido(Border borderResaltar) {
		this.resaltarid_anioDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePedido() {
		return this.mostrarid_anioDetallePedido;
	}

	public void setMostrarid_anioDetallePedido(Boolean mostrarid_anioDetallePedido) {
		this.mostrarid_anioDetallePedido= mostrarid_anioDetallePedido;
	}

	public Boolean getActivarid_anioDetallePedido() {
		return this.activarid_anioDetallePedido;
	}

	public void setActivarid_anioDetallePedido(Boolean activarid_anioDetallePedido) {
		this.activarid_anioDetallePedido= activarid_anioDetallePedido;
	}

	public Boolean getCargarid_anioDetallePedido() {
		return this.cargarid_anioDetallePedido;
	}

	public void setCargarid_anioDetallePedido(Boolean cargarid_anioDetallePedido) {
		this.cargarid_anioDetallePedido= cargarid_anioDetallePedido;
	}

	public Border setResaltarid_mesDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePedido() {
		return this.resaltarid_mesDetallePedido;
	}

	public void setResaltarid_mesDetallePedido(Border borderResaltar) {
		this.resaltarid_mesDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePedido() {
		return this.mostrarid_mesDetallePedido;
	}

	public void setMostrarid_mesDetallePedido(Boolean mostrarid_mesDetallePedido) {
		this.mostrarid_mesDetallePedido= mostrarid_mesDetallePedido;
	}

	public Boolean getActivarid_mesDetallePedido() {
		return this.activarid_mesDetallePedido;
	}

	public void setActivarid_mesDetallePedido(Boolean activarid_mesDetallePedido) {
		this.activarid_mesDetallePedido= activarid_mesDetallePedido;
	}

	public Boolean getCargarid_mesDetallePedido() {
		return this.cargarid_mesDetallePedido;
	}

	public void setCargarid_mesDetallePedido(Boolean cargarid_mesDetallePedido) {
		this.cargarid_mesDetallePedido= cargarid_mesDetallePedido;
	}

	public Border setResaltarid_productoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePedido() {
		return this.resaltarid_productoDetallePedido;
	}

	public void setResaltarid_productoDetallePedido(Border borderResaltar) {
		this.resaltarid_productoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePedido() {
		return this.mostrarid_productoDetallePedido;
	}

	public void setMostrarid_productoDetallePedido(Boolean mostrarid_productoDetallePedido) {
		this.mostrarid_productoDetallePedido= mostrarid_productoDetallePedido;
	}

	public Boolean getActivarid_productoDetallePedido() {
		return this.activarid_productoDetallePedido;
	}

	public void setActivarid_productoDetallePedido(Boolean activarid_productoDetallePedido) {
		this.activarid_productoDetallePedido= activarid_productoDetallePedido;
	}

	public Boolean getCargarid_productoDetallePedido() {
		return this.cargarid_productoDetallePedido;
	}

	public void setCargarid_productoDetallePedido(Boolean cargarid_productoDetallePedido) {
		this.cargarid_productoDetallePedido= cargarid_productoDetallePedido;
	}

	public Border setResaltarid_bodegaDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetallePedido() {
		return this.resaltarid_bodegaDetallePedido;
	}

	public void setResaltarid_bodegaDetallePedido(Border borderResaltar) {
		this.resaltarid_bodegaDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetallePedido() {
		return this.mostrarid_bodegaDetallePedido;
	}

	public void setMostrarid_bodegaDetallePedido(Boolean mostrarid_bodegaDetallePedido) {
		this.mostrarid_bodegaDetallePedido= mostrarid_bodegaDetallePedido;
	}

	public Boolean getActivarid_bodegaDetallePedido() {
		return this.activarid_bodegaDetallePedido;
	}

	public void setActivarid_bodegaDetallePedido(Boolean activarid_bodegaDetallePedido) {
		this.activarid_bodegaDetallePedido= activarid_bodegaDetallePedido;
	}

	public Boolean getCargarid_bodegaDetallePedido() {
		return this.cargarid_bodegaDetallePedido;
	}

	public void setCargarid_bodegaDetallePedido(Boolean cargarid_bodegaDetallePedido) {
		this.cargarid_bodegaDetallePedido= cargarid_bodegaDetallePedido;
	}

	public Border setResaltarid_unidadDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePedido() {
		return this.resaltarid_unidadDetallePedido;
	}

	public void setResaltarid_unidadDetallePedido(Border borderResaltar) {
		this.resaltarid_unidadDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePedido() {
		return this.mostrarid_unidadDetallePedido;
	}

	public void setMostrarid_unidadDetallePedido(Boolean mostrarid_unidadDetallePedido) {
		this.mostrarid_unidadDetallePedido= mostrarid_unidadDetallePedido;
	}

	public Boolean getActivarid_unidadDetallePedido() {
		return this.activarid_unidadDetallePedido;
	}

	public void setActivarid_unidadDetallePedido(Boolean activarid_unidadDetallePedido) {
		this.activarid_unidadDetallePedido= activarid_unidadDetallePedido;
	}

	public Boolean getCargarid_unidadDetallePedido() {
		return this.cargarid_unidadDetallePedido;
	}

	public void setCargarid_unidadDetallePedido(Boolean cargarid_unidadDetallePedido) {
		this.cargarid_unidadDetallePedido= cargarid_unidadDetallePedido;
	}

	public Border setResaltarid_estado_detalle_pedidoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_pedidoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_pedidoDetallePedido() {
		return this.resaltarid_estado_detalle_pedidoDetallePedido;
	}

	public void setResaltarid_estado_detalle_pedidoDetallePedido(Border borderResaltar) {
		this.resaltarid_estado_detalle_pedidoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_pedidoDetallePedido() {
		return this.mostrarid_estado_detalle_pedidoDetallePedido;
	}

	public void setMostrarid_estado_detalle_pedidoDetallePedido(Boolean mostrarid_estado_detalle_pedidoDetallePedido) {
		this.mostrarid_estado_detalle_pedidoDetallePedido= mostrarid_estado_detalle_pedidoDetallePedido;
	}

	public Boolean getActivarid_estado_detalle_pedidoDetallePedido() {
		return this.activarid_estado_detalle_pedidoDetallePedido;
	}

	public void setActivarid_estado_detalle_pedidoDetallePedido(Boolean activarid_estado_detalle_pedidoDetallePedido) {
		this.activarid_estado_detalle_pedidoDetallePedido= activarid_estado_detalle_pedidoDetallePedido;
	}

	public Boolean getCargarid_estado_detalle_pedidoDetallePedido() {
		return this.cargarid_estado_detalle_pedidoDetallePedido;
	}

	public void setCargarid_estado_detalle_pedidoDetallePedido(Boolean cargarid_estado_detalle_pedidoDetallePedido) {
		this.cargarid_estado_detalle_pedidoDetallePedido= cargarid_estado_detalle_pedidoDetallePedido;
	}

	public Border setResaltarcantidadDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarcantidadDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetallePedido() {
		return this.resaltarcantidadDetallePedido;
	}

	public void setResaltarcantidadDetallePedido(Border borderResaltar) {
		this.resaltarcantidadDetallePedido= borderResaltar;
	}

	public Boolean getMostrarcantidadDetallePedido() {
		return this.mostrarcantidadDetallePedido;
	}

	public void setMostrarcantidadDetallePedido(Boolean mostrarcantidadDetallePedido) {
		this.mostrarcantidadDetallePedido= mostrarcantidadDetallePedido;
	}

	public Boolean getActivarcantidadDetallePedido() {
		return this.activarcantidadDetallePedido;
	}

	public void setActivarcantidadDetallePedido(Boolean activarcantidadDetallePedido) {
		this.activarcantidadDetallePedido= activarcantidadDetallePedido;
	}

	public Border setResaltarprecioDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarprecioDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetallePedido() {
		return this.resaltarprecioDetallePedido;
	}

	public void setResaltarprecioDetallePedido(Border borderResaltar) {
		this.resaltarprecioDetallePedido= borderResaltar;
	}

	public Boolean getMostrarprecioDetallePedido() {
		return this.mostrarprecioDetallePedido;
	}

	public void setMostrarprecioDetallePedido(Boolean mostrarprecioDetallePedido) {
		this.mostrarprecioDetallePedido= mostrarprecioDetallePedido;
	}

	public Boolean getActivarprecioDetallePedido() {
		return this.activarprecioDetallePedido;
	}

	public void setActivarprecioDetallePedido(Boolean activarprecioDetallePedido) {
		this.activarprecioDetallePedido= activarprecioDetallePedido;
	}

	public Border setResaltardescuento_porcentajeDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeDetallePedido() {
		return this.resaltardescuento_porcentajeDetallePedido;
	}

	public void setResaltardescuento_porcentajeDetallePedido(Border borderResaltar) {
		this.resaltardescuento_porcentajeDetallePedido= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeDetallePedido() {
		return this.mostrardescuento_porcentajeDetallePedido;
	}

	public void setMostrardescuento_porcentajeDetallePedido(Boolean mostrardescuento_porcentajeDetallePedido) {
		this.mostrardescuento_porcentajeDetallePedido= mostrardescuento_porcentajeDetallePedido;
	}

	public Boolean getActivardescuento_porcentajeDetallePedido() {
		return this.activardescuento_porcentajeDetallePedido;
	}

	public void setActivardescuento_porcentajeDetallePedido(Boolean activardescuento_porcentajeDetallePedido) {
		this.activardescuento_porcentajeDetallePedido= activardescuento_porcentajeDetallePedido;
	}

	public Border setResaltardescuento_valorDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetallePedido() {
		return this.resaltardescuento_valorDetallePedido;
	}

	public void setResaltardescuento_valorDetallePedido(Border borderResaltar) {
		this.resaltardescuento_valorDetallePedido= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetallePedido() {
		return this.mostrardescuento_valorDetallePedido;
	}

	public void setMostrardescuento_valorDetallePedido(Boolean mostrardescuento_valorDetallePedido) {
		this.mostrardescuento_valorDetallePedido= mostrardescuento_valorDetallePedido;
	}

	public Boolean getActivardescuento_valorDetallePedido() {
		return this.activardescuento_valorDetallePedido;
	}

	public void setActivardescuento_valorDetallePedido(Boolean activardescuento_valorDetallePedido) {
		this.activardescuento_valorDetallePedido= activardescuento_valorDetallePedido;
	}

	public Border setResaltarivaDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarivaDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetallePedido() {
		return this.resaltarivaDetallePedido;
	}

	public void setResaltarivaDetallePedido(Border borderResaltar) {
		this.resaltarivaDetallePedido= borderResaltar;
	}

	public Boolean getMostrarivaDetallePedido() {
		return this.mostrarivaDetallePedido;
	}

	public void setMostrarivaDetallePedido(Boolean mostrarivaDetallePedido) {
		this.mostrarivaDetallePedido= mostrarivaDetallePedido;
	}

	public Boolean getActivarivaDetallePedido() {
		return this.activarivaDetallePedido;
	}

	public void setActivarivaDetallePedido(Boolean activarivaDetallePedido) {
		this.activarivaDetallePedido= activarivaDetallePedido;
	}

	public Border setResaltariceDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltariceDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetallePedido() {
		return this.resaltariceDetallePedido;
	}

	public void setResaltariceDetallePedido(Border borderResaltar) {
		this.resaltariceDetallePedido= borderResaltar;
	}

	public Boolean getMostrariceDetallePedido() {
		return this.mostrariceDetallePedido;
	}

	public void setMostrariceDetallePedido(Boolean mostrariceDetallePedido) {
		this.mostrariceDetallePedido= mostrariceDetallePedido;
	}

	public Boolean getActivariceDetallePedido() {
		return this.activariceDetallePedido;
	}

	public void setActivariceDetallePedido(Boolean activariceDetallePedido) {
		this.activariceDetallePedido= activariceDetallePedido;
	}

	public Border setResaltartotalDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltartotalDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetallePedido() {
		return this.resaltartotalDetallePedido;
	}

	public void setResaltartotalDetallePedido(Border borderResaltar) {
		this.resaltartotalDetallePedido= borderResaltar;
	}

	public Boolean getMostrartotalDetallePedido() {
		return this.mostrartotalDetallePedido;
	}

	public void setMostrartotalDetallePedido(Boolean mostrartotalDetallePedido) {
		this.mostrartotalDetallePedido= mostrartotalDetallePedido;
	}

	public Boolean getActivartotalDetallePedido() {
		return this.activartotalDetallePedido;
	}

	public void setActivartotalDetallePedido(Boolean activartotalDetallePedido) {
		this.activartotalDetallePedido= activartotalDetallePedido;
	}

	public Border setResaltarcostoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarcostoDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetallePedido() {
		return this.resaltarcostoDetallePedido;
	}

	public void setResaltarcostoDetallePedido(Border borderResaltar) {
		this.resaltarcostoDetallePedido= borderResaltar;
	}

	public Boolean getMostrarcostoDetallePedido() {
		return this.mostrarcostoDetallePedido;
	}

	public void setMostrarcostoDetallePedido(Boolean mostrarcostoDetallePedido) {
		this.mostrarcostoDetallePedido= mostrarcostoDetallePedido;
	}

	public Boolean getActivarcostoDetallePedido() {
		return this.activarcostoDetallePedido;
	}

	public void setActivarcostoDetallePedido(Boolean activarcostoDetallePedido) {
		this.activarcostoDetallePedido= activarcostoDetallePedido;
	}

	public Border setResaltarutilidadDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoBeanSwingJInternalFrame.jTtoolBarDetallePedido.setBorder(borderResaltar);
		
		this.resaltarutilidadDetallePedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidadDetallePedido() {
		return this.resaltarutilidadDetallePedido;
	}

	public void setResaltarutilidadDetallePedido(Border borderResaltar) {
		this.resaltarutilidadDetallePedido= borderResaltar;
	}

	public Boolean getMostrarutilidadDetallePedido() {
		return this.mostrarutilidadDetallePedido;
	}

	public void setMostrarutilidadDetallePedido(Boolean mostrarutilidadDetallePedido) {
		this.mostrarutilidadDetallePedido= mostrarutilidadDetallePedido;
	}

	public Boolean getActivarutilidadDetallePedido() {
		return this.activarutilidadDetallePedido;
	}

	public void setActivarutilidadDetallePedido(Boolean activarutilidadDetallePedido) {
		this.activarutilidadDetallePedido= activarutilidadDetallePedido;
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
		
		
		this.setMostraridDetallePedido(esInicial);
		this.setMostrarid_pedidoDetallePedido(esInicial);
		this.setMostrarid_empresaDetallePedido(esInicial);
		this.setMostrarid_sucursalDetallePedido(esInicial);
		this.setMostrarid_ejercicioDetallePedido(esInicial);
		this.setMostrarid_periodoDetallePedido(esInicial);
		this.setMostrarid_anioDetallePedido(esInicial);
		this.setMostrarid_mesDetallePedido(esInicial);
		this.setMostrarid_productoDetallePedido(esInicial);
		this.setMostrarid_bodegaDetallePedido(esInicial);
		this.setMostrarid_unidadDetallePedido(esInicial);
		this.setMostrarid_estado_detalle_pedidoDetallePedido(esInicial);
		this.setMostrarcantidadDetallePedido(esInicial);
		this.setMostrarprecioDetallePedido(esInicial);
		this.setMostrardescuento_porcentajeDetallePedido(esInicial);
		this.setMostrardescuento_valorDetallePedido(esInicial);
		this.setMostrarivaDetallePedido(esInicial);
		this.setMostrariceDetallePedido(esInicial);
		this.setMostrartotalDetallePedido(esInicial);
		this.setMostrarcostoDetallePedido(esInicial);
		this.setMostrarutilidadDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ID)) {
				this.setMostraridDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPEDIDO)) {
				this.setMostrarid_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setMostrarid_estado_detalle_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IVA)) {
				this.setMostrarivaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ICE)) {
				this.setMostrariceDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.UTILIDAD)) {
				this.setMostrarutilidadDetallePedido(esAsigna);
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
		
		
		this.setActivaridDetallePedido(esInicial);
		this.setActivarid_pedidoDetallePedido(esInicial);
		this.setActivarid_empresaDetallePedido(esInicial);
		this.setActivarid_sucursalDetallePedido(esInicial);
		this.setActivarid_ejercicioDetallePedido(esInicial);
		this.setActivarid_periodoDetallePedido(esInicial);
		this.setActivarid_anioDetallePedido(esInicial);
		this.setActivarid_mesDetallePedido(esInicial);
		this.setActivarid_productoDetallePedido(esInicial);
		this.setActivarid_bodegaDetallePedido(esInicial);
		this.setActivarid_unidadDetallePedido(esInicial);
		this.setActivarid_estado_detalle_pedidoDetallePedido(esInicial);
		this.setActivarcantidadDetallePedido(esInicial);
		this.setActivarprecioDetallePedido(esInicial);
		this.setActivardescuento_porcentajeDetallePedido(esInicial);
		this.setActivardescuento_valorDetallePedido(esInicial);
		this.setActivarivaDetallePedido(esInicial);
		this.setActivariceDetallePedido(esInicial);
		this.setActivartotalDetallePedido(esInicial);
		this.setActivarcostoDetallePedido(esInicial);
		this.setActivarutilidadDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ID)) {
				this.setActivaridDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPEDIDO)) {
				this.setActivarid_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setActivarid_estado_detalle_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IVA)) {
				this.setActivarivaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ICE)) {
				this.setActivariceDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.TOTAL)) {
				this.setActivartotalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.COSTO)) {
				this.setActivarcostoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.UTILIDAD)) {
				this.setActivarutilidadDetallePedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePedido(esInicial);
		this.setResaltarid_pedidoDetallePedido(esInicial);
		this.setResaltarid_empresaDetallePedido(esInicial);
		this.setResaltarid_sucursalDetallePedido(esInicial);
		this.setResaltarid_ejercicioDetallePedido(esInicial);
		this.setResaltarid_periodoDetallePedido(esInicial);
		this.setResaltarid_anioDetallePedido(esInicial);
		this.setResaltarid_mesDetallePedido(esInicial);
		this.setResaltarid_productoDetallePedido(esInicial);
		this.setResaltarid_bodegaDetallePedido(esInicial);
		this.setResaltarid_unidadDetallePedido(esInicial);
		this.setResaltarid_estado_detalle_pedidoDetallePedido(esInicial);
		this.setResaltarcantidadDetallePedido(esInicial);
		this.setResaltarprecioDetallePedido(esInicial);
		this.setResaltardescuento_porcentajeDetallePedido(esInicial);
		this.setResaltardescuento_valorDetallePedido(esInicial);
		this.setResaltarivaDetallePedido(esInicial);
		this.setResaltariceDetallePedido(esInicial);
		this.setResaltartotalDetallePedido(esInicial);
		this.setResaltarcostoDetallePedido(esInicial);
		this.setResaltarutilidadDetallePedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ID)) {
				this.setResaltaridDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPEDIDO)) {
				this.setResaltarid_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IDESTADODETALLEPEDIDO)) {
				this.setResaltarid_estado_detalle_pedidoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.IVA)) {
				this.setResaltarivaDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.ICE)) {
				this.setResaltariceDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetallePedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoConstantesFunciones.UTILIDAD)) {
				this.setResaltarutilidadDetallePedido(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetallePedido=true;

	public Boolean getMostrarFK_IdBodegaDetallePedido() {
		return this.mostrarFK_IdBodegaDetallePedido;
	}

	public void setMostrarFK_IdBodegaDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePedido=true;

	public Boolean getMostrarFK_IdEjercicioDetallePedido() {
		return this.mostrarFK_IdEjercicioDetallePedido;
	}

	public void setMostrarFK_IdEjercicioDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePedido=true;

	public Boolean getMostrarFK_IdEmpresaDetallePedido() {
		return this.mostrarFK_IdEmpresaDetallePedido;
	}

	public void setMostrarFK_IdEmpresaDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetallePedidoDetallePedido=true;

	public Boolean getMostrarFK_IdEstadoDetallePedidoDetallePedido() {
		return this.mostrarFK_IdEstadoDetallePedidoDetallePedido;
	}

	public void setMostrarFK_IdEstadoDetallePedidoDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetallePedidoDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoDetallePedido=true;

	public Boolean getMostrarFK_IdPedidoDetallePedido() {
		return this.mostrarFK_IdPedidoDetallePedido;
	}

	public void setMostrarFK_IdPedidoDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePedido=true;

	public Boolean getMostrarFK_IdPeriodoDetallePedido() {
		return this.mostrarFK_IdPeriodoDetallePedido;
	}

	public void setMostrarFK_IdPeriodoDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePedido=true;

	public Boolean getMostrarFK_IdProductoDetallePedido() {
		return this.mostrarFK_IdProductoDetallePedido;
	}

	public void setMostrarFK_IdProductoDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePedido=true;

	public Boolean getMostrarFK_IdSucursalDetallePedido() {
		return this.mostrarFK_IdSucursalDetallePedido;
	}

	public void setMostrarFK_IdSucursalDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePedido=true;

	public Boolean getMostrarFK_IdUnidadDetallePedido() {
		return this.mostrarFK_IdUnidadDetallePedido;
	}

	public void setMostrarFK_IdUnidadDetallePedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePedido= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetallePedido=true;

	public Boolean getActivarFK_IdBodegaDetallePedido() {
		return this.activarFK_IdBodegaDetallePedido;
	}

	public void setActivarFK_IdBodegaDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePedido=true;

	public Boolean getActivarFK_IdEjercicioDetallePedido() {
		return this.activarFK_IdEjercicioDetallePedido;
	}

	public void setActivarFK_IdEjercicioDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePedido=true;

	public Boolean getActivarFK_IdEmpresaDetallePedido() {
		return this.activarFK_IdEmpresaDetallePedido;
	}

	public void setActivarFK_IdEmpresaDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetallePedidoDetallePedido=true;

	public Boolean getActivarFK_IdEstadoDetallePedidoDetallePedido() {
		return this.activarFK_IdEstadoDetallePedidoDetallePedido;
	}

	public void setActivarFK_IdEstadoDetallePedidoDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetallePedidoDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoDetallePedido=true;

	public Boolean getActivarFK_IdPedidoDetallePedido() {
		return this.activarFK_IdPedidoDetallePedido;
	}

	public void setActivarFK_IdPedidoDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePedido=true;

	public Boolean getActivarFK_IdPeriodoDetallePedido() {
		return this.activarFK_IdPeriodoDetallePedido;
	}

	public void setActivarFK_IdPeriodoDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePedido=true;

	public Boolean getActivarFK_IdProductoDetallePedido() {
		return this.activarFK_IdProductoDetallePedido;
	}

	public void setActivarFK_IdProductoDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePedido=true;

	public Boolean getActivarFK_IdSucursalDetallePedido() {
		return this.activarFK_IdSucursalDetallePedido;
	}

	public void setActivarFK_IdSucursalDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePedido= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePedido=true;

	public Boolean getActivarFK_IdUnidadDetallePedido() {
		return this.activarFK_IdUnidadDetallePedido;
	}

	public void setActivarFK_IdUnidadDetallePedido(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePedido= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetallePedido=null;

	public Border getResaltarFK_IdBodegaDetallePedido() {
		return this.resaltarFK_IdBodegaDetallePedido;
	}

	public void setResaltarFK_IdBodegaDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePedido=null;

	public Border getResaltarFK_IdEjercicioDetallePedido() {
		return this.resaltarFK_IdEjercicioDetallePedido;
	}

	public void setResaltarFK_IdEjercicioDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePedido=null;

	public Border getResaltarFK_IdEmpresaDetallePedido() {
		return this.resaltarFK_IdEmpresaDetallePedido;
	}

	public void setResaltarFK_IdEmpresaDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetallePedidoDetallePedido=null;

	public Border getResaltarFK_IdEstadoDetallePedidoDetallePedido() {
		return this.resaltarFK_IdEstadoDetallePedidoDetallePedido;
	}

	public void setResaltarFK_IdEstadoDetallePedidoDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetallePedidoDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetallePedidoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetallePedidoDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdPedidoDetallePedido=null;

	public Border getResaltarFK_IdPedidoDetallePedido() {
		return this.resaltarFK_IdPedidoDetallePedido;
	}

	public void setResaltarFK_IdPedidoDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdPedidoDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdPedidoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePedido=null;

	public Border getResaltarFK_IdPeriodoDetallePedido() {
		return this.resaltarFK_IdPeriodoDetallePedido;
	}

	public void setResaltarFK_IdPeriodoDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePedido=null;

	public Border getResaltarFK_IdProductoDetallePedido() {
		return this.resaltarFK_IdProductoDetallePedido;
	}

	public void setResaltarFK_IdProductoDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePedido=null;

	public Border getResaltarFK_IdSucursalDetallePedido() {
		return this.resaltarFK_IdSucursalDetallePedido;
	}

	public void setResaltarFK_IdSucursalDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePedido= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePedido=null;

	public Border getResaltarFK_IdUnidadDetallePedido() {
		return this.resaltarFK_IdUnidadDetallePedido;
	}

	public void setResaltarFK_IdUnidadDetallePedido(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePedido= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePedido(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoBeanSwingJInternalFrame detallepedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}