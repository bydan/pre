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


import com.bydan.erp.facturacion.util.DetalleFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleFacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleFacturaParameterGeneral;

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
final public class DetalleFacturaConstantesFunciones extends DetalleFacturaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
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
	public static final String SNOMBREOPCION="DetalleFactura";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleFactura"+DetalleFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleFacturaConstantesFunciones.SCHEMA+"_"+DetalleFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleFacturaConstantesFunciones.SCHEMA+"_"+DetalleFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleFacturaConstantesFunciones.SCHEMA+"_"+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleFacturaConstantesFunciones.SCHEMA+"_"+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Factura";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleFactura";
	public static final String OBJECTNAME="detallefactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallefactura from "+DetalleFacturaConstantesFunciones.SPERSISTENCENAME+" detallefactura";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_anio,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_mes,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_factura,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_producto,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".codigo_lote,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".fecha,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".descripcion,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".cantidad,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".precio,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".iva,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".iva_valor,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".ice,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".ice_valor,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".descuento,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".descuento2,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".sub_total,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".total,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".monto,"+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME+".nombre from "+DetalleFacturaConstantesFunciones.SCHEMA+"."+DetalleFacturaConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleFacturaConstantesFuncionesAdditional detallefacturaConstantesFuncionesAdditional=null;
	
	public DetalleFacturaConstantesFuncionesAdditional getDetalleFacturaConstantesFuncionesAdditional() {
		return this.detallefacturaConstantesFuncionesAdditional;
	}
	
	public void setDetalleFacturaConstantesFuncionesAdditional(DetalleFacturaConstantesFuncionesAdditional detallefacturaConstantesFuncionesAdditional) {
		try {
			this.detallefacturaConstantesFuncionesAdditional=detallefacturaConstantesFuncionesAdditional;
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
    public static final String IDFACTURA= "id_factura";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CODIGOLOTE= "codigo_lote";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String DESCUENTO2= "descuento2";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String MONTO= "monto";
    public static final String NOMBRE= "nombre";
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
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CODIGOLOTE= "Codigo Lote";
		public static final String LABEL_CODIGOLOTE_LOWER= "Codigo Lote";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_IVA= "Iva %";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_ICE= "Ice %";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ICEVALOR= "Ice Valor";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_DESCUENTO= "Descuento %";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_DESCUENTO2= "Descuento2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_LOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_LOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDANIO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDMES)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDFACTURA)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.CODIGOLOTE)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_CODIGOLOTE;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.FECHA)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.PRECIO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IVA)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.IVAVALOR)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.ICE)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.ICEVALOR)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.TOTAL)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.MONTO)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(DetalleFacturaConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleFacturaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleFacturaDescripcion(DetalleFactura detallefactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallefactura !=null/* && detallefactura.getId()!=0*/) {
			sDescripcion=detallefactura.getnombre();//detallefacturadetallefactura.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleFacturaDescripcionDetallado(DetalleFactura detallefactura) {
		String sDescripcion="";
			
		sDescripcion+=DetalleFacturaConstantesFunciones.ID+"=";
		sDescripcion+=detallefactura.getId().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallefactura.getVersionRow().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallefactura.getid_empresa().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallefactura.getid_sucursal().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallefactura.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallefactura.getid_periodo().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallefactura.getid_anio().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDMES+"=";
		sDescripcion+=detallefactura.getid_mes().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detallefactura.getid_factura().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallefactura.getid_bodega().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallefactura.getid_producto().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallefactura.getid_unidad().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.CODIGOLOTE+"=";
		sDescripcion+=detallefactura.getcodigo_lote()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallefactura.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.FECHA+"=";
		sDescripcion+=detallefactura.getfecha().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallefactura.getdescripcion()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallefactura.getcantidad().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallefactura.getprecio().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IVA+"=";
		sDescripcion+=detallefactura.getiva().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=detallefactura.getiva_valor().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.ICE+"=";
		sDescripcion+=detallefactura.getice().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=detallefactura.getice_valor().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detallefactura.getdescuento().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallefactura.getdescuento_valor().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detallefactura.getdescuento2().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detallefactura.getsub_total().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallefactura.gettotal().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.MONTO+"=";
		sDescripcion+=detallefactura.getmonto().toString()+",";
		sDescripcion+=DetalleFacturaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detallefactura.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleFacturaDescripcion(DetalleFactura detallefactura,String sValor) throws Exception {			
		if(detallefactura !=null) {
			detallefactura.setnombre(sValor);;//detallefacturadetallefactura.getnombre().trim();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleFactura(DetalleFactura detallefactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefactura.setcodigo_lote(detallefactura.getcodigo_lote().trim());
		detallefactura.setdescripcion(detallefactura.getdescripcion().trim());
		detallefactura.setnombre(detallefactura.getnombre().trim());
	}
	
	public static void quitarEspaciosDetalleFacturas(List<DetalleFactura> detallefacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFactura detallefactura: detallefacturas) {
			detallefactura.setcodigo_lote(detallefactura.getcodigo_lote().trim());
			detallefactura.setdescripcion(detallefactura.getdescripcion().trim());
			detallefactura.setnombre(detallefactura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFactura(DetalleFactura detallefactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallefactura.getConCambioAuxiliar()) {
			detallefactura.setIsDeleted(detallefactura.getIsDeletedAuxiliar());	
			detallefactura.setIsNew(detallefactura.getIsNewAuxiliar());	
			detallefactura.setIsChanged(detallefactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallefactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallefactura.setIsDeletedAuxiliar(false);	
			detallefactura.setIsNewAuxiliar(false);	
			detallefactura.setIsChangedAuxiliar(false);
			
			detallefactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturas(List<DetalleFactura> detallefacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleFactura detallefactura : detallefacturas) {
			if(conAsignarBase && detallefactura.getConCambioAuxiliar()) {
				detallefactura.setIsDeleted(detallefactura.getIsDeletedAuxiliar());	
				detallefactura.setIsNew(detallefactura.getIsNewAuxiliar());	
				detallefactura.setIsChanged(detallefactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallefactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallefactura.setIsDeletedAuxiliar(false);	
				detallefactura.setIsNewAuxiliar(false);	
				detallefactura.setIsChangedAuxiliar(false);
				
				detallefactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleFactura(DetalleFactura detallefactura,Boolean conEnteros) throws Exception  {
		detallefactura.setprecio(0.0);
		detallefactura.setiva(0.0);
		detallefactura.setiva_valor(0.0);
		detallefactura.setice(0.0);
		detallefactura.setice_valor(0.0);
		detallefactura.setdescuento(0.0);
		detallefactura.setdescuento_valor(0.0);
		detallefactura.setdescuento2(0.0);
		detallefactura.setsub_total(0.0);
		detallefactura.settotal(0.0);
		detallefactura.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallefactura.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleFacturas(List<DetalleFactura> detallefacturas,Boolean conEnteros) throws Exception  {
		
		for(DetalleFactura detallefactura: detallefacturas) {
			detallefactura.setprecio(0.0);
			detallefactura.setiva(0.0);
			detallefactura.setiva_valor(0.0);
			detallefactura.setice(0.0);
			detallefactura.setice_valor(0.0);
			detallefactura.setdescuento(0.0);
			detallefactura.setdescuento_valor(0.0);
			detallefactura.setdescuento2(0.0);
			detallefactura.setsub_total(0.0);
			detallefactura.settotal(0.0);
			detallefactura.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallefactura.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleFactura(List<DetalleFactura> detallefacturas,DetalleFactura detallefacturaAux) throws Exception  {
		DetalleFacturaConstantesFunciones.InicializarValoresDetalleFactura(detallefacturaAux,true);
		
		for(DetalleFactura detallefactura: detallefacturas) {
			if(detallefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallefacturaAux.setcantidad(detallefacturaAux.getcantidad()+detallefactura.getcantidad());			
			detallefacturaAux.setprecio(detallefacturaAux.getprecio()+detallefactura.getprecio());			
			detallefacturaAux.setiva(detallefacturaAux.getiva()+detallefactura.getiva());			
			detallefacturaAux.setiva_valor(detallefacturaAux.getiva_valor()+detallefactura.getiva_valor());			
			detallefacturaAux.setice(detallefacturaAux.getice()+detallefactura.getice());			
			detallefacturaAux.setice_valor(detallefacturaAux.getice_valor()+detallefactura.getice_valor());			
			detallefacturaAux.setdescuento(detallefacturaAux.getdescuento()+detallefactura.getdescuento());			
			detallefacturaAux.setdescuento_valor(detallefacturaAux.getdescuento_valor()+detallefactura.getdescuento_valor());			
			detallefacturaAux.setdescuento2(detallefacturaAux.getdescuento2()+detallefactura.getdescuento2());			
			detallefacturaAux.setsub_total(detallefacturaAux.getsub_total()+detallefactura.getsub_total());			
			detallefacturaAux.settotal(detallefacturaAux.gettotal()+detallefactura.gettotal());			
			detallefacturaAux.setmonto(detallefacturaAux.getmonto()+detallefactura.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleFacturaConstantesFunciones.getArrayColumnasGlobalesDetalleFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFactura> detallefacturas,DetalleFactura detallefactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFactura detallefacturaAux: detallefacturas) {
			if(detallefacturaAux!=null && detallefactura!=null) {
				if((detallefacturaAux.getId()==null && detallefactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallefacturaAux.getId()!=null && detallefactura.getId()!=null){
					if(detallefacturaAux.getId().equals(detallefactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFactura(List<DetalleFactura> detallefacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double descuento2Total=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double montoTotal=0.0;
	
		for(DetalleFactura detallefactura: detallefacturas) {			
			if(detallefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallefactura.getprecio();
			ivaTotal+=detallefactura.getiva();
			iva_valorTotal+=detallefactura.getiva_valor();
			iceTotal+=detallefactura.getice();
			ice_valorTotal+=detallefactura.getice_valor();
			descuentoTotal+=detallefactura.getdescuento();
			descuento_valorTotal+=detallefactura.getdescuento_valor();
			descuento2Total+=detallefactura.getdescuento2();
			sub_totalTotal+=detallefactura.getsub_total();
			totalTotal+=detallefactura.gettotal();
			montoTotal+=detallefactura.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_ID, DetalleFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_VERSIONROW, DetalleFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDEMPRESA, DetalleFacturaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDSUCURSAL, DetalleFacturaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDEJERCICIO, DetalleFacturaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDPERIODO, DetalleFacturaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDANIO, DetalleFacturaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDMES, DetalleFacturaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDFACTURA, DetalleFacturaConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDBODEGA, DetalleFacturaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDPRODUCTO, DetalleFacturaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDUNIDAD, DetalleFacturaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_CODIGOLOTE, DetalleFacturaConstantesFunciones.CODIGOLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleFacturaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_FECHA, DetalleFacturaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_DESCRIPCION, DetalleFacturaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_CANTIDAD, DetalleFacturaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_PRECIO, DetalleFacturaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IVA, DetalleFacturaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_IVAVALOR, DetalleFacturaConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_ICE, DetalleFacturaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_ICEVALOR, DetalleFacturaConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_DESCUENTO, DetalleFacturaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR, DetalleFacturaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2, DetalleFacturaConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL, DetalleFacturaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_TOTAL, DetalleFacturaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_MONTO, DetalleFacturaConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturaConstantesFunciones.LABEL_NOMBRE, DetalleFacturaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.CODIGOLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFactura() throws Exception  {
		return DetalleFacturaConstantesFunciones.getTiposSeleccionarDetalleFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFactura(Boolean conFk) throws Exception  {
		return DetalleFacturaConstantesFunciones.getTiposSeleccionarDetalleFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_CODIGOLOTE);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_CODIGOLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleFacturaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFactura(DetalleFactura detallefacturaAux) throws Exception {
		
			detallefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturaAux.getEmpresa()));
			detallefacturaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturaAux.getSucursal()));
			detallefacturaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallefacturaAux.getEjercicio()));
			detallefacturaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallefacturaAux.getPeriodo()));
			detallefacturaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallefacturaAux.getAnio()));
			detallefacturaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallefacturaAux.getMes()));
			detallefacturaAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detallefacturaAux.getFactura()));
			detallefacturaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaAux.getBodega()));
			detallefacturaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturaAux.getProducto()));
			detallefacturaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturaAux.getUnidad()));
			detallefacturaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallefacturaAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFactura(List<DetalleFactura> detallefacturasTemp) throws Exception {
		for(DetalleFactura detallefacturaAux:detallefacturasTemp) {
			
			detallefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturaAux.getEmpresa()));
			detallefacturaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallefacturaAux.getSucursal()));
			detallefacturaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallefacturaAux.getEjercicio()));
			detallefacturaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallefacturaAux.getPeriodo()));
			detallefacturaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallefacturaAux.getAnio()));
			detallefacturaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallefacturaAux.getMes()));
			detallefacturaAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detallefacturaAux.getFactura()));
			detallefacturaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallefacturaAux.getBodega()));
			detallefacturaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallefacturaAux.getProducto()));
			detallefacturaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallefacturaAux.getUnidad()));
			detallefacturaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallefacturaAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(CentroCosto.class));
				
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaConstantesFunciones.getClassesRelationshipsOfDetalleFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleFactura detallefactura,List<DetalleFactura> detallefacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleFactura detallefacturaEncontrado=null;
			
			for(DetalleFactura detallefacturaLocal:detallefacturas) {
				if(detallefacturaLocal.getId().equals(detallefactura.getId())) {
					detallefacturaEncontrado=detallefacturaLocal;
					
					detallefacturaLocal.setIsChanged(detallefactura.getIsChanged());
					detallefacturaLocal.setIsNew(detallefactura.getIsNew());
					detallefacturaLocal.setIsDeleted(detallefactura.getIsDeleted());
					
					detallefacturaLocal.setGeneralEntityOriginal(detallefactura.getGeneralEntityOriginal());
					
					detallefacturaLocal.setId(detallefactura.getId());	
					detallefacturaLocal.setVersionRow(detallefactura.getVersionRow());	
					detallefacturaLocal.setid_empresa(detallefactura.getid_empresa());	
					detallefacturaLocal.setid_sucursal(detallefactura.getid_sucursal());	
					detallefacturaLocal.setid_ejercicio(detallefactura.getid_ejercicio());	
					detallefacturaLocal.setid_periodo(detallefactura.getid_periodo());	
					detallefacturaLocal.setid_anio(detallefactura.getid_anio());	
					detallefacturaLocal.setid_mes(detallefactura.getid_mes());	
					detallefacturaLocal.setid_factura(detallefactura.getid_factura());	
					detallefacturaLocal.setid_bodega(detallefactura.getid_bodega());	
					detallefacturaLocal.setid_producto(detallefactura.getid_producto());	
					detallefacturaLocal.setid_unidad(detallefactura.getid_unidad());	
					detallefacturaLocal.setcodigo_lote(detallefactura.getcodigo_lote());	
					detallefacturaLocal.setid_centro_costo(detallefactura.getid_centro_costo());	
					detallefacturaLocal.setfecha(detallefactura.getfecha());	
					detallefacturaLocal.setdescripcion(detallefactura.getdescripcion());	
					detallefacturaLocal.setcantidad(detallefactura.getcantidad());	
					detallefacturaLocal.setprecio(detallefactura.getprecio());	
					detallefacturaLocal.setiva(detallefactura.getiva());	
					detallefacturaLocal.setiva_valor(detallefactura.getiva_valor());	
					detallefacturaLocal.setice(detallefactura.getice());	
					detallefacturaLocal.setice_valor(detallefactura.getice_valor());	
					detallefacturaLocal.setdescuento(detallefactura.getdescuento());	
					detallefacturaLocal.setdescuento_valor(detallefactura.getdescuento_valor());	
					detallefacturaLocal.setdescuento2(detallefactura.getdescuento2());	
					detallefacturaLocal.setsub_total(detallefactura.getsub_total());	
					detallefacturaLocal.settotal(detallefactura.gettotal());	
					detallefacturaLocal.setmonto(detallefactura.getmonto());	
					detallefacturaLocal.setnombre(detallefactura.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallefactura.getIsDeleted()) {
				if(!existe) {
					detallefacturas.add(detallefactura);
				}
			} else {
				if(detallefacturaEncontrado!=null && permiteQuitar)  {
					detallefacturas.remove(detallefacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleFactura detallefactura,List<DetalleFactura> detallefacturas) throws Exception {
		try	{			
			for(DetalleFactura detallefacturaLocal:detallefacturas) {
				if(detallefacturaLocal.getId().equals(detallefactura.getId())) {
					detallefacturaLocal.setIsSelected(detallefactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleFactura(List<DetalleFactura> detallefacturasAux) throws Exception {
		//this.detallefacturasAux=detallefacturasAux;
		
		for(DetalleFactura detallefacturaAux:detallefacturasAux) {
			if(detallefacturaAux.getIsChanged()) {
				detallefacturaAux.setIsChanged(false);
			}		
			
			if(detallefacturaAux.getIsNew()) {
				detallefacturaAux.setIsNew(false);
			}	
			
			if(detallefacturaAux.getIsDeleted()) {
				detallefacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleFactura(DetalleFactura detallefacturaAux) throws Exception {
		//this.detallefacturaAux=detallefacturaAux;
		
			if(detallefacturaAux.getIsChanged()) {
				detallefacturaAux.setIsChanged(false);
			}		
			
			if(detallefacturaAux.getIsNew()) {
				detallefacturaAux.setIsNew(false);
			}	
			
			if(detallefacturaAux.getIsDeleted()) {
				detallefacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleFactura detallefacturaAsignar,DetalleFactura detallefactura) throws Exception {
		detallefacturaAsignar.setId(detallefactura.getId());	
		detallefacturaAsignar.setVersionRow(detallefactura.getVersionRow());	
		detallefacturaAsignar.setid_empresa(detallefactura.getid_empresa());
		detallefacturaAsignar.setempresa_descripcion(detallefactura.getempresa_descripcion());	
		detallefacturaAsignar.setid_sucursal(detallefactura.getid_sucursal());
		detallefacturaAsignar.setsucursal_descripcion(detallefactura.getsucursal_descripcion());	
		detallefacturaAsignar.setid_ejercicio(detallefactura.getid_ejercicio());
		detallefacturaAsignar.setejercicio_descripcion(detallefactura.getejercicio_descripcion());	
		detallefacturaAsignar.setid_periodo(detallefactura.getid_periodo());
		detallefacturaAsignar.setperiodo_descripcion(detallefactura.getperiodo_descripcion());	
		detallefacturaAsignar.setid_anio(detallefactura.getid_anio());
		detallefacturaAsignar.setanio_descripcion(detallefactura.getanio_descripcion());	
		detallefacturaAsignar.setid_mes(detallefactura.getid_mes());
		detallefacturaAsignar.setmes_descripcion(detallefactura.getmes_descripcion());	
		detallefacturaAsignar.setid_factura(detallefactura.getid_factura());
		detallefacturaAsignar.setfactura_descripcion(detallefactura.getfactura_descripcion());	
		detallefacturaAsignar.setid_bodega(detallefactura.getid_bodega());
		detallefacturaAsignar.setbodega_descripcion(detallefactura.getbodega_descripcion());	
		detallefacturaAsignar.setid_producto(detallefactura.getid_producto());
		detallefacturaAsignar.setproducto_descripcion(detallefactura.getproducto_descripcion());	
		detallefacturaAsignar.setid_unidad(detallefactura.getid_unidad());
		detallefacturaAsignar.setunidad_descripcion(detallefactura.getunidad_descripcion());	
		detallefacturaAsignar.setcodigo_lote(detallefactura.getcodigo_lote());	
		detallefacturaAsignar.setid_centro_costo(detallefactura.getid_centro_costo());
		detallefacturaAsignar.setcentrocosto_descripcion(detallefactura.getcentrocosto_descripcion());	
		detallefacturaAsignar.setfecha(detallefactura.getfecha());	
		detallefacturaAsignar.setdescripcion(detallefactura.getdescripcion());	
		detallefacturaAsignar.setcantidad(detallefactura.getcantidad());	
		detallefacturaAsignar.setprecio(detallefactura.getprecio());	
		detallefacturaAsignar.setiva(detallefactura.getiva());	
		detallefacturaAsignar.setiva_valor(detallefactura.getiva_valor());	
		detallefacturaAsignar.setice(detallefactura.getice());	
		detallefacturaAsignar.setice_valor(detallefactura.getice_valor());	
		detallefacturaAsignar.setdescuento(detallefactura.getdescuento());	
		detallefacturaAsignar.setdescuento_valor(detallefactura.getdescuento_valor());	
		detallefacturaAsignar.setdescuento2(detallefactura.getdescuento2());	
		detallefacturaAsignar.setsub_total(detallefactura.getsub_total());	
		detallefacturaAsignar.settotal(detallefactura.gettotal());	
		detallefacturaAsignar.setmonto(detallefactura.getmonto());	
		detallefacturaAsignar.setnombre(detallefactura.getnombre());	
	}
	
	public static void inicializarDetalleFactura(DetalleFactura detallefactura) throws Exception {
		try {
				detallefactura.setId(0L);	
					
				detallefactura.setid_empresa(-1L);	
				detallefactura.setid_sucursal(-1L);	
				detallefactura.setid_ejercicio(-1L);	
				detallefactura.setid_periodo(-1L);	
				detallefactura.setid_anio(null);	
				detallefactura.setid_mes(null);	
				detallefactura.setid_factura(-1L);	
				detallefactura.setid_bodega(-1L);	
				detallefactura.setid_producto(-1L);	
				detallefactura.setid_unidad(-1L);	
				detallefactura.setcodigo_lote("");	
				detallefactura.setid_centro_costo(null);	
				detallefactura.setfecha(new Date());	
				detallefactura.setdescripcion("");	
				detallefactura.setcantidad(0);	
				detallefactura.setprecio(0.0);	
				detallefactura.setiva(0.0);	
				detallefactura.setiva_valor(0.0);	
				detallefactura.setice(0.0);	
				detallefactura.setice_valor(0.0);	
				detallefactura.setdescuento(0.0);	
				detallefactura.setdescuento_valor(0.0);	
				detallefactura.setdescuento2(0.0);	
				detallefactura.setsub_total(0.0);	
				detallefactura.settotal(0.0);	
				detallefactura.setmonto(0.0);	
				detallefactura.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_CODIGOLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleFactura(String sTipo,Row row,Workbook workbook,DetalleFactura detallefactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getcodigo_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefactura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleFactura() {
		return this.sFinalQueryDetalleFactura;
	}
	
	public void setsFinalQueryDetalleFactura(String sFinalQueryDetalleFactura) {
		this.sFinalQueryDetalleFactura= sFinalQueryDetalleFactura;
	}
	
	public Border resaltarSeleccionarDetalleFactura=null;
	
	public Border setResaltarSeleccionarDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleFactura() {
		return this.resaltarSeleccionarDetalleFactura;
	}
	
	public void setResaltarSeleccionarDetalleFactura(Border borderResaltarSeleccionarDetalleFactura) {
		this.resaltarSeleccionarDetalleFactura= borderResaltarSeleccionarDetalleFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleFactura=null;
	public Boolean mostraridDetalleFactura=true;
	public Boolean activaridDetalleFactura=true;

	public Border resaltarid_empresaDetalleFactura=null;
	public Boolean mostrarid_empresaDetalleFactura=true;
	public Boolean activarid_empresaDetalleFactura=true;
	public Boolean cargarid_empresaDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleFactura=null;
	public Boolean mostrarid_sucursalDetalleFactura=true;
	public Boolean activarid_sucursalDetalleFactura=true;
	public Boolean cargarid_sucursalDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleFactura=null;
	public Boolean mostrarid_ejercicioDetalleFactura=true;
	public Boolean activarid_ejercicioDetalleFactura=true;
	public Boolean cargarid_ejercicioDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleFactura=null;
	public Boolean mostrarid_periodoDetalleFactura=true;
	public Boolean activarid_periodoDetalleFactura=true;
	public Boolean cargarid_periodoDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleFactura=null;
	public Boolean mostrarid_anioDetalleFactura=true;
	public Boolean activarid_anioDetalleFactura=false;
	public Boolean cargarid_anioDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleFactura=null;
	public Boolean mostrarid_mesDetalleFactura=true;
	public Boolean activarid_mesDetalleFactura=false;
	public Boolean cargarid_mesDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_facturaDetalleFactura=null;
	public Boolean mostrarid_facturaDetalleFactura=true;
	public Boolean activarid_facturaDetalleFactura=true;
	public Boolean cargarid_facturaDetalleFactura=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleFactura=null;
	public Boolean mostrarid_bodegaDetalleFactura=true;
	public Boolean activarid_bodegaDetalleFactura=true;
	public Boolean cargarid_bodegaDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleFactura=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleFactura=null;
	public Boolean mostrarid_productoDetalleFactura=true;
	public Boolean activarid_productoDetalleFactura=true;
	public Boolean cargarid_productoDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleFactura=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleFactura=null;
	public Boolean mostrarid_unidadDetalleFactura=true;
	public Boolean activarid_unidadDetalleFactura=true;
	public Boolean cargarid_unidadDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleFactura=true;//ConEventDepend=true

	public Border resaltarcodigo_loteDetalleFactura=null;
	public Boolean mostrarcodigo_loteDetalleFactura=true;
	public Boolean activarcodigo_loteDetalleFactura=true;

	public Border resaltarid_centro_costoDetalleFactura=null;
	public Boolean mostrarid_centro_costoDetalleFactura=true;
	public Boolean activarid_centro_costoDetalleFactura=true;
	public Boolean cargarid_centro_costoDetalleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleFactura=false;//ConEventDepend=true

	public Border resaltarfechaDetalleFactura=null;
	public Boolean mostrarfechaDetalleFactura=true;
	public Boolean activarfechaDetalleFactura=false;

	public Border resaltardescripcionDetalleFactura=null;
	public Boolean mostrardescripcionDetalleFactura=true;
	public Boolean activardescripcionDetalleFactura=true;

	public Border resaltarcantidadDetalleFactura=null;
	public Boolean mostrarcantidadDetalleFactura=true;
	public Boolean activarcantidadDetalleFactura=true;

	public Border resaltarprecioDetalleFactura=null;
	public Boolean mostrarprecioDetalleFactura=true;
	public Boolean activarprecioDetalleFactura=true;

	public Border resaltarivaDetalleFactura=null;
	public Boolean mostrarivaDetalleFactura=true;
	public Boolean activarivaDetalleFactura=true;

	public Border resaltariva_valorDetalleFactura=null;
	public Boolean mostrariva_valorDetalleFactura=true;
	public Boolean activariva_valorDetalleFactura=true;

	public Border resaltariceDetalleFactura=null;
	public Boolean mostrariceDetalleFactura=true;
	public Boolean activariceDetalleFactura=true;

	public Border resaltarice_valorDetalleFactura=null;
	public Boolean mostrarice_valorDetalleFactura=true;
	public Boolean activarice_valorDetalleFactura=true;

	public Border resaltardescuentoDetalleFactura=null;
	public Boolean mostrardescuentoDetalleFactura=true;
	public Boolean activardescuentoDetalleFactura=true;

	public Border resaltardescuento_valorDetalleFactura=null;
	public Boolean mostrardescuento_valorDetalleFactura=true;
	public Boolean activardescuento_valorDetalleFactura=true;

	public Border resaltardescuento2DetalleFactura=null;
	public Boolean mostrardescuento2DetalleFactura=true;
	public Boolean activardescuento2DetalleFactura=true;

	public Border resaltarsub_totalDetalleFactura=null;
	public Boolean mostrarsub_totalDetalleFactura=true;
	public Boolean activarsub_totalDetalleFactura=true;

	public Border resaltartotalDetalleFactura=null;
	public Boolean mostrartotalDetalleFactura=true;
	public Boolean activartotalDetalleFactura=true;

	public Border resaltarmontoDetalleFactura=null;
	public Boolean mostrarmontoDetalleFactura=true;
	public Boolean activarmontoDetalleFactura=false;

	public Border resaltarnombreDetalleFactura=null;
	public Boolean mostrarnombreDetalleFactura=true;
	public Boolean activarnombreDetalleFactura=false;

	
	

	public Border setResaltaridDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltaridDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleFactura() {
		return this.resaltaridDetalleFactura;
	}

	public void setResaltaridDetalleFactura(Border borderResaltar) {
		this.resaltaridDetalleFactura= borderResaltar;
	}

	public Boolean getMostraridDetalleFactura() {
		return this.mostraridDetalleFactura;
	}

	public void setMostraridDetalleFactura(Boolean mostraridDetalleFactura) {
		this.mostraridDetalleFactura= mostraridDetalleFactura;
	}

	public Boolean getActivaridDetalleFactura() {
		return this.activaridDetalleFactura;
	}

	public void setActivaridDetalleFactura(Boolean activaridDetalleFactura) {
		this.activaridDetalleFactura= activaridDetalleFactura;
	}

	public Border setResaltarid_empresaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleFactura() {
		return this.resaltarid_empresaDetalleFactura;
	}

	public void setResaltarid_empresaDetalleFactura(Border borderResaltar) {
		this.resaltarid_empresaDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleFactura() {
		return this.mostrarid_empresaDetalleFactura;
	}

	public void setMostrarid_empresaDetalleFactura(Boolean mostrarid_empresaDetalleFactura) {
		this.mostrarid_empresaDetalleFactura= mostrarid_empresaDetalleFactura;
	}

	public Boolean getActivarid_empresaDetalleFactura() {
		return this.activarid_empresaDetalleFactura;
	}

	public void setActivarid_empresaDetalleFactura(Boolean activarid_empresaDetalleFactura) {
		this.activarid_empresaDetalleFactura= activarid_empresaDetalleFactura;
	}

	public Boolean getCargarid_empresaDetalleFactura() {
		return this.cargarid_empresaDetalleFactura;
	}

	public void setCargarid_empresaDetalleFactura(Boolean cargarid_empresaDetalleFactura) {
		this.cargarid_empresaDetalleFactura= cargarid_empresaDetalleFactura;
	}

	public Border setResaltarid_sucursalDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleFactura() {
		return this.resaltarid_sucursalDetalleFactura;
	}

	public void setResaltarid_sucursalDetalleFactura(Border borderResaltar) {
		this.resaltarid_sucursalDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleFactura() {
		return this.mostrarid_sucursalDetalleFactura;
	}

	public void setMostrarid_sucursalDetalleFactura(Boolean mostrarid_sucursalDetalleFactura) {
		this.mostrarid_sucursalDetalleFactura= mostrarid_sucursalDetalleFactura;
	}

	public Boolean getActivarid_sucursalDetalleFactura() {
		return this.activarid_sucursalDetalleFactura;
	}

	public void setActivarid_sucursalDetalleFactura(Boolean activarid_sucursalDetalleFactura) {
		this.activarid_sucursalDetalleFactura= activarid_sucursalDetalleFactura;
	}

	public Boolean getCargarid_sucursalDetalleFactura() {
		return this.cargarid_sucursalDetalleFactura;
	}

	public void setCargarid_sucursalDetalleFactura(Boolean cargarid_sucursalDetalleFactura) {
		this.cargarid_sucursalDetalleFactura= cargarid_sucursalDetalleFactura;
	}

	public Border setResaltarid_ejercicioDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleFactura() {
		return this.resaltarid_ejercicioDetalleFactura;
	}

	public void setResaltarid_ejercicioDetalleFactura(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleFactura() {
		return this.mostrarid_ejercicioDetalleFactura;
	}

	public void setMostrarid_ejercicioDetalleFactura(Boolean mostrarid_ejercicioDetalleFactura) {
		this.mostrarid_ejercicioDetalleFactura= mostrarid_ejercicioDetalleFactura;
	}

	public Boolean getActivarid_ejercicioDetalleFactura() {
		return this.activarid_ejercicioDetalleFactura;
	}

	public void setActivarid_ejercicioDetalleFactura(Boolean activarid_ejercicioDetalleFactura) {
		this.activarid_ejercicioDetalleFactura= activarid_ejercicioDetalleFactura;
	}

	public Boolean getCargarid_ejercicioDetalleFactura() {
		return this.cargarid_ejercicioDetalleFactura;
	}

	public void setCargarid_ejercicioDetalleFactura(Boolean cargarid_ejercicioDetalleFactura) {
		this.cargarid_ejercicioDetalleFactura= cargarid_ejercicioDetalleFactura;
	}

	public Border setResaltarid_periodoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleFactura() {
		return this.resaltarid_periodoDetalleFactura;
	}

	public void setResaltarid_periodoDetalleFactura(Border borderResaltar) {
		this.resaltarid_periodoDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleFactura() {
		return this.mostrarid_periodoDetalleFactura;
	}

	public void setMostrarid_periodoDetalleFactura(Boolean mostrarid_periodoDetalleFactura) {
		this.mostrarid_periodoDetalleFactura= mostrarid_periodoDetalleFactura;
	}

	public Boolean getActivarid_periodoDetalleFactura() {
		return this.activarid_periodoDetalleFactura;
	}

	public void setActivarid_periodoDetalleFactura(Boolean activarid_periodoDetalleFactura) {
		this.activarid_periodoDetalleFactura= activarid_periodoDetalleFactura;
	}

	public Boolean getCargarid_periodoDetalleFactura() {
		return this.cargarid_periodoDetalleFactura;
	}

	public void setCargarid_periodoDetalleFactura(Boolean cargarid_periodoDetalleFactura) {
		this.cargarid_periodoDetalleFactura= cargarid_periodoDetalleFactura;
	}

	public Border setResaltarid_anioDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleFactura() {
		return this.resaltarid_anioDetalleFactura;
	}

	public void setResaltarid_anioDetalleFactura(Border borderResaltar) {
		this.resaltarid_anioDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleFactura() {
		return this.mostrarid_anioDetalleFactura;
	}

	public void setMostrarid_anioDetalleFactura(Boolean mostrarid_anioDetalleFactura) {
		this.mostrarid_anioDetalleFactura= mostrarid_anioDetalleFactura;
	}

	public Boolean getActivarid_anioDetalleFactura() {
		return this.activarid_anioDetalleFactura;
	}

	public void setActivarid_anioDetalleFactura(Boolean activarid_anioDetalleFactura) {
		this.activarid_anioDetalleFactura= activarid_anioDetalleFactura;
	}

	public Boolean getCargarid_anioDetalleFactura() {
		return this.cargarid_anioDetalleFactura;
	}

	public void setCargarid_anioDetalleFactura(Boolean cargarid_anioDetalleFactura) {
		this.cargarid_anioDetalleFactura= cargarid_anioDetalleFactura;
	}

	public Border setResaltarid_mesDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleFactura() {
		return this.resaltarid_mesDetalleFactura;
	}

	public void setResaltarid_mesDetalleFactura(Border borderResaltar) {
		this.resaltarid_mesDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleFactura() {
		return this.mostrarid_mesDetalleFactura;
	}

	public void setMostrarid_mesDetalleFactura(Boolean mostrarid_mesDetalleFactura) {
		this.mostrarid_mesDetalleFactura= mostrarid_mesDetalleFactura;
	}

	public Boolean getActivarid_mesDetalleFactura() {
		return this.activarid_mesDetalleFactura;
	}

	public void setActivarid_mesDetalleFactura(Boolean activarid_mesDetalleFactura) {
		this.activarid_mesDetalleFactura= activarid_mesDetalleFactura;
	}

	public Boolean getCargarid_mesDetalleFactura() {
		return this.cargarid_mesDetalleFactura;
	}

	public void setCargarid_mesDetalleFactura(Boolean cargarid_mesDetalleFactura) {
		this.cargarid_mesDetalleFactura= cargarid_mesDetalleFactura;
	}

	public Border setResaltarid_facturaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_facturaDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetalleFactura() {
		return this.resaltarid_facturaDetalleFactura;
	}

	public void setResaltarid_facturaDetalleFactura(Border borderResaltar) {
		this.resaltarid_facturaDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetalleFactura() {
		return this.mostrarid_facturaDetalleFactura;
	}

	public void setMostrarid_facturaDetalleFactura(Boolean mostrarid_facturaDetalleFactura) {
		this.mostrarid_facturaDetalleFactura= mostrarid_facturaDetalleFactura;
	}

	public Boolean getActivarid_facturaDetalleFactura() {
		return this.activarid_facturaDetalleFactura;
	}

	public void setActivarid_facturaDetalleFactura(Boolean activarid_facturaDetalleFactura) {
		this.activarid_facturaDetalleFactura= activarid_facturaDetalleFactura;
	}

	public Boolean getCargarid_facturaDetalleFactura() {
		return this.cargarid_facturaDetalleFactura;
	}

	public void setCargarid_facturaDetalleFactura(Boolean cargarid_facturaDetalleFactura) {
		this.cargarid_facturaDetalleFactura= cargarid_facturaDetalleFactura;
	}

	public Border setResaltarid_bodegaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleFactura() {
		return this.resaltarid_bodegaDetalleFactura;
	}

	public void setResaltarid_bodegaDetalleFactura(Border borderResaltar) {
		this.resaltarid_bodegaDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleFactura() {
		return this.mostrarid_bodegaDetalleFactura;
	}

	public void setMostrarid_bodegaDetalleFactura(Boolean mostrarid_bodegaDetalleFactura) {
		this.mostrarid_bodegaDetalleFactura= mostrarid_bodegaDetalleFactura;
	}

	public Boolean getActivarid_bodegaDetalleFactura() {
		return this.activarid_bodegaDetalleFactura;
	}

	public void setActivarid_bodegaDetalleFactura(Boolean activarid_bodegaDetalleFactura) {
		this.activarid_bodegaDetalleFactura= activarid_bodegaDetalleFactura;
	}

	public Boolean getCargarid_bodegaDetalleFactura() {
		return this.cargarid_bodegaDetalleFactura;
	}

	public void setCargarid_bodegaDetalleFactura(Boolean cargarid_bodegaDetalleFactura) {
		this.cargarid_bodegaDetalleFactura= cargarid_bodegaDetalleFactura;
	}

	public Border setResaltarid_productoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleFactura() {
		return this.resaltarid_productoDetalleFactura;
	}

	public void setResaltarid_productoDetalleFactura(Border borderResaltar) {
		this.resaltarid_productoDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleFactura() {
		return this.mostrarid_productoDetalleFactura;
	}

	public void setMostrarid_productoDetalleFactura(Boolean mostrarid_productoDetalleFactura) {
		this.mostrarid_productoDetalleFactura= mostrarid_productoDetalleFactura;
	}

	public Boolean getActivarid_productoDetalleFactura() {
		return this.activarid_productoDetalleFactura;
	}

	public void setActivarid_productoDetalleFactura(Boolean activarid_productoDetalleFactura) {
		this.activarid_productoDetalleFactura= activarid_productoDetalleFactura;
	}

	public Boolean getCargarid_productoDetalleFactura() {
		return this.cargarid_productoDetalleFactura;
	}

	public void setCargarid_productoDetalleFactura(Boolean cargarid_productoDetalleFactura) {
		this.cargarid_productoDetalleFactura= cargarid_productoDetalleFactura;
	}

	public Border setResaltarid_unidadDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleFactura() {
		return this.resaltarid_unidadDetalleFactura;
	}

	public void setResaltarid_unidadDetalleFactura(Border borderResaltar) {
		this.resaltarid_unidadDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleFactura() {
		return this.mostrarid_unidadDetalleFactura;
	}

	public void setMostrarid_unidadDetalleFactura(Boolean mostrarid_unidadDetalleFactura) {
		this.mostrarid_unidadDetalleFactura= mostrarid_unidadDetalleFactura;
	}

	public Boolean getActivarid_unidadDetalleFactura() {
		return this.activarid_unidadDetalleFactura;
	}

	public void setActivarid_unidadDetalleFactura(Boolean activarid_unidadDetalleFactura) {
		this.activarid_unidadDetalleFactura= activarid_unidadDetalleFactura;
	}

	public Boolean getCargarid_unidadDetalleFactura() {
		return this.cargarid_unidadDetalleFactura;
	}

	public void setCargarid_unidadDetalleFactura(Boolean cargarid_unidadDetalleFactura) {
		this.cargarid_unidadDetalleFactura= cargarid_unidadDetalleFactura;
	}

	public Border setResaltarcodigo_loteDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarcodigo_loteDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_loteDetalleFactura() {
		return this.resaltarcodigo_loteDetalleFactura;
	}

	public void setResaltarcodigo_loteDetalleFactura(Border borderResaltar) {
		this.resaltarcodigo_loteDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarcodigo_loteDetalleFactura() {
		return this.mostrarcodigo_loteDetalleFactura;
	}

	public void setMostrarcodigo_loteDetalleFactura(Boolean mostrarcodigo_loteDetalleFactura) {
		this.mostrarcodigo_loteDetalleFactura= mostrarcodigo_loteDetalleFactura;
	}

	public Boolean getActivarcodigo_loteDetalleFactura() {
		return this.activarcodigo_loteDetalleFactura;
	}

	public void setActivarcodigo_loteDetalleFactura(Boolean activarcodigo_loteDetalleFactura) {
		this.activarcodigo_loteDetalleFactura= activarcodigo_loteDetalleFactura;
	}

	public Border setResaltarid_centro_costoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleFactura() {
		return this.resaltarid_centro_costoDetalleFactura;
	}

	public void setResaltarid_centro_costoDetalleFactura(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleFactura() {
		return this.mostrarid_centro_costoDetalleFactura;
	}

	public void setMostrarid_centro_costoDetalleFactura(Boolean mostrarid_centro_costoDetalleFactura) {
		this.mostrarid_centro_costoDetalleFactura= mostrarid_centro_costoDetalleFactura;
	}

	public Boolean getActivarid_centro_costoDetalleFactura() {
		return this.activarid_centro_costoDetalleFactura;
	}

	public void setActivarid_centro_costoDetalleFactura(Boolean activarid_centro_costoDetalleFactura) {
		this.activarid_centro_costoDetalleFactura= activarid_centro_costoDetalleFactura;
	}

	public Boolean getCargarid_centro_costoDetalleFactura() {
		return this.cargarid_centro_costoDetalleFactura;
	}

	public void setCargarid_centro_costoDetalleFactura(Boolean cargarid_centro_costoDetalleFactura) {
		this.cargarid_centro_costoDetalleFactura= cargarid_centro_costoDetalleFactura;
	}

	public Border setResaltarfechaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleFactura() {
		return this.resaltarfechaDetalleFactura;
	}

	public void setResaltarfechaDetalleFactura(Border borderResaltar) {
		this.resaltarfechaDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleFactura() {
		return this.mostrarfechaDetalleFactura;
	}

	public void setMostrarfechaDetalleFactura(Boolean mostrarfechaDetalleFactura) {
		this.mostrarfechaDetalleFactura= mostrarfechaDetalleFactura;
	}

	public Boolean getActivarfechaDetalleFactura() {
		return this.activarfechaDetalleFactura;
	}

	public void setActivarfechaDetalleFactura(Boolean activarfechaDetalleFactura) {
		this.activarfechaDetalleFactura= activarfechaDetalleFactura;
	}

	public Border setResaltardescripcionDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleFactura() {
		return this.resaltardescripcionDetalleFactura;
	}

	public void setResaltardescripcionDetalleFactura(Border borderResaltar) {
		this.resaltardescripcionDetalleFactura= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleFactura() {
		return this.mostrardescripcionDetalleFactura;
	}

	public void setMostrardescripcionDetalleFactura(Boolean mostrardescripcionDetalleFactura) {
		this.mostrardescripcionDetalleFactura= mostrardescripcionDetalleFactura;
	}

	public Boolean getActivardescripcionDetalleFactura() {
		return this.activardescripcionDetalleFactura;
	}

	public void setActivardescripcionDetalleFactura(Boolean activardescripcionDetalleFactura) {
		this.activardescripcionDetalleFactura= activardescripcionDetalleFactura;
	}

	public Border setResaltarcantidadDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleFactura() {
		return this.resaltarcantidadDetalleFactura;
	}

	public void setResaltarcantidadDetalleFactura(Border borderResaltar) {
		this.resaltarcantidadDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleFactura() {
		return this.mostrarcantidadDetalleFactura;
	}

	public void setMostrarcantidadDetalleFactura(Boolean mostrarcantidadDetalleFactura) {
		this.mostrarcantidadDetalleFactura= mostrarcantidadDetalleFactura;
	}

	public Boolean getActivarcantidadDetalleFactura() {
		return this.activarcantidadDetalleFactura;
	}

	public void setActivarcantidadDetalleFactura(Boolean activarcantidadDetalleFactura) {
		this.activarcantidadDetalleFactura= activarcantidadDetalleFactura;
	}

	public Border setResaltarprecioDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleFactura() {
		return this.resaltarprecioDetalleFactura;
	}

	public void setResaltarprecioDetalleFactura(Border borderResaltar) {
		this.resaltarprecioDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleFactura() {
		return this.mostrarprecioDetalleFactura;
	}

	public void setMostrarprecioDetalleFactura(Boolean mostrarprecioDetalleFactura) {
		this.mostrarprecioDetalleFactura= mostrarprecioDetalleFactura;
	}

	public Boolean getActivarprecioDetalleFactura() {
		return this.activarprecioDetalleFactura;
	}

	public void setActivarprecioDetalleFactura(Boolean activarprecioDetalleFactura) {
		this.activarprecioDetalleFactura= activarprecioDetalleFactura;
	}

	public Border setResaltarivaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarivaDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleFactura() {
		return this.resaltarivaDetalleFactura;
	}

	public void setResaltarivaDetalleFactura(Border borderResaltar) {
		this.resaltarivaDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarivaDetalleFactura() {
		return this.mostrarivaDetalleFactura;
	}

	public void setMostrarivaDetalleFactura(Boolean mostrarivaDetalleFactura) {
		this.mostrarivaDetalleFactura= mostrarivaDetalleFactura;
	}

	public Boolean getActivarivaDetalleFactura() {
		return this.activarivaDetalleFactura;
	}

	public void setActivarivaDetalleFactura(Boolean activarivaDetalleFactura) {
		this.activarivaDetalleFactura= activarivaDetalleFactura;
	}

	public Border setResaltariva_valorDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltariva_valorDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorDetalleFactura() {
		return this.resaltariva_valorDetalleFactura;
	}

	public void setResaltariva_valorDetalleFactura(Border borderResaltar) {
		this.resaltariva_valorDetalleFactura= borderResaltar;
	}

	public Boolean getMostrariva_valorDetalleFactura() {
		return this.mostrariva_valorDetalleFactura;
	}

	public void setMostrariva_valorDetalleFactura(Boolean mostrariva_valorDetalleFactura) {
		this.mostrariva_valorDetalleFactura= mostrariva_valorDetalleFactura;
	}

	public Boolean getActivariva_valorDetalleFactura() {
		return this.activariva_valorDetalleFactura;
	}

	public void setActivariva_valorDetalleFactura(Boolean activariva_valorDetalleFactura) {
		this.activariva_valorDetalleFactura= activariva_valorDetalleFactura;
	}

	public Border setResaltariceDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltariceDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleFactura() {
		return this.resaltariceDetalleFactura;
	}

	public void setResaltariceDetalleFactura(Border borderResaltar) {
		this.resaltariceDetalleFactura= borderResaltar;
	}

	public Boolean getMostrariceDetalleFactura() {
		return this.mostrariceDetalleFactura;
	}

	public void setMostrariceDetalleFactura(Boolean mostrariceDetalleFactura) {
		this.mostrariceDetalleFactura= mostrariceDetalleFactura;
	}

	public Boolean getActivariceDetalleFactura() {
		return this.activariceDetalleFactura;
	}

	public void setActivariceDetalleFactura(Boolean activariceDetalleFactura) {
		this.activariceDetalleFactura= activariceDetalleFactura;
	}

	public Border setResaltarice_valorDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarice_valorDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorDetalleFactura() {
		return this.resaltarice_valorDetalleFactura;
	}

	public void setResaltarice_valorDetalleFactura(Border borderResaltar) {
		this.resaltarice_valorDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarice_valorDetalleFactura() {
		return this.mostrarice_valorDetalleFactura;
	}

	public void setMostrarice_valorDetalleFactura(Boolean mostrarice_valorDetalleFactura) {
		this.mostrarice_valorDetalleFactura= mostrarice_valorDetalleFactura;
	}

	public Boolean getActivarice_valorDetalleFactura() {
		return this.activarice_valorDetalleFactura;
	}

	public void setActivarice_valorDetalleFactura(Boolean activarice_valorDetalleFactura) {
		this.activarice_valorDetalleFactura= activarice_valorDetalleFactura;
	}

	public Border setResaltardescuentoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltardescuentoDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleFactura() {
		return this.resaltardescuentoDetalleFactura;
	}

	public void setResaltardescuentoDetalleFactura(Border borderResaltar) {
		this.resaltardescuentoDetalleFactura= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleFactura() {
		return this.mostrardescuentoDetalleFactura;
	}

	public void setMostrardescuentoDetalleFactura(Boolean mostrardescuentoDetalleFactura) {
		this.mostrardescuentoDetalleFactura= mostrardescuentoDetalleFactura;
	}

	public Boolean getActivardescuentoDetalleFactura() {
		return this.activardescuentoDetalleFactura;
	}

	public void setActivardescuentoDetalleFactura(Boolean activardescuentoDetalleFactura) {
		this.activardescuentoDetalleFactura= activardescuentoDetalleFactura;
	}

	public Border setResaltardescuento_valorDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetalleFactura() {
		return this.resaltardescuento_valorDetalleFactura;
	}

	public void setResaltardescuento_valorDetalleFactura(Border borderResaltar) {
		this.resaltardescuento_valorDetalleFactura= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetalleFactura() {
		return this.mostrardescuento_valorDetalleFactura;
	}

	public void setMostrardescuento_valorDetalleFactura(Boolean mostrardescuento_valorDetalleFactura) {
		this.mostrardescuento_valorDetalleFactura= mostrardescuento_valorDetalleFactura;
	}

	public Boolean getActivardescuento_valorDetalleFactura() {
		return this.activardescuento_valorDetalleFactura;
	}

	public void setActivardescuento_valorDetalleFactura(Boolean activardescuento_valorDetalleFactura) {
		this.activardescuento_valorDetalleFactura= activardescuento_valorDetalleFactura;
	}

	public Border setResaltardescuento2DetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltardescuento2DetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetalleFactura() {
		return this.resaltardescuento2DetalleFactura;
	}

	public void setResaltardescuento2DetalleFactura(Border borderResaltar) {
		this.resaltardescuento2DetalleFactura= borderResaltar;
	}

	public Boolean getMostrardescuento2DetalleFactura() {
		return this.mostrardescuento2DetalleFactura;
	}

	public void setMostrardescuento2DetalleFactura(Boolean mostrardescuento2DetalleFactura) {
		this.mostrardescuento2DetalleFactura= mostrardescuento2DetalleFactura;
	}

	public Boolean getActivardescuento2DetalleFactura() {
		return this.activardescuento2DetalleFactura;
	}

	public void setActivardescuento2DetalleFactura(Boolean activardescuento2DetalleFactura) {
		this.activardescuento2DetalleFactura= activardescuento2DetalleFactura;
	}

	public Border setResaltarsub_totalDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetalleFactura() {
		return this.resaltarsub_totalDetalleFactura;
	}

	public void setResaltarsub_totalDetalleFactura(Border borderResaltar) {
		this.resaltarsub_totalDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetalleFactura() {
		return this.mostrarsub_totalDetalleFactura;
	}

	public void setMostrarsub_totalDetalleFactura(Boolean mostrarsub_totalDetalleFactura) {
		this.mostrarsub_totalDetalleFactura= mostrarsub_totalDetalleFactura;
	}

	public Boolean getActivarsub_totalDetalleFactura() {
		return this.activarsub_totalDetalleFactura;
	}

	public void setActivarsub_totalDetalleFactura(Boolean activarsub_totalDetalleFactura) {
		this.activarsub_totalDetalleFactura= activarsub_totalDetalleFactura;
	}

	public Border setResaltartotalDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltartotalDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleFactura() {
		return this.resaltartotalDetalleFactura;
	}

	public void setResaltartotalDetalleFactura(Border borderResaltar) {
		this.resaltartotalDetalleFactura= borderResaltar;
	}

	public Boolean getMostrartotalDetalleFactura() {
		return this.mostrartotalDetalleFactura;
	}

	public void setMostrartotalDetalleFactura(Boolean mostrartotalDetalleFactura) {
		this.mostrartotalDetalleFactura= mostrartotalDetalleFactura;
	}

	public Boolean getActivartotalDetalleFactura() {
		return this.activartotalDetalleFactura;
	}

	public void setActivartotalDetalleFactura(Boolean activartotalDetalleFactura) {
		this.activartotalDetalleFactura= activartotalDetalleFactura;
	}

	public Border setResaltarmontoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarmontoDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoDetalleFactura() {
		return this.resaltarmontoDetalleFactura;
	}

	public void setResaltarmontoDetalleFactura(Border borderResaltar) {
		this.resaltarmontoDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarmontoDetalleFactura() {
		return this.mostrarmontoDetalleFactura;
	}

	public void setMostrarmontoDetalleFactura(Boolean mostrarmontoDetalleFactura) {
		this.mostrarmontoDetalleFactura= mostrarmontoDetalleFactura;
	}

	public Boolean getActivarmontoDetalleFactura() {
		return this.activarmontoDetalleFactura;
	}

	public void setActivarmontoDetalleFactura(Boolean activarmontoDetalleFactura) {
		this.activarmontoDetalleFactura= activarmontoDetalleFactura;
	}

	public Border setResaltarnombreDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturaBeanSwingJInternalFrame.jTtoolBarDetalleFactura.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleFactura() {
		return this.resaltarnombreDetalleFactura;
	}

	public void setResaltarnombreDetalleFactura(Border borderResaltar) {
		this.resaltarnombreDetalleFactura= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleFactura() {
		return this.mostrarnombreDetalleFactura;
	}

	public void setMostrarnombreDetalleFactura(Boolean mostrarnombreDetalleFactura) {
		this.mostrarnombreDetalleFactura= mostrarnombreDetalleFactura;
	}

	public Boolean getActivarnombreDetalleFactura() {
		return this.activarnombreDetalleFactura;
	}

	public void setActivarnombreDetalleFactura(Boolean activarnombreDetalleFactura) {
		this.activarnombreDetalleFactura= activarnombreDetalleFactura;
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
		
		
		this.setMostraridDetalleFactura(esInicial);
		this.setMostrarid_empresaDetalleFactura(esInicial);
		this.setMostrarid_sucursalDetalleFactura(esInicial);
		this.setMostrarid_ejercicioDetalleFactura(esInicial);
		this.setMostrarid_periodoDetalleFactura(esInicial);
		this.setMostrarid_anioDetalleFactura(esInicial);
		this.setMostrarid_mesDetalleFactura(esInicial);
		this.setMostrarid_facturaDetalleFactura(esInicial);
		this.setMostrarid_bodegaDetalleFactura(esInicial);
		this.setMostrarid_productoDetalleFactura(esInicial);
		this.setMostrarid_unidadDetalleFactura(esInicial);
		this.setMostrarcodigo_loteDetalleFactura(esInicial);
		this.setMostrarid_centro_costoDetalleFactura(esInicial);
		this.setMostrarfechaDetalleFactura(esInicial);
		this.setMostrardescripcionDetalleFactura(esInicial);
		this.setMostrarcantidadDetalleFactura(esInicial);
		this.setMostrarprecioDetalleFactura(esInicial);
		this.setMostrarivaDetalleFactura(esInicial);
		this.setMostrariva_valorDetalleFactura(esInicial);
		this.setMostrariceDetalleFactura(esInicial);
		this.setMostrarice_valorDetalleFactura(esInicial);
		this.setMostrardescuentoDetalleFactura(esInicial);
		this.setMostrardescuento_valorDetalleFactura(esInicial);
		this.setMostrardescuento2DetalleFactura(esInicial);
		this.setMostrarsub_totalDetalleFactura(esInicial);
		this.setMostrartotalDetalleFactura(esInicial);
		this.setMostrarmontoDetalleFactura(esInicial);
		this.setMostrarnombreDetalleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ID)) {
				this.setMostraridDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CODIGOLOTE)) {
				this.setMostrarcodigo_loteDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICE)) {
				this.setMostrariceDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.MONTO)) {
				this.setMostrarmontoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleFactura(esAsigna);
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
		
		
		this.setActivaridDetalleFactura(esInicial);
		this.setActivarid_empresaDetalleFactura(esInicial);
		this.setActivarid_sucursalDetalleFactura(esInicial);
		this.setActivarid_ejercicioDetalleFactura(esInicial);
		this.setActivarid_periodoDetalleFactura(esInicial);
		this.setActivarid_anioDetalleFactura(esInicial);
		this.setActivarid_mesDetalleFactura(esInicial);
		this.setActivarid_facturaDetalleFactura(esInicial);
		this.setActivarid_bodegaDetalleFactura(esInicial);
		this.setActivarid_productoDetalleFactura(esInicial);
		this.setActivarid_unidadDetalleFactura(esInicial);
		this.setActivarcodigo_loteDetalleFactura(esInicial);
		this.setActivarid_centro_costoDetalleFactura(esInicial);
		this.setActivarfechaDetalleFactura(esInicial);
		this.setActivardescripcionDetalleFactura(esInicial);
		this.setActivarcantidadDetalleFactura(esInicial);
		this.setActivarprecioDetalleFactura(esInicial);
		this.setActivarivaDetalleFactura(esInicial);
		this.setActivariva_valorDetalleFactura(esInicial);
		this.setActivariceDetalleFactura(esInicial);
		this.setActivarice_valorDetalleFactura(esInicial);
		this.setActivardescuentoDetalleFactura(esInicial);
		this.setActivardescuento_valorDetalleFactura(esInicial);
		this.setActivardescuento2DetalleFactura(esInicial);
		this.setActivarsub_totalDetalleFactura(esInicial);
		this.setActivartotalDetalleFactura(esInicial);
		this.setActivarmontoDetalleFactura(esInicial);
		this.setActivarnombreDetalleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ID)) {
				this.setActivaridDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CODIGOLOTE)) {
				this.setActivarcodigo_loteDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVA)) {
				this.setActivarivaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICE)) {
				this.setActivariceDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.MONTO)) {
				this.setActivarmontoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleFactura(esInicial);
		this.setResaltarid_empresaDetalleFactura(esInicial);
		this.setResaltarid_sucursalDetalleFactura(esInicial);
		this.setResaltarid_ejercicioDetalleFactura(esInicial);
		this.setResaltarid_periodoDetalleFactura(esInicial);
		this.setResaltarid_anioDetalleFactura(esInicial);
		this.setResaltarid_mesDetalleFactura(esInicial);
		this.setResaltarid_facturaDetalleFactura(esInicial);
		this.setResaltarid_bodegaDetalleFactura(esInicial);
		this.setResaltarid_productoDetalleFactura(esInicial);
		this.setResaltarid_unidadDetalleFactura(esInicial);
		this.setResaltarcodigo_loteDetalleFactura(esInicial);
		this.setResaltarid_centro_costoDetalleFactura(esInicial);
		this.setResaltarfechaDetalleFactura(esInicial);
		this.setResaltardescripcionDetalleFactura(esInicial);
		this.setResaltarcantidadDetalleFactura(esInicial);
		this.setResaltarprecioDetalleFactura(esInicial);
		this.setResaltarivaDetalleFactura(esInicial);
		this.setResaltariva_valorDetalleFactura(esInicial);
		this.setResaltariceDetalleFactura(esInicial);
		this.setResaltarice_valorDetalleFactura(esInicial);
		this.setResaltardescuentoDetalleFactura(esInicial);
		this.setResaltardescuento_valorDetalleFactura(esInicial);
		this.setResaltardescuento2DetalleFactura(esInicial);
		this.setResaltarsub_totalDetalleFactura(esInicial);
		this.setResaltartotalDetalleFactura(esInicial);
		this.setResaltarmontoDetalleFactura(esInicial);
		this.setResaltarnombreDetalleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ID)) {
				this.setResaltaridDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CODIGOLOTE)) {
				this.setResaltarcodigo_loteDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICE)) {
				this.setResaltariceDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.MONTO)) {
				this.setResaltarmontoDetalleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleFactura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleFactura=true;

	public Boolean getMostrarFK_IdBodegaDetalleFactura() {
		return this.mostrarFK_IdBodegaDetalleFactura;
	}

	public void setMostrarFK_IdBodegaDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleFactura=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleFactura() {
		return this.mostrarFK_IdCentroCostoDetalleFactura;
	}

	public void setMostrarFK_IdCentroCostoDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleFactura=true;

	public Boolean getMostrarFK_IdEjercicioDetalleFactura() {
		return this.mostrarFK_IdEjercicioDetalleFactura;
	}

	public void setMostrarFK_IdEjercicioDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleFactura=true;

	public Boolean getMostrarFK_IdEmpresaDetalleFactura() {
		return this.mostrarFK_IdEmpresaDetalleFactura;
	}

	public void setMostrarFK_IdEmpresaDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetalleFactura=true;

	public Boolean getMostrarFK_IdFacturaDetalleFactura() {
		return this.mostrarFK_IdFacturaDetalleFactura;
	}

	public void setMostrarFK_IdFacturaDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleFactura=true;

	public Boolean getMostrarFK_IdPeriodoDetalleFactura() {
		return this.mostrarFK_IdPeriodoDetalleFactura;
	}

	public void setMostrarFK_IdPeriodoDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleFactura=true;

	public Boolean getMostrarFK_IdProductoDetalleFactura() {
		return this.mostrarFK_IdProductoDetalleFactura;
	}

	public void setMostrarFK_IdProductoDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleFactura=true;

	public Boolean getMostrarFK_IdSucursalDetalleFactura() {
		return this.mostrarFK_IdSucursalDetalleFactura;
	}

	public void setMostrarFK_IdSucursalDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleFactura=true;

	public Boolean getMostrarFK_IdUnidadDetalleFactura() {
		return this.mostrarFK_IdUnidadDetalleFactura;
	}

	public void setMostrarFK_IdUnidadDetalleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleFactura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleFactura=true;

	public Boolean getActivarFK_IdBodegaDetalleFactura() {
		return this.activarFK_IdBodegaDetalleFactura;
	}

	public void setActivarFK_IdBodegaDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleFactura=true;

	public Boolean getActivarFK_IdCentroCostoDetalleFactura() {
		return this.activarFK_IdCentroCostoDetalleFactura;
	}

	public void setActivarFK_IdCentroCostoDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleFactura=true;

	public Boolean getActivarFK_IdEjercicioDetalleFactura() {
		return this.activarFK_IdEjercicioDetalleFactura;
	}

	public void setActivarFK_IdEjercicioDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleFactura=true;

	public Boolean getActivarFK_IdEmpresaDetalleFactura() {
		return this.activarFK_IdEmpresaDetalleFactura;
	}

	public void setActivarFK_IdEmpresaDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetalleFactura=true;

	public Boolean getActivarFK_IdFacturaDetalleFactura() {
		return this.activarFK_IdFacturaDetalleFactura;
	}

	public void setActivarFK_IdFacturaDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleFactura=true;

	public Boolean getActivarFK_IdPeriodoDetalleFactura() {
		return this.activarFK_IdPeriodoDetalleFactura;
	}

	public void setActivarFK_IdPeriodoDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleFactura=true;

	public Boolean getActivarFK_IdProductoDetalleFactura() {
		return this.activarFK_IdProductoDetalleFactura;
	}

	public void setActivarFK_IdProductoDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleFactura=true;

	public Boolean getActivarFK_IdSucursalDetalleFactura() {
		return this.activarFK_IdSucursalDetalleFactura;
	}

	public void setActivarFK_IdSucursalDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleFactura=true;

	public Boolean getActivarFK_IdUnidadDetalleFactura() {
		return this.activarFK_IdUnidadDetalleFactura;
	}

	public void setActivarFK_IdUnidadDetalleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleFactura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleFactura=null;

	public Border getResaltarFK_IdBodegaDetalleFactura() {
		return this.resaltarFK_IdBodegaDetalleFactura;
	}

	public void setResaltarFK_IdBodegaDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleFactura=null;

	public Border getResaltarFK_IdCentroCostoDetalleFactura() {
		return this.resaltarFK_IdCentroCostoDetalleFactura;
	}

	public void setResaltarFK_IdCentroCostoDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleFactura=null;

	public Border getResaltarFK_IdEjercicioDetalleFactura() {
		return this.resaltarFK_IdEjercicioDetalleFactura;
	}

	public void setResaltarFK_IdEjercicioDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleFactura=null;

	public Border getResaltarFK_IdEmpresaDetalleFactura() {
		return this.resaltarFK_IdEmpresaDetalleFactura;
	}

	public void setResaltarFK_IdEmpresaDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetalleFactura=null;

	public Border getResaltarFK_IdFacturaDetalleFactura() {
		return this.resaltarFK_IdFacturaDetalleFactura;
	}

	public void setResaltarFK_IdFacturaDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleFactura=null;

	public Border getResaltarFK_IdPeriodoDetalleFactura() {
		return this.resaltarFK_IdPeriodoDetalleFactura;
	}

	public void setResaltarFK_IdPeriodoDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleFactura=null;

	public Border getResaltarFK_IdProductoDetalleFactura() {
		return this.resaltarFK_IdProductoDetalleFactura;
	}

	public void setResaltarFK_IdProductoDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleFactura=null;

	public Border getResaltarFK_IdSucursalDetalleFactura() {
		return this.resaltarFK_IdSucursalDetalleFactura;
	}

	public void setResaltarFK_IdSucursalDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleFactura= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleFactura=null;

	public Border getResaltarFK_IdUnidadDetalleFactura() {
		return this.resaltarFK_IdUnidadDetalleFactura;
	}

	public void setResaltarFK_IdUnidadDetalleFactura(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleFactura= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturaBeanSwingJInternalFrame detallefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}