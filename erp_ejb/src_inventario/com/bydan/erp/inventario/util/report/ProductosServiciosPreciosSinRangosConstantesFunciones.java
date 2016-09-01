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


import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductosServiciosPreciosSinRangosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProductosServiciosPreciosSinRangos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProductosServiciosPreciosSinRangos"+ProductosServiciosPreciosSinRangosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductosServiciosPreciosSinRangosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductosServiciosPreciosSinRangosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"_"+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosPreciosSinRangosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"_"+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"_"+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductosServiciosPreciosSinRangosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"_"+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosPreciosSinRangosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductosServiciosPreciosSinRangosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductosServiciosPreciosSinRangosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductosServiciosPreciosSinRangosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductosServiciosPreciosSinRangosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductosServiciosPreciosSinRangosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductosServiciosPreciosSinRangosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos Servicios Precios Sin Rangoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Productos Servicios Precios Sin Rangos";
	public static final String SCLASSWEBTITULO_LOWER="Productos Servicios Precios Sin Rangos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProductosServiciosPreciosSinRangos";
	public static final String OBJECTNAME="productosserviciospreciossinrangos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="productos_servicios_precios_sin_rangos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select productosserviciospreciossinrangos from "+ProductosServiciosPreciosSinRangosConstantesFunciones.SPERSISTENCENAME+" productosserviciospreciossinrangos";
	public static String QUERYSELECTNATIVE="select "+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".version_row,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_empresa,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_sucursal,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_bodega,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_linea,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".nombre_sucursal,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".codigo,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".nombre,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".nombre_bodega,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".nombre_unidad,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".codigo_tipo_precio,"+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME+".precio from "+ProductosServiciosPreciosSinRangosConstantesFunciones.SCHEMA+"."+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME;//+" as "+ProductosServiciosPreciosSinRangosConstantesFunciones.TABLENAME;
	
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
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CODIGOTIPOPRECIO= "codigo_tipo_precio";
    public static final String PRECIO= "precio";
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
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CODIGOTIPOPRECIO= "Codigo Tipo Precio";
		public static final String LABEL_CODIGOTIPOPRECIO_LOWER= "Codigo Tipo Precio";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_TIPO_PRECIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_PRECIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getProductosServiciosPreciosSinRangosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDBODEGA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGOTIPOPRECIO;}
		if(sNombreColumna.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO)) {sLabelColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductosServiciosPreciosSinRangosDescripcion(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(productosserviciospreciossinrangos !=null/* && productosserviciospreciossinrangos.getId()!=0*/) {
			sDescripcion=productosserviciospreciossinrangos.getcodigo();//productosserviciospreciossinrangosproductosserviciospreciossinrangos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductosServiciosPreciosSinRangosDescripcionDetallado(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos) {
		String sDescripcion="";
			
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.ID+"=";
		sDescripcion+=productosserviciospreciossinrangos.getId().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=productosserviciospreciossinrangos.getVersionRow().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_empresa().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_sucursal().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_bodega().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_linea().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getid_linea_marca().toString()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=productosserviciospreciossinrangos.getnombre_sucursal()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO+"=";
		sDescripcion+=productosserviciospreciossinrangos.getcodigo()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=productosserviciospreciossinrangos.getnombre()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=productosserviciospreciossinrangos.getnombre_bodega()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=productosserviciospreciossinrangos.getnombre_unidad()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO+"=";
		sDescripcion+=productosserviciospreciossinrangos.getcodigo_tipo_precio()+",";
		sDescripcion+=ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO+"=";
		sDescripcion+=productosserviciospreciossinrangos.getprecio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProductosServiciosPreciosSinRangosDescripcion(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,String sValor) throws Exception {			
		if(productosserviciospreciossinrangos !=null) {
			productosserviciospreciossinrangos.setcodigo(sValor);;//productosserviciospreciossinrangosproductosserviciospreciossinrangos.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProductosServiciosPreciosSinRangos")) {
			sNombreIndice="Tipo=  Por Bodega Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProductosServiciosPreciosSinRangos(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciospreciossinrangos.setnombre_sucursal(productosserviciospreciossinrangos.getnombre_sucursal().trim());
		productosserviciospreciossinrangos.setcodigo(productosserviciospreciossinrangos.getcodigo().trim());
		productosserviciospreciossinrangos.setnombre(productosserviciospreciossinrangos.getnombre().trim());
		productosserviciospreciossinrangos.setnombre_bodega(productosserviciospreciossinrangos.getnombre_bodega().trim());
		productosserviciospreciossinrangos.setnombre_unidad(productosserviciospreciossinrangos.getnombre_unidad().trim());
		productosserviciospreciossinrangos.setcodigo_tipo_precio(productosserviciospreciossinrangos.getcodigo_tipo_precio().trim());
	}
	
	public static void quitarEspaciosProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {
			productosserviciospreciossinrangos.setnombre_sucursal(productosserviciospreciossinrangos.getnombre_sucursal().trim());
			productosserviciospreciossinrangos.setcodigo(productosserviciospreciossinrangos.getcodigo().trim());
			productosserviciospreciossinrangos.setnombre(productosserviciospreciossinrangos.getnombre().trim());
			productosserviciospreciossinrangos.setnombre_bodega(productosserviciospreciossinrangos.getnombre_bodega().trim());
			productosserviciospreciossinrangos.setnombre_unidad(productosserviciospreciossinrangos.getnombre_unidad().trim());
			productosserviciospreciossinrangos.setcodigo_tipo_precio(productosserviciospreciossinrangos.getcodigo_tipo_precio().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && productosserviciospreciossinrangos.getConCambioAuxiliar()) {
			productosserviciospreciossinrangos.setIsDeleted(productosserviciospreciossinrangos.getIsDeletedAuxiliar());	
			productosserviciospreciossinrangos.setIsNew(productosserviciospreciossinrangos.getIsNewAuxiliar());	
			productosserviciospreciossinrangos.setIsChanged(productosserviciospreciossinrangos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			productosserviciospreciossinrangos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			productosserviciospreciossinrangos.setIsDeletedAuxiliar(false);	
			productosserviciospreciossinrangos.setIsNewAuxiliar(false);	
			productosserviciospreciossinrangos.setIsChangedAuxiliar(false);
			
			productosserviciospreciossinrangos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos : productosserviciospreciossinrangoss) {
			if(conAsignarBase && productosserviciospreciossinrangos.getConCambioAuxiliar()) {
				productosserviciospreciossinrangos.setIsDeleted(productosserviciospreciossinrangos.getIsDeletedAuxiliar());	
				productosserviciospreciossinrangos.setIsNew(productosserviciospreciossinrangos.getIsNewAuxiliar());	
				productosserviciospreciossinrangos.setIsChanged(productosserviciospreciossinrangos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				productosserviciospreciossinrangos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				productosserviciospreciossinrangos.setIsDeletedAuxiliar(false);	
				productosserviciospreciossinrangos.setIsNewAuxiliar(false);	
				productosserviciospreciossinrangos.setIsChangedAuxiliar(false);
				
				productosserviciospreciossinrangos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,Boolean conEnteros) throws Exception  {
		productosserviciospreciossinrangos.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,Boolean conEnteros) throws Exception  {
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {
			productosserviciospreciossinrangos.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProductosServiciosPreciosSinRangos(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux) throws Exception  {
		ProductosServiciosPreciosSinRangosConstantesFunciones.InicializarValoresProductosServiciosPreciosSinRangos(productosserviciospreciossinrangosAux,true);
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {
			if(productosserviciospreciossinrangos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productosserviciospreciossinrangosAux.setprecio(productosserviciospreciossinrangosAux.getprecio()+productosserviciospreciossinrangos.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosPreciosSinRangos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductosServiciosPreciosSinRangosConstantesFunciones.getArrayColumnasGlobalesProductosServiciosPreciosSinRangos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosPreciosSinRangos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProductosServiciosPreciosSinRangos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux: productosserviciospreciossinrangoss) {
			if(productosserviciospreciossinrangosAux!=null && productosserviciospreciossinrangos!=null) {
				if((productosserviciospreciossinrangosAux.getId()==null && productosserviciospreciossinrangos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productosserviciospreciossinrangosAux.getId()!=null && productosserviciospreciossinrangos.getId()!=null){
					if(productosserviciospreciossinrangosAux.getId().equals(productosserviciospreciossinrangos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosPreciosSinRangos(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {			
			if(productosserviciospreciossinrangos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=productosserviciospreciossinrangos.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProductosServiciosPreciosSinRangos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_ID, ProductosServiciosPreciosSinRangosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_VERSIONROW, ProductosServiciosPreciosSinRangosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRESUCURSAL, ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGO, ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRE, ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREBODEGA, ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREUNIDAD, ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGOTIPOPRECIO, ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO, ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProductosServiciosPreciosSinRangos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosPreciosSinRangos() throws Exception  {
		return ProductosServiciosPreciosSinRangosConstantesFunciones.getTiposSeleccionarProductosServiciosPreciosSinRangos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosPreciosSinRangos(Boolean conFk) throws Exception  {
		return ProductosServiciosPreciosSinRangosConstantesFunciones.getTiposSeleccionarProductosServiciosPreciosSinRangos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProductosServiciosPreciosSinRangos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGOTIPOPRECIO);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGOTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProductosServiciosPreciosSinRangos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux) throws Exception {
		
			productosserviciospreciossinrangosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciospreciossinrangosAux.getEmpresa()));
			productosserviciospreciossinrangosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciospreciossinrangosAux.getSucursal()));
			productosserviciospreciossinrangosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciospreciossinrangosAux.getBodega()));
			productosserviciospreciossinrangosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLinea()));
			productosserviciospreciossinrangosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaGrupo()));
			productosserviciospreciossinrangosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaCategoria()));
			productosserviciospreciossinrangosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProductosServiciosPreciosSinRangos(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangossTemp) throws Exception {
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux:productosserviciospreciossinrangossTemp) {
			
			productosserviciospreciossinrangosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productosserviciospreciossinrangosAux.getEmpresa()));
			productosserviciospreciossinrangosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productosserviciospreciossinrangosAux.getSucursal()));
			productosserviciospreciossinrangosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(productosserviciospreciossinrangosAux.getBodega()));
			productosserviciospreciossinrangosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLinea()));
			productosserviciospreciossinrangosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaGrupo()));
			productosserviciospreciossinrangosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaCategoria()));
			productosserviciospreciossinrangosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productosserviciospreciossinrangosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProductosServiciosPreciosSinRangos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProductosServiciosPreciosSinRangos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosPreciosSinRangos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosPreciosSinRangosConstantesFunciones.getClassesRelationshipsOfProductosServiciosPreciosSinRangos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProductosServiciosPreciosSinRangos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosPreciosSinRangos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductosServiciosPreciosSinRangosConstantesFunciones.getClassesRelationshipsFromStringsOfProductosServiciosPreciosSinRangos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProductosServiciosPreciosSinRangos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss) throws Exception {
		try	{			
			for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosLocal:productosserviciospreciossinrangoss) {
				if(productosserviciospreciossinrangosLocal.getId().equals(productosserviciospreciossinrangos.getId())) {
					productosserviciospreciossinrangosLocal.setIsSelected(productosserviciospreciossinrangos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProductosServiciosPreciosSinRangos(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangossAux) throws Exception {
		//this.productosserviciospreciossinrangossAux=productosserviciospreciossinrangossAux;
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux:productosserviciospreciossinrangossAux) {
			if(productosserviciospreciossinrangosAux.getIsChanged()) {
				productosserviciospreciossinrangosAux.setIsChanged(false);
			}		
			
			if(productosserviciospreciossinrangosAux.getIsNew()) {
				productosserviciospreciossinrangosAux.setIsNew(false);
			}	
			
			if(productosserviciospreciossinrangosAux.getIsDeleted()) {
				productosserviciospreciossinrangosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux) throws Exception {
		//this.productosserviciospreciossinrangosAux=productosserviciospreciossinrangosAux;
		
			if(productosserviciospreciossinrangosAux.getIsChanged()) {
				productosserviciospreciossinrangosAux.setIsChanged(false);
			}		
			
			if(productosserviciospreciossinrangosAux.getIsNew()) {
				productosserviciospreciossinrangosAux.setIsNew(false);
			}	
			
			if(productosserviciospreciossinrangosAux.getIsDeleted()) {
				productosserviciospreciossinrangosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAsignar,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos) throws Exception {
		productosserviciospreciossinrangosAsignar.setId(productosserviciospreciossinrangos.getId());	
		productosserviciospreciossinrangosAsignar.setVersionRow(productosserviciospreciossinrangos.getVersionRow());	
		productosserviciospreciossinrangosAsignar.setnombre_sucursal(productosserviciospreciossinrangos.getnombre_sucursal());	
		productosserviciospreciossinrangosAsignar.setcodigo(productosserviciospreciossinrangos.getcodigo());	
		productosserviciospreciossinrangosAsignar.setnombre(productosserviciospreciossinrangos.getnombre());	
		productosserviciospreciossinrangosAsignar.setnombre_bodega(productosserviciospreciossinrangos.getnombre_bodega());	
		productosserviciospreciossinrangosAsignar.setnombre_unidad(productosserviciospreciossinrangos.getnombre_unidad());	
		productosserviciospreciossinrangosAsignar.setcodigo_tipo_precio(productosserviciospreciossinrangos.getcodigo_tipo_precio());	
		productosserviciospreciossinrangosAsignar.setprecio(productosserviciospreciossinrangos.getprecio());	
	}
	
	public static void inicializarProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos) throws Exception {
		try {
				productosserviciospreciossinrangos.setId(0L);	
					
				productosserviciospreciossinrangos.setnombre_sucursal("");	
				productosserviciospreciossinrangos.setcodigo("");	
				productosserviciospreciossinrangos.setnombre("");	
				productosserviciospreciossinrangos.setnombre_bodega("");	
				productosserviciospreciossinrangos.setnombre_unidad("");	
				productosserviciospreciossinrangos.setcodigo_tipo_precio("");	
				productosserviciospreciossinrangos.setprecio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProductosServiciosPreciosSinRangos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_CODIGOTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProductosServiciosPreciosSinRangos(String sTipo,Row row,Workbook workbook,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getcodigo_tipo_precio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(productosserviciospreciossinrangos.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProductosServiciosPreciosSinRangos="";
	
	public String getsFinalQueryProductosServiciosPreciosSinRangos() {
		return this.sFinalQueryProductosServiciosPreciosSinRangos;
	}
	
	public void setsFinalQueryProductosServiciosPreciosSinRangos(String sFinalQueryProductosServiciosPreciosSinRangos) {
		this.sFinalQueryProductosServiciosPreciosSinRangos= sFinalQueryProductosServiciosPreciosSinRangos;
	}
	
	public Border resaltarSeleccionarProductosServiciosPreciosSinRangos=null;
	
	public Border setResaltarSeleccionarProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProductosServiciosPreciosSinRangos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProductosServiciosPreciosSinRangos() {
		return this.resaltarSeleccionarProductosServiciosPreciosSinRangos;
	}
	
	public void setResaltarSeleccionarProductosServiciosPreciosSinRangos(Border borderResaltarSeleccionarProductosServiciosPreciosSinRangos) {
		this.resaltarSeleccionarProductosServiciosPreciosSinRangos= borderResaltarSeleccionarProductosServiciosPreciosSinRangos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProductosServiciosPreciosSinRangos=null;
	public Boolean mostraridProductosServiciosPreciosSinRangos=true;
	public Boolean activaridProductosServiciosPreciosSinRangos=true;

	public Border resaltarid_empresaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_empresaProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_empresaProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_empresaProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_sucursalProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_sucursalProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_sucursalProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_bodegaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_bodegaProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_bodegaProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_bodegaProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_lineaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_lineaProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_lineaProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_lineaProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_linea_grupoProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_linea_grupoProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_linea_grupoProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_linea_categoriaProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_linea_categoriaProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_linea_categoriaProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarid_linea_marcaProductosServiciosPreciosSinRangos=true;
	public Boolean activarid_linea_marcaProductosServiciosPreciosSinRangos=true;
	public Boolean cargarid_linea_marcaProductosServiciosPreciosSinRangos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProductosServiciosPreciosSinRangos=false;//ConEventDepend=true

	public Border resaltarnombre_sucursalProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarnombre_sucursalProductosServiciosPreciosSinRangos=true;
	public Boolean activarnombre_sucursalProductosServiciosPreciosSinRangos=true;

	public Border resaltarcodigoProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarcodigoProductosServiciosPreciosSinRangos=true;
	public Boolean activarcodigoProductosServiciosPreciosSinRangos=true;

	public Border resaltarnombreProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarnombreProductosServiciosPreciosSinRangos=true;
	public Boolean activarnombreProductosServiciosPreciosSinRangos=true;

	public Border resaltarnombre_bodegaProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarnombre_bodegaProductosServiciosPreciosSinRangos=true;
	public Boolean activarnombre_bodegaProductosServiciosPreciosSinRangos=true;

	public Border resaltarnombre_unidadProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarnombre_unidadProductosServiciosPreciosSinRangos=true;
	public Boolean activarnombre_unidadProductosServiciosPreciosSinRangos=true;

	public Border resaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos=true;
	public Boolean activarcodigo_tipo_precioProductosServiciosPreciosSinRangos=true;

	public Border resaltarprecioProductosServiciosPreciosSinRangos=null;
	public Boolean mostrarprecioProductosServiciosPreciosSinRangos=true;
	public Boolean activarprecioProductosServiciosPreciosSinRangos=true;

	
	

	public Border setResaltaridProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltaridProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProductosServiciosPreciosSinRangos() {
		return this.resaltaridProductosServiciosPreciosSinRangos;
	}

	public void setResaltaridProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltaridProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostraridProductosServiciosPreciosSinRangos() {
		return this.mostraridProductosServiciosPreciosSinRangos;
	}

	public void setMostraridProductosServiciosPreciosSinRangos(Boolean mostraridProductosServiciosPreciosSinRangos) {
		this.mostraridProductosServiciosPreciosSinRangos= mostraridProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivaridProductosServiciosPreciosSinRangos() {
		return this.activaridProductosServiciosPreciosSinRangos;
	}

	public void setActivaridProductosServiciosPreciosSinRangos(Boolean activaridProductosServiciosPreciosSinRangos) {
		this.activaridProductosServiciosPreciosSinRangos= activaridProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_empresaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProductosServiciosPreciosSinRangos() {
		return this.resaltarid_empresaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_empresaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_empresaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProductosServiciosPreciosSinRangos() {
		return this.mostrarid_empresaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_empresaProductosServiciosPreciosSinRangos(Boolean mostrarid_empresaProductosServiciosPreciosSinRangos) {
		this.mostrarid_empresaProductosServiciosPreciosSinRangos= mostrarid_empresaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_empresaProductosServiciosPreciosSinRangos() {
		return this.activarid_empresaProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_empresaProductosServiciosPreciosSinRangos(Boolean activarid_empresaProductosServiciosPreciosSinRangos) {
		this.activarid_empresaProductosServiciosPreciosSinRangos= activarid_empresaProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_empresaProductosServiciosPreciosSinRangos() {
		return this.cargarid_empresaProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_empresaProductosServiciosPreciosSinRangos(Boolean cargarid_empresaProductosServiciosPreciosSinRangos) {
		this.cargarid_empresaProductosServiciosPreciosSinRangos= cargarid_empresaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_sucursalProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProductosServiciosPreciosSinRangos() {
		return this.resaltarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_sucursalProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_sucursalProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProductosServiciosPreciosSinRangos() {
		return this.mostrarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_sucursalProductosServiciosPreciosSinRangos(Boolean mostrarid_sucursalProductosServiciosPreciosSinRangos) {
		this.mostrarid_sucursalProductosServiciosPreciosSinRangos= mostrarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_sucursalProductosServiciosPreciosSinRangos() {
		return this.activarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_sucursalProductosServiciosPreciosSinRangos(Boolean activarid_sucursalProductosServiciosPreciosSinRangos) {
		this.activarid_sucursalProductosServiciosPreciosSinRangos= activarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_sucursalProductosServiciosPreciosSinRangos() {
		return this.cargarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_sucursalProductosServiciosPreciosSinRangos(Boolean cargarid_sucursalProductosServiciosPreciosSinRangos) {
		this.cargarid_sucursalProductosServiciosPreciosSinRangos= cargarid_sucursalProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_bodegaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProductosServiciosPreciosSinRangos() {
		return this.resaltarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_bodegaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_bodegaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProductosServiciosPreciosSinRangos() {
		return this.mostrarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_bodegaProductosServiciosPreciosSinRangos(Boolean mostrarid_bodegaProductosServiciosPreciosSinRangos) {
		this.mostrarid_bodegaProductosServiciosPreciosSinRangos= mostrarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_bodegaProductosServiciosPreciosSinRangos() {
		return this.activarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_bodegaProductosServiciosPreciosSinRangos(Boolean activarid_bodegaProductosServiciosPreciosSinRangos) {
		this.activarid_bodegaProductosServiciosPreciosSinRangos= activarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_bodegaProductosServiciosPreciosSinRangos() {
		return this.cargarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_bodegaProductosServiciosPreciosSinRangos(Boolean cargarid_bodegaProductosServiciosPreciosSinRangos) {
		this.cargarid_bodegaProductosServiciosPreciosSinRangos= cargarid_bodegaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_lineaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_lineaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProductosServiciosPreciosSinRangos() {
		return this.resaltarid_lineaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_lineaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_lineaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_lineaProductosServiciosPreciosSinRangos() {
		return this.mostrarid_lineaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_lineaProductosServiciosPreciosSinRangos(Boolean mostrarid_lineaProductosServiciosPreciosSinRangos) {
		this.mostrarid_lineaProductosServiciosPreciosSinRangos= mostrarid_lineaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_lineaProductosServiciosPreciosSinRangos() {
		return this.activarid_lineaProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_lineaProductosServiciosPreciosSinRangos(Boolean activarid_lineaProductosServiciosPreciosSinRangos) {
		this.activarid_lineaProductosServiciosPreciosSinRangos= activarid_lineaProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_lineaProductosServiciosPreciosSinRangos() {
		return this.cargarid_lineaProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_lineaProductosServiciosPreciosSinRangos(Boolean cargarid_lineaProductosServiciosPreciosSinRangos) {
		this.cargarid_lineaProductosServiciosPreciosSinRangos= cargarid_lineaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_linea_grupoProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProductosServiciosPreciosSinRangos() {
		return this.resaltarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_linea_grupoProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_linea_grupoProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProductosServiciosPreciosSinRangos() {
		return this.mostrarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_linea_grupoProductosServiciosPreciosSinRangos(Boolean mostrarid_linea_grupoProductosServiciosPreciosSinRangos) {
		this.mostrarid_linea_grupoProductosServiciosPreciosSinRangos= mostrarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_linea_grupoProductosServiciosPreciosSinRangos() {
		return this.activarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_linea_grupoProductosServiciosPreciosSinRangos(Boolean activarid_linea_grupoProductosServiciosPreciosSinRangos) {
		this.activarid_linea_grupoProductosServiciosPreciosSinRangos= activarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_linea_grupoProductosServiciosPreciosSinRangos() {
		return this.cargarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_linea_grupoProductosServiciosPreciosSinRangos(Boolean cargarid_linea_grupoProductosServiciosPreciosSinRangos) {
		this.cargarid_linea_grupoProductosServiciosPreciosSinRangos= cargarid_linea_grupoProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_linea_categoriaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProductosServiciosPreciosSinRangos() {
		return this.resaltarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_linea_categoriaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_linea_categoriaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProductosServiciosPreciosSinRangos() {
		return this.mostrarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_linea_categoriaProductosServiciosPreciosSinRangos(Boolean mostrarid_linea_categoriaProductosServiciosPreciosSinRangos) {
		this.mostrarid_linea_categoriaProductosServiciosPreciosSinRangos= mostrarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_linea_categoriaProductosServiciosPreciosSinRangos() {
		return this.activarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_linea_categoriaProductosServiciosPreciosSinRangos(Boolean activarid_linea_categoriaProductosServiciosPreciosSinRangos) {
		this.activarid_linea_categoriaProductosServiciosPreciosSinRangos= activarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_linea_categoriaProductosServiciosPreciosSinRangos() {
		return this.cargarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_linea_categoriaProductosServiciosPreciosSinRangos(Boolean cargarid_linea_categoriaProductosServiciosPreciosSinRangos) {
		this.cargarid_linea_categoriaProductosServiciosPreciosSinRangos= cargarid_linea_categoriaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarid_linea_marcaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProductosServiciosPreciosSinRangos() {
		return this.resaltarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarid_linea_marcaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarid_linea_marcaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProductosServiciosPreciosSinRangos() {
		return this.mostrarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarid_linea_marcaProductosServiciosPreciosSinRangos(Boolean mostrarid_linea_marcaProductosServiciosPreciosSinRangos) {
		this.mostrarid_linea_marcaProductosServiciosPreciosSinRangos= mostrarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarid_linea_marcaProductosServiciosPreciosSinRangos() {
		return this.activarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public void setActivarid_linea_marcaProductosServiciosPreciosSinRangos(Boolean activarid_linea_marcaProductosServiciosPreciosSinRangos) {
		this.activarid_linea_marcaProductosServiciosPreciosSinRangos= activarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public Boolean getCargarid_linea_marcaProductosServiciosPreciosSinRangos() {
		return this.cargarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public void setCargarid_linea_marcaProductosServiciosPreciosSinRangos(Boolean cargarid_linea_marcaProductosServiciosPreciosSinRangos) {
		this.cargarid_linea_marcaProductosServiciosPreciosSinRangos= cargarid_linea_marcaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarnombre_sucursalProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalProductosServiciosPreciosSinRangos() {
		return this.resaltarnombre_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setResaltarnombre_sucursalProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarnombre_sucursalProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalProductosServiciosPreciosSinRangos() {
		return this.mostrarnombre_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setMostrarnombre_sucursalProductosServiciosPreciosSinRangos(Boolean mostrarnombre_sucursalProductosServiciosPreciosSinRangos) {
		this.mostrarnombre_sucursalProductosServiciosPreciosSinRangos= mostrarnombre_sucursalProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarnombre_sucursalProductosServiciosPreciosSinRangos() {
		return this.activarnombre_sucursalProductosServiciosPreciosSinRangos;
	}

	public void setActivarnombre_sucursalProductosServiciosPreciosSinRangos(Boolean activarnombre_sucursalProductosServiciosPreciosSinRangos) {
		this.activarnombre_sucursalProductosServiciosPreciosSinRangos= activarnombre_sucursalProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarcodigoProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarcodigoProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProductosServiciosPreciosSinRangos() {
		return this.resaltarcodigoProductosServiciosPreciosSinRangos;
	}

	public void setResaltarcodigoProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarcodigoProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarcodigoProductosServiciosPreciosSinRangos() {
		return this.mostrarcodigoProductosServiciosPreciosSinRangos;
	}

	public void setMostrarcodigoProductosServiciosPreciosSinRangos(Boolean mostrarcodigoProductosServiciosPreciosSinRangos) {
		this.mostrarcodigoProductosServiciosPreciosSinRangos= mostrarcodigoProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarcodigoProductosServiciosPreciosSinRangos() {
		return this.activarcodigoProductosServiciosPreciosSinRangos;
	}

	public void setActivarcodigoProductosServiciosPreciosSinRangos(Boolean activarcodigoProductosServiciosPreciosSinRangos) {
		this.activarcodigoProductosServiciosPreciosSinRangos= activarcodigoProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarnombreProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarnombreProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProductosServiciosPreciosSinRangos() {
		return this.resaltarnombreProductosServiciosPreciosSinRangos;
	}

	public void setResaltarnombreProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarnombreProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarnombreProductosServiciosPreciosSinRangos() {
		return this.mostrarnombreProductosServiciosPreciosSinRangos;
	}

	public void setMostrarnombreProductosServiciosPreciosSinRangos(Boolean mostrarnombreProductosServiciosPreciosSinRangos) {
		this.mostrarnombreProductosServiciosPreciosSinRangos= mostrarnombreProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarnombreProductosServiciosPreciosSinRangos() {
		return this.activarnombreProductosServiciosPreciosSinRangos;
	}

	public void setActivarnombreProductosServiciosPreciosSinRangos(Boolean activarnombreProductosServiciosPreciosSinRangos) {
		this.activarnombreProductosServiciosPreciosSinRangos= activarnombreProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarnombre_bodegaProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaProductosServiciosPreciosSinRangos() {
		return this.resaltarnombre_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setResaltarnombre_bodegaProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarnombre_bodegaProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaProductosServiciosPreciosSinRangos() {
		return this.mostrarnombre_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setMostrarnombre_bodegaProductosServiciosPreciosSinRangos(Boolean mostrarnombre_bodegaProductosServiciosPreciosSinRangos) {
		this.mostrarnombre_bodegaProductosServiciosPreciosSinRangos= mostrarnombre_bodegaProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarnombre_bodegaProductosServiciosPreciosSinRangos() {
		return this.activarnombre_bodegaProductosServiciosPreciosSinRangos;
	}

	public void setActivarnombre_bodegaProductosServiciosPreciosSinRangos(Boolean activarnombre_bodegaProductosServiciosPreciosSinRangos) {
		this.activarnombre_bodegaProductosServiciosPreciosSinRangos= activarnombre_bodegaProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarnombre_unidadProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProductosServiciosPreciosSinRangos() {
		return this.resaltarnombre_unidadProductosServiciosPreciosSinRangos;
	}

	public void setResaltarnombre_unidadProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarnombre_unidadProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProductosServiciosPreciosSinRangos() {
		return this.mostrarnombre_unidadProductosServiciosPreciosSinRangos;
	}

	public void setMostrarnombre_unidadProductosServiciosPreciosSinRangos(Boolean mostrarnombre_unidadProductosServiciosPreciosSinRangos) {
		this.mostrarnombre_unidadProductosServiciosPreciosSinRangos= mostrarnombre_unidadProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarnombre_unidadProductosServiciosPreciosSinRangos() {
		return this.activarnombre_unidadProductosServiciosPreciosSinRangos;
	}

	public void setActivarnombre_unidadProductosServiciosPreciosSinRangos(Boolean activarnombre_unidadProductosServiciosPreciosSinRangos) {
		this.activarnombre_unidadProductosServiciosPreciosSinRangos= activarnombre_unidadProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos() {
		return this.resaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos;
	}

	public void setResaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos() {
		return this.mostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos;
	}

	public void setMostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos(Boolean mostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos) {
		this.mostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos= mostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarcodigo_tipo_precioProductosServiciosPreciosSinRangos() {
		return this.activarcodigo_tipo_precioProductosServiciosPreciosSinRangos;
	}

	public void setActivarcodigo_tipo_precioProductosServiciosPreciosSinRangos(Boolean activarcodigo_tipo_precioProductosServiciosPreciosSinRangos) {
		this.activarcodigo_tipo_precioProductosServiciosPreciosSinRangos= activarcodigo_tipo_precioProductosServiciosPreciosSinRangos;
	}

	public Border setResaltarprecioProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productosserviciospreciossinrangosBeanSwingJInternalFrame.jTtoolBarProductosServiciosPreciosSinRangos.setBorder(borderResaltar);
		
		this.resaltarprecioProductosServiciosPreciosSinRangos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProductosServiciosPreciosSinRangos() {
		return this.resaltarprecioProductosServiciosPreciosSinRangos;
	}

	public void setResaltarprecioProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarprecioProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public Boolean getMostrarprecioProductosServiciosPreciosSinRangos() {
		return this.mostrarprecioProductosServiciosPreciosSinRangos;
	}

	public void setMostrarprecioProductosServiciosPreciosSinRangos(Boolean mostrarprecioProductosServiciosPreciosSinRangos) {
		this.mostrarprecioProductosServiciosPreciosSinRangos= mostrarprecioProductosServiciosPreciosSinRangos;
	}

	public Boolean getActivarprecioProductosServiciosPreciosSinRangos() {
		return this.activarprecioProductosServiciosPreciosSinRangos;
	}

	public void setActivarprecioProductosServiciosPreciosSinRangos(Boolean activarprecioProductosServiciosPreciosSinRangos) {
		this.activarprecioProductosServiciosPreciosSinRangos= activarprecioProductosServiciosPreciosSinRangos;
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
		
		
		this.setMostraridProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_empresaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_lineaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_linea_grupoProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_linea_categoriaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarid_linea_marcaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarnombre_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarcodigoProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarnombreProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarnombre_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarnombre_unidadProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esInicial);
		this.setMostrarprecioProductosServiciosPreciosSinRangos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.ID)) {
				this.setMostraridProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO)) {
				this.setMostrarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProductosServiciosPreciosSinRangos(esAsigna);
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
		
		
		this.setActivaridProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_empresaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_lineaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_linea_grupoProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_linea_categoriaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarid_linea_marcaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarnombre_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarcodigoProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarnombreProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarnombre_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarnombre_unidadProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esInicial);
		this.setActivarprecioProductosServiciosPreciosSinRangos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.ID)) {
				this.setActivaridProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO)) {
				this.setActivarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO)) {
				this.setActivarprecioProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_empresaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_lineaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_linea_grupoProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_linea_categoriaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarid_linea_marcaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarnombre_sucursalProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarcodigoProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarnombreProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarnombre_bodegaProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarnombre_unidadProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esInicial);
		this.setResaltarprecioProductosServiciosPreciosSinRangos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.ID)) {
				this.setResaltaridProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.CODIGOTIPOPRECIO)) {
				this.setResaltarcodigo_tipo_precioProductosServiciosPreciosSinRangos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProductosServiciosPreciosSinRangos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos=true;

	public Boolean getMostrarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos() {
		return this.mostrarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos;
	}

	public void setMostrarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos=true;

	public Boolean getActivarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos() {
		return this.activarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos;
	}

	public void setActivarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos(Boolean habilitarResaltar) {
		this.activarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos=null;

	public Border getResaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos() {
		return this.resaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos;
	}

	public void setResaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos(Border borderResaltar) {
		this.resaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos= borderResaltar;
	}

	public void setResaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos(ParametroGeneralUsuario parametroGeneralUsuario/*ProductosServiciosPreciosSinRangosBeanSwingJInternalFrame productosserviciospreciossinrangosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProductosServiciosPreciosSinRangosProductosServiciosPreciosSinRangos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}