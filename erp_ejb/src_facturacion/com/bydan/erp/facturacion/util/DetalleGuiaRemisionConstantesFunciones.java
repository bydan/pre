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


import com.bydan.erp.facturacion.util.DetalleGuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleGuiaRemisionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleGuiaRemisionParameterGeneral;

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
final public class DetalleGuiaRemisionConstantesFunciones extends DetalleGuiaRemisionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleGuiaRemision";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleGuiaRemision"+DetalleGuiaRemisionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleGuiaRemisionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleGuiaRemisionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleGuiaRemisionConstantesFunciones.SCHEMA+"_"+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleGuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleGuiaRemisionConstantesFunciones.SCHEMA+"_"+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleGuiaRemisionConstantesFunciones.SCHEMA+"_"+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleGuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleGuiaRemisionConstantesFunciones.SCHEMA+"_"+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleGuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleGuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleGuiaRemisionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleGuiaRemisionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleGuiaRemisionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleGuiaRemisionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Guia Remisiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Guia Remision";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Guia Remision";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleGuiaRemision";
	public static final String OBJECTNAME="detalleguiaremision";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_guia_remision";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleguiaremision from "+DetalleGuiaRemisionConstantesFunciones.SPERSISTENCENAME+" detalleguiaremision";
	public static String QUERYSELECTNATIVE="select "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".version_row,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_guia_remision,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_producto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad_envases,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad_auxiliar,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descripcion,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".monto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".precio,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".porcentaje_descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento2,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento3,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".iva,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total_descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total_impuesto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".sub_total,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".lote,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".lote_cliente,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".orden_compra,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".area,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".medidas,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".acabado,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".acabado2 from "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME;//+" as "+DetalleGuiaRemisionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleGuiaRemisionConstantesFuncionesAdditional detalleguiaremisionConstantesFuncionesAdditional=null;
	
	public DetalleGuiaRemisionConstantesFuncionesAdditional getDetalleGuiaRemisionConstantesFuncionesAdditional() {
		return this.detalleguiaremisionConstantesFuncionesAdditional;
	}
	
	public void setDetalleGuiaRemisionConstantesFuncionesAdditional(DetalleGuiaRemisionConstantesFuncionesAdditional detalleguiaremisionConstantesFuncionesAdditional) {
		try {
			this.detalleguiaremisionConstantesFuncionesAdditional=detalleguiaremisionConstantesFuncionesAdditional;
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
    public static final String IDGUIAREMISION= "id_guia_remision";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String CANTIDADENVASES= "cantidad_envases";
    public static final String CANTIDADAUXILIAR= "cantidad_auxiliar";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDAD= "cantidad";
    public static final String MONTO= "monto";
    public static final String PRECIO= "precio";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTO2= "descuento2";
    public static final String DESCUENTO3= "descuento3";
    public static final String PORCENTAJEIVA= "porcentaje_iva";
    public static final String IVA= "iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String TOTALIMPUESTO= "total_impuesto";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String LOTE= "lote";
    public static final String LOTECLIENTE= "lote_cliente";
    public static final String ORDENCOMPRA= "orden_compra";
    public static final String AREA= "area";
    public static final String MEDIDAS= "medidas";
    public static final String ACABADO= "acabado";
    public static final String ACABADO2= "acabado2";
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
    	public static final String LABEL_IDGUIAREMISION= "Guia Remision";
		public static final String LABEL_IDGUIAREMISION_LOWER= "Guia Remision";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_CANTIDADENVASES= "Cantidad Envases";
		public static final String LABEL_CANTIDADENVASES_LOWER= "Cantidad Envases";
    	public static final String LABEL_CANTIDADAUXILIAR= "Cantidad Auxiliar";
		public static final String LABEL_CANTIDADAUXILIAR_LOWER= "Cantidad Auxiliar";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "% Descuento";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "Porcentaje Descuento";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTO2= "Descuento 2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_DESCUENTO3= "Descuento 3";
		public static final String LABEL_DESCUENTO3_LOWER= "Descuento3";
    	public static final String LABEL_PORCENTAJEIVA= "% Iva";
		public static final String LABEL_PORCENTAJEIVA_LOWER= "Porcentaje Iva";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_TOTALIMPUESTO= "Total Impuesto";
		public static final String LABEL_TOTALIMPUESTO_LOWER= "Total Impuesto";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_LOTECLIENTE= "Lote Cliente";
		public static final String LABEL_LOTECLIENTE_LOWER= "Lote Cliente";
    	public static final String LABEL_ORDENCOMPRA= "Orden Compra";
		public static final String LABEL_ORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_AREA= "Area";
		public static final String LABEL_AREA_LOWER= "Area";
    	public static final String LABEL_MEDIDAS= "Medidas";
		public static final String LABEL_MEDIDAS_LOWER= "Medidas";
    	public static final String LABEL_ACABADO= "Acabado";
		public static final String LABEL_ACABADO_LOWER= "Acabado";
    	public static final String LABEL_ACABADO2= "Acabado 2";
		public static final String LABEL_ACABADO2_LOWER= "Acabado2";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORDEN_COMPRA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORDEN_COMPRA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMEDIDAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMEDIDAS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACABADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACABADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACABADO2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACABADO2=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleGuiaRemisionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDGUIAREMISION;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADENVASES;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADAUXILIAR;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.MONTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.PRECIO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.IVA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.TOTAL)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.LOTE)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_LOTECLIENTE;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_ORDENCOMPRA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.AREA)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_AREA;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.MEDIDAS)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_MEDIDAS;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO;}
		if(sNombreColumna.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO2)) {sLabelColumna=DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO2;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleGuiaRemisionDescripcion(DetalleGuiaRemision detalleguiaremision) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleguiaremision !=null/* && detalleguiaremision.getId()!=0*/) {
			if(detalleguiaremision.getId()!=null) {
				sDescripcion=detalleguiaremision.getId().toString();
			}//detalleguiaremisiondetalleguiaremision.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleGuiaRemisionDescripcionDetallado(DetalleGuiaRemision detalleguiaremision) {
		String sDescripcion="";
			
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.ID+"=";
		sDescripcion+=detalleguiaremision.getId().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleguiaremision.getVersionRow().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleguiaremision.getid_empresa().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleguiaremision.getid_sucursal().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleguiaremision.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleguiaremision.getid_periodo().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION+"=";
		sDescripcion+=detalleguiaremision.getid_guia_remision().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleguiaremision.getid_bodega().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleguiaremision.getid_producto().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleguiaremision.getid_unidad().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleguiaremision.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES+"=";
		sDescripcion+=detalleguiaremision.getcantidad_envases().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR+"=";
		sDescripcion+=detalleguiaremision.getcantidad_auxiliar().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleguiaremision.getdescripcion()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleguiaremision.getcantidad().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.MONTO+"=";
		sDescripcion+=detalleguiaremision.getmonto().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.PRECIO+"=";
		sDescripcion+=detalleguiaremision.getprecio().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=detalleguiaremision.getporcentaje_descuento().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detalleguiaremision.getdescuento().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detalleguiaremision.getdescuento2().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.DESCUENTO3+"=";
		sDescripcion+=detalleguiaremision.getdescuento3().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA+"=";
		sDescripcion+=detalleguiaremision.getporcentaje_iva().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.IVA+"=";
		sDescripcion+=detalleguiaremision.getiva().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=detalleguiaremision.gettotal_descuento().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO+"=";
		sDescripcion+=detalleguiaremision.gettotal_impuesto().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detalleguiaremision.getsub_total().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.TOTAL+"=";
		sDescripcion+=detalleguiaremision.gettotal().toString()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.LOTE+"=";
		sDescripcion+=detalleguiaremision.getlote()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE+"=";
		sDescripcion+=detalleguiaremision.getlote_cliente()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA+"=";
		sDescripcion+=detalleguiaremision.getorden_compra()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.AREA+"=";
		sDescripcion+=detalleguiaremision.getarea()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.MEDIDAS+"=";
		sDescripcion+=detalleguiaremision.getmedidas()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.ACABADO+"=";
		sDescripcion+=detalleguiaremision.getacabado()+",";
		sDescripcion+=DetalleGuiaRemisionConstantesFunciones.ACABADO2+"=";
		sDescripcion+=detalleguiaremision.getacabado2()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleGuiaRemisionDescripcion(DetalleGuiaRemision detalleguiaremision,String sValor) throws Exception {			
		if(detalleguiaremision !=null) {
			//detalleguiaremisiondetalleguiaremision.getId().toString();
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

	public static String getGuiaRemisionDescripcion(GuiaRemision guiaremision) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(guiaremision!=null/*&&guiaremision.getId()>0*/) {
			sDescripcion=GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(guiaremision);
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGuiaRemision")) {
			sNombreIndice="Tipo=  Por Guia Remision";
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

	public static String getDetalleIndiceFK_IdGuiaRemision(Long id_guia_remision) {
		String sDetalleIndice=" Parametros->";
		if(id_guia_remision!=null) {sDetalleIndice+=" Codigo Unico De Guia Remision="+id_guia_remision.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleguiaremision.setdescripcion(detalleguiaremision.getdescripcion().trim());
		detalleguiaremision.setlote(detalleguiaremision.getlote().trim());
		detalleguiaremision.setlote_cliente(detalleguiaremision.getlote_cliente().trim());
		detalleguiaremision.setorden_compra(detalleguiaremision.getorden_compra().trim());
		detalleguiaremision.setarea(detalleguiaremision.getarea().trim());
		detalleguiaremision.setmedidas(detalleguiaremision.getmedidas().trim());
		detalleguiaremision.setacabado(detalleguiaremision.getacabado().trim());
		detalleguiaremision.setacabado2(detalleguiaremision.getacabado2().trim());
	}
	
	public static void quitarEspaciosDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {
			detalleguiaremision.setdescripcion(detalleguiaremision.getdescripcion().trim());
			detalleguiaremision.setlote(detalleguiaremision.getlote().trim());
			detalleguiaremision.setlote_cliente(detalleguiaremision.getlote_cliente().trim());
			detalleguiaremision.setorden_compra(detalleguiaremision.getorden_compra().trim());
			detalleguiaremision.setarea(detalleguiaremision.getarea().trim());
			detalleguiaremision.setmedidas(detalleguiaremision.getmedidas().trim());
			detalleguiaremision.setacabado(detalleguiaremision.getacabado().trim());
			detalleguiaremision.setacabado2(detalleguiaremision.getacabado2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleguiaremision.getConCambioAuxiliar()) {
			detalleguiaremision.setIsDeleted(detalleguiaremision.getIsDeletedAuxiliar());	
			detalleguiaremision.setIsNew(detalleguiaremision.getIsNewAuxiliar());	
			detalleguiaremision.setIsChanged(detalleguiaremision.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleguiaremision.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleguiaremision.setIsDeletedAuxiliar(false);	
			detalleguiaremision.setIsNewAuxiliar(false);	
			detalleguiaremision.setIsChangedAuxiliar(false);
			
			detalleguiaremision.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision : detalleguiaremisions) {
			if(conAsignarBase && detalleguiaremision.getConCambioAuxiliar()) {
				detalleguiaremision.setIsDeleted(detalleguiaremision.getIsDeletedAuxiliar());	
				detalleguiaremision.setIsNew(detalleguiaremision.getIsNewAuxiliar());	
				detalleguiaremision.setIsChanged(detalleguiaremision.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleguiaremision.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleguiaremision.setIsDeletedAuxiliar(false);	
				detalleguiaremision.setIsNewAuxiliar(false);	
				detalleguiaremision.setIsChangedAuxiliar(false);
				
				detalleguiaremision.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision,Boolean conEnteros) throws Exception  {
		detalleguiaremision.setmonto(0.0);
		detalleguiaremision.setprecio(0.0);
		detalleguiaremision.setporcentaje_descuento(0.0);
		detalleguiaremision.setdescuento(0.0);
		detalleguiaremision.setdescuento2(0.0);
		detalleguiaremision.setdescuento3(0.0);
		detalleguiaremision.setporcentaje_iva(0.0);
		detalleguiaremision.setiva(0.0);
		detalleguiaremision.settotal_descuento(0.0);
		detalleguiaremision.settotal_impuesto(0.0);
		detalleguiaremision.setsub_total(0.0);
		detalleguiaremision.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleguiaremision.setcantidad_envases(0);
			detalleguiaremision.setcantidad_auxiliar(0);
			detalleguiaremision.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions,Boolean conEnteros) throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {
			detalleguiaremision.setmonto(0.0);
			detalleguiaremision.setprecio(0.0);
			detalleguiaremision.setporcentaje_descuento(0.0);
			detalleguiaremision.setdescuento(0.0);
			detalleguiaremision.setdescuento2(0.0);
			detalleguiaremision.setdescuento3(0.0);
			detalleguiaremision.setporcentaje_iva(0.0);
			detalleguiaremision.setiva(0.0);
			detalleguiaremision.settotal_descuento(0.0);
			detalleguiaremision.settotal_impuesto(0.0);
			detalleguiaremision.setsub_total(0.0);
			detalleguiaremision.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleguiaremision.setcantidad_envases(0);
				detalleguiaremision.setcantidad_auxiliar(0);
				detalleguiaremision.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleGuiaRemision(List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemision detalleguiaremisionAux) throws Exception  {
		DetalleGuiaRemisionConstantesFunciones.InicializarValoresDetalleGuiaRemision(detalleguiaremisionAux,true);
		
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {
			if(detalleguiaremision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleguiaremisionAux.setcantidad_envases(detalleguiaremisionAux.getcantidad_envases()+detalleguiaremision.getcantidad_envases());			
			detalleguiaremisionAux.setcantidad_auxiliar(detalleguiaremisionAux.getcantidad_auxiliar()+detalleguiaremision.getcantidad_auxiliar());			
			detalleguiaremisionAux.setcantidad(detalleguiaremisionAux.getcantidad()+detalleguiaremision.getcantidad());			
			detalleguiaremisionAux.setmonto(detalleguiaremisionAux.getmonto()+detalleguiaremision.getmonto());			
			detalleguiaremisionAux.setprecio(detalleguiaremisionAux.getprecio()+detalleguiaremision.getprecio());			
			detalleguiaremisionAux.setporcentaje_descuento(detalleguiaremisionAux.getporcentaje_descuento()+detalleguiaremision.getporcentaje_descuento());			
			detalleguiaremisionAux.setdescuento(detalleguiaremisionAux.getdescuento()+detalleguiaremision.getdescuento());			
			detalleguiaremisionAux.setdescuento2(detalleguiaremisionAux.getdescuento2()+detalleguiaremision.getdescuento2());			
			detalleguiaremisionAux.setdescuento3(detalleguiaremisionAux.getdescuento3()+detalleguiaremision.getdescuento3());			
			detalleguiaremisionAux.setporcentaje_iva(detalleguiaremisionAux.getporcentaje_iva()+detalleguiaremision.getporcentaje_iva());			
			detalleguiaremisionAux.setiva(detalleguiaremisionAux.getiva()+detalleguiaremision.getiva());			
			detalleguiaremisionAux.settotal_descuento(detalleguiaremisionAux.gettotal_descuento()+detalleguiaremision.gettotal_descuento());			
			detalleguiaremisionAux.settotal_impuesto(detalleguiaremisionAux.gettotal_impuesto()+detalleguiaremision.gettotal_impuesto());			
			detalleguiaremisionAux.setsub_total(detalleguiaremisionAux.getsub_total()+detalleguiaremision.getsub_total());			
			detalleguiaremisionAux.settotal(detalleguiaremisionAux.gettotal()+detalleguiaremision.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleGuiaRemisionConstantesFunciones.getArrayColumnasGlobalesDetalleGuiaRemision(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleGuiaRemisionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemision detalleguiaremision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleGuiaRemision detalleguiaremisionAux: detalleguiaremisions) {
			if(detalleguiaremisionAux!=null && detalleguiaremision!=null) {
				if((detalleguiaremisionAux.getId()==null && detalleguiaremision.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleguiaremisionAux.getId()!=null && detalleguiaremision.getId()!=null){
					if(detalleguiaremisionAux.getId().equals(detalleguiaremision.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleGuiaRemision(List<DetalleGuiaRemision> detalleguiaremisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double precioTotal=0.0;
		Double porcentaje_descuentoTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento2Total=0.0;
		Double descuento3Total=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double total_impuestoTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {			
			if(detalleguiaremision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=detalleguiaremision.getmonto();
			precioTotal+=detalleguiaremision.getprecio();
			porcentaje_descuentoTotal+=detalleguiaremision.getporcentaje_descuento();
			descuentoTotal+=detalleguiaremision.getdescuento();
			descuento2Total+=detalleguiaremision.getdescuento2();
			descuento3Total+=detalleguiaremision.getdescuento3();
			porcentaje_ivaTotal+=detalleguiaremision.getporcentaje_iva();
			ivaTotal+=detalleguiaremision.getiva();
			total_descuentoTotal+=detalleguiaremision.gettotal_descuento();
			total_impuestoTotal+=detalleguiaremision.gettotal_impuesto();
			sub_totalTotal+=detalleguiaremision.getsub_total();
			totalTotal+=detalleguiaremision.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3);
		datoGeneral.setdValorDouble(descuento3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO);
		datoGeneral.setdValorDouble(total_impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleGuiaRemision() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_ID, DetalleGuiaRemisionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_VERSIONROW, DetalleGuiaRemisionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDEMPRESA, DetalleGuiaRemisionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL, DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO, DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDPERIODO, DetalleGuiaRemisionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDGUIAREMISION, DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDBODEGA, DetalleGuiaRemisionConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDPRODUCTO, DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDUNIDAD, DetalleGuiaRemisionConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADENVASES, DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADAUXILIAR, DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_DESCRIPCION, DetalleGuiaRemisionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDAD, DetalleGuiaRemisionConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO, DetalleGuiaRemisionConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO, DetalleGuiaRemisionConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO, DetalleGuiaRemisionConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2, DetalleGuiaRemisionConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3, DetalleGuiaRemisionConstantesFunciones.DESCUENTO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA, DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_IVA, DetalleGuiaRemisionConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO, DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO, DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL, DetalleGuiaRemisionConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL, DetalleGuiaRemisionConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_LOTE, DetalleGuiaRemisionConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_LOTECLIENTE, DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_ORDENCOMPRA, DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_AREA, DetalleGuiaRemisionConstantesFunciones.AREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_MEDIDAS, DetalleGuiaRemisionConstantesFunciones.MEDIDAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO, DetalleGuiaRemisionConstantesFunciones.ACABADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO2, DetalleGuiaRemisionConstantesFunciones.ACABADO2,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleGuiaRemision() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.DESCUENTO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.AREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.MEDIDAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.ACABADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGuiaRemisionConstantesFunciones.ACABADO2;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGuiaRemision() throws Exception  {
		return DetalleGuiaRemisionConstantesFunciones.getTiposSeleccionarDetalleGuiaRemision(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGuiaRemision(Boolean conFk) throws Exception  {
		return DetalleGuiaRemisionConstantesFunciones.getTiposSeleccionarDetalleGuiaRemision(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGuiaRemision(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDGUIAREMISION);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDGUIAREMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADENVASES);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADENVASES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADAUXILIAR);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTECLIENTE);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_ORDENCOMPRA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_ORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_AREA);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_AREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_MEDIDAS);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_MEDIDAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO2);
			reporte.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleGuiaRemision(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremisionAux) throws Exception {
		
			detalleguiaremisionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleguiaremisionAux.getEmpresa()));
			detalleguiaremisionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleguiaremisionAux.getSucursal()));
			detalleguiaremisionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleguiaremisionAux.getEjercicio()));
			detalleguiaremisionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleguiaremisionAux.getPeriodo()));
			detalleguiaremisionAux.setguiaremision_descripcion(GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(detalleguiaremisionAux.getGuiaRemision()));
			detalleguiaremisionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleguiaremisionAux.getBodega()));
			detalleguiaremisionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleguiaremisionAux.getProducto()));
			detalleguiaremisionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleguiaremisionAux.getUnidad()));
			detalleguiaremisionAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleguiaremisionAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleGuiaRemision(List<DetalleGuiaRemision> detalleguiaremisionsTemp) throws Exception {
		for(DetalleGuiaRemision detalleguiaremisionAux:detalleguiaremisionsTemp) {
			
			detalleguiaremisionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleguiaremisionAux.getEmpresa()));
			detalleguiaremisionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleguiaremisionAux.getSucursal()));
			detalleguiaremisionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleguiaremisionAux.getEjercicio()));
			detalleguiaremisionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleguiaremisionAux.getPeriodo()));
			detalleguiaremisionAux.setguiaremision_descripcion(GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(detalleguiaremisionAux.getGuiaRemision()));
			detalleguiaremisionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleguiaremisionAux.getBodega()));
			detalleguiaremisionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleguiaremisionAux.getProducto()));
			detalleguiaremisionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleguiaremisionAux.getUnidad()));
			detalleguiaremisionAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleguiaremisionAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(GuiaRemision.class));
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
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
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

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleGuiaRemisionConstantesFunciones.getClassesRelationshipsOfDetalleGuiaRemision(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleGuiaRemisionConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleGuiaRemision(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleGuiaRemision detalleguiaremision,List<DetalleGuiaRemision> detalleguiaremisions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleGuiaRemision detalleguiaremisionEncontrado=null;
			
			for(DetalleGuiaRemision detalleguiaremisionLocal:detalleguiaremisions) {
				if(detalleguiaremisionLocal.getId().equals(detalleguiaremision.getId())) {
					detalleguiaremisionEncontrado=detalleguiaremisionLocal;
					
					detalleguiaremisionLocal.setIsChanged(detalleguiaremision.getIsChanged());
					detalleguiaremisionLocal.setIsNew(detalleguiaremision.getIsNew());
					detalleguiaremisionLocal.setIsDeleted(detalleguiaremision.getIsDeleted());
					
					detalleguiaremisionLocal.setGeneralEntityOriginal(detalleguiaremision.getGeneralEntityOriginal());
					
					detalleguiaremisionLocal.setId(detalleguiaremision.getId());	
					detalleguiaremisionLocal.setVersionRow(detalleguiaremision.getVersionRow());	
					detalleguiaremisionLocal.setid_empresa(detalleguiaremision.getid_empresa());	
					detalleguiaremisionLocal.setid_sucursal(detalleguiaremision.getid_sucursal());	
					detalleguiaremisionLocal.setid_ejercicio(detalleguiaremision.getid_ejercicio());	
					detalleguiaremisionLocal.setid_periodo(detalleguiaremision.getid_periodo());	
					detalleguiaremisionLocal.setid_guia_remision(detalleguiaremision.getid_guia_remision());	
					detalleguiaremisionLocal.setid_bodega(detalleguiaremision.getid_bodega());	
					detalleguiaremisionLocal.setid_producto(detalleguiaremision.getid_producto());	
					detalleguiaremisionLocal.setid_unidad(detalleguiaremision.getid_unidad());	
					detalleguiaremisionLocal.setid_centro_costo(detalleguiaremision.getid_centro_costo());	
					detalleguiaremisionLocal.setcantidad_envases(detalleguiaremision.getcantidad_envases());	
					detalleguiaremisionLocal.setcantidad_auxiliar(detalleguiaremision.getcantidad_auxiliar());	
					detalleguiaremisionLocal.setdescripcion(detalleguiaremision.getdescripcion());	
					detalleguiaremisionLocal.setcantidad(detalleguiaremision.getcantidad());	
					detalleguiaremisionLocal.setmonto(detalleguiaremision.getmonto());	
					detalleguiaremisionLocal.setprecio(detalleguiaremision.getprecio());	
					detalleguiaremisionLocal.setporcentaje_descuento(detalleguiaremision.getporcentaje_descuento());	
					detalleguiaremisionLocal.setdescuento(detalleguiaremision.getdescuento());	
					detalleguiaremisionLocal.setdescuento2(detalleguiaremision.getdescuento2());	
					detalleguiaremisionLocal.setdescuento3(detalleguiaremision.getdescuento3());	
					detalleguiaremisionLocal.setporcentaje_iva(detalleguiaremision.getporcentaje_iva());	
					detalleguiaremisionLocal.setiva(detalleguiaremision.getiva());	
					detalleguiaremisionLocal.settotal_descuento(detalleguiaremision.gettotal_descuento());	
					detalleguiaremisionLocal.settotal_impuesto(detalleguiaremision.gettotal_impuesto());	
					detalleguiaremisionLocal.setsub_total(detalleguiaremision.getsub_total());	
					detalleguiaremisionLocal.settotal(detalleguiaremision.gettotal());	
					detalleguiaremisionLocal.setlote(detalleguiaremision.getlote());	
					detalleguiaremisionLocal.setlote_cliente(detalleguiaremision.getlote_cliente());	
					detalleguiaremisionLocal.setorden_compra(detalleguiaremision.getorden_compra());	
					detalleguiaremisionLocal.setarea(detalleguiaremision.getarea());	
					detalleguiaremisionLocal.setmedidas(detalleguiaremision.getmedidas());	
					detalleguiaremisionLocal.setacabado(detalleguiaremision.getacabado());	
					detalleguiaremisionLocal.setacabado2(detalleguiaremision.getacabado2());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleguiaremision.getIsDeleted()) {
				if(!existe) {
					detalleguiaremisions.add(detalleguiaremision);
				}
			} else {
				if(detalleguiaremisionEncontrado!=null && permiteQuitar)  {
					detalleguiaremisions.remove(detalleguiaremisionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleGuiaRemision detalleguiaremision,List<DetalleGuiaRemision> detalleguiaremisions) throws Exception {
		try	{			
			for(DetalleGuiaRemision detalleguiaremisionLocal:detalleguiaremisions) {
				if(detalleguiaremisionLocal.getId().equals(detalleguiaremision.getId())) {
					detalleguiaremisionLocal.setIsSelected(detalleguiaremision.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleGuiaRemision(List<DetalleGuiaRemision> detalleguiaremisionsAux) throws Exception {
		//this.detalleguiaremisionsAux=detalleguiaremisionsAux;
		
		for(DetalleGuiaRemision detalleguiaremisionAux:detalleguiaremisionsAux) {
			if(detalleguiaremisionAux.getIsChanged()) {
				detalleguiaremisionAux.setIsChanged(false);
			}		
			
			if(detalleguiaremisionAux.getIsNew()) {
				detalleguiaremisionAux.setIsNew(false);
			}	
			
			if(detalleguiaremisionAux.getIsDeleted()) {
				detalleguiaremisionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremisionAux) throws Exception {
		//this.detalleguiaremisionAux=detalleguiaremisionAux;
		
			if(detalleguiaremisionAux.getIsChanged()) {
				detalleguiaremisionAux.setIsChanged(false);
			}		
			
			if(detalleguiaremisionAux.getIsNew()) {
				detalleguiaremisionAux.setIsNew(false);
			}	
			
			if(detalleguiaremisionAux.getIsDeleted()) {
				detalleguiaremisionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleGuiaRemision detalleguiaremisionAsignar,DetalleGuiaRemision detalleguiaremision) throws Exception {
		detalleguiaremisionAsignar.setId(detalleguiaremision.getId());	
		detalleguiaremisionAsignar.setVersionRow(detalleguiaremision.getVersionRow());	
		detalleguiaremisionAsignar.setid_empresa(detalleguiaremision.getid_empresa());
		detalleguiaremisionAsignar.setempresa_descripcion(detalleguiaremision.getempresa_descripcion());	
		detalleguiaremisionAsignar.setid_sucursal(detalleguiaremision.getid_sucursal());
		detalleguiaremisionAsignar.setsucursal_descripcion(detalleguiaremision.getsucursal_descripcion());	
		detalleguiaremisionAsignar.setid_ejercicio(detalleguiaremision.getid_ejercicio());
		detalleguiaremisionAsignar.setejercicio_descripcion(detalleguiaremision.getejercicio_descripcion());	
		detalleguiaremisionAsignar.setid_periodo(detalleguiaremision.getid_periodo());
		detalleguiaremisionAsignar.setperiodo_descripcion(detalleguiaremision.getperiodo_descripcion());	
		detalleguiaremisionAsignar.setid_guia_remision(detalleguiaremision.getid_guia_remision());
		detalleguiaremisionAsignar.setguiaremision_descripcion(detalleguiaremision.getguiaremision_descripcion());	
		detalleguiaremisionAsignar.setid_bodega(detalleguiaremision.getid_bodega());
		detalleguiaremisionAsignar.setbodega_descripcion(detalleguiaremision.getbodega_descripcion());	
		detalleguiaremisionAsignar.setid_producto(detalleguiaremision.getid_producto());
		detalleguiaremisionAsignar.setproducto_descripcion(detalleguiaremision.getproducto_descripcion());	
		detalleguiaremisionAsignar.setid_unidad(detalleguiaremision.getid_unidad());
		detalleguiaremisionAsignar.setunidad_descripcion(detalleguiaremision.getunidad_descripcion());	
		detalleguiaremisionAsignar.setid_centro_costo(detalleguiaremision.getid_centro_costo());
		detalleguiaremisionAsignar.setcentrocosto_descripcion(detalleguiaremision.getcentrocosto_descripcion());	
		detalleguiaremisionAsignar.setcantidad_envases(detalleguiaremision.getcantidad_envases());	
		detalleguiaremisionAsignar.setcantidad_auxiliar(detalleguiaremision.getcantidad_auxiliar());	
		detalleguiaremisionAsignar.setdescripcion(detalleguiaremision.getdescripcion());	
		detalleguiaremisionAsignar.setcantidad(detalleguiaremision.getcantidad());	
		detalleguiaremisionAsignar.setmonto(detalleguiaremision.getmonto());	
		detalleguiaremisionAsignar.setprecio(detalleguiaremision.getprecio());	
		detalleguiaremisionAsignar.setporcentaje_descuento(detalleguiaremision.getporcentaje_descuento());	
		detalleguiaremisionAsignar.setdescuento(detalleguiaremision.getdescuento());	
		detalleguiaremisionAsignar.setdescuento2(detalleguiaremision.getdescuento2());	
		detalleguiaremisionAsignar.setdescuento3(detalleguiaremision.getdescuento3());	
		detalleguiaremisionAsignar.setporcentaje_iva(detalleguiaremision.getporcentaje_iva());	
		detalleguiaremisionAsignar.setiva(detalleguiaremision.getiva());	
		detalleguiaremisionAsignar.settotal_descuento(detalleguiaremision.gettotal_descuento());	
		detalleguiaremisionAsignar.settotal_impuesto(detalleguiaremision.gettotal_impuesto());	
		detalleguiaremisionAsignar.setsub_total(detalleguiaremision.getsub_total());	
		detalleguiaremisionAsignar.settotal(detalleguiaremision.gettotal());	
		detalleguiaremisionAsignar.setlote(detalleguiaremision.getlote());	
		detalleguiaremisionAsignar.setlote_cliente(detalleguiaremision.getlote_cliente());	
		detalleguiaremisionAsignar.setorden_compra(detalleguiaremision.getorden_compra());	
		detalleguiaremisionAsignar.setarea(detalleguiaremision.getarea());	
		detalleguiaremisionAsignar.setmedidas(detalleguiaremision.getmedidas());	
		detalleguiaremisionAsignar.setacabado(detalleguiaremision.getacabado());	
		detalleguiaremisionAsignar.setacabado2(detalleguiaremision.getacabado2());	
	}
	
	public static void inicializarDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision) throws Exception {
		try {
				detalleguiaremision.setId(0L);	
					
				detalleguiaremision.setid_empresa(-1L);	
				detalleguiaremision.setid_sucursal(-1L);	
				detalleguiaremision.setid_ejercicio(-1L);	
				detalleguiaremision.setid_periodo(-1L);	
				detalleguiaremision.setid_guia_remision(-1L);	
				detalleguiaremision.setid_bodega(-1L);	
				detalleguiaremision.setid_producto(-1L);	
				detalleguiaremision.setid_unidad(-1L);	
				detalleguiaremision.setid_centro_costo(null);	
				detalleguiaremision.setcantidad_envases(0);	
				detalleguiaremision.setcantidad_auxiliar(0);	
				detalleguiaremision.setdescripcion("");	
				detalleguiaremision.setcantidad(0);	
				detalleguiaremision.setmonto(0.0);	
				detalleguiaremision.setprecio(0.0);	
				detalleguiaremision.setporcentaje_descuento(0.0);	
				detalleguiaremision.setdescuento(0.0);	
				detalleguiaremision.setdescuento2(0.0);	
				detalleguiaremision.setdescuento3(0.0);	
				detalleguiaremision.setporcentaje_iva(0.0);	
				detalleguiaremision.setiva(0.0);	
				detalleguiaremision.settotal_descuento(0.0);	
				detalleguiaremision.settotal_impuesto(0.0);	
				detalleguiaremision.setsub_total(0.0);	
				detalleguiaremision.settotal(0.0);	
				detalleguiaremision.setlote("");	
				detalleguiaremision.setlote_cliente("");	
				detalleguiaremision.setorden_compra("");	
				detalleguiaremision.setarea("");	
				detalleguiaremision.setmedidas("");	
				detalleguiaremision.setacabado("");	
				detalleguiaremision.setacabado2("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleGuiaRemision(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDGUIAREMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADENVASES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDADAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_LOTECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_ORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_AREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_MEDIDAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGuiaRemisionConstantesFunciones.LABEL_ACABADO2);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleGuiaRemision(String sTipo,Row row,Workbook workbook,DetalleGuiaRemision detalleguiaremision,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getguiaremision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getcantidad_envases());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getcantidad_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getdescuento3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getporcentaje_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.gettotal_impuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getlote_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getorden_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getmedidas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getacabado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleguiaremision.getacabado2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleGuiaRemision=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleGuiaRemision() {
		return this.sFinalQueryDetalleGuiaRemision;
	}
	
	public void setsFinalQueryDetalleGuiaRemision(String sFinalQueryDetalleGuiaRemision) {
		this.sFinalQueryDetalleGuiaRemision= sFinalQueryDetalleGuiaRemision;
	}
	
	public Border resaltarSeleccionarDetalleGuiaRemision=null;
	
	public Border setResaltarSeleccionarDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleGuiaRemision= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleGuiaRemision() {
		return this.resaltarSeleccionarDetalleGuiaRemision;
	}
	
	public void setResaltarSeleccionarDetalleGuiaRemision(Border borderResaltarSeleccionarDetalleGuiaRemision) {
		this.resaltarSeleccionarDetalleGuiaRemision= borderResaltarSeleccionarDetalleGuiaRemision;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleGuiaRemision=null;
	public Boolean mostraridDetalleGuiaRemision=true;
	public Boolean activaridDetalleGuiaRemision=true;

	public Border resaltarid_empresaDetalleGuiaRemision=null;
	public Boolean mostrarid_empresaDetalleGuiaRemision=true;
	public Boolean activarid_empresaDetalleGuiaRemision=true;
	public Boolean cargarid_empresaDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleGuiaRemision=null;
	public Boolean mostrarid_sucursalDetalleGuiaRemision=true;
	public Boolean activarid_sucursalDetalleGuiaRemision=true;
	public Boolean cargarid_sucursalDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleGuiaRemision=null;
	public Boolean mostrarid_ejercicioDetalleGuiaRemision=true;
	public Boolean activarid_ejercicioDetalleGuiaRemision=true;
	public Boolean cargarid_ejercicioDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleGuiaRemision=null;
	public Boolean mostrarid_periodoDetalleGuiaRemision=true;
	public Boolean activarid_periodoDetalleGuiaRemision=true;
	public Boolean cargarid_periodoDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_guia_remisionDetalleGuiaRemision=null;
	public Boolean mostrarid_guia_remisionDetalleGuiaRemision=true;
	public Boolean activarid_guia_remisionDetalleGuiaRemision=true;
	public Boolean cargarid_guia_remisionDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_guia_remisionDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleGuiaRemision=null;
	public Boolean mostrarid_bodegaDetalleGuiaRemision=true;
	public Boolean activarid_bodegaDetalleGuiaRemision=true;
	public Boolean cargarid_bodegaDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleGuiaRemision=null;
	public Boolean mostrarid_productoDetalleGuiaRemision=true;
	public Boolean activarid_productoDetalleGuiaRemision=true;
	public Boolean cargarid_productoDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleGuiaRemision=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleGuiaRemision=null;
	public Boolean mostrarid_unidadDetalleGuiaRemision=true;
	public Boolean activarid_unidadDetalleGuiaRemision=true;
	public Boolean cargarid_unidadDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleGuiaRemision=true;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleGuiaRemision=null;
	public Boolean mostrarid_centro_costoDetalleGuiaRemision=true;
	public Boolean activarid_centro_costoDetalleGuiaRemision=true;
	public Boolean cargarid_centro_costoDetalleGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleGuiaRemision=false;//ConEventDepend=true

	public Border resaltarcantidad_envasesDetalleGuiaRemision=null;
	public Boolean mostrarcantidad_envasesDetalleGuiaRemision=true;
	public Boolean activarcantidad_envasesDetalleGuiaRemision=true;

	public Border resaltarcantidad_auxiliarDetalleGuiaRemision=null;
	public Boolean mostrarcantidad_auxiliarDetalleGuiaRemision=true;
	public Boolean activarcantidad_auxiliarDetalleGuiaRemision=true;

	public Border resaltardescripcionDetalleGuiaRemision=null;
	public Boolean mostrardescripcionDetalleGuiaRemision=true;
	public Boolean activardescripcionDetalleGuiaRemision=true;

	public Border resaltarcantidadDetalleGuiaRemision=null;
	public Boolean mostrarcantidadDetalleGuiaRemision=true;
	public Boolean activarcantidadDetalleGuiaRemision=true;

	public Border resaltarmontoDetalleGuiaRemision=null;
	public Boolean mostrarmontoDetalleGuiaRemision=true;
	public Boolean activarmontoDetalleGuiaRemision=true;

	public Border resaltarprecioDetalleGuiaRemision=null;
	public Boolean mostrarprecioDetalleGuiaRemision=true;
	public Boolean activarprecioDetalleGuiaRemision=true;

	public Border resaltarporcentaje_descuentoDetalleGuiaRemision=null;
	public Boolean mostrarporcentaje_descuentoDetalleGuiaRemision=true;
	public Boolean activarporcentaje_descuentoDetalleGuiaRemision=true;

	public Border resaltardescuentoDetalleGuiaRemision=null;
	public Boolean mostrardescuentoDetalleGuiaRemision=true;
	public Boolean activardescuentoDetalleGuiaRemision=true;

	public Border resaltardescuento2DetalleGuiaRemision=null;
	public Boolean mostrardescuento2DetalleGuiaRemision=true;
	public Boolean activardescuento2DetalleGuiaRemision=true;

	public Border resaltardescuento3DetalleGuiaRemision=null;
	public Boolean mostrardescuento3DetalleGuiaRemision=true;
	public Boolean activardescuento3DetalleGuiaRemision=true;

	public Border resaltarporcentaje_ivaDetalleGuiaRemision=null;
	public Boolean mostrarporcentaje_ivaDetalleGuiaRemision=true;
	public Boolean activarporcentaje_ivaDetalleGuiaRemision=true;

	public Border resaltarivaDetalleGuiaRemision=null;
	public Boolean mostrarivaDetalleGuiaRemision=true;
	public Boolean activarivaDetalleGuiaRemision=true;

	public Border resaltartotal_descuentoDetalleGuiaRemision=null;
	public Boolean mostrartotal_descuentoDetalleGuiaRemision=true;
	public Boolean activartotal_descuentoDetalleGuiaRemision=true;

	public Border resaltartotal_impuestoDetalleGuiaRemision=null;
	public Boolean mostrartotal_impuestoDetalleGuiaRemision=true;
	public Boolean activartotal_impuestoDetalleGuiaRemision=true;

	public Border resaltarsub_totalDetalleGuiaRemision=null;
	public Boolean mostrarsub_totalDetalleGuiaRemision=true;
	public Boolean activarsub_totalDetalleGuiaRemision=true;

	public Border resaltartotalDetalleGuiaRemision=null;
	public Boolean mostrartotalDetalleGuiaRemision=true;
	public Boolean activartotalDetalleGuiaRemision=true;

	public Border resaltarloteDetalleGuiaRemision=null;
	public Boolean mostrarloteDetalleGuiaRemision=true;
	public Boolean activarloteDetalleGuiaRemision=true;

	public Border resaltarlote_clienteDetalleGuiaRemision=null;
	public Boolean mostrarlote_clienteDetalleGuiaRemision=true;
	public Boolean activarlote_clienteDetalleGuiaRemision=true;

	public Border resaltarorden_compraDetalleGuiaRemision=null;
	public Boolean mostrarorden_compraDetalleGuiaRemision=true;
	public Boolean activarorden_compraDetalleGuiaRemision=true;

	public Border resaltarareaDetalleGuiaRemision=null;
	public Boolean mostrarareaDetalleGuiaRemision=true;
	public Boolean activarareaDetalleGuiaRemision=true;

	public Border resaltarmedidasDetalleGuiaRemision=null;
	public Boolean mostrarmedidasDetalleGuiaRemision=true;
	public Boolean activarmedidasDetalleGuiaRemision=true;

	public Border resaltaracabadoDetalleGuiaRemision=null;
	public Boolean mostraracabadoDetalleGuiaRemision=true;
	public Boolean activaracabadoDetalleGuiaRemision=true;

	public Border resaltaracabado2DetalleGuiaRemision=null;
	public Boolean mostraracabado2DetalleGuiaRemision=true;
	public Boolean activaracabado2DetalleGuiaRemision=true;

	
	

	public Border setResaltaridDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltaridDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleGuiaRemision() {
		return this.resaltaridDetalleGuiaRemision;
	}

	public void setResaltaridDetalleGuiaRemision(Border borderResaltar) {
		this.resaltaridDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostraridDetalleGuiaRemision() {
		return this.mostraridDetalleGuiaRemision;
	}

	public void setMostraridDetalleGuiaRemision(Boolean mostraridDetalleGuiaRemision) {
		this.mostraridDetalleGuiaRemision= mostraridDetalleGuiaRemision;
	}

	public Boolean getActivaridDetalleGuiaRemision() {
		return this.activaridDetalleGuiaRemision;
	}

	public void setActivaridDetalleGuiaRemision(Boolean activaridDetalleGuiaRemision) {
		this.activaridDetalleGuiaRemision= activaridDetalleGuiaRemision;
	}

	public Border setResaltarid_empresaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleGuiaRemision() {
		return this.resaltarid_empresaDetalleGuiaRemision;
	}

	public void setResaltarid_empresaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_empresaDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleGuiaRemision() {
		return this.mostrarid_empresaDetalleGuiaRemision;
	}

	public void setMostrarid_empresaDetalleGuiaRemision(Boolean mostrarid_empresaDetalleGuiaRemision) {
		this.mostrarid_empresaDetalleGuiaRemision= mostrarid_empresaDetalleGuiaRemision;
	}

	public Boolean getActivarid_empresaDetalleGuiaRemision() {
		return this.activarid_empresaDetalleGuiaRemision;
	}

	public void setActivarid_empresaDetalleGuiaRemision(Boolean activarid_empresaDetalleGuiaRemision) {
		this.activarid_empresaDetalleGuiaRemision= activarid_empresaDetalleGuiaRemision;
	}

	public Boolean getCargarid_empresaDetalleGuiaRemision() {
		return this.cargarid_empresaDetalleGuiaRemision;
	}

	public void setCargarid_empresaDetalleGuiaRemision(Boolean cargarid_empresaDetalleGuiaRemision) {
		this.cargarid_empresaDetalleGuiaRemision= cargarid_empresaDetalleGuiaRemision;
	}

	public Border setResaltarid_sucursalDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleGuiaRemision() {
		return this.resaltarid_sucursalDetalleGuiaRemision;
	}

	public void setResaltarid_sucursalDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_sucursalDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleGuiaRemision() {
		return this.mostrarid_sucursalDetalleGuiaRemision;
	}

	public void setMostrarid_sucursalDetalleGuiaRemision(Boolean mostrarid_sucursalDetalleGuiaRemision) {
		this.mostrarid_sucursalDetalleGuiaRemision= mostrarid_sucursalDetalleGuiaRemision;
	}

	public Boolean getActivarid_sucursalDetalleGuiaRemision() {
		return this.activarid_sucursalDetalleGuiaRemision;
	}

	public void setActivarid_sucursalDetalleGuiaRemision(Boolean activarid_sucursalDetalleGuiaRemision) {
		this.activarid_sucursalDetalleGuiaRemision= activarid_sucursalDetalleGuiaRemision;
	}

	public Boolean getCargarid_sucursalDetalleGuiaRemision() {
		return this.cargarid_sucursalDetalleGuiaRemision;
	}

	public void setCargarid_sucursalDetalleGuiaRemision(Boolean cargarid_sucursalDetalleGuiaRemision) {
		this.cargarid_sucursalDetalleGuiaRemision= cargarid_sucursalDetalleGuiaRemision;
	}

	public Border setResaltarid_ejercicioDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleGuiaRemision() {
		return this.resaltarid_ejercicioDetalleGuiaRemision;
	}

	public void setResaltarid_ejercicioDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleGuiaRemision() {
		return this.mostrarid_ejercicioDetalleGuiaRemision;
	}

	public void setMostrarid_ejercicioDetalleGuiaRemision(Boolean mostrarid_ejercicioDetalleGuiaRemision) {
		this.mostrarid_ejercicioDetalleGuiaRemision= mostrarid_ejercicioDetalleGuiaRemision;
	}

	public Boolean getActivarid_ejercicioDetalleGuiaRemision() {
		return this.activarid_ejercicioDetalleGuiaRemision;
	}

	public void setActivarid_ejercicioDetalleGuiaRemision(Boolean activarid_ejercicioDetalleGuiaRemision) {
		this.activarid_ejercicioDetalleGuiaRemision= activarid_ejercicioDetalleGuiaRemision;
	}

	public Boolean getCargarid_ejercicioDetalleGuiaRemision() {
		return this.cargarid_ejercicioDetalleGuiaRemision;
	}

	public void setCargarid_ejercicioDetalleGuiaRemision(Boolean cargarid_ejercicioDetalleGuiaRemision) {
		this.cargarid_ejercicioDetalleGuiaRemision= cargarid_ejercicioDetalleGuiaRemision;
	}

	public Border setResaltarid_periodoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleGuiaRemision() {
		return this.resaltarid_periodoDetalleGuiaRemision;
	}

	public void setResaltarid_periodoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_periodoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleGuiaRemision() {
		return this.mostrarid_periodoDetalleGuiaRemision;
	}

	public void setMostrarid_periodoDetalleGuiaRemision(Boolean mostrarid_periodoDetalleGuiaRemision) {
		this.mostrarid_periodoDetalleGuiaRemision= mostrarid_periodoDetalleGuiaRemision;
	}

	public Boolean getActivarid_periodoDetalleGuiaRemision() {
		return this.activarid_periodoDetalleGuiaRemision;
	}

	public void setActivarid_periodoDetalleGuiaRemision(Boolean activarid_periodoDetalleGuiaRemision) {
		this.activarid_periodoDetalleGuiaRemision= activarid_periodoDetalleGuiaRemision;
	}

	public Boolean getCargarid_periodoDetalleGuiaRemision() {
		return this.cargarid_periodoDetalleGuiaRemision;
	}

	public void setCargarid_periodoDetalleGuiaRemision(Boolean cargarid_periodoDetalleGuiaRemision) {
		this.cargarid_periodoDetalleGuiaRemision= cargarid_periodoDetalleGuiaRemision;
	}

	public Border setResaltarid_guia_remisionDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_guia_remisionDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_guia_remisionDetalleGuiaRemision() {
		return this.resaltarid_guia_remisionDetalleGuiaRemision;
	}

	public void setResaltarid_guia_remisionDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_guia_remisionDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_guia_remisionDetalleGuiaRemision() {
		return this.mostrarid_guia_remisionDetalleGuiaRemision;
	}

	public void setMostrarid_guia_remisionDetalleGuiaRemision(Boolean mostrarid_guia_remisionDetalleGuiaRemision) {
		this.mostrarid_guia_remisionDetalleGuiaRemision= mostrarid_guia_remisionDetalleGuiaRemision;
	}

	public Boolean getActivarid_guia_remisionDetalleGuiaRemision() {
		return this.activarid_guia_remisionDetalleGuiaRemision;
	}

	public void setActivarid_guia_remisionDetalleGuiaRemision(Boolean activarid_guia_remisionDetalleGuiaRemision) {
		this.activarid_guia_remisionDetalleGuiaRemision= activarid_guia_remisionDetalleGuiaRemision;
	}

	public Boolean getCargarid_guia_remisionDetalleGuiaRemision() {
		return this.cargarid_guia_remisionDetalleGuiaRemision;
	}

	public void setCargarid_guia_remisionDetalleGuiaRemision(Boolean cargarid_guia_remisionDetalleGuiaRemision) {
		this.cargarid_guia_remisionDetalleGuiaRemision= cargarid_guia_remisionDetalleGuiaRemision;
	}

	public Border setResaltarid_bodegaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleGuiaRemision() {
		return this.resaltarid_bodegaDetalleGuiaRemision;
	}

	public void setResaltarid_bodegaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_bodegaDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleGuiaRemision() {
		return this.mostrarid_bodegaDetalleGuiaRemision;
	}

	public void setMostrarid_bodegaDetalleGuiaRemision(Boolean mostrarid_bodegaDetalleGuiaRemision) {
		this.mostrarid_bodegaDetalleGuiaRemision= mostrarid_bodegaDetalleGuiaRemision;
	}

	public Boolean getActivarid_bodegaDetalleGuiaRemision() {
		return this.activarid_bodegaDetalleGuiaRemision;
	}

	public void setActivarid_bodegaDetalleGuiaRemision(Boolean activarid_bodegaDetalleGuiaRemision) {
		this.activarid_bodegaDetalleGuiaRemision= activarid_bodegaDetalleGuiaRemision;
	}

	public Boolean getCargarid_bodegaDetalleGuiaRemision() {
		return this.cargarid_bodegaDetalleGuiaRemision;
	}

	public void setCargarid_bodegaDetalleGuiaRemision(Boolean cargarid_bodegaDetalleGuiaRemision) {
		this.cargarid_bodegaDetalleGuiaRemision= cargarid_bodegaDetalleGuiaRemision;
	}

	public Border setResaltarid_productoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleGuiaRemision() {
		return this.resaltarid_productoDetalleGuiaRemision;
	}

	public void setResaltarid_productoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_productoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleGuiaRemision() {
		return this.mostrarid_productoDetalleGuiaRemision;
	}

	public void setMostrarid_productoDetalleGuiaRemision(Boolean mostrarid_productoDetalleGuiaRemision) {
		this.mostrarid_productoDetalleGuiaRemision= mostrarid_productoDetalleGuiaRemision;
	}

	public Boolean getActivarid_productoDetalleGuiaRemision() {
		return this.activarid_productoDetalleGuiaRemision;
	}

	public void setActivarid_productoDetalleGuiaRemision(Boolean activarid_productoDetalleGuiaRemision) {
		this.activarid_productoDetalleGuiaRemision= activarid_productoDetalleGuiaRemision;
	}

	public Boolean getCargarid_productoDetalleGuiaRemision() {
		return this.cargarid_productoDetalleGuiaRemision;
	}

	public void setCargarid_productoDetalleGuiaRemision(Boolean cargarid_productoDetalleGuiaRemision) {
		this.cargarid_productoDetalleGuiaRemision= cargarid_productoDetalleGuiaRemision;
	}

	public Border setResaltarid_unidadDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleGuiaRemision() {
		return this.resaltarid_unidadDetalleGuiaRemision;
	}

	public void setResaltarid_unidadDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_unidadDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleGuiaRemision() {
		return this.mostrarid_unidadDetalleGuiaRemision;
	}

	public void setMostrarid_unidadDetalleGuiaRemision(Boolean mostrarid_unidadDetalleGuiaRemision) {
		this.mostrarid_unidadDetalleGuiaRemision= mostrarid_unidadDetalleGuiaRemision;
	}

	public Boolean getActivarid_unidadDetalleGuiaRemision() {
		return this.activarid_unidadDetalleGuiaRemision;
	}

	public void setActivarid_unidadDetalleGuiaRemision(Boolean activarid_unidadDetalleGuiaRemision) {
		this.activarid_unidadDetalleGuiaRemision= activarid_unidadDetalleGuiaRemision;
	}

	public Boolean getCargarid_unidadDetalleGuiaRemision() {
		return this.cargarid_unidadDetalleGuiaRemision;
	}

	public void setCargarid_unidadDetalleGuiaRemision(Boolean cargarid_unidadDetalleGuiaRemision) {
		this.cargarid_unidadDetalleGuiaRemision= cargarid_unidadDetalleGuiaRemision;
	}

	public Border setResaltarid_centro_costoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleGuiaRemision() {
		return this.resaltarid_centro_costoDetalleGuiaRemision;
	}

	public void setResaltarid_centro_costoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleGuiaRemision() {
		return this.mostrarid_centro_costoDetalleGuiaRemision;
	}

	public void setMostrarid_centro_costoDetalleGuiaRemision(Boolean mostrarid_centro_costoDetalleGuiaRemision) {
		this.mostrarid_centro_costoDetalleGuiaRemision= mostrarid_centro_costoDetalleGuiaRemision;
	}

	public Boolean getActivarid_centro_costoDetalleGuiaRemision() {
		return this.activarid_centro_costoDetalleGuiaRemision;
	}

	public void setActivarid_centro_costoDetalleGuiaRemision(Boolean activarid_centro_costoDetalleGuiaRemision) {
		this.activarid_centro_costoDetalleGuiaRemision= activarid_centro_costoDetalleGuiaRemision;
	}

	public Boolean getCargarid_centro_costoDetalleGuiaRemision() {
		return this.cargarid_centro_costoDetalleGuiaRemision;
	}

	public void setCargarid_centro_costoDetalleGuiaRemision(Boolean cargarid_centro_costoDetalleGuiaRemision) {
		this.cargarid_centro_costoDetalleGuiaRemision= cargarid_centro_costoDetalleGuiaRemision;
	}

	public Border setResaltarcantidad_envasesDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarcantidad_envasesDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_envasesDetalleGuiaRemision() {
		return this.resaltarcantidad_envasesDetalleGuiaRemision;
	}

	public void setResaltarcantidad_envasesDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarcantidad_envasesDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarcantidad_envasesDetalleGuiaRemision() {
		return this.mostrarcantidad_envasesDetalleGuiaRemision;
	}

	public void setMostrarcantidad_envasesDetalleGuiaRemision(Boolean mostrarcantidad_envasesDetalleGuiaRemision) {
		this.mostrarcantidad_envasesDetalleGuiaRemision= mostrarcantidad_envasesDetalleGuiaRemision;
	}

	public Boolean getActivarcantidad_envasesDetalleGuiaRemision() {
		return this.activarcantidad_envasesDetalleGuiaRemision;
	}

	public void setActivarcantidad_envasesDetalleGuiaRemision(Boolean activarcantidad_envasesDetalleGuiaRemision) {
		this.activarcantidad_envasesDetalleGuiaRemision= activarcantidad_envasesDetalleGuiaRemision;
	}

	public Border setResaltarcantidad_auxiliarDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarcantidad_auxiliarDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_auxiliarDetalleGuiaRemision() {
		return this.resaltarcantidad_auxiliarDetalleGuiaRemision;
	}

	public void setResaltarcantidad_auxiliarDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarcantidad_auxiliarDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarcantidad_auxiliarDetalleGuiaRemision() {
		return this.mostrarcantidad_auxiliarDetalleGuiaRemision;
	}

	public void setMostrarcantidad_auxiliarDetalleGuiaRemision(Boolean mostrarcantidad_auxiliarDetalleGuiaRemision) {
		this.mostrarcantidad_auxiliarDetalleGuiaRemision= mostrarcantidad_auxiliarDetalleGuiaRemision;
	}

	public Boolean getActivarcantidad_auxiliarDetalleGuiaRemision() {
		return this.activarcantidad_auxiliarDetalleGuiaRemision;
	}

	public void setActivarcantidad_auxiliarDetalleGuiaRemision(Boolean activarcantidad_auxiliarDetalleGuiaRemision) {
		this.activarcantidad_auxiliarDetalleGuiaRemision= activarcantidad_auxiliarDetalleGuiaRemision;
	}

	public Border setResaltardescripcionDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleGuiaRemision() {
		return this.resaltardescripcionDetalleGuiaRemision;
	}

	public void setResaltardescripcionDetalleGuiaRemision(Border borderResaltar) {
		this.resaltardescripcionDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleGuiaRemision() {
		return this.mostrardescripcionDetalleGuiaRemision;
	}

	public void setMostrardescripcionDetalleGuiaRemision(Boolean mostrardescripcionDetalleGuiaRemision) {
		this.mostrardescripcionDetalleGuiaRemision= mostrardescripcionDetalleGuiaRemision;
	}

	public Boolean getActivardescripcionDetalleGuiaRemision() {
		return this.activardescripcionDetalleGuiaRemision;
	}

	public void setActivardescripcionDetalleGuiaRemision(Boolean activardescripcionDetalleGuiaRemision) {
		this.activardescripcionDetalleGuiaRemision= activardescripcionDetalleGuiaRemision;
	}

	public Border setResaltarcantidadDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleGuiaRemision() {
		return this.resaltarcantidadDetalleGuiaRemision;
	}

	public void setResaltarcantidadDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarcantidadDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleGuiaRemision() {
		return this.mostrarcantidadDetalleGuiaRemision;
	}

	public void setMostrarcantidadDetalleGuiaRemision(Boolean mostrarcantidadDetalleGuiaRemision) {
		this.mostrarcantidadDetalleGuiaRemision= mostrarcantidadDetalleGuiaRemision;
	}

	public Boolean getActivarcantidadDetalleGuiaRemision() {
		return this.activarcantidadDetalleGuiaRemision;
	}

	public void setActivarcantidadDetalleGuiaRemision(Boolean activarcantidadDetalleGuiaRemision) {
		this.activarcantidadDetalleGuiaRemision= activarcantidadDetalleGuiaRemision;
	}

	public Border setResaltarmontoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarmontoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoDetalleGuiaRemision() {
		return this.resaltarmontoDetalleGuiaRemision;
	}

	public void setResaltarmontoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarmontoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarmontoDetalleGuiaRemision() {
		return this.mostrarmontoDetalleGuiaRemision;
	}

	public void setMostrarmontoDetalleGuiaRemision(Boolean mostrarmontoDetalleGuiaRemision) {
		this.mostrarmontoDetalleGuiaRemision= mostrarmontoDetalleGuiaRemision;
	}

	public Boolean getActivarmontoDetalleGuiaRemision() {
		return this.activarmontoDetalleGuiaRemision;
	}

	public void setActivarmontoDetalleGuiaRemision(Boolean activarmontoDetalleGuiaRemision) {
		this.activarmontoDetalleGuiaRemision= activarmontoDetalleGuiaRemision;
	}

	public Border setResaltarprecioDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleGuiaRemision() {
		return this.resaltarprecioDetalleGuiaRemision;
	}

	public void setResaltarprecioDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarprecioDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleGuiaRemision() {
		return this.mostrarprecioDetalleGuiaRemision;
	}

	public void setMostrarprecioDetalleGuiaRemision(Boolean mostrarprecioDetalleGuiaRemision) {
		this.mostrarprecioDetalleGuiaRemision= mostrarprecioDetalleGuiaRemision;
	}

	public Boolean getActivarprecioDetalleGuiaRemision() {
		return this.activarprecioDetalleGuiaRemision;
	}

	public void setActivarprecioDetalleGuiaRemision(Boolean activarprecioDetalleGuiaRemision) {
		this.activarprecioDetalleGuiaRemision= activarprecioDetalleGuiaRemision;
	}

	public Border setResaltarporcentaje_descuentoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoDetalleGuiaRemision() {
		return this.resaltarporcentaje_descuentoDetalleGuiaRemision;
	}

	public void setResaltarporcentaje_descuentoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarporcentaje_descuentoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoDetalleGuiaRemision() {
		return this.mostrarporcentaje_descuentoDetalleGuiaRemision;
	}

	public void setMostrarporcentaje_descuentoDetalleGuiaRemision(Boolean mostrarporcentaje_descuentoDetalleGuiaRemision) {
		this.mostrarporcentaje_descuentoDetalleGuiaRemision= mostrarporcentaje_descuentoDetalleGuiaRemision;
	}

	public Boolean getActivarporcentaje_descuentoDetalleGuiaRemision() {
		return this.activarporcentaje_descuentoDetalleGuiaRemision;
	}

	public void setActivarporcentaje_descuentoDetalleGuiaRemision(Boolean activarporcentaje_descuentoDetalleGuiaRemision) {
		this.activarporcentaje_descuentoDetalleGuiaRemision= activarporcentaje_descuentoDetalleGuiaRemision;
	}

	public Border setResaltardescuentoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescuentoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetalleGuiaRemision() {
		return this.resaltardescuentoDetalleGuiaRemision;
	}

	public void setResaltardescuentoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltardescuentoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescuentoDetalleGuiaRemision() {
		return this.mostrardescuentoDetalleGuiaRemision;
	}

	public void setMostrardescuentoDetalleGuiaRemision(Boolean mostrardescuentoDetalleGuiaRemision) {
		this.mostrardescuentoDetalleGuiaRemision= mostrardescuentoDetalleGuiaRemision;
	}

	public Boolean getActivardescuentoDetalleGuiaRemision() {
		return this.activardescuentoDetalleGuiaRemision;
	}

	public void setActivardescuentoDetalleGuiaRemision(Boolean activardescuentoDetalleGuiaRemision) {
		this.activardescuentoDetalleGuiaRemision= activardescuentoDetalleGuiaRemision;
	}

	public Border setResaltardescuento2DetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescuento2DetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetalleGuiaRemision() {
		return this.resaltardescuento2DetalleGuiaRemision;
	}

	public void setResaltardescuento2DetalleGuiaRemision(Border borderResaltar) {
		this.resaltardescuento2DetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescuento2DetalleGuiaRemision() {
		return this.mostrardescuento2DetalleGuiaRemision;
	}

	public void setMostrardescuento2DetalleGuiaRemision(Boolean mostrardescuento2DetalleGuiaRemision) {
		this.mostrardescuento2DetalleGuiaRemision= mostrardescuento2DetalleGuiaRemision;
	}

	public Boolean getActivardescuento2DetalleGuiaRemision() {
		return this.activardescuento2DetalleGuiaRemision;
	}

	public void setActivardescuento2DetalleGuiaRemision(Boolean activardescuento2DetalleGuiaRemision) {
		this.activardescuento2DetalleGuiaRemision= activardescuento2DetalleGuiaRemision;
	}

	public Border setResaltardescuento3DetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescuento3DetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento3DetalleGuiaRemision() {
		return this.resaltardescuento3DetalleGuiaRemision;
	}

	public void setResaltardescuento3DetalleGuiaRemision(Border borderResaltar) {
		this.resaltardescuento3DetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescuento3DetalleGuiaRemision() {
		return this.mostrardescuento3DetalleGuiaRemision;
	}

	public void setMostrardescuento3DetalleGuiaRemision(Boolean mostrardescuento3DetalleGuiaRemision) {
		this.mostrardescuento3DetalleGuiaRemision= mostrardescuento3DetalleGuiaRemision;
	}

	public Boolean getActivardescuento3DetalleGuiaRemision() {
		return this.activardescuento3DetalleGuiaRemision;
	}

	public void setActivardescuento3DetalleGuiaRemision(Boolean activardescuento3DetalleGuiaRemision) {
		this.activardescuento3DetalleGuiaRemision= activardescuento3DetalleGuiaRemision;
	}

	public Border setResaltarporcentaje_ivaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ivaDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ivaDetalleGuiaRemision() {
		return this.resaltarporcentaje_ivaDetalleGuiaRemision;
	}

	public void setResaltarporcentaje_ivaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarporcentaje_ivaDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ivaDetalleGuiaRemision() {
		return this.mostrarporcentaje_ivaDetalleGuiaRemision;
	}

	public void setMostrarporcentaje_ivaDetalleGuiaRemision(Boolean mostrarporcentaje_ivaDetalleGuiaRemision) {
		this.mostrarporcentaje_ivaDetalleGuiaRemision= mostrarporcentaje_ivaDetalleGuiaRemision;
	}

	public Boolean getActivarporcentaje_ivaDetalleGuiaRemision() {
		return this.activarporcentaje_ivaDetalleGuiaRemision;
	}

	public void setActivarporcentaje_ivaDetalleGuiaRemision(Boolean activarporcentaje_ivaDetalleGuiaRemision) {
		this.activarporcentaje_ivaDetalleGuiaRemision= activarporcentaje_ivaDetalleGuiaRemision;
	}

	public Border setResaltarivaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarivaDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleGuiaRemision() {
		return this.resaltarivaDetalleGuiaRemision;
	}

	public void setResaltarivaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarivaDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarivaDetalleGuiaRemision() {
		return this.mostrarivaDetalleGuiaRemision;
	}

	public void setMostrarivaDetalleGuiaRemision(Boolean mostrarivaDetalleGuiaRemision) {
		this.mostrarivaDetalleGuiaRemision= mostrarivaDetalleGuiaRemision;
	}

	public Boolean getActivarivaDetalleGuiaRemision() {
		return this.activarivaDetalleGuiaRemision;
	}

	public void setActivarivaDetalleGuiaRemision(Boolean activarivaDetalleGuiaRemision) {
		this.activarivaDetalleGuiaRemision= activarivaDetalleGuiaRemision;
	}

	public Border setResaltartotal_descuentoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoDetalleGuiaRemision() {
		return this.resaltartotal_descuentoDetalleGuiaRemision;
	}

	public void setResaltartotal_descuentoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltartotal_descuentoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoDetalleGuiaRemision() {
		return this.mostrartotal_descuentoDetalleGuiaRemision;
	}

	public void setMostrartotal_descuentoDetalleGuiaRemision(Boolean mostrartotal_descuentoDetalleGuiaRemision) {
		this.mostrartotal_descuentoDetalleGuiaRemision= mostrartotal_descuentoDetalleGuiaRemision;
	}

	public Boolean getActivartotal_descuentoDetalleGuiaRemision() {
		return this.activartotal_descuentoDetalleGuiaRemision;
	}

	public void setActivartotal_descuentoDetalleGuiaRemision(Boolean activartotal_descuentoDetalleGuiaRemision) {
		this.activartotal_descuentoDetalleGuiaRemision= activartotal_descuentoDetalleGuiaRemision;
	}

	public Border setResaltartotal_impuestoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotal_impuestoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_impuestoDetalleGuiaRemision() {
		return this.resaltartotal_impuestoDetalleGuiaRemision;
	}

	public void setResaltartotal_impuestoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltartotal_impuestoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotal_impuestoDetalleGuiaRemision() {
		return this.mostrartotal_impuestoDetalleGuiaRemision;
	}

	public void setMostrartotal_impuestoDetalleGuiaRemision(Boolean mostrartotal_impuestoDetalleGuiaRemision) {
		this.mostrartotal_impuestoDetalleGuiaRemision= mostrartotal_impuestoDetalleGuiaRemision;
	}

	public Boolean getActivartotal_impuestoDetalleGuiaRemision() {
		return this.activartotal_impuestoDetalleGuiaRemision;
	}

	public void setActivartotal_impuestoDetalleGuiaRemision(Boolean activartotal_impuestoDetalleGuiaRemision) {
		this.activartotal_impuestoDetalleGuiaRemision= activartotal_impuestoDetalleGuiaRemision;
	}

	public Border setResaltarsub_totalDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetalleGuiaRemision() {
		return this.resaltarsub_totalDetalleGuiaRemision;
	}

	public void setResaltarsub_totalDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarsub_totalDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetalleGuiaRemision() {
		return this.mostrarsub_totalDetalleGuiaRemision;
	}

	public void setMostrarsub_totalDetalleGuiaRemision(Boolean mostrarsub_totalDetalleGuiaRemision) {
		this.mostrarsub_totalDetalleGuiaRemision= mostrarsub_totalDetalleGuiaRemision;
	}

	public Boolean getActivarsub_totalDetalleGuiaRemision() {
		return this.activarsub_totalDetalleGuiaRemision;
	}

	public void setActivarsub_totalDetalleGuiaRemision(Boolean activarsub_totalDetalleGuiaRemision) {
		this.activarsub_totalDetalleGuiaRemision= activarsub_totalDetalleGuiaRemision;
	}

	public Border setResaltartotalDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotalDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleGuiaRemision() {
		return this.resaltartotalDetalleGuiaRemision;
	}

	public void setResaltartotalDetalleGuiaRemision(Border borderResaltar) {
		this.resaltartotalDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotalDetalleGuiaRemision() {
		return this.mostrartotalDetalleGuiaRemision;
	}

	public void setMostrartotalDetalleGuiaRemision(Boolean mostrartotalDetalleGuiaRemision) {
		this.mostrartotalDetalleGuiaRemision= mostrartotalDetalleGuiaRemision;
	}

	public Boolean getActivartotalDetalleGuiaRemision() {
		return this.activartotalDetalleGuiaRemision;
	}

	public void setActivartotalDetalleGuiaRemision(Boolean activartotalDetalleGuiaRemision) {
		this.activartotalDetalleGuiaRemision= activartotalDetalleGuiaRemision;
	}

	public Border setResaltarloteDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarloteDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleGuiaRemision() {
		return this.resaltarloteDetalleGuiaRemision;
	}

	public void setResaltarloteDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarloteDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarloteDetalleGuiaRemision() {
		return this.mostrarloteDetalleGuiaRemision;
	}

	public void setMostrarloteDetalleGuiaRemision(Boolean mostrarloteDetalleGuiaRemision) {
		this.mostrarloteDetalleGuiaRemision= mostrarloteDetalleGuiaRemision;
	}

	public Boolean getActivarloteDetalleGuiaRemision() {
		return this.activarloteDetalleGuiaRemision;
	}

	public void setActivarloteDetalleGuiaRemision(Boolean activarloteDetalleGuiaRemision) {
		this.activarloteDetalleGuiaRemision= activarloteDetalleGuiaRemision;
	}

	public Border setResaltarlote_clienteDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarlote_clienteDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlote_clienteDetalleGuiaRemision() {
		return this.resaltarlote_clienteDetalleGuiaRemision;
	}

	public void setResaltarlote_clienteDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarlote_clienteDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarlote_clienteDetalleGuiaRemision() {
		return this.mostrarlote_clienteDetalleGuiaRemision;
	}

	public void setMostrarlote_clienteDetalleGuiaRemision(Boolean mostrarlote_clienteDetalleGuiaRemision) {
		this.mostrarlote_clienteDetalleGuiaRemision= mostrarlote_clienteDetalleGuiaRemision;
	}

	public Boolean getActivarlote_clienteDetalleGuiaRemision() {
		return this.activarlote_clienteDetalleGuiaRemision;
	}

	public void setActivarlote_clienteDetalleGuiaRemision(Boolean activarlote_clienteDetalleGuiaRemision) {
		this.activarlote_clienteDetalleGuiaRemision= activarlote_clienteDetalleGuiaRemision;
	}

	public Border setResaltarorden_compraDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarorden_compraDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorden_compraDetalleGuiaRemision() {
		return this.resaltarorden_compraDetalleGuiaRemision;
	}

	public void setResaltarorden_compraDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarorden_compraDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarorden_compraDetalleGuiaRemision() {
		return this.mostrarorden_compraDetalleGuiaRemision;
	}

	public void setMostrarorden_compraDetalleGuiaRemision(Boolean mostrarorden_compraDetalleGuiaRemision) {
		this.mostrarorden_compraDetalleGuiaRemision= mostrarorden_compraDetalleGuiaRemision;
	}

	public Boolean getActivarorden_compraDetalleGuiaRemision() {
		return this.activarorden_compraDetalleGuiaRemision;
	}

	public void setActivarorden_compraDetalleGuiaRemision(Boolean activarorden_compraDetalleGuiaRemision) {
		this.activarorden_compraDetalleGuiaRemision= activarorden_compraDetalleGuiaRemision;
	}

	public Border setResaltarareaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarareaDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarareaDetalleGuiaRemision() {
		return this.resaltarareaDetalleGuiaRemision;
	}

	public void setResaltarareaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarareaDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarareaDetalleGuiaRemision() {
		return this.mostrarareaDetalleGuiaRemision;
	}

	public void setMostrarareaDetalleGuiaRemision(Boolean mostrarareaDetalleGuiaRemision) {
		this.mostrarareaDetalleGuiaRemision= mostrarareaDetalleGuiaRemision;
	}

	public Boolean getActivarareaDetalleGuiaRemision() {
		return this.activarareaDetalleGuiaRemision;
	}

	public void setActivarareaDetalleGuiaRemision(Boolean activarareaDetalleGuiaRemision) {
		this.activarareaDetalleGuiaRemision= activarareaDetalleGuiaRemision;
	}

	public Border setResaltarmedidasDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarmedidasDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmedidasDetalleGuiaRemision() {
		return this.resaltarmedidasDetalleGuiaRemision;
	}

	public void setResaltarmedidasDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarmedidasDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarmedidasDetalleGuiaRemision() {
		return this.mostrarmedidasDetalleGuiaRemision;
	}

	public void setMostrarmedidasDetalleGuiaRemision(Boolean mostrarmedidasDetalleGuiaRemision) {
		this.mostrarmedidasDetalleGuiaRemision= mostrarmedidasDetalleGuiaRemision;
	}

	public Boolean getActivarmedidasDetalleGuiaRemision() {
		return this.activarmedidasDetalleGuiaRemision;
	}

	public void setActivarmedidasDetalleGuiaRemision(Boolean activarmedidasDetalleGuiaRemision) {
		this.activarmedidasDetalleGuiaRemision= activarmedidasDetalleGuiaRemision;
	}

	public Border setResaltaracabadoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltaracabadoDetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracabadoDetalleGuiaRemision() {
		return this.resaltaracabadoDetalleGuiaRemision;
	}

	public void setResaltaracabadoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltaracabadoDetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostraracabadoDetalleGuiaRemision() {
		return this.mostraracabadoDetalleGuiaRemision;
	}

	public void setMostraracabadoDetalleGuiaRemision(Boolean mostraracabadoDetalleGuiaRemision) {
		this.mostraracabadoDetalleGuiaRemision= mostraracabadoDetalleGuiaRemision;
	}

	public Boolean getActivaracabadoDetalleGuiaRemision() {
		return this.activaracabadoDetalleGuiaRemision;
	}

	public void setActivaracabadoDetalleGuiaRemision(Boolean activaracabadoDetalleGuiaRemision) {
		this.activaracabadoDetalleGuiaRemision= activaracabadoDetalleGuiaRemision;
	}

	public Border setResaltaracabado2DetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleguiaremisionBeanSwingJInternalFrame.jTtoolBarDetalleGuiaRemision.setBorder(borderResaltar);
		
		this.resaltaracabado2DetalleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracabado2DetalleGuiaRemision() {
		return this.resaltaracabado2DetalleGuiaRemision;
	}

	public void setResaltaracabado2DetalleGuiaRemision(Border borderResaltar) {
		this.resaltaracabado2DetalleGuiaRemision= borderResaltar;
	}

	public Boolean getMostraracabado2DetalleGuiaRemision() {
		return this.mostraracabado2DetalleGuiaRemision;
	}

	public void setMostraracabado2DetalleGuiaRemision(Boolean mostraracabado2DetalleGuiaRemision) {
		this.mostraracabado2DetalleGuiaRemision= mostraracabado2DetalleGuiaRemision;
	}

	public Boolean getActivaracabado2DetalleGuiaRemision() {
		return this.activaracabado2DetalleGuiaRemision;
	}

	public void setActivaracabado2DetalleGuiaRemision(Boolean activaracabado2DetalleGuiaRemision) {
		this.activaracabado2DetalleGuiaRemision= activaracabado2DetalleGuiaRemision;
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
		
		
		this.setMostraridDetalleGuiaRemision(esInicial);
		this.setMostrarid_empresaDetalleGuiaRemision(esInicial);
		this.setMostrarid_sucursalDetalleGuiaRemision(esInicial);
		this.setMostrarid_ejercicioDetalleGuiaRemision(esInicial);
		this.setMostrarid_periodoDetalleGuiaRemision(esInicial);
		this.setMostrarid_guia_remisionDetalleGuiaRemision(esInicial);
		this.setMostrarid_bodegaDetalleGuiaRemision(esInicial);
		this.setMostrarid_productoDetalleGuiaRemision(esInicial);
		this.setMostrarid_unidadDetalleGuiaRemision(esInicial);
		this.setMostrarid_centro_costoDetalleGuiaRemision(esInicial);
		this.setMostrarcantidad_envasesDetalleGuiaRemision(esInicial);
		this.setMostrarcantidad_auxiliarDetalleGuiaRemision(esInicial);
		this.setMostrardescripcionDetalleGuiaRemision(esInicial);
		this.setMostrarcantidadDetalleGuiaRemision(esInicial);
		this.setMostrarmontoDetalleGuiaRemision(esInicial);
		this.setMostrarprecioDetalleGuiaRemision(esInicial);
		this.setMostrarporcentaje_descuentoDetalleGuiaRemision(esInicial);
		this.setMostrardescuentoDetalleGuiaRemision(esInicial);
		this.setMostrardescuento2DetalleGuiaRemision(esInicial);
		this.setMostrardescuento3DetalleGuiaRemision(esInicial);
		this.setMostrarporcentaje_ivaDetalleGuiaRemision(esInicial);
		this.setMostrarivaDetalleGuiaRemision(esInicial);
		this.setMostrartotal_descuentoDetalleGuiaRemision(esInicial);
		this.setMostrartotal_impuestoDetalleGuiaRemision(esInicial);
		this.setMostrarsub_totalDetalleGuiaRemision(esInicial);
		this.setMostrartotalDetalleGuiaRemision(esInicial);
		this.setMostrarloteDetalleGuiaRemision(esInicial);
		this.setMostrarlote_clienteDetalleGuiaRemision(esInicial);
		this.setMostrarorden_compraDetalleGuiaRemision(esInicial);
		this.setMostrarareaDetalleGuiaRemision(esInicial);
		this.setMostrarmedidasDetalleGuiaRemision(esInicial);
		this.setMostraracabadoDetalleGuiaRemision(esInicial);
		this.setMostraracabado2DetalleGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ID)) {
				this.setMostraridDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION)) {
				this.setMostrarid_guia_remisionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES)) {
				this.setMostrarcantidad_envasesDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setMostrarcantidad_auxiliarDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MONTO)) {
				this.setMostrarmontoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3)) {
				this.setMostrardescuento3DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA)) {
				this.setMostrarporcentaje_ivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO)) {
				this.setMostrartotal_impuestoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE)) {
				this.setMostrarlote_clienteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA)) {
				this.setMostrarorden_compraDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.AREA)) {
				this.setMostrarareaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MEDIDAS)) {
				this.setMostrarmedidasDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO)) {
				this.setMostraracabadoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO2)) {
				this.setMostraracabado2DetalleGuiaRemision(esAsigna);
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
		
		
		this.setActivaridDetalleGuiaRemision(esInicial);
		this.setActivarid_empresaDetalleGuiaRemision(esInicial);
		this.setActivarid_sucursalDetalleGuiaRemision(esInicial);
		this.setActivarid_ejercicioDetalleGuiaRemision(esInicial);
		this.setActivarid_periodoDetalleGuiaRemision(esInicial);
		this.setActivarid_guia_remisionDetalleGuiaRemision(esInicial);
		this.setActivarid_bodegaDetalleGuiaRemision(esInicial);
		this.setActivarid_productoDetalleGuiaRemision(esInicial);
		this.setActivarid_unidadDetalleGuiaRemision(esInicial);
		this.setActivarid_centro_costoDetalleGuiaRemision(esInicial);
		this.setActivarcantidad_envasesDetalleGuiaRemision(esInicial);
		this.setActivarcantidad_auxiliarDetalleGuiaRemision(esInicial);
		this.setActivardescripcionDetalleGuiaRemision(esInicial);
		this.setActivarcantidadDetalleGuiaRemision(esInicial);
		this.setActivarmontoDetalleGuiaRemision(esInicial);
		this.setActivarprecioDetalleGuiaRemision(esInicial);
		this.setActivarporcentaje_descuentoDetalleGuiaRemision(esInicial);
		this.setActivardescuentoDetalleGuiaRemision(esInicial);
		this.setActivardescuento2DetalleGuiaRemision(esInicial);
		this.setActivardescuento3DetalleGuiaRemision(esInicial);
		this.setActivarporcentaje_ivaDetalleGuiaRemision(esInicial);
		this.setActivarivaDetalleGuiaRemision(esInicial);
		this.setActivartotal_descuentoDetalleGuiaRemision(esInicial);
		this.setActivartotal_impuestoDetalleGuiaRemision(esInicial);
		this.setActivarsub_totalDetalleGuiaRemision(esInicial);
		this.setActivartotalDetalleGuiaRemision(esInicial);
		this.setActivarloteDetalleGuiaRemision(esInicial);
		this.setActivarlote_clienteDetalleGuiaRemision(esInicial);
		this.setActivarorden_compraDetalleGuiaRemision(esInicial);
		this.setActivarareaDetalleGuiaRemision(esInicial);
		this.setActivarmedidasDetalleGuiaRemision(esInicial);
		this.setActivaracabadoDetalleGuiaRemision(esInicial);
		this.setActivaracabado2DetalleGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ID)) {
				this.setActivaridDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION)) {
				this.setActivarid_guia_remisionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES)) {
				this.setActivarcantidad_envasesDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setActivarcantidad_auxiliarDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MONTO)) {
				this.setActivarmontoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3)) {
				this.setActivardescuento3DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA)) {
				this.setActivarporcentaje_ivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IVA)) {
				this.setActivarivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO)) {
				this.setActivartotal_impuestoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE)) {
				this.setActivarlote_clienteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA)) {
				this.setActivarorden_compraDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.AREA)) {
				this.setActivarareaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MEDIDAS)) {
				this.setActivarmedidasDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO)) {
				this.setActivaracabadoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO2)) {
				this.setActivaracabado2DetalleGuiaRemision(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleGuiaRemision(esInicial);
		this.setResaltarid_empresaDetalleGuiaRemision(esInicial);
		this.setResaltarid_sucursalDetalleGuiaRemision(esInicial);
		this.setResaltarid_ejercicioDetalleGuiaRemision(esInicial);
		this.setResaltarid_periodoDetalleGuiaRemision(esInicial);
		this.setResaltarid_guia_remisionDetalleGuiaRemision(esInicial);
		this.setResaltarid_bodegaDetalleGuiaRemision(esInicial);
		this.setResaltarid_productoDetalleGuiaRemision(esInicial);
		this.setResaltarid_unidadDetalleGuiaRemision(esInicial);
		this.setResaltarid_centro_costoDetalleGuiaRemision(esInicial);
		this.setResaltarcantidad_envasesDetalleGuiaRemision(esInicial);
		this.setResaltarcantidad_auxiliarDetalleGuiaRemision(esInicial);
		this.setResaltardescripcionDetalleGuiaRemision(esInicial);
		this.setResaltarcantidadDetalleGuiaRemision(esInicial);
		this.setResaltarmontoDetalleGuiaRemision(esInicial);
		this.setResaltarprecioDetalleGuiaRemision(esInicial);
		this.setResaltarporcentaje_descuentoDetalleGuiaRemision(esInicial);
		this.setResaltardescuentoDetalleGuiaRemision(esInicial);
		this.setResaltardescuento2DetalleGuiaRemision(esInicial);
		this.setResaltardescuento3DetalleGuiaRemision(esInicial);
		this.setResaltarporcentaje_ivaDetalleGuiaRemision(esInicial);
		this.setResaltarivaDetalleGuiaRemision(esInicial);
		this.setResaltartotal_descuentoDetalleGuiaRemision(esInicial);
		this.setResaltartotal_impuestoDetalleGuiaRemision(esInicial);
		this.setResaltarsub_totalDetalleGuiaRemision(esInicial);
		this.setResaltartotalDetalleGuiaRemision(esInicial);
		this.setResaltarloteDetalleGuiaRemision(esInicial);
		this.setResaltarlote_clienteDetalleGuiaRemision(esInicial);
		this.setResaltarorden_compraDetalleGuiaRemision(esInicial);
		this.setResaltarareaDetalleGuiaRemision(esInicial);
		this.setResaltarmedidasDetalleGuiaRemision(esInicial);
		this.setResaltaracabadoDetalleGuiaRemision(esInicial);
		this.setResaltaracabado2DetalleGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ID)) {
				this.setResaltaridDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION)) {
				this.setResaltarid_guia_remisionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES)) {
				this.setResaltarcantidad_envasesDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR)) {
				this.setResaltarcantidad_auxiliarDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MONTO)) {
				this.setResaltarmontoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3)) {
				this.setResaltardescuento3DetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA)) {
				this.setResaltarporcentaje_ivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO)) {
				this.setResaltartotal_impuestoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE)) {
				this.setResaltarlote_clienteDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA)) {
				this.setResaltarorden_compraDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.AREA)) {
				this.setResaltarareaDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.MEDIDAS)) {
				this.setResaltarmedidasDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO)) {
				this.setResaltaracabadoDetalleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGuiaRemisionConstantesFunciones.ACABADO2)) {
				this.setResaltaracabado2DetalleGuiaRemision(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdBodegaDetalleGuiaRemision() {
		return this.mostrarFK_IdBodegaDetalleGuiaRemision;
	}

	public void setMostrarFK_IdBodegaDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleGuiaRemision() {
		return this.mostrarFK_IdCentroCostoDetalleGuiaRemision;
	}

	public void setMostrarFK_IdCentroCostoDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdEjercicioDetalleGuiaRemision() {
		return this.mostrarFK_IdEjercicioDetalleGuiaRemision;
	}

	public void setMostrarFK_IdEjercicioDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdEmpresaDetalleGuiaRemision() {
		return this.mostrarFK_IdEmpresaDetalleGuiaRemision;
	}

	public void setMostrarFK_IdEmpresaDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGuiaRemisionDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdGuiaRemisionDetalleGuiaRemision() {
		return this.mostrarFK_IdGuiaRemisionDetalleGuiaRemision;
	}

	public void setMostrarFK_IdGuiaRemisionDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGuiaRemisionDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdPeriodoDetalleGuiaRemision() {
		return this.mostrarFK_IdPeriodoDetalleGuiaRemision;
	}

	public void setMostrarFK_IdPeriodoDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdProductoDetalleGuiaRemision() {
		return this.mostrarFK_IdProductoDetalleGuiaRemision;
	}

	public void setMostrarFK_IdProductoDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdSucursalDetalleGuiaRemision() {
		return this.mostrarFK_IdSucursalDetalleGuiaRemision;
	}

	public void setMostrarFK_IdSucursalDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleGuiaRemision=true;

	public Boolean getMostrarFK_IdUnidadDetalleGuiaRemision() {
		return this.mostrarFK_IdUnidadDetalleGuiaRemision;
	}

	public void setMostrarFK_IdUnidadDetalleGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleGuiaRemision= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdBodegaDetalleGuiaRemision() {
		return this.activarFK_IdBodegaDetalleGuiaRemision;
	}

	public void setActivarFK_IdBodegaDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdCentroCostoDetalleGuiaRemision() {
		return this.activarFK_IdCentroCostoDetalleGuiaRemision;
	}

	public void setActivarFK_IdCentroCostoDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdEjercicioDetalleGuiaRemision() {
		return this.activarFK_IdEjercicioDetalleGuiaRemision;
	}

	public void setActivarFK_IdEjercicioDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdEmpresaDetalleGuiaRemision() {
		return this.activarFK_IdEmpresaDetalleGuiaRemision;
	}

	public void setActivarFK_IdEmpresaDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdGuiaRemisionDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdGuiaRemisionDetalleGuiaRemision() {
		return this.activarFK_IdGuiaRemisionDetalleGuiaRemision;
	}

	public void setActivarFK_IdGuiaRemisionDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdGuiaRemisionDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdPeriodoDetalleGuiaRemision() {
		return this.activarFK_IdPeriodoDetalleGuiaRemision;
	}

	public void setActivarFK_IdPeriodoDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdProductoDetalleGuiaRemision() {
		return this.activarFK_IdProductoDetalleGuiaRemision;
	}

	public void setActivarFK_IdProductoDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdSucursalDetalleGuiaRemision() {
		return this.activarFK_IdSucursalDetalleGuiaRemision;
	}

	public void setActivarFK_IdSucursalDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleGuiaRemision=true;

	public Boolean getActivarFK_IdUnidadDetalleGuiaRemision() {
		return this.activarFK_IdUnidadDetalleGuiaRemision;
	}

	public void setActivarFK_IdUnidadDetalleGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleGuiaRemision= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleGuiaRemision=null;

	public Border getResaltarFK_IdBodegaDetalleGuiaRemision() {
		return this.resaltarFK_IdBodegaDetalleGuiaRemision;
	}

	public void setResaltarFK_IdBodegaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleGuiaRemision=null;

	public Border getResaltarFK_IdCentroCostoDetalleGuiaRemision() {
		return this.resaltarFK_IdCentroCostoDetalleGuiaRemision;
	}

	public void setResaltarFK_IdCentroCostoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleGuiaRemision=null;

	public Border getResaltarFK_IdEjercicioDetalleGuiaRemision() {
		return this.resaltarFK_IdEjercicioDetalleGuiaRemision;
	}

	public void setResaltarFK_IdEjercicioDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleGuiaRemision=null;

	public Border getResaltarFK_IdEmpresaDetalleGuiaRemision() {
		return this.resaltarFK_IdEmpresaDetalleGuiaRemision;
	}

	public void setResaltarFK_IdEmpresaDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdGuiaRemisionDetalleGuiaRemision=null;

	public Border getResaltarFK_IdGuiaRemisionDetalleGuiaRemision() {
		return this.resaltarFK_IdGuiaRemisionDetalleGuiaRemision;
	}

	public void setResaltarFK_IdGuiaRemisionDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdGuiaRemisionDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdGuiaRemisionDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGuiaRemisionDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleGuiaRemision=null;

	public Border getResaltarFK_IdPeriodoDetalleGuiaRemision() {
		return this.resaltarFK_IdPeriodoDetalleGuiaRemision;
	}

	public void setResaltarFK_IdPeriodoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleGuiaRemision=null;

	public Border getResaltarFK_IdProductoDetalleGuiaRemision() {
		return this.resaltarFK_IdProductoDetalleGuiaRemision;
	}

	public void setResaltarFK_IdProductoDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleGuiaRemision=null;

	public Border getResaltarFK_IdSucursalDetalleGuiaRemision() {
		return this.resaltarFK_IdSucursalDetalleGuiaRemision;
	}

	public void setResaltarFK_IdSucursalDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleGuiaRemision=null;

	public Border getResaltarFK_IdUnidadDetalleGuiaRemision() {
		return this.resaltarFK_IdUnidadDetalleGuiaRemision;
	}

	public void setResaltarFK_IdUnidadDetalleGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGuiaRemisionBeanSwingJInternalFrame detalleguiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleGuiaRemision= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}