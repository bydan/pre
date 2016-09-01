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


import com.bydan.erp.inventario.util.report.ProductosServiciosProductosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProductosServiciosProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosProductosParameterGeneral;

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
final public class ProductosServiciosProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosServiciosProductos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosServiciosProductos"+ProductosServiciosProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosServiciosProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosServiciosProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosServiciosProductosConstantesFunciones.SCHEMA+"_"+ProductosServiciosProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosServiciosProductosConstantesFunciones.SCHEMA+"_"+ProductosServiciosProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosServiciosProductosConstantesFunciones.SCHEMA+"_"+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosServiciosProductosConstantesFunciones.SCHEMA+"_"+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosServiciosProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosServiciosProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosServiciosProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosServiciosProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Servicios Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Servicios Productos";
	public static final String SCLASSWEBTITULO_LOWER="Productos Servicios Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosServiciosProductos";
	public static final String OBJECTNAME="productosserviciosproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="productos_servicios_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosserviciosproductos from "+ProductosServiciosProductosConstantesFunciones.SPERSISTENCENAME+" productosserviciosproductos";
	public static String QUERYSELECTNATIVE="select "+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".version_row,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_empresa,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_bodega,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_linea,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_linea,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".codigo,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_tipo_producto_servicio,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_bodega,"+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME+".nombre_unidad from "+ProductosServiciosProductosConstantesFunciones.SCHEMA+"."+ProductosServiciosProductosConstantesFunciones.TABLENAME;//+" as "+ProductosServiciosProductosConstantesFunciones.TABLENAME;
	
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
	
	public static String getProductosServiciosProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.CODIGO)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRE)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosServiciosProductosDescripcion(ProductosServiciosProductos productosserviciosproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosserviciosproductos !=null/* && productosserviciosproductos.getId()!=0*/) {
			sDescripcion=productosserviciosproductos.getcodigo();//productosserviciosproductosproductosserviciosproductos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosServiciosProductosDescripcionDetallado(ProductosServiciosProductos productosserviciosproductos) {
		String sDescripcion="";
			
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.ID+"=";
		sDescripcion+=productosserviciosproductos.getId().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosserviciosproductos.getVersionRow().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosserviciosproductos.getid_empresa().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosserviciosproductos.getid_sucursal().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productosserviciosproductos.getid_bodega().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productosserviciosproductos.getid_linea().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productosserviciosproductos.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productosserviciosproductos.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productosserviciosproductos.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosproductos.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=productosserviciosproductos.getnombre_sucursal()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=productosserviciosproductos.getnombre_linea()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=productosserviciosproductos.getnombre_linea_grupo()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=productosserviciosproductos.getnombre_linea_categoria()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=productosserviciosproductos.getnombre_linea_marca()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.CODIGO+"=";
		sDescripcion+=productosserviciosproductos.getcodigo()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=productosserviciosproductos.getnombre()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=productosserviciosproductos.getnombre_tipo_producto_servicio()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=productosserviciosproductos.getnombre_bodega()+",";
		sDescripcion+=ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosserviciosproductos.getnombre_unidad()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosServiciosProductosDescripcion(ProductosServiciosProductos productosserviciosproductos,String sValor) throws Exception {			
		if(productosserviciosproductos !=null) {
			productosserviciosproductos.setcodigo(sValor);;//productosserviciosproductosproductosserviciosproductos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProductosServiciosProductos")) {
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

	public static String getDetalleIndiceBusquedaProductosServiciosProductos(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio) {
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
	
	
	
	
	
	
	public static void quitarEspaciosProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosproductos.setnombre_sucursal(productosserviciosproductos.getnombre_sucursal().trim());
		productosserviciosproductos.setnombre_linea(productosserviciosproductos.getnombre_linea().trim());
		productosserviciosproductos.setnombre_linea_grupo(productosserviciosproductos.getnombre_linea_grupo().trim());
		productosserviciosproductos.setnombre_linea_categoria(productosserviciosproductos.getnombre_linea_categoria().trim());
		productosserviciosproductos.setnombre_linea_marca(productosserviciosproductos.getnombre_linea_marca().trim());
		productosserviciosproductos.setcodigo(productosserviciosproductos.getcodigo().trim());
		productosserviciosproductos.setnombre(productosserviciosproductos.getnombre().trim());
		productosserviciosproductos.setnombre_tipo_producto_servicio(productosserviciosproductos.getnombre_tipo_producto_servicio().trim());
		productosserviciosproductos.setnombre_bodega(productosserviciosproductos.getnombre_bodega().trim());
		productosserviciosproductos.setnombre_unidad(productosserviciosproductos.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosProductoss(List<ProductosServiciosProductos> productosserviciosproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {
			productosserviciosproductos.setnombre_sucursal(productosserviciosproductos.getnombre_sucursal().trim());
			productosserviciosproductos.setnombre_linea(productosserviciosproductos.getnombre_linea().trim());
			productosserviciosproductos.setnombre_linea_grupo(productosserviciosproductos.getnombre_linea_grupo().trim());
			productosserviciosproductos.setnombre_linea_categoria(productosserviciosproductos.getnombre_linea_categoria().trim());
			productosserviciosproductos.setnombre_linea_marca(productosserviciosproductos.getnombre_linea_marca().trim());
			productosserviciosproductos.setcodigo(productosserviciosproductos.getcodigo().trim());
			productosserviciosproductos.setnombre(productosserviciosproductos.getnombre().trim());
			productosserviciosproductos.setnombre_tipo_producto_servicio(productosserviciosproductos.getnombre_tipo_producto_servicio().trim());
			productosserviciosproductos.setnombre_bodega(productosserviciosproductos.getnombre_bodega().trim());
			productosserviciosproductos.setnombre_unidad(productosserviciosproductos.getnombre_unidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosserviciosproductos.getConCambioAuxiliar()) {
			productosserviciosproductos.setIsDeleted(productosserviciosproductos.getIsDeletedAuxiliar());	
			productosserviciosproductos.setIsNew(productosserviciosproductos.getIsNewAuxiliar());	
			productosserviciosproductos.setIsChanged(productosserviciosproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosserviciosproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosserviciosproductos.setIsDeletedAuxiliar(false);	
			productosserviciosproductos.setIsNewAuxiliar(false);	
			productosserviciosproductos.setIsChangedAuxiliar(false);
			
			productosserviciosproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosProductoss(List<ProductosServiciosProductos> productosserviciosproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosServiciosProductos productosserviciosproductos : productosserviciosproductoss) {
			if(conAsignarBase && productosserviciosproductos.getConCambioAuxiliar()) {
				productosserviciosproductos.setIsDeleted(productosserviciosproductos.getIsDeletedAuxiliar());	
				productosserviciosproductos.setIsNew(productosserviciosproductos.getIsNewAuxiliar());	
				productosserviciosproductos.setIsChanged(productosserviciosproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosserviciosproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosserviciosproductos.setIsDeletedAuxiliar(false);	
				productosserviciosproductos.setIsNewAuxiliar(false);	
				productosserviciosproductos.setIsChangedAuxiliar(false);
				
				productosserviciosproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductosServiciosProductoss(List<ProductosServiciosProductos> productosserviciosproductoss,Boolean conEnteros) throws Exception  {
		
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosServiciosProductos(List<ProductosServiciosProductos> productosserviciosproductoss,ProductosServiciosProductos productosserviciosproductosAux) throws Exception  {
		ProductosServiciosProductosConstantesFunciones.InicializarValoresProductosServiciosProductos(productosserviciosproductosAux,true);
		
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {
			if(productosserviciosproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosServiciosProductosConstantesFunciones.getArrayColumnasGlobalesProductosServiciosProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosServiciosProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosProductos> productosserviciosproductoss,ProductosServiciosProductos productosserviciosproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosProductos productosserviciosproductosAux: productosserviciosproductoss) {
			if(productosserviciosproductosAux!=null && productosserviciosproductos!=null) {
				if((productosserviciosproductosAux.getId()==null && productosserviciosproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosserviciosproductosAux.getId()!=null && productosserviciosproductos.getId()!=null){
					if(productosserviciosproductosAux.getId().equals(productosserviciosproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosProductos(List<ProductosServiciosProductos> productosserviciosproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {			
			if(productosserviciosproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosServiciosProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_ID, ProductosServiciosProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_VERSIONROW, ProductosServiciosProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRESUCURSAL, ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEA, ProductosServiciosProductosConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAMARCA, ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_CODIGO, ProductosServiciosProductosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRE, ProductosServiciosProductosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO, ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREBODEGA, ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosServiciosProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosProductos() throws Exception  {
		return ProductosServiciosProductosConstantesFunciones.getTiposSeleccionarProductosServiciosProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosProductos(Boolean conFk) throws Exception  {
		return ProductosServiciosProductosConstantesFunciones.getTiposSeleccionarProductosServiciosProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosServiciosProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductosAux) throws Exception {
		
			productosserviciosproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosproductosAux.getEmpresa()));
			productosserviciosproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosproductosAux.getSucursal()));
			productosserviciosproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosproductosAux.getBodega()));
			productosserviciosproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLinea()));
			productosserviciosproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaGrupo()));
			productosserviciosproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaCategoria()));
			productosserviciosproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaMarca()));
			productosserviciosproductosAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosproductosAux.getTipoProductoServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosProductos(List<ProductosServiciosProductos> productosserviciosproductossTemp) throws Exception {
		for(ProductosServiciosProductos productosserviciosproductosAux:productosserviciosproductossTemp) {
			
			productosserviciosproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciosproductosAux.getEmpresa()));
			productosserviciosproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciosproductosAux.getSucursal()));
			productosserviciosproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciosproductosAux.getBodega()));
			productosserviciosproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLinea()));
			productosserviciosproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaGrupo()));
			productosserviciosproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaCategoria()));
			productosserviciosproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciosproductosAux.getLineaMarca()));
			productosserviciosproductosAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productosserviciosproductosAux.getTipoProductoServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosServiciosProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosServiciosProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosProductosConstantesFunciones.getClassesRelationshipsOfProductosServiciosProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosProductosConstantesFunciones.getClassesRelationshipsFromStringsOfProductosServiciosProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosServiciosProductos productosserviciosproductos,List<ProductosServiciosProductos> productosserviciosproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosServiciosProductos productosserviciosproductos,List<ProductosServiciosProductos> productosserviciosproductoss) throws Exception {
		try	{			
			for(ProductosServiciosProductos productosserviciosproductosLocal:productosserviciosproductoss) {
				if(productosserviciosproductosLocal.getId().equals(productosserviciosproductos.getId())) {
					productosserviciosproductosLocal.setIsSelected(productosserviciosproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosServiciosProductos(List<ProductosServiciosProductos> productosserviciosproductossAux) throws Exception {
		//this.productosserviciosproductossAux=productosserviciosproductossAux;
		
		for(ProductosServiciosProductos productosserviciosproductosAux:productosserviciosproductossAux) {
			if(productosserviciosproductosAux.getIsChanged()) {
				productosserviciosproductosAux.setIsChanged(false);
			}		
			
			if(productosserviciosproductosAux.getIsNew()) {
				productosserviciosproductosAux.setIsNew(false);
			}	
			
			if(productosserviciosproductosAux.getIsDeleted()) {
				productosserviciosproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductosAux) throws Exception {
		//this.productosserviciosproductosAux=productosserviciosproductosAux;
		
			if(productosserviciosproductosAux.getIsChanged()) {
				productosserviciosproductosAux.setIsChanged(false);
			}		
			
			if(productosserviciosproductosAux.getIsNew()) {
				productosserviciosproductosAux.setIsNew(false);
			}	
			
			if(productosserviciosproductosAux.getIsDeleted()) {
				productosserviciosproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosServiciosProductos productosserviciosproductosAsignar,ProductosServiciosProductos productosserviciosproductos) throws Exception {
		productosserviciosproductosAsignar.setId(productosserviciosproductos.getId());	
		productosserviciosproductosAsignar.setVersionRow(productosserviciosproductos.getVersionRow());	
		productosserviciosproductosAsignar.setnombre_sucursal(productosserviciosproductos.getnombre_sucursal());	
		productosserviciosproductosAsignar.setnombre_linea(productosserviciosproductos.getnombre_linea());	
		productosserviciosproductosAsignar.setnombre_linea_grupo(productosserviciosproductos.getnombre_linea_grupo());	
		productosserviciosproductosAsignar.setnombre_linea_categoria(productosserviciosproductos.getnombre_linea_categoria());	
		productosserviciosproductosAsignar.setnombre_linea_marca(productosserviciosproductos.getnombre_linea_marca());	
		productosserviciosproductosAsignar.setcodigo(productosserviciosproductos.getcodigo());	
		productosserviciosproductosAsignar.setnombre(productosserviciosproductos.getnombre());	
		productosserviciosproductosAsignar.setnombre_tipo_producto_servicio(productosserviciosproductos.getnombre_tipo_producto_servicio());	
		productosserviciosproductosAsignar.setnombre_bodega(productosserviciosproductos.getnombre_bodega());	
		productosserviciosproductosAsignar.setnombre_unidad(productosserviciosproductos.getnombre_unidad());	
	}
	
	public static void inicializarProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductos) throws Exception {
		try {
				productosserviciosproductos.setId(0L);	
					
				productosserviciosproductos.setnombre_sucursal("");	
				productosserviciosproductos.setnombre_linea("");	
				productosserviciosproductos.setnombre_linea_grupo("");	
				productosserviciosproductos.setnombre_linea_categoria("");	
				productosserviciosproductos.setnombre_linea_marca("");	
				productosserviciosproductos.setcodigo("");	
				productosserviciosproductos.setnombre("");	
				productosserviciosproductos.setnombre_tipo_producto_servicio("");	
				productosserviciosproductos.setnombre_bodega("");	
				productosserviciosproductos.setnombre_unidad("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosServiciosProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBRETIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosServiciosProductos(String sTipo,Row row,Workbook workbook,ProductosServiciosProductos productosserviciosproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_tipo_producto_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciosproductos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosServiciosProductos="";
	
	public String getsFinalQueryProductosServiciosProductos() {
		return this.sFinalQueryProductosServiciosProductos;
	}
	
	public void setsFinalQueryProductosServiciosProductos(String sFinalQueryProductosServiciosProductos) {
		this.sFinalQueryProductosServiciosProductos= sFinalQueryProductosServiciosProductos;
	}
	
	public Border resaltarSeleccionarProductosServiciosProductos=null;
	
	public Border setResaltarSeleccionarProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosServiciosProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosServiciosProductos() {
		return this.resaltarSeleccionarProductosServiciosProductos;
	}
	
	public void setResaltarSeleccionarProductosServiciosProductos(Border borderResaltarSeleccionarProductosServiciosProductos) {
		this.resaltarSeleccionarProductosServiciosProductos= borderResaltarSeleccionarProductosServiciosProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosServiciosProductos=null;
	public Boolean mostraridProductosServiciosProductos=true;
	public Boolean activaridProductosServiciosProductos=true;

	public Border resaltarid_empresaProductosServiciosProductos=null;
	public Boolean mostrarid_empresaProductosServiciosProductos=true;
	public Boolean activarid_empresaProductosServiciosProductos=true;
	public Boolean cargarid_empresaProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosServiciosProductos=null;
	public Boolean mostrarid_sucursalProductosServiciosProductos=true;
	public Boolean activarid_sucursalProductosServiciosProductos=true;
	public Boolean cargarid_sucursalProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosServiciosProductos=null;
	public Boolean mostrarid_bodegaProductosServiciosProductos=true;
	public Boolean activarid_bodegaProductosServiciosProductos=true;
	public Boolean cargarid_bodegaProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosServiciosProductos=null;
	public Boolean mostrarid_lineaProductosServiciosProductos=true;
	public Boolean activarid_lineaProductosServiciosProductos=true;
	public Boolean cargarid_lineaProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosServiciosProductos=null;
	public Boolean mostrarid_linea_grupoProductosServiciosProductos=true;
	public Boolean activarid_linea_grupoProductosServiciosProductos=true;
	public Boolean cargarid_linea_grupoProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosServiciosProductos=null;
	public Boolean mostrarid_linea_categoriaProductosServiciosProductos=true;
	public Boolean activarid_linea_categoriaProductosServiciosProductos=true;
	public Boolean cargarid_linea_categoriaProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosServiciosProductos=null;
	public Boolean mostrarid_linea_marcaProductosServiciosProductos=true;
	public Boolean activarid_linea_marcaProductosServiciosProductos=true;
	public Boolean cargarid_linea_marcaProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioProductosServiciosProductos=null;
	public Boolean mostrarid_tipo_producto_servicioProductosServiciosProductos=true;
	public Boolean activarid_tipo_producto_servicioProductosServiciosProductos=true;
	public Boolean cargarid_tipo_producto_servicioProductosServiciosProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioProductosServiciosProductos=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProductosServiciosProductos=null;
	public Boolean mostrarnombre_sucursalProductosServiciosProductos=true;
	public Boolean activarnombre_sucursalProductosServiciosProductos=true;

	public Border resaltarnombre_lineaProductosServiciosProductos=null;
	public Boolean mostrarnombre_lineaProductosServiciosProductos=true;
	public Boolean activarnombre_lineaProductosServiciosProductos=true;

	public Border resaltarnombre_linea_grupoProductosServiciosProductos=null;
	public Boolean mostrarnombre_linea_grupoProductosServiciosProductos=true;
	public Boolean activarnombre_linea_grupoProductosServiciosProductos=true;

	public Border resaltarnombre_linea_categoriaProductosServiciosProductos=null;
	public Boolean mostrarnombre_linea_categoriaProductosServiciosProductos=true;
	public Boolean activarnombre_linea_categoriaProductosServiciosProductos=true;

	public Border resaltarnombre_linea_marcaProductosServiciosProductos=null;
	public Boolean mostrarnombre_linea_marcaProductosServiciosProductos=true;
	public Boolean activarnombre_linea_marcaProductosServiciosProductos=true;

	public Border resaltarcodigoProductosServiciosProductos=null;
	public Boolean mostrarcodigoProductosServiciosProductos=true;
	public Boolean activarcodigoProductosServiciosProductos=true;

	public Border resaltarnombreProductosServiciosProductos=null;
	public Boolean mostrarnombreProductosServiciosProductos=true;
	public Boolean activarnombreProductosServiciosProductos=true;

	public Border resaltarnombre_tipo_producto_servicioProductosServiciosProductos=null;
	public Boolean mostrarnombre_tipo_producto_servicioProductosServiciosProductos=true;
	public Boolean activarnombre_tipo_producto_servicioProductosServiciosProductos=true;

	public Border resaltarnombre_bodegaProductosServiciosProductos=null;
	public Boolean mostrarnombre_bodegaProductosServiciosProductos=true;
	public Boolean activarnombre_bodegaProductosServiciosProductos=true;

	public Border resaltarnombre_unidadProductosServiciosProductos=null;
	public Boolean mostrarnombre_unidadProductosServiciosProductos=true;
	public Boolean activarnombre_unidadProductosServiciosProductos=true;

	
	

	public Border setResaltaridProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltaridProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosServiciosProductos() {
		return this.resaltaridProductosServiciosProductos;
	}

	public void setResaltaridProductosServiciosProductos(Border borderResaltar) {
		this.resaltaridProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostraridProductosServiciosProductos() {
		return this.mostraridProductosServiciosProductos;
	}

	public void setMostraridProductosServiciosProductos(Boolean mostraridProductosServiciosProductos) {
		this.mostraridProductosServiciosProductos= mostraridProductosServiciosProductos;
	}

	public Boolean getActivaridProductosServiciosProductos() {
		return this.activaridProductosServiciosProductos;
	}

	public void setActivaridProductosServiciosProductos(Boolean activaridProductosServiciosProductos) {
		this.activaridProductosServiciosProductos= activaridProductosServiciosProductos;
	}

	public Border setResaltarid_empresaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosServiciosProductos() {
		return this.resaltarid_empresaProductosServiciosProductos;
	}

	public void setResaltarid_empresaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_empresaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosServiciosProductos() {
		return this.mostrarid_empresaProductosServiciosProductos;
	}

	public void setMostrarid_empresaProductosServiciosProductos(Boolean mostrarid_empresaProductosServiciosProductos) {
		this.mostrarid_empresaProductosServiciosProductos= mostrarid_empresaProductosServiciosProductos;
	}

	public Boolean getActivarid_empresaProductosServiciosProductos() {
		return this.activarid_empresaProductosServiciosProductos;
	}

	public void setActivarid_empresaProductosServiciosProductos(Boolean activarid_empresaProductosServiciosProductos) {
		this.activarid_empresaProductosServiciosProductos= activarid_empresaProductosServiciosProductos;
	}

	public Boolean getCargarid_empresaProductosServiciosProductos() {
		return this.cargarid_empresaProductosServiciosProductos;
	}

	public void setCargarid_empresaProductosServiciosProductos(Boolean cargarid_empresaProductosServiciosProductos) {
		this.cargarid_empresaProductosServiciosProductos= cargarid_empresaProductosServiciosProductos;
	}

	public Border setResaltarid_sucursalProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosServiciosProductos() {
		return this.resaltarid_sucursalProductosServiciosProductos;
	}

	public void setResaltarid_sucursalProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_sucursalProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosServiciosProductos() {
		return this.mostrarid_sucursalProductosServiciosProductos;
	}

	public void setMostrarid_sucursalProductosServiciosProductos(Boolean mostrarid_sucursalProductosServiciosProductos) {
		this.mostrarid_sucursalProductosServiciosProductos= mostrarid_sucursalProductosServiciosProductos;
	}

	public Boolean getActivarid_sucursalProductosServiciosProductos() {
		return this.activarid_sucursalProductosServiciosProductos;
	}

	public void setActivarid_sucursalProductosServiciosProductos(Boolean activarid_sucursalProductosServiciosProductos) {
		this.activarid_sucursalProductosServiciosProductos= activarid_sucursalProductosServiciosProductos;
	}

	public Boolean getCargarid_sucursalProductosServiciosProductos() {
		return this.cargarid_sucursalProductosServiciosProductos;
	}

	public void setCargarid_sucursalProductosServiciosProductos(Boolean cargarid_sucursalProductosServiciosProductos) {
		this.cargarid_sucursalProductosServiciosProductos= cargarid_sucursalProductosServiciosProductos;
	}

	public Border setResaltarid_bodegaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosServiciosProductos() {
		return this.resaltarid_bodegaProductosServiciosProductos;
	}

	public void setResaltarid_bodegaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_bodegaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosServiciosProductos() {
		return this.mostrarid_bodegaProductosServiciosProductos;
	}

	public void setMostrarid_bodegaProductosServiciosProductos(Boolean mostrarid_bodegaProductosServiciosProductos) {
		this.mostrarid_bodegaProductosServiciosProductos= mostrarid_bodegaProductosServiciosProductos;
	}

	public Boolean getActivarid_bodegaProductosServiciosProductos() {
		return this.activarid_bodegaProductosServiciosProductos;
	}

	public void setActivarid_bodegaProductosServiciosProductos(Boolean activarid_bodegaProductosServiciosProductos) {
		this.activarid_bodegaProductosServiciosProductos= activarid_bodegaProductosServiciosProductos;
	}

	public Boolean getCargarid_bodegaProductosServiciosProductos() {
		return this.cargarid_bodegaProductosServiciosProductos;
	}

	public void setCargarid_bodegaProductosServiciosProductos(Boolean cargarid_bodegaProductosServiciosProductos) {
		this.cargarid_bodegaProductosServiciosProductos= cargarid_bodegaProductosServiciosProductos;
	}

	public Border setResaltarid_lineaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosServiciosProductos() {
		return this.resaltarid_lineaProductosServiciosProductos;
	}

	public void setResaltarid_lineaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_lineaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosServiciosProductos() {
		return this.mostrarid_lineaProductosServiciosProductos;
	}

	public void setMostrarid_lineaProductosServiciosProductos(Boolean mostrarid_lineaProductosServiciosProductos) {
		this.mostrarid_lineaProductosServiciosProductos= mostrarid_lineaProductosServiciosProductos;
	}

	public Boolean getActivarid_lineaProductosServiciosProductos() {
		return this.activarid_lineaProductosServiciosProductos;
	}

	public void setActivarid_lineaProductosServiciosProductos(Boolean activarid_lineaProductosServiciosProductos) {
		this.activarid_lineaProductosServiciosProductos= activarid_lineaProductosServiciosProductos;
	}

	public Boolean getCargarid_lineaProductosServiciosProductos() {
		return this.cargarid_lineaProductosServiciosProductos;
	}

	public void setCargarid_lineaProductosServiciosProductos(Boolean cargarid_lineaProductosServiciosProductos) {
		this.cargarid_lineaProductosServiciosProductos= cargarid_lineaProductosServiciosProductos;
	}

	public Border setResaltarid_linea_grupoProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosServiciosProductos() {
		return this.resaltarid_linea_grupoProductosServiciosProductos;
	}

	public void setResaltarid_linea_grupoProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosServiciosProductos() {
		return this.mostrarid_linea_grupoProductosServiciosProductos;
	}

	public void setMostrarid_linea_grupoProductosServiciosProductos(Boolean mostrarid_linea_grupoProductosServiciosProductos) {
		this.mostrarid_linea_grupoProductosServiciosProductos= mostrarid_linea_grupoProductosServiciosProductos;
	}

	public Boolean getActivarid_linea_grupoProductosServiciosProductos() {
		return this.activarid_linea_grupoProductosServiciosProductos;
	}

	public void setActivarid_linea_grupoProductosServiciosProductos(Boolean activarid_linea_grupoProductosServiciosProductos) {
		this.activarid_linea_grupoProductosServiciosProductos= activarid_linea_grupoProductosServiciosProductos;
	}

	public Boolean getCargarid_linea_grupoProductosServiciosProductos() {
		return this.cargarid_linea_grupoProductosServiciosProductos;
	}

	public void setCargarid_linea_grupoProductosServiciosProductos(Boolean cargarid_linea_grupoProductosServiciosProductos) {
		this.cargarid_linea_grupoProductosServiciosProductos= cargarid_linea_grupoProductosServiciosProductos;
	}

	public Border setResaltarid_linea_categoriaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosServiciosProductos() {
		return this.resaltarid_linea_categoriaProductosServiciosProductos;
	}

	public void setResaltarid_linea_categoriaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosServiciosProductos() {
		return this.mostrarid_linea_categoriaProductosServiciosProductos;
	}

	public void setMostrarid_linea_categoriaProductosServiciosProductos(Boolean mostrarid_linea_categoriaProductosServiciosProductos) {
		this.mostrarid_linea_categoriaProductosServiciosProductos= mostrarid_linea_categoriaProductosServiciosProductos;
	}

	public Boolean getActivarid_linea_categoriaProductosServiciosProductos() {
		return this.activarid_linea_categoriaProductosServiciosProductos;
	}

	public void setActivarid_linea_categoriaProductosServiciosProductos(Boolean activarid_linea_categoriaProductosServiciosProductos) {
		this.activarid_linea_categoriaProductosServiciosProductos= activarid_linea_categoriaProductosServiciosProductos;
	}

	public Boolean getCargarid_linea_categoriaProductosServiciosProductos() {
		return this.cargarid_linea_categoriaProductosServiciosProductos;
	}

	public void setCargarid_linea_categoriaProductosServiciosProductos(Boolean cargarid_linea_categoriaProductosServiciosProductos) {
		this.cargarid_linea_categoriaProductosServiciosProductos= cargarid_linea_categoriaProductosServiciosProductos;
	}

	public Border setResaltarid_linea_marcaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosServiciosProductos() {
		return this.resaltarid_linea_marcaProductosServiciosProductos;
	}

	public void setResaltarid_linea_marcaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosServiciosProductos() {
		return this.mostrarid_linea_marcaProductosServiciosProductos;
	}

	public void setMostrarid_linea_marcaProductosServiciosProductos(Boolean mostrarid_linea_marcaProductosServiciosProductos) {
		this.mostrarid_linea_marcaProductosServiciosProductos= mostrarid_linea_marcaProductosServiciosProductos;
	}

	public Boolean getActivarid_linea_marcaProductosServiciosProductos() {
		return this.activarid_linea_marcaProductosServiciosProductos;
	}

	public void setActivarid_linea_marcaProductosServiciosProductos(Boolean activarid_linea_marcaProductosServiciosProductos) {
		this.activarid_linea_marcaProductosServiciosProductos= activarid_linea_marcaProductosServiciosProductos;
	}

	public Boolean getCargarid_linea_marcaProductosServiciosProductos() {
		return this.cargarid_linea_marcaProductosServiciosProductos;
	}

	public void setCargarid_linea_marcaProductosServiciosProductos(Boolean cargarid_linea_marcaProductosServiciosProductos) {
		this.cargarid_linea_marcaProductosServiciosProductos= cargarid_linea_marcaProductosServiciosProductos;
	}

	public Border setResaltarid_tipo_producto_servicioProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioProductosServiciosProductos() {
		return this.resaltarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setResaltarid_tipo_producto_servicioProductosServiciosProductos(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioProductosServiciosProductos() {
		return this.mostrarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setMostrarid_tipo_producto_servicioProductosServiciosProductos(Boolean mostrarid_tipo_producto_servicioProductosServiciosProductos) {
		this.mostrarid_tipo_producto_servicioProductosServiciosProductos= mostrarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public Boolean getActivarid_tipo_producto_servicioProductosServiciosProductos() {
		return this.activarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setActivarid_tipo_producto_servicioProductosServiciosProductos(Boolean activarid_tipo_producto_servicioProductosServiciosProductos) {
		this.activarid_tipo_producto_servicioProductosServiciosProductos= activarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public Boolean getCargarid_tipo_producto_servicioProductosServiciosProductos() {
		return this.cargarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setCargarid_tipo_producto_servicioProductosServiciosProductos(Boolean cargarid_tipo_producto_servicioProductosServiciosProductos) {
		this.cargarid_tipo_producto_servicioProductosServiciosProductos= cargarid_tipo_producto_servicioProductosServiciosProductos;
	}

	public Border setResaltarnombre_sucursalProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProductosServiciosProductos() {
		return this.resaltarnombre_sucursalProductosServiciosProductos;
	}

	public void setResaltarnombre_sucursalProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_sucursalProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProductosServiciosProductos() {
		return this.mostrarnombre_sucursalProductosServiciosProductos;
	}

	public void setMostrarnombre_sucursalProductosServiciosProductos(Boolean mostrarnombre_sucursalProductosServiciosProductos) {
		this.mostrarnombre_sucursalProductosServiciosProductos= mostrarnombre_sucursalProductosServiciosProductos;
	}

	public Boolean getActivarnombre_sucursalProductosServiciosProductos() {
		return this.activarnombre_sucursalProductosServiciosProductos;
	}

	public void setActivarnombre_sucursalProductosServiciosProductos(Boolean activarnombre_sucursalProductosServiciosProductos) {
		this.activarnombre_sucursalProductosServiciosProductos= activarnombre_sucursalProductosServiciosProductos;
	}

	public Border setResaltarnombre_lineaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaProductosServiciosProductos() {
		return this.resaltarnombre_lineaProductosServiciosProductos;
	}

	public void setResaltarnombre_lineaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_lineaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaProductosServiciosProductos() {
		return this.mostrarnombre_lineaProductosServiciosProductos;
	}

	public void setMostrarnombre_lineaProductosServiciosProductos(Boolean mostrarnombre_lineaProductosServiciosProductos) {
		this.mostrarnombre_lineaProductosServiciosProductos= mostrarnombre_lineaProductosServiciosProductos;
	}

	public Boolean getActivarnombre_lineaProductosServiciosProductos() {
		return this.activarnombre_lineaProductosServiciosProductos;
	}

	public void setActivarnombre_lineaProductosServiciosProductos(Boolean activarnombre_lineaProductosServiciosProductos) {
		this.activarnombre_lineaProductosServiciosProductos= activarnombre_lineaProductosServiciosProductos;
	}

	public Border setResaltarnombre_linea_grupoProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoProductosServiciosProductos() {
		return this.resaltarnombre_linea_grupoProductosServiciosProductos;
	}

	public void setResaltarnombre_linea_grupoProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_linea_grupoProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoProductosServiciosProductos() {
		return this.mostrarnombre_linea_grupoProductosServiciosProductos;
	}

	public void setMostrarnombre_linea_grupoProductosServiciosProductos(Boolean mostrarnombre_linea_grupoProductosServiciosProductos) {
		this.mostrarnombre_linea_grupoProductosServiciosProductos= mostrarnombre_linea_grupoProductosServiciosProductos;
	}

	public Boolean getActivarnombre_linea_grupoProductosServiciosProductos() {
		return this.activarnombre_linea_grupoProductosServiciosProductos;
	}

	public void setActivarnombre_linea_grupoProductosServiciosProductos(Boolean activarnombre_linea_grupoProductosServiciosProductos) {
		this.activarnombre_linea_grupoProductosServiciosProductos= activarnombre_linea_grupoProductosServiciosProductos;
	}

	public Border setResaltarnombre_linea_categoriaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaProductosServiciosProductos() {
		return this.resaltarnombre_linea_categoriaProductosServiciosProductos;
	}

	public void setResaltarnombre_linea_categoriaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaProductosServiciosProductos() {
		return this.mostrarnombre_linea_categoriaProductosServiciosProductos;
	}

	public void setMostrarnombre_linea_categoriaProductosServiciosProductos(Boolean mostrarnombre_linea_categoriaProductosServiciosProductos) {
		this.mostrarnombre_linea_categoriaProductosServiciosProductos= mostrarnombre_linea_categoriaProductosServiciosProductos;
	}

	public Boolean getActivarnombre_linea_categoriaProductosServiciosProductos() {
		return this.activarnombre_linea_categoriaProductosServiciosProductos;
	}

	public void setActivarnombre_linea_categoriaProductosServiciosProductos(Boolean activarnombre_linea_categoriaProductosServiciosProductos) {
		this.activarnombre_linea_categoriaProductosServiciosProductos= activarnombre_linea_categoriaProductosServiciosProductos;
	}

	public Border setResaltarnombre_linea_marcaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaProductosServiciosProductos() {
		return this.resaltarnombre_linea_marcaProductosServiciosProductos;
	}

	public void setResaltarnombre_linea_marcaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_linea_marcaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaProductosServiciosProductos() {
		return this.mostrarnombre_linea_marcaProductosServiciosProductos;
	}

	public void setMostrarnombre_linea_marcaProductosServiciosProductos(Boolean mostrarnombre_linea_marcaProductosServiciosProductos) {
		this.mostrarnombre_linea_marcaProductosServiciosProductos= mostrarnombre_linea_marcaProductosServiciosProductos;
	}

	public Boolean getActivarnombre_linea_marcaProductosServiciosProductos() {
		return this.activarnombre_linea_marcaProductosServiciosProductos;
	}

	public void setActivarnombre_linea_marcaProductosServiciosProductos(Boolean activarnombre_linea_marcaProductosServiciosProductos) {
		this.activarnombre_linea_marcaProductosServiciosProductos= activarnombre_linea_marcaProductosServiciosProductos;
	}

	public Border setResaltarcodigoProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarcodigoProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProductosServiciosProductos() {
		return this.resaltarcodigoProductosServiciosProductos;
	}

	public void setResaltarcodigoProductosServiciosProductos(Border borderResaltar) {
		this.resaltarcodigoProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarcodigoProductosServiciosProductos() {
		return this.mostrarcodigoProductosServiciosProductos;
	}

	public void setMostrarcodigoProductosServiciosProductos(Boolean mostrarcodigoProductosServiciosProductos) {
		this.mostrarcodigoProductosServiciosProductos= mostrarcodigoProductosServiciosProductos;
	}

	public Boolean getActivarcodigoProductosServiciosProductos() {
		return this.activarcodigoProductosServiciosProductos;
	}

	public void setActivarcodigoProductosServiciosProductos(Boolean activarcodigoProductosServiciosProductos) {
		this.activarcodigoProductosServiciosProductos= activarcodigoProductosServiciosProductos;
	}

	public Border setResaltarnombreProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombreProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProductosServiciosProductos() {
		return this.resaltarnombreProductosServiciosProductos;
	}

	public void setResaltarnombreProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombreProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombreProductosServiciosProductos() {
		return this.mostrarnombreProductosServiciosProductos;
	}

	public void setMostrarnombreProductosServiciosProductos(Boolean mostrarnombreProductosServiciosProductos) {
		this.mostrarnombreProductosServiciosProductos= mostrarnombreProductosServiciosProductos;
	}

	public Boolean getActivarnombreProductosServiciosProductos() {
		return this.activarnombreProductosServiciosProductos;
	}

	public void setActivarnombreProductosServiciosProductos(Boolean activarnombreProductosServiciosProductos) {
		this.activarnombreProductosServiciosProductos= activarnombreProductosServiciosProductos;
	}

	public Border setResaltarnombre_tipo_producto_servicioProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_producto_servicioProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_producto_servicioProductosServiciosProductos() {
		return this.resaltarnombre_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setResaltarnombre_tipo_producto_servicioProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_tipo_producto_servicioProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_producto_servicioProductosServiciosProductos() {
		return this.mostrarnombre_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setMostrarnombre_tipo_producto_servicioProductosServiciosProductos(Boolean mostrarnombre_tipo_producto_servicioProductosServiciosProductos) {
		this.mostrarnombre_tipo_producto_servicioProductosServiciosProductos= mostrarnombre_tipo_producto_servicioProductosServiciosProductos;
	}

	public Boolean getActivarnombre_tipo_producto_servicioProductosServiciosProductos() {
		return this.activarnombre_tipo_producto_servicioProductosServiciosProductos;
	}

	public void setActivarnombre_tipo_producto_servicioProductosServiciosProductos(Boolean activarnombre_tipo_producto_servicioProductosServiciosProductos) {
		this.activarnombre_tipo_producto_servicioProductosServiciosProductos= activarnombre_tipo_producto_servicioProductosServiciosProductos;
	}

	public Border setResaltarnombre_bodegaProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProductosServiciosProductos() {
		return this.resaltarnombre_bodegaProductosServiciosProductos;
	}

	public void setResaltarnombre_bodegaProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_bodegaProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProductosServiciosProductos() {
		return this.mostrarnombre_bodegaProductosServiciosProductos;
	}

	public void setMostrarnombre_bodegaProductosServiciosProductos(Boolean mostrarnombre_bodegaProductosServiciosProductos) {
		this.mostrarnombre_bodegaProductosServiciosProductos= mostrarnombre_bodegaProductosServiciosProductos;
	}

	public Boolean getActivarnombre_bodegaProductosServiciosProductos() {
		return this.activarnombre_bodegaProductosServiciosProductos;
	}

	public void setActivarnombre_bodegaProductosServiciosProductos(Boolean activarnombre_bodegaProductosServiciosProductos) {
		this.activarnombre_bodegaProductosServiciosProductos= activarnombre_bodegaProductosServiciosProductos;
	}

	public Border setResaltarnombre_unidadProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciosproductosBeanSwingJInternalFrame.jTtoolBarProductosServiciosProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosServiciosProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosServiciosProductos() {
		return this.resaltarnombre_unidadProductosServiciosProductos;
	}

	public void setResaltarnombre_unidadProductosServiciosProductos(Border borderResaltar) {
		this.resaltarnombre_unidadProductosServiciosProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosServiciosProductos() {
		return this.mostrarnombre_unidadProductosServiciosProductos;
	}

	public void setMostrarnombre_unidadProductosServiciosProductos(Boolean mostrarnombre_unidadProductosServiciosProductos) {
		this.mostrarnombre_unidadProductosServiciosProductos= mostrarnombre_unidadProductosServiciosProductos;
	}

	public Boolean getActivarnombre_unidadProductosServiciosProductos() {
		return this.activarnombre_unidadProductosServiciosProductos;
	}

	public void setActivarnombre_unidadProductosServiciosProductos(Boolean activarnombre_unidadProductosServiciosProductos) {
		this.activarnombre_unidadProductosServiciosProductos= activarnombre_unidadProductosServiciosProductos;
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
		
		
		this.setMostraridProductosServiciosProductos(esInicial);
		this.setMostrarid_empresaProductosServiciosProductos(esInicial);
		this.setMostrarid_sucursalProductosServiciosProductos(esInicial);
		this.setMostrarid_bodegaProductosServiciosProductos(esInicial);
		this.setMostrarid_lineaProductosServiciosProductos(esInicial);
		this.setMostrarid_linea_grupoProductosServiciosProductos(esInicial);
		this.setMostrarid_linea_categoriaProductosServiciosProductos(esInicial);
		this.setMostrarid_linea_marcaProductosServiciosProductos(esInicial);
		this.setMostrarid_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setMostrarnombre_sucursalProductosServiciosProductos(esInicial);
		this.setMostrarnombre_lineaProductosServiciosProductos(esInicial);
		this.setMostrarnombre_linea_grupoProductosServiciosProductos(esInicial);
		this.setMostrarnombre_linea_categoriaProductosServiciosProductos(esInicial);
		this.setMostrarnombre_linea_marcaProductosServiciosProductos(esInicial);
		this.setMostrarcodigoProductosServiciosProductos(esInicial);
		this.setMostrarnombreProductosServiciosProductos(esInicial);
		this.setMostrarnombre_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setMostrarnombre_bodegaProductosServiciosProductos(esInicial);
		this.setMostrarnombre_unidadProductosServiciosProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.ID)) {
				this.setMostraridProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setMostrarnombre_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosServiciosProductos(esAsigna);
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
		
		
		this.setActivaridProductosServiciosProductos(esInicial);
		this.setActivarid_empresaProductosServiciosProductos(esInicial);
		this.setActivarid_sucursalProductosServiciosProductos(esInicial);
		this.setActivarid_bodegaProductosServiciosProductos(esInicial);
		this.setActivarid_lineaProductosServiciosProductos(esInicial);
		this.setActivarid_linea_grupoProductosServiciosProductos(esInicial);
		this.setActivarid_linea_categoriaProductosServiciosProductos(esInicial);
		this.setActivarid_linea_marcaProductosServiciosProductos(esInicial);
		this.setActivarid_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setActivarnombre_sucursalProductosServiciosProductos(esInicial);
		this.setActivarnombre_lineaProductosServiciosProductos(esInicial);
		this.setActivarnombre_linea_grupoProductosServiciosProductos(esInicial);
		this.setActivarnombre_linea_categoriaProductosServiciosProductos(esInicial);
		this.setActivarnombre_linea_marcaProductosServiciosProductos(esInicial);
		this.setActivarcodigoProductosServiciosProductos(esInicial);
		this.setActivarnombreProductosServiciosProductos(esInicial);
		this.setActivarnombre_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setActivarnombre_bodegaProductosServiciosProductos(esInicial);
		this.setActivarnombre_unidadProductosServiciosProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.ID)) {
				this.setActivaridProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setActivarnombre_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosServiciosProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosServiciosProductos(esInicial);
		this.setResaltarid_empresaProductosServiciosProductos(esInicial);
		this.setResaltarid_sucursalProductosServiciosProductos(esInicial);
		this.setResaltarid_bodegaProductosServiciosProductos(esInicial);
		this.setResaltarid_lineaProductosServiciosProductos(esInicial);
		this.setResaltarid_linea_grupoProductosServiciosProductos(esInicial);
		this.setResaltarid_linea_categoriaProductosServiciosProductos(esInicial);
		this.setResaltarid_linea_marcaProductosServiciosProductos(esInicial);
		this.setResaltarid_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setResaltarnombre_sucursalProductosServiciosProductos(esInicial);
		this.setResaltarnombre_lineaProductosServiciosProductos(esInicial);
		this.setResaltarnombre_linea_grupoProductosServiciosProductos(esInicial);
		this.setResaltarnombre_linea_categoriaProductosServiciosProductos(esInicial);
		this.setResaltarnombre_linea_marcaProductosServiciosProductos(esInicial);
		this.setResaltarcodigoProductosServiciosProductos(esInicial);
		this.setResaltarnombreProductosServiciosProductos(esInicial);
		this.setResaltarnombre_tipo_producto_servicioProductosServiciosProductos(esInicial);
		this.setResaltarnombre_bodegaProductosServiciosProductos(esInicial);
		this.setResaltarnombre_unidadProductosServiciosProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.ID)) {
				this.setResaltaridProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBRETIPOPRODUCTOSERVICIO)) {
				this.setResaltarnombre_tipo_producto_servicioProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProductosServiciosProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosServiciosProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosServiciosProductosProductosServiciosProductos=true;

	public Boolean getMostrarBusquedaProductosServiciosProductosProductosServiciosProductos() {
		return this.mostrarBusquedaProductosServiciosProductosProductosServiciosProductos;
	}

	public void setMostrarBusquedaProductosServiciosProductosProductosServiciosProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosServiciosProductosProductosServiciosProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosServiciosProductosProductosServiciosProductos=true;

	public Boolean getActivarBusquedaProductosServiciosProductosProductosServiciosProductos() {
		return this.activarBusquedaProductosServiciosProductosProductosServiciosProductos;
	}

	public void setActivarBusquedaProductosServiciosProductosProductosServiciosProductos(Boolean habilitarResaltar) {
		this.activarBusquedaProductosServiciosProductosProductosServiciosProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosServiciosProductosProductosServiciosProductos=null;

	public Border getResaltarBusquedaProductosServiciosProductosProductosServiciosProductos() {
		return this.resaltarBusquedaProductosServiciosProductosProductosServiciosProductos;
	}

	public void setResaltarBusquedaProductosServiciosProductosProductosServiciosProductos(Border borderResaltar) {
		this.resaltarBusquedaProductosServiciosProductosProductosServiciosProductos= borderResaltar;
	}

	public void setResaltarBusquedaProductosServiciosProductosProductosServiciosProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosProductosBeanSwingJInternalFrame productosserviciosproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosServiciosProductosProductosServiciosProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}