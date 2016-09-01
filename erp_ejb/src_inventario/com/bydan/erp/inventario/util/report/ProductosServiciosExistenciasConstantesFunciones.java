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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosServiciosExistenciasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosServiciosExistencias";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosServiciosExistencias"+ProductosServiciosExistenciasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosServiciosExistenciasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosServiciosExistenciasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"_"+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosExistenciasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"_"+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"_"+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosExistenciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"_"+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosExistenciasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosExistenciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosExistenciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosServiciosExistenciasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosServiciosExistenciasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosServiciosExistenciasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosServiciosExistenciasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Servicios Existenciases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Servicios Existencias";
	public static final String SCLASSWEBTITULO_LOWER="Productos Servicios Existencias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosServiciosExistencias";
	public static final String OBJECTNAME="productosserviciosexistencias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="productos_servicios_existencias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosserviciosexistencias from "+ProductosServiciosExistenciasConstantesFunciones.SPERSISTENCENAME+" productosserviciosexistencias";
	public static String QUERYSELECTNATIVE="select "+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".version_row,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_empresa,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_bodega,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_producto,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_linea,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_linea,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".codigo,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_tipo_producto_servicio,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_bodega,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".cantidad_disponible,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".cantidad_reservada,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".cantidad_pedida,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".total_egreso,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".total_compra,"+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME+".total_devuelto from "+ProductosServiciosExistenciasConstantesFunciones.SCHEMA+"."+ProductosServiciosExistenciasConstantesFunciones.TABLENAME;//+" as "+ProductosServiciosExistenciasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRETIPOPRODUCTOSERVICIO= "nombre_tipo_producto_servicio";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String CANTIDADRESERVADA= "cantidad_reservada";
    public static final String CANTIDADPEDIDA= "cantidad_pedida";
    public static final String TOTALEGRESO= "total_egreso";
    public static final String TOTALCOMPRA= "total_compra";
    public static final String TOTALDEVUELTO= "total_devuelto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIO= "Tipo Producto Servicio";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIO_LOWER= "Tipo Producto Servicio";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBRELINEAGRUPO= "Nombre Linea Grupo";
		public static final String LABEL_NOMBRELINEAGRUPO_LOWER= "Nombre Linea Grupo";
    	public static final String LABEL_NOMBRELINEACATEGORIA= "Nombre Linea Categoria";
		public static final String LABEL_NOMBRELINEACATEGORIA_LOWER= "Nombre Linea Categoria";
    	public static final String LABEL_NOMBRELINEAMARCA= "Nombre Linea Marca";
		public static final String LABEL_NOMBRELINEAMARCA_LOWER= "Nombre Linea Marca";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRETIPOPRODUCTOSERVICIO= "Nombre Tipo Producto Servicio";
		public static final String LABEL_NOMBRETIPOPRODUCTOSERVICIO_LOWER= "Nombre Tipo Producto Servicio";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_CANTIDADRESERVADA= "Cantad Reservada";
		public static final String LABEL_CANTIDADRESERVADA_LOWER= "Cantidad Reservada";
    	public static final String LABEL_CANTIDADPEDIDA= "Cantad Peda";
		public static final String LABEL_CANTIDADPEDIDA_LOWER= "Cantidad Pedida";
    	public static final String LABEL_TOTALEGRESO= "Total Egreso";
		public static final String LABEL_TOTALEGRESO_LOWER= "Total Egreso";
    	public static final String LABEL_TOTALCOMPRA= "Total Compra";
		public static final String LABEL_TOTALCOMPRA_LOWER= "Total Compra";
    	public static final String LABEL_TOTALDEVUELTO= "Total Devuelto";
		public static final String LABEL_TOTALDEVUELTO_LOWER= "Total Devuelto";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_PRODUCTO_SERVICIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_PRODUCTO_SERVICIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getProductosServiciosExistenciasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.CODIGO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRE)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA;}
		if(sNombreColumna.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO)) {sLabelColumna=ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosServiciosExistenciasDescripcion(ProductosServiciosExistencias productosserviciosexistencias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosserviciosexistencias !=null/* && productosserviciosexistencias.getId()!=0*/) {
			sDescripcion=productosserviciosexistencias.getcodigo();//productosserviciosexistenciasproductosserviciosexistencias.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosServiciosExistenciasDescripcionDetallado(ProductosServiciosExistencias productosserviciosexistencias) {
		String sDescripcion="";
			
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.ID+"=";
		sDescripcion+=productosserviciosexistencias.getId().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosserviciosexistencias.getVersionRow().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosserviciosexistencias.getid_empresa().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosserviciosexistencias.getid_sucursal().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productosserviciosexistencias.getid_bodega().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productosserviciosexistencias.getid_producto().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productosserviciosexistencias.getid_linea().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productosserviciosexistencias.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productosserviciosexistencias.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productosserviciosexistencias.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosexistencias.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_sucursal()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_linea()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_linea_grupo()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_linea_categoria()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_linea_marca()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.CODIGO+"=";
		sDescripcion+=productosserviciosexistencias.getcodigo()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=productosserviciosexistencias.getnombre()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_tipo_producto_servicio()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_bodega()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosserviciosexistencias.getnombre_unidad()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=productosserviciosexistencias.getcantidad_disponible().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA+"=";
		sDescripcion+=productosserviciosexistencias.getcantidad_reservada().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA+"=";
		sDescripcion+=productosserviciosexistencias.getcantidad_pedida().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO+"=";
		sDescripcion+=productosserviciosexistencias.gettotal_egreso().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA+"=";
		sDescripcion+=productosserviciosexistencias.gettotal_compra().toString()+",";
		sDescripcion+=ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO+"=";
		sDescripcion+=productosserviciosexistencias.gettotal_devuelto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosServiciosExistenciasDescripcion(ProductosServiciosExistencias productosserviciosexistencias,String sValor) throws Exception {			
		if(productosserviciosexistencias !=null) {
			productosserviciosexistencias.setcodigo(sValor);;//productosserviciosexistenciasproductosserviciosexistencias.getcodigo().trim();
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getTipoProductoServicioDescripcion(TipoProductoServicio tipoproductoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproductoservicio!=null/*&&tipoproductoservicio.getId()>0*/) {
			sDescripcion=TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(tipoproductoservicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProductosServiciosExistencias")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Tipo Producto Servicio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProductosServiciosExistencias(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosexistencias.setnombre_sucursal(productosserviciosexistencias.getnombre_sucursal().trim());
		productosserviciosexistencias.setnombre_linea(productosserviciosexistencias.getnombre_linea().trim());
		productosserviciosexistencias.setnombre_linea_grupo(productosserviciosexistencias.getnombre_linea_grupo().trim());
		productosserviciosexistencias.setnombre_linea_categoria(productosserviciosexistencias.getnombre_linea_categoria().trim());
		productosserviciosexistencias.setnombre_linea_marca(productosserviciosexistencias.getnombre_linea_marca().trim());
		productosserviciosexistencias.setcodigo(productosserviciosexistencias.getcodigo().trim());
		productosserviciosexistencias.setnombre(productosserviciosexistencias.getnombre().trim());
		productosserviciosexistencias.setnombre_tipo_producto_servicio(productosserviciosexistencias.getnombre_tipo_producto_servicio().trim());
		productosserviciosexistencias.setnombre_bodega(productosserviciosexistencias.getnombre_bodega().trim());
		productosserviciosexistencias.setnombre_unidad(productosserviciosexistencias.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosExistenciass(List<ProductosServiciosExistencias> productosserviciosexistenciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {
			productosserviciosexistencias.setnombre_sucursal(productosserviciosexistencias.getnombre_sucursal().trim());
			productosserviciosexistencias.setnombre_linea(productosserviciosexistencias.getnombre_linea().trim());
			productosserviciosexistencias.setnombre_linea_grupo(productosserviciosexistencias.getnombre_linea_grupo().trim());
			productosserviciosexistencias.setnombre_linea_categoria(productosserviciosexistencias.getnombre_linea_categoria().trim());
			productosserviciosexistencias.setnombre_linea_marca(productosserviciosexistencias.getnombre_linea_marca().trim());
			productosserviciosexistencias.setcodigo(productosserviciosexistencias.getcodigo().trim());
			productosserviciosexistencias.setnombre(productosserviciosexistencias.getnombre().trim());
			productosserviciosexistencias.setnombre_tipo_producto_servicio(productosserviciosexistencias.getnombre_tipo_producto_servicio().trim());
			productosserviciosexistencias.setnombre_bodega(productosserviciosexistencias.getnombre_bodega().trim());
			productosserviciosexistencias.setnombre_unidad(productosserviciosexistencias.getnombre_unidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosserviciosexistencias.getConCambioAuxiliar()) {
			productosserviciosexistencias.setIsDeleted(productosserviciosexistencias.getIsDeletedAuxiliar());	
			productosserviciosexistencias.setIsNew(productosserviciosexistencias.getIsNewAuxiliar());	
			productosserviciosexistencias.setIsChanged(productosserviciosexistencias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosserviciosexistencias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosserviciosexistencias.setIsDeletedAuxiliar(false);	
			productosserviciosexistencias.setIsNewAuxiliar(false);	
			productosserviciosexistencias.setIsChangedAuxiliar(false);
			
			productosserviciosexistencias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosExistenciass(List<ProductosServiciosExistencias> productosserviciosexistenciass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosServiciosExistencias productosserviciosexistencias : productosserviciosexistenciass) {
			if(conAsignarBase && productosserviciosexistencias.getConCambioAuxiliar()) {
				productosserviciosexistencias.setIsDeleted(productosserviciosexistencias.getIsDeletedAuxiliar());	
				productosserviciosexistencias.setIsNew(productosserviciosexistencias.getIsNewAuxiliar());	
				productosserviciosexistencias.setIsChanged(productosserviciosexistencias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosserviciosexistencias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosserviciosexistencias.setIsDeletedAuxiliar(false);	
				productosserviciosexistencias.setIsNewAuxiliar(false);	
				productosserviciosexistencias.setIsChangedAuxiliar(false);
				
				productosserviciosexistencias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistencias,Boolean conEnteros) throws Exception  {
		productosserviciosexistencias.setcantidad_reservada(0.0);
		productosserviciosexistencias.setcantidad_pedida(0.0);
		productosserviciosexistencias.settotal_egreso(0.0);
		productosserviciosexistencias.settotal_compra(0.0);
		productosserviciosexistencias.settotal_devuelto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productosserviciosexistencias.setcantidad_disponible(0);
		}
	}		
	
	public static void InicializarValoresProductosServiciosExistenciass(List<ProductosServiciosExistencias> productosserviciosexistenciass,Boolean conEnteros) throws Exception  {
		
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {
			productosserviciosexistencias.setcantidad_reservada(0.0);
			productosserviciosexistencias.setcantidad_pedida(0.0);
			productosserviciosexistencias.settotal_egreso(0.0);
			productosserviciosexistencias.settotal_compra(0.0);
			productosserviciosexistencias.settotal_devuelto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productosserviciosexistencias.setcantidad_disponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosServiciosExistencias(List<ProductosServiciosExistencias> productosserviciosexistenciass,ProductosServiciosExistencias productosserviciosexistenciasAux) throws Exception  {
		ProductosServiciosExistenciasConstantesFunciones.InicializarValoresProductosServiciosExistencias(productosserviciosexistenciasAux,true);
		
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {
			if(productosserviciosexistencias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosserviciosexistenciasAux.setcantidad_disponible(productosserviciosexistenciasAux.getcantidad_disponible()+productosserviciosexistencias.getcantidad_disponible());			
			productosserviciosexistenciasAux.setcantidad_reservada(productosserviciosexistenciasAux.getcantidad_reservada()+productosserviciosexistencias.getcantidad_reservada());			
			productosserviciosexistenciasAux.setcantidad_pedida(productosserviciosexistenciasAux.getcantidad_pedida()+productosserviciosexistencias.getcantidad_pedida());			
			productosserviciosexistenciasAux.settotal_egreso(productosserviciosexistenciasAux.gettotal_egreso()+productosserviciosexistencias.gettotal_egreso());			
			productosserviciosexistenciasAux.settotal_compra(productosserviciosexistenciasAux.gettotal_compra()+productosserviciosexistencias.gettotal_compra());			
			productosserviciosexistenciasAux.settotal_devuelto(productosserviciosexistenciasAux.gettotal_devuelto()+productosserviciosexistencias.gettotal_devuelto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosExistencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosServiciosExistenciasConstantesFunciones.getArrayColumnasGlobalesProductosServiciosExistencias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosExistencias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosServiciosExistencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosExistencias> productosserviciosexistenciass,ProductosServiciosExistencias productosserviciosexistencias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosExistencias productosserviciosexistenciasAux: productosserviciosexistenciass) {
			if(productosserviciosexistenciasAux!=null && productosserviciosexistencias!=null) {
				if((productosserviciosexistenciasAux.getId()==null && productosserviciosexistencias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosserviciosexistenciasAux.getId()!=null && productosserviciosexistencias.getId()!=null){
					if(productosserviciosexistenciasAux.getId().equals(productosserviciosexistencias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosExistencias(List<ProductosServiciosExistencias> productosserviciosexistenciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_reservadaTotal=0.0;
		Double cantidad_pedidaTotal=0.0;
		Double total_egresoTotal=0.0;
		Double total_compraTotal=0.0;
		Double total_devueltoTotal=0.0;
	
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {			
			if(productosserviciosexistencias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidad_reservadaTotal+=productosserviciosexistencias.getcantidad_reservada();
			cantidad_pedidaTotal+=productosserviciosexistencias.getcantidad_pedida();
			total_egresoTotal+=productosserviciosexistencias.gettotal_egreso();
			total_compraTotal+=productosserviciosexistencias.gettotal_compra();
			total_devueltoTotal+=productosserviciosexistencias.gettotal_devuelto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA);
		datoGeneral.setdValorDouble(cantidad_reservadaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA);
		datoGeneral.setdValorDouble(cantidad_pedidaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO);
		datoGeneral.setdValorDouble(total_egresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA);
		datoGeneral.setdValorDouble(total_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO);
		datoGeneral.setdValorDouble(total_devueltoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosServiciosExistencias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_ID, ProductosServiciosExistenciasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_VERSIONROW, ProductosServiciosExistenciasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRESUCURSAL, ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEA, ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAMARCA, ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_CODIGO, ProductosServiciosExistenciasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRE, ProductosServiciosExistenciasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO, ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREBODEGA, ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADDISPONIBLE, ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA, ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA, ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO, ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA, ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO, ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosServiciosExistencias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosExistencias() throws Exception  {
		return ProductosServiciosExistenciasConstantesFunciones.getTiposSeleccionarProductosServiciosExistencias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosExistencias(Boolean conFk) throws Exception  {
		return ProductosServiciosExistenciasConstantesFunciones.getTiposSeleccionarProductosServiciosExistencias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosExistencias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO);
			reporte.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosServiciosExistencias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistenciasAux) throws Exception {
		
			productosserviciosexistenciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosexistenciasAux.getEmpresa()));
			productosserviciosexistenciasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosexistenciasAux.getSucursal()));
			productosserviciosexistenciasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosexistenciasAux.getBodega()));
			productosserviciosexistenciasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosserviciosexistenciasAux.getProducto()));
			productosserviciosexistenciasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLinea()));
			productosserviciosexistenciasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaGrupo()));
			productosserviciosexistenciasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaCategoria()));
			productosserviciosexistenciasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaMarca()));
			productosserviciosexistenciasAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosexistenciasAux.getTipoProductoServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosExistencias(List<ProductosServiciosExistencias> productosserviciosexistenciassTemp) throws Exception {
		for(ProductosServiciosExistencias productosserviciosexistenciasAux:productosserviciosexistenciassTemp) {
			
			productosserviciosexistenciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosexistenciasAux.getEmpresa()));
			productosserviciosexistenciasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosexistenciasAux.getSucursal()));
			productosserviciosexistenciasAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosexistenciasAux.getBodega()));
			productosserviciosexistenciasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosserviciosexistenciasAux.getProducto()));
			productosserviciosexistenciasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLinea()));
			productosserviciosexistenciasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaGrupo()));
			productosserviciosexistenciasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaCategoria()));
			productosserviciosexistenciasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosexistenciasAux.getLineaMarca()));
			productosserviciosexistenciasAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosexistenciasAux.getTipoProductoServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosServiciosExistencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(TipoProductoServicio.class));
				
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
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicio.class)) {
						classes.add(new Classe(TipoProductoServicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosServiciosExistencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosExistencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosExistenciasConstantesFunciones.getClassesRelationshipsOfProductosServiciosExistencias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosExistencias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosExistencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosExistenciasConstantesFunciones.getClassesRelationshipsFromStringsOfProductosServiciosExistencias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosExistencias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosServiciosExistencias productosserviciosexistencias,List<ProductosServiciosExistencias> productosserviciosexistenciass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosServiciosExistencias productosserviciosexistencias,List<ProductosServiciosExistencias> productosserviciosexistenciass) throws Exception {
		try	{			
			for(ProductosServiciosExistencias productosserviciosexistenciasLocal:productosserviciosexistenciass) {
				if(productosserviciosexistenciasLocal.getId().equals(productosserviciosexistencias.getId())) {
					productosserviciosexistenciasLocal.setIsSelected(productosserviciosexistencias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosServiciosExistencias(List<ProductosServiciosExistencias> productosserviciosexistenciassAux) throws Exception {
		//this.productosserviciosexistenciassAux=productosserviciosexistenciassAux;
		
		for(ProductosServiciosExistencias productosserviciosexistenciasAux:productosserviciosexistenciassAux) {
			if(productosserviciosexistenciasAux.getIsChanged()) {
				productosserviciosexistenciasAux.setIsChanged(false);
			}		
			
			if(productosserviciosexistenciasAux.getIsNew()) {
				productosserviciosexistenciasAux.setIsNew(false);
			}	
			
			if(productosserviciosexistenciasAux.getIsDeleted()) {
				productosserviciosexistenciasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistenciasAux) throws Exception {
		//this.productosserviciosexistenciasAux=productosserviciosexistenciasAux;
		
			if(productosserviciosexistenciasAux.getIsChanged()) {
				productosserviciosexistenciasAux.setIsChanged(false);
			}		
			
			if(productosserviciosexistenciasAux.getIsNew()) {
				productosserviciosexistenciasAux.setIsNew(false);
			}	
			
			if(productosserviciosexistenciasAux.getIsDeleted()) {
				productosserviciosexistenciasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosServiciosExistencias productosserviciosexistenciasAsignar,ProductosServiciosExistencias productosserviciosexistencias) throws Exception {
		productosserviciosexistenciasAsignar.setId(productosserviciosexistencias.getId());	
		productosserviciosexistenciasAsignar.setVersionRow(productosserviciosexistencias.getVersionRow());	
		productosserviciosexistenciasAsignar.setnombre_sucursal(productosserviciosexistencias.getnombre_sucursal());	
		productosserviciosexistenciasAsignar.setnombre_linea(productosserviciosexistencias.getnombre_linea());	
		productosserviciosexistenciasAsignar.setnombre_linea_grupo(productosserviciosexistencias.getnombre_linea_grupo());	
		productosserviciosexistenciasAsignar.setnombre_linea_categoria(productosserviciosexistencias.getnombre_linea_categoria());	
		productosserviciosexistenciasAsignar.setnombre_linea_marca(productosserviciosexistencias.getnombre_linea_marca());	
		productosserviciosexistenciasAsignar.setcodigo(productosserviciosexistencias.getcodigo());	
		productosserviciosexistenciasAsignar.setnombre(productosserviciosexistencias.getnombre());	
		productosserviciosexistenciasAsignar.setnombre_tipo_producto_servicio(productosserviciosexistencias.getnombre_tipo_producto_servicio());	
		productosserviciosexistenciasAsignar.setnombre_bodega(productosserviciosexistencias.getnombre_bodega());	
		productosserviciosexistenciasAsignar.setnombre_unidad(productosserviciosexistencias.getnombre_unidad());	
		productosserviciosexistenciasAsignar.setcantidad_disponible(productosserviciosexistencias.getcantidad_disponible());	
		productosserviciosexistenciasAsignar.setcantidad_reservada(productosserviciosexistencias.getcantidad_reservada());	
		productosserviciosexistenciasAsignar.setcantidad_pedida(productosserviciosexistencias.getcantidad_pedida());	
		productosserviciosexistenciasAsignar.settotal_egreso(productosserviciosexistencias.gettotal_egreso());	
		productosserviciosexistenciasAsignar.settotal_compra(productosserviciosexistencias.gettotal_compra());	
		productosserviciosexistenciasAsignar.settotal_devuelto(productosserviciosexistencias.gettotal_devuelto());	
	}
	
	public static void inicializarProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistencias) throws Exception {
		try {
				productosserviciosexistencias.setId(0L);	
					
				productosserviciosexistencias.setnombre_sucursal("");	
				productosserviciosexistencias.setnombre_linea("");	
				productosserviciosexistencias.setnombre_linea_grupo("");	
				productosserviciosexistencias.setnombre_linea_categoria("");	
				productosserviciosexistencias.setnombre_linea_marca("");	
				productosserviciosexistencias.setcodigo("");	
				productosserviciosexistencias.setnombre("");	
				productosserviciosexistencias.setnombre_tipo_producto_servicio("");	
				productosserviciosexistencias.setnombre_bodega("");	
				productosserviciosexistencias.setnombre_unidad("");	
				productosserviciosexistencias.setcantidad_disponible(0);	
				productosserviciosexistencias.setcantidad_reservada(0.0);	
				productosserviciosexistencias.setcantidad_pedida(0.0);	
				productosserviciosexistencias.settotal_egreso(0.0);	
				productosserviciosexistencias.settotal_compra(0.0);	
				productosserviciosexistencias.settotal_devuelto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosServiciosExistencias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosServiciosExistencias(String sTipo,Row row,Workbook workbook,ProductosServiciosExistencias productosserviciosexistencias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_tipo_producto_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getcantidad_reservada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.getcantidad_pedida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.gettotal_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.gettotal_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosexistencias.gettotal_devuelto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosServiciosExistencias="";
	
	public String getsFinalQueryProductosServiciosExistencias() {
		return this.sFinalQueryProductosServiciosExistencias;
	}
	
	public void setsFinalQueryProductosServiciosExistencias(String sFinalQueryProductosServiciosExistencias) {
		this.sFinalQueryProductosServiciosExistencias= sFinalQueryProductosServiciosExistencias;
	}
	
	public Border resaltarSeleccionarProductosServiciosExistencias=null;
	
	public Border setResaltarSeleccionarProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosServiciosExistencias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosServiciosExistencias() {
		return this.resaltarSeleccionarProductosServiciosExistencias;
	}
	
	public void setResaltarSeleccionarProductosServiciosExistencias(Border borderResaltarSeleccionarProductosServiciosExistencias) {
		this.resaltarSeleccionarProductosServiciosExistencias= borderResaltarSeleccionarProductosServiciosExistencias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosServiciosExistencias=null;
	public Boolean mostraridProductosServiciosExistencias=true;
	public Boolean activaridProductosServiciosExistencias=true;

	public Border resaltarid_empresaProductosServiciosExistencias=null;
	public Boolean mostrarid_empresaProductosServiciosExistencias=true;
	public Boolean activarid_empresaProductosServiciosExistencias=true;
	public Boolean cargarid_empresaProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosServiciosExistencias=null;
	public Boolean mostrarid_sucursalProductosServiciosExistencias=true;
	public Boolean activarid_sucursalProductosServiciosExistencias=true;
	public Boolean cargarid_sucursalProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosServiciosExistencias=null;
	public Boolean mostrarid_bodegaProductosServiciosExistencias=true;
	public Boolean activarid_bodegaProductosServiciosExistencias=true;
	public Boolean cargarid_bodegaProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_productoProductosServiciosExistencias=null;
	public Boolean mostrarid_productoProductosServiciosExistencias=true;
	public Boolean activarid_productoProductosServiciosExistencias=true;
	public Boolean cargarid_productoProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosServiciosExistencias=null;
	public Boolean mostrarid_lineaProductosServiciosExistencias=true;
	public Boolean activarid_lineaProductosServiciosExistencias=true;
	public Boolean cargarid_lineaProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosServiciosExistencias=null;
	public Boolean mostrarid_linea_grupoProductosServiciosExistencias=true;
	public Boolean activarid_linea_grupoProductosServiciosExistencias=true;
	public Boolean cargarid_linea_grupoProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosServiciosExistencias=null;
	public Boolean mostrarid_linea_categoriaProductosServiciosExistencias=true;
	public Boolean activarid_linea_categoriaProductosServiciosExistencias=true;
	public Boolean cargarid_linea_categoriaProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosServiciosExistencias=null;
	public Boolean mostrarid_linea_marcaProductosServiciosExistencias=true;
	public Boolean activarid_linea_marcaProductosServiciosExistencias=true;
	public Boolean cargarid_linea_marcaProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioProductosServiciosExistencias=null;
	public Boolean mostrarid_tipo_producto_servicioProductosServiciosExistencias=true;
	public Boolean activarid_tipo_producto_servicioProductosServiciosExistencias=true;
	public Boolean cargarid_tipo_producto_servicioProductosServiciosExistencias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioProductosServiciosExistencias=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProductosServiciosExistencias=null;
	public Boolean mostrarnombre_sucursalProductosServiciosExistencias=true;
	public Boolean activarnombre_sucursalProductosServiciosExistencias=true;

	public Border resaltarnombre_lineaProductosServiciosExistencias=null;
	public Boolean mostrarnombre_lineaProductosServiciosExistencias=true;
	public Boolean activarnombre_lineaProductosServiciosExistencias=true;

	public Border resaltarnombre_linea_grupoProductosServiciosExistencias=null;
	public Boolean mostrarnombre_linea_grupoProductosServiciosExistencias=true;
	public Boolean activarnombre_linea_grupoProductosServiciosExistencias=true;

	public Border resaltarnombre_linea_categoriaProductosServiciosExistencias=null;
	public Boolean mostrarnombre_linea_categoriaProductosServiciosExistencias=true;
	public Boolean activarnombre_linea_categoriaProductosServiciosExistencias=true;

	public Border resaltarnombre_linea_marcaProductosServiciosExistencias=null;
	public Boolean mostrarnombre_linea_marcaProductosServiciosExistencias=true;
	public Boolean activarnombre_linea_marcaProductosServiciosExistencias=true;

	public Border resaltarcodigoProductosServiciosExistencias=null;
	public Boolean mostrarcodigoProductosServiciosExistencias=true;
	public Boolean activarcodigoProductosServiciosExistencias=true;

	public Border resaltarnombreProductosServiciosExistencias=null;
	public Boolean mostrarnombreProductosServiciosExistencias=true;
	public Boolean activarnombreProductosServiciosExistencias=true;

	public Border resaltarnombre_tipo_producto_servicioProductosServiciosExistencias=null;
	public Boolean mostrarnombre_tipo_producto_servicioProductosServiciosExistencias=true;
	public Boolean activarnombre_tipo_producto_servicioProductosServiciosExistencias=true;

	public Border resaltarnombre_bodegaProductosServiciosExistencias=null;
	public Boolean mostrarnombre_bodegaProductosServiciosExistencias=true;
	public Boolean activarnombre_bodegaProductosServiciosExistencias=true;

	public Border resaltarnombre_unidadProductosServiciosExistencias=null;
	public Boolean mostrarnombre_unidadProductosServiciosExistencias=true;
	public Boolean activarnombre_unidadProductosServiciosExistencias=true;

	public Border resaltarcantidad_disponibleProductosServiciosExistencias=null;
	public Boolean mostrarcantidad_disponibleProductosServiciosExistencias=true;
	public Boolean activarcantidad_disponibleProductosServiciosExistencias=true;

	public Border resaltarcantidad_reservadaProductosServiciosExistencias=null;
	public Boolean mostrarcantidad_reservadaProductosServiciosExistencias=true;
	public Boolean activarcantidad_reservadaProductosServiciosExistencias=true;

	public Border resaltarcantidad_pedidaProductosServiciosExistencias=null;
	public Boolean mostrarcantidad_pedidaProductosServiciosExistencias=true;
	public Boolean activarcantidad_pedidaProductosServiciosExistencias=true;

	public Border resaltartotal_egresoProductosServiciosExistencias=null;
	public Boolean mostrartotal_egresoProductosServiciosExistencias=true;
	public Boolean activartotal_egresoProductosServiciosExistencias=true;

	public Border resaltartotal_compraProductosServiciosExistencias=null;
	public Boolean mostrartotal_compraProductosServiciosExistencias=true;
	public Boolean activartotal_compraProductosServiciosExistencias=true;

	public Border resaltartotal_devueltoProductosServiciosExistencias=null;
	public Boolean mostrartotal_devueltoProductosServiciosExistencias=true;
	public Boolean activartotal_devueltoProductosServiciosExistencias=true;

	
	

	public Border setResaltaridProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltaridProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosServiciosExistencias() {
		return this.resaltaridProductosServiciosExistencias;
	}

	public void setResaltaridProductosServiciosExistencias(Border borderResaltar) {
		this.resaltaridProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostraridProductosServiciosExistencias() {
		return this.mostraridProductosServiciosExistencias;
	}

	public void setMostraridProductosServiciosExistencias(Boolean mostraridProductosServiciosExistencias) {
		this.mostraridProductosServiciosExistencias= mostraridProductosServiciosExistencias;
	}

	public Boolean getActivaridProductosServiciosExistencias() {
		return this.activaridProductosServiciosExistencias;
	}

	public void setActivaridProductosServiciosExistencias(Boolean activaridProductosServiciosExistencias) {
		this.activaridProductosServiciosExistencias= activaridProductosServiciosExistencias;
	}

	public Border setResaltarid_empresaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosServiciosExistencias() {
		return this.resaltarid_empresaProductosServiciosExistencias;
	}

	public void setResaltarid_empresaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_empresaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosServiciosExistencias() {
		return this.mostrarid_empresaProductosServiciosExistencias;
	}

	public void setMostrarid_empresaProductosServiciosExistencias(Boolean mostrarid_empresaProductosServiciosExistencias) {
		this.mostrarid_empresaProductosServiciosExistencias= mostrarid_empresaProductosServiciosExistencias;
	}

	public Boolean getActivarid_empresaProductosServiciosExistencias() {
		return this.activarid_empresaProductosServiciosExistencias;
	}

	public void setActivarid_empresaProductosServiciosExistencias(Boolean activarid_empresaProductosServiciosExistencias) {
		this.activarid_empresaProductosServiciosExistencias= activarid_empresaProductosServiciosExistencias;
	}

	public Boolean getCargarid_empresaProductosServiciosExistencias() {
		return this.cargarid_empresaProductosServiciosExistencias;
	}

	public void setCargarid_empresaProductosServiciosExistencias(Boolean cargarid_empresaProductosServiciosExistencias) {
		this.cargarid_empresaProductosServiciosExistencias= cargarid_empresaProductosServiciosExistencias;
	}

	public Border setResaltarid_sucursalProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosServiciosExistencias() {
		return this.resaltarid_sucursalProductosServiciosExistencias;
	}

	public void setResaltarid_sucursalProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_sucursalProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosServiciosExistencias() {
		return this.mostrarid_sucursalProductosServiciosExistencias;
	}

	public void setMostrarid_sucursalProductosServiciosExistencias(Boolean mostrarid_sucursalProductosServiciosExistencias) {
		this.mostrarid_sucursalProductosServiciosExistencias= mostrarid_sucursalProductosServiciosExistencias;
	}

	public Boolean getActivarid_sucursalProductosServiciosExistencias() {
		return this.activarid_sucursalProductosServiciosExistencias;
	}

	public void setActivarid_sucursalProductosServiciosExistencias(Boolean activarid_sucursalProductosServiciosExistencias) {
		this.activarid_sucursalProductosServiciosExistencias= activarid_sucursalProductosServiciosExistencias;
	}

	public Boolean getCargarid_sucursalProductosServiciosExistencias() {
		return this.cargarid_sucursalProductosServiciosExistencias;
	}

	public void setCargarid_sucursalProductosServiciosExistencias(Boolean cargarid_sucursalProductosServiciosExistencias) {
		this.cargarid_sucursalProductosServiciosExistencias= cargarid_sucursalProductosServiciosExistencias;
	}

	public Border setResaltarid_bodegaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosServiciosExistencias() {
		return this.resaltarid_bodegaProductosServiciosExistencias;
	}

	public void setResaltarid_bodegaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_bodegaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosServiciosExistencias() {
		return this.mostrarid_bodegaProductosServiciosExistencias;
	}

	public void setMostrarid_bodegaProductosServiciosExistencias(Boolean mostrarid_bodegaProductosServiciosExistencias) {
		this.mostrarid_bodegaProductosServiciosExistencias= mostrarid_bodegaProductosServiciosExistencias;
	}

	public Boolean getActivarid_bodegaProductosServiciosExistencias() {
		return this.activarid_bodegaProductosServiciosExistencias;
	}

	public void setActivarid_bodegaProductosServiciosExistencias(Boolean activarid_bodegaProductosServiciosExistencias) {
		this.activarid_bodegaProductosServiciosExistencias= activarid_bodegaProductosServiciosExistencias;
	}

	public Boolean getCargarid_bodegaProductosServiciosExistencias() {
		return this.cargarid_bodegaProductosServiciosExistencias;
	}

	public void setCargarid_bodegaProductosServiciosExistencias(Boolean cargarid_bodegaProductosServiciosExistencias) {
		this.cargarid_bodegaProductosServiciosExistencias= cargarid_bodegaProductosServiciosExistencias;
	}

	public Border setResaltarid_productoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_productoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductosServiciosExistencias() {
		return this.resaltarid_productoProductosServiciosExistencias;
	}

	public void setResaltarid_productoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_productoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_productoProductosServiciosExistencias() {
		return this.mostrarid_productoProductosServiciosExistencias;
	}

	public void setMostrarid_productoProductosServiciosExistencias(Boolean mostrarid_productoProductosServiciosExistencias) {
		this.mostrarid_productoProductosServiciosExistencias= mostrarid_productoProductosServiciosExistencias;
	}

	public Boolean getActivarid_productoProductosServiciosExistencias() {
		return this.activarid_productoProductosServiciosExistencias;
	}

	public void setActivarid_productoProductosServiciosExistencias(Boolean activarid_productoProductosServiciosExistencias) {
		this.activarid_productoProductosServiciosExistencias= activarid_productoProductosServiciosExistencias;
	}

	public Boolean getCargarid_productoProductosServiciosExistencias() {
		return this.cargarid_productoProductosServiciosExistencias;
	}

	public void setCargarid_productoProductosServiciosExistencias(Boolean cargarid_productoProductosServiciosExistencias) {
		this.cargarid_productoProductosServiciosExistencias= cargarid_productoProductosServiciosExistencias;
	}

	public Border setResaltarid_lineaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosServiciosExistencias() {
		return this.resaltarid_lineaProductosServiciosExistencias;
	}

	public void setResaltarid_lineaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_lineaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosServiciosExistencias() {
		return this.mostrarid_lineaProductosServiciosExistencias;
	}

	public void setMostrarid_lineaProductosServiciosExistencias(Boolean mostrarid_lineaProductosServiciosExistencias) {
		this.mostrarid_lineaProductosServiciosExistencias= mostrarid_lineaProductosServiciosExistencias;
	}

	public Boolean getActivarid_lineaProductosServiciosExistencias() {
		return this.activarid_lineaProductosServiciosExistencias;
	}

	public void setActivarid_lineaProductosServiciosExistencias(Boolean activarid_lineaProductosServiciosExistencias) {
		this.activarid_lineaProductosServiciosExistencias= activarid_lineaProductosServiciosExistencias;
	}

	public Boolean getCargarid_lineaProductosServiciosExistencias() {
		return this.cargarid_lineaProductosServiciosExistencias;
	}

	public void setCargarid_lineaProductosServiciosExistencias(Boolean cargarid_lineaProductosServiciosExistencias) {
		this.cargarid_lineaProductosServiciosExistencias= cargarid_lineaProductosServiciosExistencias;
	}

	public Border setResaltarid_linea_grupoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosServiciosExistencias() {
		return this.resaltarid_linea_grupoProductosServiciosExistencias;
	}

	public void setResaltarid_linea_grupoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosServiciosExistencias() {
		return this.mostrarid_linea_grupoProductosServiciosExistencias;
	}

	public void setMostrarid_linea_grupoProductosServiciosExistencias(Boolean mostrarid_linea_grupoProductosServiciosExistencias) {
		this.mostrarid_linea_grupoProductosServiciosExistencias= mostrarid_linea_grupoProductosServiciosExistencias;
	}

	public Boolean getActivarid_linea_grupoProductosServiciosExistencias() {
		return this.activarid_linea_grupoProductosServiciosExistencias;
	}

	public void setActivarid_linea_grupoProductosServiciosExistencias(Boolean activarid_linea_grupoProductosServiciosExistencias) {
		this.activarid_linea_grupoProductosServiciosExistencias= activarid_linea_grupoProductosServiciosExistencias;
	}

	public Boolean getCargarid_linea_grupoProductosServiciosExistencias() {
		return this.cargarid_linea_grupoProductosServiciosExistencias;
	}

	public void setCargarid_linea_grupoProductosServiciosExistencias(Boolean cargarid_linea_grupoProductosServiciosExistencias) {
		this.cargarid_linea_grupoProductosServiciosExistencias= cargarid_linea_grupoProductosServiciosExistencias;
	}

	public Border setResaltarid_linea_categoriaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosServiciosExistencias() {
		return this.resaltarid_linea_categoriaProductosServiciosExistencias;
	}

	public void setResaltarid_linea_categoriaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosServiciosExistencias() {
		return this.mostrarid_linea_categoriaProductosServiciosExistencias;
	}

	public void setMostrarid_linea_categoriaProductosServiciosExistencias(Boolean mostrarid_linea_categoriaProductosServiciosExistencias) {
		this.mostrarid_linea_categoriaProductosServiciosExistencias= mostrarid_linea_categoriaProductosServiciosExistencias;
	}

	public Boolean getActivarid_linea_categoriaProductosServiciosExistencias() {
		return this.activarid_linea_categoriaProductosServiciosExistencias;
	}

	public void setActivarid_linea_categoriaProductosServiciosExistencias(Boolean activarid_linea_categoriaProductosServiciosExistencias) {
		this.activarid_linea_categoriaProductosServiciosExistencias= activarid_linea_categoriaProductosServiciosExistencias;
	}

	public Boolean getCargarid_linea_categoriaProductosServiciosExistencias() {
		return this.cargarid_linea_categoriaProductosServiciosExistencias;
	}

	public void setCargarid_linea_categoriaProductosServiciosExistencias(Boolean cargarid_linea_categoriaProductosServiciosExistencias) {
		this.cargarid_linea_categoriaProductosServiciosExistencias= cargarid_linea_categoriaProductosServiciosExistencias;
	}

	public Border setResaltarid_linea_marcaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosServiciosExistencias() {
		return this.resaltarid_linea_marcaProductosServiciosExistencias;
	}

	public void setResaltarid_linea_marcaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosServiciosExistencias() {
		return this.mostrarid_linea_marcaProductosServiciosExistencias;
	}

	public void setMostrarid_linea_marcaProductosServiciosExistencias(Boolean mostrarid_linea_marcaProductosServiciosExistencias) {
		this.mostrarid_linea_marcaProductosServiciosExistencias= mostrarid_linea_marcaProductosServiciosExistencias;
	}

	public Boolean getActivarid_linea_marcaProductosServiciosExistencias() {
		return this.activarid_linea_marcaProductosServiciosExistencias;
	}

	public void setActivarid_linea_marcaProductosServiciosExistencias(Boolean activarid_linea_marcaProductosServiciosExistencias) {
		this.activarid_linea_marcaProductosServiciosExistencias= activarid_linea_marcaProductosServiciosExistencias;
	}

	public Boolean getCargarid_linea_marcaProductosServiciosExistencias() {
		return this.cargarid_linea_marcaProductosServiciosExistencias;
	}

	public void setCargarid_linea_marcaProductosServiciosExistencias(Boolean cargarid_linea_marcaProductosServiciosExistencias) {
		this.cargarid_linea_marcaProductosServiciosExistencias= cargarid_linea_marcaProductosServiciosExistencias;
	}

	public Border setResaltarid_tipo_producto_servicioProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioProductosServiciosExistencias() {
		return this.resaltarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setResaltarid_tipo_producto_servicioProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioProductosServiciosExistencias() {
		return this.mostrarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setMostrarid_tipo_producto_servicioProductosServiciosExistencias(Boolean mostrarid_tipo_producto_servicioProductosServiciosExistencias) {
		this.mostrarid_tipo_producto_servicioProductosServiciosExistencias= mostrarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public Boolean getActivarid_tipo_producto_servicioProductosServiciosExistencias() {
		return this.activarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setActivarid_tipo_producto_servicioProductosServiciosExistencias(Boolean activarid_tipo_producto_servicioProductosServiciosExistencias) {
		this.activarid_tipo_producto_servicioProductosServiciosExistencias= activarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public Boolean getCargarid_tipo_producto_servicioProductosServiciosExistencias() {
		return this.cargarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setCargarid_tipo_producto_servicioProductosServiciosExistencias(Boolean cargarid_tipo_producto_servicioProductosServiciosExistencias) {
		this.cargarid_tipo_producto_servicioProductosServiciosExistencias= cargarid_tipo_producto_servicioProductosServiciosExistencias;
	}

	public Border setResaltarnombre_sucursalProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProductosServiciosExistencias() {
		return this.resaltarnombre_sucursalProductosServiciosExistencias;
	}

	public void setResaltarnombre_sucursalProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_sucursalProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProductosServiciosExistencias() {
		return this.mostrarnombre_sucursalProductosServiciosExistencias;
	}

	public void setMostrarnombre_sucursalProductosServiciosExistencias(Boolean mostrarnombre_sucursalProductosServiciosExistencias) {
		this.mostrarnombre_sucursalProductosServiciosExistencias= mostrarnombre_sucursalProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_sucursalProductosServiciosExistencias() {
		return this.activarnombre_sucursalProductosServiciosExistencias;
	}

	public void setActivarnombre_sucursalProductosServiciosExistencias(Boolean activarnombre_sucursalProductosServiciosExistencias) {
		this.activarnombre_sucursalProductosServiciosExistencias= activarnombre_sucursalProductosServiciosExistencias;
	}

	public Border setResaltarnombre_lineaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaProductosServiciosExistencias() {
		return this.resaltarnombre_lineaProductosServiciosExistencias;
	}

	public void setResaltarnombre_lineaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_lineaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaProductosServiciosExistencias() {
		return this.mostrarnombre_lineaProductosServiciosExistencias;
	}

	public void setMostrarnombre_lineaProductosServiciosExistencias(Boolean mostrarnombre_lineaProductosServiciosExistencias) {
		this.mostrarnombre_lineaProductosServiciosExistencias= mostrarnombre_lineaProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_lineaProductosServiciosExistencias() {
		return this.activarnombre_lineaProductosServiciosExistencias;
	}

	public void setActivarnombre_lineaProductosServiciosExistencias(Boolean activarnombre_lineaProductosServiciosExistencias) {
		this.activarnombre_lineaProductosServiciosExistencias= activarnombre_lineaProductosServiciosExistencias;
	}

	public Border setResaltarnombre_linea_grupoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoProductosServiciosExistencias() {
		return this.resaltarnombre_linea_grupoProductosServiciosExistencias;
	}

	public void setResaltarnombre_linea_grupoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_linea_grupoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoProductosServiciosExistencias() {
		return this.mostrarnombre_linea_grupoProductosServiciosExistencias;
	}

	public void setMostrarnombre_linea_grupoProductosServiciosExistencias(Boolean mostrarnombre_linea_grupoProductosServiciosExistencias) {
		this.mostrarnombre_linea_grupoProductosServiciosExistencias= mostrarnombre_linea_grupoProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_linea_grupoProductosServiciosExistencias() {
		return this.activarnombre_linea_grupoProductosServiciosExistencias;
	}

	public void setActivarnombre_linea_grupoProductosServiciosExistencias(Boolean activarnombre_linea_grupoProductosServiciosExistencias) {
		this.activarnombre_linea_grupoProductosServiciosExistencias= activarnombre_linea_grupoProductosServiciosExistencias;
	}

	public Border setResaltarnombre_linea_categoriaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaProductosServiciosExistencias() {
		return this.resaltarnombre_linea_categoriaProductosServiciosExistencias;
	}

	public void setResaltarnombre_linea_categoriaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaProductosServiciosExistencias() {
		return this.mostrarnombre_linea_categoriaProductosServiciosExistencias;
	}

	public void setMostrarnombre_linea_categoriaProductosServiciosExistencias(Boolean mostrarnombre_linea_categoriaProductosServiciosExistencias) {
		this.mostrarnombre_linea_categoriaProductosServiciosExistencias= mostrarnombre_linea_categoriaProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_linea_categoriaProductosServiciosExistencias() {
		return this.activarnombre_linea_categoriaProductosServiciosExistencias;
	}

	public void setActivarnombre_linea_categoriaProductosServiciosExistencias(Boolean activarnombre_linea_categoriaProductosServiciosExistencias) {
		this.activarnombre_linea_categoriaProductosServiciosExistencias= activarnombre_linea_categoriaProductosServiciosExistencias;
	}

	public Border setResaltarnombre_linea_marcaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaProductosServiciosExistencias() {
		return this.resaltarnombre_linea_marcaProductosServiciosExistencias;
	}

	public void setResaltarnombre_linea_marcaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_linea_marcaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaProductosServiciosExistencias() {
		return this.mostrarnombre_linea_marcaProductosServiciosExistencias;
	}

	public void setMostrarnombre_linea_marcaProductosServiciosExistencias(Boolean mostrarnombre_linea_marcaProductosServiciosExistencias) {
		this.mostrarnombre_linea_marcaProductosServiciosExistencias= mostrarnombre_linea_marcaProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_linea_marcaProductosServiciosExistencias() {
		return this.activarnombre_linea_marcaProductosServiciosExistencias;
	}

	public void setActivarnombre_linea_marcaProductosServiciosExistencias(Boolean activarnombre_linea_marcaProductosServiciosExistencias) {
		this.activarnombre_linea_marcaProductosServiciosExistencias= activarnombre_linea_marcaProductosServiciosExistencias;
	}

	public Border setResaltarcodigoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarcodigoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProductosServiciosExistencias() {
		return this.resaltarcodigoProductosServiciosExistencias;
	}

	public void setResaltarcodigoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarcodigoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarcodigoProductosServiciosExistencias() {
		return this.mostrarcodigoProductosServiciosExistencias;
	}

	public void setMostrarcodigoProductosServiciosExistencias(Boolean mostrarcodigoProductosServiciosExistencias) {
		this.mostrarcodigoProductosServiciosExistencias= mostrarcodigoProductosServiciosExistencias;
	}

	public Boolean getActivarcodigoProductosServiciosExistencias() {
		return this.activarcodigoProductosServiciosExistencias;
	}

	public void setActivarcodigoProductosServiciosExistencias(Boolean activarcodigoProductosServiciosExistencias) {
		this.activarcodigoProductosServiciosExistencias= activarcodigoProductosServiciosExistencias;
	}

	public Border setResaltarnombreProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombreProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProductosServiciosExistencias() {
		return this.resaltarnombreProductosServiciosExistencias;
	}

	public void setResaltarnombreProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombreProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombreProductosServiciosExistencias() {
		return this.mostrarnombreProductosServiciosExistencias;
	}

	public void setMostrarnombreProductosServiciosExistencias(Boolean mostrarnombreProductosServiciosExistencias) {
		this.mostrarnombreProductosServiciosExistencias= mostrarnombreProductosServiciosExistencias;
	}

	public Boolean getActivarnombreProductosServiciosExistencias() {
		return this.activarnombreProductosServiciosExistencias;
	}

	public void setActivarnombreProductosServiciosExistencias(Boolean activarnombreProductosServiciosExistencias) {
		this.activarnombreProductosServiciosExistencias= activarnombreProductosServiciosExistencias;
	}

	public Border setResaltarnombre_tipo_producto_servicioProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_producto_servicioProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_producto_servicioProductosServiciosExistencias() {
		return this.resaltarnombre_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setResaltarnombre_tipo_producto_servicioProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_tipo_producto_servicioProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_producto_servicioProductosServiciosExistencias() {
		return this.mostrarnombre_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setMostrarnombre_tipo_producto_servicioProductosServiciosExistencias(Boolean mostrarnombre_tipo_producto_servicioProductosServiciosExistencias) {
		this.mostrarnombre_tipo_producto_servicioProductosServiciosExistencias= mostrarnombre_tipo_producto_servicioProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_tipo_producto_servicioProductosServiciosExistencias() {
		return this.activarnombre_tipo_producto_servicioProductosServiciosExistencias;
	}

	public void setActivarnombre_tipo_producto_servicioProductosServiciosExistencias(Boolean activarnombre_tipo_producto_servicioProductosServiciosExistencias) {
		this.activarnombre_tipo_producto_servicioProductosServiciosExistencias= activarnombre_tipo_producto_servicioProductosServiciosExistencias;
	}

	public Border setResaltarnombre_bodegaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProductosServiciosExistencias() {
		return this.resaltarnombre_bodegaProductosServiciosExistencias;
	}

	public void setResaltarnombre_bodegaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_bodegaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProductosServiciosExistencias() {
		return this.mostrarnombre_bodegaProductosServiciosExistencias;
	}

	public void setMostrarnombre_bodegaProductosServiciosExistencias(Boolean mostrarnombre_bodegaProductosServiciosExistencias) {
		this.mostrarnombre_bodegaProductosServiciosExistencias= mostrarnombre_bodegaProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_bodegaProductosServiciosExistencias() {
		return this.activarnombre_bodegaProductosServiciosExistencias;
	}

	public void setActivarnombre_bodegaProductosServiciosExistencias(Boolean activarnombre_bodegaProductosServiciosExistencias) {
		this.activarnombre_bodegaProductosServiciosExistencias= activarnombre_bodegaProductosServiciosExistencias;
	}

	public Border setResaltarnombre_unidadProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosServiciosExistencias() {
		return this.resaltarnombre_unidadProductosServiciosExistencias;
	}

	public void setResaltarnombre_unidadProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarnombre_unidadProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosServiciosExistencias() {
		return this.mostrarnombre_unidadProductosServiciosExistencias;
	}

	public void setMostrarnombre_unidadProductosServiciosExistencias(Boolean mostrarnombre_unidadProductosServiciosExistencias) {
		this.mostrarnombre_unidadProductosServiciosExistencias= mostrarnombre_unidadProductosServiciosExistencias;
	}

	public Boolean getActivarnombre_unidadProductosServiciosExistencias() {
		return this.activarnombre_unidadProductosServiciosExistencias;
	}

	public void setActivarnombre_unidadProductosServiciosExistencias(Boolean activarnombre_unidadProductosServiciosExistencias) {
		this.activarnombre_unidadProductosServiciosExistencias= activarnombre_unidadProductosServiciosExistencias;
	}

	public Border setResaltarcantidad_disponibleProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleProductosServiciosExistencias() {
		return this.resaltarcantidad_disponibleProductosServiciosExistencias;
	}

	public void setResaltarcantidad_disponibleProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarcantidad_disponibleProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleProductosServiciosExistencias() {
		return this.mostrarcantidad_disponibleProductosServiciosExistencias;
	}

	public void setMostrarcantidad_disponibleProductosServiciosExistencias(Boolean mostrarcantidad_disponibleProductosServiciosExistencias) {
		this.mostrarcantidad_disponibleProductosServiciosExistencias= mostrarcantidad_disponibleProductosServiciosExistencias;
	}

	public Boolean getActivarcantidad_disponibleProductosServiciosExistencias() {
		return this.activarcantidad_disponibleProductosServiciosExistencias;
	}

	public void setActivarcantidad_disponibleProductosServiciosExistencias(Boolean activarcantidad_disponibleProductosServiciosExistencias) {
		this.activarcantidad_disponibleProductosServiciosExistencias= activarcantidad_disponibleProductosServiciosExistencias;
	}

	public Border setResaltarcantidad_reservadaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarcantidad_reservadaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_reservadaProductosServiciosExistencias() {
		return this.resaltarcantidad_reservadaProductosServiciosExistencias;
	}

	public void setResaltarcantidad_reservadaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarcantidad_reservadaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarcantidad_reservadaProductosServiciosExistencias() {
		return this.mostrarcantidad_reservadaProductosServiciosExistencias;
	}

	public void setMostrarcantidad_reservadaProductosServiciosExistencias(Boolean mostrarcantidad_reservadaProductosServiciosExistencias) {
		this.mostrarcantidad_reservadaProductosServiciosExistencias= mostrarcantidad_reservadaProductosServiciosExistencias;
	}

	public Boolean getActivarcantidad_reservadaProductosServiciosExistencias() {
		return this.activarcantidad_reservadaProductosServiciosExistencias;
	}

	public void setActivarcantidad_reservadaProductosServiciosExistencias(Boolean activarcantidad_reservadaProductosServiciosExistencias) {
		this.activarcantidad_reservadaProductosServiciosExistencias= activarcantidad_reservadaProductosServiciosExistencias;
	}

	public Border setResaltarcantidad_pedidaProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidaProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidaProductosServiciosExistencias() {
		return this.resaltarcantidad_pedidaProductosServiciosExistencias;
	}

	public void setResaltarcantidad_pedidaProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarcantidad_pedidaProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidaProductosServiciosExistencias() {
		return this.mostrarcantidad_pedidaProductosServiciosExistencias;
	}

	public void setMostrarcantidad_pedidaProductosServiciosExistencias(Boolean mostrarcantidad_pedidaProductosServiciosExistencias) {
		this.mostrarcantidad_pedidaProductosServiciosExistencias= mostrarcantidad_pedidaProductosServiciosExistencias;
	}

	public Boolean getActivarcantidad_pedidaProductosServiciosExistencias() {
		return this.activarcantidad_pedidaProductosServiciosExistencias;
	}

	public void setActivarcantidad_pedidaProductosServiciosExistencias(Boolean activarcantidad_pedidaProductosServiciosExistencias) {
		this.activarcantidad_pedidaProductosServiciosExistencias= activarcantidad_pedidaProductosServiciosExistencias;
	}

	public Border setResaltartotal_egresoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltartotal_egresoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_egresoProductosServiciosExistencias() {
		return this.resaltartotal_egresoProductosServiciosExistencias;
	}

	public void setResaltartotal_egresoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltartotal_egresoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrartotal_egresoProductosServiciosExistencias() {
		return this.mostrartotal_egresoProductosServiciosExistencias;
	}

	public void setMostrartotal_egresoProductosServiciosExistencias(Boolean mostrartotal_egresoProductosServiciosExistencias) {
		this.mostrartotal_egresoProductosServiciosExistencias= mostrartotal_egresoProductosServiciosExistencias;
	}

	public Boolean getActivartotal_egresoProductosServiciosExistencias() {
		return this.activartotal_egresoProductosServiciosExistencias;
	}

	public void setActivartotal_egresoProductosServiciosExistencias(Boolean activartotal_egresoProductosServiciosExistencias) {
		this.activartotal_egresoProductosServiciosExistencias= activartotal_egresoProductosServiciosExistencias;
	}

	public Border setResaltartotal_compraProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltartotal_compraProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_compraProductosServiciosExistencias() {
		return this.resaltartotal_compraProductosServiciosExistencias;
	}

	public void setResaltartotal_compraProductosServiciosExistencias(Border borderResaltar) {
		this.resaltartotal_compraProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrartotal_compraProductosServiciosExistencias() {
		return this.mostrartotal_compraProductosServiciosExistencias;
	}

	public void setMostrartotal_compraProductosServiciosExistencias(Boolean mostrartotal_compraProductosServiciosExistencias) {
		this.mostrartotal_compraProductosServiciosExistencias= mostrartotal_compraProductosServiciosExistencias;
	}

	public Boolean getActivartotal_compraProductosServiciosExistencias() {
		return this.activartotal_compraProductosServiciosExistencias;
	}

	public void setActivartotal_compraProductosServiciosExistencias(Boolean activartotal_compraProductosServiciosExistencias) {
		this.activartotal_compraProductosServiciosExistencias= activartotal_compraProductosServiciosExistencias;
	}

	public Border setResaltartotal_devueltoProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosexistenciasBeanSwingJInternalFrame.jTtoolBarProductosServiciosExistencias.setBorder(borderResaltar);
		
		this.resaltartotal_devueltoProductosServiciosExistencias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_devueltoProductosServiciosExistencias() {
		return this.resaltartotal_devueltoProductosServiciosExistencias;
	}

	public void setResaltartotal_devueltoProductosServiciosExistencias(Border borderResaltar) {
		this.resaltartotal_devueltoProductosServiciosExistencias= borderResaltar;
	}

	public Boolean getMostrartotal_devueltoProductosServiciosExistencias() {
		return this.mostrartotal_devueltoProductosServiciosExistencias;
	}

	public void setMostrartotal_devueltoProductosServiciosExistencias(Boolean mostrartotal_devueltoProductosServiciosExistencias) {
		this.mostrartotal_devueltoProductosServiciosExistencias= mostrartotal_devueltoProductosServiciosExistencias;
	}

	public Boolean getActivartotal_devueltoProductosServiciosExistencias() {
		return this.activartotal_devueltoProductosServiciosExistencias;
	}

	public void setActivartotal_devueltoProductosServiciosExistencias(Boolean activartotal_devueltoProductosServiciosExistencias) {
		this.activartotal_devueltoProductosServiciosExistencias= activartotal_devueltoProductosServiciosExistencias;
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
		
		
		this.setMostraridProductosServiciosExistencias(esInicial);
		this.setMostrarid_empresaProductosServiciosExistencias(esInicial);
		this.setMostrarid_sucursalProductosServiciosExistencias(esInicial);
		this.setMostrarid_bodegaProductosServiciosExistencias(esInicial);
		this.setMostrarid_productoProductosServiciosExistencias(esInicial);
		this.setMostrarid_lineaProductosServiciosExistencias(esInicial);
		this.setMostrarid_linea_grupoProductosServiciosExistencias(esInicial);
		this.setMostrarid_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setMostrarid_linea_marcaProductosServiciosExistencias(esInicial);
		this.setMostrarid_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_sucursalProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_lineaProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_linea_grupoProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_linea_marcaProductosServiciosExistencias(esInicial);
		this.setMostrarcodigoProductosServiciosExistencias(esInicial);
		this.setMostrarnombreProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_bodegaProductosServiciosExistencias(esInicial);
		this.setMostrarnombre_unidadProductosServiciosExistencias(esInicial);
		this.setMostrarcantidad_disponibleProductosServiciosExistencias(esInicial);
		this.setMostrarcantidad_reservadaProductosServiciosExistencias(esInicial);
		this.setMostrarcantidad_pedidaProductosServiciosExistencias(esInicial);
		this.setMostrartotal_egresoProductosServiciosExistencias(esInicial);
		this.setMostrartotal_compraProductosServiciosExistencias(esInicial);
		this.setMostrartotal_devueltoProductosServiciosExistencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.ID)) {
				this.setMostraridProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setMostrarnombre_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA)) {
				this.setMostrarcantidad_reservadaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA)) {
				this.setMostrarcantidad_pedidaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO)) {
				this.setMostrartotal_egresoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA)) {
				this.setMostrartotal_compraProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO)) {
				this.setMostrartotal_devueltoProductosServiciosExistencias(esAsigna);
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
		
		
		this.setActivaridProductosServiciosExistencias(esInicial);
		this.setActivarid_empresaProductosServiciosExistencias(esInicial);
		this.setActivarid_sucursalProductosServiciosExistencias(esInicial);
		this.setActivarid_bodegaProductosServiciosExistencias(esInicial);
		this.setActivarid_productoProductosServiciosExistencias(esInicial);
		this.setActivarid_lineaProductosServiciosExistencias(esInicial);
		this.setActivarid_linea_grupoProductosServiciosExistencias(esInicial);
		this.setActivarid_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setActivarid_linea_marcaProductosServiciosExistencias(esInicial);
		this.setActivarid_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setActivarnombre_sucursalProductosServiciosExistencias(esInicial);
		this.setActivarnombre_lineaProductosServiciosExistencias(esInicial);
		this.setActivarnombre_linea_grupoProductosServiciosExistencias(esInicial);
		this.setActivarnombre_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setActivarnombre_linea_marcaProductosServiciosExistencias(esInicial);
		this.setActivarcodigoProductosServiciosExistencias(esInicial);
		this.setActivarnombreProductosServiciosExistencias(esInicial);
		this.setActivarnombre_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setActivarnombre_bodegaProductosServiciosExistencias(esInicial);
		this.setActivarnombre_unidadProductosServiciosExistencias(esInicial);
		this.setActivarcantidad_disponibleProductosServiciosExistencias(esInicial);
		this.setActivarcantidad_reservadaProductosServiciosExistencias(esInicial);
		this.setActivarcantidad_pedidaProductosServiciosExistencias(esInicial);
		this.setActivartotal_egresoProductosServiciosExistencias(esInicial);
		this.setActivartotal_compraProductosServiciosExistencias(esInicial);
		this.setActivartotal_devueltoProductosServiciosExistencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.ID)) {
				this.setActivaridProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setActivarnombre_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA)) {
				this.setActivarcantidad_reservadaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA)) {
				this.setActivarcantidad_pedidaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO)) {
				this.setActivartotal_egresoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA)) {
				this.setActivartotal_compraProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO)) {
				this.setActivartotal_devueltoProductosServiciosExistencias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosServiciosExistencias(esInicial);
		this.setResaltarid_empresaProductosServiciosExistencias(esInicial);
		this.setResaltarid_sucursalProductosServiciosExistencias(esInicial);
		this.setResaltarid_bodegaProductosServiciosExistencias(esInicial);
		this.setResaltarid_productoProductosServiciosExistencias(esInicial);
		this.setResaltarid_lineaProductosServiciosExistencias(esInicial);
		this.setResaltarid_linea_grupoProductosServiciosExistencias(esInicial);
		this.setResaltarid_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setResaltarid_linea_marcaProductosServiciosExistencias(esInicial);
		this.setResaltarid_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_sucursalProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_lineaProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_linea_grupoProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_linea_categoriaProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_linea_marcaProductosServiciosExistencias(esInicial);
		this.setResaltarcodigoProductosServiciosExistencias(esInicial);
		this.setResaltarnombreProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_tipo_producto_servicioProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_bodegaProductosServiciosExistencias(esInicial);
		this.setResaltarnombre_unidadProductosServiciosExistencias(esInicial);
		this.setResaltarcantidad_disponibleProductosServiciosExistencias(esInicial);
		this.setResaltarcantidad_reservadaProductosServiciosExistencias(esInicial);
		this.setResaltarcantidad_pedidaProductosServiciosExistencias(esInicial);
		this.setResaltartotal_egresoProductosServiciosExistencias(esInicial);
		this.setResaltartotal_compraProductosServiciosExistencias(esInicial);
		this.setResaltartotal_devueltoProductosServiciosExistencias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.ID)) {
				this.setResaltaridProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setResaltarnombre_tipo_producto_servicioProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA)) {
				this.setResaltarcantidad_reservadaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA)) {
				this.setResaltarcantidad_pedidaProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO)) {
				this.setResaltartotal_egresoProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA)) {
				this.setResaltartotal_compraProductosServiciosExistencias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO)) {
				this.setResaltartotal_devueltoProductosServiciosExistencias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosServiciosExistenciasProductosServiciosExistencias=true;

	public Boolean getMostrarBusquedaProductosServiciosExistenciasProductosServiciosExistencias() {
		return this.mostrarBusquedaProductosServiciosExistenciasProductosServiciosExistencias;
	}

	public void setMostrarBusquedaProductosServiciosExistenciasProductosServiciosExistencias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosServiciosExistenciasProductosServiciosExistencias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosServiciosExistenciasProductosServiciosExistencias=true;

	public Boolean getActivarBusquedaProductosServiciosExistenciasProductosServiciosExistencias() {
		return this.activarBusquedaProductosServiciosExistenciasProductosServiciosExistencias;
	}

	public void setActivarBusquedaProductosServiciosExistenciasProductosServiciosExistencias(Boolean habilitarResaltar) {
		this.activarBusquedaProductosServiciosExistenciasProductosServiciosExistencias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias=null;

	public Border getResaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias() {
		return this.resaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias;
	}

	public void setResaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias(Border borderResaltar) {
		this.resaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias= borderResaltar;
	}

	public void setResaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosExistenciasBeanSwingJInternalFrame productosserviciosexistenciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosServiciosExistenciasProductosServiciosExistencias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}