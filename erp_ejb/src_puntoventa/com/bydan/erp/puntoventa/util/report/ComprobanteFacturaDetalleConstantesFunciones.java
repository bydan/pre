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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComprobanteFacturaDetalleConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ComprobanteFacturaDetalle";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobanteFacturaDetalle"+ComprobanteFacturaDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobanteFacturaDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobanteFacturaDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobanteFacturaDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobanteFacturaDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobanteFacturaDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobanteFacturaDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobante Factura Detalles";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comprobante Factura Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Comprobante Factura Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobanteFacturaDetalle";
	public static final String OBJECTNAME="comprobantefacturadetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="comprobante_factura_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobantefacturadetalle from "+ComprobanteFacturaDetalleConstantesFunciones.SPERSISTENCENAME+" comprobantefacturadetalle";
	public static String QUERYSELECTNATIVE="select "+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".id,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".version_row,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".id_empresa,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".id_cliente,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".fecha_inicio,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".fecha_fin,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".secuencial,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".fecha,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".nombre_cliente,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".descuento,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".subtotal,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".total,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".nombre_bodega,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".nombre_producto,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".cantidad,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".precio,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".descuento_producto,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".iva,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".serie,"+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME+".descripcion from "+ComprobanteFacturaDetalleConstantesFunciones.SCHEMA+"."+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME;//+" as "+ComprobanteFacturaDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String DESCUENTO= "descuento";
    public static final String SUBTOTAL= "subtotal";
    public static final String TOTAL= "total";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTOPRODUCTO= "descuento_producto";
    public static final String IVA= "iva";
    public static final String SERIE= "serie";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTOPRODUCTO= "Descuento Producto";
		public static final String LABEL_DESCUENTOPRODUCTO_LOWER= "Descuento Producto";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComprobanteFacturaDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAINICIO)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAFIN)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHA)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.TOTAL)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.PRECIO)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.IVA)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.SERIE)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobanteFacturaDetalleDescripcion(ComprobanteFacturaDetalle comprobantefacturadetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobantefacturadetalle !=null/* && comprobantefacturadetalle.getId()!=0*/) {
			if(comprobantefacturadetalle.getId()!=null) {
				sDescripcion=comprobantefacturadetalle.getId().toString();
			}//comprobantefacturadetallecomprobantefacturadetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobanteFacturaDetalleDescripcionDetallado(ComprobanteFacturaDetalle comprobantefacturadetalle) {
		String sDescripcion="";
			
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.ID+"=";
		sDescripcion+=comprobantefacturadetalle.getId().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobantefacturadetalle.getVersionRow().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobantefacturadetalle.getid_empresa().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=comprobantefacturadetalle.getid_sucursal().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=comprobantefacturadetalle.getid_cliente().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=comprobantefacturadetalle.getfecha_inicio().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=comprobantefacturadetalle.getfecha_fin().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=comprobantefacturadetalle.getsecuencial()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.FECHA+"=";
		sDescripcion+=comprobantefacturadetalle.getfecha().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=comprobantefacturadetalle.getnombre_cliente()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=comprobantefacturadetalle.getdescuento().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=comprobantefacturadetalle.getsubtotal().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.TOTAL+"=";
		sDescripcion+=comprobantefacturadetalle.gettotal().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=comprobantefacturadetalle.getnombre_bodega()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=comprobantefacturadetalle.getnombre_producto()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=comprobantefacturadetalle.getcantidad().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.PRECIO+"=";
		sDescripcion+=comprobantefacturadetalle.getprecio().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO+"=";
		sDescripcion+=comprobantefacturadetalle.getdescuento_producto().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.IVA+"=";
		sDescripcion+=comprobantefacturadetalle.getiva().toString()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.SERIE+"=";
		sDescripcion+=comprobantefacturadetalle.getserie()+",";
		sDescripcion+=ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comprobantefacturadetalle.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobanteFacturaDetalleDescripcion(ComprobanteFacturaDetalle comprobantefacturadetalle,String sValor) throws Exception {			
		if(comprobantefacturadetalle !=null) {
			//comprobantefacturadetallecomprobantefacturadetalle.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaComprobanteFacturaDetalle")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaComprobanteFacturaDetalle(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantefacturadetalle.setsecuencial(comprobantefacturadetalle.getsecuencial().trim());
		comprobantefacturadetalle.setnombre_cliente(comprobantefacturadetalle.getnombre_cliente().trim());
		comprobantefacturadetalle.setnombre_bodega(comprobantefacturadetalle.getnombre_bodega().trim());
		comprobantefacturadetalle.setnombre_producto(comprobantefacturadetalle.getnombre_producto().trim());
		comprobantefacturadetalle.setserie(comprobantefacturadetalle.getserie().trim());
		comprobantefacturadetalle.setdescripcion(comprobantefacturadetalle.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComprobanteFacturaDetalles(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {
			comprobantefacturadetalle.setsecuencial(comprobantefacturadetalle.getsecuencial().trim());
			comprobantefacturadetalle.setnombre_cliente(comprobantefacturadetalle.getnombre_cliente().trim());
			comprobantefacturadetalle.setnombre_bodega(comprobantefacturadetalle.getnombre_bodega().trim());
			comprobantefacturadetalle.setnombre_producto(comprobantefacturadetalle.getnombre_producto().trim());
			comprobantefacturadetalle.setserie(comprobantefacturadetalle.getserie().trim());
			comprobantefacturadetalle.setdescripcion(comprobantefacturadetalle.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobantefacturadetalle.getConCambioAuxiliar()) {
			comprobantefacturadetalle.setIsDeleted(comprobantefacturadetalle.getIsDeletedAuxiliar());	
			comprobantefacturadetalle.setIsNew(comprobantefacturadetalle.getIsNewAuxiliar());	
			comprobantefacturadetalle.setIsChanged(comprobantefacturadetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobantefacturadetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobantefacturadetalle.setIsDeletedAuxiliar(false);	
			comprobantefacturadetalle.setIsNewAuxiliar(false);	
			comprobantefacturadetalle.setIsChangedAuxiliar(false);
			
			comprobantefacturadetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFacturaDetalles(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle : comprobantefacturadetalles) {
			if(conAsignarBase && comprobantefacturadetalle.getConCambioAuxiliar()) {
				comprobantefacturadetalle.setIsDeleted(comprobantefacturadetalle.getIsDeletedAuxiliar());	
				comprobantefacturadetalle.setIsNew(comprobantefacturadetalle.getIsNewAuxiliar());	
				comprobantefacturadetalle.setIsChanged(comprobantefacturadetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobantefacturadetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobantefacturadetalle.setIsDeletedAuxiliar(false);	
				comprobantefacturadetalle.setIsNewAuxiliar(false);	
				comprobantefacturadetalle.setIsChangedAuxiliar(false);
				
				comprobantefacturadetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalle,Boolean conEnteros) throws Exception  {
		comprobantefacturadetalle.setdescuento(0.0);
		comprobantefacturadetalle.setsubtotal(0.0);
		comprobantefacturadetalle.settotal(0.0);
		comprobantefacturadetalle.setprecio(0.0);
		comprobantefacturadetalle.setdescuento_producto(0.0);
		comprobantefacturadetalle.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			comprobantefacturadetalle.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresComprobanteFacturaDetalles(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,Boolean conEnteros) throws Exception  {
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {
			comprobantefacturadetalle.setdescuento(0.0);
			comprobantefacturadetalle.setsubtotal(0.0);
			comprobantefacturadetalle.settotal(0.0);
			comprobantefacturadetalle.setprecio(0.0);
			comprobantefacturadetalle.setdescuento_producto(0.0);
			comprobantefacturadetalle.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				comprobantefacturadetalle.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobanteFacturaDetalle(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ComprobanteFacturaDetalle comprobantefacturadetalleAux) throws Exception  {
		ComprobanteFacturaDetalleConstantesFunciones.InicializarValoresComprobanteFacturaDetalle(comprobantefacturadetalleAux,true);
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {
			if(comprobantefacturadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobantefacturadetalleAux.setdescuento(comprobantefacturadetalleAux.getdescuento()+comprobantefacturadetalle.getdescuento());			
			comprobantefacturadetalleAux.setsubtotal(comprobantefacturadetalleAux.getsubtotal()+comprobantefacturadetalle.getsubtotal());			
			comprobantefacturadetalleAux.settotal(comprobantefacturadetalleAux.gettotal()+comprobantefacturadetalle.gettotal());			
			comprobantefacturadetalleAux.setcantidad(comprobantefacturadetalleAux.getcantidad()+comprobantefacturadetalle.getcantidad());			
			comprobantefacturadetalleAux.setprecio(comprobantefacturadetalleAux.getprecio()+comprobantefacturadetalle.getprecio());			
			comprobantefacturadetalleAux.setdescuento_producto(comprobantefacturadetalleAux.getdescuento_producto()+comprobantefacturadetalle.getdescuento_producto());			
			comprobantefacturadetalleAux.setiva(comprobantefacturadetalleAux.getiva()+comprobantefacturadetalle.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFacturaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobanteFacturaDetalleConstantesFunciones.getArrayColumnasGlobalesComprobanteFacturaDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFacturaDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobanteFacturaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ComprobanteFacturaDetalle comprobantefacturadetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalleAux: comprobantefacturadetalles) {
			if(comprobantefacturadetalleAux!=null && comprobantefacturadetalle!=null) {
				if((comprobantefacturadetalleAux.getId()==null && comprobantefacturadetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobantefacturadetalleAux.getId()!=null && comprobantefacturadetalle.getId()!=null){
					if(comprobantefacturadetalleAux.getId().equals(comprobantefacturadetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFacturaDetalle(List<ComprobanteFacturaDetalle> comprobantefacturadetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double subtotalTotal=0.0;
		Double totalTotal=0.0;
		Double precioTotal=0.0;
		Double descuento_productoTotal=0.0;
		Double ivaTotal=0.0;
	
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {			
			if(comprobantefacturadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentoTotal+=comprobantefacturadetalle.getdescuento();
			subtotalTotal+=comprobantefacturadetalle.getsubtotal();
			totalTotal+=comprobantefacturadetalle.gettotal();
			precioTotal+=comprobantefacturadetalle.getprecio();
			descuento_productoTotal+=comprobantefacturadetalle.getdescuento_producto();
			ivaTotal+=comprobantefacturadetalle.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO);
		datoGeneral.setdValorDouble(descuento_productoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobanteFacturaDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_ID, ComprobanteFacturaDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_VERSIONROW, ComprobanteFacturaDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDCLIENTE, ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_SECUENCIAL, ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHA, ComprobanteFacturaDetalleConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBRECLIENTE, ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO, ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL, ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL, ComprobanteFacturaDetalleConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREBODEGA, ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREPRODUCTO, ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_CANTIDAD, ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO, ComprobanteFacturaDetalleConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO, ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA, ComprobanteFacturaDetalleConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_SERIE, ComprobanteFacturaDetalleConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCRIPCION, ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobanteFacturaDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFacturaDetalle() throws Exception  {
		return ComprobanteFacturaDetalleConstantesFunciones.getTiposSeleccionarComprobanteFacturaDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFacturaDetalle(Boolean conFk) throws Exception  {
		return ComprobanteFacturaDetalleConstantesFunciones.getTiposSeleccionarComprobanteFacturaDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFacturaDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobanteFacturaDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalleAux) throws Exception {
		
			comprobantefacturadetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantefacturadetalleAux.getEmpresa()));
			comprobantefacturadetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantefacturadetalleAux.getSucursal()));
			comprobantefacturadetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantefacturadetalleAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFacturaDetalle(List<ComprobanteFacturaDetalle> comprobantefacturadetallesTemp) throws Exception {
		for(ComprobanteFacturaDetalle comprobantefacturadetalleAux:comprobantefacturadetallesTemp) {
			
			comprobantefacturadetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantefacturadetalleAux.getEmpresa()));
			comprobantefacturadetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantefacturadetalleAux.getSucursal()));
			comprobantefacturadetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantefacturadetalleAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobanteFacturaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobanteFacturaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFacturaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFacturaDetalleConstantesFunciones.getClassesRelationshipsOfComprobanteFacturaDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFacturaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFacturaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFacturaDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfComprobanteFacturaDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFacturaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobanteFacturaDetalle comprobantefacturadetalle,List<ComprobanteFacturaDetalle> comprobantefacturadetalles,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobanteFacturaDetalle comprobantefacturadetalle,List<ComprobanteFacturaDetalle> comprobantefacturadetalles) throws Exception {
		try	{			
			for(ComprobanteFacturaDetalle comprobantefacturadetalleLocal:comprobantefacturadetalles) {
				if(comprobantefacturadetalleLocal.getId().equals(comprobantefacturadetalle.getId())) {
					comprobantefacturadetalleLocal.setIsSelected(comprobantefacturadetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobanteFacturaDetalle(List<ComprobanteFacturaDetalle> comprobantefacturadetallesAux) throws Exception {
		//this.comprobantefacturadetallesAux=comprobantefacturadetallesAux;
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalleAux:comprobantefacturadetallesAux) {
			if(comprobantefacturadetalleAux.getIsChanged()) {
				comprobantefacturadetalleAux.setIsChanged(false);
			}		
			
			if(comprobantefacturadetalleAux.getIsNew()) {
				comprobantefacturadetalleAux.setIsNew(false);
			}	
			
			if(comprobantefacturadetalleAux.getIsDeleted()) {
				comprobantefacturadetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalleAux) throws Exception {
		//this.comprobantefacturadetalleAux=comprobantefacturadetalleAux;
		
			if(comprobantefacturadetalleAux.getIsChanged()) {
				comprobantefacturadetalleAux.setIsChanged(false);
			}		
			
			if(comprobantefacturadetalleAux.getIsNew()) {
				comprobantefacturadetalleAux.setIsNew(false);
			}	
			
			if(comprobantefacturadetalleAux.getIsDeleted()) {
				comprobantefacturadetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobanteFacturaDetalle comprobantefacturadetalleAsignar,ComprobanteFacturaDetalle comprobantefacturadetalle) throws Exception {
		comprobantefacturadetalleAsignar.setId(comprobantefacturadetalle.getId());	
		comprobantefacturadetalleAsignar.setVersionRow(comprobantefacturadetalle.getVersionRow());	
		comprobantefacturadetalleAsignar.setid_cliente(comprobantefacturadetalle.getid_cliente());
		comprobantefacturadetalleAsignar.setcliente_descripcion(comprobantefacturadetalle.getcliente_descripcion());	
		comprobantefacturadetalleAsignar.setsecuencial(comprobantefacturadetalle.getsecuencial());	
		comprobantefacturadetalleAsignar.setfecha(comprobantefacturadetalle.getfecha());	
		comprobantefacturadetalleAsignar.setnombre_cliente(comprobantefacturadetalle.getnombre_cliente());	
		comprobantefacturadetalleAsignar.setdescuento(comprobantefacturadetalle.getdescuento());	
		comprobantefacturadetalleAsignar.setsubtotal(comprobantefacturadetalle.getsubtotal());	
		comprobantefacturadetalleAsignar.settotal(comprobantefacturadetalle.gettotal());	
		comprobantefacturadetalleAsignar.setnombre_bodega(comprobantefacturadetalle.getnombre_bodega());	
		comprobantefacturadetalleAsignar.setnombre_producto(comprobantefacturadetalle.getnombre_producto());	
		comprobantefacturadetalleAsignar.setcantidad(comprobantefacturadetalle.getcantidad());	
		comprobantefacturadetalleAsignar.setprecio(comprobantefacturadetalle.getprecio());	
		comprobantefacturadetalleAsignar.setdescuento_producto(comprobantefacturadetalle.getdescuento_producto());	
		comprobantefacturadetalleAsignar.setiva(comprobantefacturadetalle.getiva());	
		comprobantefacturadetalleAsignar.setserie(comprobantefacturadetalle.getserie());	
		comprobantefacturadetalleAsignar.setdescripcion(comprobantefacturadetalle.getdescripcion());	
	}
	
	public static void inicializarComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalle) throws Exception {
		try {
				comprobantefacturadetalle.setId(0L);	
					
				comprobantefacturadetalle.setid_cliente(-1L);	
				comprobantefacturadetalle.setsecuencial("");	
				comprobantefacturadetalle.setfecha(new Date());	
				comprobantefacturadetalle.setnombre_cliente("");	
				comprobantefacturadetalle.setdescuento(0.0);	
				comprobantefacturadetalle.setsubtotal(0.0);	
				comprobantefacturadetalle.settotal(0.0);	
				comprobantefacturadetalle.setnombre_bodega("");	
				comprobantefacturadetalle.setnombre_producto("");	
				comprobantefacturadetalle.setcantidad(0);	
				comprobantefacturadetalle.setprecio(0.0);	
				comprobantefacturadetalle.setdescuento_producto(0.0);	
				comprobantefacturadetalle.setiva(0.0);	
				comprobantefacturadetalle.setserie("");	
				comprobantefacturadetalle.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobanteFacturaDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobanteFacturaDetalle(String sTipo,Row row,Workbook workbook,ComprobanteFacturaDetalle comprobantefacturadetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getdescuento_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefacturadetalle.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobanteFacturaDetalle="";
	
	public String getsFinalQueryComprobanteFacturaDetalle() {
		return this.sFinalQueryComprobanteFacturaDetalle;
	}
	
	public void setsFinalQueryComprobanteFacturaDetalle(String sFinalQueryComprobanteFacturaDetalle) {
		this.sFinalQueryComprobanteFacturaDetalle= sFinalQueryComprobanteFacturaDetalle;
	}
	
	public Border resaltarSeleccionarComprobanteFacturaDetalle=null;
	
	public Border setResaltarSeleccionarComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobanteFacturaDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobanteFacturaDetalle() {
		return this.resaltarSeleccionarComprobanteFacturaDetalle;
	}
	
	public void setResaltarSeleccionarComprobanteFacturaDetalle(Border borderResaltarSeleccionarComprobanteFacturaDetalle) {
		this.resaltarSeleccionarComprobanteFacturaDetalle= borderResaltarSeleccionarComprobanteFacturaDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobanteFacturaDetalle=null;
	public Boolean mostraridComprobanteFacturaDetalle=true;
	public Boolean activaridComprobanteFacturaDetalle=true;

	public Border resaltarid_empresaComprobanteFacturaDetalle=null;
	public Boolean mostrarid_empresaComprobanteFacturaDetalle=true;
	public Boolean activarid_empresaComprobanteFacturaDetalle=true;
	public Boolean cargarid_empresaComprobanteFacturaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobanteFacturaDetalle=false;//ConEventDepend=true

	public Border resaltarid_sucursalComprobanteFacturaDetalle=null;
	public Boolean mostrarid_sucursalComprobanteFacturaDetalle=true;
	public Boolean activarid_sucursalComprobanteFacturaDetalle=true;
	public Boolean cargarid_sucursalComprobanteFacturaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalComprobanteFacturaDetalle=false;//ConEventDepend=true

	public Border resaltarid_clienteComprobanteFacturaDetalle=null;
	public Boolean mostrarid_clienteComprobanteFacturaDetalle=true;
	public Boolean activarid_clienteComprobanteFacturaDetalle=false;
	public Boolean cargarid_clienteComprobanteFacturaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteComprobanteFacturaDetalle=false;//ConEventDepend=true

	public Border resaltarfecha_inicioComprobanteFacturaDetalle=null;
	public Boolean mostrarfecha_inicioComprobanteFacturaDetalle=true;
	public Boolean activarfecha_inicioComprobanteFacturaDetalle=true;

	public Border resaltarfecha_finComprobanteFacturaDetalle=null;
	public Boolean mostrarfecha_finComprobanteFacturaDetalle=true;
	public Boolean activarfecha_finComprobanteFacturaDetalle=true;

	public Border resaltarsecuencialComprobanteFacturaDetalle=null;
	public Boolean mostrarsecuencialComprobanteFacturaDetalle=true;
	public Boolean activarsecuencialComprobanteFacturaDetalle=true;

	public Border resaltarfechaComprobanteFacturaDetalle=null;
	public Boolean mostrarfechaComprobanteFacturaDetalle=true;
	public Boolean activarfechaComprobanteFacturaDetalle=true;

	public Border resaltarnombre_clienteComprobanteFacturaDetalle=null;
	public Boolean mostrarnombre_clienteComprobanteFacturaDetalle=true;
	public Boolean activarnombre_clienteComprobanteFacturaDetalle=true;

	public Border resaltardescuentoComprobanteFacturaDetalle=null;
	public Boolean mostrardescuentoComprobanteFacturaDetalle=true;
	public Boolean activardescuentoComprobanteFacturaDetalle=true;

	public Border resaltarsubtotalComprobanteFacturaDetalle=null;
	public Boolean mostrarsubtotalComprobanteFacturaDetalle=true;
	public Boolean activarsubtotalComprobanteFacturaDetalle=true;

	public Border resaltartotalComprobanteFacturaDetalle=null;
	public Boolean mostrartotalComprobanteFacturaDetalle=true;
	public Boolean activartotalComprobanteFacturaDetalle=true;

	public Border resaltarnombre_bodegaComprobanteFacturaDetalle=null;
	public Boolean mostrarnombre_bodegaComprobanteFacturaDetalle=true;
	public Boolean activarnombre_bodegaComprobanteFacturaDetalle=true;

	public Border resaltarnombre_productoComprobanteFacturaDetalle=null;
	public Boolean mostrarnombre_productoComprobanteFacturaDetalle=true;
	public Boolean activarnombre_productoComprobanteFacturaDetalle=true;

	public Border resaltarcantidadComprobanteFacturaDetalle=null;
	public Boolean mostrarcantidadComprobanteFacturaDetalle=true;
	public Boolean activarcantidadComprobanteFacturaDetalle=true;

	public Border resaltarprecioComprobanteFacturaDetalle=null;
	public Boolean mostrarprecioComprobanteFacturaDetalle=true;
	public Boolean activarprecioComprobanteFacturaDetalle=true;

	public Border resaltardescuento_productoComprobanteFacturaDetalle=null;
	public Boolean mostrardescuento_productoComprobanteFacturaDetalle=true;
	public Boolean activardescuento_productoComprobanteFacturaDetalle=true;

	public Border resaltarivaComprobanteFacturaDetalle=null;
	public Boolean mostrarivaComprobanteFacturaDetalle=true;
	public Boolean activarivaComprobanteFacturaDetalle=true;

	public Border resaltarserieComprobanteFacturaDetalle=null;
	public Boolean mostrarserieComprobanteFacturaDetalle=true;
	public Boolean activarserieComprobanteFacturaDetalle=true;

	public Border resaltardescripcionComprobanteFacturaDetalle=null;
	public Boolean mostrardescripcionComprobanteFacturaDetalle=true;
	public Boolean activardescripcionComprobanteFacturaDetalle=true;

	
	

	public Border setResaltaridComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltaridComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobanteFacturaDetalle() {
		return this.resaltaridComprobanteFacturaDetalle;
	}

	public void setResaltaridComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltaridComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostraridComprobanteFacturaDetalle() {
		return this.mostraridComprobanteFacturaDetalle;
	}

	public void setMostraridComprobanteFacturaDetalle(Boolean mostraridComprobanteFacturaDetalle) {
		this.mostraridComprobanteFacturaDetalle= mostraridComprobanteFacturaDetalle;
	}

	public Boolean getActivaridComprobanteFacturaDetalle() {
		return this.activaridComprobanteFacturaDetalle;
	}

	public void setActivaridComprobanteFacturaDetalle(Boolean activaridComprobanteFacturaDetalle) {
		this.activaridComprobanteFacturaDetalle= activaridComprobanteFacturaDetalle;
	}

	public Border setResaltarid_empresaComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobanteFacturaDetalle() {
		return this.resaltarid_empresaComprobanteFacturaDetalle;
	}

	public void setResaltarid_empresaComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarid_empresaComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobanteFacturaDetalle() {
		return this.mostrarid_empresaComprobanteFacturaDetalle;
	}

	public void setMostrarid_empresaComprobanteFacturaDetalle(Boolean mostrarid_empresaComprobanteFacturaDetalle) {
		this.mostrarid_empresaComprobanteFacturaDetalle= mostrarid_empresaComprobanteFacturaDetalle;
	}

	public Boolean getActivarid_empresaComprobanteFacturaDetalle() {
		return this.activarid_empresaComprobanteFacturaDetalle;
	}

	public void setActivarid_empresaComprobanteFacturaDetalle(Boolean activarid_empresaComprobanteFacturaDetalle) {
		this.activarid_empresaComprobanteFacturaDetalle= activarid_empresaComprobanteFacturaDetalle;
	}

	public Boolean getCargarid_empresaComprobanteFacturaDetalle() {
		return this.cargarid_empresaComprobanteFacturaDetalle;
	}

	public void setCargarid_empresaComprobanteFacturaDetalle(Boolean cargarid_empresaComprobanteFacturaDetalle) {
		this.cargarid_empresaComprobanteFacturaDetalle= cargarid_empresaComprobanteFacturaDetalle;
	}

	public Border setResaltarid_sucursalComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_sucursalComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalComprobanteFacturaDetalle() {
		return this.resaltarid_sucursalComprobanteFacturaDetalle;
	}

	public void setResaltarid_sucursalComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarid_sucursalComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_sucursalComprobanteFacturaDetalle() {
		return this.mostrarid_sucursalComprobanteFacturaDetalle;
	}

	public void setMostrarid_sucursalComprobanteFacturaDetalle(Boolean mostrarid_sucursalComprobanteFacturaDetalle) {
		this.mostrarid_sucursalComprobanteFacturaDetalle= mostrarid_sucursalComprobanteFacturaDetalle;
	}

	public Boolean getActivarid_sucursalComprobanteFacturaDetalle() {
		return this.activarid_sucursalComprobanteFacturaDetalle;
	}

	public void setActivarid_sucursalComprobanteFacturaDetalle(Boolean activarid_sucursalComprobanteFacturaDetalle) {
		this.activarid_sucursalComprobanteFacturaDetalle= activarid_sucursalComprobanteFacturaDetalle;
	}

	public Boolean getCargarid_sucursalComprobanteFacturaDetalle() {
		return this.cargarid_sucursalComprobanteFacturaDetalle;
	}

	public void setCargarid_sucursalComprobanteFacturaDetalle(Boolean cargarid_sucursalComprobanteFacturaDetalle) {
		this.cargarid_sucursalComprobanteFacturaDetalle= cargarid_sucursalComprobanteFacturaDetalle;
	}

	public Border setResaltarid_clienteComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_clienteComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteComprobanteFacturaDetalle() {
		return this.resaltarid_clienteComprobanteFacturaDetalle;
	}

	public void setResaltarid_clienteComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarid_clienteComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_clienteComprobanteFacturaDetalle() {
		return this.mostrarid_clienteComprobanteFacturaDetalle;
	}

	public void setMostrarid_clienteComprobanteFacturaDetalle(Boolean mostrarid_clienteComprobanteFacturaDetalle) {
		this.mostrarid_clienteComprobanteFacturaDetalle= mostrarid_clienteComprobanteFacturaDetalle;
	}

	public Boolean getActivarid_clienteComprobanteFacturaDetalle() {
		return this.activarid_clienteComprobanteFacturaDetalle;
	}

	public void setActivarid_clienteComprobanteFacturaDetalle(Boolean activarid_clienteComprobanteFacturaDetalle) {
		this.activarid_clienteComprobanteFacturaDetalle= activarid_clienteComprobanteFacturaDetalle;
	}

	public Boolean getCargarid_clienteComprobanteFacturaDetalle() {
		return this.cargarid_clienteComprobanteFacturaDetalle;
	}

	public void setCargarid_clienteComprobanteFacturaDetalle(Boolean cargarid_clienteComprobanteFacturaDetalle) {
		this.cargarid_clienteComprobanteFacturaDetalle= cargarid_clienteComprobanteFacturaDetalle;
	}

	public Border setResaltarfecha_inicioComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioComprobanteFacturaDetalle() {
		return this.resaltarfecha_inicioComprobanteFacturaDetalle;
	}

	public void setResaltarfecha_inicioComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarfecha_inicioComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioComprobanteFacturaDetalle() {
		return this.mostrarfecha_inicioComprobanteFacturaDetalle;
	}

	public void setMostrarfecha_inicioComprobanteFacturaDetalle(Boolean mostrarfecha_inicioComprobanteFacturaDetalle) {
		this.mostrarfecha_inicioComprobanteFacturaDetalle= mostrarfecha_inicioComprobanteFacturaDetalle;
	}

	public Boolean getActivarfecha_inicioComprobanteFacturaDetalle() {
		return this.activarfecha_inicioComprobanteFacturaDetalle;
	}

	public void setActivarfecha_inicioComprobanteFacturaDetalle(Boolean activarfecha_inicioComprobanteFacturaDetalle) {
		this.activarfecha_inicioComprobanteFacturaDetalle= activarfecha_inicioComprobanteFacturaDetalle;
	}

	public Border setResaltarfecha_finComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_finComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finComprobanteFacturaDetalle() {
		return this.resaltarfecha_finComprobanteFacturaDetalle;
	}

	public void setResaltarfecha_finComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarfecha_finComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_finComprobanteFacturaDetalle() {
		return this.mostrarfecha_finComprobanteFacturaDetalle;
	}

	public void setMostrarfecha_finComprobanteFacturaDetalle(Boolean mostrarfecha_finComprobanteFacturaDetalle) {
		this.mostrarfecha_finComprobanteFacturaDetalle= mostrarfecha_finComprobanteFacturaDetalle;
	}

	public Boolean getActivarfecha_finComprobanteFacturaDetalle() {
		return this.activarfecha_finComprobanteFacturaDetalle;
	}

	public void setActivarfecha_finComprobanteFacturaDetalle(Boolean activarfecha_finComprobanteFacturaDetalle) {
		this.activarfecha_finComprobanteFacturaDetalle= activarfecha_finComprobanteFacturaDetalle;
	}

	public Border setResaltarsecuencialComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarsecuencialComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialComprobanteFacturaDetalle() {
		return this.resaltarsecuencialComprobanteFacturaDetalle;
	}

	public void setResaltarsecuencialComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarsecuencialComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarsecuencialComprobanteFacturaDetalle() {
		return this.mostrarsecuencialComprobanteFacturaDetalle;
	}

	public void setMostrarsecuencialComprobanteFacturaDetalle(Boolean mostrarsecuencialComprobanteFacturaDetalle) {
		this.mostrarsecuencialComprobanteFacturaDetalle= mostrarsecuencialComprobanteFacturaDetalle;
	}

	public Boolean getActivarsecuencialComprobanteFacturaDetalle() {
		return this.activarsecuencialComprobanteFacturaDetalle;
	}

	public void setActivarsecuencialComprobanteFacturaDetalle(Boolean activarsecuencialComprobanteFacturaDetalle) {
		this.activarsecuencialComprobanteFacturaDetalle= activarsecuencialComprobanteFacturaDetalle;
	}

	public Border setResaltarfechaComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarfechaComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaComprobanteFacturaDetalle() {
		return this.resaltarfechaComprobanteFacturaDetalle;
	}

	public void setResaltarfechaComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarfechaComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarfechaComprobanteFacturaDetalle() {
		return this.mostrarfechaComprobanteFacturaDetalle;
	}

	public void setMostrarfechaComprobanteFacturaDetalle(Boolean mostrarfechaComprobanteFacturaDetalle) {
		this.mostrarfechaComprobanteFacturaDetalle= mostrarfechaComprobanteFacturaDetalle;
	}

	public Boolean getActivarfechaComprobanteFacturaDetalle() {
		return this.activarfechaComprobanteFacturaDetalle;
	}

	public void setActivarfechaComprobanteFacturaDetalle(Boolean activarfechaComprobanteFacturaDetalle) {
		this.activarfechaComprobanteFacturaDetalle= activarfechaComprobanteFacturaDetalle;
	}

	public Border setResaltarnombre_clienteComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteComprobanteFacturaDetalle() {
		return this.resaltarnombre_clienteComprobanteFacturaDetalle;
	}

	public void setResaltarnombre_clienteComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarnombre_clienteComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteComprobanteFacturaDetalle() {
		return this.mostrarnombre_clienteComprobanteFacturaDetalle;
	}

	public void setMostrarnombre_clienteComprobanteFacturaDetalle(Boolean mostrarnombre_clienteComprobanteFacturaDetalle) {
		this.mostrarnombre_clienteComprobanteFacturaDetalle= mostrarnombre_clienteComprobanteFacturaDetalle;
	}

	public Boolean getActivarnombre_clienteComprobanteFacturaDetalle() {
		return this.activarnombre_clienteComprobanteFacturaDetalle;
	}

	public void setActivarnombre_clienteComprobanteFacturaDetalle(Boolean activarnombre_clienteComprobanteFacturaDetalle) {
		this.activarnombre_clienteComprobanteFacturaDetalle= activarnombre_clienteComprobanteFacturaDetalle;
	}

	public Border setResaltardescuentoComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltardescuentoComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoComprobanteFacturaDetalle() {
		return this.resaltardescuentoComprobanteFacturaDetalle;
	}

	public void setResaltardescuentoComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltardescuentoComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrardescuentoComprobanteFacturaDetalle() {
		return this.mostrardescuentoComprobanteFacturaDetalle;
	}

	public void setMostrardescuentoComprobanteFacturaDetalle(Boolean mostrardescuentoComprobanteFacturaDetalle) {
		this.mostrardescuentoComprobanteFacturaDetalle= mostrardescuentoComprobanteFacturaDetalle;
	}

	public Boolean getActivardescuentoComprobanteFacturaDetalle() {
		return this.activardescuentoComprobanteFacturaDetalle;
	}

	public void setActivardescuentoComprobanteFacturaDetalle(Boolean activardescuentoComprobanteFacturaDetalle) {
		this.activardescuentoComprobanteFacturaDetalle= activardescuentoComprobanteFacturaDetalle;
	}

	public Border setResaltarsubtotalComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarsubtotalComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalComprobanteFacturaDetalle() {
		return this.resaltarsubtotalComprobanteFacturaDetalle;
	}

	public void setResaltarsubtotalComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarsubtotalComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarsubtotalComprobanteFacturaDetalle() {
		return this.mostrarsubtotalComprobanteFacturaDetalle;
	}

	public void setMostrarsubtotalComprobanteFacturaDetalle(Boolean mostrarsubtotalComprobanteFacturaDetalle) {
		this.mostrarsubtotalComprobanteFacturaDetalle= mostrarsubtotalComprobanteFacturaDetalle;
	}

	public Boolean getActivarsubtotalComprobanteFacturaDetalle() {
		return this.activarsubtotalComprobanteFacturaDetalle;
	}

	public void setActivarsubtotalComprobanteFacturaDetalle(Boolean activarsubtotalComprobanteFacturaDetalle) {
		this.activarsubtotalComprobanteFacturaDetalle= activarsubtotalComprobanteFacturaDetalle;
	}

	public Border setResaltartotalComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltartotalComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalComprobanteFacturaDetalle() {
		return this.resaltartotalComprobanteFacturaDetalle;
	}

	public void setResaltartotalComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltartotalComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrartotalComprobanteFacturaDetalle() {
		return this.mostrartotalComprobanteFacturaDetalle;
	}

	public void setMostrartotalComprobanteFacturaDetalle(Boolean mostrartotalComprobanteFacturaDetalle) {
		this.mostrartotalComprobanteFacturaDetalle= mostrartotalComprobanteFacturaDetalle;
	}

	public Boolean getActivartotalComprobanteFacturaDetalle() {
		return this.activartotalComprobanteFacturaDetalle;
	}

	public void setActivartotalComprobanteFacturaDetalle(Boolean activartotalComprobanteFacturaDetalle) {
		this.activartotalComprobanteFacturaDetalle= activartotalComprobanteFacturaDetalle;
	}

	public Border setResaltarnombre_bodegaComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaComprobanteFacturaDetalle() {
		return this.resaltarnombre_bodegaComprobanteFacturaDetalle;
	}

	public void setResaltarnombre_bodegaComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarnombre_bodegaComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaComprobanteFacturaDetalle() {
		return this.mostrarnombre_bodegaComprobanteFacturaDetalle;
	}

	public void setMostrarnombre_bodegaComprobanteFacturaDetalle(Boolean mostrarnombre_bodegaComprobanteFacturaDetalle) {
		this.mostrarnombre_bodegaComprobanteFacturaDetalle= mostrarnombre_bodegaComprobanteFacturaDetalle;
	}

	public Boolean getActivarnombre_bodegaComprobanteFacturaDetalle() {
		return this.activarnombre_bodegaComprobanteFacturaDetalle;
	}

	public void setActivarnombre_bodegaComprobanteFacturaDetalle(Boolean activarnombre_bodegaComprobanteFacturaDetalle) {
		this.activarnombre_bodegaComprobanteFacturaDetalle= activarnombre_bodegaComprobanteFacturaDetalle;
	}

	public Border setResaltarnombre_productoComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_productoComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoComprobanteFacturaDetalle() {
		return this.resaltarnombre_productoComprobanteFacturaDetalle;
	}

	public void setResaltarnombre_productoComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarnombre_productoComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_productoComprobanteFacturaDetalle() {
		return this.mostrarnombre_productoComprobanteFacturaDetalle;
	}

	public void setMostrarnombre_productoComprobanteFacturaDetalle(Boolean mostrarnombre_productoComprobanteFacturaDetalle) {
		this.mostrarnombre_productoComprobanteFacturaDetalle= mostrarnombre_productoComprobanteFacturaDetalle;
	}

	public Boolean getActivarnombre_productoComprobanteFacturaDetalle() {
		return this.activarnombre_productoComprobanteFacturaDetalle;
	}

	public void setActivarnombre_productoComprobanteFacturaDetalle(Boolean activarnombre_productoComprobanteFacturaDetalle) {
		this.activarnombre_productoComprobanteFacturaDetalle= activarnombre_productoComprobanteFacturaDetalle;
	}

	public Border setResaltarcantidadComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarcantidadComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadComprobanteFacturaDetalle() {
		return this.resaltarcantidadComprobanteFacturaDetalle;
	}

	public void setResaltarcantidadComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarcantidadComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarcantidadComprobanteFacturaDetalle() {
		return this.mostrarcantidadComprobanteFacturaDetalle;
	}

	public void setMostrarcantidadComprobanteFacturaDetalle(Boolean mostrarcantidadComprobanteFacturaDetalle) {
		this.mostrarcantidadComprobanteFacturaDetalle= mostrarcantidadComprobanteFacturaDetalle;
	}

	public Boolean getActivarcantidadComprobanteFacturaDetalle() {
		return this.activarcantidadComprobanteFacturaDetalle;
	}

	public void setActivarcantidadComprobanteFacturaDetalle(Boolean activarcantidadComprobanteFacturaDetalle) {
		this.activarcantidadComprobanteFacturaDetalle= activarcantidadComprobanteFacturaDetalle;
	}

	public Border setResaltarprecioComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarprecioComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioComprobanteFacturaDetalle() {
		return this.resaltarprecioComprobanteFacturaDetalle;
	}

	public void setResaltarprecioComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarprecioComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarprecioComprobanteFacturaDetalle() {
		return this.mostrarprecioComprobanteFacturaDetalle;
	}

	public void setMostrarprecioComprobanteFacturaDetalle(Boolean mostrarprecioComprobanteFacturaDetalle) {
		this.mostrarprecioComprobanteFacturaDetalle= mostrarprecioComprobanteFacturaDetalle;
	}

	public Boolean getActivarprecioComprobanteFacturaDetalle() {
		return this.activarprecioComprobanteFacturaDetalle;
	}

	public void setActivarprecioComprobanteFacturaDetalle(Boolean activarprecioComprobanteFacturaDetalle) {
		this.activarprecioComprobanteFacturaDetalle= activarprecioComprobanteFacturaDetalle;
	}

	public Border setResaltardescuento_productoComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltardescuento_productoComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_productoComprobanteFacturaDetalle() {
		return this.resaltardescuento_productoComprobanteFacturaDetalle;
	}

	public void setResaltardescuento_productoComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltardescuento_productoComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrardescuento_productoComprobanteFacturaDetalle() {
		return this.mostrardescuento_productoComprobanteFacturaDetalle;
	}

	public void setMostrardescuento_productoComprobanteFacturaDetalle(Boolean mostrardescuento_productoComprobanteFacturaDetalle) {
		this.mostrardescuento_productoComprobanteFacturaDetalle= mostrardescuento_productoComprobanteFacturaDetalle;
	}

	public Boolean getActivardescuento_productoComprobanteFacturaDetalle() {
		return this.activardescuento_productoComprobanteFacturaDetalle;
	}

	public void setActivardescuento_productoComprobanteFacturaDetalle(Boolean activardescuento_productoComprobanteFacturaDetalle) {
		this.activardescuento_productoComprobanteFacturaDetalle= activardescuento_productoComprobanteFacturaDetalle;
	}

	public Border setResaltarivaComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarivaComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaComprobanteFacturaDetalle() {
		return this.resaltarivaComprobanteFacturaDetalle;
	}

	public void setResaltarivaComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarivaComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarivaComprobanteFacturaDetalle() {
		return this.mostrarivaComprobanteFacturaDetalle;
	}

	public void setMostrarivaComprobanteFacturaDetalle(Boolean mostrarivaComprobanteFacturaDetalle) {
		this.mostrarivaComprobanteFacturaDetalle= mostrarivaComprobanteFacturaDetalle;
	}

	public Boolean getActivarivaComprobanteFacturaDetalle() {
		return this.activarivaComprobanteFacturaDetalle;
	}

	public void setActivarivaComprobanteFacturaDetalle(Boolean activarivaComprobanteFacturaDetalle) {
		this.activarivaComprobanteFacturaDetalle= activarivaComprobanteFacturaDetalle;
	}

	public Border setResaltarserieComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltarserieComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieComprobanteFacturaDetalle() {
		return this.resaltarserieComprobanteFacturaDetalle;
	}

	public void setResaltarserieComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarserieComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrarserieComprobanteFacturaDetalle() {
		return this.mostrarserieComprobanteFacturaDetalle;
	}

	public void setMostrarserieComprobanteFacturaDetalle(Boolean mostrarserieComprobanteFacturaDetalle) {
		this.mostrarserieComprobanteFacturaDetalle= mostrarserieComprobanteFacturaDetalle;
	}

	public Boolean getActivarserieComprobanteFacturaDetalle() {
		return this.activarserieComprobanteFacturaDetalle;
	}

	public void setActivarserieComprobanteFacturaDetalle(Boolean activarserieComprobanteFacturaDetalle) {
		this.activarserieComprobanteFacturaDetalle= activarserieComprobanteFacturaDetalle;
	}

	public Border setResaltardescripcionComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturadetalleBeanSwingJInternalFrame.jTtoolBarComprobanteFacturaDetalle.setBorder(borderResaltar);
		
		this.resaltardescripcionComprobanteFacturaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComprobanteFacturaDetalle() {
		return this.resaltardescripcionComprobanteFacturaDetalle;
	}

	public void setResaltardescripcionComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltardescripcionComprobanteFacturaDetalle= borderResaltar;
	}

	public Boolean getMostrardescripcionComprobanteFacturaDetalle() {
		return this.mostrardescripcionComprobanteFacturaDetalle;
	}

	public void setMostrardescripcionComprobanteFacturaDetalle(Boolean mostrardescripcionComprobanteFacturaDetalle) {
		this.mostrardescripcionComprobanteFacturaDetalle= mostrardescripcionComprobanteFacturaDetalle;
	}

	public Boolean getActivardescripcionComprobanteFacturaDetalle() {
		return this.activardescripcionComprobanteFacturaDetalle;
	}

	public void setActivardescripcionComprobanteFacturaDetalle(Boolean activardescripcionComprobanteFacturaDetalle) {
		this.activardescripcionComprobanteFacturaDetalle= activardescripcionComprobanteFacturaDetalle;
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
		
		
		this.setMostraridComprobanteFacturaDetalle(esInicial);
		this.setMostrarid_empresaComprobanteFacturaDetalle(esInicial);
		this.setMostrarid_sucursalComprobanteFacturaDetalle(esInicial);
		this.setMostrarid_clienteComprobanteFacturaDetalle(esInicial);
		this.setMostrarfecha_inicioComprobanteFacturaDetalle(esInicial);
		this.setMostrarfecha_finComprobanteFacturaDetalle(esInicial);
		this.setMostrarsecuencialComprobanteFacturaDetalle(esInicial);
		this.setMostrarfechaComprobanteFacturaDetalle(esInicial);
		this.setMostrarnombre_clienteComprobanteFacturaDetalle(esInicial);
		this.setMostrardescuentoComprobanteFacturaDetalle(esInicial);
		this.setMostrarsubtotalComprobanteFacturaDetalle(esInicial);
		this.setMostrartotalComprobanteFacturaDetalle(esInicial);
		this.setMostrarnombre_bodegaComprobanteFacturaDetalle(esInicial);
		this.setMostrarnombre_productoComprobanteFacturaDetalle(esInicial);
		this.setMostrarcantidadComprobanteFacturaDetalle(esInicial);
		this.setMostrarprecioComprobanteFacturaDetalle(esInicial);
		this.setMostrardescuento_productoComprobanteFacturaDetalle(esInicial);
		this.setMostrarivaComprobanteFacturaDetalle(esInicial);
		this.setMostrarserieComprobanteFacturaDetalle(esInicial);
		this.setMostrardescripcionComprobanteFacturaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.ID)) {
				this.setMostraridComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHA)) {
				this.setMostrarfechaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.TOTAL)) {
				this.setMostrartotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.PRECIO)) {
				this.setMostrarprecioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO)) {
				this.setMostrardescuento_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IVA)) {
				this.setMostrarivaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SERIE)) {
				this.setMostrarserieComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComprobanteFacturaDetalle(esAsigna);
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
		
		
		this.setActivaridComprobanteFacturaDetalle(esInicial);
		this.setActivarid_empresaComprobanteFacturaDetalle(esInicial);
		this.setActivarid_sucursalComprobanteFacturaDetalle(esInicial);
		this.setActivarid_clienteComprobanteFacturaDetalle(esInicial);
		this.setActivarfecha_inicioComprobanteFacturaDetalle(esInicial);
		this.setActivarfecha_finComprobanteFacturaDetalle(esInicial);
		this.setActivarsecuencialComprobanteFacturaDetalle(esInicial);
		this.setActivarfechaComprobanteFacturaDetalle(esInicial);
		this.setActivarnombre_clienteComprobanteFacturaDetalle(esInicial);
		this.setActivardescuentoComprobanteFacturaDetalle(esInicial);
		this.setActivarsubtotalComprobanteFacturaDetalle(esInicial);
		this.setActivartotalComprobanteFacturaDetalle(esInicial);
		this.setActivarnombre_bodegaComprobanteFacturaDetalle(esInicial);
		this.setActivarnombre_productoComprobanteFacturaDetalle(esInicial);
		this.setActivarcantidadComprobanteFacturaDetalle(esInicial);
		this.setActivarprecioComprobanteFacturaDetalle(esInicial);
		this.setActivardescuento_productoComprobanteFacturaDetalle(esInicial);
		this.setActivarivaComprobanteFacturaDetalle(esInicial);
		this.setActivarserieComprobanteFacturaDetalle(esInicial);
		this.setActivardescripcionComprobanteFacturaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.ID)) {
				this.setActivaridComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHA)) {
				this.setActivarfechaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.TOTAL)) {
				this.setActivartotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.PRECIO)) {
				this.setActivarprecioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO)) {
				this.setActivardescuento_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IVA)) {
				this.setActivarivaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SERIE)) {
				this.setActivarserieComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComprobanteFacturaDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobanteFacturaDetalle(esInicial);
		this.setResaltarid_empresaComprobanteFacturaDetalle(esInicial);
		this.setResaltarid_sucursalComprobanteFacturaDetalle(esInicial);
		this.setResaltarid_clienteComprobanteFacturaDetalle(esInicial);
		this.setResaltarfecha_inicioComprobanteFacturaDetalle(esInicial);
		this.setResaltarfecha_finComprobanteFacturaDetalle(esInicial);
		this.setResaltarsecuencialComprobanteFacturaDetalle(esInicial);
		this.setResaltarfechaComprobanteFacturaDetalle(esInicial);
		this.setResaltarnombre_clienteComprobanteFacturaDetalle(esInicial);
		this.setResaltardescuentoComprobanteFacturaDetalle(esInicial);
		this.setResaltarsubtotalComprobanteFacturaDetalle(esInicial);
		this.setResaltartotalComprobanteFacturaDetalle(esInicial);
		this.setResaltarnombre_bodegaComprobanteFacturaDetalle(esInicial);
		this.setResaltarnombre_productoComprobanteFacturaDetalle(esInicial);
		this.setResaltarcantidadComprobanteFacturaDetalle(esInicial);
		this.setResaltarprecioComprobanteFacturaDetalle(esInicial);
		this.setResaltardescuento_productoComprobanteFacturaDetalle(esInicial);
		this.setResaltarivaComprobanteFacturaDetalle(esInicial);
		this.setResaltarserieComprobanteFacturaDetalle(esInicial);
		this.setResaltardescripcionComprobanteFacturaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.ID)) {
				this.setResaltaridComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.FECHA)) {
				this.setResaltarfechaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.TOTAL)) {
				this.setResaltartotalComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.PRECIO)) {
				this.setResaltarprecioComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO)) {
				this.setResaltardescuento_productoComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.IVA)) {
				this.setResaltarivaComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.SERIE)) {
				this.setResaltarserieComprobanteFacturaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaDetalleConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComprobanteFacturaDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle=true;

	public Boolean getMostrarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle() {
		return this.mostrarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle;
	}

	public void setMostrarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle=true;

	public Boolean getActivarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle() {
		return this.activarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle;
	}

	public void setActivarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle(Boolean habilitarResaltar) {
		this.activarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle=null;

	public Border getResaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle() {
		return this.resaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle;
	}

	public void setResaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle(Border borderResaltar) {
		this.resaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle= borderResaltar;
	}

	public void setResaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaDetalleBeanSwingJInternalFrame comprobantefacturadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobanteFacturaDetalleComprobanteFacturaDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}