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


import com.bydan.erp.inventario.util.DefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.DefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DefinicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DefinicionConstantesFunciones extends DefinicionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Definicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Definicion"+DefinicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DefinicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DefinicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DefinicionConstantesFunciones.SCHEMA+"_"+DefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DefinicionConstantesFunciones.SCHEMA+"_"+DefinicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DefinicionConstantesFunciones.SCHEMA+"_"+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DefinicionConstantesFunciones.SCHEMA+"_"+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DefinicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefinicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DefinicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DefinicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DefinicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DefinicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Definiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Definicion";
	public static final String SCLASSWEBTITULO_LOWER="Definicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Definicion";
	public static final String OBJECTNAME="definicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="definicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select definicion from "+DefinicionConstantesFunciones.SPERSISTENCENAME+" definicion";
	public static String QUERYSELECTNATIVE="select "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".version_row,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_empresa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_modulo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".secuencial_formato,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".secuencial,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_transaccion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_sucursal,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_iva_item,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_mostrar_bodega,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".factor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_otro_recargo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_global_cliente,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_coa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_costeo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_retencion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_costo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_novedad_producto,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_ice,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cantidad,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_producto_por_proveedor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_lote_cliente,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cuenta_contable,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_detalle,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_iva_incluido,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_lotes,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".numero_descuentos,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_precio,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".numero_registros,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_centro_costo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_orden_iva,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_multi_empresa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_formato,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_en_linea,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_tributario,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_evaluacion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_ot,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_anticipo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cierre,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_general,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_por_producto,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_descuento,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_series,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".cantidad,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_documento,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_libro_contable,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_interno,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_reserva,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_precio_proveedor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_produccion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_codigo_barra,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_romaneos,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_cuenta_contable from "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME;//+" as "+DefinicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DefinicionConstantesFuncionesAdditional definicionConstantesFuncionesAdditional=null;
	
	public DefinicionConstantesFuncionesAdditional getDefinicionConstantesFuncionesAdditional() {
		return this.definicionConstantesFuncionesAdditional;
	}
	
	public void setDefinicionConstantesFuncionesAdditional(DefinicionConstantesFuncionesAdditional definicionConstantesFuncionesAdditional) {
		try {
			this.definicionConstantesFuncionesAdditional=definicionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String SECUENCIALFORMATO= "secuencial_formato";
    public static final String SECUENCIAL= "secuencial";
    public static final String IDTIPODEFINICION= "id_tipo_definicion";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOIVAITEM= "id_tipo_iva_item";
    public static final String CONMOSTRARBODEGA= "con_mostrar_bodega";
    public static final String FACTOR= "factor";
    public static final String CONOTRORECARGO= "con_otro_recargo";
    public static final String IDTIPOGLOBALCLIENTE= "id_tipo_global_cliente";
    public static final String CONCOA= "con_coa";
    public static final String IDTIPOCOSTEODEFINICION= "id_tipo_costeo_definicion";
    public static final String CONRETENCION= "con_retencion";
    public static final String IDTIPOCOSTODEFINICION= "id_tipo_costo_definicion";
    public static final String CONNOVEDADPRODUCTO= "con_novedad_producto";
    public static final String CONICE= "con_ice";
    public static final String CONCANTIDAD= "con_cantidad";
    public static final String CONPRODUCTOPORPROVEEDOR= "con_producto_por_proveedor";
    public static final String CONLOTECLIENTE= "con_lote_cliente";
    public static final String CONCUENTACONTABLE= "con_cuenta_contable";
    public static final String CONDETALLE= "con_detalle";
    public static final String CONIVAINCLUIDO= "con_iva_incluido";
    public static final String CONLOTES= "con_lotes";
    public static final String NUMERODESCUENTOS= "numero_descuentos";
    public static final String CONPRECIO= "con_precio";
    public static final String NUMEROREGISTROS= "numero_registros";
    public static final String CONCENTROCOSTO= "con_centro_costo";
    public static final String CONORDENIVA= "con_orden_iva";
    public static final String CONMULTIEMPRESA= "con_multi_empresa";
    public static final String IDFORMATO= "id_formato";
    public static final String CONENLINEA= "con_en_linea";
    public static final String IDTIPOTRIBUTARIO= "id_tipo_tributario";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String CONEVALUACION= "con_evaluacion";
    public static final String CONOT= "con_ot";
    public static final String CONANTICIPO= "con_anticipo";
    public static final String CONCIERRE= "con_cierre";
    public static final String CONGENERAL= "con_general";
    public static final String CONPORPRODUCTO= "con_por_producto";
    public static final String CONDESCUENTO= "con_descuento";
    public static final String CONSERIES= "con_series";
    public static final String CANTIDAD= "cantidad";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDLIBROCONTABLE= "id_libro_contable";
    public static final String CONINTERNO= "con_interno";
    public static final String CONRESERVA= "con_reserva";
    public static final String CONPRECIOPROVEEDOR= "con_precio_proveedor";
    public static final String CONPRODUCCION= "con_produccion";
    public static final String CONCODIGOBARRA= "con_codigo_barra";
    public static final String CONROMANEOS= "con_romaneos";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_SECUENCIALFORMATO= "Secuencial Formato";
		public static final String LABEL_SECUENCIALFORMATO_LOWER= "Secuencial Formato";
    	public static final String LABEL_SECUENCIAL= "Secuencia";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_IDTIPODEFINICION= "Tipo";
		public static final String LABEL_IDTIPODEFINICION_LOWER= "Tipo Definicion";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOIVAITEM= "Iva Item";
		public static final String LABEL_IDTIPOIVAITEM_LOWER= "Tipo Iva Item";
    	public static final String LABEL_CONMOSTRARBODEGA= "Mostrar Bodega";
		public static final String LABEL_CONMOSTRARBODEGA_LOWER= "Con Mostrar Bodega";
    	public static final String LABEL_FACTOR= "Factor";
		public static final String LABEL_FACTOR_LOWER= "Factor";
    	public static final String LABEL_CONOTRORECARGO= "Otros Recargos";
		public static final String LABEL_CONOTRORECARGO_LOWER= "Con Otro Recargo";
    	public static final String LABEL_IDTIPOGLOBALCLIENTE= "T. Cliente";
		public static final String LABEL_IDTIPOGLOBALCLIENTE_LOWER= "Tipo Global Cliente";
    	public static final String LABEL_CONCOA= "Coa";
		public static final String LABEL_CONCOA_LOWER= "Con Coa";
    	public static final String LABEL_IDTIPOCOSTEODEFINICION= "T. Costeo";
		public static final String LABEL_IDTIPOCOSTEODEFINICION_LOWER= "Tipo Costeo Definicion";
    	public static final String LABEL_CONRETENCION= "Retenciones";
		public static final String LABEL_CONRETENCION_LOWER= "Con Retencion";
    	public static final String LABEL_IDTIPOCOSTODEFINICION= "T. Costo";
		public static final String LABEL_IDTIPOCOSTODEFINICION_LOWER= "Tipo Costo Definicion";
    	public static final String LABEL_CONNOVEDADPRODUCTO= "Novedades Prod";
		public static final String LABEL_CONNOVEDADPRODUCTO_LOWER= "Con Novedad Producto";
    	public static final String LABEL_CONICE= " Ice";
		public static final String LABEL_CONICE_LOWER= "Con Ice";
    	public static final String LABEL_CONCANTIDAD= "Con Cantidad";
		public static final String LABEL_CONCANTIDAD_LOWER= "Con Cantidad";
    	public static final String LABEL_CONPRODUCTOPORPROVEEDOR= "Prod x Proveedor";
		public static final String LABEL_CONPRODUCTOPORPROVEEDOR_LOWER= "Con Producto Por Proveedor";
    	public static final String LABEL_CONLOTECLIENTE= "Lote Cliente";
		public static final String LABEL_CONLOTECLIENTE_LOWER= "Con Lote Cliente";
    	public static final String LABEL_CONCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_CONCUENTACONTABLE_LOWER= "Con Cuenta Contable";
    	public static final String LABEL_CONDETALLE= "Detalle";
		public static final String LABEL_CONDETALLE_LOWER= "Con Detalle";
    	public static final String LABEL_CONIVAINCLUIDO= "Iva Incluido";
		public static final String LABEL_CONIVAINCLUIDO_LOWER= "Con Iva Incluido";
    	public static final String LABEL_CONLOTES= "Lotes";
		public static final String LABEL_CONLOTES_LOWER= "Con Lotes";
    	public static final String LABEL_NUMERODESCUENTOS= "No Descuentos";
		public static final String LABEL_NUMERODESCUENTOS_LOWER= "Numero Descuentos";
    	public static final String LABEL_CONPRECIO= "Precio";
		public static final String LABEL_CONPRECIO_LOWER= "Con Precio";
    	public static final String LABEL_NUMEROREGISTROS= "No Registros";
		public static final String LABEL_NUMEROREGISTROS_LOWER= "Numero Registros";
    	public static final String LABEL_CONCENTROCOSTO= "Centro Costo";
		public static final String LABEL_CONCENTROCOSTO_LOWER= "Con Centro Costo";
    	public static final String LABEL_CONORDENIVA= "Orden Iva Incluido";
		public static final String LABEL_CONORDENIVA_LOWER= "Con Orden Iva";
    	public static final String LABEL_CONMULTIEMPRESA= "Multi Empresa";
		public static final String LABEL_CONMULTIEMPRESA_LOWER= "Con Multi Empresa";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_CONENLINEA= "Integracion En Linea";
		public static final String LABEL_CONENLINEA_LOWER= "Con En Linea";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "Sustento Trib.";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "Tipo Tributario";
    	public static final String LABEL_IDTIPORETENCION= "Cod Ret.";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_CONEVALUACION= "Evaluacion";
		public static final String LABEL_CONEVALUACION_LOWER= "Con Evaluacion";
    	public static final String LABEL_CONOT= "OT";
		public static final String LABEL_CONOT_LOWER= "Con Ot";
    	public static final String LABEL_CONANTICIPO= "Anticipo";
		public static final String LABEL_CONANTICIPO_LOWER= "Con Anticipo";
    	public static final String LABEL_CONCIERRE= "Cierre";
		public static final String LABEL_CONCIERRE_LOWER= "Con Cierre";
    	public static final String LABEL_CONGENERAL= "General";
		public static final String LABEL_CONGENERAL_LOWER= "Con General";
    	public static final String LABEL_CONPORPRODUCTO= "Por Producto";
		public static final String LABEL_CONPORPRODUCTO_LOWER= "Con Por Producto";
    	public static final String LABEL_CONDESCUENTO= "Descuento";
		public static final String LABEL_CONDESCUENTO_LOWER= "Con Descuento";
    	public static final String LABEL_CONSERIES= "Series";
		public static final String LABEL_CONSERIES_LOWER= "Con Series";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDLIBROCONTABLE= "Libro";
		public static final String LABEL_IDLIBROCONTABLE_LOWER= "Libro Contable";
    	public static final String LABEL_CONINTERNO= "P. Interno";
		public static final String LABEL_CONINTERNO_LOWER= "Con Interno";
    	public static final String LABEL_CONRESERVA= "Reserva";
		public static final String LABEL_CONRESERVA_LOWER= "Con Reserva";
    	public static final String LABEL_CONPRECIOPROVEEDOR= "Precio Proveedor";
		public static final String LABEL_CONPRECIOPROVEEDOR_LOWER= "Con Precio Proveedor";
    	public static final String LABEL_CONPRODUCCION= "Produccion";
		public static final String LABEL_CONPRODUCCION_LOWER= "Con Produccion";
    	public static final String LABEL_CONCODIGOBARRA= "Con Codigo Barra";
		public static final String LABEL_CONCODIGOBARRA_LOWER= "Con Codigo Barra";
    	public static final String LABEL_CONROMANEOS= "Romaneos";
		public static final String LABEL_CONROMANEOS_LOWER= "Con Romaneos";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable.";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
	
		
		
		
		
	public static final String SREGEXSECUENCIAL_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDefinicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDMODULO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.SECUENCIALFORMATO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_SECUENCIALFORMATO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.SECUENCIAL)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPODEFINICION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPODEFINICION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTRANSACCION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOIVAITEM)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOIVAITEM;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONMOSTRARBODEGA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONMOSTRARBODEGA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.FACTOR)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_FACTOR;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONOTRORECARGO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONOTRORECARGO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOGLOBALCLIENTE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCOA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCOA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOCOSTEODEFINICION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONRETENCION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONRETENCION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOCOSTODEFINICION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONNOVEDADPRODUCTO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONICE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONICE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCANTIDAD)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCANTIDAD;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONPRODUCTOPORPROVEEDOR;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONLOTECLIENTE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONLOTECLIENTE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCUENTACONTABLE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCUENTACONTABLE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONDETALLE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONDETALLE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONIVAINCLUIDO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONIVAINCLUIDO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONLOTES)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONLOTES;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.NUMERODESCUENTOS)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_NUMERODESCUENTOS;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONPRECIO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONPRECIO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.NUMEROREGISTROS)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_NUMEROREGISTROS;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCENTROCOSTO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCENTROCOSTO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONORDENIVA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONORDENIVA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONMULTIEMPRESA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONMULTIEMPRESA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDFORMATO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONENLINEA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONENLINEA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONEVALUACION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONEVALUACION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONOT)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONOT;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONANTICIPO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONANTICIPO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCIERRE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCIERRE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONGENERAL)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONGENERAL;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONPORPRODUCTO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONPORPRODUCTO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONDESCUENTO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONDESCUENTO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONSERIES)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONSERIES;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CANTIDAD)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDLIBROCONTABLE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDLIBROCONTABLE;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONINTERNO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONINTERNO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONRESERVA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONRESERVA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONPRECIOPROVEEDOR)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONPRECIOPROVEEDOR;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONPRODUCCION)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONPRODUCCION;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONCODIGOBARRA)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONCODIGOBARRA;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.CONROMANEOS)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_CONROMANEOS;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DefinicionConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=DefinicionConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_mostrar_bodegaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_mostrar_bodega()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mostrar_bodegaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_mostrar_bodega());

		return sDescripcion;
	}	
			
		
	public static String getcon_otro_recargoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_otro_recargo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_otro_recargoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_otro_recargo());

		return sDescripcion;
	}	
			
		
	public static String getcon_coaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_coa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_coaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_coa());

		return sDescripcion;
	}	
			
		
	public static String getcon_retencionDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_retencion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_retencionHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_retencion());

		return sDescripcion;
	}	
			
		
	public static String getcon_novedad_productoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_novedad_producto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_novedad_productoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_novedad_producto());

		return sDescripcion;
	}	
		
	public static String getcon_iceDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_ice()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_iceHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_ice());

		return sDescripcion;
	}	
		
	public static String getcon_cantidadDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_cantidad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cantidadHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_cantidad());

		return sDescripcion;
	}	
		
	public static String getcon_producto_por_proveedorDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_producto_por_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_producto_por_proveedorHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_producto_por_proveedor());

		return sDescripcion;
	}	
		
	public static String getcon_lote_clienteDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_lote_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_lote_clienteHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_lote_cliente());

		return sDescripcion;
	}	
		
	public static String getcon_cuenta_contableDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_cuenta_contable()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuenta_contableHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_cuenta_contable());

		return sDescripcion;
	}	
		
	public static String getcon_detalleDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_detalle()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalleHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_detalle());

		return sDescripcion;
	}	
		
	public static String getcon_iva_incluidoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_iva_incluido()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_iva_incluidoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_iva_incluido());

		return sDescripcion;
	}	
		
	public static String getcon_lotesDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_lotes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_lotesHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_lotes());

		return sDescripcion;
	}	
			
		
	public static String getcon_precioDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_precio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precioHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_precio());

		return sDescripcion;
	}	
			
		
	public static String getcon_centro_costoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_centro_costo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_centro_costo());

		return sDescripcion;
	}	
		
	public static String getcon_orden_ivaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_orden_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_orden_ivaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_orden_iva());

		return sDescripcion;
	}	
		
	public static String getcon_multi_empresaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_multi_empresa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_multi_empresaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_multi_empresa());

		return sDescripcion;
	}	
			
		
	public static String getcon_en_lineaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_en_linea()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_en_lineaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_en_linea());

		return sDescripcion;
	}	
			
			
		
	public static String getcon_evaluacionDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_evaluacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_evaluacionHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_evaluacion());

		return sDescripcion;
	}	
		
	public static String getcon_otDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_ot()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_otHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_ot());

		return sDescripcion;
	}	
		
	public static String getcon_anticipoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_anticipo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_anticipoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_anticipo());

		return sDescripcion;
	}	
		
	public static String getcon_cierreDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_cierre()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cierreHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_cierre());

		return sDescripcion;
	}	
		
	public static String getcon_generalDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_general()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_generalHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_general());

		return sDescripcion;
	}	
		
	public static String getcon_por_productoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_por_producto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_por_productoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_por_producto());

		return sDescripcion;
	}	
		
	public static String getcon_descuentoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_descuento()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_descuentoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_descuento());

		return sDescripcion;
	}	
		
	public static String getcon_seriesDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_series()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_seriesHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_series());

		return sDescripcion;
	}	
			
			
			
		
	public static String getcon_internoDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_interno()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_internoHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_interno());

		return sDescripcion;
	}	
		
	public static String getcon_reservaDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_reserva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_reservaHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_reserva());

		return sDescripcion;
	}	
		
	public static String getcon_precio_proveedorDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_precio_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_precio_proveedorHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_precio_proveedor());

		return sDescripcion;
	}	
		
	public static String getcon_produccionDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_produccion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_produccionHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_produccion());

		return sDescripcion;
	}	
		
	public static String getcon_codigo_barraDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_codigo_barra()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_codigo_barraHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_codigo_barra());

		return sDescripcion;
	}	
		
	public static String getcon_romaneosDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!definicion.getcon_romaneos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_romaneosHtmlDescripcion(Definicion definicion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(definicion.getId(),definicion.getcon_romaneos());

		return sDescripcion;
	}	
			
			
	
	public static String getDefinicionDescripcion(Definicion definicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(definicion !=null/* && definicion.getId()!=0*/) {
			sDescripcion=definicion.getsecuencial_formato();//definiciondefinicion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDefinicionDescripcionDetallado(Definicion definicion) {
		String sDescripcion="";
			
		sDescripcion+=DefinicionConstantesFunciones.ID+"=";
		sDescripcion+=definicion.getId().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=definicion.getVersionRow().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=definicion.getid_empresa().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=definicion.getid_modulo().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.SECUENCIALFORMATO+"=";
		sDescripcion+=definicion.getsecuencial_formato()+",";
		sDescripcion+=DefinicionConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=definicion.getsecuencial().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPODEFINICION+"=";
		sDescripcion+=definicion.getid_tipo_definicion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=definicion.getid_transaccion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=definicion.getid_sucursal().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOIVAITEM+"=";
		sDescripcion+=definicion.getid_tipo_iva_item().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONMOSTRARBODEGA+"=";
		sDescripcion+=definicion.getcon_mostrar_bodega().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.FACTOR+"=";
		sDescripcion+=definicion.getfactor().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONOTRORECARGO+"=";
		sDescripcion+=definicion.getcon_otro_recargo().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE+"=";
		sDescripcion+=definicion.getid_tipo_global_cliente().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCOA+"=";
		sDescripcion+=definicion.getcon_coa().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION+"=";
		sDescripcion+=definicion.getid_tipo_costeo_definicion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONRETENCION+"=";
		sDescripcion+=definicion.getcon_retencion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION+"=";
		sDescripcion+=definicion.getid_tipo_costo_definicion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONNOVEDADPRODUCTO+"=";
		sDescripcion+=definicion.getcon_novedad_producto().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONICE+"=";
		sDescripcion+=definicion.getcon_ice().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCANTIDAD+"=";
		sDescripcion+=definicion.getcon_cantidad().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR+"=";
		sDescripcion+=definicion.getcon_producto_por_proveedor().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONLOTECLIENTE+"=";
		sDescripcion+=definicion.getcon_lote_cliente().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCUENTACONTABLE+"=";
		sDescripcion+=definicion.getcon_cuenta_contable().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONDETALLE+"=";
		sDescripcion+=definicion.getcon_detalle().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONIVAINCLUIDO+"=";
		sDescripcion+=definicion.getcon_iva_incluido().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONLOTES+"=";
		sDescripcion+=definicion.getcon_lotes().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.NUMERODESCUENTOS+"=";
		sDescripcion+=definicion.getnumero_descuentos().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONPRECIO+"=";
		sDescripcion+=definicion.getcon_precio().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.NUMEROREGISTROS+"=";
		sDescripcion+=definicion.getnumero_registros().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCENTROCOSTO+"=";
		sDescripcion+=definicion.getcon_centro_costo().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONORDENIVA+"=";
		sDescripcion+=definicion.getcon_orden_iva().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONMULTIEMPRESA+"=";
		sDescripcion+=definicion.getcon_multi_empresa().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=definicion.getid_formato().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONENLINEA+"=";
		sDescripcion+=definicion.getcon_en_linea().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=definicion.getid_tipo_tributario().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=definicion.getid_tipo_retencion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONEVALUACION+"=";
		sDescripcion+=definicion.getcon_evaluacion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONOT+"=";
		sDescripcion+=definicion.getcon_ot().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONANTICIPO+"=";
		sDescripcion+=definicion.getcon_anticipo().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCIERRE+"=";
		sDescripcion+=definicion.getcon_cierre().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONGENERAL+"=";
		sDescripcion+=definicion.getcon_general().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONPORPRODUCTO+"=";
		sDescripcion+=definicion.getcon_por_producto().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONDESCUENTO+"=";
		sDescripcion+=definicion.getcon_descuento().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONSERIES+"=";
		sDescripcion+=definicion.getcon_series().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=definicion.getcantidad().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=definicion.getid_tipo_documento().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDLIBROCONTABLE+"=";
		sDescripcion+=definicion.getid_libro_contable().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONINTERNO+"=";
		sDescripcion+=definicion.getcon_interno().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONRESERVA+"=";
		sDescripcion+=definicion.getcon_reserva().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONPRECIOPROVEEDOR+"=";
		sDescripcion+=definicion.getcon_precio_proveedor().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONPRODUCCION+"=";
		sDescripcion+=definicion.getcon_produccion().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONCODIGOBARRA+"=";
		sDescripcion+=definicion.getcon_codigo_barra().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.CONROMANEOS+"=";
		sDescripcion+=definicion.getcon_romaneos().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=definicion.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DefinicionConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=definicion.getid_cuenta_contable().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDefinicionDescripcion(Definicion definicion,String sValor) throws Exception {			
		if(definicion !=null) {
			definicion.setsecuencial_formato(sValor);//definiciondefinicion.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoDefinicionDescripcion(TipoDefinicion tipodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodefinicion!=null/*&&tipodefinicion.getId()>0*/) {
			sDescripcion=TipoDefinicionConstantesFunciones.getTipoDefinicionDescripcion(tipodefinicion);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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

	public static String getTipoIvaItemDescripcion(TipoIvaItem tipoivaitem) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoivaitem!=null/*&&tipoivaitem.getId()>0*/) {
			sDescripcion=TipoIvaItemConstantesFunciones.getTipoIvaItemDescripcion(tipoivaitem);
		}

		return sDescripcion;
	}

	public static String getTipoGlobalClienteDescripcion(TipoGlobalCliente tipoglobalcliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoglobalcliente!=null/*&&tipoglobalcliente.getId()>0*/) {
			sDescripcion=TipoGlobalClienteConstantesFunciones.getTipoGlobalClienteDescripcion(tipoglobalcliente);
		}

		return sDescripcion;
	}

	public static String getTipoCosteoDefinicionDescripcion(TipoCosteoDefinicion tipocosteodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocosteodefinicion!=null/*&&tipocosteodefinicion.getId()>0*/) {
			sDescripcion=TipoCosteoDefinicionConstantesFunciones.getTipoCosteoDefinicionDescripcion(tipocosteodefinicion);
		}

		return sDescripcion;
	}

	public static String getTipoCostoDefinicionDescripcion(TipoCostoDefinicion tipocostodefinicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocostodefinicion!=null/*&&tipocostodefinicion.getId()>0*/) {
			sDescripcion=TipoCostoDefinicionConstantesFunciones.getTipoCostoDefinicionDescripcion(tipocostodefinicion);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTipoTributarioDescripcion(TipoTributario tipotributario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotributario!=null/*&&tipotributario.getId()>0*/) {
			sDescripcion=TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(tipotributario);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getLibroContableDescripcion(LibroContable librocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(librocontable!=null/*&&librocontable.getId()>0*/) {
			sDescripcion=LibroContableConstantesFunciones.getLibroContableDescripcion(librocontable);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable.";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdLibroContable")) {
			sNombreIndice="Tipo=  Por Libro";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCosteoDefinicion")) {
			sNombreIndice="Tipo=  Por T. Costeo";
		} else if(sNombreIndice.equals("FK_IdTipoCostoDefinicion")) {
			sNombreIndice="Tipo=  Por T. Costo";
		} else if(sNombreIndice.equals("FK_IdTipoDefinicion")) {
			sNombreIndice="Tipo=  Por Tipo";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoGlobalCliente")) {
			sNombreIndice="Tipo=  Por T. Cliente";
		} else if(sNombreIndice.equals("FK_IdTipoIvaItem")) {
			sNombreIndice="Tipo=  Por Iva Item";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Cod Ret.";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por Sustento Trib.";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable.="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLibroContable(Long id_libro_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_libro_contable!=null) {sDetalleIndice+=" Codigo Unico De Libro="+id_libro_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCosteoDefinicion(Long id_tipo_costeo_definicion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costeo_definicion!=null) {sDetalleIndice+=" Codigo Unico De T. Costeo="+id_tipo_costeo_definicion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCostoDefinicion(Long id_tipo_costo_definicion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costo_definicion!=null) {sDetalleIndice+=" Codigo Unico De T. Costo="+id_tipo_costo_definicion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDefinicion(Long id_tipo_definicion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_definicion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_definicion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGlobalCliente(Long id_tipo_global_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_global_cliente!=null) {sDetalleIndice+=" Codigo Unico De T. Cliente="+id_tipo_global_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIvaItem(Long id_tipo_iva_item) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva_item!=null) {sDetalleIndice+=" Codigo Unico De Iva Item="+id_tipo_iva_item.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Cod Ret.="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long id_tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De Sustento Trib.="+id_tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDefinicion(Definicion definicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		definicion.setsecuencial_formato(definicion.getsecuencial_formato().trim());
	}
	
	public static void quitarEspaciosDefinicions(List<Definicion> definicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Definicion definicion: definicions) {
			definicion.setsecuencial_formato(definicion.getsecuencial_formato().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDefinicion(Definicion definicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && definicion.getConCambioAuxiliar()) {
			definicion.setIsDeleted(definicion.getIsDeletedAuxiliar());	
			definicion.setIsNew(definicion.getIsNewAuxiliar());	
			definicion.setIsChanged(definicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			definicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			definicion.setIsDeletedAuxiliar(false);	
			definicion.setIsNewAuxiliar(false);	
			definicion.setIsChangedAuxiliar(false);
			
			definicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDefinicions(List<Definicion> definicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Definicion definicion : definicions) {
			if(conAsignarBase && definicion.getConCambioAuxiliar()) {
				definicion.setIsDeleted(definicion.getIsDeletedAuxiliar());	
				definicion.setIsNew(definicion.getIsNewAuxiliar());	
				definicion.setIsChanged(definicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				definicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				definicion.setIsDeletedAuxiliar(false);	
				definicion.setIsNewAuxiliar(false);	
				definicion.setIsChangedAuxiliar(false);
				
				definicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDefinicion(Definicion definicion,Boolean conEnteros) throws Exception  {
		definicion.setfactor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			definicion.setsecuencial(0L);
			definicion.setnumero_descuentos(0);
			definicion.setnumero_registros(0);
			definicion.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDefinicions(List<Definicion> definicions,Boolean conEnteros) throws Exception  {
		
		for(Definicion definicion: definicions) {
			definicion.setfactor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				definicion.setsecuencial(0L);
				definicion.setnumero_descuentos(0);
				definicion.setnumero_registros(0);
				definicion.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDefinicion(List<Definicion> definicions,Definicion definicionAux) throws Exception  {
		DefinicionConstantesFunciones.InicializarValoresDefinicion(definicionAux,true);
		
		for(Definicion definicion: definicions) {
			if(definicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			definicionAux.setsecuencial(definicionAux.getsecuencial()+definicion.getsecuencial());			
			definicionAux.setfactor(definicionAux.getfactor()+definicion.getfactor());			
			definicionAux.setnumero_descuentos(definicionAux.getnumero_descuentos()+definicion.getnumero_descuentos());			
			definicionAux.setnumero_registros(definicionAux.getnumero_registros()+definicion.getnumero_registros());			
			definicionAux.setcantidad(definicionAux.getcantidad()+definicion.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DefinicionConstantesFunciones.getArrayColumnasGlobalesDefinicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDefinicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DefinicionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DefinicionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DefinicionConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DefinicionConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DefinicionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DefinicionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDefinicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DefinicionConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Definicion> definicions,Definicion definicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Definicion definicionAux: definicions) {
			if(definicionAux!=null && definicion!=null) {
				if((definicionAux.getId()==null && definicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(definicionAux.getId()!=null && definicion.getId()!=null){
					if(definicionAux.getId().equals(definicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDefinicion(List<Definicion> definicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double factorTotal=0.0;
	
		for(Definicion definicion: definicions) {			
			if(definicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			factorTotal+=definicion.getfactor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DefinicionConstantesFunciones.FACTOR);
		datoGeneral.setsDescripcion(DefinicionConstantesFunciones.LABEL_FACTOR);
		datoGeneral.setdValorDouble(factorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDefinicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_ID, DefinicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_VERSIONROW, DefinicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDEMPRESA, DefinicionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDMODULO, DefinicionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_SECUENCIALFORMATO, DefinicionConstantesFunciones.SECUENCIALFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_SECUENCIAL, DefinicionConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPODEFINICION, DefinicionConstantesFunciones.IDTIPODEFINICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTRANSACCION, DefinicionConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDSUCURSAL, DefinicionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOIVAITEM, DefinicionConstantesFunciones.IDTIPOIVAITEM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONMOSTRARBODEGA, DefinicionConstantesFunciones.CONMOSTRARBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_FACTOR, DefinicionConstantesFunciones.FACTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONOTRORECARGO, DefinicionConstantesFunciones.CONOTRORECARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOGLOBALCLIENTE, DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCOA, DefinicionConstantesFunciones.CONCOA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOCOSTEODEFINICION, DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONRETENCION, DefinicionConstantesFunciones.CONRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOCOSTODEFINICION, DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONNOVEDADPRODUCTO, DefinicionConstantesFunciones.CONNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONICE, DefinicionConstantesFunciones.CONICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCANTIDAD, DefinicionConstantesFunciones.CONCANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONPRODUCTOPORPROVEEDOR, DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONLOTECLIENTE, DefinicionConstantesFunciones.CONLOTECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCUENTACONTABLE, DefinicionConstantesFunciones.CONCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONDETALLE, DefinicionConstantesFunciones.CONDETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONIVAINCLUIDO, DefinicionConstantesFunciones.CONIVAINCLUIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONLOTES, DefinicionConstantesFunciones.CONLOTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_NUMERODESCUENTOS, DefinicionConstantesFunciones.NUMERODESCUENTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONPRECIO, DefinicionConstantesFunciones.CONPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_NUMEROREGISTROS, DefinicionConstantesFunciones.NUMEROREGISTROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCENTROCOSTO, DefinicionConstantesFunciones.CONCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONORDENIVA, DefinicionConstantesFunciones.CONORDENIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONMULTIEMPRESA, DefinicionConstantesFunciones.CONMULTIEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDFORMATO, DefinicionConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONENLINEA, DefinicionConstantesFunciones.CONENLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, DefinicionConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPORETENCION, DefinicionConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONEVALUACION, DefinicionConstantesFunciones.CONEVALUACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONOT, DefinicionConstantesFunciones.CONOT,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONANTICIPO, DefinicionConstantesFunciones.CONANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCIERRE, DefinicionConstantesFunciones.CONCIERRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONGENERAL, DefinicionConstantesFunciones.CONGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONPORPRODUCTO, DefinicionConstantesFunciones.CONPORPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONDESCUENTO, DefinicionConstantesFunciones.CONDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONSERIES, DefinicionConstantesFunciones.CONSERIES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CANTIDAD, DefinicionConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPODOCUMENTO, DefinicionConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDLIBROCONTABLE, DefinicionConstantesFunciones.IDLIBROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONINTERNO, DefinicionConstantesFunciones.CONINTERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONRESERVA, DefinicionConstantesFunciones.CONRESERVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONPRECIOPROVEEDOR, DefinicionConstantesFunciones.CONPRECIOPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONPRODUCCION, DefinicionConstantesFunciones.CONPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONCODIGOBARRA, DefinicionConstantesFunciones.CONCODIGOBARRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_CONROMANEOS, DefinicionConstantesFunciones.CONROMANEOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefinicionConstantesFunciones.LABEL_IDCUENTACONTABLE, DefinicionConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDefinicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.SECUENCIALFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPODEFINICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOIVAITEM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONMOSTRARBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.FACTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONOTRORECARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCOA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONLOTECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONDETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONIVAINCLUIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONLOTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.NUMERODESCUENTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.NUMEROREGISTROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONORDENIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONMULTIEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONENLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONEVALUACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONOT;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCIERRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONPORPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONSERIES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDLIBROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONINTERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONRESERVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONPRECIOPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONCODIGOBARRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.CONROMANEOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefinicionConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefinicion() throws Exception  {
		return DefinicionConstantesFunciones.getTiposSeleccionarDefinicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefinicion(Boolean conFk) throws Exception  {
		return DefinicionConstantesFunciones.getTiposSeleccionarDefinicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefinicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_SECUENCIALFORMATO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_SECUENCIALFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPODEFINICION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPODEFINICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOIVAITEM);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOIVAITEM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONMOSTRARBODEGA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONMOSTRARBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_FACTOR);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_FACTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONOTRORECARGO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONOTRORECARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOGLOBALCLIENTE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOGLOBALCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCOA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCOA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTEODEFINICION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTEODEFINICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONRETENCION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTODEFINICION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTODEFINICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONNOVEDADPRODUCTO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONICE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCANTIDAD);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONPRODUCTOPORPROVEEDOR);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONPRODUCTOPORPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONLOTECLIENTE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONLOTECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCUENTACONTABLE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONDETALLE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONDETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONIVAINCLUIDO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONIVAINCLUIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONLOTES);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONLOTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_NUMERODESCUENTOS);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_NUMERODESCUENTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONPRECIO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_NUMEROREGISTROS);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_NUMEROREGISTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCENTROCOSTO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONORDENIVA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONORDENIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONMULTIEMPRESA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONMULTIEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONENLINEA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONENLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONEVALUACION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONEVALUACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONOT);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONOT);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONANTICIPO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCIERRE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCIERRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONGENERAL);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONPORPRODUCTO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONPORPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONDESCUENTO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONSERIES);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONSERIES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDLIBROCONTABLE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDLIBROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONINTERNO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONINTERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONRESERVA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONRESERVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONPRECIOPROVEEDOR);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONPRECIOPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONPRODUCCION);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONCODIGOBARRA);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONCODIGOBARRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_CONROMANEOS);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_CONROMANEOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefinicionConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(DefinicionConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDefinicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDefinicion(Definicion definicionAux) throws Exception {
		
			definicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(definicionAux.getEmpresa()));
			definicionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(definicionAux.getModulo()));
			definicionAux.settipodefinicion_descripcion(TipoDefinicionConstantesFunciones.getTipoDefinicionDescripcion(definicionAux.getTipoDefinicion()));
			definicionAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(definicionAux.getTransaccion()));
			definicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(definicionAux.getSucursal()));
			definicionAux.settipoivaitem_descripcion(TipoIvaItemConstantesFunciones.getTipoIvaItemDescripcion(definicionAux.getTipoIvaItem()));
			definicionAux.settipoglobalcliente_descripcion(TipoGlobalClienteConstantesFunciones.getTipoGlobalClienteDescripcion(definicionAux.getTipoGlobalCliente()));
			definicionAux.settipocosteodefinicion_descripcion(TipoCosteoDefinicionConstantesFunciones.getTipoCosteoDefinicionDescripcion(definicionAux.getTipoCosteoDefinicion()));
			definicionAux.settipocostodefinicion_descripcion(TipoCostoDefinicionConstantesFunciones.getTipoCostoDefinicionDescripcion(definicionAux.getTipoCostoDefinicion()));
			definicionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(definicionAux.getFormato()));
			definicionAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(definicionAux.getTipoTributario()));
			definicionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(definicionAux.getTipoRetencion()));
			definicionAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(definicionAux.getTipoDocumento()));
			definicionAux.setlibrocontable_descripcion(LibroContableConstantesFunciones.getLibroContableDescripcion(definicionAux.getLibroContable()));
			definicionAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(definicionAux.getTipoTransaccionModulo()));
			definicionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(definicionAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDefinicion(List<Definicion> definicionsTemp) throws Exception {
		for(Definicion definicionAux:definicionsTemp) {
			
			definicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(definicionAux.getEmpresa()));
			definicionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(definicionAux.getModulo()));
			definicionAux.settipodefinicion_descripcion(TipoDefinicionConstantesFunciones.getTipoDefinicionDescripcion(definicionAux.getTipoDefinicion()));
			definicionAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(definicionAux.getTransaccion()));
			definicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(definicionAux.getSucursal()));
			definicionAux.settipoivaitem_descripcion(TipoIvaItemConstantesFunciones.getTipoIvaItemDescripcion(definicionAux.getTipoIvaItem()));
			definicionAux.settipoglobalcliente_descripcion(TipoGlobalClienteConstantesFunciones.getTipoGlobalClienteDescripcion(definicionAux.getTipoGlobalCliente()));
			definicionAux.settipocosteodefinicion_descripcion(TipoCosteoDefinicionConstantesFunciones.getTipoCosteoDefinicionDescripcion(definicionAux.getTipoCosteoDefinicion()));
			definicionAux.settipocostodefinicion_descripcion(TipoCostoDefinicionConstantesFunciones.getTipoCostoDefinicionDescripcion(definicionAux.getTipoCostoDefinicion()));
			definicionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(definicionAux.getFormato()));
			definicionAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(definicionAux.getTipoTributario()));
			definicionAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(definicionAux.getTipoRetencion()));
			definicionAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(definicionAux.getTipoDocumento()));
			definicionAux.setlibrocontable_descripcion(LibroContableConstantesFunciones.getLibroContableDescripcion(definicionAux.getLibroContable()));
			definicionAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(definicionAux.getTipoTransaccionModulo()));
			definicionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(definicionAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoDefinicion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoIvaItem.class));
				classes.add(new Classe(TipoGlobalCliente.class));
				classes.add(new Classe(TipoCosteoDefinicion.class));
				classes.add(new Classe(TipoCostoDefinicion.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(LibroContable.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDefinicion.class)) {
						classes.add(new Classe(TipoDefinicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIvaItem.class)) {
						classes.add(new Classe(TipoIvaItem.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGlobalCliente.class)) {
						classes.add(new Classe(TipoGlobalCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCosteoDefinicion.class)) {
						classes.add(new Classe(TipoCosteoDefinicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCostoDefinicion.class)) {
						classes.add(new Classe(TipoCostoDefinicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTributario.class)) {
						classes.add(new Classe(TipoTributario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LibroContable.class)) {
						classes.add(new Classe(LibroContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDefinicion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoIvaItem.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIvaItem.class)); continue;
					}

					if(TipoGlobalCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGlobalCliente.class)); continue;
					}

					if(TipoCosteoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteoDefinicion.class)); continue;
					}

					if(TipoCostoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCostoDefinicion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(LibroContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LibroContable.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDefinicion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoIvaItem.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIvaItem.class)); continue;
					}

					if(TipoGlobalCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGlobalCliente.class)); continue;
					}

					if(TipoCosteoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteoDefinicion.class)); continue;
					}

					if(TipoCostoDefinicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCostoDefinicion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(LibroContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LibroContable.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DefinicionConstantesFunciones.getClassesRelationshipsOfDefinicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DefinicionConstantesFunciones.getClassesRelationshipsFromStringsOfDefinicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDefinicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Definicion definicion,List<Definicion> definicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Definicion definicionEncontrado=null;
			
			for(Definicion definicionLocal:definicions) {
				if(definicionLocal.getId().equals(definicion.getId())) {
					definicionEncontrado=definicionLocal;
					
					definicionLocal.setIsChanged(definicion.getIsChanged());
					definicionLocal.setIsNew(definicion.getIsNew());
					definicionLocal.setIsDeleted(definicion.getIsDeleted());
					
					definicionLocal.setGeneralEntityOriginal(definicion.getGeneralEntityOriginal());
					
					definicionLocal.setId(definicion.getId());	
					definicionLocal.setVersionRow(definicion.getVersionRow());	
					definicionLocal.setid_empresa(definicion.getid_empresa());	
					definicionLocal.setid_modulo(definicion.getid_modulo());	
					definicionLocal.setsecuencial_formato(definicion.getsecuencial_formato());	
					definicionLocal.setsecuencial(definicion.getsecuencial());	
					definicionLocal.setid_tipo_definicion(definicion.getid_tipo_definicion());	
					definicionLocal.setid_transaccion(definicion.getid_transaccion());	
					definicionLocal.setid_sucursal(definicion.getid_sucursal());	
					definicionLocal.setid_tipo_iva_item(definicion.getid_tipo_iva_item());	
					definicionLocal.setcon_mostrar_bodega(definicion.getcon_mostrar_bodega());	
					definicionLocal.setfactor(definicion.getfactor());	
					definicionLocal.setcon_otro_recargo(definicion.getcon_otro_recargo());	
					definicionLocal.setid_tipo_global_cliente(definicion.getid_tipo_global_cliente());	
					definicionLocal.setcon_coa(definicion.getcon_coa());	
					definicionLocal.setid_tipo_costeo_definicion(definicion.getid_tipo_costeo_definicion());	
					definicionLocal.setcon_retencion(definicion.getcon_retencion());	
					definicionLocal.setid_tipo_costo_definicion(definicion.getid_tipo_costo_definicion());	
					definicionLocal.setcon_novedad_producto(definicion.getcon_novedad_producto());	
					definicionLocal.setcon_ice(definicion.getcon_ice());	
					definicionLocal.setcon_cantidad(definicion.getcon_cantidad());	
					definicionLocal.setcon_producto_por_proveedor(definicion.getcon_producto_por_proveedor());	
					definicionLocal.setcon_lote_cliente(definicion.getcon_lote_cliente());	
					definicionLocal.setcon_cuenta_contable(definicion.getcon_cuenta_contable());	
					definicionLocal.setcon_detalle(definicion.getcon_detalle());	
					definicionLocal.setcon_iva_incluido(definicion.getcon_iva_incluido());	
					definicionLocal.setcon_lotes(definicion.getcon_lotes());	
					definicionLocal.setnumero_descuentos(definicion.getnumero_descuentos());	
					definicionLocal.setcon_precio(definicion.getcon_precio());	
					definicionLocal.setnumero_registros(definicion.getnumero_registros());	
					definicionLocal.setcon_centro_costo(definicion.getcon_centro_costo());	
					definicionLocal.setcon_orden_iva(definicion.getcon_orden_iva());	
					definicionLocal.setcon_multi_empresa(definicion.getcon_multi_empresa());	
					definicionLocal.setid_formato(definicion.getid_formato());	
					definicionLocal.setcon_en_linea(definicion.getcon_en_linea());	
					definicionLocal.setid_tipo_tributario(definicion.getid_tipo_tributario());	
					definicionLocal.setid_tipo_retencion(definicion.getid_tipo_retencion());	
					definicionLocal.setcon_evaluacion(definicion.getcon_evaluacion());	
					definicionLocal.setcon_ot(definicion.getcon_ot());	
					definicionLocal.setcon_anticipo(definicion.getcon_anticipo());	
					definicionLocal.setcon_cierre(definicion.getcon_cierre());	
					definicionLocal.setcon_general(definicion.getcon_general());	
					definicionLocal.setcon_por_producto(definicion.getcon_por_producto());	
					definicionLocal.setcon_descuento(definicion.getcon_descuento());	
					definicionLocal.setcon_series(definicion.getcon_series());	
					definicionLocal.setcantidad(definicion.getcantidad());	
					definicionLocal.setid_tipo_documento(definicion.getid_tipo_documento());	
					definicionLocal.setid_libro_contable(definicion.getid_libro_contable());	
					definicionLocal.setcon_interno(definicion.getcon_interno());	
					definicionLocal.setcon_reserva(definicion.getcon_reserva());	
					definicionLocal.setcon_precio_proveedor(definicion.getcon_precio_proveedor());	
					definicionLocal.setcon_produccion(definicion.getcon_produccion());	
					definicionLocal.setcon_codigo_barra(definicion.getcon_codigo_barra());	
					definicionLocal.setcon_romaneos(definicion.getcon_romaneos());	
					definicionLocal.setid_tipo_transaccion_modulo(definicion.getid_tipo_transaccion_modulo());	
					definicionLocal.setid_cuenta_contable(definicion.getid_cuenta_contable());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!definicion.getIsDeleted()) {
				if(!existe) {
					definicions.add(definicion);
				}
			} else {
				if(definicionEncontrado!=null && permiteQuitar)  {
					definicions.remove(definicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Definicion definicion,List<Definicion> definicions) throws Exception {
		try	{			
			for(Definicion definicionLocal:definicions) {
				if(definicionLocal.getId().equals(definicion.getId())) {
					definicionLocal.setIsSelected(definicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDefinicion(List<Definicion> definicionsAux) throws Exception {
		//this.definicionsAux=definicionsAux;
		
		for(Definicion definicionAux:definicionsAux) {
			if(definicionAux.getIsChanged()) {
				definicionAux.setIsChanged(false);
			}		
			
			if(definicionAux.getIsNew()) {
				definicionAux.setIsNew(false);
			}	
			
			if(definicionAux.getIsDeleted()) {
				definicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDefinicion(Definicion definicionAux) throws Exception {
		//this.definicionAux=definicionAux;
		
			if(definicionAux.getIsChanged()) {
				definicionAux.setIsChanged(false);
			}		
			
			if(definicionAux.getIsNew()) {
				definicionAux.setIsNew(false);
			}	
			
			if(definicionAux.getIsDeleted()) {
				definicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Definicion definicionAsignar,Definicion definicion) throws Exception {
		definicionAsignar.setId(definicion.getId());	
		definicionAsignar.setVersionRow(definicion.getVersionRow());	
		definicionAsignar.setid_empresa(definicion.getid_empresa());
		definicionAsignar.setempresa_descripcion(definicion.getempresa_descripcion());	
		definicionAsignar.setid_modulo(definicion.getid_modulo());
		definicionAsignar.setmodulo_descripcion(definicion.getmodulo_descripcion());	
		definicionAsignar.setsecuencial_formato(definicion.getsecuencial_formato());	
		definicionAsignar.setsecuencial(definicion.getsecuencial());	
		definicionAsignar.setid_tipo_definicion(definicion.getid_tipo_definicion());
		definicionAsignar.settipodefinicion_descripcion(definicion.gettipodefinicion_descripcion());	
		definicionAsignar.setid_transaccion(definicion.getid_transaccion());
		definicionAsignar.settransaccion_descripcion(definicion.gettransaccion_descripcion());	
		definicionAsignar.setid_sucursal(definicion.getid_sucursal());
		definicionAsignar.setsucursal_descripcion(definicion.getsucursal_descripcion());	
		definicionAsignar.setid_tipo_iva_item(definicion.getid_tipo_iva_item());
		definicionAsignar.settipoivaitem_descripcion(definicion.gettipoivaitem_descripcion());	
		definicionAsignar.setcon_mostrar_bodega(definicion.getcon_mostrar_bodega());	
		definicionAsignar.setfactor(definicion.getfactor());	
		definicionAsignar.setcon_otro_recargo(definicion.getcon_otro_recargo());	
		definicionAsignar.setid_tipo_global_cliente(definicion.getid_tipo_global_cliente());
		definicionAsignar.settipoglobalcliente_descripcion(definicion.gettipoglobalcliente_descripcion());	
		definicionAsignar.setcon_coa(definicion.getcon_coa());	
		definicionAsignar.setid_tipo_costeo_definicion(definicion.getid_tipo_costeo_definicion());
		definicionAsignar.settipocosteodefinicion_descripcion(definicion.gettipocosteodefinicion_descripcion());	
		definicionAsignar.setcon_retencion(definicion.getcon_retencion());	
		definicionAsignar.setid_tipo_costo_definicion(definicion.getid_tipo_costo_definicion());
		definicionAsignar.settipocostodefinicion_descripcion(definicion.gettipocostodefinicion_descripcion());	
		definicionAsignar.setcon_novedad_producto(definicion.getcon_novedad_producto());	
		definicionAsignar.setcon_ice(definicion.getcon_ice());	
		definicionAsignar.setcon_cantidad(definicion.getcon_cantidad());	
		definicionAsignar.setcon_producto_por_proveedor(definicion.getcon_producto_por_proveedor());	
		definicionAsignar.setcon_lote_cliente(definicion.getcon_lote_cliente());	
		definicionAsignar.setcon_cuenta_contable(definicion.getcon_cuenta_contable());	
		definicionAsignar.setcon_detalle(definicion.getcon_detalle());	
		definicionAsignar.setcon_iva_incluido(definicion.getcon_iva_incluido());	
		definicionAsignar.setcon_lotes(definicion.getcon_lotes());	
		definicionAsignar.setnumero_descuentos(definicion.getnumero_descuentos());	
		definicionAsignar.setcon_precio(definicion.getcon_precio());	
		definicionAsignar.setnumero_registros(definicion.getnumero_registros());	
		definicionAsignar.setcon_centro_costo(definicion.getcon_centro_costo());	
		definicionAsignar.setcon_orden_iva(definicion.getcon_orden_iva());	
		definicionAsignar.setcon_multi_empresa(definicion.getcon_multi_empresa());	
		definicionAsignar.setid_formato(definicion.getid_formato());
		definicionAsignar.setformato_descripcion(definicion.getformato_descripcion());	
		definicionAsignar.setcon_en_linea(definicion.getcon_en_linea());	
		definicionAsignar.setid_tipo_tributario(definicion.getid_tipo_tributario());
		definicionAsignar.settipotributario_descripcion(definicion.gettipotributario_descripcion());	
		definicionAsignar.setid_tipo_retencion(definicion.getid_tipo_retencion());
		definicionAsignar.settiporetencion_descripcion(definicion.gettiporetencion_descripcion());	
		definicionAsignar.setcon_evaluacion(definicion.getcon_evaluacion());	
		definicionAsignar.setcon_ot(definicion.getcon_ot());	
		definicionAsignar.setcon_anticipo(definicion.getcon_anticipo());	
		definicionAsignar.setcon_cierre(definicion.getcon_cierre());	
		definicionAsignar.setcon_general(definicion.getcon_general());	
		definicionAsignar.setcon_por_producto(definicion.getcon_por_producto());	
		definicionAsignar.setcon_descuento(definicion.getcon_descuento());	
		definicionAsignar.setcon_series(definicion.getcon_series());	
		definicionAsignar.setcantidad(definicion.getcantidad());	
		definicionAsignar.setid_tipo_documento(definicion.getid_tipo_documento());
		definicionAsignar.settipodocumento_descripcion(definicion.gettipodocumento_descripcion());	
		definicionAsignar.setid_libro_contable(definicion.getid_libro_contable());
		definicionAsignar.setlibrocontable_descripcion(definicion.getlibrocontable_descripcion());	
		definicionAsignar.setcon_interno(definicion.getcon_interno());	
		definicionAsignar.setcon_reserva(definicion.getcon_reserva());	
		definicionAsignar.setcon_precio_proveedor(definicion.getcon_precio_proveedor());	
		definicionAsignar.setcon_produccion(definicion.getcon_produccion());	
		definicionAsignar.setcon_codigo_barra(definicion.getcon_codigo_barra());	
		definicionAsignar.setcon_romaneos(definicion.getcon_romaneos());	
		definicionAsignar.setid_tipo_transaccion_modulo(definicion.getid_tipo_transaccion_modulo());
		definicionAsignar.settipotransaccionmodulo_descripcion(definicion.gettipotransaccionmodulo_descripcion());	
		definicionAsignar.setid_cuenta_contable(definicion.getid_cuenta_contable());
		definicionAsignar.setcuentacontable_descripcion(definicion.getcuentacontable_descripcion());	
	}
	
	public static void inicializarDefinicion(Definicion definicion) throws Exception {
		try {
				definicion.setId(0L);	
					
				definicion.setid_empresa(-1L);	
				definicion.setid_modulo(-1L);	
				definicion.setsecuencial_formato("");	
				definicion.setsecuencial(0L);	
				definicion.setid_tipo_definicion(-1L);	
				definicion.setid_transaccion(-1L);	
				definicion.setid_sucursal(-1L);	
				definicion.setid_tipo_iva_item(-1L);	
				definicion.setcon_mostrar_bodega(false);	
				definicion.setfactor(0.0);	
				definicion.setcon_otro_recargo(false);	
				definicion.setid_tipo_global_cliente(-1L);	
				definicion.setcon_coa(false);	
				definicion.setid_tipo_costeo_definicion(-1L);	
				definicion.setcon_retencion(false);	
				definicion.setid_tipo_costo_definicion(-1L);	
				definicion.setcon_novedad_producto(false);	
				definicion.setcon_ice(false);	
				definicion.setcon_cantidad(false);	
				definicion.setcon_producto_por_proveedor(false);	
				definicion.setcon_lote_cliente(false);	
				definicion.setcon_cuenta_contable(false);	
				definicion.setcon_detalle(false);	
				definicion.setcon_iva_incluido(false);	
				definicion.setcon_lotes(false);	
				definicion.setnumero_descuentos(0);	
				definicion.setcon_precio(false);	
				definicion.setnumero_registros(0);	
				definicion.setcon_centro_costo(false);	
				definicion.setcon_orden_iva(false);	
				definicion.setcon_multi_empresa(false);	
				definicion.setid_formato(null);	
				definicion.setcon_en_linea(false);	
				definicion.setid_tipo_tributario(null);	
				definicion.setid_tipo_retencion(null);	
				definicion.setcon_evaluacion(false);	
				definicion.setcon_ot(false);	
				definicion.setcon_anticipo(false);	
				definicion.setcon_cierre(false);	
				definicion.setcon_general(false);	
				definicion.setcon_por_producto(false);	
				definicion.setcon_descuento(false);	
				definicion.setcon_series(false);	
				definicion.setcantidad(0);	
				definicion.setid_tipo_documento(null);	
				definicion.setid_libro_contable(null);	
				definicion.setcon_interno(false);	
				definicion.setcon_reserva(false);	
				definicion.setcon_precio_proveedor(false);	
				definicion.setcon_produccion(false);	
				definicion.setcon_codigo_barra(false);	
				definicion.setcon_romaneos(false);	
				definicion.setid_tipo_transaccion_modulo(null);	
				definicion.setid_cuenta_contable(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDefinicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_SECUENCIALFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPODEFINICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOIVAITEM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONMOSTRARBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_FACTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONOTRORECARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOGLOBALCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCOA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTEODEFINICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOCOSTODEFINICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONPRODUCTOPORPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONLOTECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONDETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONIVAINCLUIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONLOTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_NUMERODESCUENTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_NUMEROREGISTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONORDENIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONMULTIEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONENLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONEVALUACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONOT);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCIERRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONPORPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONSERIES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDLIBROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONINTERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONRESERVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONPRECIOPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONCODIGOBARRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_CONROMANEOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefinicionConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDefinicion(String sTipo,Row row,Workbook workbook,Definicion definicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getsecuencial_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipodefinicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipoivaitem_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_mostrar_bodega()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getfactor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_otro_recargo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipoglobalcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_coa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipocosteodefinicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_retencion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipocostodefinicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_novedad_producto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_ice()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_cantidad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_producto_por_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_lote_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_cuenta_contable()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_detalle()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_iva_incluido()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_lotes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getnumero_descuentos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_precio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getnumero_registros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_centro_costo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_orden_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_multi_empresa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_en_linea()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_evaluacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_ot()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_anticipo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_cierre()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_general()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_por_producto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_descuento()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_series()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getlibrocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_interno()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_reserva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_precio_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_produccion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_codigo_barra()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(definicion.getcon_romaneos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(definicion.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDefinicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDefinicion() {
		return this.sFinalQueryDefinicion;
	}
	
	public void setsFinalQueryDefinicion(String sFinalQueryDefinicion) {
		this.sFinalQueryDefinicion= sFinalQueryDefinicion;
	}
	
	public Border resaltarSeleccionarDefinicion=null;
	
	public Border setResaltarSeleccionarDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDefinicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDefinicion() {
		return this.resaltarSeleccionarDefinicion;
	}
	
	public void setResaltarSeleccionarDefinicion(Border borderResaltarSeleccionarDefinicion) {
		this.resaltarSeleccionarDefinicion= borderResaltarSeleccionarDefinicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDefinicion=null;
	public Boolean mostraridDefinicion=true;
	public Boolean activaridDefinicion=true;

	public Border resaltarid_empresaDefinicion=null;
	public Boolean mostrarid_empresaDefinicion=true;
	public Boolean activarid_empresaDefinicion=true;
	public Boolean cargarid_empresaDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDefinicion=false;//ConEventDepend=true

	public Border resaltarid_moduloDefinicion=null;
	public Boolean mostrarid_moduloDefinicion=true;
	public Boolean activarid_moduloDefinicion=true;
	public Boolean cargarid_moduloDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDefinicion=false;//ConEventDepend=true

	public Border resaltarsecuencial_formatoDefinicion=null;
	public Boolean mostrarsecuencial_formatoDefinicion=true;
	public Boolean activarsecuencial_formatoDefinicion=true;

	public Border resaltarsecuencialDefinicion=null;
	public Boolean mostrarsecuencialDefinicion=true;
	public Boolean activarsecuencialDefinicion=true;

	public Border resaltarid_tipo_definicionDefinicion=null;
	public Boolean mostrarid_tipo_definicionDefinicion=true;
	public Boolean activarid_tipo_definicionDefinicion=true;
	public Boolean cargarid_tipo_definicionDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_definicionDefinicion=false;//ConEventDepend=true

	public Border resaltarid_transaccionDefinicion=null;
	public Boolean mostrarid_transaccionDefinicion=true;
	public Boolean activarid_transaccionDefinicion=true;
	public Boolean cargarid_transaccionDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionDefinicion=false;//ConEventDepend=true

	public Border resaltarid_sucursalDefinicion=null;
	public Boolean mostrarid_sucursalDefinicion=true;
	public Boolean activarid_sucursalDefinicion=true;
	public Boolean cargarid_sucursalDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDefinicion=false;//ConEventDepend=true

	public Border resaltarid_tipo_iva_itemDefinicion=null;
	public Boolean mostrarid_tipo_iva_itemDefinicion=true;
	public Boolean activarid_tipo_iva_itemDefinicion=true;
	public Boolean cargarid_tipo_iva_itemDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_iva_itemDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_mostrar_bodegaDefinicion=null;
	public Boolean mostrarcon_mostrar_bodegaDefinicion=true;
	public Boolean activarcon_mostrar_bodegaDefinicion=true;

	public Border resaltarfactorDefinicion=null;
	public Boolean mostrarfactorDefinicion=true;
	public Boolean activarfactorDefinicion=true;

	public Border resaltarcon_otro_recargoDefinicion=null;
	public Boolean mostrarcon_otro_recargoDefinicion=true;
	public Boolean activarcon_otro_recargoDefinicion=true;

	public Border resaltarid_tipo_global_clienteDefinicion=null;
	public Boolean mostrarid_tipo_global_clienteDefinicion=true;
	public Boolean activarid_tipo_global_clienteDefinicion=true;
	public Boolean cargarid_tipo_global_clienteDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_global_clienteDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_coaDefinicion=null;
	public Boolean mostrarcon_coaDefinicion=true;
	public Boolean activarcon_coaDefinicion=true;

	public Border resaltarid_tipo_costeo_definicionDefinicion=null;
	public Boolean mostrarid_tipo_costeo_definicionDefinicion=true;
	public Boolean activarid_tipo_costeo_definicionDefinicion=true;
	public Boolean cargarid_tipo_costeo_definicionDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costeo_definicionDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_retencionDefinicion=null;
	public Boolean mostrarcon_retencionDefinicion=true;
	public Boolean activarcon_retencionDefinicion=true;

	public Border resaltarid_tipo_costo_definicionDefinicion=null;
	public Boolean mostrarid_tipo_costo_definicionDefinicion=true;
	public Boolean activarid_tipo_costo_definicionDefinicion=true;
	public Boolean cargarid_tipo_costo_definicionDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costo_definicionDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_novedad_productoDefinicion=null;
	public Boolean mostrarcon_novedad_productoDefinicion=true;
	public Boolean activarcon_novedad_productoDefinicion=true;

	public Border resaltarcon_iceDefinicion=null;
	public Boolean mostrarcon_iceDefinicion=true;
	public Boolean activarcon_iceDefinicion=true;

	public Border resaltarcon_cantidadDefinicion=null;
	public Boolean mostrarcon_cantidadDefinicion=true;
	public Boolean activarcon_cantidadDefinicion=true;

	public Border resaltarcon_producto_por_proveedorDefinicion=null;
	public Boolean mostrarcon_producto_por_proveedorDefinicion=true;
	public Boolean activarcon_producto_por_proveedorDefinicion=true;

	public Border resaltarcon_lote_clienteDefinicion=null;
	public Boolean mostrarcon_lote_clienteDefinicion=true;
	public Boolean activarcon_lote_clienteDefinicion=true;

	public Border resaltarcon_cuenta_contableDefinicion=null;
	public Boolean mostrarcon_cuenta_contableDefinicion=true;
	public Boolean activarcon_cuenta_contableDefinicion=true;

	public Border resaltarcon_detalleDefinicion=null;
	public Boolean mostrarcon_detalleDefinicion=true;
	public Boolean activarcon_detalleDefinicion=true;

	public Border resaltarcon_iva_incluidoDefinicion=null;
	public Boolean mostrarcon_iva_incluidoDefinicion=true;
	public Boolean activarcon_iva_incluidoDefinicion=true;

	public Border resaltarcon_lotesDefinicion=null;
	public Boolean mostrarcon_lotesDefinicion=true;
	public Boolean activarcon_lotesDefinicion=true;

	public Border resaltarnumero_descuentosDefinicion=null;
	public Boolean mostrarnumero_descuentosDefinicion=true;
	public Boolean activarnumero_descuentosDefinicion=true;

	public Border resaltarcon_precioDefinicion=null;
	public Boolean mostrarcon_precioDefinicion=true;
	public Boolean activarcon_precioDefinicion=true;

	public Border resaltarnumero_registrosDefinicion=null;
	public Boolean mostrarnumero_registrosDefinicion=true;
	public Boolean activarnumero_registrosDefinicion=true;

	public Border resaltarcon_centro_costoDefinicion=null;
	public Boolean mostrarcon_centro_costoDefinicion=true;
	public Boolean activarcon_centro_costoDefinicion=true;

	public Border resaltarcon_orden_ivaDefinicion=null;
	public Boolean mostrarcon_orden_ivaDefinicion=true;
	public Boolean activarcon_orden_ivaDefinicion=true;

	public Border resaltarcon_multi_empresaDefinicion=null;
	public Boolean mostrarcon_multi_empresaDefinicion=true;
	public Boolean activarcon_multi_empresaDefinicion=true;

	public Border resaltarid_formatoDefinicion=null;
	public Boolean mostrarid_formatoDefinicion=true;
	public Boolean activarid_formatoDefinicion=true;
	public Boolean cargarid_formatoDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_en_lineaDefinicion=null;
	public Boolean mostrarcon_en_lineaDefinicion=true;
	public Boolean activarcon_en_lineaDefinicion=true;

	public Border resaltarid_tipo_tributarioDefinicion=null;
	public Boolean mostrarid_tipo_tributarioDefinicion=true;
	public Boolean activarid_tipo_tributarioDefinicion=true;
	public Boolean cargarid_tipo_tributarioDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tributarioDefinicion=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionDefinicion=null;
	public Boolean mostrarid_tipo_retencionDefinicion=true;
	public Boolean activarid_tipo_retencionDefinicion=true;
	public Boolean cargarid_tipo_retencionDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_evaluacionDefinicion=null;
	public Boolean mostrarcon_evaluacionDefinicion=true;
	public Boolean activarcon_evaluacionDefinicion=true;

	public Border resaltarcon_otDefinicion=null;
	public Boolean mostrarcon_otDefinicion=true;
	public Boolean activarcon_otDefinicion=true;

	public Border resaltarcon_anticipoDefinicion=null;
	public Boolean mostrarcon_anticipoDefinicion=true;
	public Boolean activarcon_anticipoDefinicion=true;

	public Border resaltarcon_cierreDefinicion=null;
	public Boolean mostrarcon_cierreDefinicion=true;
	public Boolean activarcon_cierreDefinicion=true;

	public Border resaltarcon_generalDefinicion=null;
	public Boolean mostrarcon_generalDefinicion=true;
	public Boolean activarcon_generalDefinicion=true;

	public Border resaltarcon_por_productoDefinicion=null;
	public Boolean mostrarcon_por_productoDefinicion=true;
	public Boolean activarcon_por_productoDefinicion=true;

	public Border resaltarcon_descuentoDefinicion=null;
	public Boolean mostrarcon_descuentoDefinicion=true;
	public Boolean activarcon_descuentoDefinicion=true;

	public Border resaltarcon_seriesDefinicion=null;
	public Boolean mostrarcon_seriesDefinicion=true;
	public Boolean activarcon_seriesDefinicion=true;

	public Border resaltarcantidadDefinicion=null;
	public Boolean mostrarcantidadDefinicion=true;
	public Boolean activarcantidadDefinicion=true;

	public Border resaltarid_tipo_documentoDefinicion=null;
	public Boolean mostrarid_tipo_documentoDefinicion=true;
	public Boolean activarid_tipo_documentoDefinicion=true;
	public Boolean cargarid_tipo_documentoDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoDefinicion=false;//ConEventDepend=true

	public Border resaltarid_libro_contableDefinicion=null;
	public Boolean mostrarid_libro_contableDefinicion=true;
	public Boolean activarid_libro_contableDefinicion=true;
	public Boolean cargarid_libro_contableDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_libro_contableDefinicion=false;//ConEventDepend=true

	public Border resaltarcon_internoDefinicion=null;
	public Boolean mostrarcon_internoDefinicion=true;
	public Boolean activarcon_internoDefinicion=true;

	public Border resaltarcon_reservaDefinicion=null;
	public Boolean mostrarcon_reservaDefinicion=true;
	public Boolean activarcon_reservaDefinicion=true;

	public Border resaltarcon_precio_proveedorDefinicion=null;
	public Boolean mostrarcon_precio_proveedorDefinicion=true;
	public Boolean activarcon_precio_proveedorDefinicion=true;

	public Border resaltarcon_produccionDefinicion=null;
	public Boolean mostrarcon_produccionDefinicion=true;
	public Boolean activarcon_produccionDefinicion=true;

	public Border resaltarcon_codigo_barraDefinicion=null;
	public Boolean mostrarcon_codigo_barraDefinicion=true;
	public Boolean activarcon_codigo_barraDefinicion=true;

	public Border resaltarcon_romaneosDefinicion=null;
	public Boolean mostrarcon_romaneosDefinicion=true;
	public Boolean activarcon_romaneosDefinicion=true;

	public Border resaltarid_tipo_transaccion_moduloDefinicion=null;
	public Boolean mostrarid_tipo_transaccion_moduloDefinicion=true;
	public Boolean activarid_tipo_transaccion_moduloDefinicion=false;
	public Boolean cargarid_tipo_transaccion_moduloDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDefinicion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableDefinicion=null;
	public Boolean mostrarid_cuenta_contableDefinicion=true;
	public Boolean activarid_cuenta_contableDefinicion=false;
	public Boolean cargarid_cuenta_contableDefinicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableDefinicion=false;//ConEventDepend=true

	
	

	public Border setResaltaridDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltaridDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDefinicion() {
		return this.resaltaridDefinicion;
	}

	public void setResaltaridDefinicion(Border borderResaltar) {
		this.resaltaridDefinicion= borderResaltar;
	}

	public Boolean getMostraridDefinicion() {
		return this.mostraridDefinicion;
	}

	public void setMostraridDefinicion(Boolean mostraridDefinicion) {
		this.mostraridDefinicion= mostraridDefinicion;
	}

	public Boolean getActivaridDefinicion() {
		return this.activaridDefinicion;
	}

	public void setActivaridDefinicion(Boolean activaridDefinicion) {
		this.activaridDefinicion= activaridDefinicion;
	}

	public Border setResaltarid_empresaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_empresaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDefinicion() {
		return this.resaltarid_empresaDefinicion;
	}

	public void setResaltarid_empresaDefinicion(Border borderResaltar) {
		this.resaltarid_empresaDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_empresaDefinicion() {
		return this.mostrarid_empresaDefinicion;
	}

	public void setMostrarid_empresaDefinicion(Boolean mostrarid_empresaDefinicion) {
		this.mostrarid_empresaDefinicion= mostrarid_empresaDefinicion;
	}

	public Boolean getActivarid_empresaDefinicion() {
		return this.activarid_empresaDefinicion;
	}

	public void setActivarid_empresaDefinicion(Boolean activarid_empresaDefinicion) {
		this.activarid_empresaDefinicion= activarid_empresaDefinicion;
	}

	public Boolean getCargarid_empresaDefinicion() {
		return this.cargarid_empresaDefinicion;
	}

	public void setCargarid_empresaDefinicion(Boolean cargarid_empresaDefinicion) {
		this.cargarid_empresaDefinicion= cargarid_empresaDefinicion;
	}

	public Border setResaltarid_moduloDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_moduloDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDefinicion() {
		return this.resaltarid_moduloDefinicion;
	}

	public void setResaltarid_moduloDefinicion(Border borderResaltar) {
		this.resaltarid_moduloDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_moduloDefinicion() {
		return this.mostrarid_moduloDefinicion;
	}

	public void setMostrarid_moduloDefinicion(Boolean mostrarid_moduloDefinicion) {
		this.mostrarid_moduloDefinicion= mostrarid_moduloDefinicion;
	}

	public Boolean getActivarid_moduloDefinicion() {
		return this.activarid_moduloDefinicion;
	}

	public void setActivarid_moduloDefinicion(Boolean activarid_moduloDefinicion) {
		this.activarid_moduloDefinicion= activarid_moduloDefinicion;
	}

	public Boolean getCargarid_moduloDefinicion() {
		return this.cargarid_moduloDefinicion;
	}

	public void setCargarid_moduloDefinicion(Boolean cargarid_moduloDefinicion) {
		this.cargarid_moduloDefinicion= cargarid_moduloDefinicion;
	}

	public Border setResaltarsecuencial_formatoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarsecuencial_formatoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_formatoDefinicion() {
		return this.resaltarsecuencial_formatoDefinicion;
	}

	public void setResaltarsecuencial_formatoDefinicion(Border borderResaltar) {
		this.resaltarsecuencial_formatoDefinicion= borderResaltar;
	}

	public Boolean getMostrarsecuencial_formatoDefinicion() {
		return this.mostrarsecuencial_formatoDefinicion;
	}

	public void setMostrarsecuencial_formatoDefinicion(Boolean mostrarsecuencial_formatoDefinicion) {
		this.mostrarsecuencial_formatoDefinicion= mostrarsecuencial_formatoDefinicion;
	}

	public Boolean getActivarsecuencial_formatoDefinicion() {
		return this.activarsecuencial_formatoDefinicion;
	}

	public void setActivarsecuencial_formatoDefinicion(Boolean activarsecuencial_formatoDefinicion) {
		this.activarsecuencial_formatoDefinicion= activarsecuencial_formatoDefinicion;
	}

	public Border setResaltarsecuencialDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarsecuencialDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialDefinicion() {
		return this.resaltarsecuencialDefinicion;
	}

	public void setResaltarsecuencialDefinicion(Border borderResaltar) {
		this.resaltarsecuencialDefinicion= borderResaltar;
	}

	public Boolean getMostrarsecuencialDefinicion() {
		return this.mostrarsecuencialDefinicion;
	}

	public void setMostrarsecuencialDefinicion(Boolean mostrarsecuencialDefinicion) {
		this.mostrarsecuencialDefinicion= mostrarsecuencialDefinicion;
	}

	public Boolean getActivarsecuencialDefinicion() {
		return this.activarsecuencialDefinicion;
	}

	public void setActivarsecuencialDefinicion(Boolean activarsecuencialDefinicion) {
		this.activarsecuencialDefinicion= activarsecuencialDefinicion;
	}

	public Border setResaltarid_tipo_definicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_definicionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_definicionDefinicion() {
		return this.resaltarid_tipo_definicionDefinicion;
	}

	public void setResaltarid_tipo_definicionDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_definicionDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_definicionDefinicion() {
		return this.mostrarid_tipo_definicionDefinicion;
	}

	public void setMostrarid_tipo_definicionDefinicion(Boolean mostrarid_tipo_definicionDefinicion) {
		this.mostrarid_tipo_definicionDefinicion= mostrarid_tipo_definicionDefinicion;
	}

	public Boolean getActivarid_tipo_definicionDefinicion() {
		return this.activarid_tipo_definicionDefinicion;
	}

	public void setActivarid_tipo_definicionDefinicion(Boolean activarid_tipo_definicionDefinicion) {
		this.activarid_tipo_definicionDefinicion= activarid_tipo_definicionDefinicion;
	}

	public Boolean getCargarid_tipo_definicionDefinicion() {
		return this.cargarid_tipo_definicionDefinicion;
	}

	public void setCargarid_tipo_definicionDefinicion(Boolean cargarid_tipo_definicionDefinicion) {
		this.cargarid_tipo_definicionDefinicion= cargarid_tipo_definicionDefinicion;
	}

	public Border setResaltarid_transaccionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_transaccionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionDefinicion() {
		return this.resaltarid_transaccionDefinicion;
	}

	public void setResaltarid_transaccionDefinicion(Border borderResaltar) {
		this.resaltarid_transaccionDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_transaccionDefinicion() {
		return this.mostrarid_transaccionDefinicion;
	}

	public void setMostrarid_transaccionDefinicion(Boolean mostrarid_transaccionDefinicion) {
		this.mostrarid_transaccionDefinicion= mostrarid_transaccionDefinicion;
	}

	public Boolean getActivarid_transaccionDefinicion() {
		return this.activarid_transaccionDefinicion;
	}

	public void setActivarid_transaccionDefinicion(Boolean activarid_transaccionDefinicion) {
		this.activarid_transaccionDefinicion= activarid_transaccionDefinicion;
	}

	public Boolean getCargarid_transaccionDefinicion() {
		return this.cargarid_transaccionDefinicion;
	}

	public void setCargarid_transaccionDefinicion(Boolean cargarid_transaccionDefinicion) {
		this.cargarid_transaccionDefinicion= cargarid_transaccionDefinicion;
	}

	public Border setResaltarid_sucursalDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDefinicion() {
		return this.resaltarid_sucursalDefinicion;
	}

	public void setResaltarid_sucursalDefinicion(Border borderResaltar) {
		this.resaltarid_sucursalDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDefinicion() {
		return this.mostrarid_sucursalDefinicion;
	}

	public void setMostrarid_sucursalDefinicion(Boolean mostrarid_sucursalDefinicion) {
		this.mostrarid_sucursalDefinicion= mostrarid_sucursalDefinicion;
	}

	public Boolean getActivarid_sucursalDefinicion() {
		return this.activarid_sucursalDefinicion;
	}

	public void setActivarid_sucursalDefinicion(Boolean activarid_sucursalDefinicion) {
		this.activarid_sucursalDefinicion= activarid_sucursalDefinicion;
	}

	public Boolean getCargarid_sucursalDefinicion() {
		return this.cargarid_sucursalDefinicion;
	}

	public void setCargarid_sucursalDefinicion(Boolean cargarid_sucursalDefinicion) {
		this.cargarid_sucursalDefinicion= cargarid_sucursalDefinicion;
	}

	public Border setResaltarid_tipo_iva_itemDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_iva_itemDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_iva_itemDefinicion() {
		return this.resaltarid_tipo_iva_itemDefinicion;
	}

	public void setResaltarid_tipo_iva_itemDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_iva_itemDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_iva_itemDefinicion() {
		return this.mostrarid_tipo_iva_itemDefinicion;
	}

	public void setMostrarid_tipo_iva_itemDefinicion(Boolean mostrarid_tipo_iva_itemDefinicion) {
		this.mostrarid_tipo_iva_itemDefinicion= mostrarid_tipo_iva_itemDefinicion;
	}

	public Boolean getActivarid_tipo_iva_itemDefinicion() {
		return this.activarid_tipo_iva_itemDefinicion;
	}

	public void setActivarid_tipo_iva_itemDefinicion(Boolean activarid_tipo_iva_itemDefinicion) {
		this.activarid_tipo_iva_itemDefinicion= activarid_tipo_iva_itemDefinicion;
	}

	public Boolean getCargarid_tipo_iva_itemDefinicion() {
		return this.cargarid_tipo_iva_itemDefinicion;
	}

	public void setCargarid_tipo_iva_itemDefinicion(Boolean cargarid_tipo_iva_itemDefinicion) {
		this.cargarid_tipo_iva_itemDefinicion= cargarid_tipo_iva_itemDefinicion;
	}

	public Border setResaltarcon_mostrar_bodegaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_mostrar_bodegaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mostrar_bodegaDefinicion() {
		return this.resaltarcon_mostrar_bodegaDefinicion;
	}

	public void setResaltarcon_mostrar_bodegaDefinicion(Border borderResaltar) {
		this.resaltarcon_mostrar_bodegaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_mostrar_bodegaDefinicion() {
		return this.mostrarcon_mostrar_bodegaDefinicion;
	}

	public void setMostrarcon_mostrar_bodegaDefinicion(Boolean mostrarcon_mostrar_bodegaDefinicion) {
		this.mostrarcon_mostrar_bodegaDefinicion= mostrarcon_mostrar_bodegaDefinicion;
	}

	public Boolean getActivarcon_mostrar_bodegaDefinicion() {
		return this.activarcon_mostrar_bodegaDefinicion;
	}

	public void setActivarcon_mostrar_bodegaDefinicion(Boolean activarcon_mostrar_bodegaDefinicion) {
		this.activarcon_mostrar_bodegaDefinicion= activarcon_mostrar_bodegaDefinicion;
	}

	public Border setResaltarfactorDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarfactorDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfactorDefinicion() {
		return this.resaltarfactorDefinicion;
	}

	public void setResaltarfactorDefinicion(Border borderResaltar) {
		this.resaltarfactorDefinicion= borderResaltar;
	}

	public Boolean getMostrarfactorDefinicion() {
		return this.mostrarfactorDefinicion;
	}

	public void setMostrarfactorDefinicion(Boolean mostrarfactorDefinicion) {
		this.mostrarfactorDefinicion= mostrarfactorDefinicion;
	}

	public Boolean getActivarfactorDefinicion() {
		return this.activarfactorDefinicion;
	}

	public void setActivarfactorDefinicion(Boolean activarfactorDefinicion) {
		this.activarfactorDefinicion= activarfactorDefinicion;
	}

	public Border setResaltarcon_otro_recargoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_otro_recargoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_otro_recargoDefinicion() {
		return this.resaltarcon_otro_recargoDefinicion;
	}

	public void setResaltarcon_otro_recargoDefinicion(Border borderResaltar) {
		this.resaltarcon_otro_recargoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_otro_recargoDefinicion() {
		return this.mostrarcon_otro_recargoDefinicion;
	}

	public void setMostrarcon_otro_recargoDefinicion(Boolean mostrarcon_otro_recargoDefinicion) {
		this.mostrarcon_otro_recargoDefinicion= mostrarcon_otro_recargoDefinicion;
	}

	public Boolean getActivarcon_otro_recargoDefinicion() {
		return this.activarcon_otro_recargoDefinicion;
	}

	public void setActivarcon_otro_recargoDefinicion(Boolean activarcon_otro_recargoDefinicion) {
		this.activarcon_otro_recargoDefinicion= activarcon_otro_recargoDefinicion;
	}

	public Border setResaltarid_tipo_global_clienteDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_global_clienteDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_global_clienteDefinicion() {
		return this.resaltarid_tipo_global_clienteDefinicion;
	}

	public void setResaltarid_tipo_global_clienteDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_global_clienteDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_global_clienteDefinicion() {
		return this.mostrarid_tipo_global_clienteDefinicion;
	}

	public void setMostrarid_tipo_global_clienteDefinicion(Boolean mostrarid_tipo_global_clienteDefinicion) {
		this.mostrarid_tipo_global_clienteDefinicion= mostrarid_tipo_global_clienteDefinicion;
	}

	public Boolean getActivarid_tipo_global_clienteDefinicion() {
		return this.activarid_tipo_global_clienteDefinicion;
	}

	public void setActivarid_tipo_global_clienteDefinicion(Boolean activarid_tipo_global_clienteDefinicion) {
		this.activarid_tipo_global_clienteDefinicion= activarid_tipo_global_clienteDefinicion;
	}

	public Boolean getCargarid_tipo_global_clienteDefinicion() {
		return this.cargarid_tipo_global_clienteDefinicion;
	}

	public void setCargarid_tipo_global_clienteDefinicion(Boolean cargarid_tipo_global_clienteDefinicion) {
		this.cargarid_tipo_global_clienteDefinicion= cargarid_tipo_global_clienteDefinicion;
	}

	public Border setResaltarcon_coaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_coaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_coaDefinicion() {
		return this.resaltarcon_coaDefinicion;
	}

	public void setResaltarcon_coaDefinicion(Border borderResaltar) {
		this.resaltarcon_coaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_coaDefinicion() {
		return this.mostrarcon_coaDefinicion;
	}

	public void setMostrarcon_coaDefinicion(Boolean mostrarcon_coaDefinicion) {
		this.mostrarcon_coaDefinicion= mostrarcon_coaDefinicion;
	}

	public Boolean getActivarcon_coaDefinicion() {
		return this.activarcon_coaDefinicion;
	}

	public void setActivarcon_coaDefinicion(Boolean activarcon_coaDefinicion) {
		this.activarcon_coaDefinicion= activarcon_coaDefinicion;
	}

	public Border setResaltarid_tipo_costeo_definicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costeo_definicionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costeo_definicionDefinicion() {
		return this.resaltarid_tipo_costeo_definicionDefinicion;
	}

	public void setResaltarid_tipo_costeo_definicionDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_costeo_definicionDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costeo_definicionDefinicion() {
		return this.mostrarid_tipo_costeo_definicionDefinicion;
	}

	public void setMostrarid_tipo_costeo_definicionDefinicion(Boolean mostrarid_tipo_costeo_definicionDefinicion) {
		this.mostrarid_tipo_costeo_definicionDefinicion= mostrarid_tipo_costeo_definicionDefinicion;
	}

	public Boolean getActivarid_tipo_costeo_definicionDefinicion() {
		return this.activarid_tipo_costeo_definicionDefinicion;
	}

	public void setActivarid_tipo_costeo_definicionDefinicion(Boolean activarid_tipo_costeo_definicionDefinicion) {
		this.activarid_tipo_costeo_definicionDefinicion= activarid_tipo_costeo_definicionDefinicion;
	}

	public Boolean getCargarid_tipo_costeo_definicionDefinicion() {
		return this.cargarid_tipo_costeo_definicionDefinicion;
	}

	public void setCargarid_tipo_costeo_definicionDefinicion(Boolean cargarid_tipo_costeo_definicionDefinicion) {
		this.cargarid_tipo_costeo_definicionDefinicion= cargarid_tipo_costeo_definicionDefinicion;
	}

	public Border setResaltarcon_retencionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_retencionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_retencionDefinicion() {
		return this.resaltarcon_retencionDefinicion;
	}

	public void setResaltarcon_retencionDefinicion(Border borderResaltar) {
		this.resaltarcon_retencionDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_retencionDefinicion() {
		return this.mostrarcon_retencionDefinicion;
	}

	public void setMostrarcon_retencionDefinicion(Boolean mostrarcon_retencionDefinicion) {
		this.mostrarcon_retencionDefinicion= mostrarcon_retencionDefinicion;
	}

	public Boolean getActivarcon_retencionDefinicion() {
		return this.activarcon_retencionDefinicion;
	}

	public void setActivarcon_retencionDefinicion(Boolean activarcon_retencionDefinicion) {
		this.activarcon_retencionDefinicion= activarcon_retencionDefinicion;
	}

	public Border setResaltarid_tipo_costo_definicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costo_definicionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costo_definicionDefinicion() {
		return this.resaltarid_tipo_costo_definicionDefinicion;
	}

	public void setResaltarid_tipo_costo_definicionDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_costo_definicionDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costo_definicionDefinicion() {
		return this.mostrarid_tipo_costo_definicionDefinicion;
	}

	public void setMostrarid_tipo_costo_definicionDefinicion(Boolean mostrarid_tipo_costo_definicionDefinicion) {
		this.mostrarid_tipo_costo_definicionDefinicion= mostrarid_tipo_costo_definicionDefinicion;
	}

	public Boolean getActivarid_tipo_costo_definicionDefinicion() {
		return this.activarid_tipo_costo_definicionDefinicion;
	}

	public void setActivarid_tipo_costo_definicionDefinicion(Boolean activarid_tipo_costo_definicionDefinicion) {
		this.activarid_tipo_costo_definicionDefinicion= activarid_tipo_costo_definicionDefinicion;
	}

	public Boolean getCargarid_tipo_costo_definicionDefinicion() {
		return this.cargarid_tipo_costo_definicionDefinicion;
	}

	public void setCargarid_tipo_costo_definicionDefinicion(Boolean cargarid_tipo_costo_definicionDefinicion) {
		this.cargarid_tipo_costo_definicionDefinicion= cargarid_tipo_costo_definicionDefinicion;
	}

	public Border setResaltarcon_novedad_productoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_novedad_productoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_novedad_productoDefinicion() {
		return this.resaltarcon_novedad_productoDefinicion;
	}

	public void setResaltarcon_novedad_productoDefinicion(Border borderResaltar) {
		this.resaltarcon_novedad_productoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_novedad_productoDefinicion() {
		return this.mostrarcon_novedad_productoDefinicion;
	}

	public void setMostrarcon_novedad_productoDefinicion(Boolean mostrarcon_novedad_productoDefinicion) {
		this.mostrarcon_novedad_productoDefinicion= mostrarcon_novedad_productoDefinicion;
	}

	public Boolean getActivarcon_novedad_productoDefinicion() {
		return this.activarcon_novedad_productoDefinicion;
	}

	public void setActivarcon_novedad_productoDefinicion(Boolean activarcon_novedad_productoDefinicion) {
		this.activarcon_novedad_productoDefinicion= activarcon_novedad_productoDefinicion;
	}

	public Border setResaltarcon_iceDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_iceDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_iceDefinicion() {
		return this.resaltarcon_iceDefinicion;
	}

	public void setResaltarcon_iceDefinicion(Border borderResaltar) {
		this.resaltarcon_iceDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_iceDefinicion() {
		return this.mostrarcon_iceDefinicion;
	}

	public void setMostrarcon_iceDefinicion(Boolean mostrarcon_iceDefinicion) {
		this.mostrarcon_iceDefinicion= mostrarcon_iceDefinicion;
	}

	public Boolean getActivarcon_iceDefinicion() {
		return this.activarcon_iceDefinicion;
	}

	public void setActivarcon_iceDefinicion(Boolean activarcon_iceDefinicion) {
		this.activarcon_iceDefinicion= activarcon_iceDefinicion;
	}

	public Border setResaltarcon_cantidadDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_cantidadDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cantidadDefinicion() {
		return this.resaltarcon_cantidadDefinicion;
	}

	public void setResaltarcon_cantidadDefinicion(Border borderResaltar) {
		this.resaltarcon_cantidadDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_cantidadDefinicion() {
		return this.mostrarcon_cantidadDefinicion;
	}

	public void setMostrarcon_cantidadDefinicion(Boolean mostrarcon_cantidadDefinicion) {
		this.mostrarcon_cantidadDefinicion= mostrarcon_cantidadDefinicion;
	}

	public Boolean getActivarcon_cantidadDefinicion() {
		return this.activarcon_cantidadDefinicion;
	}

	public void setActivarcon_cantidadDefinicion(Boolean activarcon_cantidadDefinicion) {
		this.activarcon_cantidadDefinicion= activarcon_cantidadDefinicion;
	}

	public Border setResaltarcon_producto_por_proveedorDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_producto_por_proveedorDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_producto_por_proveedorDefinicion() {
		return this.resaltarcon_producto_por_proveedorDefinicion;
	}

	public void setResaltarcon_producto_por_proveedorDefinicion(Border borderResaltar) {
		this.resaltarcon_producto_por_proveedorDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_producto_por_proveedorDefinicion() {
		return this.mostrarcon_producto_por_proveedorDefinicion;
	}

	public void setMostrarcon_producto_por_proveedorDefinicion(Boolean mostrarcon_producto_por_proveedorDefinicion) {
		this.mostrarcon_producto_por_proveedorDefinicion= mostrarcon_producto_por_proveedorDefinicion;
	}

	public Boolean getActivarcon_producto_por_proveedorDefinicion() {
		return this.activarcon_producto_por_proveedorDefinicion;
	}

	public void setActivarcon_producto_por_proveedorDefinicion(Boolean activarcon_producto_por_proveedorDefinicion) {
		this.activarcon_producto_por_proveedorDefinicion= activarcon_producto_por_proveedorDefinicion;
	}

	public Border setResaltarcon_lote_clienteDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_lote_clienteDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_lote_clienteDefinicion() {
		return this.resaltarcon_lote_clienteDefinicion;
	}

	public void setResaltarcon_lote_clienteDefinicion(Border borderResaltar) {
		this.resaltarcon_lote_clienteDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_lote_clienteDefinicion() {
		return this.mostrarcon_lote_clienteDefinicion;
	}

	public void setMostrarcon_lote_clienteDefinicion(Boolean mostrarcon_lote_clienteDefinicion) {
		this.mostrarcon_lote_clienteDefinicion= mostrarcon_lote_clienteDefinicion;
	}

	public Boolean getActivarcon_lote_clienteDefinicion() {
		return this.activarcon_lote_clienteDefinicion;
	}

	public void setActivarcon_lote_clienteDefinicion(Boolean activarcon_lote_clienteDefinicion) {
		this.activarcon_lote_clienteDefinicion= activarcon_lote_clienteDefinicion;
	}

	public Border setResaltarcon_cuenta_contableDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_cuenta_contableDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuenta_contableDefinicion() {
		return this.resaltarcon_cuenta_contableDefinicion;
	}

	public void setResaltarcon_cuenta_contableDefinicion(Border borderResaltar) {
		this.resaltarcon_cuenta_contableDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_cuenta_contableDefinicion() {
		return this.mostrarcon_cuenta_contableDefinicion;
	}

	public void setMostrarcon_cuenta_contableDefinicion(Boolean mostrarcon_cuenta_contableDefinicion) {
		this.mostrarcon_cuenta_contableDefinicion= mostrarcon_cuenta_contableDefinicion;
	}

	public Boolean getActivarcon_cuenta_contableDefinicion() {
		return this.activarcon_cuenta_contableDefinicion;
	}

	public void setActivarcon_cuenta_contableDefinicion(Boolean activarcon_cuenta_contableDefinicion) {
		this.activarcon_cuenta_contableDefinicion= activarcon_cuenta_contableDefinicion;
	}

	public Border setResaltarcon_detalleDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_detalleDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalleDefinicion() {
		return this.resaltarcon_detalleDefinicion;
	}

	public void setResaltarcon_detalleDefinicion(Border borderResaltar) {
		this.resaltarcon_detalleDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_detalleDefinicion() {
		return this.mostrarcon_detalleDefinicion;
	}

	public void setMostrarcon_detalleDefinicion(Boolean mostrarcon_detalleDefinicion) {
		this.mostrarcon_detalleDefinicion= mostrarcon_detalleDefinicion;
	}

	public Boolean getActivarcon_detalleDefinicion() {
		return this.activarcon_detalleDefinicion;
	}

	public void setActivarcon_detalleDefinicion(Boolean activarcon_detalleDefinicion) {
		this.activarcon_detalleDefinicion= activarcon_detalleDefinicion;
	}

	public Border setResaltarcon_iva_incluidoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_iva_incluidoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_iva_incluidoDefinicion() {
		return this.resaltarcon_iva_incluidoDefinicion;
	}

	public void setResaltarcon_iva_incluidoDefinicion(Border borderResaltar) {
		this.resaltarcon_iva_incluidoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_iva_incluidoDefinicion() {
		return this.mostrarcon_iva_incluidoDefinicion;
	}

	public void setMostrarcon_iva_incluidoDefinicion(Boolean mostrarcon_iva_incluidoDefinicion) {
		this.mostrarcon_iva_incluidoDefinicion= mostrarcon_iva_incluidoDefinicion;
	}

	public Boolean getActivarcon_iva_incluidoDefinicion() {
		return this.activarcon_iva_incluidoDefinicion;
	}

	public void setActivarcon_iva_incluidoDefinicion(Boolean activarcon_iva_incluidoDefinicion) {
		this.activarcon_iva_incluidoDefinicion= activarcon_iva_incluidoDefinicion;
	}

	public Border setResaltarcon_lotesDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_lotesDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_lotesDefinicion() {
		return this.resaltarcon_lotesDefinicion;
	}

	public void setResaltarcon_lotesDefinicion(Border borderResaltar) {
		this.resaltarcon_lotesDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_lotesDefinicion() {
		return this.mostrarcon_lotesDefinicion;
	}

	public void setMostrarcon_lotesDefinicion(Boolean mostrarcon_lotesDefinicion) {
		this.mostrarcon_lotesDefinicion= mostrarcon_lotesDefinicion;
	}

	public Boolean getActivarcon_lotesDefinicion() {
		return this.activarcon_lotesDefinicion;
	}

	public void setActivarcon_lotesDefinicion(Boolean activarcon_lotesDefinicion) {
		this.activarcon_lotesDefinicion= activarcon_lotesDefinicion;
	}

	public Border setResaltarnumero_descuentosDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarnumero_descuentosDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_descuentosDefinicion() {
		return this.resaltarnumero_descuentosDefinicion;
	}

	public void setResaltarnumero_descuentosDefinicion(Border borderResaltar) {
		this.resaltarnumero_descuentosDefinicion= borderResaltar;
	}

	public Boolean getMostrarnumero_descuentosDefinicion() {
		return this.mostrarnumero_descuentosDefinicion;
	}

	public void setMostrarnumero_descuentosDefinicion(Boolean mostrarnumero_descuentosDefinicion) {
		this.mostrarnumero_descuentosDefinicion= mostrarnumero_descuentosDefinicion;
	}

	public Boolean getActivarnumero_descuentosDefinicion() {
		return this.activarnumero_descuentosDefinicion;
	}

	public void setActivarnumero_descuentosDefinicion(Boolean activarnumero_descuentosDefinicion) {
		this.activarnumero_descuentosDefinicion= activarnumero_descuentosDefinicion;
	}

	public Border setResaltarcon_precioDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_precioDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precioDefinicion() {
		return this.resaltarcon_precioDefinicion;
	}

	public void setResaltarcon_precioDefinicion(Border borderResaltar) {
		this.resaltarcon_precioDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_precioDefinicion() {
		return this.mostrarcon_precioDefinicion;
	}

	public void setMostrarcon_precioDefinicion(Boolean mostrarcon_precioDefinicion) {
		this.mostrarcon_precioDefinicion= mostrarcon_precioDefinicion;
	}

	public Boolean getActivarcon_precioDefinicion() {
		return this.activarcon_precioDefinicion;
	}

	public void setActivarcon_precioDefinicion(Boolean activarcon_precioDefinicion) {
		this.activarcon_precioDefinicion= activarcon_precioDefinicion;
	}

	public Border setResaltarnumero_registrosDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarnumero_registrosDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_registrosDefinicion() {
		return this.resaltarnumero_registrosDefinicion;
	}

	public void setResaltarnumero_registrosDefinicion(Border borderResaltar) {
		this.resaltarnumero_registrosDefinicion= borderResaltar;
	}

	public Boolean getMostrarnumero_registrosDefinicion() {
		return this.mostrarnumero_registrosDefinicion;
	}

	public void setMostrarnumero_registrosDefinicion(Boolean mostrarnumero_registrosDefinicion) {
		this.mostrarnumero_registrosDefinicion= mostrarnumero_registrosDefinicion;
	}

	public Boolean getActivarnumero_registrosDefinicion() {
		return this.activarnumero_registrosDefinicion;
	}

	public void setActivarnumero_registrosDefinicion(Boolean activarnumero_registrosDefinicion) {
		this.activarnumero_registrosDefinicion= activarnumero_registrosDefinicion;
	}

	public Border setResaltarcon_centro_costoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_centro_costoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costoDefinicion() {
		return this.resaltarcon_centro_costoDefinicion;
	}

	public void setResaltarcon_centro_costoDefinicion(Border borderResaltar) {
		this.resaltarcon_centro_costoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costoDefinicion() {
		return this.mostrarcon_centro_costoDefinicion;
	}

	public void setMostrarcon_centro_costoDefinicion(Boolean mostrarcon_centro_costoDefinicion) {
		this.mostrarcon_centro_costoDefinicion= mostrarcon_centro_costoDefinicion;
	}

	public Boolean getActivarcon_centro_costoDefinicion() {
		return this.activarcon_centro_costoDefinicion;
	}

	public void setActivarcon_centro_costoDefinicion(Boolean activarcon_centro_costoDefinicion) {
		this.activarcon_centro_costoDefinicion= activarcon_centro_costoDefinicion;
	}

	public Border setResaltarcon_orden_ivaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_orden_ivaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_orden_ivaDefinicion() {
		return this.resaltarcon_orden_ivaDefinicion;
	}

	public void setResaltarcon_orden_ivaDefinicion(Border borderResaltar) {
		this.resaltarcon_orden_ivaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_orden_ivaDefinicion() {
		return this.mostrarcon_orden_ivaDefinicion;
	}

	public void setMostrarcon_orden_ivaDefinicion(Boolean mostrarcon_orden_ivaDefinicion) {
		this.mostrarcon_orden_ivaDefinicion= mostrarcon_orden_ivaDefinicion;
	}

	public Boolean getActivarcon_orden_ivaDefinicion() {
		return this.activarcon_orden_ivaDefinicion;
	}

	public void setActivarcon_orden_ivaDefinicion(Boolean activarcon_orden_ivaDefinicion) {
		this.activarcon_orden_ivaDefinicion= activarcon_orden_ivaDefinicion;
	}

	public Border setResaltarcon_multi_empresaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_multi_empresaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_multi_empresaDefinicion() {
		return this.resaltarcon_multi_empresaDefinicion;
	}

	public void setResaltarcon_multi_empresaDefinicion(Border borderResaltar) {
		this.resaltarcon_multi_empresaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_multi_empresaDefinicion() {
		return this.mostrarcon_multi_empresaDefinicion;
	}

	public void setMostrarcon_multi_empresaDefinicion(Boolean mostrarcon_multi_empresaDefinicion) {
		this.mostrarcon_multi_empresaDefinicion= mostrarcon_multi_empresaDefinicion;
	}

	public Boolean getActivarcon_multi_empresaDefinicion() {
		return this.activarcon_multi_empresaDefinicion;
	}

	public void setActivarcon_multi_empresaDefinicion(Boolean activarcon_multi_empresaDefinicion) {
		this.activarcon_multi_empresaDefinicion= activarcon_multi_empresaDefinicion;
	}

	public Border setResaltarid_formatoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_formatoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoDefinicion() {
		return this.resaltarid_formatoDefinicion;
	}

	public void setResaltarid_formatoDefinicion(Border borderResaltar) {
		this.resaltarid_formatoDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_formatoDefinicion() {
		return this.mostrarid_formatoDefinicion;
	}

	public void setMostrarid_formatoDefinicion(Boolean mostrarid_formatoDefinicion) {
		this.mostrarid_formatoDefinicion= mostrarid_formatoDefinicion;
	}

	public Boolean getActivarid_formatoDefinicion() {
		return this.activarid_formatoDefinicion;
	}

	public void setActivarid_formatoDefinicion(Boolean activarid_formatoDefinicion) {
		this.activarid_formatoDefinicion= activarid_formatoDefinicion;
	}

	public Boolean getCargarid_formatoDefinicion() {
		return this.cargarid_formatoDefinicion;
	}

	public void setCargarid_formatoDefinicion(Boolean cargarid_formatoDefinicion) {
		this.cargarid_formatoDefinicion= cargarid_formatoDefinicion;
	}

	public Border setResaltarcon_en_lineaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_en_lineaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_en_lineaDefinicion() {
		return this.resaltarcon_en_lineaDefinicion;
	}

	public void setResaltarcon_en_lineaDefinicion(Border borderResaltar) {
		this.resaltarcon_en_lineaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_en_lineaDefinicion() {
		return this.mostrarcon_en_lineaDefinicion;
	}

	public void setMostrarcon_en_lineaDefinicion(Boolean mostrarcon_en_lineaDefinicion) {
		this.mostrarcon_en_lineaDefinicion= mostrarcon_en_lineaDefinicion;
	}

	public Boolean getActivarcon_en_lineaDefinicion() {
		return this.activarcon_en_lineaDefinicion;
	}

	public void setActivarcon_en_lineaDefinicion(Boolean activarcon_en_lineaDefinicion) {
		this.activarcon_en_lineaDefinicion= activarcon_en_lineaDefinicion;
	}

	public Border setResaltarid_tipo_tributarioDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tributarioDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tributarioDefinicion() {
		return this.resaltarid_tipo_tributarioDefinicion;
	}

	public void setResaltarid_tipo_tributarioDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_tributarioDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tributarioDefinicion() {
		return this.mostrarid_tipo_tributarioDefinicion;
	}

	public void setMostrarid_tipo_tributarioDefinicion(Boolean mostrarid_tipo_tributarioDefinicion) {
		this.mostrarid_tipo_tributarioDefinicion= mostrarid_tipo_tributarioDefinicion;
	}

	public Boolean getActivarid_tipo_tributarioDefinicion() {
		return this.activarid_tipo_tributarioDefinicion;
	}

	public void setActivarid_tipo_tributarioDefinicion(Boolean activarid_tipo_tributarioDefinicion) {
		this.activarid_tipo_tributarioDefinicion= activarid_tipo_tributarioDefinicion;
	}

	public Boolean getCargarid_tipo_tributarioDefinicion() {
		return this.cargarid_tipo_tributarioDefinicion;
	}

	public void setCargarid_tipo_tributarioDefinicion(Boolean cargarid_tipo_tributarioDefinicion) {
		this.cargarid_tipo_tributarioDefinicion= cargarid_tipo_tributarioDefinicion;
	}

	public Border setResaltarid_tipo_retencionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionDefinicion() {
		return this.resaltarid_tipo_retencionDefinicion;
	}

	public void setResaltarid_tipo_retencionDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_retencionDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionDefinicion() {
		return this.mostrarid_tipo_retencionDefinicion;
	}

	public void setMostrarid_tipo_retencionDefinicion(Boolean mostrarid_tipo_retencionDefinicion) {
		this.mostrarid_tipo_retencionDefinicion= mostrarid_tipo_retencionDefinicion;
	}

	public Boolean getActivarid_tipo_retencionDefinicion() {
		return this.activarid_tipo_retencionDefinicion;
	}

	public void setActivarid_tipo_retencionDefinicion(Boolean activarid_tipo_retencionDefinicion) {
		this.activarid_tipo_retencionDefinicion= activarid_tipo_retencionDefinicion;
	}

	public Boolean getCargarid_tipo_retencionDefinicion() {
		return this.cargarid_tipo_retencionDefinicion;
	}

	public void setCargarid_tipo_retencionDefinicion(Boolean cargarid_tipo_retencionDefinicion) {
		this.cargarid_tipo_retencionDefinicion= cargarid_tipo_retencionDefinicion;
	}

	public Border setResaltarcon_evaluacionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_evaluacionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_evaluacionDefinicion() {
		return this.resaltarcon_evaluacionDefinicion;
	}

	public void setResaltarcon_evaluacionDefinicion(Border borderResaltar) {
		this.resaltarcon_evaluacionDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_evaluacionDefinicion() {
		return this.mostrarcon_evaluacionDefinicion;
	}

	public void setMostrarcon_evaluacionDefinicion(Boolean mostrarcon_evaluacionDefinicion) {
		this.mostrarcon_evaluacionDefinicion= mostrarcon_evaluacionDefinicion;
	}

	public Boolean getActivarcon_evaluacionDefinicion() {
		return this.activarcon_evaluacionDefinicion;
	}

	public void setActivarcon_evaluacionDefinicion(Boolean activarcon_evaluacionDefinicion) {
		this.activarcon_evaluacionDefinicion= activarcon_evaluacionDefinicion;
	}

	public Border setResaltarcon_otDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_otDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_otDefinicion() {
		return this.resaltarcon_otDefinicion;
	}

	public void setResaltarcon_otDefinicion(Border borderResaltar) {
		this.resaltarcon_otDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_otDefinicion() {
		return this.mostrarcon_otDefinicion;
	}

	public void setMostrarcon_otDefinicion(Boolean mostrarcon_otDefinicion) {
		this.mostrarcon_otDefinicion= mostrarcon_otDefinicion;
	}

	public Boolean getActivarcon_otDefinicion() {
		return this.activarcon_otDefinicion;
	}

	public void setActivarcon_otDefinicion(Boolean activarcon_otDefinicion) {
		this.activarcon_otDefinicion= activarcon_otDefinicion;
	}

	public Border setResaltarcon_anticipoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_anticipoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_anticipoDefinicion() {
		return this.resaltarcon_anticipoDefinicion;
	}

	public void setResaltarcon_anticipoDefinicion(Border borderResaltar) {
		this.resaltarcon_anticipoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_anticipoDefinicion() {
		return this.mostrarcon_anticipoDefinicion;
	}

	public void setMostrarcon_anticipoDefinicion(Boolean mostrarcon_anticipoDefinicion) {
		this.mostrarcon_anticipoDefinicion= mostrarcon_anticipoDefinicion;
	}

	public Boolean getActivarcon_anticipoDefinicion() {
		return this.activarcon_anticipoDefinicion;
	}

	public void setActivarcon_anticipoDefinicion(Boolean activarcon_anticipoDefinicion) {
		this.activarcon_anticipoDefinicion= activarcon_anticipoDefinicion;
	}

	public Border setResaltarcon_cierreDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_cierreDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cierreDefinicion() {
		return this.resaltarcon_cierreDefinicion;
	}

	public void setResaltarcon_cierreDefinicion(Border borderResaltar) {
		this.resaltarcon_cierreDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_cierreDefinicion() {
		return this.mostrarcon_cierreDefinicion;
	}

	public void setMostrarcon_cierreDefinicion(Boolean mostrarcon_cierreDefinicion) {
		this.mostrarcon_cierreDefinicion= mostrarcon_cierreDefinicion;
	}

	public Boolean getActivarcon_cierreDefinicion() {
		return this.activarcon_cierreDefinicion;
	}

	public void setActivarcon_cierreDefinicion(Boolean activarcon_cierreDefinicion) {
		this.activarcon_cierreDefinicion= activarcon_cierreDefinicion;
	}

	public Border setResaltarcon_generalDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_generalDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_generalDefinicion() {
		return this.resaltarcon_generalDefinicion;
	}

	public void setResaltarcon_generalDefinicion(Border borderResaltar) {
		this.resaltarcon_generalDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_generalDefinicion() {
		return this.mostrarcon_generalDefinicion;
	}

	public void setMostrarcon_generalDefinicion(Boolean mostrarcon_generalDefinicion) {
		this.mostrarcon_generalDefinicion= mostrarcon_generalDefinicion;
	}

	public Boolean getActivarcon_generalDefinicion() {
		return this.activarcon_generalDefinicion;
	}

	public void setActivarcon_generalDefinicion(Boolean activarcon_generalDefinicion) {
		this.activarcon_generalDefinicion= activarcon_generalDefinicion;
	}

	public Border setResaltarcon_por_productoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_por_productoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_por_productoDefinicion() {
		return this.resaltarcon_por_productoDefinicion;
	}

	public void setResaltarcon_por_productoDefinicion(Border borderResaltar) {
		this.resaltarcon_por_productoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_por_productoDefinicion() {
		return this.mostrarcon_por_productoDefinicion;
	}

	public void setMostrarcon_por_productoDefinicion(Boolean mostrarcon_por_productoDefinicion) {
		this.mostrarcon_por_productoDefinicion= mostrarcon_por_productoDefinicion;
	}

	public Boolean getActivarcon_por_productoDefinicion() {
		return this.activarcon_por_productoDefinicion;
	}

	public void setActivarcon_por_productoDefinicion(Boolean activarcon_por_productoDefinicion) {
		this.activarcon_por_productoDefinicion= activarcon_por_productoDefinicion;
	}

	public Border setResaltarcon_descuentoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_descuentoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_descuentoDefinicion() {
		return this.resaltarcon_descuentoDefinicion;
	}

	public void setResaltarcon_descuentoDefinicion(Border borderResaltar) {
		this.resaltarcon_descuentoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_descuentoDefinicion() {
		return this.mostrarcon_descuentoDefinicion;
	}

	public void setMostrarcon_descuentoDefinicion(Boolean mostrarcon_descuentoDefinicion) {
		this.mostrarcon_descuentoDefinicion= mostrarcon_descuentoDefinicion;
	}

	public Boolean getActivarcon_descuentoDefinicion() {
		return this.activarcon_descuentoDefinicion;
	}

	public void setActivarcon_descuentoDefinicion(Boolean activarcon_descuentoDefinicion) {
		this.activarcon_descuentoDefinicion= activarcon_descuentoDefinicion;
	}

	public Border setResaltarcon_seriesDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_seriesDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_seriesDefinicion() {
		return this.resaltarcon_seriesDefinicion;
	}

	public void setResaltarcon_seriesDefinicion(Border borderResaltar) {
		this.resaltarcon_seriesDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_seriesDefinicion() {
		return this.mostrarcon_seriesDefinicion;
	}

	public void setMostrarcon_seriesDefinicion(Boolean mostrarcon_seriesDefinicion) {
		this.mostrarcon_seriesDefinicion= mostrarcon_seriesDefinicion;
	}

	public Boolean getActivarcon_seriesDefinicion() {
		return this.activarcon_seriesDefinicion;
	}

	public void setActivarcon_seriesDefinicion(Boolean activarcon_seriesDefinicion) {
		this.activarcon_seriesDefinicion= activarcon_seriesDefinicion;
	}

	public Border setResaltarcantidadDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcantidadDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDefinicion() {
		return this.resaltarcantidadDefinicion;
	}

	public void setResaltarcantidadDefinicion(Border borderResaltar) {
		this.resaltarcantidadDefinicion= borderResaltar;
	}

	public Boolean getMostrarcantidadDefinicion() {
		return this.mostrarcantidadDefinicion;
	}

	public void setMostrarcantidadDefinicion(Boolean mostrarcantidadDefinicion) {
		this.mostrarcantidadDefinicion= mostrarcantidadDefinicion;
	}

	public Boolean getActivarcantidadDefinicion() {
		return this.activarcantidadDefinicion;
	}

	public void setActivarcantidadDefinicion(Boolean activarcantidadDefinicion) {
		this.activarcantidadDefinicion= activarcantidadDefinicion;
	}

	public Border setResaltarid_tipo_documentoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoDefinicion() {
		return this.resaltarid_tipo_documentoDefinicion;
	}

	public void setResaltarid_tipo_documentoDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_documentoDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoDefinicion() {
		return this.mostrarid_tipo_documentoDefinicion;
	}

	public void setMostrarid_tipo_documentoDefinicion(Boolean mostrarid_tipo_documentoDefinicion) {
		this.mostrarid_tipo_documentoDefinicion= mostrarid_tipo_documentoDefinicion;
	}

	public Boolean getActivarid_tipo_documentoDefinicion() {
		return this.activarid_tipo_documentoDefinicion;
	}

	public void setActivarid_tipo_documentoDefinicion(Boolean activarid_tipo_documentoDefinicion) {
		this.activarid_tipo_documentoDefinicion= activarid_tipo_documentoDefinicion;
	}

	public Boolean getCargarid_tipo_documentoDefinicion() {
		return this.cargarid_tipo_documentoDefinicion;
	}

	public void setCargarid_tipo_documentoDefinicion(Boolean cargarid_tipo_documentoDefinicion) {
		this.cargarid_tipo_documentoDefinicion= cargarid_tipo_documentoDefinicion;
	}

	public Border setResaltarid_libro_contableDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_libro_contableDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_libro_contableDefinicion() {
		return this.resaltarid_libro_contableDefinicion;
	}

	public void setResaltarid_libro_contableDefinicion(Border borderResaltar) {
		this.resaltarid_libro_contableDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_libro_contableDefinicion() {
		return this.mostrarid_libro_contableDefinicion;
	}

	public void setMostrarid_libro_contableDefinicion(Boolean mostrarid_libro_contableDefinicion) {
		this.mostrarid_libro_contableDefinicion= mostrarid_libro_contableDefinicion;
	}

	public Boolean getActivarid_libro_contableDefinicion() {
		return this.activarid_libro_contableDefinicion;
	}

	public void setActivarid_libro_contableDefinicion(Boolean activarid_libro_contableDefinicion) {
		this.activarid_libro_contableDefinicion= activarid_libro_contableDefinicion;
	}

	public Boolean getCargarid_libro_contableDefinicion() {
		return this.cargarid_libro_contableDefinicion;
	}

	public void setCargarid_libro_contableDefinicion(Boolean cargarid_libro_contableDefinicion) {
		this.cargarid_libro_contableDefinicion= cargarid_libro_contableDefinicion;
	}

	public Border setResaltarcon_internoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_internoDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_internoDefinicion() {
		return this.resaltarcon_internoDefinicion;
	}

	public void setResaltarcon_internoDefinicion(Border borderResaltar) {
		this.resaltarcon_internoDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_internoDefinicion() {
		return this.mostrarcon_internoDefinicion;
	}

	public void setMostrarcon_internoDefinicion(Boolean mostrarcon_internoDefinicion) {
		this.mostrarcon_internoDefinicion= mostrarcon_internoDefinicion;
	}

	public Boolean getActivarcon_internoDefinicion() {
		return this.activarcon_internoDefinicion;
	}

	public void setActivarcon_internoDefinicion(Boolean activarcon_internoDefinicion) {
		this.activarcon_internoDefinicion= activarcon_internoDefinicion;
	}

	public Border setResaltarcon_reservaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_reservaDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_reservaDefinicion() {
		return this.resaltarcon_reservaDefinicion;
	}

	public void setResaltarcon_reservaDefinicion(Border borderResaltar) {
		this.resaltarcon_reservaDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_reservaDefinicion() {
		return this.mostrarcon_reservaDefinicion;
	}

	public void setMostrarcon_reservaDefinicion(Boolean mostrarcon_reservaDefinicion) {
		this.mostrarcon_reservaDefinicion= mostrarcon_reservaDefinicion;
	}

	public Boolean getActivarcon_reservaDefinicion() {
		return this.activarcon_reservaDefinicion;
	}

	public void setActivarcon_reservaDefinicion(Boolean activarcon_reservaDefinicion) {
		this.activarcon_reservaDefinicion= activarcon_reservaDefinicion;
	}

	public Border setResaltarcon_precio_proveedorDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_precio_proveedorDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_precio_proveedorDefinicion() {
		return this.resaltarcon_precio_proveedorDefinicion;
	}

	public void setResaltarcon_precio_proveedorDefinicion(Border borderResaltar) {
		this.resaltarcon_precio_proveedorDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_precio_proveedorDefinicion() {
		return this.mostrarcon_precio_proveedorDefinicion;
	}

	public void setMostrarcon_precio_proveedorDefinicion(Boolean mostrarcon_precio_proveedorDefinicion) {
		this.mostrarcon_precio_proveedorDefinicion= mostrarcon_precio_proveedorDefinicion;
	}

	public Boolean getActivarcon_precio_proveedorDefinicion() {
		return this.activarcon_precio_proveedorDefinicion;
	}

	public void setActivarcon_precio_proveedorDefinicion(Boolean activarcon_precio_proveedorDefinicion) {
		this.activarcon_precio_proveedorDefinicion= activarcon_precio_proveedorDefinicion;
	}

	public Border setResaltarcon_produccionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_produccionDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_produccionDefinicion() {
		return this.resaltarcon_produccionDefinicion;
	}

	public void setResaltarcon_produccionDefinicion(Border borderResaltar) {
		this.resaltarcon_produccionDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_produccionDefinicion() {
		return this.mostrarcon_produccionDefinicion;
	}

	public void setMostrarcon_produccionDefinicion(Boolean mostrarcon_produccionDefinicion) {
		this.mostrarcon_produccionDefinicion= mostrarcon_produccionDefinicion;
	}

	public Boolean getActivarcon_produccionDefinicion() {
		return this.activarcon_produccionDefinicion;
	}

	public void setActivarcon_produccionDefinicion(Boolean activarcon_produccionDefinicion) {
		this.activarcon_produccionDefinicion= activarcon_produccionDefinicion;
	}

	public Border setResaltarcon_codigo_barraDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_codigo_barraDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_codigo_barraDefinicion() {
		return this.resaltarcon_codigo_barraDefinicion;
	}

	public void setResaltarcon_codigo_barraDefinicion(Border borderResaltar) {
		this.resaltarcon_codigo_barraDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_codigo_barraDefinicion() {
		return this.mostrarcon_codigo_barraDefinicion;
	}

	public void setMostrarcon_codigo_barraDefinicion(Boolean mostrarcon_codigo_barraDefinicion) {
		this.mostrarcon_codigo_barraDefinicion= mostrarcon_codigo_barraDefinicion;
	}

	public Boolean getActivarcon_codigo_barraDefinicion() {
		return this.activarcon_codigo_barraDefinicion;
	}

	public void setActivarcon_codigo_barraDefinicion(Boolean activarcon_codigo_barraDefinicion) {
		this.activarcon_codigo_barraDefinicion= activarcon_codigo_barraDefinicion;
	}

	public Border setResaltarcon_romaneosDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarcon_romaneosDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_romaneosDefinicion() {
		return this.resaltarcon_romaneosDefinicion;
	}

	public void setResaltarcon_romaneosDefinicion(Border borderResaltar) {
		this.resaltarcon_romaneosDefinicion= borderResaltar;
	}

	public Boolean getMostrarcon_romaneosDefinicion() {
		return this.mostrarcon_romaneosDefinicion;
	}

	public void setMostrarcon_romaneosDefinicion(Boolean mostrarcon_romaneosDefinicion) {
		this.mostrarcon_romaneosDefinicion= mostrarcon_romaneosDefinicion;
	}

	public Boolean getActivarcon_romaneosDefinicion() {
		return this.activarcon_romaneosDefinicion;
	}

	public void setActivarcon_romaneosDefinicion(Boolean activarcon_romaneosDefinicion) {
		this.activarcon_romaneosDefinicion= activarcon_romaneosDefinicion;
	}

	public Border setResaltarid_tipo_transaccion_moduloDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDefinicion() {
		return this.resaltarid_tipo_transaccion_moduloDefinicion;
	}

	public void setResaltarid_tipo_transaccion_moduloDefinicion(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDefinicion() {
		return this.mostrarid_tipo_transaccion_moduloDefinicion;
	}

	public void setMostrarid_tipo_transaccion_moduloDefinicion(Boolean mostrarid_tipo_transaccion_moduloDefinicion) {
		this.mostrarid_tipo_transaccion_moduloDefinicion= mostrarid_tipo_transaccion_moduloDefinicion;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDefinicion() {
		return this.activarid_tipo_transaccion_moduloDefinicion;
	}

	public void setActivarid_tipo_transaccion_moduloDefinicion(Boolean activarid_tipo_transaccion_moduloDefinicion) {
		this.activarid_tipo_transaccion_moduloDefinicion= activarid_tipo_transaccion_moduloDefinicion;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDefinicion() {
		return this.cargarid_tipo_transaccion_moduloDefinicion;
	}

	public void setCargarid_tipo_transaccion_moduloDefinicion(Boolean cargarid_tipo_transaccion_moduloDefinicion) {
		this.cargarid_tipo_transaccion_moduloDefinicion= cargarid_tipo_transaccion_moduloDefinicion;
	}

	public Border setResaltarid_cuenta_contableDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//definicionBeanSwingJInternalFrame.jTtoolBarDefinicion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableDefinicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableDefinicion() {
		return this.resaltarid_cuenta_contableDefinicion;
	}

	public void setResaltarid_cuenta_contableDefinicion(Border borderResaltar) {
		this.resaltarid_cuenta_contableDefinicion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableDefinicion() {
		return this.mostrarid_cuenta_contableDefinicion;
	}

	public void setMostrarid_cuenta_contableDefinicion(Boolean mostrarid_cuenta_contableDefinicion) {
		this.mostrarid_cuenta_contableDefinicion= mostrarid_cuenta_contableDefinicion;
	}

	public Boolean getActivarid_cuenta_contableDefinicion() {
		return this.activarid_cuenta_contableDefinicion;
	}

	public void setActivarid_cuenta_contableDefinicion(Boolean activarid_cuenta_contableDefinicion) {
		this.activarid_cuenta_contableDefinicion= activarid_cuenta_contableDefinicion;
	}

	public Boolean getCargarid_cuenta_contableDefinicion() {
		return this.cargarid_cuenta_contableDefinicion;
	}

	public void setCargarid_cuenta_contableDefinicion(Boolean cargarid_cuenta_contableDefinicion) {
		this.cargarid_cuenta_contableDefinicion= cargarid_cuenta_contableDefinicion;
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
		
		
		this.setMostraridDefinicion(esInicial);
		this.setMostrarid_empresaDefinicion(esInicial);
		this.setMostrarid_moduloDefinicion(esInicial);
		this.setMostrarsecuencial_formatoDefinicion(esInicial);
		this.setMostrarsecuencialDefinicion(esInicial);
		this.setMostrarid_tipo_definicionDefinicion(esInicial);
		this.setMostrarid_transaccionDefinicion(esInicial);
		this.setMostrarid_sucursalDefinicion(esInicial);
		this.setMostrarid_tipo_iva_itemDefinicion(esInicial);
		this.setMostrarcon_mostrar_bodegaDefinicion(esInicial);
		this.setMostrarfactorDefinicion(esInicial);
		this.setMostrarcon_otro_recargoDefinicion(esInicial);
		this.setMostrarid_tipo_global_clienteDefinicion(esInicial);
		this.setMostrarcon_coaDefinicion(esInicial);
		this.setMostrarid_tipo_costeo_definicionDefinicion(esInicial);
		this.setMostrarcon_retencionDefinicion(esInicial);
		this.setMostrarid_tipo_costo_definicionDefinicion(esInicial);
		this.setMostrarcon_novedad_productoDefinicion(esInicial);
		this.setMostrarcon_iceDefinicion(esInicial);
		this.setMostrarcon_cantidadDefinicion(esInicial);
		this.setMostrarcon_producto_por_proveedorDefinicion(esInicial);
		this.setMostrarcon_lote_clienteDefinicion(esInicial);
		this.setMostrarcon_cuenta_contableDefinicion(esInicial);
		this.setMostrarcon_detalleDefinicion(esInicial);
		this.setMostrarcon_iva_incluidoDefinicion(esInicial);
		this.setMostrarcon_lotesDefinicion(esInicial);
		this.setMostrarnumero_descuentosDefinicion(esInicial);
		this.setMostrarcon_precioDefinicion(esInicial);
		this.setMostrarnumero_registrosDefinicion(esInicial);
		this.setMostrarcon_centro_costoDefinicion(esInicial);
		this.setMostrarcon_orden_ivaDefinicion(esInicial);
		this.setMostrarcon_multi_empresaDefinicion(esInicial);
		this.setMostrarid_formatoDefinicion(esInicial);
		this.setMostrarcon_en_lineaDefinicion(esInicial);
		this.setMostrarid_tipo_tributarioDefinicion(esInicial);
		this.setMostrarid_tipo_retencionDefinicion(esInicial);
		this.setMostrarcon_evaluacionDefinicion(esInicial);
		this.setMostrarcon_otDefinicion(esInicial);
		this.setMostrarcon_anticipoDefinicion(esInicial);
		this.setMostrarcon_cierreDefinicion(esInicial);
		this.setMostrarcon_generalDefinicion(esInicial);
		this.setMostrarcon_por_productoDefinicion(esInicial);
		this.setMostrarcon_descuentoDefinicion(esInicial);
		this.setMostrarcon_seriesDefinicion(esInicial);
		this.setMostrarcantidadDefinicion(esInicial);
		this.setMostrarid_tipo_documentoDefinicion(esInicial);
		this.setMostrarid_libro_contableDefinicion(esInicial);
		this.setMostrarcon_internoDefinicion(esInicial);
		this.setMostrarcon_reservaDefinicion(esInicial);
		this.setMostrarcon_precio_proveedorDefinicion(esInicial);
		this.setMostrarcon_produccionDefinicion(esInicial);
		this.setMostrarcon_codigo_barraDefinicion(esInicial);
		this.setMostrarcon_romaneosDefinicion(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDefinicion(esInicial);
		this.setMostrarid_cuenta_contableDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefinicionConstantesFunciones.ID)) {
				this.setMostraridDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIALFORMATO)) {
				this.setMostrarsecuencial_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODEFINICION)) {
				this.setMostrarid_tipo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOIVAITEM)) {
				this.setMostrarid_tipo_iva_itemDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMOSTRARBODEGA)) {
				this.setMostrarcon_mostrar_bodegaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.FACTOR)) {
				this.setMostrarfactorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOTRORECARGO)) {
				this.setMostrarcon_otro_recargoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE)) {
				this.setMostrarid_tipo_global_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCOA)) {
				this.setMostrarcon_coaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION)) {
				this.setMostrarid_tipo_costeo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRETENCION)) {
				this.setMostrarcon_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION)) {
				this.setMostrarid_tipo_costo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONNOVEDADPRODUCTO)) {
				this.setMostrarcon_novedad_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONICE)) {
				this.setMostrarcon_iceDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCANTIDAD)) {
				this.setMostrarcon_cantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR)) {
				this.setMostrarcon_producto_por_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTECLIENTE)) {
				this.setMostrarcon_lote_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCUENTACONTABLE)) {
				this.setMostrarcon_cuenta_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDETALLE)) {
				this.setMostrarcon_detalleDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONIVAINCLUIDO)) {
				this.setMostrarcon_iva_incluidoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTES)) {
				this.setMostrarcon_lotesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMERODESCUENTOS)) {
				this.setMostrarnumero_descuentosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIO)) {
				this.setMostrarcon_precioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMEROREGISTROS)) {
				this.setMostrarnumero_registrosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCENTROCOSTO)) {
				this.setMostrarcon_centro_costoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONORDENIVA)) {
				this.setMostrarcon_orden_ivaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMULTIEMPRESA)) {
				this.setMostrarcon_multi_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONENLINEA)) {
				this.setMostrarcon_en_lineaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrarid_tipo_tributarioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONEVALUACION)) {
				this.setMostrarcon_evaluacionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOT)) {
				this.setMostrarcon_otDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONANTICIPO)) {
				this.setMostrarcon_anticipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCIERRE)) {
				this.setMostrarcon_cierreDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONGENERAL)) {
				this.setMostrarcon_generalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPORPRODUCTO)) {
				this.setMostrarcon_por_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDESCUENTO)) {
				this.setMostrarcon_descuentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONSERIES)) {
				this.setMostrarcon_seriesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDLIBROCONTABLE)) {
				this.setMostrarid_libro_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONINTERNO)) {
				this.setMostrarcon_internoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRESERVA)) {
				this.setMostrarcon_reservaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIOPROVEEDOR)) {
				this.setMostrarcon_precio_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCCION)) {
				this.setMostrarcon_produccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCODIGOBARRA)) {
				this.setMostrarcon_codigo_barraDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONROMANEOS)) {
				this.setMostrarcon_romaneosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableDefinicion(esAsigna);
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
		
		
		this.setActivaridDefinicion(esInicial);
		this.setActivarid_empresaDefinicion(esInicial);
		this.setActivarid_moduloDefinicion(esInicial);
		this.setActivarsecuencial_formatoDefinicion(esInicial);
		this.setActivarsecuencialDefinicion(esInicial);
		this.setActivarid_tipo_definicionDefinicion(esInicial);
		this.setActivarid_transaccionDefinicion(esInicial);
		this.setActivarid_sucursalDefinicion(esInicial);
		this.setActivarid_tipo_iva_itemDefinicion(esInicial);
		this.setActivarcon_mostrar_bodegaDefinicion(esInicial);
		this.setActivarfactorDefinicion(esInicial);
		this.setActivarcon_otro_recargoDefinicion(esInicial);
		this.setActivarid_tipo_global_clienteDefinicion(esInicial);
		this.setActivarcon_coaDefinicion(esInicial);
		this.setActivarid_tipo_costeo_definicionDefinicion(esInicial);
		this.setActivarcon_retencionDefinicion(esInicial);
		this.setActivarid_tipo_costo_definicionDefinicion(esInicial);
		this.setActivarcon_novedad_productoDefinicion(esInicial);
		this.setActivarcon_iceDefinicion(esInicial);
		this.setActivarcon_cantidadDefinicion(esInicial);
		this.setActivarcon_producto_por_proveedorDefinicion(esInicial);
		this.setActivarcon_lote_clienteDefinicion(esInicial);
		this.setActivarcon_cuenta_contableDefinicion(esInicial);
		this.setActivarcon_detalleDefinicion(esInicial);
		this.setActivarcon_iva_incluidoDefinicion(esInicial);
		this.setActivarcon_lotesDefinicion(esInicial);
		this.setActivarnumero_descuentosDefinicion(esInicial);
		this.setActivarcon_precioDefinicion(esInicial);
		this.setActivarnumero_registrosDefinicion(esInicial);
		this.setActivarcon_centro_costoDefinicion(esInicial);
		this.setActivarcon_orden_ivaDefinicion(esInicial);
		this.setActivarcon_multi_empresaDefinicion(esInicial);
		this.setActivarid_formatoDefinicion(esInicial);
		this.setActivarcon_en_lineaDefinicion(esInicial);
		this.setActivarid_tipo_tributarioDefinicion(esInicial);
		this.setActivarid_tipo_retencionDefinicion(esInicial);
		this.setActivarcon_evaluacionDefinicion(esInicial);
		this.setActivarcon_otDefinicion(esInicial);
		this.setActivarcon_anticipoDefinicion(esInicial);
		this.setActivarcon_cierreDefinicion(esInicial);
		this.setActivarcon_generalDefinicion(esInicial);
		this.setActivarcon_por_productoDefinicion(esInicial);
		this.setActivarcon_descuentoDefinicion(esInicial);
		this.setActivarcon_seriesDefinicion(esInicial);
		this.setActivarcantidadDefinicion(esInicial);
		this.setActivarid_tipo_documentoDefinicion(esInicial);
		this.setActivarid_libro_contableDefinicion(esInicial);
		this.setActivarcon_internoDefinicion(esInicial);
		this.setActivarcon_reservaDefinicion(esInicial);
		this.setActivarcon_precio_proveedorDefinicion(esInicial);
		this.setActivarcon_produccionDefinicion(esInicial);
		this.setActivarcon_codigo_barraDefinicion(esInicial);
		this.setActivarcon_romaneosDefinicion(esInicial);
		this.setActivarid_tipo_transaccion_moduloDefinicion(esInicial);
		this.setActivarid_cuenta_contableDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefinicionConstantesFunciones.ID)) {
				this.setActivaridDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIALFORMATO)) {
				this.setActivarsecuencial_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODEFINICION)) {
				this.setActivarid_tipo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOIVAITEM)) {
				this.setActivarid_tipo_iva_itemDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMOSTRARBODEGA)) {
				this.setActivarcon_mostrar_bodegaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.FACTOR)) {
				this.setActivarfactorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOTRORECARGO)) {
				this.setActivarcon_otro_recargoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE)) {
				this.setActivarid_tipo_global_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCOA)) {
				this.setActivarcon_coaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION)) {
				this.setActivarid_tipo_costeo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRETENCION)) {
				this.setActivarcon_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION)) {
				this.setActivarid_tipo_costo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONNOVEDADPRODUCTO)) {
				this.setActivarcon_novedad_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONICE)) {
				this.setActivarcon_iceDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCANTIDAD)) {
				this.setActivarcon_cantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR)) {
				this.setActivarcon_producto_por_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTECLIENTE)) {
				this.setActivarcon_lote_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCUENTACONTABLE)) {
				this.setActivarcon_cuenta_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDETALLE)) {
				this.setActivarcon_detalleDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONIVAINCLUIDO)) {
				this.setActivarcon_iva_incluidoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTES)) {
				this.setActivarcon_lotesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMERODESCUENTOS)) {
				this.setActivarnumero_descuentosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIO)) {
				this.setActivarcon_precioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMEROREGISTROS)) {
				this.setActivarnumero_registrosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCENTROCOSTO)) {
				this.setActivarcon_centro_costoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONORDENIVA)) {
				this.setActivarcon_orden_ivaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMULTIEMPRESA)) {
				this.setActivarcon_multi_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONENLINEA)) {
				this.setActivarcon_en_lineaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivarid_tipo_tributarioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONEVALUACION)) {
				this.setActivarcon_evaluacionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOT)) {
				this.setActivarcon_otDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONANTICIPO)) {
				this.setActivarcon_anticipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCIERRE)) {
				this.setActivarcon_cierreDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONGENERAL)) {
				this.setActivarcon_generalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPORPRODUCTO)) {
				this.setActivarcon_por_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDESCUENTO)) {
				this.setActivarcon_descuentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONSERIES)) {
				this.setActivarcon_seriesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDLIBROCONTABLE)) {
				this.setActivarid_libro_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONINTERNO)) {
				this.setActivarcon_internoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRESERVA)) {
				this.setActivarcon_reservaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIOPROVEEDOR)) {
				this.setActivarcon_precio_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCCION)) {
				this.setActivarcon_produccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCODIGOBARRA)) {
				this.setActivarcon_codigo_barraDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONROMANEOS)) {
				this.setActivarcon_romaneosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableDefinicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDefinicion(esInicial);
		this.setResaltarid_empresaDefinicion(esInicial);
		this.setResaltarid_moduloDefinicion(esInicial);
		this.setResaltarsecuencial_formatoDefinicion(esInicial);
		this.setResaltarsecuencialDefinicion(esInicial);
		this.setResaltarid_tipo_definicionDefinicion(esInicial);
		this.setResaltarid_transaccionDefinicion(esInicial);
		this.setResaltarid_sucursalDefinicion(esInicial);
		this.setResaltarid_tipo_iva_itemDefinicion(esInicial);
		this.setResaltarcon_mostrar_bodegaDefinicion(esInicial);
		this.setResaltarfactorDefinicion(esInicial);
		this.setResaltarcon_otro_recargoDefinicion(esInicial);
		this.setResaltarid_tipo_global_clienteDefinicion(esInicial);
		this.setResaltarcon_coaDefinicion(esInicial);
		this.setResaltarid_tipo_costeo_definicionDefinicion(esInicial);
		this.setResaltarcon_retencionDefinicion(esInicial);
		this.setResaltarid_tipo_costo_definicionDefinicion(esInicial);
		this.setResaltarcon_novedad_productoDefinicion(esInicial);
		this.setResaltarcon_iceDefinicion(esInicial);
		this.setResaltarcon_cantidadDefinicion(esInicial);
		this.setResaltarcon_producto_por_proveedorDefinicion(esInicial);
		this.setResaltarcon_lote_clienteDefinicion(esInicial);
		this.setResaltarcon_cuenta_contableDefinicion(esInicial);
		this.setResaltarcon_detalleDefinicion(esInicial);
		this.setResaltarcon_iva_incluidoDefinicion(esInicial);
		this.setResaltarcon_lotesDefinicion(esInicial);
		this.setResaltarnumero_descuentosDefinicion(esInicial);
		this.setResaltarcon_precioDefinicion(esInicial);
		this.setResaltarnumero_registrosDefinicion(esInicial);
		this.setResaltarcon_centro_costoDefinicion(esInicial);
		this.setResaltarcon_orden_ivaDefinicion(esInicial);
		this.setResaltarcon_multi_empresaDefinicion(esInicial);
		this.setResaltarid_formatoDefinicion(esInicial);
		this.setResaltarcon_en_lineaDefinicion(esInicial);
		this.setResaltarid_tipo_tributarioDefinicion(esInicial);
		this.setResaltarid_tipo_retencionDefinicion(esInicial);
		this.setResaltarcon_evaluacionDefinicion(esInicial);
		this.setResaltarcon_otDefinicion(esInicial);
		this.setResaltarcon_anticipoDefinicion(esInicial);
		this.setResaltarcon_cierreDefinicion(esInicial);
		this.setResaltarcon_generalDefinicion(esInicial);
		this.setResaltarcon_por_productoDefinicion(esInicial);
		this.setResaltarcon_descuentoDefinicion(esInicial);
		this.setResaltarcon_seriesDefinicion(esInicial);
		this.setResaltarcantidadDefinicion(esInicial);
		this.setResaltarid_tipo_documentoDefinicion(esInicial);
		this.setResaltarid_libro_contableDefinicion(esInicial);
		this.setResaltarcon_internoDefinicion(esInicial);
		this.setResaltarcon_reservaDefinicion(esInicial);
		this.setResaltarcon_precio_proveedorDefinicion(esInicial);
		this.setResaltarcon_produccionDefinicion(esInicial);
		this.setResaltarcon_codigo_barraDefinicion(esInicial);
		this.setResaltarcon_romaneosDefinicion(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDefinicion(esInicial);
		this.setResaltarid_cuenta_contableDefinicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefinicionConstantesFunciones.ID)) {
				this.setResaltaridDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIALFORMATO)) {
				this.setResaltarsecuencial_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODEFINICION)) {
				this.setResaltarid_tipo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOIVAITEM)) {
				this.setResaltarid_tipo_iva_itemDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMOSTRARBODEGA)) {
				this.setResaltarcon_mostrar_bodegaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.FACTOR)) {
				this.setResaltarfactorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOTRORECARGO)) {
				this.setResaltarcon_otro_recargoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE)) {
				this.setResaltarid_tipo_global_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCOA)) {
				this.setResaltarcon_coaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION)) {
				this.setResaltarid_tipo_costeo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRETENCION)) {
				this.setResaltarcon_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION)) {
				this.setResaltarid_tipo_costo_definicionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONNOVEDADPRODUCTO)) {
				this.setResaltarcon_novedad_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONICE)) {
				this.setResaltarcon_iceDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCANTIDAD)) {
				this.setResaltarcon_cantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR)) {
				this.setResaltarcon_producto_por_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTECLIENTE)) {
				this.setResaltarcon_lote_clienteDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCUENTACONTABLE)) {
				this.setResaltarcon_cuenta_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDETALLE)) {
				this.setResaltarcon_detalleDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONIVAINCLUIDO)) {
				this.setResaltarcon_iva_incluidoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONLOTES)) {
				this.setResaltarcon_lotesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMERODESCUENTOS)) {
				this.setResaltarnumero_descuentosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIO)) {
				this.setResaltarcon_precioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.NUMEROREGISTROS)) {
				this.setResaltarnumero_registrosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCENTROCOSTO)) {
				this.setResaltarcon_centro_costoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONORDENIVA)) {
				this.setResaltarcon_orden_ivaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONMULTIEMPRESA)) {
				this.setResaltarcon_multi_empresaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONENLINEA)) {
				this.setResaltarcon_en_lineaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltarid_tipo_tributarioDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONEVALUACION)) {
				this.setResaltarcon_evaluacionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONOT)) {
				this.setResaltarcon_otDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONANTICIPO)) {
				this.setResaltarcon_anticipoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCIERRE)) {
				this.setResaltarcon_cierreDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONGENERAL)) {
				this.setResaltarcon_generalDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPORPRODUCTO)) {
				this.setResaltarcon_por_productoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONDESCUENTO)) {
				this.setResaltarcon_descuentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONSERIES)) {
				this.setResaltarcon_seriesDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDLIBROCONTABLE)) {
				this.setResaltarid_libro_contableDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONINTERNO)) {
				this.setResaltarcon_internoDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONRESERVA)) {
				this.setResaltarcon_reservaDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRECIOPROVEEDOR)) {
				this.setResaltarcon_precio_proveedorDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONPRODUCCION)) {
				this.setResaltarcon_produccionDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONCODIGOBARRA)) {
				this.setResaltarcon_codigo_barraDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.CONROMANEOS)) {
				this.setResaltarcon_romaneosDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDefinicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefinicionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableDefinicion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableDefinicion=true;

	public Boolean getMostrarFK_IdCuentaContableDefinicion() {
		return this.mostrarFK_IdCuentaContableDefinicion;
	}

	public void setMostrarFK_IdCuentaContableDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDefinicion=true;

	public Boolean getMostrarFK_IdEmpresaDefinicion() {
		return this.mostrarFK_IdEmpresaDefinicion;
	}

	public void setMostrarFK_IdEmpresaDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLibroContableDefinicion=true;

	public Boolean getMostrarFK_IdLibroContableDefinicion() {
		return this.mostrarFK_IdLibroContableDefinicion;
	}

	public void setMostrarFK_IdLibroContableDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLibroContableDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDefinicion=true;

	public Boolean getMostrarFK_IdModuloDefinicion() {
		return this.mostrarFK_IdModuloDefinicion;
	}

	public void setMostrarFK_IdModuloDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDefinicion=true;

	public Boolean getMostrarFK_IdSucursalDefinicion() {
		return this.mostrarFK_IdSucursalDefinicion;
	}

	public void setMostrarFK_IdSucursalDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCosteoDefinicionDefinicion=true;

	public Boolean getMostrarFK_IdTipoCosteoDefinicionDefinicion() {
		return this.mostrarFK_IdTipoCosteoDefinicionDefinicion;
	}

	public void setMostrarFK_IdTipoCosteoDefinicionDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCosteoDefinicionDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCostoDefinicionDefinicion=true;

	public Boolean getMostrarFK_IdTipoCostoDefinicionDefinicion() {
		return this.mostrarFK_IdTipoCostoDefinicionDefinicion;
	}

	public void setMostrarFK_IdTipoCostoDefinicionDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCostoDefinicionDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDefinicionDefinicion=true;

	public Boolean getMostrarFK_IdTipoDefinicionDefinicion() {
		return this.mostrarFK_IdTipoDefinicionDefinicion;
	}

	public void setMostrarFK_IdTipoDefinicionDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDefinicionDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoDefinicion=true;

	public Boolean getMostrarFK_IdTipoDocumentoDefinicion() {
		return this.mostrarFK_IdTipoDocumentoDefinicion;
	}

	public void setMostrarFK_IdTipoDocumentoDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGlobalClienteDefinicion=true;

	public Boolean getMostrarFK_IdTipoGlobalClienteDefinicion() {
		return this.mostrarFK_IdTipoGlobalClienteDefinicion;
	}

	public void setMostrarFK_IdTipoGlobalClienteDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGlobalClienteDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIvaItemDefinicion=true;

	public Boolean getMostrarFK_IdTipoIvaItemDefinicion() {
		return this.mostrarFK_IdTipoIvaItemDefinicion;
	}

	public void setMostrarFK_IdTipoIvaItemDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIvaItemDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionDefinicion=true;

	public Boolean getMostrarFK_IdTipoRetencionDefinicion() {
		return this.mostrarFK_IdTipoRetencionDefinicion;
	}

	public void setMostrarFK_IdTipoRetencionDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloDefinicion=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloDefinicion() {
		return this.mostrarFK_IdTipoTransaccionModuloDefinicion;
	}

	public void setMostrarFK_IdTipoTransaccionModuloDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioDefinicion=true;

	public Boolean getMostrarFK_IdTipoTributarioDefinicion() {
		return this.mostrarFK_IdTipoTributarioDefinicion;
	}

	public void setMostrarFK_IdTipoTributarioDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioDefinicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDefinicion=true;

	public Boolean getMostrarFK_IdTransaccionDefinicion() {
		return this.mostrarFK_IdTransaccionDefinicion;
	}

	public void setMostrarFK_IdTransaccionDefinicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDefinicion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableDefinicion=true;

	public Boolean getActivarFK_IdCuentaContableDefinicion() {
		return this.activarFK_IdCuentaContableDefinicion;
	}

	public void setActivarFK_IdCuentaContableDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDefinicion=true;

	public Boolean getActivarFK_IdEmpresaDefinicion() {
		return this.activarFK_IdEmpresaDefinicion;
	}

	public void setActivarFK_IdEmpresaDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdLibroContableDefinicion=true;

	public Boolean getActivarFK_IdLibroContableDefinicion() {
		return this.activarFK_IdLibroContableDefinicion;
	}

	public void setActivarFK_IdLibroContableDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdLibroContableDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDefinicion=true;

	public Boolean getActivarFK_IdModuloDefinicion() {
		return this.activarFK_IdModuloDefinicion;
	}

	public void setActivarFK_IdModuloDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDefinicion=true;

	public Boolean getActivarFK_IdSucursalDefinicion() {
		return this.activarFK_IdSucursalDefinicion;
	}

	public void setActivarFK_IdSucursalDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCosteoDefinicionDefinicion=true;

	public Boolean getActivarFK_IdTipoCosteoDefinicionDefinicion() {
		return this.activarFK_IdTipoCosteoDefinicionDefinicion;
	}

	public void setActivarFK_IdTipoCosteoDefinicionDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCosteoDefinicionDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCostoDefinicionDefinicion=true;

	public Boolean getActivarFK_IdTipoCostoDefinicionDefinicion() {
		return this.activarFK_IdTipoCostoDefinicionDefinicion;
	}

	public void setActivarFK_IdTipoCostoDefinicionDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCostoDefinicionDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDefinicionDefinicion=true;

	public Boolean getActivarFK_IdTipoDefinicionDefinicion() {
		return this.activarFK_IdTipoDefinicionDefinicion;
	}

	public void setActivarFK_IdTipoDefinicionDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDefinicionDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoDefinicion=true;

	public Boolean getActivarFK_IdTipoDocumentoDefinicion() {
		return this.activarFK_IdTipoDocumentoDefinicion;
	}

	public void setActivarFK_IdTipoDocumentoDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGlobalClienteDefinicion=true;

	public Boolean getActivarFK_IdTipoGlobalClienteDefinicion() {
		return this.activarFK_IdTipoGlobalClienteDefinicion;
	}

	public void setActivarFK_IdTipoGlobalClienteDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGlobalClienteDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIvaItemDefinicion=true;

	public Boolean getActivarFK_IdTipoIvaItemDefinicion() {
		return this.activarFK_IdTipoIvaItemDefinicion;
	}

	public void setActivarFK_IdTipoIvaItemDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIvaItemDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionDefinicion=true;

	public Boolean getActivarFK_IdTipoRetencionDefinicion() {
		return this.activarFK_IdTipoRetencionDefinicion;
	}

	public void setActivarFK_IdTipoRetencionDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloDefinicion=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloDefinicion() {
		return this.activarFK_IdTipoTransaccionModuloDefinicion;
	}

	public void setActivarFK_IdTipoTransaccionModuloDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioDefinicion=true;

	public Boolean getActivarFK_IdTipoTributarioDefinicion() {
		return this.activarFK_IdTipoTributarioDefinicion;
	}

	public void setActivarFK_IdTipoTributarioDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioDefinicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDefinicion=true;

	public Boolean getActivarFK_IdTransaccionDefinicion() {
		return this.activarFK_IdTransaccionDefinicion;
	}

	public void setActivarFK_IdTransaccionDefinicion(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDefinicion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableDefinicion=null;

	public Border getResaltarFK_IdCuentaContableDefinicion() {
		return this.resaltarFK_IdCuentaContableDefinicion;
	}

	public void setResaltarFK_IdCuentaContableDefinicion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDefinicion=null;

	public Border getResaltarFK_IdEmpresaDefinicion() {
		return this.resaltarFK_IdEmpresaDefinicion;
	}

	public void setResaltarFK_IdEmpresaDefinicion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdLibroContableDefinicion=null;

	public Border getResaltarFK_IdLibroContableDefinicion() {
		return this.resaltarFK_IdLibroContableDefinicion;
	}

	public void setResaltarFK_IdLibroContableDefinicion(Border borderResaltar) {
		this.resaltarFK_IdLibroContableDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdLibroContableDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLibroContableDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdModuloDefinicion=null;

	public Border getResaltarFK_IdModuloDefinicion() {
		return this.resaltarFK_IdModuloDefinicion;
	}

	public void setResaltarFK_IdModuloDefinicion(Border borderResaltar) {
		this.resaltarFK_IdModuloDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdModuloDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDefinicion=null;

	public Border getResaltarFK_IdSucursalDefinicion() {
		return this.resaltarFK_IdSucursalDefinicion;
	}

	public void setResaltarFK_IdSucursalDefinicion(Border borderResaltar) {
		this.resaltarFK_IdSucursalDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoCosteoDefinicionDefinicion=null;

	public Border getResaltarFK_IdTipoCosteoDefinicionDefinicion() {
		return this.resaltarFK_IdTipoCosteoDefinicionDefinicion;
	}

	public void setResaltarFK_IdTipoCosteoDefinicionDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoCosteoDefinicionDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoCosteoDefinicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCosteoDefinicionDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoCostoDefinicionDefinicion=null;

	public Border getResaltarFK_IdTipoCostoDefinicionDefinicion() {
		return this.resaltarFK_IdTipoCostoDefinicionDefinicion;
	}

	public void setResaltarFK_IdTipoCostoDefinicionDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoCostoDefinicionDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoCostoDefinicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCostoDefinicionDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoDefinicionDefinicion=null;

	public Border getResaltarFK_IdTipoDefinicionDefinicion() {
		return this.resaltarFK_IdTipoDefinicionDefinicion;
	}

	public void setResaltarFK_IdTipoDefinicionDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoDefinicionDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoDefinicionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDefinicionDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoDefinicion=null;

	public Border getResaltarFK_IdTipoDocumentoDefinicion() {
		return this.resaltarFK_IdTipoDocumentoDefinicion;
	}

	public void setResaltarFK_IdTipoDocumentoDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoGlobalClienteDefinicion=null;

	public Border getResaltarFK_IdTipoGlobalClienteDefinicion() {
		return this.resaltarFK_IdTipoGlobalClienteDefinicion;
	}

	public void setResaltarFK_IdTipoGlobalClienteDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoGlobalClienteDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoGlobalClienteDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGlobalClienteDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoIvaItemDefinicion=null;

	public Border getResaltarFK_IdTipoIvaItemDefinicion() {
		return this.resaltarFK_IdTipoIvaItemDefinicion;
	}

	public void setResaltarFK_IdTipoIvaItemDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoIvaItemDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoIvaItemDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIvaItemDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionDefinicion=null;

	public Border getResaltarFK_IdTipoRetencionDefinicion() {
		return this.resaltarFK_IdTipoRetencionDefinicion;
	}

	public void setResaltarFK_IdTipoRetencionDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloDefinicion=null;

	public Border getResaltarFK_IdTipoTransaccionModuloDefinicion() {
		return this.resaltarFK_IdTipoTransaccionModuloDefinicion;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioDefinicion=null;

	public Border getResaltarFK_IdTipoTributarioDefinicion() {
		return this.resaltarFK_IdTipoTributarioDefinicion;
	}

	public void setResaltarFK_IdTipoTributarioDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioDefinicion= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDefinicion=null;

	public Border getResaltarFK_IdTransaccionDefinicion() {
		return this.resaltarFK_IdTransaccionDefinicion;
	}

	public void setResaltarFK_IdTransaccionDefinicion(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDefinicion= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDefinicion(ParametroGeneralUsuario parametroGeneralUsuario/*DefinicionBeanSwingJInternalFrame definicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDefinicion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}