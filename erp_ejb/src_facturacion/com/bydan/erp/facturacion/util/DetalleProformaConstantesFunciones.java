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


import com.bydan.erp.facturacion.util.DetalleProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleProformaParameterGeneral;

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
final public class DetalleProformaConstantesFunciones extends DetalleProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleProforma"+DetalleProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleProformaConstantesFunciones.SCHEMA+"_"+DetalleProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleProformaConstantesFunciones.SCHEMA+"_"+DetalleProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleProformaConstantesFunciones.SCHEMA+"_"+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleProformaConstantesFunciones.SCHEMA+"_"+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleProforma";
	public static final String OBJECTNAME="detalleproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleproforma from "+DetalleProformaConstantesFunciones.SPERSISTENCENAME+" detalleproforma";
	public static String QUERYSELECTNATIVE="select "+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".version_row,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_anio,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_mes,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_proforma,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_producto,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_empaque,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".id_estado_detalle_proforma,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".descripcion,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".cantidad_envases,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".cantidad,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".precio,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".iva,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".lote,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".total,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".ice,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".costo,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".utilidad,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".area,"+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME+".medida from "+DetalleProformaConstantesFunciones.SCHEMA+"."+DetalleProformaConstantesFunciones.TABLENAME;//+" as "+DetalleProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleProformaConstantesFuncionesAdditional detalleproformaConstantesFuncionesAdditional=null;
	
	public DetalleProformaConstantesFuncionesAdditional getDetalleProformaConstantesFuncionesAdditional() {
		return this.detalleproformaConstantesFuncionesAdditional;
	}
	
	public void setDetalleProformaConstantesFuncionesAdditional(DetalleProformaConstantesFuncionesAdditional detalleproformaConstantesFuncionesAdditional) {
		try {
			this.detalleproformaConstantesFuncionesAdditional=detalleproformaConstantesFuncionesAdditional;
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
    public static final String IDPROFORMA= "id_proforma";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDEMPAQUE= "id_empaque";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDESTADODETALLEPROFORMA= "id_estado_detalle_proforma";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDADENVASES= "cantidad_envases";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String IVA= "iva";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String LOTE= "lote";
    public static final String TOTAL= "total";
    public static final String ICE= "ice";
    public static final String COSTO= "costo";
    public static final String UTILIDAD= "utilidad";
    public static final String AREA= "area";
    public static final String MEDIDA= "medida";
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
    	public static final String LABEL_IDPROFORMA= "Proforma";
		public static final String LABEL_IDPROFORMA_LOWER= "Proforma";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDEMPAQUE= "Empaque";
		public static final String LABEL_IDEMPAQUE_LOWER= "Empaque";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDESTADODETALLEPROFORMA= "Estado";
		public static final String LABEL_IDESTADODETALLEPROFORMA_LOWER= "Estado Detalle Proforma";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDADENVASES= "Cantidad Envases";
		public static final String LABEL_CANTIDADENVASES_LOWER= "Cantidad Envases";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Descuento Porcentaje";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_UTILIDAD= "Utilidad";
		public static final String LABEL_UTILIDAD_LOWER= "Utilidad";
    	public static final String LABEL_AREA= "Area";
		public static final String LABEL_AREA_LOWER= "Area";
    	public static final String LABEL_MEDIDA= "Meda";
		public static final String LABEL_MEDIDA_LOWER= "Medida";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMEDIDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMEDIDA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDANIO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDMES)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDPROFORMA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDPROFORMA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDEMPAQUE)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDEMPAQUE;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IDESTADODETALLEPROFORMA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.CANTIDADENVASES)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.PRECIO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.IVA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.LOTE)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.TOTAL)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.ICE)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.COSTO)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.UTILIDAD)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_UTILIDAD;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.AREA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_AREA;}
		if(sNombreColumna.equals(DetalleProformaConstantesFunciones.MEDIDA)) {sLabelColumna=DetalleProformaConstantesFunciones.LABEL_MEDIDA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleProformaDescripcion(DetalleProforma detalleproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleproforma !=null/* && detalleproforma.getId()!=0*/) {
			if(detalleproforma.getId()!=null) {
				sDescripcion=detalleproforma.getId().toString();
			}//detalleproformadetalleproforma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleProformaDescripcionDetallado(DetalleProforma detalleproforma) {
		String sDescripcion="";
			
		sDescripcion+=DetalleProformaConstantesFunciones.ID+"=";
		sDescripcion+=detalleproforma.getId().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleproforma.getVersionRow().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleproforma.getid_empresa().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleproforma.getid_sucursal().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleproforma.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleproforma.getid_periodo().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleproforma.getid_anio().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleproforma.getid_mes().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDPROFORMA+"=";
		sDescripcion+=detalleproforma.getid_proforma().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleproforma.getid_bodega().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleproforma.getid_producto().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleproforma.getid_unidad().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDEMPAQUE+"=";
		sDescripcion+=detalleproforma.getid_empaque().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleproforma.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA+"=";
		sDescripcion+=detalleproforma.getid_estado_detalle_proforma().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleproforma.getdescripcion()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.CANTIDADENVASES+"=";
		sDescripcion+=detalleproforma.getcantidad_envases().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleproforma.getcantidad().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.PRECIO+"=";
		sDescripcion+=detalleproforma.getprecio().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.IVA+"=";
		sDescripcion+=detalleproforma.getiva().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=detalleproforma.getdescuento_porcentaje().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detalleproforma.getdescuento_valor().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.LOTE+"=";
		sDescripcion+=detalleproforma.getlote()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.TOTAL+"=";
		sDescripcion+=detalleproforma.gettotal().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.ICE+"=";
		sDescripcion+=detalleproforma.getice().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.COSTO+"=";
		sDescripcion+=detalleproforma.getcosto().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.UTILIDAD+"=";
		sDescripcion+=detalleproforma.getutilidad().toString()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.AREA+"=";
		sDescripcion+=detalleproforma.getarea()+",";
		sDescripcion+=DetalleProformaConstantesFunciones.MEDIDA+"=";
		sDescripcion+=detalleproforma.getmedida()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleProformaDescripcion(DetalleProforma detalleproforma,String sValor) throws Exception {			
		if(detalleproforma !=null) {
			//detalleproformadetalleproforma.getId().toString();
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

	public static String getProformaDescripcion(Proforma proforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(proforma!=null/*&&proforma.getId()>0*/) {
			sDescripcion=ProformaConstantesFunciones.getProformaDescripcion(proforma);
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

	public static String getEmpaqueDescripcion(Empaque empaque) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empaque!=null/*&&empaque.getId()>0*/) {
			sDescripcion=EmpaqueConstantesFunciones.getEmpaqueDescripcion(empaque);
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

	public static String getEstadoDetalleProformaDescripcion(EstadoDetalleProforma estadodetalleproforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetalleproforma!=null/*&&estadodetalleproforma.getId()>0*/) {
			sDescripcion=EstadoDetalleProformaConstantesFunciones.getEstadoDetalleProformaDescripcion(estadodetalleproforma);
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
		} else if(sNombreIndice.equals("FK_IdEmpaque")) {
			sNombreIndice="Tipo=  Por Empaque";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleProforma")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdProforma")) {
			sNombreIndice="Tipo=  Por Proforma";
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

	public static String getDetalleIndiceFK_IdEmpaque(Long id_empaque) {
		String sDetalleIndice=" Parametros->";
		if(id_empaque!=null) {sDetalleIndice+=" Codigo Unico De Empaque="+id_empaque.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoDetalleProforma(Long id_estado_detalle_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_proforma!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_proforma.toString();} 

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

	public static String getDetalleIndiceFK_IdProforma(Long id_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_proforma!=null) {sDetalleIndice+=" Codigo Unico De Proforma="+id_proforma.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleProforma(DetalleProforma detalleproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleproforma.setdescripcion(detalleproforma.getdescripcion().trim());
		detalleproforma.setlote(detalleproforma.getlote().trim());
		detalleproforma.setarea(detalleproforma.getarea().trim());
		detalleproforma.setmedida(detalleproforma.getmedida().trim());
	}
	
	public static void quitarEspaciosDetalleProformas(List<DetalleProforma> detalleproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleProforma detalleproforma: detalleproformas) {
			detalleproforma.setdescripcion(detalleproforma.getdescripcion().trim());
			detalleproforma.setlote(detalleproforma.getlote().trim());
			detalleproforma.setarea(detalleproforma.getarea().trim());
			detalleproforma.setmedida(detalleproforma.getmedida().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleProforma(DetalleProforma detalleproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleproforma.getConCambioAuxiliar()) {
			detalleproforma.setIsDeleted(detalleproforma.getIsDeletedAuxiliar());	
			detalleproforma.setIsNew(detalleproforma.getIsNewAuxiliar());	
			detalleproforma.setIsChanged(detalleproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleproforma.setIsDeletedAuxiliar(false);	
			detalleproforma.setIsNewAuxiliar(false);	
			detalleproforma.setIsChangedAuxiliar(false);
			
			detalleproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleProformas(List<DetalleProforma> detalleproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleProforma detalleproforma : detalleproformas) {
			if(conAsignarBase && detalleproforma.getConCambioAuxiliar()) {
				detalleproforma.setIsDeleted(detalleproforma.getIsDeletedAuxiliar());	
				detalleproforma.setIsNew(detalleproforma.getIsNewAuxiliar());	
				detalleproforma.setIsChanged(detalleproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleproforma.setIsDeletedAuxiliar(false);	
				detalleproforma.setIsNewAuxiliar(false);	
				detalleproforma.setIsChangedAuxiliar(false);
				
				detalleproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleProforma(DetalleProforma detalleproforma,Boolean conEnteros) throws Exception  {
		detalleproforma.setcantidad_envases(0.0);
		detalleproforma.setprecio(0.0);
		detalleproforma.setiva(0.0);
		detalleproforma.setdescuento_porcentaje(0.0);
		detalleproforma.setdescuento_valor(0.0);
		detalleproforma.settotal(0.0);
		detalleproforma.setice(0.0);
		detalleproforma.setcosto(0.0);
		detalleproforma.setutilidad(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleproforma.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleProformas(List<DetalleProforma> detalleproformas,Boolean conEnteros) throws Exception  {
		
		for(DetalleProforma detalleproforma: detalleproformas) {
			detalleproforma.setcantidad_envases(0.0);
			detalleproforma.setprecio(0.0);
			detalleproforma.setiva(0.0);
			detalleproforma.setdescuento_porcentaje(0.0);
			detalleproforma.setdescuento_valor(0.0);
			detalleproforma.settotal(0.0);
			detalleproforma.setice(0.0);
			detalleproforma.setcosto(0.0);
			detalleproforma.setutilidad(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleproforma.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleProforma(List<DetalleProforma> detalleproformas,DetalleProforma detalleproformaAux) throws Exception  {
		DetalleProformaConstantesFunciones.InicializarValoresDetalleProforma(detalleproformaAux,true);
		
		for(DetalleProforma detalleproforma: detalleproformas) {
			if(detalleproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleproformaAux.setcantidad_envases(detalleproformaAux.getcantidad_envases()+detalleproforma.getcantidad_envases());			
			detalleproformaAux.setcantidad(detalleproformaAux.getcantidad()+detalleproforma.getcantidad());			
			detalleproformaAux.setprecio(detalleproformaAux.getprecio()+detalleproforma.getprecio());			
			detalleproformaAux.setiva(detalleproformaAux.getiva()+detalleproforma.getiva());			
			detalleproformaAux.setdescuento_porcentaje(detalleproformaAux.getdescuento_porcentaje()+detalleproforma.getdescuento_porcentaje());			
			detalleproformaAux.setdescuento_valor(detalleproformaAux.getdescuento_valor()+detalleproforma.getdescuento_valor());			
			detalleproformaAux.settotal(detalleproformaAux.gettotal()+detalleproforma.gettotal());			
			detalleproformaAux.setice(detalleproformaAux.getice()+detalleproforma.getice());			
			detalleproformaAux.setcosto(detalleproformaAux.getcosto()+detalleproforma.getcosto());			
			detalleproformaAux.setutilidad(detalleproformaAux.getutilidad()+detalleproforma.getutilidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleProformaConstantesFunciones.getArrayColumnasGlobalesDetalleProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProformaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProformaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProformaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProformaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProformaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProformaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProformaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleProforma> detalleproformas,DetalleProforma detalleproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleProforma detalleproformaAux: detalleproformas) {
			if(detalleproformaAux!=null && detalleproforma!=null) {
				if((detalleproformaAux.getId()==null && detalleproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleproformaAux.getId()!=null && detalleproforma.getId()!=null){
					if(detalleproformaAux.getId().equals(detalleproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleProforma(List<DetalleProforma> detalleproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_envasesTotal=0.0;
		Double precioTotal=0.0;
		Double ivaTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double totalTotal=0.0;
		Double iceTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
	
		for(DetalleProforma detalleproforma: detalleproformas) {			
			if(detalleproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidad_envasesTotal+=detalleproforma.getcantidad_envases();
			precioTotal+=detalleproforma.getprecio();
			ivaTotal+=detalleproforma.getiva();
			descuento_porcentajeTotal+=detalleproforma.getdescuento_porcentaje();
			descuento_valorTotal+=detalleproforma.getdescuento_valor();
			totalTotal+=detalleproforma.gettotal();
			iceTotal+=detalleproforma.getice();
			costoTotal+=detalleproforma.getcosto();
			utilidadTotal+=detalleproforma.getutilidad();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.CANTIDADENVASES);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES);
		datoGeneral.setdValorDouble(cantidad_envasesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProformaConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_ID, DetalleProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_VERSIONROW, DetalleProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDEMPRESA, DetalleProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDSUCURSAL, DetalleProformaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDEJERCICIO, DetalleProformaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDPERIODO, DetalleProformaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDANIO, DetalleProformaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDMES, DetalleProformaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDPROFORMA, DetalleProformaConstantesFunciones.IDPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDBODEGA, DetalleProformaConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDPRODUCTO, DetalleProformaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDUNIDAD, DetalleProformaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDEMPAQUE, DetalleProformaConstantesFunciones.IDEMPAQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleProformaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IDESTADODETALLEPROFORMA, DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_DESCRIPCION, DetalleProformaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES, DetalleProformaConstantesFunciones.CANTIDADENVASES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_CANTIDAD, DetalleProformaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_PRECIO, DetalleProformaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_IVA, DetalleProformaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR, DetalleProformaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_LOTE, DetalleProformaConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_TOTAL, DetalleProformaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_ICE, DetalleProformaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_COSTO, DetalleProformaConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_UTILIDAD, DetalleProformaConstantesFunciones.UTILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_AREA, DetalleProformaConstantesFunciones.AREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProformaConstantesFunciones.LABEL_MEDIDA, DetalleProformaConstantesFunciones.MEDIDA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDEMPAQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.CANTIDADENVASES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.UTILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.AREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProformaConstantesFunciones.MEDIDA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProforma() throws Exception  {
		return DetalleProformaConstantesFunciones.getTiposSeleccionarDetalleProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProforma(Boolean conFk) throws Exception  {
		return DetalleProformaConstantesFunciones.getTiposSeleccionarDetalleProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDPROFORMA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDEMPAQUE);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDEMPAQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IDESTADODETALLEPROFORMA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IDESTADODETALLEPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_UTILIDAD);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_UTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_AREA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_AREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProformaConstantesFunciones.LABEL_MEDIDA);
			reporte.setsDescripcion(DetalleProformaConstantesFunciones.LABEL_MEDIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleProforma(DetalleProforma detalleproformaAux) throws Exception {
		
			detalleproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleproformaAux.getEmpresa()));
			detalleproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproformaAux.getSucursal()));
			detalleproformaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleproformaAux.getEjercicio()));
			detalleproformaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleproformaAux.getPeriodo()));
			detalleproformaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleproformaAux.getAnio()));
			detalleproformaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleproformaAux.getMes()));
			detalleproformaAux.setproforma_descripcion(ProformaConstantesFunciones.getProformaDescripcion(detalleproformaAux.getProforma()));
			detalleproformaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleproformaAux.getBodega()));
			detalleproformaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleproformaAux.getProducto()));
			detalleproformaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleproformaAux.getUnidad()));
			detalleproformaAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detalleproformaAux.getEmpaque()));
			detalleproformaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleproformaAux.getCentroCosto()));
			detalleproformaAux.setestadodetalleproforma_descripcion(EstadoDetalleProformaConstantesFunciones.getEstadoDetalleProformaDescripcion(detalleproformaAux.getEstadoDetalleProforma()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleProforma(List<DetalleProforma> detalleproformasTemp) throws Exception {
		for(DetalleProforma detalleproformaAux:detalleproformasTemp) {
			
			detalleproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleproformaAux.getEmpresa()));
			detalleproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproformaAux.getSucursal()));
			detalleproformaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleproformaAux.getEjercicio()));
			detalleproformaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleproformaAux.getPeriodo()));
			detalleproformaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleproformaAux.getAnio()));
			detalleproformaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleproformaAux.getMes()));
			detalleproformaAux.setproforma_descripcion(ProformaConstantesFunciones.getProformaDescripcion(detalleproformaAux.getProforma()));
			detalleproformaAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleproformaAux.getBodega()));
			detalleproformaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleproformaAux.getProducto()));
			detalleproformaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleproformaAux.getUnidad()));
			detalleproformaAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detalleproformaAux.getEmpaque()));
			detalleproformaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleproformaAux.getCentroCosto()));
			detalleproformaAux.setestadodetalleproforma_descripcion(EstadoDetalleProformaConstantesFunciones.getEstadoDetalleProformaDescripcion(detalleproformaAux.getEstadoDetalleProforma()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Proforma.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Empaque.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(EstadoDetalleProforma.class));
				
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
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class));
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
					if(clas.clas.equals(Empaque.class)) {
						classes.add(new Classe(Empaque.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetalleProforma.class)) {
						classes.add(new Classe(EstadoDetalleProforma.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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

					if(Empaque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empaque.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(EstadoDetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleProforma.class)); continue;
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

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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

					if(Empaque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empaque.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(EstadoDetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleProforma.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleProformaConstantesFunciones.getClassesRelationshipsOfDetalleProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleProformaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleProforma detalleproforma,List<DetalleProforma> detalleproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleProforma detalleproformaEncontrado=null;
			
			for(DetalleProforma detalleproformaLocal:detalleproformas) {
				if(detalleproformaLocal.getId().equals(detalleproforma.getId())) {
					detalleproformaEncontrado=detalleproformaLocal;
					
					detalleproformaLocal.setIsChanged(detalleproforma.getIsChanged());
					detalleproformaLocal.setIsNew(detalleproforma.getIsNew());
					detalleproformaLocal.setIsDeleted(detalleproforma.getIsDeleted());
					
					detalleproformaLocal.setGeneralEntityOriginal(detalleproforma.getGeneralEntityOriginal());
					
					detalleproformaLocal.setId(detalleproforma.getId());	
					detalleproformaLocal.setVersionRow(detalleproforma.getVersionRow());	
					detalleproformaLocal.setid_empresa(detalleproforma.getid_empresa());	
					detalleproformaLocal.setid_sucursal(detalleproforma.getid_sucursal());	
					detalleproformaLocal.setid_ejercicio(detalleproforma.getid_ejercicio());	
					detalleproformaLocal.setid_periodo(detalleproforma.getid_periodo());	
					detalleproformaLocal.setid_anio(detalleproforma.getid_anio());	
					detalleproformaLocal.setid_mes(detalleproforma.getid_mes());	
					detalleproformaLocal.setid_proforma(detalleproforma.getid_proforma());	
					detalleproformaLocal.setid_bodega(detalleproforma.getid_bodega());	
					detalleproformaLocal.setid_producto(detalleproforma.getid_producto());	
					detalleproformaLocal.setid_unidad(detalleproforma.getid_unidad());	
					detalleproformaLocal.setid_empaque(detalleproforma.getid_empaque());	
					detalleproformaLocal.setid_centro_costo(detalleproforma.getid_centro_costo());	
					detalleproformaLocal.setid_estado_detalle_proforma(detalleproforma.getid_estado_detalle_proforma());	
					detalleproformaLocal.setdescripcion(detalleproforma.getdescripcion());	
					detalleproformaLocal.setcantidad_envases(detalleproforma.getcantidad_envases());	
					detalleproformaLocal.setcantidad(detalleproforma.getcantidad());	
					detalleproformaLocal.setprecio(detalleproforma.getprecio());	
					detalleproformaLocal.setiva(detalleproforma.getiva());	
					detalleproformaLocal.setdescuento_porcentaje(detalleproforma.getdescuento_porcentaje());	
					detalleproformaLocal.setdescuento_valor(detalleproforma.getdescuento_valor());	
					detalleproformaLocal.setlote(detalleproforma.getlote());	
					detalleproformaLocal.settotal(detalleproforma.gettotal());	
					detalleproformaLocal.setice(detalleproforma.getice());	
					detalleproformaLocal.setcosto(detalleproforma.getcosto());	
					detalleproformaLocal.setutilidad(detalleproforma.getutilidad());	
					detalleproformaLocal.setarea(detalleproforma.getarea());	
					detalleproformaLocal.setmedida(detalleproforma.getmedida());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleproforma.getIsDeleted()) {
				if(!existe) {
					detalleproformas.add(detalleproforma);
				}
			} else {
				if(detalleproformaEncontrado!=null && permiteQuitar)  {
					detalleproformas.remove(detalleproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleProforma detalleproforma,List<DetalleProforma> detalleproformas) throws Exception {
		try	{			
			for(DetalleProforma detalleproformaLocal:detalleproformas) {
				if(detalleproformaLocal.getId().equals(detalleproforma.getId())) {
					detalleproformaLocal.setIsSelected(detalleproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleProforma(List<DetalleProforma> detalleproformasAux) throws Exception {
		//this.detalleproformasAux=detalleproformasAux;
		
		for(DetalleProforma detalleproformaAux:detalleproformasAux) {
			if(detalleproformaAux.getIsChanged()) {
				detalleproformaAux.setIsChanged(false);
			}		
			
			if(detalleproformaAux.getIsNew()) {
				detalleproformaAux.setIsNew(false);
			}	
			
			if(detalleproformaAux.getIsDeleted()) {
				detalleproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleProforma(DetalleProforma detalleproformaAux) throws Exception {
		//this.detalleproformaAux=detalleproformaAux;
		
			if(detalleproformaAux.getIsChanged()) {
				detalleproformaAux.setIsChanged(false);
			}		
			
			if(detalleproformaAux.getIsNew()) {
				detalleproformaAux.setIsNew(false);
			}	
			
			if(detalleproformaAux.getIsDeleted()) {
				detalleproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleProforma detalleproformaAsignar,DetalleProforma detalleproforma) throws Exception {
		detalleproformaAsignar.setId(detalleproforma.getId());	
		detalleproformaAsignar.setVersionRow(detalleproforma.getVersionRow());	
		detalleproformaAsignar.setid_empresa(detalleproforma.getid_empresa());
		detalleproformaAsignar.setempresa_descripcion(detalleproforma.getempresa_descripcion());	
		detalleproformaAsignar.setid_sucursal(detalleproforma.getid_sucursal());
		detalleproformaAsignar.setsucursal_descripcion(detalleproforma.getsucursal_descripcion());	
		detalleproformaAsignar.setid_ejercicio(detalleproforma.getid_ejercicio());
		detalleproformaAsignar.setejercicio_descripcion(detalleproforma.getejercicio_descripcion());	
		detalleproformaAsignar.setid_periodo(detalleproforma.getid_periodo());
		detalleproformaAsignar.setperiodo_descripcion(detalleproforma.getperiodo_descripcion());	
		detalleproformaAsignar.setid_anio(detalleproforma.getid_anio());
		detalleproformaAsignar.setanio_descripcion(detalleproforma.getanio_descripcion());	
		detalleproformaAsignar.setid_mes(detalleproforma.getid_mes());
		detalleproformaAsignar.setmes_descripcion(detalleproforma.getmes_descripcion());	
		detalleproformaAsignar.setid_proforma(detalleproforma.getid_proforma());
		detalleproformaAsignar.setproforma_descripcion(detalleproforma.getproforma_descripcion());	
		detalleproformaAsignar.setid_bodega(detalleproforma.getid_bodega());
		detalleproformaAsignar.setbodega_descripcion(detalleproforma.getbodega_descripcion());	
		detalleproformaAsignar.setid_producto(detalleproforma.getid_producto());
		detalleproformaAsignar.setproducto_descripcion(detalleproforma.getproducto_descripcion());	
		detalleproformaAsignar.setid_unidad(detalleproforma.getid_unidad());
		detalleproformaAsignar.setunidad_descripcion(detalleproforma.getunidad_descripcion());	
		detalleproformaAsignar.setid_empaque(detalleproforma.getid_empaque());
		detalleproformaAsignar.setempaque_descripcion(detalleproforma.getempaque_descripcion());	
		detalleproformaAsignar.setid_centro_costo(detalleproforma.getid_centro_costo());
		detalleproformaAsignar.setcentrocosto_descripcion(detalleproforma.getcentrocosto_descripcion());	
		detalleproformaAsignar.setid_estado_detalle_proforma(detalleproforma.getid_estado_detalle_proforma());
		detalleproformaAsignar.setestadodetalleproforma_descripcion(detalleproforma.getestadodetalleproforma_descripcion());	
		detalleproformaAsignar.setdescripcion(detalleproforma.getdescripcion());	
		detalleproformaAsignar.setcantidad_envases(detalleproforma.getcantidad_envases());	
		detalleproformaAsignar.setcantidad(detalleproforma.getcantidad());	
		detalleproformaAsignar.setprecio(detalleproforma.getprecio());	
		detalleproformaAsignar.setiva(detalleproforma.getiva());	
		detalleproformaAsignar.setdescuento_porcentaje(detalleproforma.getdescuento_porcentaje());	
		detalleproformaAsignar.setdescuento_valor(detalleproforma.getdescuento_valor());	
		detalleproformaAsignar.setlote(detalleproforma.getlote());	
		detalleproformaAsignar.settotal(detalleproforma.gettotal());	
		detalleproformaAsignar.setice(detalleproforma.getice());	
		detalleproformaAsignar.setcosto(detalleproforma.getcosto());	
		detalleproformaAsignar.setutilidad(detalleproforma.getutilidad());	
		detalleproformaAsignar.setarea(detalleproforma.getarea());	
		detalleproformaAsignar.setmedida(detalleproforma.getmedida());	
	}
	
	public static void inicializarDetalleProforma(DetalleProforma detalleproforma) throws Exception {
		try {
				detalleproforma.setId(0L);	
					
				detalleproforma.setid_empresa(-1L);	
				detalleproforma.setid_sucursal(-1L);	
				detalleproforma.setid_ejercicio(-1L);	
				detalleproforma.setid_periodo(-1L);	
				detalleproforma.setid_anio(null);	
				detalleproforma.setid_mes(null);	
				detalleproforma.setid_proforma(-1L);	
				detalleproforma.setid_bodega(-1L);	
				detalleproforma.setid_producto(-1L);	
				detalleproforma.setid_unidad(-1L);	
				detalleproforma.setid_empaque(null);	
				detalleproforma.setid_centro_costo(null);	
				detalleproforma.setid_estado_detalle_proforma(-1L);	
				detalleproforma.setdescripcion("");	
				detalleproforma.setcantidad_envases(0.0);	
				detalleproforma.setcantidad(0);	
				detalleproforma.setprecio(0.0);	
				detalleproforma.setiva(0.0);	
				detalleproforma.setdescuento_porcentaje(0.0);	
				detalleproforma.setdescuento_valor(0.0);	
				detalleproforma.setlote("");	
				detalleproforma.settotal(0.0);	
				detalleproforma.setice(0.0);	
				detalleproforma.setcosto(0.0);	
				detalleproforma.setutilidad(0.0);	
				detalleproforma.setarea("");	
				detalleproforma.setmedida("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDEMPAQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IDESTADODETALLEPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_CANTIDADENVASES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_UTILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_AREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProformaConstantesFunciones.LABEL_MEDIDA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleProforma(String sTipo,Row row,Workbook workbook,DetalleProforma detalleproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getempaque_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getestadodetalleproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getcantidad_envases());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getutilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleproforma.getmedida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleProforma() {
		return this.sFinalQueryDetalleProforma;
	}
	
	public void setsFinalQueryDetalleProforma(String sFinalQueryDetalleProforma) {
		this.sFinalQueryDetalleProforma= sFinalQueryDetalleProforma;
	}
	
	public Border resaltarSeleccionarDetalleProforma=null;
	
	public Border setResaltarSeleccionarDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleProforma() {
		return this.resaltarSeleccionarDetalleProforma;
	}
	
	public void setResaltarSeleccionarDetalleProforma(Border borderResaltarSeleccionarDetalleProforma) {
		this.resaltarSeleccionarDetalleProforma= borderResaltarSeleccionarDetalleProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleProforma=null;
	public Boolean mostraridDetalleProforma=true;
	public Boolean activaridDetalleProforma=true;

	public Border resaltarid_empresaDetalleProforma=null;
	public Boolean mostrarid_empresaDetalleProforma=true;
	public Boolean activarid_empresaDetalleProforma=true;
	public Boolean cargarid_empresaDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleProforma=null;
	public Boolean mostrarid_sucursalDetalleProforma=true;
	public Boolean activarid_sucursalDetalleProforma=true;
	public Boolean cargarid_sucursalDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleProforma=null;
	public Boolean mostrarid_ejercicioDetalleProforma=true;
	public Boolean activarid_ejercicioDetalleProforma=true;
	public Boolean cargarid_ejercicioDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleProforma=null;
	public Boolean mostrarid_periodoDetalleProforma=true;
	public Boolean activarid_periodoDetalleProforma=true;
	public Boolean cargarid_periodoDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleProforma=null;
	public Boolean mostrarid_anioDetalleProforma=true;
	public Boolean activarid_anioDetalleProforma=false;
	public Boolean cargarid_anioDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleProforma=null;
	public Boolean mostrarid_mesDetalleProforma=true;
	public Boolean activarid_mesDetalleProforma=false;
	public Boolean cargarid_mesDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_proformaDetalleProforma=null;
	public Boolean mostrarid_proformaDetalleProforma=true;
	public Boolean activarid_proformaDetalleProforma=true;
	public Boolean cargarid_proformaDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_proformaDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleProforma=null;
	public Boolean mostrarid_bodegaDetalleProforma=true;
	public Boolean activarid_bodegaDetalleProforma=true;
	public Boolean cargarid_bodegaDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleProforma=null;
	public Boolean mostrarid_productoDetalleProforma=true;
	public Boolean activarid_productoDetalleProforma=true;
	public Boolean cargarid_productoDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleProforma=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleProforma=null;
	public Boolean mostrarid_unidadDetalleProforma=true;
	public Boolean activarid_unidadDetalleProforma=true;
	public Boolean cargarid_unidadDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleProforma=true;//ConEventDepend=true

	public Border resaltarid_empaqueDetalleProforma=null;
	public Boolean mostrarid_empaqueDetalleProforma=true;
	public Boolean activarid_empaqueDetalleProforma=true;
	public Boolean cargarid_empaqueDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empaqueDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleProforma=null;
	public Boolean mostrarid_centro_costoDetalleProforma=true;
	public Boolean activarid_centro_costoDetalleProforma=true;
	public Boolean cargarid_centro_costoDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleProforma=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_proformaDetalleProforma=null;
	public Boolean mostrarid_estado_detalle_proformaDetalleProforma=true;
	public Boolean activarid_estado_detalle_proformaDetalleProforma=true;
	public Boolean cargarid_estado_detalle_proformaDetalleProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_proformaDetalleProforma=false;//ConEventDepend=true

	public Border resaltardescripcionDetalleProforma=null;
	public Boolean mostrardescripcionDetalleProforma=true;
	public Boolean activardescripcionDetalleProforma=true;

	public Border resaltarcantidad_envasesDetalleProforma=null;
	public Boolean mostrarcantidad_envasesDetalleProforma=true;
	public Boolean activarcantidad_envasesDetalleProforma=true;

	public Border resaltarcantidadDetalleProforma=null;
	public Boolean mostrarcantidadDetalleProforma=true;
	public Boolean activarcantidadDetalleProforma=true;

	public Border resaltarprecioDetalleProforma=null;
	public Boolean mostrarprecioDetalleProforma=true;
	public Boolean activarprecioDetalleProforma=true;

	public Border resaltarivaDetalleProforma=null;
	public Boolean mostrarivaDetalleProforma=true;
	public Boolean activarivaDetalleProforma=true;

	public Border resaltardescuento_porcentajeDetalleProforma=null;
	public Boolean mostrardescuento_porcentajeDetalleProforma=true;
	public Boolean activardescuento_porcentajeDetalleProforma=true;

	public Border resaltardescuento_valorDetalleProforma=null;
	public Boolean mostrardescuento_valorDetalleProforma=true;
	public Boolean activardescuento_valorDetalleProforma=true;

	public Border resaltarloteDetalleProforma=null;
	public Boolean mostrarloteDetalleProforma=true;
	public Boolean activarloteDetalleProforma=true;

	public Border resaltartotalDetalleProforma=null;
	public Boolean mostrartotalDetalleProforma=true;
	public Boolean activartotalDetalleProforma=true;

	public Border resaltariceDetalleProforma=null;
	public Boolean mostrariceDetalleProforma=true;
	public Boolean activariceDetalleProforma=false;

	public Border resaltarcostoDetalleProforma=null;
	public Boolean mostrarcostoDetalleProforma=true;
	public Boolean activarcostoDetalleProforma=false;

	public Border resaltarutilidadDetalleProforma=null;
	public Boolean mostrarutilidadDetalleProforma=true;
	public Boolean activarutilidadDetalleProforma=false;

	public Border resaltarareaDetalleProforma=null;
	public Boolean mostrarareaDetalleProforma=true;
	public Boolean activarareaDetalleProforma=false;

	public Border resaltarmedidaDetalleProforma=null;
	public Boolean mostrarmedidaDetalleProforma=true;
	public Boolean activarmedidaDetalleProforma=false;

	
	

	public Border setResaltaridDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltaridDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleProforma() {
		return this.resaltaridDetalleProforma;
	}

	public void setResaltaridDetalleProforma(Border borderResaltar) {
		this.resaltaridDetalleProforma= borderResaltar;
	}

	public Boolean getMostraridDetalleProforma() {
		return this.mostraridDetalleProforma;
	}

	public void setMostraridDetalleProforma(Boolean mostraridDetalleProforma) {
		this.mostraridDetalleProforma= mostraridDetalleProforma;
	}

	public Boolean getActivaridDetalleProforma() {
		return this.activaridDetalleProforma;
	}

	public void setActivaridDetalleProforma(Boolean activaridDetalleProforma) {
		this.activaridDetalleProforma= activaridDetalleProforma;
	}

	public Border setResaltarid_empresaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleProforma() {
		return this.resaltarid_empresaDetalleProforma;
	}

	public void setResaltarid_empresaDetalleProforma(Border borderResaltar) {
		this.resaltarid_empresaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleProforma() {
		return this.mostrarid_empresaDetalleProforma;
	}

	public void setMostrarid_empresaDetalleProforma(Boolean mostrarid_empresaDetalleProforma) {
		this.mostrarid_empresaDetalleProforma= mostrarid_empresaDetalleProforma;
	}

	public Boolean getActivarid_empresaDetalleProforma() {
		return this.activarid_empresaDetalleProforma;
	}

	public void setActivarid_empresaDetalleProforma(Boolean activarid_empresaDetalleProforma) {
		this.activarid_empresaDetalleProforma= activarid_empresaDetalleProforma;
	}

	public Boolean getCargarid_empresaDetalleProforma() {
		return this.cargarid_empresaDetalleProforma;
	}

	public void setCargarid_empresaDetalleProforma(Boolean cargarid_empresaDetalleProforma) {
		this.cargarid_empresaDetalleProforma= cargarid_empresaDetalleProforma;
	}

	public Border setResaltarid_sucursalDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleProforma() {
		return this.resaltarid_sucursalDetalleProforma;
	}

	public void setResaltarid_sucursalDetalleProforma(Border borderResaltar) {
		this.resaltarid_sucursalDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleProforma() {
		return this.mostrarid_sucursalDetalleProforma;
	}

	public void setMostrarid_sucursalDetalleProforma(Boolean mostrarid_sucursalDetalleProforma) {
		this.mostrarid_sucursalDetalleProforma= mostrarid_sucursalDetalleProforma;
	}

	public Boolean getActivarid_sucursalDetalleProforma() {
		return this.activarid_sucursalDetalleProforma;
	}

	public void setActivarid_sucursalDetalleProforma(Boolean activarid_sucursalDetalleProforma) {
		this.activarid_sucursalDetalleProforma= activarid_sucursalDetalleProforma;
	}

	public Boolean getCargarid_sucursalDetalleProforma() {
		return this.cargarid_sucursalDetalleProforma;
	}

	public void setCargarid_sucursalDetalleProforma(Boolean cargarid_sucursalDetalleProforma) {
		this.cargarid_sucursalDetalleProforma= cargarid_sucursalDetalleProforma;
	}

	public Border setResaltarid_ejercicioDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleProforma() {
		return this.resaltarid_ejercicioDetalleProforma;
	}

	public void setResaltarid_ejercicioDetalleProforma(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleProforma() {
		return this.mostrarid_ejercicioDetalleProforma;
	}

	public void setMostrarid_ejercicioDetalleProforma(Boolean mostrarid_ejercicioDetalleProforma) {
		this.mostrarid_ejercicioDetalleProforma= mostrarid_ejercicioDetalleProforma;
	}

	public Boolean getActivarid_ejercicioDetalleProforma() {
		return this.activarid_ejercicioDetalleProforma;
	}

	public void setActivarid_ejercicioDetalleProforma(Boolean activarid_ejercicioDetalleProforma) {
		this.activarid_ejercicioDetalleProforma= activarid_ejercicioDetalleProforma;
	}

	public Boolean getCargarid_ejercicioDetalleProforma() {
		return this.cargarid_ejercicioDetalleProforma;
	}

	public void setCargarid_ejercicioDetalleProforma(Boolean cargarid_ejercicioDetalleProforma) {
		this.cargarid_ejercicioDetalleProforma= cargarid_ejercicioDetalleProforma;
	}

	public Border setResaltarid_periodoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleProforma() {
		return this.resaltarid_periodoDetalleProforma;
	}

	public void setResaltarid_periodoDetalleProforma(Border borderResaltar) {
		this.resaltarid_periodoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleProforma() {
		return this.mostrarid_periodoDetalleProforma;
	}

	public void setMostrarid_periodoDetalleProforma(Boolean mostrarid_periodoDetalleProforma) {
		this.mostrarid_periodoDetalleProforma= mostrarid_periodoDetalleProforma;
	}

	public Boolean getActivarid_periodoDetalleProforma() {
		return this.activarid_periodoDetalleProforma;
	}

	public void setActivarid_periodoDetalleProforma(Boolean activarid_periodoDetalleProforma) {
		this.activarid_periodoDetalleProforma= activarid_periodoDetalleProforma;
	}

	public Boolean getCargarid_periodoDetalleProforma() {
		return this.cargarid_periodoDetalleProforma;
	}

	public void setCargarid_periodoDetalleProforma(Boolean cargarid_periodoDetalleProforma) {
		this.cargarid_periodoDetalleProforma= cargarid_periodoDetalleProforma;
	}

	public Border setResaltarid_anioDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleProforma() {
		return this.resaltarid_anioDetalleProforma;
	}

	public void setResaltarid_anioDetalleProforma(Border borderResaltar) {
		this.resaltarid_anioDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleProforma() {
		return this.mostrarid_anioDetalleProforma;
	}

	public void setMostrarid_anioDetalleProforma(Boolean mostrarid_anioDetalleProforma) {
		this.mostrarid_anioDetalleProforma= mostrarid_anioDetalleProforma;
	}

	public Boolean getActivarid_anioDetalleProforma() {
		return this.activarid_anioDetalleProforma;
	}

	public void setActivarid_anioDetalleProforma(Boolean activarid_anioDetalleProforma) {
		this.activarid_anioDetalleProforma= activarid_anioDetalleProforma;
	}

	public Boolean getCargarid_anioDetalleProforma() {
		return this.cargarid_anioDetalleProforma;
	}

	public void setCargarid_anioDetalleProforma(Boolean cargarid_anioDetalleProforma) {
		this.cargarid_anioDetalleProforma= cargarid_anioDetalleProforma;
	}

	public Border setResaltarid_mesDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleProforma() {
		return this.resaltarid_mesDetalleProforma;
	}

	public void setResaltarid_mesDetalleProforma(Border borderResaltar) {
		this.resaltarid_mesDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleProforma() {
		return this.mostrarid_mesDetalleProforma;
	}

	public void setMostrarid_mesDetalleProforma(Boolean mostrarid_mesDetalleProforma) {
		this.mostrarid_mesDetalleProforma= mostrarid_mesDetalleProforma;
	}

	public Boolean getActivarid_mesDetalleProforma() {
		return this.activarid_mesDetalleProforma;
	}

	public void setActivarid_mesDetalleProforma(Boolean activarid_mesDetalleProforma) {
		this.activarid_mesDetalleProforma= activarid_mesDetalleProforma;
	}

	public Boolean getCargarid_mesDetalleProforma() {
		return this.cargarid_mesDetalleProforma;
	}

	public void setCargarid_mesDetalleProforma(Boolean cargarid_mesDetalleProforma) {
		this.cargarid_mesDetalleProforma= cargarid_mesDetalleProforma;
	}

	public Border setResaltarid_proformaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_proformaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_proformaDetalleProforma() {
		return this.resaltarid_proformaDetalleProforma;
	}

	public void setResaltarid_proformaDetalleProforma(Border borderResaltar) {
		this.resaltarid_proformaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_proformaDetalleProforma() {
		return this.mostrarid_proformaDetalleProforma;
	}

	public void setMostrarid_proformaDetalleProforma(Boolean mostrarid_proformaDetalleProforma) {
		this.mostrarid_proformaDetalleProforma= mostrarid_proformaDetalleProforma;
	}

	public Boolean getActivarid_proformaDetalleProforma() {
		return this.activarid_proformaDetalleProforma;
	}

	public void setActivarid_proformaDetalleProforma(Boolean activarid_proformaDetalleProforma) {
		this.activarid_proformaDetalleProforma= activarid_proformaDetalleProforma;
	}

	public Boolean getCargarid_proformaDetalleProforma() {
		return this.cargarid_proformaDetalleProforma;
	}

	public void setCargarid_proformaDetalleProforma(Boolean cargarid_proformaDetalleProforma) {
		this.cargarid_proformaDetalleProforma= cargarid_proformaDetalleProforma;
	}

	public Border setResaltarid_bodegaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleProforma() {
		return this.resaltarid_bodegaDetalleProforma;
	}

	public void setResaltarid_bodegaDetalleProforma(Border borderResaltar) {
		this.resaltarid_bodegaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleProforma() {
		return this.mostrarid_bodegaDetalleProforma;
	}

	public void setMostrarid_bodegaDetalleProforma(Boolean mostrarid_bodegaDetalleProforma) {
		this.mostrarid_bodegaDetalleProforma= mostrarid_bodegaDetalleProforma;
	}

	public Boolean getActivarid_bodegaDetalleProforma() {
		return this.activarid_bodegaDetalleProforma;
	}

	public void setActivarid_bodegaDetalleProforma(Boolean activarid_bodegaDetalleProforma) {
		this.activarid_bodegaDetalleProforma= activarid_bodegaDetalleProforma;
	}

	public Boolean getCargarid_bodegaDetalleProforma() {
		return this.cargarid_bodegaDetalleProforma;
	}

	public void setCargarid_bodegaDetalleProforma(Boolean cargarid_bodegaDetalleProforma) {
		this.cargarid_bodegaDetalleProforma= cargarid_bodegaDetalleProforma;
	}

	public Border setResaltarid_productoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleProforma() {
		return this.resaltarid_productoDetalleProforma;
	}

	public void setResaltarid_productoDetalleProforma(Border borderResaltar) {
		this.resaltarid_productoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleProforma() {
		return this.mostrarid_productoDetalleProforma;
	}

	public void setMostrarid_productoDetalleProforma(Boolean mostrarid_productoDetalleProforma) {
		this.mostrarid_productoDetalleProforma= mostrarid_productoDetalleProforma;
	}

	public Boolean getActivarid_productoDetalleProforma() {
		return this.activarid_productoDetalleProforma;
	}

	public void setActivarid_productoDetalleProforma(Boolean activarid_productoDetalleProforma) {
		this.activarid_productoDetalleProforma= activarid_productoDetalleProforma;
	}

	public Boolean getCargarid_productoDetalleProforma() {
		return this.cargarid_productoDetalleProforma;
	}

	public void setCargarid_productoDetalleProforma(Boolean cargarid_productoDetalleProforma) {
		this.cargarid_productoDetalleProforma= cargarid_productoDetalleProforma;
	}

	public Border setResaltarid_unidadDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleProforma() {
		return this.resaltarid_unidadDetalleProforma;
	}

	public void setResaltarid_unidadDetalleProforma(Border borderResaltar) {
		this.resaltarid_unidadDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleProforma() {
		return this.mostrarid_unidadDetalleProforma;
	}

	public void setMostrarid_unidadDetalleProforma(Boolean mostrarid_unidadDetalleProforma) {
		this.mostrarid_unidadDetalleProforma= mostrarid_unidadDetalleProforma;
	}

	public Boolean getActivarid_unidadDetalleProforma() {
		return this.activarid_unidadDetalleProforma;
	}

	public void setActivarid_unidadDetalleProforma(Boolean activarid_unidadDetalleProforma) {
		this.activarid_unidadDetalleProforma= activarid_unidadDetalleProforma;
	}

	public Boolean getCargarid_unidadDetalleProforma() {
		return this.cargarid_unidadDetalleProforma;
	}

	public void setCargarid_unidadDetalleProforma(Boolean cargarid_unidadDetalleProforma) {
		this.cargarid_unidadDetalleProforma= cargarid_unidadDetalleProforma;
	}

	public Border setResaltarid_empaqueDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_empaqueDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empaqueDetalleProforma() {
		return this.resaltarid_empaqueDetalleProforma;
	}

	public void setResaltarid_empaqueDetalleProforma(Border borderResaltar) {
		this.resaltarid_empaqueDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_empaqueDetalleProforma() {
		return this.mostrarid_empaqueDetalleProforma;
	}

	public void setMostrarid_empaqueDetalleProforma(Boolean mostrarid_empaqueDetalleProforma) {
		this.mostrarid_empaqueDetalleProforma= mostrarid_empaqueDetalleProforma;
	}

	public Boolean getActivarid_empaqueDetalleProforma() {
		return this.activarid_empaqueDetalleProforma;
	}

	public void setActivarid_empaqueDetalleProforma(Boolean activarid_empaqueDetalleProforma) {
		this.activarid_empaqueDetalleProforma= activarid_empaqueDetalleProforma;
	}

	public Boolean getCargarid_empaqueDetalleProforma() {
		return this.cargarid_empaqueDetalleProforma;
	}

	public void setCargarid_empaqueDetalleProforma(Boolean cargarid_empaqueDetalleProforma) {
		this.cargarid_empaqueDetalleProforma= cargarid_empaqueDetalleProforma;
	}

	public Border setResaltarid_centro_costoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleProforma() {
		return this.resaltarid_centro_costoDetalleProforma;
	}

	public void setResaltarid_centro_costoDetalleProforma(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleProforma() {
		return this.mostrarid_centro_costoDetalleProforma;
	}

	public void setMostrarid_centro_costoDetalleProforma(Boolean mostrarid_centro_costoDetalleProforma) {
		this.mostrarid_centro_costoDetalleProforma= mostrarid_centro_costoDetalleProforma;
	}

	public Boolean getActivarid_centro_costoDetalleProforma() {
		return this.activarid_centro_costoDetalleProforma;
	}

	public void setActivarid_centro_costoDetalleProforma(Boolean activarid_centro_costoDetalleProforma) {
		this.activarid_centro_costoDetalleProforma= activarid_centro_costoDetalleProforma;
	}

	public Boolean getCargarid_centro_costoDetalleProforma() {
		return this.cargarid_centro_costoDetalleProforma;
	}

	public void setCargarid_centro_costoDetalleProforma(Boolean cargarid_centro_costoDetalleProforma) {
		this.cargarid_centro_costoDetalleProforma= cargarid_centro_costoDetalleProforma;
	}

	public Border setResaltarid_estado_detalle_proformaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_proformaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_proformaDetalleProforma() {
		return this.resaltarid_estado_detalle_proformaDetalleProforma;
	}

	public void setResaltarid_estado_detalle_proformaDetalleProforma(Border borderResaltar) {
		this.resaltarid_estado_detalle_proformaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_proformaDetalleProforma() {
		return this.mostrarid_estado_detalle_proformaDetalleProforma;
	}

	public void setMostrarid_estado_detalle_proformaDetalleProforma(Boolean mostrarid_estado_detalle_proformaDetalleProforma) {
		this.mostrarid_estado_detalle_proformaDetalleProforma= mostrarid_estado_detalle_proformaDetalleProforma;
	}

	public Boolean getActivarid_estado_detalle_proformaDetalleProforma() {
		return this.activarid_estado_detalle_proformaDetalleProforma;
	}

	public void setActivarid_estado_detalle_proformaDetalleProforma(Boolean activarid_estado_detalle_proformaDetalleProforma) {
		this.activarid_estado_detalle_proformaDetalleProforma= activarid_estado_detalle_proformaDetalleProforma;
	}

	public Boolean getCargarid_estado_detalle_proformaDetalleProforma() {
		return this.cargarid_estado_detalle_proformaDetalleProforma;
	}

	public void setCargarid_estado_detalle_proformaDetalleProforma(Boolean cargarid_estado_detalle_proformaDetalleProforma) {
		this.cargarid_estado_detalle_proformaDetalleProforma= cargarid_estado_detalle_proformaDetalleProforma;
	}

	public Border setResaltardescripcionDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleProforma() {
		return this.resaltardescripcionDetalleProforma;
	}

	public void setResaltardescripcionDetalleProforma(Border borderResaltar) {
		this.resaltardescripcionDetalleProforma= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleProforma() {
		return this.mostrardescripcionDetalleProforma;
	}

	public void setMostrardescripcionDetalleProforma(Boolean mostrardescripcionDetalleProforma) {
		this.mostrardescripcionDetalleProforma= mostrardescripcionDetalleProforma;
	}

	public Boolean getActivardescripcionDetalleProforma() {
		return this.activardescripcionDetalleProforma;
	}

	public void setActivardescripcionDetalleProforma(Boolean activardescripcionDetalleProforma) {
		this.activardescripcionDetalleProforma= activardescripcionDetalleProforma;
	}

	public Border setResaltarcantidad_envasesDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarcantidad_envasesDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_envasesDetalleProforma() {
		return this.resaltarcantidad_envasesDetalleProforma;
	}

	public void setResaltarcantidad_envasesDetalleProforma(Border borderResaltar) {
		this.resaltarcantidad_envasesDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarcantidad_envasesDetalleProforma() {
		return this.mostrarcantidad_envasesDetalleProforma;
	}

	public void setMostrarcantidad_envasesDetalleProforma(Boolean mostrarcantidad_envasesDetalleProforma) {
		this.mostrarcantidad_envasesDetalleProforma= mostrarcantidad_envasesDetalleProforma;
	}

	public Boolean getActivarcantidad_envasesDetalleProforma() {
		return this.activarcantidad_envasesDetalleProforma;
	}

	public void setActivarcantidad_envasesDetalleProforma(Boolean activarcantidad_envasesDetalleProforma) {
		this.activarcantidad_envasesDetalleProforma= activarcantidad_envasesDetalleProforma;
	}

	public Border setResaltarcantidadDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleProforma() {
		return this.resaltarcantidadDetalleProforma;
	}

	public void setResaltarcantidadDetalleProforma(Border borderResaltar) {
		this.resaltarcantidadDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleProforma() {
		return this.mostrarcantidadDetalleProforma;
	}

	public void setMostrarcantidadDetalleProforma(Boolean mostrarcantidadDetalleProforma) {
		this.mostrarcantidadDetalleProforma= mostrarcantidadDetalleProforma;
	}

	public Boolean getActivarcantidadDetalleProforma() {
		return this.activarcantidadDetalleProforma;
	}

	public void setActivarcantidadDetalleProforma(Boolean activarcantidadDetalleProforma) {
		this.activarcantidadDetalleProforma= activarcantidadDetalleProforma;
	}

	public Border setResaltarprecioDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarprecioDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetalleProforma() {
		return this.resaltarprecioDetalleProforma;
	}

	public void setResaltarprecioDetalleProforma(Border borderResaltar) {
		this.resaltarprecioDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarprecioDetalleProforma() {
		return this.mostrarprecioDetalleProforma;
	}

	public void setMostrarprecioDetalleProforma(Boolean mostrarprecioDetalleProforma) {
		this.mostrarprecioDetalleProforma= mostrarprecioDetalleProforma;
	}

	public Boolean getActivarprecioDetalleProforma() {
		return this.activarprecioDetalleProforma;
	}

	public void setActivarprecioDetalleProforma(Boolean activarprecioDetalleProforma) {
		this.activarprecioDetalleProforma= activarprecioDetalleProforma;
	}

	public Border setResaltarivaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarivaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetalleProforma() {
		return this.resaltarivaDetalleProforma;
	}

	public void setResaltarivaDetalleProforma(Border borderResaltar) {
		this.resaltarivaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarivaDetalleProforma() {
		return this.mostrarivaDetalleProforma;
	}

	public void setMostrarivaDetalleProforma(Boolean mostrarivaDetalleProforma) {
		this.mostrarivaDetalleProforma= mostrarivaDetalleProforma;
	}

	public Boolean getActivarivaDetalleProforma() {
		return this.activarivaDetalleProforma;
	}

	public void setActivarivaDetalleProforma(Boolean activarivaDetalleProforma) {
		this.activarivaDetalleProforma= activarivaDetalleProforma;
	}

	public Border setResaltardescuento_porcentajeDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeDetalleProforma() {
		return this.resaltardescuento_porcentajeDetalleProforma;
	}

	public void setResaltardescuento_porcentajeDetalleProforma(Border borderResaltar) {
		this.resaltardescuento_porcentajeDetalleProforma= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeDetalleProforma() {
		return this.mostrardescuento_porcentajeDetalleProforma;
	}

	public void setMostrardescuento_porcentajeDetalleProforma(Boolean mostrardescuento_porcentajeDetalleProforma) {
		this.mostrardescuento_porcentajeDetalleProforma= mostrardescuento_porcentajeDetalleProforma;
	}

	public Boolean getActivardescuento_porcentajeDetalleProforma() {
		return this.activardescuento_porcentajeDetalleProforma;
	}

	public void setActivardescuento_porcentajeDetalleProforma(Boolean activardescuento_porcentajeDetalleProforma) {
		this.activardescuento_porcentajeDetalleProforma= activardescuento_porcentajeDetalleProforma;
	}

	public Border setResaltardescuento_valorDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetalleProforma() {
		return this.resaltardescuento_valorDetalleProforma;
	}

	public void setResaltardescuento_valorDetalleProforma(Border borderResaltar) {
		this.resaltardescuento_valorDetalleProforma= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetalleProforma() {
		return this.mostrardescuento_valorDetalleProforma;
	}

	public void setMostrardescuento_valorDetalleProforma(Boolean mostrardescuento_valorDetalleProforma) {
		this.mostrardescuento_valorDetalleProforma= mostrardescuento_valorDetalleProforma;
	}

	public Boolean getActivardescuento_valorDetalleProforma() {
		return this.activardescuento_valorDetalleProforma;
	}

	public void setActivardescuento_valorDetalleProforma(Boolean activardescuento_valorDetalleProforma) {
		this.activardescuento_valorDetalleProforma= activardescuento_valorDetalleProforma;
	}

	public Border setResaltarloteDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarloteDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetalleProforma() {
		return this.resaltarloteDetalleProforma;
	}

	public void setResaltarloteDetalleProforma(Border borderResaltar) {
		this.resaltarloteDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarloteDetalleProforma() {
		return this.mostrarloteDetalleProforma;
	}

	public void setMostrarloteDetalleProforma(Boolean mostrarloteDetalleProforma) {
		this.mostrarloteDetalleProforma= mostrarloteDetalleProforma;
	}

	public Boolean getActivarloteDetalleProforma() {
		return this.activarloteDetalleProforma;
	}

	public void setActivarloteDetalleProforma(Boolean activarloteDetalleProforma) {
		this.activarloteDetalleProforma= activarloteDetalleProforma;
	}

	public Border setResaltartotalDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltartotalDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleProforma() {
		return this.resaltartotalDetalleProforma;
	}

	public void setResaltartotalDetalleProforma(Border borderResaltar) {
		this.resaltartotalDetalleProforma= borderResaltar;
	}

	public Boolean getMostrartotalDetalleProforma() {
		return this.mostrartotalDetalleProforma;
	}

	public void setMostrartotalDetalleProforma(Boolean mostrartotalDetalleProforma) {
		this.mostrartotalDetalleProforma= mostrartotalDetalleProforma;
	}

	public Boolean getActivartotalDetalleProforma() {
		return this.activartotalDetalleProforma;
	}

	public void setActivartotalDetalleProforma(Boolean activartotalDetalleProforma) {
		this.activartotalDetalleProforma= activartotalDetalleProforma;
	}

	public Border setResaltariceDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltariceDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetalleProforma() {
		return this.resaltariceDetalleProforma;
	}

	public void setResaltariceDetalleProforma(Border borderResaltar) {
		this.resaltariceDetalleProforma= borderResaltar;
	}

	public Boolean getMostrariceDetalleProforma() {
		return this.mostrariceDetalleProforma;
	}

	public void setMostrariceDetalleProforma(Boolean mostrariceDetalleProforma) {
		this.mostrariceDetalleProforma= mostrariceDetalleProforma;
	}

	public Boolean getActivariceDetalleProforma() {
		return this.activariceDetalleProforma;
	}

	public void setActivariceDetalleProforma(Boolean activariceDetalleProforma) {
		this.activariceDetalleProforma= activariceDetalleProforma;
	}

	public Border setResaltarcostoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarcostoDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetalleProforma() {
		return this.resaltarcostoDetalleProforma;
	}

	public void setResaltarcostoDetalleProforma(Border borderResaltar) {
		this.resaltarcostoDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarcostoDetalleProforma() {
		return this.mostrarcostoDetalleProforma;
	}

	public void setMostrarcostoDetalleProforma(Boolean mostrarcostoDetalleProforma) {
		this.mostrarcostoDetalleProforma= mostrarcostoDetalleProforma;
	}

	public Boolean getActivarcostoDetalleProforma() {
		return this.activarcostoDetalleProforma;
	}

	public void setActivarcostoDetalleProforma(Boolean activarcostoDetalleProforma) {
		this.activarcostoDetalleProforma= activarcostoDetalleProforma;
	}

	public Border setResaltarutilidadDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarutilidadDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidadDetalleProforma() {
		return this.resaltarutilidadDetalleProforma;
	}

	public void setResaltarutilidadDetalleProforma(Border borderResaltar) {
		this.resaltarutilidadDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarutilidadDetalleProforma() {
		return this.mostrarutilidadDetalleProforma;
	}

	public void setMostrarutilidadDetalleProforma(Boolean mostrarutilidadDetalleProforma) {
		this.mostrarutilidadDetalleProforma= mostrarutilidadDetalleProforma;
	}

	public Boolean getActivarutilidadDetalleProforma() {
		return this.activarutilidadDetalleProforma;
	}

	public void setActivarutilidadDetalleProforma(Boolean activarutilidadDetalleProforma) {
		this.activarutilidadDetalleProforma= activarutilidadDetalleProforma;
	}

	public Border setResaltarareaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarareaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarareaDetalleProforma() {
		return this.resaltarareaDetalleProforma;
	}

	public void setResaltarareaDetalleProforma(Border borderResaltar) {
		this.resaltarareaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarareaDetalleProforma() {
		return this.mostrarareaDetalleProforma;
	}

	public void setMostrarareaDetalleProforma(Boolean mostrarareaDetalleProforma) {
		this.mostrarareaDetalleProforma= mostrarareaDetalleProforma;
	}

	public Boolean getActivarareaDetalleProforma() {
		return this.activarareaDetalleProforma;
	}

	public void setActivarareaDetalleProforma(Boolean activarareaDetalleProforma) {
		this.activarareaDetalleProforma= activarareaDetalleProforma;
	}

	public Border setResaltarmedidaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproformaBeanSwingJInternalFrame.jTtoolBarDetalleProforma.setBorder(borderResaltar);
		
		this.resaltarmedidaDetalleProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmedidaDetalleProforma() {
		return this.resaltarmedidaDetalleProforma;
	}

	public void setResaltarmedidaDetalleProforma(Border borderResaltar) {
		this.resaltarmedidaDetalleProforma= borderResaltar;
	}

	public Boolean getMostrarmedidaDetalleProforma() {
		return this.mostrarmedidaDetalleProforma;
	}

	public void setMostrarmedidaDetalleProforma(Boolean mostrarmedidaDetalleProforma) {
		this.mostrarmedidaDetalleProforma= mostrarmedidaDetalleProforma;
	}

	public Boolean getActivarmedidaDetalleProforma() {
		return this.activarmedidaDetalleProforma;
	}

	public void setActivarmedidaDetalleProforma(Boolean activarmedidaDetalleProforma) {
		this.activarmedidaDetalleProforma= activarmedidaDetalleProforma;
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
		
		
		this.setMostraridDetalleProforma(esInicial);
		this.setMostrarid_empresaDetalleProforma(esInicial);
		this.setMostrarid_sucursalDetalleProforma(esInicial);
		this.setMostrarid_ejercicioDetalleProforma(esInicial);
		this.setMostrarid_periodoDetalleProforma(esInicial);
		this.setMostrarid_anioDetalleProforma(esInicial);
		this.setMostrarid_mesDetalleProforma(esInicial);
		this.setMostrarid_proformaDetalleProforma(esInicial);
		this.setMostrarid_bodegaDetalleProforma(esInicial);
		this.setMostrarid_productoDetalleProforma(esInicial);
		this.setMostrarid_unidadDetalleProforma(esInicial);
		this.setMostrarid_empaqueDetalleProforma(esInicial);
		this.setMostrarid_centro_costoDetalleProforma(esInicial);
		this.setMostrarid_estado_detalle_proformaDetalleProforma(esInicial);
		this.setMostrardescripcionDetalleProforma(esInicial);
		this.setMostrarcantidad_envasesDetalleProforma(esInicial);
		this.setMostrarcantidadDetalleProforma(esInicial);
		this.setMostrarprecioDetalleProforma(esInicial);
		this.setMostrarivaDetalleProforma(esInicial);
		this.setMostrardescuento_porcentajeDetalleProforma(esInicial);
		this.setMostrardescuento_valorDetalleProforma(esInicial);
		this.setMostrarloteDetalleProforma(esInicial);
		this.setMostrartotalDetalleProforma(esInicial);
		this.setMostrariceDetalleProforma(esInicial);
		this.setMostrarcostoDetalleProforma(esInicial);
		this.setMostrarutilidadDetalleProforma(esInicial);
		this.setMostrarareaDetalleProforma(esInicial);
		this.setMostrarmedidaDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ID)) {
				this.setMostraridDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPROFORMA)) {
				this.setMostrarid_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPAQUE)) {
				this.setMostrarid_empaqueDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA)) {
				this.setMostrarid_estado_detalle_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDADENVASES)) {
				this.setMostrarcantidad_envasesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IVA)) {
				this.setMostrarivaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.LOTE)) {
				this.setMostrarloteDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ICE)) {
				this.setMostrariceDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.UTILIDAD)) {
				this.setMostrarutilidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.AREA)) {
				this.setMostrarareaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.MEDIDA)) {
				this.setMostrarmedidaDetalleProforma(esAsigna);
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
		
		
		this.setActivaridDetalleProforma(esInicial);
		this.setActivarid_empresaDetalleProforma(esInicial);
		this.setActivarid_sucursalDetalleProforma(esInicial);
		this.setActivarid_ejercicioDetalleProforma(esInicial);
		this.setActivarid_periodoDetalleProforma(esInicial);
		this.setActivarid_anioDetalleProforma(esInicial);
		this.setActivarid_mesDetalleProforma(esInicial);
		this.setActivarid_proformaDetalleProforma(esInicial);
		this.setActivarid_bodegaDetalleProforma(esInicial);
		this.setActivarid_productoDetalleProforma(esInicial);
		this.setActivarid_unidadDetalleProforma(esInicial);
		this.setActivarid_empaqueDetalleProforma(esInicial);
		this.setActivarid_centro_costoDetalleProforma(esInicial);
		this.setActivarid_estado_detalle_proformaDetalleProforma(esInicial);
		this.setActivardescripcionDetalleProforma(esInicial);
		this.setActivarcantidad_envasesDetalleProforma(esInicial);
		this.setActivarcantidadDetalleProforma(esInicial);
		this.setActivarprecioDetalleProforma(esInicial);
		this.setActivarivaDetalleProforma(esInicial);
		this.setActivardescuento_porcentajeDetalleProforma(esInicial);
		this.setActivardescuento_valorDetalleProforma(esInicial);
		this.setActivarloteDetalleProforma(esInicial);
		this.setActivartotalDetalleProforma(esInicial);
		this.setActivariceDetalleProforma(esInicial);
		this.setActivarcostoDetalleProforma(esInicial);
		this.setActivarutilidadDetalleProforma(esInicial);
		this.setActivarareaDetalleProforma(esInicial);
		this.setActivarmedidaDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ID)) {
				this.setActivaridDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPROFORMA)) {
				this.setActivarid_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPAQUE)) {
				this.setActivarid_empaqueDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA)) {
				this.setActivarid_estado_detalle_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDADENVASES)) {
				this.setActivarcantidad_envasesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IVA)) {
				this.setActivarivaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.LOTE)) {
				this.setActivarloteDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ICE)) {
				this.setActivariceDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.COSTO)) {
				this.setActivarcostoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.UTILIDAD)) {
				this.setActivarutilidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.AREA)) {
				this.setActivarareaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.MEDIDA)) {
				this.setActivarmedidaDetalleProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleProforma(esInicial);
		this.setResaltarid_empresaDetalleProforma(esInicial);
		this.setResaltarid_sucursalDetalleProforma(esInicial);
		this.setResaltarid_ejercicioDetalleProforma(esInicial);
		this.setResaltarid_periodoDetalleProforma(esInicial);
		this.setResaltarid_anioDetalleProforma(esInicial);
		this.setResaltarid_mesDetalleProforma(esInicial);
		this.setResaltarid_proformaDetalleProforma(esInicial);
		this.setResaltarid_bodegaDetalleProforma(esInicial);
		this.setResaltarid_productoDetalleProforma(esInicial);
		this.setResaltarid_unidadDetalleProforma(esInicial);
		this.setResaltarid_empaqueDetalleProforma(esInicial);
		this.setResaltarid_centro_costoDetalleProforma(esInicial);
		this.setResaltarid_estado_detalle_proformaDetalleProforma(esInicial);
		this.setResaltardescripcionDetalleProforma(esInicial);
		this.setResaltarcantidad_envasesDetalleProforma(esInicial);
		this.setResaltarcantidadDetalleProforma(esInicial);
		this.setResaltarprecioDetalleProforma(esInicial);
		this.setResaltarivaDetalleProforma(esInicial);
		this.setResaltardescuento_porcentajeDetalleProforma(esInicial);
		this.setResaltardescuento_valorDetalleProforma(esInicial);
		this.setResaltarloteDetalleProforma(esInicial);
		this.setResaltartotalDetalleProforma(esInicial);
		this.setResaltariceDetalleProforma(esInicial);
		this.setResaltarcostoDetalleProforma(esInicial);
		this.setResaltarutilidadDetalleProforma(esInicial);
		this.setResaltarareaDetalleProforma(esInicial);
		this.setResaltarmedidaDetalleProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ID)) {
				this.setResaltaridDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPROFORMA)) {
				this.setResaltarid_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDEMPAQUE)) {
				this.setResaltarid_empaqueDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA)) {
				this.setResaltarid_estado_detalle_proformaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDADENVASES)) {
				this.setResaltarcantidad_envasesDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.IVA)) {
				this.setResaltarivaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.LOTE)) {
				this.setResaltarloteDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.ICE)) {
				this.setResaltariceDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.UTILIDAD)) {
				this.setResaltarutilidadDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.AREA)) {
				this.setResaltarareaDetalleProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProformaConstantesFunciones.MEDIDA)) {
				this.setResaltarmedidaDetalleProforma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleProforma=true;

	public Boolean getMostrarFK_IdBodegaDetalleProforma() {
		return this.mostrarFK_IdBodegaDetalleProforma;
	}

	public void setMostrarFK_IdBodegaDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleProforma=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleProforma() {
		return this.mostrarFK_IdCentroCostoDetalleProforma;
	}

	public void setMostrarFK_IdCentroCostoDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleProforma=true;

	public Boolean getMostrarFK_IdEjercicioDetalleProforma() {
		return this.mostrarFK_IdEjercicioDetalleProforma;
	}

	public void setMostrarFK_IdEjercicioDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpaqueDetalleProforma=true;

	public Boolean getMostrarFK_IdEmpaqueDetalleProforma() {
		return this.mostrarFK_IdEmpaqueDetalleProforma;
	}

	public void setMostrarFK_IdEmpaqueDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpaqueDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleProforma=true;

	public Boolean getMostrarFK_IdEmpresaDetalleProforma() {
		return this.mostrarFK_IdEmpresaDetalleProforma;
	}

	public void setMostrarFK_IdEmpresaDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleProformaDetalleProforma=true;

	public Boolean getMostrarFK_IdEstadoDetalleProformaDetalleProforma() {
		return this.mostrarFK_IdEstadoDetalleProformaDetalleProforma;
	}

	public void setMostrarFK_IdEstadoDetalleProformaDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleProformaDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleProforma=true;

	public Boolean getMostrarFK_IdPeriodoDetalleProforma() {
		return this.mostrarFK_IdPeriodoDetalleProforma;
	}

	public void setMostrarFK_IdPeriodoDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleProforma=true;

	public Boolean getMostrarFK_IdProductoDetalleProforma() {
		return this.mostrarFK_IdProductoDetalleProforma;
	}

	public void setMostrarFK_IdProductoDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProformaDetalleProforma=true;

	public Boolean getMostrarFK_IdProformaDetalleProforma() {
		return this.mostrarFK_IdProformaDetalleProforma;
	}

	public void setMostrarFK_IdProformaDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProformaDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleProforma=true;

	public Boolean getMostrarFK_IdSucursalDetalleProforma() {
		return this.mostrarFK_IdSucursalDetalleProforma;
	}

	public void setMostrarFK_IdSucursalDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleProforma=true;

	public Boolean getMostrarFK_IdUnidadDetalleProforma() {
		return this.mostrarFK_IdUnidadDetalleProforma;
	}

	public void setMostrarFK_IdUnidadDetalleProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleProforma=true;

	public Boolean getActivarFK_IdBodegaDetalleProforma() {
		return this.activarFK_IdBodegaDetalleProforma;
	}

	public void setActivarFK_IdBodegaDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleProforma=true;

	public Boolean getActivarFK_IdCentroCostoDetalleProforma() {
		return this.activarFK_IdCentroCostoDetalleProforma;
	}

	public void setActivarFK_IdCentroCostoDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleProforma=true;

	public Boolean getActivarFK_IdEjercicioDetalleProforma() {
		return this.activarFK_IdEjercicioDetalleProforma;
	}

	public void setActivarFK_IdEjercicioDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpaqueDetalleProforma=true;

	public Boolean getActivarFK_IdEmpaqueDetalleProforma() {
		return this.activarFK_IdEmpaqueDetalleProforma;
	}

	public void setActivarFK_IdEmpaqueDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpaqueDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleProforma=true;

	public Boolean getActivarFK_IdEmpresaDetalleProforma() {
		return this.activarFK_IdEmpresaDetalleProforma;
	}

	public void setActivarFK_IdEmpresaDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleProformaDetalleProforma=true;

	public Boolean getActivarFK_IdEstadoDetalleProformaDetalleProforma() {
		return this.activarFK_IdEstadoDetalleProformaDetalleProforma;
	}

	public void setActivarFK_IdEstadoDetalleProformaDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleProformaDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleProforma=true;

	public Boolean getActivarFK_IdPeriodoDetalleProforma() {
		return this.activarFK_IdPeriodoDetalleProforma;
	}

	public void setActivarFK_IdPeriodoDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleProforma=true;

	public Boolean getActivarFK_IdProductoDetalleProforma() {
		return this.activarFK_IdProductoDetalleProforma;
	}

	public void setActivarFK_IdProductoDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdProformaDetalleProforma=true;

	public Boolean getActivarFK_IdProformaDetalleProforma() {
		return this.activarFK_IdProformaDetalleProforma;
	}

	public void setActivarFK_IdProformaDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdProformaDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleProforma=true;

	public Boolean getActivarFK_IdSucursalDetalleProforma() {
		return this.activarFK_IdSucursalDetalleProforma;
	}

	public void setActivarFK_IdSucursalDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleProforma=true;

	public Boolean getActivarFK_IdUnidadDetalleProforma() {
		return this.activarFK_IdUnidadDetalleProforma;
	}

	public void setActivarFK_IdUnidadDetalleProforma(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleProforma=null;

	public Border getResaltarFK_IdBodegaDetalleProforma() {
		return this.resaltarFK_IdBodegaDetalleProforma;
	}

	public void setResaltarFK_IdBodegaDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleProforma=null;

	public Border getResaltarFK_IdCentroCostoDetalleProforma() {
		return this.resaltarFK_IdCentroCostoDetalleProforma;
	}

	public void setResaltarFK_IdCentroCostoDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleProforma=null;

	public Border getResaltarFK_IdEjercicioDetalleProforma() {
		return this.resaltarFK_IdEjercicioDetalleProforma;
	}

	public void setResaltarFK_IdEjercicioDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdEmpaqueDetalleProforma=null;

	public Border getResaltarFK_IdEmpaqueDetalleProforma() {
		return this.resaltarFK_IdEmpaqueDetalleProforma;
	}

	public void setResaltarFK_IdEmpaqueDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpaqueDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpaqueDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpaqueDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleProforma=null;

	public Border getResaltarFK_IdEmpresaDetalleProforma() {
		return this.resaltarFK_IdEmpresaDetalleProforma;
	}

	public void setResaltarFK_IdEmpresaDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleProformaDetalleProforma=null;

	public Border getResaltarFK_IdEstadoDetalleProformaDetalleProforma() {
		return this.resaltarFK_IdEstadoDetalleProformaDetalleProforma;
	}

	public void setResaltarFK_IdEstadoDetalleProformaDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleProformaDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleProformaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleProformaDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleProforma=null;

	public Border getResaltarFK_IdPeriodoDetalleProforma() {
		return this.resaltarFK_IdPeriodoDetalleProforma;
	}

	public void setResaltarFK_IdPeriodoDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleProforma=null;

	public Border getResaltarFK_IdProductoDetalleProforma() {
		return this.resaltarFK_IdProductoDetalleProforma;
	}

	public void setResaltarFK_IdProductoDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdProformaDetalleProforma=null;

	public Border getResaltarFK_IdProformaDetalleProforma() {
		return this.resaltarFK_IdProformaDetalleProforma;
	}

	public void setResaltarFK_IdProformaDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdProformaDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdProformaDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProformaDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleProforma=null;

	public Border getResaltarFK_IdSucursalDetalleProforma() {
		return this.resaltarFK_IdSucursalDetalleProforma;
	}

	public void setResaltarFK_IdSucursalDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleProforma= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleProforma=null;

	public Border getResaltarFK_IdUnidadDetalleProforma() {
		return this.resaltarFK_IdUnidadDetalleProforma;
	}

	public void setResaltarFK_IdUnidadDetalleProforma(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleProforma= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProformaBeanSwingJInternalFrame detalleproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}