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


import com.bydan.erp.facturacion.util.DetaNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaNotaCreditoParameterGeneral;

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
final public class DetaNotaCreditoConstantesFunciones extends DetaNotaCreditoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetaNotaCredito";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetaNotaCredito"+DetaNotaCreditoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetaNotaCreditoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetaNotaCreditoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetaNotaCreditoConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetaNotaCreditoConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetaNotaCreditoConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetaNotaCreditoConstantesFunciones.SCHEMA+"_"+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetaNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetaNotaCreditoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetaNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetaNotaCreditoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Deta Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Deta Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Deta Nota Credito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetaNotaCredito";
	public static final String OBJECTNAME="detanotacredito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="deta_nota_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detanotacredito from "+DetaNotaCreditoConstantesFunciones.SPERSISTENCENAME+" detanotacredito";
	public static String QUERYSELECTNATIVE="select "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_periodo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_anio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_mes,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_nota_credito,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_bodega,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_producto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_unidad,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_tipo_deta_nota_credito,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_tipo_devolucion_empresa,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descripcion,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".cantidad,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".precio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".monto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".costo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descuento,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descuento2,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".impuesto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_iva,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_descuen,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_ice,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".sub_total,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".total,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_centro_costo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_empaque,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".incluye_impuesto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".fecha_emision,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".codigo_lote,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".numero_caja from "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetaNotaCreditoConstantesFuncionesAdditional detanotacreditoConstantesFuncionesAdditional=null;
	
	public DetaNotaCreditoConstantesFuncionesAdditional getDetaNotaCreditoConstantesFuncionesAdditional() {
		return this.detanotacreditoConstantesFuncionesAdditional;
	}
	
	public void setDetaNotaCreditoConstantesFuncionesAdditional(DetaNotaCreditoConstantesFuncionesAdditional detanotacreditoConstantesFuncionesAdditional) {
		try {
			this.detanotacreditoConstantesFuncionesAdditional=detanotacreditoConstantesFuncionesAdditional;
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
    public static final String IDNOTACREDITO= "id_nota_credito";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDTIPODETANOTACREDITO= "id_tipo_deta_nota_credito";
    public static final String IDTIPODEVOLUCIONEMPRESA= "id_tipo_devolucion_empresa";
    public static final String DESCRIPCION= "descripcion";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String MONTO= "monto";
    public static final String COSTO= "costo";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTO2= "descuento2";
    public static final String IMPUESTO= "impuesto";
    public static final String PORCENIVA= "porcen_iva";
    public static final String PORCENDESCUEN= "porcen_descuen";
    public static final String PORCENICE= "porcen_ice";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDEMPAQUE= "id_empaque";
    public static final String INCLUYEIMPUESTO= "incluye_impuesto";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String CODIGOLOTE= "codigo_lote";
    public static final String NUMEROCAJA= "numero_caja";
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
    	public static final String LABEL_IDNOTACREDITO= "Nota Credito";
		public static final String LABEL_IDNOTACREDITO_LOWER= "Nota Credito";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDTIPODETANOTACREDITO= "Tipo";
		public static final String LABEL_IDTIPODETANOTACREDITO_LOWER= "Tipo Deta Nota Credito";
    	public static final String LABEL_IDTIPODEVOLUCIONEMPRESA= "Tipo Devolucion";
		public static final String LABEL_IDTIPODEVOLUCIONEMPRESA_LOWER= "Tipo Devolucion Empresa";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTO2= "Descuento 2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_PORCENIVA= "% Iva";
		public static final String LABEL_PORCENIVA_LOWER= "Porcen Iva";
    	public static final String LABEL_PORCENDESCUEN= "% Descuen";
		public static final String LABEL_PORCENDESCUEN_LOWER= "Porcen Descuen";
    	public static final String LABEL_PORCENICE= "% Ice";
		public static final String LABEL_PORCENICE_LOWER= "Porcen Ice";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDEMPAQUE= "Empaque";
		public static final String LABEL_IDEMPAQUE_LOWER= "Empaque";
    	public static final String LABEL_INCLUYEIMPUESTO= "Incluye Impuesto";
		public static final String LABEL_INCLUYEIMPUESTO_LOWER= "Incluye Impuesto";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_CODIGOLOTE= "Codigo Lote";
		public static final String LABEL_CODIGOLOTE_LOWER= "Codigo Lote";
    	public static final String LABEL_NUMEROCAJA= "Numero Caja";
		public static final String LABEL_NUMEROCAJA_LOWER= "Numero Caja";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_LOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_LOTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetaNotaCreditoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDPERIODO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDANIO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDMES)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDNOTACREDITO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDNOTACREDITO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDBODEGA)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODETANOTACREDITO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.CANTIDAD)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.PRECIO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.MONTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.COSTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO2)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IMPUESTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.PORCENIVA)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.PORCENDESCUEN)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.PORCENICE)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.SUBTOTAL)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.TOTAL)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.IDEMPAQUE)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_IDEMPAQUE;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_INCLUYEIMPUESTO;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.CODIGOLOTE)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_CODIGOLOTE;}
		if(sNombreColumna.equals(DetaNotaCreditoConstantesFunciones.NUMEROCAJA)) {sLabelColumna=DetaNotaCreditoConstantesFunciones.LABEL_NUMEROCAJA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getincluye_impuestoDescripcion(DetaNotaCredito detanotacredito) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detanotacredito.getincluye_impuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getincluye_impuestoHtmlDescripcion(DetaNotaCredito detanotacredito) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detanotacredito.getId(),detanotacredito.getincluye_impuesto());

		return sDescripcion;
	}	
			
			
			
	
	public static String getDetaNotaCreditoDescripcion(DetaNotaCredito detanotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detanotacredito !=null/* && detanotacredito.getId()!=0*/) {
			if(detanotacredito.getId()!=null) {
				sDescripcion=detanotacredito.getId().toString();
			}//detanotacreditodetanotacredito.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetaNotaCreditoDescripcionDetallado(DetaNotaCredito detanotacredito) {
		String sDescripcion="";
			
		sDescripcion+=DetaNotaCreditoConstantesFunciones.ID+"=";
		sDescripcion+=detanotacredito.getId().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detanotacredito.getVersionRow().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detanotacredito.getid_empresa().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detanotacredito.getid_sucursal().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detanotacredito.getid_ejercicio().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detanotacredito.getid_periodo().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDANIO+"=";
		sDescripcion+=detanotacredito.getid_anio().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDMES+"=";
		sDescripcion+=detanotacredito.getid_mes().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDNOTACREDITO+"=";
		sDescripcion+=detanotacredito.getid_nota_credito().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detanotacredito.getid_bodega().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detanotacredito.getid_producto().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detanotacredito.getid_unidad().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO+"=";
		sDescripcion+=detanotacredito.getid_tipo_deta_nota_credito().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA+"=";
		sDescripcion+=detanotacredito.getid_tipo_devolucion_empresa().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detanotacredito.getdescripcion()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detanotacredito.getcantidad().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.PRECIO+"=";
		sDescripcion+=detanotacredito.getprecio().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.MONTO+"=";
		sDescripcion+=detanotacredito.getmonto().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.COSTO+"=";
		sDescripcion+=detanotacredito.getcosto().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=detanotacredito.getdescuento().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=detanotacredito.getdescuento2().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=detanotacredito.getimpuesto().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.PORCENIVA+"=";
		sDescripcion+=detanotacredito.getporcen_iva().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.PORCENDESCUEN+"=";
		sDescripcion+=detanotacredito.getporcen_descuen().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.PORCENICE+"=";
		sDescripcion+=detanotacredito.getporcen_ice().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=detanotacredito.getsub_total().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.TOTAL+"=";
		sDescripcion+=detanotacredito.gettotal().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detanotacredito.getid_centro_costo().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.IDEMPAQUE+"=";
		sDescripcion+=detanotacredito.getid_empaque().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO+"=";
		sDescripcion+=detanotacredito.getincluye_impuesto().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detanotacredito.getfecha_emision().toString()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.CODIGOLOTE+"=";
		sDescripcion+=detanotacredito.getcodigo_lote()+",";
		sDescripcion+=DetaNotaCreditoConstantesFunciones.NUMEROCAJA+"=";
		sDescripcion+=detanotacredito.getnumero_caja()+",";
			
		return sDescripcion;
	}
	
	public static void setDetaNotaCreditoDescripcion(DetaNotaCredito detanotacredito,String sValor) throws Exception {			
		if(detanotacredito !=null) {
			//detanotacreditodetanotacredito.getId().toString();
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

	public static String getNotaCreditoDescripcion(NotaCredito notacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(notacredito!=null/*&&notacredito.getId()>0*/) {
			sDescripcion=NotaCreditoConstantesFunciones.getNotaCreditoDescripcion(notacredito);
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

	public static String getTipoDetaNotaCreditoDescripcion(TipoDetaNotaCredito tipodetanotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodetanotacredito!=null/*&&tipodetanotacredito.getId()>0*/) {
			sDescripcion=TipoDetaNotaCreditoConstantesFunciones.getTipoDetaNotaCreditoDescripcion(tipodetanotacredito);
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

	public static String getEmpaqueDescripcion(Empaque empaque) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empaque!=null/*&&empaque.getId()>0*/) {
			sDescripcion=EmpaqueConstantesFunciones.getEmpaqueDescripcion(empaque);
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
		} else if(sNombreIndice.equals("FK_IdNotaCredito")) {
			sNombreIndice="Tipo=  Por Nota Credito";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDetaNotaCredito")) {
			sNombreIndice="Tipo=  Por Tipo";
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

	public static String getDetalleIndiceFK_IdNotaCredito(Long id_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Nota Credito="+id_nota_credito.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoDetaNotaCredito(Long id_tipo_deta_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_deta_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_deta_nota_credito.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetaNotaCredito(DetaNotaCredito detanotacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detanotacredito.setdescripcion(detanotacredito.getdescripcion().trim());
		detanotacredito.setcodigo_lote(detanotacredito.getcodigo_lote().trim());
		detanotacredito.setnumero_caja(detanotacredito.getnumero_caja().trim());
	}
	
	public static void quitarEspaciosDetaNotaCreditos(List<DetaNotaCredito> detanotacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetaNotaCredito detanotacredito: detanotacreditos) {
			detanotacredito.setdescripcion(detanotacredito.getdescripcion().trim());
			detanotacredito.setcodigo_lote(detanotacredito.getcodigo_lote().trim());
			detanotacredito.setnumero_caja(detanotacredito.getnumero_caja().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaNotaCredito(DetaNotaCredito detanotacredito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detanotacredito.getConCambioAuxiliar()) {
			detanotacredito.setIsDeleted(detanotacredito.getIsDeletedAuxiliar());	
			detanotacredito.setIsNew(detanotacredito.getIsNewAuxiliar());	
			detanotacredito.setIsChanged(detanotacredito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detanotacredito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detanotacredito.setIsDeletedAuxiliar(false);	
			detanotacredito.setIsNewAuxiliar(false);	
			detanotacredito.setIsChangedAuxiliar(false);
			
			detanotacredito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaNotaCreditos(List<DetaNotaCredito> detanotacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetaNotaCredito detanotacredito : detanotacreditos) {
			if(conAsignarBase && detanotacredito.getConCambioAuxiliar()) {
				detanotacredito.setIsDeleted(detanotacredito.getIsDeletedAuxiliar());	
				detanotacredito.setIsNew(detanotacredito.getIsNewAuxiliar());	
				detanotacredito.setIsChanged(detanotacredito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detanotacredito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detanotacredito.setIsDeletedAuxiliar(false);	
				detanotacredito.setIsNewAuxiliar(false);	
				detanotacredito.setIsChangedAuxiliar(false);
				
				detanotacredito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetaNotaCredito(DetaNotaCredito detanotacredito,Boolean conEnteros) throws Exception  {
		detanotacredito.setprecio(0.0);
		detanotacredito.setmonto(0.0);
		detanotacredito.setcosto(0.0);
		detanotacredito.setdescuento(0.0);
		detanotacredito.setdescuento2(0.0);
		detanotacredito.setimpuesto(0.0);
		detanotacredito.setporcen_iva(0.0);
		detanotacredito.setporcen_descuen(0.0);
		detanotacredito.setporcen_ice(0.0);
		detanotacredito.setsub_total(0.0);
		detanotacredito.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detanotacredito.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetaNotaCreditos(List<DetaNotaCredito> detanotacreditos,Boolean conEnteros) throws Exception  {
		
		for(DetaNotaCredito detanotacredito: detanotacreditos) {
			detanotacredito.setprecio(0.0);
			detanotacredito.setmonto(0.0);
			detanotacredito.setcosto(0.0);
			detanotacredito.setdescuento(0.0);
			detanotacredito.setdescuento2(0.0);
			detanotacredito.setimpuesto(0.0);
			detanotacredito.setporcen_iva(0.0);
			detanotacredito.setporcen_descuen(0.0);
			detanotacredito.setporcen_ice(0.0);
			detanotacredito.setsub_total(0.0);
			detanotacredito.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detanotacredito.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetaNotaCredito(List<DetaNotaCredito> detanotacreditos,DetaNotaCredito detanotacreditoAux) throws Exception  {
		DetaNotaCreditoConstantesFunciones.InicializarValoresDetaNotaCredito(detanotacreditoAux,true);
		
		for(DetaNotaCredito detanotacredito: detanotacreditos) {
			if(detanotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detanotacreditoAux.setcantidad(detanotacreditoAux.getcantidad()+detanotacredito.getcantidad());			
			detanotacreditoAux.setprecio(detanotacreditoAux.getprecio()+detanotacredito.getprecio());			
			detanotacreditoAux.setmonto(detanotacreditoAux.getmonto()+detanotacredito.getmonto());			
			detanotacreditoAux.setcosto(detanotacreditoAux.getcosto()+detanotacredito.getcosto());			
			detanotacreditoAux.setdescuento(detanotacreditoAux.getdescuento()+detanotacredito.getdescuento());			
			detanotacreditoAux.setdescuento2(detanotacreditoAux.getdescuento2()+detanotacredito.getdescuento2());			
			detanotacreditoAux.setimpuesto(detanotacreditoAux.getimpuesto()+detanotacredito.getimpuesto());			
			detanotacreditoAux.setporcen_iva(detanotacreditoAux.getporcen_iva()+detanotacredito.getporcen_iva());			
			detanotacreditoAux.setporcen_descuen(detanotacreditoAux.getporcen_descuen()+detanotacredito.getporcen_descuen());			
			detanotacreditoAux.setporcen_ice(detanotacreditoAux.getporcen_ice()+detanotacredito.getporcen_ice());			
			detanotacreditoAux.setsub_total(detanotacreditoAux.getsub_total()+detanotacredito.getsub_total());			
			detanotacreditoAux.settotal(detanotacreditoAux.gettotal()+detanotacredito.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetaNotaCreditoConstantesFunciones.getArrayColumnasGlobalesDetaNotaCredito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaNotaCreditoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaNotaCreditoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetaNotaCredito> detanotacreditos,DetaNotaCredito detanotacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetaNotaCredito detanotacreditoAux: detanotacreditos) {
			if(detanotacreditoAux!=null && detanotacredito!=null) {
				if((detanotacreditoAux.getId()==null && detanotacredito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detanotacreditoAux.getId()!=null && detanotacredito.getId()!=null){
					if(detanotacreditoAux.getId().equals(detanotacredito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetaNotaCredito(List<DetaNotaCredito> detanotacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double montoTotal=0.0;
		Double costoTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento2Total=0.0;
		Double impuestoTotal=0.0;
		Double porcen_ivaTotal=0.0;
		Double porcen_descuenTotal=0.0;
		Double porcen_iceTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetaNotaCredito detanotacredito: detanotacreditos) {			
			if(detanotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detanotacredito.getprecio();
			montoTotal+=detanotacredito.getmonto();
			costoTotal+=detanotacredito.getcosto();
			descuentoTotal+=detanotacredito.getdescuento();
			descuento2Total+=detanotacredito.getdescuento2();
			impuestoTotal+=detanotacredito.getimpuesto();
			porcen_ivaTotal+=detanotacredito.getporcen_iva();
			porcen_descuenTotal+=detanotacredito.getporcen_descuen();
			porcen_iceTotal+=detanotacredito.getporcen_ice();
			sub_totalTotal+=detanotacredito.getsub_total();
			totalTotal+=detanotacredito.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.PORCENIVA);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA);
		datoGeneral.setdValorDouble(porcen_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.PORCENDESCUEN);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN);
		datoGeneral.setdValorDouble(porcen_descuenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.PORCENICE);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE);
		datoGeneral.setdValorDouble(porcen_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaNotaCreditoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetaNotaCredito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_ID, DetaNotaCreditoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_VERSIONROW, DetaNotaCreditoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA, DetaNotaCreditoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDSUCURSAL, DetaNotaCreditoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDEJERCICIO, DetaNotaCreditoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDPERIODO, DetaNotaCreditoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDANIO, DetaNotaCreditoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDMES, DetaNotaCreditoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDNOTACREDITO, DetaNotaCreditoConstantesFunciones.IDNOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDBODEGA, DetaNotaCreditoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDPRODUCTO, DetaNotaCreditoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDUNIDAD, DetaNotaCreditoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODETANOTACREDITO, DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA, DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_DESCRIPCION, DetaNotaCreditoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_CANTIDAD, DetaNotaCreditoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_PRECIO, DetaNotaCreditoConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_MONTO, DetaNotaCreditoConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_COSTO, DetaNotaCreditoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO, DetaNotaCreditoConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2, DetaNotaCreditoConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO, DetaNotaCreditoConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA, DetaNotaCreditoConstantesFunciones.PORCENIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN, DetaNotaCreditoConstantesFunciones.PORCENDESCUEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE, DetaNotaCreditoConstantesFunciones.PORCENICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL, DetaNotaCreditoConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_TOTAL, DetaNotaCreditoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO, DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_IDEMPAQUE, DetaNotaCreditoConstantesFunciones.IDEMPAQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_INCLUYEIMPUESTO, DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_FECHAEMISION, DetaNotaCreditoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_CODIGOLOTE, DetaNotaCreditoConstantesFunciones.CODIGOLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaNotaCreditoConstantesFunciones.LABEL_NUMEROCAJA, DetaNotaCreditoConstantesFunciones.NUMEROCAJA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetaNotaCredito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDNOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.PORCENIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.PORCENDESCUEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.PORCENICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.IDEMPAQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.CODIGOLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaNotaCreditoConstantesFunciones.NUMEROCAJA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCredito() throws Exception  {
		return DetaNotaCreditoConstantesFunciones.getTiposSeleccionarDetaNotaCredito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCredito(Boolean conFk) throws Exception  {
		return DetaNotaCreditoConstantesFunciones.getTiposSeleccionarDetaNotaCredito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaNotaCredito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDNOTACREDITO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDNOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODETANOTACREDITO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODETANOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPAQUE);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPAQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_INCLUYEIMPUESTO);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_INCLUYEIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_CODIGOLOTE);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_CODIGOLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaNotaCreditoConstantesFunciones.LABEL_NUMEROCAJA);
			reporte.setsDescripcion(DetaNotaCreditoConstantesFunciones.LABEL_NUMEROCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetaNotaCredito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetaNotaCredito(DetaNotaCredito detanotacreditoAux) throws Exception {
		
			detanotacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detanotacreditoAux.getEmpresa()));
			detanotacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detanotacreditoAux.getSucursal()));
			detanotacreditoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detanotacreditoAux.getEjercicio()));
			detanotacreditoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detanotacreditoAux.getPeriodo()));
			detanotacreditoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detanotacreditoAux.getAnio()));
			detanotacreditoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detanotacreditoAux.getMes()));
			detanotacreditoAux.setnotacredito_descripcion(NotaCreditoConstantesFunciones.getNotaCreditoDescripcion(detanotacreditoAux.getNotaCredito()));
			detanotacreditoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detanotacreditoAux.getBodega()));
			detanotacreditoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detanotacreditoAux.getProducto()));
			detanotacreditoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detanotacreditoAux.getUnidad()));
			detanotacreditoAux.settipodetanotacredito_descripcion(TipoDetaNotaCreditoConstantesFunciones.getTipoDetaNotaCreditoDescripcion(detanotacreditoAux.getTipoDetaNotaCredito()));
			detanotacreditoAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(detanotacreditoAux.getTipoDevolucionEmpresa()));
			detanotacreditoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detanotacreditoAux.getCentroCosto()));
			detanotacreditoAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detanotacreditoAux.getEmpaque()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetaNotaCredito(List<DetaNotaCredito> detanotacreditosTemp) throws Exception {
		for(DetaNotaCredito detanotacreditoAux:detanotacreditosTemp) {
			
			detanotacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detanotacreditoAux.getEmpresa()));
			detanotacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detanotacreditoAux.getSucursal()));
			detanotacreditoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detanotacreditoAux.getEjercicio()));
			detanotacreditoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detanotacreditoAux.getPeriodo()));
			detanotacreditoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detanotacreditoAux.getAnio()));
			detanotacreditoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detanotacreditoAux.getMes()));
			detanotacreditoAux.setnotacredito_descripcion(NotaCreditoConstantesFunciones.getNotaCreditoDescripcion(detanotacreditoAux.getNotaCredito()));
			detanotacreditoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detanotacreditoAux.getBodega()));
			detanotacreditoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detanotacreditoAux.getProducto()));
			detanotacreditoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detanotacreditoAux.getUnidad()));
			detanotacreditoAux.settipodetanotacredito_descripcion(TipoDetaNotaCreditoConstantesFunciones.getTipoDetaNotaCreditoDescripcion(detanotacreditoAux.getTipoDetaNotaCredito()));
			detanotacreditoAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(detanotacreditoAux.getTipoDevolucionEmpresa()));
			detanotacreditoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detanotacreditoAux.getCentroCosto()));
			detanotacreditoAux.setempaque_descripcion(EmpaqueConstantesFunciones.getEmpaqueDescripcion(detanotacreditoAux.getEmpaque()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(NotaCredito.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(TipoDetaNotaCredito.class));
				classes.add(new Classe(TipoDevolucionEmpresa.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Empaque.class));
				
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
					if(clas.clas.equals(NotaCredito.class)) {
						classes.add(new Classe(NotaCredito.class));
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
					if(clas.clas.equals(TipoDetaNotaCredito.class)) {
						classes.add(new Classe(TipoDetaNotaCredito.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empaque.class)) {
						classes.add(new Classe(Empaque.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
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

					if(TipoDetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetaNotaCredito.class)); continue;
					}

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Empaque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empaque.class)); continue;
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

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
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

					if(TipoDetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetaNotaCredito.class)); continue;
					}

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Empaque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empaque.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaNotaCreditoConstantesFunciones.getClassesRelationshipsOfDetaNotaCredito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaNotaCreditoConstantesFunciones.getClassesRelationshipsFromStringsOfDetaNotaCredito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetaNotaCredito detanotacredito,List<DetaNotaCredito> detanotacreditos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetaNotaCredito detanotacreditoEncontrado=null;
			
			for(DetaNotaCredito detanotacreditoLocal:detanotacreditos) {
				if(detanotacreditoLocal.getId().equals(detanotacredito.getId())) {
					detanotacreditoEncontrado=detanotacreditoLocal;
					
					detanotacreditoLocal.setIsChanged(detanotacredito.getIsChanged());
					detanotacreditoLocal.setIsNew(detanotacredito.getIsNew());
					detanotacreditoLocal.setIsDeleted(detanotacredito.getIsDeleted());
					
					detanotacreditoLocal.setGeneralEntityOriginal(detanotacredito.getGeneralEntityOriginal());
					
					detanotacreditoLocal.setId(detanotacredito.getId());	
					detanotacreditoLocal.setVersionRow(detanotacredito.getVersionRow());	
					detanotacreditoLocal.setid_empresa(detanotacredito.getid_empresa());	
					detanotacreditoLocal.setid_sucursal(detanotacredito.getid_sucursal());	
					detanotacreditoLocal.setid_ejercicio(detanotacredito.getid_ejercicio());	
					detanotacreditoLocal.setid_periodo(detanotacredito.getid_periodo());	
					detanotacreditoLocal.setid_anio(detanotacredito.getid_anio());	
					detanotacreditoLocal.setid_mes(detanotacredito.getid_mes());	
					detanotacreditoLocal.setid_nota_credito(detanotacredito.getid_nota_credito());	
					detanotacreditoLocal.setid_bodega(detanotacredito.getid_bodega());	
					detanotacreditoLocal.setid_producto(detanotacredito.getid_producto());	
					detanotacreditoLocal.setid_unidad(detanotacredito.getid_unidad());	
					detanotacreditoLocal.setid_tipo_deta_nota_credito(detanotacredito.getid_tipo_deta_nota_credito());	
					detanotacreditoLocal.setid_tipo_devolucion_empresa(detanotacredito.getid_tipo_devolucion_empresa());	
					detanotacreditoLocal.setdescripcion(detanotacredito.getdescripcion());	
					detanotacreditoLocal.setcantidad(detanotacredito.getcantidad());	
					detanotacreditoLocal.setprecio(detanotacredito.getprecio());	
					detanotacreditoLocal.setmonto(detanotacredito.getmonto());	
					detanotacreditoLocal.setcosto(detanotacredito.getcosto());	
					detanotacreditoLocal.setdescuento(detanotacredito.getdescuento());	
					detanotacreditoLocal.setdescuento2(detanotacredito.getdescuento2());	
					detanotacreditoLocal.setimpuesto(detanotacredito.getimpuesto());	
					detanotacreditoLocal.setporcen_iva(detanotacredito.getporcen_iva());	
					detanotacreditoLocal.setporcen_descuen(detanotacredito.getporcen_descuen());	
					detanotacreditoLocal.setporcen_ice(detanotacredito.getporcen_ice());	
					detanotacreditoLocal.setsub_total(detanotacredito.getsub_total());	
					detanotacreditoLocal.settotal(detanotacredito.gettotal());	
					detanotacreditoLocal.setid_centro_costo(detanotacredito.getid_centro_costo());	
					detanotacreditoLocal.setid_empaque(detanotacredito.getid_empaque());	
					detanotacreditoLocal.setincluye_impuesto(detanotacredito.getincluye_impuesto());	
					detanotacreditoLocal.setfecha_emision(detanotacredito.getfecha_emision());	
					detanotacreditoLocal.setcodigo_lote(detanotacredito.getcodigo_lote());	
					detanotacreditoLocal.setnumero_caja(detanotacredito.getnumero_caja());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detanotacredito.getIsDeleted()) {
				if(!existe) {
					detanotacreditos.add(detanotacredito);
				}
			} else {
				if(detanotacreditoEncontrado!=null && permiteQuitar)  {
					detanotacreditos.remove(detanotacreditoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetaNotaCredito detanotacredito,List<DetaNotaCredito> detanotacreditos) throws Exception {
		try	{			
			for(DetaNotaCredito detanotacreditoLocal:detanotacreditos) {
				if(detanotacreditoLocal.getId().equals(detanotacredito.getId())) {
					detanotacreditoLocal.setIsSelected(detanotacredito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetaNotaCredito(List<DetaNotaCredito> detanotacreditosAux) throws Exception {
		//this.detanotacreditosAux=detanotacreditosAux;
		
		for(DetaNotaCredito detanotacreditoAux:detanotacreditosAux) {
			if(detanotacreditoAux.getIsChanged()) {
				detanotacreditoAux.setIsChanged(false);
			}		
			
			if(detanotacreditoAux.getIsNew()) {
				detanotacreditoAux.setIsNew(false);
			}	
			
			if(detanotacreditoAux.getIsDeleted()) {
				detanotacreditoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetaNotaCredito(DetaNotaCredito detanotacreditoAux) throws Exception {
		//this.detanotacreditoAux=detanotacreditoAux;
		
			if(detanotacreditoAux.getIsChanged()) {
				detanotacreditoAux.setIsChanged(false);
			}		
			
			if(detanotacreditoAux.getIsNew()) {
				detanotacreditoAux.setIsNew(false);
			}	
			
			if(detanotacreditoAux.getIsDeleted()) {
				detanotacreditoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetaNotaCredito detanotacreditoAsignar,DetaNotaCredito detanotacredito) throws Exception {
		detanotacreditoAsignar.setId(detanotacredito.getId());	
		detanotacreditoAsignar.setVersionRow(detanotacredito.getVersionRow());	
		detanotacreditoAsignar.setid_empresa(detanotacredito.getid_empresa());
		detanotacreditoAsignar.setempresa_descripcion(detanotacredito.getempresa_descripcion());	
		detanotacreditoAsignar.setid_sucursal(detanotacredito.getid_sucursal());
		detanotacreditoAsignar.setsucursal_descripcion(detanotacredito.getsucursal_descripcion());	
		detanotacreditoAsignar.setid_ejercicio(detanotacredito.getid_ejercicio());
		detanotacreditoAsignar.setejercicio_descripcion(detanotacredito.getejercicio_descripcion());	
		detanotacreditoAsignar.setid_periodo(detanotacredito.getid_periodo());
		detanotacreditoAsignar.setperiodo_descripcion(detanotacredito.getperiodo_descripcion());	
		detanotacreditoAsignar.setid_anio(detanotacredito.getid_anio());
		detanotacreditoAsignar.setanio_descripcion(detanotacredito.getanio_descripcion());	
		detanotacreditoAsignar.setid_mes(detanotacredito.getid_mes());
		detanotacreditoAsignar.setmes_descripcion(detanotacredito.getmes_descripcion());	
		detanotacreditoAsignar.setid_nota_credito(detanotacredito.getid_nota_credito());
		detanotacreditoAsignar.setnotacredito_descripcion(detanotacredito.getnotacredito_descripcion());	
		detanotacreditoAsignar.setid_bodega(detanotacredito.getid_bodega());
		detanotacreditoAsignar.setbodega_descripcion(detanotacredito.getbodega_descripcion());	
		detanotacreditoAsignar.setid_producto(detanotacredito.getid_producto());
		detanotacreditoAsignar.setproducto_descripcion(detanotacredito.getproducto_descripcion());	
		detanotacreditoAsignar.setid_unidad(detanotacredito.getid_unidad());
		detanotacreditoAsignar.setunidad_descripcion(detanotacredito.getunidad_descripcion());	
		detanotacreditoAsignar.setid_tipo_deta_nota_credito(detanotacredito.getid_tipo_deta_nota_credito());
		detanotacreditoAsignar.settipodetanotacredito_descripcion(detanotacredito.gettipodetanotacredito_descripcion());	
		detanotacreditoAsignar.setid_tipo_devolucion_empresa(detanotacredito.getid_tipo_devolucion_empresa());
		detanotacreditoAsignar.settipodevolucionempresa_descripcion(detanotacredito.gettipodevolucionempresa_descripcion());	
		detanotacreditoAsignar.setdescripcion(detanotacredito.getdescripcion());	
		detanotacreditoAsignar.setcantidad(detanotacredito.getcantidad());	
		detanotacreditoAsignar.setprecio(detanotacredito.getprecio());	
		detanotacreditoAsignar.setmonto(detanotacredito.getmonto());	
		detanotacreditoAsignar.setcosto(detanotacredito.getcosto());	
		detanotacreditoAsignar.setdescuento(detanotacredito.getdescuento());	
		detanotacreditoAsignar.setdescuento2(detanotacredito.getdescuento2());	
		detanotacreditoAsignar.setimpuesto(detanotacredito.getimpuesto());	
		detanotacreditoAsignar.setporcen_iva(detanotacredito.getporcen_iva());	
		detanotacreditoAsignar.setporcen_descuen(detanotacredito.getporcen_descuen());	
		detanotacreditoAsignar.setporcen_ice(detanotacredito.getporcen_ice());	
		detanotacreditoAsignar.setsub_total(detanotacredito.getsub_total());	
		detanotacreditoAsignar.settotal(detanotacredito.gettotal());	
		detanotacreditoAsignar.setid_centro_costo(detanotacredito.getid_centro_costo());
		detanotacreditoAsignar.setcentrocosto_descripcion(detanotacredito.getcentrocosto_descripcion());	
		detanotacreditoAsignar.setid_empaque(detanotacredito.getid_empaque());
		detanotacreditoAsignar.setempaque_descripcion(detanotacredito.getempaque_descripcion());	
		detanotacreditoAsignar.setincluye_impuesto(detanotacredito.getincluye_impuesto());	
		detanotacreditoAsignar.setfecha_emision(detanotacredito.getfecha_emision());	
		detanotacreditoAsignar.setcodigo_lote(detanotacredito.getcodigo_lote());	
		detanotacreditoAsignar.setnumero_caja(detanotacredito.getnumero_caja());	
	}
	
	public static void inicializarDetaNotaCredito(DetaNotaCredito detanotacredito) throws Exception {
		try {
				detanotacredito.setId(0L);	
					
				detanotacredito.setid_empresa(-1L);	
				detanotacredito.setid_sucursal(-1L);	
				detanotacredito.setid_ejercicio(-1L);	
				detanotacredito.setid_periodo(-1L);	
				detanotacredito.setid_anio(null);	
				detanotacredito.setid_mes(null);	
				detanotacredito.setid_nota_credito(-1L);	
				detanotacredito.setid_bodega(-1L);	
				detanotacredito.setid_producto(-1L);	
				detanotacredito.setid_unidad(-1L);	
				detanotacredito.setid_tipo_deta_nota_credito(-1L);	
				detanotacredito.setid_tipo_devolucion_empresa(-1L);	
				detanotacredito.setdescripcion("");	
				detanotacredito.setcantidad(0);	
				detanotacredito.setprecio(0.0);	
				detanotacredito.setmonto(0.0);	
				detanotacredito.setcosto(0.0);	
				detanotacredito.setdescuento(0.0);	
				detanotacredito.setdescuento2(0.0);	
				detanotacredito.setimpuesto(0.0);	
				detanotacredito.setporcen_iva(0.0);	
				detanotacredito.setporcen_descuen(0.0);	
				detanotacredito.setporcen_ice(0.0);	
				detanotacredito.setsub_total(0.0);	
				detanotacredito.settotal(0.0);	
				detanotacredito.setid_centro_costo(null);	
				detanotacredito.setid_empaque(null);	
				detanotacredito.setincluye_impuesto(false);	
				detanotacredito.setfecha_emision(new Date());	
				detanotacredito.setcodigo_lote("");	
				detanotacredito.setnumero_caja("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetaNotaCredito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDNOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODETANOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_PORCENIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_PORCENDESCUEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_PORCENICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_IDEMPAQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_INCLUYEIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_CODIGOLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaNotaCreditoConstantesFunciones.LABEL_NUMEROCAJA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetaNotaCredito(String sTipo,Row row,Workbook workbook,DetaNotaCredito detanotacredito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getnotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.gettipodetanotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.gettipodevolucionempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getporcen_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getporcen_descuen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getporcen_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getempaque_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detanotacredito.getincluye_impuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getcodigo_lote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detanotacredito.getnumero_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetaNotaCredito=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetaNotaCredito() {
		return this.sFinalQueryDetaNotaCredito;
	}
	
	public void setsFinalQueryDetaNotaCredito(String sFinalQueryDetaNotaCredito) {
		this.sFinalQueryDetaNotaCredito= sFinalQueryDetaNotaCredito;
	}
	
	public Border resaltarSeleccionarDetaNotaCredito=null;
	
	public Border setResaltarSeleccionarDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetaNotaCredito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetaNotaCredito() {
		return this.resaltarSeleccionarDetaNotaCredito;
	}
	
	public void setResaltarSeleccionarDetaNotaCredito(Border borderResaltarSeleccionarDetaNotaCredito) {
		this.resaltarSeleccionarDetaNotaCredito= borderResaltarSeleccionarDetaNotaCredito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetaNotaCredito=null;
	public Boolean mostraridDetaNotaCredito=true;
	public Boolean activaridDetaNotaCredito=true;

	public Border resaltarid_empresaDetaNotaCredito=null;
	public Boolean mostrarid_empresaDetaNotaCredito=true;
	public Boolean activarid_empresaDetaNotaCredito=true;
	public Boolean cargarid_empresaDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetaNotaCredito=null;
	public Boolean mostrarid_sucursalDetaNotaCredito=true;
	public Boolean activarid_sucursalDetaNotaCredito=true;
	public Boolean cargarid_sucursalDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetaNotaCredito=null;
	public Boolean mostrarid_ejercicioDetaNotaCredito=true;
	public Boolean activarid_ejercicioDetaNotaCredito=true;
	public Boolean cargarid_ejercicioDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_periodoDetaNotaCredito=null;
	public Boolean mostrarid_periodoDetaNotaCredito=true;
	public Boolean activarid_periodoDetaNotaCredito=true;
	public Boolean cargarid_periodoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_anioDetaNotaCredito=null;
	public Boolean mostrarid_anioDetaNotaCredito=true;
	public Boolean activarid_anioDetaNotaCredito=false;
	public Boolean cargarid_anioDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_mesDetaNotaCredito=null;
	public Boolean mostrarid_mesDetaNotaCredito=true;
	public Boolean activarid_mesDetaNotaCredito=false;
	public Boolean cargarid_mesDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_nota_creditoDetaNotaCredito=null;
	public Boolean mostrarid_nota_creditoDetaNotaCredito=true;
	public Boolean activarid_nota_creditoDetaNotaCredito=true;
	public Boolean cargarid_nota_creditoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nota_creditoDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetaNotaCredito=null;
	public Boolean mostrarid_bodegaDetaNotaCredito=true;
	public Boolean activarid_bodegaDetaNotaCredito=true;
	public Boolean cargarid_bodegaDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_productoDetaNotaCredito=null;
	public Boolean mostrarid_productoDetaNotaCredito=true;
	public Boolean activarid_productoDetaNotaCredito=true;
	public Boolean cargarid_productoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetaNotaCredito=true;//ConEventDepend=true

	public Border resaltarid_unidadDetaNotaCredito=null;
	public Boolean mostrarid_unidadDetaNotaCredito=true;
	public Boolean activarid_unidadDetaNotaCredito=true;
	public Boolean cargarid_unidadDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetaNotaCredito=true;//ConEventDepend=true

	public Border resaltarid_tipo_deta_nota_creditoDetaNotaCredito=null;
	public Boolean mostrarid_tipo_deta_nota_creditoDetaNotaCredito=true;
	public Boolean activarid_tipo_deta_nota_creditoDetaNotaCredito=true;
	public Boolean cargarid_tipo_deta_nota_creditoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_deta_nota_creditoDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_tipo_devolucion_empresaDetaNotaCredito=null;
	public Boolean mostrarid_tipo_devolucion_empresaDetaNotaCredito=true;
	public Boolean activarid_tipo_devolucion_empresaDetaNotaCredito=true;
	public Boolean cargarid_tipo_devolucion_empresaDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_devolucion_empresaDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltardescripcionDetaNotaCredito=null;
	public Boolean mostrardescripcionDetaNotaCredito=true;
	public Boolean activardescripcionDetaNotaCredito=true;

	public Border resaltarcantidadDetaNotaCredito=null;
	public Boolean mostrarcantidadDetaNotaCredito=true;
	public Boolean activarcantidadDetaNotaCredito=true;

	public Border resaltarprecioDetaNotaCredito=null;
	public Boolean mostrarprecioDetaNotaCredito=true;
	public Boolean activarprecioDetaNotaCredito=true;

	public Border resaltarmontoDetaNotaCredito=null;
	public Boolean mostrarmontoDetaNotaCredito=true;
	public Boolean activarmontoDetaNotaCredito=true;

	public Border resaltarcostoDetaNotaCredito=null;
	public Boolean mostrarcostoDetaNotaCredito=true;
	public Boolean activarcostoDetaNotaCredito=true;

	public Border resaltardescuentoDetaNotaCredito=null;
	public Boolean mostrardescuentoDetaNotaCredito=true;
	public Boolean activardescuentoDetaNotaCredito=true;

	public Border resaltardescuento2DetaNotaCredito=null;
	public Boolean mostrardescuento2DetaNotaCredito=true;
	public Boolean activardescuento2DetaNotaCredito=true;

	public Border resaltarimpuestoDetaNotaCredito=null;
	public Boolean mostrarimpuestoDetaNotaCredito=true;
	public Boolean activarimpuestoDetaNotaCredito=true;

	public Border resaltarporcen_ivaDetaNotaCredito=null;
	public Boolean mostrarporcen_ivaDetaNotaCredito=true;
	public Boolean activarporcen_ivaDetaNotaCredito=true;

	public Border resaltarporcen_descuenDetaNotaCredito=null;
	public Boolean mostrarporcen_descuenDetaNotaCredito=true;
	public Boolean activarporcen_descuenDetaNotaCredito=true;

	public Border resaltarporcen_iceDetaNotaCredito=null;
	public Boolean mostrarporcen_iceDetaNotaCredito=true;
	public Boolean activarporcen_iceDetaNotaCredito=true;

	public Border resaltarsub_totalDetaNotaCredito=null;
	public Boolean mostrarsub_totalDetaNotaCredito=true;
	public Boolean activarsub_totalDetaNotaCredito=true;

	public Border resaltartotalDetaNotaCredito=null;
	public Boolean mostrartotalDetaNotaCredito=true;
	public Boolean activartotalDetaNotaCredito=true;

	public Border resaltarid_centro_costoDetaNotaCredito=null;
	public Boolean mostrarid_centro_costoDetaNotaCredito=true;
	public Boolean activarid_centro_costoDetaNotaCredito=true;
	public Boolean cargarid_centro_costoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_empaqueDetaNotaCredito=null;
	public Boolean mostrarid_empaqueDetaNotaCredito=true;
	public Boolean activarid_empaqueDetaNotaCredito=true;
	public Boolean cargarid_empaqueDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empaqueDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarincluye_impuestoDetaNotaCredito=null;
	public Boolean mostrarincluye_impuestoDetaNotaCredito=true;
	public Boolean activarincluye_impuestoDetaNotaCredito=true;

	public Border resaltarfecha_emisionDetaNotaCredito=null;
	public Boolean mostrarfecha_emisionDetaNotaCredito=true;
	public Boolean activarfecha_emisionDetaNotaCredito=false;

	public Border resaltarcodigo_loteDetaNotaCredito=null;
	public Boolean mostrarcodigo_loteDetaNotaCredito=true;
	public Boolean activarcodigo_loteDetaNotaCredito=true;

	public Border resaltarnumero_cajaDetaNotaCredito=null;
	public Boolean mostrarnumero_cajaDetaNotaCredito=true;
	public Boolean activarnumero_cajaDetaNotaCredito=true;

	
	

	public Border setResaltaridDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltaridDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetaNotaCredito() {
		return this.resaltaridDetaNotaCredito;
	}

	public void setResaltaridDetaNotaCredito(Border borderResaltar) {
		this.resaltaridDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostraridDetaNotaCredito() {
		return this.mostraridDetaNotaCredito;
	}

	public void setMostraridDetaNotaCredito(Boolean mostraridDetaNotaCredito) {
		this.mostraridDetaNotaCredito= mostraridDetaNotaCredito;
	}

	public Boolean getActivaridDetaNotaCredito() {
		return this.activaridDetaNotaCredito;
	}

	public void setActivaridDetaNotaCredito(Boolean activaridDetaNotaCredito) {
		this.activaridDetaNotaCredito= activaridDetaNotaCredito;
	}

	public Border setResaltarid_empresaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetaNotaCredito() {
		return this.resaltarid_empresaDetaNotaCredito;
	}

	public void setResaltarid_empresaDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_empresaDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetaNotaCredito() {
		return this.mostrarid_empresaDetaNotaCredito;
	}

	public void setMostrarid_empresaDetaNotaCredito(Boolean mostrarid_empresaDetaNotaCredito) {
		this.mostrarid_empresaDetaNotaCredito= mostrarid_empresaDetaNotaCredito;
	}

	public Boolean getActivarid_empresaDetaNotaCredito() {
		return this.activarid_empresaDetaNotaCredito;
	}

	public void setActivarid_empresaDetaNotaCredito(Boolean activarid_empresaDetaNotaCredito) {
		this.activarid_empresaDetaNotaCredito= activarid_empresaDetaNotaCredito;
	}

	public Boolean getCargarid_empresaDetaNotaCredito() {
		return this.cargarid_empresaDetaNotaCredito;
	}

	public void setCargarid_empresaDetaNotaCredito(Boolean cargarid_empresaDetaNotaCredito) {
		this.cargarid_empresaDetaNotaCredito= cargarid_empresaDetaNotaCredito;
	}

	public Border setResaltarid_sucursalDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetaNotaCredito() {
		return this.resaltarid_sucursalDetaNotaCredito;
	}

	public void setResaltarid_sucursalDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_sucursalDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetaNotaCredito() {
		return this.mostrarid_sucursalDetaNotaCredito;
	}

	public void setMostrarid_sucursalDetaNotaCredito(Boolean mostrarid_sucursalDetaNotaCredito) {
		this.mostrarid_sucursalDetaNotaCredito= mostrarid_sucursalDetaNotaCredito;
	}

	public Boolean getActivarid_sucursalDetaNotaCredito() {
		return this.activarid_sucursalDetaNotaCredito;
	}

	public void setActivarid_sucursalDetaNotaCredito(Boolean activarid_sucursalDetaNotaCredito) {
		this.activarid_sucursalDetaNotaCredito= activarid_sucursalDetaNotaCredito;
	}

	public Boolean getCargarid_sucursalDetaNotaCredito() {
		return this.cargarid_sucursalDetaNotaCredito;
	}

	public void setCargarid_sucursalDetaNotaCredito(Boolean cargarid_sucursalDetaNotaCredito) {
		this.cargarid_sucursalDetaNotaCredito= cargarid_sucursalDetaNotaCredito;
	}

	public Border setResaltarid_ejercicioDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetaNotaCredito() {
		return this.resaltarid_ejercicioDetaNotaCredito;
	}

	public void setResaltarid_ejercicioDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_ejercicioDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetaNotaCredito() {
		return this.mostrarid_ejercicioDetaNotaCredito;
	}

	public void setMostrarid_ejercicioDetaNotaCredito(Boolean mostrarid_ejercicioDetaNotaCredito) {
		this.mostrarid_ejercicioDetaNotaCredito= mostrarid_ejercicioDetaNotaCredito;
	}

	public Boolean getActivarid_ejercicioDetaNotaCredito() {
		return this.activarid_ejercicioDetaNotaCredito;
	}

	public void setActivarid_ejercicioDetaNotaCredito(Boolean activarid_ejercicioDetaNotaCredito) {
		this.activarid_ejercicioDetaNotaCredito= activarid_ejercicioDetaNotaCredito;
	}

	public Boolean getCargarid_ejercicioDetaNotaCredito() {
		return this.cargarid_ejercicioDetaNotaCredito;
	}

	public void setCargarid_ejercicioDetaNotaCredito(Boolean cargarid_ejercicioDetaNotaCredito) {
		this.cargarid_ejercicioDetaNotaCredito= cargarid_ejercicioDetaNotaCredito;
	}

	public Border setResaltarid_periodoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetaNotaCredito() {
		return this.resaltarid_periodoDetaNotaCredito;
	}

	public void setResaltarid_periodoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_periodoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetaNotaCredito() {
		return this.mostrarid_periodoDetaNotaCredito;
	}

	public void setMostrarid_periodoDetaNotaCredito(Boolean mostrarid_periodoDetaNotaCredito) {
		this.mostrarid_periodoDetaNotaCredito= mostrarid_periodoDetaNotaCredito;
	}

	public Boolean getActivarid_periodoDetaNotaCredito() {
		return this.activarid_periodoDetaNotaCredito;
	}

	public void setActivarid_periodoDetaNotaCredito(Boolean activarid_periodoDetaNotaCredito) {
		this.activarid_periodoDetaNotaCredito= activarid_periodoDetaNotaCredito;
	}

	public Boolean getCargarid_periodoDetaNotaCredito() {
		return this.cargarid_periodoDetaNotaCredito;
	}

	public void setCargarid_periodoDetaNotaCredito(Boolean cargarid_periodoDetaNotaCredito) {
		this.cargarid_periodoDetaNotaCredito= cargarid_periodoDetaNotaCredito;
	}

	public Border setResaltarid_anioDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_anioDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetaNotaCredito() {
		return this.resaltarid_anioDetaNotaCredito;
	}

	public void setResaltarid_anioDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_anioDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_anioDetaNotaCredito() {
		return this.mostrarid_anioDetaNotaCredito;
	}

	public void setMostrarid_anioDetaNotaCredito(Boolean mostrarid_anioDetaNotaCredito) {
		this.mostrarid_anioDetaNotaCredito= mostrarid_anioDetaNotaCredito;
	}

	public Boolean getActivarid_anioDetaNotaCredito() {
		return this.activarid_anioDetaNotaCredito;
	}

	public void setActivarid_anioDetaNotaCredito(Boolean activarid_anioDetaNotaCredito) {
		this.activarid_anioDetaNotaCredito= activarid_anioDetaNotaCredito;
	}

	public Boolean getCargarid_anioDetaNotaCredito() {
		return this.cargarid_anioDetaNotaCredito;
	}

	public void setCargarid_anioDetaNotaCredito(Boolean cargarid_anioDetaNotaCredito) {
		this.cargarid_anioDetaNotaCredito= cargarid_anioDetaNotaCredito;
	}

	public Border setResaltarid_mesDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_mesDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetaNotaCredito() {
		return this.resaltarid_mesDetaNotaCredito;
	}

	public void setResaltarid_mesDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_mesDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_mesDetaNotaCredito() {
		return this.mostrarid_mesDetaNotaCredito;
	}

	public void setMostrarid_mesDetaNotaCredito(Boolean mostrarid_mesDetaNotaCredito) {
		this.mostrarid_mesDetaNotaCredito= mostrarid_mesDetaNotaCredito;
	}

	public Boolean getActivarid_mesDetaNotaCredito() {
		return this.activarid_mesDetaNotaCredito;
	}

	public void setActivarid_mesDetaNotaCredito(Boolean activarid_mesDetaNotaCredito) {
		this.activarid_mesDetaNotaCredito= activarid_mesDetaNotaCredito;
	}

	public Boolean getCargarid_mesDetaNotaCredito() {
		return this.cargarid_mesDetaNotaCredito;
	}

	public void setCargarid_mesDetaNotaCredito(Boolean cargarid_mesDetaNotaCredito) {
		this.cargarid_mesDetaNotaCredito= cargarid_mesDetaNotaCredito;
	}

	public Border setResaltarid_nota_creditoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_nota_creditoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nota_creditoDetaNotaCredito() {
		return this.resaltarid_nota_creditoDetaNotaCredito;
	}

	public void setResaltarid_nota_creditoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_nota_creditoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_nota_creditoDetaNotaCredito() {
		return this.mostrarid_nota_creditoDetaNotaCredito;
	}

	public void setMostrarid_nota_creditoDetaNotaCredito(Boolean mostrarid_nota_creditoDetaNotaCredito) {
		this.mostrarid_nota_creditoDetaNotaCredito= mostrarid_nota_creditoDetaNotaCredito;
	}

	public Boolean getActivarid_nota_creditoDetaNotaCredito() {
		return this.activarid_nota_creditoDetaNotaCredito;
	}

	public void setActivarid_nota_creditoDetaNotaCredito(Boolean activarid_nota_creditoDetaNotaCredito) {
		this.activarid_nota_creditoDetaNotaCredito= activarid_nota_creditoDetaNotaCredito;
	}

	public Boolean getCargarid_nota_creditoDetaNotaCredito() {
		return this.cargarid_nota_creditoDetaNotaCredito;
	}

	public void setCargarid_nota_creditoDetaNotaCredito(Boolean cargarid_nota_creditoDetaNotaCredito) {
		this.cargarid_nota_creditoDetaNotaCredito= cargarid_nota_creditoDetaNotaCredito;
	}

	public Border setResaltarid_bodegaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetaNotaCredito() {
		return this.resaltarid_bodegaDetaNotaCredito;
	}

	public void setResaltarid_bodegaDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_bodegaDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetaNotaCredito() {
		return this.mostrarid_bodegaDetaNotaCredito;
	}

	public void setMostrarid_bodegaDetaNotaCredito(Boolean mostrarid_bodegaDetaNotaCredito) {
		this.mostrarid_bodegaDetaNotaCredito= mostrarid_bodegaDetaNotaCredito;
	}

	public Boolean getActivarid_bodegaDetaNotaCredito() {
		return this.activarid_bodegaDetaNotaCredito;
	}

	public void setActivarid_bodegaDetaNotaCredito(Boolean activarid_bodegaDetaNotaCredito) {
		this.activarid_bodegaDetaNotaCredito= activarid_bodegaDetaNotaCredito;
	}

	public Boolean getCargarid_bodegaDetaNotaCredito() {
		return this.cargarid_bodegaDetaNotaCredito;
	}

	public void setCargarid_bodegaDetaNotaCredito(Boolean cargarid_bodegaDetaNotaCredito) {
		this.cargarid_bodegaDetaNotaCredito= cargarid_bodegaDetaNotaCredito;
	}

	public Border setResaltarid_productoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_productoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetaNotaCredito() {
		return this.resaltarid_productoDetaNotaCredito;
	}

	public void setResaltarid_productoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_productoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_productoDetaNotaCredito() {
		return this.mostrarid_productoDetaNotaCredito;
	}

	public void setMostrarid_productoDetaNotaCredito(Boolean mostrarid_productoDetaNotaCredito) {
		this.mostrarid_productoDetaNotaCredito= mostrarid_productoDetaNotaCredito;
	}

	public Boolean getActivarid_productoDetaNotaCredito() {
		return this.activarid_productoDetaNotaCredito;
	}

	public void setActivarid_productoDetaNotaCredito(Boolean activarid_productoDetaNotaCredito) {
		this.activarid_productoDetaNotaCredito= activarid_productoDetaNotaCredito;
	}

	public Boolean getCargarid_productoDetaNotaCredito() {
		return this.cargarid_productoDetaNotaCredito;
	}

	public void setCargarid_productoDetaNotaCredito(Boolean cargarid_productoDetaNotaCredito) {
		this.cargarid_productoDetaNotaCredito= cargarid_productoDetaNotaCredito;
	}

	public Border setResaltarid_unidadDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetaNotaCredito() {
		return this.resaltarid_unidadDetaNotaCredito;
	}

	public void setResaltarid_unidadDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_unidadDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetaNotaCredito() {
		return this.mostrarid_unidadDetaNotaCredito;
	}

	public void setMostrarid_unidadDetaNotaCredito(Boolean mostrarid_unidadDetaNotaCredito) {
		this.mostrarid_unidadDetaNotaCredito= mostrarid_unidadDetaNotaCredito;
	}

	public Boolean getActivarid_unidadDetaNotaCredito() {
		return this.activarid_unidadDetaNotaCredito;
	}

	public void setActivarid_unidadDetaNotaCredito(Boolean activarid_unidadDetaNotaCredito) {
		this.activarid_unidadDetaNotaCredito= activarid_unidadDetaNotaCredito;
	}

	public Boolean getCargarid_unidadDetaNotaCredito() {
		return this.cargarid_unidadDetaNotaCredito;
	}

	public void setCargarid_unidadDetaNotaCredito(Boolean cargarid_unidadDetaNotaCredito) {
		this.cargarid_unidadDetaNotaCredito= cargarid_unidadDetaNotaCredito;
	}

	public Border setResaltarid_tipo_deta_nota_creditoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_deta_nota_creditoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_deta_nota_creditoDetaNotaCredito() {
		return this.resaltarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public void setResaltarid_tipo_deta_nota_creditoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_tipo_deta_nota_creditoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_deta_nota_creditoDetaNotaCredito() {
		return this.mostrarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public void setMostrarid_tipo_deta_nota_creditoDetaNotaCredito(Boolean mostrarid_tipo_deta_nota_creditoDetaNotaCredito) {
		this.mostrarid_tipo_deta_nota_creditoDetaNotaCredito= mostrarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public Boolean getActivarid_tipo_deta_nota_creditoDetaNotaCredito() {
		return this.activarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public void setActivarid_tipo_deta_nota_creditoDetaNotaCredito(Boolean activarid_tipo_deta_nota_creditoDetaNotaCredito) {
		this.activarid_tipo_deta_nota_creditoDetaNotaCredito= activarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public Boolean getCargarid_tipo_deta_nota_creditoDetaNotaCredito() {
		return this.cargarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public void setCargarid_tipo_deta_nota_creditoDetaNotaCredito(Boolean cargarid_tipo_deta_nota_creditoDetaNotaCredito) {
		this.cargarid_tipo_deta_nota_creditoDetaNotaCredito= cargarid_tipo_deta_nota_creditoDetaNotaCredito;
	}

	public Border setResaltarid_tipo_devolucion_empresaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_devolucion_empresaDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_devolucion_empresaDetaNotaCredito() {
		return this.resaltarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public void setResaltarid_tipo_devolucion_empresaDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_tipo_devolucion_empresaDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_devolucion_empresaDetaNotaCredito() {
		return this.mostrarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public void setMostrarid_tipo_devolucion_empresaDetaNotaCredito(Boolean mostrarid_tipo_devolucion_empresaDetaNotaCredito) {
		this.mostrarid_tipo_devolucion_empresaDetaNotaCredito= mostrarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public Boolean getActivarid_tipo_devolucion_empresaDetaNotaCredito() {
		return this.activarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public void setActivarid_tipo_devolucion_empresaDetaNotaCredito(Boolean activarid_tipo_devolucion_empresaDetaNotaCredito) {
		this.activarid_tipo_devolucion_empresaDetaNotaCredito= activarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public Boolean getCargarid_tipo_devolucion_empresaDetaNotaCredito() {
		return this.cargarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public void setCargarid_tipo_devolucion_empresaDetaNotaCredito(Boolean cargarid_tipo_devolucion_empresaDetaNotaCredito) {
		this.cargarid_tipo_devolucion_empresaDetaNotaCredito= cargarid_tipo_devolucion_empresaDetaNotaCredito;
	}

	public Border setResaltardescripcionDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescripcionDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetaNotaCredito() {
		return this.resaltardescripcionDetaNotaCredito;
	}

	public void setResaltardescripcionDetaNotaCredito(Border borderResaltar) {
		this.resaltardescripcionDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescripcionDetaNotaCredito() {
		return this.mostrardescripcionDetaNotaCredito;
	}

	public void setMostrardescripcionDetaNotaCredito(Boolean mostrardescripcionDetaNotaCredito) {
		this.mostrardescripcionDetaNotaCredito= mostrardescripcionDetaNotaCredito;
	}

	public Boolean getActivardescripcionDetaNotaCredito() {
		return this.activardescripcionDetaNotaCredito;
	}

	public void setActivardescripcionDetaNotaCredito(Boolean activardescripcionDetaNotaCredito) {
		this.activardescripcionDetaNotaCredito= activardescripcionDetaNotaCredito;
	}

	public Border setResaltarcantidadDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcantidadDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetaNotaCredito() {
		return this.resaltarcantidadDetaNotaCredito;
	}

	public void setResaltarcantidadDetaNotaCredito(Border borderResaltar) {
		this.resaltarcantidadDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcantidadDetaNotaCredito() {
		return this.mostrarcantidadDetaNotaCredito;
	}

	public void setMostrarcantidadDetaNotaCredito(Boolean mostrarcantidadDetaNotaCredito) {
		this.mostrarcantidadDetaNotaCredito= mostrarcantidadDetaNotaCredito;
	}

	public Boolean getActivarcantidadDetaNotaCredito() {
		return this.activarcantidadDetaNotaCredito;
	}

	public void setActivarcantidadDetaNotaCredito(Boolean activarcantidadDetaNotaCredito) {
		this.activarcantidadDetaNotaCredito= activarcantidadDetaNotaCredito;
	}

	public Border setResaltarprecioDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarprecioDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetaNotaCredito() {
		return this.resaltarprecioDetaNotaCredito;
	}

	public void setResaltarprecioDetaNotaCredito(Border borderResaltar) {
		this.resaltarprecioDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarprecioDetaNotaCredito() {
		return this.mostrarprecioDetaNotaCredito;
	}

	public void setMostrarprecioDetaNotaCredito(Boolean mostrarprecioDetaNotaCredito) {
		this.mostrarprecioDetaNotaCredito= mostrarprecioDetaNotaCredito;
	}

	public Boolean getActivarprecioDetaNotaCredito() {
		return this.activarprecioDetaNotaCredito;
	}

	public void setActivarprecioDetaNotaCredito(Boolean activarprecioDetaNotaCredito) {
		this.activarprecioDetaNotaCredito= activarprecioDetaNotaCredito;
	}

	public Border setResaltarmontoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarmontoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoDetaNotaCredito() {
		return this.resaltarmontoDetaNotaCredito;
	}

	public void setResaltarmontoDetaNotaCredito(Border borderResaltar) {
		this.resaltarmontoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarmontoDetaNotaCredito() {
		return this.mostrarmontoDetaNotaCredito;
	}

	public void setMostrarmontoDetaNotaCredito(Boolean mostrarmontoDetaNotaCredito) {
		this.mostrarmontoDetaNotaCredito= mostrarmontoDetaNotaCredito;
	}

	public Boolean getActivarmontoDetaNotaCredito() {
		return this.activarmontoDetaNotaCredito;
	}

	public void setActivarmontoDetaNotaCredito(Boolean activarmontoDetaNotaCredito) {
		this.activarmontoDetaNotaCredito= activarmontoDetaNotaCredito;
	}

	public Border setResaltarcostoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcostoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetaNotaCredito() {
		return this.resaltarcostoDetaNotaCredito;
	}

	public void setResaltarcostoDetaNotaCredito(Border borderResaltar) {
		this.resaltarcostoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcostoDetaNotaCredito() {
		return this.mostrarcostoDetaNotaCredito;
	}

	public void setMostrarcostoDetaNotaCredito(Boolean mostrarcostoDetaNotaCredito) {
		this.mostrarcostoDetaNotaCredito= mostrarcostoDetaNotaCredito;
	}

	public Boolean getActivarcostoDetaNotaCredito() {
		return this.activarcostoDetaNotaCredito;
	}

	public void setActivarcostoDetaNotaCredito(Boolean activarcostoDetaNotaCredito) {
		this.activarcostoDetaNotaCredito= activarcostoDetaNotaCredito;
	}

	public Border setResaltardescuentoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescuentoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoDetaNotaCredito() {
		return this.resaltardescuentoDetaNotaCredito;
	}

	public void setResaltardescuentoDetaNotaCredito(Border borderResaltar) {
		this.resaltardescuentoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescuentoDetaNotaCredito() {
		return this.mostrardescuentoDetaNotaCredito;
	}

	public void setMostrardescuentoDetaNotaCredito(Boolean mostrardescuentoDetaNotaCredito) {
		this.mostrardescuentoDetaNotaCredito= mostrardescuentoDetaNotaCredito;
	}

	public Boolean getActivardescuentoDetaNotaCredito() {
		return this.activardescuentoDetaNotaCredito;
	}

	public void setActivardescuentoDetaNotaCredito(Boolean activardescuentoDetaNotaCredito) {
		this.activardescuentoDetaNotaCredito= activardescuentoDetaNotaCredito;
	}

	public Border setResaltardescuento2DetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescuento2DetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2DetaNotaCredito() {
		return this.resaltardescuento2DetaNotaCredito;
	}

	public void setResaltardescuento2DetaNotaCredito(Border borderResaltar) {
		this.resaltardescuento2DetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescuento2DetaNotaCredito() {
		return this.mostrardescuento2DetaNotaCredito;
	}

	public void setMostrardescuento2DetaNotaCredito(Boolean mostrardescuento2DetaNotaCredito) {
		this.mostrardescuento2DetaNotaCredito= mostrardescuento2DetaNotaCredito;
	}

	public Boolean getActivardescuento2DetaNotaCredito() {
		return this.activardescuento2DetaNotaCredito;
	}

	public void setActivardescuento2DetaNotaCredito(Boolean activardescuento2DetaNotaCredito) {
		this.activardescuento2DetaNotaCredito= activardescuento2DetaNotaCredito;
	}

	public Border setResaltarimpuestoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarimpuestoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoDetaNotaCredito() {
		return this.resaltarimpuestoDetaNotaCredito;
	}

	public void setResaltarimpuestoDetaNotaCredito(Border borderResaltar) {
		this.resaltarimpuestoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarimpuestoDetaNotaCredito() {
		return this.mostrarimpuestoDetaNotaCredito;
	}

	public void setMostrarimpuestoDetaNotaCredito(Boolean mostrarimpuestoDetaNotaCredito) {
		this.mostrarimpuestoDetaNotaCredito= mostrarimpuestoDetaNotaCredito;
	}

	public Boolean getActivarimpuestoDetaNotaCredito() {
		return this.activarimpuestoDetaNotaCredito;
	}

	public void setActivarimpuestoDetaNotaCredito(Boolean activarimpuestoDetaNotaCredito) {
		this.activarimpuestoDetaNotaCredito= activarimpuestoDetaNotaCredito;
	}

	public Border setResaltarporcen_ivaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarporcen_ivaDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_ivaDetaNotaCredito() {
		return this.resaltarporcen_ivaDetaNotaCredito;
	}

	public void setResaltarporcen_ivaDetaNotaCredito(Border borderResaltar) {
		this.resaltarporcen_ivaDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarporcen_ivaDetaNotaCredito() {
		return this.mostrarporcen_ivaDetaNotaCredito;
	}

	public void setMostrarporcen_ivaDetaNotaCredito(Boolean mostrarporcen_ivaDetaNotaCredito) {
		this.mostrarporcen_ivaDetaNotaCredito= mostrarporcen_ivaDetaNotaCredito;
	}

	public Boolean getActivarporcen_ivaDetaNotaCredito() {
		return this.activarporcen_ivaDetaNotaCredito;
	}

	public void setActivarporcen_ivaDetaNotaCredito(Boolean activarporcen_ivaDetaNotaCredito) {
		this.activarporcen_ivaDetaNotaCredito= activarporcen_ivaDetaNotaCredito;
	}

	public Border setResaltarporcen_descuenDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarporcen_descuenDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_descuenDetaNotaCredito() {
		return this.resaltarporcen_descuenDetaNotaCredito;
	}

	public void setResaltarporcen_descuenDetaNotaCredito(Border borderResaltar) {
		this.resaltarporcen_descuenDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarporcen_descuenDetaNotaCredito() {
		return this.mostrarporcen_descuenDetaNotaCredito;
	}

	public void setMostrarporcen_descuenDetaNotaCredito(Boolean mostrarporcen_descuenDetaNotaCredito) {
		this.mostrarporcen_descuenDetaNotaCredito= mostrarporcen_descuenDetaNotaCredito;
	}

	public Boolean getActivarporcen_descuenDetaNotaCredito() {
		return this.activarporcen_descuenDetaNotaCredito;
	}

	public void setActivarporcen_descuenDetaNotaCredito(Boolean activarporcen_descuenDetaNotaCredito) {
		this.activarporcen_descuenDetaNotaCredito= activarporcen_descuenDetaNotaCredito;
	}

	public Border setResaltarporcen_iceDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarporcen_iceDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_iceDetaNotaCredito() {
		return this.resaltarporcen_iceDetaNotaCredito;
	}

	public void setResaltarporcen_iceDetaNotaCredito(Border borderResaltar) {
		this.resaltarporcen_iceDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarporcen_iceDetaNotaCredito() {
		return this.mostrarporcen_iceDetaNotaCredito;
	}

	public void setMostrarporcen_iceDetaNotaCredito(Boolean mostrarporcen_iceDetaNotaCredito) {
		this.mostrarporcen_iceDetaNotaCredito= mostrarporcen_iceDetaNotaCredito;
	}

	public Boolean getActivarporcen_iceDetaNotaCredito() {
		return this.activarporcen_iceDetaNotaCredito;
	}

	public void setActivarporcen_iceDetaNotaCredito(Boolean activarporcen_iceDetaNotaCredito) {
		this.activarporcen_iceDetaNotaCredito= activarporcen_iceDetaNotaCredito;
	}

	public Border setResaltarsub_totalDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarsub_totalDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalDetaNotaCredito() {
		return this.resaltarsub_totalDetaNotaCredito;
	}

	public void setResaltarsub_totalDetaNotaCredito(Border borderResaltar) {
		this.resaltarsub_totalDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarsub_totalDetaNotaCredito() {
		return this.mostrarsub_totalDetaNotaCredito;
	}

	public void setMostrarsub_totalDetaNotaCredito(Boolean mostrarsub_totalDetaNotaCredito) {
		this.mostrarsub_totalDetaNotaCredito= mostrarsub_totalDetaNotaCredito;
	}

	public Boolean getActivarsub_totalDetaNotaCredito() {
		return this.activarsub_totalDetaNotaCredito;
	}

	public void setActivarsub_totalDetaNotaCredito(Boolean activarsub_totalDetaNotaCredito) {
		this.activarsub_totalDetaNotaCredito= activarsub_totalDetaNotaCredito;
	}

	public Border setResaltartotalDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltartotalDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetaNotaCredito() {
		return this.resaltartotalDetaNotaCredito;
	}

	public void setResaltartotalDetaNotaCredito(Border borderResaltar) {
		this.resaltartotalDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrartotalDetaNotaCredito() {
		return this.mostrartotalDetaNotaCredito;
	}

	public void setMostrartotalDetaNotaCredito(Boolean mostrartotalDetaNotaCredito) {
		this.mostrartotalDetaNotaCredito= mostrartotalDetaNotaCredito;
	}

	public Boolean getActivartotalDetaNotaCredito() {
		return this.activartotalDetaNotaCredito;
	}

	public void setActivartotalDetaNotaCredito(Boolean activartotalDetaNotaCredito) {
		this.activartotalDetaNotaCredito= activartotalDetaNotaCredito;
	}

	public Border setResaltarid_centro_costoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetaNotaCredito() {
		return this.resaltarid_centro_costoDetaNotaCredito;
	}

	public void setResaltarid_centro_costoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_centro_costoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetaNotaCredito() {
		return this.mostrarid_centro_costoDetaNotaCredito;
	}

	public void setMostrarid_centro_costoDetaNotaCredito(Boolean mostrarid_centro_costoDetaNotaCredito) {
		this.mostrarid_centro_costoDetaNotaCredito= mostrarid_centro_costoDetaNotaCredito;
	}

	public Boolean getActivarid_centro_costoDetaNotaCredito() {
		return this.activarid_centro_costoDetaNotaCredito;
	}

	public void setActivarid_centro_costoDetaNotaCredito(Boolean activarid_centro_costoDetaNotaCredito) {
		this.activarid_centro_costoDetaNotaCredito= activarid_centro_costoDetaNotaCredito;
	}

	public Boolean getCargarid_centro_costoDetaNotaCredito() {
		return this.cargarid_centro_costoDetaNotaCredito;
	}

	public void setCargarid_centro_costoDetaNotaCredito(Boolean cargarid_centro_costoDetaNotaCredito) {
		this.cargarid_centro_costoDetaNotaCredito= cargarid_centro_costoDetaNotaCredito;
	}

	public Border setResaltarid_empaqueDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empaqueDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empaqueDetaNotaCredito() {
		return this.resaltarid_empaqueDetaNotaCredito;
	}

	public void setResaltarid_empaqueDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_empaqueDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empaqueDetaNotaCredito() {
		return this.mostrarid_empaqueDetaNotaCredito;
	}

	public void setMostrarid_empaqueDetaNotaCredito(Boolean mostrarid_empaqueDetaNotaCredito) {
		this.mostrarid_empaqueDetaNotaCredito= mostrarid_empaqueDetaNotaCredito;
	}

	public Boolean getActivarid_empaqueDetaNotaCredito() {
		return this.activarid_empaqueDetaNotaCredito;
	}

	public void setActivarid_empaqueDetaNotaCredito(Boolean activarid_empaqueDetaNotaCredito) {
		this.activarid_empaqueDetaNotaCredito= activarid_empaqueDetaNotaCredito;
	}

	public Boolean getCargarid_empaqueDetaNotaCredito() {
		return this.cargarid_empaqueDetaNotaCredito;
	}

	public void setCargarid_empaqueDetaNotaCredito(Boolean cargarid_empaqueDetaNotaCredito) {
		this.cargarid_empaqueDetaNotaCredito= cargarid_empaqueDetaNotaCredito;
	}

	public Border setResaltarincluye_impuestoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarincluye_impuestoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarincluye_impuestoDetaNotaCredito() {
		return this.resaltarincluye_impuestoDetaNotaCredito;
	}

	public void setResaltarincluye_impuestoDetaNotaCredito(Border borderResaltar) {
		this.resaltarincluye_impuestoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarincluye_impuestoDetaNotaCredito() {
		return this.mostrarincluye_impuestoDetaNotaCredito;
	}

	public void setMostrarincluye_impuestoDetaNotaCredito(Boolean mostrarincluye_impuestoDetaNotaCredito) {
		this.mostrarincluye_impuestoDetaNotaCredito= mostrarincluye_impuestoDetaNotaCredito;
	}

	public Boolean getActivarincluye_impuestoDetaNotaCredito() {
		return this.activarincluye_impuestoDetaNotaCredito;
	}

	public void setActivarincluye_impuestoDetaNotaCredito(Boolean activarincluye_impuestoDetaNotaCredito) {
		this.activarincluye_impuestoDetaNotaCredito= activarincluye_impuestoDetaNotaCredito;
	}

	public Border setResaltarfecha_emisionDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetaNotaCredito() {
		return this.resaltarfecha_emisionDetaNotaCredito;
	}

	public void setResaltarfecha_emisionDetaNotaCredito(Border borderResaltar) {
		this.resaltarfecha_emisionDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetaNotaCredito() {
		return this.mostrarfecha_emisionDetaNotaCredito;
	}

	public void setMostrarfecha_emisionDetaNotaCredito(Boolean mostrarfecha_emisionDetaNotaCredito) {
		this.mostrarfecha_emisionDetaNotaCredito= mostrarfecha_emisionDetaNotaCredito;
	}

	public Boolean getActivarfecha_emisionDetaNotaCredito() {
		return this.activarfecha_emisionDetaNotaCredito;
	}

	public void setActivarfecha_emisionDetaNotaCredito(Boolean activarfecha_emisionDetaNotaCredito) {
		this.activarfecha_emisionDetaNotaCredito= activarfecha_emisionDetaNotaCredito;
	}

	public Border setResaltarcodigo_loteDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcodigo_loteDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_loteDetaNotaCredito() {
		return this.resaltarcodigo_loteDetaNotaCredito;
	}

	public void setResaltarcodigo_loteDetaNotaCredito(Border borderResaltar) {
		this.resaltarcodigo_loteDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcodigo_loteDetaNotaCredito() {
		return this.mostrarcodigo_loteDetaNotaCredito;
	}

	public void setMostrarcodigo_loteDetaNotaCredito(Boolean mostrarcodigo_loteDetaNotaCredito) {
		this.mostrarcodigo_loteDetaNotaCredito= mostrarcodigo_loteDetaNotaCredito;
	}

	public Boolean getActivarcodigo_loteDetaNotaCredito() {
		return this.activarcodigo_loteDetaNotaCredito;
	}

	public void setActivarcodigo_loteDetaNotaCredito(Boolean activarcodigo_loteDetaNotaCredito) {
		this.activarcodigo_loteDetaNotaCredito= activarcodigo_loteDetaNotaCredito;
	}

	public Border setResaltarnumero_cajaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detanotacreditoBeanSwingJInternalFrame.jTtoolBarDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarnumero_cajaDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cajaDetaNotaCredito() {
		return this.resaltarnumero_cajaDetaNotaCredito;
	}

	public void setResaltarnumero_cajaDetaNotaCredito(Border borderResaltar) {
		this.resaltarnumero_cajaDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarnumero_cajaDetaNotaCredito() {
		return this.mostrarnumero_cajaDetaNotaCredito;
	}

	public void setMostrarnumero_cajaDetaNotaCredito(Boolean mostrarnumero_cajaDetaNotaCredito) {
		this.mostrarnumero_cajaDetaNotaCredito= mostrarnumero_cajaDetaNotaCredito;
	}

	public Boolean getActivarnumero_cajaDetaNotaCredito() {
		return this.activarnumero_cajaDetaNotaCredito;
	}

	public void setActivarnumero_cajaDetaNotaCredito(Boolean activarnumero_cajaDetaNotaCredito) {
		this.activarnumero_cajaDetaNotaCredito= activarnumero_cajaDetaNotaCredito;
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
		
		
		this.setMostraridDetaNotaCredito(esInicial);
		this.setMostrarid_empresaDetaNotaCredito(esInicial);
		this.setMostrarid_sucursalDetaNotaCredito(esInicial);
		this.setMostrarid_ejercicioDetaNotaCredito(esInicial);
		this.setMostrarid_periodoDetaNotaCredito(esInicial);
		this.setMostrarid_anioDetaNotaCredito(esInicial);
		this.setMostrarid_mesDetaNotaCredito(esInicial);
		this.setMostrarid_nota_creditoDetaNotaCredito(esInicial);
		this.setMostrarid_bodegaDetaNotaCredito(esInicial);
		this.setMostrarid_productoDetaNotaCredito(esInicial);
		this.setMostrarid_unidadDetaNotaCredito(esInicial);
		this.setMostrarid_tipo_deta_nota_creditoDetaNotaCredito(esInicial);
		this.setMostrarid_tipo_devolucion_empresaDetaNotaCredito(esInicial);
		this.setMostrardescripcionDetaNotaCredito(esInicial);
		this.setMostrarcantidadDetaNotaCredito(esInicial);
		this.setMostrarprecioDetaNotaCredito(esInicial);
		this.setMostrarmontoDetaNotaCredito(esInicial);
		this.setMostrarcostoDetaNotaCredito(esInicial);
		this.setMostrardescuentoDetaNotaCredito(esInicial);
		this.setMostrardescuento2DetaNotaCredito(esInicial);
		this.setMostrarimpuestoDetaNotaCredito(esInicial);
		this.setMostrarporcen_ivaDetaNotaCredito(esInicial);
		this.setMostrarporcen_descuenDetaNotaCredito(esInicial);
		this.setMostrarporcen_iceDetaNotaCredito(esInicial);
		this.setMostrarsub_totalDetaNotaCredito(esInicial);
		this.setMostrartotalDetaNotaCredito(esInicial);
		this.setMostrarid_centro_costoDetaNotaCredito(esInicial);
		this.setMostrarid_empaqueDetaNotaCredito(esInicial);
		this.setMostrarincluye_impuestoDetaNotaCredito(esInicial);
		this.setMostrarfecha_emisionDetaNotaCredito(esInicial);
		this.setMostrarcodigo_loteDetaNotaCredito(esInicial);
		this.setMostrarnumero_cajaDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.ID)) {
				this.setMostraridDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDNOTACREDITO)) {
				this.setMostrarid_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO)) {
				this.setMostrarid_tipo_deta_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setMostrarid_tipo_devolucion_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.MONTO)) {
				this.setMostrarmontoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2DetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENIVA)) {
				this.setMostrarporcen_ivaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENDESCUEN)) {
				this.setMostrarporcen_descuenDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENICE)) {
				this.setMostrarporcen_iceDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPAQUE)) {
				this.setMostrarid_empaqueDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setMostrarincluye_impuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CODIGOLOTE)) {
				this.setMostrarcodigo_loteDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.NUMEROCAJA)) {
				this.setMostrarnumero_cajaDetaNotaCredito(esAsigna);
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
		
		
		this.setActivaridDetaNotaCredito(esInicial);
		this.setActivarid_empresaDetaNotaCredito(esInicial);
		this.setActivarid_sucursalDetaNotaCredito(esInicial);
		this.setActivarid_ejercicioDetaNotaCredito(esInicial);
		this.setActivarid_periodoDetaNotaCredito(esInicial);
		this.setActivarid_anioDetaNotaCredito(esInicial);
		this.setActivarid_mesDetaNotaCredito(esInicial);
		this.setActivarid_nota_creditoDetaNotaCredito(esInicial);
		this.setActivarid_bodegaDetaNotaCredito(esInicial);
		this.setActivarid_productoDetaNotaCredito(esInicial);
		this.setActivarid_unidadDetaNotaCredito(esInicial);
		this.setActivarid_tipo_deta_nota_creditoDetaNotaCredito(esInicial);
		this.setActivarid_tipo_devolucion_empresaDetaNotaCredito(esInicial);
		this.setActivardescripcionDetaNotaCredito(esInicial);
		this.setActivarcantidadDetaNotaCredito(esInicial);
		this.setActivarprecioDetaNotaCredito(esInicial);
		this.setActivarmontoDetaNotaCredito(esInicial);
		this.setActivarcostoDetaNotaCredito(esInicial);
		this.setActivardescuentoDetaNotaCredito(esInicial);
		this.setActivardescuento2DetaNotaCredito(esInicial);
		this.setActivarimpuestoDetaNotaCredito(esInicial);
		this.setActivarporcen_ivaDetaNotaCredito(esInicial);
		this.setActivarporcen_descuenDetaNotaCredito(esInicial);
		this.setActivarporcen_iceDetaNotaCredito(esInicial);
		this.setActivarsub_totalDetaNotaCredito(esInicial);
		this.setActivartotalDetaNotaCredito(esInicial);
		this.setActivarid_centro_costoDetaNotaCredito(esInicial);
		this.setActivarid_empaqueDetaNotaCredito(esInicial);
		this.setActivarincluye_impuestoDetaNotaCredito(esInicial);
		this.setActivarfecha_emisionDetaNotaCredito(esInicial);
		this.setActivarcodigo_loteDetaNotaCredito(esInicial);
		this.setActivarnumero_cajaDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.ID)) {
				this.setActivaridDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDNOTACREDITO)) {
				this.setActivarid_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO)) {
				this.setActivarid_tipo_deta_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setActivarid_tipo_devolucion_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.MONTO)) {
				this.setActivarmontoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.COSTO)) {
				this.setActivarcostoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2DetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENIVA)) {
				this.setActivarporcen_ivaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENDESCUEN)) {
				this.setActivarporcen_descuenDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENICE)) {
				this.setActivarporcen_iceDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.TOTAL)) {
				this.setActivartotalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPAQUE)) {
				this.setActivarid_empaqueDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setActivarincluye_impuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CODIGOLOTE)) {
				this.setActivarcodigo_loteDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.NUMEROCAJA)) {
				this.setActivarnumero_cajaDetaNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetaNotaCredito(esInicial);
		this.setResaltarid_empresaDetaNotaCredito(esInicial);
		this.setResaltarid_sucursalDetaNotaCredito(esInicial);
		this.setResaltarid_ejercicioDetaNotaCredito(esInicial);
		this.setResaltarid_periodoDetaNotaCredito(esInicial);
		this.setResaltarid_anioDetaNotaCredito(esInicial);
		this.setResaltarid_mesDetaNotaCredito(esInicial);
		this.setResaltarid_nota_creditoDetaNotaCredito(esInicial);
		this.setResaltarid_bodegaDetaNotaCredito(esInicial);
		this.setResaltarid_productoDetaNotaCredito(esInicial);
		this.setResaltarid_unidadDetaNotaCredito(esInicial);
		this.setResaltarid_tipo_deta_nota_creditoDetaNotaCredito(esInicial);
		this.setResaltarid_tipo_devolucion_empresaDetaNotaCredito(esInicial);
		this.setResaltardescripcionDetaNotaCredito(esInicial);
		this.setResaltarcantidadDetaNotaCredito(esInicial);
		this.setResaltarprecioDetaNotaCredito(esInicial);
		this.setResaltarmontoDetaNotaCredito(esInicial);
		this.setResaltarcostoDetaNotaCredito(esInicial);
		this.setResaltardescuentoDetaNotaCredito(esInicial);
		this.setResaltardescuento2DetaNotaCredito(esInicial);
		this.setResaltarimpuestoDetaNotaCredito(esInicial);
		this.setResaltarporcen_ivaDetaNotaCredito(esInicial);
		this.setResaltarporcen_descuenDetaNotaCredito(esInicial);
		this.setResaltarporcen_iceDetaNotaCredito(esInicial);
		this.setResaltarsub_totalDetaNotaCredito(esInicial);
		this.setResaltartotalDetaNotaCredito(esInicial);
		this.setResaltarid_centro_costoDetaNotaCredito(esInicial);
		this.setResaltarid_empaqueDetaNotaCredito(esInicial);
		this.setResaltarincluye_impuestoDetaNotaCredito(esInicial);
		this.setResaltarfecha_emisionDetaNotaCredito(esInicial);
		this.setResaltarcodigo_loteDetaNotaCredito(esInicial);
		this.setResaltarnumero_cajaDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.ID)) {
				this.setResaltaridDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDNOTACREDITO)) {
				this.setResaltarid_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO)) {
				this.setResaltarid_tipo_deta_nota_creditoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setResaltarid_tipo_devolucion_empresaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.MONTO)) {
				this.setResaltarmontoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2DetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENIVA)) {
				this.setResaltarporcen_ivaDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENDESCUEN)) {
				this.setResaltarporcen_descuenDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.PORCENICE)) {
				this.setResaltarporcen_iceDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.IDEMPAQUE)) {
				this.setResaltarid_empaqueDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO)) {
				this.setResaltarincluye_impuestoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.CODIGOLOTE)) {
				this.setResaltarcodigo_loteDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaNotaCreditoConstantesFunciones.NUMEROCAJA)) {
				this.setResaltarnumero_cajaDetaNotaCredito(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetaNotaCredito=true;

	public Boolean getMostrarFK_IdBodegaDetaNotaCredito() {
		return this.mostrarFK_IdBodegaDetaNotaCredito;
	}

	public void setMostrarFK_IdBodegaDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdCentroCostoDetaNotaCredito() {
		return this.mostrarFK_IdCentroCostoDetaNotaCredito;
	}

	public void setMostrarFK_IdCentroCostoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetaNotaCredito=true;

	public Boolean getMostrarFK_IdEjercicioDetaNotaCredito() {
		return this.mostrarFK_IdEjercicioDetaNotaCredito;
	}

	public void setMostrarFK_IdEjercicioDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpaqueDetaNotaCredito=true;

	public Boolean getMostrarFK_IdEmpaqueDetaNotaCredito() {
		return this.mostrarFK_IdEmpaqueDetaNotaCredito;
	}

	public void setMostrarFK_IdEmpaqueDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpaqueDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetaNotaCredito=true;

	public Boolean getMostrarFK_IdEmpresaDetaNotaCredito() {
		return this.mostrarFK_IdEmpresaDetaNotaCredito;
	}

	public void setMostrarFK_IdEmpresaDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNotaCreditoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdNotaCreditoDetaNotaCredito() {
		return this.mostrarFK_IdNotaCreditoDetaNotaCredito;
	}

	public void setMostrarFK_IdNotaCreditoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNotaCreditoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdPeriodoDetaNotaCredito() {
		return this.mostrarFK_IdPeriodoDetaNotaCredito;
	}

	public void setMostrarFK_IdPeriodoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdProductoDetaNotaCredito() {
		return this.mostrarFK_IdProductoDetaNotaCredito;
	}

	public void setMostrarFK_IdProductoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetaNotaCredito=true;

	public Boolean getMostrarFK_IdSucursalDetaNotaCredito() {
		return this.mostrarFK_IdSucursalDetaNotaCredito;
	}

	public void setMostrarFK_IdSucursalDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDetaNotaCreditoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdTipoDetaNotaCreditoDetaNotaCredito() {
		return this.mostrarFK_IdTipoDetaNotaCreditoDetaNotaCredito;
	}

	public void setMostrarFK_IdTipoDetaNotaCreditoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDetaNotaCreditoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDevolucionEmpresaDetaNotaCredito=true;

	public Boolean getMostrarFK_IdTipoDevolucionEmpresaDetaNotaCredito() {
		return this.mostrarFK_IdTipoDevolucionEmpresaDetaNotaCredito;
	}

	public void setMostrarFK_IdTipoDevolucionEmpresaDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDevolucionEmpresaDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetaNotaCredito=true;

	public Boolean getMostrarFK_IdUnidadDetaNotaCredito() {
		return this.mostrarFK_IdUnidadDetaNotaCredito;
	}

	public void setMostrarFK_IdUnidadDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetaNotaCredito= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetaNotaCredito=true;

	public Boolean getActivarFK_IdBodegaDetaNotaCredito() {
		return this.activarFK_IdBodegaDetaNotaCredito;
	}

	public void setActivarFK_IdBodegaDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetaNotaCredito=true;

	public Boolean getActivarFK_IdCentroCostoDetaNotaCredito() {
		return this.activarFK_IdCentroCostoDetaNotaCredito;
	}

	public void setActivarFK_IdCentroCostoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetaNotaCredito=true;

	public Boolean getActivarFK_IdEjercicioDetaNotaCredito() {
		return this.activarFK_IdEjercicioDetaNotaCredito;
	}

	public void setActivarFK_IdEjercicioDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpaqueDetaNotaCredito=true;

	public Boolean getActivarFK_IdEmpaqueDetaNotaCredito() {
		return this.activarFK_IdEmpaqueDetaNotaCredito;
	}

	public void setActivarFK_IdEmpaqueDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEmpaqueDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetaNotaCredito=true;

	public Boolean getActivarFK_IdEmpresaDetaNotaCredito() {
		return this.activarFK_IdEmpresaDetaNotaCredito;
	}

	public void setActivarFK_IdEmpresaDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdNotaCreditoDetaNotaCredito=true;

	public Boolean getActivarFK_IdNotaCreditoDetaNotaCredito() {
		return this.activarFK_IdNotaCreditoDetaNotaCredito;
	}

	public void setActivarFK_IdNotaCreditoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdNotaCreditoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetaNotaCredito=true;

	public Boolean getActivarFK_IdPeriodoDetaNotaCredito() {
		return this.activarFK_IdPeriodoDetaNotaCredito;
	}

	public void setActivarFK_IdPeriodoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetaNotaCredito=true;

	public Boolean getActivarFK_IdProductoDetaNotaCredito() {
		return this.activarFK_IdProductoDetaNotaCredito;
	}

	public void setActivarFK_IdProductoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetaNotaCredito=true;

	public Boolean getActivarFK_IdSucursalDetaNotaCredito() {
		return this.activarFK_IdSucursalDetaNotaCredito;
	}

	public void setActivarFK_IdSucursalDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDetaNotaCreditoDetaNotaCredito=true;

	public Boolean getActivarFK_IdTipoDetaNotaCreditoDetaNotaCredito() {
		return this.activarFK_IdTipoDetaNotaCreditoDetaNotaCredito;
	}

	public void setActivarFK_IdTipoDetaNotaCreditoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDetaNotaCreditoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDevolucionEmpresaDetaNotaCredito=true;

	public Boolean getActivarFK_IdTipoDevolucionEmpresaDetaNotaCredito() {
		return this.activarFK_IdTipoDevolucionEmpresaDetaNotaCredito;
	}

	public void setActivarFK_IdTipoDevolucionEmpresaDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDevolucionEmpresaDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetaNotaCredito=true;

	public Boolean getActivarFK_IdUnidadDetaNotaCredito() {
		return this.activarFK_IdUnidadDetaNotaCredito;
	}

	public void setActivarFK_IdUnidadDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetaNotaCredito= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetaNotaCredito=null;

	public Border getResaltarFK_IdBodegaDetaNotaCredito() {
		return this.resaltarFK_IdBodegaDetaNotaCredito;
	}

	public void setResaltarFK_IdBodegaDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetaNotaCredito=null;

	public Border getResaltarFK_IdCentroCostoDetaNotaCredito() {
		return this.resaltarFK_IdCentroCostoDetaNotaCredito;
	}

	public void setResaltarFK_IdCentroCostoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetaNotaCredito=null;

	public Border getResaltarFK_IdEjercicioDetaNotaCredito() {
		return this.resaltarFK_IdEjercicioDetaNotaCredito;
	}

	public void setResaltarFK_IdEjercicioDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEmpaqueDetaNotaCredito=null;

	public Border getResaltarFK_IdEmpaqueDetaNotaCredito() {
		return this.resaltarFK_IdEmpaqueDetaNotaCredito;
	}

	public void setResaltarFK_IdEmpaqueDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEmpaqueDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEmpaqueDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpaqueDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetaNotaCredito=null;

	public Border getResaltarFK_IdEmpresaDetaNotaCredito() {
		return this.resaltarFK_IdEmpresaDetaNotaCredito;
	}

	public void setResaltarFK_IdEmpresaDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdNotaCreditoDetaNotaCredito=null;

	public Border getResaltarFK_IdNotaCreditoDetaNotaCredito() {
		return this.resaltarFK_IdNotaCreditoDetaNotaCredito;
	}

	public void setResaltarFK_IdNotaCreditoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdNotaCreditoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdNotaCreditoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNotaCreditoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetaNotaCredito=null;

	public Border getResaltarFK_IdPeriodoDetaNotaCredito() {
		return this.resaltarFK_IdPeriodoDetaNotaCredito;
	}

	public void setResaltarFK_IdPeriodoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetaNotaCredito=null;

	public Border getResaltarFK_IdProductoDetaNotaCredito() {
		return this.resaltarFK_IdProductoDetaNotaCredito;
	}

	public void setResaltarFK_IdProductoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdProductoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetaNotaCredito=null;

	public Border getResaltarFK_IdSucursalDetaNotaCredito() {
		return this.resaltarFK_IdSucursalDetaNotaCredito;
	}

	public void setResaltarFK_IdSucursalDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito=null;

	public Border getResaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito() {
		return this.resaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito;
	}

	public void setResaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDetaNotaCreditoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito=null;

	public Border getResaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito() {
		return this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito;
	}

	public void setResaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDevolucionEmpresaDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetaNotaCredito=null;

	public Border getResaltarFK_IdUnidadDetaNotaCredito() {
		return this.resaltarFK_IdUnidadDetaNotaCredito;
	}

	public void setResaltarFK_IdUnidadDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*DetaNotaCreditoBeanSwingJInternalFrame detanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetaNotaCredito= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}