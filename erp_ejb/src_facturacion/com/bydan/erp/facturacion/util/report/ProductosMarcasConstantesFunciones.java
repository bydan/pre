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


import com.bydan.erp.facturacion.util.report.ProductosMarcasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProductosMarcasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProductosMarcasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosMarcasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosMarcas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosMarcas"+ProductosMarcasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosMarcasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosMarcasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosMarcasConstantesFunciones.SCHEMA+"_"+ProductosMarcasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosMarcasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosMarcasConstantesFunciones.SCHEMA+"_"+ProductosMarcasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosMarcasConstantesFunciones.SCHEMA+"_"+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosMarcasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosMarcasConstantesFunciones.SCHEMA+"_"+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosMarcasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosMarcasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosMarcasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosMarcasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosMarcasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosMarcasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosMarcasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Marcases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Marcas";
	public static final String SCLASSWEBTITULO_LOWER="Productos Marcas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosMarcas";
	public static final String OBJECTNAME="productosmarcas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="productos_marcas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosmarcas from "+ProductosMarcasConstantesFunciones.SPERSISTENCENAME+" productosmarcas";
	public static String QUERYSELECTNATIVE="select "+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".id,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".version_row,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".id_empresa,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".id_producto,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_producto,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_linea,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".cantidad,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".monto,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".codigo_producto,"+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME+".tipo from "+ProductosMarcasConstantesFunciones.SCHEMA+"."+ProductosMarcasConstantesFunciones.TABLENAME;//+" as "+ProductosMarcasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CANTIDAD= "cantidad";
    public static final String MONTO= "monto";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBRELINEAGRUPO= "Nombre Linea Grupo";
		public static final String LABEL_NOMBRELINEAGRUPO_LOWER= "Nombre Linea Grupo";
    	public static final String LABEL_NOMBRELINEACATEGORIA= "Nombre Linea Categoria";
		public static final String LABEL_NOMBRELINEACATEGORIA_LOWER= "Nombre Linea Categoria";
    	public static final String LABEL_NOMBRELINEAMARCA= "Nombre Linea Marca";
		public static final String LABEL_NOMBRELINEAMARCA_LOWER= "Nombre Linea Marca";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductosMarcasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.CANTIDAD)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.MONTO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ProductosMarcasConstantesFunciones.TIPO)) {sLabelColumna=ProductosMarcasConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosMarcasDescripcion(ProductosMarcas productosmarcas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosmarcas !=null/* && productosmarcas.getId()!=0*/) {
			if(productosmarcas.getId()!=null) {
				sDescripcion=productosmarcas.getId().toString();
			}//productosmarcasproductosmarcas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosMarcasDescripcionDetallado(ProductosMarcas productosmarcas) {
		String sDescripcion="";
			
		sDescripcion+=ProductosMarcasConstantesFunciones.ID+"=";
		sDescripcion+=productosmarcas.getId().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosmarcas.getVersionRow().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosmarcas.getid_empresa().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosmarcas.getid_sucursal().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=productosmarcas.getid_producto().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=productosmarcas.getfecha_emision_desde().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=productosmarcas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosmarcas.getnombre_unidad()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=productosmarcas.getnombre_producto()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=productosmarcas.getnombre_linea()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=productosmarcas.getnombre_linea_grupo()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=productosmarcas.getnombre_linea_categoria()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=productosmarcas.getnombre_linea_marca()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=productosmarcas.getcantidad().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.MONTO+"=";
		sDescripcion+=productosmarcas.getmonto().toString()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=productosmarcas.getcodigo_producto()+",";
		sDescripcion+=ProductosMarcasConstantesFunciones.TIPO+"=";
		sDescripcion+=productosmarcas.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosMarcasDescripcion(ProductosMarcas productosmarcas,String sValor) throws Exception {			
		if(productosmarcas !=null) {
			//productosmarcasproductosmarcas.getId().toString();
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

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProductosMarcas")) {
			sNombreIndice="Tipo=  Por Producto Por Fecha Emision Desde Por Fecha Emision Hasta";
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

	public static String getDetalleIndiceBusquedaProductosMarcas(Long id_producto,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductosMarcas(ProductosMarcas productosmarcas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosmarcas.setnombre_unidad(productosmarcas.getnombre_unidad().trim());
		productosmarcas.setnombre_producto(productosmarcas.getnombre_producto().trim());
		productosmarcas.setnombre_linea(productosmarcas.getnombre_linea().trim());
		productosmarcas.setnombre_linea_grupo(productosmarcas.getnombre_linea_grupo().trim());
		productosmarcas.setnombre_linea_categoria(productosmarcas.getnombre_linea_categoria().trim());
		productosmarcas.setnombre_linea_marca(productosmarcas.getnombre_linea_marca().trim());
		productosmarcas.setcodigo_producto(productosmarcas.getcodigo_producto().trim());
		productosmarcas.settipo(productosmarcas.gettipo().trim());
	}
	
	public static void quitarEspaciosProductosMarcass(List<ProductosMarcas> productosmarcass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosMarcas productosmarcas: productosmarcass) {
			productosmarcas.setnombre_unidad(productosmarcas.getnombre_unidad().trim());
			productosmarcas.setnombre_producto(productosmarcas.getnombre_producto().trim());
			productosmarcas.setnombre_linea(productosmarcas.getnombre_linea().trim());
			productosmarcas.setnombre_linea_grupo(productosmarcas.getnombre_linea_grupo().trim());
			productosmarcas.setnombre_linea_categoria(productosmarcas.getnombre_linea_categoria().trim());
			productosmarcas.setnombre_linea_marca(productosmarcas.getnombre_linea_marca().trim());
			productosmarcas.setcodigo_producto(productosmarcas.getcodigo_producto().trim());
			productosmarcas.settipo(productosmarcas.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosMarcas(ProductosMarcas productosmarcas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosmarcas.getConCambioAuxiliar()) {
			productosmarcas.setIsDeleted(productosmarcas.getIsDeletedAuxiliar());	
			productosmarcas.setIsNew(productosmarcas.getIsNewAuxiliar());	
			productosmarcas.setIsChanged(productosmarcas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosmarcas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosmarcas.setIsDeletedAuxiliar(false);	
			productosmarcas.setIsNewAuxiliar(false);	
			productosmarcas.setIsChangedAuxiliar(false);
			
			productosmarcas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosMarcass(List<ProductosMarcas> productosmarcass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosMarcas productosmarcas : productosmarcass) {
			if(conAsignarBase && productosmarcas.getConCambioAuxiliar()) {
				productosmarcas.setIsDeleted(productosmarcas.getIsDeletedAuxiliar());	
				productosmarcas.setIsNew(productosmarcas.getIsNewAuxiliar());	
				productosmarcas.setIsChanged(productosmarcas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosmarcas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosmarcas.setIsDeletedAuxiliar(false);	
				productosmarcas.setIsNewAuxiliar(false);	
				productosmarcas.setIsChangedAuxiliar(false);
				
				productosmarcas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosMarcas(ProductosMarcas productosmarcas,Boolean conEnteros) throws Exception  {
		productosmarcas.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			productosmarcas.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresProductosMarcass(List<ProductosMarcas> productosmarcass,Boolean conEnteros) throws Exception  {
		
		for(ProductosMarcas productosmarcas: productosmarcass) {
			productosmarcas.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				productosmarcas.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosMarcas(List<ProductosMarcas> productosmarcass,ProductosMarcas productosmarcasAux) throws Exception  {
		ProductosMarcasConstantesFunciones.InicializarValoresProductosMarcas(productosmarcasAux,true);
		
		for(ProductosMarcas productosmarcas: productosmarcass) {
			if(productosmarcas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosmarcasAux.setcantidad(productosmarcasAux.getcantidad()+productosmarcas.getcantidad());			
			productosmarcasAux.setmonto(productosmarcasAux.getmonto()+productosmarcas.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosMarcas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosMarcasConstantesFunciones.getArrayColumnasGlobalesProductosMarcas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosMarcas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosMarcasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosMarcasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosMarcasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosMarcasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosMarcas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosMarcas> productosmarcass,ProductosMarcas productosmarcas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosMarcas productosmarcasAux: productosmarcass) {
			if(productosmarcasAux!=null && productosmarcas!=null) {
				if((productosmarcasAux.getId()==null && productosmarcas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosmarcasAux.getId()!=null && productosmarcas.getId()!=null){
					if(productosmarcasAux.getId().equals(productosmarcas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosMarcas(List<ProductosMarcas> productosmarcass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
	
		for(ProductosMarcas productosmarcas: productosmarcass) {			
			if(productosmarcas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=productosmarcas.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosMarcasConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosMarcas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_ID, ProductosMarcasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_VERSIONROW, ProductosMarcasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosMarcasConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBREPRODUCTO, ProductosMarcasConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEA, ProductosMarcasConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAMARCA, ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_CANTIDAD, ProductosMarcasConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_MONTO, ProductosMarcasConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_CODIGOPRODUCTO, ProductosMarcasConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosMarcasConstantesFunciones.LABEL_TIPO, ProductosMarcasConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosMarcas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosMarcasConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosMarcas() throws Exception  {
		return ProductosMarcasConstantesFunciones.getTiposSeleccionarProductosMarcas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosMarcas(Boolean conFk) throws Exception  {
		return ProductosMarcasConstantesFunciones.getTiposSeleccionarProductosMarcas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosMarcas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosMarcasConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(ProductosMarcasConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosMarcas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosMarcas(ProductosMarcas productosmarcasAux) throws Exception {
		
			productosmarcasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosmarcasAux.getEmpresa()));
			productosmarcasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosmarcasAux.getSucursal()));
			productosmarcasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosmarcasAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosMarcas(List<ProductosMarcas> productosmarcassTemp) throws Exception {
		for(ProductosMarcas productosmarcasAux:productosmarcassTemp) {
			
			productosmarcasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosmarcasAux.getEmpresa()));
			productosmarcasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosmarcasAux.getSucursal()));
			productosmarcasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(productosmarcasAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosMarcas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosMarcas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosMarcas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosMarcasConstantesFunciones.getClassesRelationshipsOfProductosMarcas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosMarcas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosMarcas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosMarcasConstantesFunciones.getClassesRelationshipsFromStringsOfProductosMarcas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosMarcas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosMarcas productosmarcas,List<ProductosMarcas> productosmarcass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosMarcas productosmarcas,List<ProductosMarcas> productosmarcass) throws Exception {
		try	{			
			for(ProductosMarcas productosmarcasLocal:productosmarcass) {
				if(productosmarcasLocal.getId().equals(productosmarcas.getId())) {
					productosmarcasLocal.setIsSelected(productosmarcas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosMarcas(List<ProductosMarcas> productosmarcassAux) throws Exception {
		//this.productosmarcassAux=productosmarcassAux;
		
		for(ProductosMarcas productosmarcasAux:productosmarcassAux) {
			if(productosmarcasAux.getIsChanged()) {
				productosmarcasAux.setIsChanged(false);
			}		
			
			if(productosmarcasAux.getIsNew()) {
				productosmarcasAux.setIsNew(false);
			}	
			
			if(productosmarcasAux.getIsDeleted()) {
				productosmarcasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosMarcas(ProductosMarcas productosmarcasAux) throws Exception {
		//this.productosmarcasAux=productosmarcasAux;
		
			if(productosmarcasAux.getIsChanged()) {
				productosmarcasAux.setIsChanged(false);
			}		
			
			if(productosmarcasAux.getIsNew()) {
				productosmarcasAux.setIsNew(false);
			}	
			
			if(productosmarcasAux.getIsDeleted()) {
				productosmarcasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosMarcas productosmarcasAsignar,ProductosMarcas productosmarcas) throws Exception {
		productosmarcasAsignar.setId(productosmarcas.getId());	
		productosmarcasAsignar.setVersionRow(productosmarcas.getVersionRow());	
		productosmarcasAsignar.setnombre_unidad(productosmarcas.getnombre_unidad());	
		productosmarcasAsignar.setnombre_producto(productosmarcas.getnombre_producto());	
		productosmarcasAsignar.setnombre_linea(productosmarcas.getnombre_linea());	
		productosmarcasAsignar.setnombre_linea_grupo(productosmarcas.getnombre_linea_grupo());	
		productosmarcasAsignar.setnombre_linea_categoria(productosmarcas.getnombre_linea_categoria());	
		productosmarcasAsignar.setnombre_linea_marca(productosmarcas.getnombre_linea_marca());	
		productosmarcasAsignar.setcantidad(productosmarcas.getcantidad());	
		productosmarcasAsignar.setmonto(productosmarcas.getmonto());	
		productosmarcasAsignar.setcodigo_producto(productosmarcas.getcodigo_producto());	
		productosmarcasAsignar.settipo(productosmarcas.gettipo());	
	}
	
	public static void inicializarProductosMarcas(ProductosMarcas productosmarcas) throws Exception {
		try {
				productosmarcas.setId(0L);	
					
				productosmarcas.setnombre_unidad("");	
				productosmarcas.setnombre_producto("");	
				productosmarcas.setnombre_linea("");	
				productosmarcas.setnombre_linea_grupo("");	
				productosmarcas.setnombre_linea_categoria("");	
				productosmarcas.setnombre_linea_marca("");	
				productosmarcas.setcantidad(0);	
				productosmarcas.setmonto(0.0);	
				productosmarcas.setcodigo_producto("");	
				productosmarcas.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosMarcas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosMarcasConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosMarcas(String sTipo,Row row,Workbook workbook,ProductosMarcas productosmarcas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosmarcas.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosMarcas="";
	
	public String getsFinalQueryProductosMarcas() {
		return this.sFinalQueryProductosMarcas;
	}
	
	public void setsFinalQueryProductosMarcas(String sFinalQueryProductosMarcas) {
		this.sFinalQueryProductosMarcas= sFinalQueryProductosMarcas;
	}
	
	public Border resaltarSeleccionarProductosMarcas=null;
	
	public Border setResaltarSeleccionarProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosMarcas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosMarcas() {
		return this.resaltarSeleccionarProductosMarcas;
	}
	
	public void setResaltarSeleccionarProductosMarcas(Border borderResaltarSeleccionarProductosMarcas) {
		this.resaltarSeleccionarProductosMarcas= borderResaltarSeleccionarProductosMarcas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosMarcas=null;
	public Boolean mostraridProductosMarcas=true;
	public Boolean activaridProductosMarcas=true;

	public Border resaltarid_empresaProductosMarcas=null;
	public Boolean mostrarid_empresaProductosMarcas=true;
	public Boolean activarid_empresaProductosMarcas=true;
	public Boolean cargarid_empresaProductosMarcas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosMarcas=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosMarcas=null;
	public Boolean mostrarid_sucursalProductosMarcas=true;
	public Boolean activarid_sucursalProductosMarcas=true;
	public Boolean cargarid_sucursalProductosMarcas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosMarcas=false;//ConEventDepend=true

	public Border resaltarid_productoProductosMarcas=null;
	public Boolean mostrarid_productoProductosMarcas=true;
	public Boolean activarid_productoProductosMarcas=true;
	public Boolean cargarid_productoProductosMarcas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProductosMarcas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeProductosMarcas=null;
	public Boolean mostrarfecha_emision_desdeProductosMarcas=true;
	public Boolean activarfecha_emision_desdeProductosMarcas=true;

	public Border resaltarfecha_emision_hastaProductosMarcas=null;
	public Boolean mostrarfecha_emision_hastaProductosMarcas=true;
	public Boolean activarfecha_emision_hastaProductosMarcas=true;

	public Border resaltarnombre_unidadProductosMarcas=null;
	public Boolean mostrarnombre_unidadProductosMarcas=true;
	public Boolean activarnombre_unidadProductosMarcas=true;

	public Border resaltarnombre_productoProductosMarcas=null;
	public Boolean mostrarnombre_productoProductosMarcas=true;
	public Boolean activarnombre_productoProductosMarcas=true;

	public Border resaltarnombre_lineaProductosMarcas=null;
	public Boolean mostrarnombre_lineaProductosMarcas=true;
	public Boolean activarnombre_lineaProductosMarcas=true;

	public Border resaltarnombre_linea_grupoProductosMarcas=null;
	public Boolean mostrarnombre_linea_grupoProductosMarcas=true;
	public Boolean activarnombre_linea_grupoProductosMarcas=true;

	public Border resaltarnombre_linea_categoriaProductosMarcas=null;
	public Boolean mostrarnombre_linea_categoriaProductosMarcas=true;
	public Boolean activarnombre_linea_categoriaProductosMarcas=true;

	public Border resaltarnombre_linea_marcaProductosMarcas=null;
	public Boolean mostrarnombre_linea_marcaProductosMarcas=true;
	public Boolean activarnombre_linea_marcaProductosMarcas=true;

	public Border resaltarcantidadProductosMarcas=null;
	public Boolean mostrarcantidadProductosMarcas=true;
	public Boolean activarcantidadProductosMarcas=true;

	public Border resaltarmontoProductosMarcas=null;
	public Boolean mostrarmontoProductosMarcas=true;
	public Boolean activarmontoProductosMarcas=true;

	public Border resaltarcodigo_productoProductosMarcas=null;
	public Boolean mostrarcodigo_productoProductosMarcas=true;
	public Boolean activarcodigo_productoProductosMarcas=true;

	public Border resaltartipoProductosMarcas=null;
	public Boolean mostrartipoProductosMarcas=true;
	public Boolean activartipoProductosMarcas=true;

	
	

	public Border setResaltaridProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltaridProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosMarcas() {
		return this.resaltaridProductosMarcas;
	}

	public void setResaltaridProductosMarcas(Border borderResaltar) {
		this.resaltaridProductosMarcas= borderResaltar;
	}

	public Boolean getMostraridProductosMarcas() {
		return this.mostraridProductosMarcas;
	}

	public void setMostraridProductosMarcas(Boolean mostraridProductosMarcas) {
		this.mostraridProductosMarcas= mostraridProductosMarcas;
	}

	public Boolean getActivaridProductosMarcas() {
		return this.activaridProductosMarcas;
	}

	public void setActivaridProductosMarcas(Boolean activaridProductosMarcas) {
		this.activaridProductosMarcas= activaridProductosMarcas;
	}

	public Border setResaltarid_empresaProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosMarcas() {
		return this.resaltarid_empresaProductosMarcas;
	}

	public void setResaltarid_empresaProductosMarcas(Border borderResaltar) {
		this.resaltarid_empresaProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosMarcas() {
		return this.mostrarid_empresaProductosMarcas;
	}

	public void setMostrarid_empresaProductosMarcas(Boolean mostrarid_empresaProductosMarcas) {
		this.mostrarid_empresaProductosMarcas= mostrarid_empresaProductosMarcas;
	}

	public Boolean getActivarid_empresaProductosMarcas() {
		return this.activarid_empresaProductosMarcas;
	}

	public void setActivarid_empresaProductosMarcas(Boolean activarid_empresaProductosMarcas) {
		this.activarid_empresaProductosMarcas= activarid_empresaProductosMarcas;
	}

	public Boolean getCargarid_empresaProductosMarcas() {
		return this.cargarid_empresaProductosMarcas;
	}

	public void setCargarid_empresaProductosMarcas(Boolean cargarid_empresaProductosMarcas) {
		this.cargarid_empresaProductosMarcas= cargarid_empresaProductosMarcas;
	}

	public Border setResaltarid_sucursalProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosMarcas() {
		return this.resaltarid_sucursalProductosMarcas;
	}

	public void setResaltarid_sucursalProductosMarcas(Border borderResaltar) {
		this.resaltarid_sucursalProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosMarcas() {
		return this.mostrarid_sucursalProductosMarcas;
	}

	public void setMostrarid_sucursalProductosMarcas(Boolean mostrarid_sucursalProductosMarcas) {
		this.mostrarid_sucursalProductosMarcas= mostrarid_sucursalProductosMarcas;
	}

	public Boolean getActivarid_sucursalProductosMarcas() {
		return this.activarid_sucursalProductosMarcas;
	}

	public void setActivarid_sucursalProductosMarcas(Boolean activarid_sucursalProductosMarcas) {
		this.activarid_sucursalProductosMarcas= activarid_sucursalProductosMarcas;
	}

	public Boolean getCargarid_sucursalProductosMarcas() {
		return this.cargarid_sucursalProductosMarcas;
	}

	public void setCargarid_sucursalProductosMarcas(Boolean cargarid_sucursalProductosMarcas) {
		this.cargarid_sucursalProductosMarcas= cargarid_sucursalProductosMarcas;
	}

	public Border setResaltarid_productoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarid_productoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProductosMarcas() {
		return this.resaltarid_productoProductosMarcas;
	}

	public void setResaltarid_productoProductosMarcas(Border borderResaltar) {
		this.resaltarid_productoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarid_productoProductosMarcas() {
		return this.mostrarid_productoProductosMarcas;
	}

	public void setMostrarid_productoProductosMarcas(Boolean mostrarid_productoProductosMarcas) {
		this.mostrarid_productoProductosMarcas= mostrarid_productoProductosMarcas;
	}

	public Boolean getActivarid_productoProductosMarcas() {
		return this.activarid_productoProductosMarcas;
	}

	public void setActivarid_productoProductosMarcas(Boolean activarid_productoProductosMarcas) {
		this.activarid_productoProductosMarcas= activarid_productoProductosMarcas;
	}

	public Boolean getCargarid_productoProductosMarcas() {
		return this.cargarid_productoProductosMarcas;
	}

	public void setCargarid_productoProductosMarcas(Boolean cargarid_productoProductosMarcas) {
		this.cargarid_productoProductosMarcas= cargarid_productoProductosMarcas;
	}

	public Border setResaltarfecha_emision_desdeProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeProductosMarcas() {
		return this.resaltarfecha_emision_desdeProductosMarcas;
	}

	public void setResaltarfecha_emision_desdeProductosMarcas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeProductosMarcas() {
		return this.mostrarfecha_emision_desdeProductosMarcas;
	}

	public void setMostrarfecha_emision_desdeProductosMarcas(Boolean mostrarfecha_emision_desdeProductosMarcas) {
		this.mostrarfecha_emision_desdeProductosMarcas= mostrarfecha_emision_desdeProductosMarcas;
	}

	public Boolean getActivarfecha_emision_desdeProductosMarcas() {
		return this.activarfecha_emision_desdeProductosMarcas;
	}

	public void setActivarfecha_emision_desdeProductosMarcas(Boolean activarfecha_emision_desdeProductosMarcas) {
		this.activarfecha_emision_desdeProductosMarcas= activarfecha_emision_desdeProductosMarcas;
	}

	public Border setResaltarfecha_emision_hastaProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaProductosMarcas() {
		return this.resaltarfecha_emision_hastaProductosMarcas;
	}

	public void setResaltarfecha_emision_hastaProductosMarcas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaProductosMarcas() {
		return this.mostrarfecha_emision_hastaProductosMarcas;
	}

	public void setMostrarfecha_emision_hastaProductosMarcas(Boolean mostrarfecha_emision_hastaProductosMarcas) {
		this.mostrarfecha_emision_hastaProductosMarcas= mostrarfecha_emision_hastaProductosMarcas;
	}

	public Boolean getActivarfecha_emision_hastaProductosMarcas() {
		return this.activarfecha_emision_hastaProductosMarcas;
	}

	public void setActivarfecha_emision_hastaProductosMarcas(Boolean activarfecha_emision_hastaProductosMarcas) {
		this.activarfecha_emision_hastaProductosMarcas= activarfecha_emision_hastaProductosMarcas;
	}

	public Border setResaltarnombre_unidadProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosMarcas() {
		return this.resaltarnombre_unidadProductosMarcas;
	}

	public void setResaltarnombre_unidadProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_unidadProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosMarcas() {
		return this.mostrarnombre_unidadProductosMarcas;
	}

	public void setMostrarnombre_unidadProductosMarcas(Boolean mostrarnombre_unidadProductosMarcas) {
		this.mostrarnombre_unidadProductosMarcas= mostrarnombre_unidadProductosMarcas;
	}

	public Boolean getActivarnombre_unidadProductosMarcas() {
		return this.activarnombre_unidadProductosMarcas;
	}

	public void setActivarnombre_unidadProductosMarcas(Boolean activarnombre_unidadProductosMarcas) {
		this.activarnombre_unidadProductosMarcas= activarnombre_unidadProductosMarcas;
	}

	public Border setResaltarnombre_productoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProductosMarcas() {
		return this.resaltarnombre_productoProductosMarcas;
	}

	public void setResaltarnombre_productoProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_productoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProductosMarcas() {
		return this.mostrarnombre_productoProductosMarcas;
	}

	public void setMostrarnombre_productoProductosMarcas(Boolean mostrarnombre_productoProductosMarcas) {
		this.mostrarnombre_productoProductosMarcas= mostrarnombre_productoProductosMarcas;
	}

	public Boolean getActivarnombre_productoProductosMarcas() {
		return this.activarnombre_productoProductosMarcas;
	}

	public void setActivarnombre_productoProductosMarcas(Boolean activarnombre_productoProductosMarcas) {
		this.activarnombre_productoProductosMarcas= activarnombre_productoProductosMarcas;
	}

	public Border setResaltarnombre_lineaProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaProductosMarcas() {
		return this.resaltarnombre_lineaProductosMarcas;
	}

	public void setResaltarnombre_lineaProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_lineaProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaProductosMarcas() {
		return this.mostrarnombre_lineaProductosMarcas;
	}

	public void setMostrarnombre_lineaProductosMarcas(Boolean mostrarnombre_lineaProductosMarcas) {
		this.mostrarnombre_lineaProductosMarcas= mostrarnombre_lineaProductosMarcas;
	}

	public Boolean getActivarnombre_lineaProductosMarcas() {
		return this.activarnombre_lineaProductosMarcas;
	}

	public void setActivarnombre_lineaProductosMarcas(Boolean activarnombre_lineaProductosMarcas) {
		this.activarnombre_lineaProductosMarcas= activarnombre_lineaProductosMarcas;
	}

	public Border setResaltarnombre_linea_grupoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoProductosMarcas() {
		return this.resaltarnombre_linea_grupoProductosMarcas;
	}

	public void setResaltarnombre_linea_grupoProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_linea_grupoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoProductosMarcas() {
		return this.mostrarnombre_linea_grupoProductosMarcas;
	}

	public void setMostrarnombre_linea_grupoProductosMarcas(Boolean mostrarnombre_linea_grupoProductosMarcas) {
		this.mostrarnombre_linea_grupoProductosMarcas= mostrarnombre_linea_grupoProductosMarcas;
	}

	public Boolean getActivarnombre_linea_grupoProductosMarcas() {
		return this.activarnombre_linea_grupoProductosMarcas;
	}

	public void setActivarnombre_linea_grupoProductosMarcas(Boolean activarnombre_linea_grupoProductosMarcas) {
		this.activarnombre_linea_grupoProductosMarcas= activarnombre_linea_grupoProductosMarcas;
	}

	public Border setResaltarnombre_linea_categoriaProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaProductosMarcas() {
		return this.resaltarnombre_linea_categoriaProductosMarcas;
	}

	public void setResaltarnombre_linea_categoriaProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaProductosMarcas() {
		return this.mostrarnombre_linea_categoriaProductosMarcas;
	}

	public void setMostrarnombre_linea_categoriaProductosMarcas(Boolean mostrarnombre_linea_categoriaProductosMarcas) {
		this.mostrarnombre_linea_categoriaProductosMarcas= mostrarnombre_linea_categoriaProductosMarcas;
	}

	public Boolean getActivarnombre_linea_categoriaProductosMarcas() {
		return this.activarnombre_linea_categoriaProductosMarcas;
	}

	public void setActivarnombre_linea_categoriaProductosMarcas(Boolean activarnombre_linea_categoriaProductosMarcas) {
		this.activarnombre_linea_categoriaProductosMarcas= activarnombre_linea_categoriaProductosMarcas;
	}

	public Border setResaltarnombre_linea_marcaProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaProductosMarcas() {
		return this.resaltarnombre_linea_marcaProductosMarcas;
	}

	public void setResaltarnombre_linea_marcaProductosMarcas(Border borderResaltar) {
		this.resaltarnombre_linea_marcaProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaProductosMarcas() {
		return this.mostrarnombre_linea_marcaProductosMarcas;
	}

	public void setMostrarnombre_linea_marcaProductosMarcas(Boolean mostrarnombre_linea_marcaProductosMarcas) {
		this.mostrarnombre_linea_marcaProductosMarcas= mostrarnombre_linea_marcaProductosMarcas;
	}

	public Boolean getActivarnombre_linea_marcaProductosMarcas() {
		return this.activarnombre_linea_marcaProductosMarcas;
	}

	public void setActivarnombre_linea_marcaProductosMarcas(Boolean activarnombre_linea_marcaProductosMarcas) {
		this.activarnombre_linea_marcaProductosMarcas= activarnombre_linea_marcaProductosMarcas;
	}

	public Border setResaltarcantidadProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarcantidadProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadProductosMarcas() {
		return this.resaltarcantidadProductosMarcas;
	}

	public void setResaltarcantidadProductosMarcas(Border borderResaltar) {
		this.resaltarcantidadProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarcantidadProductosMarcas() {
		return this.mostrarcantidadProductosMarcas;
	}

	public void setMostrarcantidadProductosMarcas(Boolean mostrarcantidadProductosMarcas) {
		this.mostrarcantidadProductosMarcas= mostrarcantidadProductosMarcas;
	}

	public Boolean getActivarcantidadProductosMarcas() {
		return this.activarcantidadProductosMarcas;
	}

	public void setActivarcantidadProductosMarcas(Boolean activarcantidadProductosMarcas) {
		this.activarcantidadProductosMarcas= activarcantidadProductosMarcas;
	}

	public Border setResaltarmontoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarmontoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoProductosMarcas() {
		return this.resaltarmontoProductosMarcas;
	}

	public void setResaltarmontoProductosMarcas(Border borderResaltar) {
		this.resaltarmontoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarmontoProductosMarcas() {
		return this.mostrarmontoProductosMarcas;
	}

	public void setMostrarmontoProductosMarcas(Boolean mostrarmontoProductosMarcas) {
		this.mostrarmontoProductosMarcas= mostrarmontoProductosMarcas;
	}

	public Boolean getActivarmontoProductosMarcas() {
		return this.activarmontoProductosMarcas;
	}

	public void setActivarmontoProductosMarcas(Boolean activarmontoProductosMarcas) {
		this.activarmontoProductosMarcas= activarmontoProductosMarcas;
	}

	public Border setResaltarcodigo_productoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProductosMarcas() {
		return this.resaltarcodigo_productoProductosMarcas;
	}

	public void setResaltarcodigo_productoProductosMarcas(Border borderResaltar) {
		this.resaltarcodigo_productoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProductosMarcas() {
		return this.mostrarcodigo_productoProductosMarcas;
	}

	public void setMostrarcodigo_productoProductosMarcas(Boolean mostrarcodigo_productoProductosMarcas) {
		this.mostrarcodigo_productoProductosMarcas= mostrarcodigo_productoProductosMarcas;
	}

	public Boolean getActivarcodigo_productoProductosMarcas() {
		return this.activarcodigo_productoProductosMarcas;
	}

	public void setActivarcodigo_productoProductosMarcas(Boolean activarcodigo_productoProductosMarcas) {
		this.activarcodigo_productoProductosMarcas= activarcodigo_productoProductosMarcas;
	}

	public Border setResaltartipoProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosmarcasBeanSwingJInternalFrame.jTtoolBarProductosMarcas.setBorder(borderResaltar);
		
		this.resaltartipoProductosMarcas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoProductosMarcas() {
		return this.resaltartipoProductosMarcas;
	}

	public void setResaltartipoProductosMarcas(Border borderResaltar) {
		this.resaltartipoProductosMarcas= borderResaltar;
	}

	public Boolean getMostrartipoProductosMarcas() {
		return this.mostrartipoProductosMarcas;
	}

	public void setMostrartipoProductosMarcas(Boolean mostrartipoProductosMarcas) {
		this.mostrartipoProductosMarcas= mostrartipoProductosMarcas;
	}

	public Boolean getActivartipoProductosMarcas() {
		return this.activartipoProductosMarcas;
	}

	public void setActivartipoProductosMarcas(Boolean activartipoProductosMarcas) {
		this.activartipoProductosMarcas= activartipoProductosMarcas;
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
		
		
		this.setMostraridProductosMarcas(esInicial);
		this.setMostrarid_empresaProductosMarcas(esInicial);
		this.setMostrarid_sucursalProductosMarcas(esInicial);
		this.setMostrarid_productoProductosMarcas(esInicial);
		this.setMostrarfecha_emision_desdeProductosMarcas(esInicial);
		this.setMostrarfecha_emision_hastaProductosMarcas(esInicial);
		this.setMostrarnombre_unidadProductosMarcas(esInicial);
		this.setMostrarnombre_productoProductosMarcas(esInicial);
		this.setMostrarnombre_lineaProductosMarcas(esInicial);
		this.setMostrarnombre_linea_grupoProductosMarcas(esInicial);
		this.setMostrarnombre_linea_categoriaProductosMarcas(esInicial);
		this.setMostrarnombre_linea_marcaProductosMarcas(esInicial);
		this.setMostrarcantidadProductosMarcas(esInicial);
		this.setMostrarmontoProductosMarcas(esInicial);
		this.setMostrarcodigo_productoProductosMarcas(esInicial);
		this.setMostrartipoProductosMarcas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.ID)) {
				this.setMostraridProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.MONTO)) {
				this.setMostrarmontoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.TIPO)) {
				this.setMostrartipoProductosMarcas(esAsigna);
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
		
		
		this.setActivaridProductosMarcas(esInicial);
		this.setActivarid_empresaProductosMarcas(esInicial);
		this.setActivarid_sucursalProductosMarcas(esInicial);
		this.setActivarid_productoProductosMarcas(esInicial);
		this.setActivarfecha_emision_desdeProductosMarcas(esInicial);
		this.setActivarfecha_emision_hastaProductosMarcas(esInicial);
		this.setActivarnombre_unidadProductosMarcas(esInicial);
		this.setActivarnombre_productoProductosMarcas(esInicial);
		this.setActivarnombre_lineaProductosMarcas(esInicial);
		this.setActivarnombre_linea_grupoProductosMarcas(esInicial);
		this.setActivarnombre_linea_categoriaProductosMarcas(esInicial);
		this.setActivarnombre_linea_marcaProductosMarcas(esInicial);
		this.setActivarcantidadProductosMarcas(esInicial);
		this.setActivarmontoProductosMarcas(esInicial);
		this.setActivarcodigo_productoProductosMarcas(esInicial);
		this.setActivartipoProductosMarcas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.ID)) {
				this.setActivaridProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.MONTO)) {
				this.setActivarmontoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.TIPO)) {
				this.setActivartipoProductosMarcas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosMarcas(esInicial);
		this.setResaltarid_empresaProductosMarcas(esInicial);
		this.setResaltarid_sucursalProductosMarcas(esInicial);
		this.setResaltarid_productoProductosMarcas(esInicial);
		this.setResaltarfecha_emision_desdeProductosMarcas(esInicial);
		this.setResaltarfecha_emision_hastaProductosMarcas(esInicial);
		this.setResaltarnombre_unidadProductosMarcas(esInicial);
		this.setResaltarnombre_productoProductosMarcas(esInicial);
		this.setResaltarnombre_lineaProductosMarcas(esInicial);
		this.setResaltarnombre_linea_grupoProductosMarcas(esInicial);
		this.setResaltarnombre_linea_categoriaProductosMarcas(esInicial);
		this.setResaltarnombre_linea_marcaProductosMarcas(esInicial);
		this.setResaltarcantidadProductosMarcas(esInicial);
		this.setResaltarmontoProductosMarcas(esInicial);
		this.setResaltarcodigo_productoProductosMarcas(esInicial);
		this.setResaltartipoProductosMarcas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.ID)) {
				this.setResaltaridProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.MONTO)) {
				this.setResaltarmontoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProductosMarcas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosMarcasConstantesFunciones.TIPO)) {
				this.setResaltartipoProductosMarcas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosMarcasProductosMarcas=true;

	public Boolean getMostrarBusquedaProductosMarcasProductosMarcas() {
		return this.mostrarBusquedaProductosMarcasProductosMarcas;
	}

	public void setMostrarBusquedaProductosMarcasProductosMarcas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosMarcasProductosMarcas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosMarcasProductosMarcas=true;

	public Boolean getActivarBusquedaProductosMarcasProductosMarcas() {
		return this.activarBusquedaProductosMarcasProductosMarcas;
	}

	public void setActivarBusquedaProductosMarcasProductosMarcas(Boolean habilitarResaltar) {
		this.activarBusquedaProductosMarcasProductosMarcas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosMarcasProductosMarcas=null;

	public Border getResaltarBusquedaProductosMarcasProductosMarcas() {
		return this.resaltarBusquedaProductosMarcasProductosMarcas;
	}

	public void setResaltarBusquedaProductosMarcasProductosMarcas(Border borderResaltar) {
		this.resaltarBusquedaProductosMarcasProductosMarcas= borderResaltar;
	}

	public void setResaltarBusquedaProductosMarcasProductosMarcas(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosMarcasBeanSwingJInternalFrame productosmarcasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosMarcasProductosMarcas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}