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


import com.bydan.erp.inventario.util.DetalleTransferenciaConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleTransferenciaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleTransferenciaParameterGeneral;

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
final public class DetalleTransferenciaConstantesFunciones extends DetalleTransferenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleTransferencia";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleTransferencia"+DetalleTransferenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleTransferenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleTransferenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleTransferenciaConstantesFunciones.SCHEMA+"_"+DetalleTransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleTransferenciaConstantesFunciones.SCHEMA+"_"+DetalleTransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleTransferenciaConstantesFunciones.SCHEMA+"_"+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleTransferenciaConstantesFunciones.SCHEMA+"_"+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleTransferenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleTransferenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleTransferenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleTransferenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Transferencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Transferencia";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Transferencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleTransferencia";
	public static final String OBJECTNAME="detalletransferencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_transferencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalletransferencia from "+DetalleTransferenciaConstantesFunciones.SPERSISTENCENAME+" detalletransferencia";
	public static String QUERYSELECTNATIVE="select "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".version_row,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_transferencia,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_anio,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_mes,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_producto,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_bodega_enviar,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".descripcion,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".id_estado_detalle_inventario,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".cantidad,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".descuento,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".costo_total,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".disponible,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleTransferenciaConstantesFunciones.SCHEMA+"."+DetalleTransferenciaConstantesFunciones.TABLENAME;//+" as "+DetalleTransferenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleTransferenciaConstantesFuncionesAdditional detalletransferenciaConstantesFuncionesAdditional=null;
	
	public DetalleTransferenciaConstantesFuncionesAdditional getDetalleTransferenciaConstantesFuncionesAdditional() {
		return this.detalletransferenciaConstantesFuncionesAdditional;
	}
	
	public void setDetalleTransferenciaConstantesFuncionesAdditional(DetalleTransferenciaConstantesFuncionesAdditional detalletransferenciaConstantesFuncionesAdditional) {
		try {
			this.detalletransferenciaConstantesFuncionesAdditional=detalletransferenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTRANSFERENCIA= "id_transferencia";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDBODEGAENVIAR= "id_bodega_enviar";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String IDESTADODETALLEINVENTARIO= "id_estado_detalle_inventario";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCUENTO= "descuento";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DISPONIBLE= "disponible";
    public static final String LOTE= "lote";
    public static final String FECHAELABORACIONLOTE= "fecha_elaboracion_lote";
    public static final String FECHACADUCIDADLOTE= "fecha_caducidad_lote";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String LOTECLIENTE= "lote_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTRANSFERENCIA= "Transferencia";
		public static final String LABEL_IDTRANSFERENCIA_LOWER= "Transferencia";
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
    	public static final String LABEL_IDBODEGAENVIAR= "Bodega Enviar";
		public static final String LABEL_IDBODEGAENVIAR_LOWER= "Bodega Enviar";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_IDESTADODETALLEINVENTARIO= "Estado";
		public static final String LABEL_IDESTADODETALLEINVENTARIO_LOWER= "Estado Detalle Inventario";
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
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_FECHAELABORACIONLOTE= "Fecha Elaboracion Lote";
		public static final String LABEL_FECHAELABORACIONLOTE_LOWER= "Fecha Elaboracion Lote";
    	public static final String LABEL_FECHACADUCIDADLOTE= "Fecha Caducidad Lote";
		public static final String LABEL_FECHACADUCIDADLOTE_LOWER= "Fecha Caducidad Lote";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Nro Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_LOTECLIENTE= "Lote Cliente";
		public static final String LABEL_LOTECLIENTE_LOWER= "Lote Cliente";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleTransferenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDTRANSFERENCIA;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDANIO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDMES)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGAENVIAR;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.COSTOTOTAL)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.DISPONIBLE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.LOTE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_FECHAELABORACIONLOTE;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_FECHACADUCIDADLOTE;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleTransferenciaConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleTransferenciaConstantesFunciones.LABEL_LOTECLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleTransferenciaDescripcion(DetalleTransferencia detalletransferencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalletransferencia !=null/* && detalletransferencia.getId()!=0*/) {
			if(detalletransferencia.getId()!=null) {
				sDescripcion=detalletransferencia.getId().toString();
			}//detalletransferenciadetalletransferencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleTransferenciaDescripcionDetallado(DetalleTransferencia detalletransferencia) {
		String sDescripcion="";
			
		sDescripcion+=DetalleTransferenciaConstantesFunciones.ID+"=";
		sDescripcion+=detalletransferencia.getId().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalletransferencia.getVersionRow().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA+"=";
		sDescripcion+=detalletransferencia.getid_transferencia().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalletransferencia.getid_empresa().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalletransferencia.getid_sucursal().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalletransferencia.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalletransferencia.getid_periodo().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalletransferencia.getid_anio().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDMES+"=";
		sDescripcion+=detalletransferencia.getid_mes().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalletransferencia.getid_bodega().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalletransferencia.getid_producto().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalletransferencia.getid_unidad().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR+"=";
		sDescripcion+=detalletransferencia.getid_bodega_enviar().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalletransferencia.getdescripcion()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=detalletransferencia.getid_novedad_producto().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO+"=";
		sDescripcion+=detalletransferencia.getid_estado_detalle_inventario().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalletransferencia.getcantidad().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detalletransferencia.getdescuento().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=detalletransferencia.getcosto_unitario().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=detalletransferencia.getcosto_total().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=detalletransferencia.getdisponible().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.LOTE+"=";
		sDescripcion+=detalletransferencia.getlote()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE+"=";
		sDescripcion+=detalletransferencia.getfecha_elaboracion_lote().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE+"=";
		sDescripcion+=detalletransferencia.getfecha_caducidad_lote().toString()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detalletransferencia.getnumero_comprobante()+",";
		sDescripcion+=DetalleTransferenciaConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detalletransferencia.getlote_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleTransferenciaDescripcion(DetalleTransferencia detalletransferencia,String sValor) throws Exception {			
		if(detalletransferencia !=null) {
			//detalletransferenciadetalletransferencia.getId().toString();
		}		
	}
	
		

	public static String getTransferenciaDescripcion(Transferencia transferencia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transferencia!=null/*&&transferencia.getId()>0*/) {
			sDescripcion=TransferenciaConstantesFunciones.getTransferenciaDescripcion(transferencia);
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

	public static String getBodegaEnviarDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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

	public static String getEstadoDetalleInventarioDescripcion(EstadoDetalleInventario estadodetalleinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetalleinventario!=null/*&&estadodetalleinventario.getId()>0*/) {
			sDescripcion=EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(estadodetalleinventario);
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
		} else if(sNombreIndice.equals("FK_IdBodegaEnviar")) {
			sNombreIndice="Tipo=  Por Bodega Enviar";
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
		} else if(sNombreIndice.equals("FK_IdTransferencia")) {
			sNombreIndice="Tipo=  Por Transferencia";
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

	public static String getDetalleIndiceFK_IdBodegaEnviar(Long id_bodega_enviar) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_enviar!=null) {sDetalleIndice+=" Codigo Unico De Bodega Enviar="+id_bodega_enviar.toString();} 

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

	public static String getDetalleIndiceFK_IdTransferencia(Long id_transferencia) {
		String sDetalleIndice=" Parametros->";
		if(id_transferencia!=null) {sDetalleIndice+=" Codigo Unico De Transferencia="+id_transferencia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleTransferencia(DetalleTransferencia detalletransferencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalletransferencia.setdescripcion(detalletransferencia.getdescripcion().trim());
		detalletransferencia.setlote(detalletransferencia.getlote().trim());
		detalletransferencia.setnumero_comprobante(detalletransferencia.getnumero_comprobante().trim());
		detalletransferencia.setlote_cliente(detalletransferencia.getlote_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleTransferencias(List<DetalleTransferencia> detalletransferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleTransferencia detalletransferencia: detalletransferencias) {
			detalletransferencia.setdescripcion(detalletransferencia.getdescripcion().trim());
			detalletransferencia.setlote(detalletransferencia.getlote().trim());
			detalletransferencia.setnumero_comprobante(detalletransferencia.getnumero_comprobante().trim());
			detalletransferencia.setlote_cliente(detalletransferencia.getlote_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTransferencia(DetalleTransferencia detalletransferencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalletransferencia.getConCambioAuxiliar()) {
			detalletransferencia.setIsDeleted(detalletransferencia.getIsDeletedAuxiliar());	
			detalletransferencia.setIsNew(detalletransferencia.getIsNewAuxiliar());	
			detalletransferencia.setIsChanged(detalletransferencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalletransferencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalletransferencia.setIsDeletedAuxiliar(false);	
			detalletransferencia.setIsNewAuxiliar(false);	
			detalletransferencia.setIsChangedAuxiliar(false);
			
			detalletransferencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTransferencias(List<DetalleTransferencia> detalletransferencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleTransferencia detalletransferencia : detalletransferencias) {
			if(conAsignarBase && detalletransferencia.getConCambioAuxiliar()) {
				detalletransferencia.setIsDeleted(detalletransferencia.getIsDeletedAuxiliar());	
				detalletransferencia.setIsNew(detalletransferencia.getIsNewAuxiliar());	
				detalletransferencia.setIsChanged(detalletransferencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalletransferencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalletransferencia.setIsDeletedAuxiliar(false);	
				detalletransferencia.setIsNewAuxiliar(false);	
				detalletransferencia.setIsChangedAuxiliar(false);
				
				detalletransferencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleTransferencia(DetalleTransferencia detalletransferencia,Boolean conEnteros) throws Exception  {
		detalletransferencia.setdescuento(0.0);
		detalletransferencia.setcosto_unitario(0.0);
		detalletransferencia.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalletransferencia.setcantidad(0);
			detalletransferencia.setdisponible(0);
		}
	}		
	
	public static void InicializarValoresDetalleTransferencias(List<DetalleTransferencia> detalletransferencias,Boolean conEnteros) throws Exception  {
		
		for(DetalleTransferencia detalletransferencia: detalletransferencias) {
			detalletransferencia.setdescuento(0.0);
			detalletransferencia.setcosto_unitario(0.0);
			detalletransferencia.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalletransferencia.setcantidad(0);
				detalletransferencia.setdisponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleTransferencia(List<DetalleTransferencia> detalletransferencias,DetalleTransferencia detalletransferenciaAux) throws Exception  {
		DetalleTransferenciaConstantesFunciones.InicializarValoresDetalleTransferencia(detalletransferenciaAux,true);
		
		for(DetalleTransferencia detalletransferencia: detalletransferencias) {
			if(detalletransferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalletransferenciaAux.setcantidad(detalletransferenciaAux.getcantidad()+detalletransferencia.getcantidad());			
			detalletransferenciaAux.setdescuento(detalletransferenciaAux.getdescuento()+detalletransferencia.getdescuento());			
			detalletransferenciaAux.setcosto_unitario(detalletransferenciaAux.getcosto_unitario()+detalletransferencia.getcosto_unitario());			
			detalletransferenciaAux.setcosto_total(detalletransferenciaAux.getcosto_total()+detalletransferencia.getcosto_total());			
			detalletransferenciaAux.setdisponible(detalletransferenciaAux.getdisponible()+detalletransferencia.getdisponible());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleTransferenciaConstantesFunciones.getArrayColumnasGlobalesDetalleTransferencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTransferencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTransferenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTransferenciaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTransferenciaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTransferenciaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTransferenciaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTransferenciaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTransferenciaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTransferenciaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleTransferencia> detalletransferencias,DetalleTransferencia detalletransferencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleTransferencia detalletransferenciaAux: detalletransferencias) {
			if(detalletransferenciaAux!=null && detalletransferencia!=null) {
				if((detalletransferenciaAux.getId()==null && detalletransferencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalletransferenciaAux.getId()!=null && detalletransferencia.getId()!=null){
					if(detalletransferenciaAux.getId().equals(detalletransferencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleTransferencia(List<DetalleTransferencia> detalletransferencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(DetalleTransferencia detalletransferencia: detalletransferencias) {			
			if(detalletransferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=detalletransferencia.getdescuento();
			costo_unitarioTotal+=detalletransferencia.getcosto_unitario();
			costo_totalTotal+=detalletransferencia.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTransferenciaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTransferenciaConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTransferenciaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleTransferencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_ID, DetalleTransferenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_VERSIONROW, DetalleTransferenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDTRANSFERENCIA, DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDEMPRESA, DetalleTransferenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDSUCURSAL, DetalleTransferenciaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDEJERCICIO, DetalleTransferenciaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDPERIODO, DetalleTransferenciaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDANIO, DetalleTransferenciaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDMES, DetalleTransferenciaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGA, DetalleTransferenciaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDPRODUCTO, DetalleTransferenciaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDUNIDAD, DetalleTransferenciaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGAENVIAR, DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_DESCRIPCION, DetalleTransferenciaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO, DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_CANTIDAD, DetalleTransferenciaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO, DetalleTransferenciaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO, DetalleTransferenciaConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL, DetalleTransferenciaConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_DISPONIBLE, DetalleTransferenciaConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_LOTE, DetalleTransferenciaConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_FECHAELABORACIONLOTE, DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_FECHACADUCIDADLOTE, DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTransferenciaConstantesFunciones.LABEL_LOTECLIENTE, DetalleTransferenciaConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleTransferencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTransferenciaConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTransferencia() throws Exception  {
		return DetalleTransferenciaConstantesFunciones.getTiposSeleccionarDetalleTransferencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTransferencia(Boolean conFk) throws Exception  {
		return DetalleTransferenciaConstantesFunciones.getTiposSeleccionarDetalleTransferencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTransferencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDTRANSFERENCIA);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDTRANSFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGAENVIAR);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGAENVIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_FECHAELABORACIONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_FECHACADUCIDADLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTransferenciaConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleTransferenciaConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleTransferencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTransferencia(DetalleTransferencia detalletransferenciaAux) throws Exception {
		
			detalletransferenciaAux.settransferencia_descripcion(TransferenciaConstantesFunciones.getTransferenciaDescripcion(detalletransferenciaAux.getTransferencia()));
			detalletransferenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalletransferenciaAux.getEmpresa()));
			detalletransferenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalletransferenciaAux.getSucursal()));
			detalletransferenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalletransferenciaAux.getEjercicio()));
			detalletransferenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalletransferenciaAux.getPeriodo()));
			detalletransferenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalletransferenciaAux.getAnio()));
			detalletransferenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalletransferenciaAux.getMes()));
			detalletransferenciaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalletransferenciaAux.getBodega()));
			detalletransferenciaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalletransferenciaAux.getProducto()));
			detalletransferenciaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalletransferenciaAux.getUnidad()));
			detalletransferenciaAux.setbodegaenviar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalletransferenciaAux.getBodegaEnviar()));
			detalletransferenciaAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detalletransferenciaAux.getNovedadProducto()));
			detalletransferenciaAux.setestadodetalleinventario_descripcion(EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(detalletransferenciaAux.getEstadoDetalleInventario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTransferencia(List<DetalleTransferencia> detalletransferenciasTemp) throws Exception {
		for(DetalleTransferencia detalletransferenciaAux:detalletransferenciasTemp) {
			
			detalletransferenciaAux.settransferencia_descripcion(TransferenciaConstantesFunciones.getTransferenciaDescripcion(detalletransferenciaAux.getTransferencia()));
			detalletransferenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalletransferenciaAux.getEmpresa()));
			detalletransferenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalletransferenciaAux.getSucursal()));
			detalletransferenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalletransferenciaAux.getEjercicio()));
			detalletransferenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalletransferenciaAux.getPeriodo()));
			detalletransferenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalletransferenciaAux.getAnio()));
			detalletransferenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalletransferenciaAux.getMes()));
			detalletransferenciaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalletransferenciaAux.getBodega()));
			detalletransferenciaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalletransferenciaAux.getProducto()));
			detalletransferenciaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalletransferenciaAux.getUnidad()));
			detalletransferenciaAux.setbodegaenviar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalletransferenciaAux.getBodegaEnviar()));
			detalletransferenciaAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(detalletransferenciaAux.getNovedadProducto()));
			detalletransferenciaAux.setestadodetalleinventario_descripcion(EstadoDetalleInventarioConstantesFunciones.getEstadoDetalleInventarioDescripcion(detalletransferenciaAux.getEstadoDetalleInventario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Transferencia.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(EstadoDetalleInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Transferencia.class)) {
						classes.add(new Classe(Transferencia.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadProducto.class)) {
						classes.add(new Classe(NovedadProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetalleInventario.class)) {
						classes.add(new Classe(EstadoDetalleInventario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(EstadoDetalleInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(EstadoDetalleInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleInventario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTransferenciaConstantesFunciones.getClassesRelationshipsOfDetalleTransferencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTransferenciaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleTransferencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleTransferencia detalletransferencia,List<DetalleTransferencia> detalletransferencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleTransferencia detalletransferenciaEncontrado=null;
			
			for(DetalleTransferencia detalletransferenciaLocal:detalletransferencias) {
				if(detalletransferenciaLocal.getId().equals(detalletransferencia.getId())) {
					detalletransferenciaEncontrado=detalletransferenciaLocal;
					
					detalletransferenciaLocal.setIsChanged(detalletransferencia.getIsChanged());
					detalletransferenciaLocal.setIsNew(detalletransferencia.getIsNew());
					detalletransferenciaLocal.setIsDeleted(detalletransferencia.getIsDeleted());
					
					detalletransferenciaLocal.setGeneralEntityOriginal(detalletransferencia.getGeneralEntityOriginal());
					
					detalletransferenciaLocal.setId(detalletransferencia.getId());	
					detalletransferenciaLocal.setVersionRow(detalletransferencia.getVersionRow());	
					detalletransferenciaLocal.setid_transferencia(detalletransferencia.getid_transferencia());	
					detalletransferenciaLocal.setid_empresa(detalletransferencia.getid_empresa());	
					detalletransferenciaLocal.setid_sucursal(detalletransferencia.getid_sucursal());	
					detalletransferenciaLocal.setid_ejercicio(detalletransferencia.getid_ejercicio());	
					detalletransferenciaLocal.setid_periodo(detalletransferencia.getid_periodo());	
					detalletransferenciaLocal.setid_anio(detalletransferencia.getid_anio());	
					detalletransferenciaLocal.setid_mes(detalletransferencia.getid_mes());	
					detalletransferenciaLocal.setid_bodega(detalletransferencia.getid_bodega());	
					detalletransferenciaLocal.setid_producto(detalletransferencia.getid_producto());	
					detalletransferenciaLocal.setid_unidad(detalletransferencia.getid_unidad());	
					detalletransferenciaLocal.setid_bodega_enviar(detalletransferencia.getid_bodega_enviar());	
					detalletransferenciaLocal.setdescripcion(detalletransferencia.getdescripcion());	
					detalletransferenciaLocal.setid_novedad_producto(detalletransferencia.getid_novedad_producto());	
					detalletransferenciaLocal.setid_estado_detalle_inventario(detalletransferencia.getid_estado_detalle_inventario());	
					detalletransferenciaLocal.setcantidad(detalletransferencia.getcantidad());	
					detalletransferenciaLocal.setdescuento(detalletransferencia.getdescuento());	
					detalletransferenciaLocal.setcosto_unitario(detalletransferencia.getcosto_unitario());	
					detalletransferenciaLocal.setcosto_total(detalletransferencia.getcosto_total());	
					detalletransferenciaLocal.setdisponible(detalletransferencia.getdisponible());	
					detalletransferenciaLocal.setlote(detalletransferencia.getlote());	
					detalletransferenciaLocal.setfecha_elaboracion_lote(detalletransferencia.getfecha_elaboracion_lote());	
					detalletransferenciaLocal.setfecha_caducidad_lote(detalletransferencia.getfecha_caducidad_lote());	
					detalletransferenciaLocal.setnumero_comprobante(detalletransferencia.getnumero_comprobante());	
					detalletransferenciaLocal.setlote_cliente(detalletransferencia.getlote_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalletransferencia.getIsDeleted()) {
				if(!existe) {
					detalletransferencias.add(detalletransferencia);
				}
			} else {
				if(detalletransferenciaEncontrado!=null && permiteQuitar)  {
					detalletransferencias.remove(detalletransferenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleTransferencia detalletransferencia,List<DetalleTransferencia> detalletransferencias) throws Exception {
		try	{			
			for(DetalleTransferencia detalletransferenciaLocal:detalletransferencias) {
				if(detalletransferenciaLocal.getId().equals(detalletransferencia.getId())) {
					detalletransferenciaLocal.setIsSelected(detalletransferencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleTransferencia(List<DetalleTransferencia> detalletransferenciasAux) throws Exception {
		//this.detalletransferenciasAux=detalletransferenciasAux;
		
		for(DetalleTransferencia detalletransferenciaAux:detalletransferenciasAux) {
			if(detalletransferenciaAux.getIsChanged()) {
				detalletransferenciaAux.setIsChanged(false);
			}		
			
			if(detalletransferenciaAux.getIsNew()) {
				detalletransferenciaAux.setIsNew(false);
			}	
			
			if(detalletransferenciaAux.getIsDeleted()) {
				detalletransferenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleTransferencia(DetalleTransferencia detalletransferenciaAux) throws Exception {
		//this.detalletransferenciaAux=detalletransferenciaAux;
		
			if(detalletransferenciaAux.getIsChanged()) {
				detalletransferenciaAux.setIsChanged(false);
			}		
			
			if(detalletransferenciaAux.getIsNew()) {
				detalletransferenciaAux.setIsNew(false);
			}	
			
			if(detalletransferenciaAux.getIsDeleted()) {
				detalletransferenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleTransferencia detalletransferenciaAsignar,DetalleTransferencia detalletransferencia) throws Exception {
		detalletransferenciaAsignar.setId(detalletransferencia.getId());	
		detalletransferenciaAsignar.setVersionRow(detalletransferencia.getVersionRow());	
		detalletransferenciaAsignar.setid_transferencia(detalletransferencia.getid_transferencia());
		detalletransferenciaAsignar.settransferencia_descripcion(detalletransferencia.gettransferencia_descripcion());	
		detalletransferenciaAsignar.setid_empresa(detalletransferencia.getid_empresa());
		detalletransferenciaAsignar.setempresa_descripcion(detalletransferencia.getempresa_descripcion());	
		detalletransferenciaAsignar.setid_sucursal(detalletransferencia.getid_sucursal());
		detalletransferenciaAsignar.setsucursal_descripcion(detalletransferencia.getsucursal_descripcion());	
		detalletransferenciaAsignar.setid_ejercicio(detalletransferencia.getid_ejercicio());
		detalletransferenciaAsignar.setejercicio_descripcion(detalletransferencia.getejercicio_descripcion());	
		detalletransferenciaAsignar.setid_periodo(detalletransferencia.getid_periodo());
		detalletransferenciaAsignar.setperiodo_descripcion(detalletransferencia.getperiodo_descripcion());	
		detalletransferenciaAsignar.setid_anio(detalletransferencia.getid_anio());
		detalletransferenciaAsignar.setanio_descripcion(detalletransferencia.getanio_descripcion());	
		detalletransferenciaAsignar.setid_mes(detalletransferencia.getid_mes());
		detalletransferenciaAsignar.setmes_descripcion(detalletransferencia.getmes_descripcion());	
		detalletransferenciaAsignar.setid_bodega(detalletransferencia.getid_bodega());
		detalletransferenciaAsignar.setbodega_descripcion(detalletransferencia.getbodega_descripcion());	
		detalletransferenciaAsignar.setid_producto(detalletransferencia.getid_producto());
		detalletransferenciaAsignar.setproducto_descripcion(detalletransferencia.getproducto_descripcion());	
		detalletransferenciaAsignar.setid_unidad(detalletransferencia.getid_unidad());
		detalletransferenciaAsignar.setunidad_descripcion(detalletransferencia.getunidad_descripcion());	
		detalletransferenciaAsignar.setid_bodega_enviar(detalletransferencia.getid_bodega_enviar());
		detalletransferenciaAsignar.setbodegaenviar_descripcion(detalletransferencia.getbodegaenviar_descripcion());	
		detalletransferenciaAsignar.setdescripcion(detalletransferencia.getdescripcion());	
		detalletransferenciaAsignar.setid_novedad_producto(detalletransferencia.getid_novedad_producto());
		detalletransferenciaAsignar.setnovedadproducto_descripcion(detalletransferencia.getnovedadproducto_descripcion());	
		detalletransferenciaAsignar.setid_estado_detalle_inventario(detalletransferencia.getid_estado_detalle_inventario());
		detalletransferenciaAsignar.setestadodetalleinventario_descripcion(detalletransferencia.getestadodetalleinventario_descripcion());	
		detalletransferenciaAsignar.setcantidad(detalletransferencia.getcantidad());	
		detalletransferenciaAsignar.setdescuento(detalletransferencia.getdescuento());	
		detalletransferenciaAsignar.setcosto_unitario(detalletransferencia.getcosto_unitario());	
		detalletransferenciaAsignar.setcosto_total(detalletransferencia.getcosto_total());	
		detalletransferenciaAsignar.setdisponible(detalletransferencia.getdisponible());	
		detalletransferenciaAsignar.setlote(detalletransferencia.getlote());	
		detalletransferenciaAsignar.setfecha_elaboracion_lote(detalletransferencia.getfecha_elaboracion_lote());	
		detalletransferenciaAsignar.setfecha_caducidad_lote(detalletransferencia.getfecha_caducidad_lote());	
		detalletransferenciaAsignar.setnumero_comprobante(detalletransferencia.getnumero_comprobante());	
		detalletransferenciaAsignar.setlote_cliente(detalletransferencia.getlote_cliente());	
	}
	
	public static void inicializarDetalleTransferencia(DetalleTransferencia detalletransferencia) throws Exception {
		try {
				detalletransferencia.setId(0L);	
					
				detalletransferencia.setid_transferencia(-1L);	
				detalletransferencia.setid_empresa(-1L);	
				detalletransferencia.setid_sucursal(-1L);	
				detalletransferencia.setid_ejercicio(-1L);	
				detalletransferencia.setid_periodo(-1L);	
				detalletransferencia.setid_anio(null);	
				detalletransferencia.setid_mes(null);	
				detalletransferencia.setid_bodega(-1L);	
				detalletransferencia.setid_producto(-1L);	
				detalletransferencia.setid_unidad(-1L);	
				detalletransferencia.setid_bodega_enviar(-1L);	
				detalletransferencia.setdescripcion("");	
				detalletransferencia.setid_novedad_producto(null);	
				detalletransferencia.setid_estado_detalle_inventario(-1L);	
				detalletransferencia.setcantidad(0);	
				detalletransferencia.setdescuento(0.0);	
				detalletransferencia.setcosto_unitario(0.0);	
				detalletransferencia.setcosto_total(0.0);	
				detalletransferencia.setdisponible(0);	
				detalletransferencia.setlote("");	
				detalletransferencia.setfecha_elaboracion_lote(new Date());	
				detalletransferencia.setfecha_caducidad_lote(new Date());	
				detalletransferencia.setnumero_comprobante("");	
				detalletransferencia.setlote_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleTransferencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDTRANSFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDBODEGAENVIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_IDESTADODETALLEINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_FECHAELABORACIONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_FECHACADUCIDADLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTransferenciaConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleTransferencia(String sTipo,Row row,Workbook workbook,DetalleTransferencia detalletransferencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.gettransferencia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getbodegaenviar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getestadodetalleinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getfecha_elaboracion_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getfecha_caducidad_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletransferencia.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleTransferencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleTransferencia() {
		return this.sFinalQueryDetalleTransferencia;
	}
	
	public void setsFinalQueryDetalleTransferencia(String sFinalQueryDetalleTransferencia) {
		this.sFinalQueryDetalleTransferencia= sFinalQueryDetalleTransferencia;
	}
	
	public Border resaltarSeleccionarDetalleTransferencia=null;
	
	public Border setResaltarSeleccionarDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleTransferencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleTransferencia() {
		return this.resaltarSeleccionarDetalleTransferencia;
	}
	
	public void setResaltarSeleccionarDetalleTransferencia(Border borderResaltarSeleccionarDetalleTransferencia) {
		this.resaltarSeleccionarDetalleTransferencia= borderResaltarSeleccionarDetalleTransferencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleTransferencia=null;
	public Boolean mostraridDetalleTransferencia=true;
	public Boolean activaridDetalleTransferencia=true;

	public Border resaltarid_transferenciaDetalleTransferencia=null;
	public Boolean mostrarid_transferenciaDetalleTransferencia=true;
	public Boolean activarid_transferenciaDetalleTransferencia=true;
	public Boolean cargarid_transferenciaDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transferenciaDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleTransferencia=null;
	public Boolean mostrarid_empresaDetalleTransferencia=true;
	public Boolean activarid_empresaDetalleTransferencia=true;
	public Boolean cargarid_empresaDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleTransferencia=null;
	public Boolean mostrarid_sucursalDetalleTransferencia=true;
	public Boolean activarid_sucursalDetalleTransferencia=true;
	public Boolean cargarid_sucursalDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleTransferencia=null;
	public Boolean mostrarid_ejercicioDetalleTransferencia=true;
	public Boolean activarid_ejercicioDetalleTransferencia=true;
	public Boolean cargarid_ejercicioDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleTransferencia=null;
	public Boolean mostrarid_periodoDetalleTransferencia=true;
	public Boolean activarid_periodoDetalleTransferencia=true;
	public Boolean cargarid_periodoDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleTransferencia=null;
	public Boolean mostrarid_anioDetalleTransferencia=true;
	public Boolean activarid_anioDetalleTransferencia=false;
	public Boolean cargarid_anioDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleTransferencia=null;
	public Boolean mostrarid_mesDetalleTransferencia=true;
	public Boolean activarid_mesDetalleTransferencia=false;
	public Boolean cargarid_mesDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleTransferencia=null;
	public Boolean mostrarid_bodegaDetalleTransferencia=true;
	public Boolean activarid_bodegaDetalleTransferencia=true;
	public Boolean cargarid_bodegaDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleTransferencia=null;
	public Boolean mostrarid_productoDetalleTransferencia=true;
	public Boolean activarid_productoDetalleTransferencia=true;
	public Boolean cargarid_productoDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleTransferencia=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleTransferencia=null;
	public Boolean mostrarid_unidadDetalleTransferencia=true;
	public Boolean activarid_unidadDetalleTransferencia=true;
	public Boolean cargarid_unidadDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleTransferencia=true;//ConEventDepend=true

	public Border resaltarid_bodega_enviarDetalleTransferencia=null;
	public Boolean mostrarid_bodega_enviarDetalleTransferencia=true;
	public Boolean activarid_bodega_enviarDetalleTransferencia=true;
	public Boolean cargarid_bodega_enviarDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_enviarDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltardescripcionDetalleTransferencia=null;
	public Boolean mostrardescripcionDetalleTransferencia=true;
	public Boolean activardescripcionDetalleTransferencia=true;

	public Border resaltarid_novedad_productoDetalleTransferencia=null;
	public Boolean mostrarid_novedad_productoDetalleTransferencia=true;
	public Boolean activarid_novedad_productoDetalleTransferencia=true;
	public Boolean cargarid_novedad_productoDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_inventarioDetalleTransferencia=null;
	public Boolean mostrarid_estado_detalle_inventarioDetalleTransferencia=true;
	public Boolean activarid_estado_detalle_inventarioDetalleTransferencia=false;
	public Boolean cargarid_estado_detalle_inventarioDetalleTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_inventarioDetalleTransferencia=false;//ConEventDepend=true

	public Border resaltarcantidadDetalleTransferencia=null;
	public Boolean mostrarcantidadDetalleTransferencia=true;
	public Boolean activarcantidadDetalleTransferencia=true;

	public Border resaltardescuentoDetalleTransferencia=null;
	public Boolean mostrardescuentoDetalleTransferencia=true;
	public Boolean activardescuentoDetalleTransferencia=false;

	public Border resaltarcosto_unitarioDetalleTransferencia=null;
	public Boolean mostrarcosto_unitarioDetalleTransferencia=true;
	public Boolean activarcosto_unitarioDetalleTransferencia=true;

	public Border resaltarcosto_totalDetalleTransferencia=null;
	public Boolean mostrarcosto_totalDetalleTransferencia=true;
	public Boolean activarcosto_totalDetalleTransferencia=true;

	public Border resaltardisponibleDetalleTransferencia=null;
	public Boolean mostrardisponibleDetalleTransferencia=true;
	public Boolean activardisponibleDetalleTransferencia=true;

	public Border resaltarloteDetalleTransferencia=null;
	public Boolean mostrarloteDetalleTransferencia=true;
	public Boolean activarloteDetalleTransferencia=true;

	public Border resaltarfecha_elaboracion_loteDetalleTransferencia=null;
	public Boolean mostrarfecha_elaboracion_loteDetalleTransferencia=true;
	public Boolean activarfecha_elaboracion_loteDetalleTransferencia=false;

	public Border resaltarfecha_caducidad_loteDetalleTransferencia=null;
	public Boolean mostrarfecha_caducidad_loteDetalleTransferencia=true;
	public Boolean activarfecha_caducidad_loteDetalleTransferencia=false;

	public Border resaltarnumero_comprobanteDetalleTransferencia=null;
	public Boolean mostrarnumero_comprobanteDetalleTransferencia=true;
	public Boolean activarnumero_comprobanteDetalleTransferencia=false;

	public Border resaltarlote_clienteDetalleTransferencia=null;
	public Boolean mostrarlote_clienteDetalleTransferencia=true;
	public Boolean activarlote_clienteDetalleTransferencia=false;

	
	

	public Border setResaltaridDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleTransferencia() {
		return this.resaltaridDetalleTransferencia;
	}

	public void setResaltaridDetalleTransferencia(Border borderResaltar) {
		this.resaltaridDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostraridDetalleTransferencia() {
		return this.mostraridDetalleTransferencia;
	}

	public void setMostraridDetalleTransferencia(Boolean mostraridDetalleTransferencia) {
		this.mostraridDetalleTransferencia= mostraridDetalleTransferencia;
	}

	public Boolean getActivaridDetalleTransferencia() {
		return this.activaridDetalleTransferencia;
	}

	public void setActivaridDetalleTransferencia(Boolean activaridDetalleTransferencia) {
		this.activaridDetalleTransferencia= activaridDetalleTransferencia;
	}

	public Border setResaltarid_transferenciaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_transferenciaDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transferenciaDetalleTransferencia() {
		return this.resaltarid_transferenciaDetalleTransferencia;
	}

	public void setResaltarid_transferenciaDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_transferenciaDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_transferenciaDetalleTransferencia() {
		return this.mostrarid_transferenciaDetalleTransferencia;
	}

	public void setMostrarid_transferenciaDetalleTransferencia(Boolean mostrarid_transferenciaDetalleTransferencia) {
		this.mostrarid_transferenciaDetalleTransferencia= mostrarid_transferenciaDetalleTransferencia;
	}

	public Boolean getActivarid_transferenciaDetalleTransferencia() {
		return this.activarid_transferenciaDetalleTransferencia;
	}

	public void setActivarid_transferenciaDetalleTransferencia(Boolean activarid_transferenciaDetalleTransferencia) {
		this.activarid_transferenciaDetalleTransferencia= activarid_transferenciaDetalleTransferencia;
	}

	public Boolean getCargarid_transferenciaDetalleTransferencia() {
		return this.cargarid_transferenciaDetalleTransferencia;
	}

	public void setCargarid_transferenciaDetalleTransferencia(Boolean cargarid_transferenciaDetalleTransferencia) {
		this.cargarid_transferenciaDetalleTransferencia= cargarid_transferenciaDetalleTransferencia;
	}

	public Border setResaltarid_empresaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleTransferencia() {
		return this.resaltarid_empresaDetalleTransferencia;
	}

	public void setResaltarid_empresaDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_empresaDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleTransferencia() {
		return this.mostrarid_empresaDetalleTransferencia;
	}

	public void setMostrarid_empresaDetalleTransferencia(Boolean mostrarid_empresaDetalleTransferencia) {
		this.mostrarid_empresaDetalleTransferencia= mostrarid_empresaDetalleTransferencia;
	}

	public Boolean getActivarid_empresaDetalleTransferencia() {
		return this.activarid_empresaDetalleTransferencia;
	}

	public void setActivarid_empresaDetalleTransferencia(Boolean activarid_empresaDetalleTransferencia) {
		this.activarid_empresaDetalleTransferencia= activarid_empresaDetalleTransferencia;
	}

	public Boolean getCargarid_empresaDetalleTransferencia() {
		return this.cargarid_empresaDetalleTransferencia;
	}

	public void setCargarid_empresaDetalleTransferencia(Boolean cargarid_empresaDetalleTransferencia) {
		this.cargarid_empresaDetalleTransferencia= cargarid_empresaDetalleTransferencia;
	}

	public Border setResaltarid_sucursalDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleTransferencia() {
		return this.resaltarid_sucursalDetalleTransferencia;
	}

	public void setResaltarid_sucursalDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_sucursalDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleTransferencia() {
		return this.mostrarid_sucursalDetalleTransferencia;
	}

	public void setMostrarid_sucursalDetalleTransferencia(Boolean mostrarid_sucursalDetalleTransferencia) {
		this.mostrarid_sucursalDetalleTransferencia= mostrarid_sucursalDetalleTransferencia;
	}

	public Boolean getActivarid_sucursalDetalleTransferencia() {
		return this.activarid_sucursalDetalleTransferencia;
	}

	public void setActivarid_sucursalDetalleTransferencia(Boolean activarid_sucursalDetalleTransferencia) {
		this.activarid_sucursalDetalleTransferencia= activarid_sucursalDetalleTransferencia;
	}

	public Boolean getCargarid_sucursalDetalleTransferencia() {
		return this.cargarid_sucursalDetalleTransferencia;
	}

	public void setCargarid_sucursalDetalleTransferencia(Boolean cargarid_sucursalDetalleTransferencia) {
		this.cargarid_sucursalDetalleTransferencia= cargarid_sucursalDetalleTransferencia;
	}

	public Border setResaltarid_ejercicioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleTransferencia() {
		return this.resaltarid_ejercicioDetalleTransferencia;
	}

	public void setResaltarid_ejercicioDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleTransferencia() {
		return this.mostrarid_ejercicioDetalleTransferencia;
	}

	public void setMostrarid_ejercicioDetalleTransferencia(Boolean mostrarid_ejercicioDetalleTransferencia) {
		this.mostrarid_ejercicioDetalleTransferencia= mostrarid_ejercicioDetalleTransferencia;
	}

	public Boolean getActivarid_ejercicioDetalleTransferencia() {
		return this.activarid_ejercicioDetalleTransferencia;
	}

	public void setActivarid_ejercicioDetalleTransferencia(Boolean activarid_ejercicioDetalleTransferencia) {
		this.activarid_ejercicioDetalleTransferencia= activarid_ejercicioDetalleTransferencia;
	}

	public Boolean getCargarid_ejercicioDetalleTransferencia() {
		return this.cargarid_ejercicioDetalleTransferencia;
	}

	public void setCargarid_ejercicioDetalleTransferencia(Boolean cargarid_ejercicioDetalleTransferencia) {
		this.cargarid_ejercicioDetalleTransferencia= cargarid_ejercicioDetalleTransferencia;
	}

	public Border setResaltarid_periodoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleTransferencia() {
		return this.resaltarid_periodoDetalleTransferencia;
	}

	public void setResaltarid_periodoDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_periodoDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleTransferencia() {
		return this.mostrarid_periodoDetalleTransferencia;
	}

	public void setMostrarid_periodoDetalleTransferencia(Boolean mostrarid_periodoDetalleTransferencia) {
		this.mostrarid_periodoDetalleTransferencia= mostrarid_periodoDetalleTransferencia;
	}

	public Boolean getActivarid_periodoDetalleTransferencia() {
		return this.activarid_periodoDetalleTransferencia;
	}

	public void setActivarid_periodoDetalleTransferencia(Boolean activarid_periodoDetalleTransferencia) {
		this.activarid_periodoDetalleTransferencia= activarid_periodoDetalleTransferencia;
	}

	public Boolean getCargarid_periodoDetalleTransferencia() {
		return this.cargarid_periodoDetalleTransferencia;
	}

	public void setCargarid_periodoDetalleTransferencia(Boolean cargarid_periodoDetalleTransferencia) {
		this.cargarid_periodoDetalleTransferencia= cargarid_periodoDetalleTransferencia;
	}

	public Border setResaltarid_anioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleTransferencia() {
		return this.resaltarid_anioDetalleTransferencia;
	}

	public void setResaltarid_anioDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_anioDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleTransferencia() {
		return this.mostrarid_anioDetalleTransferencia;
	}

	public void setMostrarid_anioDetalleTransferencia(Boolean mostrarid_anioDetalleTransferencia) {
		this.mostrarid_anioDetalleTransferencia= mostrarid_anioDetalleTransferencia;
	}

	public Boolean getActivarid_anioDetalleTransferencia() {
		return this.activarid_anioDetalleTransferencia;
	}

	public void setActivarid_anioDetalleTransferencia(Boolean activarid_anioDetalleTransferencia) {
		this.activarid_anioDetalleTransferencia= activarid_anioDetalleTransferencia;
	}

	public Boolean getCargarid_anioDetalleTransferencia() {
		return this.cargarid_anioDetalleTransferencia;
	}

	public void setCargarid_anioDetalleTransferencia(Boolean cargarid_anioDetalleTransferencia) {
		this.cargarid_anioDetalleTransferencia= cargarid_anioDetalleTransferencia;
	}

	public Border setResaltarid_mesDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleTransferencia() {
		return this.resaltarid_mesDetalleTransferencia;
	}

	public void setResaltarid_mesDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_mesDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleTransferencia() {
		return this.mostrarid_mesDetalleTransferencia;
	}

	public void setMostrarid_mesDetalleTransferencia(Boolean mostrarid_mesDetalleTransferencia) {
		this.mostrarid_mesDetalleTransferencia= mostrarid_mesDetalleTransferencia;
	}

	public Boolean getActivarid_mesDetalleTransferencia() {
		return this.activarid_mesDetalleTransferencia;
	}

	public void setActivarid_mesDetalleTransferencia(Boolean activarid_mesDetalleTransferencia) {
		this.activarid_mesDetalleTransferencia= activarid_mesDetalleTransferencia;
	}

	public Boolean getCargarid_mesDetalleTransferencia() {
		return this.cargarid_mesDetalleTransferencia;
	}

	public void setCargarid_mesDetalleTransferencia(Boolean cargarid_mesDetalleTransferencia) {
		this.cargarid_mesDetalleTransferencia= cargarid_mesDetalleTransferencia;
	}

	public Border setResaltarid_bodegaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_bodegaDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleTransferencia() {
		return this.resaltarid_bodegaDetalleTransferencia;
	}

	public void setResaltarid_bodegaDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_bodegaDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleTransferencia() {
		return this.mostrarid_bodegaDetalleTransferencia;
	}

	public void setMostrarid_bodegaDetalleTransferencia(Boolean mostrarid_bodegaDetalleTransferencia) {
		this.mostrarid_bodegaDetalleTransferencia= mostrarid_bodegaDetalleTransferencia;
	}

	public Boolean getActivarid_bodegaDetalleTransferencia() {
		return this.activarid_bodegaDetalleTransferencia;
	}

	public void setActivarid_bodegaDetalleTransferencia(Boolean activarid_bodegaDetalleTransferencia) {
		this.activarid_bodegaDetalleTransferencia= activarid_bodegaDetalleTransferencia;
	}

	public Boolean getCargarid_bodegaDetalleTransferencia() {
		return this.cargarid_bodegaDetalleTransferencia;
	}

	public void setCargarid_bodegaDetalleTransferencia(Boolean cargarid_bodegaDetalleTransferencia) {
		this.cargarid_bodegaDetalleTransferencia= cargarid_bodegaDetalleTransferencia;
	}

	public Border setResaltarid_productoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_productoDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleTransferencia() {
		return this.resaltarid_productoDetalleTransferencia;
	}

	public void setResaltarid_productoDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_productoDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleTransferencia() {
		return this.mostrarid_productoDetalleTransferencia;
	}

	public void setMostrarid_productoDetalleTransferencia(Boolean mostrarid_productoDetalleTransferencia) {
		this.mostrarid_productoDetalleTransferencia= mostrarid_productoDetalleTransferencia;
	}

	public Boolean getActivarid_productoDetalleTransferencia() {
		return this.activarid_productoDetalleTransferencia;
	}

	public void setActivarid_productoDetalleTransferencia(Boolean activarid_productoDetalleTransferencia) {
		this.activarid_productoDetalleTransferencia= activarid_productoDetalleTransferencia;
	}

	public Boolean getCargarid_productoDetalleTransferencia() {
		return this.cargarid_productoDetalleTransferencia;
	}

	public void setCargarid_productoDetalleTransferencia(Boolean cargarid_productoDetalleTransferencia) {
		this.cargarid_productoDetalleTransferencia= cargarid_productoDetalleTransferencia;
	}

	public Border setResaltarid_unidadDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_unidadDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleTransferencia() {
		return this.resaltarid_unidadDetalleTransferencia;
	}

	public void setResaltarid_unidadDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_unidadDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleTransferencia() {
		return this.mostrarid_unidadDetalleTransferencia;
	}

	public void setMostrarid_unidadDetalleTransferencia(Boolean mostrarid_unidadDetalleTransferencia) {
		this.mostrarid_unidadDetalleTransferencia= mostrarid_unidadDetalleTransferencia;
	}

	public Boolean getActivarid_unidadDetalleTransferencia() {
		return this.activarid_unidadDetalleTransferencia;
	}

	public void setActivarid_unidadDetalleTransferencia(Boolean activarid_unidadDetalleTransferencia) {
		this.activarid_unidadDetalleTransferencia= activarid_unidadDetalleTransferencia;
	}

	public Boolean getCargarid_unidadDetalleTransferencia() {
		return this.cargarid_unidadDetalleTransferencia;
	}

	public void setCargarid_unidadDetalleTransferencia(Boolean cargarid_unidadDetalleTransferencia) {
		this.cargarid_unidadDetalleTransferencia= cargarid_unidadDetalleTransferencia;
	}

	public Border setResaltarid_bodega_enviarDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_bodega_enviarDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_enviarDetalleTransferencia() {
		return this.resaltarid_bodega_enviarDetalleTransferencia;
	}

	public void setResaltarid_bodega_enviarDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_bodega_enviarDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_bodega_enviarDetalleTransferencia() {
		return this.mostrarid_bodega_enviarDetalleTransferencia;
	}

	public void setMostrarid_bodega_enviarDetalleTransferencia(Boolean mostrarid_bodega_enviarDetalleTransferencia) {
		this.mostrarid_bodega_enviarDetalleTransferencia= mostrarid_bodega_enviarDetalleTransferencia;
	}

	public Boolean getActivarid_bodega_enviarDetalleTransferencia() {
		return this.activarid_bodega_enviarDetalleTransferencia;
	}

	public void setActivarid_bodega_enviarDetalleTransferencia(Boolean activarid_bodega_enviarDetalleTransferencia) {
		this.activarid_bodega_enviarDetalleTransferencia= activarid_bodega_enviarDetalleTransferencia;
	}

	public Boolean getCargarid_bodega_enviarDetalleTransferencia() {
		return this.cargarid_bodega_enviarDetalleTransferencia;
	}

	public void setCargarid_bodega_enviarDetalleTransferencia(Boolean cargarid_bodega_enviarDetalleTransferencia) {
		this.cargarid_bodega_enviarDetalleTransferencia= cargarid_bodega_enviarDetalleTransferencia;
	}

	public Border setResaltardescripcionDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltardescripcionDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleTransferencia() {
		return this.resaltardescripcionDetalleTransferencia;
	}

	public void setResaltardescripcionDetalleTransferencia(Border borderResaltar) {
		this.resaltardescripcionDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleTransferencia() {
		return this.mostrardescripcionDetalleTransferencia;
	}

	public void setMostrardescripcionDetalleTransferencia(Boolean mostrardescripcionDetalleTransferencia) {
		this.mostrardescripcionDetalleTransferencia= mostrardescripcionDetalleTransferencia;
	}

	public Boolean getActivardescripcionDetalleTransferencia() {
		return this.activardescripcionDetalleTransferencia;
	}

	public void setActivardescripcionDetalleTransferencia(Boolean activardescripcionDetalleTransferencia) {
		this.activardescripcionDetalleTransferencia= activardescripcionDetalleTransferencia;
	}

	public Border setResaltarid_novedad_productoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_novedad_productoDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoDetalleTransferencia() {
		return this.resaltarid_novedad_productoDetalleTransferencia;
	}

	public void setResaltarid_novedad_productoDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_novedad_productoDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoDetalleTransferencia() {
		return this.mostrarid_novedad_productoDetalleTransferencia;
	}

	public void setMostrarid_novedad_productoDetalleTransferencia(Boolean mostrarid_novedad_productoDetalleTransferencia) {
		this.mostrarid_novedad_productoDetalleTransferencia= mostrarid_novedad_productoDetalleTransferencia;
	}

	public Boolean getActivarid_novedad_productoDetalleTransferencia() {
		return this.activarid_novedad_productoDetalleTransferencia;
	}

	public void setActivarid_novedad_productoDetalleTransferencia(Boolean activarid_novedad_productoDetalleTransferencia) {
		this.activarid_novedad_productoDetalleTransferencia= activarid_novedad_productoDetalleTransferencia;
	}

	public Boolean getCargarid_novedad_productoDetalleTransferencia() {
		return this.cargarid_novedad_productoDetalleTransferencia;
	}

	public void setCargarid_novedad_productoDetalleTransferencia(Boolean cargarid_novedad_productoDetalleTransferencia) {
		this.cargarid_novedad_productoDetalleTransferencia= cargarid_novedad_productoDetalleTransferencia;
	}

	public Border setResaltarid_estado_detalle_inventarioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_detalle_inventarioDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_inventarioDetalleTransferencia() {
		return this.resaltarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public void setResaltarid_estado_detalle_inventarioDetalleTransferencia(Border borderResaltar) {
		this.resaltarid_estado_detalle_inventarioDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_inventarioDetalleTransferencia() {
		return this.mostrarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public void setMostrarid_estado_detalle_inventarioDetalleTransferencia(Boolean mostrarid_estado_detalle_inventarioDetalleTransferencia) {
		this.mostrarid_estado_detalle_inventarioDetalleTransferencia= mostrarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public Boolean getActivarid_estado_detalle_inventarioDetalleTransferencia() {
		return this.activarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public void setActivarid_estado_detalle_inventarioDetalleTransferencia(Boolean activarid_estado_detalle_inventarioDetalleTransferencia) {
		this.activarid_estado_detalle_inventarioDetalleTransferencia= activarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public Boolean getCargarid_estado_detalle_inventarioDetalleTransferencia() {
		return this.cargarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public void setCargarid_estado_detalle_inventarioDetalleTransferencia(Boolean cargarid_estado_detalle_inventarioDetalleTransferencia) {
		this.cargarid_estado_detalle_inventarioDetalleTransferencia= cargarid_estado_detalle_inventarioDetalleTransferencia;
	}

	public Border setResaltarcantidadDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarcantidadDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleTransferencia() {
		return this.resaltarcantidadDetalleTransferencia;
	}

	public void setResaltarcantidadDetalleTransferencia(Border borderResaltar) {
		this.resaltarcantidadDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleTransferencia() {
		return this.mostrarcantidadDetalleTransferencia;
	}

	public void setMostrarcantidadDetalleTransferencia(Boolean mostrarcantidadDetalleTransferencia) {
		this.mostrarcantidadDetalleTransferencia= mostrarcantidadDetalleTransferencia;
	}

	public Boolean getActivarcantidadDetalleTransferencia() {
		return this.activarcantidadDetalleTransferencia;
	}

	public void setActivarcantidadDetalleTransferencia(Boolean activarcantidadDetalleTransferencia) {
		this.activarcantidadDetalleTransferencia= activarcantidadDetalleTransferencia;
	}

	public Border setResaltardescuentoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltardescuentoDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleTransferencia() {
		return this.resaltardescuentoDetalleTransferencia;
	}

	public void setResaltardescuentoDetalleTransferencia(Border borderResaltar) {
		this.resaltardescuentoDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleTransferencia() {
		return this.mostrardescuentoDetalleTransferencia;
	}

	public void setMostrardescuentoDetalleTransferencia(Boolean mostrardescuentoDetalleTransferencia) {
		this.mostrardescuentoDetalleTransferencia= mostrardescuentoDetalleTransferencia;
	}

	public Boolean getActivardescuentoDetalleTransferencia() {
		return this.activardescuentoDetalleTransferencia;
	}

	public void setActivardescuentoDetalleTransferencia(Boolean activardescuentoDetalleTransferencia) {
		this.activardescuentoDetalleTransferencia= activardescuentoDetalleTransferencia;
	}

	public Border setResaltarcosto_unitarioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarcosto_unitarioDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioDetalleTransferencia() {
		return this.resaltarcosto_unitarioDetalleTransferencia;
	}

	public void setResaltarcosto_unitarioDetalleTransferencia(Border borderResaltar) {
		this.resaltarcosto_unitarioDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioDetalleTransferencia() {
		return this.mostrarcosto_unitarioDetalleTransferencia;
	}

	public void setMostrarcosto_unitarioDetalleTransferencia(Boolean mostrarcosto_unitarioDetalleTransferencia) {
		this.mostrarcosto_unitarioDetalleTransferencia= mostrarcosto_unitarioDetalleTransferencia;
	}

	public Boolean getActivarcosto_unitarioDetalleTransferencia() {
		return this.activarcosto_unitarioDetalleTransferencia;
	}

	public void setActivarcosto_unitarioDetalleTransferencia(Boolean activarcosto_unitarioDetalleTransferencia) {
		this.activarcosto_unitarioDetalleTransferencia= activarcosto_unitarioDetalleTransferencia;
	}

	public Border setResaltarcosto_totalDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarcosto_totalDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalDetalleTransferencia() {
		return this.resaltarcosto_totalDetalleTransferencia;
	}

	public void setResaltarcosto_totalDetalleTransferencia(Border borderResaltar) {
		this.resaltarcosto_totalDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarcosto_totalDetalleTransferencia() {
		return this.mostrarcosto_totalDetalleTransferencia;
	}

	public void setMostrarcosto_totalDetalleTransferencia(Boolean mostrarcosto_totalDetalleTransferencia) {
		this.mostrarcosto_totalDetalleTransferencia= mostrarcosto_totalDetalleTransferencia;
	}

	public Boolean getActivarcosto_totalDetalleTransferencia() {
		return this.activarcosto_totalDetalleTransferencia;
	}

	public void setActivarcosto_totalDetalleTransferencia(Boolean activarcosto_totalDetalleTransferencia) {
		this.activarcosto_totalDetalleTransferencia= activarcosto_totalDetalleTransferencia;
	}

	public Border setResaltardisponibleDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltardisponibleDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleDetalleTransferencia() {
		return this.resaltardisponibleDetalleTransferencia;
	}

	public void setResaltardisponibleDetalleTransferencia(Border borderResaltar) {
		this.resaltardisponibleDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrardisponibleDetalleTransferencia() {
		return this.mostrardisponibleDetalleTransferencia;
	}

	public void setMostrardisponibleDetalleTransferencia(Boolean mostrardisponibleDetalleTransferencia) {
		this.mostrardisponibleDetalleTransferencia= mostrardisponibleDetalleTransferencia;
	}

	public Boolean getActivardisponibleDetalleTransferencia() {
		return this.activardisponibleDetalleTransferencia;
	}

	public void setActivardisponibleDetalleTransferencia(Boolean activardisponibleDetalleTransferencia) {
		this.activardisponibleDetalleTransferencia= activardisponibleDetalleTransferencia;
	}

	public Border setResaltarloteDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarloteDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleTransferencia() {
		return this.resaltarloteDetalleTransferencia;
	}

	public void setResaltarloteDetalleTransferencia(Border borderResaltar) {
		this.resaltarloteDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarloteDetalleTransferencia() {
		return this.mostrarloteDetalleTransferencia;
	}

	public void setMostrarloteDetalleTransferencia(Boolean mostrarloteDetalleTransferencia) {
		this.mostrarloteDetalleTransferencia= mostrarloteDetalleTransferencia;
	}

	public Boolean getActivarloteDetalleTransferencia() {
		return this.activarloteDetalleTransferencia;
	}

	public void setActivarloteDetalleTransferencia(Boolean activarloteDetalleTransferencia) {
		this.activarloteDetalleTransferencia= activarloteDetalleTransferencia;
	}

	public Border setResaltarfecha_elaboracion_loteDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarfecha_elaboracion_loteDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_elaboracion_loteDetalleTransferencia() {
		return this.resaltarfecha_elaboracion_loteDetalleTransferencia;
	}

	public void setResaltarfecha_elaboracion_loteDetalleTransferencia(Border borderResaltar) {
		this.resaltarfecha_elaboracion_loteDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarfecha_elaboracion_loteDetalleTransferencia() {
		return this.mostrarfecha_elaboracion_loteDetalleTransferencia;
	}

	public void setMostrarfecha_elaboracion_loteDetalleTransferencia(Boolean mostrarfecha_elaboracion_loteDetalleTransferencia) {
		this.mostrarfecha_elaboracion_loteDetalleTransferencia= mostrarfecha_elaboracion_loteDetalleTransferencia;
	}

	public Boolean getActivarfecha_elaboracion_loteDetalleTransferencia() {
		return this.activarfecha_elaboracion_loteDetalleTransferencia;
	}

	public void setActivarfecha_elaboracion_loteDetalleTransferencia(Boolean activarfecha_elaboracion_loteDetalleTransferencia) {
		this.activarfecha_elaboracion_loteDetalleTransferencia= activarfecha_elaboracion_loteDetalleTransferencia;
	}

	public Border setResaltarfecha_caducidad_loteDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarfecha_caducidad_loteDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidad_loteDetalleTransferencia() {
		return this.resaltarfecha_caducidad_loteDetalleTransferencia;
	}

	public void setResaltarfecha_caducidad_loteDetalleTransferencia(Border borderResaltar) {
		this.resaltarfecha_caducidad_loteDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidad_loteDetalleTransferencia() {
		return this.mostrarfecha_caducidad_loteDetalleTransferencia;
	}

	public void setMostrarfecha_caducidad_loteDetalleTransferencia(Boolean mostrarfecha_caducidad_loteDetalleTransferencia) {
		this.mostrarfecha_caducidad_loteDetalleTransferencia= mostrarfecha_caducidad_loteDetalleTransferencia;
	}

	public Boolean getActivarfecha_caducidad_loteDetalleTransferencia() {
		return this.activarfecha_caducidad_loteDetalleTransferencia;
	}

	public void setActivarfecha_caducidad_loteDetalleTransferencia(Boolean activarfecha_caducidad_loteDetalleTransferencia) {
		this.activarfecha_caducidad_loteDetalleTransferencia= activarfecha_caducidad_loteDetalleTransferencia;
	}

	public Border setResaltarnumero_comprobanteDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleTransferencia() {
		return this.resaltarnumero_comprobanteDetalleTransferencia;
	}

	public void setResaltarnumero_comprobanteDetalleTransferencia(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleTransferencia() {
		return this.mostrarnumero_comprobanteDetalleTransferencia;
	}

	public void setMostrarnumero_comprobanteDetalleTransferencia(Boolean mostrarnumero_comprobanteDetalleTransferencia) {
		this.mostrarnumero_comprobanteDetalleTransferencia= mostrarnumero_comprobanteDetalleTransferencia;
	}

	public Boolean getActivarnumero_comprobanteDetalleTransferencia() {
		return this.activarnumero_comprobanteDetalleTransferencia;
	}

	public void setActivarnumero_comprobanteDetalleTransferencia(Boolean activarnumero_comprobanteDetalleTransferencia) {
		this.activarnumero_comprobanteDetalleTransferencia= activarnumero_comprobanteDetalleTransferencia;
	}

	public Border setResaltarlote_clienteDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalletransferenciaBeanSwingJInternalFrame.jTtoolBarDetalleTransferencia.setBorder(borderResaltar);
		*/
		this.resaltarlote_clienteDetalleTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleTransferencia() {
		return this.resaltarlote_clienteDetalleTransferencia;
	}

	public void setResaltarlote_clienteDetalleTransferencia(Border borderResaltar) {
		this.resaltarlote_clienteDetalleTransferencia= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleTransferencia() {
		return this.mostrarlote_clienteDetalleTransferencia;
	}

	public void setMostrarlote_clienteDetalleTransferencia(Boolean mostrarlote_clienteDetalleTransferencia) {
		this.mostrarlote_clienteDetalleTransferencia= mostrarlote_clienteDetalleTransferencia;
	}

	public Boolean getActivarlote_clienteDetalleTransferencia() {
		return this.activarlote_clienteDetalleTransferencia;
	}

	public void setActivarlote_clienteDetalleTransferencia(Boolean activarlote_clienteDetalleTransferencia) {
		this.activarlote_clienteDetalleTransferencia= activarlote_clienteDetalleTransferencia;
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
		
		
		this.setMostraridDetalleTransferencia(esInicial);
		this.setMostrarid_transferenciaDetalleTransferencia(esInicial);
		this.setMostrarid_empresaDetalleTransferencia(esInicial);
		this.setMostrarid_sucursalDetalleTransferencia(esInicial);
		this.setMostrarid_ejercicioDetalleTransferencia(esInicial);
		this.setMostrarid_periodoDetalleTransferencia(esInicial);
		this.setMostrarid_anioDetalleTransferencia(esInicial);
		this.setMostrarid_mesDetalleTransferencia(esInicial);
		this.setMostrarid_bodegaDetalleTransferencia(esInicial);
		this.setMostrarid_productoDetalleTransferencia(esInicial);
		this.setMostrarid_unidadDetalleTransferencia(esInicial);
		this.setMostrarid_bodega_enviarDetalleTransferencia(esInicial);
		this.setMostrardescripcionDetalleTransferencia(esInicial);
		this.setMostrarid_novedad_productoDetalleTransferencia(esInicial);
		this.setMostrarid_estado_detalle_inventarioDetalleTransferencia(esInicial);
		this.setMostrarcantidadDetalleTransferencia(esInicial);
		this.setMostrardescuentoDetalleTransferencia(esInicial);
		this.setMostrarcosto_unitarioDetalleTransferencia(esInicial);
		this.setMostrarcosto_totalDetalleTransferencia(esInicial);
		this.setMostrardisponibleDetalleTransferencia(esInicial);
		this.setMostrarloteDetalleTransferencia(esInicial);
		this.setMostrarfecha_elaboracion_loteDetalleTransferencia(esInicial);
		this.setMostrarfecha_caducidad_loteDetalleTransferencia(esInicial);
		this.setMostrarnumero_comprobanteDetalleTransferencia(esInicial);
		this.setMostrarlote_clienteDetalleTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.ID)) {
				this.setMostraridDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA)) {
				this.setMostrarid_transferenciaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR)) {
				this.setMostrarid_bodega_enviarDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setMostrarid_estado_detalle_inventarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setMostrarfecha_elaboracion_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setMostrarfecha_caducidad_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleTransferencia(esAsigna);
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
		
		
		this.setActivaridDetalleTransferencia(esInicial);
		this.setActivarid_transferenciaDetalleTransferencia(esInicial);
		this.setActivarid_empresaDetalleTransferencia(esInicial);
		this.setActivarid_sucursalDetalleTransferencia(esInicial);
		this.setActivarid_ejercicioDetalleTransferencia(esInicial);
		this.setActivarid_periodoDetalleTransferencia(esInicial);
		this.setActivarid_anioDetalleTransferencia(esInicial);
		this.setActivarid_mesDetalleTransferencia(esInicial);
		this.setActivarid_bodegaDetalleTransferencia(esInicial);
		this.setActivarid_productoDetalleTransferencia(esInicial);
		this.setActivarid_unidadDetalleTransferencia(esInicial);
		this.setActivarid_bodega_enviarDetalleTransferencia(esInicial);
		this.setActivardescripcionDetalleTransferencia(esInicial);
		this.setActivarid_novedad_productoDetalleTransferencia(esInicial);
		this.setActivarid_estado_detalle_inventarioDetalleTransferencia(esInicial);
		this.setActivarcantidadDetalleTransferencia(esInicial);
		this.setActivardescuentoDetalleTransferencia(esInicial);
		this.setActivarcosto_unitarioDetalleTransferencia(esInicial);
		this.setActivarcosto_totalDetalleTransferencia(esInicial);
		this.setActivardisponibleDetalleTransferencia(esInicial);
		this.setActivarloteDetalleTransferencia(esInicial);
		this.setActivarfecha_elaboracion_loteDetalleTransferencia(esInicial);
		this.setActivarfecha_caducidad_loteDetalleTransferencia(esInicial);
		this.setActivarnumero_comprobanteDetalleTransferencia(esInicial);
		this.setActivarlote_clienteDetalleTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.ID)) {
				this.setActivaridDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA)) {
				this.setActivarid_transferenciaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR)) {
				this.setActivarid_bodega_enviarDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setActivarid_estado_detalle_inventarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setActivarfecha_elaboracion_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setActivarfecha_caducidad_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleTransferencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleTransferencia(esInicial);
		this.setResaltarid_transferenciaDetalleTransferencia(esInicial);
		this.setResaltarid_empresaDetalleTransferencia(esInicial);
		this.setResaltarid_sucursalDetalleTransferencia(esInicial);
		this.setResaltarid_ejercicioDetalleTransferencia(esInicial);
		this.setResaltarid_periodoDetalleTransferencia(esInicial);
		this.setResaltarid_anioDetalleTransferencia(esInicial);
		this.setResaltarid_mesDetalleTransferencia(esInicial);
		this.setResaltarid_bodegaDetalleTransferencia(esInicial);
		this.setResaltarid_productoDetalleTransferencia(esInicial);
		this.setResaltarid_unidadDetalleTransferencia(esInicial);
		this.setResaltarid_bodega_enviarDetalleTransferencia(esInicial);
		this.setResaltardescripcionDetalleTransferencia(esInicial);
		this.setResaltarid_novedad_productoDetalleTransferencia(esInicial);
		this.setResaltarid_estado_detalle_inventarioDetalleTransferencia(esInicial);
		this.setResaltarcantidadDetalleTransferencia(esInicial);
		this.setResaltardescuentoDetalleTransferencia(esInicial);
		this.setResaltarcosto_unitarioDetalleTransferencia(esInicial);
		this.setResaltarcosto_totalDetalleTransferencia(esInicial);
		this.setResaltardisponibleDetalleTransferencia(esInicial);
		this.setResaltarloteDetalleTransferencia(esInicial);
		this.setResaltarfecha_elaboracion_loteDetalleTransferencia(esInicial);
		this.setResaltarfecha_caducidad_loteDetalleTransferencia(esInicial);
		this.setResaltarnumero_comprobanteDetalleTransferencia(esInicial);
		this.setResaltarlote_clienteDetalleTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.ID)) {
				this.setResaltaridDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDTRANSFERENCIA)) {
				this.setResaltarid_transferenciaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDBODEGAENVIAR)) {
				this.setResaltarid_bodega_enviarDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.IDESTADODETALLEINVENTARIO)) {
				this.setResaltarid_estado_detalle_inventarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHAELABORACIONLOTE)) {
				this.setResaltarfecha_elaboracion_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.FECHACADUCIDADLOTE)) {
				this.setResaltarfecha_caducidad_loteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTransferenciaConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleTransferencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleTransferencia=true;

	public Boolean getMostrarFK_IdBodegaDetalleTransferencia() {
		return this.mostrarFK_IdBodegaDetalleTransferencia;
	}

	public void setMostrarFK_IdBodegaDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaEnviarDetalleTransferencia=true;

	public Boolean getMostrarFK_IdBodegaEnviarDetalleTransferencia() {
		return this.mostrarFK_IdBodegaEnviarDetalleTransferencia;
	}

	public void setMostrarFK_IdBodegaEnviarDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaEnviarDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleTransferencia=true;

	public Boolean getMostrarFK_IdEjercicioDetalleTransferencia() {
		return this.mostrarFK_IdEjercicioDetalleTransferencia;
	}

	public void setMostrarFK_IdEjercicioDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleTransferencia=true;

	public Boolean getMostrarFK_IdEmpresaDetalleTransferencia() {
		return this.mostrarFK_IdEmpresaDetalleTransferencia;
	}

	public void setMostrarFK_IdEmpresaDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleInventarioDetalleTransferencia=true;

	public Boolean getMostrarFK_IdEstadoDetalleInventarioDetalleTransferencia() {
		return this.mostrarFK_IdEstadoDetalleInventarioDetalleTransferencia;
	}

	public void setMostrarFK_IdEstadoDetalleInventarioDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleInventarioDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoDetalleTransferencia=true;

	public Boolean getMostrarFK_IdNovedadProductoDetalleTransferencia() {
		return this.mostrarFK_IdNovedadProductoDetalleTransferencia;
	}

	public void setMostrarFK_IdNovedadProductoDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleTransferencia=true;

	public Boolean getMostrarFK_IdPeriodoDetalleTransferencia() {
		return this.mostrarFK_IdPeriodoDetalleTransferencia;
	}

	public void setMostrarFK_IdPeriodoDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleTransferencia=true;

	public Boolean getMostrarFK_IdProductoDetalleTransferencia() {
		return this.mostrarFK_IdProductoDetalleTransferencia;
	}

	public void setMostrarFK_IdProductoDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleTransferencia=true;

	public Boolean getMostrarFK_IdSucursalDetalleTransferencia() {
		return this.mostrarFK_IdSucursalDetalleTransferencia;
	}

	public void setMostrarFK_IdSucursalDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransferenciaDetalleTransferencia=true;

	public Boolean getMostrarFK_IdTransferenciaDetalleTransferencia() {
		return this.mostrarFK_IdTransferenciaDetalleTransferencia;
	}

	public void setMostrarFK_IdTransferenciaDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransferenciaDetalleTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleTransferencia=true;

	public Boolean getMostrarFK_IdUnidadDetalleTransferencia() {
		return this.mostrarFK_IdUnidadDetalleTransferencia;
	}

	public void setMostrarFK_IdUnidadDetalleTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleTransferencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleTransferencia=true;

	public Boolean getActivarFK_IdBodegaDetalleTransferencia() {
		return this.activarFK_IdBodegaDetalleTransferencia;
	}

	public void setActivarFK_IdBodegaDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaEnviarDetalleTransferencia=true;

	public Boolean getActivarFK_IdBodegaEnviarDetalleTransferencia() {
		return this.activarFK_IdBodegaEnviarDetalleTransferencia;
	}

	public void setActivarFK_IdBodegaEnviarDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaEnviarDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleTransferencia=true;

	public Boolean getActivarFK_IdEjercicioDetalleTransferencia() {
		return this.activarFK_IdEjercicioDetalleTransferencia;
	}

	public void setActivarFK_IdEjercicioDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleTransferencia=true;

	public Boolean getActivarFK_IdEmpresaDetalleTransferencia() {
		return this.activarFK_IdEmpresaDetalleTransferencia;
	}

	public void setActivarFK_IdEmpresaDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleInventarioDetalleTransferencia=true;

	public Boolean getActivarFK_IdEstadoDetalleInventarioDetalleTransferencia() {
		return this.activarFK_IdEstadoDetalleInventarioDetalleTransferencia;
	}

	public void setActivarFK_IdEstadoDetalleInventarioDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleInventarioDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoDetalleTransferencia=true;

	public Boolean getActivarFK_IdNovedadProductoDetalleTransferencia() {
		return this.activarFK_IdNovedadProductoDetalleTransferencia;
	}

	public void setActivarFK_IdNovedadProductoDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleTransferencia=true;

	public Boolean getActivarFK_IdPeriodoDetalleTransferencia() {
		return this.activarFK_IdPeriodoDetalleTransferencia;
	}

	public void setActivarFK_IdPeriodoDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleTransferencia=true;

	public Boolean getActivarFK_IdProductoDetalleTransferencia() {
		return this.activarFK_IdProductoDetalleTransferencia;
	}

	public void setActivarFK_IdProductoDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleTransferencia=true;

	public Boolean getActivarFK_IdSucursalDetalleTransferencia() {
		return this.activarFK_IdSucursalDetalleTransferencia;
	}

	public void setActivarFK_IdSucursalDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdTransferenciaDetalleTransferencia=true;

	public Boolean getActivarFK_IdTransferenciaDetalleTransferencia() {
		return this.activarFK_IdTransferenciaDetalleTransferencia;
	}

	public void setActivarFK_IdTransferenciaDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdTransferenciaDetalleTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleTransferencia=true;

	public Boolean getActivarFK_IdUnidadDetalleTransferencia() {
		return this.activarFK_IdUnidadDetalleTransferencia;
	}

	public void setActivarFK_IdUnidadDetalleTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleTransferencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleTransferencia=null;

	public Border getResaltarFK_IdBodegaDetalleTransferencia() {
		return this.resaltarFK_IdBodegaDetalleTransferencia;
	}

	public void setResaltarFK_IdBodegaDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdBodegaEnviarDetalleTransferencia=null;

	public Border getResaltarFK_IdBodegaEnviarDetalleTransferencia() {
		return this.resaltarFK_IdBodegaEnviarDetalleTransferencia;
	}

	public void setResaltarFK_IdBodegaEnviarDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdBodegaEnviarDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdBodegaEnviarDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaEnviarDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleTransferencia=null;

	public Border getResaltarFK_IdEjercicioDetalleTransferencia() {
		return this.resaltarFK_IdEjercicioDetalleTransferencia;
	}

	public void setResaltarFK_IdEjercicioDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleTransferencia=null;

	public Border getResaltarFK_IdEmpresaDetalleTransferencia() {
		return this.resaltarFK_IdEmpresaDetalleTransferencia;
	}

	public void setResaltarFK_IdEmpresaDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleInventarioDetalleTransferencia=null;

	public Border getResaltarFK_IdEstadoDetalleInventarioDetalleTransferencia() {
		return this.resaltarFK_IdEstadoDetalleInventarioDetalleTransferencia;
	}

	public void setResaltarFK_IdEstadoDetalleInventarioDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleInventarioDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleInventarioDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleInventarioDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoDetalleTransferencia=null;

	public Border getResaltarFK_IdNovedadProductoDetalleTransferencia() {
		return this.resaltarFK_IdNovedadProductoDetalleTransferencia;
	}

	public void setResaltarFK_IdNovedadProductoDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleTransferencia=null;

	public Border getResaltarFK_IdPeriodoDetalleTransferencia() {
		return this.resaltarFK_IdPeriodoDetalleTransferencia;
	}

	public void setResaltarFK_IdPeriodoDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleTransferencia=null;

	public Border getResaltarFK_IdProductoDetalleTransferencia() {
		return this.resaltarFK_IdProductoDetalleTransferencia;
	}

	public void setResaltarFK_IdProductoDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleTransferencia=null;

	public Border getResaltarFK_IdSucursalDetalleTransferencia() {
		return this.resaltarFK_IdSucursalDetalleTransferencia;
	}

	public void setResaltarFK_IdSucursalDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdTransferenciaDetalleTransferencia=null;

	public Border getResaltarFK_IdTransferenciaDetalleTransferencia() {
		return this.resaltarFK_IdTransferenciaDetalleTransferencia;
	}

	public void setResaltarFK_IdTransferenciaDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdTransferenciaDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdTransferenciaDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransferenciaDetalleTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleTransferencia=null;

	public Border getResaltarFK_IdUnidadDetalleTransferencia() {
		return this.resaltarFK_IdUnidadDetalleTransferencia;
	}

	public void setResaltarFK_IdUnidadDetalleTransferencia(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTransferenciaBeanSwingJInternalFrame detalletransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleTransferencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}