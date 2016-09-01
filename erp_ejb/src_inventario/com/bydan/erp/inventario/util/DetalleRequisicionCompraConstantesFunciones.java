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


import com.bydan.erp.inventario.util.DetalleRequisicionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleRequisicionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleRequisicionCompraParameterGeneral;

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
final public class DetalleRequisicionCompraConstantesFunciones extends DetalleRequisicionCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleRequisicionCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleRequisicionCompra"+DetalleRequisicionCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleRequisicionCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleRequisicionCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleRequisicionCompraConstantesFunciones.SCHEMA+"_"+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleRequisicionCompraConstantesFunciones.SCHEMA+"_"+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleRequisicionCompraConstantesFunciones.SCHEMA+"_"+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleRequisicionCompraConstantesFunciones.SCHEMA+"_"+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleRequisicionCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleRequisicionCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleRequisicionCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleRequisicionCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Requisicion Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Requisicion Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Requisicion Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleRequisicionCompra";
	public static final String OBJECTNAME="detallerequisicioncompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_requisicion_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallerequisicioncompra from "+DetalleRequisicionCompraConstantesFunciones.SPERSISTENCENAME+" detallerequisicioncompra";
	public static String QUERYSELECTNATIVE="select "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_requisicion_compra,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_requisicion,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_entregada,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_pendiente from "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleRequisicionCompraConstantesFuncionesAdditional detallerequisicioncompraConstantesFuncionesAdditional=null;
	
	public DetalleRequisicionCompraConstantesFuncionesAdditional getDetalleRequisicionCompraConstantesFuncionesAdditional() {
		return this.detallerequisicioncompraConstantesFuncionesAdditional;
	}
	
	public void setDetalleRequisicionCompraConstantesFuncionesAdditional(DetalleRequisicionCompraConstantesFuncionesAdditional detallerequisicioncompraConstantesFuncionesAdditional) {
		try {
			this.detallerequisicioncompraConstantesFuncionesAdditional=detallerequisicioncompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDREQUISICIONCOMPRA= "id_requisicion_compra";
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
    public static final String CANTIDADREQUISICION= "cantidad_requisicion";
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
    	public static final String LABEL_IDREQUISICIONCOMPRA= "Requisicion Compra";
		public static final String LABEL_IDREQUISICIONCOMPRA_LOWER= "Requisicion Compra";
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
    	public static final String LABEL_CANTIDADREQUISICION= "Cantidad Requisicion";
		public static final String LABEL_CANTIDADREQUISICION_LOWER= "Cantidad Requisicion";
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
		
		
	
	public static String getDetalleRequisicionCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDREQUISICIONCOMPRA;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDANIO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDMES)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADREQUISICION;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADENTREGADA;}
		if(sNombreColumna.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleRequisicionCompraDescripcion(DetalleRequisicionCompra detallerequisicioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallerequisicioncompra !=null/* && detallerequisicioncompra.getId()!=0*/) {
			if(detallerequisicioncompra.getId()!=null) {
				sDescripcion=detallerequisicioncompra.getId().toString();
			}//detallerequisicioncompradetallerequisicioncompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleRequisicionCompraDescripcionDetallado(DetalleRequisicionCompra detallerequisicioncompra) {
		String sDescripcion="";
			
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.ID+"=";
		sDescripcion+=detallerequisicioncompra.getId().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallerequisicioncompra.getVersionRow().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA+"=";
		sDescripcion+=detallerequisicioncompra.getid_requisicion_compra().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallerequisicioncompra.getid_empresa().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallerequisicioncompra.getid_sucursal().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallerequisicioncompra.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallerequisicioncompra.getid_periodo().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallerequisicioncompra.getid_anio().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=detallerequisicioncompra.getid_mes().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallerequisicioncompra.getid_bodega().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallerequisicioncompra.getid_producto().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallerequisicioncompra.getid_unidad().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallerequisicioncompra.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION+"=";
		sDescripcion+=detallerequisicioncompra.getcantidad_requisicion().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detallerequisicioncompra.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detallerequisicioncompra.getcosto_total().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallerequisicioncompra.getdescripcion()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA+"=";
		sDescripcion+=detallerequisicioncompra.getcantidad_entregada().toString()+",";
		sDescripcion+=DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=detallerequisicioncompra.getcantidad_pendiente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleRequisicionCompraDescripcion(DetalleRequisicionCompra detallerequisicioncompra,String sValor) throws Exception {			
		if(detallerequisicioncompra !=null) {
			//detallerequisicioncompradetallerequisicioncompra.getId().toString();
		}		
	}
	
		

	public static String getRequisicionCompraDescripcion(RequisicionCompra requisicioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(requisicioncompra!=null/*&&requisicioncompra.getId()>0*/) {
			sDescripcion=RequisicionCompraConstantesFunciones.getRequisicionCompraDescripcion(requisicioncompra);
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
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdRequisicionCompra")) {
			sNombreIndice="Tipo=  Por Requisicion Compra";
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

	public static String getDetalleIndiceFK_IdRequisicionCompra(Long id_requisicion_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_requisicion_compra!=null) {sDetalleIndice+=" Codigo Unico De Requisicion Compra="+id_requisicion_compra.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallerequisicioncompra.setdescripcion(detallerequisicioncompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleRequisicionCompras(List<DetalleRequisicionCompra> detallerequisicioncompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleRequisicionCompra detallerequisicioncompra: detallerequisicioncompras) {
			detallerequisicioncompra.setdescripcion(detallerequisicioncompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallerequisicioncompra.getConCambioAuxiliar()) {
			detallerequisicioncompra.setIsDeleted(detallerequisicioncompra.getIsDeletedAuxiliar());	
			detallerequisicioncompra.setIsNew(detallerequisicioncompra.getIsNewAuxiliar());	
			detallerequisicioncompra.setIsChanged(detallerequisicioncompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallerequisicioncompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallerequisicioncompra.setIsDeletedAuxiliar(false);	
			detallerequisicioncompra.setIsNewAuxiliar(false);	
			detallerequisicioncompra.setIsChangedAuxiliar(false);
			
			detallerequisicioncompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRequisicionCompras(List<DetalleRequisicionCompra> detallerequisicioncompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleRequisicionCompra detallerequisicioncompra : detallerequisicioncompras) {
			if(conAsignarBase && detallerequisicioncompra.getConCambioAuxiliar()) {
				detallerequisicioncompra.setIsDeleted(detallerequisicioncompra.getIsDeletedAuxiliar());	
				detallerequisicioncompra.setIsNew(detallerequisicioncompra.getIsNewAuxiliar());	
				detallerequisicioncompra.setIsChanged(detallerequisicioncompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallerequisicioncompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallerequisicioncompra.setIsDeletedAuxiliar(false);	
				detallerequisicioncompra.setIsNewAuxiliar(false);	
				detallerequisicioncompra.setIsChangedAuxiliar(false);
				
				detallerequisicioncompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra,Boolean conEnteros) throws Exception  {
		detallerequisicioncompra.setcosto_unitario(0.0);
		detallerequisicioncompra.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallerequisicioncompra.setcantidad_requisicion(0);
			detallerequisicioncompra.setcantidad_entregada(0);
			detallerequisicioncompra.setcantidad_pendiente(0);
		}
	}		
	
	public static void InicializarValoresDetalleRequisicionCompras(List<DetalleRequisicionCompra> detallerequisicioncompras,Boolean conEnteros) throws Exception  {
		
		for(DetalleRequisicionCompra detallerequisicioncompra: detallerequisicioncompras) {
			detallerequisicioncompra.setcosto_unitario(0.0);
			detallerequisicioncompra.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallerequisicioncompra.setcantidad_requisicion(0);
				detallerequisicioncompra.setcantidad_entregada(0);
				detallerequisicioncompra.setcantidad_pendiente(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleRequisicionCompra(List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompra detallerequisicioncompraAux) throws Exception  {
		DetalleRequisicionCompraConstantesFunciones.InicializarValoresDetalleRequisicionCompra(detallerequisicioncompraAux,true);
		
		for(DetalleRequisicionCompra detallerequisicioncompra: detallerequisicioncompras) {
			if(detallerequisicioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallerequisicioncompraAux.setcantidad_requisicion(detallerequisicioncompraAux.getcantidad_requisicion()+detallerequisicioncompra.getcantidad_requisicion());			
			detallerequisicioncompraAux.setcosto_unitario(detallerequisicioncompraAux.getcosto_unitario()+detallerequisicioncompra.getcosto_unitario());			
			detallerequisicioncompraAux.setcosto_total(detallerequisicioncompraAux.getcosto_total()+detallerequisicioncompra.getcosto_total());			
			detallerequisicioncompraAux.setcantidad_entregada(detallerequisicioncompraAux.getcantidad_entregada()+detallerequisicioncompra.getcantidad_entregada());			
			detallerequisicioncompraAux.setcantidad_pendiente(detallerequisicioncompraAux.getcantidad_pendiente()+detallerequisicioncompra.getcantidad_pendiente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleRequisicionCompraConstantesFunciones.getArrayColumnasGlobalesDetalleRequisicionCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionCompraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompra detallerequisicioncompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleRequisicionCompra detallerequisicioncompraAux: detallerequisicioncompras) {
			if(detallerequisicioncompraAux!=null && detallerequisicioncompra!=null) {
				if((detallerequisicioncompraAux.getId()==null && detallerequisicioncompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallerequisicioncompraAux.getId()!=null && detallerequisicioncompra.getId()!=null){
					if(detallerequisicioncompraAux.getId().equals(detallerequisicioncompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleRequisicionCompra(List<DetalleRequisicionCompra> detallerequisicioncompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(DetalleRequisicionCompra detallerequisicioncompra: detallerequisicioncompras) {			
			if(detallerequisicioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=detallerequisicioncompra.getcosto_unitario();
			costo_totalTotal+=detallerequisicioncompra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleRequisicionCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_ID, DetalleRequisicionCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_VERSIONROW, DetalleRequisicionCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDREQUISICIONCOMPRA, DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDEMPRESA, DetalleRequisicionCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL, DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO, DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDPERIODO, DetalleRequisicionCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDANIO, DetalleRequisicionCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDMES, DetalleRequisicionCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDBODEGA, DetalleRequisicionCompraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDPRODUCTO, DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDUNIDAD, DetalleRequisicionCompraConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADREQUISICION, DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO, DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL, DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_DESCRIPCION, DetalleRequisicionCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADENTREGADA, DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE, DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleRequisicionCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicionCompra() throws Exception  {
		return DetalleRequisicionCompraConstantesFunciones.getTiposSeleccionarDetalleRequisicionCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicionCompra(Boolean conFk) throws Exception  {
		return DetalleRequisicionCompraConstantesFunciones.getTiposSeleccionarDetalleRequisicionCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicionCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDREQUISICIONCOMPRA);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDREQUISICIONCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADREQUISICION);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleRequisicionCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompraAux) throws Exception {
		
			detallerequisicioncompraAux.setrequisicioncompra_descripcion(RequisicionCompraConstantesFunciones.getRequisicionCompraDescripcion(detallerequisicioncompraAux.getRequisicionCompra()));
			detallerequisicioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerequisicioncompraAux.getEmpresa()));
			detallerequisicioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerequisicioncompraAux.getSucursal()));
			detallerequisicioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerequisicioncompraAux.getEjercicio()));
			detallerequisicioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallerequisicioncompraAux.getPeriodo()));
			detallerequisicioncompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallerequisicioncompraAux.getAnio()));
			detallerequisicioncompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallerequisicioncompraAux.getMes()));
			detallerequisicioncompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallerequisicioncompraAux.getBodega()));
			detallerequisicioncompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallerequisicioncompraAux.getProducto()));
			detallerequisicioncompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallerequisicioncompraAux.getUnidad()));
			detallerequisicioncompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallerequisicioncompraAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRequisicionCompra(List<DetalleRequisicionCompra> detallerequisicioncomprasTemp) throws Exception {
		for(DetalleRequisicionCompra detallerequisicioncompraAux:detallerequisicioncomprasTemp) {
			
			detallerequisicioncompraAux.setrequisicioncompra_descripcion(RequisicionCompraConstantesFunciones.getRequisicionCompraDescripcion(detallerequisicioncompraAux.getRequisicionCompra()));
			detallerequisicioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerequisicioncompraAux.getEmpresa()));
			detallerequisicioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerequisicioncompraAux.getSucursal()));
			detallerequisicioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerequisicioncompraAux.getEjercicio()));
			detallerequisicioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallerequisicioncompraAux.getPeriodo()));
			detallerequisicioncompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallerequisicioncompraAux.getAnio()));
			detallerequisicioncompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallerequisicioncompraAux.getMes()));
			detallerequisicioncompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallerequisicioncompraAux.getBodega()));
			detallerequisicioncompraAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallerequisicioncompraAux.getProducto()));
			detallerequisicioncompraAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallerequisicioncompraAux.getUnidad()));
			detallerequisicioncompraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallerequisicioncompraAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RequisicionCompra.class));
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
					if(clas.clas.equals(RequisicionCompra.class)) {
						classes.add(new Classe(RequisicionCompra.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
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

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRequisicionCompraConstantesFunciones.getClassesRelationshipsOfDetalleRequisicionCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRequisicionCompraConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleRequisicionCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleRequisicionCompra detallerequisicioncompra,List<DetalleRequisicionCompra> detallerequisicioncompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleRequisicionCompra detallerequisicioncompraEncontrado=null;
			
			for(DetalleRequisicionCompra detallerequisicioncompraLocal:detallerequisicioncompras) {
				if(detallerequisicioncompraLocal.getId().equals(detallerequisicioncompra.getId())) {
					detallerequisicioncompraEncontrado=detallerequisicioncompraLocal;
					
					detallerequisicioncompraLocal.setIsChanged(detallerequisicioncompra.getIsChanged());
					detallerequisicioncompraLocal.setIsNew(detallerequisicioncompra.getIsNew());
					detallerequisicioncompraLocal.setIsDeleted(detallerequisicioncompra.getIsDeleted());
					
					detallerequisicioncompraLocal.setGeneralEntityOriginal(detallerequisicioncompra.getGeneralEntityOriginal());
					
					detallerequisicioncompraLocal.setId(detallerequisicioncompra.getId());	
					detallerequisicioncompraLocal.setVersionRow(detallerequisicioncompra.getVersionRow());	
					detallerequisicioncompraLocal.setid_requisicion_compra(detallerequisicioncompra.getid_requisicion_compra());	
					detallerequisicioncompraLocal.setid_empresa(detallerequisicioncompra.getid_empresa());	
					detallerequisicioncompraLocal.setid_sucursal(detallerequisicioncompra.getid_sucursal());	
					detallerequisicioncompraLocal.setid_ejercicio(detallerequisicioncompra.getid_ejercicio());	
					detallerequisicioncompraLocal.setid_periodo(detallerequisicioncompra.getid_periodo());	
					detallerequisicioncompraLocal.setid_anio(detallerequisicioncompra.getid_anio());	
					detallerequisicioncompraLocal.setid_mes(detallerequisicioncompra.getid_mes());	
					detallerequisicioncompraLocal.setid_bodega(detallerequisicioncompra.getid_bodega());	
					detallerequisicioncompraLocal.setid_producto(detallerequisicioncompra.getid_producto());	
					detallerequisicioncompraLocal.setid_unidad(detallerequisicioncompra.getid_unidad());	
					detallerequisicioncompraLocal.setid_centro_costo(detallerequisicioncompra.getid_centro_costo());	
					detallerequisicioncompraLocal.setcantidad_requisicion(detallerequisicioncompra.getcantidad_requisicion());	
					detallerequisicioncompraLocal.setcosto_unitario(detallerequisicioncompra.getcosto_unitario());	
					detallerequisicioncompraLocal.setcosto_total(detallerequisicioncompra.getcosto_total());	
					detallerequisicioncompraLocal.setdescripcion(detallerequisicioncompra.getdescripcion());	
					detallerequisicioncompraLocal.setcantidad_entregada(detallerequisicioncompra.getcantidad_entregada());	
					detallerequisicioncompraLocal.setcantidad_pendiente(detallerequisicioncompra.getcantidad_pendiente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallerequisicioncompra.getIsDeleted()) {
				if(!existe) {
					detallerequisicioncompras.add(detallerequisicioncompra);
				}
			} else {
				if(detallerequisicioncompraEncontrado!=null && permiteQuitar)  {
					detallerequisicioncompras.remove(detallerequisicioncompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleRequisicionCompra detallerequisicioncompra,List<DetalleRequisicionCompra> detallerequisicioncompras) throws Exception {
		try	{			
			for(DetalleRequisicionCompra detallerequisicioncompraLocal:detallerequisicioncompras) {
				if(detallerequisicioncompraLocal.getId().equals(detallerequisicioncompra.getId())) {
					detallerequisicioncompraLocal.setIsSelected(detallerequisicioncompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleRequisicionCompra(List<DetalleRequisicionCompra> detallerequisicioncomprasAux) throws Exception {
		//this.detallerequisicioncomprasAux=detallerequisicioncomprasAux;
		
		for(DetalleRequisicionCompra detallerequisicioncompraAux:detallerequisicioncomprasAux) {
			if(detallerequisicioncompraAux.getIsChanged()) {
				detallerequisicioncompraAux.setIsChanged(false);
			}		
			
			if(detallerequisicioncompraAux.getIsNew()) {
				detallerequisicioncompraAux.setIsNew(false);
			}	
			
			if(detallerequisicioncompraAux.getIsDeleted()) {
				detallerequisicioncompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompraAux) throws Exception {
		//this.detallerequisicioncompraAux=detallerequisicioncompraAux;
		
			if(detallerequisicioncompraAux.getIsChanged()) {
				detallerequisicioncompraAux.setIsChanged(false);
			}		
			
			if(detallerequisicioncompraAux.getIsNew()) {
				detallerequisicioncompraAux.setIsNew(false);
			}	
			
			if(detallerequisicioncompraAux.getIsDeleted()) {
				detallerequisicioncompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleRequisicionCompra detallerequisicioncompraAsignar,DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		detallerequisicioncompraAsignar.setId(detallerequisicioncompra.getId());	
		detallerequisicioncompraAsignar.setVersionRow(detallerequisicioncompra.getVersionRow());	
		detallerequisicioncompraAsignar.setid_requisicion_compra(detallerequisicioncompra.getid_requisicion_compra());
		detallerequisicioncompraAsignar.setrequisicioncompra_descripcion(detallerequisicioncompra.getrequisicioncompra_descripcion());	
		detallerequisicioncompraAsignar.setid_empresa(detallerequisicioncompra.getid_empresa());
		detallerequisicioncompraAsignar.setempresa_descripcion(detallerequisicioncompra.getempresa_descripcion());	
		detallerequisicioncompraAsignar.setid_sucursal(detallerequisicioncompra.getid_sucursal());
		detallerequisicioncompraAsignar.setsucursal_descripcion(detallerequisicioncompra.getsucursal_descripcion());	
		detallerequisicioncompraAsignar.setid_ejercicio(detallerequisicioncompra.getid_ejercicio());
		detallerequisicioncompraAsignar.setejercicio_descripcion(detallerequisicioncompra.getejercicio_descripcion());	
		detallerequisicioncompraAsignar.setid_periodo(detallerequisicioncompra.getid_periodo());
		detallerequisicioncompraAsignar.setperiodo_descripcion(detallerequisicioncompra.getperiodo_descripcion());	
		detallerequisicioncompraAsignar.setid_anio(detallerequisicioncompra.getid_anio());
		detallerequisicioncompraAsignar.setanio_descripcion(detallerequisicioncompra.getanio_descripcion());	
		detallerequisicioncompraAsignar.setid_mes(detallerequisicioncompra.getid_mes());
		detallerequisicioncompraAsignar.setmes_descripcion(detallerequisicioncompra.getmes_descripcion());	
		detallerequisicioncompraAsignar.setid_bodega(detallerequisicioncompra.getid_bodega());
		detallerequisicioncompraAsignar.setbodega_descripcion(detallerequisicioncompra.getbodega_descripcion());	
		detallerequisicioncompraAsignar.setid_producto(detallerequisicioncompra.getid_producto());
		detallerequisicioncompraAsignar.setproducto_descripcion(detallerequisicioncompra.getproducto_descripcion());	
		detallerequisicioncompraAsignar.setid_unidad(detallerequisicioncompra.getid_unidad());
		detallerequisicioncompraAsignar.setunidad_descripcion(detallerequisicioncompra.getunidad_descripcion());	
		detallerequisicioncompraAsignar.setid_centro_costo(detallerequisicioncompra.getid_centro_costo());
		detallerequisicioncompraAsignar.setcentrocosto_descripcion(detallerequisicioncompra.getcentrocosto_descripcion());	
		detallerequisicioncompraAsignar.setcantidad_requisicion(detallerequisicioncompra.getcantidad_requisicion());	
		detallerequisicioncompraAsignar.setcosto_unitario(detallerequisicioncompra.getcosto_unitario());	
		detallerequisicioncompraAsignar.setcosto_total(detallerequisicioncompra.getcosto_total());	
		detallerequisicioncompraAsignar.setdescripcion(detallerequisicioncompra.getdescripcion());	
		detallerequisicioncompraAsignar.setcantidad_entregada(detallerequisicioncompra.getcantidad_entregada());	
		detallerequisicioncompraAsignar.setcantidad_pendiente(detallerequisicioncompra.getcantidad_pendiente());	
	}
	
	public static void inicializarDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		try {
				detallerequisicioncompra.setId(0L);	
					
				detallerequisicioncompra.setid_requisicion_compra(-1L);	
				detallerequisicioncompra.setid_empresa(-1L);	
				detallerequisicioncompra.setid_sucursal(-1L);	
				detallerequisicioncompra.setid_ejercicio(-1L);	
				detallerequisicioncompra.setid_periodo(-1L);	
				detallerequisicioncompra.setid_anio(null);	
				detallerequisicioncompra.setid_mes(null);	
				detallerequisicioncompra.setid_bodega(-1L);	
				detallerequisicioncompra.setid_producto(-1L);	
				detallerequisicioncompra.setid_unidad(-1L);	
				detallerequisicioncompra.setid_centro_costo(null);	
				detallerequisicioncompra.setcantidad_requisicion(0);	
				detallerequisicioncompra.setcosto_unitario(0.0);	
				detallerequisicioncompra.setcosto_total(0.0);	
				detallerequisicioncompra.setdescripcion("");	
				detallerequisicioncompra.setcantidad_entregada(0);	
				detallerequisicioncompra.setcantidad_pendiente(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleRequisicionCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDREQUISICIONCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADENTREGADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionCompraConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleRequisicionCompra(String sTipo,Row row,Workbook workbook,DetalleRequisicionCompra detallerequisicioncompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getrequisicioncompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcantidad_requisicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcantidad_entregada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicioncompra.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleRequisicionCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleRequisicionCompra() {
		return this.sFinalQueryDetalleRequisicionCompra;
	}
	
	public void setsFinalQueryDetalleRequisicionCompra(String sFinalQueryDetalleRequisicionCompra) {
		this.sFinalQueryDetalleRequisicionCompra= sFinalQueryDetalleRequisicionCompra;
	}
	
	public Border resaltarSeleccionarDetalleRequisicionCompra=null;
	
	public Border setResaltarSeleccionarDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleRequisicionCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleRequisicionCompra() {
		return this.resaltarSeleccionarDetalleRequisicionCompra;
	}
	
	public void setResaltarSeleccionarDetalleRequisicionCompra(Border borderResaltarSeleccionarDetalleRequisicionCompra) {
		this.resaltarSeleccionarDetalleRequisicionCompra= borderResaltarSeleccionarDetalleRequisicionCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleRequisicionCompra=null;
	public Boolean mostraridDetalleRequisicionCompra=true;
	public Boolean activaridDetalleRequisicionCompra=true;

	public Border resaltarid_requisicion_compraDetalleRequisicionCompra=null;
	public Boolean mostrarid_requisicion_compraDetalleRequisicionCompra=true;
	public Boolean activarid_requisicion_compraDetalleRequisicionCompra=true;
	public Boolean cargarid_requisicion_compraDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_requisicion_compraDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleRequisicionCompra=null;
	public Boolean mostrarid_empresaDetalleRequisicionCompra=true;
	public Boolean activarid_empresaDetalleRequisicionCompra=true;
	public Boolean cargarid_empresaDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleRequisicionCompra=null;
	public Boolean mostrarid_sucursalDetalleRequisicionCompra=true;
	public Boolean activarid_sucursalDetalleRequisicionCompra=true;
	public Boolean cargarid_sucursalDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleRequisicionCompra=null;
	public Boolean mostrarid_ejercicioDetalleRequisicionCompra=true;
	public Boolean activarid_ejercicioDetalleRequisicionCompra=true;
	public Boolean cargarid_ejercicioDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleRequisicionCompra=null;
	public Boolean mostrarid_periodoDetalleRequisicionCompra=true;
	public Boolean activarid_periodoDetalleRequisicionCompra=true;
	public Boolean cargarid_periodoDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleRequisicionCompra=null;
	public Boolean mostrarid_anioDetalleRequisicionCompra=true;
	public Boolean activarid_anioDetalleRequisicionCompra=false;
	public Boolean cargarid_anioDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleRequisicionCompra=null;
	public Boolean mostrarid_mesDetalleRequisicionCompra=true;
	public Boolean activarid_mesDetalleRequisicionCompra=false;
	public Boolean cargarid_mesDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleRequisicionCompra=null;
	public Boolean mostrarid_bodegaDetalleRequisicionCompra=true;
	public Boolean activarid_bodegaDetalleRequisicionCompra=true;
	public Boolean cargarid_bodegaDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleRequisicionCompra=null;
	public Boolean mostrarid_productoDetalleRequisicionCompra=true;
	public Boolean activarid_productoDetalleRequisicionCompra=true;
	public Boolean cargarid_productoDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleRequisicionCompra=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleRequisicionCompra=null;
	public Boolean mostrarid_unidadDetalleRequisicionCompra=true;
	public Boolean activarid_unidadDetalleRequisicionCompra=true;
	public Boolean cargarid_unidadDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleRequisicionCompra=true;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleRequisicionCompra=null;
	public Boolean mostrarid_centro_costoDetalleRequisicionCompra=true;
	public Boolean activarid_centro_costoDetalleRequisicionCompra=true;
	public Boolean cargarid_centro_costoDetalleRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarcantidad_requisicionDetalleRequisicionCompra=null;
	public Boolean mostrarcantidad_requisicionDetalleRequisicionCompra=true;
	public Boolean activarcantidad_requisicionDetalleRequisicionCompra=true;

	public Border resaltarcosto_unitarioDetalleRequisicionCompra=null;
	public Boolean mostrarcosto_unitarioDetalleRequisicionCompra=true;
	public Boolean activarcosto_unitarioDetalleRequisicionCompra=false;

	public Border resaltarcosto_totalDetalleRequisicionCompra=null;
	public Boolean mostrarcosto_totalDetalleRequisicionCompra=true;
	public Boolean activarcosto_totalDetalleRequisicionCompra=false;

	public Border resaltardescripcionDetalleRequisicionCompra=null;
	public Boolean mostrardescripcionDetalleRequisicionCompra=true;
	public Boolean activardescripcionDetalleRequisicionCompra=true;

	public Border resaltarcantidad_entregadaDetalleRequisicionCompra=null;
	public Boolean mostrarcantidad_entregadaDetalleRequisicionCompra=true;
	public Boolean activarcantidad_entregadaDetalleRequisicionCompra=false;

	public Border resaltarcantidad_pendienteDetalleRequisicionCompra=null;
	public Boolean mostrarcantidad_pendienteDetalleRequisicionCompra=true;
	public Boolean activarcantidad_pendienteDetalleRequisicionCompra=false;

	
	

	public Border setResaltaridDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltaridDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleRequisicionCompra() {
		return this.resaltaridDetalleRequisicionCompra;
	}

	public void setResaltaridDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltaridDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostraridDetalleRequisicionCompra() {
		return this.mostraridDetalleRequisicionCompra;
	}

	public void setMostraridDetalleRequisicionCompra(Boolean mostraridDetalleRequisicionCompra) {
		this.mostraridDetalleRequisicionCompra= mostraridDetalleRequisicionCompra;
	}

	public Boolean getActivaridDetalleRequisicionCompra() {
		return this.activaridDetalleRequisicionCompra;
	}

	public void setActivaridDetalleRequisicionCompra(Boolean activaridDetalleRequisicionCompra) {
		this.activaridDetalleRequisicionCompra= activaridDetalleRequisicionCompra;
	}

	public Border setResaltarid_requisicion_compraDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_requisicion_compraDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_requisicion_compraDetalleRequisicionCompra() {
		return this.resaltarid_requisicion_compraDetalleRequisicionCompra;
	}

	public void setResaltarid_requisicion_compraDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_requisicion_compraDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_requisicion_compraDetalleRequisicionCompra() {
		return this.mostrarid_requisicion_compraDetalleRequisicionCompra;
	}

	public void setMostrarid_requisicion_compraDetalleRequisicionCompra(Boolean mostrarid_requisicion_compraDetalleRequisicionCompra) {
		this.mostrarid_requisicion_compraDetalleRequisicionCompra= mostrarid_requisicion_compraDetalleRequisicionCompra;
	}

	public Boolean getActivarid_requisicion_compraDetalleRequisicionCompra() {
		return this.activarid_requisicion_compraDetalleRequisicionCompra;
	}

	public void setActivarid_requisicion_compraDetalleRequisicionCompra(Boolean activarid_requisicion_compraDetalleRequisicionCompra) {
		this.activarid_requisicion_compraDetalleRequisicionCompra= activarid_requisicion_compraDetalleRequisicionCompra;
	}

	public Boolean getCargarid_requisicion_compraDetalleRequisicionCompra() {
		return this.cargarid_requisicion_compraDetalleRequisicionCompra;
	}

	public void setCargarid_requisicion_compraDetalleRequisicionCompra(Boolean cargarid_requisicion_compraDetalleRequisicionCompra) {
		this.cargarid_requisicion_compraDetalleRequisicionCompra= cargarid_requisicion_compraDetalleRequisicionCompra;
	}

	public Border setResaltarid_empresaDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleRequisicionCompra() {
		return this.resaltarid_empresaDetalleRequisicionCompra;
	}

	public void setResaltarid_empresaDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_empresaDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleRequisicionCompra() {
		return this.mostrarid_empresaDetalleRequisicionCompra;
	}

	public void setMostrarid_empresaDetalleRequisicionCompra(Boolean mostrarid_empresaDetalleRequisicionCompra) {
		this.mostrarid_empresaDetalleRequisicionCompra= mostrarid_empresaDetalleRequisicionCompra;
	}

	public Boolean getActivarid_empresaDetalleRequisicionCompra() {
		return this.activarid_empresaDetalleRequisicionCompra;
	}

	public void setActivarid_empresaDetalleRequisicionCompra(Boolean activarid_empresaDetalleRequisicionCompra) {
		this.activarid_empresaDetalleRequisicionCompra= activarid_empresaDetalleRequisicionCompra;
	}

	public Boolean getCargarid_empresaDetalleRequisicionCompra() {
		return this.cargarid_empresaDetalleRequisicionCompra;
	}

	public void setCargarid_empresaDetalleRequisicionCompra(Boolean cargarid_empresaDetalleRequisicionCompra) {
		this.cargarid_empresaDetalleRequisicionCompra= cargarid_empresaDetalleRequisicionCompra;
	}

	public Border setResaltarid_sucursalDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleRequisicionCompra() {
		return this.resaltarid_sucursalDetalleRequisicionCompra;
	}

	public void setResaltarid_sucursalDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_sucursalDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleRequisicionCompra() {
		return this.mostrarid_sucursalDetalleRequisicionCompra;
	}

	public void setMostrarid_sucursalDetalleRequisicionCompra(Boolean mostrarid_sucursalDetalleRequisicionCompra) {
		this.mostrarid_sucursalDetalleRequisicionCompra= mostrarid_sucursalDetalleRequisicionCompra;
	}

	public Boolean getActivarid_sucursalDetalleRequisicionCompra() {
		return this.activarid_sucursalDetalleRequisicionCompra;
	}

	public void setActivarid_sucursalDetalleRequisicionCompra(Boolean activarid_sucursalDetalleRequisicionCompra) {
		this.activarid_sucursalDetalleRequisicionCompra= activarid_sucursalDetalleRequisicionCompra;
	}

	public Boolean getCargarid_sucursalDetalleRequisicionCompra() {
		return this.cargarid_sucursalDetalleRequisicionCompra;
	}

	public void setCargarid_sucursalDetalleRequisicionCompra(Boolean cargarid_sucursalDetalleRequisicionCompra) {
		this.cargarid_sucursalDetalleRequisicionCompra= cargarid_sucursalDetalleRequisicionCompra;
	}

	public Border setResaltarid_ejercicioDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleRequisicionCompra() {
		return this.resaltarid_ejercicioDetalleRequisicionCompra;
	}

	public void setResaltarid_ejercicioDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleRequisicionCompra() {
		return this.mostrarid_ejercicioDetalleRequisicionCompra;
	}

	public void setMostrarid_ejercicioDetalleRequisicionCompra(Boolean mostrarid_ejercicioDetalleRequisicionCompra) {
		this.mostrarid_ejercicioDetalleRequisicionCompra= mostrarid_ejercicioDetalleRequisicionCompra;
	}

	public Boolean getActivarid_ejercicioDetalleRequisicionCompra() {
		return this.activarid_ejercicioDetalleRequisicionCompra;
	}

	public void setActivarid_ejercicioDetalleRequisicionCompra(Boolean activarid_ejercicioDetalleRequisicionCompra) {
		this.activarid_ejercicioDetalleRequisicionCompra= activarid_ejercicioDetalleRequisicionCompra;
	}

	public Boolean getCargarid_ejercicioDetalleRequisicionCompra() {
		return this.cargarid_ejercicioDetalleRequisicionCompra;
	}

	public void setCargarid_ejercicioDetalleRequisicionCompra(Boolean cargarid_ejercicioDetalleRequisicionCompra) {
		this.cargarid_ejercicioDetalleRequisicionCompra= cargarid_ejercicioDetalleRequisicionCompra;
	}

	public Border setResaltarid_periodoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleRequisicionCompra() {
		return this.resaltarid_periodoDetalleRequisicionCompra;
	}

	public void setResaltarid_periodoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_periodoDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleRequisicionCompra() {
		return this.mostrarid_periodoDetalleRequisicionCompra;
	}

	public void setMostrarid_periodoDetalleRequisicionCompra(Boolean mostrarid_periodoDetalleRequisicionCompra) {
		this.mostrarid_periodoDetalleRequisicionCompra= mostrarid_periodoDetalleRequisicionCompra;
	}

	public Boolean getActivarid_periodoDetalleRequisicionCompra() {
		return this.activarid_periodoDetalleRequisicionCompra;
	}

	public void setActivarid_periodoDetalleRequisicionCompra(Boolean activarid_periodoDetalleRequisicionCompra) {
		this.activarid_periodoDetalleRequisicionCompra= activarid_periodoDetalleRequisicionCompra;
	}

	public Boolean getCargarid_periodoDetalleRequisicionCompra() {
		return this.cargarid_periodoDetalleRequisicionCompra;
	}

	public void setCargarid_periodoDetalleRequisicionCompra(Boolean cargarid_periodoDetalleRequisicionCompra) {
		this.cargarid_periodoDetalleRequisicionCompra= cargarid_periodoDetalleRequisicionCompra;
	}

	public Border setResaltarid_anioDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleRequisicionCompra() {
		return this.resaltarid_anioDetalleRequisicionCompra;
	}

	public void setResaltarid_anioDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_anioDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleRequisicionCompra() {
		return this.mostrarid_anioDetalleRequisicionCompra;
	}

	public void setMostrarid_anioDetalleRequisicionCompra(Boolean mostrarid_anioDetalleRequisicionCompra) {
		this.mostrarid_anioDetalleRequisicionCompra= mostrarid_anioDetalleRequisicionCompra;
	}

	public Boolean getActivarid_anioDetalleRequisicionCompra() {
		return this.activarid_anioDetalleRequisicionCompra;
	}

	public void setActivarid_anioDetalleRequisicionCompra(Boolean activarid_anioDetalleRequisicionCompra) {
		this.activarid_anioDetalleRequisicionCompra= activarid_anioDetalleRequisicionCompra;
	}

	public Boolean getCargarid_anioDetalleRequisicionCompra() {
		return this.cargarid_anioDetalleRequisicionCompra;
	}

	public void setCargarid_anioDetalleRequisicionCompra(Boolean cargarid_anioDetalleRequisicionCompra) {
		this.cargarid_anioDetalleRequisicionCompra= cargarid_anioDetalleRequisicionCompra;
	}

	public Border setResaltarid_mesDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleRequisicionCompra() {
		return this.resaltarid_mesDetalleRequisicionCompra;
	}

	public void setResaltarid_mesDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_mesDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleRequisicionCompra() {
		return this.mostrarid_mesDetalleRequisicionCompra;
	}

	public void setMostrarid_mesDetalleRequisicionCompra(Boolean mostrarid_mesDetalleRequisicionCompra) {
		this.mostrarid_mesDetalleRequisicionCompra= mostrarid_mesDetalleRequisicionCompra;
	}

	public Boolean getActivarid_mesDetalleRequisicionCompra() {
		return this.activarid_mesDetalleRequisicionCompra;
	}

	public void setActivarid_mesDetalleRequisicionCompra(Boolean activarid_mesDetalleRequisicionCompra) {
		this.activarid_mesDetalleRequisicionCompra= activarid_mesDetalleRequisicionCompra;
	}

	public Boolean getCargarid_mesDetalleRequisicionCompra() {
		return this.cargarid_mesDetalleRequisicionCompra;
	}

	public void setCargarid_mesDetalleRequisicionCompra(Boolean cargarid_mesDetalleRequisicionCompra) {
		this.cargarid_mesDetalleRequisicionCompra= cargarid_mesDetalleRequisicionCompra;
	}

	public Border setResaltarid_bodegaDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleRequisicionCompra() {
		return this.resaltarid_bodegaDetalleRequisicionCompra;
	}

	public void setResaltarid_bodegaDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_bodegaDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleRequisicionCompra() {
		return this.mostrarid_bodegaDetalleRequisicionCompra;
	}

	public void setMostrarid_bodegaDetalleRequisicionCompra(Boolean mostrarid_bodegaDetalleRequisicionCompra) {
		this.mostrarid_bodegaDetalleRequisicionCompra= mostrarid_bodegaDetalleRequisicionCompra;
	}

	public Boolean getActivarid_bodegaDetalleRequisicionCompra() {
		return this.activarid_bodegaDetalleRequisicionCompra;
	}

	public void setActivarid_bodegaDetalleRequisicionCompra(Boolean activarid_bodegaDetalleRequisicionCompra) {
		this.activarid_bodegaDetalleRequisicionCompra= activarid_bodegaDetalleRequisicionCompra;
	}

	public Boolean getCargarid_bodegaDetalleRequisicionCompra() {
		return this.cargarid_bodegaDetalleRequisicionCompra;
	}

	public void setCargarid_bodegaDetalleRequisicionCompra(Boolean cargarid_bodegaDetalleRequisicionCompra) {
		this.cargarid_bodegaDetalleRequisicionCompra= cargarid_bodegaDetalleRequisicionCompra;
	}

	public Border setResaltarid_productoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleRequisicionCompra() {
		return this.resaltarid_productoDetalleRequisicionCompra;
	}

	public void setResaltarid_productoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_productoDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleRequisicionCompra() {
		return this.mostrarid_productoDetalleRequisicionCompra;
	}

	public void setMostrarid_productoDetalleRequisicionCompra(Boolean mostrarid_productoDetalleRequisicionCompra) {
		this.mostrarid_productoDetalleRequisicionCompra= mostrarid_productoDetalleRequisicionCompra;
	}

	public Boolean getActivarid_productoDetalleRequisicionCompra() {
		return this.activarid_productoDetalleRequisicionCompra;
	}

	public void setActivarid_productoDetalleRequisicionCompra(Boolean activarid_productoDetalleRequisicionCompra) {
		this.activarid_productoDetalleRequisicionCompra= activarid_productoDetalleRequisicionCompra;
	}

	public Boolean getCargarid_productoDetalleRequisicionCompra() {
		return this.cargarid_productoDetalleRequisicionCompra;
	}

	public void setCargarid_productoDetalleRequisicionCompra(Boolean cargarid_productoDetalleRequisicionCompra) {
		this.cargarid_productoDetalleRequisicionCompra= cargarid_productoDetalleRequisicionCompra;
	}

	public Border setResaltarid_unidadDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleRequisicionCompra() {
		return this.resaltarid_unidadDetalleRequisicionCompra;
	}

	public void setResaltarid_unidadDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_unidadDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleRequisicionCompra() {
		return this.mostrarid_unidadDetalleRequisicionCompra;
	}

	public void setMostrarid_unidadDetalleRequisicionCompra(Boolean mostrarid_unidadDetalleRequisicionCompra) {
		this.mostrarid_unidadDetalleRequisicionCompra= mostrarid_unidadDetalleRequisicionCompra;
	}

	public Boolean getActivarid_unidadDetalleRequisicionCompra() {
		return this.activarid_unidadDetalleRequisicionCompra;
	}

	public void setActivarid_unidadDetalleRequisicionCompra(Boolean activarid_unidadDetalleRequisicionCompra) {
		this.activarid_unidadDetalleRequisicionCompra= activarid_unidadDetalleRequisicionCompra;
	}

	public Boolean getCargarid_unidadDetalleRequisicionCompra() {
		return this.cargarid_unidadDetalleRequisicionCompra;
	}

	public void setCargarid_unidadDetalleRequisicionCompra(Boolean cargarid_unidadDetalleRequisicionCompra) {
		this.cargarid_unidadDetalleRequisicionCompra= cargarid_unidadDetalleRequisicionCompra;
	}

	public Border setResaltarid_centro_costoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleRequisicionCompra() {
		return this.resaltarid_centro_costoDetalleRequisicionCompra;
	}

	public void setResaltarid_centro_costoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleRequisicionCompra() {
		return this.mostrarid_centro_costoDetalleRequisicionCompra;
	}

	public void setMostrarid_centro_costoDetalleRequisicionCompra(Boolean mostrarid_centro_costoDetalleRequisicionCompra) {
		this.mostrarid_centro_costoDetalleRequisicionCompra= mostrarid_centro_costoDetalleRequisicionCompra;
	}

	public Boolean getActivarid_centro_costoDetalleRequisicionCompra() {
		return this.activarid_centro_costoDetalleRequisicionCompra;
	}

	public void setActivarid_centro_costoDetalleRequisicionCompra(Boolean activarid_centro_costoDetalleRequisicionCompra) {
		this.activarid_centro_costoDetalleRequisicionCompra= activarid_centro_costoDetalleRequisicionCompra;
	}

	public Boolean getCargarid_centro_costoDetalleRequisicionCompra() {
		return this.cargarid_centro_costoDetalleRequisicionCompra;
	}

	public void setCargarid_centro_costoDetalleRequisicionCompra(Boolean cargarid_centro_costoDetalleRequisicionCompra) {
		this.cargarid_centro_costoDetalleRequisicionCompra= cargarid_centro_costoDetalleRequisicionCompra;
	}

	public Border setResaltarcantidad_requisicionDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_requisicionDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_requisicionDetalleRequisicionCompra() {
		return this.resaltarcantidad_requisicionDetalleRequisicionCompra;
	}

	public void setResaltarcantidad_requisicionDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarcantidad_requisicionDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_requisicionDetalleRequisicionCompra() {
		return this.mostrarcantidad_requisicionDetalleRequisicionCompra;
	}

	public void setMostrarcantidad_requisicionDetalleRequisicionCompra(Boolean mostrarcantidad_requisicionDetalleRequisicionCompra) {
		this.mostrarcantidad_requisicionDetalleRequisicionCompra= mostrarcantidad_requisicionDetalleRequisicionCompra;
	}

	public Boolean getActivarcantidad_requisicionDetalleRequisicionCompra() {
		return this.activarcantidad_requisicionDetalleRequisicionCompra;
	}

	public void setActivarcantidad_requisicionDetalleRequisicionCompra(Boolean activarcantidad_requisicionDetalleRequisicionCompra) {
		this.activarcantidad_requisicionDetalleRequisicionCompra= activarcantidad_requisicionDetalleRequisicionCompra;
	}

	public Border setResaltarcosto_unitarioDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleRequisicionCompra() {
		return this.resaltarcosto_unitarioDetalleRequisicionCompra;
	}

	public void setResaltarcosto_unitarioDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleRequisicionCompra() {
		return this.mostrarcosto_unitarioDetalleRequisicionCompra;
	}

	public void setMostrarcosto_unitarioDetalleRequisicionCompra(Boolean mostrarcosto_unitarioDetalleRequisicionCompra) {
		this.mostrarcosto_unitarioDetalleRequisicionCompra= mostrarcosto_unitarioDetalleRequisicionCompra;
	}

	public Boolean getActivarcosto_unitarioDetalleRequisicionCompra() {
		return this.activarcosto_unitarioDetalleRequisicionCompra;
	}

	public void setActivarcosto_unitarioDetalleRequisicionCompra(Boolean activarcosto_unitarioDetalleRequisicionCompra) {
		this.activarcosto_unitarioDetalleRequisicionCompra= activarcosto_unitarioDetalleRequisicionCompra;
	}

	public Border setResaltarcosto_totalDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarcosto_totalDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleRequisicionCompra() {
		return this.resaltarcosto_totalDetalleRequisicionCompra;
	}

	public void setResaltarcosto_totalDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarcosto_totalDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleRequisicionCompra() {
		return this.mostrarcosto_totalDetalleRequisicionCompra;
	}

	public void setMostrarcosto_totalDetalleRequisicionCompra(Boolean mostrarcosto_totalDetalleRequisicionCompra) {
		this.mostrarcosto_totalDetalleRequisicionCompra= mostrarcosto_totalDetalleRequisicionCompra;
	}

	public Boolean getActivarcosto_totalDetalleRequisicionCompra() {
		return this.activarcosto_totalDetalleRequisicionCompra;
	}

	public void setActivarcosto_totalDetalleRequisicionCompra(Boolean activarcosto_totalDetalleRequisicionCompra) {
		this.activarcosto_totalDetalleRequisicionCompra= activarcosto_totalDetalleRequisicionCompra;
	}

	public Border setResaltardescripcionDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleRequisicionCompra() {
		return this.resaltardescripcionDetalleRequisicionCompra;
	}

	public void setResaltardescripcionDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltardescripcionDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleRequisicionCompra() {
		return this.mostrardescripcionDetalleRequisicionCompra;
	}

	public void setMostrardescripcionDetalleRequisicionCompra(Boolean mostrardescripcionDetalleRequisicionCompra) {
		this.mostrardescripcionDetalleRequisicionCompra= mostrardescripcionDetalleRequisicionCompra;
	}

	public Boolean getActivardescripcionDetalleRequisicionCompra() {
		return this.activardescripcionDetalleRequisicionCompra;
	}

	public void setActivardescripcionDetalleRequisicionCompra(Boolean activardescripcionDetalleRequisicionCompra) {
		this.activardescripcionDetalleRequisicionCompra= activardescripcionDetalleRequisicionCompra;
	}

	public Border setResaltarcantidad_entregadaDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_entregadaDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_entregadaDetalleRequisicionCompra() {
		return this.resaltarcantidad_entregadaDetalleRequisicionCompra;
	}

	public void setResaltarcantidad_entregadaDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarcantidad_entregadaDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_entregadaDetalleRequisicionCompra() {
		return this.mostrarcantidad_entregadaDetalleRequisicionCompra;
	}

	public void setMostrarcantidad_entregadaDetalleRequisicionCompra(Boolean mostrarcantidad_entregadaDetalleRequisicionCompra) {
		this.mostrarcantidad_entregadaDetalleRequisicionCompra= mostrarcantidad_entregadaDetalleRequisicionCompra;
	}

	public Boolean getActivarcantidad_entregadaDetalleRequisicionCompra() {
		return this.activarcantidad_entregadaDetalleRequisicionCompra;
	}

	public void setActivarcantidad_entregadaDetalleRequisicionCompra(Boolean activarcantidad_entregadaDetalleRequisicionCompra) {
		this.activarcantidad_entregadaDetalleRequisicionCompra= activarcantidad_entregadaDetalleRequisicionCompra;
	}

	public Border setResaltarcantidad_pendienteDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicioncompraBeanSwingJInternalFrame.jTtoolBarDetalleRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendienteDetalleRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendienteDetalleRequisicionCompra() {
		return this.resaltarcantidad_pendienteDetalleRequisicionCompra;
	}

	public void setResaltarcantidad_pendienteDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarcantidad_pendienteDetalleRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendienteDetalleRequisicionCompra() {
		return this.mostrarcantidad_pendienteDetalleRequisicionCompra;
	}

	public void setMostrarcantidad_pendienteDetalleRequisicionCompra(Boolean mostrarcantidad_pendienteDetalleRequisicionCompra) {
		this.mostrarcantidad_pendienteDetalleRequisicionCompra= mostrarcantidad_pendienteDetalleRequisicionCompra;
	}

	public Boolean getActivarcantidad_pendienteDetalleRequisicionCompra() {
		return this.activarcantidad_pendienteDetalleRequisicionCompra;
	}

	public void setActivarcantidad_pendienteDetalleRequisicionCompra(Boolean activarcantidad_pendienteDetalleRequisicionCompra) {
		this.activarcantidad_pendienteDetalleRequisicionCompra= activarcantidad_pendienteDetalleRequisicionCompra;
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
		
		
		this.setMostraridDetalleRequisicionCompra(esInicial);
		this.setMostrarid_requisicion_compraDetalleRequisicionCompra(esInicial);
		this.setMostrarid_empresaDetalleRequisicionCompra(esInicial);
		this.setMostrarid_sucursalDetalleRequisicionCompra(esInicial);
		this.setMostrarid_ejercicioDetalleRequisicionCompra(esInicial);
		this.setMostrarid_periodoDetalleRequisicionCompra(esInicial);
		this.setMostrarid_anioDetalleRequisicionCompra(esInicial);
		this.setMostrarid_mesDetalleRequisicionCompra(esInicial);
		this.setMostrarid_bodegaDetalleRequisicionCompra(esInicial);
		this.setMostrarid_productoDetalleRequisicionCompra(esInicial);
		this.setMostrarid_unidadDetalleRequisicionCompra(esInicial);
		this.setMostrarid_centro_costoDetalleRequisicionCompra(esInicial);
		this.setMostrarcantidad_requisicionDetalleRequisicionCompra(esInicial);
		this.setMostrarcosto_unitarioDetalleRequisicionCompra(esInicial);
		this.setMostrarcosto_totalDetalleRequisicionCompra(esInicial);
		this.setMostrardescripcionDetalleRequisicionCompra(esInicial);
		this.setMostrarcantidad_entregadaDetalleRequisicionCompra(esInicial);
		this.setMostrarcantidad_pendienteDetalleRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.ID)) {
				this.setMostraridDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA)) {
				this.setMostrarid_requisicion_compraDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION)) {
				this.setMostrarcantidad_requisicionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setMostrarcantidad_entregadaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendienteDetalleRequisicionCompra(esAsigna);
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
		
		
		this.setActivaridDetalleRequisicionCompra(esInicial);
		this.setActivarid_requisicion_compraDetalleRequisicionCompra(esInicial);
		this.setActivarid_empresaDetalleRequisicionCompra(esInicial);
		this.setActivarid_sucursalDetalleRequisicionCompra(esInicial);
		this.setActivarid_ejercicioDetalleRequisicionCompra(esInicial);
		this.setActivarid_periodoDetalleRequisicionCompra(esInicial);
		this.setActivarid_anioDetalleRequisicionCompra(esInicial);
		this.setActivarid_mesDetalleRequisicionCompra(esInicial);
		this.setActivarid_bodegaDetalleRequisicionCompra(esInicial);
		this.setActivarid_productoDetalleRequisicionCompra(esInicial);
		this.setActivarid_unidadDetalleRequisicionCompra(esInicial);
		this.setActivarid_centro_costoDetalleRequisicionCompra(esInicial);
		this.setActivarcantidad_requisicionDetalleRequisicionCompra(esInicial);
		this.setActivarcosto_unitarioDetalleRequisicionCompra(esInicial);
		this.setActivarcosto_totalDetalleRequisicionCompra(esInicial);
		this.setActivardescripcionDetalleRequisicionCompra(esInicial);
		this.setActivarcantidad_entregadaDetalleRequisicionCompra(esInicial);
		this.setActivarcantidad_pendienteDetalleRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.ID)) {
				this.setActivaridDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA)) {
				this.setActivarid_requisicion_compraDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION)) {
				this.setActivarcantidad_requisicionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setActivarcantidad_entregadaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendienteDetalleRequisicionCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleRequisicionCompra(esInicial);
		this.setResaltarid_requisicion_compraDetalleRequisicionCompra(esInicial);
		this.setResaltarid_empresaDetalleRequisicionCompra(esInicial);
		this.setResaltarid_sucursalDetalleRequisicionCompra(esInicial);
		this.setResaltarid_ejercicioDetalleRequisicionCompra(esInicial);
		this.setResaltarid_periodoDetalleRequisicionCompra(esInicial);
		this.setResaltarid_anioDetalleRequisicionCompra(esInicial);
		this.setResaltarid_mesDetalleRequisicionCompra(esInicial);
		this.setResaltarid_bodegaDetalleRequisicionCompra(esInicial);
		this.setResaltarid_productoDetalleRequisicionCompra(esInicial);
		this.setResaltarid_unidadDetalleRequisicionCompra(esInicial);
		this.setResaltarid_centro_costoDetalleRequisicionCompra(esInicial);
		this.setResaltarcantidad_requisicionDetalleRequisicionCompra(esInicial);
		this.setResaltarcosto_unitarioDetalleRequisicionCompra(esInicial);
		this.setResaltarcosto_totalDetalleRequisicionCompra(esInicial);
		this.setResaltardescripcionDetalleRequisicionCompra(esInicial);
		this.setResaltarcantidad_entregadaDetalleRequisicionCompra(esInicial);
		this.setResaltarcantidad_pendienteDetalleRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.ID)) {
				this.setResaltaridDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA)) {
				this.setResaltarid_requisicion_compraDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION)) {
				this.setResaltarcantidad_requisicionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA)) {
				this.setResaltarcantidad_entregadaDetalleRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendienteDetalleRequisicionCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdBodegaDetalleRequisicionCompra() {
		return this.mostrarFK_IdBodegaDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdBodegaDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleRequisicionCompra() {
		return this.mostrarFK_IdCentroCostoDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdCentroCostoDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdEjercicioDetalleRequisicionCompra() {
		return this.mostrarFK_IdEjercicioDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdEjercicioDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdEmpresaDetalleRequisicionCompra() {
		return this.mostrarFK_IdEmpresaDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdEmpresaDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdPeriodoDetalleRequisicionCompra() {
		return this.mostrarFK_IdPeriodoDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdPeriodoDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdProductoDetalleRequisicionCompra() {
		return this.mostrarFK_IdProductoDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdProductoDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRequisicionCompraDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdRequisicionCompraDetalleRequisicionCompra() {
		return this.mostrarFK_IdRequisicionCompraDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdRequisicionCompraDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRequisicionCompraDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdSucursalDetalleRequisicionCompra() {
		return this.mostrarFK_IdSucursalDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdSucursalDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleRequisicionCompra=true;

	public Boolean getMostrarFK_IdUnidadDetalleRequisicionCompra() {
		return this.mostrarFK_IdUnidadDetalleRequisicionCompra;
	}

	public void setMostrarFK_IdUnidadDetalleRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleRequisicionCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdBodegaDetalleRequisicionCompra() {
		return this.activarFK_IdBodegaDetalleRequisicionCompra;
	}

	public void setActivarFK_IdBodegaDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdCentroCostoDetalleRequisicionCompra() {
		return this.activarFK_IdCentroCostoDetalleRequisicionCompra;
	}

	public void setActivarFK_IdCentroCostoDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdEjercicioDetalleRequisicionCompra() {
		return this.activarFK_IdEjercicioDetalleRequisicionCompra;
	}

	public void setActivarFK_IdEjercicioDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdEmpresaDetalleRequisicionCompra() {
		return this.activarFK_IdEmpresaDetalleRequisicionCompra;
	}

	public void setActivarFK_IdEmpresaDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdPeriodoDetalleRequisicionCompra() {
		return this.activarFK_IdPeriodoDetalleRequisicionCompra;
	}

	public void setActivarFK_IdPeriodoDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdProductoDetalleRequisicionCompra() {
		return this.activarFK_IdProductoDetalleRequisicionCompra;
	}

	public void setActivarFK_IdProductoDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdRequisicionCompraDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdRequisicionCompraDetalleRequisicionCompra() {
		return this.activarFK_IdRequisicionCompraDetalleRequisicionCompra;
	}

	public void setActivarFK_IdRequisicionCompraDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdRequisicionCompraDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdSucursalDetalleRequisicionCompra() {
		return this.activarFK_IdSucursalDetalleRequisicionCompra;
	}

	public void setActivarFK_IdSucursalDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleRequisicionCompra=true;

	public Boolean getActivarFK_IdUnidadDetalleRequisicionCompra() {
		return this.activarFK_IdUnidadDetalleRequisicionCompra;
	}

	public void setActivarFK_IdUnidadDetalleRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleRequisicionCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdBodegaDetalleRequisicionCompra() {
		return this.resaltarFK_IdBodegaDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdBodegaDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdCentroCostoDetalleRequisicionCompra() {
		return this.resaltarFK_IdCentroCostoDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdCentroCostoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdEjercicioDetalleRequisicionCompra() {
		return this.resaltarFK_IdEjercicioDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdEjercicioDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdEmpresaDetalleRequisicionCompra() {
		return this.resaltarFK_IdEmpresaDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdEmpresaDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdPeriodoDetalleRequisicionCompra() {
		return this.resaltarFK_IdPeriodoDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdPeriodoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdProductoDetalleRequisicionCompra() {
		return this.resaltarFK_IdProductoDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdProductoDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdRequisicionCompraDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdRequisicionCompraDetalleRequisicionCompra() {
		return this.resaltarFK_IdRequisicionCompraDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdRequisicionCompraDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdRequisicionCompraDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdRequisicionCompraDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRequisicionCompraDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdSucursalDetalleRequisicionCompra() {
		return this.resaltarFK_IdSucursalDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdSucursalDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleRequisicionCompra=null;

	public Border getResaltarFK_IdUnidadDetalleRequisicionCompra() {
		return this.resaltarFK_IdUnidadDetalleRequisicionCompra;
	}

	public void setResaltarFK_IdUnidadDetalleRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionCompraBeanSwingJInternalFrame detallerequisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleRequisicionCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}