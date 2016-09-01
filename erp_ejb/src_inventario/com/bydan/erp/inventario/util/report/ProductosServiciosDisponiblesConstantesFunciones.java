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


import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesParameterGeneral;

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
final public class ProductosServiciosDisponiblesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosServiciosDisponibles";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosServiciosDisponibles"+ProductosServiciosDisponiblesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosServiciosDisponiblesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosServiciosDisponiblesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"_"+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"_"+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"_"+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"_"+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosServiciosDisponiblesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosServiciosDisponiblesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosServiciosDisponiblesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosServiciosDisponiblesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Servicios Disponibleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Servicios Disponibles";
	public static final String SCLASSWEBTITULO_LOWER="Productos Servicios Disponibles";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosServiciosDisponibles";
	public static final String OBJECTNAME="productosserviciosdisponibles";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="productos_servicios_disponibles";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosserviciosdisponibles from "+ProductosServiciosDisponiblesConstantesFunciones.SPERSISTENCENAME+" productosserviciosdisponibles";
	public static String QUERYSELECTNATIVE="select "+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".version_row,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_empresa,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_bodega,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_linea,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_linea,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".codigo,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_tipo_producto_servicio,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_bodega,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".cantidad_disponible,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".cantidad_maximo,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".cantidad_minimo,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".precio_compra,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".precio_venta,"+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME+".costo_ultimo from "+ProductosServiciosDisponiblesConstantesFunciones.SCHEMA+"."+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME;//+" as "+ProductosServiciosDisponiblesConstantesFunciones.TABLENAME;
	
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
    public static final String CANTIDADMAXIMO= "cantidad_maximo";
    public static final String CANTIDADMINIMO= "cantidad_minimo";
    public static final String PRECIOCOMPRA= "precio_compra";
    public static final String PRECIOVENTA= "precio_venta";
    public static final String COSTOULTIMO= "costo_ultimo";
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
    	public static final String LABEL_CANTIDADMAXIMO= "Cantad Maximo";
		public static final String LABEL_CANTIDADMAXIMO_LOWER= "Cantidad Maximo";
    	public static final String LABEL_CANTIDADMINIMO= "Cantad Minimo";
		public static final String LABEL_CANTIDADMINIMO_LOWER= "Cantidad Minimo";
    	public static final String LABEL_PRECIOCOMPRA= "Precio Compra";
		public static final String LABEL_PRECIOCOMPRA_LOWER= "Precio Compra";
    	public static final String LABEL_PRECIOVENTA= "Precio Venta";
		public static final String LABEL_PRECIOVENTA_LOWER= "Precio Venta";
    	public static final String LABEL_COSTOULTIMO= "Costo Ultimo";
		public static final String LABEL_COSTOULTIMO_LOWER= "Costo Ultimo";
	
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		
		
	
	public static String getProductosServiciosDisponiblesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.CODIGO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRE)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMAXIMO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMINIMO;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA;}
		if(sNombreColumna.equals(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO)) {sLabelColumna=ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosServiciosDisponiblesDescripcion(ProductosServiciosDisponibles productosserviciosdisponibles) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosserviciosdisponibles !=null/* && productosserviciosdisponibles.getId()!=0*/) {
			sDescripcion=productosserviciosdisponibles.getcodigo();//productosserviciosdisponiblesproductosserviciosdisponibles.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosServiciosDisponiblesDescripcionDetallado(ProductosServiciosDisponibles productosserviciosdisponibles) {
		String sDescripcion="";
			
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.ID+"=";
		sDescripcion+=productosserviciosdisponibles.getId().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosserviciosdisponibles.getVersionRow().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosserviciosdisponibles.getid_empresa().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosserviciosdisponibles.getid_sucursal().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productosserviciosdisponibles.getid_bodega().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productosserviciosdisponibles.getid_linea().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productosserviciosdisponibles.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productosserviciosdisponibles.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productosserviciosdisponibles.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosdisponibles.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_sucursal()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_linea()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_linea_grupo()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_linea_categoria()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_linea_marca()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.CODIGO+"=";
		sDescripcion+=productosserviciosdisponibles.getcodigo()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_tipo_producto_servicio()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_bodega()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosserviciosdisponibles.getnombre_unidad()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=productosserviciosdisponibles.getcantidad_disponible().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO+"=";
		sDescripcion+=productosserviciosdisponibles.getcantidad_maximo().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO+"=";
		sDescripcion+=productosserviciosdisponibles.getcantidad_minimo().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA+"=";
		sDescripcion+=productosserviciosdisponibles.getprecio_compra().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA+"=";
		sDescripcion+=productosserviciosdisponibles.getprecio_venta().toString()+",";
		sDescripcion+=ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO+"=";
		sDescripcion+=productosserviciosdisponibles.getcosto_ultimo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosServiciosDisponiblesDescripcion(ProductosServiciosDisponibles productosserviciosdisponibles,String sValor) throws Exception {			
		if(productosserviciosdisponibles !=null) {
			productosserviciosdisponibles.setcodigo(sValor);;//productosserviciosdisponiblesproductosserviciosdisponibles.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProductosServiciosDisponibles")) {
			sNombreIndice="Tipo=  Por Bodega Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Tipo Producto Servicio";
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

	public static String getDetalleIndiceBusquedaProductosServiciosDisponibles(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
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
	
	
	
	
	
	
	public static void quitarEspaciosProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosdisponibles.setnombre_sucursal(productosserviciosdisponibles.getnombre_sucursal().trim());
		productosserviciosdisponibles.setnombre_linea(productosserviciosdisponibles.getnombre_linea().trim());
		productosserviciosdisponibles.setnombre_linea_grupo(productosserviciosdisponibles.getnombre_linea_grupo().trim());
		productosserviciosdisponibles.setnombre_linea_categoria(productosserviciosdisponibles.getnombre_linea_categoria().trim());
		productosserviciosdisponibles.setnombre_linea_marca(productosserviciosdisponibles.getnombre_linea_marca().trim());
		productosserviciosdisponibles.setcodigo(productosserviciosdisponibles.getcodigo().trim());
		productosserviciosdisponibles.setnombre(productosserviciosdisponibles.getnombre().trim());
		productosserviciosdisponibles.setnombre_tipo_producto_servicio(productosserviciosdisponibles.getnombre_tipo_producto_servicio().trim());
		productosserviciosdisponibles.setnombre_bodega(productosserviciosdisponibles.getnombre_bodega().trim());
		productosserviciosdisponibles.setnombre_unidad(productosserviciosdisponibles.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosDisponibless(List<ProductosServiciosDisponibles> productosserviciosdisponibless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {
			productosserviciosdisponibles.setnombre_sucursal(productosserviciosdisponibles.getnombre_sucursal().trim());
			productosserviciosdisponibles.setnombre_linea(productosserviciosdisponibles.getnombre_linea().trim());
			productosserviciosdisponibles.setnombre_linea_grupo(productosserviciosdisponibles.getnombre_linea_grupo().trim());
			productosserviciosdisponibles.setnombre_linea_categoria(productosserviciosdisponibles.getnombre_linea_categoria().trim());
			productosserviciosdisponibles.setnombre_linea_marca(productosserviciosdisponibles.getnombre_linea_marca().trim());
			productosserviciosdisponibles.setcodigo(productosserviciosdisponibles.getcodigo().trim());
			productosserviciosdisponibles.setnombre(productosserviciosdisponibles.getnombre().trim());
			productosserviciosdisponibles.setnombre_tipo_producto_servicio(productosserviciosdisponibles.getnombre_tipo_producto_servicio().trim());
			productosserviciosdisponibles.setnombre_bodega(productosserviciosdisponibles.getnombre_bodega().trim());
			productosserviciosdisponibles.setnombre_unidad(productosserviciosdisponibles.getnombre_unidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponibles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosserviciosdisponibles.getConCambioAuxiliar()) {
			productosserviciosdisponibles.setIsDeleted(productosserviciosdisponibles.getIsDeletedAuxiliar());	
			productosserviciosdisponibles.setIsNew(productosserviciosdisponibles.getIsNewAuxiliar());	
			productosserviciosdisponibles.setIsChanged(productosserviciosdisponibles.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosserviciosdisponibles.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosserviciosdisponibles.setIsDeletedAuxiliar(false);	
			productosserviciosdisponibles.setIsNewAuxiliar(false);	
			productosserviciosdisponibles.setIsChangedAuxiliar(false);
			
			productosserviciosdisponibles.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosDisponibless(List<ProductosServiciosDisponibles> productosserviciosdisponibless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles : productosserviciosdisponibless) {
			if(conAsignarBase && productosserviciosdisponibles.getConCambioAuxiliar()) {
				productosserviciosdisponibles.setIsDeleted(productosserviciosdisponibles.getIsDeletedAuxiliar());	
				productosserviciosdisponibles.setIsNew(productosserviciosdisponibles.getIsNewAuxiliar());	
				productosserviciosdisponibles.setIsChanged(productosserviciosdisponibles.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosserviciosdisponibles.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosserviciosdisponibles.setIsDeletedAuxiliar(false);	
				productosserviciosdisponibles.setIsNewAuxiliar(false);	
				productosserviciosdisponibles.setIsChangedAuxiliar(false);
				
				productosserviciosdisponibles.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponibles,Boolean conEnteros) throws Exception  {
		productosserviciosdisponibles.setprecio_compra(0.0);
		productosserviciosdisponibles.setprecio_venta(0.0);
		productosserviciosdisponibles.setcosto_ultimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productosserviciosdisponibles.setcantidad_disponible(0);
			productosserviciosdisponibles.setcantidad_maximo(0);
			productosserviciosdisponibles.setcantidad_minimo(0);
		}
	}		
	
	public static void InicializarValoresProductosServiciosDisponibless(List<ProductosServiciosDisponibles> productosserviciosdisponibless,Boolean conEnteros) throws Exception  {
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {
			productosserviciosdisponibles.setprecio_compra(0.0);
			productosserviciosdisponibles.setprecio_venta(0.0);
			productosserviciosdisponibles.setcosto_ultimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productosserviciosdisponibles.setcantidad_disponible(0);
				productosserviciosdisponibles.setcantidad_maximo(0);
				productosserviciosdisponibles.setcantidad_minimo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosServiciosDisponibles(List<ProductosServiciosDisponibles> productosserviciosdisponibless,ProductosServiciosDisponibles productosserviciosdisponiblesAux) throws Exception  {
		ProductosServiciosDisponiblesConstantesFunciones.InicializarValoresProductosServiciosDisponibles(productosserviciosdisponiblesAux,true);
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {
			if(productosserviciosdisponibles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosserviciosdisponiblesAux.setcantidad_disponible(productosserviciosdisponiblesAux.getcantidad_disponible()+productosserviciosdisponibles.getcantidad_disponible());			
			productosserviciosdisponiblesAux.setcantidad_maximo(productosserviciosdisponiblesAux.getcantidad_maximo()+productosserviciosdisponibles.getcantidad_maximo());			
			productosserviciosdisponiblesAux.setcantidad_minimo(productosserviciosdisponiblesAux.getcantidad_minimo()+productosserviciosdisponibles.getcantidad_minimo());			
			productosserviciosdisponiblesAux.setprecio_compra(productosserviciosdisponiblesAux.getprecio_compra()+productosserviciosdisponibles.getprecio_compra());			
			productosserviciosdisponiblesAux.setprecio_venta(productosserviciosdisponiblesAux.getprecio_venta()+productosserviciosdisponibles.getprecio_venta());			
			productosserviciosdisponiblesAux.setcosto_ultimo(productosserviciosdisponiblesAux.getcosto_ultimo()+productosserviciosdisponibles.getcosto_ultimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosDisponibles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosServiciosDisponiblesConstantesFunciones.getArrayColumnasGlobalesProductosServiciosDisponibles(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosDisponibles(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosServiciosDisponibles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosDisponibles> productosserviciosdisponibless,ProductosServiciosDisponibles productosserviciosdisponibles,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosDisponibles productosserviciosdisponiblesAux: productosserviciosdisponibless) {
			if(productosserviciosdisponiblesAux!=null && productosserviciosdisponibles!=null) {
				if((productosserviciosdisponiblesAux.getId()==null && productosserviciosdisponibles.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosserviciosdisponiblesAux.getId()!=null && productosserviciosdisponibles.getId()!=null){
					if(productosserviciosdisponiblesAux.getId().equals(productosserviciosdisponibles.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosDisponibles(List<ProductosServiciosDisponibles> productosserviciosdisponibless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio_compraTotal=0.0;
		Double precio_ventaTotal=0.0;
		Double costo_ultimoTotal=0.0;
	
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {			
			if(productosserviciosdisponibles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precio_compraTotal+=productosserviciosdisponibles.getprecio_compra();
			precio_ventaTotal+=productosserviciosdisponibles.getprecio_venta();
			costo_ultimoTotal+=productosserviciosdisponibles.getcosto_ultimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA);
		datoGeneral.setdValorDouble(precio_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA);
		datoGeneral.setdValorDouble(precio_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO);
		datoGeneral.setdValorDouble(costo_ultimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosServiciosDisponibles() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_ID, ProductosServiciosDisponiblesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_VERSIONROW, ProductosServiciosDisponiblesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRESUCURSAL, ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEA, ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAMARCA, ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_CODIGO, ProductosServiciosDisponiblesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRE, ProductosServiciosDisponiblesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO, ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREBODEGA, ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE, ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMAXIMO, ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMINIMO, ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA, ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA, ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO, ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosServiciosDisponibles() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosDisponibles() throws Exception  {
		return ProductosServiciosDisponiblesConstantesFunciones.getTiposSeleccionarProductosServiciosDisponibles(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosDisponibles(Boolean conFk) throws Exception  {
		return ProductosServiciosDisponiblesConstantesFunciones.getTiposSeleccionarProductosServiciosDisponibles(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosDisponibles(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMAXIMO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMINIMO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO);
			reporte.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosServiciosDisponibles(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponiblesAux) throws Exception {
		
			productosserviciosdisponiblesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosdisponiblesAux.getEmpresa()));
			productosserviciosdisponiblesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosdisponiblesAux.getSucursal()));
			productosserviciosdisponiblesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosdisponiblesAux.getBodega()));
			productosserviciosdisponiblesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLinea()));
			productosserviciosdisponiblesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaGrupo()));
			productosserviciosdisponiblesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaCategoria()));
			productosserviciosdisponiblesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaMarca()));
			productosserviciosdisponiblesAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosdisponiblesAux.getTipoProductoServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosDisponibles(List<ProductosServiciosDisponibles> productosserviciosdisponiblessTemp) throws Exception {
		for(ProductosServiciosDisponibles productosserviciosdisponiblesAux:productosserviciosdisponiblessTemp) {
			
			productosserviciosdisponiblesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosdisponiblesAux.getEmpresa()));
			productosserviciosdisponiblesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosdisponiblesAux.getSucursal()));
			productosserviciosdisponiblesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosdisponiblesAux.getBodega()));
			productosserviciosdisponiblesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLinea()));
			productosserviciosdisponiblesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaGrupo()));
			productosserviciosdisponiblesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaCategoria()));
			productosserviciosdisponiblesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosdisponiblesAux.getLineaMarca()));
			productosserviciosdisponiblesAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosdisponiblesAux.getTipoProductoServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosServiciosDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosServiciosDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosDisponiblesConstantesFunciones.getClassesRelationshipsOfProductosServiciosDisponibles(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosDisponiblesConstantesFunciones.getClassesRelationshipsFromStringsOfProductosServiciosDisponibles(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosServiciosDisponibles productosserviciosdisponibles,List<ProductosServiciosDisponibles> productosserviciosdisponibless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosServiciosDisponibles productosserviciosdisponibles,List<ProductosServiciosDisponibles> productosserviciosdisponibless) throws Exception {
		try	{			
			for(ProductosServiciosDisponibles productosserviciosdisponiblesLocal:productosserviciosdisponibless) {
				if(productosserviciosdisponiblesLocal.getId().equals(productosserviciosdisponibles.getId())) {
					productosserviciosdisponiblesLocal.setIsSelected(productosserviciosdisponibles.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosServiciosDisponibles(List<ProductosServiciosDisponibles> productosserviciosdisponiblessAux) throws Exception {
		//this.productosserviciosdisponiblessAux=productosserviciosdisponiblessAux;
		
		for(ProductosServiciosDisponibles productosserviciosdisponiblesAux:productosserviciosdisponiblessAux) {
			if(productosserviciosdisponiblesAux.getIsChanged()) {
				productosserviciosdisponiblesAux.setIsChanged(false);
			}		
			
			if(productosserviciosdisponiblesAux.getIsNew()) {
				productosserviciosdisponiblesAux.setIsNew(false);
			}	
			
			if(productosserviciosdisponiblesAux.getIsDeleted()) {
				productosserviciosdisponiblesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponiblesAux) throws Exception {
		//this.productosserviciosdisponiblesAux=productosserviciosdisponiblesAux;
		
			if(productosserviciosdisponiblesAux.getIsChanged()) {
				productosserviciosdisponiblesAux.setIsChanged(false);
			}		
			
			if(productosserviciosdisponiblesAux.getIsNew()) {
				productosserviciosdisponiblesAux.setIsNew(false);
			}	
			
			if(productosserviciosdisponiblesAux.getIsDeleted()) {
				productosserviciosdisponiblesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosServiciosDisponibles productosserviciosdisponiblesAsignar,ProductosServiciosDisponibles productosserviciosdisponibles) throws Exception {
		productosserviciosdisponiblesAsignar.setId(productosserviciosdisponibles.getId());	
		productosserviciosdisponiblesAsignar.setVersionRow(productosserviciosdisponibles.getVersionRow());	
		productosserviciosdisponiblesAsignar.setnombre_sucursal(productosserviciosdisponibles.getnombre_sucursal());	
		productosserviciosdisponiblesAsignar.setnombre_linea(productosserviciosdisponibles.getnombre_linea());	
		productosserviciosdisponiblesAsignar.setnombre_linea_grupo(productosserviciosdisponibles.getnombre_linea_grupo());	
		productosserviciosdisponiblesAsignar.setnombre_linea_categoria(productosserviciosdisponibles.getnombre_linea_categoria());	
		productosserviciosdisponiblesAsignar.setnombre_linea_marca(productosserviciosdisponibles.getnombre_linea_marca());	
		productosserviciosdisponiblesAsignar.setcodigo(productosserviciosdisponibles.getcodigo());	
		productosserviciosdisponiblesAsignar.setnombre(productosserviciosdisponibles.getnombre());	
		productosserviciosdisponiblesAsignar.setnombre_tipo_producto_servicio(productosserviciosdisponibles.getnombre_tipo_producto_servicio());	
		productosserviciosdisponiblesAsignar.setnombre_bodega(productosserviciosdisponibles.getnombre_bodega());	
		productosserviciosdisponiblesAsignar.setnombre_unidad(productosserviciosdisponibles.getnombre_unidad());	
		productosserviciosdisponiblesAsignar.setcantidad_disponible(productosserviciosdisponibles.getcantidad_disponible());	
		productosserviciosdisponiblesAsignar.setcantidad_maximo(productosserviciosdisponibles.getcantidad_maximo());	
		productosserviciosdisponiblesAsignar.setcantidad_minimo(productosserviciosdisponibles.getcantidad_minimo());	
		productosserviciosdisponiblesAsignar.setprecio_compra(productosserviciosdisponibles.getprecio_compra());	
		productosserviciosdisponiblesAsignar.setprecio_venta(productosserviciosdisponibles.getprecio_venta());	
		productosserviciosdisponiblesAsignar.setcosto_ultimo(productosserviciosdisponibles.getcosto_ultimo());	
	}
	
	public static void inicializarProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponibles) throws Exception {
		try {
				productosserviciosdisponibles.setId(0L);	
					
				productosserviciosdisponibles.setnombre_sucursal("");	
				productosserviciosdisponibles.setnombre_linea("");	
				productosserviciosdisponibles.setnombre_linea_grupo("");	
				productosserviciosdisponibles.setnombre_linea_categoria("");	
				productosserviciosdisponibles.setnombre_linea_marca("");	
				productosserviciosdisponibles.setcodigo("");	
				productosserviciosdisponibles.setnombre("");	
				productosserviciosdisponibles.setnombre_tipo_producto_servicio("");	
				productosserviciosdisponibles.setnombre_bodega("");	
				productosserviciosdisponibles.setnombre_unidad("");	
				productosserviciosdisponibles.setcantidad_disponible(0);	
				productosserviciosdisponibles.setcantidad_maximo(0);	
				productosserviciosdisponibles.setcantidad_minimo(0);	
				productosserviciosdisponibles.setprecio_compra(0.0);	
				productosserviciosdisponibles.setprecio_venta(0.0);	
				productosserviciosdisponibles.setcosto_ultimo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosServiciosDisponibles(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_CANTIDADMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosServiciosDisponibles(String sTipo,Row row,Workbook workbook,ProductosServiciosDisponibles productosserviciosdisponibles,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_tipo_producto_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getcantidad_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getcantidad_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getprecio_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getprecio_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosdisponibles.getcosto_ultimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosServiciosDisponibles="";
	
	public String getsFinalQueryProductosServiciosDisponibles() {
		return this.sFinalQueryProductosServiciosDisponibles;
	}
	
	public void setsFinalQueryProductosServiciosDisponibles(String sFinalQueryProductosServiciosDisponibles) {
		this.sFinalQueryProductosServiciosDisponibles= sFinalQueryProductosServiciosDisponibles;
	}
	
	public Border resaltarSeleccionarProductosServiciosDisponibles=null;
	
	public Border setResaltarSeleccionarProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosServiciosDisponibles= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosServiciosDisponibles() {
		return this.resaltarSeleccionarProductosServiciosDisponibles;
	}
	
	public void setResaltarSeleccionarProductosServiciosDisponibles(Border borderResaltarSeleccionarProductosServiciosDisponibles) {
		this.resaltarSeleccionarProductosServiciosDisponibles= borderResaltarSeleccionarProductosServiciosDisponibles;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosServiciosDisponibles=null;
	public Boolean mostraridProductosServiciosDisponibles=true;
	public Boolean activaridProductosServiciosDisponibles=true;

	public Border resaltarid_empresaProductosServiciosDisponibles=null;
	public Boolean mostrarid_empresaProductosServiciosDisponibles=true;
	public Boolean activarid_empresaProductosServiciosDisponibles=true;
	public Boolean cargarid_empresaProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosServiciosDisponibles=null;
	public Boolean mostrarid_sucursalProductosServiciosDisponibles=true;
	public Boolean activarid_sucursalProductosServiciosDisponibles=true;
	public Boolean cargarid_sucursalProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosServiciosDisponibles=null;
	public Boolean mostrarid_bodegaProductosServiciosDisponibles=true;
	public Boolean activarid_bodegaProductosServiciosDisponibles=true;
	public Boolean cargarid_bodegaProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosServiciosDisponibles=null;
	public Boolean mostrarid_lineaProductosServiciosDisponibles=true;
	public Boolean activarid_lineaProductosServiciosDisponibles=true;
	public Boolean cargarid_lineaProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosServiciosDisponibles=null;
	public Boolean mostrarid_linea_grupoProductosServiciosDisponibles=true;
	public Boolean activarid_linea_grupoProductosServiciosDisponibles=true;
	public Boolean cargarid_linea_grupoProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosServiciosDisponibles=null;
	public Boolean mostrarid_linea_categoriaProductosServiciosDisponibles=true;
	public Boolean activarid_linea_categoriaProductosServiciosDisponibles=true;
	public Boolean cargarid_linea_categoriaProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosServiciosDisponibles=null;
	public Boolean mostrarid_linea_marcaProductosServiciosDisponibles=true;
	public Boolean activarid_linea_marcaProductosServiciosDisponibles=true;
	public Boolean cargarid_linea_marcaProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioProductosServiciosDisponibles=null;
	public Boolean mostrarid_tipo_producto_servicioProductosServiciosDisponibles=true;
	public Boolean activarid_tipo_producto_servicioProductosServiciosDisponibles=true;
	public Boolean cargarid_tipo_producto_servicioProductosServiciosDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioProductosServiciosDisponibles=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_sucursalProductosServiciosDisponibles=true;
	public Boolean activarnombre_sucursalProductosServiciosDisponibles=true;

	public Border resaltarnombre_lineaProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_lineaProductosServiciosDisponibles=true;
	public Boolean activarnombre_lineaProductosServiciosDisponibles=true;

	public Border resaltarnombre_linea_grupoProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_linea_grupoProductosServiciosDisponibles=true;
	public Boolean activarnombre_linea_grupoProductosServiciosDisponibles=true;

	public Border resaltarnombre_linea_categoriaProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_linea_categoriaProductosServiciosDisponibles=true;
	public Boolean activarnombre_linea_categoriaProductosServiciosDisponibles=true;

	public Border resaltarnombre_linea_marcaProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_linea_marcaProductosServiciosDisponibles=true;
	public Boolean activarnombre_linea_marcaProductosServiciosDisponibles=true;

	public Border resaltarcodigoProductosServiciosDisponibles=null;
	public Boolean mostrarcodigoProductosServiciosDisponibles=true;
	public Boolean activarcodigoProductosServiciosDisponibles=true;

	public Border resaltarnombreProductosServiciosDisponibles=null;
	public Boolean mostrarnombreProductosServiciosDisponibles=true;
	public Boolean activarnombreProductosServiciosDisponibles=true;

	public Border resaltarnombre_tipo_producto_servicioProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_tipo_producto_servicioProductosServiciosDisponibles=true;
	public Boolean activarnombre_tipo_producto_servicioProductosServiciosDisponibles=true;

	public Border resaltarnombre_bodegaProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_bodegaProductosServiciosDisponibles=true;
	public Boolean activarnombre_bodegaProductosServiciosDisponibles=true;

	public Border resaltarnombre_unidadProductosServiciosDisponibles=null;
	public Boolean mostrarnombre_unidadProductosServiciosDisponibles=true;
	public Boolean activarnombre_unidadProductosServiciosDisponibles=true;

	public Border resaltarcantidad_disponibleProductosServiciosDisponibles=null;
	public Boolean mostrarcantidad_disponibleProductosServiciosDisponibles=true;
	public Boolean activarcantidad_disponibleProductosServiciosDisponibles=true;

	public Border resaltarcantidad_maximoProductosServiciosDisponibles=null;
	public Boolean mostrarcantidad_maximoProductosServiciosDisponibles=true;
	public Boolean activarcantidad_maximoProductosServiciosDisponibles=true;

	public Border resaltarcantidad_minimoProductosServiciosDisponibles=null;
	public Boolean mostrarcantidad_minimoProductosServiciosDisponibles=true;
	public Boolean activarcantidad_minimoProductosServiciosDisponibles=true;

	public Border resaltarprecio_compraProductosServiciosDisponibles=null;
	public Boolean mostrarprecio_compraProductosServiciosDisponibles=true;
	public Boolean activarprecio_compraProductosServiciosDisponibles=true;

	public Border resaltarprecio_ventaProductosServiciosDisponibles=null;
	public Boolean mostrarprecio_ventaProductosServiciosDisponibles=true;
	public Boolean activarprecio_ventaProductosServiciosDisponibles=true;

	public Border resaltarcosto_ultimoProductosServiciosDisponibles=null;
	public Boolean mostrarcosto_ultimoProductosServiciosDisponibles=true;
	public Boolean activarcosto_ultimoProductosServiciosDisponibles=true;

	
	

	public Border setResaltaridProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltaridProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosServiciosDisponibles() {
		return this.resaltaridProductosServiciosDisponibles;
	}

	public void setResaltaridProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltaridProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostraridProductosServiciosDisponibles() {
		return this.mostraridProductosServiciosDisponibles;
	}

	public void setMostraridProductosServiciosDisponibles(Boolean mostraridProductosServiciosDisponibles) {
		this.mostraridProductosServiciosDisponibles= mostraridProductosServiciosDisponibles;
	}

	public Boolean getActivaridProductosServiciosDisponibles() {
		return this.activaridProductosServiciosDisponibles;
	}

	public void setActivaridProductosServiciosDisponibles(Boolean activaridProductosServiciosDisponibles) {
		this.activaridProductosServiciosDisponibles= activaridProductosServiciosDisponibles;
	}

	public Border setResaltarid_empresaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosServiciosDisponibles() {
		return this.resaltarid_empresaProductosServiciosDisponibles;
	}

	public void setResaltarid_empresaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_empresaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosServiciosDisponibles() {
		return this.mostrarid_empresaProductosServiciosDisponibles;
	}

	public void setMostrarid_empresaProductosServiciosDisponibles(Boolean mostrarid_empresaProductosServiciosDisponibles) {
		this.mostrarid_empresaProductosServiciosDisponibles= mostrarid_empresaProductosServiciosDisponibles;
	}

	public Boolean getActivarid_empresaProductosServiciosDisponibles() {
		return this.activarid_empresaProductosServiciosDisponibles;
	}

	public void setActivarid_empresaProductosServiciosDisponibles(Boolean activarid_empresaProductosServiciosDisponibles) {
		this.activarid_empresaProductosServiciosDisponibles= activarid_empresaProductosServiciosDisponibles;
	}

	public Boolean getCargarid_empresaProductosServiciosDisponibles() {
		return this.cargarid_empresaProductosServiciosDisponibles;
	}

	public void setCargarid_empresaProductosServiciosDisponibles(Boolean cargarid_empresaProductosServiciosDisponibles) {
		this.cargarid_empresaProductosServiciosDisponibles= cargarid_empresaProductosServiciosDisponibles;
	}

	public Border setResaltarid_sucursalProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosServiciosDisponibles() {
		return this.resaltarid_sucursalProductosServiciosDisponibles;
	}

	public void setResaltarid_sucursalProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_sucursalProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosServiciosDisponibles() {
		return this.mostrarid_sucursalProductosServiciosDisponibles;
	}

	public void setMostrarid_sucursalProductosServiciosDisponibles(Boolean mostrarid_sucursalProductosServiciosDisponibles) {
		this.mostrarid_sucursalProductosServiciosDisponibles= mostrarid_sucursalProductosServiciosDisponibles;
	}

	public Boolean getActivarid_sucursalProductosServiciosDisponibles() {
		return this.activarid_sucursalProductosServiciosDisponibles;
	}

	public void setActivarid_sucursalProductosServiciosDisponibles(Boolean activarid_sucursalProductosServiciosDisponibles) {
		this.activarid_sucursalProductosServiciosDisponibles= activarid_sucursalProductosServiciosDisponibles;
	}

	public Boolean getCargarid_sucursalProductosServiciosDisponibles() {
		return this.cargarid_sucursalProductosServiciosDisponibles;
	}

	public void setCargarid_sucursalProductosServiciosDisponibles(Boolean cargarid_sucursalProductosServiciosDisponibles) {
		this.cargarid_sucursalProductosServiciosDisponibles= cargarid_sucursalProductosServiciosDisponibles;
	}

	public Border setResaltarid_bodegaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosServiciosDisponibles() {
		return this.resaltarid_bodegaProductosServiciosDisponibles;
	}

	public void setResaltarid_bodegaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_bodegaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosServiciosDisponibles() {
		return this.mostrarid_bodegaProductosServiciosDisponibles;
	}

	public void setMostrarid_bodegaProductosServiciosDisponibles(Boolean mostrarid_bodegaProductosServiciosDisponibles) {
		this.mostrarid_bodegaProductosServiciosDisponibles= mostrarid_bodegaProductosServiciosDisponibles;
	}

	public Boolean getActivarid_bodegaProductosServiciosDisponibles() {
		return this.activarid_bodegaProductosServiciosDisponibles;
	}

	public void setActivarid_bodegaProductosServiciosDisponibles(Boolean activarid_bodegaProductosServiciosDisponibles) {
		this.activarid_bodegaProductosServiciosDisponibles= activarid_bodegaProductosServiciosDisponibles;
	}

	public Boolean getCargarid_bodegaProductosServiciosDisponibles() {
		return this.cargarid_bodegaProductosServiciosDisponibles;
	}

	public void setCargarid_bodegaProductosServiciosDisponibles(Boolean cargarid_bodegaProductosServiciosDisponibles) {
		this.cargarid_bodegaProductosServiciosDisponibles= cargarid_bodegaProductosServiciosDisponibles;
	}

	public Border setResaltarid_lineaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosServiciosDisponibles() {
		return this.resaltarid_lineaProductosServiciosDisponibles;
	}

	public void setResaltarid_lineaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_lineaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosServiciosDisponibles() {
		return this.mostrarid_lineaProductosServiciosDisponibles;
	}

	public void setMostrarid_lineaProductosServiciosDisponibles(Boolean mostrarid_lineaProductosServiciosDisponibles) {
		this.mostrarid_lineaProductosServiciosDisponibles= mostrarid_lineaProductosServiciosDisponibles;
	}

	public Boolean getActivarid_lineaProductosServiciosDisponibles() {
		return this.activarid_lineaProductosServiciosDisponibles;
	}

	public void setActivarid_lineaProductosServiciosDisponibles(Boolean activarid_lineaProductosServiciosDisponibles) {
		this.activarid_lineaProductosServiciosDisponibles= activarid_lineaProductosServiciosDisponibles;
	}

	public Boolean getCargarid_lineaProductosServiciosDisponibles() {
		return this.cargarid_lineaProductosServiciosDisponibles;
	}

	public void setCargarid_lineaProductosServiciosDisponibles(Boolean cargarid_lineaProductosServiciosDisponibles) {
		this.cargarid_lineaProductosServiciosDisponibles= cargarid_lineaProductosServiciosDisponibles;
	}

	public Border setResaltarid_linea_grupoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosServiciosDisponibles() {
		return this.resaltarid_linea_grupoProductosServiciosDisponibles;
	}

	public void setResaltarid_linea_grupoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosServiciosDisponibles() {
		return this.mostrarid_linea_grupoProductosServiciosDisponibles;
	}

	public void setMostrarid_linea_grupoProductosServiciosDisponibles(Boolean mostrarid_linea_grupoProductosServiciosDisponibles) {
		this.mostrarid_linea_grupoProductosServiciosDisponibles= mostrarid_linea_grupoProductosServiciosDisponibles;
	}

	public Boolean getActivarid_linea_grupoProductosServiciosDisponibles() {
		return this.activarid_linea_grupoProductosServiciosDisponibles;
	}

	public void setActivarid_linea_grupoProductosServiciosDisponibles(Boolean activarid_linea_grupoProductosServiciosDisponibles) {
		this.activarid_linea_grupoProductosServiciosDisponibles= activarid_linea_grupoProductosServiciosDisponibles;
	}

	public Boolean getCargarid_linea_grupoProductosServiciosDisponibles() {
		return this.cargarid_linea_grupoProductosServiciosDisponibles;
	}

	public void setCargarid_linea_grupoProductosServiciosDisponibles(Boolean cargarid_linea_grupoProductosServiciosDisponibles) {
		this.cargarid_linea_grupoProductosServiciosDisponibles= cargarid_linea_grupoProductosServiciosDisponibles;
	}

	public Border setResaltarid_linea_categoriaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosServiciosDisponibles() {
		return this.resaltarid_linea_categoriaProductosServiciosDisponibles;
	}

	public void setResaltarid_linea_categoriaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosServiciosDisponibles() {
		return this.mostrarid_linea_categoriaProductosServiciosDisponibles;
	}

	public void setMostrarid_linea_categoriaProductosServiciosDisponibles(Boolean mostrarid_linea_categoriaProductosServiciosDisponibles) {
		this.mostrarid_linea_categoriaProductosServiciosDisponibles= mostrarid_linea_categoriaProductosServiciosDisponibles;
	}

	public Boolean getActivarid_linea_categoriaProductosServiciosDisponibles() {
		return this.activarid_linea_categoriaProductosServiciosDisponibles;
	}

	public void setActivarid_linea_categoriaProductosServiciosDisponibles(Boolean activarid_linea_categoriaProductosServiciosDisponibles) {
		this.activarid_linea_categoriaProductosServiciosDisponibles= activarid_linea_categoriaProductosServiciosDisponibles;
	}

	public Boolean getCargarid_linea_categoriaProductosServiciosDisponibles() {
		return this.cargarid_linea_categoriaProductosServiciosDisponibles;
	}

	public void setCargarid_linea_categoriaProductosServiciosDisponibles(Boolean cargarid_linea_categoriaProductosServiciosDisponibles) {
		this.cargarid_linea_categoriaProductosServiciosDisponibles= cargarid_linea_categoriaProductosServiciosDisponibles;
	}

	public Border setResaltarid_linea_marcaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosServiciosDisponibles() {
		return this.resaltarid_linea_marcaProductosServiciosDisponibles;
	}

	public void setResaltarid_linea_marcaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosServiciosDisponibles() {
		return this.mostrarid_linea_marcaProductosServiciosDisponibles;
	}

	public void setMostrarid_linea_marcaProductosServiciosDisponibles(Boolean mostrarid_linea_marcaProductosServiciosDisponibles) {
		this.mostrarid_linea_marcaProductosServiciosDisponibles= mostrarid_linea_marcaProductosServiciosDisponibles;
	}

	public Boolean getActivarid_linea_marcaProductosServiciosDisponibles() {
		return this.activarid_linea_marcaProductosServiciosDisponibles;
	}

	public void setActivarid_linea_marcaProductosServiciosDisponibles(Boolean activarid_linea_marcaProductosServiciosDisponibles) {
		this.activarid_linea_marcaProductosServiciosDisponibles= activarid_linea_marcaProductosServiciosDisponibles;
	}

	public Boolean getCargarid_linea_marcaProductosServiciosDisponibles() {
		return this.cargarid_linea_marcaProductosServiciosDisponibles;
	}

	public void setCargarid_linea_marcaProductosServiciosDisponibles(Boolean cargarid_linea_marcaProductosServiciosDisponibles) {
		this.cargarid_linea_marcaProductosServiciosDisponibles= cargarid_linea_marcaProductosServiciosDisponibles;
	}

	public Border setResaltarid_tipo_producto_servicioProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.resaltarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setResaltarid_tipo_producto_servicioProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.mostrarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setMostrarid_tipo_producto_servicioProductosServiciosDisponibles(Boolean mostrarid_tipo_producto_servicioProductosServiciosDisponibles) {
		this.mostrarid_tipo_producto_servicioProductosServiciosDisponibles= mostrarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public Boolean getActivarid_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.activarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setActivarid_tipo_producto_servicioProductosServiciosDisponibles(Boolean activarid_tipo_producto_servicioProductosServiciosDisponibles) {
		this.activarid_tipo_producto_servicioProductosServiciosDisponibles= activarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public Boolean getCargarid_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.cargarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setCargarid_tipo_producto_servicioProductosServiciosDisponibles(Boolean cargarid_tipo_producto_servicioProductosServiciosDisponibles) {
		this.cargarid_tipo_producto_servicioProductosServiciosDisponibles= cargarid_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_sucursalProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProductosServiciosDisponibles() {
		return this.resaltarnombre_sucursalProductosServiciosDisponibles;
	}

	public void setResaltarnombre_sucursalProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_sucursalProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProductosServiciosDisponibles() {
		return this.mostrarnombre_sucursalProductosServiciosDisponibles;
	}

	public void setMostrarnombre_sucursalProductosServiciosDisponibles(Boolean mostrarnombre_sucursalProductosServiciosDisponibles) {
		this.mostrarnombre_sucursalProductosServiciosDisponibles= mostrarnombre_sucursalProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_sucursalProductosServiciosDisponibles() {
		return this.activarnombre_sucursalProductosServiciosDisponibles;
	}

	public void setActivarnombre_sucursalProductosServiciosDisponibles(Boolean activarnombre_sucursalProductosServiciosDisponibles) {
		this.activarnombre_sucursalProductosServiciosDisponibles= activarnombre_sucursalProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_lineaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaProductosServiciosDisponibles() {
		return this.resaltarnombre_lineaProductosServiciosDisponibles;
	}

	public void setResaltarnombre_lineaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_lineaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaProductosServiciosDisponibles() {
		return this.mostrarnombre_lineaProductosServiciosDisponibles;
	}

	public void setMostrarnombre_lineaProductosServiciosDisponibles(Boolean mostrarnombre_lineaProductosServiciosDisponibles) {
		this.mostrarnombre_lineaProductosServiciosDisponibles= mostrarnombre_lineaProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_lineaProductosServiciosDisponibles() {
		return this.activarnombre_lineaProductosServiciosDisponibles;
	}

	public void setActivarnombre_lineaProductosServiciosDisponibles(Boolean activarnombre_lineaProductosServiciosDisponibles) {
		this.activarnombre_lineaProductosServiciosDisponibles= activarnombre_lineaProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_linea_grupoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoProductosServiciosDisponibles() {
		return this.resaltarnombre_linea_grupoProductosServiciosDisponibles;
	}

	public void setResaltarnombre_linea_grupoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_linea_grupoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoProductosServiciosDisponibles() {
		return this.mostrarnombre_linea_grupoProductosServiciosDisponibles;
	}

	public void setMostrarnombre_linea_grupoProductosServiciosDisponibles(Boolean mostrarnombre_linea_grupoProductosServiciosDisponibles) {
		this.mostrarnombre_linea_grupoProductosServiciosDisponibles= mostrarnombre_linea_grupoProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_linea_grupoProductosServiciosDisponibles() {
		return this.activarnombre_linea_grupoProductosServiciosDisponibles;
	}

	public void setActivarnombre_linea_grupoProductosServiciosDisponibles(Boolean activarnombre_linea_grupoProductosServiciosDisponibles) {
		this.activarnombre_linea_grupoProductosServiciosDisponibles= activarnombre_linea_grupoProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_linea_categoriaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaProductosServiciosDisponibles() {
		return this.resaltarnombre_linea_categoriaProductosServiciosDisponibles;
	}

	public void setResaltarnombre_linea_categoriaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaProductosServiciosDisponibles() {
		return this.mostrarnombre_linea_categoriaProductosServiciosDisponibles;
	}

	public void setMostrarnombre_linea_categoriaProductosServiciosDisponibles(Boolean mostrarnombre_linea_categoriaProductosServiciosDisponibles) {
		this.mostrarnombre_linea_categoriaProductosServiciosDisponibles= mostrarnombre_linea_categoriaProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_linea_categoriaProductosServiciosDisponibles() {
		return this.activarnombre_linea_categoriaProductosServiciosDisponibles;
	}

	public void setActivarnombre_linea_categoriaProductosServiciosDisponibles(Boolean activarnombre_linea_categoriaProductosServiciosDisponibles) {
		this.activarnombre_linea_categoriaProductosServiciosDisponibles= activarnombre_linea_categoriaProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_linea_marcaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaProductosServiciosDisponibles() {
		return this.resaltarnombre_linea_marcaProductosServiciosDisponibles;
	}

	public void setResaltarnombre_linea_marcaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_linea_marcaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaProductosServiciosDisponibles() {
		return this.mostrarnombre_linea_marcaProductosServiciosDisponibles;
	}

	public void setMostrarnombre_linea_marcaProductosServiciosDisponibles(Boolean mostrarnombre_linea_marcaProductosServiciosDisponibles) {
		this.mostrarnombre_linea_marcaProductosServiciosDisponibles= mostrarnombre_linea_marcaProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_linea_marcaProductosServiciosDisponibles() {
		return this.activarnombre_linea_marcaProductosServiciosDisponibles;
	}

	public void setActivarnombre_linea_marcaProductosServiciosDisponibles(Boolean activarnombre_linea_marcaProductosServiciosDisponibles) {
		this.activarnombre_linea_marcaProductosServiciosDisponibles= activarnombre_linea_marcaProductosServiciosDisponibles;
	}

	public Border setResaltarcodigoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarcodigoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProductosServiciosDisponibles() {
		return this.resaltarcodigoProductosServiciosDisponibles;
	}

	public void setResaltarcodigoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarcodigoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarcodigoProductosServiciosDisponibles() {
		return this.mostrarcodigoProductosServiciosDisponibles;
	}

	public void setMostrarcodigoProductosServiciosDisponibles(Boolean mostrarcodigoProductosServiciosDisponibles) {
		this.mostrarcodigoProductosServiciosDisponibles= mostrarcodigoProductosServiciosDisponibles;
	}

	public Boolean getActivarcodigoProductosServiciosDisponibles() {
		return this.activarcodigoProductosServiciosDisponibles;
	}

	public void setActivarcodigoProductosServiciosDisponibles(Boolean activarcodigoProductosServiciosDisponibles) {
		this.activarcodigoProductosServiciosDisponibles= activarcodigoProductosServiciosDisponibles;
	}

	public Border setResaltarnombreProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombreProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProductosServiciosDisponibles() {
		return this.resaltarnombreProductosServiciosDisponibles;
	}

	public void setResaltarnombreProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombreProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombreProductosServiciosDisponibles() {
		return this.mostrarnombreProductosServiciosDisponibles;
	}

	public void setMostrarnombreProductosServiciosDisponibles(Boolean mostrarnombreProductosServiciosDisponibles) {
		this.mostrarnombreProductosServiciosDisponibles= mostrarnombreProductosServiciosDisponibles;
	}

	public Boolean getActivarnombreProductosServiciosDisponibles() {
		return this.activarnombreProductosServiciosDisponibles;
	}

	public void setActivarnombreProductosServiciosDisponibles(Boolean activarnombreProductosServiciosDisponibles) {
		this.activarnombreProductosServiciosDisponibles= activarnombreProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_tipo_producto_servicioProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_producto_servicioProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.resaltarnombre_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setResaltarnombre_tipo_producto_servicioProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_tipo_producto_servicioProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.mostrarnombre_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setMostrarnombre_tipo_producto_servicioProductosServiciosDisponibles(Boolean mostrarnombre_tipo_producto_servicioProductosServiciosDisponibles) {
		this.mostrarnombre_tipo_producto_servicioProductosServiciosDisponibles= mostrarnombre_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_tipo_producto_servicioProductosServiciosDisponibles() {
		return this.activarnombre_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public void setActivarnombre_tipo_producto_servicioProductosServiciosDisponibles(Boolean activarnombre_tipo_producto_servicioProductosServiciosDisponibles) {
		this.activarnombre_tipo_producto_servicioProductosServiciosDisponibles= activarnombre_tipo_producto_servicioProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_bodegaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProductosServiciosDisponibles() {
		return this.resaltarnombre_bodegaProductosServiciosDisponibles;
	}

	public void setResaltarnombre_bodegaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_bodegaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProductosServiciosDisponibles() {
		return this.mostrarnombre_bodegaProductosServiciosDisponibles;
	}

	public void setMostrarnombre_bodegaProductosServiciosDisponibles(Boolean mostrarnombre_bodegaProductosServiciosDisponibles) {
		this.mostrarnombre_bodegaProductosServiciosDisponibles= mostrarnombre_bodegaProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_bodegaProductosServiciosDisponibles() {
		return this.activarnombre_bodegaProductosServiciosDisponibles;
	}

	public void setActivarnombre_bodegaProductosServiciosDisponibles(Boolean activarnombre_bodegaProductosServiciosDisponibles) {
		this.activarnombre_bodegaProductosServiciosDisponibles= activarnombre_bodegaProductosServiciosDisponibles;
	}

	public Border setResaltarnombre_unidadProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosServiciosDisponibles() {
		return this.resaltarnombre_unidadProductosServiciosDisponibles;
	}

	public void setResaltarnombre_unidadProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarnombre_unidadProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosServiciosDisponibles() {
		return this.mostrarnombre_unidadProductosServiciosDisponibles;
	}

	public void setMostrarnombre_unidadProductosServiciosDisponibles(Boolean mostrarnombre_unidadProductosServiciosDisponibles) {
		this.mostrarnombre_unidadProductosServiciosDisponibles= mostrarnombre_unidadProductosServiciosDisponibles;
	}

	public Boolean getActivarnombre_unidadProductosServiciosDisponibles() {
		return this.activarnombre_unidadProductosServiciosDisponibles;
	}

	public void setActivarnombre_unidadProductosServiciosDisponibles(Boolean activarnombre_unidadProductosServiciosDisponibles) {
		this.activarnombre_unidadProductosServiciosDisponibles= activarnombre_unidadProductosServiciosDisponibles;
	}

	public Border setResaltarcantidad_disponibleProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleProductosServiciosDisponibles() {
		return this.resaltarcantidad_disponibleProductosServiciosDisponibles;
	}

	public void setResaltarcantidad_disponibleProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarcantidad_disponibleProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleProductosServiciosDisponibles() {
		return this.mostrarcantidad_disponibleProductosServiciosDisponibles;
	}

	public void setMostrarcantidad_disponibleProductosServiciosDisponibles(Boolean mostrarcantidad_disponibleProductosServiciosDisponibles) {
		this.mostrarcantidad_disponibleProductosServiciosDisponibles= mostrarcantidad_disponibleProductosServiciosDisponibles;
	}

	public Boolean getActivarcantidad_disponibleProductosServiciosDisponibles() {
		return this.activarcantidad_disponibleProductosServiciosDisponibles;
	}

	public void setActivarcantidad_disponibleProductosServiciosDisponibles(Boolean activarcantidad_disponibleProductosServiciosDisponibles) {
		this.activarcantidad_disponibleProductosServiciosDisponibles= activarcantidad_disponibleProductosServiciosDisponibles;
	}

	public Border setResaltarcantidad_maximoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarcantidad_maximoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_maximoProductosServiciosDisponibles() {
		return this.resaltarcantidad_maximoProductosServiciosDisponibles;
	}

	public void setResaltarcantidad_maximoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarcantidad_maximoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarcantidad_maximoProductosServiciosDisponibles() {
		return this.mostrarcantidad_maximoProductosServiciosDisponibles;
	}

	public void setMostrarcantidad_maximoProductosServiciosDisponibles(Boolean mostrarcantidad_maximoProductosServiciosDisponibles) {
		this.mostrarcantidad_maximoProductosServiciosDisponibles= mostrarcantidad_maximoProductosServiciosDisponibles;
	}

	public Boolean getActivarcantidad_maximoProductosServiciosDisponibles() {
		return this.activarcantidad_maximoProductosServiciosDisponibles;
	}

	public void setActivarcantidad_maximoProductosServiciosDisponibles(Boolean activarcantidad_maximoProductosServiciosDisponibles) {
		this.activarcantidad_maximoProductosServiciosDisponibles= activarcantidad_maximoProductosServiciosDisponibles;
	}

	public Border setResaltarcantidad_minimoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarcantidad_minimoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_minimoProductosServiciosDisponibles() {
		return this.resaltarcantidad_minimoProductosServiciosDisponibles;
	}

	public void setResaltarcantidad_minimoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarcantidad_minimoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarcantidad_minimoProductosServiciosDisponibles() {
		return this.mostrarcantidad_minimoProductosServiciosDisponibles;
	}

	public void setMostrarcantidad_minimoProductosServiciosDisponibles(Boolean mostrarcantidad_minimoProductosServiciosDisponibles) {
		this.mostrarcantidad_minimoProductosServiciosDisponibles= mostrarcantidad_minimoProductosServiciosDisponibles;
	}

	public Boolean getActivarcantidad_minimoProductosServiciosDisponibles() {
		return this.activarcantidad_minimoProductosServiciosDisponibles;
	}

	public void setActivarcantidad_minimoProductosServiciosDisponibles(Boolean activarcantidad_minimoProductosServiciosDisponibles) {
		this.activarcantidad_minimoProductosServiciosDisponibles= activarcantidad_minimoProductosServiciosDisponibles;
	}

	public Border setResaltarprecio_compraProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarprecio_compraProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_compraProductosServiciosDisponibles() {
		return this.resaltarprecio_compraProductosServiciosDisponibles;
	}

	public void setResaltarprecio_compraProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarprecio_compraProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarprecio_compraProductosServiciosDisponibles() {
		return this.mostrarprecio_compraProductosServiciosDisponibles;
	}

	public void setMostrarprecio_compraProductosServiciosDisponibles(Boolean mostrarprecio_compraProductosServiciosDisponibles) {
		this.mostrarprecio_compraProductosServiciosDisponibles= mostrarprecio_compraProductosServiciosDisponibles;
	}

	public Boolean getActivarprecio_compraProductosServiciosDisponibles() {
		return this.activarprecio_compraProductosServiciosDisponibles;
	}

	public void setActivarprecio_compraProductosServiciosDisponibles(Boolean activarprecio_compraProductosServiciosDisponibles) {
		this.activarprecio_compraProductosServiciosDisponibles= activarprecio_compraProductosServiciosDisponibles;
	}

	public Border setResaltarprecio_ventaProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarprecio_ventaProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_ventaProductosServiciosDisponibles() {
		return this.resaltarprecio_ventaProductosServiciosDisponibles;
	}

	public void setResaltarprecio_ventaProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarprecio_ventaProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarprecio_ventaProductosServiciosDisponibles() {
		return this.mostrarprecio_ventaProductosServiciosDisponibles;
	}

	public void setMostrarprecio_ventaProductosServiciosDisponibles(Boolean mostrarprecio_ventaProductosServiciosDisponibles) {
		this.mostrarprecio_ventaProductosServiciosDisponibles= mostrarprecio_ventaProductosServiciosDisponibles;
	}

	public Boolean getActivarprecio_ventaProductosServiciosDisponibles() {
		return this.activarprecio_ventaProductosServiciosDisponibles;
	}

	public void setActivarprecio_ventaProductosServiciosDisponibles(Boolean activarprecio_ventaProductosServiciosDisponibles) {
		this.activarprecio_ventaProductosServiciosDisponibles= activarprecio_ventaProductosServiciosDisponibles;
	}

	public Border setResaltarcosto_ultimoProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosdisponiblesBeanSwingJInternalFrame.jTtoolBarProductosServiciosDisponibles.setBorder(borderResaltar);
		
		this.resaltarcosto_ultimoProductosServiciosDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ultimoProductosServiciosDisponibles() {
		return this.resaltarcosto_ultimoProductosServiciosDisponibles;
	}

	public void setResaltarcosto_ultimoProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarcosto_ultimoProductosServiciosDisponibles= borderResaltar;
	}

	public Boolean getMostrarcosto_ultimoProductosServiciosDisponibles() {
		return this.mostrarcosto_ultimoProductosServiciosDisponibles;
	}

	public void setMostrarcosto_ultimoProductosServiciosDisponibles(Boolean mostrarcosto_ultimoProductosServiciosDisponibles) {
		this.mostrarcosto_ultimoProductosServiciosDisponibles= mostrarcosto_ultimoProductosServiciosDisponibles;
	}

	public Boolean getActivarcosto_ultimoProductosServiciosDisponibles() {
		return this.activarcosto_ultimoProductosServiciosDisponibles;
	}

	public void setActivarcosto_ultimoProductosServiciosDisponibles(Boolean activarcosto_ultimoProductosServiciosDisponibles) {
		this.activarcosto_ultimoProductosServiciosDisponibles= activarcosto_ultimoProductosServiciosDisponibles;
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
		
		
		this.setMostraridProductosServiciosDisponibles(esInicial);
		this.setMostrarid_empresaProductosServiciosDisponibles(esInicial);
		this.setMostrarid_sucursalProductosServiciosDisponibles(esInicial);
		this.setMostrarid_bodegaProductosServiciosDisponibles(esInicial);
		this.setMostrarid_lineaProductosServiciosDisponibles(esInicial);
		this.setMostrarid_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setMostrarid_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setMostrarid_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setMostrarid_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_sucursalProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_lineaProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setMostrarcodigoProductosServiciosDisponibles(esInicial);
		this.setMostrarnombreProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_bodegaProductosServiciosDisponibles(esInicial);
		this.setMostrarnombre_unidadProductosServiciosDisponibles(esInicial);
		this.setMostrarcantidad_disponibleProductosServiciosDisponibles(esInicial);
		this.setMostrarcantidad_maximoProductosServiciosDisponibles(esInicial);
		this.setMostrarcantidad_minimoProductosServiciosDisponibles(esInicial);
		this.setMostrarprecio_compraProductosServiciosDisponibles(esInicial);
		this.setMostrarprecio_ventaProductosServiciosDisponibles(esInicial);
		this.setMostrarcosto_ultimoProductosServiciosDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.ID)) {
				this.setMostraridProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setMostrarnombre_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO)) {
				this.setMostrarcantidad_maximoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO)) {
				this.setMostrarcantidad_minimoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA)) {
				this.setMostrarprecio_compraProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA)) {
				this.setMostrarprecio_ventaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO)) {
				this.setMostrarcosto_ultimoProductosServiciosDisponibles(esAsigna);
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
		
		
		this.setActivaridProductosServiciosDisponibles(esInicial);
		this.setActivarid_empresaProductosServiciosDisponibles(esInicial);
		this.setActivarid_sucursalProductosServiciosDisponibles(esInicial);
		this.setActivarid_bodegaProductosServiciosDisponibles(esInicial);
		this.setActivarid_lineaProductosServiciosDisponibles(esInicial);
		this.setActivarid_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setActivarid_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setActivarid_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setActivarid_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_sucursalProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_lineaProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setActivarcodigoProductosServiciosDisponibles(esInicial);
		this.setActivarnombreProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_bodegaProductosServiciosDisponibles(esInicial);
		this.setActivarnombre_unidadProductosServiciosDisponibles(esInicial);
		this.setActivarcantidad_disponibleProductosServiciosDisponibles(esInicial);
		this.setActivarcantidad_maximoProductosServiciosDisponibles(esInicial);
		this.setActivarcantidad_minimoProductosServiciosDisponibles(esInicial);
		this.setActivarprecio_compraProductosServiciosDisponibles(esInicial);
		this.setActivarprecio_ventaProductosServiciosDisponibles(esInicial);
		this.setActivarcosto_ultimoProductosServiciosDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.ID)) {
				this.setActivaridProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setActivarnombre_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO)) {
				this.setActivarcantidad_maximoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO)) {
				this.setActivarcantidad_minimoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA)) {
				this.setActivarprecio_compraProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA)) {
				this.setActivarprecio_ventaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO)) {
				this.setActivarcosto_ultimoProductosServiciosDisponibles(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosServiciosDisponibles(esInicial);
		this.setResaltarid_empresaProductosServiciosDisponibles(esInicial);
		this.setResaltarid_sucursalProductosServiciosDisponibles(esInicial);
		this.setResaltarid_bodegaProductosServiciosDisponibles(esInicial);
		this.setResaltarid_lineaProductosServiciosDisponibles(esInicial);
		this.setResaltarid_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setResaltarid_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setResaltarid_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setResaltarid_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_sucursalProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_lineaProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_linea_grupoProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_linea_categoriaProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_linea_marcaProductosServiciosDisponibles(esInicial);
		this.setResaltarcodigoProductosServiciosDisponibles(esInicial);
		this.setResaltarnombreProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_tipo_producto_servicioProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_bodegaProductosServiciosDisponibles(esInicial);
		this.setResaltarnombre_unidadProductosServiciosDisponibles(esInicial);
		this.setResaltarcantidad_disponibleProductosServiciosDisponibles(esInicial);
		this.setResaltarcantidad_maximoProductosServiciosDisponibles(esInicial);
		this.setResaltarcantidad_minimoProductosServiciosDisponibles(esInicial);
		this.setResaltarprecio_compraProductosServiciosDisponibles(esInicial);
		this.setResaltarprecio_ventaProductosServiciosDisponibles(esInicial);
		this.setResaltarcosto_ultimoProductosServiciosDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.ID)) {
				this.setResaltaridProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setResaltarnombre_tipo_producto_servicioProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMAXIMO)) {
				this.setResaltarcantidad_maximoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.CANTIDADMINIMO)) {
				this.setResaltarcantidad_minimoProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA)) {
				this.setResaltarprecio_compraProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA)) {
				this.setResaltarprecio_ventaProductosServiciosDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO)) {
				this.setResaltarcosto_ultimoProductosServiciosDisponibles(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles=true;

	public Boolean getMostrarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles() {
		return this.mostrarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles;
	}

	public void setMostrarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles=true;

	public Boolean getActivarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles() {
		return this.activarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles;
	}

	public void setActivarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles(Boolean habilitarResaltar) {
		this.activarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles=null;

	public Border getResaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles() {
		return this.resaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles;
	}

	public void setResaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles(Border borderResaltar) {
		this.resaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles= borderResaltar;
	}

	public void setResaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosDisponiblesBeanSwingJInternalFrame productosserviciosdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosServiciosDisponiblesProductosServiciosDisponibles= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}