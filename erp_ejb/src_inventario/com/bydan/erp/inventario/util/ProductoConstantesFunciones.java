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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProductoConstantesFunciones extends ProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Producto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Producto"+ProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProductoConstantesFunciones.SCHEMA+"_"+ProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProductoConstantesFunciones.SCHEMA+"_"+ProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProductoConstantesFunciones.SCHEMA+"_"+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProductoConstantesFunciones.SCHEMA+"_"+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Producto";
	public static final String SCLASSWEBTITULO_LOWER="Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Producto";
	public static final String OBJECTNAME="producto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select producto from "+ProductoConstantesFunciones.SPERSISTENCENAME+" producto";
	public static String QUERYSELECTNATIVE="select "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".version_row,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_empresa,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".codigo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".nombre,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".nombre_extranjero,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".resumen_detalle,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".codigo_barra,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio_inven,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_costeo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_unidad_peso,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_arancel,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_cliente,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_cliente_proveedor_defecto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".esta_activo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descripcion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".precio,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".iva,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".iva_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ice,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ice_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descuento,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descuento_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".arancel_porcentaje,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".arancel_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".comision,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".comision_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".dias_produccion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_stock_negativo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_precio_minimo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_lote,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_confirmacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_presupuesto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_importacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_final,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_consep,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_serie,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_balanza,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".alto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ancho,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".largo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".volumen,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".peso,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".gramos,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".unidades_caja,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".margen,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".factor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".fob,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".fob2,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_color_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_clase_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_efecto_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_marca_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_modelo_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_material_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_segmento_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_talla_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".grupo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".referencia,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".aplicacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".procedencia from "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME;//+" as "+ProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProductoConstantesFuncionesAdditional productoConstantesFuncionesAdditional=null;
	
	public ProductoConstantesFuncionesAdditional getProductoConstantesFuncionesAdditional() {
		return this.productoConstantesFuncionesAdditional;
	}
	
	public void setProductoConstantesFuncionesAdditional(ProductoConstantesFuncionesAdditional productoConstantesFuncionesAdditional) {
		try {
			this.productoConstantesFuncionesAdditional=productoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREEXTRANJERO= "nombre_extranjero";
    public static final String RESUMENDETALLE= "resumen_detalle";
    public static final String CODIGOBARRA= "codigo_barra";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String IDTIPOPRODUCTOSERVICIOINVEN= "id_tipo_producto_servicio_inven";
    public static final String IDTIPOCOSTEO= "id_tipo_costeo";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDUNIDADPESO= "id_unidad_peso";
    public static final String IDARANCEL= "id_arancel";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCLIENTEPROVEEDORDEFECTO= "id_cliente_proveedor_defecto";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
    public static final String PRECIO= "precio";
    public static final String IVA= "iva";
    public static final String IVAVALOR= "iva_valor";
    public static final String ICE= "ice";
    public static final String ICEVALOR= "ice_valor";
    public static final String DESCUENTO= "descuento";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String ARANCELPORCENTAJE= "arancel_porcentaje";
    public static final String ARANCELVALOR= "arancel_valor";
    public static final String COMISION= "comision";
    public static final String COMISIONVALOR= "comision_valor";
    public static final String DIASPRODUCCION= "dias_produccion";
    public static final String CONSTOCKNEGATIVO= "con_stock_negativo";
    public static final String CONPRECIOMINIMO= "con_precio_minimo";
    public static final String CONLOTE= "con_lote";
    public static final String CONCONFIRMACION= "con_confirmacion";
    public static final String CONPRESUPUESTO= "con_presupuesto";
    public static final String CONIMPORTACION= "con_importacion";
    public static final String CONFINAL= "con_final";
    public static final String CONCONSEP= "con_consep";
    public static final String CONSERIE= "con_serie";
    public static final String CONBALANZA= "con_balanza";
    public static final String ALTO= "alto";
    public static final String ANCHO= "ancho";
    public static final String LARGO= "largo";
    public static final String VOLUMEN= "volumen";
    public static final String PESO= "peso";
    public static final String GRAMOS= "gramos";
    public static final String UNIDADESCAJA= "unidades_caja";
    public static final String MARGEN= "margen";
    public static final String FACTOR= "factor";
    public static final String FOB= "fob";
    public static final String FOB2= "fob2";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String IDCOLORPRODUCTO= "id_color_producto";
    public static final String IDCLASEPRODUCTO= "id_clase_producto";
    public static final String IDEFECTOPRODUCTO= "id_efecto_producto";
    public static final String IDMARCAPRODUCTO= "id_marca_producto";
    public static final String IDMODELOPRODUCTO= "id_modelo_producto";
    public static final String IDMATERIALPRODUCTO= "id_material_producto";
    public static final String IDSEGMENTOPRODUCTO= "id_segmento_producto";
    public static final String IDTALLAPRODUCTO= "id_talla_producto";
    public static final String GRUPO= "grupo";
    public static final String REFERENCIA= "referencia";
    public static final String APLICACION= "aplicacion";
    public static final String PROCEDENCIA= "procedencia";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREEXTRANJERO= "Nombre Extranjero";
		public static final String LABEL_NOMBREEXTRANJERO_LOWER= "Nombre Extranjero";
    	public static final String LABEL_RESUMENDETALLE= "Resumen Detalle";
		public static final String LABEL_RESUMENDETALLE_LOWER= "Resumen Detalle";
    	public static final String LABEL_CODIGOBARRA= "Codigo Barra";
		public static final String LABEL_CODIGOBARRA_LOWER= "Codigo Barra";
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
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIOINVEN= "Tipo Producto Servicio.";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIOINVEN_LOWER= "Tipo Producto Servicio Inven";
    	public static final String LABEL_IDTIPOCOSTEO= "Tipo Costeo";
		public static final String LABEL_IDTIPOCOSTEO_LOWER= "Tipo Costeo";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDUNIDADPESO= "Unidad Peso";
		public static final String LABEL_IDUNIDADPESO_LOWER= "Unidad Peso";
    	public static final String LABEL_IDARANCEL= "Codigo Arancelario";
		public static final String LABEL_IDARANCEL_LOWER= "Arancel";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCLIENTEPROVEEDORDEFECTO= "Cliente Proveedor Defecto";
		public static final String LABEL_IDCLIENTEPROVEEDORDEFECTO_LOWER= "Cliente Proveedor Defecto";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_IVAVALOR= "Iva Valor";
		public static final String LABEL_IVAVALOR_LOWER= "Iva Valor";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ICEVALOR= "Ice Valor";
		public static final String LABEL_ICEVALOR_LOWER= "Ice Valor";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_ARANCELPORCENTAJE= "Arancel %";
		public static final String LABEL_ARANCELPORCENTAJE_LOWER= "Arancel Porcentaje";
    	public static final String LABEL_ARANCELVALOR= "Arancel Valor";
		public static final String LABEL_ARANCELVALOR_LOWER= "Arancel Valor";
    	public static final String LABEL_COMISION= "Comision";
		public static final String LABEL_COMISION_LOWER= "Comision";
    	public static final String LABEL_COMISIONVALOR= "Comision Valor";
		public static final String LABEL_COMISIONVALOR_LOWER= "Comision Valor";
    	public static final String LABEL_DIASPRODUCCION= "Dias Produccion";
		public static final String LABEL_DIASPRODUCCION_LOWER= "Dias Produccion";
    	public static final String LABEL_CONSTOCKNEGATIVO= "Con Stock Negativo";
		public static final String LABEL_CONSTOCKNEGATIVO_LOWER= "Con Stock Negativo";
    	public static final String LABEL_CONPRECIOMINIMO= "Con Precio Minimo";
		public static final String LABEL_CONPRECIOMINIMO_LOWER= "Con Precio Minimo";
    	public static final String LABEL_CONLOTE= "Con Lote";
		public static final String LABEL_CONLOTE_LOWER= "Con Lote";
    	public static final String LABEL_CONCONFIRMACION= "Con Confirmacion";
		public static final String LABEL_CONCONFIRMACION_LOWER= "Con Confirmacion";
    	public static final String LABEL_CONPRESUPUESTO= "Con Presupuesto Cantidad";
		public static final String LABEL_CONPRESUPUESTO_LOWER= "Con Presupuesto";
    	public static final String LABEL_CONIMPORTACION= "Es Importado";
		public static final String LABEL_CONIMPORTACION_LOWER= "Con Importacion";
    	public static final String LABEL_CONFINAL= "Es Final";
		public static final String LABEL_CONFINAL_LOWER= "Con Final";
    	public static final String LABEL_CONCONSEP= "Autorizacion Consep";
		public static final String LABEL_CONCONSEP_LOWER= "Con Consep";
    	public static final String LABEL_CONSERIE= "Con Serie";
		public static final String LABEL_CONSERIE_LOWER= "Con Serie";
    	public static final String LABEL_CONBALANZA= "Con Balanza";
		public static final String LABEL_CONBALANZA_LOWER= "Con Balanza";
    	public static final String LABEL_ALTO= "Alto";
		public static final String LABEL_ALTO_LOWER= "Alto";
    	public static final String LABEL_ANCHO= "Ancho";
		public static final String LABEL_ANCHO_LOWER= "Ancho";
    	public static final String LABEL_LARGO= "Largo";
		public static final String LABEL_LARGO_LOWER= "Largo";
    	public static final String LABEL_VOLUMEN= "Volumen";
		public static final String LABEL_VOLUMEN_LOWER= "Volumen";
    	public static final String LABEL_PESO= "Peso";
		public static final String LABEL_PESO_LOWER= "Peso";
    	public static final String LABEL_GRAMOS= "Gramos";
		public static final String LABEL_GRAMOS_LOWER= "Gramos";
    	public static final String LABEL_UNIDADESCAJA= "Unidades Caja";
		public static final String LABEL_UNIDADESCAJA_LOWER= "Unidades Caja";
    	public static final String LABEL_MARGEN= "Margen";
		public static final String LABEL_MARGEN_LOWER= "Margen";
    	public static final String LABEL_FACTOR= "Factor";
		public static final String LABEL_FACTOR_LOWER= "Factor";
    	public static final String LABEL_FOB= "Fob";
		public static final String LABEL_FOB_LOWER= "Fob";
    	public static final String LABEL_FOB2= "Fob 2";
		public static final String LABEL_FOB2_LOWER= "Fob2";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_IDCOLORPRODUCTO= "Color Producto";
		public static final String LABEL_IDCOLORPRODUCTO_LOWER= "Color Producto";
    	public static final String LABEL_IDCLASEPRODUCTO= "Clase Producto";
		public static final String LABEL_IDCLASEPRODUCTO_LOWER= "Clase Producto";
    	public static final String LABEL_IDEFECTOPRODUCTO= "Efecto Producto";
		public static final String LABEL_IDEFECTOPRODUCTO_LOWER= "Efecto Producto";
    	public static final String LABEL_IDMARCAPRODUCTO= "Marca Producto";
		public static final String LABEL_IDMARCAPRODUCTO_LOWER= "Marca Producto";
    	public static final String LABEL_IDMODELOPRODUCTO= "Modelo Producto";
		public static final String LABEL_IDMODELOPRODUCTO_LOWER= "Modelo Producto";
    	public static final String LABEL_IDMATERIALPRODUCTO= "Material Producto";
		public static final String LABEL_IDMATERIALPRODUCTO_LOWER= "Material Producto";
    	public static final String LABEL_IDSEGMENTOPRODUCTO= "Segmento Producto";
		public static final String LABEL_IDSEGMENTOPRODUCTO_LOWER= "Segmento Producto";
    	public static final String LABEL_IDTALLAPRODUCTO= "Talla Producto";
		public static final String LABEL_IDTALLAPRODUCTO_LOWER= "Talla Producto";
    	public static final String LABEL_GRUPO= "Grupo";
		public static final String LABEL_GRUPO_LOWER= "Grupo";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_APLICACION= "Aplicacion";
		public static final String LABEL_APLICACION_LOWER= "Aplicacion";
    	public static final String LABEL_PROCEDENCIA= "Procedencia";
		public static final String LABEL_PROCEDENCIA_LOWER= "Procedencia";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EXTRANJERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EXTRANJERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESUMEN_DETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESUMEN_DETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_BARRA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_BARRA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXGRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPLICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPLICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPROCEDENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPROCEDENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CODIGO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.NOMBRE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.NOMBREEXTRANJERO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_NOMBREEXTRANJERO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.RESUMENDETALLE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_RESUMENDETALLE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CODIGOBARRA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CODIGOBARRA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDLINEA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDTIPOCOSTEO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDTIPOCOSTEO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDUNIDAD)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDUNIDADPESO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDUNIDADPESO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDARANCEL)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDARANCEL;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDCLIENTE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDCLIENTEPROVEEDORDEFECTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ESTAACTIVO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.PRECIO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IVA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IVAVALOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IVAVALOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ICE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ICEVALOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ICEVALOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.DESCUENTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ARANCELPORCENTAJE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ARANCELVALOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ARANCELVALOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.COMISION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_COMISION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.COMISIONVALOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_COMISIONVALOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.DIASPRODUCCION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_DIASPRODUCCION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONSTOCKNEGATIVO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONSTOCKNEGATIVO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONPRECIOMINIMO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONPRECIOMINIMO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONLOTE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONLOTE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONCONFIRMACION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONCONFIRMACION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONPRESUPUESTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONPRESUPUESTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONIMPORTACION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONIMPORTACION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONFINAL)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONFINAL;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONCONSEP)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONCONSEP;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONSERIE)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONSERIE;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.CONBALANZA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_CONBALANZA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ALTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ALTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.ANCHO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_ANCHO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.LARGO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_LARGO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.VOLUMEN)) {sLabelColumna=ProductoConstantesFunciones.LABEL_VOLUMEN;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.PESO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_PESO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.GRAMOS)) {sLabelColumna=ProductoConstantesFunciones.LABEL_GRAMOS;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.UNIDADESCAJA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_UNIDADESCAJA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.MARGEN)) {sLabelColumna=ProductoConstantesFunciones.LABEL_MARGEN;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.FACTOR)) {sLabelColumna=ProductoConstantesFunciones.LABEL_FACTOR;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.FOB)) {sLabelColumna=ProductoConstantesFunciones.LABEL_FOB;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.FOB2)) {sLabelColumna=ProductoConstantesFunciones.LABEL_FOB2;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDCOLORPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDCOLORPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDCLASEPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDCLASEPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDEFECTOPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDEFECTOPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDMARCAPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDMARCAPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDMODELOPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDMODELOPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDMATERIALPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDMATERIALPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDSEGMENTOPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.IDTALLAPRODUCTO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_IDTALLAPRODUCTO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.GRUPO)) {sLabelColumna=ProductoConstantesFunciones.LABEL_GRUPO;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.REFERENCIA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.APLICACION)) {sLabelColumna=ProductoConstantesFunciones.LABEL_APLICACION;}
		if(sNombreColumna.equals(ProductoConstantesFunciones.PROCEDENCIA)) {sLabelColumna=ProductoConstantesFunciones.LABEL_PROCEDENCIA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getesta_activo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_stock_negativoDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_stock_negativo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_stock_negativoHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_stock_negativo());

		return sDescripcion;
	}	
		
	public static String getcon_precio_minimoDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_precio_minimo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precio_minimoHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_precio_minimo());

		return sDescripcion;
	}	
		
	public static String getcon_loteDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_lote()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_loteHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_lote());

		return sDescripcion;
	}	
		
	public static String getcon_confirmacionDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_confirmacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_confirmacionHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_confirmacion());

		return sDescripcion;
	}	
		
	public static String getcon_presupuestoDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_presupuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_presupuestoHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_presupuesto());

		return sDescripcion;
	}	
		
	public static String getcon_importacionDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_importacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_importacionHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_importacion());

		return sDescripcion;
	}	
		
	public static String getcon_finalDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_final()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_finalHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_final());

		return sDescripcion;
	}	
		
	public static String getcon_consepDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_consep()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_consepHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_consep());

		return sDescripcion;
	}	
		
	public static String getcon_serieDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_serie()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_serieHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_serie());

		return sDescripcion;
	}	
		
	public static String getcon_balanzaDescripcion(Producto producto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!producto.getcon_balanza()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_balanzaHtmlDescripcion(Producto producto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(producto.getId(),producto.getcon_balanza());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(producto !=null/* && producto.getId()!=0*/) {
			sDescripcion=producto.getnombre();//productoproducto.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProductoDescripcionDetallado(Producto producto) {
		String sDescripcion="";
			
		sDescripcion+=ProductoConstantesFunciones.ID+"=";
		sDescripcion+=producto.getId().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=producto.getVersionRow().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=producto.getid_empresa().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=producto.getid_sucursal().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=producto.getcodigo()+",";
		sDescripcion+=ProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=producto.getnombre()+",";
		sDescripcion+=ProductoConstantesFunciones.NOMBREEXTRANJERO+"=";
		sDescripcion+=producto.getnombre_extranjero()+",";
		sDescripcion+=ProductoConstantesFunciones.RESUMENDETALLE+"=";
		sDescripcion+=producto.getresumen_detalle()+",";
		sDescripcion+=ProductoConstantesFunciones.CODIGOBARRA+"=";
		sDescripcion+=producto.getcodigo_barra()+",";
		sDescripcion+=ProductoConstantesFunciones.IDLINEA+"=";
		sDescripcion+=producto.getid_linea().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=producto.getid_linea_grupo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=producto.getid_linea_categoria().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=producto.getid_linea_marca().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=producto.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN+"=";
		sDescripcion+=producto.getid_tipo_producto_servicio_inven().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDTIPOCOSTEO+"=";
		sDescripcion+=producto.getid_tipo_costeo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=producto.getid_unidad().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDUNIDADPESO+"=";
		sDescripcion+=producto.getid_unidad_peso().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDARANCEL+"=";
		sDescripcion+=producto.getid_arancel().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=producto.getid_cliente().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO+"=";
		sDescripcion+=producto.getid_cliente_proveedor_defecto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=producto.getesta_activo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=producto.getdescripcion()+",";
		sDescripcion+=ProductoConstantesFunciones.PRECIO+"=";
		sDescripcion+=producto.getprecio().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IVA+"=";
		sDescripcion+=producto.getiva().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IVAVALOR+"=";
		sDescripcion+=producto.getiva_valor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ICE+"=";
		sDescripcion+=producto.getice().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ICEVALOR+"=";
		sDescripcion+=producto.getice_valor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=producto.getdescuento().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=producto.getdescuento_valor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ARANCELPORCENTAJE+"=";
		sDescripcion+=producto.getarancel_porcentaje().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ARANCELVALOR+"=";
		sDescripcion+=producto.getarancel_valor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.COMISION+"=";
		sDescripcion+=producto.getcomision().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.COMISIONVALOR+"=";
		sDescripcion+=producto.getcomision_valor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.DIASPRODUCCION+"=";
		sDescripcion+=producto.getdias_produccion().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONSTOCKNEGATIVO+"=";
		sDescripcion+=producto.getcon_stock_negativo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONPRECIOMINIMO+"=";
		sDescripcion+=producto.getcon_precio_minimo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONLOTE+"=";
		sDescripcion+=producto.getcon_lote().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONCONFIRMACION+"=";
		sDescripcion+=producto.getcon_confirmacion().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONPRESUPUESTO+"=";
		sDescripcion+=producto.getcon_presupuesto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONIMPORTACION+"=";
		sDescripcion+=producto.getcon_importacion().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONFINAL+"=";
		sDescripcion+=producto.getcon_final().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONCONSEP+"=";
		sDescripcion+=producto.getcon_consep().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONSERIE+"=";
		sDescripcion+=producto.getcon_serie().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.CONBALANZA+"=";
		sDescripcion+=producto.getcon_balanza().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ALTO+"=";
		sDescripcion+=producto.getalto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.ANCHO+"=";
		sDescripcion+=producto.getancho().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.LARGO+"=";
		sDescripcion+=producto.getlargo().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.VOLUMEN+"=";
		sDescripcion+=producto.getvolumen().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.PESO+"=";
		sDescripcion+=producto.getpeso().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.GRAMOS+"=";
		sDescripcion+=producto.getgramos().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.UNIDADESCAJA+"=";
		sDescripcion+=producto.getunidades_caja().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.MARGEN+"=";
		sDescripcion+=producto.getmargen().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.FACTOR+"=";
		sDescripcion+=producto.getfactor().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.FOB+"=";
		sDescripcion+=producto.getfob().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.FOB2+"=";
		sDescripcion+=producto.getfob2().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=producto.getid_tipo_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDCOLORPRODUCTO+"=";
		sDescripcion+=producto.getid_color_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDCLASEPRODUCTO+"=";
		sDescripcion+=producto.getid_clase_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDEFECTOPRODUCTO+"=";
		sDescripcion+=producto.getid_efecto_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDMARCAPRODUCTO+"=";
		sDescripcion+=producto.getid_marca_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDMODELOPRODUCTO+"=";
		sDescripcion+=producto.getid_modelo_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDMATERIALPRODUCTO+"=";
		sDescripcion+=producto.getid_material_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDSEGMENTOPRODUCTO+"=";
		sDescripcion+=producto.getid_segmento_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.IDTALLAPRODUCTO+"=";
		sDescripcion+=producto.getid_talla_producto().toString()+",";
		sDescripcion+=ProductoConstantesFunciones.GRUPO+"=";
		sDescripcion+=producto.getgrupo()+",";
		sDescripcion+=ProductoConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=producto.getreferencia()+",";
		sDescripcion+=ProductoConstantesFunciones.APLICACION+"=";
		sDescripcion+=producto.getaplicacion()+",";
		sDescripcion+=ProductoConstantesFunciones.PROCEDENCIA+"=";
		sDescripcion+=producto.getprocedencia()+",";
			
		return sDescripcion;
	}
	
	public static void setProductoDescripcion(Producto producto,String sValor) throws Exception {			
		if(producto !=null) {
			producto.setnombre(sValor);;//productoproducto.getnombre().trim();
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

	public static String getTipoProductoServicioInvenDescripcion(TipoProductoServicioInven tipoproductoservicioinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproductoservicioinven!=null/*&&tipoproductoservicioinven.getId()>0*/) {
			sDescripcion=TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(tipoproductoservicioinven);
		}

		return sDescripcion;
	}

	public static String getTipoCosteoDescripcion(TipoCosteo tipocosteo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocosteo!=null/*&&tipocosteo.getId()>0*/) {
			sDescripcion=TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(tipocosteo);
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

	public static String getUnidadPesoDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getArancelDescripcion(Arancel arancel) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(arancel!=null/*&&arancel.getId()>0*/) {
			sDescripcion=ArancelConstantesFunciones.getArancelDescripcion(arancel);
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

	public static String getClienteProveedorDefectoDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproducto!=null/*&&tipoproducto.getId()>0*/) {
			sDescripcion=TipoProductoConstantesFunciones.getTipoProductoDescripcion(tipoproducto);
		}

		return sDescripcion;
	}

	public static String getColorProductoDescripcion(ColorProducto colorproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(colorproducto!=null/*&&colorproducto.getId()>0*/) {
			sDescripcion=ColorProductoConstantesFunciones.getColorProductoDescripcion(colorproducto);
		}

		return sDescripcion;
	}

	public static String getClaseProductoDescripcion(ClaseProducto claseproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(claseproducto!=null/*&&claseproducto.getId()>0*/) {
			sDescripcion=ClaseProductoConstantesFunciones.getClaseProductoDescripcion(claseproducto);
		}

		return sDescripcion;
	}

	public static String getEfectoProductoDescripcion(EfectoProducto efectoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(efectoproducto!=null/*&&efectoproducto.getId()>0*/) {
			sDescripcion=EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(efectoproducto);
		}

		return sDescripcion;
	}

	public static String getMarcaProductoDescripcion(MarcaProducto marcaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(marcaproducto!=null/*&&marcaproducto.getId()>0*/) {
			sDescripcion=MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(marcaproducto);
		}

		return sDescripcion;
	}

	public static String getModeloProductoDescripcion(ModeloProducto modeloproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modeloproducto!=null/*&&modeloproducto.getId()>0*/) {
			sDescripcion=ModeloProductoConstantesFunciones.getModeloProductoDescripcion(modeloproducto);
		}

		return sDescripcion;
	}

	public static String getMaterialProductoDescripcion(MaterialProducto materialproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(materialproducto!=null/*&&materialproducto.getId()>0*/) {
			sDescripcion=MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(materialproducto);
		}

		return sDescripcion;
	}

	public static String getSegmentoProductoDescripcion(SegmentoProducto segmentoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(segmentoproducto!=null/*&&segmentoproducto.getId()>0*/) {
			sDescripcion=SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(segmentoproducto);
		}

		return sDescripcion;
	}

	public static String getTallaProductoDescripcion(TallaProducto tallaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tallaproducto!=null/*&&tallaproducto.getId()>0*/) {
			sDescripcion=TallaProductoConstantesFunciones.getTallaProductoDescripcion(tallaproducto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorNombreExtranjero")) {
			sNombreIndice="Tipo=  Por Nombre Extranjero";
		} else if(sNombreIndice.equals("FK_IdArancel")) {
			sNombreIndice="Tipo=  Por Codigo Arancelario";
		} else if(sNombreIndice.equals("FK_IdClaseProducto")) {
			sNombreIndice="Tipo=  Por Clase Producto";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdClienteProveedorDefecto")) {
			sNombreIndice="Tipo=  Por Cliente Proveedor Defecto";
		} else if(sNombreIndice.equals("FK_IdColorProducto")) {
			sNombreIndice="Tipo=  Por Color Producto";
		} else if(sNombreIndice.equals("FK_IdEfectoProducto")) {
			sNombreIndice="Tipo=  Por Efecto Producto";
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
		} else if(sNombreIndice.equals("FK_IdMarcaProducto")) {
			sNombreIndice="Tipo=  Por Marca Producto";
		} else if(sNombreIndice.equals("FK_IdMaterialProducto")) {
			sNombreIndice="Tipo=  Por Material Producto";
		} else if(sNombreIndice.equals("FK_IdModeloProducto")) {
			sNombreIndice="Tipo=  Por Modelo Producto";
		} else if(sNombreIndice.equals("FK_IdSegmentoProducto")) {
			sNombreIndice="Tipo=  Por Segmento Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTallaProducto")) {
			sNombreIndice="Tipo=  Por Talla Producto";
		} else if(sNombreIndice.equals("FK_IdTipoCosteo")) {
			sNombreIndice="Tipo=  Por Tipo Costeo";
		} else if(sNombreIndice.equals("FK_IdTipoProducto")) {
			sNombreIndice="Tipo=  Por Tipo Producto";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicioInven")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio.";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
		} else if(sNombreIndice.equals("FK_IdUnidadPeso")) {
			sNombreIndice="Tipo=  Por Unidad Peso";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombreExtranjero(String nombre_extranjero) {
		String sDetalleIndice=" Parametros->";
		if(nombre_extranjero!=null) {sDetalleIndice+=" Nombre Extranjero="+nombre_extranjero;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdArancel(Long id_arancel) {
		String sDetalleIndice=" Parametros->";
		if(id_arancel!=null) {sDetalleIndice+=" Codigo Unico De Codigo Arancelario="+id_arancel.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClaseProducto(Long id_clase_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_clase_producto!=null) {sDetalleIndice+=" Codigo Unico De Clase Producto="+id_clase_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClienteProveedorDefecto(Long id_cliente_proveedor_defecto) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_proveedor_defecto!=null) {sDetalleIndice+=" Codigo Unico De Cliente Proveedor Defecto="+id_cliente_proveedor_defecto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdColorProducto(Long id_color_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_color_producto!=null) {sDetalleIndice+=" Codigo Unico De Color Producto="+id_color_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEfectoProducto(Long id_efecto_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_efecto_producto!=null) {sDetalleIndice+=" Codigo Unico De Efecto Producto="+id_efecto_producto.toString();} 

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

	public static String getDetalleIndiceFK_IdMarcaProducto(Long id_marca_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_marca_producto!=null) {sDetalleIndice+=" Codigo Unico De Marca Producto="+id_marca_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMaterialProducto(Long id_material_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_material_producto!=null) {sDetalleIndice+=" Codigo Unico De Material Producto="+id_material_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModeloProducto(Long id_modelo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_modelo_producto!=null) {sDetalleIndice+=" Codigo Unico De Modelo Producto="+id_modelo_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSegmentoProducto(Long id_segmento_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_segmento_producto!=null) {sDetalleIndice+=" Codigo Unico De Segmento Producto="+id_segmento_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTallaProducto(Long id_talla_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_talla_producto!=null) {sDetalleIndice+=" Codigo Unico De Talla Producto="+id_talla_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCosteo(Long id_tipo_costeo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costeo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Costeo="+id_tipo_costeo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicioInven(Long id_tipo_producto_servicio_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio_inven!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio.="+id_tipo_producto_servicio_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidadPeso(Long id_unidad_peso) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad_peso!=null) {sDetalleIndice+=" Codigo Unico De Unidad Peso="+id_unidad_peso.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProducto(Producto producto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		producto.setcodigo(producto.getcodigo().trim());
		producto.setnombre(producto.getnombre().trim());
		producto.setnombre_extranjero(producto.getnombre_extranjero().trim());
		producto.setresumen_detalle(producto.getresumen_detalle().trim());
		producto.setcodigo_barra(producto.getcodigo_barra().trim());
		producto.setdescripcion(producto.getdescripcion().trim());
		producto.setgrupo(producto.getgrupo().trim());
		producto.setreferencia(producto.getreferencia().trim());
		producto.setaplicacion(producto.getaplicacion().trim());
		producto.setprocedencia(producto.getprocedencia().trim());
	}
	
	public static void quitarEspaciosProductos(List<Producto> productos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Producto producto: productos) {
			producto.setcodigo(producto.getcodigo().trim());
			producto.setnombre(producto.getnombre().trim());
			producto.setnombre_extranjero(producto.getnombre_extranjero().trim());
			producto.setresumen_detalle(producto.getresumen_detalle().trim());
			producto.setcodigo_barra(producto.getcodigo_barra().trim());
			producto.setdescripcion(producto.getdescripcion().trim());
			producto.setgrupo(producto.getgrupo().trim());
			producto.setreferencia(producto.getreferencia().trim());
			producto.setaplicacion(producto.getaplicacion().trim());
			producto.setprocedencia(producto.getprocedencia().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProducto(Producto producto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && producto.getConCambioAuxiliar()) {
			producto.setIsDeleted(producto.getIsDeletedAuxiliar());	
			producto.setIsNew(producto.getIsNewAuxiliar());	
			producto.setIsChanged(producto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			producto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			producto.setIsDeletedAuxiliar(false);	
			producto.setIsNewAuxiliar(false);	
			producto.setIsChangedAuxiliar(false);
			
			producto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProductos(List<Producto> productos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Producto producto : productos) {
			if(conAsignarBase && producto.getConCambioAuxiliar()) {
				producto.setIsDeleted(producto.getIsDeletedAuxiliar());	
				producto.setIsNew(producto.getIsNewAuxiliar());	
				producto.setIsChanged(producto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				producto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				producto.setIsDeletedAuxiliar(false);	
				producto.setIsNewAuxiliar(false);	
				producto.setIsChangedAuxiliar(false);
				
				producto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProducto(Producto producto,Boolean conEnteros) throws Exception  {
		producto.setprecio(0.0);
		producto.setiva(0.0);
		producto.setiva_valor(0.0);
		producto.setice(0.0);
		producto.setice_valor(0.0);
		producto.setdescuento(0.0);
		producto.setdescuento_valor(0.0);
		producto.setarancel_porcentaje(0.0);
		producto.setarancel_valor(0.0);
		producto.setcomision(0.0);
		producto.setcomision_valor(0.0);
		producto.setdias_produccion(0.0);
		producto.setalto(0.0);
		producto.setancho(0.0);
		producto.setlargo(0.0);
		producto.setvolumen(0.0);
		producto.setpeso(0.0);
		producto.setgramos(0.0);
		producto.setunidades_caja(0.0);
		producto.setmargen(0.0);
		producto.setfactor(0.0);
		producto.setfob(0.0);
		producto.setfob2(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProductos(List<Producto> productos,Boolean conEnteros) throws Exception  {
		
		for(Producto producto: productos) {
			producto.setprecio(0.0);
			producto.setiva(0.0);
			producto.setiva_valor(0.0);
			producto.setice(0.0);
			producto.setice_valor(0.0);
			producto.setdescuento(0.0);
			producto.setdescuento_valor(0.0);
			producto.setarancel_porcentaje(0.0);
			producto.setarancel_valor(0.0);
			producto.setcomision(0.0);
			producto.setcomision_valor(0.0);
			producto.setdias_produccion(0.0);
			producto.setalto(0.0);
			producto.setancho(0.0);
			producto.setlargo(0.0);
			producto.setvolumen(0.0);
			producto.setpeso(0.0);
			producto.setgramos(0.0);
			producto.setunidades_caja(0.0);
			producto.setmargen(0.0);
			producto.setfactor(0.0);
			producto.setfob(0.0);
			producto.setfob2(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProducto(List<Producto> productos,Producto productoAux) throws Exception  {
		ProductoConstantesFunciones.InicializarValoresProducto(productoAux,true);
		
		for(Producto producto: productos) {
			if(producto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			productoAux.setprecio(productoAux.getprecio()+producto.getprecio());			
			productoAux.setiva(productoAux.getiva()+producto.getiva());			
			productoAux.setiva_valor(productoAux.getiva_valor()+producto.getiva_valor());			
			productoAux.setice(productoAux.getice()+producto.getice());			
			productoAux.setice_valor(productoAux.getice_valor()+producto.getice_valor());			
			productoAux.setdescuento(productoAux.getdescuento()+producto.getdescuento());			
			productoAux.setdescuento_valor(productoAux.getdescuento_valor()+producto.getdescuento_valor());			
			productoAux.setarancel_porcentaje(productoAux.getarancel_porcentaje()+producto.getarancel_porcentaje());			
			productoAux.setarancel_valor(productoAux.getarancel_valor()+producto.getarancel_valor());			
			productoAux.setcomision(productoAux.getcomision()+producto.getcomision());			
			productoAux.setcomision_valor(productoAux.getcomision_valor()+producto.getcomision_valor());			
			productoAux.setdias_produccion(productoAux.getdias_produccion()+producto.getdias_produccion());			
			productoAux.setalto(productoAux.getalto()+producto.getalto());			
			productoAux.setancho(productoAux.getancho()+producto.getancho());			
			productoAux.setlargo(productoAux.getlargo()+producto.getlargo());			
			productoAux.setvolumen(productoAux.getvolumen()+producto.getvolumen());			
			productoAux.setpeso(productoAux.getpeso()+producto.getpeso());			
			productoAux.setgramos(productoAux.getgramos()+producto.getgramos());			
			productoAux.setunidades_caja(productoAux.getunidades_caja()+producto.getunidades_caja());			
			productoAux.setmargen(productoAux.getmargen()+producto.getmargen());			
			productoAux.setfactor(productoAux.getfactor()+producto.getfactor());			
			productoAux.setfob(productoAux.getfob()+producto.getfob());			
			productoAux.setfob2(productoAux.getfob2()+producto.getfob2());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProductoConstantesFunciones.getArrayColumnasGlobalesProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Producto> productos,Producto producto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Producto productoAux: productos) {
			if(productoAux!=null && producto!=null) {
				if((productoAux.getId()==null && producto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(productoAux.getId()!=null && producto.getId()!=null){
					if(productoAux.getId().equals(producto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProducto(List<Producto> productos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double ivaTotal=0.0;
		Double iva_valorTotal=0.0;
		Double iceTotal=0.0;
		Double ice_valorTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double arancel_porcentajeTotal=0.0;
		Double arancel_valorTotal=0.0;
		Double comisionTotal=0.0;
		Double comision_valorTotal=0.0;
		Double dias_produccionTotal=0.0;
		Double altoTotal=0.0;
		Double anchoTotal=0.0;
		Double largoTotal=0.0;
		Double volumenTotal=0.0;
		Double pesoTotal=0.0;
		Double gramosTotal=0.0;
		Double unidades_cajaTotal=0.0;
		Double margenTotal=0.0;
		Double factorTotal=0.0;
		Double fobTotal=0.0;
		Double fob2Total=0.0;
	
		for(Producto producto: productos) {			
			if(producto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=producto.getprecio();
			ivaTotal+=producto.getiva();
			iva_valorTotal+=producto.getiva_valor();
			iceTotal+=producto.getice();
			ice_valorTotal+=producto.getice_valor();
			descuentoTotal+=producto.getdescuento();
			descuento_valorTotal+=producto.getdescuento_valor();
			arancel_porcentajeTotal+=producto.getarancel_porcentaje();
			arancel_valorTotal+=producto.getarancel_valor();
			comisionTotal+=producto.getcomision();
			comision_valorTotal+=producto.getcomision_valor();
			dias_produccionTotal+=producto.getdias_produccion();
			altoTotal+=producto.getalto();
			anchoTotal+=producto.getancho();
			largoTotal+=producto.getlargo();
			volumenTotal+=producto.getvolumen();
			pesoTotal+=producto.getpeso();
			gramosTotal+=producto.getgramos();
			unidades_cajaTotal+=producto.getunidades_caja();
			margenTotal+=producto.getmargen();
			factorTotal+=producto.getfactor();
			fobTotal+=producto.getfob();
			fob2Total+=producto.getfob2();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.IVAVALOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_IVAVALOR);
		datoGeneral.setdValorDouble(iva_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ARANCELPORCENTAJE);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
		datoGeneral.setdValorDouble(arancel_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ARANCELVALOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ARANCELVALOR);
		datoGeneral.setdValorDouble(arancel_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.COMISION);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_COMISION);
		datoGeneral.setdValorDouble(comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.COMISIONVALOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_COMISIONVALOR);
		datoGeneral.setdValorDouble(comision_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.DIASPRODUCCION);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_DIASPRODUCCION);
		datoGeneral.setdValorDouble(dias_produccionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ALTO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ALTO);
		datoGeneral.setdValorDouble(altoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.ANCHO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_ANCHO);
		datoGeneral.setdValorDouble(anchoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.LARGO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_LARGO);
		datoGeneral.setdValorDouble(largoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.VOLUMEN);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_VOLUMEN);
		datoGeneral.setdValorDouble(volumenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.PESO);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_PESO);
		datoGeneral.setdValorDouble(pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.GRAMOS);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_GRAMOS);
		datoGeneral.setdValorDouble(gramosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.UNIDADESCAJA);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_UNIDADESCAJA);
		datoGeneral.setdValorDouble(unidades_cajaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.MARGEN);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_MARGEN);
		datoGeneral.setdValorDouble(margenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.FACTOR);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_FACTOR);
		datoGeneral.setdValorDouble(factorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoConstantesFunciones.FOB2);
		datoGeneral.setsDescripcion(ProductoConstantesFunciones.LABEL_FOB2);
		datoGeneral.setdValorDouble(fob2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ID, ProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_VERSIONROW, ProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDEMPRESA, ProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDSUCURSAL, ProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CODIGO, ProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_NOMBRE, ProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_NOMBREEXTRANJERO, ProductoConstantesFunciones.NOMBREEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_RESUMENDETALLE, ProductoConstantesFunciones.RESUMENDETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CODIGOBARRA, ProductoConstantesFunciones.CODIGOBARRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDLINEA, ProductoConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDLINEAGRUPO, ProductoConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDLINEACATEGORIA, ProductoConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDLINEAMARCA, ProductoConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO, ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN, ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDTIPOCOSTEO, ProductoConstantesFunciones.IDTIPOCOSTEO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDUNIDAD, ProductoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDUNIDADPESO, ProductoConstantesFunciones.IDUNIDADPESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDARANCEL, ProductoConstantesFunciones.IDARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDCLIENTE, ProductoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDCLIENTEPROVEEDORDEFECTO, ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ESTAACTIVO, ProductoConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_DESCRIPCION, ProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_PRECIO, ProductoConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IVA, ProductoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IVAVALOR, ProductoConstantesFunciones.IVAVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ICE, ProductoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ICEVALOR, ProductoConstantesFunciones.ICEVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_DESCUENTO, ProductoConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_DESCUENTOVALOR, ProductoConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE, ProductoConstantesFunciones.ARANCELPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ARANCELVALOR, ProductoConstantesFunciones.ARANCELVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_COMISION, ProductoConstantesFunciones.COMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_COMISIONVALOR, ProductoConstantesFunciones.COMISIONVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_DIASPRODUCCION, ProductoConstantesFunciones.DIASPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONSTOCKNEGATIVO, ProductoConstantesFunciones.CONSTOCKNEGATIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONPRECIOMINIMO, ProductoConstantesFunciones.CONPRECIOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONLOTE, ProductoConstantesFunciones.CONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONCONFIRMACION, ProductoConstantesFunciones.CONCONFIRMACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONPRESUPUESTO, ProductoConstantesFunciones.CONPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONIMPORTACION, ProductoConstantesFunciones.CONIMPORTACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONFINAL, ProductoConstantesFunciones.CONFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONCONSEP, ProductoConstantesFunciones.CONCONSEP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONSERIE, ProductoConstantesFunciones.CONSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_CONBALANZA, ProductoConstantesFunciones.CONBALANZA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ALTO, ProductoConstantesFunciones.ALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_ANCHO, ProductoConstantesFunciones.ANCHO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_LARGO, ProductoConstantesFunciones.LARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_VOLUMEN, ProductoConstantesFunciones.VOLUMEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_PESO, ProductoConstantesFunciones.PESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_GRAMOS, ProductoConstantesFunciones.GRAMOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_UNIDADESCAJA, ProductoConstantesFunciones.UNIDADESCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_MARGEN, ProductoConstantesFunciones.MARGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_FACTOR, ProductoConstantesFunciones.FACTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_FOB, ProductoConstantesFunciones.FOB,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_FOB2, ProductoConstantesFunciones.FOB2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, ProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDCOLORPRODUCTO, ProductoConstantesFunciones.IDCOLORPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDCLASEPRODUCTO, ProductoConstantesFunciones.IDCLASEPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDEFECTOPRODUCTO, ProductoConstantesFunciones.IDEFECTOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDMARCAPRODUCTO, ProductoConstantesFunciones.IDMARCAPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDMODELOPRODUCTO, ProductoConstantesFunciones.IDMODELOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDMATERIALPRODUCTO, ProductoConstantesFunciones.IDMATERIALPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO, ProductoConstantesFunciones.IDSEGMENTOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_IDTALLAPRODUCTO, ProductoConstantesFunciones.IDTALLAPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_GRUPO, ProductoConstantesFunciones.GRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_REFERENCIA, ProductoConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_APLICACION, ProductoConstantesFunciones.APLICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProductoConstantesFunciones.LABEL_PROCEDENCIA, ProductoConstantesFunciones.PROCEDENCIA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.NOMBREEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.RESUMENDETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CODIGOBARRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDTIPOCOSTEO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDUNIDADPESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IVAVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ICEVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ARANCELPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ARANCELVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.COMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.COMISIONVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.DIASPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONSTOCKNEGATIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONPRECIOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONCONFIRMACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONIMPORTACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONCONSEP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.CONBALANZA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.ANCHO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.LARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.VOLUMEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.PESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.GRAMOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.UNIDADESCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.MARGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.FACTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.FOB;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.FOB2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDCOLORPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDCLASEPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDEFECTOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDMARCAPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDMODELOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDMATERIALPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDSEGMENTOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.IDTALLAPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.GRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.APLICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProductoConstantesFunciones.PROCEDENCIA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProducto() throws Exception  {
		return ProductoConstantesFunciones.getTiposSeleccionarProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProducto(Boolean conFk) throws Exception  {
		return ProductoConstantesFunciones.getTiposSeleccionarProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_NOMBREEXTRANJERO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_NOMBREEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_RESUMENDETALLE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_RESUMENDETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CODIGOBARRA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CODIGOBARRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDTIPOCOSTEO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDTIPOCOSTEO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDUNIDADPESO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDUNIDADPESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDARANCEL);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDCLIENTEPROVEEDORDEFECTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDCLIENTEPROVEEDORDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IVAVALOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IVAVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ICEVALOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ICEVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ARANCELVALOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ARANCELVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_COMISION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_COMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_COMISIONVALOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_COMISIONVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_DIASPRODUCCION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_DIASPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONSTOCKNEGATIVO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONSTOCKNEGATIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONPRECIOMINIMO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONPRECIOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONLOTE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONCONFIRMACION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONCONFIRMACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONPRESUPUESTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONIMPORTACION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONIMPORTACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONFINAL);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONCONSEP);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONCONSEP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONSERIE);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_CONBALANZA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_CONBALANZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ALTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_ANCHO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_ANCHO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_LARGO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_LARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_VOLUMEN);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_VOLUMEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_PESO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_PESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_GRAMOS);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_GRAMOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_UNIDADESCAJA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_UNIDADESCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_MARGEN);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_MARGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_FACTOR);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_FACTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_FOB);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_FOB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_FOB2);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_FOB2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDCOLORPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDCOLORPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDCLASEPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDCLASEPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDMARCAPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDMARCAPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDMODELOPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDMODELOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_IDTALLAPRODUCTO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_IDTALLAPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_GRUPO);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_GRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_APLICACION);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_APLICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProductoConstantesFunciones.LABEL_PROCEDENCIA);
			reporte.setsDescripcion(ProductoConstantesFunciones.LABEL_PROCEDENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProducto(Producto productoAux) throws Exception {
		
			productoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoAux.getEmpresa()));
			productoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoAux.getSucursal()));
			productoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLinea()));
			productoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaGrupo()));
			productoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaCategoria()));
			productoAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaMarca()));
			productoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productoAux.getTipoProductoServicio()));
			productoAux.settipoproductoservicioinven_descripcion(TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(productoAux.getTipoProductoServicioInven()));
			productoAux.settipocosteo_descripcion(TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(productoAux.getTipoCosteo()));
			productoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoAux.getUnidad()));
			productoAux.setunidadpeso_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoAux.getUnidadPeso()));
			productoAux.setarancel_descripcion(ArancelConstantesFunciones.getArancelDescripcion(productoAux.getArancel()));
			productoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoAux.getCliente()));
			productoAux.setclienteproveedordefecto_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoAux.getClienteProveedorDefecto()));
			productoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(productoAux.getTipoProducto()));
			productoAux.setcolorproducto_descripcion(ColorProductoConstantesFunciones.getColorProductoDescripcion(productoAux.getColorProducto()));
			productoAux.setclaseproducto_descripcion(ClaseProductoConstantesFunciones.getClaseProductoDescripcion(productoAux.getClaseProducto()));
			productoAux.setefectoproducto_descripcion(EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(productoAux.getEfectoProducto()));
			productoAux.setmarcaproducto_descripcion(MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(productoAux.getMarcaProducto()));
			productoAux.setmodeloproducto_descripcion(ModeloProductoConstantesFunciones.getModeloProductoDescripcion(productoAux.getModeloProducto()));
			productoAux.setmaterialproducto_descripcion(MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(productoAux.getMaterialProducto()));
			productoAux.setsegmentoproducto_descripcion(SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(productoAux.getSegmentoProducto()));
			productoAux.settallaproducto_descripcion(TallaProductoConstantesFunciones.getTallaProductoDescripcion(productoAux.getTallaProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProducto(List<Producto> productosTemp) throws Exception {
		for(Producto productoAux:productosTemp) {
			
			productoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(productoAux.getEmpresa()));
			productoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(productoAux.getSucursal()));
			productoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLinea()));
			productoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaGrupo()));
			productoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaCategoria()));
			productoAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(productoAux.getLineaMarca()));
			productoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(productoAux.getTipoProductoServicio()));
			productoAux.settipoproductoservicioinven_descripcion(TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(productoAux.getTipoProductoServicioInven()));
			productoAux.settipocosteo_descripcion(TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(productoAux.getTipoCosteo()));
			productoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoAux.getUnidad()));
			productoAux.setunidadpeso_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(productoAux.getUnidadPeso()));
			productoAux.setarancel_descripcion(ArancelConstantesFunciones.getArancelDescripcion(productoAux.getArancel()));
			productoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoAux.getCliente()));
			productoAux.setclienteproveedordefecto_descripcion(ClienteConstantesFunciones.getClienteDescripcion(productoAux.getClienteProveedorDefecto()));
			productoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(productoAux.getTipoProducto()));
			productoAux.setcolorproducto_descripcion(ColorProductoConstantesFunciones.getColorProductoDescripcion(productoAux.getColorProducto()));
			productoAux.setclaseproducto_descripcion(ClaseProductoConstantesFunciones.getClaseProductoDescripcion(productoAux.getClaseProducto()));
			productoAux.setefectoproducto_descripcion(EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(productoAux.getEfectoProducto()));
			productoAux.setmarcaproducto_descripcion(MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(productoAux.getMarcaProducto()));
			productoAux.setmodeloproducto_descripcion(ModeloProductoConstantesFunciones.getModeloProductoDescripcion(productoAux.getModeloProducto()));
			productoAux.setmaterialproducto_descripcion(MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(productoAux.getMaterialProducto()));
			productoAux.setsegmentoproducto_descripcion(SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(productoAux.getSegmentoProducto()));
			productoAux.settallaproducto_descripcion(TallaProductoConstantesFunciones.getTallaProductoDescripcion(productoAux.getTallaProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(TipoProductoServicio.class));
				classes.add(new Classe(TipoProductoServicioInven.class));
				classes.add(new Classe(TipoCosteo.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Arancel.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoProducto.class));
				classes.add(new Classe(ColorProducto.class));
				classes.add(new Classe(ClaseProducto.class));
				classes.add(new Classe(EfectoProducto.class));
				classes.add(new Classe(MarcaProducto.class));
				classes.add(new Classe(ModeloProducto.class));
				classes.add(new Classe(MaterialProducto.class));
				classes.add(new Classe(SegmentoProducto.class));
				classes.add(new Classe(TallaProducto.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicioInven.class)) {
						classes.add(new Classe(TipoProductoServicioInven.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCosteo.class)) {
						classes.add(new Classe(TipoCosteo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Arancel.class)) {
						classes.add(new Classe(Arancel.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProducto.class)) {
						classes.add(new Classe(TipoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorProducto.class)) {
						classes.add(new Classe(ColorProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClaseProducto.class)) {
						classes.add(new Classe(ClaseProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EfectoProducto.class)) {
						classes.add(new Classe(EfectoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MarcaProducto.class)) {
						classes.add(new Classe(MarcaProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ModeloProducto.class)) {
						classes.add(new Classe(ModeloProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MaterialProducto.class)) {
						classes.add(new Classe(MaterialProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SegmentoProducto.class)) {
						classes.add(new Classe(SegmentoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TallaProducto.class)) {
						classes.add(new Classe(TallaProducto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoProductoServicioInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicioInven.class)); continue;
					}

					if(TipoCosteo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteo.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Arancel.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Arancel.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
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

					if(TipoProductoServicioInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicioInven.class)); continue;
					}

					if(TipoCosteo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteo.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Arancel.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Arancel.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoConstantesFunciones.getClassesRelationshipsOfProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProveedorProducto.class));
				classes.add(new Classe(Precio.class));
				classes.add(new Classe(DetalleImpuestoInven.class));
				classes.add(new Classe(PresupuestoVentas.class));
				classes.add(new Classe(PoliticaProducto.class));
				classes.add(new Classe(SerieProducto.class));
				classes.add(new Classe(UbicacionProdu.class));
				classes.add(new Classe(ParametroProducto.class));
				classes.add(new Classe(ProductoUnidad.class));
				classes.add(new Classe(Ingrediente.class));
				classes.add(new Classe(ProductoCarac.class));
				classes.add(new Classe(ServicioCliente.class));
				classes.add(new Classe(ProductoPromocion.class));
				classes.add(new Classe(ProductoEspeci.class));
				classes.add(new Classe(ProductoReempla.class));
				classes.add(new Classe(ProductoEstadistica.class));
				classes.add(new Classe(PoliticaFactu.class));
				classes.add(new Classe(ProductoCuentaContable.class));
				classes.add(new Classe(BodegaProducto.class));
				classes.add(new Classe(PresupuestoProducto.class));
				classes.add(new Classe(SaldoMesProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProveedorProducto.class)) {
						classes.add(new Classe(ProveedorProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Precio.class)) {
						classes.add(new Classe(Precio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleImpuestoInven.class)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoVentas.class)) {
						classes.add(new Classe(PresupuestoVentas.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticaProducto.class)) {
						classes.add(new Classe(PoliticaProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SerieProducto.class)) {
						classes.add(new Classe(SerieProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UbicacionProdu.class)) {
						classes.add(new Classe(UbicacionProdu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroProducto.class)) {
						classes.add(new Classe(ParametroProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoUnidad.class)) {
						classes.add(new Classe(ProductoUnidad.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ingrediente.class)) {
						classes.add(new Classe(Ingrediente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoCarac.class)) {
						classes.add(new Classe(ProductoCarac.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioCliente.class)) {
						classes.add(new Classe(ServicioCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoPromocion.class)) {
						classes.add(new Classe(ProductoPromocion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoEspeci.class)) {
						classes.add(new Classe(ProductoEspeci.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoReempla.class)) {
						classes.add(new Classe(ProductoReempla.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoEstadistica.class)) {
						classes.add(new Classe(ProductoEstadistica.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticaFactu.class)) {
						classes.add(new Classe(PoliticaFactu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoCuentaContable.class)) {
						classes.add(new Classe(ProductoCuentaContable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(BodegaProducto.class)) {
						classes.add(new Classe(BodegaProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresupuestoProducto.class)) {
						classes.add(new Classe(PresupuestoProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SaldoMesProducto.class)) {
						classes.add(new Classe(SaldoMesProducto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProductoConstantesFunciones.getClassesRelationshipsFromStringsOfProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProveedorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProveedorProducto.class)); continue;
					}

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(DetalleImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(PoliticaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaProducto.class)); continue;
					}

					if(SerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SerieProducto.class)); continue;
					}

					if(UbicacionProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionProdu.class)); continue;
					}

					if(ParametroProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroProducto.class)); continue;
					}

					if(ProductoUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoUnidad.class)); continue;
					}

					if(Ingrediente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ingrediente.class)); continue;
					}

					if(ProductoCarac.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoCarac.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(ProductoPromocion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoPromocion.class)); continue;
					}

					if(ProductoEspeci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoEspeci.class)); continue;
					}

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
					}

					if(ProductoEstadistica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoEstadistica.class)); continue;
					}

					if(PoliticaFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaFactu.class)); continue;
					}

					if(ProductoCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoCuentaContable.class)); continue;
					}

					if(BodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BodegaProducto.class)); continue;
					}

					if(PresupuestoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoProducto.class)); continue;
					}

					if(SaldoMesProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SaldoMesProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProveedorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProveedorProducto.class)); continue;
					}

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(DetalleImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); continue;
					}

					if(PresupuestoVentas.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoVentas.class)); continue;
					}

					if(PoliticaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaProducto.class)); continue;
					}

					if(SerieProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SerieProducto.class)); continue;
					}

					if(UbicacionProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionProdu.class)); continue;
					}

					if(ParametroProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroProducto.class)); continue;
					}

					if(ProductoUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoUnidad.class)); continue;
					}

					if(Ingrediente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ingrediente.class)); continue;
					}

					if(ProductoCarac.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoCarac.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(ProductoPromocion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoPromocion.class)); continue;
					}

					if(ProductoEspeci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoEspeci.class)); continue;
					}

					if(ProductoReempla.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoReempla.class)); continue;
					}

					if(ProductoEstadistica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoEstadistica.class)); continue;
					}

					if(PoliticaFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaFactu.class)); continue;
					}

					if(ProductoCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoCuentaContable.class)); continue;
					}

					if(BodegaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BodegaProducto.class)); continue;
					}

					if(PresupuestoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresupuestoProducto.class)); continue;
					}

					if(SaldoMesProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SaldoMesProducto.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Producto producto,List<Producto> productos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Producto productoEncontrado=null;
			
			for(Producto productoLocal:productos) {
				if(productoLocal.getId().equals(producto.getId())) {
					productoEncontrado=productoLocal;
					
					productoLocal.setIsChanged(producto.getIsChanged());
					productoLocal.setIsNew(producto.getIsNew());
					productoLocal.setIsDeleted(producto.getIsDeleted());
					
					productoLocal.setGeneralEntityOriginal(producto.getGeneralEntityOriginal());
					
					productoLocal.setId(producto.getId());	
					productoLocal.setVersionRow(producto.getVersionRow());	
					productoLocal.setid_empresa(producto.getid_empresa());	
					productoLocal.setid_sucursal(producto.getid_sucursal());	
					productoLocal.setcodigo(producto.getcodigo());	
					productoLocal.setnombre(producto.getnombre());	
					productoLocal.setnombre_extranjero(producto.getnombre_extranjero());	
					productoLocal.setresumen_detalle(producto.getresumen_detalle());	
					productoLocal.setcodigo_barra(producto.getcodigo_barra());	
					productoLocal.setid_linea(producto.getid_linea());	
					productoLocal.setid_linea_grupo(producto.getid_linea_grupo());	
					productoLocal.setid_linea_categoria(producto.getid_linea_categoria());	
					productoLocal.setid_linea_marca(producto.getid_linea_marca());	
					productoLocal.setid_tipo_producto_servicio(producto.getid_tipo_producto_servicio());	
					productoLocal.setid_tipo_producto_servicio_inven(producto.getid_tipo_producto_servicio_inven());	
					productoLocal.setid_tipo_costeo(producto.getid_tipo_costeo());	
					productoLocal.setid_unidad(producto.getid_unidad());	
					productoLocal.setid_unidad_peso(producto.getid_unidad_peso());	
					productoLocal.setid_arancel(producto.getid_arancel());	
					productoLocal.setid_cliente(producto.getid_cliente());	
					productoLocal.setid_cliente_proveedor_defecto(producto.getid_cliente_proveedor_defecto());	
					productoLocal.setesta_activo(producto.getesta_activo());	
					productoLocal.setdescripcion(producto.getdescripcion());	
					productoLocal.setprecio(producto.getprecio());	
					productoLocal.setiva(producto.getiva());	
					productoLocal.setiva_valor(producto.getiva_valor());	
					productoLocal.setice(producto.getice());	
					productoLocal.setice_valor(producto.getice_valor());	
					productoLocal.setdescuento(producto.getdescuento());	
					productoLocal.setdescuento_valor(producto.getdescuento_valor());	
					productoLocal.setarancel_porcentaje(producto.getarancel_porcentaje());	
					productoLocal.setarancel_valor(producto.getarancel_valor());	
					productoLocal.setcomision(producto.getcomision());	
					productoLocal.setcomision_valor(producto.getcomision_valor());	
					productoLocal.setdias_produccion(producto.getdias_produccion());	
					productoLocal.setcon_stock_negativo(producto.getcon_stock_negativo());	
					productoLocal.setcon_precio_minimo(producto.getcon_precio_minimo());	
					productoLocal.setcon_lote(producto.getcon_lote());	
					productoLocal.setcon_confirmacion(producto.getcon_confirmacion());	
					productoLocal.setcon_presupuesto(producto.getcon_presupuesto());	
					productoLocal.setcon_importacion(producto.getcon_importacion());	
					productoLocal.setcon_final(producto.getcon_final());	
					productoLocal.setcon_consep(producto.getcon_consep());	
					productoLocal.setcon_serie(producto.getcon_serie());	
					productoLocal.setcon_balanza(producto.getcon_balanza());	
					productoLocal.setalto(producto.getalto());	
					productoLocal.setancho(producto.getancho());	
					productoLocal.setlargo(producto.getlargo());	
					productoLocal.setvolumen(producto.getvolumen());	
					productoLocal.setpeso(producto.getpeso());	
					productoLocal.setgramos(producto.getgramos());	
					productoLocal.setunidades_caja(producto.getunidades_caja());	
					productoLocal.setmargen(producto.getmargen());	
					productoLocal.setfactor(producto.getfactor());	
					productoLocal.setfob(producto.getfob());	
					productoLocal.setfob2(producto.getfob2());	
					productoLocal.setid_tipo_producto(producto.getid_tipo_producto());	
					productoLocal.setid_color_producto(producto.getid_color_producto());	
					productoLocal.setid_clase_producto(producto.getid_clase_producto());	
					productoLocal.setid_efecto_producto(producto.getid_efecto_producto());	
					productoLocal.setid_marca_producto(producto.getid_marca_producto());	
					productoLocal.setid_modelo_producto(producto.getid_modelo_producto());	
					productoLocal.setid_material_producto(producto.getid_material_producto());	
					productoLocal.setid_segmento_producto(producto.getid_segmento_producto());	
					productoLocal.setid_talla_producto(producto.getid_talla_producto());	
					productoLocal.setgrupo(producto.getgrupo());	
					productoLocal.setreferencia(producto.getreferencia());	
					productoLocal.setaplicacion(producto.getaplicacion());	
					productoLocal.setprocedencia(producto.getprocedencia());	
					
					
					productoLocal.setProveedorProductos(producto.getProveedorProductos());
					productoLocal.setPrecios(producto.getPrecios());
					productoLocal.setDetalleImpuestoInvens(producto.getDetalleImpuestoInvens());
					productoLocal.setPresupuestoVentass(producto.getPresupuestoVentass());
					productoLocal.setPoliticaProductos(producto.getPoliticaProductos());
					productoLocal.setSerieProductos(producto.getSerieProductos());
					productoLocal.setUbicacionProdus(producto.getUbicacionProdus());
					productoLocal.setParametroProductos(producto.getParametroProductos());
					productoLocal.setProductoUnidads(producto.getProductoUnidads());
					productoLocal.setIngredienteRelacions(producto.getIngredienteRelacions());
					productoLocal.setProductoCaracs(producto.getProductoCaracs());
					productoLocal.setServicioClientes(producto.getServicioClientes());
					productoLocal.setProductoPromocionRelacions(producto.getProductoPromocionRelacions());
					productoLocal.setProductoEspecis(producto.getProductoEspecis());
					productoLocal.setProductoReemplas(producto.getProductoReemplas());
					productoLocal.setProductoEstadisticas(producto.getProductoEstadisticas());
					productoLocal.setPoliticaFactus(producto.getPoliticaFactus());
					productoLocal.setProductoCuentaContables(producto.getProductoCuentaContables());
					productoLocal.setBodegaProductos(producto.getBodegaProductos());
					productoLocal.setPresupuestoProductos(producto.getPresupuestoProductos());
					productoLocal.setSaldoMesProductos(producto.getSaldoMesProductos());
					
					existe=true;
					break;
				}
			}
			
			if(!producto.getIsDeleted()) {
				if(!existe) {
					productos.add(producto);
				}
			} else {
				if(productoEncontrado!=null && permiteQuitar)  {
					productos.remove(productoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Producto producto,List<Producto> productos) throws Exception {
		try	{			
			for(Producto productoLocal:productos) {
				if(productoLocal.getId().equals(producto.getId())) {
					productoLocal.setIsSelected(producto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProducto(List<Producto> productosAux) throws Exception {
		//this.productosAux=productosAux;
		
		for(Producto productoAux:productosAux) {
			if(productoAux.getIsChanged()) {
				productoAux.setIsChanged(false);
			}		
			
			if(productoAux.getIsNew()) {
				productoAux.setIsNew(false);
			}	
			
			if(productoAux.getIsDeleted()) {
				productoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProducto(Producto productoAux) throws Exception {
		//this.productoAux=productoAux;
		
			if(productoAux.getIsChanged()) {
				productoAux.setIsChanged(false);
			}		
			
			if(productoAux.getIsNew()) {
				productoAux.setIsNew(false);
			}	
			
			if(productoAux.getIsDeleted()) {
				productoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Producto productoAsignar,Producto producto) throws Exception {
		productoAsignar.setId(producto.getId());	
		productoAsignar.setVersionRow(producto.getVersionRow());	
		productoAsignar.setid_empresa(producto.getid_empresa());
		productoAsignar.setempresa_descripcion(producto.getempresa_descripcion());	
		productoAsignar.setid_sucursal(producto.getid_sucursal());
		productoAsignar.setsucursal_descripcion(producto.getsucursal_descripcion());	
		productoAsignar.setcodigo(producto.getcodigo());	
		productoAsignar.setnombre(producto.getnombre());	
		productoAsignar.setnombre_extranjero(producto.getnombre_extranjero());	
		productoAsignar.setresumen_detalle(producto.getresumen_detalle());	
		productoAsignar.setcodigo_barra(producto.getcodigo_barra());	
		productoAsignar.setid_linea(producto.getid_linea());
		productoAsignar.setlinea_descripcion(producto.getlinea_descripcion());	
		productoAsignar.setid_linea_grupo(producto.getid_linea_grupo());
		productoAsignar.setlineagrupo_descripcion(producto.getlineagrupo_descripcion());	
		productoAsignar.setid_linea_categoria(producto.getid_linea_categoria());
		productoAsignar.setlineacategoria_descripcion(producto.getlineacategoria_descripcion());	
		productoAsignar.setid_linea_marca(producto.getid_linea_marca());
		productoAsignar.setlineamarca_descripcion(producto.getlineamarca_descripcion());	
		productoAsignar.setid_tipo_producto_servicio(producto.getid_tipo_producto_servicio());
		productoAsignar.settipoproductoservicio_descripcion(producto.gettipoproductoservicio_descripcion());	
		productoAsignar.setid_tipo_producto_servicio_inven(producto.getid_tipo_producto_servicio_inven());
		productoAsignar.settipoproductoservicioinven_descripcion(producto.gettipoproductoservicioinven_descripcion());	
		productoAsignar.setid_tipo_costeo(producto.getid_tipo_costeo());
		productoAsignar.settipocosteo_descripcion(producto.gettipocosteo_descripcion());	
		productoAsignar.setid_unidad(producto.getid_unidad());
		productoAsignar.setunidad_descripcion(producto.getunidad_descripcion());	
		productoAsignar.setid_unidad_peso(producto.getid_unidad_peso());
		productoAsignar.setunidadpeso_descripcion(producto.getunidadpeso_descripcion());	
		productoAsignar.setid_arancel(producto.getid_arancel());
		productoAsignar.setarancel_descripcion(producto.getarancel_descripcion());	
		productoAsignar.setid_cliente(producto.getid_cliente());
		productoAsignar.setcliente_descripcion(producto.getcliente_descripcion());	
		productoAsignar.setid_cliente_proveedor_defecto(producto.getid_cliente_proveedor_defecto());
		productoAsignar.setclienteproveedordefecto_descripcion(producto.getclienteproveedordefecto_descripcion());	
		productoAsignar.setesta_activo(producto.getesta_activo());	
		productoAsignar.setdescripcion(producto.getdescripcion());	
		productoAsignar.setprecio(producto.getprecio());	
		productoAsignar.setiva(producto.getiva());	
		productoAsignar.setiva_valor(producto.getiva_valor());	
		productoAsignar.setice(producto.getice());	
		productoAsignar.setice_valor(producto.getice_valor());	
		productoAsignar.setdescuento(producto.getdescuento());	
		productoAsignar.setdescuento_valor(producto.getdescuento_valor());	
		productoAsignar.setarancel_porcentaje(producto.getarancel_porcentaje());	
		productoAsignar.setarancel_valor(producto.getarancel_valor());	
		productoAsignar.setcomision(producto.getcomision());	
		productoAsignar.setcomision_valor(producto.getcomision_valor());	
		productoAsignar.setdias_produccion(producto.getdias_produccion());	
		productoAsignar.setcon_stock_negativo(producto.getcon_stock_negativo());	
		productoAsignar.setcon_precio_minimo(producto.getcon_precio_minimo());	
		productoAsignar.setcon_lote(producto.getcon_lote());	
		productoAsignar.setcon_confirmacion(producto.getcon_confirmacion());	
		productoAsignar.setcon_presupuesto(producto.getcon_presupuesto());	
		productoAsignar.setcon_importacion(producto.getcon_importacion());	
		productoAsignar.setcon_final(producto.getcon_final());	
		productoAsignar.setcon_consep(producto.getcon_consep());	
		productoAsignar.setcon_serie(producto.getcon_serie());	
		productoAsignar.setcon_balanza(producto.getcon_balanza());	
		productoAsignar.setalto(producto.getalto());	
		productoAsignar.setancho(producto.getancho());	
		productoAsignar.setlargo(producto.getlargo());	
		productoAsignar.setvolumen(producto.getvolumen());	
		productoAsignar.setpeso(producto.getpeso());	
		productoAsignar.setgramos(producto.getgramos());	
		productoAsignar.setunidades_caja(producto.getunidades_caja());	
		productoAsignar.setmargen(producto.getmargen());	
		productoAsignar.setfactor(producto.getfactor());	
		productoAsignar.setfob(producto.getfob());	
		productoAsignar.setfob2(producto.getfob2());	
		productoAsignar.setid_tipo_producto(producto.getid_tipo_producto());
		productoAsignar.settipoproducto_descripcion(producto.gettipoproducto_descripcion());	
		productoAsignar.setid_color_producto(producto.getid_color_producto());
		productoAsignar.setcolorproducto_descripcion(producto.getcolorproducto_descripcion());	
		productoAsignar.setid_clase_producto(producto.getid_clase_producto());
		productoAsignar.setclaseproducto_descripcion(producto.getclaseproducto_descripcion());	
		productoAsignar.setid_efecto_producto(producto.getid_efecto_producto());
		productoAsignar.setefectoproducto_descripcion(producto.getefectoproducto_descripcion());	
		productoAsignar.setid_marca_producto(producto.getid_marca_producto());
		productoAsignar.setmarcaproducto_descripcion(producto.getmarcaproducto_descripcion());	
		productoAsignar.setid_modelo_producto(producto.getid_modelo_producto());
		productoAsignar.setmodeloproducto_descripcion(producto.getmodeloproducto_descripcion());	
		productoAsignar.setid_material_producto(producto.getid_material_producto());
		productoAsignar.setmaterialproducto_descripcion(producto.getmaterialproducto_descripcion());	
		productoAsignar.setid_segmento_producto(producto.getid_segmento_producto());
		productoAsignar.setsegmentoproducto_descripcion(producto.getsegmentoproducto_descripcion());	
		productoAsignar.setid_talla_producto(producto.getid_talla_producto());
		productoAsignar.settallaproducto_descripcion(producto.gettallaproducto_descripcion());	
		productoAsignar.setgrupo(producto.getgrupo());	
		productoAsignar.setreferencia(producto.getreferencia());	
		productoAsignar.setaplicacion(producto.getaplicacion());	
		productoAsignar.setprocedencia(producto.getprocedencia());	
	}
	
	public static void inicializarProducto(Producto producto) throws Exception {
		try {
				producto.setId(0L);	
					
				producto.setid_empresa(-1L);	
				producto.setid_sucursal(-1L);	
				producto.setcodigo("");	
				producto.setnombre("");	
				producto.setnombre_extranjero("");	
				producto.setresumen_detalle("");	
				producto.setcodigo_barra("");	
				producto.setid_linea(-1L);	
				producto.setid_linea_grupo(null);	
				producto.setid_linea_categoria(null);	
				producto.setid_linea_marca(null);	
				producto.setid_tipo_producto_servicio(-1L);	
				producto.setid_tipo_producto_servicio_inven(-1L);	
				producto.setid_tipo_costeo(-1L);	
				producto.setid_unidad(-1L);	
				producto.setid_unidad_peso(-1L);	
				producto.setid_arancel(-1L);	
				producto.setid_cliente(-1L);	
				producto.setid_cliente_proveedor_defecto(-1L);	
				producto.setesta_activo(false);	
				producto.setdescripcion("");	
				producto.setprecio(0.0);	
				producto.setiva(0.0);	
				producto.setiva_valor(0.0);	
				producto.setice(0.0);	
				producto.setice_valor(0.0);	
				producto.setdescuento(0.0);	
				producto.setdescuento_valor(0.0);	
				producto.setarancel_porcentaje(0.0);	
				producto.setarancel_valor(0.0);	
				producto.setcomision(0.0);	
				producto.setcomision_valor(0.0);	
				producto.setdias_produccion(0.0);	
				producto.setcon_stock_negativo(false);	
				producto.setcon_precio_minimo(false);	
				producto.setcon_lote(false);	
				producto.setcon_confirmacion(false);	
				producto.setcon_presupuesto(false);	
				producto.setcon_importacion(false);	
				producto.setcon_final(false);	
				producto.setcon_consep(false);	
				producto.setcon_serie(false);	
				producto.setcon_balanza(false);	
				producto.setalto(0.0);	
				producto.setancho(0.0);	
				producto.setlargo(0.0);	
				producto.setvolumen(0.0);	
				producto.setpeso(0.0);	
				producto.setgramos(0.0);	
				producto.setunidades_caja(0.0);	
				producto.setmargen(0.0);	
				producto.setfactor(0.0);	
				producto.setfob(0.0);	
				producto.setfob2(0.0);	
				producto.setid_tipo_producto(-1L);	
				producto.setid_color_producto(-1L);	
				producto.setid_clase_producto(-1L);	
				producto.setid_efecto_producto(-1L);	
				producto.setid_marca_producto(-1L);	
				producto.setid_modelo_producto(-1L);	
				producto.setid_material_producto(-1L);	
				producto.setid_segmento_producto(-1L);	
				producto.setid_talla_producto(-1L);	
				producto.setgrupo("");	
				producto.setreferencia("");	
				producto.setaplicacion("");	
				producto.setprocedencia("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_NOMBREEXTRANJERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_RESUMENDETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CODIGOBARRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDTIPOCOSTEO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDUNIDADPESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDCLIENTEPROVEEDORDEFECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IVAVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ICEVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ARANCELPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ARANCELVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_COMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_COMISIONVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_DIASPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONSTOCKNEGATIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONPRECIOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONCONFIRMACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONPRESUPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONIMPORTACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONCONSEP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_CONBALANZA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_ANCHO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_LARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_VOLUMEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_PESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_GRAMOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_UNIDADESCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_MARGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_FACTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_FOB);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_FOB2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDCOLORPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDCLASEPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDMARCAPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDMODELOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_IDTALLAPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_GRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_APLICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProductoConstantesFunciones.LABEL_PROCEDENCIA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProducto(String sTipo,Row row,Workbook workbook,Producto producto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getnombre_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getresumen_detalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcodigo_barra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.gettipoproductoservicioinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.gettipocosteo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getunidadpeso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getarancel_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getclienteproveedordefecto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getiva_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getice_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getarancel_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getarancel_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcomision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcomision_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getdias_produccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_stock_negativo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_precio_minimo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_lote()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_confirmacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_presupuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_importacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_final()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_consep()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_serie()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(producto.getcon_balanza()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getalto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getancho());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getlargo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getvolumen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getpeso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getgramos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getunidades_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getmargen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getfactor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getfob());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getfob2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getcolorproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getclaseproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getefectoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getmarcaproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getmodeloproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getmaterialproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getsegmentoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.gettallaproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getgrupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getaplicacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(producto.getprocedencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProducto() {
		return this.sFinalQueryProducto;
	}
	
	public void setsFinalQueryProducto(String sFinalQueryProducto) {
		this.sFinalQueryProducto= sFinalQueryProducto;
	}
	
	public Border resaltarSeleccionarProducto=null;
	
	public Border setResaltarSeleccionarProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProducto() {
		return this.resaltarSeleccionarProducto;
	}
	
	public void setResaltarSeleccionarProducto(Border borderResaltarSeleccionarProducto) {
		this.resaltarSeleccionarProducto= borderResaltarSeleccionarProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProducto=null;
	public Boolean mostraridProducto=true;
	public Boolean activaridProducto=true;

	public Border resaltarid_empresaProducto=null;
	public Boolean mostrarid_empresaProducto=true;
	public Boolean activarid_empresaProducto=true;
	public Boolean cargarid_empresaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalProducto=null;
	public Boolean mostrarid_sucursalProducto=true;
	public Boolean activarid_sucursalProducto=true;
	public Boolean cargarid_sucursalProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProducto=false;//ConEventDepend=true

	public Border resaltarcodigoProducto=null;
	public Boolean mostrarcodigoProducto=true;
	public Boolean activarcodigoProducto=true;

	public Border resaltarnombreProducto=null;
	public Boolean mostrarnombreProducto=true;
	public Boolean activarnombreProducto=true;

	public Border resaltarnombre_extranjeroProducto=null;
	public Boolean mostrarnombre_extranjeroProducto=true;
	public Boolean activarnombre_extranjeroProducto=true;

	public Border resaltarresumen_detalleProducto=null;
	public Boolean mostrarresumen_detalleProducto=true;
	public Boolean activarresumen_detalleProducto=true;

	public Border resaltarcodigo_barraProducto=null;
	public Boolean mostrarcodigo_barraProducto=true;
	public Boolean activarcodigo_barraProducto=true;

	public Border resaltarid_lineaProducto=null;
	public Boolean mostrarid_lineaProducto=true;
	public Boolean activarid_lineaProducto=true;
	public Boolean cargarid_lineaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProducto=null;
	public Boolean mostrarid_linea_grupoProducto=true;
	public Boolean activarid_linea_grupoProducto=true;
	public Boolean cargarid_linea_grupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProducto=true;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProducto=null;
	public Boolean mostrarid_linea_categoriaProducto=true;
	public Boolean activarid_linea_categoriaProducto=true;
	public Boolean cargarid_linea_categoriaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProducto=true;//ConEventDepend=true

	public Border resaltarid_linea_marcaProducto=null;
	public Boolean mostrarid_linea_marcaProducto=true;
	public Boolean activarid_linea_marcaProducto=true;
	public Boolean cargarid_linea_marcaProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProducto=true;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioProducto=null;
	public Boolean mostrarid_tipo_producto_servicioProducto=true;
	public Boolean activarid_tipo_producto_servicioProducto=true;
	public Boolean cargarid_tipo_producto_servicioProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicio_invenProducto=null;
	public Boolean mostrarid_tipo_producto_servicio_invenProducto=true;
	public Boolean activarid_tipo_producto_servicio_invenProducto=true;
	public Boolean cargarid_tipo_producto_servicio_invenProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicio_invenProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_costeoProducto=null;
	public Boolean mostrarid_tipo_costeoProducto=true;
	public Boolean activarid_tipo_costeoProducto=true;
	public Boolean cargarid_tipo_costeoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costeoProducto=false;//ConEventDepend=true

	public Border resaltarid_unidadProducto=null;
	public Boolean mostrarid_unidadProducto=true;
	public Boolean activarid_unidadProducto=true;
	public Boolean cargarid_unidadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadProducto=false;//ConEventDepend=true

	public Border resaltarid_unidad_pesoProducto=null;
	public Boolean mostrarid_unidad_pesoProducto=true;
	public Boolean activarid_unidad_pesoProducto=true;
	public Boolean cargarid_unidad_pesoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidad_pesoProducto=false;//ConEventDepend=true

	public Border resaltarid_arancelProducto=null;
	public Boolean mostrarid_arancelProducto=true;
	public Boolean activarid_arancelProducto=true;
	public Boolean cargarid_arancelProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_arancelProducto=false;//ConEventDepend=true

	public Border resaltarid_clienteProducto=null;
	public Boolean mostrarid_clienteProducto=true;
	public Boolean activarid_clienteProducto=true;
	public Boolean cargarid_clienteProducto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteProducto=false;//ConEventDepend=true

	public Border resaltarid_cliente_proveedor_defectoProducto=null;
	public Boolean mostrarid_cliente_proveedor_defectoProducto=true;
	public Boolean activarid_cliente_proveedor_defectoProducto=true;
	public Boolean cargarid_cliente_proveedor_defectoProducto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_proveedor_defectoProducto=false;//ConEventDepend=true

	public Border resaltaresta_activoProducto=null;
	public Boolean mostraresta_activoProducto=true;
	public Boolean activaresta_activoProducto=true;

	public Border resaltardescripcionProducto=null;
	public Boolean mostrardescripcionProducto=true;
	public Boolean activardescripcionProducto=true;

	public Border resaltarprecioProducto=null;
	public Boolean mostrarprecioProducto=true;
	public Boolean activarprecioProducto=true;

	public Border resaltarivaProducto=null;
	public Boolean mostrarivaProducto=true;
	public Boolean activarivaProducto=true;

	public Border resaltariva_valorProducto=null;
	public Boolean mostrariva_valorProducto=true;
	public Boolean activariva_valorProducto=true;

	public Border resaltariceProducto=null;
	public Boolean mostrariceProducto=true;
	public Boolean activariceProducto=true;

	public Border resaltarice_valorProducto=null;
	public Boolean mostrarice_valorProducto=true;
	public Boolean activarice_valorProducto=true;

	public Border resaltardescuentoProducto=null;
	public Boolean mostrardescuentoProducto=true;
	public Boolean activardescuentoProducto=true;

	public Border resaltardescuento_valorProducto=null;
	public Boolean mostrardescuento_valorProducto=true;
	public Boolean activardescuento_valorProducto=true;

	public Border resaltararancel_porcentajeProducto=null;
	public Boolean mostrararancel_porcentajeProducto=true;
	public Boolean activararancel_porcentajeProducto=true;

	public Border resaltararancel_valorProducto=null;
	public Boolean mostrararancel_valorProducto=true;
	public Boolean activararancel_valorProducto=true;

	public Border resaltarcomisionProducto=null;
	public Boolean mostrarcomisionProducto=true;
	public Boolean activarcomisionProducto=true;

	public Border resaltarcomision_valorProducto=null;
	public Boolean mostrarcomision_valorProducto=true;
	public Boolean activarcomision_valorProducto=true;

	public Border resaltardias_produccionProducto=null;
	public Boolean mostrardias_produccionProducto=true;
	public Boolean activardias_produccionProducto=true;

	public Border resaltarcon_stock_negativoProducto=null;
	public Boolean mostrarcon_stock_negativoProducto=true;
	public Boolean activarcon_stock_negativoProducto=true;

	public Border resaltarcon_precio_minimoProducto=null;
	public Boolean mostrarcon_precio_minimoProducto=true;
	public Boolean activarcon_precio_minimoProducto=true;

	public Border resaltarcon_loteProducto=null;
	public Boolean mostrarcon_loteProducto=true;
	public Boolean activarcon_loteProducto=true;

	public Border resaltarcon_confirmacionProducto=null;
	public Boolean mostrarcon_confirmacionProducto=true;
	public Boolean activarcon_confirmacionProducto=true;

	public Border resaltarcon_presupuestoProducto=null;
	public Boolean mostrarcon_presupuestoProducto=true;
	public Boolean activarcon_presupuestoProducto=true;

	public Border resaltarcon_importacionProducto=null;
	public Boolean mostrarcon_importacionProducto=true;
	public Boolean activarcon_importacionProducto=true;

	public Border resaltarcon_finalProducto=null;
	public Boolean mostrarcon_finalProducto=true;
	public Boolean activarcon_finalProducto=true;

	public Border resaltarcon_consepProducto=null;
	public Boolean mostrarcon_consepProducto=true;
	public Boolean activarcon_consepProducto=true;

	public Border resaltarcon_serieProducto=null;
	public Boolean mostrarcon_serieProducto=true;
	public Boolean activarcon_serieProducto=true;

	public Border resaltarcon_balanzaProducto=null;
	public Boolean mostrarcon_balanzaProducto=true;
	public Boolean activarcon_balanzaProducto=true;

	public Border resaltaraltoProducto=null;
	public Boolean mostraraltoProducto=true;
	public Boolean activaraltoProducto=true;

	public Border resaltaranchoProducto=null;
	public Boolean mostraranchoProducto=true;
	public Boolean activaranchoProducto=true;

	public Border resaltarlargoProducto=null;
	public Boolean mostrarlargoProducto=true;
	public Boolean activarlargoProducto=true;

	public Border resaltarvolumenProducto=null;
	public Boolean mostrarvolumenProducto=true;
	public Boolean activarvolumenProducto=true;

	public Border resaltarpesoProducto=null;
	public Boolean mostrarpesoProducto=true;
	public Boolean activarpesoProducto=true;

	public Border resaltargramosProducto=null;
	public Boolean mostrargramosProducto=true;
	public Boolean activargramosProducto=true;

	public Border resaltarunidades_cajaProducto=null;
	public Boolean mostrarunidades_cajaProducto=true;
	public Boolean activarunidades_cajaProducto=true;

	public Border resaltarmargenProducto=null;
	public Boolean mostrarmargenProducto=true;
	public Boolean activarmargenProducto=true;

	public Border resaltarfactorProducto=null;
	public Boolean mostrarfactorProducto=true;
	public Boolean activarfactorProducto=true;

	public Border resaltarfobProducto=null;
	public Boolean mostrarfobProducto=true;
	public Boolean activarfobProducto=true;

	public Border resaltarfob2Producto=null;
	public Boolean mostrarfob2Producto=true;
	public Boolean activarfob2Producto=true;

	public Border resaltarid_tipo_productoProducto=null;
	public Boolean mostrarid_tipo_productoProducto=true;
	public Boolean activarid_tipo_productoProducto=true;
	public Boolean cargarid_tipo_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_color_productoProducto=null;
	public Boolean mostrarid_color_productoProducto=true;
	public Boolean activarid_color_productoProducto=true;
	public Boolean cargarid_color_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_color_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_clase_productoProducto=null;
	public Boolean mostrarid_clase_productoProducto=true;
	public Boolean activarid_clase_productoProducto=true;
	public Boolean cargarid_clase_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clase_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_efecto_productoProducto=null;
	public Boolean mostrarid_efecto_productoProducto=true;
	public Boolean activarid_efecto_productoProducto=true;
	public Boolean cargarid_efecto_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_efecto_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_marca_productoProducto=null;
	public Boolean mostrarid_marca_productoProducto=true;
	public Boolean activarid_marca_productoProducto=true;
	public Boolean cargarid_marca_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_marca_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_modelo_productoProducto=null;
	public Boolean mostrarid_modelo_productoProducto=true;
	public Boolean activarid_modelo_productoProducto=true;
	public Boolean cargarid_modelo_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_modelo_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_material_productoProducto=null;
	public Boolean mostrarid_material_productoProducto=true;
	public Boolean activarid_material_productoProducto=true;
	public Boolean cargarid_material_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_material_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_segmento_productoProducto=null;
	public Boolean mostrarid_segmento_productoProducto=true;
	public Boolean activarid_segmento_productoProducto=true;
	public Boolean cargarid_segmento_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_segmento_productoProducto=false;//ConEventDepend=true

	public Border resaltarid_talla_productoProducto=null;
	public Boolean mostrarid_talla_productoProducto=true;
	public Boolean activarid_talla_productoProducto=true;
	public Boolean cargarid_talla_productoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_talla_productoProducto=false;//ConEventDepend=true

	public Border resaltargrupoProducto=null;
	public Boolean mostrargrupoProducto=true;
	public Boolean activargrupoProducto=true;

	public Border resaltarreferenciaProducto=null;
	public Boolean mostrarreferenciaProducto=true;
	public Boolean activarreferenciaProducto=true;

	public Border resaltaraplicacionProducto=null;
	public Boolean mostraraplicacionProducto=true;
	public Boolean activaraplicacionProducto=true;

	public Border resaltarprocedenciaProducto=null;
	public Boolean mostrarprocedenciaProducto=true;
	public Boolean activarprocedenciaProducto=true;

	
	

	public Border setResaltaridProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltaridProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProducto() {
		return this.resaltaridProducto;
	}

	public void setResaltaridProducto(Border borderResaltar) {
		this.resaltaridProducto= borderResaltar;
	}

	public Boolean getMostraridProducto() {
		return this.mostraridProducto;
	}

	public void setMostraridProducto(Boolean mostraridProducto) {
		this.mostraridProducto= mostraridProducto;
	}

	public Boolean getActivaridProducto() {
		return this.activaridProducto;
	}

	public void setActivaridProducto(Boolean activaridProducto) {
		this.activaridProducto= activaridProducto;
	}

	public Border setResaltarid_empresaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProducto() {
		return this.resaltarid_empresaProducto;
	}

	public void setResaltarid_empresaProducto(Border borderResaltar) {
		this.resaltarid_empresaProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaProducto() {
		return this.mostrarid_empresaProducto;
	}

	public void setMostrarid_empresaProducto(Boolean mostrarid_empresaProducto) {
		this.mostrarid_empresaProducto= mostrarid_empresaProducto;
	}

	public Boolean getActivarid_empresaProducto() {
		return this.activarid_empresaProducto;
	}

	public void setActivarid_empresaProducto(Boolean activarid_empresaProducto) {
		this.activarid_empresaProducto= activarid_empresaProducto;
	}

	public Boolean getCargarid_empresaProducto() {
		return this.cargarid_empresaProducto;
	}

	public void setCargarid_empresaProducto(Boolean cargarid_empresaProducto) {
		this.cargarid_empresaProducto= cargarid_empresaProducto;
	}

	public Border setResaltarid_sucursalProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProducto() {
		return this.resaltarid_sucursalProducto;
	}

	public void setResaltarid_sucursalProducto(Border borderResaltar) {
		this.resaltarid_sucursalProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProducto() {
		return this.mostrarid_sucursalProducto;
	}

	public void setMostrarid_sucursalProducto(Boolean mostrarid_sucursalProducto) {
		this.mostrarid_sucursalProducto= mostrarid_sucursalProducto;
	}

	public Boolean getActivarid_sucursalProducto() {
		return this.activarid_sucursalProducto;
	}

	public void setActivarid_sucursalProducto(Boolean activarid_sucursalProducto) {
		this.activarid_sucursalProducto= activarid_sucursalProducto;
	}

	public Boolean getCargarid_sucursalProducto() {
		return this.cargarid_sucursalProducto;
	}

	public void setCargarid_sucursalProducto(Boolean cargarid_sucursalProducto) {
		this.cargarid_sucursalProducto= cargarid_sucursalProducto;
	}

	public Border setResaltarcodigoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProducto() {
		return this.resaltarcodigoProducto;
	}

	public void setResaltarcodigoProducto(Border borderResaltar) {
		this.resaltarcodigoProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoProducto() {
		return this.mostrarcodigoProducto;
	}

	public void setMostrarcodigoProducto(Boolean mostrarcodigoProducto) {
		this.mostrarcodigoProducto= mostrarcodigoProducto;
	}

	public Boolean getActivarcodigoProducto() {
		return this.activarcodigoProducto;
	}

	public void setActivarcodigoProducto(Boolean activarcodigoProducto) {
		this.activarcodigoProducto= activarcodigoProducto;
	}

	public Border setResaltarnombreProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarnombreProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProducto() {
		return this.resaltarnombreProducto;
	}

	public void setResaltarnombreProducto(Border borderResaltar) {
		this.resaltarnombreProducto= borderResaltar;
	}

	public Boolean getMostrarnombreProducto() {
		return this.mostrarnombreProducto;
	}

	public void setMostrarnombreProducto(Boolean mostrarnombreProducto) {
		this.mostrarnombreProducto= mostrarnombreProducto;
	}

	public Boolean getActivarnombreProducto() {
		return this.activarnombreProducto;
	}

	public void setActivarnombreProducto(Boolean activarnombreProducto) {
		this.activarnombreProducto= activarnombreProducto;
	}

	public Border setResaltarnombre_extranjeroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarnombre_extranjeroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_extranjeroProducto() {
		return this.resaltarnombre_extranjeroProducto;
	}

	public void setResaltarnombre_extranjeroProducto(Border borderResaltar) {
		this.resaltarnombre_extranjeroProducto= borderResaltar;
	}

	public Boolean getMostrarnombre_extranjeroProducto() {
		return this.mostrarnombre_extranjeroProducto;
	}

	public void setMostrarnombre_extranjeroProducto(Boolean mostrarnombre_extranjeroProducto) {
		this.mostrarnombre_extranjeroProducto= mostrarnombre_extranjeroProducto;
	}

	public Boolean getActivarnombre_extranjeroProducto() {
		return this.activarnombre_extranjeroProducto;
	}

	public void setActivarnombre_extranjeroProducto(Boolean activarnombre_extranjeroProducto) {
		this.activarnombre_extranjeroProducto= activarnombre_extranjeroProducto;
	}

	public Border setResaltarresumen_detalleProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarresumen_detalleProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresumen_detalleProducto() {
		return this.resaltarresumen_detalleProducto;
	}

	public void setResaltarresumen_detalleProducto(Border borderResaltar) {
		this.resaltarresumen_detalleProducto= borderResaltar;
	}

	public Boolean getMostrarresumen_detalleProducto() {
		return this.mostrarresumen_detalleProducto;
	}

	public void setMostrarresumen_detalleProducto(Boolean mostrarresumen_detalleProducto) {
		this.mostrarresumen_detalleProducto= mostrarresumen_detalleProducto;
	}

	public Boolean getActivarresumen_detalleProducto() {
		return this.activarresumen_detalleProducto;
	}

	public void setActivarresumen_detalleProducto(Boolean activarresumen_detalleProducto) {
		this.activarresumen_detalleProducto= activarresumen_detalleProducto;
	}

	public Border setResaltarcodigo_barraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcodigo_barraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_barraProducto() {
		return this.resaltarcodigo_barraProducto;
	}

	public void setResaltarcodigo_barraProducto(Border borderResaltar) {
		this.resaltarcodigo_barraProducto= borderResaltar;
	}

	public Boolean getMostrarcodigo_barraProducto() {
		return this.mostrarcodigo_barraProducto;
	}

	public void setMostrarcodigo_barraProducto(Boolean mostrarcodigo_barraProducto) {
		this.mostrarcodigo_barraProducto= mostrarcodigo_barraProducto;
	}

	public Boolean getActivarcodigo_barraProducto() {
		return this.activarcodigo_barraProducto;
	}

	public void setActivarcodigo_barraProducto(Boolean activarcodigo_barraProducto) {
		this.activarcodigo_barraProducto= activarcodigo_barraProducto;
	}

	public Border setResaltarid_lineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_lineaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProducto() {
		return this.resaltarid_lineaProducto;
	}

	public void setResaltarid_lineaProducto(Border borderResaltar) {
		this.resaltarid_lineaProducto= borderResaltar;
	}

	public Boolean getMostrarid_lineaProducto() {
		return this.mostrarid_lineaProducto;
	}

	public void setMostrarid_lineaProducto(Boolean mostrarid_lineaProducto) {
		this.mostrarid_lineaProducto= mostrarid_lineaProducto;
	}

	public Boolean getActivarid_lineaProducto() {
		return this.activarid_lineaProducto;
	}

	public void setActivarid_lineaProducto(Boolean activarid_lineaProducto) {
		this.activarid_lineaProducto= activarid_lineaProducto;
	}

	public Boolean getCargarid_lineaProducto() {
		return this.cargarid_lineaProducto;
	}

	public void setCargarid_lineaProducto(Boolean cargarid_lineaProducto) {
		this.cargarid_lineaProducto= cargarid_lineaProducto;
	}

	public Border setResaltarid_linea_grupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProducto() {
		return this.resaltarid_linea_grupoProducto;
	}

	public void setResaltarid_linea_grupoProducto(Border borderResaltar) {
		this.resaltarid_linea_grupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProducto() {
		return this.mostrarid_linea_grupoProducto;
	}

	public void setMostrarid_linea_grupoProducto(Boolean mostrarid_linea_grupoProducto) {
		this.mostrarid_linea_grupoProducto= mostrarid_linea_grupoProducto;
	}

	public Boolean getActivarid_linea_grupoProducto() {
		return this.activarid_linea_grupoProducto;
	}

	public void setActivarid_linea_grupoProducto(Boolean activarid_linea_grupoProducto) {
		this.activarid_linea_grupoProducto= activarid_linea_grupoProducto;
	}

	public Boolean getCargarid_linea_grupoProducto() {
		return this.cargarid_linea_grupoProducto;
	}

	public void setCargarid_linea_grupoProducto(Boolean cargarid_linea_grupoProducto) {
		this.cargarid_linea_grupoProducto= cargarid_linea_grupoProducto;
	}

	public Border setResaltarid_linea_categoriaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProducto() {
		return this.resaltarid_linea_categoriaProducto;
	}

	public void setResaltarid_linea_categoriaProducto(Border borderResaltar) {
		this.resaltarid_linea_categoriaProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProducto() {
		return this.mostrarid_linea_categoriaProducto;
	}

	public void setMostrarid_linea_categoriaProducto(Boolean mostrarid_linea_categoriaProducto) {
		this.mostrarid_linea_categoriaProducto= mostrarid_linea_categoriaProducto;
	}

	public Boolean getActivarid_linea_categoriaProducto() {
		return this.activarid_linea_categoriaProducto;
	}

	public void setActivarid_linea_categoriaProducto(Boolean activarid_linea_categoriaProducto) {
		this.activarid_linea_categoriaProducto= activarid_linea_categoriaProducto;
	}

	public Boolean getCargarid_linea_categoriaProducto() {
		return this.cargarid_linea_categoriaProducto;
	}

	public void setCargarid_linea_categoriaProducto(Boolean cargarid_linea_categoriaProducto) {
		this.cargarid_linea_categoriaProducto= cargarid_linea_categoriaProducto;
	}

	public Border setResaltarid_linea_marcaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProducto() {
		return this.resaltarid_linea_marcaProducto;
	}

	public void setResaltarid_linea_marcaProducto(Border borderResaltar) {
		this.resaltarid_linea_marcaProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProducto() {
		return this.mostrarid_linea_marcaProducto;
	}

	public void setMostrarid_linea_marcaProducto(Boolean mostrarid_linea_marcaProducto) {
		this.mostrarid_linea_marcaProducto= mostrarid_linea_marcaProducto;
	}

	public Boolean getActivarid_linea_marcaProducto() {
		return this.activarid_linea_marcaProducto;
	}

	public void setActivarid_linea_marcaProducto(Boolean activarid_linea_marcaProducto) {
		this.activarid_linea_marcaProducto= activarid_linea_marcaProducto;
	}

	public Boolean getCargarid_linea_marcaProducto() {
		return this.cargarid_linea_marcaProducto;
	}

	public void setCargarid_linea_marcaProducto(Boolean cargarid_linea_marcaProducto) {
		this.cargarid_linea_marcaProducto= cargarid_linea_marcaProducto;
	}

	public Border setResaltarid_tipo_producto_servicioProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioProducto() {
		return this.resaltarid_tipo_producto_servicioProducto;
	}

	public void setResaltarid_tipo_producto_servicioProducto(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioProducto() {
		return this.mostrarid_tipo_producto_servicioProducto;
	}

	public void setMostrarid_tipo_producto_servicioProducto(Boolean mostrarid_tipo_producto_servicioProducto) {
		this.mostrarid_tipo_producto_servicioProducto= mostrarid_tipo_producto_servicioProducto;
	}

	public Boolean getActivarid_tipo_producto_servicioProducto() {
		return this.activarid_tipo_producto_servicioProducto;
	}

	public void setActivarid_tipo_producto_servicioProducto(Boolean activarid_tipo_producto_servicioProducto) {
		this.activarid_tipo_producto_servicioProducto= activarid_tipo_producto_servicioProducto;
	}

	public Boolean getCargarid_tipo_producto_servicioProducto() {
		return this.cargarid_tipo_producto_servicioProducto;
	}

	public void setCargarid_tipo_producto_servicioProducto(Boolean cargarid_tipo_producto_servicioProducto) {
		this.cargarid_tipo_producto_servicioProducto= cargarid_tipo_producto_servicioProducto;
	}

	public Border setResaltarid_tipo_producto_servicio_invenProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicio_invenProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicio_invenProducto() {
		return this.resaltarid_tipo_producto_servicio_invenProducto;
	}

	public void setResaltarid_tipo_producto_servicio_invenProducto(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicio_invenProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicio_invenProducto() {
		return this.mostrarid_tipo_producto_servicio_invenProducto;
	}

	public void setMostrarid_tipo_producto_servicio_invenProducto(Boolean mostrarid_tipo_producto_servicio_invenProducto) {
		this.mostrarid_tipo_producto_servicio_invenProducto= mostrarid_tipo_producto_servicio_invenProducto;
	}

	public Boolean getActivarid_tipo_producto_servicio_invenProducto() {
		return this.activarid_tipo_producto_servicio_invenProducto;
	}

	public void setActivarid_tipo_producto_servicio_invenProducto(Boolean activarid_tipo_producto_servicio_invenProducto) {
		this.activarid_tipo_producto_servicio_invenProducto= activarid_tipo_producto_servicio_invenProducto;
	}

	public Boolean getCargarid_tipo_producto_servicio_invenProducto() {
		return this.cargarid_tipo_producto_servicio_invenProducto;
	}

	public void setCargarid_tipo_producto_servicio_invenProducto(Boolean cargarid_tipo_producto_servicio_invenProducto) {
		this.cargarid_tipo_producto_servicio_invenProducto= cargarid_tipo_producto_servicio_invenProducto;
	}

	public Border setResaltarid_tipo_costeoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costeoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costeoProducto() {
		return this.resaltarid_tipo_costeoProducto;
	}

	public void setResaltarid_tipo_costeoProducto(Border borderResaltar) {
		this.resaltarid_tipo_costeoProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costeoProducto() {
		return this.mostrarid_tipo_costeoProducto;
	}

	public void setMostrarid_tipo_costeoProducto(Boolean mostrarid_tipo_costeoProducto) {
		this.mostrarid_tipo_costeoProducto= mostrarid_tipo_costeoProducto;
	}

	public Boolean getActivarid_tipo_costeoProducto() {
		return this.activarid_tipo_costeoProducto;
	}

	public void setActivarid_tipo_costeoProducto(Boolean activarid_tipo_costeoProducto) {
		this.activarid_tipo_costeoProducto= activarid_tipo_costeoProducto;
	}

	public Boolean getCargarid_tipo_costeoProducto() {
		return this.cargarid_tipo_costeoProducto;
	}

	public void setCargarid_tipo_costeoProducto(Boolean cargarid_tipo_costeoProducto) {
		this.cargarid_tipo_costeoProducto= cargarid_tipo_costeoProducto;
	}

	public Border setResaltarid_unidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_unidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadProducto() {
		return this.resaltarid_unidadProducto;
	}

	public void setResaltarid_unidadProducto(Border borderResaltar) {
		this.resaltarid_unidadProducto= borderResaltar;
	}

	public Boolean getMostrarid_unidadProducto() {
		return this.mostrarid_unidadProducto;
	}

	public void setMostrarid_unidadProducto(Boolean mostrarid_unidadProducto) {
		this.mostrarid_unidadProducto= mostrarid_unidadProducto;
	}

	public Boolean getActivarid_unidadProducto() {
		return this.activarid_unidadProducto;
	}

	public void setActivarid_unidadProducto(Boolean activarid_unidadProducto) {
		this.activarid_unidadProducto= activarid_unidadProducto;
	}

	public Boolean getCargarid_unidadProducto() {
		return this.cargarid_unidadProducto;
	}

	public void setCargarid_unidadProducto(Boolean cargarid_unidadProducto) {
		this.cargarid_unidadProducto= cargarid_unidadProducto;
	}

	public Border setResaltarid_unidad_pesoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_unidad_pesoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidad_pesoProducto() {
		return this.resaltarid_unidad_pesoProducto;
	}

	public void setResaltarid_unidad_pesoProducto(Border borderResaltar) {
		this.resaltarid_unidad_pesoProducto= borderResaltar;
	}

	public Boolean getMostrarid_unidad_pesoProducto() {
		return this.mostrarid_unidad_pesoProducto;
	}

	public void setMostrarid_unidad_pesoProducto(Boolean mostrarid_unidad_pesoProducto) {
		this.mostrarid_unidad_pesoProducto= mostrarid_unidad_pesoProducto;
	}

	public Boolean getActivarid_unidad_pesoProducto() {
		return this.activarid_unidad_pesoProducto;
	}

	public void setActivarid_unidad_pesoProducto(Boolean activarid_unidad_pesoProducto) {
		this.activarid_unidad_pesoProducto= activarid_unidad_pesoProducto;
	}

	public Boolean getCargarid_unidad_pesoProducto() {
		return this.cargarid_unidad_pesoProducto;
	}

	public void setCargarid_unidad_pesoProducto(Boolean cargarid_unidad_pesoProducto) {
		this.cargarid_unidad_pesoProducto= cargarid_unidad_pesoProducto;
	}

	public Border setResaltarid_arancelProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_arancelProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_arancelProducto() {
		return this.resaltarid_arancelProducto;
	}

	public void setResaltarid_arancelProducto(Border borderResaltar) {
		this.resaltarid_arancelProducto= borderResaltar;
	}

	public Boolean getMostrarid_arancelProducto() {
		return this.mostrarid_arancelProducto;
	}

	public void setMostrarid_arancelProducto(Boolean mostrarid_arancelProducto) {
		this.mostrarid_arancelProducto= mostrarid_arancelProducto;
	}

	public Boolean getActivarid_arancelProducto() {
		return this.activarid_arancelProducto;
	}

	public void setActivarid_arancelProducto(Boolean activarid_arancelProducto) {
		this.activarid_arancelProducto= activarid_arancelProducto;
	}

	public Boolean getCargarid_arancelProducto() {
		return this.cargarid_arancelProducto;
	}

	public void setCargarid_arancelProducto(Boolean cargarid_arancelProducto) {
		this.cargarid_arancelProducto= cargarid_arancelProducto;
	}

	public Border setResaltarid_clienteProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_clienteProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteProducto() {
		return this.resaltarid_clienteProducto;
	}

	public void setResaltarid_clienteProducto(Border borderResaltar) {
		this.resaltarid_clienteProducto= borderResaltar;
	}

	public Boolean getMostrarid_clienteProducto() {
		return this.mostrarid_clienteProducto;
	}

	public void setMostrarid_clienteProducto(Boolean mostrarid_clienteProducto) {
		this.mostrarid_clienteProducto= mostrarid_clienteProducto;
	}

	public Boolean getActivarid_clienteProducto() {
		return this.activarid_clienteProducto;
	}

	public void setActivarid_clienteProducto(Boolean activarid_clienteProducto) {
		this.activarid_clienteProducto= activarid_clienteProducto;
	}

	public Boolean getCargarid_clienteProducto() {
		return this.cargarid_clienteProducto;
	}

	public void setCargarid_clienteProducto(Boolean cargarid_clienteProducto) {
		this.cargarid_clienteProducto= cargarid_clienteProducto;
	}

	public Border setResaltarid_cliente_proveedor_defectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_cliente_proveedor_defectoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_proveedor_defectoProducto() {
		return this.resaltarid_cliente_proveedor_defectoProducto;
	}

	public void setResaltarid_cliente_proveedor_defectoProducto(Border borderResaltar) {
		this.resaltarid_cliente_proveedor_defectoProducto= borderResaltar;
	}

	public Boolean getMostrarid_cliente_proveedor_defectoProducto() {
		return this.mostrarid_cliente_proveedor_defectoProducto;
	}

	public void setMostrarid_cliente_proveedor_defectoProducto(Boolean mostrarid_cliente_proveedor_defectoProducto) {
		this.mostrarid_cliente_proveedor_defectoProducto= mostrarid_cliente_proveedor_defectoProducto;
	}

	public Boolean getActivarid_cliente_proveedor_defectoProducto() {
		return this.activarid_cliente_proveedor_defectoProducto;
	}

	public void setActivarid_cliente_proveedor_defectoProducto(Boolean activarid_cliente_proveedor_defectoProducto) {
		this.activarid_cliente_proveedor_defectoProducto= activarid_cliente_proveedor_defectoProducto;
	}

	public Boolean getCargarid_cliente_proveedor_defectoProducto() {
		return this.cargarid_cliente_proveedor_defectoProducto;
	}

	public void setCargarid_cliente_proveedor_defectoProducto(Boolean cargarid_cliente_proveedor_defectoProducto) {
		this.cargarid_cliente_proveedor_defectoProducto= cargarid_cliente_proveedor_defectoProducto;
	}

	public Border setResaltaresta_activoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltaresta_activoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoProducto() {
		return this.resaltaresta_activoProducto;
	}

	public void setResaltaresta_activoProducto(Border borderResaltar) {
		this.resaltaresta_activoProducto= borderResaltar;
	}

	public Boolean getMostraresta_activoProducto() {
		return this.mostraresta_activoProducto;
	}

	public void setMostraresta_activoProducto(Boolean mostraresta_activoProducto) {
		this.mostraresta_activoProducto= mostraresta_activoProducto;
	}

	public Boolean getActivaresta_activoProducto() {
		return this.activaresta_activoProducto;
	}

	public void setActivaresta_activoProducto(Boolean activaresta_activoProducto) {
		this.activaresta_activoProducto= activaresta_activoProducto;
	}

	public Border setResaltardescripcionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionProducto() {
		return this.resaltardescripcionProducto;
	}

	public void setResaltardescripcionProducto(Border borderResaltar) {
		this.resaltardescripcionProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionProducto() {
		return this.mostrardescripcionProducto;
	}

	public void setMostrardescripcionProducto(Boolean mostrardescripcionProducto) {
		this.mostrardescripcionProducto= mostrardescripcionProducto;
	}

	public Boolean getActivardescripcionProducto() {
		return this.activardescripcionProducto;
	}

	public void setActivardescripcionProducto(Boolean activardescripcionProducto) {
		this.activardescripcionProducto= activardescripcionProducto;
	}

	public Border setResaltarprecioProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarprecioProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProducto() {
		return this.resaltarprecioProducto;
	}

	public void setResaltarprecioProducto(Border borderResaltar) {
		this.resaltarprecioProducto= borderResaltar;
	}

	public Boolean getMostrarprecioProducto() {
		return this.mostrarprecioProducto;
	}

	public void setMostrarprecioProducto(Boolean mostrarprecioProducto) {
		this.mostrarprecioProducto= mostrarprecioProducto;
	}

	public Boolean getActivarprecioProducto() {
		return this.activarprecioProducto;
	}

	public void setActivarprecioProducto(Boolean activarprecioProducto) {
		this.activarprecioProducto= activarprecioProducto;
	}

	public Border setResaltarivaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarivaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaProducto() {
		return this.resaltarivaProducto;
	}

	public void setResaltarivaProducto(Border borderResaltar) {
		this.resaltarivaProducto= borderResaltar;
	}

	public Boolean getMostrarivaProducto() {
		return this.mostrarivaProducto;
	}

	public void setMostrarivaProducto(Boolean mostrarivaProducto) {
		this.mostrarivaProducto= mostrarivaProducto;
	}

	public Boolean getActivarivaProducto() {
		return this.activarivaProducto;
	}

	public void setActivarivaProducto(Boolean activarivaProducto) {
		this.activarivaProducto= activarivaProducto;
	}

	public Border setResaltariva_valorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltariva_valorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_valorProducto() {
		return this.resaltariva_valorProducto;
	}

	public void setResaltariva_valorProducto(Border borderResaltar) {
		this.resaltariva_valorProducto= borderResaltar;
	}

	public Boolean getMostrariva_valorProducto() {
		return this.mostrariva_valorProducto;
	}

	public void setMostrariva_valorProducto(Boolean mostrariva_valorProducto) {
		this.mostrariva_valorProducto= mostrariva_valorProducto;
	}

	public Boolean getActivariva_valorProducto() {
		return this.activariva_valorProducto;
	}

	public void setActivariva_valorProducto(Boolean activariva_valorProducto) {
		this.activariva_valorProducto= activariva_valorProducto;
	}

	public Border setResaltariceProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltariceProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceProducto() {
		return this.resaltariceProducto;
	}

	public void setResaltariceProducto(Border borderResaltar) {
		this.resaltariceProducto= borderResaltar;
	}

	public Boolean getMostrariceProducto() {
		return this.mostrariceProducto;
	}

	public void setMostrariceProducto(Boolean mostrariceProducto) {
		this.mostrariceProducto= mostrariceProducto;
	}

	public Boolean getActivariceProducto() {
		return this.activariceProducto;
	}

	public void setActivariceProducto(Boolean activariceProducto) {
		this.activariceProducto= activariceProducto;
	}

	public Border setResaltarice_valorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarice_valorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarice_valorProducto() {
		return this.resaltarice_valorProducto;
	}

	public void setResaltarice_valorProducto(Border borderResaltar) {
		this.resaltarice_valorProducto= borderResaltar;
	}

	public Boolean getMostrarice_valorProducto() {
		return this.mostrarice_valorProducto;
	}

	public void setMostrarice_valorProducto(Boolean mostrarice_valorProducto) {
		this.mostrarice_valorProducto= mostrarice_valorProducto;
	}

	public Boolean getActivarice_valorProducto() {
		return this.activarice_valorProducto;
	}

	public void setActivarice_valorProducto(Boolean activarice_valorProducto) {
		this.activarice_valorProducto= activarice_valorProducto;
	}

	public Border setResaltardescuentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltardescuentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoProducto() {
		return this.resaltardescuentoProducto;
	}

	public void setResaltardescuentoProducto(Border borderResaltar) {
		this.resaltardescuentoProducto= borderResaltar;
	}

	public Boolean getMostrardescuentoProducto() {
		return this.mostrardescuentoProducto;
	}

	public void setMostrardescuentoProducto(Boolean mostrardescuentoProducto) {
		this.mostrardescuentoProducto= mostrardescuentoProducto;
	}

	public Boolean getActivardescuentoProducto() {
		return this.activardescuentoProducto;
	}

	public void setActivardescuentoProducto(Boolean activardescuentoProducto) {
		this.activardescuentoProducto= activardescuentoProducto;
	}

	public Border setResaltardescuento_valorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltardescuento_valorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorProducto() {
		return this.resaltardescuento_valorProducto;
	}

	public void setResaltardescuento_valorProducto(Border borderResaltar) {
		this.resaltardescuento_valorProducto= borderResaltar;
	}

	public Boolean getMostrardescuento_valorProducto() {
		return this.mostrardescuento_valorProducto;
	}

	public void setMostrardescuento_valorProducto(Boolean mostrardescuento_valorProducto) {
		this.mostrardescuento_valorProducto= mostrardescuento_valorProducto;
	}

	public Boolean getActivardescuento_valorProducto() {
		return this.activardescuento_valorProducto;
	}

	public void setActivardescuento_valorProducto(Boolean activardescuento_valorProducto) {
		this.activardescuento_valorProducto= activardescuento_valorProducto;
	}

	public Border setResaltararancel_porcentajeProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltararancel_porcentajeProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararancel_porcentajeProducto() {
		return this.resaltararancel_porcentajeProducto;
	}

	public void setResaltararancel_porcentajeProducto(Border borderResaltar) {
		this.resaltararancel_porcentajeProducto= borderResaltar;
	}

	public Boolean getMostrararancel_porcentajeProducto() {
		return this.mostrararancel_porcentajeProducto;
	}

	public void setMostrararancel_porcentajeProducto(Boolean mostrararancel_porcentajeProducto) {
		this.mostrararancel_porcentajeProducto= mostrararancel_porcentajeProducto;
	}

	public Boolean getActivararancel_porcentajeProducto() {
		return this.activararancel_porcentajeProducto;
	}

	public void setActivararancel_porcentajeProducto(Boolean activararancel_porcentajeProducto) {
		this.activararancel_porcentajeProducto= activararancel_porcentajeProducto;
	}

	public Border setResaltararancel_valorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltararancel_valorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararancel_valorProducto() {
		return this.resaltararancel_valorProducto;
	}

	public void setResaltararancel_valorProducto(Border borderResaltar) {
		this.resaltararancel_valorProducto= borderResaltar;
	}

	public Boolean getMostrararancel_valorProducto() {
		return this.mostrararancel_valorProducto;
	}

	public void setMostrararancel_valorProducto(Boolean mostrararancel_valorProducto) {
		this.mostrararancel_valorProducto= mostrararancel_valorProducto;
	}

	public Boolean getActivararancel_valorProducto() {
		return this.activararancel_valorProducto;
	}

	public void setActivararancel_valorProducto(Boolean activararancel_valorProducto) {
		this.activararancel_valorProducto= activararancel_valorProducto;
	}

	public Border setResaltarcomisionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcomisionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcomisionProducto() {
		return this.resaltarcomisionProducto;
	}

	public void setResaltarcomisionProducto(Border borderResaltar) {
		this.resaltarcomisionProducto= borderResaltar;
	}

	public Boolean getMostrarcomisionProducto() {
		return this.mostrarcomisionProducto;
	}

	public void setMostrarcomisionProducto(Boolean mostrarcomisionProducto) {
		this.mostrarcomisionProducto= mostrarcomisionProducto;
	}

	public Boolean getActivarcomisionProducto() {
		return this.activarcomisionProducto;
	}

	public void setActivarcomisionProducto(Boolean activarcomisionProducto) {
		this.activarcomisionProducto= activarcomisionProducto;
	}

	public Border setResaltarcomision_valorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcomision_valorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcomision_valorProducto() {
		return this.resaltarcomision_valorProducto;
	}

	public void setResaltarcomision_valorProducto(Border borderResaltar) {
		this.resaltarcomision_valorProducto= borderResaltar;
	}

	public Boolean getMostrarcomision_valorProducto() {
		return this.mostrarcomision_valorProducto;
	}

	public void setMostrarcomision_valorProducto(Boolean mostrarcomision_valorProducto) {
		this.mostrarcomision_valorProducto= mostrarcomision_valorProducto;
	}

	public Boolean getActivarcomision_valorProducto() {
		return this.activarcomision_valorProducto;
	}

	public void setActivarcomision_valorProducto(Boolean activarcomision_valorProducto) {
		this.activarcomision_valorProducto= activarcomision_valorProducto;
	}

	public Border setResaltardias_produccionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltardias_produccionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_produccionProducto() {
		return this.resaltardias_produccionProducto;
	}

	public void setResaltardias_produccionProducto(Border borderResaltar) {
		this.resaltardias_produccionProducto= borderResaltar;
	}

	public Boolean getMostrardias_produccionProducto() {
		return this.mostrardias_produccionProducto;
	}

	public void setMostrardias_produccionProducto(Boolean mostrardias_produccionProducto) {
		this.mostrardias_produccionProducto= mostrardias_produccionProducto;
	}

	public Boolean getActivardias_produccionProducto() {
		return this.activardias_produccionProducto;
	}

	public void setActivardias_produccionProducto(Boolean activardias_produccionProducto) {
		this.activardias_produccionProducto= activardias_produccionProducto;
	}

	public Border setResaltarcon_stock_negativoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_stock_negativoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_stock_negativoProducto() {
		return this.resaltarcon_stock_negativoProducto;
	}

	public void setResaltarcon_stock_negativoProducto(Border borderResaltar) {
		this.resaltarcon_stock_negativoProducto= borderResaltar;
	}

	public Boolean getMostrarcon_stock_negativoProducto() {
		return this.mostrarcon_stock_negativoProducto;
	}

	public void setMostrarcon_stock_negativoProducto(Boolean mostrarcon_stock_negativoProducto) {
		this.mostrarcon_stock_negativoProducto= mostrarcon_stock_negativoProducto;
	}

	public Boolean getActivarcon_stock_negativoProducto() {
		return this.activarcon_stock_negativoProducto;
	}

	public void setActivarcon_stock_negativoProducto(Boolean activarcon_stock_negativoProducto) {
		this.activarcon_stock_negativoProducto= activarcon_stock_negativoProducto;
	}

	public Border setResaltarcon_precio_minimoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_precio_minimoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precio_minimoProducto() {
		return this.resaltarcon_precio_minimoProducto;
	}

	public void setResaltarcon_precio_minimoProducto(Border borderResaltar) {
		this.resaltarcon_precio_minimoProducto= borderResaltar;
	}

	public Boolean getMostrarcon_precio_minimoProducto() {
		return this.mostrarcon_precio_minimoProducto;
	}

	public void setMostrarcon_precio_minimoProducto(Boolean mostrarcon_precio_minimoProducto) {
		this.mostrarcon_precio_minimoProducto= mostrarcon_precio_minimoProducto;
	}

	public Boolean getActivarcon_precio_minimoProducto() {
		return this.activarcon_precio_minimoProducto;
	}

	public void setActivarcon_precio_minimoProducto(Boolean activarcon_precio_minimoProducto) {
		this.activarcon_precio_minimoProducto= activarcon_precio_minimoProducto;
	}

	public Border setResaltarcon_loteProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_loteProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_loteProducto() {
		return this.resaltarcon_loteProducto;
	}

	public void setResaltarcon_loteProducto(Border borderResaltar) {
		this.resaltarcon_loteProducto= borderResaltar;
	}

	public Boolean getMostrarcon_loteProducto() {
		return this.mostrarcon_loteProducto;
	}

	public void setMostrarcon_loteProducto(Boolean mostrarcon_loteProducto) {
		this.mostrarcon_loteProducto= mostrarcon_loteProducto;
	}

	public Boolean getActivarcon_loteProducto() {
		return this.activarcon_loteProducto;
	}

	public void setActivarcon_loteProducto(Boolean activarcon_loteProducto) {
		this.activarcon_loteProducto= activarcon_loteProducto;
	}

	public Border setResaltarcon_confirmacionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_confirmacionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_confirmacionProducto() {
		return this.resaltarcon_confirmacionProducto;
	}

	public void setResaltarcon_confirmacionProducto(Border borderResaltar) {
		this.resaltarcon_confirmacionProducto= borderResaltar;
	}

	public Boolean getMostrarcon_confirmacionProducto() {
		return this.mostrarcon_confirmacionProducto;
	}

	public void setMostrarcon_confirmacionProducto(Boolean mostrarcon_confirmacionProducto) {
		this.mostrarcon_confirmacionProducto= mostrarcon_confirmacionProducto;
	}

	public Boolean getActivarcon_confirmacionProducto() {
		return this.activarcon_confirmacionProducto;
	}

	public void setActivarcon_confirmacionProducto(Boolean activarcon_confirmacionProducto) {
		this.activarcon_confirmacionProducto= activarcon_confirmacionProducto;
	}

	public Border setResaltarcon_presupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_presupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_presupuestoProducto() {
		return this.resaltarcon_presupuestoProducto;
	}

	public void setResaltarcon_presupuestoProducto(Border borderResaltar) {
		this.resaltarcon_presupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarcon_presupuestoProducto() {
		return this.mostrarcon_presupuestoProducto;
	}

	public void setMostrarcon_presupuestoProducto(Boolean mostrarcon_presupuestoProducto) {
		this.mostrarcon_presupuestoProducto= mostrarcon_presupuestoProducto;
	}

	public Boolean getActivarcon_presupuestoProducto() {
		return this.activarcon_presupuestoProducto;
	}

	public void setActivarcon_presupuestoProducto(Boolean activarcon_presupuestoProducto) {
		this.activarcon_presupuestoProducto= activarcon_presupuestoProducto;
	}

	public Border setResaltarcon_importacionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_importacionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_importacionProducto() {
		return this.resaltarcon_importacionProducto;
	}

	public void setResaltarcon_importacionProducto(Border borderResaltar) {
		this.resaltarcon_importacionProducto= borderResaltar;
	}

	public Boolean getMostrarcon_importacionProducto() {
		return this.mostrarcon_importacionProducto;
	}

	public void setMostrarcon_importacionProducto(Boolean mostrarcon_importacionProducto) {
		this.mostrarcon_importacionProducto= mostrarcon_importacionProducto;
	}

	public Boolean getActivarcon_importacionProducto() {
		return this.activarcon_importacionProducto;
	}

	public void setActivarcon_importacionProducto(Boolean activarcon_importacionProducto) {
		this.activarcon_importacionProducto= activarcon_importacionProducto;
	}

	public Border setResaltarcon_finalProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_finalProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_finalProducto() {
		return this.resaltarcon_finalProducto;
	}

	public void setResaltarcon_finalProducto(Border borderResaltar) {
		this.resaltarcon_finalProducto= borderResaltar;
	}

	public Boolean getMostrarcon_finalProducto() {
		return this.mostrarcon_finalProducto;
	}

	public void setMostrarcon_finalProducto(Boolean mostrarcon_finalProducto) {
		this.mostrarcon_finalProducto= mostrarcon_finalProducto;
	}

	public Boolean getActivarcon_finalProducto() {
		return this.activarcon_finalProducto;
	}

	public void setActivarcon_finalProducto(Boolean activarcon_finalProducto) {
		this.activarcon_finalProducto= activarcon_finalProducto;
	}

	public Border setResaltarcon_consepProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_consepProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_consepProducto() {
		return this.resaltarcon_consepProducto;
	}

	public void setResaltarcon_consepProducto(Border borderResaltar) {
		this.resaltarcon_consepProducto= borderResaltar;
	}

	public Boolean getMostrarcon_consepProducto() {
		return this.mostrarcon_consepProducto;
	}

	public void setMostrarcon_consepProducto(Boolean mostrarcon_consepProducto) {
		this.mostrarcon_consepProducto= mostrarcon_consepProducto;
	}

	public Boolean getActivarcon_consepProducto() {
		return this.activarcon_consepProducto;
	}

	public void setActivarcon_consepProducto(Boolean activarcon_consepProducto) {
		this.activarcon_consepProducto= activarcon_consepProducto;
	}

	public Border setResaltarcon_serieProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_serieProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_serieProducto() {
		return this.resaltarcon_serieProducto;
	}

	public void setResaltarcon_serieProducto(Border borderResaltar) {
		this.resaltarcon_serieProducto= borderResaltar;
	}

	public Boolean getMostrarcon_serieProducto() {
		return this.mostrarcon_serieProducto;
	}

	public void setMostrarcon_serieProducto(Boolean mostrarcon_serieProducto) {
		this.mostrarcon_serieProducto= mostrarcon_serieProducto;
	}

	public Boolean getActivarcon_serieProducto() {
		return this.activarcon_serieProducto;
	}

	public void setActivarcon_serieProducto(Boolean activarcon_serieProducto) {
		this.activarcon_serieProducto= activarcon_serieProducto;
	}

	public Border setResaltarcon_balanzaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarcon_balanzaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_balanzaProducto() {
		return this.resaltarcon_balanzaProducto;
	}

	public void setResaltarcon_balanzaProducto(Border borderResaltar) {
		this.resaltarcon_balanzaProducto= borderResaltar;
	}

	public Boolean getMostrarcon_balanzaProducto() {
		return this.mostrarcon_balanzaProducto;
	}

	public void setMostrarcon_balanzaProducto(Boolean mostrarcon_balanzaProducto) {
		this.mostrarcon_balanzaProducto= mostrarcon_balanzaProducto;
	}

	public Boolean getActivarcon_balanzaProducto() {
		return this.activarcon_balanzaProducto;
	}

	public void setActivarcon_balanzaProducto(Boolean activarcon_balanzaProducto) {
		this.activarcon_balanzaProducto= activarcon_balanzaProducto;
	}

	public Border setResaltaraltoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltaraltoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraltoProducto() {
		return this.resaltaraltoProducto;
	}

	public void setResaltaraltoProducto(Border borderResaltar) {
		this.resaltaraltoProducto= borderResaltar;
	}

	public Boolean getMostraraltoProducto() {
		return this.mostraraltoProducto;
	}

	public void setMostraraltoProducto(Boolean mostraraltoProducto) {
		this.mostraraltoProducto= mostraraltoProducto;
	}

	public Boolean getActivaraltoProducto() {
		return this.activaraltoProducto;
	}

	public void setActivaraltoProducto(Boolean activaraltoProducto) {
		this.activaraltoProducto= activaraltoProducto;
	}

	public Border setResaltaranchoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltaranchoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranchoProducto() {
		return this.resaltaranchoProducto;
	}

	public void setResaltaranchoProducto(Border borderResaltar) {
		this.resaltaranchoProducto= borderResaltar;
	}

	public Boolean getMostraranchoProducto() {
		return this.mostraranchoProducto;
	}

	public void setMostraranchoProducto(Boolean mostraranchoProducto) {
		this.mostraranchoProducto= mostraranchoProducto;
	}

	public Boolean getActivaranchoProducto() {
		return this.activaranchoProducto;
	}

	public void setActivaranchoProducto(Boolean activaranchoProducto) {
		this.activaranchoProducto= activaranchoProducto;
	}

	public Border setResaltarlargoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarlargoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlargoProducto() {
		return this.resaltarlargoProducto;
	}

	public void setResaltarlargoProducto(Border borderResaltar) {
		this.resaltarlargoProducto= borderResaltar;
	}

	public Boolean getMostrarlargoProducto() {
		return this.mostrarlargoProducto;
	}

	public void setMostrarlargoProducto(Boolean mostrarlargoProducto) {
		this.mostrarlargoProducto= mostrarlargoProducto;
	}

	public Boolean getActivarlargoProducto() {
		return this.activarlargoProducto;
	}

	public void setActivarlargoProducto(Boolean activarlargoProducto) {
		this.activarlargoProducto= activarlargoProducto;
	}

	public Border setResaltarvolumenProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarvolumenProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvolumenProducto() {
		return this.resaltarvolumenProducto;
	}

	public void setResaltarvolumenProducto(Border borderResaltar) {
		this.resaltarvolumenProducto= borderResaltar;
	}

	public Boolean getMostrarvolumenProducto() {
		return this.mostrarvolumenProducto;
	}

	public void setMostrarvolumenProducto(Boolean mostrarvolumenProducto) {
		this.mostrarvolumenProducto= mostrarvolumenProducto;
	}

	public Boolean getActivarvolumenProducto() {
		return this.activarvolumenProducto;
	}

	public void setActivarvolumenProducto(Boolean activarvolumenProducto) {
		this.activarvolumenProducto= activarvolumenProducto;
	}

	public Border setResaltarpesoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarpesoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpesoProducto() {
		return this.resaltarpesoProducto;
	}

	public void setResaltarpesoProducto(Border borderResaltar) {
		this.resaltarpesoProducto= borderResaltar;
	}

	public Boolean getMostrarpesoProducto() {
		return this.mostrarpesoProducto;
	}

	public void setMostrarpesoProducto(Boolean mostrarpesoProducto) {
		this.mostrarpesoProducto= mostrarpesoProducto;
	}

	public Boolean getActivarpesoProducto() {
		return this.activarpesoProducto;
	}

	public void setActivarpesoProducto(Boolean activarpesoProducto) {
		this.activarpesoProducto= activarpesoProducto;
	}

	public Border setResaltargramosProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltargramosProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargramosProducto() {
		return this.resaltargramosProducto;
	}

	public void setResaltargramosProducto(Border borderResaltar) {
		this.resaltargramosProducto= borderResaltar;
	}

	public Boolean getMostrargramosProducto() {
		return this.mostrargramosProducto;
	}

	public void setMostrargramosProducto(Boolean mostrargramosProducto) {
		this.mostrargramosProducto= mostrargramosProducto;
	}

	public Boolean getActivargramosProducto() {
		return this.activargramosProducto;
	}

	public void setActivargramosProducto(Boolean activargramosProducto) {
		this.activargramosProducto= activargramosProducto;
	}

	public Border setResaltarunidades_cajaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarunidades_cajaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarunidades_cajaProducto() {
		return this.resaltarunidades_cajaProducto;
	}

	public void setResaltarunidades_cajaProducto(Border borderResaltar) {
		this.resaltarunidades_cajaProducto= borderResaltar;
	}

	public Boolean getMostrarunidades_cajaProducto() {
		return this.mostrarunidades_cajaProducto;
	}

	public void setMostrarunidades_cajaProducto(Boolean mostrarunidades_cajaProducto) {
		this.mostrarunidades_cajaProducto= mostrarunidades_cajaProducto;
	}

	public Boolean getActivarunidades_cajaProducto() {
		return this.activarunidades_cajaProducto;
	}

	public void setActivarunidades_cajaProducto(Boolean activarunidades_cajaProducto) {
		this.activarunidades_cajaProducto= activarunidades_cajaProducto;
	}

	public Border setResaltarmargenProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarmargenProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmargenProducto() {
		return this.resaltarmargenProducto;
	}

	public void setResaltarmargenProducto(Border borderResaltar) {
		this.resaltarmargenProducto= borderResaltar;
	}

	public Boolean getMostrarmargenProducto() {
		return this.mostrarmargenProducto;
	}

	public void setMostrarmargenProducto(Boolean mostrarmargenProducto) {
		this.mostrarmargenProducto= mostrarmargenProducto;
	}

	public Boolean getActivarmargenProducto() {
		return this.activarmargenProducto;
	}

	public void setActivarmargenProducto(Boolean activarmargenProducto) {
		this.activarmargenProducto= activarmargenProducto;
	}

	public Border setResaltarfactorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarfactorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfactorProducto() {
		return this.resaltarfactorProducto;
	}

	public void setResaltarfactorProducto(Border borderResaltar) {
		this.resaltarfactorProducto= borderResaltar;
	}

	public Boolean getMostrarfactorProducto() {
		return this.mostrarfactorProducto;
	}

	public void setMostrarfactorProducto(Boolean mostrarfactorProducto) {
		this.mostrarfactorProducto= mostrarfactorProducto;
	}

	public Boolean getActivarfactorProducto() {
		return this.activarfactorProducto;
	}

	public void setActivarfactorProducto(Boolean activarfactorProducto) {
		this.activarfactorProducto= activarfactorProducto;
	}

	public Border setResaltarfobProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarfobProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfobProducto() {
		return this.resaltarfobProducto;
	}

	public void setResaltarfobProducto(Border borderResaltar) {
		this.resaltarfobProducto= borderResaltar;
	}

	public Boolean getMostrarfobProducto() {
		return this.mostrarfobProducto;
	}

	public void setMostrarfobProducto(Boolean mostrarfobProducto) {
		this.mostrarfobProducto= mostrarfobProducto;
	}

	public Boolean getActivarfobProducto() {
		return this.activarfobProducto;
	}

	public void setActivarfobProducto(Boolean activarfobProducto) {
		this.activarfobProducto= activarfobProducto;
	}

	public Border setResaltarfob2Producto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarfob2Producto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfob2Producto() {
		return this.resaltarfob2Producto;
	}

	public void setResaltarfob2Producto(Border borderResaltar) {
		this.resaltarfob2Producto= borderResaltar;
	}

	public Boolean getMostrarfob2Producto() {
		return this.mostrarfob2Producto;
	}

	public void setMostrarfob2Producto(Boolean mostrarfob2Producto) {
		this.mostrarfob2Producto= mostrarfob2Producto;
	}

	public Boolean getActivarfob2Producto() {
		return this.activarfob2Producto;
	}

	public void setActivarfob2Producto(Boolean activarfob2Producto) {
		this.activarfob2Producto= activarfob2Producto;
	}

	public Border setResaltarid_tipo_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoProducto() {
		return this.resaltarid_tipo_productoProducto;
	}

	public void setResaltarid_tipo_productoProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoProducto() {
		return this.mostrarid_tipo_productoProducto;
	}

	public void setMostrarid_tipo_productoProducto(Boolean mostrarid_tipo_productoProducto) {
		this.mostrarid_tipo_productoProducto= mostrarid_tipo_productoProducto;
	}

	public Boolean getActivarid_tipo_productoProducto() {
		return this.activarid_tipo_productoProducto;
	}

	public void setActivarid_tipo_productoProducto(Boolean activarid_tipo_productoProducto) {
		this.activarid_tipo_productoProducto= activarid_tipo_productoProducto;
	}

	public Boolean getCargarid_tipo_productoProducto() {
		return this.cargarid_tipo_productoProducto;
	}

	public void setCargarid_tipo_productoProducto(Boolean cargarid_tipo_productoProducto) {
		this.cargarid_tipo_productoProducto= cargarid_tipo_productoProducto;
	}

	public Border setResaltarid_color_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_color_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_color_productoProducto() {
		return this.resaltarid_color_productoProducto;
	}

	public void setResaltarid_color_productoProducto(Border borderResaltar) {
		this.resaltarid_color_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_color_productoProducto() {
		return this.mostrarid_color_productoProducto;
	}

	public void setMostrarid_color_productoProducto(Boolean mostrarid_color_productoProducto) {
		this.mostrarid_color_productoProducto= mostrarid_color_productoProducto;
	}

	public Boolean getActivarid_color_productoProducto() {
		return this.activarid_color_productoProducto;
	}

	public void setActivarid_color_productoProducto(Boolean activarid_color_productoProducto) {
		this.activarid_color_productoProducto= activarid_color_productoProducto;
	}

	public Boolean getCargarid_color_productoProducto() {
		return this.cargarid_color_productoProducto;
	}

	public void setCargarid_color_productoProducto(Boolean cargarid_color_productoProducto) {
		this.cargarid_color_productoProducto= cargarid_color_productoProducto;
	}

	public Border setResaltarid_clase_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_clase_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clase_productoProducto() {
		return this.resaltarid_clase_productoProducto;
	}

	public void setResaltarid_clase_productoProducto(Border borderResaltar) {
		this.resaltarid_clase_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_clase_productoProducto() {
		return this.mostrarid_clase_productoProducto;
	}

	public void setMostrarid_clase_productoProducto(Boolean mostrarid_clase_productoProducto) {
		this.mostrarid_clase_productoProducto= mostrarid_clase_productoProducto;
	}

	public Boolean getActivarid_clase_productoProducto() {
		return this.activarid_clase_productoProducto;
	}

	public void setActivarid_clase_productoProducto(Boolean activarid_clase_productoProducto) {
		this.activarid_clase_productoProducto= activarid_clase_productoProducto;
	}

	public Boolean getCargarid_clase_productoProducto() {
		return this.cargarid_clase_productoProducto;
	}

	public void setCargarid_clase_productoProducto(Boolean cargarid_clase_productoProducto) {
		this.cargarid_clase_productoProducto= cargarid_clase_productoProducto;
	}

	public Border setResaltarid_efecto_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_efecto_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_efecto_productoProducto() {
		return this.resaltarid_efecto_productoProducto;
	}

	public void setResaltarid_efecto_productoProducto(Border borderResaltar) {
		this.resaltarid_efecto_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_efecto_productoProducto() {
		return this.mostrarid_efecto_productoProducto;
	}

	public void setMostrarid_efecto_productoProducto(Boolean mostrarid_efecto_productoProducto) {
		this.mostrarid_efecto_productoProducto= mostrarid_efecto_productoProducto;
	}

	public Boolean getActivarid_efecto_productoProducto() {
		return this.activarid_efecto_productoProducto;
	}

	public void setActivarid_efecto_productoProducto(Boolean activarid_efecto_productoProducto) {
		this.activarid_efecto_productoProducto= activarid_efecto_productoProducto;
	}

	public Boolean getCargarid_efecto_productoProducto() {
		return this.cargarid_efecto_productoProducto;
	}

	public void setCargarid_efecto_productoProducto(Boolean cargarid_efecto_productoProducto) {
		this.cargarid_efecto_productoProducto= cargarid_efecto_productoProducto;
	}

	public Border setResaltarid_marca_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_marca_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_marca_productoProducto() {
		return this.resaltarid_marca_productoProducto;
	}

	public void setResaltarid_marca_productoProducto(Border borderResaltar) {
		this.resaltarid_marca_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_marca_productoProducto() {
		return this.mostrarid_marca_productoProducto;
	}

	public void setMostrarid_marca_productoProducto(Boolean mostrarid_marca_productoProducto) {
		this.mostrarid_marca_productoProducto= mostrarid_marca_productoProducto;
	}

	public Boolean getActivarid_marca_productoProducto() {
		return this.activarid_marca_productoProducto;
	}

	public void setActivarid_marca_productoProducto(Boolean activarid_marca_productoProducto) {
		this.activarid_marca_productoProducto= activarid_marca_productoProducto;
	}

	public Boolean getCargarid_marca_productoProducto() {
		return this.cargarid_marca_productoProducto;
	}

	public void setCargarid_marca_productoProducto(Boolean cargarid_marca_productoProducto) {
		this.cargarid_marca_productoProducto= cargarid_marca_productoProducto;
	}

	public Border setResaltarid_modelo_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_modelo_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_modelo_productoProducto() {
		return this.resaltarid_modelo_productoProducto;
	}

	public void setResaltarid_modelo_productoProducto(Border borderResaltar) {
		this.resaltarid_modelo_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_modelo_productoProducto() {
		return this.mostrarid_modelo_productoProducto;
	}

	public void setMostrarid_modelo_productoProducto(Boolean mostrarid_modelo_productoProducto) {
		this.mostrarid_modelo_productoProducto= mostrarid_modelo_productoProducto;
	}

	public Boolean getActivarid_modelo_productoProducto() {
		return this.activarid_modelo_productoProducto;
	}

	public void setActivarid_modelo_productoProducto(Boolean activarid_modelo_productoProducto) {
		this.activarid_modelo_productoProducto= activarid_modelo_productoProducto;
	}

	public Boolean getCargarid_modelo_productoProducto() {
		return this.cargarid_modelo_productoProducto;
	}

	public void setCargarid_modelo_productoProducto(Boolean cargarid_modelo_productoProducto) {
		this.cargarid_modelo_productoProducto= cargarid_modelo_productoProducto;
	}

	public Border setResaltarid_material_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_material_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_material_productoProducto() {
		return this.resaltarid_material_productoProducto;
	}

	public void setResaltarid_material_productoProducto(Border borderResaltar) {
		this.resaltarid_material_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_material_productoProducto() {
		return this.mostrarid_material_productoProducto;
	}

	public void setMostrarid_material_productoProducto(Boolean mostrarid_material_productoProducto) {
		this.mostrarid_material_productoProducto= mostrarid_material_productoProducto;
	}

	public Boolean getActivarid_material_productoProducto() {
		return this.activarid_material_productoProducto;
	}

	public void setActivarid_material_productoProducto(Boolean activarid_material_productoProducto) {
		this.activarid_material_productoProducto= activarid_material_productoProducto;
	}

	public Boolean getCargarid_material_productoProducto() {
		return this.cargarid_material_productoProducto;
	}

	public void setCargarid_material_productoProducto(Boolean cargarid_material_productoProducto) {
		this.cargarid_material_productoProducto= cargarid_material_productoProducto;
	}

	public Border setResaltarid_segmento_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_segmento_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_segmento_productoProducto() {
		return this.resaltarid_segmento_productoProducto;
	}

	public void setResaltarid_segmento_productoProducto(Border borderResaltar) {
		this.resaltarid_segmento_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_segmento_productoProducto() {
		return this.mostrarid_segmento_productoProducto;
	}

	public void setMostrarid_segmento_productoProducto(Boolean mostrarid_segmento_productoProducto) {
		this.mostrarid_segmento_productoProducto= mostrarid_segmento_productoProducto;
	}

	public Boolean getActivarid_segmento_productoProducto() {
		return this.activarid_segmento_productoProducto;
	}

	public void setActivarid_segmento_productoProducto(Boolean activarid_segmento_productoProducto) {
		this.activarid_segmento_productoProducto= activarid_segmento_productoProducto;
	}

	public Boolean getCargarid_segmento_productoProducto() {
		return this.cargarid_segmento_productoProducto;
	}

	public void setCargarid_segmento_productoProducto(Boolean cargarid_segmento_productoProducto) {
		this.cargarid_segmento_productoProducto= cargarid_segmento_productoProducto;
	}

	public Border setResaltarid_talla_productoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarid_talla_productoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_talla_productoProducto() {
		return this.resaltarid_talla_productoProducto;
	}

	public void setResaltarid_talla_productoProducto(Border borderResaltar) {
		this.resaltarid_talla_productoProducto= borderResaltar;
	}

	public Boolean getMostrarid_talla_productoProducto() {
		return this.mostrarid_talla_productoProducto;
	}

	public void setMostrarid_talla_productoProducto(Boolean mostrarid_talla_productoProducto) {
		this.mostrarid_talla_productoProducto= mostrarid_talla_productoProducto;
	}

	public Boolean getActivarid_talla_productoProducto() {
		return this.activarid_talla_productoProducto;
	}

	public void setActivarid_talla_productoProducto(Boolean activarid_talla_productoProducto) {
		this.activarid_talla_productoProducto= activarid_talla_productoProducto;
	}

	public Boolean getCargarid_talla_productoProducto() {
		return this.cargarid_talla_productoProducto;
	}

	public void setCargarid_talla_productoProducto(Boolean cargarid_talla_productoProducto) {
		this.cargarid_talla_productoProducto= cargarid_talla_productoProducto;
	}

	public Border setResaltargrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltargrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargrupoProducto() {
		return this.resaltargrupoProducto;
	}

	public void setResaltargrupoProducto(Border borderResaltar) {
		this.resaltargrupoProducto= borderResaltar;
	}

	public Boolean getMostrargrupoProducto() {
		return this.mostrargrupoProducto;
	}

	public void setMostrargrupoProducto(Boolean mostrargrupoProducto) {
		this.mostrargrupoProducto= mostrargrupoProducto;
	}

	public Boolean getActivargrupoProducto() {
		return this.activargrupoProducto;
	}

	public void setActivargrupoProducto(Boolean activargrupoProducto) {
		this.activargrupoProducto= activargrupoProducto;
	}

	public Border setResaltarreferenciaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarreferenciaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaProducto() {
		return this.resaltarreferenciaProducto;
	}

	public void setResaltarreferenciaProducto(Border borderResaltar) {
		this.resaltarreferenciaProducto= borderResaltar;
	}

	public Boolean getMostrarreferenciaProducto() {
		return this.mostrarreferenciaProducto;
	}

	public void setMostrarreferenciaProducto(Boolean mostrarreferenciaProducto) {
		this.mostrarreferenciaProducto= mostrarreferenciaProducto;
	}

	public Boolean getActivarreferenciaProducto() {
		return this.activarreferenciaProducto;
	}

	public void setActivarreferenciaProducto(Boolean activarreferenciaProducto) {
		this.activarreferenciaProducto= activarreferenciaProducto;
	}

	public Border setResaltaraplicacionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltaraplicacionProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraplicacionProducto() {
		return this.resaltaraplicacionProducto;
	}

	public void setResaltaraplicacionProducto(Border borderResaltar) {
		this.resaltaraplicacionProducto= borderResaltar;
	}

	public Boolean getMostraraplicacionProducto() {
		return this.mostraraplicacionProducto;
	}

	public void setMostraraplicacionProducto(Boolean mostraraplicacionProducto) {
		this.mostraraplicacionProducto= mostraraplicacionProducto;
	}

	public Boolean getActivaraplicacionProducto() {
		return this.activaraplicacionProducto;
	}

	public void setActivaraplicacionProducto(Boolean activaraplicacionProducto) {
		this.activaraplicacionProducto= activaraplicacionProducto;
	}

	public Border setResaltarprocedenciaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltar);
		
		this.resaltarprocedenciaProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprocedenciaProducto() {
		return this.resaltarprocedenciaProducto;
	}

	public void setResaltarprocedenciaProducto(Border borderResaltar) {
		this.resaltarprocedenciaProducto= borderResaltar;
	}

	public Boolean getMostrarprocedenciaProducto() {
		return this.mostrarprocedenciaProducto;
	}

	public void setMostrarprocedenciaProducto(Boolean mostrarprocedenciaProducto) {
		this.mostrarprocedenciaProducto= mostrarprocedenciaProducto;
	}

	public Boolean getActivarprocedenciaProducto() {
		return this.activarprocedenciaProducto;
	}

	public void setActivarprocedenciaProducto(Boolean activarprocedenciaProducto) {
		this.activarprocedenciaProducto= activarprocedenciaProducto;
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
		
		
		this.setMostraridProducto(esInicial);
		this.setMostrarid_empresaProducto(esInicial);
		this.setMostrarid_sucursalProducto(esInicial);
		this.setMostrarcodigoProducto(esInicial);
		this.setMostrarnombreProducto(esInicial);
		this.setMostrarnombre_extranjeroProducto(esInicial);
		this.setMostrarresumen_detalleProducto(esInicial);
		this.setMostrarcodigo_barraProducto(esInicial);
		this.setMostrarid_lineaProducto(esInicial);
		this.setMostrarid_linea_grupoProducto(esInicial);
		this.setMostrarid_linea_categoriaProducto(esInicial);
		this.setMostrarid_linea_marcaProducto(esInicial);
		this.setMostrarid_tipo_producto_servicioProducto(esInicial);
		this.setMostrarid_tipo_producto_servicio_invenProducto(esInicial);
		this.setMostrarid_tipo_costeoProducto(esInicial);
		this.setMostrarid_unidadProducto(esInicial);
		this.setMostrarid_unidad_pesoProducto(esInicial);
		this.setMostrarid_arancelProducto(esInicial);
		this.setMostrarid_clienteProducto(esInicial);
		this.setMostrarid_cliente_proveedor_defectoProducto(esInicial);
		this.setMostraresta_activoProducto(esInicial);
		this.setMostrardescripcionProducto(esInicial);
		this.setMostrarprecioProducto(esInicial);
		this.setMostrarivaProducto(esInicial);
		this.setMostrariva_valorProducto(esInicial);
		this.setMostrariceProducto(esInicial);
		this.setMostrarice_valorProducto(esInicial);
		this.setMostrardescuentoProducto(esInicial);
		this.setMostrardescuento_valorProducto(esInicial);
		this.setMostrararancel_porcentajeProducto(esInicial);
		this.setMostrararancel_valorProducto(esInicial);
		this.setMostrarcomisionProducto(esInicial);
		this.setMostrarcomision_valorProducto(esInicial);
		this.setMostrardias_produccionProducto(esInicial);
		this.setMostrarcon_stock_negativoProducto(esInicial);
		this.setMostrarcon_precio_minimoProducto(esInicial);
		this.setMostrarcon_loteProducto(esInicial);
		this.setMostrarcon_confirmacionProducto(esInicial);
		this.setMostrarcon_presupuestoProducto(esInicial);
		this.setMostrarcon_importacionProducto(esInicial);
		this.setMostrarcon_finalProducto(esInicial);
		this.setMostrarcon_consepProducto(esInicial);
		this.setMostrarcon_serieProducto(esInicial);
		this.setMostrarcon_balanzaProducto(esInicial);
		this.setMostraraltoProducto(esInicial);
		this.setMostraranchoProducto(esInicial);
		this.setMostrarlargoProducto(esInicial);
		this.setMostrarvolumenProducto(esInicial);
		this.setMostrarpesoProducto(esInicial);
		this.setMostrargramosProducto(esInicial);
		this.setMostrarunidades_cajaProducto(esInicial);
		this.setMostrarmargenProducto(esInicial);
		this.setMostrarfactorProducto(esInicial);
		this.setMostrarfobProducto(esInicial);
		this.setMostrarfob2Producto(esInicial);
		this.setMostrarid_tipo_productoProducto(esInicial);
		this.setMostrarid_color_productoProducto(esInicial);
		this.setMostrarid_clase_productoProducto(esInicial);
		this.setMostrarid_efecto_productoProducto(esInicial);
		this.setMostrarid_marca_productoProducto(esInicial);
		this.setMostrarid_modelo_productoProducto(esInicial);
		this.setMostrarid_material_productoProducto(esInicial);
		this.setMostrarid_segmento_productoProducto(esInicial);
		this.setMostrarid_talla_productoProducto(esInicial);
		this.setMostrargrupoProducto(esInicial);
		this.setMostrarreferenciaProducto(esInicial);
		this.setMostraraplicacionProducto(esInicial);
		this.setMostrarprocedenciaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoConstantesFunciones.ID)) {
				this.setMostraridProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setMostrarnombre_extranjeroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.RESUMENDETALLE)) {
				this.setMostrarresumen_detalleProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGOBARRA)) {
				this.setMostrarcodigo_barraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setMostrarid_tipo_producto_servicio_invenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setMostrarid_tipo_costeoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDADPESO)) {
				this.setMostrarid_unidad_pesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDARANCEL)) {
				this.setMostrarid_arancelProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO)) {
				this.setMostrarid_cliente_proveedor_defectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVA)) {
				this.setMostrarivaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVAVALOR)) {
				this.setMostrariva_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICE)) {
				this.setMostrariceProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICEVALOR)) {
				this.setMostrarice_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setMostrararancel_porcentajeProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELVALOR)) {
				this.setMostrararancel_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISION)) {
				this.setMostrarcomisionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISIONVALOR)) {
				this.setMostrarcomision_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setMostrardias_produccionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setMostrarcon_stock_negativoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRECIOMINIMO)) {
				this.setMostrarcon_precio_minimoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONLOTE)) {
				this.setMostrarcon_loteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONFIRMACION)) {
				this.setMostrarcon_confirmacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRESUPUESTO)) {
				this.setMostrarcon_presupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONIMPORTACION)) {
				this.setMostrarcon_importacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONFINAL)) {
				this.setMostrarcon_finalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONSEP)) {
				this.setMostrarcon_consepProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSERIE)) {
				this.setMostrarcon_serieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONBALANZA)) {
				this.setMostrarcon_balanzaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ALTO)) {
				this.setMostraraltoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ANCHO)) {
				this.setMostraranchoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.LARGO)) {
				this.setMostrarlargoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.VOLUMEN)) {
				this.setMostrarvolumenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PESO)) {
				this.setMostrarpesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRAMOS)) {
				this.setMostrargramosProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.UNIDADESCAJA)) {
				this.setMostrarunidades_cajaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.MARGEN)) {
				this.setMostrarmargenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FACTOR)) {
				this.setMostrarfactorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB)) {
				this.setMostrarfobProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB2)) {
				this.setMostrarfob2Producto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setMostrarid_color_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setMostrarid_clase_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setMostrarid_efecto_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setMostrarid_marca_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setMostrarid_modelo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setMostrarid_material_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setMostrarid_segmento_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setMostrarid_talla_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRUPO)) {
				this.setMostrargrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.APLICACION)) {
				this.setMostraraplicacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PROCEDENCIA)) {
				this.setMostrarprocedenciaProducto(esAsigna);
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
		
		
		this.setActivaridProducto(esInicial);
		this.setActivarid_empresaProducto(esInicial);
		this.setActivarid_sucursalProducto(esInicial);
		this.setActivarcodigoProducto(esInicial);
		this.setActivarnombreProducto(esInicial);
		this.setActivarnombre_extranjeroProducto(esInicial);
		this.setActivarresumen_detalleProducto(esInicial);
		this.setActivarcodigo_barraProducto(esInicial);
		this.setActivarid_lineaProducto(esInicial);
		this.setActivarid_linea_grupoProducto(esInicial);
		this.setActivarid_linea_categoriaProducto(esInicial);
		this.setActivarid_linea_marcaProducto(esInicial);
		this.setActivarid_tipo_producto_servicioProducto(esInicial);
		this.setActivarid_tipo_producto_servicio_invenProducto(esInicial);
		this.setActivarid_tipo_costeoProducto(esInicial);
		this.setActivarid_unidadProducto(esInicial);
		this.setActivarid_unidad_pesoProducto(esInicial);
		this.setActivarid_arancelProducto(esInicial);
		this.setActivarid_clienteProducto(esInicial);
		this.setActivarid_cliente_proveedor_defectoProducto(esInicial);
		this.setActivaresta_activoProducto(esInicial);
		this.setActivardescripcionProducto(esInicial);
		this.setActivarprecioProducto(esInicial);
		this.setActivarivaProducto(esInicial);
		this.setActivariva_valorProducto(esInicial);
		this.setActivariceProducto(esInicial);
		this.setActivarice_valorProducto(esInicial);
		this.setActivardescuentoProducto(esInicial);
		this.setActivardescuento_valorProducto(esInicial);
		this.setActivararancel_porcentajeProducto(esInicial);
		this.setActivararancel_valorProducto(esInicial);
		this.setActivarcomisionProducto(esInicial);
		this.setActivarcomision_valorProducto(esInicial);
		this.setActivardias_produccionProducto(esInicial);
		this.setActivarcon_stock_negativoProducto(esInicial);
		this.setActivarcon_precio_minimoProducto(esInicial);
		this.setActivarcon_loteProducto(esInicial);
		this.setActivarcon_confirmacionProducto(esInicial);
		this.setActivarcon_presupuestoProducto(esInicial);
		this.setActivarcon_importacionProducto(esInicial);
		this.setActivarcon_finalProducto(esInicial);
		this.setActivarcon_consepProducto(esInicial);
		this.setActivarcon_serieProducto(esInicial);
		this.setActivarcon_balanzaProducto(esInicial);
		this.setActivaraltoProducto(esInicial);
		this.setActivaranchoProducto(esInicial);
		this.setActivarlargoProducto(esInicial);
		this.setActivarvolumenProducto(esInicial);
		this.setActivarpesoProducto(esInicial);
		this.setActivargramosProducto(esInicial);
		this.setActivarunidades_cajaProducto(esInicial);
		this.setActivarmargenProducto(esInicial);
		this.setActivarfactorProducto(esInicial);
		this.setActivarfobProducto(esInicial);
		this.setActivarfob2Producto(esInicial);
		this.setActivarid_tipo_productoProducto(esInicial);
		this.setActivarid_color_productoProducto(esInicial);
		this.setActivarid_clase_productoProducto(esInicial);
		this.setActivarid_efecto_productoProducto(esInicial);
		this.setActivarid_marca_productoProducto(esInicial);
		this.setActivarid_modelo_productoProducto(esInicial);
		this.setActivarid_material_productoProducto(esInicial);
		this.setActivarid_segmento_productoProducto(esInicial);
		this.setActivarid_talla_productoProducto(esInicial);
		this.setActivargrupoProducto(esInicial);
		this.setActivarreferenciaProducto(esInicial);
		this.setActivaraplicacionProducto(esInicial);
		this.setActivarprocedenciaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoConstantesFunciones.ID)) {
				this.setActivaridProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setActivarnombre_extranjeroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.RESUMENDETALLE)) {
				this.setActivarresumen_detalleProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGOBARRA)) {
				this.setActivarcodigo_barraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setActivarid_tipo_producto_servicio_invenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setActivarid_tipo_costeoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDADPESO)) {
				this.setActivarid_unidad_pesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDARANCEL)) {
				this.setActivarid_arancelProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO)) {
				this.setActivarid_cliente_proveedor_defectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PRECIO)) {
				this.setActivarprecioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVA)) {
				this.setActivarivaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVAVALOR)) {
				this.setActivariva_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICE)) {
				this.setActivariceProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICEVALOR)) {
				this.setActivarice_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setActivararancel_porcentajeProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELVALOR)) {
				this.setActivararancel_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISION)) {
				this.setActivarcomisionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISIONVALOR)) {
				this.setActivarcomision_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setActivardias_produccionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setActivarcon_stock_negativoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRECIOMINIMO)) {
				this.setActivarcon_precio_minimoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONLOTE)) {
				this.setActivarcon_loteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONFIRMACION)) {
				this.setActivarcon_confirmacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRESUPUESTO)) {
				this.setActivarcon_presupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONIMPORTACION)) {
				this.setActivarcon_importacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONFINAL)) {
				this.setActivarcon_finalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONSEP)) {
				this.setActivarcon_consepProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSERIE)) {
				this.setActivarcon_serieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONBALANZA)) {
				this.setActivarcon_balanzaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ALTO)) {
				this.setActivaraltoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ANCHO)) {
				this.setActivaranchoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.LARGO)) {
				this.setActivarlargoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.VOLUMEN)) {
				this.setActivarvolumenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PESO)) {
				this.setActivarpesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRAMOS)) {
				this.setActivargramosProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.UNIDADESCAJA)) {
				this.setActivarunidades_cajaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.MARGEN)) {
				this.setActivarmargenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FACTOR)) {
				this.setActivarfactorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB)) {
				this.setActivarfobProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB2)) {
				this.setActivarfob2Producto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setActivarid_color_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setActivarid_clase_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setActivarid_efecto_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setActivarid_marca_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setActivarid_modelo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setActivarid_material_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setActivarid_segmento_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setActivarid_talla_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRUPO)) {
				this.setActivargrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.APLICACION)) {
				this.setActivaraplicacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PROCEDENCIA)) {
				this.setActivarprocedenciaProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProducto(esInicial);
		this.setResaltarid_empresaProducto(esInicial);
		this.setResaltarid_sucursalProducto(esInicial);
		this.setResaltarcodigoProducto(esInicial);
		this.setResaltarnombreProducto(esInicial);
		this.setResaltarnombre_extranjeroProducto(esInicial);
		this.setResaltarresumen_detalleProducto(esInicial);
		this.setResaltarcodigo_barraProducto(esInicial);
		this.setResaltarid_lineaProducto(esInicial);
		this.setResaltarid_linea_grupoProducto(esInicial);
		this.setResaltarid_linea_categoriaProducto(esInicial);
		this.setResaltarid_linea_marcaProducto(esInicial);
		this.setResaltarid_tipo_producto_servicioProducto(esInicial);
		this.setResaltarid_tipo_producto_servicio_invenProducto(esInicial);
		this.setResaltarid_tipo_costeoProducto(esInicial);
		this.setResaltarid_unidadProducto(esInicial);
		this.setResaltarid_unidad_pesoProducto(esInicial);
		this.setResaltarid_arancelProducto(esInicial);
		this.setResaltarid_clienteProducto(esInicial);
		this.setResaltarid_cliente_proveedor_defectoProducto(esInicial);
		this.setResaltaresta_activoProducto(esInicial);
		this.setResaltardescripcionProducto(esInicial);
		this.setResaltarprecioProducto(esInicial);
		this.setResaltarivaProducto(esInicial);
		this.setResaltariva_valorProducto(esInicial);
		this.setResaltariceProducto(esInicial);
		this.setResaltarice_valorProducto(esInicial);
		this.setResaltardescuentoProducto(esInicial);
		this.setResaltardescuento_valorProducto(esInicial);
		this.setResaltararancel_porcentajeProducto(esInicial);
		this.setResaltararancel_valorProducto(esInicial);
		this.setResaltarcomisionProducto(esInicial);
		this.setResaltarcomision_valorProducto(esInicial);
		this.setResaltardias_produccionProducto(esInicial);
		this.setResaltarcon_stock_negativoProducto(esInicial);
		this.setResaltarcon_precio_minimoProducto(esInicial);
		this.setResaltarcon_loteProducto(esInicial);
		this.setResaltarcon_confirmacionProducto(esInicial);
		this.setResaltarcon_presupuestoProducto(esInicial);
		this.setResaltarcon_importacionProducto(esInicial);
		this.setResaltarcon_finalProducto(esInicial);
		this.setResaltarcon_consepProducto(esInicial);
		this.setResaltarcon_serieProducto(esInicial);
		this.setResaltarcon_balanzaProducto(esInicial);
		this.setResaltaraltoProducto(esInicial);
		this.setResaltaranchoProducto(esInicial);
		this.setResaltarlargoProducto(esInicial);
		this.setResaltarvolumenProducto(esInicial);
		this.setResaltarpesoProducto(esInicial);
		this.setResaltargramosProducto(esInicial);
		this.setResaltarunidades_cajaProducto(esInicial);
		this.setResaltarmargenProducto(esInicial);
		this.setResaltarfactorProducto(esInicial);
		this.setResaltarfobProducto(esInicial);
		this.setResaltarfob2Producto(esInicial);
		this.setResaltarid_tipo_productoProducto(esInicial);
		this.setResaltarid_color_productoProducto(esInicial);
		this.setResaltarid_clase_productoProducto(esInicial);
		this.setResaltarid_efecto_productoProducto(esInicial);
		this.setResaltarid_marca_productoProducto(esInicial);
		this.setResaltarid_modelo_productoProducto(esInicial);
		this.setResaltarid_material_productoProducto(esInicial);
		this.setResaltarid_segmento_productoProducto(esInicial);
		this.setResaltarid_talla_productoProducto(esInicial);
		this.setResaltargrupoProducto(esInicial);
		this.setResaltarreferenciaProducto(esInicial);
		this.setResaltaraplicacionProducto(esInicial);
		this.setResaltarprocedenciaProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProductoConstantesFunciones.ID)) {
				this.setResaltaridProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setResaltarnombre_extranjeroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.RESUMENDETALLE)) {
				this.setResaltarresumen_detalleProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CODIGOBARRA)) {
				this.setResaltarcodigo_barraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setResaltarid_tipo_producto_servicio_invenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setResaltarid_tipo_costeoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDUNIDADPESO)) {
				this.setResaltarid_unidad_pesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDARANCEL)) {
				this.setResaltarid_arancelProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO)) {
				this.setResaltarid_cliente_proveedor_defectoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVA)) {
				this.setResaltarivaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IVAVALOR)) {
				this.setResaltariva_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICE)) {
				this.setResaltariceProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ICEVALOR)) {
				this.setResaltarice_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELPORCENTAJE)) {
				this.setResaltararancel_porcentajeProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ARANCELVALOR)) {
				this.setResaltararancel_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISION)) {
				this.setResaltarcomisionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.COMISIONVALOR)) {
				this.setResaltarcomision_valorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.DIASPRODUCCION)) {
				this.setResaltardias_produccionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSTOCKNEGATIVO)) {
				this.setResaltarcon_stock_negativoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRECIOMINIMO)) {
				this.setResaltarcon_precio_minimoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONLOTE)) {
				this.setResaltarcon_loteProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONFIRMACION)) {
				this.setResaltarcon_confirmacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONPRESUPUESTO)) {
				this.setResaltarcon_presupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONIMPORTACION)) {
				this.setResaltarcon_importacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONFINAL)) {
				this.setResaltarcon_finalProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONCONSEP)) {
				this.setResaltarcon_consepProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONSERIE)) {
				this.setResaltarcon_serieProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.CONBALANZA)) {
				this.setResaltarcon_balanzaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ALTO)) {
				this.setResaltaraltoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.ANCHO)) {
				this.setResaltaranchoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.LARGO)) {
				this.setResaltarlargoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.VOLUMEN)) {
				this.setResaltarvolumenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PESO)) {
				this.setResaltarpesoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRAMOS)) {
				this.setResaltargramosProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.UNIDADESCAJA)) {
				this.setResaltarunidades_cajaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.MARGEN)) {
				this.setResaltarmargenProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FACTOR)) {
				this.setResaltarfactorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB)) {
				this.setResaltarfobProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.FOB2)) {
				this.setResaltarfob2Producto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setResaltarid_color_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setResaltarid_clase_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setResaltarid_efecto_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setResaltarid_marca_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setResaltarid_modelo_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setResaltarid_material_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setResaltarid_segmento_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setResaltarid_talla_productoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.GRUPO)) {
				this.setResaltargrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.APLICACION)) {
				this.setResaltaraplicacionProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProductoConstantesFunciones.PROCEDENCIA)) {
				this.setResaltarprocedenciaProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProveedorProductoProducto=null;

	public Border getResaltarProveedorProductoProducto() {
		return this.resaltarProveedorProductoProducto;
	}

	public void setResaltarProveedorProductoProducto(Border borderResaltarProveedorProducto) {
		if(borderResaltarProveedorProducto!=null) {
			this.resaltarProveedorProductoProducto= borderResaltarProveedorProducto;
		}
	}

	public Border setResaltarProveedorProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProveedorProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProveedorProducto);
			
		this.resaltarProveedorProductoProducto= borderResaltarProveedorProducto;

		 return borderResaltarProveedorProducto;
	}



	public Boolean mostrarProveedorProductoProducto=true;

	public Boolean getMostrarProveedorProductoProducto() {
		return this.mostrarProveedorProductoProducto;
	}

	public void setMostrarProveedorProductoProducto(Boolean visibilidadResaltarProveedorProducto) {
		this.mostrarProveedorProductoProducto= visibilidadResaltarProveedorProducto;
	}



	public Boolean activarProveedorProductoProducto=true;

	public Boolean gethabilitarResaltarProveedorProductoProducto() {
		return this.activarProveedorProductoProducto;
	}

	public void setActivarProveedorProductoProducto(Boolean habilitarResaltarProveedorProducto) {
		this.activarProveedorProductoProducto= habilitarResaltarProveedorProducto;
	}


	public Border resaltarPrecioProducto=null;

	public Border getResaltarPrecioProducto() {
		return this.resaltarPrecioProducto;
	}

	public void setResaltarPrecioProducto(Border borderResaltarPrecio) {
		if(borderResaltarPrecio!=null) {
			this.resaltarPrecioProducto= borderResaltarPrecio;
		}
	}

	public Border setResaltarPrecioProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarPrecio);
			
		this.resaltarPrecioProducto= borderResaltarPrecio;

		 return borderResaltarPrecio;
	}



	public Boolean mostrarPrecioProducto=true;

	public Boolean getMostrarPrecioProducto() {
		return this.mostrarPrecioProducto;
	}

	public void setMostrarPrecioProducto(Boolean visibilidadResaltarPrecio) {
		this.mostrarPrecioProducto= visibilidadResaltarPrecio;
	}



	public Boolean activarPrecioProducto=true;

	public Boolean gethabilitarResaltarPrecioProducto() {
		return this.activarPrecioProducto;
	}

	public void setActivarPrecioProducto(Boolean habilitarResaltarPrecio) {
		this.activarPrecioProducto= habilitarResaltarPrecio;
	}


	public Border resaltarDetalleImpuestoInvenProducto=null;

	public Border getResaltarDetalleImpuestoInvenProducto() {
		return this.resaltarDetalleImpuestoInvenProducto;
	}

	public void setResaltarDetalleImpuestoInvenProducto(Border borderResaltarDetalleImpuestoInven) {
		if(borderResaltarDetalleImpuestoInven!=null) {
			this.resaltarDetalleImpuestoInvenProducto= borderResaltarDetalleImpuestoInven;
		}
	}

	public Border setResaltarDetalleImpuestoInvenProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleImpuestoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarDetalleImpuestoInven);
			
		this.resaltarDetalleImpuestoInvenProducto= borderResaltarDetalleImpuestoInven;

		 return borderResaltarDetalleImpuestoInven;
	}



	public Boolean mostrarDetalleImpuestoInvenProducto=true;

	public Boolean getMostrarDetalleImpuestoInvenProducto() {
		return this.mostrarDetalleImpuestoInvenProducto;
	}

	public void setMostrarDetalleImpuestoInvenProducto(Boolean visibilidadResaltarDetalleImpuestoInven) {
		this.mostrarDetalleImpuestoInvenProducto= visibilidadResaltarDetalleImpuestoInven;
	}



	public Boolean activarDetalleImpuestoInvenProducto=true;

	public Boolean gethabilitarResaltarDetalleImpuestoInvenProducto() {
		return this.activarDetalleImpuestoInvenProducto;
	}

	public void setActivarDetalleImpuestoInvenProducto(Boolean habilitarResaltarDetalleImpuestoInven) {
		this.activarDetalleImpuestoInvenProducto= habilitarResaltarDetalleImpuestoInven;
	}


	public Border resaltarPresupuestoVentasProducto=null;

	public Border getResaltarPresupuestoVentasProducto() {
		return this.resaltarPresupuestoVentasProducto;
	}

	public void setResaltarPresupuestoVentasProducto(Border borderResaltarPresupuestoVentas) {
		if(borderResaltarPresupuestoVentas!=null) {
			this.resaltarPresupuestoVentasProducto= borderResaltarPresupuestoVentas;
		}
	}

	public Border setResaltarPresupuestoVentasProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoVentas=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarPresupuestoVentas);
			
		this.resaltarPresupuestoVentasProducto= borderResaltarPresupuestoVentas;

		 return borderResaltarPresupuestoVentas;
	}



	public Boolean mostrarPresupuestoVentasProducto=true;

	public Boolean getMostrarPresupuestoVentasProducto() {
		return this.mostrarPresupuestoVentasProducto;
	}

	public void setMostrarPresupuestoVentasProducto(Boolean visibilidadResaltarPresupuestoVentas) {
		this.mostrarPresupuestoVentasProducto= visibilidadResaltarPresupuestoVentas;
	}



	public Boolean activarPresupuestoVentasProducto=true;

	public Boolean gethabilitarResaltarPresupuestoVentasProducto() {
		return this.activarPresupuestoVentasProducto;
	}

	public void setActivarPresupuestoVentasProducto(Boolean habilitarResaltarPresupuestoVentas) {
		this.activarPresupuestoVentasProducto= habilitarResaltarPresupuestoVentas;
	}


	public Border resaltarPoliticaProductoProducto=null;

	public Border getResaltarPoliticaProductoProducto() {
		return this.resaltarPoliticaProductoProducto;
	}

	public void setResaltarPoliticaProductoProducto(Border borderResaltarPoliticaProducto) {
		if(borderResaltarPoliticaProducto!=null) {
			this.resaltarPoliticaProductoProducto= borderResaltarPoliticaProducto;
		}
	}

	public Border setResaltarPoliticaProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticaProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarPoliticaProducto);
			
		this.resaltarPoliticaProductoProducto= borderResaltarPoliticaProducto;

		 return borderResaltarPoliticaProducto;
	}



	public Boolean mostrarPoliticaProductoProducto=true;

	public Boolean getMostrarPoliticaProductoProducto() {
		return this.mostrarPoliticaProductoProducto;
	}

	public void setMostrarPoliticaProductoProducto(Boolean visibilidadResaltarPoliticaProducto) {
		this.mostrarPoliticaProductoProducto= visibilidadResaltarPoliticaProducto;
	}



	public Boolean activarPoliticaProductoProducto=true;

	public Boolean gethabilitarResaltarPoliticaProductoProducto() {
		return this.activarPoliticaProductoProducto;
	}

	public void setActivarPoliticaProductoProducto(Boolean habilitarResaltarPoliticaProducto) {
		this.activarPoliticaProductoProducto= habilitarResaltarPoliticaProducto;
	}


	public Border resaltarSerieProductoProducto=null;

	public Border getResaltarSerieProductoProducto() {
		return this.resaltarSerieProductoProducto;
	}

	public void setResaltarSerieProductoProducto(Border borderResaltarSerieProducto) {
		if(borderResaltarSerieProducto!=null) {
			this.resaltarSerieProductoProducto= borderResaltarSerieProducto;
		}
	}

	public Border setResaltarSerieProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarSerieProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarSerieProducto);
			
		this.resaltarSerieProductoProducto= borderResaltarSerieProducto;

		 return borderResaltarSerieProducto;
	}



	public Boolean mostrarSerieProductoProducto=true;

	public Boolean getMostrarSerieProductoProducto() {
		return this.mostrarSerieProductoProducto;
	}

	public void setMostrarSerieProductoProducto(Boolean visibilidadResaltarSerieProducto) {
		this.mostrarSerieProductoProducto= visibilidadResaltarSerieProducto;
	}



	public Boolean activarSerieProductoProducto=true;

	public Boolean gethabilitarResaltarSerieProductoProducto() {
		return this.activarSerieProductoProducto;
	}

	public void setActivarSerieProductoProducto(Boolean habilitarResaltarSerieProducto) {
		this.activarSerieProductoProducto= habilitarResaltarSerieProducto;
	}


	public Border resaltarUbicacionProduProducto=null;

	public Border getResaltarUbicacionProduProducto() {
		return this.resaltarUbicacionProduProducto;
	}

	public void setResaltarUbicacionProduProducto(Border borderResaltarUbicacionProdu) {
		if(borderResaltarUbicacionProdu!=null) {
			this.resaltarUbicacionProduProducto= borderResaltarUbicacionProdu;
		}
	}

	public Border setResaltarUbicacionProduProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarUbicacionProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarUbicacionProdu);
			
		this.resaltarUbicacionProduProducto= borderResaltarUbicacionProdu;

		 return borderResaltarUbicacionProdu;
	}



	public Boolean mostrarUbicacionProduProducto=true;

	public Boolean getMostrarUbicacionProduProducto() {
		return this.mostrarUbicacionProduProducto;
	}

	public void setMostrarUbicacionProduProducto(Boolean visibilidadResaltarUbicacionProdu) {
		this.mostrarUbicacionProduProducto= visibilidadResaltarUbicacionProdu;
	}



	public Boolean activarUbicacionProduProducto=true;

	public Boolean gethabilitarResaltarUbicacionProduProducto() {
		return this.activarUbicacionProduProducto;
	}

	public void setActivarUbicacionProduProducto(Boolean habilitarResaltarUbicacionProdu) {
		this.activarUbicacionProduProducto= habilitarResaltarUbicacionProdu;
	}


	public Border resaltarParametroProductoProducto=null;

	public Border getResaltarParametroProductoProducto() {
		return this.resaltarParametroProductoProducto;
	}

	public void setResaltarParametroProductoProducto(Border borderResaltarParametroProducto) {
		if(borderResaltarParametroProducto!=null) {
			this.resaltarParametroProductoProducto= borderResaltarParametroProducto;
		}
	}

	public Border setResaltarParametroProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarParametroProducto);
			
		this.resaltarParametroProductoProducto= borderResaltarParametroProducto;

		 return borderResaltarParametroProducto;
	}



	public Boolean mostrarParametroProductoProducto=true;

	public Boolean getMostrarParametroProductoProducto() {
		return this.mostrarParametroProductoProducto;
	}

	public void setMostrarParametroProductoProducto(Boolean visibilidadResaltarParametroProducto) {
		this.mostrarParametroProductoProducto= visibilidadResaltarParametroProducto;
	}



	public Boolean activarParametroProductoProducto=true;

	public Boolean gethabilitarResaltarParametroProductoProducto() {
		return this.activarParametroProductoProducto;
	}

	public void setActivarParametroProductoProducto(Boolean habilitarResaltarParametroProducto) {
		this.activarParametroProductoProducto= habilitarResaltarParametroProducto;
	}


	public Border resaltarProductoUnidadProducto=null;

	public Border getResaltarProductoUnidadProducto() {
		return this.resaltarProductoUnidadProducto;
	}

	public void setResaltarProductoUnidadProducto(Border borderResaltarProductoUnidad) {
		if(borderResaltarProductoUnidad!=null) {
			this.resaltarProductoUnidadProducto= borderResaltarProductoUnidad;
		}
	}

	public Border setResaltarProductoUnidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoUnidad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoUnidad);
			
		this.resaltarProductoUnidadProducto= borderResaltarProductoUnidad;

		 return borderResaltarProductoUnidad;
	}



	public Boolean mostrarProductoUnidadProducto=true;

	public Boolean getMostrarProductoUnidadProducto() {
		return this.mostrarProductoUnidadProducto;
	}

	public void setMostrarProductoUnidadProducto(Boolean visibilidadResaltarProductoUnidad) {
		this.mostrarProductoUnidadProducto= visibilidadResaltarProductoUnidad;
	}



	public Boolean activarProductoUnidadProducto=true;

	public Boolean gethabilitarResaltarProductoUnidadProducto() {
		return this.activarProductoUnidadProducto;
	}

	public void setActivarProductoUnidadProducto(Boolean habilitarResaltarProductoUnidad) {
		this.activarProductoUnidadProducto= habilitarResaltarProductoUnidad;
	}


	public Border resaltarIngredienteProducto=null;

	public Border getResaltarIngredienteProducto() {
		return this.resaltarIngredienteProducto;
	}

	public void setResaltarIngredienteProducto(Border borderResaltarIngrediente) {
		if(borderResaltarIngrediente!=null) {
			this.resaltarIngredienteProducto= borderResaltarIngrediente;
		}
	}

	public Border setResaltarIngredienteProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarIngrediente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarIngrediente);
			
		this.resaltarIngredienteProducto= borderResaltarIngrediente;

		 return borderResaltarIngrediente;
	}



	public Boolean mostrarIngredienteProducto=true;

	public Boolean getMostrarIngredienteProducto() {
		return this.mostrarIngredienteProducto;
	}

	public void setMostrarIngredienteProducto(Boolean visibilidadResaltarIngrediente) {
		this.mostrarIngredienteProducto= visibilidadResaltarIngrediente;
	}



	public Boolean activarIngredienteProducto=true;

	public Boolean gethabilitarResaltarIngredienteProducto() {
		return this.activarIngredienteProducto;
	}

	public void setActivarIngredienteProducto(Boolean habilitarResaltarIngrediente) {
		this.activarIngredienteProducto= habilitarResaltarIngrediente;
	}


	public Border resaltarProductoCaracProducto=null;

	public Border getResaltarProductoCaracProducto() {
		return this.resaltarProductoCaracProducto;
	}

	public void setResaltarProductoCaracProducto(Border borderResaltarProductoCarac) {
		if(borderResaltarProductoCarac!=null) {
			this.resaltarProductoCaracProducto= borderResaltarProductoCarac;
		}
	}

	public Border setResaltarProductoCaracProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoCarac=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoCarac);
			
		this.resaltarProductoCaracProducto= borderResaltarProductoCarac;

		 return borderResaltarProductoCarac;
	}



	public Boolean mostrarProductoCaracProducto=true;

	public Boolean getMostrarProductoCaracProducto() {
		return this.mostrarProductoCaracProducto;
	}

	public void setMostrarProductoCaracProducto(Boolean visibilidadResaltarProductoCarac) {
		this.mostrarProductoCaracProducto= visibilidadResaltarProductoCarac;
	}



	public Boolean activarProductoCaracProducto=true;

	public Boolean gethabilitarResaltarProductoCaracProducto() {
		return this.activarProductoCaracProducto;
	}

	public void setActivarProductoCaracProducto(Boolean habilitarResaltarProductoCarac) {
		this.activarProductoCaracProducto= habilitarResaltarProductoCarac;
	}


	public Border resaltarServicioClienteProducto=null;

	public Border getResaltarServicioClienteProducto() {
		return this.resaltarServicioClienteProducto;
	}

	public void setResaltarServicioClienteProducto(Border borderResaltarServicioCliente) {
		if(borderResaltarServicioCliente!=null) {
			this.resaltarServicioClienteProducto= borderResaltarServicioCliente;
		}
	}

	public Border setResaltarServicioClienteProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarServicioCliente);
			
		this.resaltarServicioClienteProducto= borderResaltarServicioCliente;

		 return borderResaltarServicioCliente;
	}



	public Boolean mostrarServicioClienteProducto=true;

	public Boolean getMostrarServicioClienteProducto() {
		return this.mostrarServicioClienteProducto;
	}

	public void setMostrarServicioClienteProducto(Boolean visibilidadResaltarServicioCliente) {
		this.mostrarServicioClienteProducto= visibilidadResaltarServicioCliente;
	}



	public Boolean activarServicioClienteProducto=true;

	public Boolean gethabilitarResaltarServicioClienteProducto() {
		return this.activarServicioClienteProducto;
	}

	public void setActivarServicioClienteProducto(Boolean habilitarResaltarServicioCliente) {
		this.activarServicioClienteProducto= habilitarResaltarServicioCliente;
	}


	public Border resaltarProductoPromocionProducto=null;

	public Border getResaltarProductoPromocionProducto() {
		return this.resaltarProductoPromocionProducto;
	}

	public void setResaltarProductoPromocionProducto(Border borderResaltarProductoPromocion) {
		if(borderResaltarProductoPromocion!=null) {
			this.resaltarProductoPromocionProducto= borderResaltarProductoPromocion;
		}
	}

	public Border setResaltarProductoPromocionProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoPromocion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoPromocion);
			
		this.resaltarProductoPromocionProducto= borderResaltarProductoPromocion;

		 return borderResaltarProductoPromocion;
	}



	public Boolean mostrarProductoPromocionProducto=true;

	public Boolean getMostrarProductoPromocionProducto() {
		return this.mostrarProductoPromocionProducto;
	}

	public void setMostrarProductoPromocionProducto(Boolean visibilidadResaltarProductoPromocion) {
		this.mostrarProductoPromocionProducto= visibilidadResaltarProductoPromocion;
	}



	public Boolean activarProductoPromocionProducto=true;

	public Boolean gethabilitarResaltarProductoPromocionProducto() {
		return this.activarProductoPromocionProducto;
	}

	public void setActivarProductoPromocionProducto(Boolean habilitarResaltarProductoPromocion) {
		this.activarProductoPromocionProducto= habilitarResaltarProductoPromocion;
	}


	public Border resaltarProductoEspeciProducto=null;

	public Border getResaltarProductoEspeciProducto() {
		return this.resaltarProductoEspeciProducto;
	}

	public void setResaltarProductoEspeciProducto(Border borderResaltarProductoEspeci) {
		if(borderResaltarProductoEspeci!=null) {
			this.resaltarProductoEspeciProducto= borderResaltarProductoEspeci;
		}
	}

	public Border setResaltarProductoEspeciProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoEspeci=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoEspeci);
			
		this.resaltarProductoEspeciProducto= borderResaltarProductoEspeci;

		 return borderResaltarProductoEspeci;
	}



	public Boolean mostrarProductoEspeciProducto=true;

	public Boolean getMostrarProductoEspeciProducto() {
		return this.mostrarProductoEspeciProducto;
	}

	public void setMostrarProductoEspeciProducto(Boolean visibilidadResaltarProductoEspeci) {
		this.mostrarProductoEspeciProducto= visibilidadResaltarProductoEspeci;
	}



	public Boolean activarProductoEspeciProducto=true;

	public Boolean gethabilitarResaltarProductoEspeciProducto() {
		return this.activarProductoEspeciProducto;
	}

	public void setActivarProductoEspeciProducto(Boolean habilitarResaltarProductoEspeci) {
		this.activarProductoEspeciProducto= habilitarResaltarProductoEspeci;
	}


	public Border resaltarProductoReemplaProducto=null;

	public Border getResaltarProductoReemplaProducto() {
		return this.resaltarProductoReemplaProducto;
	}

	public void setResaltarProductoReemplaProducto(Border borderResaltarProductoReempla) {
		if(borderResaltarProductoReempla!=null) {
			this.resaltarProductoReemplaProducto= borderResaltarProductoReempla;
		}
	}

	public Border setResaltarProductoReemplaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoReempla=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoReempla);
			
		this.resaltarProductoReemplaProducto= borderResaltarProductoReempla;

		 return borderResaltarProductoReempla;
	}



	public Boolean mostrarProductoReemplaProducto=true;

	public Boolean getMostrarProductoReemplaProducto() {
		return this.mostrarProductoReemplaProducto;
	}

	public void setMostrarProductoReemplaProducto(Boolean visibilidadResaltarProductoReempla) {
		this.mostrarProductoReemplaProducto= visibilidadResaltarProductoReempla;
	}



	public Boolean activarProductoReemplaProducto=true;

	public Boolean gethabilitarResaltarProductoReemplaProducto() {
		return this.activarProductoReemplaProducto;
	}

	public void setActivarProductoReemplaProducto(Boolean habilitarResaltarProductoReempla) {
		this.activarProductoReemplaProducto= habilitarResaltarProductoReempla;
	}


	public Border resaltarProductoEstadisticaProducto=null;

	public Border getResaltarProductoEstadisticaProducto() {
		return this.resaltarProductoEstadisticaProducto;
	}

	public void setResaltarProductoEstadisticaProducto(Border borderResaltarProductoEstadistica) {
		if(borderResaltarProductoEstadistica!=null) {
			this.resaltarProductoEstadisticaProducto= borderResaltarProductoEstadistica;
		}
	}

	public Border setResaltarProductoEstadisticaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoEstadistica=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoEstadistica);
			
		this.resaltarProductoEstadisticaProducto= borderResaltarProductoEstadistica;

		 return borderResaltarProductoEstadistica;
	}



	public Boolean mostrarProductoEstadisticaProducto=true;

	public Boolean getMostrarProductoEstadisticaProducto() {
		return this.mostrarProductoEstadisticaProducto;
	}

	public void setMostrarProductoEstadisticaProducto(Boolean visibilidadResaltarProductoEstadistica) {
		this.mostrarProductoEstadisticaProducto= visibilidadResaltarProductoEstadistica;
	}



	public Boolean activarProductoEstadisticaProducto=true;

	public Boolean gethabilitarResaltarProductoEstadisticaProducto() {
		return this.activarProductoEstadisticaProducto;
	}

	public void setActivarProductoEstadisticaProducto(Boolean habilitarResaltarProductoEstadistica) {
		this.activarProductoEstadisticaProducto= habilitarResaltarProductoEstadistica;
	}


	public Border resaltarPoliticaFactuProducto=null;

	public Border getResaltarPoliticaFactuProducto() {
		return this.resaltarPoliticaFactuProducto;
	}

	public void setResaltarPoliticaFactuProducto(Border borderResaltarPoliticaFactu) {
		if(borderResaltarPoliticaFactu!=null) {
			this.resaltarPoliticaFactuProducto= borderResaltarPoliticaFactu;
		}
	}

	public Border setResaltarPoliticaFactuProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticaFactu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarPoliticaFactu);
			
		this.resaltarPoliticaFactuProducto= borderResaltarPoliticaFactu;

		 return borderResaltarPoliticaFactu;
	}



	public Boolean mostrarPoliticaFactuProducto=true;

	public Boolean getMostrarPoliticaFactuProducto() {
		return this.mostrarPoliticaFactuProducto;
	}

	public void setMostrarPoliticaFactuProducto(Boolean visibilidadResaltarPoliticaFactu) {
		this.mostrarPoliticaFactuProducto= visibilidadResaltarPoliticaFactu;
	}



	public Boolean activarPoliticaFactuProducto=true;

	public Boolean gethabilitarResaltarPoliticaFactuProducto() {
		return this.activarPoliticaFactuProducto;
	}

	public void setActivarPoliticaFactuProducto(Boolean habilitarResaltarPoliticaFactu) {
		this.activarPoliticaFactuProducto= habilitarResaltarPoliticaFactu;
	}


	public Border resaltarProductoCuentaContableProducto=null;

	public Border getResaltarProductoCuentaContableProducto() {
		return this.resaltarProductoCuentaContableProducto;
	}

	public void setResaltarProductoCuentaContableProducto(Border borderResaltarProductoCuentaContable) {
		if(borderResaltarProductoCuentaContable!=null) {
			this.resaltarProductoCuentaContableProducto= borderResaltarProductoCuentaContable;
		}
	}

	public Border setResaltarProductoCuentaContableProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoCuentaContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarProductoCuentaContable);
			
		this.resaltarProductoCuentaContableProducto= borderResaltarProductoCuentaContable;

		 return borderResaltarProductoCuentaContable;
	}



	public Boolean mostrarProductoCuentaContableProducto=true;

	public Boolean getMostrarProductoCuentaContableProducto() {
		return this.mostrarProductoCuentaContableProducto;
	}

	public void setMostrarProductoCuentaContableProducto(Boolean visibilidadResaltarProductoCuentaContable) {
		this.mostrarProductoCuentaContableProducto= visibilidadResaltarProductoCuentaContable;
	}



	public Boolean activarProductoCuentaContableProducto=true;

	public Boolean gethabilitarResaltarProductoCuentaContableProducto() {
		return this.activarProductoCuentaContableProducto;
	}

	public void setActivarProductoCuentaContableProducto(Boolean habilitarResaltarProductoCuentaContable) {
		this.activarProductoCuentaContableProducto= habilitarResaltarProductoCuentaContable;
	}


	public Border resaltarBodegaProductoProducto=null;

	public Border getResaltarBodegaProductoProducto() {
		return this.resaltarBodegaProductoProducto;
	}

	public void setResaltarBodegaProductoProducto(Border borderResaltarBodegaProducto) {
		if(borderResaltarBodegaProducto!=null) {
			this.resaltarBodegaProductoProducto= borderResaltarBodegaProducto;
		}
	}

	public Border setResaltarBodegaProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarBodegaProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarBodegaProducto);
			
		this.resaltarBodegaProductoProducto= borderResaltarBodegaProducto;

		 return borderResaltarBodegaProducto;
	}



	public Boolean mostrarBodegaProductoProducto=true;

	public Boolean getMostrarBodegaProductoProducto() {
		return this.mostrarBodegaProductoProducto;
	}

	public void setMostrarBodegaProductoProducto(Boolean visibilidadResaltarBodegaProducto) {
		this.mostrarBodegaProductoProducto= visibilidadResaltarBodegaProducto;
	}



	public Boolean activarBodegaProductoProducto=true;

	public Boolean gethabilitarResaltarBodegaProductoProducto() {
		return this.activarBodegaProductoProducto;
	}

	public void setActivarBodegaProductoProducto(Boolean habilitarResaltarBodegaProducto) {
		this.activarBodegaProductoProducto= habilitarResaltarBodegaProducto;
	}


	public Border resaltarPresupuestoProductoProducto=null;

	public Border getResaltarPresupuestoProductoProducto() {
		return this.resaltarPresupuestoProductoProducto;
	}

	public void setResaltarPresupuestoProductoProducto(Border borderResaltarPresupuestoProducto) {
		if(borderResaltarPresupuestoProducto!=null) {
			this.resaltarPresupuestoProductoProducto= borderResaltarPresupuestoProducto;
		}
	}

	public Border setResaltarPresupuestoProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarPresupuestoProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarPresupuestoProducto);
			
		this.resaltarPresupuestoProductoProducto= borderResaltarPresupuestoProducto;

		 return borderResaltarPresupuestoProducto;
	}



	public Boolean mostrarPresupuestoProductoProducto=true;

	public Boolean getMostrarPresupuestoProductoProducto() {
		return this.mostrarPresupuestoProductoProducto;
	}

	public void setMostrarPresupuestoProductoProducto(Boolean visibilidadResaltarPresupuestoProducto) {
		this.mostrarPresupuestoProductoProducto= visibilidadResaltarPresupuestoProducto;
	}



	public Boolean activarPresupuestoProductoProducto=true;

	public Boolean gethabilitarResaltarPresupuestoProductoProducto() {
		return this.activarPresupuestoProductoProducto;
	}

	public void setActivarPresupuestoProductoProducto(Boolean habilitarResaltarPresupuestoProducto) {
		this.activarPresupuestoProductoProducto= habilitarResaltarPresupuestoProducto;
	}


	public Border resaltarSaldoMesProductoProducto=null;

	public Border getResaltarSaldoMesProductoProducto() {
		return this.resaltarSaldoMesProductoProducto;
	}

	public void setResaltarSaldoMesProductoProducto(Border borderResaltarSaldoMesProducto) {
		if(borderResaltarSaldoMesProducto!=null) {
			this.resaltarSaldoMesProductoProducto= borderResaltarSaldoMesProducto;
		}
	}

	public Border setResaltarSaldoMesProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltarSaldoMesProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//productoBeanSwingJInternalFrame.jTtoolBarProducto.setBorder(borderResaltarSaldoMesProducto);
			
		this.resaltarSaldoMesProductoProducto= borderResaltarSaldoMesProducto;

		 return borderResaltarSaldoMesProducto;
	}



	public Boolean mostrarSaldoMesProductoProducto=true;

	public Boolean getMostrarSaldoMesProductoProducto() {
		return this.mostrarSaldoMesProductoProducto;
	}

	public void setMostrarSaldoMesProductoProducto(Boolean visibilidadResaltarSaldoMesProducto) {
		this.mostrarSaldoMesProductoProducto= visibilidadResaltarSaldoMesProducto;
	}



	public Boolean activarSaldoMesProductoProducto=true;

	public Boolean gethabilitarResaltarSaldoMesProductoProducto() {
		return this.activarSaldoMesProductoProducto;
	}

	public void setActivarSaldoMesProductoProducto(Boolean habilitarResaltarSaldoMesProducto) {
		this.activarSaldoMesProductoProducto= habilitarResaltarSaldoMesProducto;
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

		this.setMostrarProveedorProductoProducto(esInicial);
		this.setMostrarPrecioProducto(esInicial);
		this.setMostrarDetalleImpuestoInvenProducto(esInicial);
		this.setMostrarPresupuestoVentasProducto(esInicial);
		this.setMostrarPoliticaProductoProducto(esInicial);
		this.setMostrarSerieProductoProducto(esInicial);
		this.setMostrarUbicacionProduProducto(esInicial);
		this.setMostrarParametroProductoProducto(esInicial);
		this.setMostrarProductoUnidadProducto(esInicial);
		this.setMostrarIngredienteProducto(esInicial);
		this.setMostrarProductoCaracProducto(esInicial);
		this.setMostrarServicioClienteProducto(esInicial);
		this.setMostrarProductoPromocionProducto(esInicial);
		this.setMostrarProductoEspeciProducto(esInicial);
		this.setMostrarProductoReemplaProducto(esInicial);
		this.setMostrarProductoEstadisticaProducto(esInicial);
		this.setMostrarPoliticaFactuProducto(esInicial);
		this.setMostrarProductoCuentaContableProducto(esInicial);
		this.setMostrarBodegaProductoProducto(esInicial);
		this.setMostrarPresupuestoProductoProducto(esInicial);
		this.setMostrarSaldoMesProductoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setMostrarProveedorProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setMostrarPrecioProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setMostrarDetalleImpuestoInvenProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setMostrarPresupuestoVentasProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaProducto.class)) {
				this.setMostrarPoliticaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SerieProducto.class)) {
				this.setMostrarSerieProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setMostrarUbicacionProduProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroProducto.class)) {
				this.setMostrarParametroProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoUnidad.class)) {
				this.setMostrarProductoUnidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ingrediente.class)) {
				this.setMostrarIngredienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCarac.class)) {
				this.setMostrarProductoCaracProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setMostrarServicioClienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPromocion.class)) {
				this.setMostrarProductoPromocionProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEspeci.class)) {
				this.setMostrarProductoEspeciProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setMostrarProductoReemplaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEstadistica.class)) {
				this.setMostrarProductoEstadisticaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaFactu.class)) {
				this.setMostrarPoliticaFactuProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCuentaContable.class)) {
				this.setMostrarProductoCuentaContableProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(BodegaProducto.class)) {
				this.setMostrarBodegaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoProducto.class)) {
				this.setMostrarPresupuestoProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SaldoMesProducto.class)) {
				this.setMostrarSaldoMesProductoProducto(esAsigna);
				continue;
			}
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

		this.setActivarProveedorProductoProducto(esInicial);
		this.setActivarPrecioProducto(esInicial);
		this.setActivarDetalleImpuestoInvenProducto(esInicial);
		this.setActivarPresupuestoVentasProducto(esInicial);
		this.setActivarPoliticaProductoProducto(esInicial);
		this.setActivarSerieProductoProducto(esInicial);
		this.setActivarUbicacionProduProducto(esInicial);
		this.setActivarParametroProductoProducto(esInicial);
		this.setActivarProductoUnidadProducto(esInicial);
		this.setActivarIngredienteProducto(esInicial);
		this.setActivarProductoCaracProducto(esInicial);
		this.setActivarServicioClienteProducto(esInicial);
		this.setActivarProductoPromocionProducto(esInicial);
		this.setActivarProductoEspeciProducto(esInicial);
		this.setActivarProductoReemplaProducto(esInicial);
		this.setActivarProductoEstadisticaProducto(esInicial);
		this.setActivarPoliticaFactuProducto(esInicial);
		this.setActivarProductoCuentaContableProducto(esInicial);
		this.setActivarBodegaProductoProducto(esInicial);
		this.setActivarPresupuestoProductoProducto(esInicial);
		this.setActivarSaldoMesProductoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setActivarProveedorProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setActivarPrecioProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setActivarDetalleImpuestoInvenProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setActivarPresupuestoVentasProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaProducto.class)) {
				this.setActivarPoliticaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SerieProducto.class)) {
				this.setActivarSerieProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setActivarUbicacionProduProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroProducto.class)) {
				this.setActivarParametroProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoUnidad.class)) {
				this.setActivarProductoUnidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ingrediente.class)) {
				this.setActivarIngredienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCarac.class)) {
				this.setActivarProductoCaracProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setActivarServicioClienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPromocion.class)) {
				this.setActivarProductoPromocionProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEspeci.class)) {
				this.setActivarProductoEspeciProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setActivarProductoReemplaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEstadistica.class)) {
				this.setActivarProductoEstadisticaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaFactu.class)) {
				this.setActivarPoliticaFactuProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCuentaContable.class)) {
				this.setActivarProductoCuentaContableProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(BodegaProducto.class)) {
				this.setActivarBodegaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoProducto.class)) {
				this.setActivarPresupuestoProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SaldoMesProducto.class)) {
				this.setActivarSaldoMesProductoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProveedorProductoProducto(esInicial);
		this.setResaltarPrecioProducto(esInicial);
		this.setResaltarDetalleImpuestoInvenProducto(esInicial);
		this.setResaltarPresupuestoVentasProducto(esInicial);
		this.setResaltarPoliticaProductoProducto(esInicial);
		this.setResaltarSerieProductoProducto(esInicial);
		this.setResaltarUbicacionProduProducto(esInicial);
		this.setResaltarParametroProductoProducto(esInicial);
		this.setResaltarProductoUnidadProducto(esInicial);
		this.setResaltarIngredienteProducto(esInicial);
		this.setResaltarProductoCaracProducto(esInicial);
		this.setResaltarServicioClienteProducto(esInicial);
		this.setResaltarProductoPromocionProducto(esInicial);
		this.setResaltarProductoEspeciProducto(esInicial);
		this.setResaltarProductoReemplaProducto(esInicial);
		this.setResaltarProductoEstadisticaProducto(esInicial);
		this.setResaltarPoliticaFactuProducto(esInicial);
		this.setResaltarProductoCuentaContableProducto(esInicial);
		this.setResaltarBodegaProductoProducto(esInicial);
		this.setResaltarPresupuestoProductoProducto(esInicial);
		this.setResaltarSaldoMesProductoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setResaltarProveedorProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Precio.class)) {
				this.setResaltarPrecioProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setResaltarDetalleImpuestoInvenProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoVentas.class)) {
				this.setResaltarPresupuestoVentasProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaProducto.class)) {
				this.setResaltarPoliticaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SerieProducto.class)) {
				this.setResaltarSerieProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setResaltarUbicacionProduProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroProducto.class)) {
				this.setResaltarParametroProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoUnidad.class)) {
				this.setResaltarProductoUnidadProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ingrediente.class)) {
				this.setResaltarIngredienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCarac.class)) {
				this.setResaltarProductoCaracProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setResaltarServicioClienteProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoPromocion.class)) {
				this.setResaltarProductoPromocionProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEspeci.class)) {
				this.setResaltarProductoEspeciProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoReempla.class)) {
				this.setResaltarProductoReemplaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoEstadistica.class)) {
				this.setResaltarProductoEstadisticaProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaFactu.class)) {
				this.setResaltarPoliticaFactuProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoCuentaContable.class)) {
				this.setResaltarProductoCuentaContableProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(BodegaProducto.class)) {
				this.setResaltarBodegaProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresupuestoProducto.class)) {
				this.setResaltarPresupuestoProductoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(SaldoMesProducto.class)) {
				this.setResaltarSaldoMesProductoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoProducto=true;

	public Boolean getMostrarBusquedaPorCodigoProducto() {
		return this.mostrarBusquedaPorCodigoProducto;
	}

	public void setMostrarBusquedaPorCodigoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreProducto=true;

	public Boolean getMostrarBusquedaPorNombreProducto() {
		return this.mostrarBusquedaPorNombreProducto;
	}

	public void setMostrarBusquedaPorNombreProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClaseProductoProducto=true;

	public Boolean getMostrarFK_IdClaseProductoProducto() {
		return this.mostrarFK_IdClaseProductoProducto;
	}

	public void setMostrarFK_IdClaseProductoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClaseProductoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProducto=true;

	public Boolean getMostrarFK_IdClienteProducto() {
		return this.mostrarFK_IdClienteProducto;
	}

	public void setMostrarFK_IdClienteProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProveedorDefectoProducto=true;

	public Boolean getMostrarFK_IdClienteProveedorDefectoProducto() {
		return this.mostrarFK_IdClienteProveedorDefectoProducto;
	}

	public void setMostrarFK_IdClienteProveedorDefectoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorDefectoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProducto=true;

	public Boolean getMostrarFK_IdEmpresaProducto() {
		return this.mostrarFK_IdEmpresaProducto;
	}

	public void setMostrarFK_IdEmpresaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaProducto=true;

	public Boolean getMostrarFK_IdLineaProducto() {
		return this.mostrarFK_IdLineaProducto;
	}

	public void setMostrarFK_IdLineaProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMarcaProductoProducto=true;

	public Boolean getMostrarFK_IdMarcaProductoProducto() {
		return this.mostrarFK_IdMarcaProductoProducto;
	}

	public void setMostrarFK_IdMarcaProductoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMarcaProductoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModeloProductoProducto=true;

	public Boolean getMostrarFK_IdModeloProductoProducto() {
		return this.mostrarFK_IdModeloProductoProducto;
	}

	public void setMostrarFK_IdModeloProductoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModeloProductoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalProducto=true;

	public Boolean getMostrarFK_IdSucursalProducto() {
		return this.mostrarFK_IdSucursalProducto;
	}

	public void setMostrarFK_IdSucursalProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoProducto=true;

	public Boolean getMostrarFK_IdTipoProductoProducto() {
		return this.mostrarFK_IdTipoProductoProducto;
	}

	public void setMostrarFK_IdTipoProductoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoServicioProducto=true;

	public Boolean getMostrarFK_IdTipoProductoServicioProducto() {
		return this.mostrarFK_IdTipoProductoServicioProducto;
	}

	public void setMostrarFK_IdTipoProductoServicioProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoServicioProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoServicioInvenProducto=true;

	public Boolean getMostrarFK_IdTipoProductoServicioInvenProducto() {
		return this.mostrarFK_IdTipoProductoServicioInvenProducto;
	}

	public void setMostrarFK_IdTipoProductoServicioInvenProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoServicioInvenProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoProducto=true;

	public Boolean getActivarBusquedaPorCodigoProducto() {
		return this.activarBusquedaPorCodigoProducto;
	}

	public void setActivarBusquedaPorCodigoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreProducto=true;

	public Boolean getActivarBusquedaPorNombreProducto() {
		return this.activarBusquedaPorNombreProducto;
	}

	public void setActivarBusquedaPorNombreProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdClaseProductoProducto=true;

	public Boolean getActivarFK_IdClaseProductoProducto() {
		return this.activarFK_IdClaseProductoProducto;
	}

	public void setActivarFK_IdClaseProductoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdClaseProductoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProducto=true;

	public Boolean getActivarFK_IdClienteProducto() {
		return this.activarFK_IdClienteProducto;
	}

	public void setActivarFK_IdClienteProducto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProveedorDefectoProducto=true;

	public Boolean getActivarFK_IdClienteProveedorDefectoProducto() {
		return this.activarFK_IdClienteProveedorDefectoProducto;
	}

	public void setActivarFK_IdClienteProveedorDefectoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorDefectoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProducto=true;

	public Boolean getActivarFK_IdEmpresaProducto() {
		return this.activarFK_IdEmpresaProducto;
	}

	public void setActivarFK_IdEmpresaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaProducto=true;

	public Boolean getActivarFK_IdLineaProducto() {
		return this.activarFK_IdLineaProducto;
	}

	public void setActivarFK_IdLineaProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdMarcaProductoProducto=true;

	public Boolean getActivarFK_IdMarcaProductoProducto() {
		return this.activarFK_IdMarcaProductoProducto;
	}

	public void setActivarFK_IdMarcaProductoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdMarcaProductoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdModeloProductoProducto=true;

	public Boolean getActivarFK_IdModeloProductoProducto() {
		return this.activarFK_IdModeloProductoProducto;
	}

	public void setActivarFK_IdModeloProductoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdModeloProductoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalProducto=true;

	public Boolean getActivarFK_IdSucursalProducto() {
		return this.activarFK_IdSucursalProducto;
	}

	public void setActivarFK_IdSucursalProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoProducto=true;

	public Boolean getActivarFK_IdTipoProductoProducto() {
		return this.activarFK_IdTipoProductoProducto;
	}

	public void setActivarFK_IdTipoProductoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoServicioProducto=true;

	public Boolean getActivarFK_IdTipoProductoServicioProducto() {
		return this.activarFK_IdTipoProductoServicioProducto;
	}

	public void setActivarFK_IdTipoProductoServicioProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoServicioProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoServicioInvenProducto=true;

	public Boolean getActivarFK_IdTipoProductoServicioInvenProducto() {
		return this.activarFK_IdTipoProductoServicioInvenProducto;
	}

	public void setActivarFK_IdTipoProductoServicioInvenProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoServicioInvenProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoProducto=null;

	public Border getResaltarBusquedaPorCodigoProducto() {
		return this.resaltarBusquedaPorCodigoProducto;
	}

	public void setResaltarBusquedaPorCodigoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreProducto=null;

	public Border getResaltarBusquedaPorNombreProducto() {
		return this.resaltarBusquedaPorNombreProducto;
	}

	public void setResaltarBusquedaPorNombreProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreProducto= borderResaltar;
	}

	public Border resaltarFK_IdClaseProductoProducto=null;

	public Border getResaltarFK_IdClaseProductoProducto() {
		return this.resaltarFK_IdClaseProductoProducto;
	}

	public void setResaltarFK_IdClaseProductoProducto(Border borderResaltar) {
		this.resaltarFK_IdClaseProductoProducto= borderResaltar;
	}

	public void setResaltarFK_IdClaseProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClaseProductoProducto= borderResaltar;
	}

	public Border resaltarFK_IdClienteProducto=null;

	public Border getResaltarFK_IdClienteProducto() {
		return this.resaltarFK_IdClienteProducto;
	}

	public void setResaltarFK_IdClienteProducto(Border borderResaltar) {
		this.resaltarFK_IdClienteProducto= borderResaltar;
	}

	public void setResaltarFK_IdClienteProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProducto= borderResaltar;
	}

	public Border resaltarFK_IdClienteProveedorDefectoProducto=null;

	public Border getResaltarFK_IdClienteProveedorDefectoProducto() {
		return this.resaltarFK_IdClienteProveedorDefectoProducto;
	}

	public void setResaltarFK_IdClienteProveedorDefectoProducto(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorDefectoProducto= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorDefectoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorDefectoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProducto=null;

	public Border getResaltarFK_IdEmpresaProducto() {
		return this.resaltarFK_IdEmpresaProducto;
	}

	public void setResaltarFK_IdEmpresaProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaProducto=null;

	public Border getResaltarFK_IdLineaProducto() {
		return this.resaltarFK_IdLineaProducto;
	}

	public void setResaltarFK_IdLineaProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaProducto= borderResaltar;
	}

	public Border resaltarFK_IdMarcaProductoProducto=null;

	public Border getResaltarFK_IdMarcaProductoProducto() {
		return this.resaltarFK_IdMarcaProductoProducto;
	}

	public void setResaltarFK_IdMarcaProductoProducto(Border borderResaltar) {
		this.resaltarFK_IdMarcaProductoProducto= borderResaltar;
	}

	public void setResaltarFK_IdMarcaProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMarcaProductoProducto= borderResaltar;
	}

	public Border resaltarFK_IdModeloProductoProducto=null;

	public Border getResaltarFK_IdModeloProductoProducto() {
		return this.resaltarFK_IdModeloProductoProducto;
	}

	public void setResaltarFK_IdModeloProductoProducto(Border borderResaltar) {
		this.resaltarFK_IdModeloProductoProducto= borderResaltar;
	}

	public void setResaltarFK_IdModeloProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModeloProductoProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalProducto=null;

	public Border getResaltarFK_IdSucursalProducto() {
		return this.resaltarFK_IdSucursalProducto;
	}

	public void setResaltarFK_IdSucursalProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoProducto=null;

	public Border getResaltarFK_IdTipoProductoProducto() {
		return this.resaltarFK_IdTipoProductoProducto;
	}

	public void setResaltarFK_IdTipoProductoProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoServicioProducto=null;

	public Border getResaltarFK_IdTipoProductoServicioProducto() {
		return this.resaltarFK_IdTipoProductoServicioProducto;
	}

	public void setResaltarFK_IdTipoProductoServicioProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoServicioProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoServicioProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoServicioProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoServicioInvenProducto=null;

	public Border getResaltarFK_IdTipoProductoServicioInvenProducto() {
		return this.resaltarFK_IdTipoProductoServicioInvenProducto;
	}

	public void setResaltarFK_IdTipoProductoServicioInvenProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoServicioInvenProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoServicioInvenProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ProductoBeanSwingJInternalFrame productoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoServicioInvenProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}