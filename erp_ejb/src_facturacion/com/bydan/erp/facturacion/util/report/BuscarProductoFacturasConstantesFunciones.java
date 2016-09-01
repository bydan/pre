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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BuscarProductoFacturasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="BuscarProductoFacturas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BuscarProductoFacturas"+BuscarProductoFacturasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BuscarProductoFacturasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BuscarProductoFacturasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BuscarProductoFacturasConstantesFunciones.SCHEMA+"_"+BuscarProductoFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BuscarProductoFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BuscarProductoFacturasConstantesFunciones.SCHEMA+"_"+BuscarProductoFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BuscarProductoFacturasConstantesFunciones.SCHEMA+"_"+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BuscarProductoFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BuscarProductoFacturasConstantesFunciones.SCHEMA+"_"+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BuscarProductoFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BuscarProductoFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BuscarProductoFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BuscarProductoFacturasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BuscarProductoFacturasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BuscarProductoFacturasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BuscarProductoFacturasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Buscar Producto Facturases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Buscar Producto Facturas";
	public static final String SCLASSWEBTITULO_LOWER="Buscar Producto Facturas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BuscarProductoFacturas";
	public static final String OBJECTNAME="buscarproductofacturas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="buscar_producto_facturas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select buscarproductofacturas from "+BuscarProductoFacturasConstantesFunciones.SPERSISTENCENAME+" buscarproductofacturas";
	public static String QUERYSELECTNATIVE="select "+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".id,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".version_row,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".id_producto,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".id_empresa,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".id_sucursal,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".id_cliente,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".numero_pre_impreso,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".nombre_vendedor,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".fecha_emision,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".numero_pre_impreso_dato,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".total,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".nombre_unidad,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".nombre_bodega,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".nombre_producto,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".cantidad,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".precio,"+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME+".descuento from "+BuscarProductoFacturasConstantesFunciones.SCHEMA+"."+BuscarProductoFacturasConstantesFunciones.TABLENAME;//+" as "+BuscarProductoFacturasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROPREIMPRESODATO= "numero_pre_impreso_dato";
    public static final String TOTAL= "total";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTO= "descuento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROPREIMPRESODATO= "Numero Pre Impreso Dato";
		public static final String LABEL_NUMEROPREIMPRESODATO_LOWER= "Numero Pre Impreso Dato";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unidad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_PRE_IMPRESO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getBuscarProductoFacturasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.IDEMPRESA)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.IDCLIENTE)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISION)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESODATO;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.TOTAL)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.CANTIDAD)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.PRECIO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(BuscarProductoFacturasConstantesFunciones.DESCUENTO)) {sLabelColumna=BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBuscarProductoFacturasDescripcion(BuscarProductoFacturas buscarproductofacturas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(buscarproductofacturas !=null/* && buscarproductofacturas.getId()!=0*/) {
			if(buscarproductofacturas.getId()!=null) {
				sDescripcion=buscarproductofacturas.getId().toString();
			}//buscarproductofacturasbuscarproductofacturas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBuscarProductoFacturasDescripcionDetallado(BuscarProductoFacturas buscarproductofacturas) {
		String sDescripcion="";
			
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.ID+"=";
		sDescripcion+=buscarproductofacturas.getId().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=buscarproductofacturas.getVersionRow().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=buscarproductofacturas.getid_producto().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=buscarproductofacturas.getid_empresa().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=buscarproductofacturas.getid_sucursal().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=buscarproductofacturas.getid_cliente().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=buscarproductofacturas.getnumero_pre_impreso()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=buscarproductofacturas.getfecha_emision_desde().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=buscarproductofacturas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=buscarproductofacturas.getnombre_vendedor()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=buscarproductofacturas.getnombre_completo_cliente()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=buscarproductofacturas.getfecha_emision().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO+"=";
		sDescripcion+=buscarproductofacturas.getnumero_pre_impreso_dato()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.TOTAL+"=";
		sDescripcion+=buscarproductofacturas.gettotal().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=buscarproductofacturas.getnombre_unidad()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=buscarproductofacturas.getnombre_bodega()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=buscarproductofacturas.getnombre_producto()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=buscarproductofacturas.getcantidad().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.PRECIO+"=";
		sDescripcion+=buscarproductofacturas.getprecio().toString()+",";
		sDescripcion+=BuscarProductoFacturasConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=buscarproductofacturas.getdescuento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBuscarProductoFacturasDescripcion(BuscarProductoFacturas buscarproductofacturas,String sValor) throws Exception {			
		if(buscarproductofacturas !=null) {
			//buscarproductofacturasbuscarproductofacturas.getId().toString();
		}		
	}
	
		

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
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
		} else if(sNombreIndice.equals("BusquedaBuscarProductoFacturas")) {
			sNombreIndice="Tipo=  Por Producto Por Cliente Por Numero Pre Impreso Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaBuscarProductoFacturas(Long id_producto,Long id_cliente,String numero_pre_impreso,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(numero_pre_impreso!=null) {sDetalleIndice+=" Numero Pre Impreso="+numero_pre_impreso;}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		buscarproductofacturas.setnombre_vendedor(buscarproductofacturas.getnombre_vendedor().trim());
		buscarproductofacturas.setnombre_completo_cliente(buscarproductofacturas.getnombre_completo_cliente().trim());
		buscarproductofacturas.setnumero_pre_impreso_dato(buscarproductofacturas.getnumero_pre_impreso_dato().trim());
		buscarproductofacturas.setnombre_unidad(buscarproductofacturas.getnombre_unidad().trim());
		buscarproductofacturas.setnombre_bodega(buscarproductofacturas.getnombre_bodega().trim());
		buscarproductofacturas.setnombre_producto(buscarproductofacturas.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosBuscarProductoFacturass(List<BuscarProductoFacturas> buscarproductofacturass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BuscarProductoFacturas buscarproductofacturas: buscarproductofacturass) {
			buscarproductofacturas.setnombre_vendedor(buscarproductofacturas.getnombre_vendedor().trim());
			buscarproductofacturas.setnombre_completo_cliente(buscarproductofacturas.getnombre_completo_cliente().trim());
			buscarproductofacturas.setnumero_pre_impreso_dato(buscarproductofacturas.getnumero_pre_impreso_dato().trim());
			buscarproductofacturas.setnombre_unidad(buscarproductofacturas.getnombre_unidad().trim());
			buscarproductofacturas.setnombre_bodega(buscarproductofacturas.getnombre_bodega().trim());
			buscarproductofacturas.setnombre_producto(buscarproductofacturas.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && buscarproductofacturas.getConCambioAuxiliar()) {
			buscarproductofacturas.setIsDeleted(buscarproductofacturas.getIsDeletedAuxiliar());	
			buscarproductofacturas.setIsNew(buscarproductofacturas.getIsNewAuxiliar());	
			buscarproductofacturas.setIsChanged(buscarproductofacturas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			buscarproductofacturas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			buscarproductofacturas.setIsDeletedAuxiliar(false);	
			buscarproductofacturas.setIsNewAuxiliar(false);	
			buscarproductofacturas.setIsChangedAuxiliar(false);
			
			buscarproductofacturas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBuscarProductoFacturass(List<BuscarProductoFacturas> buscarproductofacturass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BuscarProductoFacturas buscarproductofacturas : buscarproductofacturass) {
			if(conAsignarBase && buscarproductofacturas.getConCambioAuxiliar()) {
				buscarproductofacturas.setIsDeleted(buscarproductofacturas.getIsDeletedAuxiliar());	
				buscarproductofacturas.setIsNew(buscarproductofacturas.getIsNewAuxiliar());	
				buscarproductofacturas.setIsChanged(buscarproductofacturas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				buscarproductofacturas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				buscarproductofacturas.setIsDeletedAuxiliar(false);	
				buscarproductofacturas.setIsNewAuxiliar(false);	
				buscarproductofacturas.setIsChangedAuxiliar(false);
				
				buscarproductofacturas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturas,Boolean conEnteros) throws Exception  {
		buscarproductofacturas.settotal(0.0);
		buscarproductofacturas.setprecio(0.0);
		buscarproductofacturas.setdescuento(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			buscarproductofacturas.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresBuscarProductoFacturass(List<BuscarProductoFacturas> buscarproductofacturass,Boolean conEnteros) throws Exception  {
		
		for(BuscarProductoFacturas buscarproductofacturas: buscarproductofacturass) {
			buscarproductofacturas.settotal(0.0);
			buscarproductofacturas.setprecio(0.0);
			buscarproductofacturas.setdescuento(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				buscarproductofacturas.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaBuscarProductoFacturas(List<BuscarProductoFacturas> buscarproductofacturass,BuscarProductoFacturas buscarproductofacturasAux) throws Exception  {
		BuscarProductoFacturasConstantesFunciones.InicializarValoresBuscarProductoFacturas(buscarproductofacturasAux,true);
		
		for(BuscarProductoFacturas buscarproductofacturas: buscarproductofacturass) {
			if(buscarproductofacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			buscarproductofacturasAux.settotal(buscarproductofacturasAux.gettotal()+buscarproductofacturas.gettotal());			
			buscarproductofacturasAux.setcantidad(buscarproductofacturasAux.getcantidad()+buscarproductofacturas.getcantidad());			
			buscarproductofacturasAux.setprecio(buscarproductofacturasAux.getprecio()+buscarproductofacturas.getprecio());			
			buscarproductofacturasAux.setdescuento(buscarproductofacturasAux.getdescuento()+buscarproductofacturas.getdescuento());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBuscarProductoFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BuscarProductoFacturasConstantesFunciones.getArrayColumnasGlobalesBuscarProductoFacturas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBuscarProductoFacturas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BuscarProductoFacturasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BuscarProductoFacturasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBuscarProductoFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BuscarProductoFacturas> buscarproductofacturass,BuscarProductoFacturas buscarproductofacturas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BuscarProductoFacturas buscarproductofacturasAux: buscarproductofacturass) {
			if(buscarproductofacturasAux!=null && buscarproductofacturas!=null) {
				if((buscarproductofacturasAux.getId()==null && buscarproductofacturas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(buscarproductofacturasAux.getId()!=null && buscarproductofacturas.getId()!=null){
					if(buscarproductofacturasAux.getId().equals(buscarproductofacturas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBuscarProductoFacturas(List<BuscarProductoFacturas> buscarproductofacturass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
	
		for(BuscarProductoFacturas buscarproductofacturas: buscarproductofacturass) {			
			if(buscarproductofacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=buscarproductofacturas.gettotal();
			precioTotal+=buscarproductofacturas.getprecio();
			descuentoTotal+=buscarproductofacturas.getdescuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BuscarProductoFacturasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BuscarProductoFacturasConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BuscarProductoFacturasConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBuscarProductoFacturas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_ID, BuscarProductoFacturasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_VERSIONROW, BuscarProductoFacturasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREVENDEDOR, BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISION, BuscarProductoFacturasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESODATO, BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL, BuscarProductoFacturasConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREUNIDAD, BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREBODEGA, BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREPRODUCTO, BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_CANTIDAD, BuscarProductoFacturasConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO, BuscarProductoFacturasConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO, BuscarProductoFacturasConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBuscarProductoFacturas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BuscarProductoFacturasConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBuscarProductoFacturas() throws Exception  {
		return BuscarProductoFacturasConstantesFunciones.getTiposSeleccionarBuscarProductoFacturas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBuscarProductoFacturas(Boolean conFk) throws Exception  {
		return BuscarProductoFacturasConstantesFunciones.getTiposSeleccionarBuscarProductoFacturas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBuscarProductoFacturas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESODATO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBuscarProductoFacturas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturasAux) throws Exception {
		
			buscarproductofacturasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(buscarproductofacturasAux.getProducto()));
			buscarproductofacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(buscarproductofacturasAux.getEmpresa()));
			buscarproductofacturasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(buscarproductofacturasAux.getSucursal()));
			buscarproductofacturasAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(buscarproductofacturasAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBuscarProductoFacturas(List<BuscarProductoFacturas> buscarproductofacturassTemp) throws Exception {
		for(BuscarProductoFacturas buscarproductofacturasAux:buscarproductofacturassTemp) {
			
			buscarproductofacturasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(buscarproductofacturasAux.getProducto()));
			buscarproductofacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(buscarproductofacturasAux.getEmpresa()));
			buscarproductofacturasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(buscarproductofacturasAux.getSucursal()));
			buscarproductofacturasAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(buscarproductofacturasAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBuscarProductoFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBuscarProductoFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBuscarProductoFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BuscarProductoFacturasConstantesFunciones.getClassesRelationshipsOfBuscarProductoFacturas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBuscarProductoFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBuscarProductoFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BuscarProductoFacturasConstantesFunciones.getClassesRelationshipsFromStringsOfBuscarProductoFacturas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBuscarProductoFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BuscarProductoFacturas buscarproductofacturas,List<BuscarProductoFacturas> buscarproductofacturass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(BuscarProductoFacturas buscarproductofacturas,List<BuscarProductoFacturas> buscarproductofacturass) throws Exception {
		try	{			
			for(BuscarProductoFacturas buscarproductofacturasLocal:buscarproductofacturass) {
				if(buscarproductofacturasLocal.getId().equals(buscarproductofacturas.getId())) {
					buscarproductofacturasLocal.setIsSelected(buscarproductofacturas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBuscarProductoFacturas(List<BuscarProductoFacturas> buscarproductofacturassAux) throws Exception {
		//this.buscarproductofacturassAux=buscarproductofacturassAux;
		
		for(BuscarProductoFacturas buscarproductofacturasAux:buscarproductofacturassAux) {
			if(buscarproductofacturasAux.getIsChanged()) {
				buscarproductofacturasAux.setIsChanged(false);
			}		
			
			if(buscarproductofacturasAux.getIsNew()) {
				buscarproductofacturasAux.setIsNew(false);
			}	
			
			if(buscarproductofacturasAux.getIsDeleted()) {
				buscarproductofacturasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturasAux) throws Exception {
		//this.buscarproductofacturasAux=buscarproductofacturasAux;
		
			if(buscarproductofacturasAux.getIsChanged()) {
				buscarproductofacturasAux.setIsChanged(false);
			}		
			
			if(buscarproductofacturasAux.getIsNew()) {
				buscarproductofacturasAux.setIsNew(false);
			}	
			
			if(buscarproductofacturasAux.getIsDeleted()) {
				buscarproductofacturasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BuscarProductoFacturas buscarproductofacturasAsignar,BuscarProductoFacturas buscarproductofacturas) throws Exception {
		buscarproductofacturasAsignar.setId(buscarproductofacturas.getId());	
		buscarproductofacturasAsignar.setVersionRow(buscarproductofacturas.getVersionRow());	
		buscarproductofacturasAsignar.setnombre_vendedor(buscarproductofacturas.getnombre_vendedor());	
		buscarproductofacturasAsignar.setnombre_completo_cliente(buscarproductofacturas.getnombre_completo_cliente());	
		buscarproductofacturasAsignar.setfecha_emision(buscarproductofacturas.getfecha_emision());	
		buscarproductofacturasAsignar.setnumero_pre_impreso_dato(buscarproductofacturas.getnumero_pre_impreso_dato());	
		buscarproductofacturasAsignar.settotal(buscarproductofacturas.gettotal());	
		buscarproductofacturasAsignar.setnombre_unidad(buscarproductofacturas.getnombre_unidad());	
		buscarproductofacturasAsignar.setnombre_bodega(buscarproductofacturas.getnombre_bodega());	
		buscarproductofacturasAsignar.setnombre_producto(buscarproductofacturas.getnombre_producto());	
		buscarproductofacturasAsignar.setcantidad(buscarproductofacturas.getcantidad());	
		buscarproductofacturasAsignar.setprecio(buscarproductofacturas.getprecio());	
		buscarproductofacturasAsignar.setdescuento(buscarproductofacturas.getdescuento());	
	}
	
	public static void inicializarBuscarProductoFacturas(BuscarProductoFacturas buscarproductofacturas) throws Exception {
		try {
				buscarproductofacturas.setId(0L);	
					
				buscarproductofacturas.setnombre_vendedor("");	
				buscarproductofacturas.setnombre_completo_cliente("");	
				buscarproductofacturas.setfecha_emision(new Date());	
				buscarproductofacturas.setnumero_pre_impreso_dato("");	
				buscarproductofacturas.settotal(0.0);	
				buscarproductofacturas.setnombre_unidad("");	
				buscarproductofacturas.setnombre_bodega("");	
				buscarproductofacturas.setnombre_producto("");	
				buscarproductofacturas.setcantidad(0);	
				buscarproductofacturas.setprecio(0.0);	
				buscarproductofacturas.setdescuento(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBuscarProductoFacturas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NUMEROPREIMPRESODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BuscarProductoFacturasConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBuscarProductoFacturas(String sTipo,Row row,Workbook workbook,BuscarProductoFacturas buscarproductofacturas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnumero_pre_impreso_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(buscarproductofacturas.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBuscarProductoFacturas="";
	
	public String getsFinalQueryBuscarProductoFacturas() {
		return this.sFinalQueryBuscarProductoFacturas;
	}
	
	public void setsFinalQueryBuscarProductoFacturas(String sFinalQueryBuscarProductoFacturas) {
		this.sFinalQueryBuscarProductoFacturas= sFinalQueryBuscarProductoFacturas;
	}
	
	public Border resaltarSeleccionarBuscarProductoFacturas=null;
	
	public Border setResaltarSeleccionarBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBuscarProductoFacturas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBuscarProductoFacturas() {
		return this.resaltarSeleccionarBuscarProductoFacturas;
	}
	
	public void setResaltarSeleccionarBuscarProductoFacturas(Border borderResaltarSeleccionarBuscarProductoFacturas) {
		this.resaltarSeleccionarBuscarProductoFacturas= borderResaltarSeleccionarBuscarProductoFacturas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBuscarProductoFacturas=null;
	public Boolean mostraridBuscarProductoFacturas=true;
	public Boolean activaridBuscarProductoFacturas=true;

	public Border resaltarid_productoBuscarProductoFacturas=null;
	public Boolean mostrarid_productoBuscarProductoFacturas=true;
	public Boolean activarid_productoBuscarProductoFacturas=true;
	public Boolean cargarid_productoBuscarProductoFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoBuscarProductoFacturas=false;//ConEventDepend=true

	public Border resaltarid_empresaBuscarProductoFacturas=null;
	public Boolean mostrarid_empresaBuscarProductoFacturas=true;
	public Boolean activarid_empresaBuscarProductoFacturas=true;
	public Boolean cargarid_empresaBuscarProductoFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBuscarProductoFacturas=false;//ConEventDepend=true

	public Border resaltarid_sucursalBuscarProductoFacturas=null;
	public Boolean mostrarid_sucursalBuscarProductoFacturas=true;
	public Boolean activarid_sucursalBuscarProductoFacturas=true;
	public Boolean cargarid_sucursalBuscarProductoFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBuscarProductoFacturas=false;//ConEventDepend=true

	public Border resaltarid_clienteBuscarProductoFacturas=null;
	public Boolean mostrarid_clienteBuscarProductoFacturas=true;
	public Boolean activarid_clienteBuscarProductoFacturas=true;
	public Boolean cargarid_clienteBuscarProductoFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteBuscarProductoFacturas=false;//ConEventDepend=true

	public Border resaltarnumero_pre_impresoBuscarProductoFacturas=null;
	public Boolean mostrarnumero_pre_impresoBuscarProductoFacturas=true;
	public Boolean activarnumero_pre_impresoBuscarProductoFacturas=true;

	public Border resaltarfecha_emision_desdeBuscarProductoFacturas=null;
	public Boolean mostrarfecha_emision_desdeBuscarProductoFacturas=true;
	public Boolean activarfecha_emision_desdeBuscarProductoFacturas=true;

	public Border resaltarfecha_emision_hastaBuscarProductoFacturas=null;
	public Boolean mostrarfecha_emision_hastaBuscarProductoFacturas=true;
	public Boolean activarfecha_emision_hastaBuscarProductoFacturas=true;

	public Border resaltarnombre_vendedorBuscarProductoFacturas=null;
	public Boolean mostrarnombre_vendedorBuscarProductoFacturas=true;
	public Boolean activarnombre_vendedorBuscarProductoFacturas=true;

	public Border resaltarnombre_completo_clienteBuscarProductoFacturas=null;
	public Boolean mostrarnombre_completo_clienteBuscarProductoFacturas=true;
	public Boolean activarnombre_completo_clienteBuscarProductoFacturas=true;

	public Border resaltarfecha_emisionBuscarProductoFacturas=null;
	public Boolean mostrarfecha_emisionBuscarProductoFacturas=true;
	public Boolean activarfecha_emisionBuscarProductoFacturas=true;

	public Border resaltarnumero_pre_impreso_datoBuscarProductoFacturas=null;
	public Boolean mostrarnumero_pre_impreso_datoBuscarProductoFacturas=true;
	public Boolean activarnumero_pre_impreso_datoBuscarProductoFacturas=true;

	public Border resaltartotalBuscarProductoFacturas=null;
	public Boolean mostrartotalBuscarProductoFacturas=true;
	public Boolean activartotalBuscarProductoFacturas=true;

	public Border resaltarnombre_unidadBuscarProductoFacturas=null;
	public Boolean mostrarnombre_unidadBuscarProductoFacturas=true;
	public Boolean activarnombre_unidadBuscarProductoFacturas=true;

	public Border resaltarnombre_bodegaBuscarProductoFacturas=null;
	public Boolean mostrarnombre_bodegaBuscarProductoFacturas=true;
	public Boolean activarnombre_bodegaBuscarProductoFacturas=true;

	public Border resaltarnombre_productoBuscarProductoFacturas=null;
	public Boolean mostrarnombre_productoBuscarProductoFacturas=true;
	public Boolean activarnombre_productoBuscarProductoFacturas=true;

	public Border resaltarcantidadBuscarProductoFacturas=null;
	public Boolean mostrarcantidadBuscarProductoFacturas=true;
	public Boolean activarcantidadBuscarProductoFacturas=true;

	public Border resaltarprecioBuscarProductoFacturas=null;
	public Boolean mostrarprecioBuscarProductoFacturas=true;
	public Boolean activarprecioBuscarProductoFacturas=true;

	public Border resaltardescuentoBuscarProductoFacturas=null;
	public Boolean mostrardescuentoBuscarProductoFacturas=true;
	public Boolean activardescuentoBuscarProductoFacturas=true;

	
	

	public Border setResaltaridBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltaridBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBuscarProductoFacturas() {
		return this.resaltaridBuscarProductoFacturas;
	}

	public void setResaltaridBuscarProductoFacturas(Border borderResaltar) {
		this.resaltaridBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostraridBuscarProductoFacturas() {
		return this.mostraridBuscarProductoFacturas;
	}

	public void setMostraridBuscarProductoFacturas(Boolean mostraridBuscarProductoFacturas) {
		this.mostraridBuscarProductoFacturas= mostraridBuscarProductoFacturas;
	}

	public Boolean getActivaridBuscarProductoFacturas() {
		return this.activaridBuscarProductoFacturas;
	}

	public void setActivaridBuscarProductoFacturas(Boolean activaridBuscarProductoFacturas) {
		this.activaridBuscarProductoFacturas= activaridBuscarProductoFacturas;
	}

	public Border setResaltarid_productoBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarid_productoBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoBuscarProductoFacturas() {
		return this.resaltarid_productoBuscarProductoFacturas;
	}

	public void setResaltarid_productoBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarid_productoBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarid_productoBuscarProductoFacturas() {
		return this.mostrarid_productoBuscarProductoFacturas;
	}

	public void setMostrarid_productoBuscarProductoFacturas(Boolean mostrarid_productoBuscarProductoFacturas) {
		this.mostrarid_productoBuscarProductoFacturas= mostrarid_productoBuscarProductoFacturas;
	}

	public Boolean getActivarid_productoBuscarProductoFacturas() {
		return this.activarid_productoBuscarProductoFacturas;
	}

	public void setActivarid_productoBuscarProductoFacturas(Boolean activarid_productoBuscarProductoFacturas) {
		this.activarid_productoBuscarProductoFacturas= activarid_productoBuscarProductoFacturas;
	}

	public Boolean getCargarid_productoBuscarProductoFacturas() {
		return this.cargarid_productoBuscarProductoFacturas;
	}

	public void setCargarid_productoBuscarProductoFacturas(Boolean cargarid_productoBuscarProductoFacturas) {
		this.cargarid_productoBuscarProductoFacturas= cargarid_productoBuscarProductoFacturas;
	}

	public Border setResaltarid_empresaBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarid_empresaBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBuscarProductoFacturas() {
		return this.resaltarid_empresaBuscarProductoFacturas;
	}

	public void setResaltarid_empresaBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarid_empresaBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarid_empresaBuscarProductoFacturas() {
		return this.mostrarid_empresaBuscarProductoFacturas;
	}

	public void setMostrarid_empresaBuscarProductoFacturas(Boolean mostrarid_empresaBuscarProductoFacturas) {
		this.mostrarid_empresaBuscarProductoFacturas= mostrarid_empresaBuscarProductoFacturas;
	}

	public Boolean getActivarid_empresaBuscarProductoFacturas() {
		return this.activarid_empresaBuscarProductoFacturas;
	}

	public void setActivarid_empresaBuscarProductoFacturas(Boolean activarid_empresaBuscarProductoFacturas) {
		this.activarid_empresaBuscarProductoFacturas= activarid_empresaBuscarProductoFacturas;
	}

	public Boolean getCargarid_empresaBuscarProductoFacturas() {
		return this.cargarid_empresaBuscarProductoFacturas;
	}

	public void setCargarid_empresaBuscarProductoFacturas(Boolean cargarid_empresaBuscarProductoFacturas) {
		this.cargarid_empresaBuscarProductoFacturas= cargarid_empresaBuscarProductoFacturas;
	}

	public Border setResaltarid_sucursalBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBuscarProductoFacturas() {
		return this.resaltarid_sucursalBuscarProductoFacturas;
	}

	public void setResaltarid_sucursalBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarid_sucursalBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBuscarProductoFacturas() {
		return this.mostrarid_sucursalBuscarProductoFacturas;
	}

	public void setMostrarid_sucursalBuscarProductoFacturas(Boolean mostrarid_sucursalBuscarProductoFacturas) {
		this.mostrarid_sucursalBuscarProductoFacturas= mostrarid_sucursalBuscarProductoFacturas;
	}

	public Boolean getActivarid_sucursalBuscarProductoFacturas() {
		return this.activarid_sucursalBuscarProductoFacturas;
	}

	public void setActivarid_sucursalBuscarProductoFacturas(Boolean activarid_sucursalBuscarProductoFacturas) {
		this.activarid_sucursalBuscarProductoFacturas= activarid_sucursalBuscarProductoFacturas;
	}

	public Boolean getCargarid_sucursalBuscarProductoFacturas() {
		return this.cargarid_sucursalBuscarProductoFacturas;
	}

	public void setCargarid_sucursalBuscarProductoFacturas(Boolean cargarid_sucursalBuscarProductoFacturas) {
		this.cargarid_sucursalBuscarProductoFacturas= cargarid_sucursalBuscarProductoFacturas;
	}

	public Border setResaltarid_clienteBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarid_clienteBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteBuscarProductoFacturas() {
		return this.resaltarid_clienteBuscarProductoFacturas;
	}

	public void setResaltarid_clienteBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarid_clienteBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarid_clienteBuscarProductoFacturas() {
		return this.mostrarid_clienteBuscarProductoFacturas;
	}

	public void setMostrarid_clienteBuscarProductoFacturas(Boolean mostrarid_clienteBuscarProductoFacturas) {
		this.mostrarid_clienteBuscarProductoFacturas= mostrarid_clienteBuscarProductoFacturas;
	}

	public Boolean getActivarid_clienteBuscarProductoFacturas() {
		return this.activarid_clienteBuscarProductoFacturas;
	}

	public void setActivarid_clienteBuscarProductoFacturas(Boolean activarid_clienteBuscarProductoFacturas) {
		this.activarid_clienteBuscarProductoFacturas= activarid_clienteBuscarProductoFacturas;
	}

	public Boolean getCargarid_clienteBuscarProductoFacturas() {
		return this.cargarid_clienteBuscarProductoFacturas;
	}

	public void setCargarid_clienteBuscarProductoFacturas(Boolean cargarid_clienteBuscarProductoFacturas) {
		this.cargarid_clienteBuscarProductoFacturas= cargarid_clienteBuscarProductoFacturas;
	}

	public Border setResaltarnumero_pre_impresoBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoBuscarProductoFacturas() {
		return this.resaltarnumero_pre_impresoBuscarProductoFacturas;
	}

	public void setResaltarnumero_pre_impresoBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnumero_pre_impresoBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoBuscarProductoFacturas() {
		return this.mostrarnumero_pre_impresoBuscarProductoFacturas;
	}

	public void setMostrarnumero_pre_impresoBuscarProductoFacturas(Boolean mostrarnumero_pre_impresoBuscarProductoFacturas) {
		this.mostrarnumero_pre_impresoBuscarProductoFacturas= mostrarnumero_pre_impresoBuscarProductoFacturas;
	}

	public Boolean getActivarnumero_pre_impresoBuscarProductoFacturas() {
		return this.activarnumero_pre_impresoBuscarProductoFacturas;
	}

	public void setActivarnumero_pre_impresoBuscarProductoFacturas(Boolean activarnumero_pre_impresoBuscarProductoFacturas) {
		this.activarnumero_pre_impresoBuscarProductoFacturas= activarnumero_pre_impresoBuscarProductoFacturas;
	}

	public Border setResaltarfecha_emision_desdeBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeBuscarProductoFacturas() {
		return this.resaltarfecha_emision_desdeBuscarProductoFacturas;
	}

	public void setResaltarfecha_emision_desdeBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeBuscarProductoFacturas() {
		return this.mostrarfecha_emision_desdeBuscarProductoFacturas;
	}

	public void setMostrarfecha_emision_desdeBuscarProductoFacturas(Boolean mostrarfecha_emision_desdeBuscarProductoFacturas) {
		this.mostrarfecha_emision_desdeBuscarProductoFacturas= mostrarfecha_emision_desdeBuscarProductoFacturas;
	}

	public Boolean getActivarfecha_emision_desdeBuscarProductoFacturas() {
		return this.activarfecha_emision_desdeBuscarProductoFacturas;
	}

	public void setActivarfecha_emision_desdeBuscarProductoFacturas(Boolean activarfecha_emision_desdeBuscarProductoFacturas) {
		this.activarfecha_emision_desdeBuscarProductoFacturas= activarfecha_emision_desdeBuscarProductoFacturas;
	}

	public Border setResaltarfecha_emision_hastaBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaBuscarProductoFacturas() {
		return this.resaltarfecha_emision_hastaBuscarProductoFacturas;
	}

	public void setResaltarfecha_emision_hastaBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaBuscarProductoFacturas() {
		return this.mostrarfecha_emision_hastaBuscarProductoFacturas;
	}

	public void setMostrarfecha_emision_hastaBuscarProductoFacturas(Boolean mostrarfecha_emision_hastaBuscarProductoFacturas) {
		this.mostrarfecha_emision_hastaBuscarProductoFacturas= mostrarfecha_emision_hastaBuscarProductoFacturas;
	}

	public Boolean getActivarfecha_emision_hastaBuscarProductoFacturas() {
		return this.activarfecha_emision_hastaBuscarProductoFacturas;
	}

	public void setActivarfecha_emision_hastaBuscarProductoFacturas(Boolean activarfecha_emision_hastaBuscarProductoFacturas) {
		this.activarfecha_emision_hastaBuscarProductoFacturas= activarfecha_emision_hastaBuscarProductoFacturas;
	}

	public Border setResaltarnombre_vendedorBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorBuscarProductoFacturas() {
		return this.resaltarnombre_vendedorBuscarProductoFacturas;
	}

	public void setResaltarnombre_vendedorBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnombre_vendedorBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorBuscarProductoFacturas() {
		return this.mostrarnombre_vendedorBuscarProductoFacturas;
	}

	public void setMostrarnombre_vendedorBuscarProductoFacturas(Boolean mostrarnombre_vendedorBuscarProductoFacturas) {
		this.mostrarnombre_vendedorBuscarProductoFacturas= mostrarnombre_vendedorBuscarProductoFacturas;
	}

	public Boolean getActivarnombre_vendedorBuscarProductoFacturas() {
		return this.activarnombre_vendedorBuscarProductoFacturas;
	}

	public void setActivarnombre_vendedorBuscarProductoFacturas(Boolean activarnombre_vendedorBuscarProductoFacturas) {
		this.activarnombre_vendedorBuscarProductoFacturas= activarnombre_vendedorBuscarProductoFacturas;
	}

	public Border setResaltarnombre_completo_clienteBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteBuscarProductoFacturas() {
		return this.resaltarnombre_completo_clienteBuscarProductoFacturas;
	}

	public void setResaltarnombre_completo_clienteBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnombre_completo_clienteBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteBuscarProductoFacturas() {
		return this.mostrarnombre_completo_clienteBuscarProductoFacturas;
	}

	public void setMostrarnombre_completo_clienteBuscarProductoFacturas(Boolean mostrarnombre_completo_clienteBuscarProductoFacturas) {
		this.mostrarnombre_completo_clienteBuscarProductoFacturas= mostrarnombre_completo_clienteBuscarProductoFacturas;
	}

	public Boolean getActivarnombre_completo_clienteBuscarProductoFacturas() {
		return this.activarnombre_completo_clienteBuscarProductoFacturas;
	}

	public void setActivarnombre_completo_clienteBuscarProductoFacturas(Boolean activarnombre_completo_clienteBuscarProductoFacturas) {
		this.activarnombre_completo_clienteBuscarProductoFacturas= activarnombre_completo_clienteBuscarProductoFacturas;
	}

	public Border setResaltarfecha_emisionBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionBuscarProductoFacturas() {
		return this.resaltarfecha_emisionBuscarProductoFacturas;
	}

	public void setResaltarfecha_emisionBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarfecha_emisionBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionBuscarProductoFacturas() {
		return this.mostrarfecha_emisionBuscarProductoFacturas;
	}

	public void setMostrarfecha_emisionBuscarProductoFacturas(Boolean mostrarfecha_emisionBuscarProductoFacturas) {
		this.mostrarfecha_emisionBuscarProductoFacturas= mostrarfecha_emisionBuscarProductoFacturas;
	}

	public Boolean getActivarfecha_emisionBuscarProductoFacturas() {
		return this.activarfecha_emisionBuscarProductoFacturas;
	}

	public void setActivarfecha_emisionBuscarProductoFacturas(Boolean activarfecha_emisionBuscarProductoFacturas) {
		this.activarfecha_emisionBuscarProductoFacturas= activarfecha_emisionBuscarProductoFacturas;
	}

	public Border setResaltarnumero_pre_impreso_datoBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_datoBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_datoBuscarProductoFacturas() {
		return this.resaltarnumero_pre_impreso_datoBuscarProductoFacturas;
	}

	public void setResaltarnumero_pre_impreso_datoBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_datoBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_datoBuscarProductoFacturas() {
		return this.mostrarnumero_pre_impreso_datoBuscarProductoFacturas;
	}

	public void setMostrarnumero_pre_impreso_datoBuscarProductoFacturas(Boolean mostrarnumero_pre_impreso_datoBuscarProductoFacturas) {
		this.mostrarnumero_pre_impreso_datoBuscarProductoFacturas= mostrarnumero_pre_impreso_datoBuscarProductoFacturas;
	}

	public Boolean getActivarnumero_pre_impreso_datoBuscarProductoFacturas() {
		return this.activarnumero_pre_impreso_datoBuscarProductoFacturas;
	}

	public void setActivarnumero_pre_impreso_datoBuscarProductoFacturas(Boolean activarnumero_pre_impreso_datoBuscarProductoFacturas) {
		this.activarnumero_pre_impreso_datoBuscarProductoFacturas= activarnumero_pre_impreso_datoBuscarProductoFacturas;
	}

	public Border setResaltartotalBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltartotalBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalBuscarProductoFacturas() {
		return this.resaltartotalBuscarProductoFacturas;
	}

	public void setResaltartotalBuscarProductoFacturas(Border borderResaltar) {
		this.resaltartotalBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrartotalBuscarProductoFacturas() {
		return this.mostrartotalBuscarProductoFacturas;
	}

	public void setMostrartotalBuscarProductoFacturas(Boolean mostrartotalBuscarProductoFacturas) {
		this.mostrartotalBuscarProductoFacturas= mostrartotalBuscarProductoFacturas;
	}

	public Boolean getActivartotalBuscarProductoFacturas() {
		return this.activartotalBuscarProductoFacturas;
	}

	public void setActivartotalBuscarProductoFacturas(Boolean activartotalBuscarProductoFacturas) {
		this.activartotalBuscarProductoFacturas= activartotalBuscarProductoFacturas;
	}

	public Border setResaltarnombre_unidadBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadBuscarProductoFacturas() {
		return this.resaltarnombre_unidadBuscarProductoFacturas;
	}

	public void setResaltarnombre_unidadBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnombre_unidadBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadBuscarProductoFacturas() {
		return this.mostrarnombre_unidadBuscarProductoFacturas;
	}

	public void setMostrarnombre_unidadBuscarProductoFacturas(Boolean mostrarnombre_unidadBuscarProductoFacturas) {
		this.mostrarnombre_unidadBuscarProductoFacturas= mostrarnombre_unidadBuscarProductoFacturas;
	}

	public Boolean getActivarnombre_unidadBuscarProductoFacturas() {
		return this.activarnombre_unidadBuscarProductoFacturas;
	}

	public void setActivarnombre_unidadBuscarProductoFacturas(Boolean activarnombre_unidadBuscarProductoFacturas) {
		this.activarnombre_unidadBuscarProductoFacturas= activarnombre_unidadBuscarProductoFacturas;
	}

	public Border setResaltarnombre_bodegaBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaBuscarProductoFacturas() {
		return this.resaltarnombre_bodegaBuscarProductoFacturas;
	}

	public void setResaltarnombre_bodegaBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnombre_bodegaBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaBuscarProductoFacturas() {
		return this.mostrarnombre_bodegaBuscarProductoFacturas;
	}

	public void setMostrarnombre_bodegaBuscarProductoFacturas(Boolean mostrarnombre_bodegaBuscarProductoFacturas) {
		this.mostrarnombre_bodegaBuscarProductoFacturas= mostrarnombre_bodegaBuscarProductoFacturas;
	}

	public Boolean getActivarnombre_bodegaBuscarProductoFacturas() {
		return this.activarnombre_bodegaBuscarProductoFacturas;
	}

	public void setActivarnombre_bodegaBuscarProductoFacturas(Boolean activarnombre_bodegaBuscarProductoFacturas) {
		this.activarnombre_bodegaBuscarProductoFacturas= activarnombre_bodegaBuscarProductoFacturas;
	}

	public Border setResaltarnombre_productoBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_productoBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoBuscarProductoFacturas() {
		return this.resaltarnombre_productoBuscarProductoFacturas;
	}

	public void setResaltarnombre_productoBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarnombre_productoBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_productoBuscarProductoFacturas() {
		return this.mostrarnombre_productoBuscarProductoFacturas;
	}

	public void setMostrarnombre_productoBuscarProductoFacturas(Boolean mostrarnombre_productoBuscarProductoFacturas) {
		this.mostrarnombre_productoBuscarProductoFacturas= mostrarnombre_productoBuscarProductoFacturas;
	}

	public Boolean getActivarnombre_productoBuscarProductoFacturas() {
		return this.activarnombre_productoBuscarProductoFacturas;
	}

	public void setActivarnombre_productoBuscarProductoFacturas(Boolean activarnombre_productoBuscarProductoFacturas) {
		this.activarnombre_productoBuscarProductoFacturas= activarnombre_productoBuscarProductoFacturas;
	}

	public Border setResaltarcantidadBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarcantidadBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadBuscarProductoFacturas() {
		return this.resaltarcantidadBuscarProductoFacturas;
	}

	public void setResaltarcantidadBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarcantidadBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarcantidadBuscarProductoFacturas() {
		return this.mostrarcantidadBuscarProductoFacturas;
	}

	public void setMostrarcantidadBuscarProductoFacturas(Boolean mostrarcantidadBuscarProductoFacturas) {
		this.mostrarcantidadBuscarProductoFacturas= mostrarcantidadBuscarProductoFacturas;
	}

	public Boolean getActivarcantidadBuscarProductoFacturas() {
		return this.activarcantidadBuscarProductoFacturas;
	}

	public void setActivarcantidadBuscarProductoFacturas(Boolean activarcantidadBuscarProductoFacturas) {
		this.activarcantidadBuscarProductoFacturas= activarcantidadBuscarProductoFacturas;
	}

	public Border setResaltarprecioBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltarprecioBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioBuscarProductoFacturas() {
		return this.resaltarprecioBuscarProductoFacturas;
	}

	public void setResaltarprecioBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarprecioBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrarprecioBuscarProductoFacturas() {
		return this.mostrarprecioBuscarProductoFacturas;
	}

	public void setMostrarprecioBuscarProductoFacturas(Boolean mostrarprecioBuscarProductoFacturas) {
		this.mostrarprecioBuscarProductoFacturas= mostrarprecioBuscarProductoFacturas;
	}

	public Boolean getActivarprecioBuscarProductoFacturas() {
		return this.activarprecioBuscarProductoFacturas;
	}

	public void setActivarprecioBuscarProductoFacturas(Boolean activarprecioBuscarProductoFacturas) {
		this.activarprecioBuscarProductoFacturas= activarprecioBuscarProductoFacturas;
	}

	public Border setResaltardescuentoBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//buscarproductofacturasBeanSwingJInternalFrame.jTtoolBarBuscarProductoFacturas.setBorder(borderResaltar);
		
		this.resaltardescuentoBuscarProductoFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoBuscarProductoFacturas() {
		return this.resaltardescuentoBuscarProductoFacturas;
	}

	public void setResaltardescuentoBuscarProductoFacturas(Border borderResaltar) {
		this.resaltardescuentoBuscarProductoFacturas= borderResaltar;
	}

	public Boolean getMostrardescuentoBuscarProductoFacturas() {
		return this.mostrardescuentoBuscarProductoFacturas;
	}

	public void setMostrardescuentoBuscarProductoFacturas(Boolean mostrardescuentoBuscarProductoFacturas) {
		this.mostrardescuentoBuscarProductoFacturas= mostrardescuentoBuscarProductoFacturas;
	}

	public Boolean getActivardescuentoBuscarProductoFacturas() {
		return this.activardescuentoBuscarProductoFacturas;
	}

	public void setActivardescuentoBuscarProductoFacturas(Boolean activardescuentoBuscarProductoFacturas) {
		this.activardescuentoBuscarProductoFacturas= activardescuentoBuscarProductoFacturas;
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
		
		
		this.setMostraridBuscarProductoFacturas(esInicial);
		this.setMostrarid_productoBuscarProductoFacturas(esInicial);
		this.setMostrarid_empresaBuscarProductoFacturas(esInicial);
		this.setMostrarid_sucursalBuscarProductoFacturas(esInicial);
		this.setMostrarid_clienteBuscarProductoFacturas(esInicial);
		this.setMostrarnumero_pre_impresoBuscarProductoFacturas(esInicial);
		this.setMostrarfecha_emision_desdeBuscarProductoFacturas(esInicial);
		this.setMostrarfecha_emision_hastaBuscarProductoFacturas(esInicial);
		this.setMostrarnombre_vendedorBuscarProductoFacturas(esInicial);
		this.setMostrarnombre_completo_clienteBuscarProductoFacturas(esInicial);
		this.setMostrarfecha_emisionBuscarProductoFacturas(esInicial);
		this.setMostrarnumero_pre_impreso_datoBuscarProductoFacturas(esInicial);
		this.setMostrartotalBuscarProductoFacturas(esInicial);
		this.setMostrarnombre_unidadBuscarProductoFacturas(esInicial);
		this.setMostrarnombre_bodegaBuscarProductoFacturas(esInicial);
		this.setMostrarnombre_productoBuscarProductoFacturas(esInicial);
		this.setMostrarcantidadBuscarProductoFacturas(esInicial);
		this.setMostrarprecioBuscarProductoFacturas(esInicial);
		this.setMostrardescuentoBuscarProductoFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.ID)) {
				this.setMostraridBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO)) {
				this.setMostrarnumero_pre_impreso_datoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.TOTAL)) {
				this.setMostrartotalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.PRECIO)) {
				this.setMostrarprecioBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoBuscarProductoFacturas(esAsigna);
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
		
		
		this.setActivaridBuscarProductoFacturas(esInicial);
		this.setActivarid_productoBuscarProductoFacturas(esInicial);
		this.setActivarid_empresaBuscarProductoFacturas(esInicial);
		this.setActivarid_sucursalBuscarProductoFacturas(esInicial);
		this.setActivarid_clienteBuscarProductoFacturas(esInicial);
		this.setActivarnumero_pre_impresoBuscarProductoFacturas(esInicial);
		this.setActivarfecha_emision_desdeBuscarProductoFacturas(esInicial);
		this.setActivarfecha_emision_hastaBuscarProductoFacturas(esInicial);
		this.setActivarnombre_vendedorBuscarProductoFacturas(esInicial);
		this.setActivarnombre_completo_clienteBuscarProductoFacturas(esInicial);
		this.setActivarfecha_emisionBuscarProductoFacturas(esInicial);
		this.setActivarnumero_pre_impreso_datoBuscarProductoFacturas(esInicial);
		this.setActivartotalBuscarProductoFacturas(esInicial);
		this.setActivarnombre_unidadBuscarProductoFacturas(esInicial);
		this.setActivarnombre_bodegaBuscarProductoFacturas(esInicial);
		this.setActivarnombre_productoBuscarProductoFacturas(esInicial);
		this.setActivarcantidadBuscarProductoFacturas(esInicial);
		this.setActivarprecioBuscarProductoFacturas(esInicial);
		this.setActivardescuentoBuscarProductoFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.ID)) {
				this.setActivaridBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO)) {
				this.setActivarnumero_pre_impreso_datoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.TOTAL)) {
				this.setActivartotalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.PRECIO)) {
				this.setActivarprecioBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoBuscarProductoFacturas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBuscarProductoFacturas(esInicial);
		this.setResaltarid_productoBuscarProductoFacturas(esInicial);
		this.setResaltarid_empresaBuscarProductoFacturas(esInicial);
		this.setResaltarid_sucursalBuscarProductoFacturas(esInicial);
		this.setResaltarid_clienteBuscarProductoFacturas(esInicial);
		this.setResaltarnumero_pre_impresoBuscarProductoFacturas(esInicial);
		this.setResaltarfecha_emision_desdeBuscarProductoFacturas(esInicial);
		this.setResaltarfecha_emision_hastaBuscarProductoFacturas(esInicial);
		this.setResaltarnombre_vendedorBuscarProductoFacturas(esInicial);
		this.setResaltarnombre_completo_clienteBuscarProductoFacturas(esInicial);
		this.setResaltarfecha_emisionBuscarProductoFacturas(esInicial);
		this.setResaltarnumero_pre_impreso_datoBuscarProductoFacturas(esInicial);
		this.setResaltartotalBuscarProductoFacturas(esInicial);
		this.setResaltarnombre_unidadBuscarProductoFacturas(esInicial);
		this.setResaltarnombre_bodegaBuscarProductoFacturas(esInicial);
		this.setResaltarnombre_productoBuscarProductoFacturas(esInicial);
		this.setResaltarcantidadBuscarProductoFacturas(esInicial);
		this.setResaltarprecioBuscarProductoFacturas(esInicial);
		this.setResaltardescuentoBuscarProductoFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.ID)) {
				this.setResaltaridBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NUMEROPREIMPRESODATO)) {
				this.setResaltarnumero_pre_impreso_datoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.TOTAL)) {
				this.setResaltartotalBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.PRECIO)) {
				this.setResaltarprecioBuscarProductoFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(BuscarProductoFacturasConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoBuscarProductoFacturas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaBuscarProductoFacturasBuscarProductoFacturas=true;

	public Boolean getMostrarBusquedaBuscarProductoFacturasBuscarProductoFacturas() {
		return this.mostrarBusquedaBuscarProductoFacturasBuscarProductoFacturas;
	}

	public void setMostrarBusquedaBuscarProductoFacturasBuscarProductoFacturas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaBuscarProductoFacturasBuscarProductoFacturas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaBuscarProductoFacturasBuscarProductoFacturas=true;

	public Boolean getActivarBusquedaBuscarProductoFacturasBuscarProductoFacturas() {
		return this.activarBusquedaBuscarProductoFacturasBuscarProductoFacturas;
	}

	public void setActivarBusquedaBuscarProductoFacturasBuscarProductoFacturas(Boolean habilitarResaltar) {
		this.activarBusquedaBuscarProductoFacturasBuscarProductoFacturas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas=null;

	public Border getResaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas() {
		return this.resaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas;
	}

	public void setResaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas(Border borderResaltar) {
		this.resaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas= borderResaltar;
	}

	public void setResaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*BuscarProductoFacturasBeanSwingJInternalFrame buscarproductofacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaBuscarProductoFacturasBuscarProductoFacturas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}