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


import com.bydan.erp.inventario.util.DetallePedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePedidoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePedidoCompraParameterGeneral;

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
final public class DetallePedidoCompraConstantesFunciones extends DetallePedidoCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePedidoCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePedidoCompra"+DetallePedidoCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePedidoCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePedidoCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePedidoCompraConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePedidoCompraConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePedidoCompraConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePedidoCompraConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePedidoCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePedidoCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pedido Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePedidoCompra";
	public static final String OBJECTNAME="detallepedidocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_pedido_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepedidocompra from "+DetallePedidoCompraConstantesFunciones.SPERSISTENCENAME+" detallepedidocompra";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_pedido_compra,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_mes,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_pedido,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".costo_total,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".descripcion,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_entregada,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_pendiente from "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePedidoCompraConstantesFuncionesAdditional detallepedidocompraConstantesFuncionesAdditional=null;
	
	public DetallePedidoCompraConstantesFuncionesAdditional getDetallePedidoCompraConstantesFuncionesAdditional() {
		return this.detallepedidocompraConstantesFuncionesAdditional;
	}
	
	public void setDetallePedidoCompraConstantesFuncionesAdditional(DetallePedidoCompraConstantesFuncionesAdditional detallepedidocompraConstantesFuncionesAdditional) {
		try {
			this.detallepedidocompraConstantesFuncionesAdditional=detallepedidocompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPEDIDOCOMPRA= "id_pedido_compra";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String CANTIDADPEDIDO= "cantidad_pedido";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDADENTREGADA= "cantidad_entregada";
    public static final String CANTIDADPENDIENTE= "cantidad_pendiente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPEDIDOCOMPRA= "Pedido Compra";
		public static final String LABEL_IDPEDIDOCOMPRA_LOWER= "Pedido Compra";
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
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_CANTIDADPEDIDO= "Cantidad Pedido";
		public static final String LABEL_CANTIDADPEDIDO_LOWER= "Cantidad Pedido";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDADENTREGADA= "Cantidad Entregada";
		public static final String LABEL_CANTIDADENTREGADA_LOWER= "Cantidad Entregada";
    	public static final String LABEL_CANTIDADPENDIENTE= "Cantidad Pendiente";
		public static final String LABEL_CANTIDADPENDIENTE_LOWER= "Cantidad Pendiente";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetallePedidoCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDANIO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDMES)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDBODEGA)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPEDIDO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADENTREGADA;}
		if(sNombreColumna.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePedidoCompraDescripcion(DetallePedidoCompra detallepedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepedidocompra !=null/* && detallepedidocompra.getId()!=0*/) {
			if(detallepedidocompra.getId()!=null) {
				sDescripcion=detallepedidocompra.getId().toString();
			}//detallepedidocompradetallepedidocompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePedidoCompraDescripcionDetallado(DetallePedidoCompra detallepedidocompra) {
		String sDescripcion="";
			
		sDescripcion+=DetallePedidoCompraConstantesFunciones.ID+"=";
		sDescripcion+=detallepedidocompra.getId().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepedidocompra.getVersionRow().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA+"=";
		sDescripcion+=detallepedidocompra.getid_pedido_compra().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepedidocompra.getid_empresa().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepedidocompra.getid_sucursal().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepedidocompra.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepedidocompra.getid_periodo().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepedidocompra.getid_anio().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepedidocompra.getid_mes().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallepedidocompra.getid_bodega().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallepedidocompra.getid_producto().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallepedidocompra.getid_unidad().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallepedidocompra.getid_centro_costo().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO+"=";
		sDescripcion+=detallepedidocompra.getcantidad_pedido().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detallepedidocompra.getcosto_unitario().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detallepedidocompra.getcosto_total().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallepedidocompra.getdescripcion()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA+"=";
		sDescripcion+=detallepedidocompra.getcantidad_entregada().toString()+",";
		sDescripcion+=DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=detallepedidocompra.getcantidad_pendiente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePedidoCompraDescripcion(DetallePedidoCompra detallepedidocompra,String sValor) throws Exception {			
		if(detallepedidocompra !=null) {
			//detallepedidocompradetallepedidocompra.getId().toString();
		}		
	}
	
		

	public static String getPedidoCompraDescripcion(PedidoCompra pedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidocompra!=null/*&&pedidocompra.getId()>0*/) {
			sDescripcion=PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(pedidocompra);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPedidoCompra")) {
			sNombreIndice="Tipo=  Por Pedido Compra";
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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoCompra(Long id_pedido_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_compra!=null) {sDetalleIndice+=" Codigo Unico De Pedido Compra="+id_pedido_compra.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetallePedidoCompra(DetallePedidoCompra detallepedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidocompra.setdescripcion(detallepedidocompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetallePedidoCompras(List<DetallePedidoCompra> detallepedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {
			detallepedidocompra.setdescripcion(detallepedidocompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoCompra(DetallePedidoCompra detallepedidocompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepedidocompra.getConCambioAuxiliar()) {
			detallepedidocompra.setIsDeleted(detallepedidocompra.getIsDeletedAuxiliar());	
			detallepedidocompra.setIsNew(detallepedidocompra.getIsNewAuxiliar());	
			detallepedidocompra.setIsChanged(detallepedidocompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepedidocompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepedidocompra.setIsDeletedAuxiliar(false);	
			detallepedidocompra.setIsNewAuxiliar(false);	
			detallepedidocompra.setIsChangedAuxiliar(false);
			
			detallepedidocompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoCompras(List<DetallePedidoCompra> detallepedidocompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra : detallepedidocompras) {
			if(conAsignarBase && detallepedidocompra.getConCambioAuxiliar()) {
				detallepedidocompra.setIsDeleted(detallepedidocompra.getIsDeletedAuxiliar());	
				detallepedidocompra.setIsNew(detallepedidocompra.getIsNewAuxiliar());	
				detallepedidocompra.setIsChanged(detallepedidocompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepedidocompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepedidocompra.setIsDeletedAuxiliar(false);	
				detallepedidocompra.setIsNewAuxiliar(false);	
				detallepedidocompra.setIsChangedAuxiliar(false);
				
				detallepedidocompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePedidoCompra(DetallePedidoCompra detallepedidocompra,Boolean conEnteros) throws Exception  {
		detallepedidocompra.setcosto_unitario(0.0);
		detallepedidocompra.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepedidocompra.setcantidad_pedido(0);
			detallepedidocompra.setcantidad_entregada(0);
			detallepedidocompra.setcantidad_pendiente(0);
		}
	}		
	
	public static void InicializarValoresDetallePedidoCompras(List<DetallePedidoCompra> detallepedidocompras,Boolean conEnteros) throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {
			detallepedidocompra.setcosto_unitario(0.0);
			detallepedidocompra.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepedidocompra.setcantidad_pedido(0);
				detallepedidocompra.setcantidad_entregada(0);
				detallepedidocompra.setcantidad_pendiente(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePedidoCompra(List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompra detallepedidocompraAux) throws Exception  {
		DetallePedidoCompraConstantesFunciones.InicializarValoresDetallePedidoCompra(detallepedidocompraAux,true);
		
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {
			if(detallepedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepedidocompraAux.setcantidad_pedido(detallepedidocompraAux.getcantidad_pedido()+detallepedidocompra.getcantidad_pedido());			
			detallepedidocompraAux.setcosto_unitario(detallepedidocompraAux.getcosto_unitario()+detallepedidocompra.getcosto_unitario());			
			detallepedidocompraAux.setcosto_total(detallepedidocompraAux.getcosto_total()+detallepedidocompra.getcosto_total());			
			detallepedidocompraAux.setcantidad_entregada(detallepedidocompraAux.getcantidad_entregada()+detallepedidocompra.getcantidad_entregada());			
			detallepedidocompraAux.setcantidad_pendiente(detallepedidocompraAux.getcantidad_pendiente()+detallepedidocompra.getcantidad_pendiente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePedidoCompraConstantesFunciones.getArrayColumnasGlobalesDetallePedidoCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoCompra> detallepedidocompras,DetallePedidoCompra detallepedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoCompra detallepedidocompraAux: detallepedidocompras) {
			if(detallepedidocompraAux!=null && detallepedidocompra!=null) {
				if((detallepedidocompraAux.getId()==null && detallepedidocompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepedidocompraAux.getId()!=null && detallepedidocompra.getId()!=null){
					if(detallepedidocompraAux.getId().equals(detallepedidocompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoCompra(List<DetallePedidoCompra> detallepedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(DetallePedidoCompra detallepedidocompra: detallepedidocompras) {			
			if(detallepedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=detallepedidocompra.getcosto_unitario();
			costo_totalTotal+=detallepedidocompra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePedidoCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_ID, DetallePedidoCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_VERSIONROW, DetallePedidoCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA, DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDEMPRESA, DetallePedidoCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDSUCURSAL, DetallePedidoCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDEJERCICIO, DetallePedidoCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDPERIODO, DetallePedidoCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDANIO, DetallePedidoCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDMES, DetallePedidoCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDBODEGA, DetallePedidoCompraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDPRODUCTO, DetallePedidoCompraConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDUNIDAD, DetallePedidoCompraConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_IDCENTROCOSTO, DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPEDIDO, DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO, DetallePedidoCompraConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL, DetallePedidoCompraConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_DESCRIPCION, DetallePedidoCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADENTREGADA, DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE, DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePedidoCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompra() throws Exception  {
		return DetallePedidoCompraConstantesFunciones.getTiposSeleccionarDetallePedidoCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompra(Boolean conFk) throws Exception  {
		return DetallePedidoCompraConstantesFunciones.getTiposSeleccionarDetallePedidoCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPEDIDO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePedidoCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoCompra(DetallePedidoCompra detallepedidocompraAux) throws Exception {
		
			detallepedidocompraAux.setpedidocompra_descripcion(PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(detallepedidocompraAux.getPedidoCompra()));
			detallepedidocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidocompraAux.getEmpresa()));
			detallepedidocompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidocompraAux.getSucursal()));
			detallepedidocompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidocompraAux.getEjercicio()));
			detallepedidocompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidocompraAux.getPeriodo()));
			detallepedidocompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidocompraAux.getAnio()));
			detallepedidocompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidocompraAux.getMes()));
			detallepedidocompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidocompraAux.getBodega()));
			detallepedidocompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidocompraAux.getProducto()));
			detallepedidocompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidocompraAux.getUnidad()));
			detallepedidocompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallepedidocompraAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoCompra(List<DetallePedidoCompra> detallepedidocomprasTemp) throws Exception {
		for(DetallePedidoCompra detallepedidocompraAux:detallepedidocomprasTemp) {
			
			detallepedidocompraAux.setpedidocompra_descripcion(PedidoCompraConstantesFunciones.getPedidoCompraDescripcion(detallepedidocompraAux.getPedidoCompra()));
			detallepedidocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidocompraAux.getEmpresa()));
			detallepedidocompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidocompraAux.getSucursal()));
			detallepedidocompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidocompraAux.getEjercicio()));
			detallepedidocompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidocompraAux.getPeriodo()));
			detallepedidocompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidocompraAux.getAnio()));
			detallepedidocompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidocompraAux.getMes()));
			detallepedidocompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidocompraAux.getBodega()));
			detallepedidocompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidocompraAux.getProducto()));
			detallepedidocompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidocompraAux.getUnidad()));
			detallepedidocompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallepedidocompraAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoCompra.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(CentroCosto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompra.class)) {
						classes.add(new Classe(PedidoCompra.class));
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompra.class)); continue;
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoCompraConstantesFunciones.getClassesRelationshipsOfDetallePedidoCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoCompraConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePedidoCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePedidoCompra detallepedidocompra,List<DetallePedidoCompra> detallepedidocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePedidoCompra detallepedidocompraEncontrado=null;
			
			for(DetallePedidoCompra detallepedidocompraLocal:detallepedidocompras) {
				if(detallepedidocompraLocal.getId().equals(detallepedidocompra.getId())) {
					detallepedidocompraEncontrado=detallepedidocompraLocal;
					
					detallepedidocompraLocal.setIsChanged(detallepedidocompra.getIsChanged());
					detallepedidocompraLocal.setIsNew(detallepedidocompra.getIsNew());
					detallepedidocompraLocal.setIsDeleted(detallepedidocompra.getIsDeleted());
					
					detallepedidocompraLocal.setGeneralEntityOriginal(detallepedidocompra.getGeneralEntityOriginal());
					
					detallepedidocompraLocal.setId(detallepedidocompra.getId());	
					detallepedidocompraLocal.setVersionRow(detallepedidocompra.getVersionRow());	
					detallepedidocompraLocal.setid_pedido_compra(detallepedidocompra.getid_pedido_compra());	
					detallepedidocompraLocal.setid_empresa(detallepedidocompra.getid_empresa());	
					detallepedidocompraLocal.setid_sucursal(detallepedidocompra.getid_sucursal());	
					detallepedidocompraLocal.setid_ejercicio(detallepedidocompra.getid_ejercicio());	
					detallepedidocompraLocal.setid_periodo(detallepedidocompra.getid_periodo());	
					detallepedidocompraLocal.setid_anio(detallepedidocompra.getid_anio());	
					detallepedidocompraLocal.setid_mes(detallepedidocompra.getid_mes());	
					detallepedidocompraLocal.setid_bodega(detallepedidocompra.getid_bodega());	
					detallepedidocompraLocal.setid_producto(detallepedidocompra.getid_producto());	
					detallepedidocompraLocal.setid_unidad(detallepedidocompra.getid_unidad());	
					detallepedidocompraLocal.setid_centro_costo(detallepedidocompra.getid_centro_costo());	
					detallepedidocompraLocal.setcantidad_pedido(detallepedidocompra.getcantidad_pedido());	
					detallepedidocompraLocal.setcosto_unitario(detallepedidocompra.getcosto_unitario());	
					detallepedidocompraLocal.setcosto_total(detallepedidocompra.getcosto_total());	
					detallepedidocompraLocal.setdescripcion(detallepedidocompra.getdescripcion());	
					detallepedidocompraLocal.setcantidad_entregada(detallepedidocompra.getcantidad_entregada());	
					detallepedidocompraLocal.setcantidad_pendiente(detallepedidocompra.getcantidad_pendiente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepedidocompra.getIsDeleted()) {
				if(!existe) {
					detallepedidocompras.add(detallepedidocompra);
				}
			} else {
				if(detallepedidocompraEncontrado!=null && permiteQuitar)  {
					detallepedidocompras.remove(detallepedidocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePedidoCompra detallepedidocompra,List<DetallePedidoCompra> detallepedidocompras) throws Exception {
		try	{			
			for(DetallePedidoCompra detallepedidocompraLocal:detallepedidocompras) {
				if(detallepedidocompraLocal.getId().equals(detallepedidocompra.getId())) {
					detallepedidocompraLocal.setIsSelected(detallepedidocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePedidoCompra(List<DetallePedidoCompra> detallepedidocomprasAux) throws Exception {
		//this.detallepedidocomprasAux=detallepedidocomprasAux;
		
		for(DetallePedidoCompra detallepedidocompraAux:detallepedidocomprasAux) {
			if(detallepedidocompraAux.getIsChanged()) {
				detallepedidocompraAux.setIsChanged(false);
			}		
			
			if(detallepedidocompraAux.getIsNew()) {
				detallepedidocompraAux.setIsNew(false);
			}	
			
			if(detallepedidocompraAux.getIsDeleted()) {
				detallepedidocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePedidoCompra(DetallePedidoCompra detallepedidocompraAux) throws Exception {
		//this.detallepedidocompraAux=detallepedidocompraAux;
		
			if(detallepedidocompraAux.getIsChanged()) {
				detallepedidocompraAux.setIsChanged(false);
			}		
			
			if(detallepedidocompraAux.getIsNew()) {
				detallepedidocompraAux.setIsNew(false);
			}	
			
			if(detallepedidocompraAux.getIsDeleted()) {
				detallepedidocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePedidoCompra detallepedidocompraAsignar,DetallePedidoCompra detallepedidocompra) throws Exception {
		detallepedidocompraAsignar.setId(detallepedidocompra.getId());	
		detallepedidocompraAsignar.setVersionRow(detallepedidocompra.getVersionRow());	
		detallepedidocompraAsignar.setid_pedido_compra(detallepedidocompra.getid_pedido_compra());
		detallepedidocompraAsignar.setpedidocompra_descripcion(detallepedidocompra.getpedidocompra_descripcion());	
		detallepedidocompraAsignar.setid_empresa(detallepedidocompra.getid_empresa());
		detallepedidocompraAsignar.setempresa_descripcion(detallepedidocompra.getempresa_descripcion());	
		detallepedidocompraAsignar.setid_sucursal(detallepedidocompra.getid_sucursal());
		detallepedidocompraAsignar.setsucursal_descripcion(detallepedidocompra.getsucursal_descripcion());	
		detallepedidocompraAsignar.setid_ejercicio(detallepedidocompra.getid_ejercicio());
		detallepedidocompraAsignar.setejercicio_descripcion(detallepedidocompra.getejercicio_descripcion());	
		detallepedidocompraAsignar.setid_periodo(detallepedidocompra.getid_periodo());
		detallepedidocompraAsignar.setperiodo_descripcion(detallepedidocompra.getperiodo_descripcion());	
		detallepedidocompraAsignar.setid_anio(detallepedidocompra.getid_anio());
		detallepedidocompraAsignar.setanio_descripcion(detallepedidocompra.getanio_descripcion());	
		detallepedidocompraAsignar.setid_mes(detallepedidocompra.getid_mes());
		detallepedidocompraAsignar.setmes_descripcion(detallepedidocompra.getmes_descripcion());	
		detallepedidocompraAsignar.setid_bodega(detallepedidocompra.getid_bodega());
		detallepedidocompraAsignar.setbodega_descripcion(detallepedidocompra.getbodega_descripcion());	
		detallepedidocompraAsignar.setid_producto(detallepedidocompra.getid_producto());
		detallepedidocompraAsignar.setproducto_descripcion(detallepedidocompra.getproducto_descripcion());	
		detallepedidocompraAsignar.setid_unidad(detallepedidocompra.getid_unidad());
		detallepedidocompraAsignar.setunidad_descripcion(detallepedidocompra.getunidad_descripcion());	
		detallepedidocompraAsignar.setid_centro_costo(detallepedidocompra.getid_centro_costo());
		detallepedidocompraAsignar.setcentrocosto_descripcion(detallepedidocompra.getcentrocosto_descripcion());	
		detallepedidocompraAsignar.setcantidad_pedido(detallepedidocompra.getcantidad_pedido());	
		detallepedidocompraAsignar.setcosto_unitario(detallepedidocompra.getcosto_unitario());	
		detallepedidocompraAsignar.setcosto_total(detallepedidocompra.getcosto_total());	
		detallepedidocompraAsignar.setdescripcion(detallepedidocompra.getdescripcion());	
		detallepedidocompraAsignar.setcantidad_entregada(detallepedidocompra.getcantidad_entregada());	
		detallepedidocompraAsignar.setcantidad_pendiente(detallepedidocompra.getcantidad_pendiente());	
	}
	
	public static void inicializarDetallePedidoCompra(DetallePedidoCompra detallepedidocompra) throws Exception {
		try {
				detallepedidocompra.setId(0L);	
					
				detallepedidocompra.setid_pedido_compra(-1L);	
				detallepedidocompra.setid_empresa(-1L);	
				detallepedidocompra.setid_sucursal(-1L);	
				detallepedidocompra.setid_ejercicio(-1L);	
				detallepedidocompra.setid_periodo(-1L);	
				detallepedidocompra.setid_anio(null);	
				detallepedidocompra.setid_mes(null);	
				detallepedidocompra.setid_bodega(-1L);	
				detallepedidocompra.setid_producto(-1L);	
				detallepedidocompra.setid_unidad(-1L);	
				detallepedidocompra.setid_centro_costo(null);	
				detallepedidocompra.setcantidad_pedido(0);	
				detallepedidocompra.setcosto_unitario(0.0);	
				detallepedidocompra.setcosto_total(0.0);	
				detallepedidocompra.setdescripcion("");	
				detallepedidocompra.setcantidad_entregada(0);	
				detallepedidocompra.setcantidad_pendiente(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePedidoCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDPEDIDOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePedidoCompra(String sTipo,Row row,Workbook workbook,DetallePedidoCompra detallepedidocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getpedidocompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcantidad_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcantidad_entregada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompra.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePedidoCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePedidoCompra() {
		return this.sFinalQueryDetallePedidoCompra;
	}
	
	public void setsFinalQueryDetallePedidoCompra(String sFinalQueryDetallePedidoCompra) {
		this.sFinalQueryDetallePedidoCompra= sFinalQueryDetallePedidoCompra;
	}
	
	public Border resaltarSeleccionarDetallePedidoCompra=null;
	
	public Border setResaltarSeleccionarDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePedidoCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePedidoCompra() {
		return this.resaltarSeleccionarDetallePedidoCompra;
	}
	
	public void setResaltarSeleccionarDetallePedidoCompra(Border borderResaltarSeleccionarDetallePedidoCompra) {
		this.resaltarSeleccionarDetallePedidoCompra= borderResaltarSeleccionarDetallePedidoCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePedidoCompra=null;
	public Boolean mostraridDetallePedidoCompra=true;
	public Boolean activaridDetallePedidoCompra=true;

	public Border resaltarid_pedido_compraDetallePedidoCompra=null;
	public Boolean mostrarid_pedido_compraDetallePedidoCompra=true;
	public Boolean activarid_pedido_compraDetallePedidoCompra=true;
	public Boolean cargarid_pedido_compraDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_compraDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_empresaDetallePedidoCompra=null;
	public Boolean mostrarid_empresaDetallePedidoCompra=true;
	public Boolean activarid_empresaDetallePedidoCompra=true;
	public Boolean cargarid_empresaDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePedidoCompra=null;
	public Boolean mostrarid_sucursalDetallePedidoCompra=true;
	public Boolean activarid_sucursalDetallePedidoCompra=true;
	public Boolean cargarid_sucursalDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePedidoCompra=null;
	public Boolean mostrarid_ejercicioDetallePedidoCompra=true;
	public Boolean activarid_ejercicioDetallePedidoCompra=true;
	public Boolean cargarid_ejercicioDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePedidoCompra=null;
	public Boolean mostrarid_periodoDetallePedidoCompra=true;
	public Boolean activarid_periodoDetallePedidoCompra=true;
	public Boolean cargarid_periodoDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_anioDetallePedidoCompra=null;
	public Boolean mostrarid_anioDetallePedidoCompra=true;
	public Boolean activarid_anioDetallePedidoCompra=false;
	public Boolean cargarid_anioDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePedidoCompra=null;
	public Boolean mostrarid_mesDetallePedidoCompra=true;
	public Boolean activarid_mesDetallePedidoCompra=false;
	public Boolean cargarid_mesDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetallePedidoCompra=null;
	public Boolean mostrarid_bodegaDetallePedidoCompra=true;
	public Boolean activarid_bodegaDetallePedidoCompra=true;
	public Boolean cargarid_bodegaDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePedidoCompra=null;
	public Boolean mostrarid_productoDetallePedidoCompra=true;
	public Boolean activarid_productoDetallePedidoCompra=true;
	public Boolean cargarid_productoDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePedidoCompra=true;//ConEventDepend=true

	public Border resaltarid_unidadDetallePedidoCompra=null;
	public Boolean mostrarid_unidadDetallePedidoCompra=true;
	public Boolean activarid_unidadDetallePedidoCompra=true;
	public Boolean cargarid_unidadDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePedidoCompra=true;//ConEventDepend=true

	public Border resaltarid_centro_costoDetallePedidoCompra=null;
	public Boolean mostrarid_centro_costoDetallePedidoCompra=true;
	public Boolean activarid_centro_costoDetallePedidoCompra=true;
	public Boolean cargarid_centro_costoDetallePedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetallePedidoCompra=false;//ConEventDepend=true

	public Border resaltarcantidad_pedidoDetallePedidoCompra=null;
	public Boolean mostrarcantidad_pedidoDetallePedidoCompra=true;
	public Boolean activarcantidad_pedidoDetallePedidoCompra=true;

	public Border resaltarcosto_unitarioDetallePedidoCompra=null;
	public Boolean mostrarcosto_unitarioDetallePedidoCompra=true;
	public Boolean activarcosto_unitarioDetallePedidoCompra=false;

	public Border resaltarcosto_totalDetallePedidoCompra=null;
	public Boolean mostrarcosto_totalDetallePedidoCompra=true;
	public Boolean activarcosto_totalDetallePedidoCompra=false;

	public Border resaltardescripcionDetallePedidoCompra=null;
	public Boolean mostrardescripcionDetallePedidoCompra=true;
	public Boolean activardescripcionDetallePedidoCompra=true;

	public Border resaltarcantidad_entregadaDetallePedidoCompra=null;
	public Boolean mostrarcantidad_entregadaDetallePedidoCompra=true;
	public Boolean activarcantidad_entregadaDetallePedidoCompra=false;

	public Border resaltarcantidad_pendienteDetallePedidoCompra=null;
	public Boolean mostrarcantidad_pendienteDetallePedidoCompra=true;
	public Boolean activarcantidad_pendienteDetallePedidoCompra=false;

	
	

	public Border setResaltaridDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltaridDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePedidoCompra() {
		return this.resaltaridDetallePedidoCompra;
	}

	public void setResaltaridDetallePedidoCompra(Border borderResaltar) {
		this.resaltaridDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostraridDetallePedidoCompra() {
		return this.mostraridDetallePedidoCompra;
	}

	public void setMostraridDetallePedidoCompra(Boolean mostraridDetallePedidoCompra) {
		this.mostraridDetallePedidoCompra= mostraridDetallePedidoCompra;
	}

	public Boolean getActivaridDetallePedidoCompra() {
		return this.activaridDetallePedidoCompra;
	}

	public void setActivaridDetallePedidoCompra(Boolean activaridDetallePedidoCompra) {
		this.activaridDetallePedidoCompra= activaridDetallePedidoCompra;
	}

	public Border setResaltarid_pedido_compraDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_pedido_compraDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_compraDetallePedidoCompra() {
		return this.resaltarid_pedido_compraDetallePedidoCompra;
	}

	public void setResaltarid_pedido_compraDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_pedido_compraDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_pedido_compraDetallePedidoCompra() {
		return this.mostrarid_pedido_compraDetallePedidoCompra;
	}

	public void setMostrarid_pedido_compraDetallePedidoCompra(Boolean mostrarid_pedido_compraDetallePedidoCompra) {
		this.mostrarid_pedido_compraDetallePedidoCompra= mostrarid_pedido_compraDetallePedidoCompra;
	}

	public Boolean getActivarid_pedido_compraDetallePedidoCompra() {
		return this.activarid_pedido_compraDetallePedidoCompra;
	}

	public void setActivarid_pedido_compraDetallePedidoCompra(Boolean activarid_pedido_compraDetallePedidoCompra) {
		this.activarid_pedido_compraDetallePedidoCompra= activarid_pedido_compraDetallePedidoCompra;
	}

	public Boolean getCargarid_pedido_compraDetallePedidoCompra() {
		return this.cargarid_pedido_compraDetallePedidoCompra;
	}

	public void setCargarid_pedido_compraDetallePedidoCompra(Boolean cargarid_pedido_compraDetallePedidoCompra) {
		this.cargarid_pedido_compraDetallePedidoCompra= cargarid_pedido_compraDetallePedidoCompra;
	}

	public Border setResaltarid_empresaDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePedidoCompra() {
		return this.resaltarid_empresaDetallePedidoCompra;
	}

	public void setResaltarid_empresaDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_empresaDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePedidoCompra() {
		return this.mostrarid_empresaDetallePedidoCompra;
	}

	public void setMostrarid_empresaDetallePedidoCompra(Boolean mostrarid_empresaDetallePedidoCompra) {
		this.mostrarid_empresaDetallePedidoCompra= mostrarid_empresaDetallePedidoCompra;
	}

	public Boolean getActivarid_empresaDetallePedidoCompra() {
		return this.activarid_empresaDetallePedidoCompra;
	}

	public void setActivarid_empresaDetallePedidoCompra(Boolean activarid_empresaDetallePedidoCompra) {
		this.activarid_empresaDetallePedidoCompra= activarid_empresaDetallePedidoCompra;
	}

	public Boolean getCargarid_empresaDetallePedidoCompra() {
		return this.cargarid_empresaDetallePedidoCompra;
	}

	public void setCargarid_empresaDetallePedidoCompra(Boolean cargarid_empresaDetallePedidoCompra) {
		this.cargarid_empresaDetallePedidoCompra= cargarid_empresaDetallePedidoCompra;
	}

	public Border setResaltarid_sucursalDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePedidoCompra() {
		return this.resaltarid_sucursalDetallePedidoCompra;
	}

	public void setResaltarid_sucursalDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_sucursalDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePedidoCompra() {
		return this.mostrarid_sucursalDetallePedidoCompra;
	}

	public void setMostrarid_sucursalDetallePedidoCompra(Boolean mostrarid_sucursalDetallePedidoCompra) {
		this.mostrarid_sucursalDetallePedidoCompra= mostrarid_sucursalDetallePedidoCompra;
	}

	public Boolean getActivarid_sucursalDetallePedidoCompra() {
		return this.activarid_sucursalDetallePedidoCompra;
	}

	public void setActivarid_sucursalDetallePedidoCompra(Boolean activarid_sucursalDetallePedidoCompra) {
		this.activarid_sucursalDetallePedidoCompra= activarid_sucursalDetallePedidoCompra;
	}

	public Boolean getCargarid_sucursalDetallePedidoCompra() {
		return this.cargarid_sucursalDetallePedidoCompra;
	}

	public void setCargarid_sucursalDetallePedidoCompra(Boolean cargarid_sucursalDetallePedidoCompra) {
		this.cargarid_sucursalDetallePedidoCompra= cargarid_sucursalDetallePedidoCompra;
	}

	public Border setResaltarid_ejercicioDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePedidoCompra() {
		return this.resaltarid_ejercicioDetallePedidoCompra;
	}

	public void setResaltarid_ejercicioDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePedidoCompra() {
		return this.mostrarid_ejercicioDetallePedidoCompra;
	}

	public void setMostrarid_ejercicioDetallePedidoCompra(Boolean mostrarid_ejercicioDetallePedidoCompra) {
		this.mostrarid_ejercicioDetallePedidoCompra= mostrarid_ejercicioDetallePedidoCompra;
	}

	public Boolean getActivarid_ejercicioDetallePedidoCompra() {
		return this.activarid_ejercicioDetallePedidoCompra;
	}

	public void setActivarid_ejercicioDetallePedidoCompra(Boolean activarid_ejercicioDetallePedidoCompra) {
		this.activarid_ejercicioDetallePedidoCompra= activarid_ejercicioDetallePedidoCompra;
	}

	public Boolean getCargarid_ejercicioDetallePedidoCompra() {
		return this.cargarid_ejercicioDetallePedidoCompra;
	}

	public void setCargarid_ejercicioDetallePedidoCompra(Boolean cargarid_ejercicioDetallePedidoCompra) {
		this.cargarid_ejercicioDetallePedidoCompra= cargarid_ejercicioDetallePedidoCompra;
	}

	public Border setResaltarid_periodoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePedidoCompra() {
		return this.resaltarid_periodoDetallePedidoCompra;
	}

	public void setResaltarid_periodoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_periodoDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePedidoCompra() {
		return this.mostrarid_periodoDetallePedidoCompra;
	}

	public void setMostrarid_periodoDetallePedidoCompra(Boolean mostrarid_periodoDetallePedidoCompra) {
		this.mostrarid_periodoDetallePedidoCompra= mostrarid_periodoDetallePedidoCompra;
	}

	public Boolean getActivarid_periodoDetallePedidoCompra() {
		return this.activarid_periodoDetallePedidoCompra;
	}

	public void setActivarid_periodoDetallePedidoCompra(Boolean activarid_periodoDetallePedidoCompra) {
		this.activarid_periodoDetallePedidoCompra= activarid_periodoDetallePedidoCompra;
	}

	public Boolean getCargarid_periodoDetallePedidoCompra() {
		return this.cargarid_periodoDetallePedidoCompra;
	}

	public void setCargarid_periodoDetallePedidoCompra(Boolean cargarid_periodoDetallePedidoCompra) {
		this.cargarid_periodoDetallePedidoCompra= cargarid_periodoDetallePedidoCompra;
	}

	public Border setResaltarid_anioDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePedidoCompra() {
		return this.resaltarid_anioDetallePedidoCompra;
	}

	public void setResaltarid_anioDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_anioDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePedidoCompra() {
		return this.mostrarid_anioDetallePedidoCompra;
	}

	public void setMostrarid_anioDetallePedidoCompra(Boolean mostrarid_anioDetallePedidoCompra) {
		this.mostrarid_anioDetallePedidoCompra= mostrarid_anioDetallePedidoCompra;
	}

	public Boolean getActivarid_anioDetallePedidoCompra() {
		return this.activarid_anioDetallePedidoCompra;
	}

	public void setActivarid_anioDetallePedidoCompra(Boolean activarid_anioDetallePedidoCompra) {
		this.activarid_anioDetallePedidoCompra= activarid_anioDetallePedidoCompra;
	}

	public Boolean getCargarid_anioDetallePedidoCompra() {
		return this.cargarid_anioDetallePedidoCompra;
	}

	public void setCargarid_anioDetallePedidoCompra(Boolean cargarid_anioDetallePedidoCompra) {
		this.cargarid_anioDetallePedidoCompra= cargarid_anioDetallePedidoCompra;
	}

	public Border setResaltarid_mesDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePedidoCompra() {
		return this.resaltarid_mesDetallePedidoCompra;
	}

	public void setResaltarid_mesDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_mesDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePedidoCompra() {
		return this.mostrarid_mesDetallePedidoCompra;
	}

	public void setMostrarid_mesDetallePedidoCompra(Boolean mostrarid_mesDetallePedidoCompra) {
		this.mostrarid_mesDetallePedidoCompra= mostrarid_mesDetallePedidoCompra;
	}

	public Boolean getActivarid_mesDetallePedidoCompra() {
		return this.activarid_mesDetallePedidoCompra;
	}

	public void setActivarid_mesDetallePedidoCompra(Boolean activarid_mesDetallePedidoCompra) {
		this.activarid_mesDetallePedidoCompra= activarid_mesDetallePedidoCompra;
	}

	public Boolean getCargarid_mesDetallePedidoCompra() {
		return this.cargarid_mesDetallePedidoCompra;
	}

	public void setCargarid_mesDetallePedidoCompra(Boolean cargarid_mesDetallePedidoCompra) {
		this.cargarid_mesDetallePedidoCompra= cargarid_mesDetallePedidoCompra;
	}

	public Border setResaltarid_bodegaDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetallePedidoCompra() {
		return this.resaltarid_bodegaDetallePedidoCompra;
	}

	public void setResaltarid_bodegaDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_bodegaDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetallePedidoCompra() {
		return this.mostrarid_bodegaDetallePedidoCompra;
	}

	public void setMostrarid_bodegaDetallePedidoCompra(Boolean mostrarid_bodegaDetallePedidoCompra) {
		this.mostrarid_bodegaDetallePedidoCompra= mostrarid_bodegaDetallePedidoCompra;
	}

	public Boolean getActivarid_bodegaDetallePedidoCompra() {
		return this.activarid_bodegaDetallePedidoCompra;
	}

	public void setActivarid_bodegaDetallePedidoCompra(Boolean activarid_bodegaDetallePedidoCompra) {
		this.activarid_bodegaDetallePedidoCompra= activarid_bodegaDetallePedidoCompra;
	}

	public Boolean getCargarid_bodegaDetallePedidoCompra() {
		return this.cargarid_bodegaDetallePedidoCompra;
	}

	public void setCargarid_bodegaDetallePedidoCompra(Boolean cargarid_bodegaDetallePedidoCompra) {
		this.cargarid_bodegaDetallePedidoCompra= cargarid_bodegaDetallePedidoCompra;
	}

	public Border setResaltarid_productoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePedidoCompra() {
		return this.resaltarid_productoDetallePedidoCompra;
	}

	public void setResaltarid_productoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_productoDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePedidoCompra() {
		return this.mostrarid_productoDetallePedidoCompra;
	}

	public void setMostrarid_productoDetallePedidoCompra(Boolean mostrarid_productoDetallePedidoCompra) {
		this.mostrarid_productoDetallePedidoCompra= mostrarid_productoDetallePedidoCompra;
	}

	public Boolean getActivarid_productoDetallePedidoCompra() {
		return this.activarid_productoDetallePedidoCompra;
	}

	public void setActivarid_productoDetallePedidoCompra(Boolean activarid_productoDetallePedidoCompra) {
		this.activarid_productoDetallePedidoCompra= activarid_productoDetallePedidoCompra;
	}

	public Boolean getCargarid_productoDetallePedidoCompra() {
		return this.cargarid_productoDetallePedidoCompra;
	}

	public void setCargarid_productoDetallePedidoCompra(Boolean cargarid_productoDetallePedidoCompra) {
		this.cargarid_productoDetallePedidoCompra= cargarid_productoDetallePedidoCompra;
	}

	public Border setResaltarid_unidadDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePedidoCompra() {
		return this.resaltarid_unidadDetallePedidoCompra;
	}

	public void setResaltarid_unidadDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_unidadDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePedidoCompra() {
		return this.mostrarid_unidadDetallePedidoCompra;
	}

	public void setMostrarid_unidadDetallePedidoCompra(Boolean mostrarid_unidadDetallePedidoCompra) {
		this.mostrarid_unidadDetallePedidoCompra= mostrarid_unidadDetallePedidoCompra;
	}

	public Boolean getActivarid_unidadDetallePedidoCompra() {
		return this.activarid_unidadDetallePedidoCompra;
	}

	public void setActivarid_unidadDetallePedidoCompra(Boolean activarid_unidadDetallePedidoCompra) {
		this.activarid_unidadDetallePedidoCompra= activarid_unidadDetallePedidoCompra;
	}

	public Boolean getCargarid_unidadDetallePedidoCompra() {
		return this.cargarid_unidadDetallePedidoCompra;
	}

	public void setCargarid_unidadDetallePedidoCompra(Boolean cargarid_unidadDetallePedidoCompra) {
		this.cargarid_unidadDetallePedidoCompra= cargarid_unidadDetallePedidoCompra;
	}

	public Border setResaltarid_centro_costoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetallePedidoCompra() {
		return this.resaltarid_centro_costoDetallePedidoCompra;
	}

	public void setResaltarid_centro_costoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarid_centro_costoDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetallePedidoCompra() {
		return this.mostrarid_centro_costoDetallePedidoCompra;
	}

	public void setMostrarid_centro_costoDetallePedidoCompra(Boolean mostrarid_centro_costoDetallePedidoCompra) {
		this.mostrarid_centro_costoDetallePedidoCompra= mostrarid_centro_costoDetallePedidoCompra;
	}

	public Boolean getActivarid_centro_costoDetallePedidoCompra() {
		return this.activarid_centro_costoDetallePedidoCompra;
	}

	public void setActivarid_centro_costoDetallePedidoCompra(Boolean activarid_centro_costoDetallePedidoCompra) {
		this.activarid_centro_costoDetallePedidoCompra= activarid_centro_costoDetallePedidoCompra;
	}

	public Boolean getCargarid_centro_costoDetallePedidoCompra() {
		return this.cargarid_centro_costoDetallePedidoCompra;
	}

	public void setCargarid_centro_costoDetallePedidoCompra(Boolean cargarid_centro_costoDetallePedidoCompra) {
		this.cargarid_centro_costoDetallePedidoCompra= cargarid_centro_costoDetallePedidoCompra;
	}

	public Border setResaltarcantidad_pedidoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidoDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidoDetallePedidoCompra() {
		return this.resaltarcantidad_pedidoDetallePedidoCompra;
	}

	public void setResaltarcantidad_pedidoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarcantidad_pedidoDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidoDetallePedidoCompra() {
		return this.mostrarcantidad_pedidoDetallePedidoCompra;
	}

	public void setMostrarcantidad_pedidoDetallePedidoCompra(Boolean mostrarcantidad_pedidoDetallePedidoCompra) {
		this.mostrarcantidad_pedidoDetallePedidoCompra= mostrarcantidad_pedidoDetallePedidoCompra;
	}

	public Boolean getActivarcantidad_pedidoDetallePedidoCompra() {
		return this.activarcantidad_pedidoDetallePedidoCompra;
	}

	public void setActivarcantidad_pedidoDetallePedidoCompra(Boolean activarcantidad_pedidoDetallePedidoCompra) {
		this.activarcantidad_pedidoDetallePedidoCompra= activarcantidad_pedidoDetallePedidoCompra;
	}

	public Border setResaltarcosto_unitarioDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetallePedidoCompra() {
		return this.resaltarcosto_unitarioDetallePedidoCompra;
	}

	public void setResaltarcosto_unitarioDetallePedidoCompra(Border borderResaltar) {
		this.resaltarcosto_unitarioDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetallePedidoCompra() {
		return this.mostrarcosto_unitarioDetallePedidoCompra;
	}

	public void setMostrarcosto_unitarioDetallePedidoCompra(Boolean mostrarcosto_unitarioDetallePedidoCompra) {
		this.mostrarcosto_unitarioDetallePedidoCompra= mostrarcosto_unitarioDetallePedidoCompra;
	}

	public Boolean getActivarcosto_unitarioDetallePedidoCompra() {
		return this.activarcosto_unitarioDetallePedidoCompra;
	}

	public void setActivarcosto_unitarioDetallePedidoCompra(Boolean activarcosto_unitarioDetallePedidoCompra) {
		this.activarcosto_unitarioDetallePedidoCompra= activarcosto_unitarioDetallePedidoCompra;
	}

	public Border setResaltarcosto_totalDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcosto_totalDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetallePedidoCompra() {
		return this.resaltarcosto_totalDetallePedidoCompra;
	}

	public void setResaltarcosto_totalDetallePedidoCompra(Border borderResaltar) {
		this.resaltarcosto_totalDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetallePedidoCompra() {
		return this.mostrarcosto_totalDetallePedidoCompra;
	}

	public void setMostrarcosto_totalDetallePedidoCompra(Boolean mostrarcosto_totalDetallePedidoCompra) {
		this.mostrarcosto_totalDetallePedidoCompra= mostrarcosto_totalDetallePedidoCompra;
	}

	public Boolean getActivarcosto_totalDetallePedidoCompra() {
		return this.activarcosto_totalDetallePedidoCompra;
	}

	public void setActivarcosto_totalDetallePedidoCompra(Boolean activarcosto_totalDetallePedidoCompra) {
		this.activarcosto_totalDetallePedidoCompra= activarcosto_totalDetallePedidoCompra;
	}

	public Border setResaltardescripcionDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetallePedidoCompra() {
		return this.resaltardescripcionDetallePedidoCompra;
	}

	public void setResaltardescripcionDetallePedidoCompra(Border borderResaltar) {
		this.resaltardescripcionDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionDetallePedidoCompra() {
		return this.mostrardescripcionDetallePedidoCompra;
	}

	public void setMostrardescripcionDetallePedidoCompra(Boolean mostrardescripcionDetallePedidoCompra) {
		this.mostrardescripcionDetallePedidoCompra= mostrardescripcionDetallePedidoCompra;
	}

	public Boolean getActivardescripcionDetallePedidoCompra() {
		return this.activardescripcionDetallePedidoCompra;
	}

	public void setActivardescripcionDetallePedidoCompra(Boolean activardescripcionDetallePedidoCompra) {
		this.activardescripcionDetallePedidoCompra= activardescripcionDetallePedidoCompra;
	}

	public Border setResaltarcantidad_entregadaDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_entregadaDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_entregadaDetallePedidoCompra() {
		return this.resaltarcantidad_entregadaDetallePedidoCompra;
	}

	public void setResaltarcantidad_entregadaDetallePedidoCompra(Border borderResaltar) {
		this.resaltarcantidad_entregadaDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_entregadaDetallePedidoCompra() {
		return this.mostrarcantidad_entregadaDetallePedidoCompra;
	}

	public void setMostrarcantidad_entregadaDetallePedidoCompra(Boolean mostrarcantidad_entregadaDetallePedidoCompra) {
		this.mostrarcantidad_entregadaDetallePedidoCompra= mostrarcantidad_entregadaDetallePedidoCompra;
	}

	public Boolean getActivarcantidad_entregadaDetallePedidoCompra() {
		return this.activarcantidad_entregadaDetallePedidoCompra;
	}

	public void setActivarcantidad_entregadaDetallePedidoCompra(Boolean activarcantidad_entregadaDetallePedidoCompra) {
		this.activarcantidad_entregadaDetallePedidoCompra= activarcantidad_entregadaDetallePedidoCompra;
	}

	public Border setResaltarcantidad_pendienteDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendienteDetallePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendienteDetallePedidoCompra() {
		return this.resaltarcantidad_pendienteDetallePedidoCompra;
	}

	public void setResaltarcantidad_pendienteDetallePedidoCompra(Border borderResaltar) {
		this.resaltarcantidad_pendienteDetallePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendienteDetallePedidoCompra() {
		return this.mostrarcantidad_pendienteDetallePedidoCompra;
	}

	public void setMostrarcantidad_pendienteDetallePedidoCompra(Boolean mostrarcantidad_pendienteDetallePedidoCompra) {
		this.mostrarcantidad_pendienteDetallePedidoCompra= mostrarcantidad_pendienteDetallePedidoCompra;
	}

	public Boolean getActivarcantidad_pendienteDetallePedidoCompra() {
		return this.activarcantidad_pendienteDetallePedidoCompra;
	}

	public void setActivarcantidad_pendienteDetallePedidoCompra(Boolean activarcantidad_pendienteDetallePedidoCompra) {
		this.activarcantidad_pendienteDetallePedidoCompra= activarcantidad_pendienteDetallePedidoCompra;
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
		
		
		this.setMostraridDetallePedidoCompra(esInicial);
		this.setMostrarid_pedido_compraDetallePedidoCompra(esInicial);
		this.setMostrarid_empresaDetallePedidoCompra(esInicial);
		this.setMostrarid_sucursalDetallePedidoCompra(esInicial);
		this.setMostrarid_ejercicioDetallePedidoCompra(esInicial);
		this.setMostrarid_periodoDetallePedidoCompra(esInicial);
		this.setMostrarid_anioDetallePedidoCompra(esInicial);
		this.setMostrarid_mesDetallePedidoCompra(esInicial);
		this.setMostrarid_bodegaDetallePedidoCompra(esInicial);
		this.setMostrarid_productoDetallePedidoCompra(esInicial);
		this.setMostrarid_unidadDetallePedidoCompra(esInicial);
		this.setMostrarid_centro_costoDetallePedidoCompra(esInicial);
		this.setMostrarcantidad_pedidoDetallePedidoCompra(esInicial);
		this.setMostrarcosto_unitarioDetallePedidoCompra(esInicial);
		this.setMostrarcosto_totalDetallePedidoCompra(esInicial);
		this.setMostrardescripcionDetallePedidoCompra(esInicial);
		this.setMostrarcantidad_entregadaDetallePedidoCompra(esInicial);
		this.setMostrarcantidad_pendienteDetallePedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.ID)) {
				this.setMostraridDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setMostrarid_pedido_compraDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO)) {
				this.setMostrarcantidad_pedidoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setMostrarcantidad_entregadaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendienteDetallePedidoCompra(esAsigna);
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
		
		
		this.setActivaridDetallePedidoCompra(esInicial);
		this.setActivarid_pedido_compraDetallePedidoCompra(esInicial);
		this.setActivarid_empresaDetallePedidoCompra(esInicial);
		this.setActivarid_sucursalDetallePedidoCompra(esInicial);
		this.setActivarid_ejercicioDetallePedidoCompra(esInicial);
		this.setActivarid_periodoDetallePedidoCompra(esInicial);
		this.setActivarid_anioDetallePedidoCompra(esInicial);
		this.setActivarid_mesDetallePedidoCompra(esInicial);
		this.setActivarid_bodegaDetallePedidoCompra(esInicial);
		this.setActivarid_productoDetallePedidoCompra(esInicial);
		this.setActivarid_unidadDetallePedidoCompra(esInicial);
		this.setActivarid_centro_costoDetallePedidoCompra(esInicial);
		this.setActivarcantidad_pedidoDetallePedidoCompra(esInicial);
		this.setActivarcosto_unitarioDetallePedidoCompra(esInicial);
		this.setActivarcosto_totalDetallePedidoCompra(esInicial);
		this.setActivardescripcionDetallePedidoCompra(esInicial);
		this.setActivarcantidad_entregadaDetallePedidoCompra(esInicial);
		this.setActivarcantidad_pendienteDetallePedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.ID)) {
				this.setActivaridDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setActivarid_pedido_compraDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO)) {
				this.setActivarcantidad_pedidoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setActivarcantidad_entregadaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendienteDetallePedidoCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePedidoCompra(esInicial);
		this.setResaltarid_pedido_compraDetallePedidoCompra(esInicial);
		this.setResaltarid_empresaDetallePedidoCompra(esInicial);
		this.setResaltarid_sucursalDetallePedidoCompra(esInicial);
		this.setResaltarid_ejercicioDetallePedidoCompra(esInicial);
		this.setResaltarid_periodoDetallePedidoCompra(esInicial);
		this.setResaltarid_anioDetallePedidoCompra(esInicial);
		this.setResaltarid_mesDetallePedidoCompra(esInicial);
		this.setResaltarid_bodegaDetallePedidoCompra(esInicial);
		this.setResaltarid_productoDetallePedidoCompra(esInicial);
		this.setResaltarid_unidadDetallePedidoCompra(esInicial);
		this.setResaltarid_centro_costoDetallePedidoCompra(esInicial);
		this.setResaltarcantidad_pedidoDetallePedidoCompra(esInicial);
		this.setResaltarcosto_unitarioDetallePedidoCompra(esInicial);
		this.setResaltarcosto_totalDetallePedidoCompra(esInicial);
		this.setResaltardescripcionDetallePedidoCompra(esInicial);
		this.setResaltarcantidad_entregadaDetallePedidoCompra(esInicial);
		this.setResaltarcantidad_pendienteDetallePedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.ID)) {
				this.setResaltaridDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA)) {
				this.setResaltarid_pedido_compraDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO)) {
				this.setResaltarcantidad_pedidoDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setResaltarcantidad_entregadaDetallePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendienteDetallePedidoCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdBodegaDetallePedidoCompra() {
		return this.mostrarFK_IdBodegaDetallePedidoCompra;
	}

	public void setMostrarFK_IdBodegaDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdCentroCostoDetallePedidoCompra() {
		return this.mostrarFK_IdCentroCostoDetallePedidoCompra;
	}

	public void setMostrarFK_IdCentroCostoDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdEjercicioDetallePedidoCompra() {
		return this.mostrarFK_IdEjercicioDetallePedidoCompra;
	}

	public void setMostrarFK_IdEjercicioDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdEmpresaDetallePedidoCompra() {
		return this.mostrarFK_IdEmpresaDetallePedidoCompra;
	}

	public void setMostrarFK_IdEmpresaDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoCompraDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdPedidoCompraDetallePedidoCompra() {
		return this.mostrarFK_IdPedidoCompraDetallePedidoCompra;
	}

	public void setMostrarFK_IdPedidoCompraDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoCompraDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdPeriodoDetallePedidoCompra() {
		return this.mostrarFK_IdPeriodoDetallePedidoCompra;
	}

	public void setMostrarFK_IdPeriodoDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdProductoDetallePedidoCompra() {
		return this.mostrarFK_IdProductoDetallePedidoCompra;
	}

	public void setMostrarFK_IdProductoDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdSucursalDetallePedidoCompra() {
		return this.mostrarFK_IdSucursalDetallePedidoCompra;
	}

	public void setMostrarFK_IdSucursalDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePedidoCompra=true;

	public Boolean getMostrarFK_IdUnidadDetallePedidoCompra() {
		return this.mostrarFK_IdUnidadDetallePedidoCompra;
	}

	public void setMostrarFK_IdUnidadDetallePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePedidoCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetallePedidoCompra=true;

	public Boolean getActivarFK_IdBodegaDetallePedidoCompra() {
		return this.activarFK_IdBodegaDetallePedidoCompra;
	}

	public void setActivarFK_IdBodegaDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetallePedidoCompra=true;

	public Boolean getActivarFK_IdCentroCostoDetallePedidoCompra() {
		return this.activarFK_IdCentroCostoDetallePedidoCompra;
	}

	public void setActivarFK_IdCentroCostoDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePedidoCompra=true;

	public Boolean getActivarFK_IdEjercicioDetallePedidoCompra() {
		return this.activarFK_IdEjercicioDetallePedidoCompra;
	}

	public void setActivarFK_IdEjercicioDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePedidoCompra=true;

	public Boolean getActivarFK_IdEmpresaDetallePedidoCompra() {
		return this.activarFK_IdEmpresaDetallePedidoCompra;
	}

	public void setActivarFK_IdEmpresaDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoCompraDetallePedidoCompra=true;

	public Boolean getActivarFK_IdPedidoCompraDetallePedidoCompra() {
		return this.activarFK_IdPedidoCompraDetallePedidoCompra;
	}

	public void setActivarFK_IdPedidoCompraDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoCompraDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePedidoCompra=true;

	public Boolean getActivarFK_IdPeriodoDetallePedidoCompra() {
		return this.activarFK_IdPeriodoDetallePedidoCompra;
	}

	public void setActivarFK_IdPeriodoDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePedidoCompra=true;

	public Boolean getActivarFK_IdProductoDetallePedidoCompra() {
		return this.activarFK_IdProductoDetallePedidoCompra;
	}

	public void setActivarFK_IdProductoDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePedidoCompra=true;

	public Boolean getActivarFK_IdSucursalDetallePedidoCompra() {
		return this.activarFK_IdSucursalDetallePedidoCompra;
	}

	public void setActivarFK_IdSucursalDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePedidoCompra=true;

	public Boolean getActivarFK_IdUnidadDetallePedidoCompra() {
		return this.activarFK_IdUnidadDetallePedidoCompra;
	}

	public void setActivarFK_IdUnidadDetallePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePedidoCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetallePedidoCompra=null;

	public Border getResaltarFK_IdBodegaDetallePedidoCompra() {
		return this.resaltarFK_IdBodegaDetallePedidoCompra;
	}

	public void setResaltarFK_IdBodegaDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetallePedidoCompra=null;

	public Border getResaltarFK_IdCentroCostoDetallePedidoCompra() {
		return this.resaltarFK_IdCentroCostoDetallePedidoCompra;
	}

	public void setResaltarFK_IdCentroCostoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePedidoCompra=null;

	public Border getResaltarFK_IdEjercicioDetallePedidoCompra() {
		return this.resaltarFK_IdEjercicioDetallePedidoCompra;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePedidoCompra=null;

	public Border getResaltarFK_IdEmpresaDetallePedidoCompra() {
		return this.resaltarFK_IdEmpresaDetallePedidoCompra;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdPedidoCompraDetallePedidoCompra=null;

	public Border getResaltarFK_IdPedidoCompraDetallePedidoCompra() {
		return this.resaltarFK_IdPedidoCompraDetallePedidoCompra;
	}

	public void setResaltarFK_IdPedidoCompraDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdPedidoCompraDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdPedidoCompraDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoCompraDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePedidoCompra=null;

	public Border getResaltarFK_IdPeriodoDetallePedidoCompra() {
		return this.resaltarFK_IdPeriodoDetallePedidoCompra;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePedidoCompra=null;

	public Border getResaltarFK_IdProductoDetallePedidoCompra() {
		return this.resaltarFK_IdProductoDetallePedidoCompra;
	}

	public void setResaltarFK_IdProductoDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePedidoCompra=null;

	public Border getResaltarFK_IdSucursalDetallePedidoCompra() {
		return this.resaltarFK_IdSucursalDetallePedidoCompra;
	}

	public void setResaltarFK_IdSucursalDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePedidoCompra=null;

	public Border getResaltarFK_IdUnidadDetallePedidoCompra() {
		return this.resaltarFK_IdUnidadDetallePedidoCompra;
	}

	public void setResaltarFK_IdUnidadDetallePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraBeanSwingJInternalFrame detallepedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePedidoCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}