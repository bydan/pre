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


import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliParameterGeneral;

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
final public class DetaNotaCreditoSoliConstantesFunciones extends DetaNotaCreditoSoliConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetaNotaCreditoSoli";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetaNotaCreditoSoli"+DetaNotaCreditoSoliConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetaNotaCreditoSoliHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetaNotaCreditoSoliHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetaNotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetaNotaCreditoSoliConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetaNotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetaNotaCreditoSoliConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle  Solicitud Nota Credits";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle  Solicitud Nota Credit";
	public static final String SCLASSWEBTITULO_LOWER="Deta Nota Credito Soli";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetaNotaCreditoSoli";
	public static final String OBJECTNAME="detanotacreditosoli";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="deta_nota_credito_soli";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detanotacreditosoli from "+DetaNotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" detanotacreditosoli";
	public static String QUERYSELECTNATIVE="select "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_empresa,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_sucursal,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_periodo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_anio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_mes,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_nota_credito_soli,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_bodega,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_producto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_unidad,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_empaque,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_devolucion_empresa,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_centro_costo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".cantidad,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".precio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_descuen,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descuento,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".impuesto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_iva,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".total,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descripcion,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".codigo_lote,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".numero_caja,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descuento2,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".costo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".incluye_impuesto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_ice,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_emision from "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetaNotaCreditoSoliConstantesFuncionesAdditional detanotacreditosoliConstantesFuncionesAdditional=null;
	
	public DetaNotaCreditoSoliConstantesFuncionesAdditional getDetaNotaCreditoSoliConstantesFuncionesAdditional() {
		return this.detanotacreditosoliConstantesFuncionesAdditional;
	}
	
	public void setDetaNotaCreditoSoliConstantesFuncionesAdditional(DetaNotaCreditoSoliConstantesFuncionesAdditional detanotacreditosoliConstantesFuncionesAdditional) {
		try {
			this.detanotacreditosoliConstantesFuncionesAdditional=detanotacreditosoliConstantesFuncionesAdditional;
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
    public static final String IDNOTACREDITOSOLI= "id_nota_credito_soli";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDEMPAQUE= "id_empaque";
    public static final String IDTIPODEVOLUCIONEMPRESA= "id_tipo_devolucion_empresa";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String PORCENDESCUEN= "porcen_descuen";
    public static final String DESCUENTO= "descuento";
    public static final String IMPUESTO= "impuesto";
    public static final String PORCENIVA= "porcen_iva";
    public static final String TOTAL= "total";
    public static final String DESCRIPCION= "descripcion";
    public static final String CODIGOLOTE= "codigo_lote";
    public static final String NUMEROCAJA= "numero_caja";
    public static final String DESCUENTO2= "descuento2";
    public static final String COSTO= "costo";
    public static final String INCLUYEIMPUESTO= "incluye_impuesto";
    public static final String PORCENICE= "porcen_ice";
    public static final String FECHAEMISION= "fecha_emision";
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
    	public static final String LABEL_IDNOTACREDITOSOLI= "Solicitud Nota Credito";
		public static final String LABEL_IDNOTACREDITOSOLI_LOWER= "Nota Credito Soli";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDEMPAQUE= "Empaque";
		public static final String LABEL_IDEMPAQUE_LOWER= "Empaque";
    	public static final String LABEL_IDTIPODEVOLUCIONEMPRESA= "Tipo Devolucion";
		public static final String LABEL_IDTIPODEVOLUCIONEMPRESA_LOWER= "Tipo Devolucion Empresa";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_PORCENDESCUEN= "% Descuen";
		public static final String LABEL_PORCENDESCUEN_LOWER= "Porcen Descuen";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_PORCENIVA= "% Iva";
		public static final String LABEL_PORCENIVA_LOWER= "Porcen Iva";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CODIGOLOTE= "Codigo Lote";
		public static final String LABEL_CODIGOLOTE_LOWER= "Codigo Lote";
    	public static final String LABEL_NUMEROCAJA= "Numero Caja";
		public static final String LABEL_NUMEROCAJA_LOWER= "Numero Caja";
    	public static final String LABEL_DESCUENTO2= "Descuento2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_INCLUYEIMPUESTO= "Incluye Impuesto";
		public static final String LABEL_INCLUYEIMPUESTO_LOWER= "Incluye Impuesto";
    	public static final String LABEL_PORCENICE= "% Ice";
		public static final String LABEL_PORCENICE_LOWER= "Porcen Ice";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_LOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_LOTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getDetaNotaCreditoSoliLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDANIO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDMES)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDNOTACREDITOSOLI;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDBODEGA)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPAQUE;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.CANTIDAD)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.PRECIO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.IMPUESTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENIVA)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.TOTAL)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_CODIGOLOTE;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_NUMEROCAJA;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.COSTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_INCLUYEIMPUESTO;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENICE)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE;}
		if(sNombreColumna.equals(DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetaNotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getincluye_impuestoDescripcion(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detanotacreditosoli.getincluye_impuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getincluye_impuestoHtmlDescripcion(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detanotacreditosoli.getId(),detanotacreditosoli.getincluye_impuesto());

		return sDescripcion;
	}	
			
			
	
	public static String getDetaNotaCreditoSoliDescripcion(DetaNotaCreditoSoli detanotacreditosoli) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detanotacreditosoli !=null/* && detanotacreditosoli.getId()!=0*/) {
			if(detanotacreditosoli.getId()!=null) {
				sDescripcion=detanotacreditosoli.getId().toString();
			}//detanotacreditosolidetanotacreditosoli.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetaNotaCreditoSoliDescripcionDetallado(DetaNotaCreditoSoli detanotacreditosoli) {
		String sDescripcion="";
			
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.ID+"=";
		sDescripcion+=detanotacreditosoli.getId().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detanotacreditosoli.getVersionRow().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detanotacreditosoli.getid_empresa().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detanotacreditosoli.getid_sucursal().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detanotacreditosoli.getid_ejercicio().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detanotacreditosoli.getid_periodo().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDANIO+"=";
		sDescripcion+=detanotacreditosoli.getid_anio().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDMES+"=";
		sDescripcion+=detanotacreditosoli.getid_mes().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI+"=";
		sDescripcion+=detanotacreditosoli.getid_nota_credito_soli().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detanotacreditosoli.getid_bodega().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detanotacreditosoli.getid_producto().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detanotacreditosoli.getid_unidad().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE+"=";
		sDescripcion+=detanotacreditosoli.getid_empaque().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA+"=";
		sDescripcion+=detanotacreditosoli.getid_tipo_devolucion_empresa().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detanotacreditosoli.getid_centro_costo().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detanotacreditosoli.getcantidad().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.PRECIO+"=";
		sDescripcion+=detanotacreditosoli.getprecio().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN+"=";
		sDescripcion+=detanotacreditosoli.getporcen_descuen().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detanotacreditosoli.getdescuento().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=detanotacreditosoli.getimpuesto().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.PORCENIVA+"=";
		sDescripcion+=detanotacreditosoli.getporcen_iva().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.TOTAL+"=";
		sDescripcion+=detanotacreditosoli.gettotal().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detanotacreditosoli.getdescripcion()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE+"=";
		sDescripcion+=detanotacreditosoli.getcodigo_lote()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA+"=";
		sDescripcion+=detanotacreditosoli.getnumero_caja()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detanotacreditosoli.getdescuento2().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.COSTO+"=";
		sDescripcion+=detanotacreditosoli.getcosto().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO+"=";
		sDescripcion+=detanotacreditosoli.getincluye_impuesto().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.PORCENICE+"=";
		sDescripcion+=detanotacreditosoli.getporcen_ice().toString()+",";
		sDescripcion+=DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detanotacreditosoli.getfecha_emision().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetaNotaCreditoSoliDescripcion(DetaNotaCreditoSoli detanotacreditosoli,String sValor) throws Exception {			
		if(detanotacreditosoli !=null) {
			//detanotacreditosolidetanotacreditosoli.getId().toString();
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

	public static String getNotaCreditoSoliDescripcion(NotaCreditoSoli notacreditosoli) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(notacreditosoli!=null/*&&notacreditosoli.getId()>0*/) {
			sDescripcion=NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliDescripcion(notacreditosoli);
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

	public static String getTipoDevolucionEmpresaDescripcion(TipoDevolucionEmpresa tipodevolucionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodevolucionempresa!=null/*&&tipodevolucionempresa.getId()>0*/) {
			sDescripcion=TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(tipodevolucionempresa);
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
		} else if(sNombreIndice.equals("FK_IdEmpaque")) {
			sNombreIndice="Tipo=  Por Empaque";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdNotaCreditoSoli")) {
			sNombreIndice="Tipo=  Por Solicitud Nota Credito";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDevolucionEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Devolucion";
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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNotaCreditoSoli(Long id_nota_credito_soli) {
		String sDetalleIndice=" Parametros->";
		if(id_nota_credito_soli!=null) {sDetalleIndice+=" Codigo Unico De Solicitud Nota Credito="+id_nota_credito_soli.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoDevolucionEmpresa(Long id_tipo_devolucion_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_devolucion_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Devolucion="+id_tipo_devolucion_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detanotacreditosoli.setdescripcion(detanotacreditosoli.getdescripcion().trim());
		detanotacreditosoli.setcodigo_lote(detanotacreditosoli.getcodigo_lote().trim());
		detanotacreditosoli.setnumero_caja(detanotacreditosoli.getnumero_caja().trim());
	}
	
	public static void quitarEspaciosDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetaNotaCreditoSoli detanotacreditosoli: detanotacreditosolis) {
			detanotacreditosoli.setdescripcion(detanotacreditosoli.getdescripcion().trim());
			detanotacreditosoli.setcodigo_lote(detanotacreditosoli.getcodigo_lote().trim());
			detanotacreditosoli.setnumero_caja(detanotacreditosoli.getnumero_caja().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detanotacreditosoli.getConCambioAuxiliar()) {
			detanotacreditosoli.setIsDeleted(detanotacreditosoli.getIsDeletedAuxiliar());	
			detanotacreditosoli.setIsNew(detanotacreditosoli.getIsNewAuxiliar());	
			detanotacreditosoli.setIsChanged(detanotacreditosoli.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detanotacreditosoli.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detanotacreditosoli.setIsDeletedAuxiliar(false);	
			detanotacreditosoli.setIsNewAuxiliar(false);	
			detanotacreditosoli.setIsChangedAuxiliar(false);
			
			detanotacreditosoli.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetaNotaCreditoSoli detanotacreditosoli : detanotacreditosolis) {
			if(conAsignarBase && detanotacreditosoli.getConCambioAuxiliar()) {
				detanotacreditosoli.setIsDeleted(detanotacreditosoli.getIsDeletedAuxiliar());	
				detanotacreditosoli.setIsNew(detanotacreditosoli.getIsNewAuxiliar());	
				detanotacreditosoli.setIsChanged(detanotacreditosoli.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detanotacreditosoli.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detanotacreditosoli.setIsDeletedAuxiliar(false);	
				detanotacreditosoli.setIsNewAuxiliar(false);	
				detanotacreditosoli.setIsChangedAuxiliar(false);
				
				detanotacreditosoli.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli,Boolean conEnteros) throws Exception  {
		detanotacreditosoli.setprecio(0.0);
		detanotacreditosoli.setporcen_descuen(0.0);
		detanotacreditosoli.setdescuento(0.0);
		detanotacreditosoli.setimpuesto(0.0);
		detanotacreditosoli.setporcen_iva(0.0);
		detanotacreditosoli.settotal(0.0);
		detanotacreditosoli.setdescuento2(0.0);
		detanotacreditosoli.setcosto(0.0);
		detanotacreditosoli.setporcen_ice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detanotacreditosoli.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis,Boolean conEnteros) throws Exception  {
		
		for(DetaNotaCreditoSoli detanotacreditosoli: detanotacreditosolis) {
			detanotacreditosoli.setprecio(0.0);
			detanotacreditosoli.setporcen_descuen(0.0);
			detanotacreditosoli.setdescuento(0.0);
			detanotacreditosoli.setimpuesto(0.0);
			detanotacreditosoli.setporcen_iva(0.0);
			detanotacreditosoli.settotal(0.0);
			detanotacreditosoli.setdescuento2(0.0);
			detanotacreditosoli.setcosto(0.0);
			detanotacreditosoli.setporcen_ice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detanotacreditosoli.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoli detanotacreditosoliAux) throws Exception  {
		DetaNotaCreditoSoliConstantesFunciones.InicializarValoresDetaNotaCreditoSoli(detanotacreditosoliAux,true);
		
		for(DetaNotaCreditoSoli detanotacreditosoli: detanotacreditosolis) {
			if(detanotacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detanotacreditosoliAux.setcantidad(detanotacreditosoliAux.getcantidad()+detanotacreditosoli.getcantidad());			
			detanotacreditosoliAux.setprecio(detanotacreditosoliAux.getprecio()+detanotacreditosoli.getprecio());			
			detanotacreditosoliAux.setporcen_descuen(detanotacreditosoliAux.getporcen_descuen()+detanotacreditosoli.getporcen_descuen());			
			detanotacreditosoliAux.setdescuento(detanotacreditosoliAux.getdescuento()+detanotacreditosoli.getdescuento());			
			detanotacreditosoliAux.setimpuesto(detanotacreditosoliAux.getimpuesto()+detanotacreditosoli.getimpuesto());			
			detanotacreditosoliAux.setporcen_iva(detanotacreditosoliAux.getporcen_iva()+detanotacreditosoli.getporcen_iva());			
			detanotacreditosoliAux.settotal(detanotacreditosoliAux.gettotal()+detanotacreditosoli.gettotal());			
			detanotacreditosoliAux.setdescuento2(detanotacreditosoliAux.getdescuento2()+detanotacreditosoli.getdescuento2());			
			detanotacreditosoliAux.setcosto(detanotacreditosoliAux.getcosto()+detanotacreditosoli.getcosto());			
			detanotacreditosoliAux.setporcen_ice(detanotacreditosoliAux.getporcen_ice()+detanotacreditosoli.getporcen_ice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetaNotaCreditoSoliConstantesFunciones.getArrayColumnasGlobalesDetaNotaCreditoSoli(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetaNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoli detanotacreditosoli,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetaNotaCreditoSoli detanotacreditosoliAux: detanotacreditosolis) {
			if(detanotacreditosoliAux!=null && detanotacreditosoli!=null) {
				if((detanotacreditosoliAux.getId()==null && detanotacreditosoli.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detanotacreditosoliAux.getId()!=null && detanotacreditosoli.getId()!=null){
					if(detanotacreditosoliAux.getId().equals(detanotacreditosoli.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> detanotacreditosolis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double porcen_descuenTotal=0.0;
		Double descuentoTotal=0.0;
		Double impuestoTotal=0.0;
		Double porcen_ivaTotal=0.0;
		Double totalTotal=0.0;
		Double descuento2Total=0.0;
		Double costoTotal=0.0;
		Double porcen_iceTotal=0.0;
	
		for(DetaNotaCreditoSoli detanotacreditosoli: detanotacreditosolis) {			
			if(detanotacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detanotacreditosoli.getprecio();
			porcen_descuenTotal+=detanotacreditosoli.getporcen_descuen();
			descuentoTotal+=detanotacreditosoli.getdescuento();
			impuestoTotal+=detanotacreditosoli.getimpuesto();
			porcen_ivaTotal+=detanotacreditosoli.getporcen_iva();
			totalTotal+=detanotacreditosoli.gettotal();
			descuento2Total+=detanotacreditosoli.getdescuento2();
			costoTotal+=detanotacreditosoli.getcosto();
			porcen_iceTotal+=detanotacreditosoli.getporcen_ice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN);
		datoGeneral.setdValorDouble(porcen_descuenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.PORCENIVA);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA);
		datoGeneral.setdValorDouble(porcen_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.PORCENICE);
		datoGeneral.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE);
		datoGeneral.setdValorDouble(porcen_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetaNotaCreditoSoli() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_ID, DetaNotaCreditoSoliConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_VERSIONROW, DetaNotaCreditoSoliConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA, DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL, DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO, DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO, DetaNotaCreditoSoliConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDANIO, DetaNotaCreditoSoliConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDMES, DetaNotaCreditoSoliConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDNOTACREDITOSOLI, DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDBODEGA, DetaNotaCreditoSoliConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPRODUCTO, DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDUNIDAD, DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPAQUE, DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA, DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO, DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_CANTIDAD, DetaNotaCreditoSoliConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO, DetaNotaCreditoSoliConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN, DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO, DetaNotaCreditoSoliConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO, DetaNotaCreditoSoliConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA, DetaNotaCreditoSoliConstantesFunciones.PORCENIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL, DetaNotaCreditoSoliConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION, DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_CODIGOLOTE, DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_NUMEROCAJA, DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2, DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO, DetaNotaCreditoSoliConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_INCLUYEIMPUESTO, DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE, DetaNotaCreditoSoliConstantesFunciones.PORCENICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION, DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetaNotaCreditoSoli() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.PORCENIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.PORCENICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCreditoSoli() throws Exception  {
		return DetaNotaCreditoSoliConstantesFunciones.getTiposSeleccionarDetaNotaCreditoSoli(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCreditoSoli(Boolean conFk) throws Exception  {
		return DetaNotaCreditoSoliConstantesFunciones.getTiposSeleccionarDetaNotaCreditoSoli(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCreditoSoli(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDNOTACREDITOSOLI);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDNOTACREDITOSOLI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPAQUE);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPAQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_CODIGOLOTE);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_CODIGOLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_NUMEROCAJA);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_NUMEROCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_INCLUYEIMPUESTO);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_INCLUYEIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetaNotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetaNotaCreditoSoli(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoliAux) throws Exception {
		
			detanotacreditosoliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detanotacreditosoliAux.getEmpresa()));
			detanotacreditosoliAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detanotacreditosoliAux.getSucursal()));
			detanotacreditosoliAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detanotacreditosoliAux.getEjercicio()));
			detanotacreditosoliAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detanotacreditosoliAux.getPeriodo()));
			detanotacreditosoliAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detanotacreditosoliAux.getAnio()));
			detanotacreditosoliAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detanotacreditosoliAux.getMes()));
			detanotacreditosoliAux.setnotacreditosoli_descripcion(NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliDescripcion(detanotacreditosoliAux.getNotaCreditoSoli()));
			detanotacreditosoliAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detanotacreditosoliAux.getBodega()));
			detanotacreditosoliAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detanotacreditosoliAux.getProducto()));
			detanotacreditosoliAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detanotacreditosoliAux.getUnidad()));
			detanotacreditosoliAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detanotacreditosoliAux.getEmpaque()));
			detanotacreditosoliAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(detanotacreditosoliAux.getTipoDevolucionEmpresa()));
			detanotacreditosoliAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detanotacreditosoliAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> detanotacreditosolisTemp) throws Exception {
		for(DetaNotaCreditoSoli detanotacreditosoliAux:detanotacreditosolisTemp) {
			
			detanotacreditosoliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detanotacreditosoliAux.getEmpresa()));
			detanotacreditosoliAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detanotacreditosoliAux.getSucursal()));
			detanotacreditosoliAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detanotacreditosoliAux.getEjercicio()));
			detanotacreditosoliAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detanotacreditosoliAux.getPeriodo()));
			detanotacreditosoliAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detanotacreditosoliAux.getAnio()));
			detanotacreditosoliAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detanotacreditosoliAux.getMes()));
			detanotacreditosoliAux.setnotacreditosoli_descripcion(NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliDescripcion(detanotacreditosoliAux.getNotaCreditoSoli()));
			detanotacreditosoliAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detanotacreditosoliAux.getBodega()));
			detanotacreditosoliAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detanotacreditosoliAux.getProducto()));
			detanotacreditosoliAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detanotacreditosoliAux.getUnidad()));
			detanotacreditosoliAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detanotacreditosoliAux.getEmpaque()));
			detanotacreditosoliAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(detanotacreditosoliAux.getTipoDevolucionEmpresa()));
			detanotacreditosoliAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detanotacreditosoliAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetaNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(NotaCreditoSoli.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Empaque.class));
				classes.add(new Classe(TipoDevolucionEmpresa.class));
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
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class));
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
					if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetaNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
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

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
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

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
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

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaNotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfDetaNotaCreditoSoli(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaNotaCreditoSoliConstantesFunciones.getClassesRelationshipsFromStringsOfDetaNotaCreditoSoli(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetaNotaCreditoSoli detanotacreditosoli,List<DetaNotaCreditoSoli> detanotacreditosolis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetaNotaCreditoSoli detanotacreditosoliEncontrado=null;
			
			for(DetaNotaCreditoSoli detanotacreditosoliLocal:detanotacreditosolis) {
				if(detanotacreditosoliLocal.getId().equals(detanotacreditosoli.getId())) {
					detanotacreditosoliEncontrado=detanotacreditosoliLocal;
					
					detanotacreditosoliLocal.setIsChanged(detanotacreditosoli.getIsChanged());
					detanotacreditosoliLocal.setIsNew(detanotacreditosoli.getIsNew());
					detanotacreditosoliLocal.setIsDeleted(detanotacreditosoli.getIsDeleted());
					
					detanotacreditosoliLocal.setGeneralEntityOriginal(detanotacreditosoli.getGeneralEntityOriginal());
					
					detanotacreditosoliLocal.setId(detanotacreditosoli.getId());	
					detanotacreditosoliLocal.setVersionRow(detanotacreditosoli.getVersionRow());	
					detanotacreditosoliLocal.setid_empresa(detanotacreditosoli.getid_empresa());	
					detanotacreditosoliLocal.setid_sucursal(detanotacreditosoli.getid_sucursal());	
					detanotacreditosoliLocal.setid_ejercicio(detanotacreditosoli.getid_ejercicio());	
					detanotacreditosoliLocal.setid_periodo(detanotacreditosoli.getid_periodo());	
					detanotacreditosoliLocal.setid_anio(detanotacreditosoli.getid_anio());	
					detanotacreditosoliLocal.setid_mes(detanotacreditosoli.getid_mes());	
					detanotacreditosoliLocal.setid_nota_credito_soli(detanotacreditosoli.getid_nota_credito_soli());	
					detanotacreditosoliLocal.setid_bodega(detanotacreditosoli.getid_bodega());	
					detanotacreditosoliLocal.setid_producto(detanotacreditosoli.getid_producto());	
					detanotacreditosoliLocal.setid_unidad(detanotacreditosoli.getid_unidad());	
					detanotacreditosoliLocal.setid_empaque(detanotacreditosoli.getid_empaque());	
					detanotacreditosoliLocal.setid_tipo_devolucion_empresa(detanotacreditosoli.getid_tipo_devolucion_empresa());	
					detanotacreditosoliLocal.setid_centro_costo(detanotacreditosoli.getid_centro_costo());	
					detanotacreditosoliLocal.setcantidad(detanotacreditosoli.getcantidad());	
					detanotacreditosoliLocal.setprecio(detanotacreditosoli.getprecio());	
					detanotacreditosoliLocal.setporcen_descuen(detanotacreditosoli.getporcen_descuen());	
					detanotacreditosoliLocal.setdescuento(detanotacreditosoli.getdescuento());	
					detanotacreditosoliLocal.setimpuesto(detanotacreditosoli.getimpuesto());	
					detanotacreditosoliLocal.setporcen_iva(detanotacreditosoli.getporcen_iva());	
					detanotacreditosoliLocal.settotal(detanotacreditosoli.gettotal());	
					detanotacreditosoliLocal.setdescripcion(detanotacreditosoli.getdescripcion());	
					detanotacreditosoliLocal.setcodigo_lote(detanotacreditosoli.getcodigo_lote());	
					detanotacreditosoliLocal.setnumero_caja(detanotacreditosoli.getnumero_caja());	
					detanotacreditosoliLocal.setdescuento2(detanotacreditosoli.getdescuento2());	
					detanotacreditosoliLocal.setcosto(detanotacreditosoli.getcosto());	
					detanotacreditosoliLocal.setincluye_impuesto(detanotacreditosoli.getincluye_impuesto());	
					detanotacreditosoliLocal.setporcen_ice(detanotacreditosoli.getporcen_ice());	
					detanotacreditosoliLocal.setfecha_emision(detanotacreditosoli.getfecha_emision());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detanotacreditosoli.getIsDeleted()) {
				if(!existe) {
					detanotacreditosolis.add(detanotacreditosoli);
				}
			} else {
				if(detanotacreditosoliEncontrado!=null && permiteQuitar)  {
					detanotacreditosolis.remove(detanotacreditosoliEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetaNotaCreditoSoli detanotacreditosoli,List<DetaNotaCreditoSoli> detanotacreditosolis) throws Exception {
		try	{			
			for(DetaNotaCreditoSoli detanotacreditosoliLocal:detanotacreditosolis) {
				if(detanotacreditosoliLocal.getId().equals(detanotacreditosoli.getId())) {
					detanotacreditosoliLocal.setIsSelected(detanotacreditosoli.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> detanotacreditosolisAux) throws Exception {
		//this.detanotacreditosolisAux=detanotacreditosolisAux;
		
		for(DetaNotaCreditoSoli detanotacreditosoliAux:detanotacreditosolisAux) {
			if(detanotacreditosoliAux.getIsChanged()) {
				detanotacreditosoliAux.setIsChanged(false);
			}		
			
			if(detanotacreditosoliAux.getIsNew()) {
				detanotacreditosoliAux.setIsNew(false);
			}	
			
			if(detanotacreditosoliAux.getIsDeleted()) {
				detanotacreditosoliAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoliAux) throws Exception {
		//this.detanotacreditosoliAux=detanotacreditosoliAux;
		
			if(detanotacreditosoliAux.getIsChanged()) {
				detanotacreditosoliAux.setIsChanged(false);
			}		
			
			if(detanotacreditosoliAux.getIsNew()) {
				detanotacreditosoliAux.setIsNew(false);
			}	
			
			if(detanotacreditosoliAux.getIsDeleted()) {
				detanotacreditosoliAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetaNotaCreditoSoli detanotacreditosoliAsignar,DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		detanotacreditosoliAsignar.setId(detanotacreditosoli.getId());	
		detanotacreditosoliAsignar.setVersionRow(detanotacreditosoli.getVersionRow());	
		detanotacreditosoliAsignar.setid_empresa(detanotacreditosoli.getid_empresa());
		detanotacreditosoliAsignar.setempresa_descripcion(detanotacreditosoli.getempresa_descripcion());	
		detanotacreditosoliAsignar.setid_sucursal(detanotacreditosoli.getid_sucursal());
		detanotacreditosoliAsignar.setsucursal_descripcion(detanotacreditosoli.getsucursal_descripcion());	
		detanotacreditosoliAsignar.setid_ejercicio(detanotacreditosoli.getid_ejercicio());
		detanotacreditosoliAsignar.setejercicio_descripcion(detanotacreditosoli.getejercicio_descripcion());	
		detanotacreditosoliAsignar.setid_periodo(detanotacreditosoli.getid_periodo());
		detanotacreditosoliAsignar.setperiodo_descripcion(detanotacreditosoli.getperiodo_descripcion());	
		detanotacreditosoliAsignar.setid_anio(detanotacreditosoli.getid_anio());
		detanotacreditosoliAsignar.setanio_descripcion(detanotacreditosoli.getanio_descripcion());	
		detanotacreditosoliAsignar.setid_mes(detanotacreditosoli.getid_mes());
		detanotacreditosoliAsignar.setmes_descripcion(detanotacreditosoli.getmes_descripcion());	
		detanotacreditosoliAsignar.setid_nota_credito_soli(detanotacreditosoli.getid_nota_credito_soli());
		detanotacreditosoliAsignar.setnotacreditosoli_descripcion(detanotacreditosoli.getnotacreditosoli_descripcion());	
		detanotacreditosoliAsignar.setid_bodega(detanotacreditosoli.getid_bodega());
		detanotacreditosoliAsignar.setbodega_descripcion(detanotacreditosoli.getbodega_descripcion());	
		detanotacreditosoliAsignar.setid_producto(detanotacreditosoli.getid_producto());
		detanotacreditosoliAsignar.setproducto_descripcion(detanotacreditosoli.getproducto_descripcion());	
		detanotacreditosoliAsignar.setid_unidad(detanotacreditosoli.getid_unidad());
		detanotacreditosoliAsignar.setunidad_descripcion(detanotacreditosoli.getunidad_descripcion());	
		detanotacreditosoliAsignar.setid_empaque(detanotacreditosoli.getid_empaque());
		detanotacreditosoliAsignar.setempaque_descripcion(detanotacreditosoli.getempaque_descripcion());	
		detanotacreditosoliAsignar.setid_tipo_devolucion_empresa(detanotacreditosoli.getid_tipo_devolucion_empresa());
		detanotacreditosoliAsignar.settipodevolucionempresa_descripcion(detanotacreditosoli.gettipodevolucionempresa_descripcion());	
		detanotacreditosoliAsignar.setid_centro_costo(detanotacreditosoli.getid_centro_costo());
		detanotacreditosoliAsignar.setcentrocosto_descripcion(detanotacreditosoli.getcentrocosto_descripcion());	
		detanotacreditosoliAsignar.setcantidad(detanotacreditosoli.getcantidad());	
		detanotacreditosoliAsignar.setprecio(detanotacreditosoli.getprecio());	
		detanotacreditosoliAsignar.setporcen_descuen(detanotacreditosoli.getporcen_descuen());	
		detanotacreditosoliAsignar.setdescuento(detanotacreditosoli.getdescuento());	
		detanotacreditosoliAsignar.setimpuesto(detanotacreditosoli.getimpuesto());	
		detanotacreditosoliAsignar.setporcen_iva(detanotacreditosoli.getporcen_iva());	
		detanotacreditosoliAsignar.settotal(detanotacreditosoli.gettotal());	
		detanotacreditosoliAsignar.setdescripcion(detanotacreditosoli.getdescripcion());	
		detanotacreditosoliAsignar.setcodigo_lote(detanotacreditosoli.getcodigo_lote());	
		detanotacreditosoliAsignar.setnumero_caja(detanotacreditosoli.getnumero_caja());	
		detanotacreditosoliAsignar.setdescuento2(detanotacreditosoli.getdescuento2());	
		detanotacreditosoliAsignar.setcosto(detanotacreditosoli.getcosto());	
		detanotacreditosoliAsignar.setincluye_impuesto(detanotacreditosoli.getincluye_impuesto());	
		detanotacreditosoliAsignar.setporcen_ice(detanotacreditosoli.getporcen_ice());	
		detanotacreditosoliAsignar.setfecha_emision(detanotacreditosoli.getfecha_emision());	
	}
	
	public static void inicializarDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		try {
				detanotacreditosoli.setId(0L);	
					
				detanotacreditosoli.setid_empresa(-1L);	
				detanotacreditosoli.setid_sucursal(-1L);	
				detanotacreditosoli.setid_ejercicio(-1L);	
				detanotacreditosoli.setid_periodo(-1L);	
				detanotacreditosoli.setid_anio(null);	
				detanotacreditosoli.setid_mes(null);	
				detanotacreditosoli.setid_nota_credito_soli(-1L);	
				detanotacreditosoli.setid_bodega(-1L);	
				detanotacreditosoli.setid_producto(-1L);	
				detanotacreditosoli.setid_unidad(-1L);	
				detanotacreditosoli.setid_empaque(null);	
				detanotacreditosoli.setid_tipo_devolucion_empresa(-1L);	
				detanotacreditosoli.setid_centro_costo(null);	
				detanotacreditosoli.setcantidad(0);	
				detanotacreditosoli.setprecio(0.0);	
				detanotacreditosoli.setporcen_descuen(0.0);	
				detanotacreditosoli.setdescuento(0.0);	
				detanotacreditosoli.setimpuesto(0.0);	
				detanotacreditosoli.setporcen_iva(0.0);	
				detanotacreditosoli.settotal(0.0);	
				detanotacreditosoli.setdescripcion("");	
				detanotacreditosoli.setcodigo_lote("");	
				detanotacreditosoli.setnumero_caja("");	
				detanotacreditosoli.setdescuento2(0.0);	
				detanotacreditosoli.setcosto(0.0);	
				detanotacreditosoli.setincluye_impuesto(false);	
				detanotacreditosoli.setporcen_ice(0.0);	
				detanotacreditosoli.setfecha_emision(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetaNotaCreditoSoli(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDNOTACREDITOSOLI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDEMPAQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENDESCUEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_CODIGOLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_NUMEROCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_INCLUYEIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_PORCENICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoSoliConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetaNotaCreditoSoli(String sTipo,Row row,Workbook workbook,DetaNotaCreditoSoli detanotacreditosoli,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getnotacreditosoli_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getempaque_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.gettipodevolucionempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getporcen_descuen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getporcen_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getcodigo_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getnumero_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detanotacreditosoli.getincluye_impuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getporcen_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacreditosoli.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetaNotaCreditoSoli=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetaNotaCreditoSoli() {
		return this.sFinalQueryDetaNotaCreditoSoli;
	}
	
	public void setsFinalQueryDetaNotaCreditoSoli(String sFinalQueryDetaNotaCreditoSoli) {
		this.sFinalQueryDetaNotaCreditoSoli= sFinalQueryDetaNotaCreditoSoli;
	}
	
	public Border resaltarSeleccionarDetaNotaCreditoSoli=null;
	
	public Border setResaltarSeleccionarDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetaNotaCreditoSoli= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetaNotaCreditoSoli() {
		return this.resaltarSeleccionarDetaNotaCreditoSoli;
	}
	
	public void setResaltarSeleccionarDetaNotaCreditoSoli(Border borderResaltarSeleccionarDetaNotaCreditoSoli) {
		this.resaltarSeleccionarDetaNotaCreditoSoli= borderResaltarSeleccionarDetaNotaCreditoSoli;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetaNotaCreditoSoli=null;
	public Boolean mostraridDetaNotaCreditoSoli=true;
	public Boolean activaridDetaNotaCreditoSoli=true;

	public Border resaltarid_empresaDetaNotaCreditoSoli=null;
	public Boolean mostrarid_empresaDetaNotaCreditoSoli=true;
	public Boolean activarid_empresaDetaNotaCreditoSoli=true;
	public Boolean cargarid_empresaDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetaNotaCreditoSoli=null;
	public Boolean mostrarid_sucursalDetaNotaCreditoSoli=true;
	public Boolean activarid_sucursalDetaNotaCreditoSoli=true;
	public Boolean cargarid_sucursalDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetaNotaCreditoSoli=null;
	public Boolean mostrarid_ejercicioDetaNotaCreditoSoli=true;
	public Boolean activarid_ejercicioDetaNotaCreditoSoli=true;
	public Boolean cargarid_ejercicioDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_periodoDetaNotaCreditoSoli=null;
	public Boolean mostrarid_periodoDetaNotaCreditoSoli=true;
	public Boolean activarid_periodoDetaNotaCreditoSoli=true;
	public Boolean cargarid_periodoDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_anioDetaNotaCreditoSoli=null;
	public Boolean mostrarid_anioDetaNotaCreditoSoli=true;
	public Boolean activarid_anioDetaNotaCreditoSoli=false;
	public Boolean cargarid_anioDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_mesDetaNotaCreditoSoli=null;
	public Boolean mostrarid_mesDetaNotaCreditoSoli=true;
	public Boolean activarid_mesDetaNotaCreditoSoli=false;
	public Boolean cargarid_mesDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_nota_credito_soliDetaNotaCreditoSoli=null;
	public Boolean mostrarid_nota_credito_soliDetaNotaCreditoSoli=true;
	public Boolean activarid_nota_credito_soliDetaNotaCreditoSoli=true;
	public Boolean cargarid_nota_credito_soliDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nota_credito_soliDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetaNotaCreditoSoli=null;
	public Boolean mostrarid_bodegaDetaNotaCreditoSoli=true;
	public Boolean activarid_bodegaDetaNotaCreditoSoli=true;
	public Boolean cargarid_bodegaDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_productoDetaNotaCreditoSoli=null;
	public Boolean mostrarid_productoDetaNotaCreditoSoli=true;
	public Boolean activarid_productoDetaNotaCreditoSoli=true;
	public Boolean cargarid_productoDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetaNotaCreditoSoli=true;//ConEventDepend=true

	public Border resaltarid_unidadDetaNotaCreditoSoli=null;
	public Boolean mostrarid_unidadDetaNotaCreditoSoli=true;
	public Boolean activarid_unidadDetaNotaCreditoSoli=true;
	public Boolean cargarid_unidadDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetaNotaCreditoSoli=true;//ConEventDepend=true

	public Border resaltarid_empaqueDetaNotaCreditoSoli=null;
	public Boolean mostrarid_empaqueDetaNotaCreditoSoli=true;
	public Boolean activarid_empaqueDetaNotaCreditoSoli=true;
	public Boolean cargarid_empaqueDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empaqueDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli=null;
	public Boolean mostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli=true;
	public Boolean activarid_tipo_devolucion_empresaDetaNotaCreditoSoli=true;
	public Boolean cargarid_tipo_devolucion_empresaDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_devolucion_empresaDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetaNotaCreditoSoli=null;
	public Boolean mostrarid_centro_costoDetaNotaCreditoSoli=true;
	public Boolean activarid_centro_costoDetaNotaCreditoSoli=true;
	public Boolean cargarid_centro_costoDetaNotaCreditoSoli=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetaNotaCreditoSoli=false;//ConEventDepend=true

	public Border resaltarcantidadDetaNotaCreditoSoli=null;
	public Boolean mostrarcantidadDetaNotaCreditoSoli=true;
	public Boolean activarcantidadDetaNotaCreditoSoli=true;

	public Border resaltarprecioDetaNotaCreditoSoli=null;
	public Boolean mostrarprecioDetaNotaCreditoSoli=true;
	public Boolean activarprecioDetaNotaCreditoSoli=true;

	public Border resaltarporcen_descuenDetaNotaCreditoSoli=null;
	public Boolean mostrarporcen_descuenDetaNotaCreditoSoli=true;
	public Boolean activarporcen_descuenDetaNotaCreditoSoli=true;

	public Border resaltardescuentoDetaNotaCreditoSoli=null;
	public Boolean mostrardescuentoDetaNotaCreditoSoli=true;
	public Boolean activardescuentoDetaNotaCreditoSoli=true;

	public Border resaltarimpuestoDetaNotaCreditoSoli=null;
	public Boolean mostrarimpuestoDetaNotaCreditoSoli=true;
	public Boolean activarimpuestoDetaNotaCreditoSoli=true;

	public Border resaltarporcen_ivaDetaNotaCreditoSoli=null;
	public Boolean mostrarporcen_ivaDetaNotaCreditoSoli=true;
	public Boolean activarporcen_ivaDetaNotaCreditoSoli=true;

	public Border resaltartotalDetaNotaCreditoSoli=null;
	public Boolean mostrartotalDetaNotaCreditoSoli=true;
	public Boolean activartotalDetaNotaCreditoSoli=true;

	public Border resaltardescripcionDetaNotaCreditoSoli=null;
	public Boolean mostrardescripcionDetaNotaCreditoSoli=true;
	public Boolean activardescripcionDetaNotaCreditoSoli=true;

	public Border resaltarcodigo_loteDetaNotaCreditoSoli=null;
	public Boolean mostrarcodigo_loteDetaNotaCreditoSoli=true;
	public Boolean activarcodigo_loteDetaNotaCreditoSoli=false;

	public Border resaltarnumero_cajaDetaNotaCreditoSoli=null;
	public Boolean mostrarnumero_cajaDetaNotaCreditoSoli=true;
	public Boolean activarnumero_cajaDetaNotaCreditoSoli=false;

	public Border resaltardescuento2DetaNotaCreditoSoli=null;
	public Boolean mostrardescuento2DetaNotaCreditoSoli=true;
	public Boolean activardescuento2DetaNotaCreditoSoli=false;

	public Border resaltarcostoDetaNotaCreditoSoli=null;
	public Boolean mostrarcostoDetaNotaCreditoSoli=true;
	public Boolean activarcostoDetaNotaCreditoSoli=false;

	public Border resaltarincluye_impuestoDetaNotaCreditoSoli=null;
	public Boolean mostrarincluye_impuestoDetaNotaCreditoSoli=true;
	public Boolean activarincluye_impuestoDetaNotaCreditoSoli=false;

	public Border resaltarporcen_iceDetaNotaCreditoSoli=null;
	public Boolean mostrarporcen_iceDetaNotaCreditoSoli=true;
	public Boolean activarporcen_iceDetaNotaCreditoSoli=false;

	public Border resaltarfecha_emisionDetaNotaCreditoSoli=null;
	public Boolean mostrarfecha_emisionDetaNotaCreditoSoli=true;
	public Boolean activarfecha_emisionDetaNotaCreditoSoli=false;

	
	

	public Border setResaltaridDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltaridDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetaNotaCreditoSoli() {
		return this.resaltaridDetaNotaCreditoSoli;
	}

	public void setResaltaridDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltaridDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostraridDetaNotaCreditoSoli() {
		return this.mostraridDetaNotaCreditoSoli;
	}

	public void setMostraridDetaNotaCreditoSoli(Boolean mostraridDetaNotaCreditoSoli) {
		this.mostraridDetaNotaCreditoSoli= mostraridDetaNotaCreditoSoli;
	}

	public Boolean getActivaridDetaNotaCreditoSoli() {
		return this.activaridDetaNotaCreditoSoli;
	}

	public void setActivaridDetaNotaCreditoSoli(Boolean activaridDetaNotaCreditoSoli) {
		this.activaridDetaNotaCreditoSoli= activaridDetaNotaCreditoSoli;
	}

	public Border setResaltarid_empresaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetaNotaCreditoSoli() {
		return this.resaltarid_empresaDetaNotaCreditoSoli;
	}

	public void setResaltarid_empresaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_empresaDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetaNotaCreditoSoli() {
		return this.mostrarid_empresaDetaNotaCreditoSoli;
	}

	public void setMostrarid_empresaDetaNotaCreditoSoli(Boolean mostrarid_empresaDetaNotaCreditoSoli) {
		this.mostrarid_empresaDetaNotaCreditoSoli= mostrarid_empresaDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_empresaDetaNotaCreditoSoli() {
		return this.activarid_empresaDetaNotaCreditoSoli;
	}

	public void setActivarid_empresaDetaNotaCreditoSoli(Boolean activarid_empresaDetaNotaCreditoSoli) {
		this.activarid_empresaDetaNotaCreditoSoli= activarid_empresaDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_empresaDetaNotaCreditoSoli() {
		return this.cargarid_empresaDetaNotaCreditoSoli;
	}

	public void setCargarid_empresaDetaNotaCreditoSoli(Boolean cargarid_empresaDetaNotaCreditoSoli) {
		this.cargarid_empresaDetaNotaCreditoSoli= cargarid_empresaDetaNotaCreditoSoli;
	}

	public Border setResaltarid_sucursalDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetaNotaCreditoSoli() {
		return this.resaltarid_sucursalDetaNotaCreditoSoli;
	}

	public void setResaltarid_sucursalDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_sucursalDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetaNotaCreditoSoli() {
		return this.mostrarid_sucursalDetaNotaCreditoSoli;
	}

	public void setMostrarid_sucursalDetaNotaCreditoSoli(Boolean mostrarid_sucursalDetaNotaCreditoSoli) {
		this.mostrarid_sucursalDetaNotaCreditoSoli= mostrarid_sucursalDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_sucursalDetaNotaCreditoSoli() {
		return this.activarid_sucursalDetaNotaCreditoSoli;
	}

	public void setActivarid_sucursalDetaNotaCreditoSoli(Boolean activarid_sucursalDetaNotaCreditoSoli) {
		this.activarid_sucursalDetaNotaCreditoSoli= activarid_sucursalDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_sucursalDetaNotaCreditoSoli() {
		return this.cargarid_sucursalDetaNotaCreditoSoli;
	}

	public void setCargarid_sucursalDetaNotaCreditoSoli(Boolean cargarid_sucursalDetaNotaCreditoSoli) {
		this.cargarid_sucursalDetaNotaCreditoSoli= cargarid_sucursalDetaNotaCreditoSoli;
	}

	public Border setResaltarid_ejercicioDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetaNotaCreditoSoli() {
		return this.resaltarid_ejercicioDetaNotaCreditoSoli;
	}

	public void setResaltarid_ejercicioDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_ejercicioDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetaNotaCreditoSoli() {
		return this.mostrarid_ejercicioDetaNotaCreditoSoli;
	}

	public void setMostrarid_ejercicioDetaNotaCreditoSoli(Boolean mostrarid_ejercicioDetaNotaCreditoSoli) {
		this.mostrarid_ejercicioDetaNotaCreditoSoli= mostrarid_ejercicioDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_ejercicioDetaNotaCreditoSoli() {
		return this.activarid_ejercicioDetaNotaCreditoSoli;
	}

	public void setActivarid_ejercicioDetaNotaCreditoSoli(Boolean activarid_ejercicioDetaNotaCreditoSoli) {
		this.activarid_ejercicioDetaNotaCreditoSoli= activarid_ejercicioDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_ejercicioDetaNotaCreditoSoli() {
		return this.cargarid_ejercicioDetaNotaCreditoSoli;
	}

	public void setCargarid_ejercicioDetaNotaCreditoSoli(Boolean cargarid_ejercicioDetaNotaCreditoSoli) {
		this.cargarid_ejercicioDetaNotaCreditoSoli= cargarid_ejercicioDetaNotaCreditoSoli;
	}

	public Border setResaltarid_periodoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetaNotaCreditoSoli() {
		return this.resaltarid_periodoDetaNotaCreditoSoli;
	}

	public void setResaltarid_periodoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_periodoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetaNotaCreditoSoli() {
		return this.mostrarid_periodoDetaNotaCreditoSoli;
	}

	public void setMostrarid_periodoDetaNotaCreditoSoli(Boolean mostrarid_periodoDetaNotaCreditoSoli) {
		this.mostrarid_periodoDetaNotaCreditoSoli= mostrarid_periodoDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_periodoDetaNotaCreditoSoli() {
		return this.activarid_periodoDetaNotaCreditoSoli;
	}

	public void setActivarid_periodoDetaNotaCreditoSoli(Boolean activarid_periodoDetaNotaCreditoSoli) {
		this.activarid_periodoDetaNotaCreditoSoli= activarid_periodoDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_periodoDetaNotaCreditoSoli() {
		return this.cargarid_periodoDetaNotaCreditoSoli;
	}

	public void setCargarid_periodoDetaNotaCreditoSoli(Boolean cargarid_periodoDetaNotaCreditoSoli) {
		this.cargarid_periodoDetaNotaCreditoSoli= cargarid_periodoDetaNotaCreditoSoli;
	}

	public Border setResaltarid_anioDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_anioDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetaNotaCreditoSoli() {
		return this.resaltarid_anioDetaNotaCreditoSoli;
	}

	public void setResaltarid_anioDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_anioDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_anioDetaNotaCreditoSoli() {
		return this.mostrarid_anioDetaNotaCreditoSoli;
	}

	public void setMostrarid_anioDetaNotaCreditoSoli(Boolean mostrarid_anioDetaNotaCreditoSoli) {
		this.mostrarid_anioDetaNotaCreditoSoli= mostrarid_anioDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_anioDetaNotaCreditoSoli() {
		return this.activarid_anioDetaNotaCreditoSoli;
	}

	public void setActivarid_anioDetaNotaCreditoSoli(Boolean activarid_anioDetaNotaCreditoSoli) {
		this.activarid_anioDetaNotaCreditoSoli= activarid_anioDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_anioDetaNotaCreditoSoli() {
		return this.cargarid_anioDetaNotaCreditoSoli;
	}

	public void setCargarid_anioDetaNotaCreditoSoli(Boolean cargarid_anioDetaNotaCreditoSoli) {
		this.cargarid_anioDetaNotaCreditoSoli= cargarid_anioDetaNotaCreditoSoli;
	}

	public Border setResaltarid_mesDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_mesDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetaNotaCreditoSoli() {
		return this.resaltarid_mesDetaNotaCreditoSoli;
	}

	public void setResaltarid_mesDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_mesDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_mesDetaNotaCreditoSoli() {
		return this.mostrarid_mesDetaNotaCreditoSoli;
	}

	public void setMostrarid_mesDetaNotaCreditoSoli(Boolean mostrarid_mesDetaNotaCreditoSoli) {
		this.mostrarid_mesDetaNotaCreditoSoli= mostrarid_mesDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_mesDetaNotaCreditoSoli() {
		return this.activarid_mesDetaNotaCreditoSoli;
	}

	public void setActivarid_mesDetaNotaCreditoSoli(Boolean activarid_mesDetaNotaCreditoSoli) {
		this.activarid_mesDetaNotaCreditoSoli= activarid_mesDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_mesDetaNotaCreditoSoli() {
		return this.cargarid_mesDetaNotaCreditoSoli;
	}

	public void setCargarid_mesDetaNotaCreditoSoli(Boolean cargarid_mesDetaNotaCreditoSoli) {
		this.cargarid_mesDetaNotaCreditoSoli= cargarid_mesDetaNotaCreditoSoli;
	}

	public Border setResaltarid_nota_credito_soliDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_nota_credito_soliDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nota_credito_soliDetaNotaCreditoSoli() {
		return this.resaltarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public void setResaltarid_nota_credito_soliDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_nota_credito_soliDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_nota_credito_soliDetaNotaCreditoSoli() {
		return this.mostrarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public void setMostrarid_nota_credito_soliDetaNotaCreditoSoli(Boolean mostrarid_nota_credito_soliDetaNotaCreditoSoli) {
		this.mostrarid_nota_credito_soliDetaNotaCreditoSoli= mostrarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_nota_credito_soliDetaNotaCreditoSoli() {
		return this.activarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public void setActivarid_nota_credito_soliDetaNotaCreditoSoli(Boolean activarid_nota_credito_soliDetaNotaCreditoSoli) {
		this.activarid_nota_credito_soliDetaNotaCreditoSoli= activarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_nota_credito_soliDetaNotaCreditoSoli() {
		return this.cargarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public void setCargarid_nota_credito_soliDetaNotaCreditoSoli(Boolean cargarid_nota_credito_soliDetaNotaCreditoSoli) {
		this.cargarid_nota_credito_soliDetaNotaCreditoSoli= cargarid_nota_credito_soliDetaNotaCreditoSoli;
	}

	public Border setResaltarid_bodegaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetaNotaCreditoSoli() {
		return this.resaltarid_bodegaDetaNotaCreditoSoli;
	}

	public void setResaltarid_bodegaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_bodegaDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetaNotaCreditoSoli() {
		return this.mostrarid_bodegaDetaNotaCreditoSoli;
	}

	public void setMostrarid_bodegaDetaNotaCreditoSoli(Boolean mostrarid_bodegaDetaNotaCreditoSoli) {
		this.mostrarid_bodegaDetaNotaCreditoSoli= mostrarid_bodegaDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_bodegaDetaNotaCreditoSoli() {
		return this.activarid_bodegaDetaNotaCreditoSoli;
	}

	public void setActivarid_bodegaDetaNotaCreditoSoli(Boolean activarid_bodegaDetaNotaCreditoSoli) {
		this.activarid_bodegaDetaNotaCreditoSoli= activarid_bodegaDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_bodegaDetaNotaCreditoSoli() {
		return this.cargarid_bodegaDetaNotaCreditoSoli;
	}

	public void setCargarid_bodegaDetaNotaCreditoSoli(Boolean cargarid_bodegaDetaNotaCreditoSoli) {
		this.cargarid_bodegaDetaNotaCreditoSoli= cargarid_bodegaDetaNotaCreditoSoli;
	}

	public Border setResaltarid_productoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_productoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetaNotaCreditoSoli() {
		return this.resaltarid_productoDetaNotaCreditoSoli;
	}

	public void setResaltarid_productoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_productoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_productoDetaNotaCreditoSoli() {
		return this.mostrarid_productoDetaNotaCreditoSoli;
	}

	public void setMostrarid_productoDetaNotaCreditoSoli(Boolean mostrarid_productoDetaNotaCreditoSoli) {
		this.mostrarid_productoDetaNotaCreditoSoli= mostrarid_productoDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_productoDetaNotaCreditoSoli() {
		return this.activarid_productoDetaNotaCreditoSoli;
	}

	public void setActivarid_productoDetaNotaCreditoSoli(Boolean activarid_productoDetaNotaCreditoSoli) {
		this.activarid_productoDetaNotaCreditoSoli= activarid_productoDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_productoDetaNotaCreditoSoli() {
		return this.cargarid_productoDetaNotaCreditoSoli;
	}

	public void setCargarid_productoDetaNotaCreditoSoli(Boolean cargarid_productoDetaNotaCreditoSoli) {
		this.cargarid_productoDetaNotaCreditoSoli= cargarid_productoDetaNotaCreditoSoli;
	}

	public Border setResaltarid_unidadDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetaNotaCreditoSoli() {
		return this.resaltarid_unidadDetaNotaCreditoSoli;
	}

	public void setResaltarid_unidadDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_unidadDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetaNotaCreditoSoli() {
		return this.mostrarid_unidadDetaNotaCreditoSoli;
	}

	public void setMostrarid_unidadDetaNotaCreditoSoli(Boolean mostrarid_unidadDetaNotaCreditoSoli) {
		this.mostrarid_unidadDetaNotaCreditoSoli= mostrarid_unidadDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_unidadDetaNotaCreditoSoli() {
		return this.activarid_unidadDetaNotaCreditoSoli;
	}

	public void setActivarid_unidadDetaNotaCreditoSoli(Boolean activarid_unidadDetaNotaCreditoSoli) {
		this.activarid_unidadDetaNotaCreditoSoli= activarid_unidadDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_unidadDetaNotaCreditoSoli() {
		return this.cargarid_unidadDetaNotaCreditoSoli;
	}

	public void setCargarid_unidadDetaNotaCreditoSoli(Boolean cargarid_unidadDetaNotaCreditoSoli) {
		this.cargarid_unidadDetaNotaCreditoSoli= cargarid_unidadDetaNotaCreditoSoli;
	}

	public Border setResaltarid_empaqueDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_empaqueDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empaqueDetaNotaCreditoSoli() {
		return this.resaltarid_empaqueDetaNotaCreditoSoli;
	}

	public void setResaltarid_empaqueDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_empaqueDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_empaqueDetaNotaCreditoSoli() {
		return this.mostrarid_empaqueDetaNotaCreditoSoli;
	}

	public void setMostrarid_empaqueDetaNotaCreditoSoli(Boolean mostrarid_empaqueDetaNotaCreditoSoli) {
		this.mostrarid_empaqueDetaNotaCreditoSoli= mostrarid_empaqueDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_empaqueDetaNotaCreditoSoli() {
		return this.activarid_empaqueDetaNotaCreditoSoli;
	}

	public void setActivarid_empaqueDetaNotaCreditoSoli(Boolean activarid_empaqueDetaNotaCreditoSoli) {
		this.activarid_empaqueDetaNotaCreditoSoli= activarid_empaqueDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_empaqueDetaNotaCreditoSoli() {
		return this.cargarid_empaqueDetaNotaCreditoSoli;
	}

	public void setCargarid_empaqueDetaNotaCreditoSoli(Boolean cargarid_empaqueDetaNotaCreditoSoli) {
		this.cargarid_empaqueDetaNotaCreditoSoli= cargarid_empaqueDetaNotaCreditoSoli;
	}

	public Border setResaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli() {
		return this.resaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public void setResaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli() {
		return this.mostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public void setMostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli(Boolean mostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli) {
		this.mostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli= mostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_tipo_devolucion_empresaDetaNotaCreditoSoli() {
		return this.activarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public void setActivarid_tipo_devolucion_empresaDetaNotaCreditoSoli(Boolean activarid_tipo_devolucion_empresaDetaNotaCreditoSoli) {
		this.activarid_tipo_devolucion_empresaDetaNotaCreditoSoli= activarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_tipo_devolucion_empresaDetaNotaCreditoSoli() {
		return this.cargarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public void setCargarid_tipo_devolucion_empresaDetaNotaCreditoSoli(Boolean cargarid_tipo_devolucion_empresaDetaNotaCreditoSoli) {
		this.cargarid_tipo_devolucion_empresaDetaNotaCreditoSoli= cargarid_tipo_devolucion_empresaDetaNotaCreditoSoli;
	}

	public Border setResaltarid_centro_costoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetaNotaCreditoSoli() {
		return this.resaltarid_centro_costoDetaNotaCreditoSoli;
	}

	public void setResaltarid_centro_costoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarid_centro_costoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetaNotaCreditoSoli() {
		return this.mostrarid_centro_costoDetaNotaCreditoSoli;
	}

	public void setMostrarid_centro_costoDetaNotaCreditoSoli(Boolean mostrarid_centro_costoDetaNotaCreditoSoli) {
		this.mostrarid_centro_costoDetaNotaCreditoSoli= mostrarid_centro_costoDetaNotaCreditoSoli;
	}

	public Boolean getActivarid_centro_costoDetaNotaCreditoSoli() {
		return this.activarid_centro_costoDetaNotaCreditoSoli;
	}

	public void setActivarid_centro_costoDetaNotaCreditoSoli(Boolean activarid_centro_costoDetaNotaCreditoSoli) {
		this.activarid_centro_costoDetaNotaCreditoSoli= activarid_centro_costoDetaNotaCreditoSoli;
	}

	public Boolean getCargarid_centro_costoDetaNotaCreditoSoli() {
		return this.cargarid_centro_costoDetaNotaCreditoSoli;
	}

	public void setCargarid_centro_costoDetaNotaCreditoSoli(Boolean cargarid_centro_costoDetaNotaCreditoSoli) {
		this.cargarid_centro_costoDetaNotaCreditoSoli= cargarid_centro_costoDetaNotaCreditoSoli;
	}

	public Border setResaltarcantidadDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcantidadDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetaNotaCreditoSoli() {
		return this.resaltarcantidadDetaNotaCreditoSoli;
	}

	public void setResaltarcantidadDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcantidadDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcantidadDetaNotaCreditoSoli() {
		return this.mostrarcantidadDetaNotaCreditoSoli;
	}

	public void setMostrarcantidadDetaNotaCreditoSoli(Boolean mostrarcantidadDetaNotaCreditoSoli) {
		this.mostrarcantidadDetaNotaCreditoSoli= mostrarcantidadDetaNotaCreditoSoli;
	}

	public Boolean getActivarcantidadDetaNotaCreditoSoli() {
		return this.activarcantidadDetaNotaCreditoSoli;
	}

	public void setActivarcantidadDetaNotaCreditoSoli(Boolean activarcantidadDetaNotaCreditoSoli) {
		this.activarcantidadDetaNotaCreditoSoli= activarcantidadDetaNotaCreditoSoli;
	}

	public Border setResaltarprecioDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarprecioDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetaNotaCreditoSoli() {
		return this.resaltarprecioDetaNotaCreditoSoli;
	}

	public void setResaltarprecioDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarprecioDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarprecioDetaNotaCreditoSoli() {
		return this.mostrarprecioDetaNotaCreditoSoli;
	}

	public void setMostrarprecioDetaNotaCreditoSoli(Boolean mostrarprecioDetaNotaCreditoSoli) {
		this.mostrarprecioDetaNotaCreditoSoli= mostrarprecioDetaNotaCreditoSoli;
	}

	public Boolean getActivarprecioDetaNotaCreditoSoli() {
		return this.activarprecioDetaNotaCreditoSoli;
	}

	public void setActivarprecioDetaNotaCreditoSoli(Boolean activarprecioDetaNotaCreditoSoli) {
		this.activarprecioDetaNotaCreditoSoli= activarprecioDetaNotaCreditoSoli;
	}

	public Border setResaltarporcen_descuenDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarporcen_descuenDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_descuenDetaNotaCreditoSoli() {
		return this.resaltarporcen_descuenDetaNotaCreditoSoli;
	}

	public void setResaltarporcen_descuenDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarporcen_descuenDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarporcen_descuenDetaNotaCreditoSoli() {
		return this.mostrarporcen_descuenDetaNotaCreditoSoli;
	}

	public void setMostrarporcen_descuenDetaNotaCreditoSoli(Boolean mostrarporcen_descuenDetaNotaCreditoSoli) {
		this.mostrarporcen_descuenDetaNotaCreditoSoli= mostrarporcen_descuenDetaNotaCreditoSoli;
	}

	public Boolean getActivarporcen_descuenDetaNotaCreditoSoli() {
		return this.activarporcen_descuenDetaNotaCreditoSoli;
	}

	public void setActivarporcen_descuenDetaNotaCreditoSoli(Boolean activarporcen_descuenDetaNotaCreditoSoli) {
		this.activarporcen_descuenDetaNotaCreditoSoli= activarporcen_descuenDetaNotaCreditoSoli;
	}

	public Border setResaltardescuentoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescuentoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetaNotaCreditoSoli() {
		return this.resaltardescuentoDetaNotaCreditoSoli;
	}

	public void setResaltardescuentoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescuentoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescuentoDetaNotaCreditoSoli() {
		return this.mostrardescuentoDetaNotaCreditoSoli;
	}

	public void setMostrardescuentoDetaNotaCreditoSoli(Boolean mostrardescuentoDetaNotaCreditoSoli) {
		this.mostrardescuentoDetaNotaCreditoSoli= mostrardescuentoDetaNotaCreditoSoli;
	}

	public Boolean getActivardescuentoDetaNotaCreditoSoli() {
		return this.activardescuentoDetaNotaCreditoSoli;
	}

	public void setActivardescuentoDetaNotaCreditoSoli(Boolean activardescuentoDetaNotaCreditoSoli) {
		this.activardescuentoDetaNotaCreditoSoli= activardescuentoDetaNotaCreditoSoli;
	}

	public Border setResaltarimpuestoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarimpuestoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoDetaNotaCreditoSoli() {
		return this.resaltarimpuestoDetaNotaCreditoSoli;
	}

	public void setResaltarimpuestoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarimpuestoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarimpuestoDetaNotaCreditoSoli() {
		return this.mostrarimpuestoDetaNotaCreditoSoli;
	}

	public void setMostrarimpuestoDetaNotaCreditoSoli(Boolean mostrarimpuestoDetaNotaCreditoSoli) {
		this.mostrarimpuestoDetaNotaCreditoSoli= mostrarimpuestoDetaNotaCreditoSoli;
	}

	public Boolean getActivarimpuestoDetaNotaCreditoSoli() {
		return this.activarimpuestoDetaNotaCreditoSoli;
	}

	public void setActivarimpuestoDetaNotaCreditoSoli(Boolean activarimpuestoDetaNotaCreditoSoli) {
		this.activarimpuestoDetaNotaCreditoSoli= activarimpuestoDetaNotaCreditoSoli;
	}

	public Border setResaltarporcen_ivaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarporcen_ivaDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_ivaDetaNotaCreditoSoli() {
		return this.resaltarporcen_ivaDetaNotaCreditoSoli;
	}

	public void setResaltarporcen_ivaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarporcen_ivaDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarporcen_ivaDetaNotaCreditoSoli() {
		return this.mostrarporcen_ivaDetaNotaCreditoSoli;
	}

	public void setMostrarporcen_ivaDetaNotaCreditoSoli(Boolean mostrarporcen_ivaDetaNotaCreditoSoli) {
		this.mostrarporcen_ivaDetaNotaCreditoSoli= mostrarporcen_ivaDetaNotaCreditoSoli;
	}

	public Boolean getActivarporcen_ivaDetaNotaCreditoSoli() {
		return this.activarporcen_ivaDetaNotaCreditoSoli;
	}

	public void setActivarporcen_ivaDetaNotaCreditoSoli(Boolean activarporcen_ivaDetaNotaCreditoSoli) {
		this.activarporcen_ivaDetaNotaCreditoSoli= activarporcen_ivaDetaNotaCreditoSoli;
	}

	public Border setResaltartotalDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltartotalDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetaNotaCreditoSoli() {
		return this.resaltartotalDetaNotaCreditoSoli;
	}

	public void setResaltartotalDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltartotalDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrartotalDetaNotaCreditoSoli() {
		return this.mostrartotalDetaNotaCreditoSoli;
	}

	public void setMostrartotalDetaNotaCreditoSoli(Boolean mostrartotalDetaNotaCreditoSoli) {
		this.mostrartotalDetaNotaCreditoSoli= mostrartotalDetaNotaCreditoSoli;
	}

	public Boolean getActivartotalDetaNotaCreditoSoli() {
		return this.activartotalDetaNotaCreditoSoli;
	}

	public void setActivartotalDetaNotaCreditoSoli(Boolean activartotalDetaNotaCreditoSoli) {
		this.activartotalDetaNotaCreditoSoli= activartotalDetaNotaCreditoSoli;
	}

	public Border setResaltardescripcionDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescripcionDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetaNotaCreditoSoli() {
		return this.resaltardescripcionDetaNotaCreditoSoli;
	}

	public void setResaltardescripcionDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescripcionDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescripcionDetaNotaCreditoSoli() {
		return this.mostrardescripcionDetaNotaCreditoSoli;
	}

	public void setMostrardescripcionDetaNotaCreditoSoli(Boolean mostrardescripcionDetaNotaCreditoSoli) {
		this.mostrardescripcionDetaNotaCreditoSoli= mostrardescripcionDetaNotaCreditoSoli;
	}

	public Boolean getActivardescripcionDetaNotaCreditoSoli() {
		return this.activardescripcionDetaNotaCreditoSoli;
	}

	public void setActivardescripcionDetaNotaCreditoSoli(Boolean activardescripcionDetaNotaCreditoSoli) {
		this.activardescripcionDetaNotaCreditoSoli= activardescripcionDetaNotaCreditoSoli;
	}

	public Border setResaltarcodigo_loteDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcodigo_loteDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_loteDetaNotaCreditoSoli() {
		return this.resaltarcodigo_loteDetaNotaCreditoSoli;
	}

	public void setResaltarcodigo_loteDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcodigo_loteDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcodigo_loteDetaNotaCreditoSoli() {
		return this.mostrarcodigo_loteDetaNotaCreditoSoli;
	}

	public void setMostrarcodigo_loteDetaNotaCreditoSoli(Boolean mostrarcodigo_loteDetaNotaCreditoSoli) {
		this.mostrarcodigo_loteDetaNotaCreditoSoli= mostrarcodigo_loteDetaNotaCreditoSoli;
	}

	public Boolean getActivarcodigo_loteDetaNotaCreditoSoli() {
		return this.activarcodigo_loteDetaNotaCreditoSoli;
	}

	public void setActivarcodigo_loteDetaNotaCreditoSoli(Boolean activarcodigo_loteDetaNotaCreditoSoli) {
		this.activarcodigo_loteDetaNotaCreditoSoli= activarcodigo_loteDetaNotaCreditoSoli;
	}

	public Border setResaltarnumero_cajaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarnumero_cajaDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cajaDetaNotaCreditoSoli() {
		return this.resaltarnumero_cajaDetaNotaCreditoSoli;
	}

	public void setResaltarnumero_cajaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarnumero_cajaDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarnumero_cajaDetaNotaCreditoSoli() {
		return this.mostrarnumero_cajaDetaNotaCreditoSoli;
	}

	public void setMostrarnumero_cajaDetaNotaCreditoSoli(Boolean mostrarnumero_cajaDetaNotaCreditoSoli) {
		this.mostrarnumero_cajaDetaNotaCreditoSoli= mostrarnumero_cajaDetaNotaCreditoSoli;
	}

	public Boolean getActivarnumero_cajaDetaNotaCreditoSoli() {
		return this.activarnumero_cajaDetaNotaCreditoSoli;
	}

	public void setActivarnumero_cajaDetaNotaCreditoSoli(Boolean activarnumero_cajaDetaNotaCreditoSoli) {
		this.activarnumero_cajaDetaNotaCreditoSoli= activarnumero_cajaDetaNotaCreditoSoli;
	}

	public Border setResaltardescuento2DetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltardescuento2DetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetaNotaCreditoSoli() {
		return this.resaltardescuento2DetaNotaCreditoSoli;
	}

	public void setResaltardescuento2DetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltardescuento2DetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrardescuento2DetaNotaCreditoSoli() {
		return this.mostrardescuento2DetaNotaCreditoSoli;
	}

	public void setMostrardescuento2DetaNotaCreditoSoli(Boolean mostrardescuento2DetaNotaCreditoSoli) {
		this.mostrardescuento2DetaNotaCreditoSoli= mostrardescuento2DetaNotaCreditoSoli;
	}

	public Boolean getActivardescuento2DetaNotaCreditoSoli() {
		return this.activardescuento2DetaNotaCreditoSoli;
	}

	public void setActivardescuento2DetaNotaCreditoSoli(Boolean activardescuento2DetaNotaCreditoSoli) {
		this.activardescuento2DetaNotaCreditoSoli= activardescuento2DetaNotaCreditoSoli;
	}

	public Border setResaltarcostoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcostoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetaNotaCreditoSoli() {
		return this.resaltarcostoDetaNotaCreditoSoli;
	}

	public void setResaltarcostoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcostoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcostoDetaNotaCreditoSoli() {
		return this.mostrarcostoDetaNotaCreditoSoli;
	}

	public void setMostrarcostoDetaNotaCreditoSoli(Boolean mostrarcostoDetaNotaCreditoSoli) {
		this.mostrarcostoDetaNotaCreditoSoli= mostrarcostoDetaNotaCreditoSoli;
	}

	public Boolean getActivarcostoDetaNotaCreditoSoli() {
		return this.activarcostoDetaNotaCreditoSoli;
	}

	public void setActivarcostoDetaNotaCreditoSoli(Boolean activarcostoDetaNotaCreditoSoli) {
		this.activarcostoDetaNotaCreditoSoli= activarcostoDetaNotaCreditoSoli;
	}

	public Border setResaltarincluye_impuestoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarincluye_impuestoDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarincluye_impuestoDetaNotaCreditoSoli() {
		return this.resaltarincluye_impuestoDetaNotaCreditoSoli;
	}

	public void setResaltarincluye_impuestoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarincluye_impuestoDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarincluye_impuestoDetaNotaCreditoSoli() {
		return this.mostrarincluye_impuestoDetaNotaCreditoSoli;
	}

	public void setMostrarincluye_impuestoDetaNotaCreditoSoli(Boolean mostrarincluye_impuestoDetaNotaCreditoSoli) {
		this.mostrarincluye_impuestoDetaNotaCreditoSoli= mostrarincluye_impuestoDetaNotaCreditoSoli;
	}

	public Boolean getActivarincluye_impuestoDetaNotaCreditoSoli() {
		return this.activarincluye_impuestoDetaNotaCreditoSoli;
	}

	public void setActivarincluye_impuestoDetaNotaCreditoSoli(Boolean activarincluye_impuestoDetaNotaCreditoSoli) {
		this.activarincluye_impuestoDetaNotaCreditoSoli= activarincluye_impuestoDetaNotaCreditoSoli;
	}

	public Border setResaltarporcen_iceDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarporcen_iceDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_iceDetaNotaCreditoSoli() {
		return this.resaltarporcen_iceDetaNotaCreditoSoli;
	}

	public void setResaltarporcen_iceDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarporcen_iceDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarporcen_iceDetaNotaCreditoSoli() {
		return this.mostrarporcen_iceDetaNotaCreditoSoli;
	}

	public void setMostrarporcen_iceDetaNotaCreditoSoli(Boolean mostrarporcen_iceDetaNotaCreditoSoli) {
		this.mostrarporcen_iceDetaNotaCreditoSoli= mostrarporcen_iceDetaNotaCreditoSoli;
	}

	public Boolean getActivarporcen_iceDetaNotaCreditoSoli() {
		return this.activarporcen_iceDetaNotaCreditoSoli;
	}

	public void setActivarporcen_iceDetaNotaCreditoSoli(Boolean activarporcen_iceDetaNotaCreditoSoli) {
		this.activarporcen_iceDetaNotaCreditoSoli= activarporcen_iceDetaNotaCreditoSoli;
	}

	public Border setResaltarfecha_emisionDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditosoliBeanSwingJInternalFrame.jTtoolBarDetaNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDetaNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetaNotaCreditoSoli() {
		return this.resaltarfecha_emisionDetaNotaCreditoSoli;
	}

	public void setResaltarfecha_emisionDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarfecha_emisionDetaNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetaNotaCreditoSoli() {
		return this.mostrarfecha_emisionDetaNotaCreditoSoli;
	}

	public void setMostrarfecha_emisionDetaNotaCreditoSoli(Boolean mostrarfecha_emisionDetaNotaCreditoSoli) {
		this.mostrarfecha_emisionDetaNotaCreditoSoli= mostrarfecha_emisionDetaNotaCreditoSoli;
	}

	public Boolean getActivarfecha_emisionDetaNotaCreditoSoli() {
		return this.activarfecha_emisionDetaNotaCreditoSoli;
	}

	public void setActivarfecha_emisionDetaNotaCreditoSoli(Boolean activarfecha_emisionDetaNotaCreditoSoli) {
		this.activarfecha_emisionDetaNotaCreditoSoli= activarfecha_emisionDetaNotaCreditoSoli;
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
		
		
		this.setMostraridDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_empresaDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_sucursalDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_ejercicioDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_periodoDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_anioDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_mesDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_nota_credito_soliDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_bodegaDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_productoDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_unidadDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_empaqueDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esInicial);
		this.setMostrarid_centro_costoDetaNotaCreditoSoli(esInicial);
		this.setMostrarcantidadDetaNotaCreditoSoli(esInicial);
		this.setMostrarprecioDetaNotaCreditoSoli(esInicial);
		this.setMostrarporcen_descuenDetaNotaCreditoSoli(esInicial);
		this.setMostrardescuentoDetaNotaCreditoSoli(esInicial);
		this.setMostrarimpuestoDetaNotaCreditoSoli(esInicial);
		this.setMostrarporcen_ivaDetaNotaCreditoSoli(esInicial);
		this.setMostrartotalDetaNotaCreditoSoli(esInicial);
		this.setMostrardescripcionDetaNotaCreditoSoli(esInicial);
		this.setMostrarcodigo_loteDetaNotaCreditoSoli(esInicial);
		this.setMostrarnumero_cajaDetaNotaCreditoSoli(esInicial);
		this.setMostrardescuento2DetaNotaCreditoSoli(esInicial);
		this.setMostrarcostoDetaNotaCreditoSoli(esInicial);
		this.setMostrarincluye_impuestoDetaNotaCreditoSoli(esInicial);
		this.setMostrarporcen_iceDetaNotaCreditoSoli(esInicial);
		this.setMostrarfecha_emisionDetaNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.ID)) {
				this.setMostraridDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI)) {
				this.setMostrarid_nota_credito_soliDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE)) {
				this.setMostrarid_empaqueDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setMostrarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN)) {
				this.setMostrarporcen_descuenDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENIVA)) {
				this.setMostrarporcen_ivaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE)) {
				this.setMostrarcodigo_loteDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA)) {
				this.setMostrarnumero_cajaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setMostrarincluye_impuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENICE)) {
				this.setMostrarporcen_iceDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetaNotaCreditoSoli(esAsigna);
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
		
		
		this.setActivaridDetaNotaCreditoSoli(esInicial);
		this.setActivarid_empresaDetaNotaCreditoSoli(esInicial);
		this.setActivarid_sucursalDetaNotaCreditoSoli(esInicial);
		this.setActivarid_ejercicioDetaNotaCreditoSoli(esInicial);
		this.setActivarid_periodoDetaNotaCreditoSoli(esInicial);
		this.setActivarid_anioDetaNotaCreditoSoli(esInicial);
		this.setActivarid_mesDetaNotaCreditoSoli(esInicial);
		this.setActivarid_nota_credito_soliDetaNotaCreditoSoli(esInicial);
		this.setActivarid_bodegaDetaNotaCreditoSoli(esInicial);
		this.setActivarid_productoDetaNotaCreditoSoli(esInicial);
		this.setActivarid_unidadDetaNotaCreditoSoli(esInicial);
		this.setActivarid_empaqueDetaNotaCreditoSoli(esInicial);
		this.setActivarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esInicial);
		this.setActivarid_centro_costoDetaNotaCreditoSoli(esInicial);
		this.setActivarcantidadDetaNotaCreditoSoli(esInicial);
		this.setActivarprecioDetaNotaCreditoSoli(esInicial);
		this.setActivarporcen_descuenDetaNotaCreditoSoli(esInicial);
		this.setActivardescuentoDetaNotaCreditoSoli(esInicial);
		this.setActivarimpuestoDetaNotaCreditoSoli(esInicial);
		this.setActivarporcen_ivaDetaNotaCreditoSoli(esInicial);
		this.setActivartotalDetaNotaCreditoSoli(esInicial);
		this.setActivardescripcionDetaNotaCreditoSoli(esInicial);
		this.setActivarcodigo_loteDetaNotaCreditoSoli(esInicial);
		this.setActivarnumero_cajaDetaNotaCreditoSoli(esInicial);
		this.setActivardescuento2DetaNotaCreditoSoli(esInicial);
		this.setActivarcostoDetaNotaCreditoSoli(esInicial);
		this.setActivarincluye_impuestoDetaNotaCreditoSoli(esInicial);
		this.setActivarporcen_iceDetaNotaCreditoSoli(esInicial);
		this.setActivarfecha_emisionDetaNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.ID)) {
				this.setActivaridDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI)) {
				this.setActivarid_nota_credito_soliDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE)) {
				this.setActivarid_empaqueDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setActivarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN)) {
				this.setActivarporcen_descuenDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENIVA)) {
				this.setActivarporcen_ivaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setActivartotalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE)) {
				this.setActivarcodigo_loteDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA)) {
				this.setActivarnumero_cajaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.COSTO)) {
				this.setActivarcostoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setActivarincluye_impuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENICE)) {
				this.setActivarporcen_iceDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetaNotaCreditoSoli(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_empresaDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_sucursalDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_ejercicioDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_periodoDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_anioDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_mesDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_nota_credito_soliDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_bodegaDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_productoDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_unidadDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_empaqueDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esInicial);
		this.setResaltarid_centro_costoDetaNotaCreditoSoli(esInicial);
		this.setResaltarcantidadDetaNotaCreditoSoli(esInicial);
		this.setResaltarprecioDetaNotaCreditoSoli(esInicial);
		this.setResaltarporcen_descuenDetaNotaCreditoSoli(esInicial);
		this.setResaltardescuentoDetaNotaCreditoSoli(esInicial);
		this.setResaltarimpuestoDetaNotaCreditoSoli(esInicial);
		this.setResaltarporcen_ivaDetaNotaCreditoSoli(esInicial);
		this.setResaltartotalDetaNotaCreditoSoli(esInicial);
		this.setResaltardescripcionDetaNotaCreditoSoli(esInicial);
		this.setResaltarcodigo_loteDetaNotaCreditoSoli(esInicial);
		this.setResaltarnumero_cajaDetaNotaCreditoSoli(esInicial);
		this.setResaltardescuento2DetaNotaCreditoSoli(esInicial);
		this.setResaltarcostoDetaNotaCreditoSoli(esInicial);
		this.setResaltarincluye_impuestoDetaNotaCreditoSoli(esInicial);
		this.setResaltarporcen_iceDetaNotaCreditoSoli(esInicial);
		this.setResaltarfecha_emisionDetaNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.ID)) {
				this.setResaltaridDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI)) {
				this.setResaltarid_nota_credito_soliDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE)) {
				this.setResaltarid_empaqueDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setResaltarid_tipo_devolucion_empresaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN)) {
				this.setResaltarporcen_descuenDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENIVA)) {
				this.setResaltarporcen_ivaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE)) {
				this.setResaltarcodigo_loteDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA)) {
				this.setResaltarnumero_cajaDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setResaltarincluye_impuestoDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.PORCENICE)) {
				this.setResaltarporcen_iceDetaNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetaNotaCreditoSoli(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdBodegaDetaNotaCreditoSoli() {
		return this.mostrarFK_IdBodegaDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdBodegaDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdCentroCostoDetaNotaCreditoSoli() {
		return this.mostrarFK_IdCentroCostoDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdCentroCostoDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEjercicioDetaNotaCreditoSoli() {
		return this.mostrarFK_IdEjercicioDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdEjercicioDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpaqueDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEmpaqueDetaNotaCreditoSoli() {
		return this.mostrarFK_IdEmpaqueDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdEmpaqueDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpaqueDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdEmpresaDetaNotaCreditoSoli() {
		return this.mostrarFK_IdEmpresaDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdEmpresaDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNotaCreditoSoliDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdNotaCreditoSoliDetaNotaCreditoSoli() {
		return this.mostrarFK_IdNotaCreditoSoliDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdNotaCreditoSoliDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNotaCreditoSoliDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdPeriodoDetaNotaCreditoSoli() {
		return this.mostrarFK_IdPeriodoDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdPeriodoDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdProductoDetaNotaCreditoSoli() {
		return this.mostrarFK_IdProductoDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdProductoDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdSucursalDetaNotaCreditoSoli() {
		return this.mostrarFK_IdSucursalDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdSucursalDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli() {
		return this.mostrarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetaNotaCreditoSoli=true;

	public Boolean getMostrarFK_IdUnidadDetaNotaCreditoSoli() {
		return this.mostrarFK_IdUnidadDetaNotaCreditoSoli;
	}

	public void setMostrarFK_IdUnidadDetaNotaCreditoSoli(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetaNotaCreditoSoli= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdBodegaDetaNotaCreditoSoli() {
		return this.activarFK_IdBodegaDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdBodegaDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdCentroCostoDetaNotaCreditoSoli() {
		return this.activarFK_IdCentroCostoDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdCentroCostoDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEjercicioDetaNotaCreditoSoli() {
		return this.activarFK_IdEjercicioDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdEjercicioDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpaqueDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEmpaqueDetaNotaCreditoSoli() {
		return this.activarFK_IdEmpaqueDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdEmpaqueDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEmpaqueDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdEmpresaDetaNotaCreditoSoli() {
		return this.activarFK_IdEmpresaDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdEmpresaDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdNotaCreditoSoliDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdNotaCreditoSoliDetaNotaCreditoSoli() {
		return this.activarFK_IdNotaCreditoSoliDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdNotaCreditoSoliDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdNotaCreditoSoliDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdPeriodoDetaNotaCreditoSoli() {
		return this.activarFK_IdPeriodoDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdPeriodoDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdProductoDetaNotaCreditoSoli() {
		return this.activarFK_IdProductoDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdProductoDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdSucursalDetaNotaCreditoSoli() {
		return this.activarFK_IdSucursalDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdSucursalDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli() {
		return this.activarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetaNotaCreditoSoli=true;

	public Boolean getActivarFK_IdUnidadDetaNotaCreditoSoli() {
		return this.activarFK_IdUnidadDetaNotaCreditoSoli;
	}

	public void setActivarFK_IdUnidadDetaNotaCreditoSoli(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetaNotaCreditoSoli= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdBodegaDetaNotaCreditoSoli() {
		return this.resaltarFK_IdBodegaDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdBodegaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdCentroCostoDetaNotaCreditoSoli() {
		return this.resaltarFK_IdCentroCostoDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdCentroCostoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdEjercicioDetaNotaCreditoSoli() {
		return this.resaltarFK_IdEjercicioDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdEjercicioDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEmpaqueDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdEmpaqueDetaNotaCreditoSoli() {
		return this.resaltarFK_IdEmpaqueDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdEmpaqueDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEmpaqueDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEmpaqueDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpaqueDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdEmpresaDetaNotaCreditoSoli() {
		return this.resaltarFK_IdEmpresaDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdEmpresaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli() {
		return this.resaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNotaCreditoSoliDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdPeriodoDetaNotaCreditoSoli() {
		return this.resaltarFK_IdPeriodoDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdPeriodoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdProductoDetaNotaCreditoSoli() {
		return this.resaltarFK_IdProductoDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdProductoDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdProductoDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdSucursalDetaNotaCreditoSoli() {
		return this.resaltarFK_IdSucursalDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdSucursalDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli() {
		return this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCreditoSoli= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetaNotaCreditoSoli=null;

	public Border getResaltarFK_IdUnidadDetaNotaCreditoSoli() {
		return this.resaltarFK_IdUnidadDetaNotaCreditoSoli;
	}

	public void setResaltarFK_IdUnidadDetaNotaCreditoSoli(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetaNotaCreditoSoli= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetaNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoSoliBeanSwingJInternalFrame detanotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetaNotaCreditoSoli= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}